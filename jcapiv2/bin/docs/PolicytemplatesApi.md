# PolicytemplatesApi

All URIs are relative to *https://console.jumpcloud.com/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**policytemplatesGet**](PolicytemplatesApi.md#policytemplatesGet) | **GET** /policytemplates/{id} | Get a specific Policy Template
[**policytemplatesList**](PolicytemplatesApi.md#policytemplatesList) | **GET** /policytemplates | Lists all of the Policy Templates


<a name="policytemplatesGet"></a>
# **policytemplatesGet**
> PolicyTemplateWithDetails policytemplatesGet(id, contentType, accept, xOrgId)

Get a specific Policy Template

This endpoint returns a specific policy template.  #### Sample Request &#x60;&#x60;&#x60;  curl -X GET https://console.jumpcloud.com/api/v2/policies/{Policy_ID}\\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.PolicytemplatesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

PolicytemplatesApi apiInstance = new PolicytemplatesApi();
String id = "id_example"; // String | ObjectID of the Policy Template.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
String xOrgId = ""; // String | 
try {
    PolicyTemplateWithDetails result = apiInstance.policytemplatesGet(id, contentType, accept, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PolicytemplatesApi#policytemplatesGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| ObjectID of the Policy Template. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

[**PolicyTemplateWithDetails**](PolicyTemplateWithDetails.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="policytemplatesList"></a>
# **policytemplatesList**
> List&lt;PolicyTemplate&gt; policytemplatesList(contentType, accept, fields, filter, limit, skip, sort, xOrgId)

Lists all of the Policy Templates

This endpoint returns all policy templates.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/policytemplates \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;   &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.PolicytemplatesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

PolicytemplatesApi apiInstance = new PolicytemplatesApi();
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
List<String> fields = Arrays.asList("[]"); // List<String> | The comma separated fields included in the returned records. If omitted the default list of fields will be returned. 
List<String> filter = Arrays.asList("[]"); // List<String> | Supported operators are: eq, ne, gt, ge, lt, le, between, search, in
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> sort = Arrays.asList("[]"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
String xOrgId = ""; // String | 
try {
    List<PolicyTemplate> result = apiInstance.policytemplatesList(contentType, accept, fields, filter, limit, skip, sort, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PolicytemplatesApi#policytemplatesList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **fields** | [**List&lt;String&gt;**](String.md)| The comma separated fields included in the returned records. If omitted the default list of fields will be returned.  | [optional] [default to []]
 **filter** | [**List&lt;String&gt;**](String.md)| Supported operators are: eq, ne, gt, ge, lt, le, between, search, in | [optional] [default to []]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **sort** | [**List&lt;String&gt;**](String.md)| The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  | [optional] [default to []]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

[**List&lt;PolicyTemplate&gt;**](PolicyTemplate.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

