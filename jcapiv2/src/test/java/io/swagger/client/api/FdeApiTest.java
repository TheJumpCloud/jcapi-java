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
import io.swagger.client.model.InlineResponse200;
import io.swagger.client.model.InlineResponse400;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for FdeApi
 */
@Ignore
public class FdeApiTest {

    private final FdeApi api = new FdeApi();

    
    /**
     * Get System FDE Key
     *
     * This endpoint will return the current (latest) fde key saved for a system.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void systemsGetFDEKeyTest() throws ApiException {
        String systemId = null;
        InlineResponse200 response = api.systemsGetFDEKey(systemId);

        // TODO: test validations
    }
    
}