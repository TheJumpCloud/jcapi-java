# KnowledgeApi

All URIs are relative to *https://console.jumpcloud.com/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**knowledgeArticlesList**](KnowledgeApi.md#knowledgeArticlesList) | **GET** /knowledge/articles | List Knowledge Articles
[**knowledgeSalesforceList**](KnowledgeApi.md#knowledgeSalesforceList) | **GET** /knowledge/salesforce | List Knowledge Articles


<a name="knowledgeArticlesList"></a>
# **knowledgeArticlesList**
> SalesforceKnowledgeListOutput knowledgeArticlesList(filter, skip, sort, limit)

List Knowledge Articles

This endpoint returns a list of knowledge articles hosted in salesforce.  &#x60;&#x60;&#x60; Sample Request curl -X GET https://console.jumpcloud.com/api/v2/knowledge/articles \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.KnowledgeApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

KnowledgeApi apiInstance = new KnowledgeApi();
List<String> filter = Arrays.asList("filter_example"); // List<String> | Supported operators are: eq, ne, gt, ge, lt, le, between, search, in
Integer skip = 0; // Integer | The offset into the records to return.
List<String> sort = Arrays.asList("sort_example"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
Integer limit = 10; // Integer | 
try {
    SalesforceKnowledgeListOutput result = apiInstance.knowledgeArticlesList(filter, skip, sort, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling KnowledgeApi#knowledgeArticlesList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filter** | [**List&lt;String&gt;**](String.md)| Supported operators are: eq, ne, gt, ge, lt, le, between, search, in | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **sort** | [**List&lt;String&gt;**](String.md)| The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  | [optional]
 **limit** | **Integer**|  | [optional] [default to 10]

### Return type

[**SalesforceKnowledgeListOutput**](SalesforceKnowledgeListOutput.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="knowledgeSalesforceList"></a>
# **knowledgeSalesforceList**
> SalesforceKnowledgeListOutput knowledgeSalesforceList(fields, filter, limit, skip, sort)

List Knowledge Articles

This endpoint returns a list of knowledge articles hosted in salesforce.  &#x60;&#x60;&#x60; Sample Request curl -X GET https://console.jumpcloud.com/api/v2/knowledge/articles \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.KnowledgeApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

KnowledgeApi apiInstance = new KnowledgeApi();
List<String> fields = Arrays.asList("fields_example"); // List<String> | 
List<String> filter = Arrays.asList("filter_example"); // List<String> | Supported operators are: eq, ne, gt, ge, lt, le, between, search, in
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> sort = Arrays.asList("sort_example"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
try {
    SalesforceKnowledgeListOutput result = apiInstance.knowledgeSalesforceList(fields, filter, limit, skip, sort);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling KnowledgeApi#knowledgeSalesforceList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fields** | [**List&lt;String&gt;**](String.md)|  | [optional]
 **filter** | [**List&lt;String&gt;**](String.md)| Supported operators are: eq, ne, gt, ge, lt, le, between, search, in | [optional]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **sort** | [**List&lt;String&gt;**](String.md)| The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  | [optional]

### Return type

[**SalesforceKnowledgeListOutput**](SalesforceKnowledgeListOutput.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

