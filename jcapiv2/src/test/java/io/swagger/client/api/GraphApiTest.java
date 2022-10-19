/*
 * JumpCloud API
 * # Overview  JumpCloud's V2 API. This set of endpoints allows JumpCloud customers to manage objects, groupings and mappings and interact with the JumpCloud Graph.  # Directory Objects  This API offers the ability to interact with some of our core features; otherwise known as Directory Objects. The Directory Objects are:  * Commands * Policies * Policy Groups * Applications * Systems * Users * User Groups * System Groups * Radius Servers * Directories: Office 365, LDAP,G-Suite, Active Directory * Duo accounts and applications.  The Directory Object is an important concept to understand in order to successfully use JumpCloud API.  ## JumpCloud Graph  We've also introduced the concept of the JumpCloud Graph along with  Directory Objects. The Graph is a powerful aspect of our platform which will enable you to associate objects with each other, or establish membership for certain objects to become members of other objects.  Specific `GET` endpoints will allow you to traverse the JumpCloud Graph to return all indirect and directly bound objects in your organization.  | ![alt text](https://s3.amazonaws.com/jumpcloud-kb/Knowledge+Base+Photos/API+Docs/jumpcloud_graph.png \"JumpCloud Graph Model Example\") | |:--:| | **This diagram highlights our association and membership model as it relates to Directory Objects.** |  # API Key  ## Access Your API Key  To locate your API Key:  1. Log into the [JumpCloud Admin Console](https://console.jumpcloud.com/). 2. Go to the username drop down located in the top-right of the Console. 3. Retrieve your API key from API Settings.  ## API Key Considerations  This API key is associated to the currently logged in administrator. Other admins will have different API keys.  **WARNING** Please keep this API key secret, as it grants full access to any data accessible via your JumpCloud console account.  You can also reset your API key in the same location in the JumpCloud Admin Console.  ## Recycling or Resetting Your API Key  In order to revoke access with the current API key, simply reset your API key. This will render all calls using the previous API key inaccessible.  Your API key will be passed in as a header with the header name \"x-api-key\".  ```bash curl -H \"x-api-key: [YOUR_API_KEY_HERE]\" \"https://console.jumpcloud.com/api/v2/systemgroups\" ```  # System Context  * [Introduction](#introduction) * [Supported endpoints](#supported-endpoints) * [Response codes](#response-codes) * [Authentication](#authentication) * [Additional examples](#additional-examples) * [Third party](#third-party)  ## Introduction  JumpCloud System Context Authorization is an alternative way to authenticate with a subset of JumpCloud's REST APIs. Using this method, a system can manage its information and resource associations, allowing modern auto provisioning environments to scale as needed.  **Notes:**   * The following documentation applies to Linux Operating Systems only.  * Systems that have been automatically enrolled using Apple's Device Enrollment Program (DEP) or systems enrolled using the User Portal install are not eligible to use the System Context API to prevent unauthorized access to system groups and resources. If a script that utilizes the System Context API is invoked on a system enrolled in this way, it will display an error.  ## Supported Endpoints  JumpCloud System Context Authorization can be used in conjunction with Systems endpoints found in the V1 API and certain System Group endpoints found in the v2 API.  * A system may fetch, alter, and delete metadata about itself, including manipulating a system's Group and Systemuser associations,   * `/api/systems/{system_id}` | [`GET`](https://docs.jumpcloud.com/api/1.0/index.html#operation/systems_get) [`PUT`](https://docs.jumpcloud.com/api/1.0/index.html#operation/systems_put) * A system may delete itself from your JumpCloud organization   * `/api/systems/{system_id}` | [`DELETE`](https://docs.jumpcloud.com/api/1.0/index.html#operation/systems_delete) * A system may fetch its direct resource associations under v2 (Groups)   * `/api/v2/systems/{system_id}/memberof` | [`GET`](https://docs.jumpcloud.com/api/2.0/index.html#operation/graph_systemGroupMembership)   * `/api/v2/systems/{system_id}/associations` | [`GET`](https://docs.jumpcloud.com/api/2.0/index.html#operation/graph_systemAssociationsList)   * `/api/v2/systems/{system_id}/users` | [`GET`](https://docs.jumpcloud.com/api/2.0/index.html#operation/graph_systemTraverseUser) * A system may alter its direct resource associations under v2 (Groups)   * `/api/v2/systems/{system_id}/associations` | [`POST`](https://docs.jumpcloud.com/api/2.0/index.html#operation/graph_systemAssociationsPost) * A system may alter its System Group associations   * `/api/v2/systemgroups/{group_id}/members` | [`POST`](https://docs.jumpcloud.com/api/2.0/index.html#operation/graph_systemGroupMembersPost)     * _NOTE_ If a system attempts to alter the system group membership of a different system the request will be rejected  ## Response Codes  If endpoints other than those described above are called using the System Context API, the server will return a `401` response.  ## Authentication  To allow for secure access to our APIs, you must authenticate each API request. JumpCloud System Context Authorization uses [HTTP Signatures](https://tools.ietf.org/html/draft-cavage-http-signatures-00) to authenticate API requests. The HTTP Signatures sent with each request are similar to the signatures used by the Amazon Web Services REST API. To help with the request-signing process, we have provided an [example bash script](https://github.com/TheJumpCloud/SystemContextAPI/blob/master/examples/shell/SigningExample.sh). This example API request simply requests the entire system record. You must be root, or have permissions to access the contents of the `/opt/jc` directory to generate a signature.  Here is a breakdown of the example script with explanations.  First, the script extracts the systemKey from the JSON formatted `/opt/jc/jcagent.conf` file.  ```bash #!/bin/bash conf=\"`cat /opt/jc/jcagent.conf`\" regex=\"systemKey\\\":\\\"(\\w+)\\\"\"  if [[ $conf =~ $regex ]] ; then   systemKey=\"${BASH_REMATCH[1]}\" fi ```  Then, the script retrieves the current date in the correct format.  ```bash now=`date -u \"+%a, %d %h %Y %H:%M:%S GMT\"`; ```  Next, we build a signing string to demonstrate the expected signature format. The signed string must consist of the [request-line](https://tools.ietf.org/html/rfc2616#page-35) and the date header, separated by a newline character.  ```bash signstr=\"GET /api/systems/${systemKey} HTTP/1.1\\ndate: ${now}\" ```  The next step is to calculate and apply the signature. This is a two-step process:  1. Create a signature from the signing string using the JumpCloud Agent private key: ``printf \"$signstr\" | openssl dgst -sha256 -sign /opt/jc/client.key`` 2. Then Base64-encode the signature string and trim off the newline characters: ``| openssl enc -e -a | tr -d '\\n'``  The combined steps above result in:  ```bash signature=`printf \"$signstr\" | openssl dgst -sha256 -sign /opt/jc/client.key | openssl enc -e -a | tr -d '\\n'` ; ```  Finally, we make sure the API call sending the signature has the same Authorization and Date header values, HTTP method, and URL that were used in the signing string.  ```bash curl -iq \\   -H \"Accept: application/json\" \\   -H \"Content-Type: application/json\" \\   -H \"Date: ${now}\" \\   -H \"Authorization: Signature keyId=\\\"system/${systemKey}\\\",headers=\\\"request-line date\\\",algorithm=\\\"rsa-sha256\\\",signature=\\\"${signature}\\\"\" \\   --url https://console.jumpcloud.com/api/systems/${systemKey} ```  ### Input Data  All PUT and POST methods should use the HTTP Content-Type header with a value of 'application/json'. PUT methods are used for updating a record. POST methods are used to create a record.  The following example demonstrates how to update the `displayName` of the system.  ```bash signstr=\"PUT /api/systems/${systemKey} HTTP/1.1\\ndate: ${now}\" signature=`printf \"$signstr\" | openssl dgst -sha256 -sign /opt/jc/client.key | openssl enc -e -a | tr -d '\\n'` ;  curl -iq \\   -d \"{\\\"displayName\\\" : \\\"updated-system-name-1\\\"}\" \\   -X \"PUT\" \\   -H \"Content-Type: application/json\" \\   -H \"Accept: application/json\" \\   -H \"Date: ${now}\" \\   -H \"Authorization: Signature keyId=\\\"system/${systemKey}\\\",headers=\\\"request-line date\\\",algorithm=\\\"rsa-sha256\\\",signature=\\\"${signature}\\\"\" \\   --url https://console.jumpcloud.com/api/systems/${systemKey} ```  ### Output Data  All results will be formatted as JSON.  Here is an abbreviated example of response output:  ```json {   \"_id\": \"525ee96f52e144993e000015\",   \"agentServer\": \"lappy386\",   \"agentVersion\": \"0.9.42\",   \"arch\": \"x86_64\",   \"connectionKey\": \"127.0.0.1_51812\",   \"displayName\": \"ubuntu-1204\",   \"firstContact\": \"2013-10-16T19:30:55.611Z\",   \"hostname\": \"ubuntu-1204\"   ... ```  ## Additional Examples  ### Signing Authentication Example  This example demonstrates how to make an authenticated request to fetch the JumpCloud record for this system.  [SigningExample.sh](https://github.com/TheJumpCloud/SystemContextAPI/blob/master/examples/shell/SigningExample.sh)  ### Shutdown Hook  This example demonstrates how to make an authenticated request on system shutdown. Using an init.d script registered at run level 0, you can call the System Context API as the system is shutting down.  [Instance-shutdown-initd](https://github.com/TheJumpCloud/SystemContextAPI/blob/master/examples/instance-shutdown-initd) is an example of an init.d script that only runs at system shutdown.  After customizing the [instance-shutdown-initd](https://github.com/TheJumpCloud/SystemContextAPI/blob/master/examples/instance-shutdown-initd) script, you should install it on the system(s) running the JumpCloud agent.  1. Copy the modified [instance-shutdown-initd](https://github.com/TheJumpCloud/SystemContextAPI/blob/master/examples/instance-shutdown-initd) to `/etc/init.d/instance-shutdown`. 2. On Ubuntu systems, run `update-rc.d instance-shutdown defaults`. On RedHat/CentOS systems, run `chkconfig --add instance-shutdown`.  ## Third Party  ### Chef Cookbooks  [https://github.com/nshenry03/jumpcloud](https://github.com/nshenry03/jumpcloud)  [https://github.com/cjs226/jumpcloud](https://github.com/cjs226/jumpcloud)  # Multi-Tenant Portal Headers  Multi-Tenant Organization API Headers are available for JumpCloud Admins to use when making API requests from Organizations that have multiple managed organizations.  The `x-org-id` is a required header for all multi-tenant admins when making API requests to JumpCloud. This header will define to which organization you would like to make the request.  **NOTE** Single Tenant Admins do not need to provide this header when making an API request.  ## Header Value  `x-org-id`  ## API Response Codes  * `400` Malformed ID. * `400` x-org-id and Organization path ID do not match. * `401` ID not included for multi-tenant admin * `403` ID included on unsupported route. * `404` Organization ID Not Found.  ```bash curl -X GET https://console.jumpcloud.com/api/v2/directories \\   -H 'accept: application/json' \\   -H 'content-type: application/json' \\   -H 'x-api-key: {API_KEY}' \\   -H 'x-org-id: {ORG_ID}'  ```  ## To Obtain an Individual Organization ID via the UI  As a prerequisite, your Primary Organization will need to be setup for Multi-Tenancy. This provides access to the Multi-Tenant Organization Admin Portal.  1. Log into JumpCloud [Admin Console](https://console.jumpcloud.com). If you are a multi-tenant Admin, you will automatically be routed to the Multi-Tenant Admin Portal. 2. From the Multi-Tenant Portal's primary navigation bar, select the Organization you'd like to access. 3. You will automatically be routed to that Organization's Admin Console. 4. Go to Settings in the sub-tenant's primary navigation. 5. You can obtain your Organization ID below your Organization's Contact Information on the Settings page.  ## To Obtain All Organization IDs via the API  * You can make an API request to this endpoint using the API key of your Primary Organization.  `https://console.jumpcloud.com/api/organizations/` This will return all your managed organizations.  ```bash curl -X GET \\   https://console.jumpcloud.com/api/organizations/ \\   -H 'Accept: application/json' \\   -H 'Content-Type: application/json' \\   -H 'x-api-key: {API_KEY}' ```  # SDKs  You can find language specific SDKs that can help you kickstart your Integration with JumpCloud in the following GitHub repositories:  * [Python](https://github.com/TheJumpCloud/jcapi-python) * [Go](https://github.com/TheJumpCloud/jcapi-go) * [Ruby](https://github.com/TheJumpCloud/jcapi-ruby) * [Java](https://github.com/TheJumpCloud/jcapi-java) 
 *
 * OpenAPI spec version: 2.0
 * Contact: support@jumpcloud.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.api;

import io.swagger.client.model.GraphConnection;
import io.swagger.client.model.GraphObjectWithPaths;
import io.swagger.client.model.GraphOperationActiveDirectory;
import io.swagger.client.model.GraphOperationApplication;
import io.swagger.client.model.GraphOperationCommand;
import io.swagger.client.model.GraphOperationGSuite;
import io.swagger.client.model.GraphOperationLdapServer;
import io.swagger.client.model.GraphOperationOffice365;
import io.swagger.client.model.GraphOperationPolicy;
import io.swagger.client.model.GraphOperationPolicyGroup;
import io.swagger.client.model.GraphOperationPolicyGroupMember;
import io.swagger.client.model.GraphOperationRadiusServer;
import io.swagger.client.model.GraphOperationSoftwareApp;
import io.swagger.client.model.GraphOperationSystem;
import io.swagger.client.model.GraphOperationSystemGroup;
import io.swagger.client.model.GraphOperationSystemGroupMember;
import io.swagger.client.model.GraphOperationUser;
import io.swagger.client.model.GraphOperationUserGroup;
import io.swagger.client.model.GraphOperationUserGroupMember;
import io.swagger.client.model.PolicyResult;
import org.junit.Test;
import org.junit.Ignore;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * API tests for GraphApi
 */
