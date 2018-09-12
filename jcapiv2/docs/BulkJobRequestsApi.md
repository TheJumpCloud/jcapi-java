# BulkJobRequestsApi

All URIs are relative to *https://console.jumpcloud.com/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**bulkUsersCreate**](BulkJobRequestsApi.md#bulkUsersCreate) | **POST** /bulk/users | Bulk Users Create
[**bulkUsersCreateResults**](BulkJobRequestsApi.md#bulkUsersCreateResults) | **GET** /bulk/users/{job_id}/results | List Bulk Users Create Results
[**jobsGet**](BulkJobRequestsApi.md#jobsGet) | **GET** /jobs/{id} | Get Job (incomplete)
[**jobsResults**](BulkJobRequestsApi.md#jobsResults) | **GET** /jobs/{id}/results | List Job Results


<a name="bulkUsersCreate"></a>
# **bulkUsersCreate**
> JobId bulkUsersCreate(contentType, accept, body, xOrgId)

Bulk Users Create

The endpoint allows you to create a bulk job to asynchronously create users.  #### Sample Request  &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/bulk/users \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;[  {   \&quot;email\&quot;:\&quot;{email}\&quot;,   \&quot;firstname\&quot;:\&quot;{firstname}\&quot;,   \&quot;lastname\&quot;:\&quot;{firstname}\&quot;,   \&quot;username\&quot;:\&quot;{username}\&quot;,   \&quot;attributes\&quot;:[    {\&quot;name\&quot;:\&quot;EmployeeID\&quot;,\&quot;value\&quot;:\&quot;0000\&quot;},    {\&quot;name\&quot;:\&quot;Custom\&quot;,\&quot;value\&quot;:\&quot;attribute\&quot;}   ]  } ] &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.BulkJobRequestsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

BulkJobRequestsApi apiInstance = new BulkJobRequestsApi();
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
List<BulkUserCreate> body = Arrays.asList(new BulkUserCreate()); // List<BulkUserCreate> | 
String xOrgId = "<<your org id>>"; // String | 
try {
    JobId result = apiInstance.bulkUsersCreate(contentType, accept, body, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BulkJobRequestsApi#bulkUsersCreate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
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

<a name="bulkUsersCreateResults"></a>
# **bulkUsersCreateResults**
> List&lt;JobWorkresult&gt; bulkUsersCreateResults(jobId, contentType, accept, limit, skip, xOrgId)

List Bulk Users Create Results

This endpoint will return the results of particular import job request.  ###Sample Request  &#x60;&#x60;&#x60; curl -X GET \\   https://console.jumpcloud.com/api/v2/bulk/users/{ImportJobID}/results \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;   &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.BulkJobRequestsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

BulkJobRequestsApi apiInstance = new BulkJobRequestsApi();
String jobId = "jobId_example"; // String | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<JobWorkresult> result = apiInstance.bulkUsersCreateResults(jobId, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BulkJobRequestsApi#bulkUsersCreateResults");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
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

<a name="jobsGet"></a>
# **jobsGet**
> JobDetails jobsGet(id, contentType, accept, xOrgId)

Get Job (incomplete)

**This endpoint is not complete and should remain hidden as it&#39;s not functional yet.**

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.BulkJobRequestsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

BulkJobRequestsApi apiInstance = new BulkJobRequestsApi();
String id = "id_example"; // String | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
String xOrgId = "<<your org id>>"; // String | 
try {
    JobDetails result = apiInstance.jobsGet(id, contentType, accept, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BulkJobRequestsApi#jobsGet");
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

[**JobDetails**](JobDetails.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="jobsResults"></a>
# **jobsResults**
> List&lt;JobWorkresult&gt; jobsResults(id, contentType, accept, limit, skip, xOrgId)

List Job Results

This endpoint will return the results of particular import job request.  ###Sample Request  &#x60;&#x60;&#x60; curl -X GET \\   https://console.jumpcloud.com/api/v2/jobs/{ImportJobID}/results \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;   &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.BulkJobRequestsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

BulkJobRequestsApi apiInstance = new BulkJobRequestsApi();
String id = "id_example"; // String | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<JobWorkresult> result = apiInstance.jobsResults(id, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BulkJobRequestsApi#jobsResults");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
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

