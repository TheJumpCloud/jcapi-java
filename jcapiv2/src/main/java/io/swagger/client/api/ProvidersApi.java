/*
 * JumpCloud APIs
 *  JumpCloud's V2 API. This set of endpoints allows JumpCloud customers to manage objects, groupings and mappings and interact with the JumpCloud Graph.
 *
 * OpenAPI spec version: 2.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.api;

import io.swagger.client.ApiCallback;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.ApiResponse;
import io.swagger.client.Configuration;
import io.swagger.client.Pair;
import io.swagger.client.ProgressRequestBody;
import io.swagger.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import io.swagger.client.model.Administrator;
import io.swagger.client.model.InlineResponse2001;
import io.swagger.client.model.InlineResponse400;
import io.swagger.client.model.ProviderAdminReq;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProvidersApi {
    private ApiClient apiClient;

    public ProvidersApi() {
        this(Configuration.getDefaultApiClient());
    }

    public ProvidersApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for providersListAdministrators
     * @param providerId  (required)
     * @param contentType  (required)
     * @param accept  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter Supported operators are: eq, ne, gt, ge, lt, le, between, search, in (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call providersListAdministratorsCall(String providerId, String contentType, String accept, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/providers/{provider_id}/administrators"
            .replaceAll("\\{" + "provider_id" + "\\}", apiClient.escapeString(providerId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (fields != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "fields", fields));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (contentType != null)
        localVarHeaderParams.put("Content-Type", apiClient.parameterToString(contentType));
        if (accept != null)
        localVarHeaderParams.put("Accept", apiClient.parameterToString(accept));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "x-api-key" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call providersListAdministratorsValidateBeforeCall(String providerId, String contentType, String accept, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'providerId' is set
        if (providerId == null) {
            throw new ApiException("Missing the required parameter 'providerId' when calling providersListAdministrators(Async)");
        }
        
        // verify the required parameter 'contentType' is set
        if (contentType == null) {
            throw new ApiException("Missing the required parameter 'contentType' when calling providersListAdministrators(Async)");
        }
        
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new ApiException("Missing the required parameter 'accept' when calling providersListAdministrators(Async)");
        }
        

        com.squareup.okhttp.Call call = providersListAdministratorsCall(providerId, contentType, accept, fields, filter, limit, skip, sort, progressListener, progressRequestListener);
        return call;

    }

    /**
     * List Provider Administrators
     * This endpoint returns a list of the Administrators associated with the Provider.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/providers/{ProviderID}/administrators \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;
     * @param providerId  (required)
     * @param contentType  (required)
     * @param accept  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter Supported operators are: eq, ne, gt, ge, lt, le, between, search, in (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @return InlineResponse2001
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public InlineResponse2001 providersListAdministrators(String providerId, String contentType, String accept, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort) throws ApiException {
        ApiResponse<InlineResponse2001> resp = providersListAdministratorsWithHttpInfo(providerId, contentType, accept, fields, filter, limit, skip, sort);
        return resp.getData();
    }

    /**
     * List Provider Administrators
     * This endpoint returns a list of the Administrators associated with the Provider.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/providers/{ProviderID}/administrators \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;
     * @param providerId  (required)
     * @param contentType  (required)
     * @param accept  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter Supported operators are: eq, ne, gt, ge, lt, le, between, search, in (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @return ApiResponse&lt;InlineResponse2001&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<InlineResponse2001> providersListAdministratorsWithHttpInfo(String providerId, String contentType, String accept, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort) throws ApiException {
        com.squareup.okhttp.Call call = providersListAdministratorsValidateBeforeCall(providerId, contentType, accept, fields, filter, limit, skip, sort, null, null);
        Type localVarReturnType = new TypeToken<InlineResponse2001>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List Provider Administrators (asynchronously)
     * This endpoint returns a list of the Administrators associated with the Provider.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/providers/{ProviderID}/administrators \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;
     * @param providerId  (required)
     * @param contentType  (required)
     * @param accept  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter Supported operators are: eq, ne, gt, ge, lt, le, between, search, in (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call providersListAdministratorsAsync(String providerId, String contentType, String accept, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort, final ApiCallback<InlineResponse2001> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = providersListAdministratorsValidateBeforeCall(providerId, contentType, accept, fields, filter, limit, skip, sort, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<InlineResponse2001>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for providersPostAdmins
     * @param providerId  (required)
     * @param contentType  (required)
     * @param accept  (required)
     * @param body  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call providersPostAdminsCall(String providerId, String contentType, String accept, ProviderAdminReq body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath = "/providers/{provider_id}/administrators"
            .replaceAll("\\{" + "provider_id" + "\\}", apiClient.escapeString(providerId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (contentType != null)
        localVarHeaderParams.put("Content-Type", apiClient.parameterToString(contentType));
        if (accept != null)
        localVarHeaderParams.put("Accept", apiClient.parameterToString(accept));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "x-api-key" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call providersPostAdminsValidateBeforeCall(String providerId, String contentType, String accept, ProviderAdminReq body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'providerId' is set
        if (providerId == null) {
            throw new ApiException("Missing the required parameter 'providerId' when calling providersPostAdmins(Async)");
        }
        
        // verify the required parameter 'contentType' is set
        if (contentType == null) {
            throw new ApiException("Missing the required parameter 'contentType' when calling providersPostAdmins(Async)");
        }
        
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new ApiException("Missing the required parameter 'accept' when calling providersPostAdmins(Async)");
        }
        

        com.squareup.okhttp.Call call = providersPostAdminsCall(providerId, contentType, accept, body, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Create a new Provider Administrator
     * This endpoint allows you to create a provider administrator. You must be associated to the provider to use this route.  **Sample Request**  &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/providers/{ProviderID}/administrators \\     -H &#39;Accept: application/json&#39; \\     -H &#39;Context-Type: application/json&#39; \\     -H &#39;x-api-key: {API_KEY}&#39; \\     -d &#39;{       \&quot;email\&quot;:\&quot;{ADMIN_EMAIL}\&quot;     }&#39; &#x60;&#x60;&#x60;
     * @param providerId  (required)
     * @param contentType  (required)
     * @param accept  (required)
     * @param body  (optional)
     * @return Administrator
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Administrator providersPostAdmins(String providerId, String contentType, String accept, ProviderAdminReq body) throws ApiException {
        ApiResponse<Administrator> resp = providersPostAdminsWithHttpInfo(providerId, contentType, accept, body);
        return resp.getData();
    }

    /**
     * Create a new Provider Administrator
     * This endpoint allows you to create a provider administrator. You must be associated to the provider to use this route.  **Sample Request**  &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/providers/{ProviderID}/administrators \\     -H &#39;Accept: application/json&#39; \\     -H &#39;Context-Type: application/json&#39; \\     -H &#39;x-api-key: {API_KEY}&#39; \\     -d &#39;{       \&quot;email\&quot;:\&quot;{ADMIN_EMAIL}\&quot;     }&#39; &#x60;&#x60;&#x60;
     * @param providerId  (required)
     * @param contentType  (required)
     * @param accept  (required)
     * @param body  (optional)
     * @return ApiResponse&lt;Administrator&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Administrator> providersPostAdminsWithHttpInfo(String providerId, String contentType, String accept, ProviderAdminReq body) throws ApiException {
        com.squareup.okhttp.Call call = providersPostAdminsValidateBeforeCall(providerId, contentType, accept, body, null, null);
        Type localVarReturnType = new TypeToken<Administrator>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Create a new Provider Administrator (asynchronously)
     * This endpoint allows you to create a provider administrator. You must be associated to the provider to use this route.  **Sample Request**  &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/providers/{ProviderID}/administrators \\     -H &#39;Accept: application/json&#39; \\     -H &#39;Context-Type: application/json&#39; \\     -H &#39;x-api-key: {API_KEY}&#39; \\     -d &#39;{       \&quot;email\&quot;:\&quot;{ADMIN_EMAIL}\&quot;     }&#39; &#x60;&#x60;&#x60;
     * @param providerId  (required)
     * @param contentType  (required)
     * @param accept  (required)
     * @param body  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call providersPostAdminsAsync(String providerId, String contentType, String accept, ProviderAdminReq body, final ApiCallback<Administrator> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = providersPostAdminsValidateBeforeCall(providerId, contentType, accept, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Administrator>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
