/*
 * JumpCloud API
 * # Overview  JumpCloud's V2 API. This set of endpoints allows JumpCloud customers to manage objects, groupings and mappings and interact with the JumpCloud Graph.  # Directory Objects  This API offers the ability to interact with some of our core features; otherwise known as Directory Objects. The Directory Objects are:  * Commands * Policies * Policy Groups * Applications * Systems * Users * User Groups * System Groups * Radius Servers * Directories: Office 365, LDAP,G-Suite, Active Directory * Duo accounts and applications.  The Directory Object is an important concept to understand in order to successfully use JumpCloud API.  ## JumpCloud Graph  We've also introduced the concept of the JumpCloud Graph along with  Directory Objects. The Graph is a powerful aspect of our platform which will enable you to associate objects with each other, or establish membership for certain objects to become members of other objects.  Specific `GET` endpoints will allow you to traverse the JumpCloud Graph to return all indirect and directly bound objects in your organization.  | ![alt text](https://s3.amazonaws.com/jumpcloud-kb/Knowledge+Base+Photos/API+Docs/jumpcloud_graph.png \"JumpCloud Graph Model Example\") | |:--:| | **This diagram highlights our association and membership model as it relates to Directory Objects.** |  # API Key  ## Access Your API Key  To locate your API Key:  1. Log into the [JumpCloud Admin Console](https://console.jumpcloud.com/). 2. Go to the username drop down located in the top-right of the Console. 3. Retrieve your API key from API Settings.  ## API Key Considerations  This API key is associated to the currently logged in administrator. Other admins will have different API keys.  **WARNING** Please keep this API key secret, as it grants full access to any data accessible via your JumpCloud console account.  You can also reset your API key in the same location in the JumpCloud Admin Console.  ## Recycling or Resetting Your API Key  In order to revoke access with the current API key, simply reset your API key. This will render all calls using the previous API key inaccessible.  Your API key will be passed in as a header with the header name \"x-api-key\".  ```bash curl -H \"x-api-key: [YOUR_API_KEY_HERE]\" \"https://console.jumpcloud.com/api/v2/systemgroups\" ```  # System Context  * [Introduction](#introduction) * [Supported endpoints](#supported-endpoints) * [Response codes](#response-codes) * [Authentication](#authentication) * [Additional examples](#additional-examples) * [Third party](#third-party)  ## Introduction  JumpCloud System Context Authorization is an alternative way to authenticate with a subset of JumpCloud's REST APIs. Using this method, a system can manage its information and resource associations, allowing modern auto provisioning environments to scale as needed.  **Notes:**   * The following documentation applies to Linux Operating Systems only.  * Systems that have been automatically enrolled using Apple's Device Enrollment Program (DEP) or systems enrolled using the User Portal install are not eligible to use the System Context API to prevent unauthorized access to system groups and resources. If a script that utilizes the System Context API is invoked on a system enrolled in this way, it will display an error.  ## Supported Endpoints  JumpCloud System Context Authorization can be used in conjunction with Systems endpoints found in the V1 API and certain System Group endpoints found in the v2 API.  * A system may fetch, alter, and delete metadata about itself, including manipulating a system's Group and Systemuser associations,   * `/api/systems/{system_id}` | [`GET`](https://docs.jumpcloud.com/api/1.0/index.html#operation/systems_get) [`PUT`](https://docs.jumpcloud.com/api/1.0/index.html#operation/systems_put) * A system may delete itself from your JumpCloud organization   * `/api/systems/{system_id}` | [`DELETE`](https://docs.jumpcloud.com/api/1.0/index.html#operation/systems_delete) * A system may fetch its direct resource associations under v2 (Groups)   * `/api/v2/systems/{system_id}/memberof` | [`GET`](https://docs.jumpcloud.com/api/2.0/index.html#operation/graph_systemGroupMembership)   * `/api/v2/systems/{system_id}/associations` | [`GET`](https://docs.jumpcloud.com/api/2.0/index.html#operation/graph_systemAssociationsList)   * `/api/v2/systems/{system_id}/users` | [`GET`](https://docs.jumpcloud.com/api/2.0/index.html#operation/graph_systemTraverseUser) * A system may alter its direct resource associations under v2 (Groups)   * `/api/v2/systems/{system_id}/associations` | [`POST`](https://docs.jumpcloud.com/api/2.0/index.html#operation/graph_systemAssociationsPost) * A system may alter its System Group associations   * `/api/v2/systemgroups/{group_id}/members` | [`POST`](https://docs.jumpcloud.com/api/2.0/index.html#operation/graph_systemGroupMembersPost)     * _NOTE_ If a system attempts to alter the system group membership of a different system the request will be rejected  ## Response Codes  If endpoints other than those described above are called using the System Context API, the server will return a `401` response.  ## Authentication  To allow for secure access to our APIs, you must authenticate each API request. JumpCloud System Context Authorization uses [HTTP Signatures](https://tools.ietf.org/html/draft-cavage-http-signatures-00) to authenticate API requests. The HTTP Signatures sent with each request are similar to the signatures used by the Amazon Web Services REST API. To help with the request-signing process, we have provided an [example bash script](https://github.com/TheJumpCloud/SystemContextAPI/blob/master/examples/shell/SigningExample.sh). This example API request simply requests the entire system record. You must be root, or have permissions to access the contents of the `/opt/jc` directory to generate a signature.  Here is a breakdown of the example script with explanations.  First, the script extracts the systemKey from the JSON formatted `/opt/jc/jcagent.conf` file.  ```bash #!/bin/bash conf=\"`cat /opt/jc/jcagent.conf`\" regex=\"systemKey\\\":\\\"(\\w+)\\\"\"  if [[ $conf =~ $regex ]] ; then   systemKey=\"${BASH_REMATCH[1]}\" fi ```  Then, the script retrieves the current date in the correct format.  ```bash now=`date -u \"+%a, %d %h %Y %H:%M:%S GMT\"`; ```  Next, we build a signing string to demonstrate the expected signature format. The signed string must consist of the [request-line](https://tools.ietf.org/html/rfc2616#page-35) and the date header, separated by a newline character.  ```bash signstr=\"GET /api/systems/${systemKey} HTTP/1.1\\ndate: ${now}\" ```  The next step is to calculate and apply the signature. This is a two-step process:  1. Create a signature from the signing string using the JumpCloud Agent private key: ``printf \"$signstr\" | openssl dgst -sha256 -sign /opt/jc/client.key`` 2. Then Base64-encode the signature string and trim off the newline characters: ``| openssl enc -e -a | tr -d '\\n'``  The combined steps above result in:  ```bash signature=`printf \"$signstr\" | openssl dgst -sha256 -sign /opt/jc/client.key | openssl enc -e -a | tr -d '\\n'` ; ```  Finally, we make sure the API call sending the signature has the same Authorization and Date header values, HTTP method, and URL that were used in the signing string.  ```bash curl -iq \\   -H \"Accept: application/json\" \\   -H \"Content-Type: application/json\" \\   -H \"Date: ${now}\" \\   -H \"Authorization: Signature keyId=\\\"system/${systemKey}\\\",headers=\\\"request-line date\\\",algorithm=\\\"rsa-sha256\\\",signature=\\\"${signature}\\\"\" \\   --url https://console.jumpcloud.com/api/systems/${systemKey} ```  ### Input Data  All PUT and POST methods should use the HTTP Content-Type header with a value of 'application/json'. PUT methods are used for updating a record. POST methods are used to create a record.  The following example demonstrates how to update the `displayName` of the system.  ```bash signstr=\"PUT /api/systems/${systemKey} HTTP/1.1\\ndate: ${now}\" signature=`printf \"$signstr\" | openssl dgst -sha256 -sign /opt/jc/client.key | openssl enc -e -a | tr -d '\\n'` ;  curl -iq \\   -d \"{\\\"displayName\\\" : \\\"updated-system-name-1\\\"}\" \\   -X \"PUT\" \\   -H \"Content-Type: application/json\" \\   -H \"Accept: application/json\" \\   -H \"Date: ${now}\" \\   -H \"Authorization: Signature keyId=\\\"system/${systemKey}\\\",headers=\\\"request-line date\\\",algorithm=\\\"rsa-sha256\\\",signature=\\\"${signature}\\\"\" \\   --url https://console.jumpcloud.com/api/systems/${systemKey} ```  ### Output Data  All results will be formatted as JSON.  Here is an abbreviated example of response output:  ```json {   \"_id\": \"525ee96f52e144993e000015\",   \"agentServer\": \"lappy386\",   \"agentVersion\": \"0.9.42\",   \"arch\": \"x86_64\",   \"connectionKey\": \"127.0.0.1_51812\",   \"displayName\": \"ubuntu-1204\",   \"firstContact\": \"2013-10-16T19:30:55.611Z\",   \"hostname\": \"ubuntu-1204\"   ... ```  ## Additional Examples  ### Signing Authentication Example  This example demonstrates how to make an authenticated request to fetch the JumpCloud record for this system.  [SigningExample.sh](https://github.com/TheJumpCloud/SystemContextAPI/blob/master/examples/shell/SigningExample.sh)  ### Shutdown Hook  This example demonstrates how to make an authenticated request on system shutdown. Using an init.d script registered at run level 0, you can call the System Context API as the system is shutting down.  [Instance-shutdown-initd](https://github.com/TheJumpCloud/SystemContextAPI/blob/master/examples/instance-shutdown-initd) is an example of an init.d script that only runs at system shutdown.  After customizing the [instance-shutdown-initd](https://github.com/TheJumpCloud/SystemContextAPI/blob/master/examples/instance-shutdown-initd) script, you should install it on the system(s) running the JumpCloud agent.  1. Copy the modified [instance-shutdown-initd](https://github.com/TheJumpCloud/SystemContextAPI/blob/master/examples/instance-shutdown-initd) to `/etc/init.d/instance-shutdown`. 2. On Ubuntu systems, run `update-rc.d instance-shutdown defaults`. On RedHat/CentOS systems, run `chkconfig --add instance-shutdown`.  ## Third Party  ### Chef Cookbooks  [https://github.com/nshenry03/jumpcloud](https://github.com/nshenry03/jumpcloud)  [https://github.com/cjs226/jumpcloud](https://github.com/cjs226/jumpcloud)  # Multi-Tenant Portal Headers  Multi-Tenant Organization API Headers are available for JumpCloud Admins to use when making API requests from Organizations that have multiple managed organizations.  The `x-org-id` is a required header for all multi-tenant admins when making API requests to JumpCloud. This header will define to which organization you would like to make the request.  **NOTE** Single Tenant Admins do not need to provide this header when making an API request.  ## Header Value  `x-org-id`  ## API Response Codes  * `400` Malformed ID. * `400` x-org-id and Organization path ID do not match. * `401` ID not included for multi-tenant admin * `403` ID included on unsupported route. * `404` Organization ID Not Found.  ```bash curl -X GET https://console.jumpcloud.com/api/v2/directories \\   -H 'accept: application/json' \\   -H 'content-type: application/json' \\   -H 'x-api-key: {API_KEY}' \\   -H 'x-org-id: {ORG_ID}'  ```  ## To Obtain an Individual Organization ID via the UI  As a prerequisite, your Primary Organization will need to be setup for Multi-Tenancy. This provides access to the Multi-Tenant Organization Admin Portal.  1. Log into JumpCloud [Admin Console](https://console.jumpcloud.com). If you are a multi-tenant Admin, you will automatically be routed to the Multi-Tenant Admin Portal. 2. From the Multi-Tenant Portal's primary navigation bar, select the Organization you'd like to access. 3. You will automatically be routed to that Organization's Admin Console. 4. Go to Settings in the sub-tenant's primary navigation. 5. You can obtain your Organization ID below your Organization's Contact Information on the Settings page.  ## To Obtain All Organization IDs via the API  * You can make an API request to this endpoint using the API key of your Primary Organization.  `https://console.jumpcloud.com/api/organizations/` This will return all your managed organizations.  ```bash curl -X GET \\   https://console.jumpcloud.com/api/organizations/ \\   -H 'Accept: application/json' \\   -H 'Content-Type: application/json' \\   -H 'x-api-key: {API_KEY}' ```  # SDKs  You can find language specific SDKs that can help you kickstart your Integration with JumpCloud in the following GitHub repositories:  * [Python](https://github.com/TheJumpCloud/jcapi-python) * [Go](https://github.com/TheJumpCloud/jcapi-go) * [Ruby](https://github.com/TheJumpCloud/jcapi-ruby) * [Java](https://github.com/TheJumpCloud/jcapi-java) 
 *
 * OpenAPI spec version: 2.0
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


import io.swagger.client.model.DuoAccount;
import io.swagger.client.model.DuoApplication;
import io.swagger.client.model.DuoApplicationReq;
import io.swagger.client.model.DuoApplicationUpdateReq;
import io.swagger.client.model.Error;
import io.swagger.client.model.ErrorDetails;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuoApi {
    private ApiClient apiClient;

    public DuoApi() {
        this(Configuration.getDefaultApiClient());
    }

    public DuoApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for duoAccountDelete
     * @param id ObjectID of the Duo Account (required)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call duoAccountDeleteCall(String id, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/duo/accounts/{id}"
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
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call duoAccountDeleteValidateBeforeCall(String id, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling duoAccountDelete(Async)");
        }
        
        com.squareup.okhttp.Call call = duoAccountDeleteCall(id, xOrgId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Delete a Duo Account
     * Removes the specified Duo account, an error will be returned if the account has some Duo application used in a protected resource.  #### Sample Request &#x60;&#x60;&#x60; curl -X DELETE https://console.jumpcloud.com/api/v2/duo/accounts/{id} \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     * @param id ObjectID of the Duo Account (required)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @return DuoAccount
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DuoAccount duoAccountDelete(String id, String xOrgId) throws ApiException {
        ApiResponse<DuoAccount> resp = duoAccountDeleteWithHttpInfo(id, xOrgId);
        return resp.getData();
    }

    /**
     * Delete a Duo Account
     * Removes the specified Duo account, an error will be returned if the account has some Duo application used in a protected resource.  #### Sample Request &#x60;&#x60;&#x60; curl -X DELETE https://console.jumpcloud.com/api/v2/duo/accounts/{id} \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     * @param id ObjectID of the Duo Account (required)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @return ApiResponse&lt;DuoAccount&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<DuoAccount> duoAccountDeleteWithHttpInfo(String id, String xOrgId) throws ApiException {
        com.squareup.okhttp.Call call = duoAccountDeleteValidateBeforeCall(id, xOrgId, null, null);
        Type localVarReturnType = new TypeToken<DuoAccount>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Delete a Duo Account (asynchronously)
     * Removes the specified Duo account, an error will be returned if the account has some Duo application used in a protected resource.  #### Sample Request &#x60;&#x60;&#x60; curl -X DELETE https://console.jumpcloud.com/api/v2/duo/accounts/{id} \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     * @param id ObjectID of the Duo Account (required)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call duoAccountDeleteAsync(String id, String xOrgId, final ApiCallback<DuoAccount> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = duoAccountDeleteValidateBeforeCall(id, xOrgId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DuoAccount>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for duoAccountGet
     * @param id ObjectID of the Duo Account (required)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call duoAccountGetCall(String id, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/duo/accounts/{id}"
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
    private com.squareup.okhttp.Call duoAccountGetValidateBeforeCall(String id, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling duoAccountGet(Async)");
        }
        
        com.squareup.okhttp.Call call = duoAccountGetCall(id, xOrgId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get a Duo Acount
     * This endpoint returns a specific Duo account.  #### Sample Request &#x60;&#x60;&#x60; curl https://console.jumpcloud.com/api/v2/duo/accounts/{id} \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     * @param id ObjectID of the Duo Account (required)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @return DuoAccount
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DuoAccount duoAccountGet(String id, String xOrgId) throws ApiException {
        ApiResponse<DuoAccount> resp = duoAccountGetWithHttpInfo(id, xOrgId);
        return resp.getData();
    }

    /**
     * Get a Duo Acount
     * This endpoint returns a specific Duo account.  #### Sample Request &#x60;&#x60;&#x60; curl https://console.jumpcloud.com/api/v2/duo/accounts/{id} \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     * @param id ObjectID of the Duo Account (required)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @return ApiResponse&lt;DuoAccount&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<DuoAccount> duoAccountGetWithHttpInfo(String id, String xOrgId) throws ApiException {
        com.squareup.okhttp.Call call = duoAccountGetValidateBeforeCall(id, xOrgId, null, null);
        Type localVarReturnType = new TypeToken<DuoAccount>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get a Duo Acount (asynchronously)
     * This endpoint returns a specific Duo account.  #### Sample Request &#x60;&#x60;&#x60; curl https://console.jumpcloud.com/api/v2/duo/accounts/{id} \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     * @param id ObjectID of the Duo Account (required)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call duoAccountGetAsync(String id, String xOrgId, final ApiCallback<DuoAccount> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = duoAccountGetValidateBeforeCall(id, xOrgId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DuoAccount>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for duoAccountList
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call duoAccountListCall(String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/duo/accounts";

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
    private com.squareup.okhttp.Call duoAccountListValidateBeforeCall(String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = duoAccountListCall(xOrgId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List Duo Accounts
     * This endpoint returns all the Duo accounts for your organization. Note: There can currently only be one Duo account for your organization.  #### Sample Request &#x60;&#x60;&#x60; curl https://console.jumpcloud.com/api/v2/duo/accounts \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @return List&lt;DuoAccount&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<DuoAccount> duoAccountList(String xOrgId) throws ApiException {
        ApiResponse<List<DuoAccount>> resp = duoAccountListWithHttpInfo(xOrgId);
        return resp.getData();
    }

    /**
     * List Duo Accounts
     * This endpoint returns all the Duo accounts for your organization. Note: There can currently only be one Duo account for your organization.  #### Sample Request &#x60;&#x60;&#x60; curl https://console.jumpcloud.com/api/v2/duo/accounts \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @return ApiResponse&lt;List&lt;DuoAccount&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<DuoAccount>> duoAccountListWithHttpInfo(String xOrgId) throws ApiException {
        com.squareup.okhttp.Call call = duoAccountListValidateBeforeCall(xOrgId, null, null);
        Type localVarReturnType = new TypeToken<List<DuoAccount>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List Duo Accounts (asynchronously)
     * This endpoint returns all the Duo accounts for your organization. Note: There can currently only be one Duo account for your organization.  #### Sample Request &#x60;&#x60;&#x60; curl https://console.jumpcloud.com/api/v2/duo/accounts \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call duoAccountListAsync(String xOrgId, final ApiCallback<List<DuoAccount>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = duoAccountListValidateBeforeCall(xOrgId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<DuoAccount>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for duoAccountPost
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call duoAccountPostCall(String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/duo/accounts";

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
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call duoAccountPostValidateBeforeCall(String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = duoAccountPostCall(xOrgId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Create Duo Account
     * Registers a Duo account for an organization. Only one Duo account will be allowed, in case an organization has a Duo account already a 409 (Conflict) code will be returned.  #### Sample Request &#x60;&#x60;&#x60;   curl -X POST https://console.jumpcloud.com/api/v2/duo/accounts \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{}&#x27; &#x60;&#x60;&#x60;
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @return DuoAccount
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DuoAccount duoAccountPost(String xOrgId) throws ApiException {
        ApiResponse<DuoAccount> resp = duoAccountPostWithHttpInfo(xOrgId);
        return resp.getData();
    }

    /**
     * Create Duo Account
     * Registers a Duo account for an organization. Only one Duo account will be allowed, in case an organization has a Duo account already a 409 (Conflict) code will be returned.  #### Sample Request &#x60;&#x60;&#x60;   curl -X POST https://console.jumpcloud.com/api/v2/duo/accounts \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{}&#x27; &#x60;&#x60;&#x60;
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @return ApiResponse&lt;DuoAccount&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<DuoAccount> duoAccountPostWithHttpInfo(String xOrgId) throws ApiException {
        com.squareup.okhttp.Call call = duoAccountPostValidateBeforeCall(xOrgId, null, null);
        Type localVarReturnType = new TypeToken<DuoAccount>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Create Duo Account (asynchronously)
     * Registers a Duo account for an organization. Only one Duo account will be allowed, in case an organization has a Duo account already a 409 (Conflict) code will be returned.  #### Sample Request &#x60;&#x60;&#x60;   curl -X POST https://console.jumpcloud.com/api/v2/duo/accounts \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{}&#x27; &#x60;&#x60;&#x60;
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call duoAccountPostAsync(String xOrgId, final ApiCallback<DuoAccount> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = duoAccountPostValidateBeforeCall(xOrgId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DuoAccount>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for duoApplicationDelete
     * @param accountId  (required)
     * @param applicationId  (required)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call duoApplicationDeleteCall(String accountId, String applicationId, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/duo/accounts/{account_id}/applications/{application_id}"
            .replaceAll("\\{" + "account_id" + "\\}", apiClient.escapeString(accountId.toString()))
            .replaceAll("\\{" + "application_id" + "\\}", apiClient.escapeString(applicationId.toString()));

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
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call duoApplicationDeleteValidateBeforeCall(String accountId, String applicationId, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'accountId' is set
        if (accountId == null) {
            throw new ApiException("Missing the required parameter 'accountId' when calling duoApplicationDelete(Async)");
        }
        // verify the required parameter 'applicationId' is set
        if (applicationId == null) {
            throw new ApiException("Missing the required parameter 'applicationId' when calling duoApplicationDelete(Async)");
        }
        
        com.squareup.okhttp.Call call = duoApplicationDeleteCall(accountId, applicationId, xOrgId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Delete a Duo Application
     * Deletes the specified Duo application, an error will be returned if the application is used in a protected resource.  #### Sample Request &#x60;&#x60;&#x60;   curl -X DELETE https://console.jumpcloud.com/api/v2/duo/accounts/{ACCOUNT_ID}/applications/{APPLICATION_ID} \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27;&#x27; &#x60;&#x60;&#x60;
     * @param accountId  (required)
     * @param applicationId  (required)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @return DuoApplication
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DuoApplication duoApplicationDelete(String accountId, String applicationId, String xOrgId) throws ApiException {
        ApiResponse<DuoApplication> resp = duoApplicationDeleteWithHttpInfo(accountId, applicationId, xOrgId);
        return resp.getData();
    }

    /**
     * Delete a Duo Application
     * Deletes the specified Duo application, an error will be returned if the application is used in a protected resource.  #### Sample Request &#x60;&#x60;&#x60;   curl -X DELETE https://console.jumpcloud.com/api/v2/duo/accounts/{ACCOUNT_ID}/applications/{APPLICATION_ID} \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27;&#x27; &#x60;&#x60;&#x60;
     * @param accountId  (required)
     * @param applicationId  (required)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @return ApiResponse&lt;DuoApplication&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<DuoApplication> duoApplicationDeleteWithHttpInfo(String accountId, String applicationId, String xOrgId) throws ApiException {
        com.squareup.okhttp.Call call = duoApplicationDeleteValidateBeforeCall(accountId, applicationId, xOrgId, null, null);
        Type localVarReturnType = new TypeToken<DuoApplication>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Delete a Duo Application (asynchronously)
     * Deletes the specified Duo application, an error will be returned if the application is used in a protected resource.  #### Sample Request &#x60;&#x60;&#x60;   curl -X DELETE https://console.jumpcloud.com/api/v2/duo/accounts/{ACCOUNT_ID}/applications/{APPLICATION_ID} \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27;&#x27; &#x60;&#x60;&#x60;
     * @param accountId  (required)
     * @param applicationId  (required)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call duoApplicationDeleteAsync(String accountId, String applicationId, String xOrgId, final ApiCallback<DuoApplication> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = duoApplicationDeleteValidateBeforeCall(accountId, applicationId, xOrgId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DuoApplication>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for duoApplicationGet
     * @param accountId  (required)
     * @param applicationId  (required)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call duoApplicationGetCall(String accountId, String applicationId, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/duo/accounts/{account_id}/applications/{application_id}"
            .replaceAll("\\{" + "account_id" + "\\}", apiClient.escapeString(accountId.toString()))
            .replaceAll("\\{" + "application_id" + "\\}", apiClient.escapeString(applicationId.toString()));

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
    private com.squareup.okhttp.Call duoApplicationGetValidateBeforeCall(String accountId, String applicationId, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'accountId' is set
        if (accountId == null) {
            throw new ApiException("Missing the required parameter 'accountId' when calling duoApplicationGet(Async)");
        }
        // verify the required parameter 'applicationId' is set
        if (applicationId == null) {
            throw new ApiException("Missing the required parameter 'applicationId' when calling duoApplicationGet(Async)");
        }
        
        com.squareup.okhttp.Call call = duoApplicationGetCall(accountId, applicationId, xOrgId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get a Duo application
     * This endpoint returns a specific Duo application that is associated with the specified Duo account.  #### Sample Request &#x60;&#x60;&#x60;   curl https://console.jumpcloud.com/api/v2/duo/accounts/{ACCOUNT_ID}/applications/{APPLICATION_ID} \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     * @param accountId  (required)
     * @param applicationId  (required)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @return DuoApplication
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DuoApplication duoApplicationGet(String accountId, String applicationId, String xOrgId) throws ApiException {
        ApiResponse<DuoApplication> resp = duoApplicationGetWithHttpInfo(accountId, applicationId, xOrgId);
        return resp.getData();
    }

    /**
     * Get a Duo application
     * This endpoint returns a specific Duo application that is associated with the specified Duo account.  #### Sample Request &#x60;&#x60;&#x60;   curl https://console.jumpcloud.com/api/v2/duo/accounts/{ACCOUNT_ID}/applications/{APPLICATION_ID} \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     * @param accountId  (required)
     * @param applicationId  (required)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @return ApiResponse&lt;DuoApplication&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<DuoApplication> duoApplicationGetWithHttpInfo(String accountId, String applicationId, String xOrgId) throws ApiException {
        com.squareup.okhttp.Call call = duoApplicationGetValidateBeforeCall(accountId, applicationId, xOrgId, null, null);
        Type localVarReturnType = new TypeToken<DuoApplication>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get a Duo application (asynchronously)
     * This endpoint returns a specific Duo application that is associated with the specified Duo account.  #### Sample Request &#x60;&#x60;&#x60;   curl https://console.jumpcloud.com/api/v2/duo/accounts/{ACCOUNT_ID}/applications/{APPLICATION_ID} \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     * @param accountId  (required)
     * @param applicationId  (required)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call duoApplicationGetAsync(String accountId, String applicationId, String xOrgId, final ApiCallback<DuoApplication> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = duoApplicationGetValidateBeforeCall(accountId, applicationId, xOrgId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DuoApplication>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for duoApplicationList
     * @param accountId  (required)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call duoApplicationListCall(String accountId, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/duo/accounts/{account_id}/applications"
            .replaceAll("\\{" + "account_id" + "\\}", apiClient.escapeString(accountId.toString()));

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
    private com.squareup.okhttp.Call duoApplicationListValidateBeforeCall(String accountId, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'accountId' is set
        if (accountId == null) {
            throw new ApiException("Missing the required parameter 'accountId' when calling duoApplicationList(Async)");
        }
        
        com.squareup.okhttp.Call call = duoApplicationListCall(accountId, xOrgId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List Duo Applications
     * This endpoint returns all the Duo applications for the specified Duo account. Note: There can currently only be one Duo application for your organization.  #### Sample Request &#x60;&#x60;&#x60;   curl https://console.jumpcloud.com/api/v2/duo/accounts/{ACCOUNT_ID}/applications \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     * @param accountId  (required)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @return List&lt;DuoApplication&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<DuoApplication> duoApplicationList(String accountId, String xOrgId) throws ApiException {
        ApiResponse<List<DuoApplication>> resp = duoApplicationListWithHttpInfo(accountId, xOrgId);
        return resp.getData();
    }

    /**
     * List Duo Applications
     * This endpoint returns all the Duo applications for the specified Duo account. Note: There can currently only be one Duo application for your organization.  #### Sample Request &#x60;&#x60;&#x60;   curl https://console.jumpcloud.com/api/v2/duo/accounts/{ACCOUNT_ID}/applications \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     * @param accountId  (required)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @return ApiResponse&lt;List&lt;DuoApplication&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<DuoApplication>> duoApplicationListWithHttpInfo(String accountId, String xOrgId) throws ApiException {
        com.squareup.okhttp.Call call = duoApplicationListValidateBeforeCall(accountId, xOrgId, null, null);
        Type localVarReturnType = new TypeToken<List<DuoApplication>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List Duo Applications (asynchronously)
     * This endpoint returns all the Duo applications for the specified Duo account. Note: There can currently only be one Duo application for your organization.  #### Sample Request &#x60;&#x60;&#x60;   curl https://console.jumpcloud.com/api/v2/duo/accounts/{ACCOUNT_ID}/applications \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;
     * @param accountId  (required)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call duoApplicationListAsync(String accountId, String xOrgId, final ApiCallback<List<DuoApplication>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = duoApplicationListValidateBeforeCall(accountId, xOrgId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<DuoApplication>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for duoApplicationPost
     * @param accountId  (required)
     * @param body  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call duoApplicationPostCall(String accountId, DuoApplicationReq body, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/duo/accounts/{account_id}/applications"
            .replaceAll("\\{" + "account_id" + "\\}", apiClient.escapeString(accountId.toString()));

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
    private com.squareup.okhttp.Call duoApplicationPostValidateBeforeCall(String accountId, DuoApplicationReq body, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'accountId' is set
        if (accountId == null) {
            throw new ApiException("Missing the required parameter 'accountId' when calling duoApplicationPost(Async)");
        }
        
        com.squareup.okhttp.Call call = duoApplicationPostCall(accountId, body, xOrgId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Create Duo Application
     * Creates a Duo application for your organization and the specified account.  #### Sample Request &#x60;&#x60;&#x60;   curl -X POST https://console.jumpcloud.com/api/v2/duo/accounts/{ACCOUNT_ID}/applications \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{     \&quot;name\&quot;: \&quot;Application Name\&quot;,     \&quot;apiHost\&quot;: \&quot;api-1234.duosecurity.com\&quot;,     \&quot;integrationKey\&quot;: \&quot;1234\&quot;,     \&quot;secretKey\&quot;: \&quot;5678\&quot;   }&#x27; &#x60;&#x60;&#x60;
     * @param accountId  (required)
     * @param body  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @return DuoApplication
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DuoApplication duoApplicationPost(String accountId, DuoApplicationReq body, String xOrgId) throws ApiException {
        ApiResponse<DuoApplication> resp = duoApplicationPostWithHttpInfo(accountId, body, xOrgId);
        return resp.getData();
    }

    /**
     * Create Duo Application
     * Creates a Duo application for your organization and the specified account.  #### Sample Request &#x60;&#x60;&#x60;   curl -X POST https://console.jumpcloud.com/api/v2/duo/accounts/{ACCOUNT_ID}/applications \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{     \&quot;name\&quot;: \&quot;Application Name\&quot;,     \&quot;apiHost\&quot;: \&quot;api-1234.duosecurity.com\&quot;,     \&quot;integrationKey\&quot;: \&quot;1234\&quot;,     \&quot;secretKey\&quot;: \&quot;5678\&quot;   }&#x27; &#x60;&#x60;&#x60;
     * @param accountId  (required)
     * @param body  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @return ApiResponse&lt;DuoApplication&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<DuoApplication> duoApplicationPostWithHttpInfo(String accountId, DuoApplicationReq body, String xOrgId) throws ApiException {
        com.squareup.okhttp.Call call = duoApplicationPostValidateBeforeCall(accountId, body, xOrgId, null, null);
        Type localVarReturnType = new TypeToken<DuoApplication>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Create Duo Application (asynchronously)
     * Creates a Duo application for your organization and the specified account.  #### Sample Request &#x60;&#x60;&#x60;   curl -X POST https://console.jumpcloud.com/api/v2/duo/accounts/{ACCOUNT_ID}/applications \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{     \&quot;name\&quot;: \&quot;Application Name\&quot;,     \&quot;apiHost\&quot;: \&quot;api-1234.duosecurity.com\&quot;,     \&quot;integrationKey\&quot;: \&quot;1234\&quot;,     \&quot;secretKey\&quot;: \&quot;5678\&quot;   }&#x27; &#x60;&#x60;&#x60;
     * @param accountId  (required)
     * @param body  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call duoApplicationPostAsync(String accountId, DuoApplicationReq body, String xOrgId, final ApiCallback<DuoApplication> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = duoApplicationPostValidateBeforeCall(accountId, body, xOrgId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DuoApplication>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for duoApplicationUpdate
     * @param accountId  (required)
     * @param applicationId  (required)
     * @param body  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call duoApplicationUpdateCall(String accountId, String applicationId, DuoApplicationUpdateReq body, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/duo/accounts/{account_id}/applications/{application_id}"
            .replaceAll("\\{" + "account_id" + "\\}", apiClient.escapeString(accountId.toString()))
            .replaceAll("\\{" + "application_id" + "\\}", apiClient.escapeString(applicationId.toString()));

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
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call duoApplicationUpdateValidateBeforeCall(String accountId, String applicationId, DuoApplicationUpdateReq body, String xOrgId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'accountId' is set
        if (accountId == null) {
            throw new ApiException("Missing the required parameter 'accountId' when calling duoApplicationUpdate(Async)");
        }
        // verify the required parameter 'applicationId' is set
        if (applicationId == null) {
            throw new ApiException("Missing the required parameter 'applicationId' when calling duoApplicationUpdate(Async)");
        }
        
        com.squareup.okhttp.Call call = duoApplicationUpdateCall(accountId, applicationId, body, xOrgId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Update Duo Application
     * Updates the specified Duo application.  #### Sample Request &#x60;&#x60;&#x60;   curl -X PUT https://console.jumpcloud.com/api/v2/duo/accounts/{ACCOUNT_ID}/applications/{APPLICATION_ID} \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{     \&quot;name\&quot;: \&quot;Application Name\&quot;,     \&quot;apiHost\&quot;: \&quot;api-1234.duosecurity.com\&quot;,     \&quot;integrationKey\&quot;: \&quot;1234\&quot;,     \&quot;secretKey\&quot;: \&quot;5678\&quot;   }&#x27; &#x60;&#x60;&#x60;
     * @param accountId  (required)
     * @param applicationId  (required)
     * @param body  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @return DuoApplication
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DuoApplication duoApplicationUpdate(String accountId, String applicationId, DuoApplicationUpdateReq body, String xOrgId) throws ApiException {
        ApiResponse<DuoApplication> resp = duoApplicationUpdateWithHttpInfo(accountId, applicationId, body, xOrgId);
        return resp.getData();
    }

    /**
     * Update Duo Application
     * Updates the specified Duo application.  #### Sample Request &#x60;&#x60;&#x60;   curl -X PUT https://console.jumpcloud.com/api/v2/duo/accounts/{ACCOUNT_ID}/applications/{APPLICATION_ID} \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{     \&quot;name\&quot;: \&quot;Application Name\&quot;,     \&quot;apiHost\&quot;: \&quot;api-1234.duosecurity.com\&quot;,     \&quot;integrationKey\&quot;: \&quot;1234\&quot;,     \&quot;secretKey\&quot;: \&quot;5678\&quot;   }&#x27; &#x60;&#x60;&#x60;
     * @param accountId  (required)
     * @param applicationId  (required)
     * @param body  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @return ApiResponse&lt;DuoApplication&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<DuoApplication> duoApplicationUpdateWithHttpInfo(String accountId, String applicationId, DuoApplicationUpdateReq body, String xOrgId) throws ApiException {
        com.squareup.okhttp.Call call = duoApplicationUpdateValidateBeforeCall(accountId, applicationId, body, xOrgId, null, null);
        Type localVarReturnType = new TypeToken<DuoApplication>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Update Duo Application (asynchronously)
     * Updates the specified Duo application.  #### Sample Request &#x60;&#x60;&#x60;   curl -X PUT https://console.jumpcloud.com/api/v2/duo/accounts/{ACCOUNT_ID}/applications/{APPLICATION_ID} \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{     \&quot;name\&quot;: \&quot;Application Name\&quot;,     \&quot;apiHost\&quot;: \&quot;api-1234.duosecurity.com\&quot;,     \&quot;integrationKey\&quot;: \&quot;1234\&quot;,     \&quot;secretKey\&quot;: \&quot;5678\&quot;   }&#x27; &#x60;&#x60;&#x60;
     * @param accountId  (required)
     * @param applicationId  (required)
     * @param body  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call duoApplicationUpdateAsync(String accountId, String applicationId, DuoApplicationUpdateReq body, String xOrgId, final ApiCallback<DuoApplication> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = duoApplicationUpdateValidateBeforeCall(accountId, applicationId, body, xOrgId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DuoApplication>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
