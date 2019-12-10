/*
 * JumpCloud APIs
 *  JumpCloud's V1 API. This set of endpoints allows JumpCloud customers to manage commands, systems, & system users.
 *
 * OpenAPI spec version: 1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.model.Body2;
import io.swagger.client.model.Errorresponse;
import io.swagger.client.model.Sshkeylist;
import io.swagger.client.model.Sshkeypost;
import io.swagger.client.model.Systemuserput;
import io.swagger.client.model.Systemuserputpost;
import io.swagger.client.model.Systemuserreturn;
import io.swagger.client.model.Systemuserslist;
import io.swagger.client.model.Usersystembinding;
import io.swagger.client.model.Usersystembindingsput;
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
     * Delete a system user&#39;s Public SSH Keys
     *
     * This endpoint will delete a specific System User&#39;s SSH Key.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void sshkeyDeleteTest() throws ApiException {
        String systemuserId = null;
        String id = null;
        String contentType = null;
        String accept = null;
        String xOrgId = null;
        api.sshkeyDelete(systemuserId, id, contentType, accept, xOrgId);

        // TODO: test validations
    }
    
    /**
     * List a system user&#39;s public SSH keys
     *
     * This endpoint will return a specific System User&#39;s public SSH key.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void sshkeyListTest() throws ApiException {
        String id = null;
        String contentType = null;
        String accept = null;
        String xOrgId = null;
        List<Sshkeylist> response = api.sshkeyList(id, contentType, accept, xOrgId);

        // TODO: test validations
    }
    
    /**
     * Create a system user&#39;s Public SSH Key
     *
     * This endpoint will create a specific System User&#39;s Public SSH Key.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void sshkeyPostTest() throws ApiException {
        String id = null;
        String contentType = null;
        String accept = null;
        Sshkeypost body = null;
        String xOrgId = null;
        Sshkeylist response = api.sshkeyPost(id, contentType, accept, body, xOrgId);

        // TODO: test validations
    }
    
    /**
     * Delete a system user
     *
     * This endpoint allows you to delete a particular system user.  #### Sample Request &#x60;&#x60;&#x60; curl -X DELETE https://console.jumpcloud.com/api/systemusers/{UserID} \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;  &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void systemusersDeleteTest() throws ApiException {
        String id = null;
        String contentType = null;
        String accept = null;
        String xOrgId = null;
        Systemuserreturn response = api.systemusersDelete(id, contentType, accept, xOrgId);

        // TODO: test validations
    }
    
    /**
     * List a system user
     *
     * This endpoint returns a particular System User.  #### Sample Request  &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/systemusers/{UserID} \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void systemusersGetTest() throws ApiException {
        String id = null;
        String contentType = null;
        String accept = null;
        String fields = null;
        String filter = null;
        String xOrgId = null;
        Systemuserreturn response = api.systemusersGet(id, contentType, accept, fields, filter, xOrgId);

        // TODO: test validations
    }
    
    /**
     * List all system users
     *
     * This endpoint returns all systemusers.  #### Sample Request  &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/systemusers \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void systemusersListTest() throws ApiException {
        String contentType = null;
        String accept = null;
        Integer limit = null;
        Integer skip = null;
        String sort = null;
        String fields = null;
        String xOrgId = null;
        String search = null;
        String filter = null;
        Systemuserslist response = api.systemusersList(contentType, accept, limit, skip, sort, fields, xOrgId, search, filter);

        // TODO: test validations
    }
    
    /**
     * Create a system user
     *
     * This endpoint allows you to create a new system user.  #### Sample Request  &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/systemusers \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{  \&quot;username\&quot;:\&quot;{username}\&quot;,  \&quot;email\&quot;:\&quot;{email_address}\&quot;,  \&quot;firstname\&quot;:\&quot;{Name}\&quot;,  \&quot;lastname\&quot;:\&quot;{Name}\&quot; }&#39; &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void systemusersPostTest() throws ApiException {
        String contentType = null;
        String accept = null;
        Systemuserputpost body = null;
        String xOrgId = null;
        Systemuserreturn response = api.systemusersPost(contentType, accept, body, xOrgId);

        // TODO: test validations
    }
    
    /**
     * Update a system user
     *
     * This endpoint allows you to update a system user.  #### Sample Request  &#x60;&#x60;&#x60; curl -X PUT https://console.jumpcloud.com/api/systemusers/{UserID} \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{  \&quot;email\&quot;:\&quot;{email_address}\&quot;,  \&quot;firstname\&quot;:\&quot;{Name}\&quot;,  \&quot;lastname\&quot;:\&quot;{Name}\&quot; }&#39; &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void systemusersPutTest() throws ApiException {
        String id = null;
        String contentType = null;
        String accept = null;
        Systemuserput body = null;
        String xOrgId = null;
        Systemuserreturn response = api.systemusersPut(id, contentType, accept, body, xOrgId);

        // TODO: test validations
    }
    
    /**
     * Reset a system user&#39;s MFA token
     *
     * This endpoint allows you to reset the TOTP key for a specified system user and put them in an TOTP MFA enrollment period. This will result in the user being prompted to setup TOTP MFA when logging into userportal. Please be aware that if the user does not complete TOTP MFA setup before the &#x60;exclusionUntil&#x60; date, they will be locked out of any resources that require TOTP MFA.  Please refer to our [Knowledge Base Article](https://support.jumpcloud.com/customer/en/portal/articles/2959138-using-multifactor-authentication-with-jumpcloud) on setting up MFA for more information.   #### Sample Request  &#x60;&#x60;&#x60; curl -X POST \\   https://console.jumpcloud.com/api/systemusers/{UserID}/resetmfa \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{\&quot;exclusion\&quot;: true, \&quot;exclusionUntil\&quot;: \&quot;{date-time}\&quot;}&#39;     &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void systemusersResetmfaTest() throws ApiException {
        String id = null;
        String contentType = null;
        String accept = null;
        Body2 body = null;
        String xOrgId = null;
        api.systemusersResetmfa(id, contentType, accept, body, xOrgId);

        // TODO: test validations
    }
    
    /**
     * List system user binding
     *
     * Hidden as Tags is deprecated  Adds or removes a system binding for a user.   This endpoint is only used for users still using JumpCloud Tags. If you are using JumpCloud Groups please refer to the documentation found [here](https://docs.jumpcloud.com/2.0/systems/manage-associations-of-a-system).   List system bindings for a specific system user in a system and user binding format.  ### Examples  #### List system bindings for specific system user  &#x60;&#x60;&#x60; curl \\   -H &#39;Content-Type: application/json&#39; \\   -H \&quot;x-api-key: [YOUR_API_KEY_HERE]\&quot; \\   \&quot;https://console.jumpcloud.com/api/systemusers/[SYSTEM_USER_ID_HERE]/systems\&quot; &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void systemusersSystemsBindingListTest() throws ApiException {
        String id = null;
        String contentType = null;
        String accept = null;
        String fields = null;
        Integer limit = null;
        Integer skip = null;
        String sort = null;
        String filter = null;
        String xOrgId = null;
        Object response = api.systemusersSystemsBindingList(id, contentType, accept, fields, limit, skip, sort, filter, xOrgId);

        // TODO: test validations
    }
    
    /**
     * Update a system user binding
     *
     * Hidden as Tags is deprecated  Adds or removes a system binding for a user.   This endpoint is only used for users still using JumpCloud Tags. If you are using JumpCloud Groups please refer to the documentation found [here](https://docs.jumpcloud.com/2.0/systems/manage-associations-of-a-system).  ### Example  #### Add (or remove) system to system user  &#x60;&#x60;&#x60; curl \\   -d &#39;{ \&quot;add\&quot;: [\&quot;[SYSTEM_ID_TO_ADD_HERE]\&quot;], \&quot;remove\&quot;: [\&quot;[SYSTEM_ID_TO_REMOVE_HERE]\&quot;] }&#39; \\   -X PUT \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;Accept: application/json&#39; \\   -H \&quot;x-api-key: [YOUR_API_KEY_HERE]\&quot; \\   \&quot;https://console.jumpcloud.com/api/systemusers/[SYSTEM_USER_ID_HERE]/systems\&quot; &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void systemusersSystemsBindingPutTest() throws ApiException {
        String id = null;
        String contentType = null;
        String accept = null;
        Usersystembindingsput body = null;
        String xOrgId = null;
        Usersystembinding response = api.systemusersSystemsBindingPut(id, contentType, accept, body, xOrgId);

        // TODO: test validations
    }
    
    /**
     * Unlock a system user
     *
     * This endpoint allows you to unlock a user&#39;s account.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void systemusersUnlockTest() throws ApiException {
        String id = null;
        String contentType = null;
        String accept = null;
        String xOrgId = null;
        api.systemusersUnlock(id, contentType, accept, xOrgId);

        // TODO: test validations
    }
    
}
