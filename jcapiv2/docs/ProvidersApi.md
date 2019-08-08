# ProvidersApi

All URIs are relative to *https://console.jumpcloud.com/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**providersListAdministrators**](ProvidersApi.md#providersListAdministrators) | **GET** /providers/{provider_id}/administrators | List Provider Administrators
[**providersPostAdmins**](ProvidersApi.md#providersPostAdmins) | **POST** /providers/{provider_id}/administrators | Create a new Provider Administrator


<a name="providersListAdministrators"></a>
# **providersListAdministrators**
> InlineResponse2001 providersListAdministrators(providerId, contentType, accept, fields, filter, limit, skip, sort)

List Provider Administrators

This endpoint returns a list of the Administrators associated with the Provider.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/providers/{ProviderID}/administrators \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

ProvidersApi apiInstance = new ProvidersApi();
String providerId = "providerId_example"; // String | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
List<String> fields = Arrays.asList("fields_example"); // List<String> | The comma separated fields included in the returned records. If omitted, the default list of fields will be returned. 
List<String> filter = Arrays.asList("filter_example"); // List<String> | Supported operators are: eq, ne, gt, ge, lt, le, between, search, in
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> sort = Arrays.asList("sort_example"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
try {
    InlineResponse2001 result = apiInstance.providersListAdministrators(providerId, contentType, accept, fields, filter, limit, skip, sort);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProvidersApi#providersListAdministrators");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **providerId** | **String**|  |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **fields** | [**List&lt;String&gt;**](String.md)| The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  | [optional]
 **filter** | [**List&lt;String&gt;**](String.md)| Supported operators are: eq, ne, gt, ge, lt, le, between, search, in | [optional]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **sort** | [**List&lt;String&gt;**](String.md)| The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  | [optional]

### Return type

[**InlineResponse2001**](InlineResponse2001.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="providersPostAdmins"></a>
# **providersPostAdmins**
> Administrator providersPostAdmins(providerId, contentType, accept, body)

Create a new Provider Administrator

This endpoint allows you to create a provider administrator. You must be associated to the provider to use this route.  **Sample Request**  &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/providers/{ProviderID}/administrators \\     -H &#39;Accept: application/json&#39; \\     -H &#39;Context-Type: application/json&#39; \\     -H &#39;x-api-key: {API_KEY}&#39; \\     -d &#39;{       \&quot;email\&quot;:\&quot;{ADMIN_EMAIL}\&quot;     }&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

ProvidersApi apiInstance = new ProvidersApi();
String providerId = "providerId_example"; // String | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
ProviderAdminReq body = new ProviderAdminReq(); // ProviderAdminReq | 
try {
    Administrator result = apiInstance.providersPostAdmins(providerId, contentType, accept, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProvidersApi#providersPostAdmins");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **providerId** | **String**|  |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **body** | [**ProviderAdminReq**](ProviderAdminReq.md)|  | [optional]

### Return type

[**Administrator**](Administrator.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

