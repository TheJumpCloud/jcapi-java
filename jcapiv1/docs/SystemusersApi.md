# SystemusersApi

All URIs are relative to *https://console.jumpcloud.com/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**sshkeyDelete**](SystemusersApi.md#sshkeyDelete) | **DELETE** /systemusers/{id}/sshkeys/{id} | Delete a system user&#39;s Public SSH Keys
[**sshkeyList**](SystemusersApi.md#sshkeyList) | **GET** /systemusers/{id}/sshkeys | List a system user&#39;s public SSH keys
[**sshkeyPost**](SystemusersApi.md#sshkeyPost) | **POST** /systemusers/{id}/sshkeys | Create a system user&#39;s Public SSH Key
[**systemusersDelete**](SystemusersApi.md#systemusersDelete) | **DELETE** /systemusers/{id} | Delete a system user
[**systemusersGet**](SystemusersApi.md#systemusersGet) | **GET** /systemusers/{id} | List a system user
[**systemusersList**](SystemusersApi.md#systemusersList) | **GET** /systemusers | List all system users
[**systemusersPost**](SystemusersApi.md#systemusersPost) | **POST** /systemusers | Create a system user
[**systemusersPut**](SystemusersApi.md#systemusersPut) | **PUT** /systemusers/{id} | Update a system user
[**systemusersResetmfa**](SystemusersApi.md#systemusersResetmfa) | **POST** /systemusers/{id}/resetmfa | Reset a system user&#39;s MFA token
[**systemusersSystemsBindingList**](SystemusersApi.md#systemusersSystemsBindingList) | **GET** /systemusers/{id}/systems | List system user binding
[**systemusersSystemsBindingPut**](SystemusersApi.md#systemusersSystemsBindingPut) | **PUT** /systemusers/{id}/systems | Update a system user binding
[**systemusersUnlock**](SystemusersApi.md#systemusersUnlock) | **POST** /systemusers/{id}/unlock | Unlock a system user


<a name="sshkeyDelete"></a>
# **sshkeyDelete**
> sshkeyDelete(id, contentType, accept, xOrgId)

Delete a system user&#39;s Public SSH Keys

This endpoint will delete a specific System User&#39;s SSH Key.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SystemusersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

SystemusersApi apiInstance = new SystemusersApi();
String id = "id_example"; // String | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
String xOrgId = ""; // String | 
try {
    apiInstance.sshkeyDelete(id, contentType, accept, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemusersApi#sshkeyDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json; charset=utf-8

<a name="sshkeyList"></a>
# **sshkeyList**
> Sshkeylist sshkeyList(id, contentType, accept, xOrgId)

List a system user&#39;s public SSH keys

This endpoint will return a specific System User&#39;s public SSH key.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SystemusersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

SystemusersApi apiInstance = new SystemusersApi();
String id = "id_example"; // String | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
String xOrgId = ""; // String | 
try {
    Sshkeylist result = apiInstance.sshkeyList(id, contentType, accept, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemusersApi#sshkeyList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

[**Sshkeylist**](Sshkeylist.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json; charset=utf-8

<a name="sshkeyPost"></a>
# **sshkeyPost**
> Sshkeylist sshkeyPost(id, contentType, accept, body, xOrgId)

Create a system user&#39;s Public SSH Key

This endpoint will create a specific System User&#39;s Public SSH Key.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SystemusersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

SystemusersApi apiInstance = new SystemusersApi();
String id = "id_example"; // String | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Sshkeypost body = new Sshkeypost(); // Sshkeypost | 
String xOrgId = ""; // String | 
try {
    Sshkeylist result = apiInstance.sshkeyPost(id, contentType, accept, body, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemusersApi#sshkeyPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **body** | [**Sshkeypost**](Sshkeypost.md)|  | [optional]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

[**Sshkeylist**](Sshkeylist.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json; charset=utf-8

<a name="systemusersDelete"></a>
# **systemusersDelete**
> Systemuserreturn systemusersDelete(id, contentType, accept, xOrgId)

Delete a system user

This endpoint allows you to delete a particular system user.  #### Sample Request &#x60;&#x60;&#x60; curl -X DELETE https://console.jumpcloud.com/api/systemusers/{UserID} \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;  &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SystemusersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

SystemusersApi apiInstance = new SystemusersApi();
String id = "id_example"; // String | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
String xOrgId = ""; // String | 
try {
    Systemuserreturn result = apiInstance.systemusersDelete(id, contentType, accept, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemusersApi#systemusersDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

[**Systemuserreturn**](Systemuserreturn.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json; charset=utf-8

<a name="systemusersGet"></a>
# **systemusersGet**
> Systemuserreturn systemusersGet(id, contentType, accept, fields, filter, xOrgId)

List a system user

This endpoint returns a particular System User.  #### Sample Request  &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/systemusers/{UserID} \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SystemusersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

SystemusersApi apiInstance = new SystemusersApi();
String id = "id_example"; // String | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
String fields = ""; // String | Use a space seperated string of field parameters to include the data in the response. If omitted the default list of fields will be returned. 
String filter = "filter_example"; // String | A filter to apply to the query.
String xOrgId = ""; // String | 
try {
    Systemuserreturn result = apiInstance.systemusersGet(id, contentType, accept, fields, filter, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemusersApi#systemusersGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **fields** | **String**| Use a space seperated string of field parameters to include the data in the response. If omitted the default list of fields will be returned.  | [optional] [default to ]
 **filter** | **String**| A filter to apply to the query. | [optional]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

[**Systemuserreturn**](Systemuserreturn.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json; charset=utf-8

<a name="systemusersList"></a>
# **systemusersList**
> Systemuserslist systemusersList(contentType, accept, limit, skip, sort, fields, xOrgId, search, filter)

List all system users

This endpoint returns all systemusers.  #### Sample Request  &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/systemusers \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;  &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SystemusersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

SystemusersApi apiInstance = new SystemusersApi();
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once.
Integer skip = 0; // Integer | The offset into the records to return.
String sort = ""; // String | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
String fields = ""; // String | The comma separated fields included in the returned records. If omitted the default list of fields will be returned. 
String xOrgId = ""; // String | 
String search = "search_example"; // String | A nested object containing a string `searchTerm` and a list of `fields` to search on.
String filter = "filter_example"; // String | A filter to apply to the query.
try {
    Systemuserslist result = apiInstance.systemusersList(contentType, accept, limit, skip, sort, fields, xOrgId, search, filter);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemusersApi#systemusersList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **sort** | **String**| The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  | [optional] [default to ]
 **fields** | **String**| The comma separated fields included in the returned records. If omitted the default list of fields will be returned.  | [optional] [default to ]
 **xOrgId** | **String**|  | [optional] [default to ]
 **search** | **String**| A nested object containing a string &#x60;searchTerm&#x60; and a list of &#x60;fields&#x60; to search on. | [optional]
 **filter** | **String**| A filter to apply to the query. | [optional]

### Return type

[**Systemuserslist**](Systemuserslist.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json; charset=utf-8

<a name="systemusersPost"></a>
# **systemusersPost**
> Systemuserreturn systemusersPost(contentType, accept, body, xOrgId)

Create a system user

This endpoint allows you to create a new system user.  #### Sample Request  &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/systemusers \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{  \&quot;username\&quot;:\&quot;{username}\&quot;,  \&quot;email\&quot;:\&quot;{email_address}\&quot;,  \&quot;firstname\&quot;:\&quot;{Name}\&quot;,  \&quot;lastname\&quot;:\&quot;{Name}\&quot; }&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SystemusersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

SystemusersApi apiInstance = new SystemusersApi();
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Systemuserputpost body = new Systemuserputpost(); // Systemuserputpost | 
String xOrgId = ""; // String | 
try {
    Systemuserreturn result = apiInstance.systemusersPost(contentType, accept, body, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemusersApi#systemusersPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **body** | [**Systemuserputpost**](Systemuserputpost.md)|  | [optional]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

[**Systemuserreturn**](Systemuserreturn.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json; charset=utf-8

<a name="systemusersPut"></a>
# **systemusersPut**
> Systemuserreturn systemusersPut(id, contentType, accept, body, xOrgId)

Update a system user

This endpoint allows you to update a system user.  #### Sample Request  &#x60;&#x60;&#x60; curl -X PUT https://console.jumpcloud.com/api/systemusers/{UserID} \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{  \&quot;email\&quot;:\&quot;{email_address}\&quot;,  \&quot;firstname\&quot;:\&quot;{Name}\&quot;,  \&quot;lastname\&quot;:\&quot;{Name}\&quot; }&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SystemusersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

SystemusersApi apiInstance = new SystemusersApi();
String id = "id_example"; // String | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Systemuserput body = new Systemuserput(); // Systemuserput | 
String xOrgId = ""; // String | 
try {
    Systemuserreturn result = apiInstance.systemusersPut(id, contentType, accept, body, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemusersApi#systemusersPut");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **body** | [**Systemuserput**](Systemuserput.md)|  | [optional]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

[**Systemuserreturn**](Systemuserreturn.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json; charset=utf-8

<a name="systemusersResetmfa"></a>
# **systemusersResetmfa**
> String systemusersResetmfa(id, xApiKey, body, xOrgId)

Reset a system user&#39;s MFA token

This endpoint allows you to reset the MFA TOTP token for a specified system user and put them in an MFA enrollment period. This will result in the user being prompted to setup MFA when logging into userportal. Please be aware that if the user does not complete MFA setup before the &#x60;exclusionUntil&#x60; date, they will be locked out of any resources that require MFA.  Please refer to our [Knowledge Base Article](https://support.jumpcloud.com/customer/en/portal/articles/2959138-using-multifactor-authentication-with-jumpcloud) on setting up MFA for more information.   #### Sample Request  &#x60;&#x60;&#x60; curl -X POST \\   https://console.jumpcloud.com/api/systemusers/{UserID}/resetmfa \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -d &#39;{\&quot;exclusion\&quot;: true, \&quot;exclusionUntil\&quot;: \&quot;{date-time}\&quot;}&#39;     &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SystemusersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

SystemusersApi apiInstance = new SystemusersApi();
String id = "id_example"; // String | 
String xApiKey = "xApiKey_example"; // String | 
Body1 body = new Body1(); // Body1 | 
String xOrgId = ""; // String | 
try {
    String result = apiInstance.systemusersResetmfa(id, xApiKey, body, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemusersApi#systemusersResetmfa");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **xApiKey** | **String**|  |
 **body** | [**Body1**](Body1.md)|  | [optional]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

**String**

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json; charset=utf-8

<a name="systemusersSystemsBindingList"></a>
# **systemusersSystemsBindingList**
> Object systemusersSystemsBindingList(id, contentType, accept, fields, limit, skip, sort, filter, xOrgId)

List system user binding

Hidden as Tags is deprecated  Adds or removes a system binding for a user.   This endpoint is only used for users still using JumpCloud Tags. If you are using JumpCloud Groups please refer to the documentation found [here](https://docs.jumpcloud.com/2.0/systems/manage-associations-of-a-system).   List system bindings for a specific system user in a system and user binding format.  ### Examples  #### List system bindings for specific system user  &#x60;&#x60;&#x60; curl \\   -H &#39;Content-Type: application/json&#39; \\   -H \&quot;x-api-key: [YOUR_API_KEY_HERE]\&quot; \\   \&quot;https://console.jumpcloud.com/api/systemusers/[SYSTEM_USER_ID_HERE]/systems\&quot; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SystemusersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

SystemusersApi apiInstance = new SystemusersApi();
String id = "id_example"; // String | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
String fields = ""; // String | Use a space seperated string of field parameters to include the data in the response. If omitted the default list of fields will be returned. 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String sort = ""; // String | Use space separated sort parameters to sort the collection. Default sort is ascending. Prefix with `-` to sort descending. 
String filter = "filter_example"; // String | A filter to apply to the query.
String xOrgId = ""; // String | 
try {
    Object result = apiInstance.systemusersSystemsBindingList(id, contentType, accept, fields, limit, skip, sort, filter, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemusersApi#systemusersSystemsBindingList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **fields** | **String**| Use a space seperated string of field parameters to include the data in the response. If omitted the default list of fields will be returned.  | [optional] [default to ]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **sort** | **String**| Use space separated sort parameters to sort the collection. Default sort is ascending. Prefix with &#x60;-&#x60; to sort descending.  | [optional] [default to ]
 **filter** | **String**| A filter to apply to the query. | [optional]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

**Object**

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json; charset=utf-8

<a name="systemusersSystemsBindingPut"></a>
# **systemusersSystemsBindingPut**
> Usersystembinding systemusersSystemsBindingPut(id, contentType, accept, body, xOrgId)

Update a system user binding

Hidden as Tags is deprecated  Adds or removes a system binding for a user.   This endpoint is only used for users still using JumpCloud Tags. If you are using JumpCloud Groups please refer to the documentation found [here](https://docs.jumpcloud.com/2.0/systems/manage-associations-of-a-system).  ### Example  #### Add (or remove) system to system user  &#x60;&#x60;&#x60; curl \\   -d &#39;{ \&quot;add\&quot;: [\&quot;[SYSTEM_ID_TO_ADD_HERE]\&quot;], \&quot;remove\&quot;: [\&quot;[SYSTEM_ID_TO_REMOVE_HERE]\&quot;] }&#39; \\   -X PUT \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;Accept: application/json&#39; \\   -H \&quot;x-api-key: [YOUR_API_KEY_HERE]\&quot; \\   \&quot;https://console.jumpcloud.com/api/systemusers/[SYSTEM_USER_ID_HERE]/systems\&quot; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SystemusersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

SystemusersApi apiInstance = new SystemusersApi();
String id = "id_example"; // String | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Usersystembindingsput body = new Usersystembindingsput(); // Usersystembindingsput | 
String xOrgId = ""; // String | 
try {
    Usersystembinding result = apiInstance.systemusersSystemsBindingPut(id, contentType, accept, body, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemusersApi#systemusersSystemsBindingPut");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **body** | [**Usersystembindingsput**](Usersystembindingsput.md)|  | [optional]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

[**Usersystembinding**](Usersystembinding.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json; charset=utf-8

<a name="systemusersUnlock"></a>
# **systemusersUnlock**
> systemusersUnlock(id, xOrgId)

Unlock a system user

This endpoint allows you to unlock a user&#39;s account.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SystemusersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

SystemusersApi apiInstance = new SystemusersApi();
String id = "id_example"; // String | 
String xOrgId = ""; // String | 
try {
    apiInstance.systemusersUnlock(id, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemusersApi#systemusersUnlock");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json; charset=utf-8

