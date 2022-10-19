# LogosApi

All URIs are relative to *https://console.jumpcloud.com/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**logosGet**](LogosApi.md#logosGet) | **GET** /logos/{id} | Get the logo associated with the specified id

<a name="logosGet"></a>
# **logosGet**
> File logosGet(id)

Get the logo associated with the specified id

Return the logo image associated with the specified id

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.LogosApi;


LogosApi apiInstance = new LogosApi();
String id = "id_example"; // String | 
try {
    File result = apiInstance.logosGet(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LogosApi#logosGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |

### Return type

[**File**](File.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: image/gif, image/jpeg, image/png

