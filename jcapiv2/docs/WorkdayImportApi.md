# WorkdayImportApi

All URIs are relative to *https://console.jumpcloud.com/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**workdaysAuthorize**](WorkdayImportApi.md#workdaysAuthorize) | **POST** /workdays/{workday_id}/auth | Authorize Workday
[**workdaysDeauthorize**](WorkdayImportApi.md#workdaysDeauthorize) | **DELETE** /workdays/{workday_id}/auth | Deauthorize Workday
[**workdaysDelete**](WorkdayImportApi.md#workdaysDelete) | **DELETE** /workdays/{id} | Delete Workday
[**workdaysGet**](WorkdayImportApi.md#workdaysGet) | **GET** /workdays/{id} | Get Workday
[**workdaysImport**](WorkdayImportApi.md#workdaysImport) | **POST** /workdays/{workday_id}/import | Workday Import
[**workdaysImportresults**](WorkdayImportApi.md#workdaysImportresults) | **GET** /workdays/{id}/import/{job_id}/results | List Import Results
[**workdaysList**](WorkdayImportApi.md#workdaysList) | **GET** /workdays | List Workdays
[**workdaysPost**](WorkdayImportApi.md#workdaysPost) | **POST** /workdays | Create new Workday
[**workdaysPut**](WorkdayImportApi.md#workdaysPut) | **PUT** /workdays/{id} | Update Workday
[**workdaysSettings**](WorkdayImportApi.md#workdaysSettings) | **GET** /workdays/settings | Get Workday Settings (incomplete)
[**workdaysWorkers**](WorkdayImportApi.md#workdaysWorkers) | **GET** /workdays/{workday_id}/workers | List Workday Workers


<a name="workdaysAuthorize"></a>
# **workdaysAuthorize**
> workdaysAuthorize(workdayId, contentType, accept, body, xOrgId)

Authorize Workday

This endpoint adds an authorization method to a workday instance.  You must supply a username and password for &#x60;Basic Authentication&#x60; that is the same as your WorkDay Integrator System User.  Failure to provide these credentials  will result in the request being rejected.  Currently &#x60;O-Auth&#x60; isn&#39;t a supported authentication protocol for WorkDay, but will be in the future.  #### Sample Request  &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/workdays/{WorkDayID}/auth \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{  \&quot;auth\&quot;:{    \&quot;basic\&quot;: {   \&quot;username\&quot;: \&quot;someDeveloper\&quot;,      \&quot;password\&quot;: \&quot;notTheRealPassword\&quot;     }  } }&#39;  &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.WorkdayImportApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

WorkdayImportApi apiInstance = new WorkdayImportApi();
String workdayId = "workdayId_example"; // String | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
AuthInputObject body = new AuthInputObject(); // AuthInputObject | 
String xOrgId = "<<your org id>>"; // String | 
try {
    apiInstance.workdaysAuthorize(workdayId, contentType, accept, body, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling WorkdayImportApi#workdaysAuthorize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **workdayId** | **String**|  |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **body** | [**AuthInputObject**](AuthInputObject.md)|  | [optional]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="workdaysDeauthorize"></a>
# **workdaysDeauthorize**
> workdaysDeauthorize(workdayId, contentType, accept, xOrgId)

Deauthorize Workday

Removes any and all authorization methods from the workday instance  ##### Sample Request &#x60;&#x60;&#x60; curl -X DELETE https://console.jumpcloud.com/api/v2/workdays/{WorkDayID}/auth \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.WorkdayImportApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

WorkdayImportApi apiInstance = new WorkdayImportApi();
String workdayId = "workdayId_example"; // String | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
String xOrgId = "<<your org id>>"; // String | 
try {
    apiInstance.workdaysDeauthorize(workdayId, contentType, accept, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling WorkdayImportApi#workdaysDeauthorize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **workdayId** | **String**|  |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="workdaysDelete"></a>
# **workdaysDelete**
> Object workdaysDelete(id, contentType, accept, xOrgId)

Delete Workday

This endpoint allows you to delete an instance of Workday.   **This functionality is currently not enable for users.**

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.WorkdayImportApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

WorkdayImportApi apiInstance = new WorkdayImportApi();
String id = "id_example"; // String | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
String xOrgId = "<<your org id>>"; // String | 
try {
    Object result = apiInstance.workdaysDelete(id, contentType, accept, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WorkdayImportApi#workdaysDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

**Object**

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="workdaysGet"></a>
# **workdaysGet**
> WorkdayOutput workdaysGet(id, contentType, accept, xOrgId)

Get Workday

This endpoint will return  all the available information about an instance of Workday.  #### Sample Request  &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/workdays/ \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;   &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.WorkdayImportApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

WorkdayImportApi apiInstance = new WorkdayImportApi();
String id = "id_example"; // String | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
String xOrgId = "<<your org id>>"; // String | 
try {
    WorkdayOutput result = apiInstance.workdaysGet(id, contentType, accept, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WorkdayImportApi#workdaysGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**WorkdayOutput**](WorkdayOutput.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="workdaysImport"></a>
# **workdaysImport**
> JobId workdaysImport(workdayId, contentType, accept, body, xOrgId)

Workday Import

The endpoint allows you to create a Workday Import request.  #### Sample Request  &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/workdays/{WorkdayID}/import \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;[  {   \&quot;email\&quot;:\&quot;{email}\&quot;,   \&quot;firstname\&quot;:\&quot;{firstname}\&quot;,   \&quot;lastname\&quot;:\&quot;{firstname}\&quot;,   \&quot;username\&quot;:\&quot;{username}\&quot;,   \&quot;attributes\&quot;:[    {\&quot;name\&quot;:\&quot;EmployeeID\&quot;,\&quot;value\&quot;:\&quot;0000\&quot;},    {\&quot;name\&quot;:\&quot;WorkdayID\&quot;,\&quot;value\&quot;:\&quot;name.name\&quot;}    ]     } ] &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.WorkdayImportApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

WorkdayImportApi apiInstance = new WorkdayImportApi();
String workdayId = "workdayId_example"; // String | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
List<BulkUserCreate> body = Arrays.asList(new BulkUserCreate()); // List<BulkUserCreate> | 
String xOrgId = "<<your org id>>"; // String | 
try {
    JobId result = apiInstance.workdaysImport(workdayId, contentType, accept, body, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WorkdayImportApi#workdaysImport");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **workdayId** | **String**|  |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **body** | [**List&lt;BulkUserCreate&gt;**](BulkUserCreate.md)|  | [optional]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**JobId**](JobId.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="workdaysImportresults"></a>
# **workdaysImportresults**
> List&lt;JobWorkresult&gt; workdaysImportresults(id, jobId, contentType, accept, limit, skip, xOrgId)

List Import Results

This endpoint provides a list of job results from the workday import and will contain all imported data from Workday.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/workdays/{WorkdayID}/import/{ImportJobID}/results \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.WorkdayImportApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

WorkdayImportApi apiInstance = new WorkdayImportApi();
String id = "id_example"; // String | 
String jobId = "jobId_example"; // String | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<JobWorkresult> result = apiInstance.workdaysImportresults(id, jobId, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WorkdayImportApi#workdaysImportresults");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **jobId** | **String**|  |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;JobWorkresult&gt;**](JobWorkresult.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="workdaysList"></a>
# **workdaysList**
> List&lt;WorkdayOutput&gt; workdaysList(contentType, accept, fields, limit, skip, sort, filter, xOrgId)

List Workdays

This endpoint will return  all the available information about all your instances of Workday.  ##### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/workdays/ \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;   &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.WorkdayImportApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

WorkdayImportApi apiInstance = new WorkdayImportApi();
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
List<String> fields = Arrays.asList("fields_example"); // List<String> | The comma separated fields included in the returned records. If omitted the default list of fields will be returned. 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> sort = Arrays.asList("sort_example"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
List<String> filter = Arrays.asList("filter_example"); // List<String> | Supported operators are: eq, ne, gt, ge, lt, le, between, search, in
String xOrgId = "<<your org id>>"; // String | 
try {
    List<WorkdayOutput> result = apiInstance.workdaysList(contentType, accept, fields, limit, skip, sort, filter, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WorkdayImportApi#workdaysList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **fields** | [**List&lt;String&gt;**](String.md)| The comma separated fields included in the returned records. If omitted the default list of fields will be returned.  | [optional]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **sort** | [**List&lt;String&gt;**](String.md)| The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  | [optional]
 **filter** | [**List&lt;String&gt;**](String.md)| Supported operators are: eq, ne, gt, ge, lt, le, between, search, in | [optional]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;WorkdayOutput&gt;**](WorkdayOutput.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="workdaysPost"></a>
# **workdaysPost**
> workdaysPost(contentType, accept, body, xOrgId)

Create new Workday

This endpoint allows you to create a new workday instance.  You must supply a username and password for &#x60;Basic Authentication&#x60; that is the same as your WorkDay Integrator System User.  Failure to provide these credentials  will result in the request being rejected.  Currently &#x60;O-Auth&#x60; isn&#39;t a supported authentication protocol for WorkDay, but will be in the future.  Currently, only one instance is allowed and it must be &#x60;Workday Import&#x60;.  #### Sample Request  &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/workdays/ \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{   \&quot;name\&quot;: \&quot;Workday2\&quot;,    \&quot;reportUrl\&quot;:\&quot;https://workday.com/ccx/service/customreport2/gms/user/reportname?format&#x3D;json\&quot;,    \&quot;auth\&quot;: {     \&quot;basic\&quot;: {       \&quot;username\&quot;: \&quot;someDeveloper\&quot;,        \&quot;password\&quot;: \&quot;notTheRealPassword\&quot;     }   } }&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.WorkdayImportApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

WorkdayImportApi apiInstance = new WorkdayImportApi();
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
WorkdayInput body = new WorkdayInput(); // WorkdayInput | 
String xOrgId = "<<your org id>>"; // String | 
try {
    apiInstance.workdaysPost(contentType, accept, body, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling WorkdayImportApi#workdaysPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **body** | [**WorkdayInput**](WorkdayInput.md)|  | [optional]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="workdaysPut"></a>
# **workdaysPut**
> WorkdayOutput workdaysPut(id, contentType, accept, body, xOrgId)

Update Workday

This endpoint allows you to update the name and Custom Report URL for a Workday Instance.  Currently, the name can not be changed from the default of &#x60;Workday Import&#x60;.  ##### Sample Request &#x60;&#x60;&#x60; curl -X PUT https://console.jumpcloud.com/api/v2/workdays/{WorkdayID} \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{  \&quot;reportUrl\&quot;:\&quot;{Report_URL}\&quot;,  \&quot;name\&quot;:\&quot;{Name}\&quot; } &#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.WorkdayImportApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

WorkdayImportApi apiInstance = new WorkdayImportApi();
String id = "id_example"; // String | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
WorkdayFields body = new WorkdayFields(); // WorkdayFields | 
String xOrgId = "<<your org id>>"; // String | 
try {
    WorkdayOutput result = apiInstance.workdaysPut(id, contentType, accept, body, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WorkdayImportApi#workdaysPut");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **body** | [**WorkdayFields**](WorkdayFields.md)|  | [optional]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**WorkdayOutput**](WorkdayOutput.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="workdaysSettings"></a>
# **workdaysSettings**
> workdaysSettings(contentType, accept, state, xOrgId)

Get Workday Settings (incomplete)

This endpoint allows you to obtain all settings needed for creating a workday instance, specifically the URL to initiate Basic Authentication with WorkDay.   **This functionality is currently not enable for users.**

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.WorkdayImportApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

WorkdayImportApi apiInstance = new WorkdayImportApi();
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
String state = "state_example"; // String | 
String xOrgId = "<<your org id>>"; // String | 
try {
    apiInstance.workdaysSettings(contentType, accept, state, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling WorkdayImportApi#workdaysSettings");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **state** | **String**|  | [optional]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="workdaysWorkers"></a>
# **workdaysWorkers**
> List&lt;WorkdayWorker&gt; workdaysWorkers(workdayId, contentType, accept, limit, skip, sort, xOrgId)

List Workday Workers

This endpoint will return all of the data in your WorkDay Custom Report that has been associated with your WorkDay Instance in JumpCloud.  ##### Sample Request   &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/workdays/{WorkDayID}/workers \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;   &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.WorkdayImportApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

WorkdayImportApi apiInstance = new WorkdayImportApi();
String workdayId = "workdayId_example"; // String | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> sort = Arrays.asList("sort_example"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
String xOrgId = "<<your org id>>"; // String | 
try {
    List<WorkdayWorker> result = apiInstance.workdaysWorkers(workdayId, contentType, accept, limit, skip, sort, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WorkdayImportApi#workdaysWorkers");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **workdayId** | **String**|  |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **sort** | [**List&lt;String&gt;**](String.md)| The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  | [optional]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;WorkdayWorker&gt;**](WorkdayWorker.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

