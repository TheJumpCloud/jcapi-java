# SystemGroupAssociationsApi

All URIs are relative to *https://console.jumpcloud.com/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**graphSystemGroupAssociationsList**](SystemGroupAssociationsApi.md#graphSystemGroupAssociationsList) | **GET** /systemgroups/{group_id}/associations | List the associations of a System Group
[**graphSystemGroupAssociationsPost**](SystemGroupAssociationsApi.md#graphSystemGroupAssociationsPost) | **POST** /systemgroups/{group_id}/associations | Manage the associations of a System Group
[**graphSystemGroupTraverseCommand**](SystemGroupAssociationsApi.md#graphSystemGroupTraverseCommand) | **GET** /systemgroups/{group_id}/commands | List the Commands bound to a System Group
[**graphSystemGroupTraversePolicy**](SystemGroupAssociationsApi.md#graphSystemGroupTraversePolicy) | **GET** /systemgroups/{group_id}/policies | List the Policies bound to a System Group
[**graphSystemGroupTraverseUser**](SystemGroupAssociationsApi.md#graphSystemGroupTraverseUser) | **GET** /systemgroups/{group_id}/users | List the Users bound to a System Group
[**graphSystemGroupTraverseUserGroup**](SystemGroupAssociationsApi.md#graphSystemGroupTraverseUserGroup) | **GET** /systemgroups/{group_id}/usergroups | List the User Groups bound to a System Group


<a name="graphSystemGroupAssociationsList"></a>
# **graphSystemGroupAssociationsList**
> List&lt;GraphConnection&gt; graphSystemGroupAssociationsList(groupId, contentType, accept, targets, limit, skip, xOrgId)

List the associations of a System Group

This endpoint returns the _direct_ associations of a System Group.  A direct association can be a non-homogeneous relationship between 2 different objects, for example System Groups and Users.   #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systemgroups/{GroupID}/associations?targets&#x3D;user \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SystemGroupAssociationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

SystemGroupAssociationsApi apiInstance = new SystemGroupAssociationsApi();
String groupId = "groupId_example"; // String | ObjectID of the System Group.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
List<String> targets = Arrays.asList("targets_example"); // List<String> | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = ""; // String | 
try {
    List<GraphConnection> result = apiInstance.graphSystemGroupAssociationsList(groupId, contentType, accept, targets, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemGroupAssociationsApi#graphSystemGroupAssociationsList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| ObjectID of the System Group. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **targets** | [**List&lt;String&gt;**](String.md)|  | [enum: active_directory, application, command, g_suite, ldap_server, office_365, policy, radius_server, user, user_group]
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

<a name="graphSystemGroupAssociationsPost"></a>
# **graphSystemGroupAssociationsPost**
> graphSystemGroupAssociationsPost(groupId, contentType, accept, body, xOrgId)

Manage the associations of a System Group

This endpoint allows you to manage the _direct_ associations of a System Group.  A direct association can be a non-homogeneous relationship between 2 different objects, for example System Groups and Users.   #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/systemgroups/{GroupID}/associations \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;user\&quot;,     \&quot;id\&quot;: \&quot;{UserID}\&quot; }&#39;  &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SystemGroupAssociationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

SystemGroupAssociationsApi apiInstance = new SystemGroupAssociationsApi();
String groupId = "groupId_example"; // String | ObjectID of the System Group.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
SystemGroupGraphManagementReq body = new SystemGroupGraphManagementReq(); // SystemGroupGraphManagementReq | 
String xOrgId = ""; // String | 
try {
    apiInstance.graphSystemGroupAssociationsPost(groupId, contentType, accept, body, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemGroupAssociationsApi#graphSystemGroupAssociationsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| ObjectID of the System Group. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **body** | [**SystemGroupGraphManagementReq**](SystemGroupGraphManagementReq.md)|  | [optional]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphSystemGroupTraverseCommand"></a>
# **graphSystemGroupTraverseCommand**
> List&lt;GraphObjectWithPaths&gt; graphSystemGroupTraverseCommand(groupId, contentType, accept, limit, skip, xOrgId)

List the Commands bound to a System Group

This endpoint will return all Commands bound to a System Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the group&#39;s type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this System Group to the corresponding Command; this array represents all grouping and/or associations that would have to be removed to deprovision the Command from this System Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systemgroups/{GroupID}/commands \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SystemGroupAssociationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

SystemGroupAssociationsApi apiInstance = new SystemGroupAssociationsApi();
String groupId = "groupId_example"; // String | ObjectID of the System Group.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = ""; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphSystemGroupTraverseCommand(groupId, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemGroupAssociationsApi#graphSystemGroupTraverseCommand");
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

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphSystemGroupTraversePolicy"></a>
# **graphSystemGroupTraversePolicy**
> List&lt;GraphObjectWithPaths&gt; graphSystemGroupTraversePolicy(groupId, contentType, accept, limit, skip, xOrgId)

List the Policies bound to a System Group

This endpoint will return all Policies bound to a System Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this System Group to the corresponding Policy; this array represents all grouping and/or associations that would have to be removed to deprovision the Policy from this System Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  This endpoint is not public yet as we haven&#39;t finished the code.  ##### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systemgroups/{GroupID}/policies \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SystemGroupAssociationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

SystemGroupAssociationsApi apiInstance = new SystemGroupAssociationsApi();
String groupId = "groupId_example"; // String | ObjectID of the System Group.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = ""; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphSystemGroupTraversePolicy(groupId, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemGroupAssociationsApi#graphSystemGroupTraversePolicy");
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

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphSystemGroupTraverseUser"></a>
# **graphSystemGroupTraverseUser**
> List&lt;GraphObjectWithPaths&gt; graphSystemGroupTraverseUser(groupId, contentType, accept, limit, skip, xOrgId)

List the Users bound to a System Group

This endpoint will return all Users bound to a System Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this System Group to the corresponding User; this array represents all grouping and/or associations that would have to be removed to deprovision the User from this System Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systemgroups/{GroupID}/users \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SystemGroupAssociationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

SystemGroupAssociationsApi apiInstance = new SystemGroupAssociationsApi();
String groupId = "groupId_example"; // String | ObjectID of the System Group.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = ""; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphSystemGroupTraverseUser(groupId, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemGroupAssociationsApi#graphSystemGroupTraverseUser");
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

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphSystemGroupTraverseUserGroup"></a>
# **graphSystemGroupTraverseUserGroup**
> List&lt;GraphObjectWithPaths&gt; graphSystemGroupTraverseUserGroup(groupId, contentType, accept, limit, skip, xOrgId)

List the User Groups bound to a System Group

This endpoint will return all User Groups bound to a System Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this System Group to the corresponding User Group; this array represents all grouping and/or associations that would have to be removed to deprovision the User Group from this System Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systemgroups/{GroupID}/usergroups \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;  &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SystemGroupAssociationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

SystemGroupAssociationsApi apiInstance = new SystemGroupAssociationsApi();
String groupId = "groupId_example"; // String | ObjectID of the System Group.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = ""; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphSystemGroupTraverseUserGroup(groupId, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemGroupAssociationsApi#graphSystemGroupTraverseUserGroup");
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

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

