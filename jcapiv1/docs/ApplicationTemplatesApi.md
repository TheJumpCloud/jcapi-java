# ApplicationTemplatesApi

All URIs are relative to *https://console.jumpcloud.com/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**applicationTemplatesGet**](ApplicationTemplatesApi.md#applicationTemplatesGet) | **GET** /application-templates/{id} | Get an Application Template
[**applicationTemplatesList**](ApplicationTemplatesApi.md#applicationTemplatesList) | **GET** /application-templates | List Application Templates


<a name="applicationTemplatesGet"></a>
# **applicationTemplatesGet**
> Applicationtemplate applicationTemplatesGet(id, contentType, accept, fields, limit, skip, sort, filter, xOrgId)

Get an Application Template

The endpoint returns a specific SSO / SAML Application Template.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/application-templates/{id} \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;   &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ApplicationTemplatesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

ApplicationTemplatesApi apiInstance = new ApplicationTemplatesApi();
String id = "id_example"; // String | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
String fields = "fields_example"; // String | The comma separated fields included in the returned records. If omitted the default list of fields will be returned.
Integer limit = 56; // Integer | The number of records to return at once.
Integer skip = 56; // Integer | The offset into the records to return.
String sort = "The comma separated fields used to sort the collection. Default sort is ascending, prefix with - to sort descending."; // String | 
String filter = "filter_example"; // String | A filter to apply to the query.
String xOrgId = ""; // String | 
try {
    Applicationtemplate result = apiInstance.applicationTemplatesGet(id, contentType, accept, fields, limit, skip, sort, filter, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ApplicationTemplatesApi#applicationTemplatesGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **fields** | **String**| The comma separated fields included in the returned records. If omitted the default list of fields will be returned. | [optional]
 **limit** | **Integer**| The number of records to return at once. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional]
 **sort** | **String**|  | [optional] [default to The comma separated fields used to sort the collection. Default sort is ascending, prefix with - to sort descending.]
 **filter** | **String**| A filter to apply to the query. | [optional]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

[**Applicationtemplate**](Applicationtemplate.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="applicationTemplatesList"></a>
# **applicationTemplatesList**
> Applicationtemplateslist applicationTemplatesList(contentType, accept, fields, limit, skip, sort, filter, xOrgId)

List Application Templates

The endpoint returns all the SSO / SAML Application Templates.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/application-templates \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;   &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ApplicationTemplatesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

ApplicationTemplatesApi apiInstance = new ApplicationTemplatesApi();
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
String fields = "fields_example"; // String | The comma separated fields included in the returned records. If omitted the default list of fields will be returned.
Integer limit = 56; // Integer | The number of records to return at once.
Integer skip = 56; // Integer | The offset into the records to return.
String sort = "The comma separated fields used to sort the collection. Default sort is ascending, prefix with - to sort descending."; // String | 
String filter = "filter_example"; // String | A filter to apply to the query.
String xOrgId = ""; // String | 
try {
    Applicationtemplateslist result = apiInstance.applicationTemplatesList(contentType, accept, fields, limit, skip, sort, filter, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ApplicationTemplatesApi#applicationTemplatesList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **fields** | **String**| The comma separated fields included in the returned records. If omitted the default list of fields will be returned. | [optional]
 **limit** | **Integer**| The number of records to return at once. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional]
 **sort** | **String**|  | [optional] [default to The comma separated fields used to sort the collection. Default sort is ascending, prefix with - to sort descending.]
 **filter** | **String**| A filter to apply to the query. | [optional]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

[**Applicationtemplateslist**](Applicationtemplateslist.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

