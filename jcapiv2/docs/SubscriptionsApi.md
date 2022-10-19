# SubscriptionsApi

All URIs are relative to *https://console.jumpcloud.com/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**subscriptionsGet**](SubscriptionsApi.md#subscriptionsGet) | **GET** /subscriptions | Lists all the Pricing &amp; Packaging Subscriptions

<a name="subscriptionsGet"></a>
# **subscriptionsGet**
> List&lt;Subscription&gt; subscriptionsGet()

Lists all the Pricing &amp; Packaging Subscriptions

This endpoint returns all pricing &amp; packaging subscriptions.  ##### Sample Request  &#x60;&#x60;&#x60;  curl -X GET  https://console.jumpcloud.com/api/v2/subscriptions \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27;   &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SubscriptionsApi;


SubscriptionsApi apiInstance = new SubscriptionsApi();
try {
    List<Subscription> result = apiInstance.subscriptionsGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SubscriptionsApi#subscriptionsGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;Subscription&gt;**](Subscription.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

