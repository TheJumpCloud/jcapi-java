# ScimImportApi

All URIs are relative to *https://console.jumpcloud.com/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**importUsers**](ScimImportApi.md#importUsers) | **GET** /applications/{application_id}/import/users | Get a list of users to import from an Application IdM service provider

<a name="importUsers"></a>
# **importUsers**
> ImportUsersResponse importUsers(applicationId, filter, query, sort, sortOrder, xOrgId, limit, skip)

Get a list of users to import from an Application IdM service provider

Get a list of users to import from an Application IdM service provider.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ScimImportApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ScimImportApi apiInstance = new ScimImportApi();
String applicationId = "applicationId_example"; // String | ObjectID of the Application.
String filter = "filter_example"; // String | Filter users by a search term
String query = "query_example"; // String | URL query to merge with the service provider request
String sort = "sort_example"; // String | Sort users by supported fields
String sortOrder = "asc"; // String | 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
try {
    ImportUsersResponse result = apiInstance.importUsers(applicationId, filter, query, sort, sortOrder, xOrgId, limit, skip);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ScimImportApi#importUsers");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationId** | **String**| ObjectID of the Application. |
 **filter** | **String**| Filter users by a search term | [optional]
 **query** | **String**| URL query to merge with the service provider request | [optional]
 **sort** | **String**| Sort users by supported fields | [optional] [enum: , firstname, lastname, email]
 **sortOrder** | **String**|  | [optional] [default to asc] [enum: asc, desc]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]

### Return type

[**ImportUsersResponse**](ImportUsersResponse.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

