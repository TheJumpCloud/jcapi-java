# SearchApi

All URIs are relative to *https://console.jumpcloud.com/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**searchOrganizationsPost**](SearchApi.md#searchOrganizationsPost) | **POST** /search/organizations | Search Organizations
[**searchSystemsPost**](SearchApi.md#searchSystemsPost) | **POST** /search/systems | Search Systems
[**searchSystemusersPost**](SearchApi.md#searchSystemusersPost) | **POST** /search/systemusers | Search System Users


<a name="searchOrganizationsPost"></a>
# **searchOrganizationsPost**
> Systemslist searchOrganizationsPost(contentType, accept, body, fields, limit, xOrgId, skip)

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

SearchApi apiInstance = new SearchApi();
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Search body = new Search(); // Search | 
String fields = ""; // String | Use a space seperated string of field parameters to include the data in the response. If omitted the default list of fields will be returned. 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "<<your org id>>"; // String | 
Integer skip = 0; // Integer | The offset into the records to return.
try {
    Systemslist result = apiInstance.searchOrganizationsPost(contentType, accept, body, fields, limit, xOrgId, skip);
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
 **fields** | **String**| Use a space seperated string of field parameters to include the data in the response. If omitted the default list of fields will be returned.  | [optional] [default to ]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]

### Return type

[**Systemslist**](Systemslist.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json; charset=utf-8

<a name="searchSystemsPost"></a>
# **searchSystemsPost**
> Systemslist searchSystemsPost(contentType, accept, body, fields, limit, xOrgId, skip)

Search Systems

Return Systems in multi-record format allowing for the passing of the &#39;filter&#39; parameter. This WILL NOT allow you to add a new system.  To support advanced filtering you can use the &#x60;filter&#x60; parameter that can only be passed in the body of POST /api/search/_* routes. The &#x60;filter&#x60; parameter must be passed as Content-Type application/json supports advanced filtering using the mongodb JSON query syntax.   The &#x60;filter&#x60; parameter is an object with a single property, either and or or with the value of the property being an array of query expressions.   This allows you to filter records using the logic of matching ALL or ANY records in the array of query expressions. If the and or or are not included the default behavior is to match ALL query expressions.   #### Sample Request  &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/search/systems \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{ \&quot;filter\&quot; :     {         \&quot;or\&quot; :             [                 {\&quot;hostname\&quot; : { \&quot;$regex\&quot; : \&quot;^www\&quot; }},                 {\&quot;hostname\&quot; : {\&quot;$regex\&quot; : \&quot;^db\&quot;}}             ]     }, \&quot;fields\&quot; : \&quot;os hostname displayName\&quot; }&#39; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

SearchApi apiInstance = new SearchApi();
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Search body = new Search(); // Search | 
String fields = ""; // String | Use a space seperated string of field parameters to include the data in the response. If omitted the default list of fields will be returned. 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "<<your org id>>"; // String | 
Integer skip = 0; // Integer | The offset into the records to return.
try {
    Systemslist result = apiInstance.searchSystemsPost(contentType, accept, body, fields, limit, xOrgId, skip);
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
 **fields** | **String**| Use a space seperated string of field parameters to include the data in the response. If omitted the default list of fields will be returned.  | [optional] [default to ]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]

### Return type

[**Systemslist**](Systemslist.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json; charset=utf-8

<a name="searchSystemusersPost"></a>
# **searchSystemusersPost**
> Systemuserslist searchSystemusersPost(contentType, accept, body, fields, limit, skip, xOrgId)

Search System Users

Return System Users in multi-record format allowing for the passing of the &#39;filter&#39; parameter. This WILL NOT allow you to add a new system user.  To support advanced filtering you can use the &#x60;filter&#x60; parameter that can only be passed in the body of POST /api/search/_* routes. The &#x60;filter&#x60; parameter must be passed as Content-Type application/json supports advanced filtering using the mongodb JSON query syntax.   The &#x60;filter&#x60; parameter is an object with a single property, either and or or with the value of the property being an array of query expressions.   This allows you to filter records using the logic of matching ALL or ANY records in the array of query expressions. If the and or or are not included the default behavior is to match ALL query expressions.  #### Sample Request  &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/search/systemsusers \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{ \&quot;filter\&quot; : [{\&quot;email\&quot; : { \&quot;$regex\&quot; : \&quot;gmail.com$\&quot;}}], \&quot;fields\&quot; : \&quot;email username sudo\&quot; }&#39; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

SearchApi apiInstance = new SearchApi();
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Search body = new Search(); // Search | 
String fields = ""; // String | Use a space seperated string of field parameters to include the data in the response. If omitted the default list of fields will be returned. 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    Systemuserslist result = apiInstance.searchSystemusersPost(contentType, accept, body, fields, limit, skip, xOrgId);
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
 **fields** | **String**| Use a space seperated string of field parameters to include the data in the response. If omitted the default list of fields will be returned.  | [optional] [default to ]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**Systemuserslist**](Systemuserslist.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json; charset=utf-8

