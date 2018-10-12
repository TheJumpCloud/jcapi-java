/*
 * JumpCloud APIs
 *  JumpCloud's V1 API. This set of endpoints allows JumpCloud customers to manage commands, systems, & system users.
 *
 * OpenAPI spec version: 1.0
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


import io.swagger.client.model.Body;
import io.swagger.client.model.Radiusserverpost;
import io.swagger.client.model.Radiusserverput;
import io.swagger.client.model.Radiusserverslist;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RadiusServersApi {
    private ApiClient apiClient;

    public RadiusServersApi() {
        this(Configuration.getDefaultApiClient());
    }

    public RadiusServersApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for radiusServersList
     * @param contentType  (required)
     * @param accept  (required)
     * @param fields Use a space seperated string of field parameters to include the data in the response. If omitted the default list of fields will be returned.  (optional, default to )
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort Use space separated sort parameters to sort the collection. Default sort is ascending. Prefix with &#x60;-&#x60; to sort descending.  (optional, default to )
     * @param xOrgId  (optional, default to )
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call radiusServersListCall(String contentType, String accept, String fields, Integer limit, Integer skip, String sort, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/radiusservers";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (fields != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("fields", fields));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("sort", sort));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (contentType != null)
        localVarHeaderParams.put("Content-Type", apiClient.parameterToString(contentType));
        if (accept != null)
        localVarHeaderParams.put("Accept", apiClient.parameterToString(accept));
        if (xOrgId != null)
        localVarHeaderParams.put("x-org-id", apiClient.parameterToString(xOrgId));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json; charset=utf-8"
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
    private com.squareup.okhttp.Call radiusServersListValidateBeforeCall(String contentType, String accept, String fields, Integer limit, Integer skip, String sort, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'contentType' is set
        if (contentType == null) {
            throw new ApiException("Missing the required parameter 'contentType' when calling radiusServersList(Async)");
        }
        
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new ApiException("Missing the required parameter 'accept' when calling radiusServersList(Async)");
        }
        

        com.squareup.okhttp.Call call = radiusServersListCall(contentType, accept, fields, limit, skip, sort, xOrgId, progressListener, progressRequestListener);
        return call;

    }

    /**
     * List Radius Servers
     * This endpoint allows you to get a list of all RADIUS servers in your organization.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/radiusservers/ \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\ &#x60;&#x60;&#x60;
     * @param contentType  (required)
     * @param accept  (required)
     * @param fields Use a space seperated string of field parameters to include the data in the response. If omitted the default list of fields will be returned.  (optional, default to )
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort Use space separated sort parameters to sort the collection. Default sort is ascending. Prefix with &#x60;-&#x60; to sort descending.  (optional, default to )
     * @param xOrgId  (optional, default to )
     * @return Radiusserverslist
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Radiusserverslist radiusServersList(String contentType, String accept, String fields, Integer limit, Integer skip, String sort, String xOrgId) throws ApiException {
        ApiResponse<Radiusserverslist> resp = radiusServersListWithHttpInfo(contentType, accept, fields, limit, skip, sort, xOrgId);
        return resp.getData();
    }

    /**
     * List Radius Servers
     * This endpoint allows you to get a list of all RADIUS servers in your organization.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/radiusservers/ \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\ &#x60;&#x60;&#x60;
     * @param contentType  (required)
     * @param accept  (required)
     * @param fields Use a space seperated string of field parameters to include the data in the response. If omitted the default list of fields will be returned.  (optional, default to )
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort Use space separated sort parameters to sort the collection. Default sort is ascending. Prefix with &#x60;-&#x60; to sort descending.  (optional, default to )
     * @param xOrgId  (optional, default to )
     * @return ApiResponse&lt;Radiusserverslist&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Radiusserverslist> radiusServersListWithHttpInfo(String contentType, String accept, String fields, Integer limit, Integer skip, String sort, String xOrgId) throws ApiException {
        com.squareup.okhttp.Call call = radiusServersListValidateBeforeCall(contentType, accept, fields, limit, skip, sort, xOrgId, null, null);
        Type localVarReturnType = new TypeToken<Radiusserverslist>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List Radius Servers (asynchronously)
     * This endpoint allows you to get a list of all RADIUS servers in your organization.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/radiusservers/ \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\ &#x60;&#x60;&#x60;
     * @param contentType  (required)
     * @param accept  (required)
     * @param fields Use a space seperated string of field parameters to include the data in the response. If omitted the default list of fields will be returned.  (optional, default to )
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort Use space separated sort parameters to sort the collection. Default sort is ascending. Prefix with &#x60;-&#x60; to sort descending.  (optional, default to )
     * @param xOrgId  (optional, default to )
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call radiusServersListAsync(String contentType, String accept, String fields, Integer limit, Integer skip, String sort, String xOrgId, final ApiCallback<Radiusserverslist> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = radiusServersListValidateBeforeCall(contentType, accept, fields, limit, skip, sort, xOrgId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Radiusserverslist>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for radiusServersPost
     * @param contentType  (required)
     * @param accept  (required)
     * @param body  (optional)
     * @param xOrgId  (optional, default to )
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call radiusServersPostCall(String contentType, String accept, Radiusserverpost body, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath = "/radiusservers";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (contentType != null)
        localVarHeaderParams.put("Content-Type", apiClient.parameterToString(contentType));
        if (accept != null)
        localVarHeaderParams.put("Accept", apiClient.parameterToString(accept));
        if (xOrgId != null)
        localVarHeaderParams.put("x-org-id", apiClient.parameterToString(xOrgId));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json; charset=utf-8"
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
    private com.squareup.okhttp.Call radiusServersPostValidateBeforeCall(String contentType, String accept, Radiusserverpost body, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'contentType' is set
        if (contentType == null) {
            throw new ApiException("Missing the required parameter 'contentType' when calling radiusServersPost(Async)");
        }
        
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new ApiException("Missing the required parameter 'accept' when calling radiusServersPost(Async)");
        }
        

        com.squareup.okhttp.Call call = radiusServersPostCall(contentType, accept, body, xOrgId, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Create a Radius Server
     * This endpoint allows you to create RADIUS servers in your organization.  #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/radiusservers/ \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{     \&quot;name\&quot;: \&quot;{test_radius}\&quot;,     \&quot;networkSourceIp\&quot;: \&quot;{0.0.0.0}\&quot;,     \&quot;sharedSecret\&quot;:\&quot;{secretpassword}\&quot; }&#39; &#x60;&#x60;&#x60;
     * @param contentType  (required)
     * @param accept  (required)
     * @param body  (optional)
     * @param xOrgId  (optional, default to )
     * @return Radiusserverslist
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Radiusserverslist radiusServersPost(String contentType, String accept, Radiusserverpost body, String xOrgId) throws ApiException {
        ApiResponse<Radiusserverslist> resp = radiusServersPostWithHttpInfo(contentType, accept, body, xOrgId);
        return resp.getData();
    }

    /**
     * Create a Radius Server
     * This endpoint allows you to create RADIUS servers in your organization.  #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/radiusservers/ \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{     \&quot;name\&quot;: \&quot;{test_radius}\&quot;,     \&quot;networkSourceIp\&quot;: \&quot;{0.0.0.0}\&quot;,     \&quot;sharedSecret\&quot;:\&quot;{secretpassword}\&quot; }&#39; &#x60;&#x60;&#x60;
     * @param contentType  (required)
     * @param accept  (required)
     * @param body  (optional)
     * @param xOrgId  (optional, default to )
     * @return ApiResponse&lt;Radiusserverslist&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Radiusserverslist> radiusServersPostWithHttpInfo(String contentType, String accept, Radiusserverpost body, String xOrgId) throws ApiException {
        com.squareup.okhttp.Call call = radiusServersPostValidateBeforeCall(contentType, accept, body, xOrgId, null, null);
        Type localVarReturnType = new TypeToken<Radiusserverslist>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Create a Radius Server (asynchronously)
     * This endpoint allows you to create RADIUS servers in your organization.  #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/radiusservers/ \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{     \&quot;name\&quot;: \&quot;{test_radius}\&quot;,     \&quot;networkSourceIp\&quot;: \&quot;{0.0.0.0}\&quot;,     \&quot;sharedSecret\&quot;:\&quot;{secretpassword}\&quot; }&#39; &#x60;&#x60;&#x60;
     * @param contentType  (required)
     * @param accept  (required)
     * @param body  (optional)
     * @param xOrgId  (optional, default to )
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call radiusServersPostAsync(String contentType, String accept, Radiusserverpost body, String xOrgId, final ApiCallback<Radiusserverslist> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = radiusServersPostValidateBeforeCall(contentType, accept, body, xOrgId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Radiusserverslist>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for radiusServersPut
     * @param contentType  (required)
     * @param accept  (required)
     * @param body  (optional)
     * @param xOrgId  (optional, default to )
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call radiusServersPutCall(String contentType, String accept, Body body, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath = "/radiusservers:id";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (contentType != null)
        localVarHeaderParams.put("Content-Type", apiClient.parameterToString(contentType));
        if (accept != null)
        localVarHeaderParams.put("Accept", apiClient.parameterToString(accept));
        if (xOrgId != null)
        localVarHeaderParams.put("x-org-id", apiClient.parameterToString(xOrgId));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json; charset=utf-8"
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
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call radiusServersPutValidateBeforeCall(String contentType, String accept, Body body, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'contentType' is set
        if (contentType == null) {
            throw new ApiException("Missing the required parameter 'contentType' when calling radiusServersPut(Async)");
        }
        
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new ApiException("Missing the required parameter 'accept' when calling radiusServersPut(Async)");
        }
        

        com.squareup.okhttp.Call call = radiusServersPutCall(contentType, accept, body, xOrgId, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Update Radius Servers
     * This endpoint allows you to update RADIUS servers in your organization.  ####  &#x60;&#x60;&#x60; curl -X PUT https://console.jumpcloud.com/api/radiusservers/{ServerID} \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{     \&quot;name\&quot;: \&quot;{name_update}\&quot;,     \&quot;networkSourceIp\&quot;: \&quot;{0.0.0.0}\&quot; }&#39; &#x60;&#x60;&#x60;
     * @param contentType  (required)
     * @param accept  (required)
     * @param body  (optional)
     * @param xOrgId  (optional, default to )
     * @return Radiusserverput
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Radiusserverput radiusServersPut(String contentType, String accept, Body body, String xOrgId) throws ApiException {
        ApiResponse<Radiusserverput> resp = radiusServersPutWithHttpInfo(contentType, accept, body, xOrgId);
        return resp.getData();
    }

    /**
     * Update Radius Servers
     * This endpoint allows you to update RADIUS servers in your organization.  ####  &#x60;&#x60;&#x60; curl -X PUT https://console.jumpcloud.com/api/radiusservers/{ServerID} \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{     \&quot;name\&quot;: \&quot;{name_update}\&quot;,     \&quot;networkSourceIp\&quot;: \&quot;{0.0.0.0}\&quot; }&#39; &#x60;&#x60;&#x60;
     * @param contentType  (required)
     * @param accept  (required)
     * @param body  (optional)
     * @param xOrgId  (optional, default to )
     * @return ApiResponse&lt;Radiusserverput&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Radiusserverput> radiusServersPutWithHttpInfo(String contentType, String accept, Body body, String xOrgId) throws ApiException {
        com.squareup.okhttp.Call call = radiusServersPutValidateBeforeCall(contentType, accept, body, xOrgId, null, null);
        Type localVarReturnType = new TypeToken<Radiusserverput>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Update Radius Servers (asynchronously)
     * This endpoint allows you to update RADIUS servers in your organization.  ####  &#x60;&#x60;&#x60; curl -X PUT https://console.jumpcloud.com/api/radiusservers/{ServerID} \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{     \&quot;name\&quot;: \&quot;{name_update}\&quot;,     \&quot;networkSourceIp\&quot;: \&quot;{0.0.0.0}\&quot; }&#39; &#x60;&#x60;&#x60;
     * @param contentType  (required)
     * @param accept  (required)
     * @param body  (optional)
     * @param xOrgId  (optional, default to )
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call radiusServersPutAsync(String contentType, String accept, Body body, String xOrgId, final ApiCallback<Radiusserverput> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = radiusServersPutValidateBeforeCall(contentType, accept, body, xOrgId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Radiusserverput>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
