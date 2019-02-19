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


import io.swagger.client.model.Error;
import io.swagger.client.model.PolicyTemplate;
import io.swagger.client.model.PolicyTemplateWithDetails;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PolicytemplatesApi {
    private ApiClient apiClient;

    public PolicytemplatesApi() {
        this(Configuration.getDefaultApiClient());
    }

    public PolicytemplatesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for policytemplatesGet
     * @param id ObjectID of the Policy Template. (required)
     * @param contentType  (required)
     * @param accept  (required)
     * @param xOrgId  (optional, default to )
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call policytemplatesGetCall(String id, String contentType, String accept, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/policytemplates/{id}"
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
    private com.squareup.okhttp.Call policytemplatesGetValidateBeforeCall(String id, String contentType, String accept, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling policytemplatesGet(Async)");
        }
        
        // verify the required parameter 'contentType' is set
        if (contentType == null) {
            throw new ApiException("Missing the required parameter 'contentType' when calling policytemplatesGet(Async)");
        }
        
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new ApiException("Missing the required parameter 'accept' when calling policytemplatesGet(Async)");
        }
        

        com.squareup.okhttp.Call call = policytemplatesGetCall(id, contentType, accept, xOrgId, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get a specific Policy Template
     * This endpoint returns a specific policy template.  #### Sample Request &#x60;&#x60;&#x60;  curl -X GET https://console.jumpcloud.com/api/v2/policies/{Policy_ID}\\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;
     * @param id ObjectID of the Policy Template. (required)
     * @param contentType  (required)
     * @param accept  (required)
     * @param xOrgId  (optional, default to )
     * @return PolicyTemplateWithDetails
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public PolicyTemplateWithDetails policytemplatesGet(String id, String contentType, String accept, String xOrgId) throws ApiException {
        ApiResponse<PolicyTemplateWithDetails> resp = policytemplatesGetWithHttpInfo(id, contentType, accept, xOrgId);
        return resp.getData();
    }

    /**
     * Get a specific Policy Template
     * This endpoint returns a specific policy template.  #### Sample Request &#x60;&#x60;&#x60;  curl -X GET https://console.jumpcloud.com/api/v2/policies/{Policy_ID}\\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;
     * @param id ObjectID of the Policy Template. (required)
     * @param contentType  (required)
     * @param accept  (required)
     * @param xOrgId  (optional, default to )
     * @return ApiResponse&lt;PolicyTemplateWithDetails&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<PolicyTemplateWithDetails> policytemplatesGetWithHttpInfo(String id, String contentType, String accept, String xOrgId) throws ApiException {
        com.squareup.okhttp.Call call = policytemplatesGetValidateBeforeCall(id, contentType, accept, xOrgId, null, null);
        Type localVarReturnType = new TypeToken<PolicyTemplateWithDetails>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get a specific Policy Template (asynchronously)
     * This endpoint returns a specific policy template.  #### Sample Request &#x60;&#x60;&#x60;  curl -X GET https://console.jumpcloud.com/api/v2/policies/{Policy_ID}\\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;
     * @param id ObjectID of the Policy Template. (required)
     * @param contentType  (required)
     * @param accept  (required)
     * @param xOrgId  (optional, default to )
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call policytemplatesGetAsync(String id, String contentType, String accept, String xOrgId, final ApiCallback<PolicyTemplateWithDetails> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = policytemplatesGetValidateBeforeCall(id, contentType, accept, xOrgId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<PolicyTemplateWithDetails>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for policytemplatesList
     * @param contentType  (required)
     * @param accept  (required)
     * @param fields The comma separated fields included in the returned records. If omitted the default list of fields will be returned.  (optional, default to [])
     * @param filter Supported operators are: eq, ne, gt, ge, lt, le, between, search, in (optional, default to [])
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional, default to [])
     * @param xOrgId  (optional, default to )
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call policytemplatesListCall(String contentType, String accept, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/policytemplates";

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
    private com.squareup.okhttp.Call policytemplatesListValidateBeforeCall(String contentType, String accept, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'contentType' is set
        if (contentType == null) {
            throw new ApiException("Missing the required parameter 'contentType' when calling policytemplatesList(Async)");
        }
        
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new ApiException("Missing the required parameter 'accept' when calling policytemplatesList(Async)");
        }
        

        com.squareup.okhttp.Call call = policytemplatesListCall(contentType, accept, fields, filter, limit, skip, sort, xOrgId, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Lists all of the Policy Templates
     * This endpoint returns all policy templates.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/policytemplates \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;   &#x60;&#x60;&#x60;
     * @param contentType  (required)
     * @param accept  (required)
     * @param fields The comma separated fields included in the returned records. If omitted the default list of fields will be returned.  (optional, default to [])
     * @param filter Supported operators are: eq, ne, gt, ge, lt, le, between, search, in (optional, default to [])
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional, default to [])
     * @param xOrgId  (optional, default to )
     * @return List&lt;PolicyTemplate&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<PolicyTemplate> policytemplatesList(String contentType, String accept, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort, String xOrgId) throws ApiException {
        ApiResponse<List<PolicyTemplate>> resp = policytemplatesListWithHttpInfo(contentType, accept, fields, filter, limit, skip, sort, xOrgId);
        return resp.getData();
    }

    /**
     * Lists all of the Policy Templates
     * This endpoint returns all policy templates.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/policytemplates \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;   &#x60;&#x60;&#x60;
     * @param contentType  (required)
     * @param accept  (required)
     * @param fields The comma separated fields included in the returned records. If omitted the default list of fields will be returned.  (optional, default to [])
     * @param filter Supported operators are: eq, ne, gt, ge, lt, le, between, search, in (optional, default to [])
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional, default to [])
     * @param xOrgId  (optional, default to )
     * @return ApiResponse&lt;List&lt;PolicyTemplate&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<PolicyTemplate>> policytemplatesListWithHttpInfo(String contentType, String accept, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort, String xOrgId) throws ApiException {
        com.squareup.okhttp.Call call = policytemplatesListValidateBeforeCall(contentType, accept, fields, filter, limit, skip, sort, xOrgId, null, null);
        Type localVarReturnType = new TypeToken<List<PolicyTemplate>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Lists all of the Policy Templates (asynchronously)
     * This endpoint returns all policy templates.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/policytemplates \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;   &#x60;&#x60;&#x60;
     * @param contentType  (required)
     * @param accept  (required)
     * @param fields The comma separated fields included in the returned records. If omitted the default list of fields will be returned.  (optional, default to [])
     * @param filter Supported operators are: eq, ne, gt, ge, lt, le, between, search, in (optional, default to [])
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional, default to [])
     * @param xOrgId  (optional, default to )
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call policytemplatesListAsync(String contentType, String accept, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort, String xOrgId, final ApiCallback<List<PolicyTemplate>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = policytemplatesListValidateBeforeCall(contentType, accept, fields, filter, limit, skip, sort, xOrgId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<PolicyTemplate>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
