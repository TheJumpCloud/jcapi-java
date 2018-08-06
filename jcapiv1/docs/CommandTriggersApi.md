# CommandTriggersApi

All URIs are relative to *https://console.jumpcloud.com/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**commandTriggerWebhookPost**](CommandTriggersApi.md#commandTriggerWebhookPost) | **POST** /command/trigger/{triggername} | Launch a command via a Trigger


<a name="commandTriggerWebhookPost"></a>
# **commandTriggerWebhookPost**
> commandTriggerWebhookPost(triggername, contentType, accept)

Launch a command via a Trigger

This endpoint allows you to launch a command based on a defined trigger.  #### Sample Requests  **Launch a Command via a Trigger**  &#x60;&#x60;&#x60; curl --silent \\      -X &#39;POST&#39; \\      -H \&quot;x-api-key: {API_KEY}\&quot; \\      \&quot;https://console.jumpcloud.com/api/command/trigger/{TriggerName}\&quot; &#x60;&#x60;&#x60; **Launch a Command via a Trigger passing a JSON object to the command** &#x60;&#x60;&#x60; curl --silent \\      -X &#39;POST&#39; \\      -H \&quot;x-api-key: {API_KEY}\&quot; \\      -H &#39;Accept: application/json&#39; \\      -H &#39;Content-Type: application/json&#39; \\      -d &#39;{ \&quot;srcip\&quot;:\&quot;192.168.2.32\&quot;, \&quot;attack\&quot;:\&quot;Cross Site Scripting Attempt\&quot; }&#39; \\      \&quot;https://console.jumpcloud.com/api/command/trigger/{TriggerName}\&quot; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.CommandTriggersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

CommandTriggersApi apiInstance = new CommandTriggersApi();
String triggername = "triggername_example"; // String | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
try {
    apiInstance.commandTriggerWebhookPost(triggername, contentType, accept);
} catch (ApiException e) {
    System.err.println("Exception when calling CommandTriggersApi#commandTriggerWebhookPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **triggername** | **String**|  |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json; charset=utf-8

