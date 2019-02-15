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
import io.swagger.client.model.InlineResponse401;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ProvidersApi
 */
@Ignore
public class ProvidersApiTest {

    private final ProvidersApi api = new ProvidersApi();

    
    /**
     * providersadministrators
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void providersListAdministratorsTest() throws ApiException {
        String providerId = null;
        String contentType = null;
        String accept = null;
        List<String> fields = null;
        List<String> filter = null;
        Integer limit = null;
        Integer skip = null;
        List<String> sort = null;
        InlineResponse200 response = api.providersListAdministrators(providerId, contentType, accept, fields, filter, limit, skip, sort);

        // TODO: test validations
    }
    
}
