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
import io.swagger.client.model.Commandresult;
import io.swagger.client.model.Commandresultslist;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for CommandResultsApi
 */
@Ignore
public class CommandResultsApiTest {

    private final CommandResultsApi api = new CommandResultsApi();

    
    /**
     * Delete a Command result
     *
     * This endpoint deletes a specific command result.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/commandresults/{CommandID} \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;   &#x60;&#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void commandResultsDeleteTest() throws ApiException {
        String id = null;
        String contentType = null;
        String accept = null;
        String xOrgId = null;
        Commandresult response = api.commandResultsDelete(id, contentType, accept, xOrgId);

        // TODO: test validations
    }
    
    /**
     * List an individual Command result
     *
     * This endpoint returns a specific command result.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/commandresults/{CommandID} \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;   &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void commandResultsGetTest() throws ApiException {
        String id = null;
        String contentType = null;
        String accept = null;
        String fields = null;
        String xOrgId = null;
        Commandresult response = api.commandResultsGet(id, contentType, accept, fields, xOrgId);

        // TODO: test validations
    }
    
    /**
     * List all Command Results
     *
     * This endpoint returns all command results.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/commandresults \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key:{API_KEY}&#39;   &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void commandResultsListTest() throws ApiException {
        String contentType = null;
        String accept = null;
        String fields = null;
        Integer limit = null;
        Integer skip = null;
        String sort = null;
        String xOrgId = null;
        Commandresultslist response = api.commandResultsList(contentType, accept, fields, limit, skip, sort, xOrgId);

        // TODO: test validations
    }
    
}
