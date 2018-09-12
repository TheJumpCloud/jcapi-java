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
import io.swagger.client.model.GraphObjectWithPaths;
import io.swagger.client.model.UserGroupMembersReq;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for UserGroupMembersMembershipApi
 */
@Ignore
public class UserGroupMembersMembershipApiTest {

    private final UserGroupMembersMembershipApi api = new UserGroupMembersMembershipApi();

    
    /**
     * List the User Group&#39;s parents
     *
     * This endpoint returns all User Groups a User Group is a member of.  #### Sample Request &#x60;&#x60;&#x60; https://console.jumpcloud.com/api/v2/usergroups/{group_id}/membersof &#x60;&#x60;&#x60;  Not public yet, as the code is not finished,
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void graphUserGroupMemberOfTest() throws ApiException {
        String groupId = null;
        String contentType = null;
        String accept = null;
        List<String> filter = null;
        Integer limit = null;
        Integer skip = null;
        List<String> sort = null;
        String xOrgId = null;
        List<GraphObjectWithPaths> response = api.graphUserGroupMemberOf(groupId, contentType, accept, filter, limit, skip, sort, xOrgId);

        // TODO: test validations
    }
    
    /**
     * List the members of a User Group
     *
     * This endpoint returns the user members of a User Group.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/members \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void graphUserGroupMembersListTest() throws ApiException {
        String groupId = null;
        String contentType = null;
        String accept = null;
        Integer limit = null;
        Integer skip = null;
        String xOrgId = null;
        List<GraphConnection> response = api.graphUserGroupMembersList(groupId, contentType, accept, limit, skip, xOrgId);

        // TODO: test validations
    }
    
    /**
     * Manage the members of a User Group
     *
     * This endpoint allows you to manage the user members of a User Group.  #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/members \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;user\&quot;,     \&quot;id\&quot;: \&quot;{User_ID}\&quot; }&#39; &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void graphUserGroupMembersPostTest() throws ApiException {
        String groupId = null;
        String contentType = null;
        String accept = null;
        UserGroupMembersReq body = null;
        String xOrgId = null;
        api.graphUserGroupMembersPost(groupId, contentType, accept, body, xOrgId);

        // TODO: test validations
    }
    
    /**
     * List the User Group&#39;s membership
     *
     * This endpoint returns all users members that are a member of this User Group.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/membership \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void graphUserGroupMembershipTest() throws ApiException {
        String groupId = null;
        String contentType = null;
        String accept = null;
        List<String> filter = null;
        Integer limit = null;
        Integer skip = null;
        List<String> sort = null;
        String xOrgId = null;
        List<GraphObjectWithPaths> response = api.graphUserGroupMembership(groupId, contentType, accept, filter, limit, skip, sort, xOrgId);

        // TODO: test validations
    }
    
}
