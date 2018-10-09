# GSuiteApi

All URIs are relative to *https://console.jumpcloud.com/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**graphGSuiteAssociationsList**](GSuiteApi.md#graphGSuiteAssociationsList) | **GET** /gsuites/{gsuite_id}/associations | List the associations of a G Suite instance
[**graphGSuiteAssociationsPost**](GSuiteApi.md#graphGSuiteAssociationsPost) | **POST** /gsuites/{gsuite_id}/associations | Manage the associations of a G Suite instance
[**graphGSuiteTraverseUser**](GSuiteApi.md#graphGSuiteTraverseUser) | **GET** /gsuites/{gsuite_id}/users | List the Users bound to a G Suite instance
[**graphGSuiteTraverseUserGroup**](GSuiteApi.md#graphGSuiteTraverseUserGroup) | **GET** /gsuites/{gsuite_id}/usergroups | List the User Groups bound to a G Suite instance


<a name="graphGSuiteAssociationsList"></a>
# **graphGSuiteAssociationsList**
> List&lt;GraphConnection&gt; graphGSuiteAssociationsList(gsuiteId, targets, contentType, accept, limit, skip, xOrgId)

List the associations of a G Suite instance

This endpoint returns the _direct_ associations of this G Suite instance.  A direct association can be a non-homogeneous relationship between 2 different objects, for example G Suite and Users.   #### Sample Request &#x60;&#x60;&#x60; curl -X GET &#39;https://console.jumpcloud.com/api/v2/gsuites/{Gsuite_ID}/associations?targets&#x3D;user_group \\   -H &#39;accept: application/json&#39; \\   -H &#39;content-type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GSuiteApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GSuiteApi apiInstance = new GSuiteApi();
String gsuiteId = "gsuiteId_example"; // String | ObjectID of the G Suite instance.
List<String> targets = Arrays.asList("targets_example"); // List<String> | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = ""; // String | 
try {
    List<GraphConnection> result = apiInstance.graphGSuiteAssociationsList(gsuiteId, targets, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GSuiteApi#graphGSuiteAssociationsList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **gsuiteId** | **String**| ObjectID of the G Suite instance. |
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

<a name="graphGSuiteAssociationsPost"></a>
# **graphGSuiteAssociationsPost**
> graphGSuiteAssociationsPost(gsuiteId, body, xOrgId)

Manage the associations of a G Suite instance

This endpoint returns the _direct_ associations of this G Suite instance.  A direct association can be a non-homogeneous relationship between 2 different objects, for example G Suite and Users.   #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/gsuites/{Gsuite_ID}/associations \\   -H &#39;accept: application/json&#39; \\   -H &#39;content-type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;user_group\&quot;,     \&quot;id\&quot;: \&quot;{Group_ID}\&quot; }&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GSuiteApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GSuiteApi apiInstance = new GSuiteApi();
String gsuiteId = "gsuiteId_example"; // String | ObjectID of the G Suite instance.
GraphManagementReq body = new GraphManagementReq(); // GraphManagementReq | 
String xOrgId = ""; // String | 
try {
    apiInstance.graphGSuiteAssociationsPost(gsuiteId, body, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling GSuiteApi#graphGSuiteAssociationsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **gsuiteId** | **String**| ObjectID of the G Suite instance. |
 **body** | [**GraphManagementReq**](GraphManagementReq.md)|  | [optional]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphGSuiteTraverseUser"></a>
# **graphGSuiteTraverseUser**
> List&lt;GraphObjectWithPaths&gt; graphGSuiteTraverseUser(gsuiteId, contentType, accept, limit, skip, xOrgId)

List the Users bound to a G Suite instance

This endpoint will return all Users bound to a G Suite instance, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this G Suite instance to the corresponding User; this array represents all grouping and/or associations that would have to be removed to deprovision the User from this G Suite instance.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60;   curl -X GET https://console.jumpcloud.com/api/v2/gsuites/{Gsuite_ID}/users \\   -H &#39;accept: application/json&#39; \\   -H &#39;content-type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GSuiteApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GSuiteApi apiInstance = new GSuiteApi();
String gsuiteId = "gsuiteId_example"; // String | ObjectID of the G Suite instance.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = ""; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphGSuiteTraverseUser(gsuiteId, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GSuiteApi#graphGSuiteTraverseUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **gsuiteId** | **String**| ObjectID of the G Suite instance. |
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

<a name="graphGSuiteTraverseUserGroup"></a>
# **graphGSuiteTraverseUserGroup**
> List&lt;GraphObjectWithPaths&gt; graphGSuiteTraverseUserGroup(gsuiteId, contentType, accept, limit, skip, xOrgId)

List the User Groups bound to a G Suite instance

This endpoint will return all User Groups bound to an G Suite instance, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the group&#39;s type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this G Suite instance to the corresponding User Group; this array represents all grouping and/or associations that would have to be removed to deprovision the User Group from this G Suite instance.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60;   curl -X GET https://console.jumpcloud.com/api/v2/gsuites/{GSuite_ID}/usergroups \\   -H &#39;accept: application/json&#39; \\   -H &#39;content-type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GSuiteApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GSuiteApi apiInstance = new GSuiteApi();
String gsuiteId = "gsuiteId_example"; // String | ObjectID of the G Suite instance.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = ""; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphGSuiteTraverseUserGroup(gsuiteId, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GSuiteApi#graphGSuiteTraverseUserGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **gsuiteId** | **String**| ObjectID of the G Suite instance. |
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

