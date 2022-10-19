# CustomEmailsApi

All URIs are relative to *https://console.jumpcloud.com/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**customEmailsCreate**](CustomEmailsApi.md#customEmailsCreate) | **POST** /customemails | Create custom email configuration
[**customEmailsDestroy**](CustomEmailsApi.md#customEmailsDestroy) | **DELETE** /customemails/{custom_email_type} | Delete custom email configuration
[**customEmailsGetTemplates**](CustomEmailsApi.md#customEmailsGetTemplates) | **GET** /customemail/templates | List custom email templates
[**customEmailsRead**](CustomEmailsApi.md#customEmailsRead) | **GET** /customemails/{custom_email_type} | Get custom email configuration
[**customEmailsUpdate**](CustomEmailsApi.md#customEmailsUpdate) | **PUT** /customemails/{custom_email_type} | Update custom email configuration

<a name="customEmailsCreate"></a>
# **customEmailsCreate**
> CustomEmail customEmailsCreate(body, xOrgId)

Create custom email configuration

Create the custom email configuration for the specified custom email type

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.CustomEmailsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

CustomEmailsApi apiInstance = new CustomEmailsApi();
CustomEmail body = new CustomEmail(); // CustomEmail | 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    CustomEmail result = apiInstance.customEmailsCreate(body, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CustomEmailsApi#customEmailsCreate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**CustomEmail**](CustomEmail.md)|  | [optional]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**CustomEmail**](CustomEmail.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="customEmailsDestroy"></a>
# **customEmailsDestroy**
> customEmailsDestroy(customEmailType, xOrgId)

Delete custom email configuration

Delete the custom email configuration for the specified custom email type

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.CustomEmailsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

CustomEmailsApi apiInstance = new CustomEmailsApi();
String customEmailType = "customEmailType_example"; // String | 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    apiInstance.customEmailsDestroy(customEmailType, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling CustomEmailsApi#customEmailsDestroy");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **customEmailType** | **String**|  |
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="customEmailsGetTemplates"></a>
# **customEmailsGetTemplates**
> List&lt;CustomEmailTemplate&gt; customEmailsGetTemplates()

List custom email templates

Get the list of custom email templates

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.CustomEmailsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

CustomEmailsApi apiInstance = new CustomEmailsApi();
try {
    List<CustomEmailTemplate> result = apiInstance.customEmailsGetTemplates();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CustomEmailsApi#customEmailsGetTemplates");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;CustomEmailTemplate&gt;**](CustomEmailTemplate.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="customEmailsRead"></a>
# **customEmailsRead**
> CustomEmail customEmailsRead(customEmailType, xOrgId)

Get custom email configuration

Get the custom email configuration for the specified custom email type

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.CustomEmailsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

CustomEmailsApi apiInstance = new CustomEmailsApi();
String customEmailType = "customEmailType_example"; // String | 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    CustomEmail result = apiInstance.customEmailsRead(customEmailType, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CustomEmailsApi#customEmailsRead");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **customEmailType** | **String**|  |
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**CustomEmail**](CustomEmail.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="customEmailsUpdate"></a>
# **customEmailsUpdate**
> CustomEmail customEmailsUpdate(customEmailType, body, xOrgId)

Update custom email configuration

Update the custom email configuration for the specified custom email type

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.CustomEmailsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

CustomEmailsApi apiInstance = new CustomEmailsApi();
String customEmailType = "customEmailType_example"; // String | 
CustomEmail body = new CustomEmail(); // CustomEmail | 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    CustomEmail result = apiInstance.customEmailsUpdate(customEmailType, body, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CustomEmailsApi#customEmailsUpdate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **customEmailType** | **String**|  |
 **body** | [**CustomEmail**](CustomEmail.md)|  | [optional]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**CustomEmail**](CustomEmail.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

