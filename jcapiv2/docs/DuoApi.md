# DuoApi

All URIs are relative to *https://console.jumpcloud.com/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**duoAccountGet**](DuoApi.md#duoAccountGet) | **GET** /duo/accounts/{id} | Get a Duo Acount
[**duoAccountList**](DuoApi.md#duoAccountList) | **GET** /duo/accounts | List Duo Acounts
[**duoAccountPost**](DuoApi.md#duoAccountPost) | **POST** /duo/accounts | Create Duo Account
[**duoApplicationGet**](DuoApi.md#duoApplicationGet) | **GET** /duo/accounts/{account_id}/applications/{application_id} | Get a Duo application
[**duoApplicationList**](DuoApi.md#duoApplicationList) | **GET** /duo/accounts/{account_id}/applications | List Duo Applications
[**duoApplicationPost**](DuoApi.md#duoApplicationPost) | **POST** /duo/accounts/{account_id}/applications | Create Duo Application


<a name="duoAccountGet"></a>
# **duoAccountGet**
> DuoAccount duoAccountGet(id, contentType, accept, xOrgId)

Get a Duo Acount

#### Sample Request &#x60;&#x60;&#x60; curl https://console.jumpcloud.com/api/v2/duo/accounts/{id} \\   -H &#39;accept: application/json&#39; \\   -H &#39;content-type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\ &#x60;&#x60;&#x60;

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
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

DuoApi apiInstance = new DuoApi();
String id = "id_example"; // String | ObjectID of the Duo Account
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
String xOrgId = ""; // String | 
try {
    DuoAccount result = apiInstance.duoAccountGet(id, contentType, accept, xOrgId);
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
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

[**DuoAccount**](DuoAccount.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="duoAccountList"></a>
# **duoAccountList**
> List&lt;DuoAccount&gt; duoAccountList(xApiKey, contentType, accept, xOrgId)

List Duo Acounts

#### Sample Request &#x60;&#x60;&#x60; curl https://console.jumpcloud.com/api/v2/duo/accounts \\   -H &#39;accept: application/json&#39; \\   -H &#39;content-type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\ &#x60;&#x60;&#x60;

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
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

DuoApi apiInstance = new DuoApi();
String xApiKey = "xApiKey_example"; // String | 
String contentType = "application/json"; // String | 
String accept = "accept_example"; // String | 
String xOrgId = "xOrgId_example"; // String | 
try {
    List<DuoAccount> result = apiInstance.duoAccountList(xApiKey, contentType, accept, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DuoApi#duoAccountList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **xApiKey** | **String**|  |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [optional]
 **xOrgId** | **String**|  | [optional]

### Return type

[**List&lt;DuoAccount&gt;**](DuoAccount.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="duoAccountPost"></a>
# **duoAccountPost**
> DuoAccount duoAccountPost(contentType, accept, body, xOrgId)

Create Duo Account

Registers a Duo account for an organization. Only one Duo account will be allowed, in case an organization has a Duo account already a 409 (Conflict) code will be returned.  #### Sample Request &#x60;&#x60;&#x60;   curl -X POST https://console.jumpcloud.com/api/v2/duo/accounts \\   -H &#39;accept: application/json&#39; \\   -H &#39;content-type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{     \&quot;registrationApplication\&quot;: {       \&quot;apiHost\&quot;: \&quot;api-1234.duosecurity.com\&quot;,       \&quot;integrationKey\&quot;: \&quot;1234\&quot;,       \&quot;secretKey\&quot;: \&quot;5678\&quot;     }   }&#39; &#x60;&#x60;&#x60;

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
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

DuoApi apiInstance = new DuoApi();
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
DuoRegistrationApplicationReq body = new DuoRegistrationApplicationReq(); // DuoRegistrationApplicationReq | 
String xOrgId = ""; // String | 
try {
    DuoAccount result = apiInstance.duoAccountPost(contentType, accept, body, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DuoApi#duoAccountPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **body** | [**DuoRegistrationApplicationReq**](DuoRegistrationApplicationReq.md)|  | [optional]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

[**DuoAccount**](DuoAccount.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="duoApplicationGet"></a>
# **duoApplicationGet**
> DuoApplication duoApplicationGet(accountId, applicationId, contentType, accept, xOrgId)

Get a Duo application

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DuoApi;


DuoApi apiInstance = new DuoApi();
String accountId = "accountId_example"; // String | 
String applicationId = "applicationId_example"; // String | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
String xOrgId = ""; // String | 
try {
    DuoApplication result = apiInstance.duoApplicationGet(accountId, applicationId, contentType, accept, xOrgId);
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
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

[**DuoApplication**](DuoApplication.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="duoApplicationList"></a>
# **duoApplicationList**
> List&lt;DuoApplication&gt; duoApplicationList(accountId, contentType, accept, xOrgId)

List Duo Applications

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DuoApi;


DuoApi apiInstance = new DuoApi();
String accountId = "accountId_example"; // String | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
String xOrgId = ""; // String | 
try {
    List<DuoApplication> result = apiInstance.duoApplicationList(accountId, contentType, accept, xOrgId);
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
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

[**List&lt;DuoApplication&gt;**](DuoApplication.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="duoApplicationPost"></a>
# **duoApplicationPost**
> DuoApplication duoApplicationPost(accountId, contentType, accept, body, xOrgId)

Create Duo Application

Creates a Duo application for an organization and its account.  #### Sample Request &#x60;&#x60;&#x60;   curl -X POST https://console.jumpcloud.com/api/v2/duo/accounts/obj-id-123/applications \\   -H &#39;accept: application/json&#39; \\   -H &#39;content-type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{     \&quot;name\&quot;: \&quot;Application Name\&quot;,     \&quot;apiHost\&quot;: \&quot;api-1234.duosecurity.com\&quot;,     \&quot;integrationKey\&quot;: \&quot;1234\&quot;,     \&quot;secretKey\&quot;: \&quot;5678\&quot;   }&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DuoApi;


DuoApi apiInstance = new DuoApi();
String accountId = "accountId_example"; // String | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
DuoApplicationReq body = new DuoApplicationReq(); // DuoApplicationReq | 
String xOrgId = ""; // String | 
try {
    DuoApplication result = apiInstance.duoApplicationPost(accountId, contentType, accept, body, xOrgId);
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
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **body** | [**DuoApplicationReq**](DuoApplicationReq.md)|  | [optional]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

[**DuoApplication**](DuoApplication.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

