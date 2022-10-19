# CommandTriggersApi

All URIs are relative to *https://console.jumpcloud.com/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**commandTriggerWebhookPost**](CommandTriggersApi.md#commandTriggerWebhookPost) | **POST** /command/trigger/{triggername} | Launch a command via a Trigger

<a name="commandTriggerWebhookPost"></a>
# **commandTriggerWebhookPost**
> Triggerreturn commandTriggerWebhookPost(triggername, body, xOrgId)

Launch a command via a Trigger

This endpoint allows you to launch a command based on a defined trigger.  #### Sample Requests  **Launch a Command via a Trigger**  &#x60;&#x60;&#x60; curl --silent \\      -X &#x27;POST&#x27; \\      -H \&quot;x-api-key: {API_KEY}\&quot; \\      \&quot;https://console.jumpcloud.com/api/command/trigger/{TriggerName}\&quot; &#x60;&#x60;&#x60; **Launch a Command via a Trigger passing a JSON object to the command** &#x60;&#x60;&#x60; curl --silent \\      -X &#x27;POST&#x27; \\      -H \&quot;x-api-key: {API_KEY}\&quot; \\      -H &#x27;Accept: application/json&#x27; \\      -H &#x27;Content-Type: application/json&#x27; \\      -d &#x27;{ \&quot;srcip\&quot;:\&quot;192.168.2.32\&quot;, \&quot;attack\&quot;:\&quot;Cross Site Scripting Attempt\&quot; }&#x27; \\      \&quot;https://console.jumpcloud.com/api/command/trigger/{TriggerName}\&quot; &#x60;&#x60;&#x60;

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
Object body = null; // Object | 
String xOrgId = "xOrgId_example"; // String | 
try {
    Triggerreturn result = apiInstance.commandTriggerWebhookPost(triggername, body, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CommandTriggersApi#commandTriggerWebhookPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **triggername** | **String**|  |
 **body** | [**Object**](Object.md)|  | [optional]
 **xOrgId** | **String**|  | [optional]

### Return type

[**Triggerreturn**](Triggerreturn.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

