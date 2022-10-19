# OrganizationsApi

All URIs are relative to *https://console.jumpcloud.com/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**administratorOrganizationsCreateByAdministrator**](OrganizationsApi.md#administratorOrganizationsCreateByAdministrator) | **POST** /administrators/{id}/organizationlinks | Allow Adminstrator access to an Organization.
[**administratorOrganizationsListByAdministrator**](OrganizationsApi.md#administratorOrganizationsListByAdministrator) | **GET** /administrators/{id}/organizationlinks | List the association links between an Administrator and Organizations.
[**administratorOrganizationsListByOrganization**](OrganizationsApi.md#administratorOrganizationsListByOrganization) | **GET** /organizations/{id}/administratorlinks | List the association links between an Organization and Administrators.
[**administratorOrganizationsRemoveByAdministrator**](OrganizationsApi.md#administratorOrganizationsRemoveByAdministrator) | **DELETE** /administrators/{administrator_id}/organizationlinks/{id} | Remove association between an Administrator and an Organization.
[**organizationsListCases**](OrganizationsApi.md#organizationsListCases) | **GET** /organizations/cases | Get all cases (Support/Feature requests) for organization

<a name="administratorOrganizationsCreateByAdministrator"></a>
# **administratorOrganizationsCreateByAdministrator**
> AdministratorOrganizationLink administratorOrganizationsCreateByAdministrator(id, body)

Allow Adminstrator access to an Organization.

This endpoint allows you to grant Administrator access to an Organization.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.OrganizationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

OrganizationsApi apiInstance = new OrganizationsApi();
String id = "id_example"; // String | 
AdministratorOrganizationLinkReq body = new AdministratorOrganizationLinkReq(); // AdministratorOrganizationLinkReq | 
try {
    AdministratorOrganizationLink result = apiInstance.administratorOrganizationsCreateByAdministrator(id, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrganizationsApi#administratorOrganizationsCreateByAdministrator");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **body** | [**AdministratorOrganizationLinkReq**](AdministratorOrganizationLinkReq.md)|  | [optional]

### Return type

[**AdministratorOrganizationLink**](AdministratorOrganizationLink.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="administratorOrganizationsListByAdministrator"></a>
# **administratorOrganizationsListByAdministrator**
> List&lt;AdministratorOrganizationLink&gt; administratorOrganizationsListByAdministrator(id, limit, skip)

List the association links between an Administrator and Organizations.

This endpoint returns the association links between an Administrator and Organizations.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.OrganizationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

OrganizationsApi apiInstance = new OrganizationsApi();
String id = "id_example"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
try {
    List<AdministratorOrganizationLink> result = apiInstance.administratorOrganizationsListByAdministrator(id, limit, skip);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrganizationsApi#administratorOrganizationsListByAdministrator");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]

### Return type

[**List&lt;AdministratorOrganizationLink&gt;**](AdministratorOrganizationLink.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="administratorOrganizationsListByOrganization"></a>
# **administratorOrganizationsListByOrganization**
> List&lt;AdministratorOrganizationLink&gt; administratorOrganizationsListByOrganization(id, limit, skip)

List the association links between an Organization and Administrators.

This endpoint returns the association links between an Organization and Administrators.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.OrganizationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

OrganizationsApi apiInstance = new OrganizationsApi();
String id = "id_example"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
try {
    List<AdministratorOrganizationLink> result = apiInstance.administratorOrganizationsListByOrganization(id, limit, skip);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrganizationsApi#administratorOrganizationsListByOrganization");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]

### Return type

[**List&lt;AdministratorOrganizationLink&gt;**](AdministratorOrganizationLink.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="administratorOrganizationsRemoveByAdministrator"></a>
# **administratorOrganizationsRemoveByAdministrator**
> administratorOrganizationsRemoveByAdministrator(administratorId, id)

Remove association between an Administrator and an Organization.

This endpoint removes the association link between an Administrator and an Organization.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.OrganizationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

OrganizationsApi apiInstance = new OrganizationsApi();
String administratorId = "administratorId_example"; // String | 
String id = "id_example"; // String | 
try {
    apiInstance.administratorOrganizationsRemoveByAdministrator(administratorId, id);
} catch (ApiException e) {
    System.err.println("Exception when calling OrganizationsApi#administratorOrganizationsRemoveByAdministrator");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **administratorId** | **String**|  |
 **id** | **String**|  |

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="organizationsListCases"></a>
# **organizationsListCases**
> OrganizationCasesResponse organizationsListCases(skip, sort, limit)

Get all cases (Support/Feature requests) for organization

This endpoint returns the cases (Support/Feature requests) for the organization

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.OrganizationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

OrganizationsApi apiInstance = new OrganizationsApi();
Integer skip = 0; // Integer | The offset into the records to return.
List<String> sort = Arrays.asList("sort_example"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
try {
    OrganizationCasesResponse result = apiInstance.organizationsListCases(skip, sort, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrganizationsApi#organizationsListCases");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **sort** | [**List&lt;String&gt;**](String.md)| The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  | [optional]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]

### Return type

[**OrganizationCasesResponse**](OrganizationCasesResponse.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

