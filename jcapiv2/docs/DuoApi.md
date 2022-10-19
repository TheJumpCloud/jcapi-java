# DuoApi

All URIs are relative to *https://console.jumpcloud.com/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**duoAccountDelete**](DuoApi.md#duoAccountDelete) | **DELETE** /duo/accounts/{id} | Delete a Duo Account
[**duoAccountGet**](DuoApi.md#duoAccountGet) | **GET** /duo/accounts/{id} | Get a Duo Acount
[**duoAccountList**](DuoApi.md#duoAccountList) | **GET** /duo/accounts | List Duo Accounts
[**duoAccountPost**](DuoApi.md#duoAccountPost) | **POST** /duo/accounts | Create Duo Account
[**duoApplicationDelete**](DuoApi.md#duoApplicationDelete) | **DELETE** /duo/accounts/{account_id}/applications/{application_id} | Delete a Duo Application
[**duoApplicationGet**](DuoApi.md#duoApplicationGet) | **GET** /duo/accounts/{account_id}/applications/{application_id} | Get a Duo application
[**duoApplicationList**](DuoApi.md#duoApplicationList) | **GET** /duo/accounts/{account_id}/applications | List Duo Applications
[**duoApplicationPost**](DuoApi.md#duoApplicationPost) | **POST** /duo/accounts/{account_id}/applications | Create Duo Application
[**duoApplicationUpdate**](DuoApi.md#duoApplicationUpdate) | **PUT** /duo/accounts/{account_id}/applications/{application_id} | Update Duo Application

<a name="duoAccountDelete"></a>
# **duoAccountDelete**
> DuoAccount duoAccountDelete(id, xOrgId)

Delete a Duo Account

Removes the specified Duo account, an error will be returned if the account has some Duo application used in a protected resource.  #### Sample Request &#x60;&#x60;&#x60; curl -X DELETE https://console.jumpcloud.com/api/v2/duo/accounts/{id} \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.DuoApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

DuoApi apiInstance = new DuoApi();
String id = "id_example"; // String | ObjectID of the Duo Account
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    DuoAccount result = apiInstance.duoAccountDelete(id, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DuoApi#duoAccountDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| ObjectID of the Duo Account |
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**DuoAccount**](DuoAccount.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="duoAccountGet"></a>
# **duoAccountGet**
> DuoAccount duoAccountGet(id, xOrgId)

Get a Duo Acount

This endpoint returns a specific Duo account.  #### Sample Request &#x60;&#x60;&#x60; curl https://console.jumpcloud.com/api/v2/duo/accounts/{id} \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.DuoApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

DuoApi apiInstance = new DuoApi();
String id = "id_example"; // String | ObjectID of the Duo Account
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    DuoAccount result = apiInstance.duoAccountGet(id, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DuoApi#duoAccountGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| ObjectID of the Duo Account |
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**DuoAccount**](DuoAccount.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="duoAccountList"></a>
# **duoAccountList**
> List&lt;DuoAccount&gt; duoAccountList(xOrgId)

List Duo Accounts

This endpoint returns all the Duo accounts for your organization. Note: There can currently only be one Duo account for your organization.  #### Sample Request &#x60;&#x60;&#x60; curl https://console.jumpcloud.com/api/v2/duo/accounts \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.DuoApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

DuoApi apiInstance = new DuoApi();
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    List<DuoAccount> result = apiInstance.duoAccountList(xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DuoApi#duoAccountList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**List&lt;DuoAccount&gt;**](DuoAccount.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="duoAccountPost"></a>
# **duoAccountPost**
> DuoAccount duoAccountPost(xOrgId)

Create Duo Account

Registers a Duo account for an organization. Only one Duo account will be allowed, in case an organization has a Duo account already a 409 (Conflict) code will be returned.  #### Sample Request &#x60;&#x60;&#x60;   curl -X POST https://console.jumpcloud.com/api/v2/duo/accounts \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{}&#x27; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.DuoApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

DuoApi apiInstance = new DuoApi();
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    DuoAccount result = apiInstance.duoAccountPost(xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DuoApi#duoAccountPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**DuoAccount**](DuoAccount.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="duoApplicationDelete"></a>
# **duoApplicationDelete**
> DuoApplication duoApplicationDelete(accountId, applicationId, xOrgId)

Delete a Duo Application

Deletes the specified Duo application, an error will be returned if the application is used in a protected resource.  #### Sample Request &#x60;&#x60;&#x60;   curl -X DELETE https://console.jumpcloud.com/api/v2/duo/accounts/{ACCOUNT_ID}/applications/{APPLICATION_ID} \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27;&#x27; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.DuoApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

DuoApi apiInstance = new DuoApi();
String accountId = "accountId_example"; // String | 
String applicationId = "applicationId_example"; // String | 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    DuoApplication result = apiInstance.duoApplicationDelete(accountId, applicationId, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DuoApi#duoApplicationDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**|  |
 **applicationId** | **String**|  |
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**DuoApplication**](DuoApplication.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="duoApplicationGet"></a>
# **duoApplicationGet**
> DuoApplication duoApplicationGet(accountId, applicationId, xOrgId)

Get a Duo application

This endpoint returns a specific Duo application that is associated with the specified Duo account.  #### Sample Request &#x60;&#x60;&#x60;   curl https://console.jumpcloud.com/api/v2/duo/accounts/{ACCOUNT_ID}/applications/{APPLICATION_ID} \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.DuoApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

DuoApi apiInstance = new DuoApi();
String accountId = "accountId_example"; // String | 
String applicationId = "applicationId_example"; // String | 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    DuoApplication result = apiInstance.duoApplicationGet(accountId, applicationId, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DuoApi#duoApplicationGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**|  |
 **applicationId** | **String**|  |
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**DuoApplication**](DuoApplication.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="duoApplicationList"></a>
# **duoApplicationList**
> List&lt;DuoApplication&gt; duoApplicationList(accountId, xOrgId)

List Duo Applications

This endpoint returns all the Duo applications for the specified Duo account. Note: There can currently only be one Duo application for your organization.  #### Sample Request &#x60;&#x60;&#x60;   curl https://console.jumpcloud.com/api/v2/duo/accounts/{ACCOUNT_ID}/applications \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.DuoApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

DuoApi apiInstance = new DuoApi();
String accountId = "accountId_example"; // String | 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    List<DuoApplication> result = apiInstance.duoApplicationList(accountId, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DuoApi#duoApplicationList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**|  |
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**List&lt;DuoApplication&gt;**](DuoApplication.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="duoApplicationPost"></a>
# **duoApplicationPost**
> DuoApplication duoApplicationPost(accountId, body, xOrgId)

Create Duo Application

Creates a Duo application for your organization and the specified account.  #### Sample Request &#x60;&#x60;&#x60;   curl -X POST https://console.jumpcloud.com/api/v2/duo/accounts/{ACCOUNT_ID}/applications \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{     \&quot;name\&quot;: \&quot;Application Name\&quot;,     \&quot;apiHost\&quot;: \&quot;api-1234.duosecurity.com\&quot;,     \&quot;integrationKey\&quot;: \&quot;1234\&quot;,     \&quot;secretKey\&quot;: \&quot;5678\&quot;   }&#x27; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.DuoApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

DuoApi apiInstance = new DuoApi();
String accountId = "accountId_example"; // String | 
DuoApplicationReq body = new DuoApplicationReq(); // DuoApplicationReq | 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    DuoApplication result = apiInstance.duoApplicationPost(accountId, body, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DuoApi#duoApplicationPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**|  |
 **body** | [**DuoApplicationReq**](DuoApplicationReq.md)|  | [optional]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**DuoApplication**](DuoApplication.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="duoApplicationUpdate"></a>
# **duoApplicationUpdate**
> DuoApplication duoApplicationUpdate(accountId, applicationId, body, xOrgId)

Update Duo Application

Updates the specified Duo application.  #### Sample Request &#x60;&#x60;&#x60;   curl -X PUT https://console.jumpcloud.com/api/v2/duo/accounts/{ACCOUNT_ID}/applications/{APPLICATION_ID} \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{     \&quot;name\&quot;: \&quot;Application Name\&quot;,     \&quot;apiHost\&quot;: \&quot;api-1234.duosecurity.com\&quot;,     \&quot;integrationKey\&quot;: \&quot;1234\&quot;,     \&quot;secretKey\&quot;: \&quot;5678\&quot;   }&#x27; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.DuoApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

DuoApi apiInstance = new DuoApi();
String accountId = "accountId_example"; // String | 
String applicationId = "applicationId_example"; // String | 
DuoApplicationUpdateReq body = new DuoApplicationUpdateReq(); // DuoApplicationUpdateReq | 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    DuoApplication result = apiInstance.duoApplicationUpdate(accountId, applicationId, body, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DuoApi#duoApplicationUpdate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**|  |
 **applicationId** | **String**|  |
 **body** | [**DuoApplicationUpdateReq**](DuoApplicationUpdateReq.md)|  | [optional]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**DuoApplication**](DuoApplication.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

