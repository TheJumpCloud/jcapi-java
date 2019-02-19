# Office365Api

All URIs are relative to *https://console.jumpcloud.com/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**graphOffice365AssociationsList**](Office365Api.md#graphOffice365AssociationsList) | **GET** /office365s/{office365_id}/associations | List the associations of an Office 365 instance
[**graphOffice365AssociationsPost**](Office365Api.md#graphOffice365AssociationsPost) | **POST** /office365s/{office365_id}/associations | Manage the associations of an Office 365 instance
[**graphOffice365TraverseUser**](Office365Api.md#graphOffice365TraverseUser) | **GET** /office365s/{office365_id}/users | List the Users bound to an Office 365 instance
[**graphOffice365TraverseUserGroup**](Office365Api.md#graphOffice365TraverseUserGroup) | **GET** /office365s/{office365_id}/usergroups | List the User Groups bound to an Office 365 instance
[**translationRulesOffice365Delete**](Office365Api.md#translationRulesOffice365Delete) | **DELETE** /office365s/{office365_id}/translationrules/{id} | Deletes a Office 365 translation rule
[**translationRulesOffice365Get**](Office365Api.md#translationRulesOffice365Get) | **GET** /office365s/{office365_id}/translationrules/{id} | Gets a specific Office 365 translation rule
[**translationRulesOffice365List**](Office365Api.md#translationRulesOffice365List) | **GET** /office365s/{office365_id}/translationrules | List all the Office 365 Translation Rules
[**translationRulesOffice365Post**](Office365Api.md#translationRulesOffice365Post) | **POST** /office365s/{office365_id}/translationrules | Create a new Office 365 Translation Rule


<a name="graphOffice365AssociationsList"></a>
# **graphOffice365AssociationsList**
> List&lt;GraphConnection&gt; graphOffice365AssociationsList(office365Id, targets, contentType, accept, limit, skip, xOrgId)

List the associations of an Office 365 instance

This endpoint returns _direct_ associations of an Office 365 instance.   A direct association can be a non-homogeneous relationship between 2 different objects, for example Office 365 and Users.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET &#39;https://console.jumpcloud.com/api/v2/office365s/{O365_ID}/associations?targets&#x3D;user_group \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;  &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.Office365Api;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

Office365Api apiInstance = new Office365Api();
String office365Id = "office365Id_example"; // String | ObjectID of the Office 365 instance.
List<String> targets = Arrays.asList("targets_example"); // List<String> | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = ""; // String | 
try {
    List<GraphConnection> result = apiInstance.graphOffice365AssociationsList(office365Id, targets, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling Office365Api#graphOffice365AssociationsList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **office365Id** | **String**| ObjectID of the Office 365 instance. |
 **targets** | [**List&lt;String&gt;**](String.md)|  | [enum: active_directory, application, command, g_suite, ldap_server, office_365, policy, radius_server, system, system_group, user, user_group]
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

[**List&lt;GraphConnection&gt;**](GraphConnection.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphOffice365AssociationsPost"></a>
# **graphOffice365AssociationsPost**
> graphOffice365AssociationsPost(office365Id, contentType, accept, body, xOrgId)

Manage the associations of an Office 365 instance

This endpoint allows you to manage the _direct_ associations of a Office 365 instance.  A direct association can be a non-homogeneous relationship between 2 different objects, for example Office 365 and Users.  #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/office365s/{O365_ID}/associations \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;user_group\&quot;,     \&quot;id\&quot;: \&quot;{Group_ID}\&quot; }&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.Office365Api;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

Office365Api apiInstance = new Office365Api();
String office365Id = "office365Id_example"; // String | ObjectID of the Office 365 instance.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
GraphManagementReq body = new GraphManagementReq(); // GraphManagementReq | 
String xOrgId = ""; // String | 
try {
    apiInstance.graphOffice365AssociationsPost(office365Id, contentType, accept, body, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling Office365Api#graphOffice365AssociationsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **office365Id** | **String**| ObjectID of the Office 365 instance. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **body** | [**GraphManagementReq**](GraphManagementReq.md)|  | [optional]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphOffice365TraverseUser"></a>
# **graphOffice365TraverseUser**
> List&lt;GraphObjectWithPaths&gt; graphOffice365TraverseUser(office365Id, contentType, accept, limit, skip, xOrgId)

List the Users bound to an Office 365 instance

This endpoint will return all Users bound to an Office 365 instance, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this Office 365 instance to the corresponding User; this array represents all grouping and/or associations that would have to be removed to deprovision the User from this Office 365 instance.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/office365s/{O365_ID}/users \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.Office365Api;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

Office365Api apiInstance = new Office365Api();
String office365Id = "office365Id_example"; // String | ObjectID of the Office 365 suite.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = ""; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphOffice365TraverseUser(office365Id, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling Office365Api#graphOffice365TraverseUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **office365Id** | **String**| ObjectID of the Office 365 suite. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphOffice365TraverseUserGroup"></a>
# **graphOffice365TraverseUserGroup**
> List&lt;GraphObjectWithPaths&gt; graphOffice365TraverseUserGroup(office365Id, contentType, accept, limit, skip, xOrgId)

List the User Groups bound to an Office 365 instance

This endpoint will return all Users Groups bound to an Office 365 instance, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the group&#39;s type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this Office 365 instance to the corresponding User Group; this array represents all grouping and/or associations that would have to be removed to deprovision the User Group from this Office 365 instance.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60;   curl -X GET https://console.jumpcloud.com/api/v2/office365s/{O365_ID/usergroups \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.Office365Api;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

Office365Api apiInstance = new Office365Api();
String office365Id = "office365Id_example"; // String | ObjectID of the Office 365 suite.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = ""; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphOffice365TraverseUserGroup(office365Id, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling Office365Api#graphOffice365TraverseUserGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **office365Id** | **String**| ObjectID of the Office 365 suite. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to ]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="translationRulesOffice365Delete"></a>
# **translationRulesOffice365Delete**
> translationRulesOffice365Delete(office365Id, id, contentType, accept)

Deletes a Office 365 translation rule

This endpoint allows you to delete a translation rule for a specific Office 365 instance. These rules specify how JumpCloud attributes translate to [Microsoft Graph](https://developer.microsoft.com/en-us/graph) attributes.  #### Sample Request  &#x60;&#x60;&#x60; curl -X DELETE https://console.jumpcloud.com/api/v2/office365s/{office365_id}/translationrules/{id} \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;   &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.Office365Api;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

Office365Api apiInstance = new Office365Api();
String office365Id = "office365Id_example"; // String | 
String id = "id_example"; // String | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
try {
    apiInstance.translationRulesOffice365Delete(office365Id, id, contentType, accept);
} catch (ApiException e) {
    System.err.println("Exception when calling Office365Api#translationRulesOffice365Delete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **office365Id** | **String**|  |
 **id** | **String**|  |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="translationRulesOffice365Get"></a>
# **translationRulesOffice365Get**
> Office365TranslationRule translationRulesOffice365Get(office365Id, id, contentType, accept)

Gets a specific Office 365 translation rule

This endpoint returns a specific translation rule for a specific Office 365 instance. These rules specify how JumpCloud attributes translate to [Microsoft Graph](https://developer.microsoft.com/en-us/graph) attributes.  ###### Sample Request  &#x60;&#x60;&#x60;   curl -X GET https://console.jumpcloud.com/api/v2/office365s/{office365_id}/translationrules/{id} \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;   &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.Office365Api;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

Office365Api apiInstance = new Office365Api();
String office365Id = "office365Id_example"; // String | 
String id = "id_example"; // String | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
try {
    Office365TranslationRule result = apiInstance.translationRulesOffice365Get(office365Id, id, contentType, accept);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling Office365Api#translationRulesOffice365Get");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **office365Id** | **String**|  |
 **id** | **String**|  |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]

### Return type

[**Office365TranslationRule**](Office365TranslationRule.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="translationRulesOffice365List"></a>
# **translationRulesOffice365List**
> List&lt;Office365TranslationRule&gt; translationRulesOffice365List(office365Id, contentType, accept, fields, filter, limit, skip, sort)

List all the Office 365 Translation Rules

This endpoint returns all translation rules for a specific Office 365 instance. These rules specify how JumpCloud attributes translate to [Microsoft Graph](https://developer.microsoft.com/en-us/graph) attributes.  ##### Sample Request  &#x60;&#x60;&#x60;  curl -X GET  https://console.jumpcloud.com/api/v2/office365s/{office365_id}/translationrules \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;   &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.Office365Api;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

Office365Api apiInstance = new Office365Api();
String office365Id = "office365Id_example"; // String | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
List<String> fields = Arrays.asList("[]"); // List<String> | The comma separated fields included in the returned records. If omitted the default list of fields will be returned. 
List<String> filter = Arrays.asList("[]"); // List<String> | Supported operators are: eq, ne, gt, ge, lt, le, between, search, in
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> sort = Arrays.asList("[]"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
try {
    List<Office365TranslationRule> result = apiInstance.translationRulesOffice365List(office365Id, contentType, accept, fields, filter, limit, skip, sort);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling Office365Api#translationRulesOffice365List");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **office365Id** | **String**|  |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **fields** | [**List&lt;String&gt;**](String.md)| The comma separated fields included in the returned records. If omitted the default list of fields will be returned.  | [optional] [default to []]
 **filter** | [**List&lt;String&gt;**](String.md)| Supported operators are: eq, ne, gt, ge, lt, le, between, search, in | [optional] [default to []]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **sort** | [**List&lt;String&gt;**](String.md)| The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  | [optional] [default to []]

### Return type

[**List&lt;Office365TranslationRule&gt;**](Office365TranslationRule.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="translationRulesOffice365Post"></a>
# **translationRulesOffice365Post**
> Office365TranslationRule translationRulesOffice365Post(office365Id, contentType, accept, body)

Create a new Office 365 Translation Rule

This endpoint allows you to create a translation rule for a specific Office 365 instance. These rules specify how JumpCloud attributes translate to [Microsoft Graph](https://developer.microsoft.com/en-us/graph) attributes.  ##### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/office365s/{office365_id}/translationrules \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{   {Translation Rule Parameters} }&#39;  &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.Office365Api;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

Office365Api apiInstance = new Office365Api();
String office365Id = "office365Id_example"; // String | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Office365TranslationRuleRequest body = new Office365TranslationRuleRequest(); // Office365TranslationRuleRequest | 
try {
    Office365TranslationRule result = apiInstance.translationRulesOffice365Post(office365Id, contentType, accept, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling Office365Api#translationRulesOffice365Post");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **office365Id** | **String**|  |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **body** | [**Office365TranslationRuleRequest**](Office365TranslationRuleRequest.md)|  | [optional]

### Return type

[**Office365TranslationRule**](Office365TranslationRule.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

