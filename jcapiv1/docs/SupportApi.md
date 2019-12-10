# SupportApi

All URIs are relative to *https://console.jumpcloud.com/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**casePost**](SupportApi.md#casePost) | **POST** /api/cases | Create a Case


<a name="casePost"></a>
# **casePost**
> InlineResponse200 casePost(contentType, accept, body)

Create a Case

This endpoint allows you to open a support case.  #### Sample Request  &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/cases \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{  \&quot;subject\&quot;:\&quot;{subject}\&quot;,  \&quot;description\&quot;:\&quot;{description}\&quot;,  \&quot;firstname\&quot;:\&quot;{firstname}\&quot;,  \&quot;lastname\&quot;:\&quot;{lastname}\&quot; }&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SupportApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

SupportApi apiInstance = new SupportApi();
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
ModelCase body = new ModelCase(); // ModelCase | 
try {
    InlineResponse200 result = apiInstance.casePost(contentType, accept, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SupportApi#casePost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **body** | [**ModelCase**](ModelCase.md)|  | [optional]

### Return type

[**InlineResponse200**](InlineResponse200.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

