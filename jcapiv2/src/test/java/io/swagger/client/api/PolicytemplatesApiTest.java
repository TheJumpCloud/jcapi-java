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
import io.swagger.client.model.Error;
import io.swagger.client.model.PolicyTemplate;
import io.swagger.client.model.PolicyTemplateWithDetails;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for PolicytemplatesApi
 */
@Ignore
public class PolicytemplatesApiTest {

    private final PolicytemplatesApi api = new PolicytemplatesApi();

    
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
        PolicyTemplateWithDetails response = api.policytemplatesGet(id, contentType, accept);

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
        List<PolicyTemplate> response = api.policytemplatesList(contentType, accept, fields, filter, limit, skip, sort);

        // TODO: test validations
    }
    
}