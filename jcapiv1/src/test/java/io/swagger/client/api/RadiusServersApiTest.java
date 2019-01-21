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
import io.swagger.client.model.Body;
import io.swagger.client.model.Radiusserverpost;
import io.swagger.client.model.Radiusserverput;
import io.swagger.client.model.Radiusserverslist;
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
     * List Radius Servers
     *
     * This endpoint allows you to get a list of all RADIUS servers in your organization.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/radiusservers/ \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\ &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void radiusServersListTest() throws ApiException {
        String contentType = null;
        String accept = null;
        String fields = null;
        Integer limit = null;
        Integer skip = null;
        String sort = null;
        String xOrgId = null;
        Radiusserverslist response = api.radiusServersList(contentType, accept, fields, limit, skip, sort, xOrgId);

        // TODO: test validations
    }
    
    /**
     * Create a Radius Server
     *
     * This endpoint allows you to create RADIUS servers in your organization.  #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/radiusservers/ \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{     \&quot;name\&quot;: \&quot;{test_radius}\&quot;,     \&quot;networkSourceIp\&quot;: \&quot;{0.0.0.0}\&quot;,     \&quot;sharedSecret\&quot;:\&quot;{secretpassword}\&quot; }&#39; &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void radiusServersPostTest() throws ApiException {
        String contentType = null;
        String accept = null;
        Radiusserverpost body = null;
        String xOrgId = null;
        Radiusserverslist response = api.radiusServersPost(contentType, accept, body, xOrgId);

        // TODO: test validations
    }
    
    /**
     * Update Radius Servers
     *
     * This endpoint allows you to update RADIUS servers in your organization.  #### &#x60;&#x60;&#x60; curl -X PUT https://console.jumpcloud.com/api/radiusservers/{ServerID} \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{     \&quot;name\&quot;: \&quot;{name_update}\&quot;,     \&quot;networkSourceIp\&quot;: \&quot;{0.0.0.0}\&quot; }&#39; &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void radiusServersPutTest() throws ApiException {
        String contentType = null;
        String accept = null;
        Body body = null;
        String xOrgId = null;
        Radiusserverput response = api.radiusServersPut(contentType, accept, body, xOrgId);

        // TODO: test validations
    }
    
}
