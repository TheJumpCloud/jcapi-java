# SystemusersApi

All URIs are relative to *https://console.jumpcloud.com/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**sshkeyDelete**](SystemusersApi.md#sshkeyDelete) | **DELETE** /systemusers/{systemuser_id}/sshkeys/{id} | Delete a system user&#x27;s Public SSH Keys
[**sshkeyList**](SystemusersApi.md#sshkeyList) | **GET** /systemusers/{id}/sshkeys | List a system user&#x27;s public SSH keys
[**sshkeyPost**](SystemusersApi.md#sshkeyPost) | **POST** /systemusers/{id}/sshkeys | Create a system user&#x27;s Public SSH Key
[**systemusersDelete**](SystemusersApi.md#systemusersDelete) | **DELETE** /systemusers/{id} | Delete a system user
[**systemusersExpire**](SystemusersApi.md#systemusersExpire) | **POST** /systemusers/{id}/expire | Expire a system user&#x27;s password
[**systemusersGet**](SystemusersApi.md#systemusersGet) | **GET** /systemusers/{id} | List a system user
[**systemusersList**](SystemusersApi.md#systemusersList) | **GET** /systemusers | List all system users
[**systemusersMfasync**](SystemusersApi.md#systemusersMfasync) | **POST** /systemusers/{id}/mfasync | Sync a systemuser&#x27;s mfa enrollment status
[**systemusersPost**](SystemusersApi.md#systemusersPost) | **POST** /systemusers | Create a system user
[**systemusersPut**](SystemusersApi.md#systemusersPut) | **PUT** /systemusers/{id} | Update a system user
[**systemusersResetmfa**](SystemusersApi.md#systemusersResetmfa) | **POST** /systemusers/{id}/resetmfa | Reset a system user&#x27;s MFA token
[**systemusersStateActivate**](SystemusersApi.md#systemusersStateActivate) | **POST** /systemusers/{id}/state/activate | Activate System User
[**systemusersUnlock**](SystemusersApi.md#systemusersUnlock) | **POST** /systemusers/{id}/unlock | Unlock a system user

<a name="sshkeyDelete"></a>
# **sshkeyDelete**
> String sshkeyDelete(systemuserId, id, xOrgId)

Delete a system user&#x27;s Public SSH Keys

This endpoint will delete a specific System User&#x27;s SSH Key.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SystemusersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

SystemusersApi apiInstance = new SystemusersApi();
String systemuserId = "systemuserId_example"; // String | 
String id = "id_example"; // String | 
String xOrgId = "xOrgId_example"; // String | 
try {
    String result = apiInstance.sshkeyDelete(systemuserId, id, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemusersApi#sshkeyDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **systemuserId** | **String**|  |
 **id** | **String**|  |
 **xOrgId** | **String**|  | [optional]

### Return type

**String**

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/plain

<a name="sshkeyList"></a>
# **sshkeyList**
> List&lt;Sshkeylist&gt; sshkeyList(id, xOrgId)

List a system user&#x27;s public SSH keys

This endpoint will return a specific System User&#x27;s public SSH key.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SystemusersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

SystemusersApi apiInstance = new SystemusersApi();
String id = "id_example"; // String | 
String xOrgId = "xOrgId_example"; // String | 
try {
    List<Sshkeylist> result = apiInstance.sshkeyList(id, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemusersApi#sshkeyList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **xOrgId** | **String**|  | [optional]

### Return type

[**List&lt;Sshkeylist&gt;**](Sshkeylist.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="sshkeyPost"></a>
# **sshkeyPost**
> Sshkeylist sshkeyPost(id, body, xOrgId)

Create a system user&#x27;s Public SSH Key

This endpoint will create a specific System User&#x27;s Public SSH Key.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SystemusersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

SystemusersApi apiInstance = new SystemusersApi();
String id = "id_example"; // String | 
Sshkeypost body = new Sshkeypost(); // Sshkeypost | 
String xOrgId = "xOrgId_example"; // String | 
try {
    Sshkeylist result = apiInstance.sshkeyPost(id, body, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemusersApi#sshkeyPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **body** | [**Sshkeypost**](Sshkeypost.md)|  | [optional]
 **xOrgId** | **String**|  | [optional]

### Return type

[**Sshkeylist**](Sshkeylist.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="systemusersDelete"></a>
# **systemusersDelete**
> Systemuserreturn systemusersDelete(id, xOrgId, cascadeManager)

Delete a system user

This endpoint allows you to delete a particular system user.  #### Sample Request &#x60;&#x60;&#x60; curl -X DELETE https://console.jumpcloud.com/api/systemusers/{UserID} \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SystemusersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

SystemusersApi apiInstance = new SystemusersApi();
String id = "id_example"; // String | 
String xOrgId = "xOrgId_example"; // String | 
String cascadeManager = "cascadeManager_example"; // String | This is an optional flag that can be enabled on the DELETE call, DELETE /systemusers/{id}?cascade_manager=null. This parameter will clear the Manager attribute on all direct reports and then delete the account.
try {
    Systemuserreturn result = apiInstance.systemusersDelete(id, xOrgId, cascadeManager);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemusersApi#systemusersDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **xOrgId** | **String**|  | [optional]
 **cascadeManager** | **String**| This is an optional flag that can be enabled on the DELETE call, DELETE /systemusers/{id}?cascade_manager&#x3D;null. This parameter will clear the Manager attribute on all direct reports and then delete the account. | [optional]

### Return type

[**Systemuserreturn**](Systemuserreturn.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="systemusersExpire"></a>
# **systemusersExpire**
> String systemusersExpire(id, xOrgId)

Expire a system user&#x27;s password

This endpoint allows you to expire a user&#x27;s password.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SystemusersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

SystemusersApi apiInstance = new SystemusersApi();
String id = "id_example"; // String | 
String xOrgId = "xOrgId_example"; // String | 
try {
    String result = apiInstance.systemusersExpire(id, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemusersApi#systemusersExpire");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **xOrgId** | **String**|  | [optional]

### Return type

**String**

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/plain

<a name="systemusersGet"></a>
# **systemusersGet**
> Systemuserreturn systemusersGet(id, fields, filter, xOrgId)

List a system user

This endpoint returns a particular System User.  #### Sample Request  &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/systemusers/{UserID} \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SystemusersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

SystemusersApi apiInstance = new SystemusersApi();
String id = "id_example"; // String | 
String fields = "fields_example"; // String | Use a space seperated string of field parameters to include the data in the response. If omitted, the default list of fields will be returned. 
String filter = "filter_example"; // String | A filter to apply to the query. See the supported operators below. For more complex searches, see the related `/search/<domain>` endpoints, e.g. `/search/systems`.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** = Supported operators are: - `$eq` (equals) - `$ne` (does not equal) - `$gt` (is greater than) - `$gte` (is greater than or equal to) - `$lt` (is less than) - `$lte` (is less than or equal to)  _Note: v1 operators differ from v2 operators._  _Note: For v1 operators, excluding the `$` will result in undefined behavior._  **value** = Populate with the value you want to search for. Is case sensitive.  **Examples** - `GET /users?filter=username:$eq:testuser` - `GET /systemusers?filter=password_expiration_date:$lte:2021-10-24` - `GET /systemusers?filter=department:$ne:Accounting` - `GET /systems?filter[0]=firstname:$eq:foo&filter[1]=lastname:$eq:bar` - this will    AND the filters together. - `GET /systems?filter[or][0]=lastname:$eq:foo&filter[or][1]=lastname:$eq:bar` - this will    OR the filters together.
String xOrgId = "xOrgId_example"; // String | 
try {
    Systemuserreturn result = apiInstance.systemusersGet(id, fields, filter, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemusersApi#systemusersGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **fields** | **String**| Use a space seperated string of field parameters to include the data in the response. If omitted, the default list of fields will be returned.  | [optional]
 **filter** | **String**| A filter to apply to the query. See the supported operators below. For more complex searches, see the related &#x60;/search/&lt;domain&gt;&#x60; endpoints, e.g. &#x60;/search/systems&#x60;.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D; Supported operators are: - &#x60;$eq&#x60; (equals) - &#x60;$ne&#x60; (does not equal) - &#x60;$gt&#x60; (is greater than) - &#x60;$gte&#x60; (is greater than or equal to) - &#x60;$lt&#x60; (is less than) - &#x60;$lte&#x60; (is less than or equal to)  _Note: v1 operators differ from v2 operators._  _Note: For v1 operators, excluding the &#x60;$&#x60; will result in undefined behavior._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive.  **Examples** - &#x60;GET /users?filter&#x3D;username:$eq:testuser&#x60; - &#x60;GET /systemusers?filter&#x3D;password_expiration_date:$lte:2021-10-24&#x60; - &#x60;GET /systemusers?filter&#x3D;department:$ne:Accounting&#x60; - &#x60;GET /systems?filter[0]&#x3D;firstname:$eq:foo&amp;filter[1]&#x3D;lastname:$eq:bar&#x60; - this will    AND the filters together. - &#x60;GET /systems?filter[or][0]&#x3D;lastname:$eq:foo&amp;filter[or][1]&#x3D;lastname:$eq:bar&#x60; - this will    OR the filters together. | [optional]
 **xOrgId** | **String**|  | [optional]

### Return type

[**Systemuserreturn**](Systemuserreturn.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="systemusersList"></a>
# **systemusersList**
> Systemuserslist systemusersList(limit, skip, sort, fields, filter, xOrgId, search)

List all system users

This endpoint returns all systemusers.  #### Sample Request  &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/systemusers \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SystemusersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

SystemusersApi apiInstance = new SystemusersApi();
Integer limit = 10; // Integer | The number of records to return at once.
Integer skip = 0; // Integer | The offset into the records to return.
String sort = "sort_example"; // String | The space separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
String fields = "fields_example"; // String | The space separated fields included in the returned records. If omitted the default list of fields will be returned. 
String filter = "filter_example"; // String | A filter to apply to the query. See the supported operators below. For more complex searches, see the related `/search/<domain>` endpoints, e.g. `/search/systems`.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** = Supported operators are: - `$eq` (equals) - `$ne` (does not equal) - `$gt` (is greater than) - `$gte` (is greater than or equal to) - `$lt` (is less than) - `$lte` (is less than or equal to)  _Note: v1 operators differ from v2 operators._  _Note: For v1 operators, excluding the `$` will result in undefined behavior._  **value** = Populate with the value you want to search for. Is case sensitive.  **Examples** - `GET /users?filter=username:$eq:testuser` - `GET /systemusers?filter=password_expiration_date:$lte:2021-10-24` - `GET /systemusers?filter=department:$ne:Accounting` - `GET /systems?filter[0]=firstname:$eq:foo&filter[1]=lastname:$eq:bar` - this will    AND the filters together. - `GET /systems?filter[or][0]=lastname:$eq:foo&filter[or][1]=lastname:$eq:bar` - this will    OR the filters together.
String xOrgId = "xOrgId_example"; // String | 
String search = "search_example"; // String | A nested object containing a `searchTerm` string or array of strings and a list of `fields` to search on.
try {
    Systemuserslist result = apiInstance.systemusersList(limit, skip, sort, fields, filter, xOrgId, search);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemusersApi#systemusersList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**| The number of records to return at once. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **sort** | **String**| The space separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  | [optional]
 **fields** | **String**| The space separated fields included in the returned records. If omitted the default list of fields will be returned.  | [optional]
 **filter** | **String**| A filter to apply to the query. See the supported operators below. For more complex searches, see the related &#x60;/search/&lt;domain&gt;&#x60; endpoints, e.g. &#x60;/search/systems&#x60;.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D; Supported operators are: - &#x60;$eq&#x60; (equals) - &#x60;$ne&#x60; (does not equal) - &#x60;$gt&#x60; (is greater than) - &#x60;$gte&#x60; (is greater than or equal to) - &#x60;$lt&#x60; (is less than) - &#x60;$lte&#x60; (is less than or equal to)  _Note: v1 operators differ from v2 operators._  _Note: For v1 operators, excluding the &#x60;$&#x60; will result in undefined behavior._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive.  **Examples** - &#x60;GET /users?filter&#x3D;username:$eq:testuser&#x60; - &#x60;GET /systemusers?filter&#x3D;password_expiration_date:$lte:2021-10-24&#x60; - &#x60;GET /systemusers?filter&#x3D;department:$ne:Accounting&#x60; - &#x60;GET /systems?filter[0]&#x3D;firstname:$eq:foo&amp;filter[1]&#x3D;lastname:$eq:bar&#x60; - this will    AND the filters together. - &#x60;GET /systems?filter[or][0]&#x3D;lastname:$eq:foo&amp;filter[or][1]&#x3D;lastname:$eq:bar&#x60; - this will    OR the filters together. | [optional]
 **xOrgId** | **String**|  | [optional]
 **search** | **String**| A nested object containing a &#x60;searchTerm&#x60; string or array of strings and a list of &#x60;fields&#x60; to search on. | [optional]

### Return type

[**Systemuserslist**](Systemuserslist.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="systemusersMfasync"></a>
# **systemusersMfasync**
> systemusersMfasync(id)

Sync a systemuser&#x27;s mfa enrollment status

This endpoint allows you to re-sync a user&#x27;s mfa enrollment status  #### Sample Request &#x60;&#x60;&#x60; curl -X POST \\   https://console.jumpcloud.com/api/systemusers/{UserID}/mfasync \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\  &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SystemusersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

SystemusersApi apiInstance = new SystemusersApi();
String id = "id_example"; // String | 
try {
    apiInstance.systemusersMfasync(id);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemusersApi#systemusersMfasync");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="systemusersPost"></a>
# **systemusersPost**
> Systemuserreturn systemusersPost(body, xOrgId, fullValidationDetails)

Create a system user

\&quot;This endpoint allows you to create a new system user.  #### Default User State The &#x60;state&#x60; of the user can be explicitly passed in or omitted. If &#x60;state&#x60; is omitted from the request, then the user will get created using the value returned from the [Get an Organization](https://docs.jumpcloud.com/api/1.0/index.html#operation/organizations_get) endpoint. The default user state for manually created users is stored in &#x60;settings.newSystemUserStateDefaults.manualEntry&#x60;  These default state values can be changed in the admin portal settings or by using the [Update an Organization](https://docs.jumpcloud.com/api/1.0/index.html#operation/organization_put) endpoint.  #### Sample Request  &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/systemusers \\ -H &#x27;Accept: application/json&#x27; \\ -H &#x27;Content-Type: application/json&#x27; \\ -H &#x27;x-api-key: {API_KEY}&#x27; \\ -d &#x27;{       \&quot;username\&quot;:\&quot;{username}\&quot;,       \&quot;email\&quot;:\&quot;{email_address}\&quot;,       \&quot;firstname\&quot;:\&quot;{Name}\&quot;,       \&quot;lastname\&quot;:\&quot;{Name}\&quot;     }&#x27; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SystemusersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

SystemusersApi apiInstance = new SystemusersApi();
Systemuserputpost body = new Systemuserputpost(); // Systemuserputpost | 
String xOrgId = "xOrgId_example"; // String | 
String fullValidationDetails = "fullValidationDetails_example"; // String | Pass this query parameter when a client wants all validation errors to be returned with a detailed error response for the form field specified. The current form fields are allowed:  * `password`  #### Password validation flag Use the `password` validation flag to receive details on a possible bad request response ``` ?fullValidationDetails=password ``` Without the flag, default behavior will be a normal 400 with only a single validation string error #### Expected Behavior Clients can expect a list of validation error mappings for the validation query field in the details provided on the response: ``` {   \"code\": 400,   \"message\": \"Password validation fail\",   \"status\": \"INVALID_ARGUMENT\",   \"details\": [       {         \"fieldViolationsList\": [           {\"field\": \"password\", \"description\": \"specialCharacter\"}         ],         '@type': 'type.googleapis.com/google.rpc.BadRequest',       },   ], }, ```
try {
    Systemuserreturn result = apiInstance.systemusersPost(body, xOrgId, fullValidationDetails);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemusersApi#systemusersPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Systemuserputpost**](Systemuserputpost.md)|  | [optional]
 **xOrgId** | **String**|  | [optional]
 **fullValidationDetails** | **String**| Pass this query parameter when a client wants all validation errors to be returned with a detailed error response for the form field specified. The current form fields are allowed:  * &#x60;password&#x60;  #### Password validation flag Use the &#x60;password&#x60; validation flag to receive details on a possible bad request response &#x60;&#x60;&#x60; ?fullValidationDetails&#x3D;password &#x60;&#x60;&#x60; Without the flag, default behavior will be a normal 400 with only a single validation string error #### Expected Behavior Clients can expect a list of validation error mappings for the validation query field in the details provided on the response: &#x60;&#x60;&#x60; {   \&quot;code\&quot;: 400,   \&quot;message\&quot;: \&quot;Password validation fail\&quot;,   \&quot;status\&quot;: \&quot;INVALID_ARGUMENT\&quot;,   \&quot;details\&quot;: [       {         \&quot;fieldViolationsList\&quot;: [           {\&quot;field\&quot;: \&quot;password\&quot;, \&quot;description\&quot;: \&quot;specialCharacter\&quot;}         ],         &#x27;@type&#x27;: &#x27;type.googleapis.com/google.rpc.BadRequest&#x27;,       },   ], }, &#x60;&#x60;&#x60; | [optional]

### Return type

[**Systemuserreturn**](Systemuserreturn.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="systemusersPut"></a>
# **systemusersPut**
> Systemuserreturn systemusersPut(id, body, xOrgId, fullValidationDetails)

Update a system user

This endpoint allows you to update a system user.  #### Sample Request  &#x60;&#x60;&#x60; curl -X PUT https://console.jumpcloud.com/api/systemusers/{UserID} \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{  \&quot;email\&quot;:\&quot;{email_address}\&quot;,  \&quot;firstname\&quot;:\&quot;{Name}\&quot;,  \&quot;lastname\&quot;:\&quot;{Name}\&quot; }&#x27; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SystemusersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

SystemusersApi apiInstance = new SystemusersApi();
String id = "id_example"; // String | 
Systemuserput body = new Systemuserput(); // Systemuserput | 
String xOrgId = "xOrgId_example"; // String | 
String fullValidationDetails = "fullValidationDetails_example"; // String | This endpoint can take in a query when a client wants all validation errors to be returned with error response for the form field specified, i.e. 'password' #### Password validation flag Use the \"password\" validation flag to receive details on a possible bad request response Without the `password` flag, default behavior will be a normal 400 with only a validation string message ``` ?fullValidationDetails=password ``` #### Expected Behavior Clients can expect a list of validation error mappings for the validation query field in the details provided on the response: ``` {   \"code\": 400,   \"message\": \"Password validation fail\",   \"status\": \"INVALID_ARGUMENT\",   \"details\": [       {         \"fieldViolationsList\": [{ \"field\": \"password\", \"description\": \"passwordHistory\" }],         '@type': 'type.googleapis.com/google.rpc.BadRequest',       },   ], }, ```
try {
    Systemuserreturn result = apiInstance.systemusersPut(id, body, xOrgId, fullValidationDetails);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemusersApi#systemusersPut");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **body** | [**Systemuserput**](Systemuserput.md)|  | [optional]
 **xOrgId** | **String**|  | [optional]
 **fullValidationDetails** | **String**| This endpoint can take in a query when a client wants all validation errors to be returned with error response for the form field specified, i.e. &#x27;password&#x27; #### Password validation flag Use the \&quot;password\&quot; validation flag to receive details on a possible bad request response Without the &#x60;password&#x60; flag, default behavior will be a normal 400 with only a validation string message &#x60;&#x60;&#x60; ?fullValidationDetails&#x3D;password &#x60;&#x60;&#x60; #### Expected Behavior Clients can expect a list of validation error mappings for the validation query field in the details provided on the response: &#x60;&#x60;&#x60; {   \&quot;code\&quot;: 400,   \&quot;message\&quot;: \&quot;Password validation fail\&quot;,   \&quot;status\&quot;: \&quot;INVALID_ARGUMENT\&quot;,   \&quot;details\&quot;: [       {         \&quot;fieldViolationsList\&quot;: [{ \&quot;field\&quot;: \&quot;password\&quot;, \&quot;description\&quot;: \&quot;passwordHistory\&quot; }],         &#x27;@type&#x27;: &#x27;type.googleapis.com/google.rpc.BadRequest&#x27;,       },   ], }, &#x60;&#x60;&#x60; | [optional]

### Return type

[**Systemuserreturn**](Systemuserreturn.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="systemusersResetmfa"></a>
# **systemusersResetmfa**
> String systemusersResetmfa(id, body, xOrgId)

Reset a system user&#x27;s MFA token

This endpoint allows you to reset the TOTP key for a specified system user and put them in an TOTP MFA enrollment period. This will result in the user being prompted to setup TOTP MFA when logging into userportal. Please be aware that if the user does not complete TOTP MFA setup before the &#x60;exclusionUntil&#x60; date, they will be locked out of any resources that require TOTP MFA.  Please refer to our [Knowledge Base Article](https://support.jumpcloud.com/customer/en/portal/articles/2959138-using-multifactor-authentication-with-jumpcloud) on setting up MFA for more information.  #### Sample Request &#x60;&#x60;&#x60; curl -X POST \\   https://console.jumpcloud.com/api/systemusers/{UserID}/resetmfa \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{\&quot;exclusion\&quot;: true, \&quot;exclusionUntil\&quot;: \&quot;{date-time}\&quot;}&#x27;  &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SystemusersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

SystemusersApi apiInstance = new SystemusersApi();
String id = "id_example"; // String | 
IdResetmfaBody body = new IdResetmfaBody(); // IdResetmfaBody | 
String xOrgId = "xOrgId_example"; // String | 
try {
    String result = apiInstance.systemusersResetmfa(id, body, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemusersApi#systemusersResetmfa");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **body** | [**IdResetmfaBody**](IdResetmfaBody.md)|  | [optional]
 **xOrgId** | **String**|  | [optional]

### Return type

**String**

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/plain

<a name="systemusersStateActivate"></a>
# **systemusersStateActivate**
> String systemusersStateActivate(id, body)

Activate System User

This endpoint changes the state of a STAGED user to ACTIVATED. #### Email Flag Use the \&quot;email\&quot; flag to determine whether or not to send a Welcome or Activation email to the newly activated user. Sending an empty body without the &#x60;email&#x60; flag, will send an email with default behavior (see the \&quot;Behavior\&quot; section below) &#x60;&#x60;&#x60; {} &#x60;&#x60;&#x60; Sending &#x60;email&#x3D;true&#x60; flag will send an email with default behavior (see &#x60;Behavior&#x60; below) &#x60;&#x60;&#x60; { \&quot;email\&quot;: true } &#x60;&#x60;&#x60; Populated email will override the default behavior and send to the specified email value &#x60;&#x60;&#x60; { \&quot;email\&quot;: \&quot;example@example.com\&quot; } &#x60;&#x60;&#x60; Sending &#x60;email&#x3D;false&#x60; will suppress sending the email &#x60;&#x60;&#x60; { \&quot;email\&quot;: false } &#x60;&#x60;&#x60; #### Behavior Users with a password will be sent a Welcome email to:   - The address specified in &#x60;email&#x60; flag in the request   - If no &#x60;email&#x60; flag, the user&#x27;s primary email address (default behavior) Users without a password will be sent an Activation email to:   - The address specified in &#x60;email&#x60; flag in the request   - If no &#x60;email&#x60; flag, the user&#x27;s alternate email address (default behavior)   - If no alternate email address, the user&#x27;s primary email address (default behavior)  #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/systemusers/{id}/state/activate \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: &lt;api-key&gt;&#x27; \\   -d &#x27;{ \&quot;email\&quot;: \&quot;alternate-activation-email@email.com\&quot; }&#x27;  &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SystemusersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

SystemusersApi apiInstance = new SystemusersApi();
String id = "id_example"; // String | 
StateActivateBody body = new StateActivateBody(); // StateActivateBody | 
try {
    String result = apiInstance.systemusersStateActivate(id, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemusersApi#systemusersStateActivate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **body** | [**StateActivateBody**](StateActivateBody.md)|  | [optional]

### Return type

**String**

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="systemusersUnlock"></a>
# **systemusersUnlock**
> String systemusersUnlock(id, xOrgId)

Unlock a system user

This endpoint allows you to unlock a user&#x27;s account.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SystemusersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

SystemusersApi apiInstance = new SystemusersApi();
String id = "id_example"; // String | 
String xOrgId = "xOrgId_example"; // String | 
try {
    String result = apiInstance.systemusersUnlock(id, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemusersApi#systemusersUnlock");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **xOrgId** | **String**|  | [optional]

### Return type

**String**

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/plain

