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


import io.swagger.client.model.Directory;
import io.swagger.client.model.Error;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DirectoriesApi {
    private ApiClient apiClient;

    public DirectoriesApi() {
        this(Configuration.getDefaultApiClient());
    }

    public DirectoriesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for directoriesList
     * @param contentType  (required)
     * @param accept  (required)
     * @param fields The comma separated fields included in the returned records. If omitted the default list of fields will be returned.  (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param xOrgId  (optional, default to <<your org id>>)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call directoriesListCall(String contentType, String accept, List<String> fields, Integer limit, List<String> sort, Integer skip, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/directories";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (fields != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "fields", fields));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));

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
    private com.squareup.okhttp.Call directoriesListValidateBeforeCall(String contentType, String accept, List<String> fields, Integer limit, List<String> sort, Integer skip, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'contentType' is set
        if (contentType == null) {
            throw new ApiException("Missing the required parameter 'contentType' when calling directoriesList(Async)");
        }
        
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new ApiException("Missing the required parameter 'accept' when calling directoriesList(Async)");
        }
        

        com.squareup.okhttp.Call call = directoriesListCall(contentType, accept, fields, limit, sort, skip, xOrgId, progressListener, progressRequestListener);
        return call;

    }

    /**
     * List All Directories
     * This endpoint returns all active directories (LDAP, O365 Suite, G-Suite).  #### Sample Request &#x60;&#x60;&#x60;  curl -X GET https://console.jumpcloud.com/api/v2/directories \\   -H &#39;accept: application/json&#39; \\   -H &#39;content-type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;
     * @param contentType  (required)
     * @param accept  (required)
     * @param fields The comma separated fields included in the returned records. If omitted the default list of fields will be returned.  (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param xOrgId  (optional, default to <<your org id>>)
     * @return List&lt;Directory&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<Directory> directoriesList(String contentType, String accept, List<String> fields, Integer limit, List<String> sort, Integer skip, String xOrgId) throws ApiException {
        ApiResponse<List<Directory>> resp = directoriesListWithHttpInfo(contentType, accept, fields, limit, sort, skip, xOrgId);
        return resp.getData();
    }

    /**
     * List All Directories
     * This endpoint returns all active directories (LDAP, O365 Suite, G-Suite).  #### Sample Request &#x60;&#x60;&#x60;  curl -X GET https://console.jumpcloud.com/api/v2/directories \\   -H &#39;accept: application/json&#39; \\   -H &#39;content-type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;
     * @param contentType  (required)
     * @param accept  (required)
     * @param fields The comma separated fields included in the returned records. If omitted the default list of fields will be returned.  (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param xOrgId  (optional, default to <<your org id>>)
     * @return ApiResponse&lt;List&lt;Directory&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<Directory>> directoriesListWithHttpInfo(String contentType, String accept, List<String> fields, Integer limit, List<String> sort, Integer skip, String xOrgId) throws ApiException {
        com.squareup.okhttp.Call call = directoriesListValidateBeforeCall(contentType, accept, fields, limit, sort, skip, xOrgId, null, null);
        Type localVarReturnType = new TypeToken<List<Directory>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List All Directories (asynchronously)
     * This endpoint returns all active directories (LDAP, O365 Suite, G-Suite).  #### Sample Request &#x60;&#x60;&#x60;  curl -X GET https://console.jumpcloud.com/api/v2/directories \\   -H &#39;accept: application/json&#39; \\   -H &#39;content-type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;
     * @param contentType  (required)
     * @param accept  (required)
     * @param fields The comma separated fields included in the returned records. If omitted the default list of fields will be returned.  (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param xOrgId  (optional, default to <<your org id>>)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call directoriesListAsync(String contentType, String accept, List<String> fields, Integer limit, List<String> sort, Integer skip, String xOrgId, final ApiCallback<List<Directory>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = directoriesListValidateBeforeCall(contentType, accept, fields, limit, sort, skip, xOrgId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<Directory>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
