# GroupsApi

All URIs are relative to *https://console.jumpcloud.com/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**groupsList**](GroupsApi.md#groupsList) | **GET** /groups | List All Groups


<a name="groupsList"></a>
# **groupsList**
> List&lt;Group&gt; groupsList(contentType, accept, fields, filter, limit, skip, sort, xOrgId)

List All Groups

This endpoint returns all Groups that exist in your organization.  #### Available filter fields:   - &#x60;name&#x60;   - &#x60;disabled&#x60;   - &#x60;type&#x60;  #### Sample Request  &#x60;&#x60;&#x60;   curl -X GET \\   https://console.jumpcloud.com/api/v2/groups \\   -H &#39;accept: application/json&#39; \\   -H &#39;content-type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GroupsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GroupsApi apiInstance = new GroupsApi();
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
List<String> fields = Arrays.asList("[]"); // List<String> | The comma separated fields included in the returned records. If omitted the default list of fields will be returned. 
List<String> filter = Arrays.asList("[]"); // List<String> | Supported operators are: eq, ne, gt, ge, lt, le, between, search, in
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> sort = Arrays.asList("[]"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
String xOrgId = ""; // String | 
try {
    List<Group> result = apiInstance.groupsList(contentType, accept, fields, filter, limit, skip, sort, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GroupsApi#groupsList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **fields** | [**List&lt;String&gt;**](String.md)| The comma separated fields included in the returned records. If omitted the default list of fields will be returned.  | [optional] [default to []]
 **filter** | [**List&lt;String&gt;**](String.md)| Supported operators are: eq, ne, gt, ge, lt, le, between, search, in | [optional] [default to []]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **sort** | [**List&lt;String&gt;**](String.md)| The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  | [optional] [default to []]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

[**List&lt;Group&gt;**](Group.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

