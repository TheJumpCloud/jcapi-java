# SystemGroupMembersMembershipApi

All URIs are relative to *https://console.jumpcloud.com/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**graphSystemGroupMemberOf**](SystemGroupMembersMembershipApi.md#graphSystemGroupMemberOf) | **GET** /systemgroups/{group_id}/memberof | List the System Group&#39;s parents
[**graphSystemGroupMembersList**](SystemGroupMembersMembershipApi.md#graphSystemGroupMembersList) | **GET** /systemgroups/{group_id}/members | List the members of a System Group
[**graphSystemGroupMembersPost**](SystemGroupMembersMembershipApi.md#graphSystemGroupMembersPost) | **POST** /systemgroups/{group_id}/members | Manage the members of a System Group
[**graphSystemGroupMembership**](SystemGroupMembersMembershipApi.md#graphSystemGroupMembership) | **GET** /systemgroups/{group_id}/membership | List the System Group&#39;s membership


<a name="graphSystemGroupMemberOf"></a>
# **graphSystemGroupMemberOf**
> List&lt;GraphObjectWithPaths&gt; graphSystemGroupMemberOf(groupId, contentType, accept, filter, limit, skip, sort, xOrgId)

List the System Group&#39;s parents

This endpoint returns all System Groups a System Group is a member of.  This endpoint is not yet public as we haven&#39;t completed the code yet.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SystemGroupMembersMembershipApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

SystemGroupMembersMembershipApi apiInstance = new SystemGroupMembersMembershipApi();
String groupId = "groupId_example"; // String | ObjectID of the System Group.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
List<String> filter = Arrays.asList("[]"); // List<String> | Supported operators are: eq, ne, gt, ge, lt, le, between, search, in
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> sort = Arrays.asList("[]"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
String xOrgId = ""; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphSystemGroupMemberOf(groupId, contentType, accept, filter, limit, skip, sort, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemGroupMembersMembershipApi#graphSystemGroupMemberOf");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| ObjectID of the System Group. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **filter** | [**List&lt;String&gt;**](String.md)| Supported operators are: eq, ne, gt, ge, lt, le, between, search, in | [optional] [default to []]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **sort** | [**List&lt;String&gt;**](String.md)| The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  | [optional] [default to []]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphSystemGroupMembersList"></a>
# **graphSystemGroupMembersList**
> List&lt;GraphConnection&gt; graphSystemGroupMembersList(groupId, contentType, accept, limit, skip, xOrgId)

List the members of a System Group

This endpoint returns the system members of a System Group.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systemgroups/{Group_ID}/members \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;  &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SystemGroupMembersMembershipApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

SystemGroupMembersMembershipApi apiInstance = new SystemGroupMembersMembershipApi();
String groupId = "groupId_example"; // String | ObjectID of the System Group.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = ""; // String | 
try {
    List<GraphConnection> result = apiInstance.graphSystemGroupMembersList(groupId, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemGroupMembersMembershipApi#graphSystemGroupMembersList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| ObjectID of the System Group. |
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

<a name="graphSystemGroupMembersPost"></a>
# **graphSystemGroupMembersPost**
> graphSystemGroupMembersPost(groupId, contentType, accept, body, date, authorization, xOrgId)

Manage the members of a System Group

This endpoint allows you to manage the system members of a System Group.  #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/systemgroups/{Group_ID}/members \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;system\&quot;,     \&quot;id\&quot;: \&quot;{System_ID}\&quot; }&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SystemGroupMembersMembershipApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

SystemGroupMembersMembershipApi apiInstance = new SystemGroupMembersMembershipApi();
String groupId = "groupId_example"; // String | ObjectID of the System Group.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
SystemGroupMembersReq body = new SystemGroupMembersReq(); // SystemGroupMembersReq | 
String date = "date_example"; // String | Current date header for the System Context API
String authorization = "authorization_example"; // String | Authorization header for the System Context API
String xOrgId = ""; // String | 
try {
    apiInstance.graphSystemGroupMembersPost(groupId, contentType, accept, body, date, authorization, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemGroupMembersMembershipApi#graphSystemGroupMembersPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| ObjectID of the System Group. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **body** | [**SystemGroupMembersReq**](SystemGroupMembersReq.md)|  | [optional]
 **date** | **String**| Current date header for the System Context API | [optional]
 **authorization** | **String**| Authorization header for the System Context API | [optional]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphSystemGroupMembership"></a>
# **graphSystemGroupMembership**
> List&lt;GraphObjectWithPaths&gt; graphSystemGroupMembership(groupId, contentType, accept, limit, skip, sort, filter, xOrgId)

List the System Group&#39;s membership

This endpoint returns all Systems that are a member of this System Group.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systemgroups/{Group_ID/membership \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;  &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SystemGroupMembersMembershipApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

SystemGroupMembersMembershipApi apiInstance = new SystemGroupMembersMembershipApi();
String groupId = "groupId_example"; // String | ObjectID of the System Group.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> sort = Arrays.asList("[]"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
List<String> filter = Arrays.asList("[]"); // List<String> | Supported operators are: eq, ne, gt, ge, lt, le, between, search, in
String xOrgId = ""; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphSystemGroupMembership(groupId, contentType, accept, limit, skip, sort, filter, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemGroupMembersMembershipApi#graphSystemGroupMembership");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| ObjectID of the System Group. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **sort** | [**List&lt;String&gt;**](String.md)| The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  | [optional] [default to []]
 **filter** | [**List&lt;String&gt;**](String.md)| Supported operators are: eq, ne, gt, ge, lt, le, between, search, in | [optional] [default to []]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

