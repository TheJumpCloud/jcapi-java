# FdeApi

All URIs are relative to *https://console.jumpcloud.com/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**systemsGetFDEKey**](FdeApi.md#systemsGetFDEKey) | **GET** /systems/{system_id}/fdekey | Get System FDE Key

<a name="systemsGetFDEKey"></a>
# **systemsGetFDEKey**
> Systemfdekey systemsGetFDEKey(systemId, xOrgId)

Get System FDE Key

This endpoint will return the current (latest) fde key saved for a system.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.FdeApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

FdeApi apiInstance = new FdeApi();
String systemId = "systemId_example"; // String | 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    Systemfdekey result = apiInstance.systemsGetFDEKey(systemId, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FdeApi#systemsGetFDEKey");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **systemId** | **String**|  |
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**Systemfdekey**](Systemfdekey.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

