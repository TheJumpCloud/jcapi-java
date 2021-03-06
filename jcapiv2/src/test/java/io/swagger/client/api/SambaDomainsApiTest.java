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
import io.swagger.client.model.SambaDomainInput;
import io.swagger.client.model.SambaDomainOutput;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for SambaDomainsApi
 */
@Ignore
public class SambaDomainsApiTest {

    private final SambaDomainsApi api = new SambaDomainsApi();

    
    /**
     * Delete Samba Domain
     *
     * This endpoint allows you to delete a samba domain from an LDAP server.  ##### Sample Request &#x60;&#x60;&#x60; curl -X DELETE https://console.jumpcloud.com/api/v2/ldapservers/{LDAP_ID}/sambadomains/{SAMBA_ID} \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void ldapserversSambaDomainsDeleteTest() throws ApiException {
        String ldapserverId = null;
        String id = null;
        String contentType = null;
        String accept = null;
        String xOrgId = null;
        String response = api.ldapserversSambaDomainsDelete(ldapserverId, id, contentType, accept, xOrgId);

        // TODO: test validations
    }
    
    /**
     * Get Samba Domain
     *
     * This endpoint returns a specific samba domain for an LDAP server.  ##### Sample Request &#x60;&#x60;&#x60; curl -X GET \\   https://console.jumpcloud.com/api/v2/ldapservers/ldapservers/{LDAP_ID}/sambadomains/{SAMBA_ID} \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;   &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void ldapserversSambaDomainsGetTest() throws ApiException {
        String ldapserverId = null;
        String id = null;
        String contentType = null;
        String accept = null;
        String xOrgId = null;
        SambaDomainOutput response = api.ldapserversSambaDomainsGet(ldapserverId, id, contentType, accept, xOrgId);

        // TODO: test validations
    }
    
    /**
     * List Samba Domains
     *
     * This endpoint returns all samba domains for an LDAP server.  ##### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/ldapservers/{LDAP_ID}/sambadomains \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;   &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void ldapserversSambaDomainsListTest() throws ApiException {
        String ldapserverId = null;
        String contentType = null;
        String accept = null;
        List<String> fields = null;
        List<String> filter = null;
        Integer limit = null;
        Integer skip = null;
        List<String> sort = null;
        String xOrgId = null;
        List<SambaDomainOutput> response = api.ldapserversSambaDomainsList(ldapserverId, contentType, accept, fields, filter, limit, skip, sort, xOrgId);

        // TODO: test validations
    }
    
    /**
     * Create Samba Domain
     *
     * This endpoint allows you to create a samba domain for an LDAP server.  ##### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/ldapservers/{LDAP_ID}/sambadomains \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{ \&quot;sid\&quot;:\&quot;{SID_ID}\&quot;, \&quot;name\&quot;:\&quot;{WORKGROUP_NAME}\&quot; }&#39; &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void ldapserversSambaDomainsPostTest() throws ApiException {
        String ldapserverId = null;
        SambaDomainInput body = null;
        String contentType = null;
        String accept = null;
        String xOrgId = null;
        SambaDomainOutput response = api.ldapserversSambaDomainsPost(ldapserverId, body, contentType, accept, xOrgId);

        // TODO: test validations
    }
    
    /**
     * Update Samba Domain
     *
     * This endpoint allows you to update the samba domain information for an LDAP server.  ##### Sample Request &#x60;&#x60;&#x60; curl -X PUT https://console.jumpcloud.com/api/v2/ldapservers/{LDAP_ID}/sambadomains/{SAMBA_ID} \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{ \&quot;sid\&quot;:\&quot;{SID_ID}\&quot;, \&quot;name\&quot;:\&quot;{WORKGROUP_NAME}\&quot; }&#39;  &#x60;&#x60;&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void ldapserversSambaDomainsPutTest() throws ApiException {
        String ldapserverId = null;
        String id = null;
        SambaDomainInput body = null;
        String contentType = null;
        String accept = null;
        String xOrgId = null;
        SambaDomainOutput response = api.ldapserversSambaDomainsPut(ldapserverId, id, body, contentType, accept, xOrgId);

        // TODO: test validations
    }
    
}
