/*
 * JumpCloud APIs
 *  JumpCloud's V2 API. This set of endpoints allows JumpCloud customers to manage objects, groupings and mappings and interact with the JumpCloud Graph.
 *
 * OpenAPI spec version: 2.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.model.Errorresponse;
import io.swagger.client.model.GraphConnection;
import io.swagger.client.model.GraphObjectWithPaths;
import io.swagger.client.model.SystemGraphManagementReq;
import io.swagger.client.model.Systemfdekey;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for SystemsApi
 */
@Ignore
public class SystemsApiTest {

    private final SystemsApi api = new SystemsApi();

    
    /**
     * List the associations of a System
     *
     * This endpoint returns the _direct_ associations of a System.  A direct association can be a non-homogeneous relationship between 2 different objects, for example Systems and Users.   #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systems/{System_ID}/associations?targets&#x3D;user \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;  &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void graphSystemAssociationsListTest() throws ApiException {
        String systemId = null;
        String contentType = null;
        String accept = null;
        List<String> targets = null;
        Integer limit = null;
        Integer skip = null;
        String date = null;
        String authorization = null;
        String xOrgId = null;
        List<GraphConnection> response = api.graphSystemAssociationsList(systemId, contentType, accept, targets, limit, skip, date, authorization, xOrgId);

        // TODO: test validations
    }
    
    /**
     * Manage associations of a System
     *
     * This endpoint allows you to manage the _direct_ associations of a System.  A direct association can be a non-homogeneous relationship between 2 different objects, for example Systems and Users.   #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/systems/{System_ID}/associations \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{    \&quot;attributes\&quot;: {       \&quot;sudo\&quot;: {          \&quot;enabled\&quot;: true,          \&quot;withoutPassword\&quot;: false       }    },     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;user\&quot;,     \&quot;id\&quot;: \&quot;UserID\&quot; }&#39;  &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void graphSystemAssociationsPostTest() throws ApiException {
        String systemId = null;
        String contentType = null;
        String accept = null;
        SystemGraphManagementReq body = null;
        String date = null;
        String authorization = null;
        String xOrgId = null;
        api.graphSystemAssociationsPost(systemId, contentType, accept, body, date, authorization, xOrgId);

        // TODO: test validations
    }
    
    /**
     * List the parent Groups of a System
     *
     * This endpoint returns all the System Groups a System is a member of.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systems/{System_ID}/memberof \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;  &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void graphSystemMemberOfTest() throws ApiException {
        String systemId = null;
        String contentType = null;
        String accept = null;
        List<String> filter = null;
        Integer limit = null;
        Integer skip = null;
        String date = null;
        String authorization = null;
        List<String> sort = null;
        String xOrgId = null;
        List<GraphObjectWithPaths> response = api.graphSystemMemberOf(systemId, contentType, accept, filter, limit, skip, date, authorization, sort, xOrgId);

        // TODO: test validations
    }
    
    /**
     * List the Commands bound to a System
     *
     * This endpoint will return all Commands bound to a System, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this System to the corresponding Command; this array represents all grouping and/or associations that would have to be removed to deprovision the Command from this System.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systems/{System_ID}/commands \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;  &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void graphSystemTraverseCommandTest() throws ApiException {
        String systemId = null;
        String contentType = null;
        String accept = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphSystemTraverseCommand(systemId, contentType, accept, limit, xOrgId, skip, filter);

        // TODO: test validations
    }
    
    /**
     * List the Policies bound to a System
     *
     * This endpoint will return all Policies bound to a System, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this System to the corresponding Policy; this array represents all grouping and/or associations that would have to be removed to deprovision the Policy from this System.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  This endpoint is not yet public as we have finish the code.  ##### Sample Request  &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/{System_ID}/policies \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;  &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void graphSystemTraversePolicyTest() throws ApiException {
        String systemId = null;
        String contentType = null;
        String accept = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphSystemTraversePolicy(systemId, contentType, accept, limit, xOrgId, skip, filter);

        // TODO: test validations
    }
    
    /**
     * List the Users bound to a System
     *
     * This endpoint will return all Users bound to a System, either directly or indirectly essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this System to the corresponding User; this array represents all grouping and/or associations that would have to be removed to deprovision the User from this System.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systems/{System_ID}/users \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;  &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void graphSystemTraverseUserTest() throws ApiException {
        String systemId = null;
        String contentType = null;
        String accept = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        String date = null;
        String authorization = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphSystemTraverseUser(systemId, contentType, accept, limit, xOrgId, skip, date, authorization, filter);

        // TODO: test validations
    }
    
    /**
     * List the User Groups bound to a System
     *
     * This endpoint will return all User Groups bound to a System, either directly or indirectly essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this System to the corresponding User Group; this array represents all grouping and/or associations that would have to be removed to deprovision the User Group from this System.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systems/{System_ID}/usergroups \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;  &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void graphSystemTraverseUserGroupTest() throws ApiException {
        String systemId = null;
        String contentType = null;
        String accept = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        String date = null;
        String authorization = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphSystemTraverseUserGroup(systemId, contentType, accept, limit, xOrgId, skip, date, authorization, filter);

        // TODO: test validations
    }
    
    /**
     * Get System FDE Key
     *
     * This endpoint will return the current (latest) fde key saved for a system.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void systemsGetFDEKeyTest() throws ApiException {
        String systemId = null;
        String xOrgId = null;
        Systemfdekey response = api.systemsGetFDEKey(systemId, xOrgId);

        // TODO: test validations
    }
    
}
