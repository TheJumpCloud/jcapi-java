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
import io.swagger.client.model.Error;
import io.swagger.client.model.GraphConnection;
import io.swagger.client.model.GraphManagementReq;
import io.swagger.client.model.GraphObjectWithPaths;
import io.swagger.client.model.Policy;
import io.swagger.client.model.PolicyRequest;
import io.swagger.client.model.PolicyResult;
import io.swagger.client.model.PolicyTemplate;
import io.swagger.client.model.PolicyTemplateWithDetails;
import io.swagger.client.model.PolicyWithDetails;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for PoliciesApi
 */
@Ignore
public class PoliciesApiTest {

    private final PoliciesApi api = new PoliciesApi();

    
    /**
     * List the associations of a Policy
     *
     * This endpoint returns the _direct_ associations of a Policy.  A direct association can be a non-homogenous relationship between 2 different objects. for example Policies and Systems.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET &#39;https://console.jumpcloud.com/api/v2/policies/{Policy_ID}/associations?targets&#x3D;system_group \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void graphPolicyAssociationsListTest() throws ApiException {
        String policyId = null;
        List<String> targets = null;
        String contentType = null;
        String accept = null;
        Integer limit = null;
        Integer skip = null;
        String xOrgId = null;
        List<GraphConnection> response = api.graphPolicyAssociationsList(policyId, targets, contentType, accept, limit, skip, xOrgId);

        // TODO: test validations
    }
    
    /**
     * Manage the associations of a Policy
     *
     * This endpoint allows you to manage the _direct_ associations of a Policy.  A direct association can be a non-homogenous relationship between 2 different objects. for example Policies and Systems.  #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/policies/{Policy_ID}/associations/ \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;system_group\&quot;,     \&quot;id\&quot;: \&quot;{Group_ID}\&quot; }&#39; &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void graphPolicyAssociationsPostTest() throws ApiException {
        String policyId = null;
        String contentType = null;
        String accept = null;
        GraphManagementReq body = null;
        String xOrgId = null;
        api.graphPolicyAssociationsPost(policyId, contentType, accept, body, xOrgId);

        // TODO: test validations
    }
    
    /**
     * List the Systems bound to a Policy
     *
     * This endpoint will return all Systems bound to a Policy, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.   Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this Policy to the corresponding System; this array represents all grouping and/or associations that would have to be removed to deprovision the System from this Policy.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/policies/{Policy_ID}/systems \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void graphPolicyTraverseSystemTest() throws ApiException {
        String policyId = null;
        String contentType = null;
        String accept = null;
        Integer limit = null;
        Integer skip = null;
        String xOrgId = null;
        List<GraphObjectWithPaths> response = api.graphPolicyTraverseSystem(policyId, contentType, accept, limit, skip, xOrgId);

        // TODO: test validations
    }
    
    /**
     * List the System Groups bound to a Policy
     *
     * This endpoint will return all Systems Groups bound to a Policy, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the group&#39;s type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this Policy to the corresponding System Group; this array represents all grouping and/or associations that would have to be removed to deprovision the System Group from this Policy.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET  https://console.jumpcloud.com/api/v2/policies/{Policy_ID}/systemgroups \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void graphPolicyTraverseSystemGroupTest() throws ApiException {
        String policyId = null;
        String contentType = null;
        String accept = null;
        Integer limit = null;
        Integer skip = null;
        String xOrgId = null;
        List<GraphObjectWithPaths> response = api.graphPolicyTraverseSystemGroup(policyId, contentType, accept, limit, skip, xOrgId);

        // TODO: test validations
    }
    
    /**
     * Deletes a Policy
     *
     * This endpoint allows you to delete a policy.  #### Sample Request  &#x60;&#x60;&#x60; curl -X DELETE https://console.jumpcloud.com/api/v2/policies/5a837ecd232e110d4291e6b9 \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;   &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void policiesDeleteTest() throws ApiException {
        String id = null;
        String contentType = null;
        String accept = null;
        String xOrgId = null;
        api.policiesDelete(id, contentType, accept, xOrgId);

        // TODO: test validations
    }
    
    /**
     * Gets a specific Policy.
     *
     * This endpoint returns a specific policy.  ###### Sample Request  &#x60;&#x60;&#x60;   curl -X GET https://console.jumpcloud.com/api/v2/policies/{PolicyID} \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;   &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void policiesGetTest() throws ApiException {
        String id = null;
        String contentType = null;
        String accept = null;
        String xOrgId = null;
        PolicyWithDetails response = api.policiesGet(id, contentType, accept, xOrgId);

        // TODO: test validations
    }
    
    /**
     * Lists all the Policies
     *
     * This endpoint returns all policies.  ##### Sample Request  &#x60;&#x60;&#x60;  curl -X GET  https://console.jumpcloud.com/api/v2/policies \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;   &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void policiesListTest() throws ApiException {
        String contentType = null;
        String accept = null;
        List<String> fields = null;
        List<String> filter = null;
        Integer limit = null;
        Integer skip = null;
        List<String> sort = null;
        String xOrgId = null;
        List<Policy> response = api.policiesList(contentType, accept, fields, filter, limit, skip, sort, xOrgId);

        // TODO: test validations
    }
    
    /**
     * Create a new Policy
     *
     * This endpoint allows you to create a policy. Given the amount of configurable parameters required to create a Policy, we suggest you use the JumpCloud Admin Console to create new policies.  ##### Sample Request  &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/policies \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{    {Policy_Parameters} }&#39;  &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void policiesPostTest() throws ApiException {
        String contentType = null;
        String accept = null;
        PolicyRequest body = null;
        String xOrgId = null;
        PolicyWithDetails response = api.policiesPost(contentType, accept, body, xOrgId);

        // TODO: test validations
    }
    
    /**
     * Update an existing Policy
     *
     * This endpoint allows you to update a policy. Given the amount of configurable parameters required to update a Policy, we suggest you use the JumpCloud Admin Console to create new policies.   ##### Sample Request &#x60;&#x60;&#x60; curl -X PUT https://console.jumpcloud.com/api/v2/policies/59fced45c9118022172547ff \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY&#39; \\   -d &#39;{     {Policy_Parameters} }&#39; &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void policiesPutTest() throws ApiException {
        String id = null;
        PolicyRequest body = null;
        String xOrgId = null;
        Policy response = api.policiesPut(id, body, xOrgId);

        // TODO: test validations
    }
    
    /**
     * Get a specific Policy Result.
     *
     * This endpoint will return the policy results for a specific policy.  ##### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/policyresults/{Policy_ID} \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;   &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void policyresultsGetTest() throws ApiException {
        String id = null;
        String contentType = null;
        String accept = null;
        String xOrgId = null;
        PolicyResult response = api.policyresultsGet(id, contentType, accept, xOrgId);

        // TODO: test validations
    }
    
    /**
     * Lists all the policy results for an organization.
     *
     * This endpoint returns all policies results for an Organization.   ##### Sample Request  &#x60;&#x60;&#x60;  curl -X GET https://console.jumpcloud.com/api/v2/policyresults \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;   &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void policyresultsListTest() throws ApiException {
        String contentType = null;
        String accept = null;
        List<String> aggregate = null;
        List<String> fields = null;
        List<String> filter = null;
        Integer limit = null;
        Integer skip = null;
        List<String> sort = null;
        String xOrgId = null;
        List<PolicyResult> response = api.policyresultsList(contentType, accept, aggregate, fields, filter, limit, skip, sort, xOrgId);

        // TODO: test validations
    }
    
    /**
     * Lists all the policy results of a policy.
     *
     * This endpoint returns all policies results for a specific policy.   ##### Sample Request  &#x60;&#x60;&#x60;  curl -X GET https://console.jumpcloud.com/api/v2/policies/{Policy_ID}/policyresults \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;   &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void policyresultsList_0Test() throws ApiException {
        String policyId = null;
        String contentType = null;
        String accept = null;
        List<String> fields = null;
        List<String> filter = null;
        Integer limit = null;
        Integer skip = null;
        List<String> sort = null;
        List<String> aggregate = null;
        String xOrgId = null;
        List<PolicyResult> response = api.policyresultsList_0(policyId, contentType, accept, fields, filter, limit, skip, sort, aggregate, xOrgId);

        // TODO: test validations
    }
    
    /**
     * Lists the latest policy results of a policy.
     *
     * This endpoint returns the latest policies results for a specific policy.   ##### Sample Request  &#x60;&#x60;&#x60;  curl -X GET https://console.jumpcloud.com/api/v2/policies/{Policy_ID}/policystatuses \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;   &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void policystatusesListTest() throws ApiException {
        String policyId = null;
        String contentType = null;
        String accept = null;
        List<String> fields = null;
        List<String> filter = null;
        Integer limit = null;
        Integer skip = null;
        List<String> sort = null;
        String xOrgId = null;
        List<PolicyResult> response = api.policystatusesList(policyId, contentType, accept, fields, filter, limit, skip, sort, xOrgId);

        // TODO: test validations
    }
    
    /**
     * List the policy statuses for a system
     *
     * This endpoint returns the policy results for a particular system.  ##### Sample Request  &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systems/{System_ID}/policystatuses \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;  &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void policystatusesList_0Test() throws ApiException {
        String systemId = null;
        String contentType = null;
        String accept = null;
        List<String> fields = null;
        List<String> filter = null;
        Integer limit = null;
        Integer skip = null;
        List<String> sort = null;
        String xOrgId = null;
        List<PolicyResult> response = api.policystatusesList_0(systemId, contentType, accept, fields, filter, limit, skip, sort, xOrgId);

        // TODO: test validations
    }
    
    /**
     * Get a specific Policy Template
     *
     * This endpoint returns a specific policy template.  #### Sample Request &#x60;&#x60;&#x60;  curl -X GET https://console.jumpcloud.com/api/v2/policies/{Policy_ID}\\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void policytemplatesGetTest() throws ApiException {
        String id = null;
        String contentType = null;
        String accept = null;
        String xOrgId = null;
        PolicyTemplateWithDetails response = api.policytemplatesGet(id, contentType, accept, xOrgId);

        // TODO: test validations
    }
    
    /**
     * Lists all of the Policy Templates
     *
     * This endpoint returns all policy templates.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/policytemplates \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;   &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void policytemplatesListTest() throws ApiException {
        String contentType = null;
        String accept = null;
        List<String> fields = null;
        List<String> filter = null;
        Integer limit = null;
        Integer skip = null;
        List<String> sort = null;
        String xOrgId = null;
        List<PolicyTemplate> response = api.policytemplatesList(contentType, accept, fields, filter, limit, skip, sort, xOrgId);

        // TODO: test validations
    }
    
}
