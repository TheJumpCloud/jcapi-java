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
import io.swagger.client.model.GraphConnection;
import io.swagger.client.model.GraphManagementReq;
import io.swagger.client.model.GraphObjectWithPaths;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for RadiusServersApi
 */
@Ignore
public class RadiusServersApiTest {

    private final RadiusServersApi api = new RadiusServersApi();

    
    /**
     * List the associations of a RADIUS  Server
     *
     * This endpoint returns the _direct_ associations of a Radius Server.  A direct association can be a non-homogeneous relationship between 2 different objects, for example Radius Servers and Users.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/radiusservers/{RADIUS_ID}/associations?targets&#x3D;user_group \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void graphRadiusServerAssociationsListTest() throws ApiException {
        String radiusserverId = null;
        List<String> targets = null;
        String contentType = null;
        String accept = null;
        Integer limit = null;
        Integer skip = null;
        String xOrgId = null;
        List<GraphConnection> response = api.graphRadiusServerAssociationsList(radiusserverId, targets, contentType, accept, limit, skip, xOrgId);

        // TODO: test validations
    }
    
    /**
     * Manage the associations of a RADIUS Server
     *
     * This endpoint allows you to manage the _direct_ associations of a Radius Server.  A direct association can be a non-homogeneous relationship between 2 different objects, for example Radius Servers and Users.  #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/radiusservers/{RADIUS_ID}/associations \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{   \&quot;type\&quot;:\&quot;user\&quot;,  \&quot;id\&quot;:\&quot;{USER_ID}\&quot;,  \&quot;op\&quot;:\&quot;add\&quot;   }&#39; &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void graphRadiusServerAssociationsPostTest() throws ApiException {
        String radiusserverId = null;
        String contentType = null;
        String accept = null;
        GraphManagementReq body = null;
        String xOrgId = null;
        api.graphRadiusServerAssociationsPost(radiusserverId, contentType, accept, body, xOrgId);

        // TODO: test validations
    }
    
    /**
     * List the Users bound to a RADIUS  Server
     *
     * This endpoint will return all Users bound to a RADIUS Server, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this RADIUS server instance to the corresponding User; this array represents all grouping and/or associations that would have to be removed to deprovision the User from this RADIUS server instance.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.   #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/ldapservers/{LDAP_ID}/users \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;   &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void graphRadiusServerTraverseUserTest() throws ApiException {
        String radiusserverId = null;
        String contentType = null;
        String accept = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphRadiusServerTraverseUser(radiusserverId, contentType, accept, limit, xOrgId, skip, filter);

        // TODO: test validations
    }
    
    /**
     * List the User Groups bound to a RADIUS  Server
     *
     * This endpoint will return all Users Groups bound to a RADIUS Server, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the group&#39;s type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this RADIUS server instance to the corresponding User Group; this array represents all grouping and/or associations that would have to be removed to deprovision the User Group from this RADIUS server instance.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/radiusservers/{RADIUS_ID}/usergroups \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void graphRadiusServerTraverseUserGroupTest() throws ApiException {
        String radiusserverId = null;
        String contentType = null;
        String accept = null;
        Integer limit = null;
        String xOrgId = null;
        Integer skip = null;
        List<String> filter = null;
        List<GraphObjectWithPaths> response = api.graphRadiusServerTraverseUserGroup(radiusserverId, contentType, accept, limit, xOrgId, skip, filter);

        // TODO: test validations
    }
    
}
