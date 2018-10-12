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
import io.swagger.client.model.Command;
import io.swagger.client.model.Commandfilereturn;
import io.swagger.client.model.Commandslist;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for CommandsApi
 */
@Ignore
public class CommandsApiTest {

    private final CommandsApi api = new CommandsApi();

    
    /**
     * Get a Command File
     *
     * This endpoint returns the uploaded file(s) associated with a specific command.  #### Sample Request  &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/files/command/{commandID} \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;    &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void commandFileGetTest() throws ApiException {
        String id = null;
        String contentType = null;
        String accept = null;
        String fields = null;
        Integer limit = null;
        Integer skip = null;
        String xOrgId = null;
        Commandfilereturn response = api.commandFileGet(id, contentType, accept, fields, limit, skip, xOrgId);

        // TODO: test validations
    }
    
    /**
     * Delete a Command
     *
     * This endpoint deletes a specific command based on the Command ID.  #### Sample Request &#x60;&#x60;&#x60; curl -X DELETE https://console.jumpcloud.com/api/commands/{CommandID} \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;  &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void commandsDeleteTest() throws ApiException {
        String id = null;
        String contentType = null;
        String accept = null;
        String xOrgId = null;
        api.commandsDelete(id, contentType, accept, xOrgId);

        // TODO: test validations
    }
    
    /**
     * List an individual Command
     *
     * This endpoint returns a specific command based on the command ID.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/commands/{CommandID} \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;  &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void commandsGetTest() throws ApiException {
        String id = null;
        String contentType = null;
        String accept = null;
        String fields = null;
        String xOrgId = null;
        Command response = api.commandsGet(id, contentType, accept, fields, xOrgId);

        // TODO: test validations
    }
    
    /**
     * List All Commands
     *
     * This endpoint returns all commands.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/commands/ \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;  &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void commandsListTest() throws ApiException {
        String contentType = null;
        String accept = null;
        Integer skip = null;
        String fields = null;
        Integer limit = null;
        String sort = null;
        String xOrgId = null;
        Commandslist response = api.commandsList(contentType, accept, skip, fields, limit, sort, xOrgId);

        // TODO: test validations
    }
    
    /**
     * Create A Command
     *
     * This endpoint allows you to create a new command.  #### Sample Request  &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/commands/ \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{  \&quot;name\&quot;:\&quot;Test API Command\&quot;,  \&quot;command\&quot;:\&quot;String\&quot;,  \&quot;user\&quot;:\&quot;{UserID}\&quot;,  \&quot;schedule\&quot;:\&quot;\&quot;,  \&quot;timeout\&quot;:\&quot;100\&quot; }&#39;  &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void commandsPostTest() throws ApiException {
        String contentType = null;
        String accept = null;
        Command body = null;
        String xOrgId = null;
        Command response = api.commandsPost(contentType, accept, body, xOrgId);

        // TODO: test validations
    }
    
    /**
     * Update a Command
     *
     * This endpoint Updates a command based on the command ID and returns the modified command record.  #### Sample Request &#x60;&#x60;&#x60; curl -X PUT https://console.jumpcloud.com/api/commands/{CommandID} \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{  \&quot;name\&quot;:\&quot;Test API Command\&quot;,  \&quot;command\&quot;:\&quot;String\&quot;,  \&quot;user\&quot;:\&quot;{UserID}\&quot;,  \&quot;schedule\&quot;:\&quot;\&quot;,  \&quot;timeout\&quot;:\&quot;100\&quot; }&#39;  &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void commandsPutTest() throws ApiException {
        String id = null;
        String contentType = null;
        String accept = null;
        Command body = null;
        String xOrgId = null;
        Command response = api.commandsPut(id, contentType, accept, body, xOrgId);

        // TODO: test validations
    }
    
}