@Ignore
public class GraphApiTest {

    private final GraphApi api = new GraphApi();

    /**
     * List the associations of an Active Directory instance
     *
     * This endpoint returns the direct associations of this Active Directory instance.  A direct association can be a non-homogeneous relationship between 2 different objects, for example Active Directory and Users.   #### Sample Request &#x60;&#x60;&#x60; curl -X GET &#x27;https://console.jumpcloud.com/api/v2/activedirectories/{ActiveDirectory_ID}/associations?targets&#x3D;user \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphActiveDirectoryAssociationsListTest() throws Exception {
        String activedirectoryId = null;
        List<String> targets = null;
        Integer limit = null;
        Integer skip = null;
        String xOrgId = null;
        List<GraphConnection> response = api.graphActiveDirectoryAssociationsList(activedirectoryId, targets, limit, skip, xOrgId);

        // TODO: test validations
    }
    /**
     * Manage the associations of an Active Directory instance
     *
     * This endpoint allows you to manage the _direct_ associations of an Active Directory instance.  A direct association can be a non-homogeneous relationship between 2 different objects, for example Active Directory and Users.  #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/activedirectories/{AD_Instance_ID}/associations \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;user\&quot;,     \&quot;id\&quot;: \&quot;{User_ID}\&quot;   }&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphActiveDirectoryAssociationsPostTest() throws Exception {
        String activedirectoryId = null;
        GraphOperationActiveDirectory body = null;
        String xOrgId = null;
        api.graphActiveDirectoryAssociationsPost(activedirectoryId, body, xOrgId);

        // TODO: test validations
    }
    /**
     * List the Users bound to an Active Directory instance
     *
     * This endpoint will return all Users bound to an Active Directory instance, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this Active Directory instance to the corresponding User; this array represents all grouping and/or associations that would have to be removed to deprovision the User from this Active Directory instance.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/activedirectories/{ActiveDirectory_ID}/users \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphActiveDirectoryTraverseUserTest() throws Exception {
        String activedirectoryId = null;
        List<String> filter = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<GraphObjectWithPaths> response = api.graphActiveDirectoryTraverseUser(activedirectoryId, filter, limit, xOrgId, skip);

        // TODO: test validations
    }
    /**
     * List the User Groups bound to an Active Directory instance
     *
     * This endpoint will return all Users Groups bound to an Active Directory instance, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the group&#x27;s type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this Active Directory instance to the corresponding User Group; this array represents all grouping and/or associations that would have to be removed to deprovision the User Group from this Active Directory instance.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/activedirectories/{ActiveDirectory_ID}/usergroups \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphActiveDirectoryTraverseUserGroupTest() throws Exception {
        String activedirectoryId = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphActiveDirectoryTraverseUserGroup(activedirectoryId, limit, xOrgId, skip, filter);

        // TODO: test validations
    }
    /**
     * List the associations of an Application
     *
     * This endpoint will return the _direct_ associations of an Application. A direct association can be a non-homogeneous relationship between 2 different objects, for example Applications and User Groups.   #### Sample Request &#x60;&#x60;&#x60; curl -X GET &#x27;https://console.jumpcloud.com/api/v2/applications/{Application_ID}/associations?targets&#x3D;user_group \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphApplicationAssociationsListTest() throws Exception {
        String applicationId = null;
        List<String> targets = null;
        Integer limit = null;
        Integer skip = null;
        String xOrgId = null;
        List<GraphConnection> response = api.graphApplicationAssociationsList(applicationId, targets, limit, skip, xOrgId);

        // TODO: test validations
    }
    /**
     * Manage the associations of an Application
     *
     * This endpoint allows you to manage the _direct_ associations of an Application. A direct association can be a non-homogeneous relationship between 2 different objects, for example Application and User Groups.  #### Sample Request &#x60;&#x60;&#x60; curl -X POST &#x27;https://console.jumpcloud.com/api/v2/applications/{Application_ID}/associations&#x27; \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;user_group\&quot;,     \&quot;id\&quot;: \&quot;{Group_ID}\&quot;   }&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphApplicationAssociationsPostTest() throws Exception {
        String applicationId = null;
        GraphOperationApplication body = null;
        String xOrgId = null;
        api.graphApplicationAssociationsPost(applicationId, body, xOrgId);

        // TODO: test validations
    }
    /**
     * List the Users bound to an Application
     *
     * This endpoint will return all Users bound to an Application, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this Application to the corresponding User; this array represents all grouping and/or associations that would have to be removed to deprovision the User from this Application.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/applications/{Application_ID}/users \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphApplicationTraverseUserTest() throws Exception {
        String applicationId = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphApplicationTraverseUser(applicationId, limit, xOrgId, skip, filter);

        // TODO: test validations
    }
    /**
     * List the User Groups bound to an Application
     *
     * This endpoint will return all Users Groups bound to an Application, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the group&#x27;s type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates  each path from this Application to the corresponding User Group; this array represents all grouping and/or associations that would have to be removed to deprovision the User Group from this Application.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/applications/{Application_ID}/usergroups \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphApplicationTraverseUserGroupTest() throws Exception {
        String applicationId = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphApplicationTraverseUserGroup(applicationId, limit, xOrgId, skip, filter);

        // TODO: test validations
    }
    /**
     * List the associations of a Command
     *
     * This endpoint will return the _direct_ associations of this Command.  A direct association can be a non-homogeneous relationship between 2 different objects, for example Commands and User Groups.   #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/commands/{Command_ID}/associations?targets&#x3D;system_group \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphCommandAssociationsListTest() throws Exception {
        String commandId = null;
        List<String> targets = null;
        Integer limit = null;
        Integer skip = null;
        String xOrgId = null;
        List<GraphConnection> response = api.graphCommandAssociationsList(commandId, targets, limit, skip, xOrgId);

        // TODO: test validations
    }
    /**
     * Manage the associations of a Command
     *
     * This endpoint will allow you to manage the _direct_ associations of this Command.  A direct association can be a non-homogeneous relationship between 2 different objects, for example Commands and User Groups.   #### Sample Request &#x60;&#x60;&#x60;  curl -X POST https://console.jumpcloud.com/api/v2/commands/{Command_ID}/associations \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;system_group\&quot;,     \&quot;id\&quot;: \&quot;Group_ID\&quot;   }&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphCommandAssociationsPostTest() throws Exception {
        String commandId = null;
        GraphOperationCommand body = null;
        String xOrgId = null;
        api.graphCommandAssociationsPost(commandId, body, xOrgId);

        // TODO: test validations
    }
    /**
     * List the Systems bound to a Command
     *
     * This endpoint will return all Systems bound to a Command, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this Command to the corresponding System; this array represents all grouping and/or associations that would have to be removed to deprovision the System from this Command.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/commands/{Command_ID}/systems \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphCommandTraverseSystemTest() throws Exception {
        String commandId = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphCommandTraverseSystem(commandId, limit, xOrgId, skip, filter);

        // TODO: test validations
    }
    /**
     * List the System Groups bound to a Command
     *
     * This endpoint will return all System Groups bound to a Command, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the group&#x27;s type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this Command to the corresponding System Group; this array represents all grouping and/or associations that would have to be removed to deprovision the System Group from this Command.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/commands/{Command_ID}/systemgroups \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphCommandTraverseSystemGroupTest() throws Exception {
        String commandId = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphCommandTraverseSystemGroup(commandId, limit, xOrgId, skip, filter);

        // TODO: test validations
    }
    /**
     * List the associations of a G Suite instance
     *
     * This endpoint returns the _direct_ associations of this G Suite instance.  A direct association can be a non-homogeneous relationship between 2 different objects, for example G Suite and Users.   #### Sample Request &#x60;&#x60;&#x60; curl -X GET &#x27;https://console.jumpcloud.com/api/v2/gsuites/{Gsuite_ID}/associations?targets&#x3D;user_group \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphGSuiteAssociationsListTest() throws Exception {
        String gsuiteId = null;
        List<String> targets = null;
        Integer limit = null;
        Integer skip = null;
        String xOrgId = null;
        List<GraphConnection> response = api.graphGSuiteAssociationsList(gsuiteId, targets, limit, skip, xOrgId);

        // TODO: test validations
    }
    /**
     * Manage the associations of a G Suite instance
     *
     * This endpoint returns the _direct_ associations of this G Suite instance.  A direct association can be a non-homogeneous relationship between 2 different objects, for example G Suite and Users.   #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/gsuites/{Gsuite_ID}/associations \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;user_group\&quot;,     \&quot;id\&quot;: \&quot;{Group_ID}\&quot;   }&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphGSuiteAssociationsPostTest() throws Exception {
        String gsuiteId = null;
        GraphOperationGSuite body = null;
        String xOrgId = null;
        api.graphGSuiteAssociationsPost(gsuiteId, body, xOrgId);

        // TODO: test validations
    }
    /**
     * List the Users bound to a G Suite instance
     *
     * This endpoint will return all Users bound to a G Suite instance, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this G Suite instance to the corresponding User; this array represents all grouping and/or associations that would have to be removed to deprovision the User from this G Suite instance.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60;   curl -X GET https://console.jumpcloud.com/api/v2/gsuites/{Gsuite_ID}/users \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphGSuiteTraverseUserTest() throws Exception {
        String gsuiteId = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphGSuiteTraverseUser(gsuiteId, limit, xOrgId, skip, filter);

        // TODO: test validations
    }
    /**
     * List the User Groups bound to a G Suite instance
     *
     * This endpoint will return all User Groups bound to an G Suite instance, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the group&#x27;s type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this G Suite instance to the corresponding User Group; this array represents all grouping and/or associations that would have to be removed to deprovision the User Group from this G Suite instance.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60;   curl -X GET https://console.jumpcloud.com/api/v2/gsuites/{GSuite_ID}/usergroups \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphGSuiteTraverseUserGroupTest() throws Exception {
        String gsuiteId = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphGSuiteTraverseUserGroup(gsuiteId, limit, xOrgId, skip, filter);

        // TODO: test validations
    }
    /**
     * List the associations of a LDAP Server
     *
     * This endpoint returns the _direct_ associations of this LDAP Server.  A direct association can be a non-homogeneous relationship between 2 different objects, for example LDAP and Users.  #### Sample Request  &#x60;&#x60;&#x60;  curl -X GET &#x27;https://console.jumpcloud.com/api/v2/ldapservers/{LDAP_ID}/associations?targets&#x3D;user_group \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphLdapServerAssociationsListTest() throws Exception {
        String ldapserverId = null;
        List<String> targets = null;
        Integer limit = null;
        Integer skip = null;
        String xOrgId = null;
        List<GraphConnection> response = api.graphLdapServerAssociationsList(ldapserverId, targets, limit, skip, xOrgId);

        // TODO: test validations
    }
    /**
     * Manage the associations of a LDAP Server
     *
     * This endpoint allows you to manage the _direct_ associations of a LDAP Server.  A direct association can be a non-homogeneous relationship between 2 different objects, for example LDAP and Users.  #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/ldapservers/{LDAP_ID}/associations \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;user\&quot;,     \&quot;id\&quot;: \&quot;{User_ID}\&quot;   }&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphLdapServerAssociationsPostTest() throws Exception {
        String ldapserverId = null;
        GraphOperationLdapServer body = null;
        String xOrgId = null;
        api.graphLdapServerAssociationsPost(ldapserverId, body, xOrgId);

        // TODO: test validations
    }
    /**
     * List the Users bound to a LDAP Server
     *
     * This endpoint will return all Users bound to an LDAP Server, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this LDAP server instance to the corresponding User; this array represents all grouping and/or associations that would have to be removed to deprovision the User from this LDAP server instance.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/ldapservers/{LDAP_ID}/users \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphLdapServerTraverseUserTest() throws Exception {
        String ldapserverId = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphLdapServerTraverseUser(ldapserverId, limit, xOrgId, skip, filter);

        // TODO: test validations
    }
    /**
     * List the User Groups bound to a LDAP Server
     *
     * This endpoint will return all Users Groups bound to a LDAP Server, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the group&#x27;s type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this LDAP server instance to the corresponding User Group; this array represents all grouping and/or associations that would have to be removed to deprovision the User Group from this LDAP server instance.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/ldapservers/{LDAP_ID}/usergroups \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphLdapServerTraverseUserGroupTest() throws Exception {
        String ldapserverId = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphLdapServerTraverseUserGroup(ldapserverId, limit, xOrgId, skip, filter);

        // TODO: test validations
    }
    /**
     * List the associations of an Office 365 instance
     *
     * This endpoint returns _direct_ associations of an Office 365 instance.   A direct association can be a non-homogeneous relationship between 2 different objects, for example Office 365 and Users.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET &#x27;https://console.jumpcloud.com/api/v2/office365s/{OFFICE365_ID}/associations?targets&#x3D;user_group&#x27; \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27;  &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphOffice365AssociationsListTest() throws Exception {
        String office365Id = null;
        List<String> targets = null;
        Integer limit = null;
        Integer skip = null;
        String xOrgId = null;
        List<GraphConnection> response = api.graphOffice365AssociationsList(office365Id, targets, limit, skip, xOrgId);

        // TODO: test validations
    }
    /**
     * Manage the associations of an Office 365 instance
     *
     * This endpoint allows you to manage the _direct_ associations of a Office 365 instance.  A direct association can be a non-homogeneous relationship between 2 different objects, for example Office 365 and Users.  #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/office365s/{OFFICE365_ID}/associations \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;user_group\&quot;,     \&quot;id\&quot;: \&quot;{Group_ID}\&quot;   }&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphOffice365AssociationsPostTest() throws Exception {
        String office365Id = null;
        GraphOperationOffice365 body = null;
        String xOrgId = null;
        api.graphOffice365AssociationsPost(office365Id, body, xOrgId);

        // TODO: test validations
    }
    /**
     * List the Users bound to an Office 365 instance
     *
     * This endpoint will return all Users bound to an Office 365 instance, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this Office 365 instance to the corresponding User; this array represents all grouping and/or associations that would have to be removed to deprovision the User from this Office 365 instance.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/office365s/{OFFICE365_ID}/users \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphOffice365TraverseUserTest() throws Exception {
        String office365Id = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphOffice365TraverseUser(office365Id, limit, xOrgId, skip, filter);

        // TODO: test validations
    }
    /**
     * List the User Groups bound to an Office 365 instance
     *
     * This endpoint will return all Users Groups bound to an Office 365 instance, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the group&#x27;s type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this Office 365 instance to the corresponding User Group; this array represents all grouping and/or associations that would have to be removed to deprovision the User Group from this Office 365 instance.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60;   curl -X GET https://console.jumpcloud.com/api/v2/office365s/{OFFICE365_ID/usergroups \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphOffice365TraverseUserGroupTest() throws Exception {
        String office365Id = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphOffice365TraverseUserGroup(office365Id, limit, xOrgId, skip, filter);

        // TODO: test validations
    }
    /**
     * List the associations of a Policy
     *
     * This endpoint returns the _direct_ associations of a Policy.  A direct association can be a non-homogeneous relationship between 2 different objects, for example Policies and Systems.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET &#x27;https://console.jumpcloud.com/api/v2/policies/{Policy_ID}/associations?targets&#x3D;system_group \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphPolicyAssociationsListTest() throws Exception {
        String policyId = null;
        List<String> targets = null;
        Integer limit = null;
        Integer skip = null;
        String xOrgId = null;
        List<GraphConnection> response = api.graphPolicyAssociationsList(policyId, targets, limit, skip, xOrgId);

        // TODO: test validations
    }
    /**
     * Manage the associations of a Policy
     *
     * This endpoint allows you to manage the _direct_ associations of a Policy.  A direct association can be a non-homogeneous relationship between 2 different objects, for example Policies and Systems.  #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/policies/{Policy_ID}/associations/ \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;system_group\&quot;,     \&quot;id\&quot;: \&quot;{Group_ID}\&quot;   }&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphPolicyAssociationsPostTest() throws Exception {
        String policyId = null;
        GraphOperationPolicy body = null;
        String xOrgId = null;
        api.graphPolicyAssociationsPost(policyId, body, xOrgId);

        // TODO: test validations
    }
    /**
     * List the associations of a Policy Group.
     *
     * This endpoint returns the _direct_ associations of this Policy Group.  A direct association can be a non-homogeneous relationship between 2 different objects, for example Policy Groups and Policies.   #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/policygroups/{GroupID}/associations?targets&#x3D;system \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphPolicyGroupAssociationsListTest() throws Exception {
        String groupId = null;
        List<String> targets = null;
        Integer limit = null;
        Integer skip = null;
        String xOrgId = null;
        List<GraphConnection> response = api.graphPolicyGroupAssociationsList(groupId, targets, limit, skip, xOrgId);

        // TODO: test validations
    }
    /**
     * Manage the associations of a Policy Group
     *
     * This endpoint manages the _direct_ associations of this Policy Group.  A direct association can be a non-homogeneous relationship between 2 different objects, for example Policy Groups and Policies.   #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/policygroups/{GroupID}/associations \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;system\&quot;,     \&quot;id\&quot;: \&quot;{SystemID}\&quot;   }&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphPolicyGroupAssociationsPostTest() throws Exception {
        String groupId = null;
        GraphOperationPolicyGroup body = null;
        String xOrgId = null;
        api.graphPolicyGroupAssociationsPost(groupId, body, xOrgId);

        // TODO: test validations
    }
    /**
     * List the members of a Policy Group
     *
     * This endpoint returns the Policy members of a Policy Group.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/policygroups/{GroupID}/members \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphPolicyGroupMembersListTest() throws Exception {
        String groupId = null;
        Integer limit = null;
        Integer skip = null;
        String xOrgId = null;
        List<GraphConnection> response = api.graphPolicyGroupMembersList(groupId, limit, skip, xOrgId);

        // TODO: test validations
    }
    /**
     * Manage the members of a Policy Group
     *
     * This endpoint allows you to manage the Policy members of a Policy Group.  #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/policygroups/{GroupID}/members \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;policy\&quot;,     \&quot;id\&quot;: \&quot;{Policy_ID}\&quot;   }&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphPolicyGroupMembersPostTest() throws Exception {
        String groupId = null;
        GraphOperationPolicyGroupMember body = null;
        String xOrgId = null;
        api.graphPolicyGroupMembersPost(groupId, body, xOrgId);

        // TODO: test validations
    }
    /**
     * List the Policy Group&#x27;s membership
     *
     * This endpoint returns all Policy members that are a member of this Policy Group.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/policygroups/{GroupID}/membership \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphPolicyGroupMembershipTest() throws Exception {
        String groupId = null;
        List<String> filter = null;
        Integer limit = null;
        Integer skip = null;
        List<String> sort = null;
        String xOrgId = null;
        List<GraphObjectWithPaths> response = api.graphPolicyGroupMembership(groupId, filter, limit, skip, sort, xOrgId);

        // TODO: test validations
    }
    /**
     * List the Systems bound to a Policy Group
     *
     * This endpoint will return all Systems bound to a Policy Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this Policy Group to the corresponding System; this array represents all grouping and/or associations that would have to be removed to deprovision the System from this Policy Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/policygroups/{GroupID}/systems \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphPolicyGroupTraverseSystemTest() throws Exception {
        String groupId = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphPolicyGroupTraverseSystem(groupId, limit, xOrgId, skip, filter);

        // TODO: test validations
    }
    /**
     * List the System Groups bound to Policy Groups
     *
     * This endpoint will return all System Groups bound to a Policy Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this Policy Group to the corresponding System Group; this array represents all grouping and/or associations that would have to be removed to deprovision the System Group from this Policy Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/policygroups/{GroupID}/systemgroups \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphPolicyGroupTraverseSystemGroupTest() throws Exception {
        String groupId = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphPolicyGroupTraverseSystemGroup(groupId, limit, xOrgId, skip, filter);

        // TODO: test validations
    }
    /**
     * List the parent Groups of a Policy
     *
     * This endpoint returns all the Policy Groups a Policy is a member of.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/policies/{Policy_ID}/memberof \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27;  &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphPolicyMemberOfTest() throws Exception {
        String policyId = null;
        List<String> filter = null;
        Integer limit = null;
        Integer skip = null;
        String date = null;
        String authorization = null;
        List<String> sort = null;
        String xOrgId = null;
        List<GraphObjectWithPaths> response = api.graphPolicyMemberOf(policyId, filter, limit, skip, date, authorization, sort, xOrgId);

        // TODO: test validations
    }
    /**
     * List the Systems bound to a Policy
     *
     * This endpoint will return all Systems bound to a Policy, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this Policy to the corresponding System; this array represents all grouping and/or associations that would have to be removed to deprovision the System from this Policy.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/policies/{Policy_ID}/systems \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphPolicyTraverseSystemTest() throws Exception {
        String policyId = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphPolicyTraverseSystem(policyId, limit, xOrgId, skip, filter);

        // TODO: test validations
    }
    /**
     * List the System Groups bound to a Policy
     *
     * This endpoint will return all Systems Groups bound to a Policy, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the group&#x27;s type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this Policy to the corresponding System Group; this array represents all grouping and/or associations that would have to be removed to deprovision the System Group from this Policy.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET  https://console.jumpcloud.com/api/v2/policies/{Policy_ID}/systemgroups \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphPolicyTraverseSystemGroupTest() throws Exception {
        String policyId = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphPolicyTraverseSystemGroup(policyId, limit, xOrgId, skip, filter);

        // TODO: test validations
    }
    /**
     * List the associations of a RADIUS  Server
     *
     * This endpoint returns the _direct_ associations of a Radius Server.  A direct association can be a non-homogeneous relationship between 2 different objects, for example Radius Servers and Users.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/radiusservers/{RADIUS_ID}/associations?targets&#x3D;user_group \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphRadiusServerAssociationsListTest() throws Exception {
        String radiusserverId = null;
        List<String> targets = null;
        Integer limit = null;
        Integer skip = null;
        String xOrgId = null;
        List<GraphConnection> response = api.graphRadiusServerAssociationsList(radiusserverId, targets, limit, skip, xOrgId);

        // TODO: test validations
    }
    /**
     * Manage the associations of a RADIUS Server
     *
     * This endpoint allows you to manage the _direct_ associations of a Radius Server.  A direct association can be a non-homogeneous relationship between 2 different objects, for example Radius Servers and Users.  #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/radiusservers/{RADIUS_ID}/associations \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{   \&quot;type\&quot;:\&quot;user\&quot;,  \&quot;id\&quot;:\&quot;{USER_ID}\&quot;,  \&quot;op\&quot;:\&quot;add\&quot;   }&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphRadiusServerAssociationsPostTest() throws Exception {
        String radiusserverId = null;
        GraphOperationRadiusServer body = null;
        String xOrgId = null;
        api.graphRadiusServerAssociationsPost(radiusserverId, body, xOrgId);

        // TODO: test validations
    }
    /**
     * List the Users bound to a RADIUS  Server
     *
     * This endpoint will return all Users bound to a RADIUS Server, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this RADIUS server instance to the corresponding User; this array represents all grouping and/or associations that would have to be removed to deprovision the User from this RADIUS server instance.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.   #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/ldapservers/{LDAP_ID}/users \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27;   &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphRadiusServerTraverseUserTest() throws Exception {
        String radiusserverId = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphRadiusServerTraverseUser(radiusserverId, limit, xOrgId, skip, filter);

        // TODO: test validations
    }
    /**
     * List the User Groups bound to a RADIUS  Server
     *
     * This endpoint will return all Users Groups bound to a RADIUS Server, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the group&#x27;s type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this RADIUS server instance to the corresponding User Group; this array represents all grouping and/or associations that would have to be removed to deprovision the User Group from this RADIUS server instance.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/radiusservers/{RADIUS_ID}/usergroups \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphRadiusServerTraverseUserGroupTest() throws Exception {
        String radiusserverId = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphRadiusServerTraverseUserGroup(radiusserverId, limit, xOrgId, skip, filter);

        // TODO: test validations
    }
    /**
     * List the associations of a Software Application
     *
     * This endpoint will return the _direct_ associations of a Software Application. A direct association can be a non-homogeneous relationship between 2 different objects, for example Software Application and System Groups.   #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/softwareapps/{software_app_id}/associations?targets&#x3D;system_group \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphSoftwareappsAssociationsListTest() throws Exception {
        String softwareAppId = null;
        List<String> targets = null;
        Integer limit = null;
        Integer skip = null;
        String xOrgId = null;
        List<GraphConnection> response = api.graphSoftwareappsAssociationsList(softwareAppId, targets, limit, skip, xOrgId);

        // TODO: test validations
    }
    /**
     * Manage the associations of a software application.
     *
     * This endpoint allows you to associate or disassociate a software application to a system or system group.  #### Sample Request &#x60;&#x60;&#x60; $ curl -X POST https://console.jumpcloud.com/api/v2/softwareapps/{software_app_id}/associations \\ -H &#x27;Accept: application/json&#x27; \\ -H &#x27;Content-Type: application/json&#x27; \\ -H &#x27;x-api-key: {API_KEY}&#x27; \\ -d &#x27;{   \&quot;id\&quot;: \&quot;&lt;object_id&gt;\&quot;,   \&quot;op\&quot;: \&quot;add\&quot;,   \&quot;type\&quot;: \&quot;system\&quot;  }&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphSoftwareappsAssociationsPostTest() throws Exception {
        String softwareAppId = null;
        GraphOperationSoftwareApp body = null;
        String xOrgId = null;
        api.graphSoftwareappsAssociationsPost(softwareAppId, body, xOrgId);

        // TODO: test validations
    }
    /**
     * List the Systems bound to a Software App.
     *
     * This endpoint will return all Systems bound to a Software App, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this Software App to the corresponding System; this array represents all grouping and/or associations that would have to be removed to deprovision the System from this Software App.  See &#x60;/associations&#x60; endpoint to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/softwareapps/{software_app_id}/systems \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphSoftwareappsTraverseSystemTest() throws Exception {
        String softwareAppId = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphSoftwareappsTraverseSystem(softwareAppId, limit, xOrgId, skip, filter);

        // TODO: test validations
    }
    /**
     * List the System Groups bound to a Software App.
     *
     * This endpoint will return all Systems Groups bound to a Software App, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the group&#x27;s type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this Software App to the corresponding System Group; this array represents all grouping and/or associations that would have to be removed to deprovision the System Group from this Software App.  See &#x60;/associations&#x60; endpoint to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET  https://console.jumpcloud.com/api/v2/softwareapps/{software_app_id}/systemgroups \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphSoftwareappsTraverseSystemGroupTest() throws Exception {
        String softwareAppId = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphSoftwareappsTraverseSystemGroup(softwareAppId, limit, xOrgId, skip, filter);

        // TODO: test validations
    }
    /**
     * List the associations of a System
     *
     * This endpoint returns the _direct_ associations of a System.  A direct association can be a non-homogeneous relationship between 2 different objects, for example Systems and Users.   #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systems/{System_ID}/associations?targets&#x3D;user \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27;  &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphSystemAssociationsListTest() throws Exception {
        String systemId = null;
        List<String> targets = null;
        Integer limit = null;
        Integer skip = null;
        String date = null;
        String authorization = null;
        String xOrgId = null;
        List<GraphConnection> response = api.graphSystemAssociationsList(systemId, targets, limit, skip, date, authorization, xOrgId);

        // TODO: test validations
    }
    /**
     * Manage associations of a System
     *
     * This endpoint allows you to manage the _direct_ associations of a System.  A direct association can be a non-homogeneous relationship between 2 different objects, for example Systems and Users.   #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/systems/{System_ID}/associations \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{     \&quot;attributes\&quot;: {       \&quot;sudo\&quot;: {         \&quot;enabled\&quot;: true,         \&quot;withoutPassword\&quot;: false       }     },     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;user\&quot;,     \&quot;id\&quot;: \&quot;UserID\&quot;   }&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphSystemAssociationsPostTest() throws Exception {
        String systemId = null;
        GraphOperationSystem body = null;
        String date = null;
        String authorization = null;
        String xOrgId = null;
        api.graphSystemAssociationsPost(systemId, body, date, authorization, xOrgId);

        // TODO: test validations
    }
    /**
     * List the associations of a System Group
     *
     * This endpoint returns the _direct_ associations of a System Group.  A direct association can be a non-homogeneous relationship between 2 different objects, for example System Groups and Users.   #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systemgroups/{GroupID}/associations?targets&#x3D;user \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphSystemGroupAssociationsListTest() throws Exception {
        String groupId = null;
        List<String> targets = null;
        Integer limit = null;
        Integer skip = null;
        String xOrgId = null;
        List<GraphConnection> response = api.graphSystemGroupAssociationsList(groupId, targets, limit, skip, xOrgId);

        // TODO: test validations
    }
    /**
     * Manage the associations of a System Group
     *
     * This endpoint allows you to manage the _direct_ associations of a System Group.  A direct association can be a non-homogeneous relationship between 2 different objects, for example System Groups and Users.   #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/systemgroups/{GroupID}/associations \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;user\&quot;,     \&quot;id\&quot;: \&quot;{UserID}\&quot;   }&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphSystemGroupAssociationsPostTest() throws Exception {
        String groupId = null;
        GraphOperationSystemGroup body = null;
        String xOrgId = null;
        api.graphSystemGroupAssociationsPost(groupId, body, xOrgId);

        // TODO: test validations
    }
    /**
     * List the members of a System Group
     *
     * This endpoint returns the system members of a System Group.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systemgroups/{Group_ID}/members \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27;  &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphSystemGroupMembersListTest() throws Exception {
        String groupId = null;
        Integer limit = null;
        Integer skip = null;
        String xOrgId = null;
        List<GraphConnection> response = api.graphSystemGroupMembersList(groupId, limit, skip, xOrgId);

        // TODO: test validations
    }
    /**
     * Manage the members of a System Group
     *
     * This endpoint allows you to manage the system members of a System Group.  #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/systemgroups/{Group_ID}/members \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;system\&quot;,     \&quot;id\&quot;: \&quot;{System_ID}\&quot;   }&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphSystemGroupMembersPostTest() throws Exception {
        String groupId = null;
        GraphOperationSystemGroupMember body = null;
        String date = null;
        String authorization = null;
        String xOrgId = null;
        api.graphSystemGroupMembersPost(groupId, body, date, authorization, xOrgId);

        // TODO: test validations
    }
    /**
     * List the System Group&#x27;s membership
     *
     * This endpoint returns all Systems that are a member of this System Group.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systemgroups/{Group_ID/membership \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27;  &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphSystemGroupMembershipTest() throws Exception {
        String groupId = null;
        Integer limit = null;
        Integer skip = null;
        List<String> sort = null;
        List<String> filter = null;
        String xOrgId = null;
        List<GraphObjectWithPaths> response = api.graphSystemGroupMembership(groupId, limit, skip, sort, filter, xOrgId);

        // TODO: test validations
    }
    /**
     * List the Commands bound to a System Group
     *
     * This endpoint will return all Commands bound to a System Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the group&#x27;s type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this System Group to the corresponding Command; this array represents all grouping and/or associations that would have to be removed to deprovision the Command from this System Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systemgroups/{GroupID}/commands \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphSystemGroupTraverseCommandTest() throws Exception {
        String groupId = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphSystemGroupTraverseCommand(groupId, limit, xOrgId, skip, filter);

        // TODO: test validations
    }
    /**
     * List the Policies bound to a System Group
     *
     * This endpoint will return all Policies bound to a System Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this System Group to the corresponding Policy; this array represents all grouping and/or associations that would have to be removed to deprovision the Policy from this System Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  This endpoint is not public yet as we haven&#x27;t finished the code.  ##### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systemgroups/{GroupID}/policies \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphSystemGroupTraversePolicyTest() throws Exception {
        String groupId = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphSystemGroupTraversePolicy(groupId, limit, xOrgId, skip, filter);

        // TODO: test validations
    }
    /**
     * List the Policy Groups bound to a System Group
     *
     * This endpoint will return all Policy Groups bound to a System Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this System Group to the corresponding Policy Group; this array represents all grouping and/or associations that would have to be removed to deprovision the Policy Group from this System Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systemgroups/{GroupID}/policygroups \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27;  &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphSystemGroupTraversePolicyGroupTest() throws Exception {
        String groupId = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphSystemGroupTraversePolicyGroup(groupId, limit, xOrgId, skip, filter);

        // TODO: test validations
    }
    /**
     * List the Users bound to a System Group
     *
     * This endpoint will return all Users bound to a System Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this System Group to the corresponding User; this array represents all grouping and/or associations that would have to be removed to deprovision the User from this System Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systemgroups/{GroupID}/users \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphSystemGroupTraverseUserTest() throws Exception {
        String groupId = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphSystemGroupTraverseUser(groupId, limit, xOrgId, skip, filter);

        // TODO: test validations
    }
    /**
     * List the User Groups bound to a System Group
     *
     * This endpoint will return all User Groups bound to a System Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this System Group to the corresponding User Group; this array represents all grouping and/or associations that would have to be removed to deprovision the User Group from this System Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systemgroups/{GroupID}/usergroups \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27;  &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphSystemGroupTraverseUserGroupTest() throws Exception {
        String groupId = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphSystemGroupTraverseUserGroup(groupId, limit, xOrgId, skip, filter);

        // TODO: test validations
    }
    /**
     * List the parent Groups of a System
     *
     * This endpoint returns all the System Groups a System is a member of.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systems/{System_ID}/memberof \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27;  &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphSystemMemberOfTest() throws Exception {
        String systemId = null;
        List<String> filter = null;
        Integer limit = null;
        Integer skip = null;
        String date = null;
        String authorization = null;
        List<String> sort = null;
        String xOrgId = null;
        List<GraphObjectWithPaths> response = api.graphSystemMemberOf(systemId, filter, limit, skip, date, authorization, sort, xOrgId);

        // TODO: test validations
    }
    /**
     * List the Commands bound to a System
     *
     * This endpoint will return all Commands bound to a System, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this System to the corresponding Command; this array represents all grouping and/or associations that would have to be removed to deprovision the Command from this System.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systems/{System_ID}/commands \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27;  &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphSystemTraverseCommandTest() throws Exception {
        String systemId = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphSystemTraverseCommand(systemId, limit, xOrgId, skip, filter);

        // TODO: test validations
    }
    /**
     * List the Policies bound to a System
     *
     * This endpoint will return all Policies bound to a System, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this System to the corresponding Policy; this array represents all grouping and/or associations that would have to be removed to deprovision the Policy from this System.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  This endpoint is not yet public as we have finish the code.  ##### Sample Request  &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/{System_ID}/policies \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27;  &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphSystemTraversePolicyTest() throws Exception {
        String systemId = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphSystemTraversePolicy(systemId, limit, xOrgId, skip, filter);

        // TODO: test validations
    }
    /**
     * List the Policy Groups bound to a System
     *
     * This endpoint will return all Policy Groups bound to a System, either directly or indirectly essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this System to the corresponding Policy Group; this array represents all grouping and/or associations that would have to be removed to deprovision the Policy Group from this System.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systems/{System_ID}/policygroups \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27;  &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphSystemTraversePolicyGroupTest() throws Exception {
        String systemId = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        String date = null;
        String authorization = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphSystemTraversePolicyGroup(systemId, limit, xOrgId, skip, date, authorization, filter);

        // TODO: test validations
    }
    /**
     * List the Users bound to a System
     *
     * This endpoint will return all Users bound to a System, either directly or indirectly essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this System to the corresponding User; this array represents all grouping and/or associations that would have to be removed to deprovision the User from this System.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systems/{System_ID}/users \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27;  &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphSystemTraverseUserTest() throws Exception {
        String systemId = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        String date = null;
        String authorization = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphSystemTraverseUser(systemId, limit, xOrgId, skip, date, authorization, filter);

        // TODO: test validations
    }
    /**
     * List the User Groups bound to a System
     *
     * This endpoint will return all User Groups bound to a System, either directly or indirectly essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this System to the corresponding User Group; this array represents all grouping and/or associations that would have to be removed to deprovision the User Group from this System.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systems/{System_ID}/usergroups \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27;  &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphSystemTraverseUserGroupTest() throws Exception {
        String systemId = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        String date = null;
        String authorization = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphSystemTraverseUserGroup(systemId, limit, xOrgId, skip, date, authorization, filter);

        // TODO: test validations
    }
    /**
     * List the associations of a User
     *
     * This endpoint returns the _direct_ associations of a User.  A direct association can be a non-homogeneous relationship between 2 different objects, for example Users and Systems.   #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/users/{UserID}/associations?targets&#x3D;system_group \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27;  &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphUserAssociationsListTest() throws Exception {
        String userId = null;
        List<String> targets = null;
        Integer limit = null;
        Integer skip = null;
        String xOrgId = null;
        List<GraphConnection> response = api.graphUserAssociationsList(userId, targets, limit, skip, xOrgId);

        // TODO: test validations
    }
    /**
     * Manage the associations of a User
     *
     * This endpoint allows you to manage the _direct_ associations of a User.  A direct association can be a non-homogeneous relationship between 2 different objects, for example Users and Systems.   #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/users/{UserID}/associations \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{     \&quot;attributes\&quot;: {       \&quot;sudo\&quot;: {       \&quot;enabled\&quot;: true,         \&quot;withoutPassword\&quot;: false       }     },     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;system_group\&quot;,     \&quot;id\&quot;: \&quot;{GroupID}\&quot;   }&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphUserAssociationsPostTest() throws Exception {
        String userId = null;
        GraphOperationUser body = null;
        String xOrgId = null;
        api.graphUserAssociationsPost(userId, body, xOrgId);

        // TODO: test validations
    }
    /**
     * List the associations of a User Group.
     *
     * This endpoint returns the _direct_ associations of this User Group.  A direct association can be a non-homogeneous relationship between 2 different objects, for example User Groups and Users.   #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/associations?targets&#x3D;system \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphUserGroupAssociationsListTest() throws Exception {
        String groupId = null;
        List<String> targets = null;
        Integer limit = null;
        Integer skip = null;
        String xOrgId = null;
        List<GraphConnection> response = api.graphUserGroupAssociationsList(groupId, targets, limit, skip, xOrgId);

        // TODO: test validations
    }
    /**
     * Manage the associations of a User Group
     *
     * This endpoint manages the _direct_ associations of this User Group.  A direct association can be a non-homogeneous relationship between 2 different objects, for example User Groups and Users.   #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/associations \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;system\&quot;,     \&quot;id\&quot;: \&quot;{SystemID}\&quot;   }&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphUserGroupAssociationsPostTest() throws Exception {
        String groupId = null;
        GraphOperationUserGroup body = null;
        String xOrgId = null;
        api.graphUserGroupAssociationsPost(groupId, body, xOrgId);

        // TODO: test validations
    }
    /**
     * List the members of a User Group
     *
     * This endpoint returns the user members of a User Group.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/members \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphUserGroupMembersListTest() throws Exception {
        String groupId = null;
        Integer limit = null;
        Integer skip = null;
        String xOrgId = null;
        List<GraphConnection> response = api.graphUserGroupMembersList(groupId, limit, skip, xOrgId);

        // TODO: test validations
    }
    /**
     * Manage the members of a User Group
     *
     * This endpoint allows you to manage the user members of a User Group.  #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/members \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;user\&quot;,     \&quot;id\&quot;: \&quot;{User_ID}\&quot;   }&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphUserGroupMembersPostTest() throws Exception {
        String groupId = null;
        GraphOperationUserGroupMember body = null;
        String xOrgId = null;
        api.graphUserGroupMembersPost(groupId, body, xOrgId);

        // TODO: test validations
    }
    /**
     * List the User Group&#x27;s membership
     *
     * This endpoint returns all users members that are a member of this User Group.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/membership \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphUserGroupMembershipTest() throws Exception {
        String groupId = null;
        List<String> filter = null;
        Integer limit = null;
        Integer skip = null;
        List<String> sort = null;
        String xOrgId = null;
        List<GraphObjectWithPaths> response = api.graphUserGroupMembership(groupId, filter, limit, skip, sort, xOrgId);

        // TODO: test validations
    }
    /**
     * List the Active Directories bound to a User Group
     *
     * This endpoint will return all Active Directory Instances bound to a User Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User Group to the corresponding Active Directory; this array represents all grouping and/or associations that would have to be removed to deprovision the Active Directory from this User Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/activedirectories \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphUserGroupTraverseActiveDirectoryTest() throws Exception {
        String groupId = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphUserGroupTraverseActiveDirectory(groupId, limit, xOrgId, skip, filter);

        // TODO: test validations
    }
    /**
     * List the Applications bound to a User Group
     *
     * This endpoint will return all Applications bound to a User Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User Group to the corresponding Application; this array represents all grouping and/or associations that would have to be removed to deprovision the Application from this User Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/applications \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphUserGroupTraverseApplicationTest() throws Exception {
        String groupId = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphUserGroupTraverseApplication(groupId, limit, xOrgId, skip, filter);

        // TODO: test validations
    }
    /**
     * List the Directories bound to a User Group
     *
     * This endpoint will return all Directories bound to a User Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User Group to the corresponding Directory; this array represents all grouping and/or associations that would have to be removed to deprovision the Directories from this User Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/directories \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27;  &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphUserGroupTraverseDirectoryTest() throws Exception {
        String groupId = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphUserGroupTraverseDirectory(groupId, limit, xOrgId, skip, filter);

        // TODO: test validations
    }
    /**
     * List the G Suite instances bound to a User Group
     *
     * This endpoint will return all G Suite Instances bound to a User Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User Group to the corresponding G Suite instance; this array represents all grouping and/or associations that would have to be removed to deprovision the G Suite instance from this User Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID/gsuites \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27;  &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphUserGroupTraverseGSuiteTest() throws Exception {
        String groupId = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphUserGroupTraverseGSuite(groupId, limit, xOrgId, skip, filter);

        // TODO: test validations
    }
    /**
     * List the LDAP Servers bound to a User Group
     *
     * This endpoint will return all LDAP Servers bound to a User Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User Group to the corresponding LDAP Server; this array represents all grouping and/or associations that would have to be removed to deprovision the LDAP Server from this User Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/ldapservers \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphUserGroupTraverseLdapServerTest() throws Exception {
        String groupId = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphUserGroupTraverseLdapServer(groupId, limit, xOrgId, skip, filter);

        // TODO: test validations
    }
    /**
     * List the Office 365 instances bound to a User Group
     *
     * This endpoint will return all Office 365 instances bound to a User Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User Group to the corresponding Office 365 instance; this array represents all grouping and/or associations that would have to be removed to deprovision the Office 365 instance from this User Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/office365s \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphUserGroupTraverseOffice365Test() throws Exception {
        String groupId = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphUserGroupTraverseOffice365(groupId, limit, xOrgId, skip, filter);

        // TODO: test validations
    }
    /**
     * List the RADIUS Servers bound to a User Group
     *
     * This endpoint will return all RADIUS servers bound to a User Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User Group to the corresponding RADIUS Server; this array represents all grouping and/or associations that would have to be removed to deprovision the RADIUS Server from this User Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/radiusservers \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27;  &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphUserGroupTraverseRadiusServerTest() throws Exception {
        String groupId = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphUserGroupTraverseRadiusServer(groupId, limit, xOrgId, skip, filter);

        // TODO: test validations
    }
    /**
     * List the Systems bound to a User Group
     *
     * This endpoint will return all Systems bound to a User Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User Group to the corresponding System; this array represents all grouping and/or associations that would have to be removed to deprovision the System from this User Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/systems \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphUserGroupTraverseSystemTest() throws Exception {
        String groupId = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphUserGroupTraverseSystem(groupId, limit, xOrgId, skip, filter);

        // TODO: test validations
    }
    /**
     * List the System Groups bound to User Groups
     *
     * This endpoint will return all System Groups bound to a User Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User Group to the corresponding System Group; this array represents all grouping and/or associations that would have to be removed to deprovision the System Group from this User Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/systemgroups \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphUserGroupTraverseSystemGroupTest() throws Exception {
        String groupId = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphUserGroupTraverseSystemGroup(groupId, limit, xOrgId, skip, filter);

        // TODO: test validations
    }
    /**
     * List the parent Groups of a User
     *
     * This endpoint returns all the User Groups a User is a member of.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/users/{UserID}/memberof \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphUserMemberOfTest() throws Exception {
        String userId = null;
        List<String> filter = null;
        Integer limit = null;
        Integer skip = null;
        List<String> sort = null;
        String xOrgId = null;
        List<GraphObjectWithPaths> response = api.graphUserMemberOf(userId, filter, limit, skip, sort, xOrgId);

        // TODO: test validations
    }
    /**
     * List the Active Directory instances bound to a User
     *
     * This endpoint will return all Active Directory Instances bound to a User, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User to the corresponding Active Directory instance; this array represents all grouping and/or associations that would have to be removed to deprovision the Active Directory instance from this User.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/users/{UserID}/activedirectories \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphUserTraverseActiveDirectoryTest() throws Exception {
        String userId = null;
        List<String> filter = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<GraphObjectWithPaths> response = api.graphUserTraverseActiveDirectory(userId, filter, limit, xOrgId, skip);

        // TODO: test validations
    }
    /**
     * List the Applications bound to a User
     *
     * This endpoint will return all Applications bound to a User, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User to the corresponding Application; this array represents all grouping and/or associations that would have to be removed to deprovision the Application from this User.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/users/{UserID}/applications \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphUserTraverseApplicationTest() throws Exception {
        String userId = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphUserTraverseApplication(userId, limit, xOrgId, skip, filter);

        // TODO: test validations
    }
    /**
     * List the Directories bound to a User
     *
     * This endpoint will return all Directories bound to a User, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User to the corresponding Directory; this array represents all grouping and/or associations that would have to be removed to deprovision the Directory from this User.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/users/{UserID}/directories \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphUserTraverseDirectoryTest() throws Exception {
        String userId = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphUserTraverseDirectory(userId, limit, xOrgId, skip, filter);

        // TODO: test validations
    }
    /**
     * List the G Suite instances bound to a User
     *
     * This endpoint will return all G-Suite Instances bound to a User, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User to the corresponding G Suite instance; this array represents all grouping and/or associations that would have to be removed to deprovision the G Suite instance from this User.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/users/{UserID}/gsuites \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphUserTraverseGSuiteTest() throws Exception {
        String userId = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphUserTraverseGSuite(userId, limit, xOrgId, skip, filter);

        // TODO: test validations
    }
    /**
     * List the LDAP servers bound to a User
     *
     * This endpoint will return all LDAP Servers bound to a User, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User to the corresponding LDAP Server; this array represents all grouping and/or associations that would have to be removed to deprovision the LDAP Server from this User.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/users/{UserID}/ldapservers \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphUserTraverseLdapServerTest() throws Exception {
        String userId = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphUserTraverseLdapServer(userId, limit, xOrgId, skip, filter);

        // TODO: test validations
    }
    /**
     * List the Office 365 instances bound to a User
     *
     * This endpoint will return all Office 365 Instances bound to a User, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User to the corresponding Office 365 instance; this array represents all grouping and/or associations that would have to be removed to deprovision the Office 365 instance from this User.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/users/{UserID}/office365s \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphUserTraverseOffice365Test() throws Exception {
        String userId = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphUserTraverseOffice365(userId, limit, xOrgId, skip, filter);

        // TODO: test validations
    }
    /**
     * List the RADIUS Servers bound to a User
     *
     * This endpoint will return all RADIUS Servers bound to a User, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User to the corresponding RADIUS Server; this array represents all grouping and/or associations that would have to be removed to deprovision the RADIUS Server from this User.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/users/{UserID}/radiusservers \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphUserTraverseRadiusServerTest() throws Exception {
        String userId = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphUserTraverseRadiusServer(userId, limit, xOrgId, skip, filter);

        // TODO: test validations
    }
    /**
     * List the Systems bound to a User
     *
     * This endpoint will return all Systems bound to a User, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User to the corresponding System; this array represents all grouping and/or associations that would have to be removed to deprovision the System from this User.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/users/{UserID}/systems\\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphUserTraverseSystemTest() throws Exception {
        String userId = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphUserTraverseSystem(userId, limit, xOrgId, skip, filter);

        // TODO: test validations
    }
    /**
     * List the System Groups bound to a User
     *
     * This endpoint will return all System Groups bound to a User, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User to the corresponding System Group; this array represents all grouping and/or associations that would have to be removed to deprovision the System Group from this User.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/users/{UserID}/systemgroups\\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void graphUserTraverseSystemGroupTest() throws Exception {
        String userId = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphUserTraverseSystemGroup(userId, limit, xOrgId, skip, filter);

        // TODO: test validations
    }
    /**
     * List the policy statuses for a system
     *
     * This endpoint returns the policy results for a particular system.  ##### Sample Request  &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systems/{System_ID}/policystatuses \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27;  &#x60;&#x60;&#x60;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void policystatusesSystemsListTest() throws Exception {
        String systemId = null;
        List<String> fields = null;
        List<String> filter = null;
        Integer limit = null;
        Integer skip = null;
        List<String> sort = null;
        String xOrgId = null;
        List<PolicyResult> response = api.policystatusesSystemsList(systemId, fields, filter, limit, skip, sort, xOrgId);

        // TODO: test validations
    }
}
