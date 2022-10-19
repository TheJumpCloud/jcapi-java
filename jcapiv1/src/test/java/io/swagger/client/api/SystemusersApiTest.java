/*
 * JumpCloud API
 * # Overview  JumpCloud's V1 API. This set of endpoints allows JumpCloud customers to manage commands, systems, and system users.  # API Key  ## Access Your API Key  To locate your API Key:  1. Log into the [JumpCloud Admin Console](https://console.jumpcloud.com/). 2. Go to the username drop down located in the top-right of the Console. 3. Retrieve your API key from API Settings.  ## API Key Considerations  This API key is associated to the currently logged in administrator. Other admins will have different API keys.  **WARNING** Please keep this API key secret, as it grants full access to any data accessible via your JumpCloud console account.  You can also reset your API key in the same location in the JumpCloud Admin Console.  ## Recycling or Resetting Your API Key  In order to revoke access with the current API key, simply reset your API key. This will render all calls using the previous API key inaccessible.  Your API key will be passed in as a header with the header name \"x-api-key\".  ```bash curl -H \"x-api-key: [YOUR_API_KEY_HERE]\" \"https://console.jumpcloud.com/api/systemusers\" ```  # System Context  * [Introduction](#introduction) * [Supported endpoints](#supported-endpoints) * [Response codes](#response-codes) * [Authentication](#authentication) * [Additional examples](#additional-examples) * [Third party](#third-party)  ## Introduction  JumpCloud System Context Authorization is an alternative way to authenticate with a subset of JumpCloud's REST APIs. Using this method, a system can manage its information and resource associations, allowing modern auto provisioning environments to scale as needed.  **Notes:**   * The following documentation applies to Linux Operating Systems only.  * Systems that have been automatically enrolled using Apple's Device Enrollment Program (DEP) or systems enrolled using the User Portal install are not eligible to use the System Context API to prevent unauthorized access to system groups and resources. If a script that utilizes the System Context API is invoked on a system enrolled in this way, it will display an error.  ## Supported Endpoints  JumpCloud System Context Authorization can be used in conjunction with Systems endpoints found in the V1 API and certain System Group endpoints found in the v2 API.  * A system may fetch, alter, and delete metadata about itself, including manipulating a system's Group and Systemuser associations,   * `/api/systems/{system_id}` | [`GET`](https://docs.jumpcloud.com/api/1.0/index.html#operation/systems_get) [`PUT`](https://docs.jumpcloud.com/api/1.0/index.html#operation/systems_put) * A system may delete itself from your JumpCloud organization   * `/api/systems/{system_id}` | [`DELETE`](https://docs.jumpcloud.com/api/1.0/index.html#operation/systems_delete) * A system may fetch its direct resource associations under v2 (Groups)   * `/api/v2/systems/{system_id}/memberof` | [`GET`](https://docs.jumpcloud.com/api/2.0/index.html#operation/graph_systemGroupMembership)   * `/api/v2/systems/{system_id}/associations` | [`GET`](https://docs.jumpcloud.com/api/2.0/index.html#operation/graph_systemAssociationsList)   * `/api/v2/systems/{system_id}/users` | [`GET`](https://docs.jumpcloud.com/api/2.0/index.html#operation/graph_systemTraverseUser) * A system may alter its direct resource associations under v2 (Groups)   * `/api/v2/systems/{system_id}/associations` | [`POST`](https://docs.jumpcloud.com/api/2.0/index.html#operation/graph_systemAssociationsPost) * A system may alter its System Group associations   * `/api/v2/systemgroups/{group_id}/members` | [`POST`](https://docs.jumpcloud.com/api/2.0/index.html#operation/graph_systemGroupMembersPost)     * _NOTE_ If a system attempts to alter the system group membership of a different system the request will be rejected  ## Response Codes  If endpoints other than those described above are called using the System Context API, the server will return a `401` response.  ## Authentication  To allow for secure access to our APIs, you must authenticate each API request. JumpCloud System Context Authorization uses [HTTP Signatures](https://tools.ietf.org/html/draft-cavage-http-signatures-00) to authenticate API requests. The HTTP Signatures sent with each request are similar to the signatures used by the Amazon Web Services REST API. To help with the request-signing process, we have provided an [example bash script](https://github.com/TheJumpCloud/SystemContextAPI/blob/master/examples/shell/SigningExample.sh). This example API request simply requests the entire system record. You must be root, or have permissions to access the contents of the `/opt/jc` directory to generate a signature.  Here is a breakdown of the example script with explanations.  First, the script extracts the systemKey from the JSON formatted `/opt/jc/jcagent.conf` file.  ```bash #!/bin/bash conf=\"`cat /opt/jc/jcagent.conf`\" regex=\"systemKey\\\":\\\"(\\w+)\\\"\"  if [[ $conf =~ $regex ]] ; then   systemKey=\"${BASH_REMATCH[1]}\" fi ```  Then, the script retrieves the current date in the correct format.  ```bash now=`date -u \"+%a, %d %h %Y %H:%M:%S GMT\"`; ```  Next, we build a signing string to demonstrate the expected signature format. The signed string must consist of the [request-line](https://tools.ietf.org/html/rfc2616#page-35) and the date header, separated by a newline character.  ```bash signstr=\"GET /api/systems/${systemKey} HTTP/1.1\\ndate: ${now}\" ```  The next step is to calculate and apply the signature. This is a two-step process:  1. Create a signature from the signing string using the JumpCloud Agent private key: ``printf \"$signstr\" | openssl dgst -sha256 -sign /opt/jc/client.key`` 2. Then Base64-encode the signature string and trim off the newline characters: ``| openssl enc -e -a | tr -d '\\n'``  The combined steps above result in:  ```bash signature=`printf \"$signstr\" | openssl dgst -sha256 -sign /opt/jc/client.key | openssl enc -e -a | tr -d '\\n'` ; ```  Finally, we make sure the API call sending the signature has the same Authorization and Date header values, HTTP method, and URL that were used in the signing string.  ```bash curl -iq \\   -H \"Accept: application/json\" \\   -H \"Content-Type: application/json\" \\   -H \"Date: ${now}\" \\   -H \"Authorization: Signature keyId=\\\"system/${systemKey}\\\",headers=\\\"request-line date\\\",algorithm=\\\"rsa-sha256\\\",signature=\\\"${signature}\\\"\" \\   --url https://console.jumpcloud.com/api/systems/${systemKey} ```  ### Input Data  All PUT and POST methods should use the HTTP Content-Type header with a value of 'application/json'. PUT methods are used for updating a record. POST methods are used to create a record.  The following example demonstrates how to update the `displayName` of the system.  ```bash signstr=\"PUT /api/systems/${systemKey} HTTP/1.1\\ndate: ${now}\" signature=`printf \"$signstr\" | openssl dgst -sha256 -sign /opt/jc/client.key | openssl enc -e -a | tr -d '\\n'` ;  curl -iq \\   -d \"{\\\"displayName\\\" : \\\"updated-system-name-1\\\"}\" \\   -X \"PUT\" \\   -H \"Content-Type: application/json\" \\   -H \"Accept: application/json\" \\   -H \"Date: ${now}\" \\   -H \"Authorization: Signature keyId=\\\"system/${systemKey}\\\",headers=\\\"request-line date\\\",algorithm=\\\"rsa-sha256\\\",signature=\\\"${signature}\\\"\" \\   --url https://console.jumpcloud.com/api/systems/${systemKey} ```  ### Output Data  All results will be formatted as JSON.  Here is an abbreviated example of response output:  ```json {   \"_id\": \"525ee96f52e144993e000015\",   \"agentServer\": \"lappy386\",   \"agentVersion\": \"0.9.42\",   \"arch\": \"x86_64\",   \"connectionKey\": \"127.0.0.1_51812\",   \"displayName\": \"ubuntu-1204\",   \"firstContact\": \"2013-10-16T19:30:55.611Z\",   \"hostname\": \"ubuntu-1204\"   ... ```  ## Additional Examples  ### Signing Authentication Example  This example demonstrates how to make an authenticated request to fetch the JumpCloud record for this system.  [SigningExample.sh](https://github.com/TheJumpCloud/SystemContextAPI/blob/master/examples/shell/SigningExample.sh)  ### Shutdown Hook  This example demonstrates how to make an authenticated request on system shutdown. Using an init.d script registered at run level 0, you can call the System Context API as the system is shutting down.  [Instance-shutdown-initd](https://github.com/TheJumpCloud/SystemContextAPI/blob/master/examples/instance-shutdown-initd) is an example of an init.d script that only runs at system shutdown.  After customizing the [instance-shutdown-initd](https://github.com/TheJumpCloud/SystemContextAPI/blob/master/examples/instance-shutdown-initd) script, you should install it on the system(s) running the JumpCloud agent.  1. Copy the modified [instance-shutdown-initd](https://github.com/TheJumpCloud/SystemContextAPI/blob/master/examples/instance-shutdown-initd) to `/etc/init.d/instance-shutdown`. 2. On Ubuntu systems, run `update-rc.d instance-shutdown defaults`. On RedHat/CentOS systems, run `chkconfig --add instance-shutdown`.  ## Third Party  ### Chef Cookbooks  [https://github.com/nshenry03/jumpcloud](https://github.com/nshenry03/jumpcloud)  [https://github.com/cjs226/jumpcloud](https://github.com/cjs226/jumpcloud)  # Multi-Tenant Portal Headers  Multi-Tenant Organization API Headers are available for JumpCloud Admins to use when making API requests from Organizations that have multiple managed organizations.  The `x-org-id` is a required header for all multi-tenant admins when making API requests to JumpCloud. This header will define to which organization you would like to make the request.  **NOTE** Single Tenant Admins do not need to provide this header when making an API request.  ## Header Value  `x-org-id`  ## API Response Codes  * `400` Malformed ID. * `400` x-org-id and Organization path ID do not match. * `401` ID not included for multi-tenant admin * `403` ID included on unsupported route. * `404` Organization ID Not Found.  ```bash curl -X GET https://console.jumpcloud.com/api/v2/directories \\   -H 'accept: application/json' \\   -H 'content-type: application/json' \\   -H 'x-api-key: {API_KEY}' \\   -H 'x-org-id: {ORG_ID}'  ```  ## To Obtain an Individual Organization ID via the UI  As a prerequisite, your Primary Organization will need to be setup for Multi-Tenancy. This provides access to the Multi-Tenant Organization Admin Portal.  1. Log into JumpCloud [Admin Console](https://console.jumpcloud.com). If you are a multi-tenant Admin, you will automatically be routed to the Multi-Tenant Admin Portal. 2. From the Multi-Tenant Portal's primary navigation bar, select the Organization you'd like to access. 3. You will automatically be routed to that Organization's Admin Console. 4. Go to Settings in the sub-tenant's primary navigation. 5. You can obtain your Organization ID below your Organization's Contact Information on the Settings page.  ## To Obtain All Organization IDs via the API  * You can make an API request to this endpoint using the API key of your Primary Organization.  `https://console.jumpcloud.com/api/organizations/` This will return all your managed organizations.  ```bash curl -X GET \\   https://console.jumpcloud.com/api/organizations/ \\   -H 'Accept: application/json' \\   -H 'Content-Type: application/json' \\   -H 'x-api-key: {API_KEY}' ```  # SDKs  You can find language specific SDKs that can help you kickstart your Integration with JumpCloud in the following GitHub repositories:  * [Python](https://github.com/TheJumpCloud/jcapi-python) * [Go](https://github.com/TheJumpCloud/jcapi-go) * [Ruby](https://github.com/TheJumpCloud/jcapi-ruby) * [Java](https://github.com/TheJumpCloud/jcapi-java) 
 *
 * OpenAPI spec version: 1.0
 * Contact: support@jumpcloud.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.api;

import io.swagger.client.model.Error;
import io.swagger.client.model.ErrorDetails;
import io.swagger.client.model.IdResetmfaBody;
import io.swagger.client.model.Sshkeylist;
import io.swagger.client.model.Sshkeypost;
import io.swagger.client.model.StateActivateBody;
import io.swagger.client.model.Systemuserput;
import io.swagger.client.model.Systemuserputpost;
import io.swagger.client.model.Systemuserreturn;
import io.swagger.client.model.Systemuserslist;
import org.junit.Test;
import org.junit.Ignore;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * API tests for SystemusersApi
 */
