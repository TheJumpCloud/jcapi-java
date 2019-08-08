# SystemInsightsApi

All URIs are relative to *https://console.jumpcloud.com/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**systeminsightsListApps**](SystemInsightsApi.md#systeminsightsListApps) | **GET** /systeminsights/apps | List System Insights Apps
[**systeminsightsListApps_0**](SystemInsightsApi.md#systeminsightsListApps_0) | **GET** /systeminsights/{jc_system_id}/apps | List System Insights System Apps
[**systeminsightsListBrowserPlugins**](SystemInsightsApi.md#systeminsightsListBrowserPlugins) | **GET** /systeminsights/{jc_system_id}/browser_plugins | List System Insights System Browser Plugins
[**systeminsightsListBrowserPlugins_0**](SystemInsightsApi.md#systeminsightsListBrowserPlugins_0) | **GET** /systeminsights/browser_plugins | List System Insights Browser Plugins
[**systeminsightsListChromeExtensions**](SystemInsightsApi.md#systeminsightsListChromeExtensions) | **GET** /systeminsights/{jc_system_id}/chrome_extensions | List System Insights System Chrome Extensions
[**systeminsightsListChromeExtensions_0**](SystemInsightsApi.md#systeminsightsListChromeExtensions_0) | **GET** /systeminsights/chrome_extensions | List System Insights Chrome Extensions
[**systeminsightsListDiskEncryption**](SystemInsightsApi.md#systeminsightsListDiskEncryption) | **GET** /systeminsights/disk_encryption | List System Insights Disk Encryption
[**systeminsightsListDiskEncryption_0**](SystemInsightsApi.md#systeminsightsListDiskEncryption_0) | **GET** /systeminsights/{jc_system_id}/disk_encryption | List System Insights System Disk Encryption
[**systeminsightsListFirefoxAddons**](SystemInsightsApi.md#systeminsightsListFirefoxAddons) | **GET** /systeminsights/firefox_addons | List System Insights Firefox Addons
[**systeminsightsListFirefoxAddons_0**](SystemInsightsApi.md#systeminsightsListFirefoxAddons_0) | **GET** /systeminsights/{jc_system_id}/firefox_addons | List System Insights System Firefox Addons
[**systeminsightsListGroups**](SystemInsightsApi.md#systeminsightsListGroups) | **GET** /systeminsights/groups | List System Insights Groups
[**systeminsightsListGroups_0**](SystemInsightsApi.md#systeminsightsListGroups_0) | **GET** /systeminsights/{jc_system_id}/groups | List System Insights System Groups
[**systeminsightsListInterfaceAddresses**](SystemInsightsApi.md#systeminsightsListInterfaceAddresses) | **GET** /systeminsights/interface_addresses | List System Insights Interface Addresses
[**systeminsightsListInterfaceAddresses_0**](SystemInsightsApi.md#systeminsightsListInterfaceAddresses_0) | **GET** /systeminsights/{jc_system_id}/interface_addresses | List System Insights System Interface Addresses
[**systeminsightsListMounts**](SystemInsightsApi.md#systeminsightsListMounts) | **GET** /systeminsights/mounts | List System Insights Mounts
[**systeminsightsListMounts_0**](SystemInsightsApi.md#systeminsightsListMounts_0) | **GET** /systeminsights/{jc_system_id}/mounts | List System Insights System Mounts
[**systeminsightsListOsVersion**](SystemInsightsApi.md#systeminsightsListOsVersion) | **GET** /systeminsights/{jc_system_id}/os_version | List System Insights System OS Version
[**systeminsightsListOsVersion_0**](SystemInsightsApi.md#systeminsightsListOsVersion_0) | **GET** /systeminsights/os_version | List System Insights OS Version
[**systeminsightsListSafariExtensions**](SystemInsightsApi.md#systeminsightsListSafariExtensions) | **GET** /systeminsights/{jc_system_id}/safari_extensions | List System Insights System Safari Extensions
[**systeminsightsListSafariExtensions_0**](SystemInsightsApi.md#systeminsightsListSafariExtensions_0) | **GET** /systeminsights/safari_extensions | List System Insights Safari Extensions
[**systeminsightsListSystemInfo**](SystemInsightsApi.md#systeminsightsListSystemInfo) | **GET** /systeminsights/system_info | List System Insights System Info
[**systeminsightsListSystemInfo_0**](SystemInsightsApi.md#systeminsightsListSystemInfo_0) | **GET** /systeminsights/{jc_system_id}/system_info | List System Insights System System Info
[**systeminsightsListUsers**](SystemInsightsApi.md#systeminsightsListUsers) | **GET** /systeminsights/users | List System Insights Users
[**systeminsightsListUsers_0**](SystemInsightsApi.md#systeminsightsListUsers_0) | **GET** /systeminsights/{jc_system_id}/users | List System Insights System Users


<a name="systeminsightsListApps"></a>
# **systeminsightsListApps**
> List&lt;SystemInsightsApps&gt; systeminsightsListApps(limit, skip, filter)

List System Insights Apps

Valid filter fields are &#x60;jc_system_id&#x60; and &#x60;bundle_name&#x60;.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SystemInsightsApi;


SystemInsightsApi apiInstance = new SystemInsightsApi();
Integer limit = 10; // Integer | 
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | Supported operators are: eq
try {
    List<SystemInsightsApps> result = apiInstance.systeminsightsListApps(limit, skip, filter);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemInsightsApi#systeminsightsListApps");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**|  | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **filter** | [**List&lt;String&gt;**](String.md)| Supported operators are: eq | [optional]

### Return type

[**List&lt;SystemInsightsApps&gt;**](SystemInsightsApps.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="systeminsightsListApps_0"></a>
# **systeminsightsListApps_0**
> List&lt;SystemInsightsApps&gt; systeminsightsListApps_0(jcSystemId, limit, skip, filter)

List System Insights System Apps

Valid filter fields are &#x60;bundle_name&#x60;.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SystemInsightsApi;


SystemInsightsApi apiInstance = new SystemInsightsApi();
String jcSystemId = "jcSystemId_example"; // String | 
Integer limit = 10; // Integer | 
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | Supported operators are: eq
try {
    List<SystemInsightsApps> result = apiInstance.systeminsightsListApps_0(jcSystemId, limit, skip, filter);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemInsightsApi#systeminsightsListApps_0");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jcSystemId** | **String**|  |
 **limit** | **Integer**|  | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **filter** | [**List&lt;String&gt;**](String.md)| Supported operators are: eq | [optional]

### Return type

[**List&lt;SystemInsightsApps&gt;**](SystemInsightsApps.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="systeminsightsListBrowserPlugins"></a>
# **systeminsightsListBrowserPlugins**
> List&lt;SystemInsightsBrowserPlugins&gt; systeminsightsListBrowserPlugins(jcSystemId, limit, skip, filter)

List System Insights System Browser Plugins

Valid filter fields are &#x60;name&#x60;.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SystemInsightsApi;


SystemInsightsApi apiInstance = new SystemInsightsApi();
String jcSystemId = "jcSystemId_example"; // String | 
Integer limit = 10; // Integer | 
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | Supported operators are: eq
try {
    List<SystemInsightsBrowserPlugins> result = apiInstance.systeminsightsListBrowserPlugins(jcSystemId, limit, skip, filter);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemInsightsApi#systeminsightsListBrowserPlugins");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jcSystemId** | **String**|  |
 **limit** | **Integer**|  | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **filter** | [**List&lt;String&gt;**](String.md)| Supported operators are: eq | [optional]

### Return type

[**List&lt;SystemInsightsBrowserPlugins&gt;**](SystemInsightsBrowserPlugins.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="systeminsightsListBrowserPlugins_0"></a>
# **systeminsightsListBrowserPlugins_0**
> List&lt;SystemInsightsBrowserPlugins&gt; systeminsightsListBrowserPlugins_0(limit, skip, filter)

List System Insights Browser Plugins

Valid filter fields are &#x60;jc_system_id&#x60; and &#x60;name&#x60;.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SystemInsightsApi;


SystemInsightsApi apiInstance = new SystemInsightsApi();
Integer limit = 10; // Integer | 
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | Supported operators are: eq
try {
    List<SystemInsightsBrowserPlugins> result = apiInstance.systeminsightsListBrowserPlugins_0(limit, skip, filter);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemInsightsApi#systeminsightsListBrowserPlugins_0");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**|  | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **filter** | [**List&lt;String&gt;**](String.md)| Supported operators are: eq | [optional]

### Return type

[**List&lt;SystemInsightsBrowserPlugins&gt;**](SystemInsightsBrowserPlugins.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="systeminsightsListChromeExtensions"></a>
# **systeminsightsListChromeExtensions**
> List&lt;SystemInsightsChromeExtensions&gt; systeminsightsListChromeExtensions(jcSystemId, limit, skip, filter)

List System Insights System Chrome Extensions

Valid filter fields are &#x60;name&#x60;.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SystemInsightsApi;


SystemInsightsApi apiInstance = new SystemInsightsApi();
String jcSystemId = "jcSystemId_example"; // String | 
Integer limit = 10; // Integer | 
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | Supported operators are: eq
try {
    List<SystemInsightsChromeExtensions> result = apiInstance.systeminsightsListChromeExtensions(jcSystemId, limit, skip, filter);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemInsightsApi#systeminsightsListChromeExtensions");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jcSystemId** | **String**|  |
 **limit** | **Integer**|  | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **filter** | [**List&lt;String&gt;**](String.md)| Supported operators are: eq | [optional]

### Return type

[**List&lt;SystemInsightsChromeExtensions&gt;**](SystemInsightsChromeExtensions.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="systeminsightsListChromeExtensions_0"></a>
# **systeminsightsListChromeExtensions_0**
> List&lt;SystemInsightsChromeExtensions&gt; systeminsightsListChromeExtensions_0(limit, skip, filter)

List System Insights Chrome Extensions

Valid filter fields are &#x60;jc_system_id&#x60; and &#x60;name&#x60;.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SystemInsightsApi;


SystemInsightsApi apiInstance = new SystemInsightsApi();
Integer limit = 10; // Integer | 
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | Supported operators are: eq
try {
    List<SystemInsightsChromeExtensions> result = apiInstance.systeminsightsListChromeExtensions_0(limit, skip, filter);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemInsightsApi#systeminsightsListChromeExtensions_0");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**|  | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **filter** | [**List&lt;String&gt;**](String.md)| Supported operators are: eq | [optional]

### Return type

[**List&lt;SystemInsightsChromeExtensions&gt;**](SystemInsightsChromeExtensions.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="systeminsightsListDiskEncryption"></a>
# **systeminsightsListDiskEncryption**
> List&lt;SystemInsightsDiskEncryption&gt; systeminsightsListDiskEncryption(limit, skip, filter)

List System Insights Disk Encryption

Valid filter fields are &#x60;jc_system_id&#x60; and &#x60;encryption_status&#x60;.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SystemInsightsApi;


SystemInsightsApi apiInstance = new SystemInsightsApi();
Integer limit = 10; // Integer | 
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | Supported operators are: eq
try {
    List<SystemInsightsDiskEncryption> result = apiInstance.systeminsightsListDiskEncryption(limit, skip, filter);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemInsightsApi#systeminsightsListDiskEncryption");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**|  | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **filter** | [**List&lt;String&gt;**](String.md)| Supported operators are: eq | [optional]

### Return type

[**List&lt;SystemInsightsDiskEncryption&gt;**](SystemInsightsDiskEncryption.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="systeminsightsListDiskEncryption_0"></a>
# **systeminsightsListDiskEncryption_0**
> List&lt;SystemInsightsDiskEncryption&gt; systeminsightsListDiskEncryption_0(jcSystemId, limit, skip, filter)

List System Insights System Disk Encryption

Valid filter fields are &#x60;encryption_status&#x60;.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SystemInsightsApi;


SystemInsightsApi apiInstance = new SystemInsightsApi();
String jcSystemId = "jcSystemId_example"; // String | 
Integer limit = 10; // Integer | 
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | Supported operators are: eq
try {
    List<SystemInsightsDiskEncryption> result = apiInstance.systeminsightsListDiskEncryption_0(jcSystemId, limit, skip, filter);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemInsightsApi#systeminsightsListDiskEncryption_0");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jcSystemId** | **String**|  |
 **limit** | **Integer**|  | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **filter** | [**List&lt;String&gt;**](String.md)| Supported operators are: eq | [optional]

### Return type

[**List&lt;SystemInsightsDiskEncryption&gt;**](SystemInsightsDiskEncryption.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="systeminsightsListFirefoxAddons"></a>
# **systeminsightsListFirefoxAddons**
> List&lt;SystemInsightsFirefoxAddons&gt; systeminsightsListFirefoxAddons(limit, skip, filter)

List System Insights Firefox Addons

Valid filter fields are &#x60;jc_system_id&#x60; and &#x60;name&#x60;.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SystemInsightsApi;


SystemInsightsApi apiInstance = new SystemInsightsApi();
Integer limit = 10; // Integer | 
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | Supported operators are: eq
try {
    List<SystemInsightsFirefoxAddons> result = apiInstance.systeminsightsListFirefoxAddons(limit, skip, filter);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemInsightsApi#systeminsightsListFirefoxAddons");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**|  | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **filter** | [**List&lt;String&gt;**](String.md)| Supported operators are: eq | [optional]

### Return type

[**List&lt;SystemInsightsFirefoxAddons&gt;**](SystemInsightsFirefoxAddons.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="systeminsightsListFirefoxAddons_0"></a>
# **systeminsightsListFirefoxAddons_0**
> List&lt;SystemInsightsFirefoxAddons&gt; systeminsightsListFirefoxAddons_0(jcSystemId, limit, skip, filter)

List System Insights System Firefox Addons

Valid filter fields are &#x60;name&#x60;.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SystemInsightsApi;


SystemInsightsApi apiInstance = new SystemInsightsApi();
String jcSystemId = "jcSystemId_example"; // String | 
Integer limit = 10; // Integer | 
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | Supported operators are: eq
try {
    List<SystemInsightsFirefoxAddons> result = apiInstance.systeminsightsListFirefoxAddons_0(jcSystemId, limit, skip, filter);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemInsightsApi#systeminsightsListFirefoxAddons_0");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jcSystemId** | **String**|  |
 **limit** | **Integer**|  | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **filter** | [**List&lt;String&gt;**](String.md)| Supported operators are: eq | [optional]

### Return type

[**List&lt;SystemInsightsFirefoxAddons&gt;**](SystemInsightsFirefoxAddons.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="systeminsightsListGroups"></a>
# **systeminsightsListGroups**
> List&lt;SystemInsightsGroups&gt; systeminsightsListGroups(limit, skip, filter)

List System Insights Groups

Valid filter fields are &#x60;jc_system_id&#x60; and &#x60;groupname&#x60;.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SystemInsightsApi;


SystemInsightsApi apiInstance = new SystemInsightsApi();
Integer limit = 10; // Integer | 
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | Supported operators are: eq
try {
    List<SystemInsightsGroups> result = apiInstance.systeminsightsListGroups(limit, skip, filter);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemInsightsApi#systeminsightsListGroups");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**|  | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **filter** | [**List&lt;String&gt;**](String.md)| Supported operators are: eq | [optional]

### Return type

[**List&lt;SystemInsightsGroups&gt;**](SystemInsightsGroups.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="systeminsightsListGroups_0"></a>
# **systeminsightsListGroups_0**
> List&lt;SystemInsightsGroups&gt; systeminsightsListGroups_0(jcSystemId, limit, skip, filter)

List System Insights System Groups

Valid filter fields are &#x60;groupname&#x60;.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SystemInsightsApi;


SystemInsightsApi apiInstance = new SystemInsightsApi();
String jcSystemId = "jcSystemId_example"; // String | 
Integer limit = 10; // Integer | 
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | Supported operators are: eq
try {
    List<SystemInsightsGroups> result = apiInstance.systeminsightsListGroups_0(jcSystemId, limit, skip, filter);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemInsightsApi#systeminsightsListGroups_0");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jcSystemId** | **String**|  |
 **limit** | **Integer**|  | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **filter** | [**List&lt;String&gt;**](String.md)| Supported operators are: eq | [optional]

### Return type

[**List&lt;SystemInsightsGroups&gt;**](SystemInsightsGroups.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="systeminsightsListInterfaceAddresses"></a>
# **systeminsightsListInterfaceAddresses**
> List&lt;SystemInsightsInterfaceAddresses&gt; systeminsightsListInterfaceAddresses(limit, skip, filter)

List System Insights Interface Addresses

Valid filter fields are &#x60;jc_system_id&#x60; and &#x60;address&#x60;.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SystemInsightsApi;


SystemInsightsApi apiInstance = new SystemInsightsApi();
Integer limit = 10; // Integer | 
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | Supported operators are: eq
try {
    List<SystemInsightsInterfaceAddresses> result = apiInstance.systeminsightsListInterfaceAddresses(limit, skip, filter);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemInsightsApi#systeminsightsListInterfaceAddresses");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**|  | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **filter** | [**List&lt;String&gt;**](String.md)| Supported operators are: eq | [optional]

### Return type

[**List&lt;SystemInsightsInterfaceAddresses&gt;**](SystemInsightsInterfaceAddresses.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="systeminsightsListInterfaceAddresses_0"></a>
# **systeminsightsListInterfaceAddresses_0**
> List&lt;SystemInsightsInterfaceAddresses&gt; systeminsightsListInterfaceAddresses_0(jcSystemId, limit, skip, filter)

List System Insights System Interface Addresses

Valid filter fields are &#x60;address&#x60;.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SystemInsightsApi;


SystemInsightsApi apiInstance = new SystemInsightsApi();
String jcSystemId = "jcSystemId_example"; // String | 
Integer limit = 10; // Integer | 
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | Supported operators are: eq
try {
    List<SystemInsightsInterfaceAddresses> result = apiInstance.systeminsightsListInterfaceAddresses_0(jcSystemId, limit, skip, filter);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemInsightsApi#systeminsightsListInterfaceAddresses_0");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jcSystemId** | **String**|  |
 **limit** | **Integer**|  | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **filter** | [**List&lt;String&gt;**](String.md)| Supported operators are: eq | [optional]

### Return type

[**List&lt;SystemInsightsInterfaceAddresses&gt;**](SystemInsightsInterfaceAddresses.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="systeminsightsListMounts"></a>
# **systeminsightsListMounts**
> List&lt;SystemInsightsMounts&gt; systeminsightsListMounts(limit, skip, filter)

List System Insights Mounts

Valid filter fields are &#x60;jc_system_id&#x60; and &#x60;path&#x60;.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SystemInsightsApi;


SystemInsightsApi apiInstance = new SystemInsightsApi();
Integer limit = 10; // Integer | 
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | Supported operators are: eq
try {
    List<SystemInsightsMounts> result = apiInstance.systeminsightsListMounts(limit, skip, filter);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemInsightsApi#systeminsightsListMounts");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**|  | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **filter** | [**List&lt;String&gt;**](String.md)| Supported operators are: eq | [optional]

### Return type

[**List&lt;SystemInsightsMounts&gt;**](SystemInsightsMounts.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="systeminsightsListMounts_0"></a>
# **systeminsightsListMounts_0**
> List&lt;SystemInsightsMounts&gt; systeminsightsListMounts_0(jcSystemId, limit, skip, filter)

List System Insights System Mounts

Valid filter fields are &#x60;path&#x60;.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SystemInsightsApi;


SystemInsightsApi apiInstance = new SystemInsightsApi();
String jcSystemId = "jcSystemId_example"; // String | 
Integer limit = 10; // Integer | 
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | Supported operators are: eq
try {
    List<SystemInsightsMounts> result = apiInstance.systeminsightsListMounts_0(jcSystemId, limit, skip, filter);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemInsightsApi#systeminsightsListMounts_0");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jcSystemId** | **String**|  |
 **limit** | **Integer**|  | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **filter** | [**List&lt;String&gt;**](String.md)| Supported operators are: eq | [optional]

### Return type

[**List&lt;SystemInsightsMounts&gt;**](SystemInsightsMounts.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="systeminsightsListOsVersion"></a>
# **systeminsightsListOsVersion**
> List&lt;SystemInsightsOsVersion&gt; systeminsightsListOsVersion(jcSystemId, limit, skip, filter)

List System Insights System OS Version

Valid filter fields are &#x60;version&#x60;.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SystemInsightsApi;


SystemInsightsApi apiInstance = new SystemInsightsApi();
String jcSystemId = "jcSystemId_example"; // String | 
Integer limit = 10; // Integer | 
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | Supported operators are: eq
try {
    List<SystemInsightsOsVersion> result = apiInstance.systeminsightsListOsVersion(jcSystemId, limit, skip, filter);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemInsightsApi#systeminsightsListOsVersion");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jcSystemId** | **String**|  |
 **limit** | **Integer**|  | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **filter** | [**List&lt;String&gt;**](String.md)| Supported operators are: eq | [optional]

### Return type

[**List&lt;SystemInsightsOsVersion&gt;**](SystemInsightsOsVersion.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="systeminsightsListOsVersion_0"></a>
# **systeminsightsListOsVersion_0**
> List&lt;SystemInsightsOsVersion&gt; systeminsightsListOsVersion_0(limit, skip, filter)

List System Insights OS Version

Valid filter fields are &#x60;jc_system_id&#x60; and &#x60;version&#x60;.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SystemInsightsApi;


SystemInsightsApi apiInstance = new SystemInsightsApi();
Integer limit = 10; // Integer | 
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | Supported operators are: eq
try {
    List<SystemInsightsOsVersion> result = apiInstance.systeminsightsListOsVersion_0(limit, skip, filter);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemInsightsApi#systeminsightsListOsVersion_0");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**|  | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **filter** | [**List&lt;String&gt;**](String.md)| Supported operators are: eq | [optional]

### Return type

[**List&lt;SystemInsightsOsVersion&gt;**](SystemInsightsOsVersion.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="systeminsightsListSafariExtensions"></a>
# **systeminsightsListSafariExtensions**
> List&lt;SystemInsightsSafariExtensions&gt; systeminsightsListSafariExtensions(jcSystemId, limit, skip, filter)

List System Insights System Safari Extensions

Valid filter fields are &#x60;name&#x60;.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SystemInsightsApi;


SystemInsightsApi apiInstance = new SystemInsightsApi();
String jcSystemId = "jcSystemId_example"; // String | 
Integer limit = 10; // Integer | 
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | Supported operators are: eq
try {
    List<SystemInsightsSafariExtensions> result = apiInstance.systeminsightsListSafariExtensions(jcSystemId, limit, skip, filter);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemInsightsApi#systeminsightsListSafariExtensions");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jcSystemId** | **String**|  |
 **limit** | **Integer**|  | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **filter** | [**List&lt;String&gt;**](String.md)| Supported operators are: eq | [optional]

### Return type

[**List&lt;SystemInsightsSafariExtensions&gt;**](SystemInsightsSafariExtensions.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="systeminsightsListSafariExtensions_0"></a>
# **systeminsightsListSafariExtensions_0**
> List&lt;SystemInsightsSafariExtensions&gt; systeminsightsListSafariExtensions_0(limit, skip, filter)

List System Insights Safari Extensions

Valid filter fields are &#x60;jc_system_id&#x60; and &#x60;name&#x60;.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SystemInsightsApi;


SystemInsightsApi apiInstance = new SystemInsightsApi();
Integer limit = 10; // Integer | 
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | Supported operators are: eq
try {
    List<SystemInsightsSafariExtensions> result = apiInstance.systeminsightsListSafariExtensions_0(limit, skip, filter);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemInsightsApi#systeminsightsListSafariExtensions_0");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**|  | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **filter** | [**List&lt;String&gt;**](String.md)| Supported operators are: eq | [optional]

### Return type

[**List&lt;SystemInsightsSafariExtensions&gt;**](SystemInsightsSafariExtensions.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="systeminsightsListSystemInfo"></a>
# **systeminsightsListSystemInfo**
> List&lt;SystemInsightsSystemInfo&gt; systeminsightsListSystemInfo(limit, skip, filter)

List System Insights System Info

Valid filter fields are &#x60;jc_system_id&#x60; and &#x60;cpu_subtype&#x60;.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SystemInsightsApi;


SystemInsightsApi apiInstance = new SystemInsightsApi();
Integer limit = 10; // Integer | 
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | Supported operators are: eq
try {
    List<SystemInsightsSystemInfo> result = apiInstance.systeminsightsListSystemInfo(limit, skip, filter);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemInsightsApi#systeminsightsListSystemInfo");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**|  | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **filter** | [**List&lt;String&gt;**](String.md)| Supported operators are: eq | [optional]

### Return type

[**List&lt;SystemInsightsSystemInfo&gt;**](SystemInsightsSystemInfo.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="systeminsightsListSystemInfo_0"></a>
# **systeminsightsListSystemInfo_0**
> List&lt;SystemInsightsSystemInfo&gt; systeminsightsListSystemInfo_0(jcSystemId, limit, skip, filter)

List System Insights System System Info

Valid filter fields are &#x60;cpu_subtype&#x60;.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SystemInsightsApi;


SystemInsightsApi apiInstance = new SystemInsightsApi();
String jcSystemId = "jcSystemId_example"; // String | 
Integer limit = 10; // Integer | 
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | Supported operators are: eq
try {
    List<SystemInsightsSystemInfo> result = apiInstance.systeminsightsListSystemInfo_0(jcSystemId, limit, skip, filter);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemInsightsApi#systeminsightsListSystemInfo_0");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jcSystemId** | **String**|  |
 **limit** | **Integer**|  | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **filter** | [**List&lt;String&gt;**](String.md)| Supported operators are: eq | [optional]

### Return type

[**List&lt;SystemInsightsSystemInfo&gt;**](SystemInsightsSystemInfo.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="systeminsightsListUsers"></a>
# **systeminsightsListUsers**
> List&lt;SystemInsightsUsers&gt; systeminsightsListUsers(limit, skip, filter)

List System Insights Users

Valid filter fields are &#x60;jc_system_id&#x60; and &#x60;username&#x60;.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SystemInsightsApi;


SystemInsightsApi apiInstance = new SystemInsightsApi();
Integer limit = 10; // Integer | 
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | Supported operators are: eq
try {
    List<SystemInsightsUsers> result = apiInstance.systeminsightsListUsers(limit, skip, filter);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemInsightsApi#systeminsightsListUsers");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**|  | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **filter** | [**List&lt;String&gt;**](String.md)| Supported operators are: eq | [optional]

### Return type

[**List&lt;SystemInsightsUsers&gt;**](SystemInsightsUsers.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="systeminsightsListUsers_0"></a>
# **systeminsightsListUsers_0**
> List&lt;SystemInsightsUsers&gt; systeminsightsListUsers_0(jcSystemId, limit, skip, filter)

List System Insights System Users

Valid filter fields are &#x60;username&#x60;.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SystemInsightsApi;


SystemInsightsApi apiInstance = new SystemInsightsApi();
String jcSystemId = "jcSystemId_example"; // String | 
Integer limit = 10; // Integer | 
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | Supported operators are: eq
try {
    List<SystemInsightsUsers> result = apiInstance.systeminsightsListUsers_0(jcSystemId, limit, skip, filter);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemInsightsApi#systeminsightsListUsers_0");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jcSystemId** | **String**|  |
 **limit** | **Integer**|  | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **filter** | [**List&lt;String&gt;**](String.md)| Supported operators are: eq | [optional]

### Return type

[**List&lt;SystemInsightsUsers&gt;**](SystemInsightsUsers.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

