# ActiveDirectoryApi

All URIs are relative to *https://console.jumpcloud.com/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**activedirectoriesAgentsDelete**](ActiveDirectoryApi.md#activedirectoriesAgentsDelete) | **DELETE** /activedirectories/{activedirectory_id}/agents/{agent_id} | Delete Active Directory Agent
[**activedirectoriesAgentsGet**](ActiveDirectoryApi.md#activedirectoriesAgentsGet) | **GET** /activedirectories/{activedirectory_id}/agents/{agent_id} | Get Active Directory Agent
[**activedirectoriesAgentsList**](ActiveDirectoryApi.md#activedirectoriesAgentsList) | **GET** /activedirectories/{activedirectory_id}/agents | List Active Directory Agents
[**activedirectoriesAgentsPost**](ActiveDirectoryApi.md#activedirectoriesAgentsPost) | **POST** /activedirectories/{activedirectory_id}/agents | Create a new Active Directory Agent
[**activedirectoriesDelete**](ActiveDirectoryApi.md#activedirectoriesDelete) | **DELETE** /activedirectories/{id} | Delete an Active Directory
[**activedirectoriesGet**](ActiveDirectoryApi.md#activedirectoriesGet) | **GET** /activedirectories/{id} | Get an Active Directory
[**activedirectoriesList**](ActiveDirectoryApi.md#activedirectoriesList) | **GET** /activedirectories | List Active Directories
[**activedirectoriesPost**](ActiveDirectoryApi.md#activedirectoriesPost) | **POST** /activedirectories | Create a new Active Directory
[**graphActiveDirectoryAssociationsList**](ActiveDirectoryApi.md#graphActiveDirectoryAssociationsList) | **GET** /activedirectories/{activedirectory_id}/associations | List the associations of an Active Directory instance
[**graphActiveDirectoryAssociationsPost**](ActiveDirectoryApi.md#graphActiveDirectoryAssociationsPost) | **POST** /activedirectories/{activedirectory_id}/associations | Manage the associations of an Active Directory instance
[**graphActiveDirectoryTraverseUserGroup**](ActiveDirectoryApi.md#graphActiveDirectoryTraverseUserGroup) | **GET** /activedirectories/{activedirectory_id}/usergroups | List the User Groups bound to an Active Directory instance


<a name="activedirectoriesAgentsDelete"></a>
# **activedirectoriesAgentsDelete**
> activedirectoriesAgentsDelete(activedirectoryId, agentId, contentType, accept, xOrgId)

Delete Active Directory Agent

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ActiveDirectoryApi;


ActiveDirectoryApi apiInstance = new ActiveDirectoryApi();
String activedirectoryId = "activedirectoryId_example"; // String | 
String agentId = "agentId_example"; // String | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
String xOrgId = ""; // String | 
try {
    apiInstance.activedirectoriesAgentsDelete(activedirectoryId, agentId, contentType, accept, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling ActiveDirectoryApi#activedirectoriesAgentsDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **activedirectoryId** | **String**|  |
 **agentId** | **String**|  |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="activedirectoriesAgentsGet"></a>
# **activedirectoriesAgentsGet**
> ActiveDirectoryAgentListOutput activedirectoriesAgentsGet(activedirectoryId, agentId, contentType, accept, xOrgId)

Get Active Directory Agent

This endpoint returns a specific active directory agent.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/activedirectories/{activedirectory_id}/agents/{agent_id} \\   -H &#39;accept: application/json&#39; \\   -H &#39;content-type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;   &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ActiveDirectoryApi;


ActiveDirectoryApi apiInstance = new ActiveDirectoryApi();
String activedirectoryId = "activedirectoryId_example"; // String | 
String agentId = "agentId_example"; // String | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
String xOrgId = ""; // String | 
try {
    ActiveDirectoryAgentListOutput result = apiInstance.activedirectoriesAgentsGet(activedirectoryId, agentId, contentType, accept, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ActiveDirectoryApi#activedirectoriesAgentsGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **activedirectoryId** | **String**|  |
 **agentId** | **String**|  |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

[**ActiveDirectoryAgentListOutput**](ActiveDirectoryAgentListOutput.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="activedirectoriesAgentsList"></a>
# **activedirectoriesAgentsList**
> List&lt;ActiveDirectoryAgentListOutput&gt; activedirectoriesAgentsList(activedirectoryId, contentType, accept, limit, skip, sort, xOrgId)

List Active Directory Agents

This endpoint allows you to list all your Active Directory Agents for a given Instance.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/activedirectories/{activedirectory_id}/agents \\   -H &#39;accept: application/json&#39; \\   -H &#39;content-type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;   &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ActiveDirectoryApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ActiveDirectoryApi apiInstance = new ActiveDirectoryApi();
String activedirectoryId = "activedirectoryId_example"; // String | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> sort = Arrays.asList("sort_example"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
String xOrgId = ""; // String | 
try {
    List<ActiveDirectoryAgentListOutput> result = apiInstance.activedirectoriesAgentsList(activedirectoryId, contentType, accept, limit, skip, sort, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ActiveDirectoryApi#activedirectoriesAgentsList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **activedirectoryId** | **String**|  |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **sort** | [**List&lt;String&gt;**](String.md)| The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  | [optional]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

[**List&lt;ActiveDirectoryAgentListOutput&gt;**](ActiveDirectoryAgentListOutput.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="activedirectoriesAgentsPost"></a>
# **activedirectoriesAgentsPost**
> ActiveDirectoryAgentGetOutput activedirectoriesAgentsPost(activedirectoryId, contentType, accept, body, xOrgId)

Create a new Active Directory Agent

This endpoint allows you to create a new Active Directory Agent.   #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/activedirectories/{activedirectory_id}/agents \\   -H &#39;accept: application/json&#39; \\   -H &#39;content-type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ActiveDirectoryApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ActiveDirectoryApi apiInstance = new ActiveDirectoryApi();
String activedirectoryId = "activedirectoryId_example"; // String | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
ActiveDirectoryAgentInput body = new ActiveDirectoryAgentInput(); // ActiveDirectoryAgentInput | 
String xOrgId = ""; // String | 
try {
    ActiveDirectoryAgentGetOutput result = apiInstance.activedirectoriesAgentsPost(activedirectoryId, contentType, accept, body, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ActiveDirectoryApi#activedirectoriesAgentsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **activedirectoryId** | **String**|  |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **body** | [**ActiveDirectoryAgentInput**](ActiveDirectoryAgentInput.md)|  | [optional]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

[**ActiveDirectoryAgentGetOutput**](ActiveDirectoryAgentGetOutput.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="activedirectoriesDelete"></a>
# **activedirectoriesDelete**
> activedirectoriesDelete(id, contentType, accept, xOrgId)

Delete an Active Directory

This endpoint allows you to delete an Active Directory Instance.  #### Sample Request &#x60;&#x60;&#x60; curl -X DELETE https://console.jumpcloud.com/api/v2/activedirectories/{ActiveDirectory_ID} \\   -H &#39;accept: application/json&#39; \\   -H &#39;content-type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY&#39;   &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ActiveDirectoryApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ActiveDirectoryApi apiInstance = new ActiveDirectoryApi();
String id = "id_example"; // String | ObjectID of this Active Directory instance.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
String xOrgId = ""; // String | 
try {
    apiInstance.activedirectoriesDelete(id, contentType, accept, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling ActiveDirectoryApi#activedirectoriesDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| ObjectID of this Active Directory instance. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="activedirectoriesGet"></a>
# **activedirectoriesGet**
> ActiveDirectoryOutput activedirectoriesGet(id, contentType, accept, xOrgId)

Get an Active Directory

This endpoint returns a specific Active Directory.  #### Sample Request  &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/activedirectories/{ActiveDirectory_ID} \\   -H &#39;accept: application/json&#39; \\   -H &#39;content-type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;   &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ActiveDirectoryApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ActiveDirectoryApi apiInstance = new ActiveDirectoryApi();
String id = "id_example"; // String | ObjectID of this Active Directory instance.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
String xOrgId = ""; // String | 
try {
    ActiveDirectoryOutput result = apiInstance.activedirectoriesGet(id, contentType, accept, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ActiveDirectoryApi#activedirectoriesGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| ObjectID of this Active Directory instance. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

[**ActiveDirectoryOutput**](ActiveDirectoryOutput.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="activedirectoriesList"></a>
# **activedirectoriesList**
> List&lt;ActiveDirectoryOutput&gt; activedirectoriesList(contentType, accept, fields, filter, limit, skip, sort, xOrgId)

List Active Directories

This endpoint allows you to list all your Active Directory Instances.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/activedirectories/ \\   -H &#39;accept: application/json&#39; \\   -H &#39;content-type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;   &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ActiveDirectoryApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ActiveDirectoryApi apiInstance = new ActiveDirectoryApi();
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
List<String> fields = Arrays.asList("fields_example"); // List<String> | The comma separated fields included in the returned records. If omitted, the default list of fields will be returned. 
List<String> filter = Arrays.asList("filter_example"); // List<String> | Supported operators are: eq, ne, gt, ge, lt, le, between, search, in
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> sort = Arrays.asList("sort_example"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
String xOrgId = ""; // String | 
try {
    List<ActiveDirectoryOutput> result = apiInstance.activedirectoriesList(contentType, accept, fields, filter, limit, skip, sort, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ActiveDirectoryApi#activedirectoriesList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **fields** | [**List&lt;String&gt;**](String.md)| The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  | [optional]
 **filter** | [**List&lt;String&gt;**](String.md)| Supported operators are: eq, ne, gt, ge, lt, le, between, search, in | [optional]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **sort** | [**List&lt;String&gt;**](String.md)| The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  | [optional]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

[**List&lt;ActiveDirectoryOutput&gt;**](ActiveDirectoryOutput.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="activedirectoriesPost"></a>
# **activedirectoriesPost**
> ActiveDirectoryOutput activedirectoriesPost(contentType, accept, body, xOrgId)

Create a new Active Directory

This endpoint allows you to create a new Active Directory.   #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/activedirectories/ \\   -H &#39;accept: application/json&#39; \\   -H &#39;content-type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{         \&quot;domain\&quot;: \&quot;{DC&#x3D;AD_domain_name;DC&#x3D;com}\&quot; } &#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ActiveDirectoryApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ActiveDirectoryApi apiInstance = new ActiveDirectoryApi();
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
ActiveDirectoryInput body = new ActiveDirectoryInput(); // ActiveDirectoryInput | 
String xOrgId = ""; // String | 
try {
    ActiveDirectoryOutput result = apiInstance.activedirectoriesPost(contentType, accept, body, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ActiveDirectoryApi#activedirectoriesPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **body** | [**ActiveDirectoryInput**](ActiveDirectoryInput.md)|  | [optional]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

[**ActiveDirectoryOutput**](ActiveDirectoryOutput.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphActiveDirectoryAssociationsList"></a>
# **graphActiveDirectoryAssociationsList**
> List&lt;GraphConnection&gt; graphActiveDirectoryAssociationsList(activedirectoryId, targets, contentType, accept, limit, skip, xOrgId)

List the associations of an Active Directory instance

This endpoint returns the direct associations of this Active Directory instance.  A direct association can be a non-homogeneous relationship between 2 different objects, for example Active Directory and Users.   #### Sample Request &#x60;&#x60;&#x60; curl -X GET &#39;https://console.jumpcloud.com/api/v2/activedirectories/{ActiveDirectory_ID}/associations?targets&#x3D;user \\   -H &#39;accept: application/json&#39; \\   -H &#39;content-type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ActiveDirectoryApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ActiveDirectoryApi apiInstance = new ActiveDirectoryApi();
String activedirectoryId = "activedirectoryId_example"; // String | 
List<String> targets = Arrays.asList("targets_example"); // List<String> | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = ""; // String | 
try {
    List<GraphConnection> result = apiInstance.graphActiveDirectoryAssociationsList(activedirectoryId, targets, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ActiveDirectoryApi#graphActiveDirectoryAssociationsList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **activedirectoryId** | **String**|  |
 **targets** | [**List&lt;String&gt;**](String.md)|  | [enum: active_directory, application, command, g_suite, ldap_server, office_365, policy, radius_server, system, system_group, user, user_group]
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

[**List&lt;GraphConnection&gt;**](GraphConnection.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphActiveDirectoryAssociationsPost"></a>
# **graphActiveDirectoryAssociationsPost**
> graphActiveDirectoryAssociationsPost(activedirectoryId, contentType, accept, body, xOrgId)

Manage the associations of an Active Directory instance

This endpoint allows you to manage the _direct_ associations of an Active Directory instance.  A direct association can be a non-homogeneous relationship between 2 different objects, for example Active Directory and Users.  #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/activedirectories/{AD_Instance_ID}/associations \\   -H &#39;accept: application/json&#39; \\   -H &#39;content-type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{         \&quot;op\&quot;: \&quot;add\&quot;,         \&quot;type\&quot;: \&quot;user\&quot;,         \&quot;id\&quot;: \&quot;{User_ID}\&quot; } &#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ActiveDirectoryApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ActiveDirectoryApi apiInstance = new ActiveDirectoryApi();
String activedirectoryId = "activedirectoryId_example"; // String | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
GraphManagementReq body = new GraphManagementReq(); // GraphManagementReq | 
String xOrgId = ""; // String | 
try {
    apiInstance.graphActiveDirectoryAssociationsPost(activedirectoryId, contentType, accept, body, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling ActiveDirectoryApi#graphActiveDirectoryAssociationsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **activedirectoryId** | **String**|  |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **body** | [**GraphManagementReq**](GraphManagementReq.md)|  | [optional]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphActiveDirectoryTraverseUserGroup"></a>
# **graphActiveDirectoryTraverseUserGroup**
> List&lt;GraphObjectWithPaths&gt; graphActiveDirectoryTraverseUserGroup(activedirectoryId, contentType, accept, limit, xOrgId, skip, filter)

List the User Groups bound to an Active Directory instance

This endpoint will return all Users Groups bound to an Active Directory instance, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the group&#39;s type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this Active Directory instance to the corresponding User Group; this array represents all grouping and/or associations that would have to be removed to deprovision the User Group from this Active Directory instance.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/activedirectories/{ActiveDirectory_ID}/usergroups \\   -H &#39;accept: application/json&#39; \\   -H &#39;content-type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ActiveDirectoryApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ActiveDirectoryApi apiInstance = new ActiveDirectoryApi();
String activedirectoryId = "activedirectoryId_example"; // String | ObjectID of the Active Directory instance.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = ""; // String | 
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | Supported operators are: eq, ne, gt, ge, lt, le, between, search, in
try {
    List<GraphObjectWithPaths> result = apiInstance.graphActiveDirectoryTraverseUserGroup(activedirectoryId, contentType, accept, limit, xOrgId, skip, filter);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ActiveDirectoryApi#graphActiveDirectoryTraverseUserGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **activedirectoryId** | **String**| ObjectID of the Active Directory instance. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**|  | [optional] [default to ]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **filter** | [**List&lt;String&gt;**](String.md)| Supported operators are: eq, ne, gt, ge, lt, le, between, search, in | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