@Ignore
public class SystemusersApiTest {

    private final SystemusersApi api = new SystemusersApi();

    /**
     * Delete a system user&#x27;s Public SSH Keys
     *
     * This endpoint will delete a specific System User&#x27;s SSH Key.
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void sshkeyDeleteTest() throws Exception {
        String systemuserId = null;
        String id = null;
        String xOrgId = null;
        String response = api.sshkeyDelete(systemuserId, id, xOrgId);

        // TODO: test validations
    }
    /**
     * List a system user&#x27;s public SSH keys
     *
     * This endpoint will return a specific System User&#x27;s public SSH key.
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void sshkeyListTest() throws Exception {
        String id = null;
        String xOrgId = null;
        List<Sshkeylist> response = api.sshkeyList(id, xOrgId);

        // TODO: test validations
    }
    /**
     * Create a system user&#x27;s Public SSH Key
     *
     * This endpoint will create a specific System User&#x27;s Public SSH Key.
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void sshkeyPostTest() throws Exception {
        String id = null;
        Sshkeypost body = null;
        String xOrgId = null;
        Sshkeylist response = api.sshkeyPost(id, body, xOrgId);

        // TODO: test validations
    }
    /**
     * Delete a system user
     *
     * This endpoint allows you to delete a particular system user.  #### Sample Request &#x60;&#x60;&#x60; curl -X DELETE https://console.jumpcloud.com/api/systemusers/{UserID} \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void systemusersDeleteTest() throws Exception {
        String id = null;
        String xOrgId = null;
        String cascadeManager = null;
        Systemuserreturn response = api.systemusersDelete(id, xOrgId, cascadeManager);

        // TODO: test validations
    }
    /**
     * Expire a system user&#x27;s password
     *
     * This endpoint allows you to expire a user&#x27;s password.
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void systemusersExpireTest() throws Exception {
        String id = null;
        String xOrgId = null;
        String response = api.systemusersExpire(id, xOrgId);

        // TODO: test validations
    }
    /**
     * List a system user
     *
     * This endpoint returns a particular System User.  #### Sample Request  &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/systemusers/{UserID} \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void systemusersGetTest() throws Exception {
        String id = null;
        String fields = null;
        String filter = null;
        String xOrgId = null;
        Systemuserreturn response = api.systemusersGet(id, fields, filter, xOrgId);

        // TODO: test validations
    }
    /**
     * List all system users
     *
     * This endpoint returns all systemusers.  #### Sample Request  &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/systemusers \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void systemusersListTest() throws Exception {
        Integer limit = null;
        Integer skip = null;
        String sort = null;
        String fields = null;
        String filter = null;
        String xOrgId = null;
        String search = null;
        Systemuserslist response = api.systemusersList(limit, skip, sort, fields, filter, xOrgId, search);

        // TODO: test validations
    }
    /**
     * Sync a systemuser&#x27;s mfa enrollment status
     *
     * This endpoint allows you to re-sync a user&#x27;s mfa enrollment status  #### Sample Request &#x60;&#x60;&#x60; curl -X POST \\   https://console.jumpcloud.com/api/systemusers/{UserID}/mfasync \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\  &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void systemusersMfasyncTest() throws Exception {
        String id = null;
        api.systemusersMfasync(id);

        // TODO: test validations
    }
    /**
     * Create a system user
     *
     * \&quot;This endpoint allows you to create a new system user.  #### Default User State The &#x60;state&#x60; of the user can be explicitly passed in or omitted. If &#x60;state&#x60; is omitted from the request, then the user will get created using the value returned from the [Get an Organization](https://docs.jumpcloud.com/api/1.0/index.html#operation/organizations_get) endpoint. The default user state for manually created users is stored in &#x60;settings.newSystemUserStateDefaults.manualEntry&#x60;  These default state values can be changed in the admin portal settings or by using the [Update an Organization](https://docs.jumpcloud.com/api/1.0/index.html#operation/organization_put) endpoint.  #### Sample Request  &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/systemusers \\ -H &#x27;Accept: application/json&#x27; \\ -H &#x27;Content-Type: application/json&#x27; \\ -H &#x27;x-api-key: {API_KEY}&#x27; \\ -d &#x27;{       \&quot;username\&quot;:\&quot;{username}\&quot;,       \&quot;email\&quot;:\&quot;{email_address}\&quot;,       \&quot;firstname\&quot;:\&quot;{Name}\&quot;,       \&quot;lastname\&quot;:\&quot;{Name}\&quot;     }&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void systemusersPostTest() throws Exception {
        Systemuserputpost body = null;
        String xOrgId = null;
        String fullValidationDetails = null;
        Systemuserreturn response = api.systemusersPost(body, xOrgId, fullValidationDetails);

        // TODO: test validations
    }
    /**
     * Update a system user
     *
     * This endpoint allows you to update a system user.  #### Sample Request  &#x60;&#x60;&#x60; curl -X PUT https://console.jumpcloud.com/api/systemusers/{UserID} \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{  \&quot;email\&quot;:\&quot;{email_address}\&quot;,  \&quot;firstname\&quot;:\&quot;{Name}\&quot;,  \&quot;lastname\&quot;:\&quot;{Name}\&quot; }&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void systemusersPutTest() throws Exception {
        String id = null;
        Systemuserput body = null;
        String xOrgId = null;
        String fullValidationDetails = null;
        Systemuserreturn response = api.systemusersPut(id, body, xOrgId, fullValidationDetails);

        // TODO: test validations
    }
    /**
     * Reset a system user&#x27;s MFA token
     *
     * This endpoint allows you to reset the TOTP key for a specified system user and put them in an TOTP MFA enrollment period. This will result in the user being prompted to setup TOTP MFA when logging into userportal. Please be aware that if the user does not complete TOTP MFA setup before the &#x60;exclusionUntil&#x60; date, they will be locked out of any resources that require TOTP MFA.  Please refer to our [Knowledge Base Article](https://support.jumpcloud.com/customer/en/portal/articles/2959138-using-multifactor-authentication-with-jumpcloud) on setting up MFA for more information.  #### Sample Request &#x60;&#x60;&#x60; curl -X POST \\   https://console.jumpcloud.com/api/systemusers/{UserID}/resetmfa \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{\&quot;exclusion\&quot;: true, \&quot;exclusionUntil\&quot;: \&quot;{date-time}\&quot;}&#x27;  &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void systemusersResetmfaTest() throws Exception {
        String id = null;
        IdResetmfaBody body = null;
        String xOrgId = null;
        String response = api.systemusersResetmfa(id, body, xOrgId);

        // TODO: test validations
    }
    /**
     * Activate System User
     *
     * This endpoint changes the state of a STAGED user to ACTIVATED. #### Email Flag Use the \&quot;email\&quot; flag to determine whether or not to send a Welcome or Activation email to the newly activated user. Sending an empty body without the &#x60;email&#x60; flag, will send an email with default behavior (see the \&quot;Behavior\&quot; section below) &#x60;&#x60;&#x60; {} &#x60;&#x60;&#x60; Sending &#x60;email&#x3D;true&#x60; flag will send an email with default behavior (see &#x60;Behavior&#x60; below) &#x60;&#x60;&#x60; { \&quot;email\&quot;: true } &#x60;&#x60;&#x60; Populated email will override the default behavior and send to the specified email value &#x60;&#x60;&#x60; { \&quot;email\&quot;: \&quot;example@example.com\&quot; } &#x60;&#x60;&#x60; Sending &#x60;email&#x3D;false&#x60; will suppress sending the email &#x60;&#x60;&#x60; { \&quot;email\&quot;: false } &#x60;&#x60;&#x60; #### Behavior Users with a password will be sent a Welcome email to:   - The address specified in &#x60;email&#x60; flag in the request   - If no &#x60;email&#x60; flag, the user&#x27;s primary email address (default behavior) Users without a password will be sent an Activation email to:   - The address specified in &#x60;email&#x60; flag in the request   - If no &#x60;email&#x60; flag, the user&#x27;s alternate email address (default behavior)   - If no alternate email address, the user&#x27;s primary email address (default behavior)  #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/systemusers/{id}/state/activate \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: &lt;api-key&gt;&#x27; \\   -d &#x27;{ \&quot;email\&quot;: \&quot;alternate-activation-email@email.com\&quot; }&#x27;  &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void systemusersStateActivateTest() throws Exception {
        String id = null;
        StateActivateBody body = null;
        String response = api.systemusersStateActivate(id, body);

        // TODO: test validations
    }
    /**
     * Unlock a system user
     *
     * This endpoint allows you to unlock a user&#x27;s account.
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void systemusersUnlockTest() throws Exception {
        String id = null;
        String xOrgId = null;
        String response = api.systemusersUnlock(id, xOrgId);

        // TODO: test validations
    }
}
