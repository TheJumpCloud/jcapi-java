# UserGroupMembersMembershipApi

All URIs are relative to *https://console.jumpcloud.com/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**graphUserGroupMemberOf**](UserGroupMembersMembershipApi.md#graphUserGroupMemberOf) | **GET** /usergroups/{group_id}/memberof | List the User Group&#39;s parents
[**graphUserGroupMembersList**](UserGroupMembersMembershipApi.md#graphUserGroupMembersList) | **GET** /usergroups/{group_id}/members | List the members of a User Group
[**graphUserGroupMembersPost**](UserGroupMembersMembershipApi.md#graphUserGroupMembersPost) | **POST** /usergroups/{group_id}/members | Manage the members of a User Group
[**graphUserGroupMembership**](UserGroupMembersMembershipApi.md#graphUserGroupMembership) | **GET** /usergroups/{group_id}/membership | List the User Group&#39;s membership


<a name="graphUserGroupMemberOf"></a>
# **graphUserGroupMemberOf**
> List&lt;GraphObjectWithPaths&gt; graphUserGroupMemberOf(groupId, contentType, accept, filter, limit, skip, sort)

List the User Group&#39;s parents

This endpoint returns all User Groups a User Group is a member of.  #### Sample Request &#x60;&#x60;&#x60; https://console.jumpcloud.com/api/v2/usergroups/{group_id}/membersof &#x60;&#x60;&#x60;  Not public yet, as the code is not finished,

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.UserGroupMembersMembershipApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

UserGroupMembersMembershipApi apiInstance = new UserGroupMembersMembershipApi();
String groupId = "groupId_example"; // String | ObjectID of the User Group.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
List<String> filter = Arrays.asList("filter_example"); // List<String> | Supported operators are: eq, ne, gt, ge, lt, le, between, search, in
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> sort = Arrays.asList("sort_example"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphUserGroupMemberOf(groupId, contentType, accept, filter, limit, skip, sort);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserGroupMembersMembershipApi#graphUserGroupMemberOf");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| ObjectID of the User Group. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **filter** | [**List&lt;String&gt;**](String.md)| Supported operators are: eq, ne, gt, ge, lt, le, between, search, in | [optional]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **sort** | [**List&lt;String&gt;**](String.md)| The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphUserGroupMembersList"></a>
# **graphUserGroupMembersList**
> List&lt;GraphConnection&gt; graphUserGroupMembersList(groupId, contentType, accept, limit, skip)

List the members of a User Group

This endpoint returns the user members of a User Group.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/members \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.UserGroupMembersMembershipApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

UserGroupMembersMembershipApi apiInstance = new UserGroupMembersMembershipApi();
String groupId = "groupId_example"; // String | ObjectID of the User Group.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
try {
    List<GraphConnection> result = apiInstance.graphUserGroupMembersList(groupId, contentType, accept, limit, skip);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserGroupMembersMembershipApi#graphUserGroupMembersList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| ObjectID of the User Group. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]

### Return type

[**List&lt;GraphConnection&gt;**](GraphConnection.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphUserGroupMembersPost"></a>
# **graphUserGroupMembersPost**
> graphUserGroupMembersPost(groupId, contentType, accept, body)

Manage the members of a User Group

This endpoint allows you to manage the user members of a User Group.  #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/members \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;user\&quot;,     \&quot;id\&quot;: \&quot;{User_ID}\&quot; }&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.UserGroupMembersMembershipApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

UserGroupMembersMembershipApi apiInstance = new UserGroupMembersMembershipApi();
String groupId = "groupId_example"; // String | ObjectID of the User Group.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
UserGroupMembersReq body = new UserGroupMembersReq(); // UserGroupMembersReq | 
try {
    apiInstance.graphUserGroupMembersPost(groupId, contentType, accept, body);
} catch (ApiException e) {
    System.err.println("Exception when calling UserGroupMembersMembershipApi#graphUserGroupMembersPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| ObjectID of the User Group. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **body** | [**UserGroupMembersReq**](UserGroupMembersReq.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphUserGroupMembership"></a>
# **graphUserGroupMembership**
> List&lt;GraphObjectWithPaths&gt; graphUserGroupMembership(groupId, contentType, accept, filter, limit, skip, sort)

List the User Group&#39;s membership

This endpoint returns all users members that are a member of this User Group.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/membership \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.UserGroupMembersMembershipApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

UserGroupMembersMembershipApi apiInstance = new UserGroupMembersMembershipApi();
String groupId = "groupId_example"; // String | ObjectID of the User Group.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
List<String> filter = Arrays.asList("filter_example"); // List<String> | Supported operators are: eq, ne, gt, ge, lt, le, between, search, in
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> sort = Arrays.asList("sort_example"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphUserGroupMembership(groupId, contentType, accept, filter, limit, skip, sort);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserGroupMembersMembershipApi#graphUserGroupMembership");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| ObjectID of the User Group. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **filter** | [**List&lt;String&gt;**](String.md)| Supported operators are: eq, ne, gt, ge, lt, le, between, search, in | [optional]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **sort** | [**List&lt;String&gt;**](String.md)| The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

