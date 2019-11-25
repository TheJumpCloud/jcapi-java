# SystemsApi

All URIs are relative to *https://console.jumpcloud.com/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**systemsDelete**](SystemsApi.md#systemsDelete) | **DELETE** /systems/{id} | Delete a System
[**systemsGet**](SystemsApi.md#systemsGet) | **GET** /systems/{id} | List an individual system
[**systemsList**](SystemsApi.md#systemsList) | **GET** /systems | List All Systems
[**systemsPut**](SystemsApi.md#systemsPut) | **PUT** /systems/{id} | Update a system
[**systemsSystemusersBindingList**](SystemsApi.md#systemsSystemusersBindingList) | **GET** /systems/{id}/systemusers | List system user bindings
[**systemsSystemusersBindingPut**](SystemsApi.md#systemsSystemusersBindingPut) | **PUT** /systems/{id}/systemusers | Update a system&#39;s or user&#39;s binding


<a name="systemsDelete"></a>
# **systemsDelete**
> System systemsDelete(id, contentType, accept, date, authorization, xOrgId)

Delete a System

This endpoint allows you to delete a system. This command will cause the system to uninstall the JumpCloud agent from its self which can can take about a minute. If the system is not connected to JumpCloud the system record will simply be removed.  #### Sample Request &#x60;&#x60;&#x60; curl -X DELETE https://console.jumpcloud.com/api/systems/{SystemID} \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;   &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SystemsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

SystemsApi apiInstance = new SystemsApi();
String id = "id_example"; // String | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
String date = "date_example"; // String | Current date header for the System Context API
String authorization = "authorization_example"; // String | Authorization header for the System Context API
String xOrgId = ""; // String | 
try {
    System result = apiInstance.systemsDelete(id, contentType, accept, date, authorization, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemsApi#systemsDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **date** | **String**| Current date header for the System Context API | [optional]
 **authorization** | **String**| Authorization header for the System Context API | [optional]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

[**System**](System.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="systemsGet"></a>
# **systemsGet**
> System systemsGet(id, contentType, accept, fields, filter, date, authorization, xOrgId)

List an individual system

This endpoint returns an individual system.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/systems/{SystemID} \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;   &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SystemsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

SystemsApi apiInstance = new SystemsApi();
String id = "id_example"; // String | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
String fields = ""; // String | Use a space seperated string of field parameters to include the data in the response. If omitted, the default list of fields will be returned. 
String filter = "filter_example"; // String | A filter to apply to the query.
String date = "date_example"; // String | Current date header for the System Context API
String authorization = "authorization_example"; // String | Authorization header for the System Context API
String xOrgId = ""; // String | 
try {
    System result = apiInstance.systemsGet(id, contentType, accept, fields, filter, date, authorization, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemsApi#systemsGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **fields** | **String**| Use a space seperated string of field parameters to include the data in the response. If omitted, the default list of fields will be returned.  | [optional] [default to ]
 **filter** | **String**| A filter to apply to the query. | [optional]
 **date** | **String**| Current date header for the System Context API | [optional]
 **authorization** | **String**| Authorization header for the System Context API | [optional]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

[**System**](System.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="systemsList"></a>
# **systemsList**
> Systemslist systemsList(contentType, accept, fields, limit, xOrgId, search, skip, sort, filter)

List All Systems

This endpoint returns all Systems.  #### Sample Requests &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/systems \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;  &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SystemsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

SystemsApi apiInstance = new SystemsApi();
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
String fields = ""; // String | Use a space seperated string of field parameters to include the data in the response. If omitted, the default list of fields will be returned. 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = ""; // String | 
String search = "search_example"; // String | A nested object containing a string `searchTerm` and a list of `fields` to search on.
Integer skip = 0; // Integer | The offset into the records to return.
String sort = ""; // String | Use space separated sort parameters to sort the collection. Default sort is ascending. Prefix with `-` to sort descending. 
String filter = "filter_example"; // String | A filter to apply to the query.
try {
    Systemslist result = apiInstance.systemsList(contentType, accept, fields, limit, xOrgId, search, skip, sort, filter);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemsApi#systemsList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **fields** | **String**| Use a space seperated string of field parameters to include the data in the response. If omitted, the default list of fields will be returned.  | [optional] [default to ]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**|  | [optional] [default to ]
 **search** | **String**| A nested object containing a string &#x60;searchTerm&#x60; and a list of &#x60;fields&#x60; to search on. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **sort** | **String**| Use space separated sort parameters to sort the collection. Default sort is ascending. Prefix with &#x60;-&#x60; to sort descending.  | [optional] [default to ]
 **filter** | **String**| A filter to apply to the query. | [optional]

### Return type

[**Systemslist**](Systemslist.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="systemsPut"></a>
# **systemsPut**
> System systemsPut(id, contentType, accept, body, date, authorization, xOrgId)

Update a system

This endpoint allows you to update a system.  #### Sample Request  &#x60;&#x60;&#x60; curl -X PUT https://console.jumpcloud.com/api/systems/{SystemID} \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{  \&quot;displayName\&quot;:\&quot;Name_Update\&quot;,  \&quot;allowSshPasswordAuthentication\&quot;:\&quot;true\&quot;,  \&quot;allowSshRootLogin\&quot;:\&quot;true\&quot;,  \&quot;allowMultiFactorAuthentication\&quot;:\&quot;true\&quot;,  \&quot;allowPublicKeyAuthentication\&quot;:\&quot;false\&quot; }&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SystemsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

SystemsApi apiInstance = new SystemsApi();
String id = "id_example"; // String | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Systemput body = new Systemput(); // Systemput | 
String date = "date_example"; // String | Current date header for the System Context API
String authorization = "authorization_example"; // String | Authorization header for the System Context API
String xOrgId = ""; // String | 
try {
    System result = apiInstance.systemsPut(id, contentType, accept, body, date, authorization, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemsApi#systemsPut");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **body** | [**Systemput**](Systemput.md)|  | [optional]
 **date** | **String**| Current date header for the System Context API | [optional]
 **authorization** | **String**| Authorization header for the System Context API | [optional]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

[**System**](System.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="systemsSystemusersBindingList"></a>
# **systemsSystemusersBindingList**
> Systemuserbinding systemsSystemusersBindingList(id, contentType, accept, fields, limit, skip, sort, filter, xOrgId)

List system user bindings

Hidden as Tags is deprecated  List system user bindings for a specific system in a system and user binding format.  This endpoint is only used for users still using JumpCloud Tags. If you are using JumpCloud Groups please refer to the documentation found [here](https://docs.jumpcloud.com/2.0/systems/manage-associations-of-a-system).  #### Sample Request  *List system user bindings for specific system*  &#x60;&#x60;&#x60; curl -X https://console.jumpcloud.com/api/systems/{SystemID}/systemusers\\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   \&quot; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SystemsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

SystemsApi apiInstance = new SystemsApi();
String id = "id_example"; // String | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
String fields = ""; // String | Use a space seperated string of field parameters to include the data in the response. If omitted, the default list of fields will be returned. 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String sort = ""; // String | Use space separated sort parameters to sort the collection. Default sort is ascending. Prefix with `-` to sort descending. 
String filter = "filter_example"; // String | A filter to apply to the query.
String xOrgId = ""; // String | 
try {
    Systemuserbinding result = apiInstance.systemsSystemusersBindingList(id, contentType, accept, fields, limit, skip, sort, filter, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemsApi#systemsSystemusersBindingList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **fields** | **String**| Use a space seperated string of field parameters to include the data in the response. If omitted, the default list of fields will be returned.  | [optional] [default to ]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **sort** | **String**| Use space separated sort parameters to sort the collection. Default sort is ascending. Prefix with &#x60;-&#x60; to sort descending.  | [optional] [default to ]
 **filter** | **String**| A filter to apply to the query. | [optional]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

[**Systemuserbinding**](Systemuserbinding.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="systemsSystemusersBindingPut"></a>
# **systemsSystemusersBindingPut**
> systemsSystemusersBindingPut(id, contentType, accept, body, xOrgId)

Update a system&#39;s or user&#39;s binding

Hidden as Tags is deprecated  Adds or removes a user binding for a system.  This endpoint is only used for users still using JumpCloud Tags. If you are using JumpCloud Groups please refer to the documentation found [here](https://docs.jumpcloud.com/2.0/systems/manage-associations-of-a-system).  #### Sample Request  *Add (or remove) a system user to (from) a system*  &#x60;&#x60;&#x60; curl \\   -d &#39;{ \&quot;add\&quot;: [\&quot;[SYSTEM_USER_ID_TO_ADD_HERE]\&quot;], \&quot;remove\&quot;: [\&quot;[SYSTEM_USER_ID_TO_REMOVE_HERE]\&quot;] }&#39; \\   -X PUT \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;Accept: application/json&#39; \\   -H \&quot;x-api-key: [YOUR_API_KEY_HERE]\&quot; \\   \&quot;https://console.jumpcloud.com/api/systems/[SYSTEM_ID_HERE]/systemusers

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SystemsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

SystemsApi apiInstance = new SystemsApi();
String id = "id_example"; // String | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Systemuserbindingsput body = new Systemuserbindingsput(); // Systemuserbindingsput | 
String xOrgId = ""; // String | 
try {
    apiInstance.systemsSystemusersBindingPut(id, contentType, accept, body, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemsApi#systemsSystemusersBindingPut");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **body** | [**Systemuserbindingsput**](Systemuserbindingsput.md)|  | [optional]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

