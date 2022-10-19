# GSuiteImportApi

All URIs are relative to *https://console.jumpcloud.com/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**gsuitesListImportJumpcloudUsers**](GSuiteImportApi.md#gsuitesListImportJumpcloudUsers) | **GET** /gsuites/{gsuite_id}/import/jumpcloudusers | Get a list of users in Jumpcloud format to import from a Google Workspace account.
[**gsuitesListImportUsers**](GSuiteImportApi.md#gsuitesListImportUsers) | **GET** /gsuites/{gsuite_id}/import/users | Get a list of users to import from a G Suite instance

<a name="gsuitesListImportJumpcloudUsers"></a>
# **gsuitesListImportJumpcloudUsers**
> InlineResponse2001 gsuitesListImportJumpcloudUsers(gsuiteId, maxResults, orderBy, pageToken, query, sortOrder)

Get a list of users in Jumpcloud format to import from a Google Workspace account.

Lists available G Suite users for import, translated to the Jumpcloud user schema.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GSuiteImportApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GSuiteImportApi apiInstance = new GSuiteImportApi();
String gsuiteId = "gsuiteId_example"; // String | 
Integer maxResults = 56; // Integer | Google Directory API maximum number of results per page. See https://developers.google.com/admin-sdk/directory/reference/rest/v1/users/list.
String orderBy = "orderBy_example"; // String | Google Directory API sort field parameter. See https://developers.google.com/admin-sdk/directory/reference/rest/v1/users/list.
String pageToken = "pageToken_example"; // String | Google Directory API token used to access the next page of results. See https://developers.google.com/admin-sdk/directory/reference/rest/v1/users/list.
String query = "query_example"; // String | Google Directory API search parameter. See https://developers.google.com/admin-sdk/directory/v1/guides/search-users.
String sortOrder = "sortOrder_example"; // String | Google Directory API sort direction parameter. See https://developers.google.com/admin-sdk/directory/reference/rest/v1/users/list.
try {
    InlineResponse2001 result = apiInstance.gsuitesListImportJumpcloudUsers(gsuiteId, maxResults, orderBy, pageToken, query, sortOrder);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GSuiteImportApi#gsuitesListImportJumpcloudUsers");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **gsuiteId** | **String**|  |
 **maxResults** | **Integer**| Google Directory API maximum number of results per page. See https://developers.google.com/admin-sdk/directory/reference/rest/v1/users/list. | [optional]
 **orderBy** | **String**| Google Directory API sort field parameter. See https://developers.google.com/admin-sdk/directory/reference/rest/v1/users/list. | [optional]
 **pageToken** | **String**| Google Directory API token used to access the next page of results. See https://developers.google.com/admin-sdk/directory/reference/rest/v1/users/list. | [optional]
 **query** | **String**| Google Directory API search parameter. See https://developers.google.com/admin-sdk/directory/v1/guides/search-users. | [optional]
 **sortOrder** | **String**| Google Directory API sort direction parameter. See https://developers.google.com/admin-sdk/directory/reference/rest/v1/users/list. | [optional]

### Return type

[**InlineResponse2001**](InlineResponse2001.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="gsuitesListImportUsers"></a>
# **gsuitesListImportUsers**
> InlineResponse2002 gsuitesListImportUsers(gsuiteId, limit, maxResults, orderBy, pageToken, query, sortOrder)

Get a list of users to import from a G Suite instance

Lists G Suite users available for import.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GSuiteImportApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GSuiteImportApi apiInstance = new GSuiteImportApi();
String gsuiteId = "gsuiteId_example"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer maxResults = 56; // Integer | Google Directory API maximum number of results per page. See https://developers.google.com/admin-sdk/directory/reference/rest/v1/users/list.
String orderBy = "orderBy_example"; // String | Google Directory API sort field parameter. See https://developers.google.com/admin-sdk/directory/reference/rest/v1/users/list.
String pageToken = "pageToken_example"; // String | Google Directory API token used to access the next page of results. See https://developers.google.com/admin-sdk/directory/reference/rest/v1/users/list.
String query = "query_example"; // String | Google Directory API search parameter. See https://developers.google.com/admin-sdk/directory/v1/guides/search-users.
String sortOrder = "sortOrder_example"; // String | Google Directory API sort direction parameter. See https://developers.google.com/admin-sdk/directory/reference/rest/v1/users/list.
try {
    InlineResponse2002 result = apiInstance.gsuitesListImportUsers(gsuiteId, limit, maxResults, orderBy, pageToken, query, sortOrder);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GSuiteImportApi#gsuitesListImportUsers");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **gsuiteId** | **String**|  |
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **maxResults** | **Integer**| Google Directory API maximum number of results per page. See https://developers.google.com/admin-sdk/directory/reference/rest/v1/users/list. | [optional]
 **orderBy** | **String**| Google Directory API sort field parameter. See https://developers.google.com/admin-sdk/directory/reference/rest/v1/users/list. | [optional]
 **pageToken** | **String**| Google Directory API token used to access the next page of results. See https://developers.google.com/admin-sdk/directory/reference/rest/v1/users/list. | [optional]
 **query** | **String**| Google Directory API search parameter. See https://developers.google.com/admin-sdk/directory/v1/guides/search-users. | [optional]
 **sortOrder** | **String**| Google Directory API sort direction parameter. See https://developers.google.com/admin-sdk/directory/reference/rest/v1/users/list. | [optional]

### Return type

[**InlineResponse2002**](InlineResponse2002.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

