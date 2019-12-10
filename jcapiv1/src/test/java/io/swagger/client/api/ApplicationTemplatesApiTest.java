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
import io.swagger.client.model.Applicationtemplate;
import io.swagger.client.model.Applicationtemplateslist;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ApplicationTemplatesApi
 */
@Ignore
public class ApplicationTemplatesApiTest {

    private final ApplicationTemplatesApi api = new ApplicationTemplatesApi();

    
    /**
     * Get an Application Template
     *
     * The endpoint returns a specific SSO / SAML Application Template.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/application-templates/{id} \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;   &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void applicationTemplatesGetTest() throws ApiException {
        String id = null;
        String contentType = null;
        String accept = null;
        String fields = null;
        Integer limit = null;
        Integer skip = null;
        String sort = null;
        String filter = null;
        String xOrgId = null;
        Applicationtemplate response = api.applicationTemplatesGet(id, contentType, accept, fields, limit, skip, sort, filter, xOrgId);

        // TODO: test validations
    }
    
    /**
     * List Application Templates
     *
     * The endpoint returns all the SSO / SAML Application Templates.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/application-templates \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;   &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void applicationTemplatesListTest() throws ApiException {
        String contentType = null;
        String accept = null;
        String fields = null;
        Integer limit = null;
        Integer skip = null;
        String sort = null;
        String filter = null;
        String xOrgId = null;
        Applicationtemplateslist response = api.applicationTemplatesList(contentType, accept, fields, limit, skip, sort, filter, xOrgId);

        // TODO: test validations
    }
    
}
