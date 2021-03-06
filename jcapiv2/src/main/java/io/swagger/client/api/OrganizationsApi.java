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


import io.swagger.client.model.OrgCryptoSettings;

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
     * Build call for orgCryptoGet
     * @param id  (required)
     * @param contentType  (required)
     * @param accept  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter Supported operators are: eq, ne, gt, ge, lt, le, between, search, in (optional)
     * @param xOrgId  (optional, default to )
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call orgCryptoGetCall(String id, String contentType, String accept, List<String> fields, List<String> filter, String xOrgId, Integer skip, List<String> sort, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/organizations/{id}/crypto"
            .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (fields != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "fields", fields));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (xOrgId != null)
        localVarHeaderParams.put("x-org-id", apiClient.parameterToString(xOrgId));
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
    private com.squareup.okhttp.Call orgCryptoGetValidateBeforeCall(String id, String contentType, String accept, List<String> fields, List<String> filter, String xOrgId, Integer skip, List<String> sort, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling orgCryptoGet(Async)");
        }
        
        // verify the required parameter 'contentType' is set
        if (contentType == null) {
            throw new ApiException("Missing the required parameter 'contentType' when calling orgCryptoGet(Async)");
        }
        
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new ApiException("Missing the required parameter 'accept' when calling orgCryptoGet(Async)");
        }
        

        com.squareup.okhttp.Call call = orgCryptoGetCall(id, contentType, accept, fields, filter, xOrgId, skip, sort, limit, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get Crypto Settings
     * 
     * @param id  (required)
     * @param contentType  (required)
     * @param accept  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter Supported operators are: eq, ne, gt, ge, lt, le, between, search, in (optional)
     * @param xOrgId  (optional, default to )
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @return OrgCryptoSettings
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public OrgCryptoSettings orgCryptoGet(String id, String contentType, String accept, List<String> fields, List<String> filter, String xOrgId, Integer skip, List<String> sort, Integer limit) throws ApiException {
        ApiResponse<OrgCryptoSettings> resp = orgCryptoGetWithHttpInfo(id, contentType, accept, fields, filter, xOrgId, skip, sort, limit);
        return resp.getData();
    }

    /**
     * Get Crypto Settings
     * 
     * @param id  (required)
     * @param contentType  (required)
     * @param accept  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter Supported operators are: eq, ne, gt, ge, lt, le, between, search, in (optional)
     * @param xOrgId  (optional, default to )
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @return ApiResponse&lt;OrgCryptoSettings&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<OrgCryptoSettings> orgCryptoGetWithHttpInfo(String id, String contentType, String accept, List<String> fields, List<String> filter, String xOrgId, Integer skip, List<String> sort, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = orgCryptoGetValidateBeforeCall(id, contentType, accept, fields, filter, xOrgId, skip, sort, limit, null, null);
        Type localVarReturnType = new TypeToken<OrgCryptoSettings>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get Crypto Settings (asynchronously)
     * 
     * @param id  (required)
     * @param contentType  (required)
     * @param accept  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter Supported operators are: eq, ne, gt, ge, lt, le, between, search, in (optional)
     * @param xOrgId  (optional, default to )
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call orgCryptoGetAsync(String id, String contentType, String accept, List<String> fields, List<String> filter, String xOrgId, Integer skip, List<String> sort, Integer limit, final ApiCallback<OrgCryptoSettings> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = orgCryptoGetValidateBeforeCall(id, contentType, accept, fields, filter, xOrgId, skip, sort, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<OrgCryptoSettings>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for orgCryptoPut
     * @param id  (required)
     * @param contentType  (required)
     * @param accept  (required)
     * @param body  (optional)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter Supported operators are: eq, ne, gt, ge, lt, le, between, search, in (optional)
     * @param xOrgId  (optional, default to )
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call orgCryptoPutCall(String id, String contentType, String accept, OrgCryptoSettings body, List<String> fields, List<String> filter, String xOrgId, Integer skip, List<String> sort, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath = "/organizations/{id}/crypto"
            .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (fields != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "fields", fields));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (xOrgId != null)
        localVarHeaderParams.put("x-org-id", apiClient.parameterToString(xOrgId));
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
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call orgCryptoPutValidateBeforeCall(String id, String contentType, String accept, OrgCryptoSettings body, List<String> fields, List<String> filter, String xOrgId, Integer skip, List<String> sort, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling orgCryptoPut(Async)");
        }
        
        // verify the required parameter 'contentType' is set
        if (contentType == null) {
            throw new ApiException("Missing the required parameter 'contentType' when calling orgCryptoPut(Async)");
        }
        
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new ApiException("Missing the required parameter 'accept' when calling orgCryptoPut(Async)");
        }
        

        com.squareup.okhttp.Call call = orgCryptoPutCall(id, contentType, accept, body, fields, filter, xOrgId, skip, sort, limit, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Edit Crypto Settings
     * 
     * @param id  (required)
     * @param contentType  (required)
     * @param accept  (required)
     * @param body  (optional)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter Supported operators are: eq, ne, gt, ge, lt, le, between, search, in (optional)
     * @param xOrgId  (optional, default to )
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @return Object
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Object orgCryptoPut(String id, String contentType, String accept, OrgCryptoSettings body, List<String> fields, List<String> filter, String xOrgId, Integer skip, List<String> sort, Integer limit) throws ApiException {
        ApiResponse<Object> resp = orgCryptoPutWithHttpInfo(id, contentType, accept, body, fields, filter, xOrgId, skip, sort, limit);
        return resp.getData();
    }

    /**
     * Edit Crypto Settings
     * 
     * @param id  (required)
     * @param contentType  (required)
     * @param accept  (required)
     * @param body  (optional)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter Supported operators are: eq, ne, gt, ge, lt, le, between, search, in (optional)
     * @param xOrgId  (optional, default to )
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @return ApiResponse&lt;Object&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Object> orgCryptoPutWithHttpInfo(String id, String contentType, String accept, OrgCryptoSettings body, List<String> fields, List<String> filter, String xOrgId, Integer skip, List<String> sort, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = orgCryptoPutValidateBeforeCall(id, contentType, accept, body, fields, filter, xOrgId, skip, sort, limit, null, null);
        Type localVarReturnType = new TypeToken<Object>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Edit Crypto Settings (asynchronously)
     * 
     * @param id  (required)
     * @param contentType  (required)
     * @param accept  (required)
     * @param body  (optional)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter Supported operators are: eq, ne, gt, ge, lt, le, between, search, in (optional)
     * @param xOrgId  (optional, default to )
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call orgCryptoPutAsync(String id, String contentType, String accept, OrgCryptoSettings body, List<String> fields, List<String> filter, String xOrgId, Integer skip, List<String> sort, Integer limit, final ApiCallback<Object> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = orgCryptoPutValidateBeforeCall(id, contentType, accept, body, fields, filter, xOrgId, skip, sort, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Object>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
