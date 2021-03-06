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


import io.swagger.client.model.Organizationslist;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrganizationsApi {
    private ApiClient apiClient;

    public OrganizationsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public OrganizationsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for organizationList
     * @param contentType  (required)
     * @param accept  (required)
     * @param fields Use a space seperated string of field parameters to include the data in the response. If omitted, the default list of fields will be returned.  (optional, default to )
     * @param filter A filter to apply to the query. (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort Use space separated sort parameters to sort the collection. Default sort is ascending. Prefix with &#x60;-&#x60; to sort descending.  (optional, default to )
     * @param search A nested object containing a string &#x60;searchTerm&#x60; and a list of &#x60;fields&#x60; to search on. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call organizationListCall(String contentType, String accept, String fields, String filter, Integer limit, Integer skip, String sort, String search, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/organizations";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (fields != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("fields", fields));
        if (filter != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("sort", sort));
        if (search != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("search", search));

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
    private com.squareup.okhttp.Call organizationListValidateBeforeCall(String contentType, String accept, String fields, String filter, Integer limit, Integer skip, String sort, String search, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'contentType' is set
        if (contentType == null) {
            throw new ApiException("Missing the required parameter 'contentType' when calling organizationList(Async)");
        }
        
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new ApiException("Missing the required parameter 'accept' when calling organizationList(Async)");
        }
        

        com.squareup.okhttp.Call call = organizationListCall(contentType, accept, fields, filter, limit, skip, sort, search, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get Organization Details
     * This endpoint returns Organization Details.  #### Sample Request  &#x60;&#x60;&#x60; curl -X GET \\   https://console.jumpcloud.com/api/organizations \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;   &#x60;&#x60;&#x60;
     * @param contentType  (required)
     * @param accept  (required)
     * @param fields Use a space seperated string of field parameters to include the data in the response. If omitted, the default list of fields will be returned.  (optional, default to )
     * @param filter A filter to apply to the query. (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort Use space separated sort parameters to sort the collection. Default sort is ascending. Prefix with &#x60;-&#x60; to sort descending.  (optional, default to )
     * @param search A nested object containing a string &#x60;searchTerm&#x60; and a list of &#x60;fields&#x60; to search on. (optional)
     * @return Organizationslist
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Organizationslist organizationList(String contentType, String accept, String fields, String filter, Integer limit, Integer skip, String sort, String search) throws ApiException {
        ApiResponse<Organizationslist> resp = organizationListWithHttpInfo(contentType, accept, fields, filter, limit, skip, sort, search);
        return resp.getData();
    }

    /**
     * Get Organization Details
     * This endpoint returns Organization Details.  #### Sample Request  &#x60;&#x60;&#x60; curl -X GET \\   https://console.jumpcloud.com/api/organizations \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;   &#x60;&#x60;&#x60;
     * @param contentType  (required)
     * @param accept  (required)
     * @param fields Use a space seperated string of field parameters to include the data in the response. If omitted, the default list of fields will be returned.  (optional, default to )
     * @param filter A filter to apply to the query. (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort Use space separated sort parameters to sort the collection. Default sort is ascending. Prefix with &#x60;-&#x60; to sort descending.  (optional, default to )
     * @param search A nested object containing a string &#x60;searchTerm&#x60; and a list of &#x60;fields&#x60; to search on. (optional)
     * @return ApiResponse&lt;Organizationslist&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Organizationslist> organizationListWithHttpInfo(String contentType, String accept, String fields, String filter, Integer limit, Integer skip, String sort, String search) throws ApiException {
        com.squareup.okhttp.Call call = organizationListValidateBeforeCall(contentType, accept, fields, filter, limit, skip, sort, search, null, null);
        Type localVarReturnType = new TypeToken<Organizationslist>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get Organization Details (asynchronously)
     * This endpoint returns Organization Details.  #### Sample Request  &#x60;&#x60;&#x60; curl -X GET \\   https://console.jumpcloud.com/api/organizations \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;   &#x60;&#x60;&#x60;
     * @param contentType  (required)
     * @param accept  (required)
     * @param fields Use a space seperated string of field parameters to include the data in the response. If omitted, the default list of fields will be returned.  (optional, default to )
     * @param filter A filter to apply to the query. (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort Use space separated sort parameters to sort the collection. Default sort is ascending. Prefix with &#x60;-&#x60; to sort descending.  (optional, default to )
     * @param search A nested object containing a string &#x60;searchTerm&#x60; and a list of &#x60;fields&#x60; to search on. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call organizationListAsync(String contentType, String accept, String fields, String filter, Integer limit, Integer skip, String sort, String search, final ApiCallback<Organizationslist> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = organizationListValidateBeforeCall(contentType, accept, fields, filter, limit, skip, sort, search, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Organizationslist>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
