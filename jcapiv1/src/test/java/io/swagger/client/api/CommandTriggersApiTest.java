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
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for CommandTriggersApi
 */
@Ignore
public class CommandTriggersApiTest {

    private final CommandTriggersApi api = new CommandTriggersApi();

    
    /**
     * Launch a command via a Trigger
     *
     * This endpoint allows you to launch a command based on a defined trigger.  #### Sample Requests  **Launch a Command via a Trigger**  &#x60;&#x60;&#x60; curl --silent \\      -X &#39;POST&#39; \\      -H \&quot;x-api-key: {API_KEY}\&quot; \\      \&quot;https://console.jumpcloud.com/api/command/trigger/{TriggerName}\&quot; &#x60;&#x60;&#x60; **Launch a Command via a Trigger passing a JSON object to the command** &#x60;&#x60;&#x60; curl --silent \\      -X &#39;POST&#39; \\      -H \&quot;x-api-key: {API_KEY}\&quot; \\      -H &#39;Accept: application/json&#39; \\      -H &#39;Content-Type: application/json&#39; \\      -d &#39;{ \&quot;srcip\&quot;:\&quot;192.168.2.32\&quot;, \&quot;attack\&quot;:\&quot;Cross Site Scripting Attempt\&quot; }&#39; \\      \&quot;https://console.jumpcloud.com/api/command/trigger/{TriggerName}\&quot; &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void commandTriggerWebhookPostTest() throws ApiException {
        String triggername = null;
        String contentType = null;
        String accept = null;
        String xOrgId = null;
        api.commandTriggerWebhookPost(triggername, contentType, accept, xOrgId);

        // TODO: test validations
    }
    
}
