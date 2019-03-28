# SearchApi

All URIs are relative to *https://console.jumpcloud.com/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**searchOrganizationsPost**](SearchApi.md#searchOrganizationsPost) | **POST** /search/organizations | Search Organizations
[**searchSystemsPost**](SearchApi.md#searchSystemsPost) | **POST** /search/systems | Search Systems
[**searchSystemusersPost**](SearchApi.md#searchSystemusersPost) | **POST** /search/systemusers | Search System Users


<a name="searchOrganizationsPost"></a>
# **searchOrganizationsPost**
> Organizationslist searchOrganizationsPost(contentType, accept, body, fields, filter, limit, skip)

Search Organizations

This endpoint will return Organization data based on your search parameters. This endpoint WILL NOT allow you to add a new Organization.  You can use the supported parameters and pass those in the body of request.   The parameters must be passed as Content-Type application/json.   #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/search/organizations \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{   \&quot;search\&quot;:{     \&quot;fields\&quot; : [\&quot;settings.name\&quot;],     \&quot;searchTerm\&quot;: \&quot;Second\&quot;     },   \&quot;fields\&quot;: [\&quot;_id\&quot;, \&quot;displayName\&quot;, \&quot;logoUrl\&quot;],   \&quot;limit\&quot; : 0,   \&quot;skip\&quot; : 0 }&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SearchApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

SearchApi apiInstance = new SearchApi();
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Search body = new Search(); // Search | 
String fields = ""; // String | Use a space seperated string of field parameters to include the data in the response. If omitted, the default list of fields will be returned. 
String filter = "filter_example"; // String | A filter to apply to the query.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
try {
    Organizationslist result = apiInstance.searchOrganizationsPost(contentType, accept, body, fields, filter, limit, skip);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SearchApi#searchOrganizationsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **body** | [**Search**](Search.md)|  | [optional]
 **fields** | **String**| Use a space seperated string of field parameters to include the data in the response. If omitted, the default list of fields will be returned.  | [optional] [default to ]
 **filter** | **String**| A filter to apply to the query. | [optional]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]

### Return type

[**Organizationslist**](Organizationslist.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json; charset=utf-8

<a name="searchSystemsPost"></a>
# **searchSystemsPost**
> Systemslist searchSystemsPost(contentType, accept, body, fields, limit, xOrgId, skip, filter)

Search Systems

Return Systems in multi-record format allowing for the passing of the &#x60;filter&#x60; and &#x60;searchFilter&#x60; parameters. This WILL NOT allow you to add a new system.  To support advanced filtering you can use the &#x60;filter&#x60; and &#x60;searchFilter&#x60; parameters that can only be passed in the body of POST /api/search/_* routes. The &#x60;filter&#x60; and &#x60;searchFilter&#x60; parameters must be passed as Content-Type application/json.  The &#x60;filter&#x60; parameter is an object with a single property, either &#x60;and&#x60; or &#x60;or&#x60; with the value of the property being an array of query expressions.   This allows you to filter records using the logic of matching ALL or ANY records in the array of query expressions. If the &#x60;and&#x60; or &#x60;or&#x60; are not included the default behavior is to match ALL query expressions.  The &#x60;searchFilter&#x60; parameter allows text searching on supported fields by specifying a &#x60;searchTerm&#x60; and a list of &#x60;fields&#x60; to query on. If any &#x60;field&#x60; has a partial text match on the&#x60;searchTerm&#x60; the record will be returned.   #### Sample Request  Exact search for a list of hostnames &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/search/systems \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{   \&quot;filter\&quot;: {     \&quot;or\&quot;: [       {\&quot;hostname\&quot; : \&quot;my-hostname\&quot;},       {\&quot;hostname\&quot; : \&quot;other-hostname\&quot;}     ]   },   \&quot;fields\&quot; : \&quot;os hostname displayName\&quot; }&#39; &#x60;&#x60;&#x60;  Text search for a hostname or display name &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/search/systems \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{   \&quot;searchFilter\&quot;: {     \&quot;searchTerm\&quot;: \&quot;my-host\&quot;,     \&quot;fields\&quot;: [\&quot;hostname\&quot;, \&quot;displayName\&quot;]   },   \&quot;fields\&quot;: \&quot;os hostname displayName\&quot; }&#39; &#x60;&#x60;&#x60;  Combining &#x60;filter&#x60; and &#x60;searchFilter&#x60; to search for names that match a given OS &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/search/systems \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{   \&quot;searchFilter\&quot;: {     \&quot;searchTerm\&quot;: \&quot;my-host\&quot;,     \&quot;fields\&quot;: [\&quot;hostname\&quot;, \&quot;displayName\&quot;]   },   \&quot;filter\&quot;: {     \&quot;or\&quot;: [       {\&quot;os\&quot; : \&quot;Ubuntu\&quot;},       {\&quot;os\&quot; : \&quot;Mac OS X\&quot;}     ]   },   \&quot;fields\&quot;: \&quot;os hostname displayName\&quot; }&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SearchApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

SearchApi apiInstance = new SearchApi();
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Search body = new Search(); // Search | 
String fields = ""; // String | Use a space seperated string of field parameters to include the data in the response. If omitted, the default list of fields will be returned. 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = ""; // String | 
Integer skip = 0; // Integer | The offset into the records to return.
String filter = "filter_example"; // String | A filter to apply to the query.
try {
    Systemslist result = apiInstance.searchSystemsPost(contentType, accept, body, fields, limit, xOrgId, skip, filter);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SearchApi#searchSystemsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **body** | [**Search**](Search.md)|  | [optional]
 **fields** | **String**| Use a space seperated string of field parameters to include the data in the response. If omitted, the default list of fields will be returned.  | [optional] [default to ]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**|  | [optional] [default to ]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **filter** | **String**| A filter to apply to the query. | [optional]

### Return type

[**Systemslist**](Systemslist.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json; charset=utf-8

<a name="searchSystemusersPost"></a>
# **searchSystemusersPost**
> Systemuserslist searchSystemusersPost(contentType, accept, body, fields, filter, limit, skip, xOrgId)

Search System Users

Return System Users in multi-record format allowing for the passing of the &#x60;filter&#x60; and &#x60;searchFilter&#x60; parameters. This WILL NOT allow you to add a new system user.  To support advanced filtering you can use the &#x60;filter&#x60; and &#x60;searchFilter&#x60; parameters that can only be passed in the body of POST /api/search/_* routes. The &#x60;filter&#x60; and &#x60;searchFilter&#x60; parameters must be passed as Content-Type application/json.  The &#x60;filter&#x60; parameter is an object with a single property, either &#x60;and&#x60; or &#x60;or&#x60; with the value of the property being an array of query expressions.   This allows you to filter records using the logic of matching ALL or ANY records in the array of query expressions. If the &#x60;and&#x60; or &#x60;or&#x60; are not included the default behavior is to match ALL query expressions.  The &#x60;searchFilter&#x60; parameter allows text searching on supported fields by specifying a &#x60;searchTerm&#x60; and a list of &#x60;fields&#x60; to query on. If any &#x60;field&#x60; has a partial text match on the&#x60;searchTerm&#x60; the record will be returned.   #### Sample Request  Exact search for a list of system users in a department &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/search/systemusers \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{   \&quot;filter\&quot; : [{\&quot;department\&quot; : \&quot;IT\&quot;}],   \&quot;fields\&quot; : \&quot;email username sudo\&quot; }&#39; &#x60;&#x60;&#x60;  Text search for system users with and email on a domain &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/search/systemusers \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{   \&quot;searchFilter\&quot; : {     \&quot;searchTerm\&quot;: \&quot;@jumpcloud.com\&quot;,     \&quot;fields\&quot;: [\&quot;email\&quot;]   },   \&quot;fields\&quot; : \&quot;email username sudo\&quot; }&#39; &#x60;&#x60;&#x60;  Combining &#x60;filter&#x60; and &#x60;searchFilter&#x60; to text search for system users with and email on a domain who are in a list of departments &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/search/systemusers \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{   \&quot;searchFilter\&quot;: {     \&quot;searchTerm\&quot;: \&quot;@jumpcloud.com\&quot;,     \&quot;fields\&quot;: [\&quot;email\&quot;]   },   \&quot;filter\&quot;: {     \&quot;or\&quot;: [       {\&quot;department\&quot; : \&quot;IT\&quot;},       {\&quot;department\&quot; : \&quot;Sales\&quot;}     ]   },   \&quot;fields\&quot; : \&quot;email username sudo\&quot; }&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SearchApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

SearchApi apiInstance = new SearchApi();
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Search body = new Search(); // Search | 
String fields = ""; // String | Use a space seperated string of field parameters to include the data in the response. If omitted, the default list of fields will be returned. 
String filter = "filter_example"; // String | A filter to apply to the query.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = ""; // String | 
try {
    Systemuserslist result = apiInstance.searchSystemusersPost(contentType, accept, body, fields, filter, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SearchApi#searchSystemusersPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **body** | [**Search**](Search.md)|  | [optional]
 **fields** | **String**| Use a space seperated string of field parameters to include the data in the response. If omitted, the default list of fields will be returned.  | [optional] [default to ]
 **filter** | **String**| A filter to apply to the query. | [optional]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

[**Systemuserslist**](Systemuserslist.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json; charset=utf-8

