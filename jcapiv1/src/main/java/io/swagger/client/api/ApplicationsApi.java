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


import io.swagger.client.model.Application;
import io.swagger.client.model.Applicationslist;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApplicationsApi {
    private ApiClient apiClient;

    public ApplicationsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public ApplicationsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for applicationsDelete
     * @param id  (required)
     * @param contentType  (optional)
     * @param accept  (optional)
     * @param xOrgId  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call applicationsDeleteCall(String id, String contentType, String accept, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/applications/{id}"
            .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

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
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call applicationsDeleteValidateBeforeCall(String id, String contentType, String accept, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling applicationsDelete(Async)");
        }
        

        com.squareup.okhttp.Call call = applicationsDeleteCall(id, contentType, accept, xOrgId, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Delete an Application
     * The endpoint deletes an SSO / SAML Application.
     * @param id  (required)
     * @param contentType  (optional)
     * @param accept  (optional)
     * @param xOrgId  (optional)
     * @return Application
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Application applicationsDelete(String id, String contentType, String accept, String xOrgId) throws ApiException {
        ApiResponse<Application> resp = applicationsDeleteWithHttpInfo(id, contentType, accept, xOrgId);
        return resp.getData();
    }

    /**
     * Delete an Application
     * The endpoint deletes an SSO / SAML Application.
     * @param id  (required)
     * @param contentType  (optional)
     * @param accept  (optional)
     * @param xOrgId  (optional)
     * @return ApiResponse&lt;Application&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Application> applicationsDeleteWithHttpInfo(String id, String contentType, String accept, String xOrgId) throws ApiException {
        com.squareup.okhttp.Call call = applicationsDeleteValidateBeforeCall(id, contentType, accept, xOrgId, null, null);
        Type localVarReturnType = new TypeToken<Application>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Delete an Application (asynchronously)
     * The endpoint deletes an SSO / SAML Application.
     * @param id  (required)
     * @param contentType  (optional)
     * @param accept  (optional)
     * @param xOrgId  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call applicationsDeleteAsync(String id, String contentType, String accept, String xOrgId, final ApiCallback<Application> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = applicationsDeleteValidateBeforeCall(id, contentType, accept, xOrgId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Application>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for applicationsGet
     * @param id  (required)
     * @param contentType  (optional)
     * @param accept  (optional)
     * @param xOrgId  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call applicationsGetCall(String id, String contentType, String accept, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/applications/{id}"
            .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

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
    private com.squareup.okhttp.Call applicationsGetValidateBeforeCall(String id, String contentType, String accept, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling applicationsGet(Async)");
        }
        

        com.squareup.okhttp.Call call = applicationsGetCall(id, contentType, accept, xOrgId, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get an Application
     * The endpoint retrieves an SSO / SAML Application.
     * @param id  (required)
     * @param contentType  (optional)
     * @param accept  (optional)
     * @param xOrgId  (optional)
     * @return Application
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Application applicationsGet(String id, String contentType, String accept, String xOrgId) throws ApiException {
        ApiResponse<Application> resp = applicationsGetWithHttpInfo(id, contentType, accept, xOrgId);
        return resp.getData();
    }

    /**
     * Get an Application
     * The endpoint retrieves an SSO / SAML Application.
     * @param id  (required)
     * @param contentType  (optional)
     * @param accept  (optional)
     * @param xOrgId  (optional)
     * @return ApiResponse&lt;Application&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Application> applicationsGetWithHttpInfo(String id, String contentType, String accept, String xOrgId) throws ApiException {
        com.squareup.okhttp.Call call = applicationsGetValidateBeforeCall(id, contentType, accept, xOrgId, null, null);
        Type localVarReturnType = new TypeToken<Application>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get an Application (asynchronously)
     * The endpoint retrieves an SSO / SAML Application.
     * @param id  (required)
     * @param contentType  (optional)
     * @param accept  (optional)
     * @param xOrgId  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call applicationsGetAsync(String id, String contentType, String accept, String xOrgId, final ApiCallback<Application> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = applicationsGetValidateBeforeCall(id, contentType, accept, xOrgId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Application>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for applicationsList
     * @param contentType  (required)
     * @param accept  (required)
     * @param fields The comma separated fields included in the returned records. If omitted the default list of fields will be returned. (optional)
     * @param limit The number of records to return at once. (optional)
     * @param skip The offset into the records to return. (optional)
     * @param sort  (optional, default to The comma separated fields used to sort the collection. Default sort is ascending, prefix with - to sort descending.)
     * @param filter A filter to apply to the query. (optional)
     * @param xOrgId  (optional, default to )
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call applicationsListCall(String contentType, String accept, String fields, Integer limit, Integer skip, String sort, String filter, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/applications";

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
        if (filter != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("filter", filter));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (contentType != null)
        localVarHeaderParams.put("Content-Type", apiClient.parameterToString(contentType));
        if (accept != null)
        localVarHeaderParams.put("Accept", apiClient.parameterToString(accept));
        if (xOrgId != null)
        localVarHeaderParams.put("x-org-id", apiClient.parameterToString(xOrgId));

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
    private com.squareup.okhttp.Call applicationsListValidateBeforeCall(String contentType, String accept, String fields, Integer limit, Integer skip, String sort, String filter, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'contentType' is set
        if (contentType == null) {
            throw new ApiException("Missing the required parameter 'contentType' when calling applicationsList(Async)");
        }
        
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new ApiException("Missing the required parameter 'accept' when calling applicationsList(Async)");
        }
        

        com.squareup.okhttp.Call call = applicationsListCall(contentType, accept, fields, limit, skip, sort, filter, xOrgId, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Applications
     * The endpoint returns all your SSO / SAML Applications.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/applications \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;   &#x60;&#x60;&#x60;
     * @param contentType  (required)
     * @param accept  (required)
     * @param fields The comma separated fields included in the returned records. If omitted the default list of fields will be returned. (optional)
     * @param limit The number of records to return at once. (optional)
     * @param skip The offset into the records to return. (optional)
     * @param sort  (optional, default to The comma separated fields used to sort the collection. Default sort is ascending, prefix with - to sort descending.)
     * @param filter A filter to apply to the query. (optional)
     * @param xOrgId  (optional, default to )
     * @return Applicationslist
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Applicationslist applicationsList(String contentType, String accept, String fields, Integer limit, Integer skip, String sort, String filter, String xOrgId) throws ApiException {
        ApiResponse<Applicationslist> resp = applicationsListWithHttpInfo(contentType, accept, fields, limit, skip, sort, filter, xOrgId);
        return resp.getData();
    }

    /**
     * Applications
     * The endpoint returns all your SSO / SAML Applications.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/applications \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;   &#x60;&#x60;&#x60;
     * @param contentType  (required)
     * @param accept  (required)
     * @param fields The comma separated fields included in the returned records. If omitted the default list of fields will be returned. (optional)
     * @param limit The number of records to return at once. (optional)
     * @param skip The offset into the records to return. (optional)
     * @param sort  (optional, default to The comma separated fields used to sort the collection. Default sort is ascending, prefix with - to sort descending.)
     * @param filter A filter to apply to the query. (optional)
     * @param xOrgId  (optional, default to )
     * @return ApiResponse&lt;Applicationslist&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Applicationslist> applicationsListWithHttpInfo(String contentType, String accept, String fields, Integer limit, Integer skip, String sort, String filter, String xOrgId) throws ApiException {
        com.squareup.okhttp.Call call = applicationsListValidateBeforeCall(contentType, accept, fields, limit, skip, sort, filter, xOrgId, null, null);
        Type localVarReturnType = new TypeToken<Applicationslist>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Applications (asynchronously)
     * The endpoint returns all your SSO / SAML Applications.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/applications \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;   &#x60;&#x60;&#x60;
     * @param contentType  (required)
     * @param accept  (required)
     * @param fields The comma separated fields included in the returned records. If omitted the default list of fields will be returned. (optional)
     * @param limit The number of records to return at once. (optional)
     * @param skip The offset into the records to return. (optional)
     * @param sort  (optional, default to The comma separated fields used to sort the collection. Default sort is ascending, prefix with - to sort descending.)
     * @param filter A filter to apply to the query. (optional)
     * @param xOrgId  (optional, default to )
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call applicationsListAsync(String contentType, String accept, String fields, Integer limit, Integer skip, String sort, String filter, String xOrgId, final ApiCallback<Applicationslist> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = applicationsListValidateBeforeCall(contentType, accept, fields, limit, skip, sort, filter, xOrgId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Applicationslist>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for applicationsPost
     * @param body  (optional)
     * @param contentType  (optional)
     * @param accept  (optional)
     * @param xOrgId  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call applicationsPostCall(Application body, String contentType, String accept, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath = "/applications";

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
    private com.squareup.okhttp.Call applicationsPostValidateBeforeCall(Application body, String contentType, String accept, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        

        com.squareup.okhttp.Call call = applicationsPostCall(body, contentType, accept, xOrgId, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Create an Application
     * The endpoint adds a new SSO / SAML Applications.
     * @param body  (optional)
     * @param contentType  (optional)
     * @param accept  (optional)
     * @param xOrgId  (optional)
     * @return Application
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Application applicationsPost(Application body, String contentType, String accept, String xOrgId) throws ApiException {
        ApiResponse<Application> resp = applicationsPostWithHttpInfo(body, contentType, accept, xOrgId);
        return resp.getData();
    }

    /**
     * Create an Application
     * The endpoint adds a new SSO / SAML Applications.
     * @param body  (optional)
     * @param contentType  (optional)
     * @param accept  (optional)
     * @param xOrgId  (optional)
     * @return ApiResponse&lt;Application&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Application> applicationsPostWithHttpInfo(Application body, String contentType, String accept, String xOrgId) throws ApiException {
        com.squareup.okhttp.Call call = applicationsPostValidateBeforeCall(body, contentType, accept, xOrgId, null, null);
        Type localVarReturnType = new TypeToken<Application>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Create an Application (asynchronously)
     * The endpoint adds a new SSO / SAML Applications.
     * @param body  (optional)
     * @param contentType  (optional)
     * @param accept  (optional)
     * @param xOrgId  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call applicationsPostAsync(Application body, String contentType, String accept, String xOrgId, final ApiCallback<Application> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = applicationsPostValidateBeforeCall(body, contentType, accept, xOrgId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Application>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for applicationsPut
     * @param id  (required)
     * @param body  (optional)
     * @param contentType  (optional)
     * @param accept  (optional)
     * @param xOrgId  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call applicationsPutCall(String id, Application body, String contentType, String accept, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath = "/applications/{id}"
            .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

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
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call applicationsPutValidateBeforeCall(String id, Application body, String contentType, String accept, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling applicationsPut(Async)");
        }
        

        com.squareup.okhttp.Call call = applicationsPutCall(id, body, contentType, accept, xOrgId, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Update an Application
     * The endpoint updates a SSO / SAML Application.
     * @param id  (required)
     * @param body  (optional)
     * @param contentType  (optional)
     * @param accept  (optional)
     * @param xOrgId  (optional)
     * @return Application
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Application applicationsPut(String id, Application body, String contentType, String accept, String xOrgId) throws ApiException {
        ApiResponse<Application> resp = applicationsPutWithHttpInfo(id, body, contentType, accept, xOrgId);
        return resp.getData();
    }

    /**
     * Update an Application
     * The endpoint updates a SSO / SAML Application.
     * @param id  (required)
     * @param body  (optional)
     * @param contentType  (optional)
     * @param accept  (optional)
     * @param xOrgId  (optional)
     * @return ApiResponse&lt;Application&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Application> applicationsPutWithHttpInfo(String id, Application body, String contentType, String accept, String xOrgId) throws ApiException {
        com.squareup.okhttp.Call call = applicationsPutValidateBeforeCall(id, body, contentType, accept, xOrgId, null, null);
        Type localVarReturnType = new TypeToken<Application>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Update an Application (asynchronously)
     * The endpoint updates a SSO / SAML Application.
     * @param id  (required)
     * @param body  (optional)
     * @param contentType  (optional)
     * @param accept  (optional)
     * @param xOrgId  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call applicationsPutAsync(String id, Application body, String contentType, String accept, String xOrgId, final ApiCallback<Application> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = applicationsPutValidateBeforeCall(id, body, contentType, accept, xOrgId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Application>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
