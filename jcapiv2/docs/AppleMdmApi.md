# AppleMdmApi

All URIs are relative to *https://console.jumpcloud.com/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**applemdmsCsrget**](AppleMdmApi.md#applemdmsCsrget) | **GET** /applemdms/{apple_mdm_id}/csr | Get Apple MDM CSR Plist
[**applemdmsDelete**](AppleMdmApi.md#applemdmsDelete) | **DELETE** /applemdms/{id} | Delete an Apple MDM
[**applemdmsDeletedevice**](AppleMdmApi.md#applemdmsDeletedevice) | **DELETE** /applemdms/{apple_mdm_id}/devices/{device_id} | Remove an Apple MDM Device&#x27;s Enrollment
[**applemdmsDepkeyget**](AppleMdmApi.md#applemdmsDepkeyget) | **GET** /applemdms/{apple_mdm_id}/depkey | Get Apple MDM DEP Public Key
[**applemdmsDevicesClearActivationLock**](AppleMdmApi.md#applemdmsDevicesClearActivationLock) | **POST** /applemdms/{apple_mdm_id}/devices/{device_id}/clearActivationLock | Clears the Activation Lock for a Device
[**applemdmsDevicesRefreshActivationLockInformation**](AppleMdmApi.md#applemdmsDevicesRefreshActivationLockInformation) | **POST** /applemdms/{apple_mdm_id}/devices/{device_id}/refreshActivationLockInformation | Refresh activation lock information for a device
[**applemdmsDeviceserase**](AppleMdmApi.md#applemdmsDeviceserase) | **POST** /applemdms/{apple_mdm_id}/devices/{device_id}/erase | Erase Device
[**applemdmsDeviceslist**](AppleMdmApi.md#applemdmsDeviceslist) | **GET** /applemdms/{apple_mdm_id}/devices | List AppleMDM Devices
[**applemdmsDeviceslock**](AppleMdmApi.md#applemdmsDeviceslock) | **POST** /applemdms/{apple_mdm_id}/devices/{device_id}/lock | Lock Device
[**applemdmsDevicesrestart**](AppleMdmApi.md#applemdmsDevicesrestart) | **POST** /applemdms/{apple_mdm_id}/devices/{device_id}/restart | Restart Device
[**applemdmsDevicesshutdown**](AppleMdmApi.md#applemdmsDevicesshutdown) | **POST** /applemdms/{apple_mdm_id}/devices/{device_id}/shutdown | Shut Down Device
[**applemdmsEnrollmentprofilesget**](AppleMdmApi.md#applemdmsEnrollmentprofilesget) | **GET** /applemdms/{apple_mdm_id}/enrollmentprofiles/{id} | Get an Apple MDM Enrollment Profile
[**applemdmsEnrollmentprofileslist**](AppleMdmApi.md#applemdmsEnrollmentprofileslist) | **GET** /applemdms/{apple_mdm_id}/enrollmentprofiles | List Apple MDM Enrollment Profiles
[**applemdmsGetdevice**](AppleMdmApi.md#applemdmsGetdevice) | **GET** /applemdms/{apple_mdm_id}/devices/{device_id} | Details of an AppleMDM Device
[**applemdmsList**](AppleMdmApi.md#applemdmsList) | **GET** /applemdms | List Apple MDMs
[**applemdmsPut**](AppleMdmApi.md#applemdmsPut) | **PUT** /applemdms/{id} | Update an Apple MDM
[**applemdmsRefreshdepdevices**](AppleMdmApi.md#applemdmsRefreshdepdevices) | **POST** /applemdms/{apple_mdm_id}/refreshdepdevices | Refresh DEP Devices

<a name="applemdmsCsrget"></a>
# **applemdmsCsrget**
> String applemdmsCsrget(appleMdmId, xOrgId)

Get Apple MDM CSR Plist

Retrieves an Apple MDM signed CSR Plist for an organization.  The user must supply the returned plist to Apple for signing, and then provide the certificate provided by Apple back into the PUT API.  #### Sample Request &#x60;&#x60;&#x60;   curl -X GET https://console.jumpcloud.com/api/v2/applemdms/{APPLE_MDM_ID}/csr \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AppleMdmApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

AppleMdmApi apiInstance = new AppleMdmApi();
String appleMdmId = "appleMdmId_example"; // String | 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    String result = apiInstance.applemdmsCsrget(appleMdmId, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AppleMdmApi#applemdmsCsrget");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **appleMdmId** | **String**|  |
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

**String**

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/octet-stream

<a name="applemdmsDelete"></a>
# **applemdmsDelete**
> AppleMDM applemdmsDelete(id, xOrgId)

Delete an Apple MDM

Removes an Apple MDM configuration.  Warning: This is a destructive operation and will remove your Apple Push Certificates.  We will no longer be able to manage your devices and the only recovery option is to re-register all devices into MDM.  #### Sample Request &#x60;&#x60;&#x60; curl -X DELETE https://console.jumpcloud.com/api/v2/applemdms/{id} \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AppleMdmApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

AppleMdmApi apiInstance = new AppleMdmApi();
String id = "id_example"; // String | 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    AppleMDM result = apiInstance.applemdmsDelete(id, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AppleMdmApi#applemdmsDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**AppleMDM**](AppleMDM.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="applemdmsDeletedevice"></a>
# **applemdmsDeletedevice**
> AppleMdmDevice applemdmsDeletedevice(appleMdmId, deviceId, xOrgId)

Remove an Apple MDM Device&#x27;s Enrollment

Remove a single Apple MDM device from MDM enrollment.  #### Sample Request &#x60;&#x60;&#x60;   curl -X DELETE https://console.jumpcloud.com/api/v2/applemdms/{apple_mdm_id}/devices/{device_id} \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AppleMdmApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

AppleMdmApi apiInstance = new AppleMdmApi();
String appleMdmId = "appleMdmId_example"; // String | 
String deviceId = "deviceId_example"; // String | 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    AppleMdmDevice result = apiInstance.applemdmsDeletedevice(appleMdmId, deviceId, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AppleMdmApi#applemdmsDeletedevice");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **appleMdmId** | **String**|  |
 **deviceId** | **String**|  |
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**AppleMdmDevice**](AppleMdmDevice.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="applemdmsDepkeyget"></a>
# **applemdmsDepkeyget**
> String applemdmsDepkeyget(appleMdmId, xOrgId)

Get Apple MDM DEP Public Key

Retrieves an Apple MDM DEP Public Key.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AppleMdmApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

AppleMdmApi apiInstance = new AppleMdmApi();
String appleMdmId = "appleMdmId_example"; // String | 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    String result = apiInstance.applemdmsDepkeyget(appleMdmId, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AppleMdmApi#applemdmsDepkeyget");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **appleMdmId** | **String**|  |
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

**String**

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/x-pem-file

<a name="applemdmsDevicesClearActivationLock"></a>
# **applemdmsDevicesClearActivationLock**
> applemdmsDevicesClearActivationLock(appleMdmId, deviceId, xOrgId)

Clears the Activation Lock for a Device

Clears the activation lock on the specified device.  #### Sample Request &#x60;&#x60;&#x60;   curl -X POST https://console.jumpcloud.com/api/v2/applemdms/{apple_mdm_id}/devices/{device_id}/clearActivationLock \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{}&#x27; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AppleMdmApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

AppleMdmApi apiInstance = new AppleMdmApi();
String appleMdmId = "appleMdmId_example"; // String | 
String deviceId = "deviceId_example"; // String | 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    apiInstance.applemdmsDevicesClearActivationLock(appleMdmId, deviceId, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling AppleMdmApi#applemdmsDevicesClearActivationLock");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **appleMdmId** | **String**|  |
 **deviceId** | **String**|  |
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="applemdmsDevicesRefreshActivationLockInformation"></a>
# **applemdmsDevicesRefreshActivationLockInformation**
> applemdmsDevicesRefreshActivationLockInformation(appleMdmId, deviceId, xOrgId)

Refresh activation lock information for a device

Refreshes the activation lock information for a device  #### Sample Request  &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/applemdms/{apple_mdm_id}/devices/{device_id}/refreshActivationLockInformation \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{}&#x27; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AppleMdmApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

AppleMdmApi apiInstance = new AppleMdmApi();
String appleMdmId = "appleMdmId_example"; // String | 
String deviceId = "deviceId_example"; // String | 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    apiInstance.applemdmsDevicesRefreshActivationLockInformation(appleMdmId, deviceId, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling AppleMdmApi#applemdmsDevicesRefreshActivationLockInformation");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **appleMdmId** | **String**|  |
 **deviceId** | **String**|  |
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="applemdmsDeviceserase"></a>
# **applemdmsDeviceserase**
> applemdmsDeviceserase(appleMdmId, deviceId, body, xOrgId)

Erase Device

Erases a DEP-enrolled device.  #### Sample Request &#x60;&#x60;&#x60;   curl -X POST https://console.jumpcloud.com/api/v2/applemdms/{apple_mdm_id}/devices/{device_id}/erase \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{}&#x27; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AppleMdmApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

AppleMdmApi apiInstance = new AppleMdmApi();
String appleMdmId = "appleMdmId_example"; // String | 
String deviceId = "deviceId_example"; // String | 
DeviceIdEraseBody body = new DeviceIdEraseBody(); // DeviceIdEraseBody | 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    apiInstance.applemdmsDeviceserase(appleMdmId, deviceId, body, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling AppleMdmApi#applemdmsDeviceserase");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **appleMdmId** | **String**|  |
 **deviceId** | **String**|  |
 **body** | [**DeviceIdEraseBody**](DeviceIdEraseBody.md)|  | [optional]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="applemdmsDeviceslist"></a>
# **applemdmsDeviceslist**
> List&lt;AppleMdmDevice&gt; applemdmsDeviceslist(appleMdmId, limit, xOrgId, skip, filter, sort, xTotalCount)

List AppleMDM Devices

Lists all Apple MDM devices.  The filter and sort queries will allow the following fields: &#x60;createdAt&#x60; &#x60;depRegistered&#x60; &#x60;enrolled&#x60; &#x60;id&#x60; &#x60;osVersion&#x60; &#x60;serialNumber&#x60; &#x60;udid&#x60;  #### Sample Request &#x60;&#x60;&#x60;   curl -X GET https://console.jumpcloud.com/api/v2/applemdms/{apple_mdm_id}/devices \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{}&#x27; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AppleMdmApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

AppleMdmApi apiInstance = new AppleMdmApi();
String appleMdmId = "appleMdmId_example"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
List<String> sort = Arrays.asList("sort_example"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
Integer xTotalCount = 56; // Integer | 
try {
    List<AppleMdmDevice> result = apiInstance.applemdmsDeviceslist(appleMdmId, limit, xOrgId, skip, filter, sort, xTotalCount);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AppleMdmApi#applemdmsDeviceslist");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **appleMdmId** | **String**|  |
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]
 **sort** | [**List&lt;String&gt;**](String.md)| The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  | [optional]
 **xTotalCount** | **Integer**|  | [optional]

### Return type

[**List&lt;AppleMdmDevice&gt;**](AppleMdmDevice.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="applemdmsDeviceslock"></a>
# **applemdmsDeviceslock**
> applemdmsDeviceslock(appleMdmId, deviceId, body, xOrgId)

Lock Device

Locks a DEP-enrolled device.  #### Sample Request &#x60;&#x60;&#x60;   curl -X POST https://console.jumpcloud.com/api/v2/applemdms/{apple_mdm_id}/devices/{device_id}/lock \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{}&#x27; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AppleMdmApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

AppleMdmApi apiInstance = new AppleMdmApi();
String appleMdmId = "appleMdmId_example"; // String | 
String deviceId = "deviceId_example"; // String | 
DeviceIdLockBody body = new DeviceIdLockBody(); // DeviceIdLockBody | 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    apiInstance.applemdmsDeviceslock(appleMdmId, deviceId, body, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling AppleMdmApi#applemdmsDeviceslock");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **appleMdmId** | **String**|  |
 **deviceId** | **String**|  |
 **body** | [**DeviceIdLockBody**](DeviceIdLockBody.md)|  | [optional]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="applemdmsDevicesrestart"></a>
# **applemdmsDevicesrestart**
> applemdmsDevicesrestart(appleMdmId, deviceId, body, xOrgId)

Restart Device

Restarts a DEP-enrolled device.  #### Sample Request &#x60;&#x60;&#x60;   curl -X POST https://console.jumpcloud.com/api/v2/applemdms/{apple_mdm_id}/devices/{device_id}/restart \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{\&quot;kextPaths\&quot;: [\&quot;Path1\&quot;, \&quot;Path2\&quot;]}&#x27; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AppleMdmApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

AppleMdmApi apiInstance = new AppleMdmApi();
String appleMdmId = "appleMdmId_example"; // String | 
String deviceId = "deviceId_example"; // String | 
DeviceIdRestartBody body = new DeviceIdRestartBody(); // DeviceIdRestartBody | 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    apiInstance.applemdmsDevicesrestart(appleMdmId, deviceId, body, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling AppleMdmApi#applemdmsDevicesrestart");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **appleMdmId** | **String**|  |
 **deviceId** | **String**|  |
 **body** | [**DeviceIdRestartBody**](DeviceIdRestartBody.md)|  | [optional]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="applemdmsDevicesshutdown"></a>
# **applemdmsDevicesshutdown**
> applemdmsDevicesshutdown(appleMdmId, deviceId, xOrgId)

Shut Down Device

Shuts down a DEP-enrolled device.  #### Sample Request &#x60;&#x60;&#x60;   curl -X POST https://console.jumpcloud.com/api/v2/applemdms/{apple_mdm_id}/devices/{device_id}/shutdown \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{}&#x27; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AppleMdmApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

AppleMdmApi apiInstance = new AppleMdmApi();
String appleMdmId = "appleMdmId_example"; // String | 
String deviceId = "deviceId_example"; // String | 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    apiInstance.applemdmsDevicesshutdown(appleMdmId, deviceId, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling AppleMdmApi#applemdmsDevicesshutdown");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **appleMdmId** | **String**|  |
 **deviceId** | **String**|  |
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="applemdmsEnrollmentprofilesget"></a>
# **applemdmsEnrollmentprofilesget**
> String applemdmsEnrollmentprofilesget(appleMdmId, id, xOrgId)

Get an Apple MDM Enrollment Profile

Get an enrollment profile  Currently only requesting the mobileconfig is supported.  #### Sample Request  &#x60;&#x60;&#x60; curl https://console.jumpcloud.com/api/v2/applemdms/{APPLE_MDM_ID}/enrollmentprofiles/{ID} \\   -H &#x27;accept: application/x-apple-aspen-config&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AppleMdmApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

AppleMdmApi apiInstance = new AppleMdmApi();
String appleMdmId = "appleMdmId_example"; // String | 
String id = "id_example"; // String | 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    String result = apiInstance.applemdmsEnrollmentprofilesget(appleMdmId, id, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AppleMdmApi#applemdmsEnrollmentprofilesget");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **appleMdmId** | **String**|  |
 **id** | **String**|  |
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

**String**

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/x-apple-aspen-config

<a name="applemdmsEnrollmentprofileslist"></a>
# **applemdmsEnrollmentprofileslist**
> List&lt;AppleMDM&gt; applemdmsEnrollmentprofileslist(appleMdmId, xOrgId)

List Apple MDM Enrollment Profiles

Get a list of enrollment profiles for an apple mdm.  Note: currently only one enrollment profile is supported.  #### Sample Request &#x60;&#x60;&#x60;  curl https://console.jumpcloud.com/api/v2/applemdms/{APPLE_MDM_ID}/enrollmentprofiles \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AppleMdmApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

AppleMdmApi apiInstance = new AppleMdmApi();
String appleMdmId = "appleMdmId_example"; // String | 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    List<AppleMDM> result = apiInstance.applemdmsEnrollmentprofileslist(appleMdmId, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AppleMdmApi#applemdmsEnrollmentprofileslist");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **appleMdmId** | **String**|  |
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**List&lt;AppleMDM&gt;**](AppleMDM.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="applemdmsGetdevice"></a>
# **applemdmsGetdevice**
> AppleMdmDevice applemdmsGetdevice(appleMdmId, deviceId, xOrgId)

Details of an AppleMDM Device

Gets a single Apple MDM device.  #### Sample Request &#x60;&#x60;&#x60;   curl -X GET https://console.jumpcloud.com/api/v2/applemdms/{apple_mdm_id}/devices/{device_id} \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AppleMdmApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

AppleMdmApi apiInstance = new AppleMdmApi();
String appleMdmId = "appleMdmId_example"; // String | 
String deviceId = "deviceId_example"; // String | 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    AppleMdmDevice result = apiInstance.applemdmsGetdevice(appleMdmId, deviceId, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AppleMdmApi#applemdmsGetdevice");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **appleMdmId** | **String**|  |
 **deviceId** | **String**|  |
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**AppleMdmDevice**](AppleMdmDevice.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="applemdmsList"></a>
# **applemdmsList**
> List&lt;AppleMDM&gt; applemdmsList(xOrgId)

List Apple MDMs

Get a list of all Apple MDM configurations.  An empty topic indicates that a signed certificate from Apple has not been provided to the PUT endpoint yet.  Note: currently only one MDM configuration per organization is supported.  #### Sample Request &#x60;&#x60;&#x60; curl https://console.jumpcloud.com/api/v2/applemdms \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AppleMdmApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

AppleMdmApi apiInstance = new AppleMdmApi();
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    List<AppleMDM> result = apiInstance.applemdmsList(xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AppleMdmApi#applemdmsList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**List&lt;AppleMDM&gt;**](AppleMDM.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="applemdmsPut"></a>
# **applemdmsPut**
> AppleMDM applemdmsPut(id, body, xOrgId)

Update an Apple MDM

Updates an Apple MDM configuration.  This endpoint is used to supply JumpCloud with a signed certificate from Apple in order to finalize the setup and allow JumpCloud to manage your devices.  It may also be used to update the DEP Settings.  #### Sample Request &#x60;&#x60;&#x60;   curl -X PUT https://console.jumpcloud.com/api/v2/applemdms/{ID} \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{     \&quot;name\&quot;: \&quot;MDM name\&quot;,     \&quot;appleSignedCert\&quot;: \&quot;{CERTIFICATE}\&quot;,     \&quot;encryptedDepServerToken\&quot;: \&quot;{SERVER_TOKEN}\&quot;,     \&quot;dep\&quot;: {       \&quot;welcomeScreen\&quot;: {         \&quot;title\&quot;: \&quot;Welcome\&quot;,         \&quot;paragraph\&quot;: \&quot;In just a few steps, you will be working securely from your Mac.\&quot;,         \&quot;button\&quot;: \&quot;continue\&quot;,       },     },   }&#x27; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AppleMdmApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

AppleMdmApi apiInstance = new AppleMdmApi();
String id = "id_example"; // String | 
AppleMdmPatchInput body = new AppleMdmPatchInput(); // AppleMdmPatchInput | 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    AppleMDM result = apiInstance.applemdmsPut(id, body, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AppleMdmApi#applemdmsPut");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **body** | [**AppleMdmPatchInput**](AppleMdmPatchInput.md)|  | [optional]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**AppleMDM**](AppleMDM.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="applemdmsRefreshdepdevices"></a>
# **applemdmsRefreshdepdevices**
> applemdmsRefreshdepdevices(appleMdmId, xOrgId)

Refresh DEP Devices

Refreshes the list of devices that a JumpCloud admin has added to their virtual MDM in Apple Business Manager - ABM so that they can be DEP enrolled with JumpCloud.  #### Sample Request &#x60;&#x60;&#x60;   curl -X POST https://console.jumpcloud.com/api/v2/applemdms/{apple_mdm_id}/refreshdepdevices \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{}&#x27; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AppleMdmApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

AppleMdmApi apiInstance = new AppleMdmApi();
String appleMdmId = "appleMdmId_example"; // String | 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    apiInstance.applemdmsRefreshdepdevices(appleMdmId, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling AppleMdmApi#applemdmsRefreshdepdevices");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **appleMdmId** | **String**|  |
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

