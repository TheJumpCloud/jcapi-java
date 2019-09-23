# ApplicationsApi

All URIs are relative to *https://console.jumpcloud.com/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**applicationsDelete**](ApplicationsApi.md#applicationsDelete) | **DELETE** /applications/{id} | Delete an Application
[**applicationsGet**](ApplicationsApi.md#applicationsGet) | **GET** /applications/{id} | Get an Application
[**applicationsList**](ApplicationsApi.md#applicationsList) | **GET** /applications | Applications
[**applicationsPost**](ApplicationsApi.md#applicationsPost) | **POST** /applications | Create an Application
[**applicationsPut**](ApplicationsApi.md#applicationsPut) | **PUT** /applications/{id} | Update an Application


<a name="applicationsDelete"></a>
# **applicationsDelete**
> Application applicationsDelete(id, contentType, accept, xOrgId)

Delete an Application

The endpoint deletes an SSO / SAML Application.

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
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

ApplicationsApi apiInstance = new ApplicationsApi();
String id = "id_example"; // String | 
String contentType = "contentType_example"; // String | 
String accept = "accept_example"; // String | 
String xOrgId = "xOrgId_example"; // String | 
try {
    Application result = apiInstance.applicationsDelete(id, contentType, accept, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ApplicationsApi#applicationsDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **contentType** | **String**|  | [optional]
 **accept** | **String**|  | [optional]
 **xOrgId** | **String**|  | [optional]

### Return type

[**Application**](Application.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="applicationsGet"></a>
# **applicationsGet**
> Application applicationsGet(id, contentType, accept, xOrgId)

Get an Application

The endpoint retrieves an SSO / SAML Application.

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
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

ApplicationsApi apiInstance = new ApplicationsApi();
String id = "id_example"; // String | 
String contentType = "contentType_example"; // String | 
String accept = "accept_example"; // String | 
String xOrgId = "xOrgId_example"; // String | 
try {
    Application result = apiInstance.applicationsGet(id, contentType, accept, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ApplicationsApi#applicationsGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **contentType** | **String**|  | [optional]
 **accept** | **String**|  | [optional]
 **xOrgId** | **String**|  | [optional]

### Return type

[**Application**](Application.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

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
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

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
 - **Accept**: application/json

<a name="applicationsPost"></a>
# **applicationsPost**
> Application applicationsPost(body, contentType, accept, xOrgId)

Create an Application

The endpoint adds a new SSO / SAML Applications.

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
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

ApplicationsApi apiInstance = new ApplicationsApi();
Application body = new Application(); // Application | 
String contentType = "contentType_example"; // String | 
String accept = "accept_example"; // String | 
String xOrgId = "xOrgId_example"; // String | 
try {
    Application result = apiInstance.applicationsPost(body, contentType, accept, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ApplicationsApi#applicationsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Application**](Application.md)|  | [optional]
 **contentType** | **String**|  | [optional]
 **accept** | **String**|  | [optional]
 **xOrgId** | **String**|  | [optional]

### Return type

[**Application**](Application.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="applicationsPut"></a>
# **applicationsPut**
> Application applicationsPut(id, body, contentType, accept, xOrgId)

Update an Application

The endpoint updates a SSO / SAML Application.

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
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

ApplicationsApi apiInstance = new ApplicationsApi();
String id = "id_example"; // String | 
Application body = new Application(); // Application | 
String contentType = "contentType_example"; // String | 
String accept = "accept_example"; // String | 
String xOrgId = "xOrgId_example"; // String | 
try {
    Application result = apiInstance.applicationsPut(id, body, contentType, accept, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ApplicationsApi#applicationsPut");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **body** | [**Application**](Application.md)|  | [optional]
 **contentType** | **String**|  | [optional]
 **accept** | **String**|  | [optional]
 **xOrgId** | **String**|  | [optional]

### Return type

[**Application**](Application.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

