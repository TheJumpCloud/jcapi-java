# ProvidersApi

All URIs are relative to *https://console.jumpcloud.com/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**autotaskCreateConfiguration**](ProvidersApi.md#autotaskCreateConfiguration) | **POST** /providers/{provider_id}/integrations/autotask | Creates a new Autotask integration for the provider
[**autotaskDeleteConfiguration**](ProvidersApi.md#autotaskDeleteConfiguration) | **DELETE** /integrations/autotask/{UUID} | Delete Autotask Integration
[**autotaskGetConfiguration**](ProvidersApi.md#autotaskGetConfiguration) | **GET** /integrations/autotask/{UUID} | Retrieve Autotask Integration Configuration
[**autotaskPatchMappings**](ProvidersApi.md#autotaskPatchMappings) | **PATCH** /integrations/autotask/{UUID}/mappings | Create, edit, and/or delete Autotask Mappings
[**autotaskPatchSettings**](ProvidersApi.md#autotaskPatchSettings) | **PATCH** /integrations/autotask/{UUID}/settings | Create, edit, and/or delete Autotask Integration settings
[**autotaskRetrieveAllAlertConfigurationOptions**](ProvidersApi.md#autotaskRetrieveAllAlertConfigurationOptions) | **GET** /providers/{provider_id}/integrations/autotask/alerts/configuration/options | Get all Autotask ticketing alert configuration options for a provider
[**autotaskRetrieveAllAlertConfigurations**](ProvidersApi.md#autotaskRetrieveAllAlertConfigurations) | **GET** /providers/{provider_id}/integrations/autotask/alerts/configuration | Get all Autotask ticketing alert configurations for a provider
[**autotaskRetrieveCompanies**](ProvidersApi.md#autotaskRetrieveCompanies) | **GET** /integrations/autotask/{UUID}/companies | Retrieve Autotask Companies
[**autotaskRetrieveCompanyTypes**](ProvidersApi.md#autotaskRetrieveCompanyTypes) | **GET** /integrations/autotask/{UUID}/companytypes | Retrieve Autotask Company Types
[**autotaskRetrieveContracts**](ProvidersApi.md#autotaskRetrieveContracts) | **GET** /integrations/autotask/{UUID}/contracts | Retrieve Autotask Contracts
[**autotaskRetrieveContractsFields**](ProvidersApi.md#autotaskRetrieveContractsFields) | **GET** /integrations/autotask/{UUID}/contracts/fields | Retrieve Autotask Contract Fields
[**autotaskRetrieveMappings**](ProvidersApi.md#autotaskRetrieveMappings) | **GET** /integrations/autotask/{UUID}/mappings | Retrieve Autotask mappings
[**autotaskRetrieveServices**](ProvidersApi.md#autotaskRetrieveServices) | **GET** /integrations/autotask/{UUID}/contracts/services | Retrieve Autotask Contract Services
[**autotaskRetrieveSettings**](ProvidersApi.md#autotaskRetrieveSettings) | **GET** /integrations/autotask/{UUID}/settings | Retrieve Autotask Integration settings
[**autotaskUpdateAlertConfiguration**](ProvidersApi.md#autotaskUpdateAlertConfiguration) | **PUT** /providers/{provider_id}/integrations/autotask/alerts/{alert_UUID}/configuration | Update an Autotask ticketing alert&#x27;s configuration
[**autotaskUpdateConfiguration**](ProvidersApi.md#autotaskUpdateConfiguration) | **PATCH** /integrations/autotask/{UUID} | Update Autotask Integration configuration
[**connectwiseCreateConfiguration**](ProvidersApi.md#connectwiseCreateConfiguration) | **POST** /providers/{provider_id}/integrations/connectwise | Creates a new ConnectWise integration for the provider
[**connectwiseDeleteConfiguration**](ProvidersApi.md#connectwiseDeleteConfiguration) | **DELETE** /integrations/connectwise/{UUID} | Delete ConnectWise Integration
[**connectwiseGetConfiguration**](ProvidersApi.md#connectwiseGetConfiguration) | **GET** /integrations/connectwise/{UUID} | Retrieve ConnectWise Integration Configuration
[**connectwisePatchMappings**](ProvidersApi.md#connectwisePatchMappings) | **PATCH** /integrations/connectwise/{UUID}/mappings | Create, edit, and/or delete ConnectWise Mappings
[**connectwisePatchSettings**](ProvidersApi.md#connectwisePatchSettings) | **PATCH** /integrations/connectwise/{UUID}/settings | Create, edit, and/or delete ConnectWise Integration settings
[**connectwiseRetrieveAdditions**](ProvidersApi.md#connectwiseRetrieveAdditions) | **GET** /integrations/connectwise/{UUID}/agreements/{agreement_ID}/additions | Retrieve ConnectWise Additions
[**connectwiseRetrieveAgreements**](ProvidersApi.md#connectwiseRetrieveAgreements) | **GET** /integrations/connectwise/{UUID}/agreements | Retrieve ConnectWise Agreements
[**connectwiseRetrieveAllAlertConfigurationOptions**](ProvidersApi.md#connectwiseRetrieveAllAlertConfigurationOptions) | **GET** /providers/{provider_id}/integrations/connectwise/alerts/configuration/options | Get all ConnectWise ticketing alert configuration options for a provider
[**connectwiseRetrieveAllAlertConfigurations**](ProvidersApi.md#connectwiseRetrieveAllAlertConfigurations) | **GET** /providers/{provider_id}/integrations/connectwise/alerts/configuration | Get all ConnectWise ticketing alert configurations for a provider
[**connectwiseRetrieveCompanies**](ProvidersApi.md#connectwiseRetrieveCompanies) | **GET** /integrations/connectwise/{UUID}/companies | Retrieve ConnectWise Companies
[**connectwiseRetrieveCompanyTypes**](ProvidersApi.md#connectwiseRetrieveCompanyTypes) | **GET** /integrations/connectwise/{UUID}/companytypes | Retrieve ConnectWise Company Types
[**connectwiseRetrieveMappings**](ProvidersApi.md#connectwiseRetrieveMappings) | **GET** /integrations/connectwise/{UUID}/mappings | Retrieve ConnectWise mappings
[**connectwiseRetrieveSettings**](ProvidersApi.md#connectwiseRetrieveSettings) | **GET** /integrations/connectwise/{UUID}/settings | Retrieve ConnectWise Integration settings
[**connectwiseUpdateAlertConfiguration**](ProvidersApi.md#connectwiseUpdateAlertConfiguration) | **PUT** /providers/{provider_id}/integrations/connectwise/alerts/{alert_UUID}/configuration | Update a ConnectWise ticketing alert&#x27;s configuration
[**connectwiseUpdateConfiguration**](ProvidersApi.md#connectwiseUpdateConfiguration) | **PATCH** /integrations/connectwise/{UUID} | Update ConnectWise Integration configuration
[**mtpIntegrationRetrieveAlerts**](ProvidersApi.md#mtpIntegrationRetrieveAlerts) | **GET** /providers/{provider_id}/integrations/ticketing/alerts | Get all ticketing alerts available for a provider&#x27;s ticketing integration.
[**mtpIntegrationRetrieveSyncErrors**](ProvidersApi.md#mtpIntegrationRetrieveSyncErrors) | **GET** /integrations/{integration_type}/{UUID}/errors | Retrieve Recent Integration Sync Errors
[**providerOrganizationsUpdateOrg**](ProvidersApi.md#providerOrganizationsUpdateOrg) | **PUT** /providers/{provider_id}/organizations/{id} | Update Provider Organization
[**providersGetProvider**](ProvidersApi.md#providersGetProvider) | **GET** /providers/{provider_id} | Retrieve Provider
[**providersListAdministrators**](ProvidersApi.md#providersListAdministrators) | **GET** /providers/{provider_id}/administrators | List Provider Administrators
[**providersListOrganizations**](ProvidersApi.md#providersListOrganizations) | **GET** /providers/{provider_id}/organizations | List Provider Organizations
[**providersPostAdmins**](ProvidersApi.md#providersPostAdmins) | **POST** /providers/{provider_id}/administrators | Create a new Provider Administrator
[**providersRemoveAdministrator**](ProvidersApi.md#providersRemoveAdministrator) | **DELETE** /providers/{provider_id}/administrators/{id} | Delete Provider Administrator
[**providersRetrieveIntegrations**](ProvidersApi.md#providersRetrieveIntegrations) | **GET** /providers/{provider_id}/integrations | Retrieve Integrations for Provider
[**providersRetrieveInvoice**](ProvidersApi.md#providersRetrieveInvoice) | **GET** /providers/{provider_id}/invoices/{ID} | Download a provider&#x27;s invoice.
[**providersRetrieveInvoices**](ProvidersApi.md#providersRetrieveInvoices) | **GET** /providers/{provider_id}/invoices | List a provider&#x27;s invoices.

<a name="autotaskCreateConfiguration"></a>
# **autotaskCreateConfiguration**
> InlineResponse201 autotaskCreateConfiguration(providerId, body)

Creates a new Autotask integration for the provider

Creates a new Autotask integration for the provider. You must be associated with the provider to use this route. A 422 Unprocessable Entity response means the server failed to validate with Autotask.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ProvidersApi apiInstance = new ProvidersApi();
String providerId = "providerId_example"; // String | 
AutotaskIntegrationReq body = new AutotaskIntegrationReq(); // AutotaskIntegrationReq | 
try {
    InlineResponse201 result = apiInstance.autotaskCreateConfiguration(providerId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProvidersApi#autotaskCreateConfiguration");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **providerId** | **String**|  |
 **body** | [**AutotaskIntegrationReq**](AutotaskIntegrationReq.md)|  | [optional]

### Return type

[**InlineResponse201**](InlineResponse201.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="autotaskDeleteConfiguration"></a>
# **autotaskDeleteConfiguration**
> autotaskDeleteConfiguration(UUID)

Delete Autotask Integration

Removes a Autotask integration.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ProvidersApi apiInstance = new ProvidersApi();
String UUID = "UUID_example"; // String | 
try {
    apiInstance.autotaskDeleteConfiguration(UUID);
} catch (ApiException e) {
    System.err.println("Exception when calling ProvidersApi#autotaskDeleteConfiguration");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **UUID** | **String**|  |

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="autotaskGetConfiguration"></a>
# **autotaskGetConfiguration**
> AutotaskIntegration autotaskGetConfiguration(UUID)

Retrieve Autotask Integration Configuration

Retrieves configuration for given Autotask integration id. You must be associated to the provider the integration is tied to in order to use this api.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ProvidersApi apiInstance = new ProvidersApi();
String UUID = "UUID_example"; // String | 
try {
    AutotaskIntegration result = apiInstance.autotaskGetConfiguration(UUID);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProvidersApi#autotaskGetConfiguration");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **UUID** | **String**|  |

### Return type

[**AutotaskIntegration**](AutotaskIntegration.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="autotaskPatchMappings"></a>
# **autotaskPatchMappings**
> AutotaskMappingResponse autotaskPatchMappings(UUID, body)

Create, edit, and/or delete Autotask Mappings

Create, edit, and/or delete mappings between Jumpcloud organizations and Autotask companies/contracts/services. You must be associated to the same provider as the Autotask integration to use this api.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ProvidersApi apiInstance = new ProvidersApi();
String UUID = "UUID_example"; // String | 
AutotaskMappingRequest body = new AutotaskMappingRequest(); // AutotaskMappingRequest | 
try {
    AutotaskMappingResponse result = apiInstance.autotaskPatchMappings(UUID, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProvidersApi#autotaskPatchMappings");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **UUID** | **String**|  |
 **body** | [**AutotaskMappingRequest**](AutotaskMappingRequest.md)|  | [optional]

### Return type

[**AutotaskMappingResponse**](AutotaskMappingResponse.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="autotaskPatchSettings"></a>
# **autotaskPatchSettings**
> AutotaskSettings autotaskPatchSettings(UUID, body)

Create, edit, and/or delete Autotask Integration settings

Create, edit, and/or delete Autotask settings. You must be associated to the same provider as the Autotask integration to use this endpoint.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ProvidersApi apiInstance = new ProvidersApi();
String UUID = "UUID_example"; // String | 
AutotaskSettingsPatchReq body = new AutotaskSettingsPatchReq(); // AutotaskSettingsPatchReq | 
try {
    AutotaskSettings result = apiInstance.autotaskPatchSettings(UUID, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProvidersApi#autotaskPatchSettings");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **UUID** | **String**|  |
 **body** | [**AutotaskSettingsPatchReq**](AutotaskSettingsPatchReq.md)|  | [optional]

### Return type

[**AutotaskSettings**](AutotaskSettings.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="autotaskRetrieveAllAlertConfigurationOptions"></a>
# **autotaskRetrieveAllAlertConfigurationOptions**
> AutotaskTicketingAlertConfigurationOptions autotaskRetrieveAllAlertConfigurationOptions(providerId)

Get all Autotask ticketing alert configuration options for a provider

Get all Autotask ticketing alert configuration options for a provider.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ProvidersApi apiInstance = new ProvidersApi();
String providerId = "providerId_example"; // String | 
try {
    AutotaskTicketingAlertConfigurationOptions result = apiInstance.autotaskRetrieveAllAlertConfigurationOptions(providerId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProvidersApi#autotaskRetrieveAllAlertConfigurationOptions");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **providerId** | **String**|  |

### Return type

[**AutotaskTicketingAlertConfigurationOptions**](AutotaskTicketingAlertConfigurationOptions.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="autotaskRetrieveAllAlertConfigurations"></a>
# **autotaskRetrieveAllAlertConfigurations**
> AutotaskTicketingAlertConfigurationList autotaskRetrieveAllAlertConfigurations(providerId)

Get all Autotask ticketing alert configurations for a provider

Get all Autotask ticketing alert configurations for a provider.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ProvidersApi apiInstance = new ProvidersApi();
String providerId = "providerId_example"; // String | 
try {
    AutotaskTicketingAlertConfigurationList result = apiInstance.autotaskRetrieveAllAlertConfigurations(providerId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProvidersApi#autotaskRetrieveAllAlertConfigurations");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **providerId** | **String**|  |

### Return type

[**AutotaskTicketingAlertConfigurationList**](AutotaskTicketingAlertConfigurationList.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="autotaskRetrieveCompanies"></a>
# **autotaskRetrieveCompanies**
> AutotaskCompanyResp autotaskRetrieveCompanies(UUID, fields, filter, limit, skip, sort)

Retrieve Autotask Companies

Retrieves a list of Autotask companies for the given Autotask id. You must be associated to the same provider as the Autotask integration to use this endpoint.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ProvidersApi apiInstance = new ProvidersApi();
String UUID = "UUID_example"; // String | 
List<String> fields = Arrays.asList("fields_example"); // List<String> | The comma separated fields included in the returned records. If omitted, the default list of fields will be returned. 
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> sort = Arrays.asList("sort_example"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
try {
    AutotaskCompanyResp result = apiInstance.autotaskRetrieveCompanies(UUID, fields, filter, limit, skip, sort);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProvidersApi#autotaskRetrieveCompanies");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **UUID** | **String**|  |
 **fields** | [**List&lt;String&gt;**](String.md)| The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  | [optional]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **sort** | [**List&lt;String&gt;**](String.md)| The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  | [optional]

### Return type

[**AutotaskCompanyResp**](AutotaskCompanyResp.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="autotaskRetrieveCompanyTypes"></a>
# **autotaskRetrieveCompanyTypes**
> AutotaskCompanyTypeResp autotaskRetrieveCompanyTypes(UUID)

Retrieve Autotask Company Types

Retrieves a list of user defined company types from Autotask for the given Autotask id.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ProvidersApi apiInstance = new ProvidersApi();
String UUID = "UUID_example"; // String | 
try {
    AutotaskCompanyTypeResp result = apiInstance.autotaskRetrieveCompanyTypes(UUID);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProvidersApi#autotaskRetrieveCompanyTypes");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **UUID** | **String**|  |

### Return type

[**AutotaskCompanyTypeResp**](AutotaskCompanyTypeResp.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="autotaskRetrieveContracts"></a>
# **autotaskRetrieveContracts**
> InlineResponse2003 autotaskRetrieveContracts(UUID, fields, filter, limit, skip, sort)

Retrieve Autotask Contracts

Retrieves a list of Autotask contracts for the given Autotask integration id. You must be associated to the same provider as the Autotask integration to use this endpoint.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ProvidersApi apiInstance = new ProvidersApi();
String UUID = "UUID_example"; // String | 
List<String> fields = Arrays.asList("fields_example"); // List<String> | The comma separated fields included in the returned records. If omitted, the default list of fields will be returned. 
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> sort = Arrays.asList("sort_example"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
try {
    InlineResponse2003 result = apiInstance.autotaskRetrieveContracts(UUID, fields, filter, limit, skip, sort);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProvidersApi#autotaskRetrieveContracts");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **UUID** | **String**|  |
 **fields** | [**List&lt;String&gt;**](String.md)| The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  | [optional]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **sort** | [**List&lt;String&gt;**](String.md)| The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  | [optional]

### Return type

[**InlineResponse2003**](InlineResponse2003.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="autotaskRetrieveContractsFields"></a>
# **autotaskRetrieveContractsFields**
> InlineResponse2004 autotaskRetrieveContractsFields(UUID)

Retrieve Autotask Contract Fields

Retrieves a list of Autotask contract fields for the given Autotask integration id. You must be associated to the same provider as the Autotask integration to use this endpoint.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ProvidersApi apiInstance = new ProvidersApi();
String UUID = "UUID_example"; // String | 
try {
    InlineResponse2004 result = apiInstance.autotaskRetrieveContractsFields(UUID);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProvidersApi#autotaskRetrieveContractsFields");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **UUID** | **String**|  |

### Return type

[**InlineResponse2004**](InlineResponse2004.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="autotaskRetrieveMappings"></a>
# **autotaskRetrieveMappings**
> InlineResponse2006 autotaskRetrieveMappings(UUID, fields, filter, limit, skip, sort)

Retrieve Autotask mappings

Retrieves the list of mappings for this Autotask integration. You must be associated to the same provider as the Autotask integration to use this api.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ProvidersApi apiInstance = new ProvidersApi();
String UUID = "UUID_example"; // String | 
List<String> fields = Arrays.asList("fields_example"); // List<String> | The comma separated fields included in the returned records. If omitted, the default list of fields will be returned. 
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> sort = Arrays.asList("sort_example"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
try {
    InlineResponse2006 result = apiInstance.autotaskRetrieveMappings(UUID, fields, filter, limit, skip, sort);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProvidersApi#autotaskRetrieveMappings");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **UUID** | **String**|  |
 **fields** | [**List&lt;String&gt;**](String.md)| The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  | [optional]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **sort** | [**List&lt;String&gt;**](String.md)| The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  | [optional]

### Return type

[**InlineResponse2006**](InlineResponse2006.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="autotaskRetrieveServices"></a>
# **autotaskRetrieveServices**
> InlineResponse2005 autotaskRetrieveServices(UUID, fields, filter, limit, skip, sort)

Retrieve Autotask Contract Services

Retrieves a list of Autotask contract services for the given Autotask integration id. You must be associated to the same provider as the Autotask integration to use this endpoint.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ProvidersApi apiInstance = new ProvidersApi();
String UUID = "UUID_example"; // String | 
List<String> fields = Arrays.asList("fields_example"); // List<String> | The comma separated fields included in the returned records. If omitted, the default list of fields will be returned. 
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> sort = Arrays.asList("sort_example"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
try {
    InlineResponse2005 result = apiInstance.autotaskRetrieveServices(UUID, fields, filter, limit, skip, sort);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProvidersApi#autotaskRetrieveServices");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **UUID** | **String**|  |
 **fields** | [**List&lt;String&gt;**](String.md)| The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  | [optional]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **sort** | [**List&lt;String&gt;**](String.md)| The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  | [optional]

### Return type

[**InlineResponse2005**](InlineResponse2005.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="autotaskRetrieveSettings"></a>
# **autotaskRetrieveSettings**
> AutotaskSettings autotaskRetrieveSettings(UUID)

Retrieve Autotask Integration settings

Retrieve the Autotask integration settings. You must be associated to the same provider as the Autotask integration to use this endpoint.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ProvidersApi apiInstance = new ProvidersApi();
String UUID = "UUID_example"; // String | 
try {
    AutotaskSettings result = apiInstance.autotaskRetrieveSettings(UUID);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProvidersApi#autotaskRetrieveSettings");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **UUID** | **String**|  |

### Return type

[**AutotaskSettings**](AutotaskSettings.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="autotaskUpdateAlertConfiguration"></a>
# **autotaskUpdateAlertConfiguration**
> AutotaskTicketingAlertConfiguration autotaskUpdateAlertConfiguration(providerId, alertUUID, body)

Update an Autotask ticketing alert&#x27;s configuration

Update an Autotask ticketing alert&#x27;s configuration

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ProvidersApi apiInstance = new ProvidersApi();
String providerId = "providerId_example"; // String | 
String alertUUID = "alertUUID_example"; // String | 
AutotaskTicketingAlertConfigurationRequest body = new AutotaskTicketingAlertConfigurationRequest(); // AutotaskTicketingAlertConfigurationRequest | 
try {
    AutotaskTicketingAlertConfiguration result = apiInstance.autotaskUpdateAlertConfiguration(providerId, alertUUID, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProvidersApi#autotaskUpdateAlertConfiguration");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **providerId** | **String**|  |
 **alertUUID** | **String**|  |
 **body** | [**AutotaskTicketingAlertConfigurationRequest**](AutotaskTicketingAlertConfigurationRequest.md)|  | [optional]

### Return type

[**AutotaskTicketingAlertConfiguration**](AutotaskTicketingAlertConfiguration.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="autotaskUpdateConfiguration"></a>
# **autotaskUpdateConfiguration**
> AutotaskIntegration autotaskUpdateConfiguration(UUID, body)

Update Autotask Integration configuration

Update the Autotask integration configuration. A 422 Unprocessable Entity response means the server failed to validate with Autotask.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ProvidersApi apiInstance = new ProvidersApi();
String UUID = "UUID_example"; // String | 
AutotaskIntegrationPatchReq body = new AutotaskIntegrationPatchReq(); // AutotaskIntegrationPatchReq | 
try {
    AutotaskIntegration result = apiInstance.autotaskUpdateConfiguration(UUID, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProvidersApi#autotaskUpdateConfiguration");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **UUID** | **String**|  |
 **body** | [**AutotaskIntegrationPatchReq**](AutotaskIntegrationPatchReq.md)|  | [optional]

### Return type

[**AutotaskIntegration**](AutotaskIntegration.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="connectwiseCreateConfiguration"></a>
# **connectwiseCreateConfiguration**
> InlineResponse201 connectwiseCreateConfiguration(providerId, body)

Creates a new ConnectWise integration for the provider

Creates a new ConnectWise integration for the provider. You must be associated with the provider to use this route. A 422 Unprocessable Entity response means the server failed to validate with ConnectWise.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ProvidersApi apiInstance = new ProvidersApi();
String providerId = "providerId_example"; // String | 
ConnectwiseIntegrationReq body = new ConnectwiseIntegrationReq(); // ConnectwiseIntegrationReq | 
try {
    InlineResponse201 result = apiInstance.connectwiseCreateConfiguration(providerId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProvidersApi#connectwiseCreateConfiguration");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **providerId** | **String**|  |
 **body** | [**ConnectwiseIntegrationReq**](ConnectwiseIntegrationReq.md)|  | [optional]

### Return type

[**InlineResponse201**](InlineResponse201.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="connectwiseDeleteConfiguration"></a>
# **connectwiseDeleteConfiguration**
> connectwiseDeleteConfiguration(UUID)

Delete ConnectWise Integration

Removes a ConnectWise integration.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ProvidersApi apiInstance = new ProvidersApi();
String UUID = "UUID_example"; // String | 
try {
    apiInstance.connectwiseDeleteConfiguration(UUID);
} catch (ApiException e) {
    System.err.println("Exception when calling ProvidersApi#connectwiseDeleteConfiguration");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **UUID** | **String**|  |

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="connectwiseGetConfiguration"></a>
# **connectwiseGetConfiguration**
> ConnectwiseIntegration connectwiseGetConfiguration(UUID)

Retrieve ConnectWise Integration Configuration

Retrieves configuration for given ConnectWise integration id. You must be associated to the provider the integration is tied to in order to use this api.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ProvidersApi apiInstance = new ProvidersApi();
String UUID = "UUID_example"; // String | 
try {
    ConnectwiseIntegration result = apiInstance.connectwiseGetConfiguration(UUID);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProvidersApi#connectwiseGetConfiguration");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **UUID** | **String**|  |

### Return type

[**ConnectwiseIntegration**](ConnectwiseIntegration.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="connectwisePatchMappings"></a>
# **connectwisePatchMappings**
> ConnectWiseMappingRequest connectwisePatchMappings(UUID, body)

Create, edit, and/or delete ConnectWise Mappings

Create, edit, and/or delete mappings between Jumpcloud organizations and ConnectWise companies/agreements/additions. You must be associated to the same provider as the ConnectWise integration to use this api.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ProvidersApi apiInstance = new ProvidersApi();
String UUID = "UUID_example"; // String | 
ConnectWiseMappingRequest body = new ConnectWiseMappingRequest(); // ConnectWiseMappingRequest | 
try {
    ConnectWiseMappingRequest result = apiInstance.connectwisePatchMappings(UUID, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProvidersApi#connectwisePatchMappings");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **UUID** | **String**|  |
 **body** | [**ConnectWiseMappingRequest**](ConnectWiseMappingRequest.md)|  | [optional]

### Return type

[**ConnectWiseMappingRequest**](ConnectWiseMappingRequest.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="connectwisePatchSettings"></a>
# **connectwisePatchSettings**
> ConnectWiseSettings connectwisePatchSettings(UUID, body)

Create, edit, and/or delete ConnectWise Integration settings

Create, edit, and/or delete ConnectWiseIntegration settings. You must be associated to the same provider as the ConnectWise integration to use this endpoint.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ProvidersApi apiInstance = new ProvidersApi();
String UUID = "UUID_example"; // String | 
ConnectWiseSettingsPatchReq body = new ConnectWiseSettingsPatchReq(); // ConnectWiseSettingsPatchReq | 
try {
    ConnectWiseSettings result = apiInstance.connectwisePatchSettings(UUID, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProvidersApi#connectwisePatchSettings");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **UUID** | **String**|  |
 **body** | [**ConnectWiseSettingsPatchReq**](ConnectWiseSettingsPatchReq.md)|  | [optional]

### Return type

[**ConnectWiseSettings**](ConnectWiseSettings.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="connectwiseRetrieveAdditions"></a>
# **connectwiseRetrieveAdditions**
> InlineResponse2008 connectwiseRetrieveAdditions(UUID, agreementID, fields, filter, limit, skip, sort)

Retrieve ConnectWise Additions

Retrieves a list of ConnectWise additions for the given ConnectWise id and Agreement id. You must be associated to the same provider as the ConnectWise integration to use this endpoint.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ProvidersApi apiInstance = new ProvidersApi();
String UUID = "UUID_example"; // String | 
String agreementID = "agreementID_example"; // String | 
List<String> fields = Arrays.asList("fields_example"); // List<String> | The comma separated fields included in the returned records. If omitted, the default list of fields will be returned. 
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> sort = Arrays.asList("sort_example"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
try {
    InlineResponse2008 result = apiInstance.connectwiseRetrieveAdditions(UUID, agreementID, fields, filter, limit, skip, sort);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProvidersApi#connectwiseRetrieveAdditions");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **UUID** | **String**|  |
 **agreementID** | **String**|  |
 **fields** | [**List&lt;String&gt;**](String.md)| The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  | [optional]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **sort** | [**List&lt;String&gt;**](String.md)| The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  | [optional]

### Return type

[**InlineResponse2008**](InlineResponse2008.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="connectwiseRetrieveAgreements"></a>
# **connectwiseRetrieveAgreements**
> InlineResponse2007 connectwiseRetrieveAgreements(UUID, fields, filter, limit, skip, sort)

Retrieve ConnectWise Agreements

Retrieves a list of ConnectWise agreements for the given ConnectWise id. You must be associated to the same provider as the ConnectWise integration to use this endpoint.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ProvidersApi apiInstance = new ProvidersApi();
String UUID = "UUID_example"; // String | 
List<String> fields = Arrays.asList("fields_example"); // List<String> | The comma separated fields included in the returned records. If omitted, the default list of fields will be returned. 
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> sort = Arrays.asList("sort_example"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
try {
    InlineResponse2007 result = apiInstance.connectwiseRetrieveAgreements(UUID, fields, filter, limit, skip, sort);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProvidersApi#connectwiseRetrieveAgreements");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **UUID** | **String**|  |
 **fields** | [**List&lt;String&gt;**](String.md)| The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  | [optional]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **sort** | [**List&lt;String&gt;**](String.md)| The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  | [optional]

### Return type

[**InlineResponse2007**](InlineResponse2007.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="connectwiseRetrieveAllAlertConfigurationOptions"></a>
# **connectwiseRetrieveAllAlertConfigurationOptions**
> ConnectWiseTicketingAlertConfigurationOptions connectwiseRetrieveAllAlertConfigurationOptions(providerId)

Get all ConnectWise ticketing alert configuration options for a provider

Get all ConnectWise ticketing alert configuration options for a provider.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ProvidersApi apiInstance = new ProvidersApi();
String providerId = "providerId_example"; // String | 
try {
    ConnectWiseTicketingAlertConfigurationOptions result = apiInstance.connectwiseRetrieveAllAlertConfigurationOptions(providerId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProvidersApi#connectwiseRetrieveAllAlertConfigurationOptions");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **providerId** | **String**|  |

### Return type

[**ConnectWiseTicketingAlertConfigurationOptions**](ConnectWiseTicketingAlertConfigurationOptions.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="connectwiseRetrieveAllAlertConfigurations"></a>
# **connectwiseRetrieveAllAlertConfigurations**
> ConnectWiseTicketingAlertConfigurationList connectwiseRetrieveAllAlertConfigurations(providerId)

Get all ConnectWise ticketing alert configurations for a provider

Get all ConnectWise ticketing alert configurations for a provider.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ProvidersApi apiInstance = new ProvidersApi();
String providerId = "providerId_example"; // String | 
try {
    ConnectWiseTicketingAlertConfigurationList result = apiInstance.connectwiseRetrieveAllAlertConfigurations(providerId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProvidersApi#connectwiseRetrieveAllAlertConfigurations");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **providerId** | **String**|  |

### Return type

[**ConnectWiseTicketingAlertConfigurationList**](ConnectWiseTicketingAlertConfigurationList.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="connectwiseRetrieveCompanies"></a>
# **connectwiseRetrieveCompanies**
> ConnectwiseCompanyResp connectwiseRetrieveCompanies(UUID, fields, filter, limit, skip, sort)

Retrieve ConnectWise Companies

Retrieves a list of ConnectWise companies for the given ConnectWise id. You must be associated to the same provider as the ConnectWise integration to use this endpoint.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ProvidersApi apiInstance = new ProvidersApi();
String UUID = "UUID_example"; // String | 
List<String> fields = Arrays.asList("fields_example"); // List<String> | The comma separated fields included in the returned records. If omitted, the default list of fields will be returned. 
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> sort = Arrays.asList("sort_example"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
try {
    ConnectwiseCompanyResp result = apiInstance.connectwiseRetrieveCompanies(UUID, fields, filter, limit, skip, sort);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProvidersApi#connectwiseRetrieveCompanies");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **UUID** | **String**|  |
 **fields** | [**List&lt;String&gt;**](String.md)| The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  | [optional]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **sort** | [**List&lt;String&gt;**](String.md)| The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  | [optional]

### Return type

[**ConnectwiseCompanyResp**](ConnectwiseCompanyResp.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="connectwiseRetrieveCompanyTypes"></a>
# **connectwiseRetrieveCompanyTypes**
> ConnectwiseCompanyTypeResp connectwiseRetrieveCompanyTypes(UUID)

Retrieve ConnectWise Company Types

Retrieves a list of user defined company types from ConnectWise for the given ConnectWise id.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ProvidersApi apiInstance = new ProvidersApi();
String UUID = "UUID_example"; // String | 
try {
    ConnectwiseCompanyTypeResp result = apiInstance.connectwiseRetrieveCompanyTypes(UUID);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProvidersApi#connectwiseRetrieveCompanyTypes");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **UUID** | **String**|  |

### Return type

[**ConnectwiseCompanyTypeResp**](ConnectwiseCompanyTypeResp.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="connectwiseRetrieveMappings"></a>
# **connectwiseRetrieveMappings**
> InlineResponse2009 connectwiseRetrieveMappings(UUID, fields, filter, limit, skip, sort)

Retrieve ConnectWise mappings

Retrieves the list of mappings for this ConnectWise integration. You must be associated to the same provider as the ConnectWise integration to use this api.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ProvidersApi apiInstance = new ProvidersApi();
String UUID = "UUID_example"; // String | 
List<String> fields = Arrays.asList("fields_example"); // List<String> | The comma separated fields included in the returned records. If omitted, the default list of fields will be returned. 
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> sort = Arrays.asList("sort_example"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
try {
    InlineResponse2009 result = apiInstance.connectwiseRetrieveMappings(UUID, fields, filter, limit, skip, sort);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProvidersApi#connectwiseRetrieveMappings");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **UUID** | **String**|  |
 **fields** | [**List&lt;String&gt;**](String.md)| The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  | [optional]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **sort** | [**List&lt;String&gt;**](String.md)| The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  | [optional]

### Return type

[**InlineResponse2009**](InlineResponse2009.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="connectwiseRetrieveSettings"></a>
# **connectwiseRetrieveSettings**
> ConnectWiseSettings connectwiseRetrieveSettings(UUID)

Retrieve ConnectWise Integration settings

Retrieve the ConnectWise integration settings. You must be associated to the same provider as the ConnectWise integration to use this endpoint.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ProvidersApi apiInstance = new ProvidersApi();
String UUID = "UUID_example"; // String | 
try {
    ConnectWiseSettings result = apiInstance.connectwiseRetrieveSettings(UUID);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProvidersApi#connectwiseRetrieveSettings");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **UUID** | **String**|  |

### Return type

[**ConnectWiseSettings**](ConnectWiseSettings.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="connectwiseUpdateAlertConfiguration"></a>
# **connectwiseUpdateAlertConfiguration**
> ConnectWiseTicketingAlertConfiguration connectwiseUpdateAlertConfiguration(providerId, alertUUID, body)

Update a ConnectWise ticketing alert&#x27;s configuration

Update a ConnectWise ticketing alert&#x27;s configuration.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ProvidersApi apiInstance = new ProvidersApi();
String providerId = "providerId_example"; // String | 
String alertUUID = "alertUUID_example"; // String | 
ConnectWiseTicketingAlertConfigurationRequest body = new ConnectWiseTicketingAlertConfigurationRequest(); // ConnectWiseTicketingAlertConfigurationRequest | 
try {
    ConnectWiseTicketingAlertConfiguration result = apiInstance.connectwiseUpdateAlertConfiguration(providerId, alertUUID, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProvidersApi#connectwiseUpdateAlertConfiguration");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **providerId** | **String**|  |
 **alertUUID** | **String**|  |
 **body** | [**ConnectWiseTicketingAlertConfigurationRequest**](ConnectWiseTicketingAlertConfigurationRequest.md)|  | [optional]

### Return type

[**ConnectWiseTicketingAlertConfiguration**](ConnectWiseTicketingAlertConfiguration.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="connectwiseUpdateConfiguration"></a>
# **connectwiseUpdateConfiguration**
> ConnectwiseIntegration connectwiseUpdateConfiguration(UUID, body)

Update ConnectWise Integration configuration

Update the ConnectWise integration configuration. A 422 Unprocessable Entity response means the server failed to validate with ConnectWise.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ProvidersApi apiInstance = new ProvidersApi();
String UUID = "UUID_example"; // String | 
ConnectwiseIntegrationPatchReq body = new ConnectwiseIntegrationPatchReq(); // ConnectwiseIntegrationPatchReq | 
try {
    ConnectwiseIntegration result = apiInstance.connectwiseUpdateConfiguration(UUID, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProvidersApi#connectwiseUpdateConfiguration");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **UUID** | **String**|  |
 **body** | [**ConnectwiseIntegrationPatchReq**](ConnectwiseIntegrationPatchReq.md)|  | [optional]

### Return type

[**ConnectwiseIntegration**](ConnectwiseIntegration.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="mtpIntegrationRetrieveAlerts"></a>
# **mtpIntegrationRetrieveAlerts**
> TicketingIntegrationAlertsResp mtpIntegrationRetrieveAlerts(providerId)

Get all ticketing alerts available for a provider&#x27;s ticketing integration.

Get all ticketing alerts available for a provider&#x27;s ticketing integration.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ProvidersApi apiInstance = new ProvidersApi();
String providerId = "providerId_example"; // String | 
try {
    TicketingIntegrationAlertsResp result = apiInstance.mtpIntegrationRetrieveAlerts(providerId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProvidersApi#mtpIntegrationRetrieveAlerts");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **providerId** | **String**|  |

### Return type

[**TicketingIntegrationAlertsResp**](TicketingIntegrationAlertsResp.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="mtpIntegrationRetrieveSyncErrors"></a>
# **mtpIntegrationRetrieveSyncErrors**
> IntegrationSyncErrorResp mtpIntegrationRetrieveSyncErrors(UUID, integrationType)

Retrieve Recent Integration Sync Errors

Retrieves recent sync errors for given integration type and integration id. You must be associated to the provider the integration is tied to in order to use this api.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ProvidersApi apiInstance = new ProvidersApi();
String UUID = "UUID_example"; // String | 
String integrationType = "integrationType_example"; // String | 
try {
    IntegrationSyncErrorResp result = apiInstance.mtpIntegrationRetrieveSyncErrors(UUID, integrationType);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProvidersApi#mtpIntegrationRetrieveSyncErrors");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **UUID** | **String**|  |
 **integrationType** | **String**|  |

### Return type

[**IntegrationSyncErrorResp**](IntegrationSyncErrorResp.md)

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
//import io.swagger.client.api.ProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ProvidersApi apiInstance = new ProvidersApi();
String providerId = "providerId_example"; // String | 
String id = "id_example"; // String | 
Organization body = new Organization(); // Organization | 
try {
    Organization result = apiInstance.providerOrganizationsUpdateOrg(providerId, id, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProvidersApi#providerOrganizationsUpdateOrg");
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
//import io.swagger.client.api.ProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ProvidersApi apiInstance = new ProvidersApi();
String providerId = "providerId_example"; // String | 
List<String> fields = Arrays.asList("fields_example"); // List<String> | The comma separated fields included in the returned records. If omitted, the default list of fields will be returned. 
try {
    Provider result = apiInstance.providersGetProvider(providerId, fields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProvidersApi#providersGetProvider");
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
//import io.swagger.client.api.ProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ProvidersApi apiInstance = new ProvidersApi();
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
    System.err.println("Exception when calling ProvidersApi#providersListAdministrators");
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
//import io.swagger.client.api.ProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ProvidersApi apiInstance = new ProvidersApi();
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
    System.err.println("Exception when calling ProvidersApi#providersListOrganizations");
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
//import io.swagger.client.api.ProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ProvidersApi apiInstance = new ProvidersApi();
String providerId = "providerId_example"; // String | 
ProviderAdminReq body = new ProviderAdminReq(); // ProviderAdminReq | 
try {
    Administrator result = apiInstance.providersPostAdmins(providerId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProvidersApi#providersPostAdmins");
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

<a name="providersRemoveAdministrator"></a>
# **providersRemoveAdministrator**
> providersRemoveAdministrator(providerId, id)

Delete Provider Administrator

This endpoint removes an Administrator associated with the Provider. You must be associated with the provider to use this route.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ProvidersApi apiInstance = new ProvidersApi();
String providerId = "providerId_example"; // String | 
String id = "id_example"; // String | 
try {
    apiInstance.providersRemoveAdministrator(providerId, id);
} catch (ApiException e) {
    System.err.println("Exception when calling ProvidersApi#providersRemoveAdministrator");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **providerId** | **String**|  |
 **id** | **String**|  |

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="providersRetrieveIntegrations"></a>
# **providersRetrieveIntegrations**
> IntegrationsResponse providersRetrieveIntegrations(providerId, filter, limit, skip, sort)

Retrieve Integrations for Provider

Retrieves a list of integrations this provider has configured. You must be associated to the provider to use this endpoint.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ProvidersApi apiInstance = new ProvidersApi();
String providerId = "providerId_example"; // String | 
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> sort = Arrays.asList("sort_example"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
try {
    IntegrationsResponse result = apiInstance.providersRetrieveIntegrations(providerId, filter, limit, skip, sort);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProvidersApi#providersRetrieveIntegrations");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **providerId** | **String**|  |
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **sort** | [**List&lt;String&gt;**](String.md)| The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  | [optional]

### Return type

[**IntegrationsResponse**](IntegrationsResponse.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
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
//import io.swagger.client.api.ProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ProvidersApi apiInstance = new ProvidersApi();
String providerId = "providerId_example"; // String | 
String ID = "ID_example"; // String | 
try {
    File result = apiInstance.providersRetrieveInvoice(providerId, ID);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProvidersApi#providersRetrieveInvoice");
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
//import io.swagger.client.api.ProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

ProvidersApi apiInstance = new ProvidersApi();
String providerId = "providerId_example"; // String | 
Integer skip = 0; // Integer | The offset into the records to return.
List<String> sort = Arrays.asList("sort_example"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
try {
    ProviderInvoiceResponse result = apiInstance.providersRetrieveInvoices(providerId, skip, sort, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProvidersApi#providersRetrieveInvoices");
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

