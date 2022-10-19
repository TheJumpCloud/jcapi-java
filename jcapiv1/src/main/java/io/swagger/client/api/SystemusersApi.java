/*
 * JumpCloud API
 * # Overview  JumpCloud's V1 API. This set of endpoints allows JumpCloud customers to manage commands, systems, and system users.  # API Key  ## Access Your API Key  To locate your API Key:  1. Log into the [JumpCloud Admin Console](https://console.jumpcloud.com/). 2. Go to the username drop down located in the top-right of the Console. 3. Retrieve your API key from API Settings.  ## API Key Considerations  This API key is associated to the currently logged in administrator. Other admins will have different API keys.  **WARNING** Please keep this API key secret, as it grants full access to any data accessible via your JumpCloud console account.  You can also reset your API key in the same location in the JumpCloud Admin Console.  ## Recycling or Resetting Your API Key  In order to revoke access with the current API key, simply reset your API key. This will render all calls using the previous API key inaccessible.  Your API key will be passed in as a header with the header name \"x-api-key\".  ```bash curl -H \"x-api-key: [YOUR_API_KEY_HERE]\" \"https://console.jumpcloud.com/api/systemusers\" ```  # System Context  * [Introduction](#introduction) * [Supported endpoints](#supported-endpoints) * [Response codes](#response-codes) * [Authentication](#authentication) * [Additional examples](#additional-examples) * [Third party](#third-party)  ## Introduction  JumpCloud System Context Authorization is an alternative way to authenticate with a subset of JumpCloud's REST APIs. Using this method, a system can manage its information and resource associations, allowing modern auto provisioning environments to scale as needed.  **Notes:**   * The following documentation applies to Linux Operating Systems only.  * Systems that have been automatically enrolled using Apple's Device Enrollment Program (DEP) or systems enrolled using the User Portal install are not eligible to use the System Context API to prevent unauthorized access to system groups and resources. If a script that utilizes the System Context API is invoked on a system enrolled in this way, it will display an error.  ## Supported Endpoints  JumpCloud System Context Authorization can be used in conjunction with Systems endpoints found in the V1 API and certain System Group endpoints found in the v2 API.  * A system may fetch, alter, and delete metadata about itself, including manipulating a system's Group and Systemuser associations,   * `/api/systems/{system_id}` | [`GET`](https://docs.jumpcloud.com/api/1.0/index.html#operation/systems_get) [`PUT`](https://docs.jumpcloud.com/api/1.0/index.html#operation/systems_put) * A system may delete itself from your JumpCloud organization   * `/api/systems/{system_id}` | [`DELETE`](https://docs.jumpcloud.com/api/1.0/index.html#operation/systems_delete) * A system may fetch its direct resource associations under v2 (Groups)   * `/api/v2/systems/{system_id}/memberof` | [`GET`](https://docs.jumpcloud.com/api/2.0/index.html#operation/graph_systemGroupMembership)   * `/api/v2/systems/{system_id}/associations` | [`GET`](https://docs.jumpcloud.com/api/2.0/index.html#operation/graph_systemAssociationsList)   * `/api/v2/systems/{system_id}/users` | [`GET`](https://docs.jumpcloud.com/api/2.0/index.html#operation/graph_systemTraverseUser) * A system may alter its direct resource associations under v2 (Groups)   * `/api/v2/systems/{system_id}/associations` | [`POST`](https://docs.jumpcloud.com/api/2.0/index.html#operation/graph_systemAssociationsPost) * A system may alter its System Group associations   * `/api/v2/systemgroups/{group_id}/members` | [`POST`](https://docs.jumpcloud.com/api/2.0/index.html#operation/graph_systemGroupMembersPost)     * _NOTE_ If a system attempts to alter the system group membership of a different system the request will be rejected  ## Response Codes  If endpoints other than those described above are called using the System Context API, the server will return a `401` response.  ## Authentication  To allow for secure access to our APIs, you must authenticate each API request. JumpCloud System Context Authorization uses [HTTP Signatures](https://tools.ietf.org/html/draft-cavage-http-signatures-00) to authenticate API requests. The HTTP Signatures sent with each request are similar to the signatures used by the Amazon Web Services REST API. To help with the request-signing process, we have provided an [example bash script](https://github.com/TheJumpCloud/SystemContextAPI/blob/master/examples/shell/SigningExample.sh). This example API request simply requests the entire system record. You must be root, or have permissions to access the contents of the `/opt/jc` directory to generate a signature.  Here is a breakdown of the example script with explanations.  First, the script extracts the systemKey from the JSON formatted `/opt/jc/jcagent.conf` file.  ```bash #!/bin/bash conf=\"`cat /opt/jc/jcagent.conf`\" regex=\"systemKey\\\":\\\"(\\w+)\\\"\"  if [[ $conf =~ $regex ]] ; then   systemKey=\"${BASH_REMATCH[1]}\" fi ```  Then, the script retrieves the current date in the correct format.  ```bash now=`date -u \"+%a, %d %h %Y %H:%M:%S GMT\"`; ```  Next, we build a signing string to demonstrate the expected signature format. The signed string must consist of the [request-line](https://tools.ietf.org/html/rfc2616#page-35) and the date header, separated by a newline character.  ```bash signstr=\"GET /api/systems/${systemKey} HTTP/1.1\\ndate: ${now}\" ```  The next step is to calculate and apply the signature. This is a two-step process:  1. Create a signature from the signing string using the JumpCloud Agent private key: ``printf \"$signstr\" | openssl dgst -sha256 -sign /opt/jc/client.key`` 2. Then Base64-encode the signature string and trim off the newline characters: ``| openssl enc -e -a | tr -d '\\n'``  The combined steps above result in:  ```bash signature=`printf \"$signstr\" | openssl dgst -sha256 -sign /opt/jc/client.key | openssl enc -e -a | tr -d '\\n'` ; ```  Finally, we make sure the API call sending the signature has the same Authorization and Date header values, HTTP method, and URL that were used in the signing string.  ```bash curl -iq \\   -H \"Accept: application/json\" \\   -H \"Content-Type: application/json\" \\   -H \"Date: ${now}\" \\   -H \"Authorization: Signature keyId=\\\"system/${systemKey}\\\",headers=\\\"request-line date\\\",algorithm=\\\"rsa-sha256\\\",signature=\\\"${signature}\\\"\" \\   --url https://console.jumpcloud.com/api/systems/${systemKey} ```  ### Input Data  All PUT and POST methods should use the HTTP Content-Type header with a value of 'application/json'. PUT methods are used for updating a record. POST methods are used to create a record.  The following example demonstrates how to update the `displayName` of the system.  ```bash signstr=\"PUT /api/systems/${systemKey} HTTP/1.1\\ndate: ${now}\" signature=`printf \"$signstr\" | openssl dgst -sha256 -sign /opt/jc/client.key | openssl enc -e -a | tr -d '\\n'` ;  curl -iq \\   -d \"{\\\"displayName\\\" : \\\"updated-system-name-1\\\"}\" \\   -X \"PUT\" \\   -H \"Content-Type: application/json\" \\   -H \"Accept: application/json\" \\   -H \"Date: ${now}\" \\   -H \"Authorization: Signature keyId=\\\"system/${systemKey}\\\",headers=\\\"request-line date\\\",algorithm=\\\"rsa-sha256\\\",signature=\\\"${signature}\\\"\" \\   --url https://console.jumpcloud.com/api/systems/${systemKey} ```  ### Output Data  All results will be formatted as JSON.  Here is an abbreviated example of response output:  ```json {   \"_id\": \"525ee96f52e144993e000015\",   \"agentServer\": \"lappy386\",   \"agentVersion\": \"0.9.42\",   \"arch\": \"x86_64\",   \"connectionKey\": \"127.0.0.1_51812\",   \"displayName\": \"ubuntu-1204\",   \"firstContact\": \"2013-10-16T19:30:55.611Z\",   \"hostname\": \"ubuntu-1204\"   ... ```  ## Additional Examples  ### Signing Authentication Example  This example demonstrates how to make an authenticated request to fetch the JumpCloud record for this system.  [SigningExample.sh](https://github.com/TheJumpCloud/SystemContextAPI/blob/master/examples/shell/SigningExample.sh)  ### Shutdown Hook  This example demonstrates how to make an authenticated request on system shutdown. Using an init.d script registered at run level 0, you can call the System Context API as the system is shutting down.  [Instance-shutdown-initd](https://github.com/TheJumpCloud/SystemContextAPI/blob/master/examples/instance-shutdown-initd) is an example of an init.d script that only runs at system shutdown.  After customizing the [instance-shutdown-initd](https://github.com/TheJumpCloud/SystemContextAPI/blob/master/examples/instance-shutdown-initd) script, you should install it on the system(s) running the JumpCloud agent.  1. Copy the modified [instance-shutdown-initd](https://github.com/TheJumpCloud/SystemContextAPI/blob/master/examples/instance-shutdown-initd) to `/etc/init.d/instance-shutdown`. 2. On Ubuntu systems, run `update-rc.d instance-shutdown defaults`. On RedHat/CentOS systems, run `chkconfig --add instance-shutdown`.  ## Third Party  ### Chef Cookbooks  [https://github.com/nshenry03/jumpcloud](https://github.com/nshenry03/jumpcloud)  [https://github.com/cjs226/jumpcloud](https://github.com/cjs226/jumpcloud)  # Multi-Tenant Portal Headers  Multi-Tenant Organization API Headers are available for JumpCloud Admins to use when making API requests from Organizations that have multiple managed organizations.  The `x-org-id` is a required header for all multi-tenant admins when making API requests to JumpCloud. This header will define to which organization you would like to make the request.  **NOTE** Single Tenant Admins do not need to provide this header when making an API request.  ## Header Value  `x-org-id`  ## API Response Codes  * `400` Malformed ID. * `400` x-org-id and Organization path ID do not match. * `401` ID not included for multi-tenant admin * `403` ID included on unsupported route. * `404` Organization ID Not Found.  ```bash curl -X GET https://console.jumpcloud.com/api/v2/directories \\   -H 'accept: application/json' \\   -H 'content-type: application/json' \\   -H 'x-api-key: {API_KEY}' \\   -H 'x-org-id: {ORG_ID}'  ```  ## To Obtain an Individual Organization ID via the UI  As a prerequisite, your Primary Organization will need to be setup for Multi-Tenancy. This provides access to the Multi-Tenant Organization Admin Portal.  1. Log into JumpCloud [Admin Console](https://console.jumpcloud.com). If you are a multi-tenant Admin, you will automatically be routed to the Multi-Tenant Admin Portal. 2. From the Multi-Tenant Portal's primary navigation bar, select the Organization you'd like to access. 3. You will automatically be routed to that Organization's Admin Console. 4. Go to Settings in the sub-tenant's primary navigation. 5. You can obtain your Organization ID below your Organization's Contact Information on the Settings page.  ## To Obtain All Organization IDs via the API  * You can make an API request to this endpoint using the API key of your Primary Organization.  `https://console.jumpcloud.com/api/organizations/` This will return all your managed organizations.  ```bash curl -X GET \\   https://console.jumpcloud.com/api/organizations/ \\   -H 'Accept: application/json' \\   -H 'Content-Type: application/json' \\   -H 'x-api-key: {API_KEY}' ```  # SDKs  You can find language specific SDKs that can help you kickstart your Integration with JumpCloud in the following GitHub repositories:  * [Python](https://github.com/TheJumpCloud/jcapi-python) * [Go](https://github.com/TheJumpCloud/jcapi-go) * [Ruby](https://github.com/TheJumpCloud/jcapi-ruby) * [Java](https://github.com/TheJumpCloud/jcapi-java) 
 *
 * OpenAPI spec version: 1.0
 * Contact: support@jumpcloud.com
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
import io.swagger.client.model.ErrorDetails;
import io.swagger.client.model.IdResetmfaBody;
import io.swagger.client.model.Sshkeylist;
import io.swagger.client.model.Sshkeypost;
import io.swagger.client.model.StateActivateBody;
import io.swagger.client.model.Systemuserput;
import io.swagger.client.model.Systemuserputpost;
import io.swagger.client.model.Systemuserreturn;
import io.swagger.client.model.Systemuserslist;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SystemusersApi {
    private ApiClient apiClient;

    public SystemusersApi() {
        this(Configuration.getDefaultApiClient());
    }

    public SystemusersApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for sshkeyDelete
     * @param systemuserId  (required)
     * @param id  (required)
     * @param xOrgId  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call sshkeyDeleteCall(String systemuserId, String id, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systemusers/{systemuser_id}/sshkeys/{id}"
            .replaceAll("\\{" + "systemuser_id" + "\\}", apiClient.escapeString(systemuserId.toString()))
            .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (xOrgId != null)
        localVarHeaderParams.put("x-org-id", apiClient.parameterToString(xOrgId));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json", "text/plain"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
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
    private com.squareup.okhttp.Call sshkeyDeleteValidateBeforeCall(String systemuserId, String id, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'systemuserId' is set
        if (systemuserId == null) {
            throw new ApiException("Missing the required parameter 'systemuserId' when calling sshkeyDelete(Async)");
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling sshkeyDelete(Async)");
        }
        
        com.squareup.okhttp.Call call = sshkeyDeleteCall(systemuserId, id, xOrgId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Delete a system user&#x27;s Public SSH Keys
     * This endpoint will delete a specific System User&#x27;s SSH Key.
     * @param systemuserId  (required)
     * @param id  (required)
     * @param xOrgId  (optional)
     * @return String
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public String sshkeyDelete(String systemuserId, String id, String xOrgId) throws ApiException {
        ApiResponse<String> resp = sshkeyDeleteWithHttpInfo(systemuserId, id, xOrgId);
        return resp.getData();
    }

    /**
     * Delete a system user&#x27;s Public SSH Keys
     * This endpoint will delete a specific System User&#x27;s SSH Key.
     * @param systemuserId  (required)
     * @param id  (required)
     * @param xOrgId  (optional)
     * @return ApiResponse&lt;String&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<String> sshkeyDeleteWithHttpInfo(String systemuserId, String id, String xOrgId) throws ApiException {
        com.squareup.okhttp.Call call = sshkeyDeleteValidateBeforeCall(systemuserId, id, xOrgId, null, null);
        Type localVarReturnType = new TypeToken<String>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Delete a system user&#x27;s Public SSH Keys (asynchronously)
     * This endpoint will delete a specific System User&#x27;s SSH Key.
     * @param systemuserId  (required)
     * @param id  (required)
     * @param xOrgId  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call sshkeyDeleteAsync(String systemuserId, String id, String xOrgId, final ApiCallback<String> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = sshkeyDeleteValidateBeforeCall(systemuserId, id, xOrgId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<String>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for sshkeyList
     * @param id  (required)
     * @param xOrgId  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call sshkeyListCall(String id, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systemusers/{id}/sshkeys"
            .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (xOrgId != null)
        localVarHeaderParams.put("x-org-id", apiClient.parameterToString(xOrgId));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
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
    private com.squareup.okhttp.Call sshkeyListValidateBeforeCall(String id, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling sshkeyList(Async)");
        }
        
        com.squareup.okhttp.Call call = sshkeyListCall(id, xOrgId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List a system user&#x27;s public SSH keys
     * This endpoint will return a specific System User&#x27;s public SSH key.
     * @param id  (required)
     * @param xOrgId  (optional)
     * @return List&lt;Sshkeylist&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<Sshkeylist> sshkeyList(String id, String xOrgId) throws ApiException {
        ApiResponse<List<Sshkeylist>> resp = sshkeyListWithHttpInfo(id, xOrgId);
        return resp.getData();
    }

    /**
     * List a system user&#x27;s public SSH keys
     * This endpoint will return a specific System User&#x27;s public SSH key.
     * @param id  (required)
     * @param xOrgId  (optional)
     * @return ApiResponse&lt;List&lt;Sshkeylist&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<Sshkeylist>> sshkeyListWithHttpInfo(String id, String xOrgId) throws ApiException {
        com.squareup.okhttp.Call call = sshkeyListValidateBeforeCall(id, xOrgId, null, null);
        Type localVarReturnType = new TypeToken<List<Sshkeylist>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List a system user&#x27;s public SSH keys (asynchronously)
     * This endpoint will return a specific System User&#x27;s public SSH key.
     * @param id  (required)
     * @param xOrgId  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call sshkeyListAsync(String id, String xOrgId, final ApiCallback<List<Sshkeylist>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = sshkeyListValidateBeforeCall(id, xOrgId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<Sshkeylist>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for sshkeyPost
     * @param id  (required)
     * @param body  (optional)
     * @param xOrgId  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call sshkeyPostCall(String id, Sshkeypost body, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/systemusers/{id}/sshkeys"
            .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
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
    private com.squareup.okhttp.Call sshkeyPostValidateBeforeCall(String id, Sshkeypost body, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling sshkeyPost(Async)");
        }
        
        com.squareup.okhttp.Call call = sshkeyPostCall(id, body, xOrgId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Create a system user&#x27;s Public SSH Key
     * This endpoint will create a specific System User&#x27;s Public SSH Key.
     * @param id  (required)
     * @param body  (optional)
     * @param xOrgId  (optional)
     * @return Sshkeylist
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Sshkeylist sshkeyPost(String id, Sshkeypost body, String xOrgId) throws ApiException {
        ApiResponse<Sshkeylist> resp = sshkeyPostWithHttpInfo(id, body, xOrgId);
        return resp.getData();
    }

    /**
     * Create a system user&#x27;s Public SSH Key
     * This endpoint will create a specific System User&#x27;s Public SSH Key.
     * @param id  (required)
     * @param body  (optional)
     * @param xOrgId  (optional)
     * @return ApiResponse&lt;Sshkeylist&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Sshkeylist> sshkeyPostWithHttpInfo(String id, Sshkeypost body, String xOrgId) throws ApiException {
        com.squareup.okhttp.Call call = sshkeyPostValidateBeforeCall(id, body, xOrgId, null, null);
        Type localVarReturnType = new TypeToken<Sshkeylist>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Create a system user&#x27;s Public SSH Key (asynchronously)
     * This endpoint will create a specific System User&#x27;s Public SSH Key.
     * @param id  (required)
     * @param body  (optional)
     * @param xOrgId  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call sshkeyPostAsync(String id, Sshkeypost body, String xOrgId, final ApiCallback<Sshkeylist> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = sshkeyPostValidateBeforeCall(id, body, xOrgId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Sshkeylist>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systemusersDelete
     * @param id  (required)
     * @param xOrgId  (optional)
     * @param cascadeManager This is an optional flag that can be enabled on the DELETE call, DELETE /systemusers/{id}?cascade_manager&#x3D;null. This parameter will clear the Manager attribute on all direct reports and then delete the account. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systemusersDeleteCall(String id, String xOrgId, String cascadeManager, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systemusers/{id}"
            .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (cascadeManager != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("cascade_manager", cascadeManager));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (xOrgId != null)
        localVarHeaderParams.put("x-org-id", apiClient.parameterToString(xOrgId));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
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
    private com.squareup.okhttp.Call systemusersDeleteValidateBeforeCall(String id, String xOrgId, String cascadeManager, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling systemusersDelete(Async)");
        }
        
        com.squareup.okhttp.Call call = systemusersDeleteCall(id, xOrgId, cascadeManager, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Delete a system user
     * This endpoint allows you to delete a particular system user.  #### Sample Request &#x60;&#x60;&#x60; curl -X DELETE https://console.jumpcloud.com/api/systemusers/{UserID} \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     * @param id  (required)
     * @param xOrgId  (optional)
     * @param cascadeManager This is an optional flag that can be enabled on the DELETE call, DELETE /systemusers/{id}?cascade_manager&#x3D;null. This parameter will clear the Manager attribute on all direct reports and then delete the account. (optional)
     * @return Systemuserreturn
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Systemuserreturn systemusersDelete(String id, String xOrgId, String cascadeManager) throws ApiException {
        ApiResponse<Systemuserreturn> resp = systemusersDeleteWithHttpInfo(id, xOrgId, cascadeManager);
        return resp.getData();
    }

    /**
     * Delete a system user
     * This endpoint allows you to delete a particular system user.  #### Sample Request &#x60;&#x60;&#x60; curl -X DELETE https://console.jumpcloud.com/api/systemusers/{UserID} \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     * @param id  (required)
     * @param xOrgId  (optional)
     * @param cascadeManager This is an optional flag that can be enabled on the DELETE call, DELETE /systemusers/{id}?cascade_manager&#x3D;null. This parameter will clear the Manager attribute on all direct reports and then delete the account. (optional)
     * @return ApiResponse&lt;Systemuserreturn&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Systemuserreturn> systemusersDeleteWithHttpInfo(String id, String xOrgId, String cascadeManager) throws ApiException {
        com.squareup.okhttp.Call call = systemusersDeleteValidateBeforeCall(id, xOrgId, cascadeManager, null, null);
        Type localVarReturnType = new TypeToken<Systemuserreturn>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Delete a system user (asynchronously)
     * This endpoint allows you to delete a particular system user.  #### Sample Request &#x60;&#x60;&#x60; curl -X DELETE https://console.jumpcloud.com/api/systemusers/{UserID} \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     * @param id  (required)
     * @param xOrgId  (optional)
     * @param cascadeManager This is an optional flag that can be enabled on the DELETE call, DELETE /systemusers/{id}?cascade_manager&#x3D;null. This parameter will clear the Manager attribute on all direct reports and then delete the account. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systemusersDeleteAsync(String id, String xOrgId, String cascadeManager, final ApiCallback<Systemuserreturn> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systemusersDeleteValidateBeforeCall(id, xOrgId, cascadeManager, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Systemuserreturn>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systemusersExpire
     * @param id  (required)
     * @param xOrgId  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systemusersExpireCall(String id, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systemusers/{id}/expire"
            .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (xOrgId != null)
        localVarHeaderParams.put("x-org-id", apiClient.parameterToString(xOrgId));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json", "text/plain"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
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
    private com.squareup.okhttp.Call systemusersExpireValidateBeforeCall(String id, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling systemusersExpire(Async)");
        }
        
        com.squareup.okhttp.Call call = systemusersExpireCall(id, xOrgId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Expire a system user&#x27;s password
     * This endpoint allows you to expire a user&#x27;s password.
     * @param id  (required)
     * @param xOrgId  (optional)
     * @return String
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public String systemusersExpire(String id, String xOrgId) throws ApiException {
        ApiResponse<String> resp = systemusersExpireWithHttpInfo(id, xOrgId);
        return resp.getData();
    }

    /**
     * Expire a system user&#x27;s password
     * This endpoint allows you to expire a user&#x27;s password.
     * @param id  (required)
     * @param xOrgId  (optional)
     * @return ApiResponse&lt;String&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<String> systemusersExpireWithHttpInfo(String id, String xOrgId) throws ApiException {
        com.squareup.okhttp.Call call = systemusersExpireValidateBeforeCall(id, xOrgId, null, null);
        Type localVarReturnType = new TypeToken<String>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Expire a system user&#x27;s password (asynchronously)
     * This endpoint allows you to expire a user&#x27;s password.
     * @param id  (required)
     * @param xOrgId  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systemusersExpireAsync(String id, String xOrgId, final ApiCallback<String> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systemusersExpireValidateBeforeCall(id, xOrgId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<String>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systemusersGet
     * @param id  (required)
     * @param fields Use a space seperated string of field parameters to include the data in the response. If omitted, the default list of fields will be returned.  (optional)
     * @param filter A filter to apply to the query. See the supported operators below. For more complex searches, see the related &#x60;/search/&lt;domain&gt;&#x60; endpoints, e.g. &#x60;/search/systems&#x60;.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D; Supported operators are: - &#x60;$eq&#x60; (equals) - &#x60;$ne&#x60; (does not equal) - &#x60;$gt&#x60; (is greater than) - &#x60;$gte&#x60; (is greater than or equal to) - &#x60;$lt&#x60; (is less than) - &#x60;$lte&#x60; (is less than or equal to)  _Note: v1 operators differ from v2 operators._  _Note: For v1 operators, excluding the &#x60;$&#x60; will result in undefined behavior._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive.  **Examples** - &#x60;GET /users?filter&#x3D;username:$eq:testuser&#x60; - &#x60;GET /systemusers?filter&#x3D;password_expiration_date:$lte:2021-10-24&#x60; - &#x60;GET /systemusers?filter&#x3D;department:$ne:Accounting&#x60; - &#x60;GET /systems?filter[0]&#x3D;firstname:$eq:foo&amp;filter[1]&#x3D;lastname:$eq:bar&#x60; - this will    AND the filters together. - &#x60;GET /systems?filter[or][0]&#x3D;lastname:$eq:foo&amp;filter[or][1]&#x3D;lastname:$eq:bar&#x60; - this will    OR the filters together. (optional)
     * @param xOrgId  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systemusersGetCall(String id, String fields, String filter, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systemusers/{id}"
            .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (fields != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("fields", fields));
        if (filter != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("filter", filter));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (xOrgId != null)
        localVarHeaderParams.put("x-org-id", apiClient.parameterToString(xOrgId));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
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
    private com.squareup.okhttp.Call systemusersGetValidateBeforeCall(String id, String fields, String filter, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling systemusersGet(Async)");
        }
        
        com.squareup.okhttp.Call call = systemusersGetCall(id, fields, filter, xOrgId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List a system user
     * This endpoint returns a particular System User.  #### Sample Request  &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/systemusers/{UserID} \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     * @param id  (required)
     * @param fields Use a space seperated string of field parameters to include the data in the response. If omitted, the default list of fields will be returned.  (optional)
     * @param filter A filter to apply to the query. See the supported operators below. For more complex searches, see the related &#x60;/search/&lt;domain&gt;&#x60; endpoints, e.g. &#x60;/search/systems&#x60;.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D; Supported operators are: - &#x60;$eq&#x60; (equals) - &#x60;$ne&#x60; (does not equal) - &#x60;$gt&#x60; (is greater than) - &#x60;$gte&#x60; (is greater than or equal to) - &#x60;$lt&#x60; (is less than) - &#x60;$lte&#x60; (is less than or equal to)  _Note: v1 operators differ from v2 operators._  _Note: For v1 operators, excluding the &#x60;$&#x60; will result in undefined behavior._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive.  **Examples** - &#x60;GET /users?filter&#x3D;username:$eq:testuser&#x60; - &#x60;GET /systemusers?filter&#x3D;password_expiration_date:$lte:2021-10-24&#x60; - &#x60;GET /systemusers?filter&#x3D;department:$ne:Accounting&#x60; - &#x60;GET /systems?filter[0]&#x3D;firstname:$eq:foo&amp;filter[1]&#x3D;lastname:$eq:bar&#x60; - this will    AND the filters together. - &#x60;GET /systems?filter[or][0]&#x3D;lastname:$eq:foo&amp;filter[or][1]&#x3D;lastname:$eq:bar&#x60; - this will    OR the filters together. (optional)
     * @param xOrgId  (optional)
     * @return Systemuserreturn
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Systemuserreturn systemusersGet(String id, String fields, String filter, String xOrgId) throws ApiException {
        ApiResponse<Systemuserreturn> resp = systemusersGetWithHttpInfo(id, fields, filter, xOrgId);
        return resp.getData();
    }

    /**
     * List a system user
     * This endpoint returns a particular System User.  #### Sample Request  &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/systemusers/{UserID} \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     * @param id  (required)
     * @param fields Use a space seperated string of field parameters to include the data in the response. If omitted, the default list of fields will be returned.  (optional)
     * @param filter A filter to apply to the query. See the supported operators below. For more complex searches, see the related &#x60;/search/&lt;domain&gt;&#x60; endpoints, e.g. &#x60;/search/systems&#x60;.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D; Supported operators are: - &#x60;$eq&#x60; (equals) - &#x60;$ne&#x60; (does not equal) - &#x60;$gt&#x60; (is greater than) - &#x60;$gte&#x60; (is greater than or equal to) - &#x60;$lt&#x60; (is less than) - &#x60;$lte&#x60; (is less than or equal to)  _Note: v1 operators differ from v2 operators._  _Note: For v1 operators, excluding the &#x60;$&#x60; will result in undefined behavior._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive.  **Examples** - &#x60;GET /users?filter&#x3D;username:$eq:testuser&#x60; - &#x60;GET /systemusers?filter&#x3D;password_expiration_date:$lte:2021-10-24&#x60; - &#x60;GET /systemusers?filter&#x3D;department:$ne:Accounting&#x60; - &#x60;GET /systems?filter[0]&#x3D;firstname:$eq:foo&amp;filter[1]&#x3D;lastname:$eq:bar&#x60; - this will    AND the filters together. - &#x60;GET /systems?filter[or][0]&#x3D;lastname:$eq:foo&amp;filter[or][1]&#x3D;lastname:$eq:bar&#x60; - this will    OR the filters together. (optional)
     * @param xOrgId  (optional)
     * @return ApiResponse&lt;Systemuserreturn&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Systemuserreturn> systemusersGetWithHttpInfo(String id, String fields, String filter, String xOrgId) throws ApiException {
        com.squareup.okhttp.Call call = systemusersGetValidateBeforeCall(id, fields, filter, xOrgId, null, null);
        Type localVarReturnType = new TypeToken<Systemuserreturn>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List a system user (asynchronously)
     * This endpoint returns a particular System User.  #### Sample Request  &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/systemusers/{UserID} \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     * @param id  (required)
     * @param fields Use a space seperated string of field parameters to include the data in the response. If omitted, the default list of fields will be returned.  (optional)
     * @param filter A filter to apply to the query. See the supported operators below. For more complex searches, see the related &#x60;/search/&lt;domain&gt;&#x60; endpoints, e.g. &#x60;/search/systems&#x60;.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D; Supported operators are: - &#x60;$eq&#x60; (equals) - &#x60;$ne&#x60; (does not equal) - &#x60;$gt&#x60; (is greater than) - &#x60;$gte&#x60; (is greater than or equal to) - &#x60;$lt&#x60; (is less than) - &#x60;$lte&#x60; (is less than or equal to)  _Note: v1 operators differ from v2 operators._  _Note: For v1 operators, excluding the &#x60;$&#x60; will result in undefined behavior._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive.  **Examples** - &#x60;GET /users?filter&#x3D;username:$eq:testuser&#x60; - &#x60;GET /systemusers?filter&#x3D;password_expiration_date:$lte:2021-10-24&#x60; - &#x60;GET /systemusers?filter&#x3D;department:$ne:Accounting&#x60; - &#x60;GET /systems?filter[0]&#x3D;firstname:$eq:foo&amp;filter[1]&#x3D;lastname:$eq:bar&#x60; - this will    AND the filters together. - &#x60;GET /systems?filter[or][0]&#x3D;lastname:$eq:foo&amp;filter[or][1]&#x3D;lastname:$eq:bar&#x60; - this will    OR the filters together. (optional)
     * @param xOrgId  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systemusersGetAsync(String id, String fields, String filter, String xOrgId, final ApiCallback<Systemuserreturn> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systemusersGetValidateBeforeCall(id, fields, filter, xOrgId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Systemuserreturn>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systemusersList
     * @param limit The number of records to return at once. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The space separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @param fields The space separated fields included in the returned records. If omitted the default list of fields will be returned.  (optional)
     * @param filter A filter to apply to the query. See the supported operators below. For more complex searches, see the related &#x60;/search/&lt;domain&gt;&#x60; endpoints, e.g. &#x60;/search/systems&#x60;.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D; Supported operators are: - &#x60;$eq&#x60; (equals) - &#x60;$ne&#x60; (does not equal) - &#x60;$gt&#x60; (is greater than) - &#x60;$gte&#x60; (is greater than or equal to) - &#x60;$lt&#x60; (is less than) - &#x60;$lte&#x60; (is less than or equal to)  _Note: v1 operators differ from v2 operators._  _Note: For v1 operators, excluding the &#x60;$&#x60; will result in undefined behavior._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive.  **Examples** - &#x60;GET /users?filter&#x3D;username:$eq:testuser&#x60; - &#x60;GET /systemusers?filter&#x3D;password_expiration_date:$lte:2021-10-24&#x60; - &#x60;GET /systemusers?filter&#x3D;department:$ne:Accounting&#x60; - &#x60;GET /systems?filter[0]&#x3D;firstname:$eq:foo&amp;filter[1]&#x3D;lastname:$eq:bar&#x60; - this will    AND the filters together. - &#x60;GET /systems?filter[or][0]&#x3D;lastname:$eq:foo&amp;filter[or][1]&#x3D;lastname:$eq:bar&#x60; - this will    OR the filters together. (optional)
     * @param xOrgId  (optional)
     * @param search A nested object containing a &#x60;searchTerm&#x60; string or array of strings and a list of &#x60;fields&#x60; to search on. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systemusersListCall(Integer limit, Integer skip, String sort, String fields, String filter, String xOrgId, String search, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systemusers";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("sort", sort));
        if (fields != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("fields", fields));
        if (filter != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("filter", filter));
        if (search != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("search", search));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (xOrgId != null)
        localVarHeaderParams.put("x-org-id", apiClient.parameterToString(xOrgId));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
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
    private com.squareup.okhttp.Call systemusersListValidateBeforeCall(Integer limit, Integer skip, String sort, String fields, String filter, String xOrgId, String search, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systemusersListCall(limit, skip, sort, fields, filter, xOrgId, search, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List all system users
     * This endpoint returns all systemusers.  #### Sample Request  &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/systemusers \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     * @param limit The number of records to return at once. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The space separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @param fields The space separated fields included in the returned records. If omitted the default list of fields will be returned.  (optional)
     * @param filter A filter to apply to the query. See the supported operators below. For more complex searches, see the related &#x60;/search/&lt;domain&gt;&#x60; endpoints, e.g. &#x60;/search/systems&#x60;.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D; Supported operators are: - &#x60;$eq&#x60; (equals) - &#x60;$ne&#x60; (does not equal) - &#x60;$gt&#x60; (is greater than) - &#x60;$gte&#x60; (is greater than or equal to) - &#x60;$lt&#x60; (is less than) - &#x60;$lte&#x60; (is less than or equal to)  _Note: v1 operators differ from v2 operators._  _Note: For v1 operators, excluding the &#x60;$&#x60; will result in undefined behavior._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive.  **Examples** - &#x60;GET /users?filter&#x3D;username:$eq:testuser&#x60; - &#x60;GET /systemusers?filter&#x3D;password_expiration_date:$lte:2021-10-24&#x60; - &#x60;GET /systemusers?filter&#x3D;department:$ne:Accounting&#x60; - &#x60;GET /systems?filter[0]&#x3D;firstname:$eq:foo&amp;filter[1]&#x3D;lastname:$eq:bar&#x60; - this will    AND the filters together. - &#x60;GET /systems?filter[or][0]&#x3D;lastname:$eq:foo&amp;filter[or][1]&#x3D;lastname:$eq:bar&#x60; - this will    OR the filters together. (optional)
     * @param xOrgId  (optional)
     * @param search A nested object containing a &#x60;searchTerm&#x60; string or array of strings and a list of &#x60;fields&#x60; to search on. (optional)
     * @return Systemuserslist
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Systemuserslist systemusersList(Integer limit, Integer skip, String sort, String fields, String filter, String xOrgId, String search) throws ApiException {
        ApiResponse<Systemuserslist> resp = systemusersListWithHttpInfo(limit, skip, sort, fields, filter, xOrgId, search);
        return resp.getData();
    }

    /**
     * List all system users
     * This endpoint returns all systemusers.  #### Sample Request  &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/systemusers \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     * @param limit The number of records to return at once. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The space separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @param fields The space separated fields included in the returned records. If omitted the default list of fields will be returned.  (optional)
     * @param filter A filter to apply to the query. See the supported operators below. For more complex searches, see the related &#x60;/search/&lt;domain&gt;&#x60; endpoints, e.g. &#x60;/search/systems&#x60;.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D; Supported operators are: - &#x60;$eq&#x60; (equals) - &#x60;$ne&#x60; (does not equal) - &#x60;$gt&#x60; (is greater than) - &#x60;$gte&#x60; (is greater than or equal to) - &#x60;$lt&#x60; (is less than) - &#x60;$lte&#x60; (is less than or equal to)  _Note: v1 operators differ from v2 operators._  _Note: For v1 operators, excluding the &#x60;$&#x60; will result in undefined behavior._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive.  **Examples** - &#x60;GET /users?filter&#x3D;username:$eq:testuser&#x60; - &#x60;GET /systemusers?filter&#x3D;password_expiration_date:$lte:2021-10-24&#x60; - &#x60;GET /systemusers?filter&#x3D;department:$ne:Accounting&#x60; - &#x60;GET /systems?filter[0]&#x3D;firstname:$eq:foo&amp;filter[1]&#x3D;lastname:$eq:bar&#x60; - this will    AND the filters together. - &#x60;GET /systems?filter[or][0]&#x3D;lastname:$eq:foo&amp;filter[or][1]&#x3D;lastname:$eq:bar&#x60; - this will    OR the filters together. (optional)
     * @param xOrgId  (optional)
     * @param search A nested object containing a &#x60;searchTerm&#x60; string or array of strings and a list of &#x60;fields&#x60; to search on. (optional)
     * @return ApiResponse&lt;Systemuserslist&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Systemuserslist> systemusersListWithHttpInfo(Integer limit, Integer skip, String sort, String fields, String filter, String xOrgId, String search) throws ApiException {
        com.squareup.okhttp.Call call = systemusersListValidateBeforeCall(limit, skip, sort, fields, filter, xOrgId, search, null, null);
        Type localVarReturnType = new TypeToken<Systemuserslist>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List all system users (asynchronously)
     * This endpoint returns all systemusers.  #### Sample Request  &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/systemusers \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     * @param limit The number of records to return at once. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The space separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @param fields The space separated fields included in the returned records. If omitted the default list of fields will be returned.  (optional)
     * @param filter A filter to apply to the query. See the supported operators below. For more complex searches, see the related &#x60;/search/&lt;domain&gt;&#x60; endpoints, e.g. &#x60;/search/systems&#x60;.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D; Supported operators are: - &#x60;$eq&#x60; (equals) - &#x60;$ne&#x60; (does not equal) - &#x60;$gt&#x60; (is greater than) - &#x60;$gte&#x60; (is greater than or equal to) - &#x60;$lt&#x60; (is less than) - &#x60;$lte&#x60; (is less than or equal to)  _Note: v1 operators differ from v2 operators._  _Note: For v1 operators, excluding the &#x60;$&#x60; will result in undefined behavior._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive.  **Examples** - &#x60;GET /users?filter&#x3D;username:$eq:testuser&#x60; - &#x60;GET /systemusers?filter&#x3D;password_expiration_date:$lte:2021-10-24&#x60; - &#x60;GET /systemusers?filter&#x3D;department:$ne:Accounting&#x60; - &#x60;GET /systems?filter[0]&#x3D;firstname:$eq:foo&amp;filter[1]&#x3D;lastname:$eq:bar&#x60; - this will    AND the filters together. - &#x60;GET /systems?filter[or][0]&#x3D;lastname:$eq:foo&amp;filter[or][1]&#x3D;lastname:$eq:bar&#x60; - this will    OR the filters together. (optional)
     * @param xOrgId  (optional)
     * @param search A nested object containing a &#x60;searchTerm&#x60; string or array of strings and a list of &#x60;fields&#x60; to search on. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systemusersListAsync(Integer limit, Integer skip, String sort, String fields, String filter, String xOrgId, String search, final ApiCallback<Systemuserslist> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systemusersListValidateBeforeCall(limit, skip, sort, fields, filter, xOrgId, search, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Systemuserslist>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systemusersMfasync
     * @param id  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systemusersMfasyncCall(String id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systemusers/{id}/mfasync"
            .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
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
    private com.squareup.okhttp.Call systemusersMfasyncValidateBeforeCall(String id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling systemusersMfasync(Async)");
        }
        
        com.squareup.okhttp.Call call = systemusersMfasyncCall(id, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Sync a systemuser&#x27;s mfa enrollment status
     * This endpoint allows you to re-sync a user&#x27;s mfa enrollment status  #### Sample Request &#x60;&#x60;&#x60; curl -X POST \\   https://console.jumpcloud.com/api/systemusers/{UserID}/mfasync \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\  &#x60;&#x60;&#x60;
     * @param id  (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void systemusersMfasync(String id) throws ApiException {
        systemusersMfasyncWithHttpInfo(id);
    }

    /**
     * Sync a systemuser&#x27;s mfa enrollment status
     * This endpoint allows you to re-sync a user&#x27;s mfa enrollment status  #### Sample Request &#x60;&#x60;&#x60; curl -X POST \\   https://console.jumpcloud.com/api/systemusers/{UserID}/mfasync \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\  &#x60;&#x60;&#x60;
     * @param id  (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> systemusersMfasyncWithHttpInfo(String id) throws ApiException {
        com.squareup.okhttp.Call call = systemusersMfasyncValidateBeforeCall(id, null, null);
        return apiClient.execute(call);
    }

    /**
     * Sync a systemuser&#x27;s mfa enrollment status (asynchronously)
     * This endpoint allows you to re-sync a user&#x27;s mfa enrollment status  #### Sample Request &#x60;&#x60;&#x60; curl -X POST \\   https://console.jumpcloud.com/api/systemusers/{UserID}/mfasync \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\  &#x60;&#x60;&#x60;
     * @param id  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systemusersMfasyncAsync(String id, final ApiCallback<Void> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systemusersMfasyncValidateBeforeCall(id, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for systemusersPost
     * @param body  (optional)
     * @param xOrgId  (optional)
     * @param fullValidationDetails Pass this query parameter when a client wants all validation errors to be returned with a detailed error response for the form field specified. The current form fields are allowed:  * &#x60;password&#x60;  #### Password validation flag Use the &#x60;password&#x60; validation flag to receive details on a possible bad request response &#x60;&#x60;&#x60; ?fullValidationDetails&#x3D;password &#x60;&#x60;&#x60; Without the flag, default behavior will be a normal 400 with only a single validation string error #### Expected Behavior Clients can expect a list of validation error mappings for the validation query field in the details provided on the response: &#x60;&#x60;&#x60; {   \&quot;code\&quot;: 400,   \&quot;message\&quot;: \&quot;Password validation fail\&quot;,   \&quot;status\&quot;: \&quot;INVALID_ARGUMENT\&quot;,   \&quot;details\&quot;: [       {         \&quot;fieldViolationsList\&quot;: [           {\&quot;field\&quot;: \&quot;password\&quot;, \&quot;description\&quot;: \&quot;specialCharacter\&quot;}         ],         &#x27;@type&#x27;: &#x27;type.googleapis.com/google.rpc.BadRequest&#x27;,       },   ], }, &#x60;&#x60;&#x60; (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systemusersPostCall(Systemuserputpost body, String xOrgId, String fullValidationDetails, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/systemusers";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (fullValidationDetails != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("fullValidationDetails", fullValidationDetails));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
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
    private com.squareup.okhttp.Call systemusersPostValidateBeforeCall(Systemuserputpost body, String xOrgId, String fullValidationDetails, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systemusersPostCall(body, xOrgId, fullValidationDetails, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Create a system user
     * \&quot;This endpoint allows you to create a new system user.  #### Default User State The &#x60;state&#x60; of the user can be explicitly passed in or omitted. If &#x60;state&#x60; is omitted from the request, then the user will get created using the value returned from the [Get an Organization](https://docs.jumpcloud.com/api/1.0/index.html#operation/organizations_get) endpoint. The default user state for manually created users is stored in &#x60;settings.newSystemUserStateDefaults.manualEntry&#x60;  These default state values can be changed in the admin portal settings or by using the [Update an Organization](https://docs.jumpcloud.com/api/1.0/index.html#operation/organization_put) endpoint.  #### Sample Request  &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/systemusers \\ -H &#x27;Accept: application/json&#x27; \\ -H &#x27;Content-Type: application/json&#x27; \\ -H &#x27;x-api-key: {API_KEY}&#x27; \\ -d &#x27;{       \&quot;username\&quot;:\&quot;{username}\&quot;,       \&quot;email\&quot;:\&quot;{email_address}\&quot;,       \&quot;firstname\&quot;:\&quot;{Name}\&quot;,       \&quot;lastname\&quot;:\&quot;{Name}\&quot;     }&#x27; &#x60;&#x60;&#x60;
     * @param body  (optional)
     * @param xOrgId  (optional)
     * @param fullValidationDetails Pass this query parameter when a client wants all validation errors to be returned with a detailed error response for the form field specified. The current form fields are allowed:  * &#x60;password&#x60;  #### Password validation flag Use the &#x60;password&#x60; validation flag to receive details on a possible bad request response &#x60;&#x60;&#x60; ?fullValidationDetails&#x3D;password &#x60;&#x60;&#x60; Without the flag, default behavior will be a normal 400 with only a single validation string error #### Expected Behavior Clients can expect a list of validation error mappings for the validation query field in the details provided on the response: &#x60;&#x60;&#x60; {   \&quot;code\&quot;: 400,   \&quot;message\&quot;: \&quot;Password validation fail\&quot;,   \&quot;status\&quot;: \&quot;INVALID_ARGUMENT\&quot;,   \&quot;details\&quot;: [       {         \&quot;fieldViolationsList\&quot;: [           {\&quot;field\&quot;: \&quot;password\&quot;, \&quot;description\&quot;: \&quot;specialCharacter\&quot;}         ],         &#x27;@type&#x27;: &#x27;type.googleapis.com/google.rpc.BadRequest&#x27;,       },   ], }, &#x60;&#x60;&#x60; (optional)
     * @return Systemuserreturn
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Systemuserreturn systemusersPost(Systemuserputpost body, String xOrgId, String fullValidationDetails) throws ApiException {
        ApiResponse<Systemuserreturn> resp = systemusersPostWithHttpInfo(body, xOrgId, fullValidationDetails);
        return resp.getData();
    }

    /**
     * Create a system user
     * \&quot;This endpoint allows you to create a new system user.  #### Default User State The &#x60;state&#x60; of the user can be explicitly passed in or omitted. If &#x60;state&#x60; is omitted from the request, then the user will get created using the value returned from the [Get an Organization](https://docs.jumpcloud.com/api/1.0/index.html#operation/organizations_get) endpoint. The default user state for manually created users is stored in &#x60;settings.newSystemUserStateDefaults.manualEntry&#x60;  These default state values can be changed in the admin portal settings or by using the [Update an Organization](https://docs.jumpcloud.com/api/1.0/index.html#operation/organization_put) endpoint.  #### Sample Request  &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/systemusers \\ -H &#x27;Accept: application/json&#x27; \\ -H &#x27;Content-Type: application/json&#x27; \\ -H &#x27;x-api-key: {API_KEY}&#x27; \\ -d &#x27;{       \&quot;username\&quot;:\&quot;{username}\&quot;,       \&quot;email\&quot;:\&quot;{email_address}\&quot;,       \&quot;firstname\&quot;:\&quot;{Name}\&quot;,       \&quot;lastname\&quot;:\&quot;{Name}\&quot;     }&#x27; &#x60;&#x60;&#x60;
     * @param body  (optional)
     * @param xOrgId  (optional)
     * @param fullValidationDetails Pass this query parameter when a client wants all validation errors to be returned with a detailed error response for the form field specified. The current form fields are allowed:  * &#x60;password&#x60;  #### Password validation flag Use the &#x60;password&#x60; validation flag to receive details on a possible bad request response &#x60;&#x60;&#x60; ?fullValidationDetails&#x3D;password &#x60;&#x60;&#x60; Without the flag, default behavior will be a normal 400 with only a single validation string error #### Expected Behavior Clients can expect a list of validation error mappings for the validation query field in the details provided on the response: &#x60;&#x60;&#x60; {   \&quot;code\&quot;: 400,   \&quot;message\&quot;: \&quot;Password validation fail\&quot;,   \&quot;status\&quot;: \&quot;INVALID_ARGUMENT\&quot;,   \&quot;details\&quot;: [       {         \&quot;fieldViolationsList\&quot;: [           {\&quot;field\&quot;: \&quot;password\&quot;, \&quot;description\&quot;: \&quot;specialCharacter\&quot;}         ],         &#x27;@type&#x27;: &#x27;type.googleapis.com/google.rpc.BadRequest&#x27;,       },   ], }, &#x60;&#x60;&#x60; (optional)
     * @return ApiResponse&lt;Systemuserreturn&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Systemuserreturn> systemusersPostWithHttpInfo(Systemuserputpost body, String xOrgId, String fullValidationDetails) throws ApiException {
        com.squareup.okhttp.Call call = systemusersPostValidateBeforeCall(body, xOrgId, fullValidationDetails, null, null);
        Type localVarReturnType = new TypeToken<Systemuserreturn>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Create a system user (asynchronously)
     * \&quot;This endpoint allows you to create a new system user.  #### Default User State The &#x60;state&#x60; of the user can be explicitly passed in or omitted. If &#x60;state&#x60; is omitted from the request, then the user will get created using the value returned from the [Get an Organization](https://docs.jumpcloud.com/api/1.0/index.html#operation/organizations_get) endpoint. The default user state for manually created users is stored in &#x60;settings.newSystemUserStateDefaults.manualEntry&#x60;  These default state values can be changed in the admin portal settings or by using the [Update an Organization](https://docs.jumpcloud.com/api/1.0/index.html#operation/organization_put) endpoint.  #### Sample Request  &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/systemusers \\ -H &#x27;Accept: application/json&#x27; \\ -H &#x27;Content-Type: application/json&#x27; \\ -H &#x27;x-api-key: {API_KEY}&#x27; \\ -d &#x27;{       \&quot;username\&quot;:\&quot;{username}\&quot;,       \&quot;email\&quot;:\&quot;{email_address}\&quot;,       \&quot;firstname\&quot;:\&quot;{Name}\&quot;,       \&quot;lastname\&quot;:\&quot;{Name}\&quot;     }&#x27; &#x60;&#x60;&#x60;
     * @param body  (optional)
     * @param xOrgId  (optional)
     * @param fullValidationDetails Pass this query parameter when a client wants all validation errors to be returned with a detailed error response for the form field specified. The current form fields are allowed:  * &#x60;password&#x60;  #### Password validation flag Use the &#x60;password&#x60; validation flag to receive details on a possible bad request response &#x60;&#x60;&#x60; ?fullValidationDetails&#x3D;password &#x60;&#x60;&#x60; Without the flag, default behavior will be a normal 400 with only a single validation string error #### Expected Behavior Clients can expect a list of validation error mappings for the validation query field in the details provided on the response: &#x60;&#x60;&#x60; {   \&quot;code\&quot;: 400,   \&quot;message\&quot;: \&quot;Password validation fail\&quot;,   \&quot;status\&quot;: \&quot;INVALID_ARGUMENT\&quot;,   \&quot;details\&quot;: [       {         \&quot;fieldViolationsList\&quot;: [           {\&quot;field\&quot;: \&quot;password\&quot;, \&quot;description\&quot;: \&quot;specialCharacter\&quot;}         ],         &#x27;@type&#x27;: &#x27;type.googleapis.com/google.rpc.BadRequest&#x27;,       },   ], }, &#x60;&#x60;&#x60; (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systemusersPostAsync(Systemuserputpost body, String xOrgId, String fullValidationDetails, final ApiCallback<Systemuserreturn> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systemusersPostValidateBeforeCall(body, xOrgId, fullValidationDetails, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Systemuserreturn>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systemusersPut
     * @param id  (required)
     * @param body  (optional)
     * @param xOrgId  (optional)
     * @param fullValidationDetails This endpoint can take in a query when a client wants all validation errors to be returned with error response for the form field specified, i.e. &#x27;password&#x27; #### Password validation flag Use the \&quot;password\&quot; validation flag to receive details on a possible bad request response Without the &#x60;password&#x60; flag, default behavior will be a normal 400 with only a validation string message &#x60;&#x60;&#x60; ?fullValidationDetails&#x3D;password &#x60;&#x60;&#x60; #### Expected Behavior Clients can expect a list of validation error mappings for the validation query field in the details provided on the response: &#x60;&#x60;&#x60; {   \&quot;code\&quot;: 400,   \&quot;message\&quot;: \&quot;Password validation fail\&quot;,   \&quot;status\&quot;: \&quot;INVALID_ARGUMENT\&quot;,   \&quot;details\&quot;: [       {         \&quot;fieldViolationsList\&quot;: [{ \&quot;field\&quot;: \&quot;password\&quot;, \&quot;description\&quot;: \&quot;passwordHistory\&quot; }],         &#x27;@type&#x27;: &#x27;type.googleapis.com/google.rpc.BadRequest&#x27;,       },   ], }, &#x60;&#x60;&#x60; (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systemusersPutCall(String id, Systemuserput body, String xOrgId, String fullValidationDetails, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/systemusers/{id}"
            .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (fullValidationDetails != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("fullValidationDetails", fullValidationDetails));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
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
    private com.squareup.okhttp.Call systemusersPutValidateBeforeCall(String id, Systemuserput body, String xOrgId, String fullValidationDetails, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling systemusersPut(Async)");
        }
        
        com.squareup.okhttp.Call call = systemusersPutCall(id, body, xOrgId, fullValidationDetails, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Update a system user
     * This endpoint allows you to update a system user.  #### Sample Request  &#x60;&#x60;&#x60; curl -X PUT https://console.jumpcloud.com/api/systemusers/{UserID} \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{  \&quot;email\&quot;:\&quot;{email_address}\&quot;,  \&quot;firstname\&quot;:\&quot;{Name}\&quot;,  \&quot;lastname\&quot;:\&quot;{Name}\&quot; }&#x27; &#x60;&#x60;&#x60;
     * @param id  (required)
     * @param body  (optional)
     * @param xOrgId  (optional)
     * @param fullValidationDetails This endpoint can take in a query when a client wants all validation errors to be returned with error response for the form field specified, i.e. &#x27;password&#x27; #### Password validation flag Use the \&quot;password\&quot; validation flag to receive details on a possible bad request response Without the &#x60;password&#x60; flag, default behavior will be a normal 400 with only a validation string message &#x60;&#x60;&#x60; ?fullValidationDetails&#x3D;password &#x60;&#x60;&#x60; #### Expected Behavior Clients can expect a list of validation error mappings for the validation query field in the details provided on the response: &#x60;&#x60;&#x60; {   \&quot;code\&quot;: 400,   \&quot;message\&quot;: \&quot;Password validation fail\&quot;,   \&quot;status\&quot;: \&quot;INVALID_ARGUMENT\&quot;,   \&quot;details\&quot;: [       {         \&quot;fieldViolationsList\&quot;: [{ \&quot;field\&quot;: \&quot;password\&quot;, \&quot;description\&quot;: \&quot;passwordHistory\&quot; }],         &#x27;@type&#x27;: &#x27;type.googleapis.com/google.rpc.BadRequest&#x27;,       },   ], }, &#x60;&#x60;&#x60; (optional)
     * @return Systemuserreturn
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Systemuserreturn systemusersPut(String id, Systemuserput body, String xOrgId, String fullValidationDetails) throws ApiException {
        ApiResponse<Systemuserreturn> resp = systemusersPutWithHttpInfo(id, body, xOrgId, fullValidationDetails);
        return resp.getData();
    }

    /**
     * Update a system user
     * This endpoint allows you to update a system user.  #### Sample Request  &#x60;&#x60;&#x60; curl -X PUT https://console.jumpcloud.com/api/systemusers/{UserID} \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{  \&quot;email\&quot;:\&quot;{email_address}\&quot;,  \&quot;firstname\&quot;:\&quot;{Name}\&quot;,  \&quot;lastname\&quot;:\&quot;{Name}\&quot; }&#x27; &#x60;&#x60;&#x60;
     * @param id  (required)
     * @param body  (optional)
     * @param xOrgId  (optional)
     * @param fullValidationDetails This endpoint can take in a query when a client wants all validation errors to be returned with error response for the form field specified, i.e. &#x27;password&#x27; #### Password validation flag Use the \&quot;password\&quot; validation flag to receive details on a possible bad request response Without the &#x60;password&#x60; flag, default behavior will be a normal 400 with only a validation string message &#x60;&#x60;&#x60; ?fullValidationDetails&#x3D;password &#x60;&#x60;&#x60; #### Expected Behavior Clients can expect a list of validation error mappings for the validation query field in the details provided on the response: &#x60;&#x60;&#x60; {   \&quot;code\&quot;: 400,   \&quot;message\&quot;: \&quot;Password validation fail\&quot;,   \&quot;status\&quot;: \&quot;INVALID_ARGUMENT\&quot;,   \&quot;details\&quot;: [       {         \&quot;fieldViolationsList\&quot;: [{ \&quot;field\&quot;: \&quot;password\&quot;, \&quot;description\&quot;: \&quot;passwordHistory\&quot; }],         &#x27;@type&#x27;: &#x27;type.googleapis.com/google.rpc.BadRequest&#x27;,       },   ], }, &#x60;&#x60;&#x60; (optional)
     * @return ApiResponse&lt;Systemuserreturn&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Systemuserreturn> systemusersPutWithHttpInfo(String id, Systemuserput body, String xOrgId, String fullValidationDetails) throws ApiException {
        com.squareup.okhttp.Call call = systemusersPutValidateBeforeCall(id, body, xOrgId, fullValidationDetails, null, null);
        Type localVarReturnType = new TypeToken<Systemuserreturn>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Update a system user (asynchronously)
     * This endpoint allows you to update a system user.  #### Sample Request  &#x60;&#x60;&#x60; curl -X PUT https://console.jumpcloud.com/api/systemusers/{UserID} \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{  \&quot;email\&quot;:\&quot;{email_address}\&quot;,  \&quot;firstname\&quot;:\&quot;{Name}\&quot;,  \&quot;lastname\&quot;:\&quot;{Name}\&quot; }&#x27; &#x60;&#x60;&#x60;
     * @param id  (required)
     * @param body  (optional)
     * @param xOrgId  (optional)
     * @param fullValidationDetails This endpoint can take in a query when a client wants all validation errors to be returned with error response for the form field specified, i.e. &#x27;password&#x27; #### Password validation flag Use the \&quot;password\&quot; validation flag to receive details on a possible bad request response Without the &#x60;password&#x60; flag, default behavior will be a normal 400 with only a validation string message &#x60;&#x60;&#x60; ?fullValidationDetails&#x3D;password &#x60;&#x60;&#x60; #### Expected Behavior Clients can expect a list of validation error mappings for the validation query field in the details provided on the response: &#x60;&#x60;&#x60; {   \&quot;code\&quot;: 400,   \&quot;message\&quot;: \&quot;Password validation fail\&quot;,   \&quot;status\&quot;: \&quot;INVALID_ARGUMENT\&quot;,   \&quot;details\&quot;: [       {         \&quot;fieldViolationsList\&quot;: [{ \&quot;field\&quot;: \&quot;password\&quot;, \&quot;description\&quot;: \&quot;passwordHistory\&quot; }],         &#x27;@type&#x27;: &#x27;type.googleapis.com/google.rpc.BadRequest&#x27;,       },   ], }, &#x60;&#x60;&#x60; (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systemusersPutAsync(String id, Systemuserput body, String xOrgId, String fullValidationDetails, final ApiCallback<Systemuserreturn> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systemusersPutValidateBeforeCall(id, body, xOrgId, fullValidationDetails, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Systemuserreturn>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systemusersResetmfa
     * @param id  (required)
     * @param body  (optional)
     * @param xOrgId  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systemusersResetmfaCall(String id, IdResetmfaBody body, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/systemusers/{id}/resetmfa"
            .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (xOrgId != null)
        localVarHeaderParams.put("x-org-id", apiClient.parameterToString(xOrgId));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json", "text/plain"
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
    private com.squareup.okhttp.Call systemusersResetmfaValidateBeforeCall(String id, IdResetmfaBody body, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling systemusersResetmfa(Async)");
        }
        
        com.squareup.okhttp.Call call = systemusersResetmfaCall(id, body, xOrgId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Reset a system user&#x27;s MFA token
     * This endpoint allows you to reset the TOTP key for a specified system user and put them in an TOTP MFA enrollment period. This will result in the user being prompted to setup TOTP MFA when logging into userportal. Please be aware that if the user does not complete TOTP MFA setup before the &#x60;exclusionUntil&#x60; date, they will be locked out of any resources that require TOTP MFA.  Please refer to our [Knowledge Base Article](https://support.jumpcloud.com/customer/en/portal/articles/2959138-using-multifactor-authentication-with-jumpcloud) on setting up MFA for more information.  #### Sample Request &#x60;&#x60;&#x60; curl -X POST \\   https://console.jumpcloud.com/api/systemusers/{UserID}/resetmfa \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{\&quot;exclusion\&quot;: true, \&quot;exclusionUntil\&quot;: \&quot;{date-time}\&quot;}&#x27;  &#x60;&#x60;&#x60;
     * @param id  (required)
     * @param body  (optional)
     * @param xOrgId  (optional)
     * @return String
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public String systemusersResetmfa(String id, IdResetmfaBody body, String xOrgId) throws ApiException {
        ApiResponse<String> resp = systemusersResetmfaWithHttpInfo(id, body, xOrgId);
        return resp.getData();
    }

    /**
     * Reset a system user&#x27;s MFA token
     * This endpoint allows you to reset the TOTP key for a specified system user and put them in an TOTP MFA enrollment period. This will result in the user being prompted to setup TOTP MFA when logging into userportal. Please be aware that if the user does not complete TOTP MFA setup before the &#x60;exclusionUntil&#x60; date, they will be locked out of any resources that require TOTP MFA.  Please refer to our [Knowledge Base Article](https://support.jumpcloud.com/customer/en/portal/articles/2959138-using-multifactor-authentication-with-jumpcloud) on setting up MFA for more information.  #### Sample Request &#x60;&#x60;&#x60; curl -X POST \\   https://console.jumpcloud.com/api/systemusers/{UserID}/resetmfa \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{\&quot;exclusion\&quot;: true, \&quot;exclusionUntil\&quot;: \&quot;{date-time}\&quot;}&#x27;  &#x60;&#x60;&#x60;
     * @param id  (required)
     * @param body  (optional)
     * @param xOrgId  (optional)
     * @return ApiResponse&lt;String&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<String> systemusersResetmfaWithHttpInfo(String id, IdResetmfaBody body, String xOrgId) throws ApiException {
        com.squareup.okhttp.Call call = systemusersResetmfaValidateBeforeCall(id, body, xOrgId, null, null);
        Type localVarReturnType = new TypeToken<String>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Reset a system user&#x27;s MFA token (asynchronously)
     * This endpoint allows you to reset the TOTP key for a specified system user and put them in an TOTP MFA enrollment period. This will result in the user being prompted to setup TOTP MFA when logging into userportal. Please be aware that if the user does not complete TOTP MFA setup before the &#x60;exclusionUntil&#x60; date, they will be locked out of any resources that require TOTP MFA.  Please refer to our [Knowledge Base Article](https://support.jumpcloud.com/customer/en/portal/articles/2959138-using-multifactor-authentication-with-jumpcloud) on setting up MFA for more information.  #### Sample Request &#x60;&#x60;&#x60; curl -X POST \\   https://console.jumpcloud.com/api/systemusers/{UserID}/resetmfa \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{\&quot;exclusion\&quot;: true, \&quot;exclusionUntil\&quot;: \&quot;{date-time}\&quot;}&#x27;  &#x60;&#x60;&#x60;
     * @param id  (required)
     * @param body  (optional)
     * @param xOrgId  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systemusersResetmfaAsync(String id, IdResetmfaBody body, String xOrgId, final ApiCallback<String> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systemusersResetmfaValidateBeforeCall(id, body, xOrgId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<String>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systemusersStateActivate
     * @param id  (required)
     * @param body  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systemusersStateActivateCall(String id, StateActivateBody body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/systemusers/{id}/state/activate"
            .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

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
    private com.squareup.okhttp.Call systemusersStateActivateValidateBeforeCall(String id, StateActivateBody body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling systemusersStateActivate(Async)");
        }
        
        com.squareup.okhttp.Call call = systemusersStateActivateCall(id, body, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Activate System User
     * This endpoint changes the state of a STAGED user to ACTIVATED. #### Email Flag Use the \&quot;email\&quot; flag to determine whether or not to send a Welcome or Activation email to the newly activated user. Sending an empty body without the &#x60;email&#x60; flag, will send an email with default behavior (see the \&quot;Behavior\&quot; section below) &#x60;&#x60;&#x60; {} &#x60;&#x60;&#x60; Sending &#x60;email&#x3D;true&#x60; flag will send an email with default behavior (see &#x60;Behavior&#x60; below) &#x60;&#x60;&#x60; { \&quot;email\&quot;: true } &#x60;&#x60;&#x60; Populated email will override the default behavior and send to the specified email value &#x60;&#x60;&#x60; { \&quot;email\&quot;: \&quot;example@example.com\&quot; } &#x60;&#x60;&#x60; Sending &#x60;email&#x3D;false&#x60; will suppress sending the email &#x60;&#x60;&#x60; { \&quot;email\&quot;: false } &#x60;&#x60;&#x60; #### Behavior Users with a password will be sent a Welcome email to:   - The address specified in &#x60;email&#x60; flag in the request   - If no &#x60;email&#x60; flag, the user&#x27;s primary email address (default behavior) Users without a password will be sent an Activation email to:   - The address specified in &#x60;email&#x60; flag in the request   - If no &#x60;email&#x60; flag, the user&#x27;s alternate email address (default behavior)   - If no alternate email address, the user&#x27;s primary email address (default behavior)  #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/systemusers/{id}/state/activate \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: &lt;api-key&gt;&#x27; \\   -d &#x27;{ \&quot;email\&quot;: \&quot;alternate-activation-email@email.com\&quot; }&#x27;  &#x60;&#x60;&#x60;
     * @param id  (required)
     * @param body  (optional)
     * @return String
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public String systemusersStateActivate(String id, StateActivateBody body) throws ApiException {
        ApiResponse<String> resp = systemusersStateActivateWithHttpInfo(id, body);
        return resp.getData();
    }

    /**
     * Activate System User
     * This endpoint changes the state of a STAGED user to ACTIVATED. #### Email Flag Use the \&quot;email\&quot; flag to determine whether or not to send a Welcome or Activation email to the newly activated user. Sending an empty body without the &#x60;email&#x60; flag, will send an email with default behavior (see the \&quot;Behavior\&quot; section below) &#x60;&#x60;&#x60; {} &#x60;&#x60;&#x60; Sending &#x60;email&#x3D;true&#x60; flag will send an email with default behavior (see &#x60;Behavior&#x60; below) &#x60;&#x60;&#x60; { \&quot;email\&quot;: true } &#x60;&#x60;&#x60; Populated email will override the default behavior and send to the specified email value &#x60;&#x60;&#x60; { \&quot;email\&quot;: \&quot;example@example.com\&quot; } &#x60;&#x60;&#x60; Sending &#x60;email&#x3D;false&#x60; will suppress sending the email &#x60;&#x60;&#x60; { \&quot;email\&quot;: false } &#x60;&#x60;&#x60; #### Behavior Users with a password will be sent a Welcome email to:   - The address specified in &#x60;email&#x60; flag in the request   - If no &#x60;email&#x60; flag, the user&#x27;s primary email address (default behavior) Users without a password will be sent an Activation email to:   - The address specified in &#x60;email&#x60; flag in the request   - If no &#x60;email&#x60; flag, the user&#x27;s alternate email address (default behavior)   - If no alternate email address, the user&#x27;s primary email address (default behavior)  #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/systemusers/{id}/state/activate \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: &lt;api-key&gt;&#x27; \\   -d &#x27;{ \&quot;email\&quot;: \&quot;alternate-activation-email@email.com\&quot; }&#x27;  &#x60;&#x60;&#x60;
     * @param id  (required)
     * @param body  (optional)
     * @return ApiResponse&lt;String&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<String> systemusersStateActivateWithHttpInfo(String id, StateActivateBody body) throws ApiException {
        com.squareup.okhttp.Call call = systemusersStateActivateValidateBeforeCall(id, body, null, null);
        Type localVarReturnType = new TypeToken<String>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Activate System User (asynchronously)
     * This endpoint changes the state of a STAGED user to ACTIVATED. #### Email Flag Use the \&quot;email\&quot; flag to determine whether or not to send a Welcome or Activation email to the newly activated user. Sending an empty body without the &#x60;email&#x60; flag, will send an email with default behavior (see the \&quot;Behavior\&quot; section below) &#x60;&#x60;&#x60; {} &#x60;&#x60;&#x60; Sending &#x60;email&#x3D;true&#x60; flag will send an email with default behavior (see &#x60;Behavior&#x60; below) &#x60;&#x60;&#x60; { \&quot;email\&quot;: true } &#x60;&#x60;&#x60; Populated email will override the default behavior and send to the specified email value &#x60;&#x60;&#x60; { \&quot;email\&quot;: \&quot;example@example.com\&quot; } &#x60;&#x60;&#x60; Sending &#x60;email&#x3D;false&#x60; will suppress sending the email &#x60;&#x60;&#x60; { \&quot;email\&quot;: false } &#x60;&#x60;&#x60; #### Behavior Users with a password will be sent a Welcome email to:   - The address specified in &#x60;email&#x60; flag in the request   - If no &#x60;email&#x60; flag, the user&#x27;s primary email address (default behavior) Users without a password will be sent an Activation email to:   - The address specified in &#x60;email&#x60; flag in the request   - If no &#x60;email&#x60; flag, the user&#x27;s alternate email address (default behavior)   - If no alternate email address, the user&#x27;s primary email address (default behavior)  #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/systemusers/{id}/state/activate \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: &lt;api-key&gt;&#x27; \\   -d &#x27;{ \&quot;email\&quot;: \&quot;alternate-activation-email@email.com\&quot; }&#x27;  &#x60;&#x60;&#x60;
     * @param id  (required)
     * @param body  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systemusersStateActivateAsync(String id, StateActivateBody body, final ApiCallback<String> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systemusersStateActivateValidateBeforeCall(id, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<String>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systemusersUnlock
     * @param id  (required)
     * @param xOrgId  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systemusersUnlockCall(String id, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systemusers/{id}/unlock"
            .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (xOrgId != null)
        localVarHeaderParams.put("x-org-id", apiClient.parameterToString(xOrgId));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json", "text/plain"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
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
    private com.squareup.okhttp.Call systemusersUnlockValidateBeforeCall(String id, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling systemusersUnlock(Async)");
        }
        
        com.squareup.okhttp.Call call = systemusersUnlockCall(id, xOrgId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Unlock a system user
     * This endpoint allows you to unlock a user&#x27;s account.
     * @param id  (required)
     * @param xOrgId  (optional)
     * @return String
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public String systemusersUnlock(String id, String xOrgId) throws ApiException {
        ApiResponse<String> resp = systemusersUnlockWithHttpInfo(id, xOrgId);
        return resp.getData();
    }

    /**
     * Unlock a system user
     * This endpoint allows you to unlock a user&#x27;s account.
     * @param id  (required)
     * @param xOrgId  (optional)
     * @return ApiResponse&lt;String&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<String> systemusersUnlockWithHttpInfo(String id, String xOrgId) throws ApiException {
        com.squareup.okhttp.Call call = systemusersUnlockValidateBeforeCall(id, xOrgId, null, null);
        Type localVarReturnType = new TypeToken<String>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Unlock a system user (asynchronously)
     * This endpoint allows you to unlock a user&#x27;s account.
     * @param id  (required)
     * @param xOrgId  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systemusersUnlockAsync(String id, String xOrgId, final ApiCallback<String> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systemusersUnlockValidateBeforeCall(id, xOrgId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<String>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
