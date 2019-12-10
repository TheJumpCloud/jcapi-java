# DefaultApi

All URIs are relative to *https://console.jumpcloud.com/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**jcEnrollmentProfilesDelete**](DefaultApi.md#jcEnrollmentProfilesDelete) | **DELETE** /enrollmentprofiles/{enrollment_profile_id} | Delete Enrollment Profile
[**jcEnrollmentProfilesGet**](DefaultApi.md#jcEnrollmentProfilesGet) | **GET** /enrollmentprofiles/{enrollment_profile_id} | Get Enrollment Profile
[**jcEnrollmentProfilesList**](DefaultApi.md#jcEnrollmentProfilesList) | **GET** /enrollmentprofiles | List Enrollment Profiles
[**jcEnrollmentProfilesPost**](DefaultApi.md#jcEnrollmentProfilesPost) | **POST** /enrollmentprofiles | Create new Enrollment Profile
[**jcEnrollmentProfilesPut**](DefaultApi.md#jcEnrollmentProfilesPut) | **PUT** /enrollmentprofiles/{enrollment_profile_id} | Update Enrollment Profile


<a name="jcEnrollmentProfilesDelete"></a>
# **jcEnrollmentProfilesDelete**
> JcEnrollmentProfile jcEnrollmentProfilesDelete(enrollmentProfileId)

Delete Enrollment Profile

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String enrollmentProfileId = "enrollmentProfileId_example"; // String | 
try {
    JcEnrollmentProfile result = apiInstance.jcEnrollmentProfilesDelete(enrollmentProfileId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#jcEnrollmentProfilesDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **enrollmentProfileId** | **String**|  |

### Return type

[**JcEnrollmentProfile**](JcEnrollmentProfile.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="jcEnrollmentProfilesGet"></a>
# **jcEnrollmentProfilesGet**
> jcEnrollmentProfilesGet(enrollmentProfileId, body)

Get Enrollment Profile

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String enrollmentProfileId = "enrollmentProfileId_example"; // String | 
JcEnrollmentProfile body = new JcEnrollmentProfile(); // JcEnrollmentProfile | 
try {
    apiInstance.jcEnrollmentProfilesGet(enrollmentProfileId, body);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#jcEnrollmentProfilesGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **enrollmentProfileId** | **String**|  |
 **body** | [**JcEnrollmentProfile**](JcEnrollmentProfile.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="jcEnrollmentProfilesList"></a>
# **jcEnrollmentProfilesList**
> List&lt;JcEnrollmentProfile&gt; jcEnrollmentProfilesList(limit, skip)

List Enrollment Profiles

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
Integer limit = 10; // Integer | 
Integer skip = 0; // Integer | The offset into the records to return.
try {
    List<JcEnrollmentProfile> result = apiInstance.jcEnrollmentProfilesList(limit, skip);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#jcEnrollmentProfilesList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**|  | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]

### Return type

[**List&lt;JcEnrollmentProfile&gt;**](JcEnrollmentProfile.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="jcEnrollmentProfilesPost"></a>
# **jcEnrollmentProfilesPost**
> JcEnrollmentProfile jcEnrollmentProfilesPost(body)

Create new Enrollment Profile

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
Body1 body = new Body1(); // Body1 | 
try {
    JcEnrollmentProfile result = apiInstance.jcEnrollmentProfilesPost(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#jcEnrollmentProfilesPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Body1**](Body1.md)|  | [optional]

### Return type

[**JcEnrollmentProfile**](JcEnrollmentProfile.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="jcEnrollmentProfilesPut"></a>
# **jcEnrollmentProfilesPut**
> JcEnrollmentProfile jcEnrollmentProfilesPut(enrollmentProfileId, body)

Update Enrollment Profile

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String enrollmentProfileId = "enrollmentProfileId_example"; // String | 
Body2 body = new Body2(); // Body2 | 
try {
    JcEnrollmentProfile result = apiInstance.jcEnrollmentProfilesPut(enrollmentProfileId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#jcEnrollmentProfilesPut");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **enrollmentProfileId** | **String**|  |
 **body** | [**Body2**](Body2.md)|  | [optional]

### Return type

[**JcEnrollmentProfile**](JcEnrollmentProfile.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

