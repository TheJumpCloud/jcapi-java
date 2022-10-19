# AuthenticationPoliciesApi

All URIs are relative to *https://console.jumpcloud.com/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**authnpoliciesDelete**](AuthenticationPoliciesApi.md#authnpoliciesDelete) | **DELETE** /authn/policies/{id} | Delete Authentication Policy
[**authnpoliciesGet**](AuthenticationPoliciesApi.md#authnpoliciesGet) | **GET** /authn/policies/{id} | Get an authentication policy
[**authnpoliciesList**](AuthenticationPoliciesApi.md#authnpoliciesList) | **GET** /authn/policies | List Authentication Policies
[**authnpoliciesPatch**](AuthenticationPoliciesApi.md#authnpoliciesPatch) | **PATCH** /authn/policies/{id} | Patch Authentication Policy
[**authnpoliciesPost**](AuthenticationPoliciesApi.md#authnpoliciesPost) | **POST** /authn/policies | Create an Authentication Policy

<a name="authnpoliciesDelete"></a>
# **authnpoliciesDelete**
> AuthnPolicy authnpoliciesDelete(id, xOrgId)

Delete Authentication Policy

Delete the specified authentication policy.  #### Sample Request &#x60;&#x60;&#x60; curl -X DELETE https://console.jumpcloud.com/api/v2/authn/policies/{id} \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AuthenticationPoliciesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

AuthenticationPoliciesApi apiInstance = new AuthenticationPoliciesApi();
String id = "id_example"; // String | Unique identifier of the authentication policy
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    AuthnPolicy result = apiInstance.authnpoliciesDelete(id, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthenticationPoliciesApi#authnpoliciesDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Unique identifier of the authentication policy |
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**AuthnPolicy**](AuthnPolicy.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="authnpoliciesGet"></a>
# **authnpoliciesGet**
> AuthnPolicy authnpoliciesGet(id, xOrgId)

Get an authentication policy

Return a specific authentication policy.  #### Sample Request &#x60;&#x60;&#x60; curl https://console.jumpcloud.com/api/v2/authn/policies/{id} \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AuthenticationPoliciesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

AuthenticationPoliciesApi apiInstance = new AuthenticationPoliciesApi();
String id = "id_example"; // String | Unique identifier of the authentication policy
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    AuthnPolicy result = apiInstance.authnpoliciesGet(id, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthenticationPoliciesApi#authnpoliciesGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Unique identifier of the authentication policy |
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**AuthnPolicy**](AuthnPolicy.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="authnpoliciesList"></a>
# **authnpoliciesList**
> List&lt;AuthnPolicy&gt; authnpoliciesList(xOrgId, xTotalCount, limit, skip, filter, sort)

List Authentication Policies

Get a list of all authentication policies.  #### Sample Request &#x60;&#x60;&#x60; curl https://console.jumpcloud.com/api/v2/authn/policies \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AuthenticationPoliciesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

AuthenticationPoliciesApi apiInstance = new AuthenticationPoliciesApi();
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer xTotalCount = 56; // Integer | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
List<String> sort = Arrays.asList("sort_example"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
try {
    List<AuthnPolicy> result = apiInstance.authnpoliciesList(xOrgId, xTotalCount, limit, skip, filter, sort);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthenticationPoliciesApi#authnpoliciesList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **xTotalCount** | **Integer**|  | [optional]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]
 **sort** | [**List&lt;String&gt;**](String.md)| The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  | [optional]

### Return type

[**List&lt;AuthnPolicy&gt;**](AuthnPolicy.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="authnpoliciesPatch"></a>
# **authnpoliciesPatch**
> AuthnPolicy authnpoliciesPatch(id, body, xOrgId)

Patch Authentication Policy

Patch the specified authentication policy.  #### Sample Request &#x60;&#x60;&#x60; curl -X PATCH https://console.jumpcloud.com/api/v2/authn/policies/{id} \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{ \&quot;disabled\&quot;: false }&#x27; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AuthenticationPoliciesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

AuthenticationPoliciesApi apiInstance = new AuthenticationPoliciesApi();
String id = "id_example"; // String | Unique identifier of the authentication policy
AuthnPolicyInput body = new AuthnPolicyInput(); // AuthnPolicyInput | 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    AuthnPolicy result = apiInstance.authnpoliciesPatch(id, body, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthenticationPoliciesApi#authnpoliciesPatch");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Unique identifier of the authentication policy |
 **body** | [**AuthnPolicyInput**](AuthnPolicyInput.md)|  | [optional]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**AuthnPolicy**](AuthnPolicy.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="authnpoliciesPost"></a>
# **authnpoliciesPost**
> AuthnPolicy authnpoliciesPost(body, xOrgId)

Create an Authentication Policy

Create an authentication policy.  #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/authn/policies \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{     \&quot;name\&quot;: \&quot;Sample Policy\&quot;,     \&quot;disabled\&quot;: false,     \&quot;effect\&quot;: {       \&quot;action\&quot;: \&quot;allow\&quot;     },     \&quot;targets\&quot;: {       \&quot;users\&quot;: {         \&quot;inclusions\&quot;: [\&quot;ALL\&quot;]       },       \&quot;userGroups\&quot;: {         \&quot;exclusions\&quot;: [{USER_GROUP_ID}]       },       \&quot;resources\&quot;: [ {\&quot;type\&quot;: \&quot;user_portal\&quot; } ]     },     \&quot;conditions\&quot;:{       \&quot;ipAddressIn\&quot;: [{IP_LIST_ID}]     }   }&#x27; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AuthenticationPoliciesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

AuthenticationPoliciesApi apiInstance = new AuthenticationPoliciesApi();
AuthnPolicyInput body = new AuthnPolicyInput(); // AuthnPolicyInput | 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    AuthnPolicy result = apiInstance.authnpoliciesPost(body, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthenticationPoliciesApi#authnpoliciesPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**AuthnPolicyInput**](AuthnPolicyInput.md)|  | [optional]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**AuthnPolicy**](AuthnPolicy.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

