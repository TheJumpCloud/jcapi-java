# ApplicationsApi

All URIs are relative to *https://console.jumpcloud.com/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**applicationsList**](ApplicationsApi.md#applicationsList) | **GET** /applications | Applications


<a name="applicationsList"></a>
# **applicationsList**
> Applicationslist applicationsList(contentType, accept, fields, limit, skip, sort, filter, xOrgId)

Applications

The endpoint returns all your SSO / SAML Applications.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/applications \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;   &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ApplicationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ApplicationsApi apiInstance = new ApplicationsApi();
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
String fields = "fields_example"; // String | The comma separated fields included in the returned records. If omitted the default list of fields will be returned.
Integer limit = 56; // Integer | The number of records to return at once.
Integer skip = 56; // Integer | The offset into the records to return.
String sort = "The comma separated fields used to sort the collection. Default sort is ascending, prefix with - to sort descending."; // String | 
String filter = "filter_example"; // String | A filter to apply to the query.
String xOrgId = ""; // String | 
try {
    Applicationslist result = apiInstance.applicationsList(contentType, accept, fields, limit, skip, sort, filter, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ApplicationsApi#applicationsList");
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

[**Applicationslist**](Applicationslist.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json; charset=utf-8

