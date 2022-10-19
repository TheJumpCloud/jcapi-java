# ApplicationsApi

All URIs are relative to *https://console.jumpcloud.com/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**applicationsDelete**](ApplicationsApi.md#applicationsDelete) | **DELETE** /applications/{id} | Delete an Application
[**applicationsGet**](ApplicationsApi.md#applicationsGet) | **GET** /applications/{id} | Get an Application
[**applicationsList**](ApplicationsApi.md#applicationsList) | **GET** /applications | Applications
[**applicationsPost**](ApplicationsApi.md#applicationsPost) | **POST** /applications | Create an Application
[**applicationsPut**](ApplicationsApi.md#applicationsPut) | **PUT** /applications/{id} | Update an Application

<a name="applicationsDelete"></a>
# **applicationsDelete**
> Application applicationsDelete(id, xOrgId)

Delete an Application

The endpoint deletes an SSO / SAML Application.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ApplicationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ApplicationsApi apiInstance = new ApplicationsApi();
String id = "id_example"; // String | 
String xOrgId = "xOrgId_example"; // String | 
try {
    Application result = apiInstance.applicationsDelete(id, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ApplicationsApi#applicationsDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **xOrgId** | **String**|  | [optional]

### Return type

[**Application**](Application.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="applicationsGet"></a>
# **applicationsGet**
> Application applicationsGet(id, xOrgId)

Get an Application

The endpoint retrieves an SSO / SAML Application.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ApplicationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ApplicationsApi apiInstance = new ApplicationsApi();
String id = "id_example"; // String | 
String xOrgId = "xOrgId_example"; // String | 
try {
    Application result = apiInstance.applicationsGet(id, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ApplicationsApi#applicationsGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **xOrgId** | **String**|  | [optional]

### Return type

[**Application**](Application.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="applicationsList"></a>
# **applicationsList**
> Applicationslist applicationsList(fields, limit, skip, sort, filter, xOrgId)

Applications

The endpoint returns all your SSO / SAML Applications.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/applications \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27;  &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ApplicationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ApplicationsApi apiInstance = new ApplicationsApi();
String fields = "fields_example"; // String | The space separated fields included in the returned records. If omitted the default list of fields will be returned.
Integer limit = 56; // Integer | The number of records to return at once.
Integer skip = 56; // Integer | The offset into the records to return.
String sort = "name"; // String | The space separated fields used to sort the collection. Default sort is ascending, prefix with - to sort descending.
String filter = "filter_example"; // String | A filter to apply to the query. See the supported operators below. For more complex searches, see the related `/search/<domain>` endpoints, e.g. `/search/systems`.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** = Supported operators are: - `$eq` (equals) - `$ne` (does not equal) - `$gt` (is greater than) - `$gte` (is greater than or equal to) - `$lt` (is less than) - `$lte` (is less than or equal to)  _Note: v1 operators differ from v2 operators._  _Note: For v1 operators, excluding the `$` will result in undefined behavior._  **value** = Populate with the value you want to search for. Is case sensitive.  **Examples** - `GET /users?filter=username:$eq:testuser` - `GET /systemusers?filter=password_expiration_date:$lte:2021-10-24` - `GET /systemusers?filter=department:$ne:Accounting` - `GET /systems?filter[0]=firstname:$eq:foo&filter[1]=lastname:$eq:bar` - this will    AND the filters together. - `GET /systems?filter[or][0]=lastname:$eq:foo&filter[or][1]=lastname:$eq:bar` - this will    OR the filters together.
String xOrgId = "xOrgId_example"; // String | 
try {
    Applicationslist result = apiInstance.applicationsList(fields, limit, skip, sort, filter, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ApplicationsApi#applicationsList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fields** | **String**| The space separated fields included in the returned records. If omitted the default list of fields will be returned. | [optional]
 **limit** | **Integer**| The number of records to return at once. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional]
 **sort** | **String**| The space separated fields used to sort the collection. Default sort is ascending, prefix with - to sort descending. | [optional] [default to name]
 **filter** | **String**| A filter to apply to the query. See the supported operators below. For more complex searches, see the related &#x60;/search/&lt;domain&gt;&#x60; endpoints, e.g. &#x60;/search/systems&#x60;.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D; Supported operators are: - &#x60;$eq&#x60; (equals) - &#x60;$ne&#x60; (does not equal) - &#x60;$gt&#x60; (is greater than) - &#x60;$gte&#x60; (is greater than or equal to) - &#x60;$lt&#x60; (is less than) - &#x60;$lte&#x60; (is less than or equal to)  _Note: v1 operators differ from v2 operators._  _Note: For v1 operators, excluding the &#x60;$&#x60; will result in undefined behavior._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive.  **Examples** - &#x60;GET /users?filter&#x3D;username:$eq:testuser&#x60; - &#x60;GET /systemusers?filter&#x3D;password_expiration_date:$lte:2021-10-24&#x60; - &#x60;GET /systemusers?filter&#x3D;department:$ne:Accounting&#x60; - &#x60;GET /systems?filter[0]&#x3D;firstname:$eq:foo&amp;filter[1]&#x3D;lastname:$eq:bar&#x60; - this will    AND the filters together. - &#x60;GET /systems?filter[or][0]&#x3D;lastname:$eq:foo&amp;filter[or][1]&#x3D;lastname:$eq:bar&#x60; - this will    OR the filters together. | [optional]
 **xOrgId** | **String**|  | [optional]

### Return type

[**Applicationslist**](Applicationslist.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="applicationsPost"></a>
# **applicationsPost**
> Application applicationsPost(body, xOrgId)

Create an Application

The endpoint adds a new SSO / SAML Applications.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ApplicationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ApplicationsApi apiInstance = new ApplicationsApi();
Application body = new Application(); // Application | 
String xOrgId = "xOrgId_example"; // String | 
try {
    Application result = apiInstance.applicationsPost(body, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ApplicationsApi#applicationsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Application**](Application.md)|  | [optional]
 **xOrgId** | **String**|  | [optional]

### Return type

[**Application**](Application.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="applicationsPut"></a>
# **applicationsPut**
> Application applicationsPut(id, body, xOrgId)

Update an Application

The endpoint updates a SSO / SAML Application. Any fields not provided will be reset or created with default values.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ApplicationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ApplicationsApi apiInstance = new ApplicationsApi();
String id = "id_example"; // String | 
Application body = new Application(); // Application | 
String xOrgId = "xOrgId_example"; // String | 
try {
    Application result = apiInstance.applicationsPut(id, body, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ApplicationsApi#applicationsPut");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **body** | [**Application**](Application.md)|  | [optional]
 **xOrgId** | **String**|  | [optional]

### Return type

[**Application**](Application.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

