# SoftwareAppsApi

All URIs are relative to *https://console.jumpcloud.com/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**graphSoftwareappsAssociationsList**](SoftwareAppsApi.md#graphSoftwareappsAssociationsList) | **GET** /softwareapps/{software_app_id}/associations | List the associations of a Software Application
[**graphSoftwareappsAssociationsPost**](SoftwareAppsApi.md#graphSoftwareappsAssociationsPost) | **POST** /softwareapps/{software_app_id}/associations | Manage the associations of a software application.
[**graphSoftwareappsTraverseSystem**](SoftwareAppsApi.md#graphSoftwareappsTraverseSystem) | **GET** /softwareapps/{software_app_id}/systems | List the Systems bound to a Software App.
[**graphSoftwareappsTraverseSystemGroup**](SoftwareAppsApi.md#graphSoftwareappsTraverseSystemGroup) | **GET** /softwareapps/{software_app_id}/systemgroups | List the System Groups bound to a Software App.
[**softwareAppStatusesList**](SoftwareAppsApi.md#softwareAppStatusesList) | **GET** /softwareapps/{software_app_id}/statuses | Get the status of the provided Software Application
[**softwareAppsDelete**](SoftwareAppsApi.md#softwareAppsDelete) | **DELETE** /softwareapps/{id} | Delete a configured Software Application
[**softwareAppsGet**](SoftwareAppsApi.md#softwareAppsGet) | **GET** /softwareapps/{id} | Retrieve a configured Software Application.
[**softwareAppsList**](SoftwareAppsApi.md#softwareAppsList) | **GET** /softwareapps | Get all configured Software Applications.
[**softwareAppsPost**](SoftwareAppsApi.md#softwareAppsPost) | **POST** /softwareapps | Create a Software Application that will be managed by JumpCloud.
[**softwareAppsReclaimLicenses**](SoftwareAppsApi.md#softwareAppsReclaimLicenses) | **POST** /softwareapps/{software_app_id}/reclaim-licenses | Reclaim Licenses for a Software Application.
[**softwareAppsRetryInstallation**](SoftwareAppsApi.md#softwareAppsRetryInstallation) | **POST** /softwareapps/{software_app_id}/retry-installation | Retry Installation for a Software Application
[**softwareAppsUpdate**](SoftwareAppsApi.md#softwareAppsUpdate) | **PUT** /softwareapps/{id} | Update a Software Application Configuration.

<a name="graphSoftwareappsAssociationsList"></a>
# **graphSoftwareappsAssociationsList**
> List&lt;GraphConnection&gt; graphSoftwareappsAssociationsList(softwareAppId, targets, limit, skip, xOrgId)

List the associations of a Software Application

This endpoint will return the _direct_ associations of a Software Application. A direct association can be a non-homogeneous relationship between 2 different objects, for example Software Application and System Groups.   #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/softwareapps/{software_app_id}/associations?targets&#x3D;system_group \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SoftwareAppsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

SoftwareAppsApi apiInstance = new SoftwareAppsApi();
String softwareAppId = "softwareAppId_example"; // String | ObjectID of the Software App.
List<String> targets = Arrays.asList("targets_example"); // List<String> | Targets which a \"software_app\" can be associated to.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    List<GraphConnection> result = apiInstance.graphSoftwareappsAssociationsList(softwareAppId, targets, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SoftwareAppsApi#graphSoftwareappsAssociationsList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **softwareAppId** | **String**| ObjectID of the Software App. |
 **targets** | [**List&lt;String&gt;**](String.md)| Targets which a \&quot;software_app\&quot; can be associated to. | [enum: system, system_group]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**List&lt;GraphConnection&gt;**](GraphConnection.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphSoftwareappsAssociationsPost"></a>
# **graphSoftwareappsAssociationsPost**
> graphSoftwareappsAssociationsPost(softwareAppId, body, xOrgId)

Manage the associations of a software application.

This endpoint allows you to associate or disassociate a software application to a system or system group.  #### Sample Request &#x60;&#x60;&#x60; $ curl -X POST https://console.jumpcloud.com/api/v2/softwareapps/{software_app_id}/associations \\ -H &#x27;Accept: application/json&#x27; \\ -H &#x27;Content-Type: application/json&#x27; \\ -H &#x27;x-api-key: {API_KEY}&#x27; \\ -d &#x27;{   \&quot;id\&quot;: \&quot;&lt;object_id&gt;\&quot;,   \&quot;op\&quot;: \&quot;add\&quot;,   \&quot;type\&quot;: \&quot;system\&quot;  }&#x27; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SoftwareAppsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

SoftwareAppsApi apiInstance = new SoftwareAppsApi();
String softwareAppId = "softwareAppId_example"; // String | ObjectID of the Software App.
GraphOperationSoftwareApp body = new GraphOperationSoftwareApp(); // GraphOperationSoftwareApp | 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    apiInstance.graphSoftwareappsAssociationsPost(softwareAppId, body, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling SoftwareAppsApi#graphSoftwareappsAssociationsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **softwareAppId** | **String**| ObjectID of the Software App. |
 **body** | [**GraphOperationSoftwareApp**](GraphOperationSoftwareApp.md)|  | [optional]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="graphSoftwareappsTraverseSystem"></a>
# **graphSoftwareappsTraverseSystem**
> List&lt;GraphObjectWithPaths&gt; graphSoftwareappsTraverseSystem(softwareAppId, limit, xOrgId, skip, filter)

List the Systems bound to a Software App.

This endpoint will return all Systems bound to a Software App, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this Software App to the corresponding System; this array represents all grouping and/or associations that would have to be removed to deprovision the System from this Software App.  See &#x60;/associations&#x60; endpoint to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/softwareapps/{software_app_id}/systems \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SoftwareAppsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

SoftwareAppsApi apiInstance = new SoftwareAppsApi();
String softwareAppId = "softwareAppId_example"; // String | ObjectID of the Software App.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
try {
    List<GraphObjectWithPaths> result = apiInstance.graphSoftwareappsTraverseSystem(softwareAppId, limit, xOrgId, skip, filter);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SoftwareAppsApi#graphSoftwareappsTraverseSystem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **softwareAppId** | **String**| ObjectID of the Software App. |
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphSoftwareappsTraverseSystemGroup"></a>
# **graphSoftwareappsTraverseSystemGroup**
> List&lt;GraphObjectWithPaths&gt; graphSoftwareappsTraverseSystemGroup(softwareAppId, limit, xOrgId, skip, filter)

List the System Groups bound to a Software App.

This endpoint will return all Systems Groups bound to a Software App, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the group&#x27;s type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this Software App to the corresponding System Group; this array represents all grouping and/or associations that would have to be removed to deprovision the System Group from this Software App.  See &#x60;/associations&#x60; endpoint to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET  https://console.jumpcloud.com/api/v2/softwareapps/{software_app_id}/systemgroups \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SoftwareAppsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

SoftwareAppsApi apiInstance = new SoftwareAppsApi();
String softwareAppId = "softwareAppId_example"; // String | ObjectID of the Software App.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
try {
    List<GraphObjectWithPaths> result = apiInstance.graphSoftwareappsTraverseSystemGroup(softwareAppId, limit, xOrgId, skip, filter);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SoftwareAppsApi#graphSoftwareappsTraverseSystemGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **softwareAppId** | **String**| ObjectID of the Software App. |
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="softwareAppStatusesList"></a>
# **softwareAppStatusesList**
> List&lt;SoftwareAppStatus&gt; softwareAppStatusesList(softwareAppId, xOrgId, filter, limit, skip, sort)

Get the status of the provided Software Application

This endpoint allows you to get the status of the provided Software Application on associated JumpCloud systems.  #### Sample Request &#x60;&#x60;&#x60; $ curl -X GET https://console.jumpcloud.com/api/v2/softwareapps/{software_app_id}/statuses \\ -H &#x27;Accept: application/json&#x27; \\ -H &#x27;Content-Type: application/json&#x27; \\ -H &#x27;x-api-key: {API_KEY}&#x27; \\ &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SoftwareAppsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

SoftwareAppsApi apiInstance = new SoftwareAppsApi();
String softwareAppId = "softwareAppId_example"; // String | ObjectID of the Software App.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> sort = Arrays.asList("sort_example"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
try {
    List<SoftwareAppStatus> result = apiInstance.softwareAppStatusesList(softwareAppId, xOrgId, filter, limit, skip, sort);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SoftwareAppsApi#softwareAppStatusesList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **softwareAppId** | **String**| ObjectID of the Software App. |
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **sort** | [**List&lt;String&gt;**](String.md)| The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  | [optional]

### Return type

[**List&lt;SoftwareAppStatus&gt;**](SoftwareAppStatus.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="softwareAppsDelete"></a>
# **softwareAppsDelete**
> softwareAppsDelete(id, xOrgId)

Delete a configured Software Application

Removes a Software Application configuration.  Warning: This is a destructive operation and will unmanage the application on all affected systems.  #### Sample Request &#x60;&#x60;&#x60; curl -X DELETE https://console.jumpcloud.com/api/v2/softwareapps/{id} \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SoftwareAppsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

SoftwareAppsApi apiInstance = new SoftwareAppsApi();
String id = "id_example"; // String | 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    apiInstance.softwareAppsDelete(id, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling SoftwareAppsApi#softwareAppsDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="softwareAppsGet"></a>
# **softwareAppsGet**
> SoftwareApp softwareAppsGet(id, xOrgId)

Retrieve a configured Software Application.

Retrieves a Software Application. The optional isConfigEnabled and appConfiguration apple_vpp attributes are populated in this response.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/softwareapps/{id} \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SoftwareAppsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

SoftwareAppsApi apiInstance = new SoftwareAppsApi();
String id = "id_example"; // String | 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    SoftwareApp result = apiInstance.softwareAppsGet(id, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SoftwareAppsApi#softwareAppsGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**SoftwareApp**](SoftwareApp.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="softwareAppsList"></a>
# **softwareAppsList**
> List&lt;SoftwareApp&gt; softwareAppsList(xOrgId, filter, limit, skip, sort)

Get all configured Software Applications.

This endpoint allows you to get all configured Software Applications that will be managed by JumpCloud on associated JumpCloud systems. The optional isConfigEnabled and appConfiguration apple_vpp attributes are not included in the response.  #### Sample Request &#x60;&#x60;&#x60; $ curl -X GET https://console.jumpcloud.com/api/v2/softwareapps \\ -H &#x27;Accept: application/json&#x27; \\ -H &#x27;Content-Type: application/json&#x27; \\ -H &#x27;x-api-key: {API_KEY}&#x27; \\ &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SoftwareAppsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

SoftwareAppsApi apiInstance = new SoftwareAppsApi();
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> sort = Arrays.asList("sort_example"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
try {
    List<SoftwareApp> result = apiInstance.softwareAppsList(xOrgId, filter, limit, skip, sort);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SoftwareAppsApi#softwareAppsList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **sort** | [**List&lt;String&gt;**](String.md)| The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  | [optional]

### Return type

[**List&lt;SoftwareApp&gt;**](SoftwareApp.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="softwareAppsPost"></a>
# **softwareAppsPost**
> SoftwareApp softwareAppsPost(body, xOrgId)

Create a Software Application that will be managed by JumpCloud.

This endpoint allows you to create a Software Application that will be managed by JumpCloud on associated JumpCloud systems. The optional isConfigEnabled and appConfiguration apple_vpp attributes are not included in the response.  #### Sample Request &#x60;&#x60;&#x60; $ curl -X POST https://console.jumpcloud.com/api/v2/softwareapps \\ -H &#x27;Accept: application/json&#x27; \\ -H &#x27;Content-Type: application/json&#x27; \\ -H &#x27;x-api-key: {API_KEY}&#x27; \\ -d &#x27;{   \&quot;displayName\&quot;: \&quot;Adobe Reader\&quot;,   \&quot;settings\&quot;: [{\&quot;packageId\&quot;: \&quot;adobereader\&quot;}] }&#x27; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SoftwareAppsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

SoftwareAppsApi apiInstance = new SoftwareAppsApi();
SoftwareApp body = new SoftwareApp(); // SoftwareApp | 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    SoftwareApp result = apiInstance.softwareAppsPost(body, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SoftwareAppsApi#softwareAppsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**SoftwareApp**](SoftwareApp.md)|  | [optional]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**SoftwareApp**](SoftwareApp.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="softwareAppsReclaimLicenses"></a>
# **softwareAppsReclaimLicenses**
> SoftwareAppReclaimLicenses softwareAppsReclaimLicenses(softwareAppId)

Reclaim Licenses for a Software Application.

This endpoint allows you to reclaim the licenses from a software app associated with devices that are deleted. #### Sample Request &#x60;&#x60;&#x60; $ curl -X POST https://console.jumpcloud.com/api/v2/softwareapps/{software_app_id}/reclaim-licenses \\ -H &#x27;Accept: application/json&#x27; \\ -H &#x27;Content-Type: application/json&#x27; \\ -H &#x27;x-api-key: {API_KEY}&#x27; \\ -d &#x27;{}&#x27; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SoftwareAppsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

SoftwareAppsApi apiInstance = new SoftwareAppsApi();
String softwareAppId = "softwareAppId_example"; // String | 
try {
    SoftwareAppReclaimLicenses result = apiInstance.softwareAppsReclaimLicenses(softwareAppId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SoftwareAppsApi#softwareAppsReclaimLicenses");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **softwareAppId** | **String**|  |

### Return type

[**SoftwareAppReclaimLicenses**](SoftwareAppReclaimLicenses.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="softwareAppsRetryInstallation"></a>
# **softwareAppsRetryInstallation**
> softwareAppsRetryInstallation(body, softwareAppId)

Retry Installation for a Software Application

This endpoints initiates an installation retry of an Apple VPP App for the provided system IDs #### Sample Request &#x60;&#x60;&#x60; $ curl -X POST https://console.jumpcloud.com/api/v2/softwareapps/{software_app_id}/retry-installation \\ -H &#x27;Accept: application/json&#x27; \\ -H &#x27;Content-Type: application/json&#x27; \\ -H &#x27;x-api-key: {API_KEY}&#x27; \\ -d &#x27;{\&quot;system_ids\&quot;: \&quot;{&lt;system_id_1&gt;, &lt;system_id_2&gt;, ...}\&quot;}&#x27; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SoftwareAppsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

SoftwareAppsApi apiInstance = new SoftwareAppsApi();
SoftwareAppsRetryInstallationRequest body = new SoftwareAppsRetryInstallationRequest(); // SoftwareAppsRetryInstallationRequest | 
String softwareAppId = "softwareAppId_example"; // String | 
try {
    apiInstance.softwareAppsRetryInstallation(body, softwareAppId);
} catch (ApiException e) {
    System.err.println("Exception when calling SoftwareAppsApi#softwareAppsRetryInstallation");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**SoftwareAppsRetryInstallationRequest**](SoftwareAppsRetryInstallationRequest.md)|  |
 **softwareAppId** | **String**|  |

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="softwareAppsUpdate"></a>
# **softwareAppsUpdate**
> SoftwareApp softwareAppsUpdate(id, body, xOrgId)

Update a Software Application Configuration.

This endpoint updates a specific Software Application configuration for the organization. displayName can be changed alone if no settings are provided. If a setting is provided, it should include all its information since this endpoint will update all the settings&#x27; fields. The optional isConfigEnabled and appConfiguration apple_vpp attributes are not included in the response.  #### Sample Request - displayName only &#x60;&#x60;&#x60;  curl -X PUT https://console.jumpcloud.com/api/v2/softwareapps/{id} \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{     \&quot;displayName\&quot;: \&quot;My Software App\&quot;   }&#x27; &#x60;&#x60;&#x60;  #### Sample Request - all attributes &#x60;&#x60;&#x60;  curl -X PUT https://console.jumpcloud.com/api/v2/softwareapps/{id} \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{     \&quot;displayName\&quot;: \&quot;My Software App\&quot;,     \&quot;settings\&quot;: [       {         \&quot;packageId\&quot;: \&quot;123456\&quot;,         \&quot;autoUpdate\&quot;: false,         \&quot;allowUpdateDelay\&quot;: false,         \&quot;packageManager\&quot;: \&quot;APPLE_VPP\&quot;,         \&quot;locationObjectId\&quot;: \&quot;123456789012123456789012\&quot;,         \&quot;location\&quot;: \&quot;123456\&quot;,         \&quot;desiredState\&quot;: \&quot;Install\&quot;,         \&quot;appleVpp\&quot;: {           \&quot;appConfiguration\&quot;: \&quot;&lt;?xml version&#x3D;\\\&quot;1.0\\\&quot; encoding&#x3D;\\\&quot;UTF-8\\\&quot;?&gt;&lt;!DOCTYPE plist PUBLIC \\\&quot;-//Apple//DTD PLIST 1.0//EN\\\&quot; \\\&quot;http://www.apple.com/DTDs/PropertyList-1.0.dtd\\\&quot;&gt;&lt;plist version&#x3D;\\\&quot;1.0\\\&quot;&gt;&lt;dict&gt;&lt;key&gt;MyKey&lt;/key&gt;&lt;string&gt;My String&lt;/string&gt;&lt;/dict&gt;&lt;/plist&gt;\&quot;,           \&quot;assignedLicenses\&quot;: 20,           \&quot;availableLicenses\&quot;: 10,           \&quot;details\&quot;: {},           \&quot;isConfigEnabled\&quot;: true,           \&quot;supportedDeviceFamilies\&quot;: [             \&quot;IPAD\&quot;,             \&quot;MAC\&quot;           ],           \&quot;totalLicenses\&quot;: 30         },         \&quot;packageSubtitle\&quot;: \&quot;My package subtitle\&quot;,         \&quot;packageVersion\&quot;: \&quot;1.2.3\&quot;,         \&quot;packageKind\&quot;: \&quot;software-package\&quot;,         \&quot;assetKind\&quot;: \&quot;software\&quot;,         \&quot;assetSha256Size\&quot;: 256,         \&quot;assetSha256Strings\&quot;: [           \&quot;a123b123c123d123\&quot;         ],         \&quot;description\&quot;: \&quot;My app description\&quot;       }     ]   }&#x27; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SoftwareAppsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

SoftwareAppsApi apiInstance = new SoftwareAppsApi();
String id = "id_example"; // String | 
SoftwareApp body = new SoftwareApp(); // SoftwareApp | 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    SoftwareApp result = apiInstance.softwareAppsUpdate(id, body, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SoftwareAppsApi#softwareAppsUpdate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **body** | [**SoftwareApp**](SoftwareApp.md)|  | [optional]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**SoftwareApp**](SoftwareApp.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

