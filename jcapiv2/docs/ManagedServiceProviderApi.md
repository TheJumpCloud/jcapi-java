# ManagedServiceProviderApi

All URIs are relative to *https://console.jumpcloud.com/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**administratorOrganizationsCreateByAdministrator**](ManagedServiceProviderApi.md#administratorOrganizationsCreateByAdministrator) | **POST** /administrators/{id}/organizationlinks | Allow Adminstrator access to an Organization.
[**administratorOrganizationsListByAdministrator**](ManagedServiceProviderApi.md#administratorOrganizationsListByAdministrator) | **GET** /administrators/{id}/organizationlinks | List the association links between an Administrator and Organizations.
[**administratorOrganizationsListByOrganization**](ManagedServiceProviderApi.md#administratorOrganizationsListByOrganization) | **GET** /organizations/{id}/administratorlinks | List the association links between an Organization and Administrators.
[**administratorOrganizationsRemoveByAdministrator**](ManagedServiceProviderApi.md#administratorOrganizationsRemoveByAdministrator) | **DELETE** /administrators/{administrator_id}/organizationlinks/{id} | Remove association between an Administrator and an Organization.
[**providerOrganizationsUpdateOrg**](ManagedServiceProviderApi.md#providerOrganizationsUpdateOrg) | **PUT** /providers/{provider_id}/organizations/{id} | Update Provider Organization
[**providersGetProvider**](ManagedServiceProviderApi.md#providersGetProvider) | **GET** /providers/{provider_id} | Retrieve Provider
[**providersListAdministrators**](ManagedServiceProviderApi.md#providersListAdministrators) | **GET** /providers/{provider_id}/administrators | List Provider Administrators
[**providersListOrganizations**](ManagedServiceProviderApi.md#providersListOrganizations) | **GET** /providers/{provider_id}/organizations | List Provider Organizations
[**providersPostAdmins**](ManagedServiceProviderApi.md#providersPostAdmins) | **POST** /providers/{provider_id}/administrators | Create a new Provider Administrator
[**providersRetrieveInvoice**](ManagedServiceProviderApi.md#providersRetrieveInvoice) | **GET** /providers/{provider_id}/invoices/{ID} | Download a provider&#x27;s invoice.
[**providersRetrieveInvoices**](ManagedServiceProviderApi.md#providersRetrieveInvoices) | **GET** /providers/{provider_id}/invoices | List a provider&#x27;s invoices.

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
//import io.swagger.client.api.ManagedServiceProviderApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ManagedServiceProviderApi apiInstance = new ManagedServiceProviderApi();
String id = "id_example"; // String | 
AdministratorOrganizationLinkReq body = new AdministratorOrganizationLinkReq(); // AdministratorOrganizationLinkReq | 
try {
    AdministratorOrganizationLink result = apiInstance.administratorOrganizationsCreateByAdministrator(id, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ManagedServiceProviderApi#administratorOrganizationsCreateByAdministrator");
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
//import io.swagger.client.api.ManagedServiceProviderApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ManagedServiceProviderApi apiInstance = new ManagedServiceProviderApi();
String id = "id_example"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
try {
    List<AdministratorOrganizationLink> result = apiInstance.administratorOrganizationsListByAdministrator(id, limit, skip);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ManagedServiceProviderApi#administratorOrganizationsListByAdministrator");
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
//import io.swagger.client.api.ManagedServiceProviderApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ManagedServiceProviderApi apiInstance = new ManagedServiceProviderApi();
String id = "id_example"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
try {
    List<AdministratorOrganizationLink> result = apiInstance.administratorOrganizationsListByOrganization(id, limit, skip);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ManagedServiceProviderApi#administratorOrganizationsListByOrganization");
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
//import io.swagger.client.api.ManagedServiceProviderApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ManagedServiceProviderApi apiInstance = new ManagedServiceProviderApi();
String administratorId = "administratorId_example"; // String | 
String id = "id_example"; // String | 
try {
    apiInstance.administratorOrganizationsRemoveByAdministrator(administratorId, id);
} catch (ApiException e) {
    System.err.println("Exception when calling ManagedServiceProviderApi#administratorOrganizationsRemoveByAdministrator");
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

<a name="providerOrganizationsUpdateOrg"></a>
# **providerOrganizationsUpdateOrg**
> Organization providerOrganizationsUpdateOrg(providerId, id, body)

Update Provider Organization

This endpoint updates a provider&#x27;s organization

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ManagedServiceProviderApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ManagedServiceProviderApi apiInstance = new ManagedServiceProviderApi();
String providerId = "providerId_example"; // String | 
String id = "id_example"; // String | 
Organization body = new Organization(); // Organization | 
try {
    Organization result = apiInstance.providerOrganizationsUpdateOrg(providerId, id, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ManagedServiceProviderApi#providerOrganizationsUpdateOrg");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **providerId** | **String**|  |
 **id** | **String**|  |
 **body** | [**Organization**](Organization.md)|  | [optional]

### Return type

[**Organization**](Organization.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="providersGetProvider"></a>
# **providersGetProvider**
> Provider providersGetProvider(providerId, fields)

Retrieve Provider

This endpoint returns details about a provider

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ManagedServiceProviderApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ManagedServiceProviderApi apiInstance = new ManagedServiceProviderApi();
String providerId = "providerId_example"; // String | 
List<String> fields = Arrays.asList("fields_example"); // List<String> | The comma separated fields included in the returned records. If omitted, the default list of fields will be returned. 
try {
    Provider result = apiInstance.providersGetProvider(providerId, fields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ManagedServiceProviderApi#providersGetProvider");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **providerId** | **String**|  |
 **fields** | [**List&lt;String&gt;**](String.md)| The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  | [optional]

### Return type

[**Provider**](Provider.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="providersListAdministrators"></a>
# **providersListAdministrators**
> InlineResponse20012 providersListAdministrators(providerId, fields, filter, limit, skip, sort)

List Provider Administrators

This endpoint returns a list of the Administrators associated with the Provider. You must be associated with the provider to use this route.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ManagedServiceProviderApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ManagedServiceProviderApi apiInstance = new ManagedServiceProviderApi();
String providerId = "providerId_example"; // String | 
List<String> fields = Arrays.asList("fields_example"); // List<String> | The comma separated fields included in the returned records. If omitted, the default list of fields will be returned. 
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> sort = Arrays.asList("sort_example"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
try {
    InlineResponse20012 result = apiInstance.providersListAdministrators(providerId, fields, filter, limit, skip, sort);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ManagedServiceProviderApi#providersListAdministrators");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **providerId** | **String**|  |
 **fields** | [**List&lt;String&gt;**](String.md)| The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  | [optional]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **sort** | [**List&lt;String&gt;**](String.md)| The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  | [optional]

### Return type

[**InlineResponse20012**](InlineResponse20012.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="providersListOrganizations"></a>
# **providersListOrganizations**
> InlineResponse20013 providersListOrganizations(providerId, fields, filter, limit, skip, sort)

List Provider Organizations

This endpoint returns a list of the Organizations associated with the Provider. You must be associated with the provider to use this route.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ManagedServiceProviderApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ManagedServiceProviderApi apiInstance = new ManagedServiceProviderApi();
String providerId = "providerId_example"; // String | 
List<String> fields = Arrays.asList("fields_example"); // List<String> | The comma separated fields included in the returned records. If omitted, the default list of fields will be returned. 
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> sort = Arrays.asList("sort_example"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
try {
    InlineResponse20013 result = apiInstance.providersListOrganizations(providerId, fields, filter, limit, skip, sort);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ManagedServiceProviderApi#providersListOrganizations");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **providerId** | **String**|  |
 **fields** | [**List&lt;String&gt;**](String.md)| The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  | [optional]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **sort** | [**List&lt;String&gt;**](String.md)| The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  | [optional]

### Return type

[**InlineResponse20013**](InlineResponse20013.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="providersPostAdmins"></a>
# **providersPostAdmins**
> Administrator providersPostAdmins(providerId, body)

Create a new Provider Administrator

This endpoint allows you to create a provider administrator. You must be associated with the provider to use this route. You must provide either &#x60;role&#x60; or &#x60;roleName&#x60;.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ManagedServiceProviderApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ManagedServiceProviderApi apiInstance = new ManagedServiceProviderApi();
String providerId = "providerId_example"; // String | 
ProviderAdminReq body = new ProviderAdminReq(); // ProviderAdminReq | 
try {
    Administrator result = apiInstance.providersPostAdmins(providerId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ManagedServiceProviderApi#providersPostAdmins");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **providerId** | **String**|  |
 **body** | [**ProviderAdminReq**](ProviderAdminReq.md)|  | [optional]

### Return type

[**Administrator**](Administrator.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="providersRetrieveInvoice"></a>
# **providersRetrieveInvoice**
> File providersRetrieveInvoice(providerId, ID)

Download a provider&#x27;s invoice.

Retrieves an invoice for this provider. You must be associated to the provider to use this endpoint.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ManagedServiceProviderApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ManagedServiceProviderApi apiInstance = new ManagedServiceProviderApi();
String providerId = "providerId_example"; // String | 
String ID = "ID_example"; // String | 
try {
    File result = apiInstance.providersRetrieveInvoice(providerId, ID);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ManagedServiceProviderApi#providersRetrieveInvoice");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **providerId** | **String**|  |
 **ID** | **String**|  |

### Return type

[**File**](File.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/pdf

<a name="providersRetrieveInvoices"></a>
# **providersRetrieveInvoices**
> ProviderInvoiceResponse providersRetrieveInvoices(providerId, skip, sort, limit)

List a provider&#x27;s invoices.

Retrieves a list of invoices for this provider. You must be associated to the provider to use this endpoint.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ManagedServiceProviderApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ManagedServiceProviderApi apiInstance = new ManagedServiceProviderApi();
String providerId = "providerId_example"; // String | 
Integer skip = 0; // Integer | The offset into the records to return.
List<String> sort = Arrays.asList("sort_example"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
try {
    ProviderInvoiceResponse result = apiInstance.providersRetrieveInvoices(providerId, skip, sort, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ManagedServiceProviderApi#providersRetrieveInvoices");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **providerId** | **String**|  |
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **sort** | [**List&lt;String&gt;**](String.md)| The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  | [optional]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]

### Return type

[**ProviderInvoiceResponse**](ProviderInvoiceResponse.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

