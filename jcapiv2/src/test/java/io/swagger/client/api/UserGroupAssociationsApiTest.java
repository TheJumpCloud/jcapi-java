/*
 * JumpCloud APIs
 * V1 & V2 versions of JumpCloud's API. The next version of JumpCloud's API. This set of endpoints allows JumpCloud customers to manage objects, groupings and mappings. The most recent version of JumpCloud's API. This set of endpoints allows JumpCloud customers to manage objects, groupings and mappings.
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
import io.swagger.client.model.UserGroupGraphManagementReq;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for UserGroupAssociationsApi
 */
@Ignore
public class UserGroupAssociationsApiTest {

    private final UserGroupAssociationsApi api = new UserGroupAssociationsApi();

    
    /**
     * List the associations of a User Group.
     *
     * This endpoint returns the _direct_ associations of this User Group.  A direct association can be a non-homogenous relationship between 2 different objects. for example User Groups and Users.   #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/associations?targets&#x3D;system \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void graphUserGroupAssociationsListTest() throws ApiException {
        String groupId = null;
        String contentType = null;
        String accept = null;
        List<String> targets = null;
        Integer limit = null;
        Integer skip = null;
        List<GraphConnection> response = api.graphUserGroupAssociationsList(groupId, contentType, accept, targets, limit, skip);

        // TODO: test validations
    }
    
    /**
     * Manage the associations of a User Group
     *
     * This endpoint manages the _direct_ associations of this User Group.  A direct association can be a non-homogenous relationship between 2 different objects. for example User Groups and Users.   #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/associations \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;system\&quot;,     \&quot;id\&quot;: \&quot;{SystemID}\&quot; }&#39;  &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void graphUserGroupAssociationsPostTest() throws ApiException {
        String groupId = null;
        String contentType = null;
        String accept = null;
        UserGroupGraphManagementReq body = null;
        api.graphUserGroupAssociationsPost(groupId, contentType, accept, body);

        // TODO: test validations
    }
    
    /**
     * List the Active Directories bound to a User Group
     *
     * This endpoint will return all Active Directory Instances bound to a User Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.   The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User Group to the corresponding Active Directory; this array represents all grouping and/or associations that would have to be removed to deprovision the Active Directory from this User Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/activedirectories \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void graphUserGroupTraverseActiveDirectoryTest() throws ApiException {
        String groupId = null;
        String contentType = null;
        String accept = null;
        Integer limit = null;
        Integer skip = null;
        List<GraphObjectWithPaths> response = api.graphUserGroupTraverseActiveDirectory(groupId, contentType, accept, limit, skip);

        // TODO: test validations
    }
    
    /**
     * List the Applications bound to a User Group
     *
     * This endpoint will return all Applications bound to a User Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User Group to the corresponding Application; this array represents all grouping and/or associations that would have to be removed to deprovision the Application from this User Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/applications \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void graphUserGroupTraverseApplicationTest() throws ApiException {
        String groupId = null;
        String contentType = null;
        String accept = null;
        Integer limit = null;
        Integer skip = null;
        List<GraphObjectWithPaths> response = api.graphUserGroupTraverseApplication(groupId, contentType, accept, limit, skip);

        // TODO: test validations
    }
    
    /**
     * List the Directories bound to a User Group
     *
     * This endpoint will return all Directories bound to a User Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User Group to the corresponding Directory; this array represents all grouping and/or associations that would have to be removed to deprovision the Directories from this User Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/directories \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;  &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void graphUserGroupTraverseDirectoryTest() throws ApiException {
        String groupId = null;
        String contentType = null;
        String accept = null;
        Integer limit = null;
        Integer skip = null;
        List<GraphObjectWithPaths> response = api.graphUserGroupTraverseDirectory(groupId, contentType, accept, limit, skip);

        // TODO: test validations
    }
    
    /**
     * List the G Suite instances bound to a User Group
     *
     * This endpoint will return all Gsuite Instances bound to a User Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User Group to the corresponding G Suite instance; this array represents all grouping and/or associations that would have to be removed to deprovision the G Suite instance from this User Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID/gsuites \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;  &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void graphUserGroupTraverseGSuiteTest() throws ApiException {
        String groupId = null;
        String contentType = null;
        String accept = null;
        Integer limit = null;
        Integer skip = null;
        List<GraphObjectWithPaths> response = api.graphUserGroupTraverseGSuite(groupId, contentType, accept, limit, skip);

        // TODO: test validations
    }
    
    /**
     * List the LDAP Servers bound to a User Group
     *
     * This endpoint will return all LDAP Servers bound to a User Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User Group to the corresponding LDAP Server; this array represents all grouping and/or associations that would have to be removed to deprovision the LDAP Server from this User Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/ldapservers \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void graphUserGroupTraverseLdapServerTest() throws ApiException {
        String groupId = null;
        String contentType = null;
        String accept = null;
        Integer limit = null;
        Integer skip = null;
        List<GraphObjectWithPaths> response = api.graphUserGroupTraverseLdapServer(groupId, contentType, accept, limit, skip);

        // TODO: test validations
    }
    
    /**
     * List the Office 365 instances bound to a User Group
     *
     * This endpoint will return all Office 365 instances bound to a User Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User Group to the corresponding Office 365 instance; this array represents all grouping and/or associations that would have to be removed to deprovision the Office 365 instance from this User Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/office365s \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void graphUserGroupTraverseOffice365Test() throws ApiException {
        String groupId = null;
        String contentType = null;
        String accept = null;
        Integer limit = null;
        Integer skip = null;
        List<GraphObjectWithPaths> response = api.graphUserGroupTraverseOffice365(groupId, contentType, accept, limit, skip);

        // TODO: test validations
    }
    
    /**
     * List the RADIUS Servers bound to a User Group
     *
     * This endpoint will return all RADIUS servers bound to a User Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.    Each element will contain the type, id, attributes and paths  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User Group to the corresponding RADIUS Server; this array represents all grouping and/or associations that would have to be removed to deprovision the RADIUS Server from this User Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/radiusservers \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;  &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void graphUserGroupTraverseRadiusServerTest() throws ApiException {
        String groupId = null;
        String contentType = null;
        String accept = null;
        Integer limit = null;
        Integer skip = null;
        List<GraphObjectWithPaths> response = api.graphUserGroupTraverseRadiusServer(groupId, contentType, accept, limit, skip);

        // TODO: test validations
    }
    
    /**
     * List the Systems bound to a User Group
     *
     * This endpoint will return all Systems bound to a User Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.    Each element will contain the type, id, attributes and paths  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User Group to the corresponding System; this array represents all grouping and/or associations that would have to be removed to deprovision the System from this User Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/systems \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void graphUserGroupTraverseSystemTest() throws ApiException {
        String groupId = null;
        String contentType = null;
        String accept = null;
        Integer limit = null;
        Integer skip = null;
        List<GraphObjectWithPaths> response = api.graphUserGroupTraverseSystem(groupId, contentType, accept, limit, skip);

        // TODO: test validations
    }
    
    /**
     * List the System Groups bound to User Groups
     *
     * This endpoint will return all System Groups bound to a User Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.    Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User Group to the corresponding System Group; this array represents all grouping and/or associations that would have to be removed to deprovision the System Group from this User Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/systemgroups \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void graphUserGroupTraverseSystemGroupTest() throws ApiException {
        String groupId = null;
        String contentType = null;
        String accept = null;
        Integer limit = null;
        Integer skip = null;
        List<GraphObjectWithPaths> response = api.graphUserGroupTraverseSystemGroup(groupId, contentType, accept, limit, skip);

        // TODO: test validations
    }
    
}