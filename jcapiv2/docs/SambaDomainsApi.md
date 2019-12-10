# SambaDomainsApi

All URIs are relative to *https://console.jumpcloud.com/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**ldapserversSambaDomainsDelete**](SambaDomainsApi.md#ldapserversSambaDomainsDelete) | **DELETE** /ldapservers/{ldapserver_id}/sambadomains/{id} | Delete Samba Domain
[**ldapserversSambaDomainsGet**](SambaDomainsApi.md#ldapserversSambaDomainsGet) | **GET** /ldapservers/{ldapserver_id}/sambadomains/{id} | Get Samba Domain
[**ldapserversSambaDomainsList**](SambaDomainsApi.md#ldapserversSambaDomainsList) | **GET** /ldapservers/{ldapserver_id}/sambadomains | List Samba Domains
[**ldapserversSambaDomainsPost**](SambaDomainsApi.md#ldapserversSambaDomainsPost) | **POST** /ldapservers/{ldapserver_id}/sambadomains | Create Samba Domain
[**ldapserversSambaDomainsPut**](SambaDomainsApi.md#ldapserversSambaDomainsPut) | **PUT** /ldapservers/{ldapserver_id}/sambadomains/{id} | Update Samba Domain


<a name="ldapserversSambaDomainsDelete"></a>
# **ldapserversSambaDomainsDelete**
> String ldapserversSambaDomainsDelete(ldapserverId, id, contentType, accept, xOrgId)

Delete Samba Domain

This endpoint allows you to delete a samba domain from an LDAP server.  ##### Sample Request &#x60;&#x60;&#x60; curl -X DELETE https://console.jumpcloud.com/api/v2/ldapservers/{LDAP_ID}/sambadomains/{SAMBA_ID} \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SambaDomainsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

SambaDomainsApi apiInstance = new SambaDomainsApi();
String ldapserverId = "ldapserverId_example"; // String | Unique identifier of the LDAP server.
String id = "id_example"; // String | Unique identifier of the samba domain.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
String xOrgId = ""; // String | 
try {
    String result = apiInstance.ldapserversSambaDomainsDelete(ldapserverId, id, contentType, accept, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SambaDomainsApi#ldapserversSambaDomainsDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ldapserverId** | **String**| Unique identifier of the LDAP server. |
 **id** | **String**| Unique identifier of the samba domain. |
 **contentType** | **String**|  | [optional] [default to application/json]
 **accept** | **String**|  | [optional] [default to application/json]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

**String**

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="ldapserversSambaDomainsGet"></a>
# **ldapserversSambaDomainsGet**
> SambaDomainOutput ldapserversSambaDomainsGet(ldapserverId, id, contentType, accept, xOrgId)

Get Samba Domain

This endpoint returns a specific samba domain for an LDAP server.  ##### Sample Request &#x60;&#x60;&#x60; curl -X GET \\   https://console.jumpcloud.com/api/v2/ldapservers/ldapservers/{LDAP_ID}/sambadomains/{SAMBA_ID} \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;   &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SambaDomainsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

SambaDomainsApi apiInstance = new SambaDomainsApi();
String ldapserverId = "ldapserverId_example"; // String | Unique identifier of the LDAP server.
String id = "id_example"; // String | Unique identifier of the samba domain.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
String xOrgId = ""; // String | 
try {
    SambaDomainOutput result = apiInstance.ldapserversSambaDomainsGet(ldapserverId, id, contentType, accept, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SambaDomainsApi#ldapserversSambaDomainsGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ldapserverId** | **String**| Unique identifier of the LDAP server. |
 **id** | **String**| Unique identifier of the samba domain. |
 **contentType** | **String**|  | [optional] [default to application/json]
 **accept** | **String**|  | [optional] [default to application/json]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

[**SambaDomainOutput**](SambaDomainOutput.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="ldapserversSambaDomainsList"></a>
# **ldapserversSambaDomainsList**
> List&lt;SambaDomainOutput&gt; ldapserversSambaDomainsList(ldapserverId, contentType, accept, fields, filter, limit, skip, sort, xOrgId)

List Samba Domains

This endpoint returns all samba domains for an LDAP server.  ##### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/ldapservers/{LDAP_ID}/sambadomains \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;   &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SambaDomainsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

SambaDomainsApi apiInstance = new SambaDomainsApi();
String ldapserverId = "ldapserverId_example"; // String | Unique identifier of the LDAP server.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
List<String> fields = Arrays.asList("fields_example"); // List<String> | The comma separated fields included in the returned records. If omitted, the default list of fields will be returned. 
List<String> filter = Arrays.asList("filter_example"); // List<String> | Supported operators are: eq, ne, gt, ge, lt, le, between, search, in
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> sort = Arrays.asList("sort_example"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
String xOrgId = ""; // String | 
try {
    List<SambaDomainOutput> result = apiInstance.ldapserversSambaDomainsList(ldapserverId, contentType, accept, fields, filter, limit, skip, sort, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SambaDomainsApi#ldapserversSambaDomainsList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ldapserverId** | **String**| Unique identifier of the LDAP server. |
 **contentType** | **String**|  | [optional] [default to application/json]
 **accept** | **String**|  | [optional] [default to application/json]
 **fields** | [**List&lt;String&gt;**](String.md)| The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  | [optional]
 **filter** | [**List&lt;String&gt;**](String.md)| Supported operators are: eq, ne, gt, ge, lt, le, between, search, in | [optional]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **sort** | [**List&lt;String&gt;**](String.md)| The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  | [optional]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

[**List&lt;SambaDomainOutput&gt;**](SambaDomainOutput.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="ldapserversSambaDomainsPost"></a>
# **ldapserversSambaDomainsPost**
> SambaDomainOutput ldapserversSambaDomainsPost(ldapserverId, body, contentType, accept, xOrgId)

Create Samba Domain

This endpoint allows you to create a samba domain for an LDAP server.  ##### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/ldapservers/{LDAP_ID}/sambadomains \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{ \&quot;sid\&quot;:\&quot;{SID_ID}\&quot;, \&quot;name\&quot;:\&quot;{WORKGROUP_NAME}\&quot; }&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SambaDomainsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

SambaDomainsApi apiInstance = new SambaDomainsApi();
String ldapserverId = "ldapserverId_example"; // String | Unique identifier of the LDAP server.
SambaDomainInput body = new SambaDomainInput(); // SambaDomainInput | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
String xOrgId = ""; // String | 
try {
    SambaDomainOutput result = apiInstance.ldapserversSambaDomainsPost(ldapserverId, body, contentType, accept, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SambaDomainsApi#ldapserversSambaDomainsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ldapserverId** | **String**| Unique identifier of the LDAP server. |
 **body** | [**SambaDomainInput**](SambaDomainInput.md)|  | [optional]
 **contentType** | **String**|  | [optional] [default to application/json]
 **accept** | **String**|  | [optional] [default to application/json]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

[**SambaDomainOutput**](SambaDomainOutput.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="ldapserversSambaDomainsPut"></a>
# **ldapserversSambaDomainsPut**
> SambaDomainOutput ldapserversSambaDomainsPut(ldapserverId, id, body, contentType, accept, xOrgId)

Update Samba Domain

This endpoint allows you to update the samba domain information for an LDAP server.  ##### Sample Request &#x60;&#x60;&#x60; curl -X PUT https://console.jumpcloud.com/api/v2/ldapservers/{LDAP_ID}/sambadomains/{SAMBA_ID} \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{ \&quot;sid\&quot;:\&quot;{SID_ID}\&quot;, \&quot;name\&quot;:\&quot;{WORKGROUP_NAME}\&quot; }&#39;  &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SambaDomainsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

SambaDomainsApi apiInstance = new SambaDomainsApi();
String ldapserverId = "ldapserverId_example"; // String | Unique identifier of the LDAP server.
String id = "id_example"; // String | Unique identifier of the samba domain.
SambaDomainInput body = new SambaDomainInput(); // SambaDomainInput | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
String xOrgId = ""; // String | 
try {
    SambaDomainOutput result = apiInstance.ldapserversSambaDomainsPut(ldapserverId, id, body, contentType, accept, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SambaDomainsApi#ldapserversSambaDomainsPut");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ldapserverId** | **String**| Unique identifier of the LDAP server. |
 **id** | **String**| Unique identifier of the samba domain. |
 **body** | [**SambaDomainInput**](SambaDomainInput.md)|  | [optional]
 **contentType** | **String**|  | [optional] [default to application/json]
 **accept** | **String**|  | [optional] [default to application/json]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

[**SambaDomainOutput**](SambaDomainOutput.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

