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
 * API tests for GSuiteApi
 */
@Ignore
public class GSuiteApiTest {

    private final GSuiteApi api = new GSuiteApi();

    
    /**
     * List the associations of a G Suite instance
     *
     * This endpoint returns the _direct_ associations of this G Suite instance.  A direct association can be a non-homogenous relationship between 2 different objects. for example G Suite and Users.   #### Sample Request &#x60;&#x60;&#x60; curl -X GET &#39;https://console.jumpcloud.com/api/v2/gsuites/{Gsuite_ID}/associations?targets&#x3D;user_group \\   -H &#39;accept: application/json&#39; \\   -H &#39;content-type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void graphGSuiteAssociationsListTest() throws ApiException {
        String gsuiteId = null;
        List<String> targets = null;
        String contentType = null;
        String accept = null;
        Integer limit = null;
        Integer skip = null;
        String xOrgId = null;
        List<GraphConnection> response = api.graphGSuiteAssociationsList(gsuiteId, targets, contentType, accept, limit, skip, xOrgId);

        // TODO: test validations
    }
    
    /**
     * Manage the associations of a G Suite instance
     *
     * This endpoint returns the _direct_ associations of this G Suite instance.  A direct association can be a non-homogenous relationship between 2 different objects. for example G Suite and Users.   #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/gsuites/{Gsuite_ID}/associations \\   -H &#39;accept: application/json&#39; \\   -H &#39;content-type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;user_group\&quot;,     \&quot;id\&quot;: \&quot;{Group_ID}\&quot; }&#39; &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void graphGSuiteAssociationsPostTest() throws ApiException {
        String gsuiteId = null;
        GraphManagementReq body = null;
        String xOrgId = null;
        api.graphGSuiteAssociationsPost(gsuiteId, body, xOrgId);

        // TODO: test validations
    }
    
    /**
     * List the Users bound to a G Suite instance
     *
     * This endpoint will return all Users bound to a G Suite instance, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this G Suite instance to the corresponding User; this array represents all grouping and/or associations that would have to be removed to deprovision the User from this G Suite instance.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60;   curl -X GET https://console.jumpcloud.com/api/v2/gsuites/{Gsuite_ID}/users \\   -H &#39;accept: application/json&#39; \\   -H &#39;content-type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void graphGSuiteTraverseUserTest() throws ApiException {
        String gsuiteId = null;
        String contentType = null;
        String accept = null;
        Integer limit = null;
        Integer skip = null;
        String xOrgId = null;
        List<GraphObjectWithPaths> response = api.graphGSuiteTraverseUser(gsuiteId, contentType, accept, limit, skip, xOrgId);

        // TODO: test validations
    }
    
    /**
     * List the User Groups bound to a G Suite instance
     *
     * This endpoint will return all User Groups bound to an G Suite instance, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the group&#39;s type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this G Suite instance to the corresponding User Group; this array represents all grouping and/or associations that would have to be removed to deprovision the User Group from this G Suite instance.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60;   curl -X GET https://console.jumpcloud.com/api/v2/gsuites/{GSuite_ID}/usergroups \\   -H &#39;accept: application/json&#39; \\   -H &#39;content-type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void graphGSuiteTraverseUserGroupTest() throws ApiException {
        String gsuiteId = null;
        String contentType = null;
        String accept = null;
        Integer limit = null;
        Integer skip = null;
        String xOrgId = null;
        List<GraphObjectWithPaths> response = api.graphGSuiteTraverseUserGroup(gsuiteId, contentType, accept, limit, skip, xOrgId);

        // TODO: test validations
    }
    
}
