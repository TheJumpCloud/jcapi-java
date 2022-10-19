# Office365ImportApi

All URIs are relative to *https://console.jumpcloud.com/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**office365sListImportUsers**](Office365ImportApi.md#office365sListImportUsers) | **GET** /office365s/{office365_id}/import/users | Get a list of users to import from an Office 365 instance

<a name="office365sListImportUsers"></a>
# **office365sListImportUsers**
> InlineResponse20011 office365sListImportUsers(office365Id, consistencyLevel, top, skipToken, filter, search, orderby, count)

Get a list of users to import from an Office 365 instance

Lists Office 365 users available for import.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.Office365ImportApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

Office365ImportApi apiInstance = new Office365ImportApi();
String office365Id = "office365Id_example"; // String | 
String consistencyLevel = "consistencyLevel_example"; // String | Defines the consistency header for O365 requests. See https://docs.microsoft.com/en-us/graph/api/user-list?view=graph-rest-1.0&tabs=http#request-headers
Integer top = 56; // Integer | Office 365 API maximum number of results per page. See https://docs.microsoft.com/en-us/graph/paging.
String skipToken = "skipToken_example"; // String | Office 365 API token used to access the next page of results. See https://docs.microsoft.com/en-us/graph/paging.
String filter = "filter_example"; // String | Office 365 API filter parameter. See https://docs.microsoft.com/en-us/graph/api/user-list?view=graph-rest-1.0&tabs=http#optional-query-parameters.
String search = "search_example"; // String | Office 365 API search parameter. See https://docs.microsoft.com/en-us/graph/api/user-list?view=graph-rest-1.0&tabs=http#optional-query-parameters.
String orderby = "orderby_example"; // String | Office 365 API orderby parameter. See https://docs.microsoft.com/en-us/graph/api/user-list?view=graph-rest-1.0&tabs=http#optional-query-parameters.
Boolean count = true; // Boolean | Office 365 API count parameter. See https://docs.microsoft.com/en-us/graph/api/user-list?view=graph-rest-1.0&tabs=http#optional-query-parameters.
try {
    InlineResponse20011 result = apiInstance.office365sListImportUsers(office365Id, consistencyLevel, top, skipToken, filter, search, orderby, count);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling Office365ImportApi#office365sListImportUsers");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **office365Id** | **String**|  |
 **consistencyLevel** | **String**| Defines the consistency header for O365 requests. See https://docs.microsoft.com/en-us/graph/api/user-list?view&#x3D;graph-rest-1.0&amp;tabs&#x3D;http#request-headers | [optional]
 **top** | **Integer**| Office 365 API maximum number of results per page. See https://docs.microsoft.com/en-us/graph/paging. | [optional]
 **skipToken** | **String**| Office 365 API token used to access the next page of results. See https://docs.microsoft.com/en-us/graph/paging. | [optional]
 **filter** | **String**| Office 365 API filter parameter. See https://docs.microsoft.com/en-us/graph/api/user-list?view&#x3D;graph-rest-1.0&amp;tabs&#x3D;http#optional-query-parameters. | [optional]
 **search** | **String**| Office 365 API search parameter. See https://docs.microsoft.com/en-us/graph/api/user-list?view&#x3D;graph-rest-1.0&amp;tabs&#x3D;http#optional-query-parameters. | [optional]
 **orderby** | **String**| Office 365 API orderby parameter. See https://docs.microsoft.com/en-us/graph/api/user-list?view&#x3D;graph-rest-1.0&amp;tabs&#x3D;http#optional-query-parameters. | [optional]
 **count** | **Boolean**| Office 365 API count parameter. See https://docs.microsoft.com/en-us/graph/api/user-list?view&#x3D;graph-rest-1.0&amp;tabs&#x3D;http#optional-query-parameters. | [optional]

### Return type

[**InlineResponse20011**](InlineResponse20011.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

