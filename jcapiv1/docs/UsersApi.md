# UsersApi

All URIs are relative to *https://console.jumpcloud.com/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**adminTotpresetBegin**](UsersApi.md#adminTotpresetBegin) | **POST** /users/resettotp/{id} | Administrator TOTP Reset Initiation
[**usersPut**](UsersApi.md#usersPut) | **PUT** /users/{id} | Update a user
[**usersReactivateGet**](UsersApi.md#usersReactivateGet) | **GET** /users/reactivate/{id} | Administrator Password Reset Initiation

<a name="adminTotpresetBegin"></a>
# **adminTotpresetBegin**
> adminTotpresetBegin(id)

Administrator TOTP Reset Initiation

This endpoint initiates a TOTP reset for an admin. This request does not accept a body.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.UsersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

UsersApi apiInstance = new UsersApi();
String id = "id_example"; // String | 
try {
    apiInstance.adminTotpresetBegin(id);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersApi#adminTotpresetBegin");
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

<a name="usersPut"></a>
# **usersPut**
> Userreturn usersPut(id, body, xOrgId)

Update a user

This endpoint allows you to update a user.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.UsersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

UsersApi apiInstance = new UsersApi();
String id = "id_example"; // String | 
Userput body = new Userput(); // Userput | 
String xOrgId = "xOrgId_example"; // String | 
try {
    Userreturn result = apiInstance.usersPut(id, body, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersApi#usersPut");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **body** | [**Userput**](Userput.md)|  | [optional]
 **xOrgId** | **String**|  | [optional]

### Return type

[**Userreturn**](Userreturn.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="usersReactivateGet"></a>
# **usersReactivateGet**
> usersReactivateGet(id)

Administrator Password Reset Initiation

This endpoint triggers the sending of a reactivation e-mail to an administrator.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.UsersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

UsersApi apiInstance = new UsersApi();
String id = "id_example"; // String | 
try {
    apiInstance.usersReactivateGet(id);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersApi#usersReactivateGet");
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

