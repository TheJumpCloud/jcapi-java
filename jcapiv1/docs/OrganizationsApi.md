# OrganizationsApi

All URIs are relative to *https://console.jumpcloud.com/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**organizationList**](OrganizationsApi.md#organizationList) | **GET** /organizations | Get Organization Details


<a name="organizationList"></a>
# **organizationList**
> Organizationslist organizationList(contentType, accept, fields, limit, skip, sort, search)

Get Organization Details

This endpoint returns Organization Details.  #### Sample Request  &#x60;&#x60;&#x60; curl -X GET \\   https://console.jumpcloud.com/api/organizations \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;   &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.OrganizationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

OrganizationsApi apiInstance = new OrganizationsApi();
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
String fields = ""; // String | Use a space seperated string of field parameters to include the data in the response. If omitted the default list of fields will be returned. 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String sort = ""; // String | Use space separated sort parameters to sort the collection. Default sort is ascending. Prefix with `-` to sort descending. 
String search = "search_example"; // String | 
try {
    Organizationslist result = apiInstance.organizationList(contentType, accept, fields, limit, skip, sort, search);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrganizationsApi#organizationList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **fields** | **String**| Use a space seperated string of field parameters to include the data in the response. If omitted the default list of fields will be returned.  | [optional] [default to ]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **sort** | **String**| Use space separated sort parameters to sort the collection. Default sort is ascending. Prefix with &#x60;-&#x60; to sort descending.  | [optional] [default to ]
 **search** | **String**|  | [optional]

### Return type

[**Organizationslist**](Organizationslist.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json; charset=utf-8

