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


import io.swagger.client.model.Administrator;
import io.swagger.client.model.AutotaskCompanyResp;
import io.swagger.client.model.AutotaskCompanyTypeResp;
import io.swagger.client.model.AutotaskIntegration;
import io.swagger.client.model.AutotaskIntegrationPatchReq;
import io.swagger.client.model.AutotaskIntegrationReq;
import io.swagger.client.model.AutotaskMappingRequest;
import io.swagger.client.model.AutotaskMappingResponse;
import io.swagger.client.model.AutotaskSettings;
import io.swagger.client.model.AutotaskSettingsPatchReq;
import io.swagger.client.model.AutotaskTicketingAlertConfiguration;
import io.swagger.client.model.AutotaskTicketingAlertConfigurationList;
import io.swagger.client.model.AutotaskTicketingAlertConfigurationOptions;
import io.swagger.client.model.AutotaskTicketingAlertConfigurationRequest;
import io.swagger.client.model.ConnectWiseMappingRequest;
import io.swagger.client.model.ConnectWiseSettings;
import io.swagger.client.model.ConnectWiseSettingsPatchReq;
import io.swagger.client.model.ConnectWiseTicketingAlertConfiguration;
import io.swagger.client.model.ConnectWiseTicketingAlertConfigurationList;
import io.swagger.client.model.ConnectWiseTicketingAlertConfigurationOptions;
import io.swagger.client.model.ConnectWiseTicketingAlertConfigurationRequest;
import io.swagger.client.model.ConnectwiseCompanyResp;
import io.swagger.client.model.ConnectwiseCompanyTypeResp;
import io.swagger.client.model.ConnectwiseIntegration;
import io.swagger.client.model.ConnectwiseIntegrationPatchReq;
import io.swagger.client.model.ConnectwiseIntegrationReq;
import io.swagger.client.model.Error;
import io.swagger.client.model.ErrorDetails;
import java.io.File;
import io.swagger.client.model.InlineResponse20012;
import io.swagger.client.model.InlineResponse20013;
import io.swagger.client.model.InlineResponse2003;
import io.swagger.client.model.InlineResponse2004;
import io.swagger.client.model.InlineResponse2005;
import io.swagger.client.model.InlineResponse2006;
import io.swagger.client.model.InlineResponse2007;
import io.swagger.client.model.InlineResponse2008;
import io.swagger.client.model.InlineResponse2009;
import io.swagger.client.model.InlineResponse201;
import io.swagger.client.model.InlineResponse400;
import io.swagger.client.model.IntegrationSyncErrorResp;
import io.swagger.client.model.IntegrationsResponse;
import io.swagger.client.model.Organization;
import io.swagger.client.model.Provider;
import io.swagger.client.model.ProviderAdminReq;
import io.swagger.client.model.ProviderInvoiceResponse;
import io.swagger.client.model.TicketingIntegrationAlertsResp;

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
     * Build call for autotaskCreateConfiguration
     * @param providerId  (required)
     * @param body  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call autotaskCreateConfigurationCall(String providerId, AutotaskIntegrationReq body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/providers/{provider_id}/integrations/autotask"
            .replaceAll("\\{" + "provider_id" + "\\}", apiClient.escapeString(providerId.toString()));

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
    private com.squareup.okhttp.Call autotaskCreateConfigurationValidateBeforeCall(String providerId, AutotaskIntegrationReq body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'providerId' is set
        if (providerId == null) {
            throw new ApiException("Missing the required parameter 'providerId' when calling autotaskCreateConfiguration(Async)");
        }
        
        com.squareup.okhttp.Call call = autotaskCreateConfigurationCall(providerId, body, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Creates a new Autotask integration for the provider
     * Creates a new Autotask integration for the provider. You must be associated with the provider to use this route. A 422 Unprocessable Entity response means the server failed to validate with Autotask.
     * @param providerId  (required)
     * @param body  (optional)
     * @return InlineResponse201
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public InlineResponse201 autotaskCreateConfiguration(String providerId, AutotaskIntegrationReq body) throws ApiException {
        ApiResponse<InlineResponse201> resp = autotaskCreateConfigurationWithHttpInfo(providerId, body);
        return resp.getData();
    }

    /**
     * Creates a new Autotask integration for the provider
     * Creates a new Autotask integration for the provider. You must be associated with the provider to use this route. A 422 Unprocessable Entity response means the server failed to validate with Autotask.
     * @param providerId  (required)
     * @param body  (optional)
     * @return ApiResponse&lt;InlineResponse201&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<InlineResponse201> autotaskCreateConfigurationWithHttpInfo(String providerId, AutotaskIntegrationReq body) throws ApiException {
        com.squareup.okhttp.Call call = autotaskCreateConfigurationValidateBeforeCall(providerId, body, null, null);
        Type localVarReturnType = new TypeToken<InlineResponse201>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Creates a new Autotask integration for the provider (asynchronously)
     * Creates a new Autotask integration for the provider. You must be associated with the provider to use this route. A 422 Unprocessable Entity response means the server failed to validate with Autotask.
     * @param providerId  (required)
     * @param body  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call autotaskCreateConfigurationAsync(String providerId, AutotaskIntegrationReq body, final ApiCallback<InlineResponse201> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = autotaskCreateConfigurationValidateBeforeCall(providerId, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<InlineResponse201>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for autotaskDeleteConfiguration
     * @param UUID  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call autotaskDeleteConfigurationCall(String UUID, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/integrations/autotask/{UUID}"
            .replaceAll("\\{" + "UUID" + "\\}", apiClient.escapeString(UUID.toString()));

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
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call autotaskDeleteConfigurationValidateBeforeCall(String UUID, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'UUID' is set
        if (UUID == null) {
            throw new ApiException("Missing the required parameter 'UUID' when calling autotaskDeleteConfiguration(Async)");
        }
        
        com.squareup.okhttp.Call call = autotaskDeleteConfigurationCall(UUID, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Delete Autotask Integration
     * Removes a Autotask integration.
     * @param UUID  (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void autotaskDeleteConfiguration(String UUID) throws ApiException {
        autotaskDeleteConfigurationWithHttpInfo(UUID);
    }

    /**
     * Delete Autotask Integration
     * Removes a Autotask integration.
     * @param UUID  (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> autotaskDeleteConfigurationWithHttpInfo(String UUID) throws ApiException {
        com.squareup.okhttp.Call call = autotaskDeleteConfigurationValidateBeforeCall(UUID, null, null);
        return apiClient.execute(call);
    }

    /**
     * Delete Autotask Integration (asynchronously)
     * Removes a Autotask integration.
     * @param UUID  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call autotaskDeleteConfigurationAsync(String UUID, final ApiCallback<Void> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = autotaskDeleteConfigurationValidateBeforeCall(UUID, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for autotaskGetConfiguration
     * @param UUID  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call autotaskGetConfigurationCall(String UUID, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/integrations/autotask/{UUID}"
            .replaceAll("\\{" + "UUID" + "\\}", apiClient.escapeString(UUID.toString()));

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
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call autotaskGetConfigurationValidateBeforeCall(String UUID, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'UUID' is set
        if (UUID == null) {
            throw new ApiException("Missing the required parameter 'UUID' when calling autotaskGetConfiguration(Async)");
        }
        
        com.squareup.okhttp.Call call = autotaskGetConfigurationCall(UUID, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Retrieve Autotask Integration Configuration
     * Retrieves configuration for given Autotask integration id. You must be associated to the provider the integration is tied to in order to use this api.
     * @param UUID  (required)
     * @return AutotaskIntegration
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AutotaskIntegration autotaskGetConfiguration(String UUID) throws ApiException {
        ApiResponse<AutotaskIntegration> resp = autotaskGetConfigurationWithHttpInfo(UUID);
        return resp.getData();
    }

    /**
     * Retrieve Autotask Integration Configuration
     * Retrieves configuration for given Autotask integration id. You must be associated to the provider the integration is tied to in order to use this api.
     * @param UUID  (required)
     * @return ApiResponse&lt;AutotaskIntegration&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<AutotaskIntegration> autotaskGetConfigurationWithHttpInfo(String UUID) throws ApiException {
        com.squareup.okhttp.Call call = autotaskGetConfigurationValidateBeforeCall(UUID, null, null);
        Type localVarReturnType = new TypeToken<AutotaskIntegration>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Retrieve Autotask Integration Configuration (asynchronously)
     * Retrieves configuration for given Autotask integration id. You must be associated to the provider the integration is tied to in order to use this api.
     * @param UUID  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call autotaskGetConfigurationAsync(String UUID, final ApiCallback<AutotaskIntegration> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = autotaskGetConfigurationValidateBeforeCall(UUID, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AutotaskIntegration>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for autotaskPatchMappings
     * @param UUID  (required)
     * @param body  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call autotaskPatchMappingsCall(String UUID, AutotaskMappingRequest body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/integrations/autotask/{UUID}/mappings"
            .replaceAll("\\{" + "UUID" + "\\}", apiClient.escapeString(UUID.toString()));

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
        return apiClient.buildCall(localVarPath, "PATCH", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call autotaskPatchMappingsValidateBeforeCall(String UUID, AutotaskMappingRequest body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'UUID' is set
        if (UUID == null) {
            throw new ApiException("Missing the required parameter 'UUID' when calling autotaskPatchMappings(Async)");
        }
        
        com.squareup.okhttp.Call call = autotaskPatchMappingsCall(UUID, body, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Create, edit, and/or delete Autotask Mappings
     * Create, edit, and/or delete mappings between Jumpcloud organizations and Autotask companies/contracts/services. You must be associated to the same provider as the Autotask integration to use this api.
     * @param UUID  (required)
     * @param body  (optional)
     * @return AutotaskMappingResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AutotaskMappingResponse autotaskPatchMappings(String UUID, AutotaskMappingRequest body) throws ApiException {
        ApiResponse<AutotaskMappingResponse> resp = autotaskPatchMappingsWithHttpInfo(UUID, body);
        return resp.getData();
    }

    /**
     * Create, edit, and/or delete Autotask Mappings
     * Create, edit, and/or delete mappings between Jumpcloud organizations and Autotask companies/contracts/services. You must be associated to the same provider as the Autotask integration to use this api.
     * @param UUID  (required)
     * @param body  (optional)
     * @return ApiResponse&lt;AutotaskMappingResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<AutotaskMappingResponse> autotaskPatchMappingsWithHttpInfo(String UUID, AutotaskMappingRequest body) throws ApiException {
        com.squareup.okhttp.Call call = autotaskPatchMappingsValidateBeforeCall(UUID, body, null, null);
        Type localVarReturnType = new TypeToken<AutotaskMappingResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Create, edit, and/or delete Autotask Mappings (asynchronously)
     * Create, edit, and/or delete mappings between Jumpcloud organizations and Autotask companies/contracts/services. You must be associated to the same provider as the Autotask integration to use this api.
     * @param UUID  (required)
     * @param body  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call autotaskPatchMappingsAsync(String UUID, AutotaskMappingRequest body, final ApiCallback<AutotaskMappingResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = autotaskPatchMappingsValidateBeforeCall(UUID, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AutotaskMappingResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for autotaskPatchSettings
     * @param UUID  (required)
     * @param body  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call autotaskPatchSettingsCall(String UUID, AutotaskSettingsPatchReq body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/integrations/autotask/{UUID}/settings"
            .replaceAll("\\{" + "UUID" + "\\}", apiClient.escapeString(UUID.toString()));

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
        return apiClient.buildCall(localVarPath, "PATCH", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call autotaskPatchSettingsValidateBeforeCall(String UUID, AutotaskSettingsPatchReq body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'UUID' is set
        if (UUID == null) {
            throw new ApiException("Missing the required parameter 'UUID' when calling autotaskPatchSettings(Async)");
        }
        
        com.squareup.okhttp.Call call = autotaskPatchSettingsCall(UUID, body, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Create, edit, and/or delete Autotask Integration settings
     * Create, edit, and/or delete Autotask settings. You must be associated to the same provider as the Autotask integration to use this endpoint.
     * @param UUID  (required)
     * @param body  (optional)
     * @return AutotaskSettings
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AutotaskSettings autotaskPatchSettings(String UUID, AutotaskSettingsPatchReq body) throws ApiException {
        ApiResponse<AutotaskSettings> resp = autotaskPatchSettingsWithHttpInfo(UUID, body);
        return resp.getData();
    }

    /**
     * Create, edit, and/or delete Autotask Integration settings
     * Create, edit, and/or delete Autotask settings. You must be associated to the same provider as the Autotask integration to use this endpoint.
     * @param UUID  (required)
     * @param body  (optional)
     * @return ApiResponse&lt;AutotaskSettings&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<AutotaskSettings> autotaskPatchSettingsWithHttpInfo(String UUID, AutotaskSettingsPatchReq body) throws ApiException {
        com.squareup.okhttp.Call call = autotaskPatchSettingsValidateBeforeCall(UUID, body, null, null);
        Type localVarReturnType = new TypeToken<AutotaskSettings>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Create, edit, and/or delete Autotask Integration settings (asynchronously)
     * Create, edit, and/or delete Autotask settings. You must be associated to the same provider as the Autotask integration to use this endpoint.
     * @param UUID  (required)
     * @param body  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call autotaskPatchSettingsAsync(String UUID, AutotaskSettingsPatchReq body, final ApiCallback<AutotaskSettings> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = autotaskPatchSettingsValidateBeforeCall(UUID, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AutotaskSettings>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for autotaskRetrieveAllAlertConfigurationOptions
     * @param providerId  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call autotaskRetrieveAllAlertConfigurationOptionsCall(String providerId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/providers/{provider_id}/integrations/autotask/alerts/configuration/options"
            .replaceAll("\\{" + "provider_id" + "\\}", apiClient.escapeString(providerId.toString()));

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
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call autotaskRetrieveAllAlertConfigurationOptionsValidateBeforeCall(String providerId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'providerId' is set
        if (providerId == null) {
            throw new ApiException("Missing the required parameter 'providerId' when calling autotaskRetrieveAllAlertConfigurationOptions(Async)");
        }
        
        com.squareup.okhttp.Call call = autotaskRetrieveAllAlertConfigurationOptionsCall(providerId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get all Autotask ticketing alert configuration options for a provider
     * Get all Autotask ticketing alert configuration options for a provider.
     * @param providerId  (required)
     * @return AutotaskTicketingAlertConfigurationOptions
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AutotaskTicketingAlertConfigurationOptions autotaskRetrieveAllAlertConfigurationOptions(String providerId) throws ApiException {
        ApiResponse<AutotaskTicketingAlertConfigurationOptions> resp = autotaskRetrieveAllAlertConfigurationOptionsWithHttpInfo(providerId);
        return resp.getData();
    }

    /**
     * Get all Autotask ticketing alert configuration options for a provider
     * Get all Autotask ticketing alert configuration options for a provider.
     * @param providerId  (required)
     * @return ApiResponse&lt;AutotaskTicketingAlertConfigurationOptions&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<AutotaskTicketingAlertConfigurationOptions> autotaskRetrieveAllAlertConfigurationOptionsWithHttpInfo(String providerId) throws ApiException {
        com.squareup.okhttp.Call call = autotaskRetrieveAllAlertConfigurationOptionsValidateBeforeCall(providerId, null, null);
        Type localVarReturnType = new TypeToken<AutotaskTicketingAlertConfigurationOptions>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get all Autotask ticketing alert configuration options for a provider (asynchronously)
     * Get all Autotask ticketing alert configuration options for a provider.
     * @param providerId  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call autotaskRetrieveAllAlertConfigurationOptionsAsync(String providerId, final ApiCallback<AutotaskTicketingAlertConfigurationOptions> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = autotaskRetrieveAllAlertConfigurationOptionsValidateBeforeCall(providerId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AutotaskTicketingAlertConfigurationOptions>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for autotaskRetrieveAllAlertConfigurations
     * @param providerId  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call autotaskRetrieveAllAlertConfigurationsCall(String providerId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/providers/{provider_id}/integrations/autotask/alerts/configuration"
            .replaceAll("\\{" + "provider_id" + "\\}", apiClient.escapeString(providerId.toString()));

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
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call autotaskRetrieveAllAlertConfigurationsValidateBeforeCall(String providerId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'providerId' is set
        if (providerId == null) {
            throw new ApiException("Missing the required parameter 'providerId' when calling autotaskRetrieveAllAlertConfigurations(Async)");
        }
        
        com.squareup.okhttp.Call call = autotaskRetrieveAllAlertConfigurationsCall(providerId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get all Autotask ticketing alert configurations for a provider
     * Get all Autotask ticketing alert configurations for a provider.
     * @param providerId  (required)
     * @return AutotaskTicketingAlertConfigurationList
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AutotaskTicketingAlertConfigurationList autotaskRetrieveAllAlertConfigurations(String providerId) throws ApiException {
        ApiResponse<AutotaskTicketingAlertConfigurationList> resp = autotaskRetrieveAllAlertConfigurationsWithHttpInfo(providerId);
        return resp.getData();
    }

    /**
     * Get all Autotask ticketing alert configurations for a provider
     * Get all Autotask ticketing alert configurations for a provider.
     * @param providerId  (required)
     * @return ApiResponse&lt;AutotaskTicketingAlertConfigurationList&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<AutotaskTicketingAlertConfigurationList> autotaskRetrieveAllAlertConfigurationsWithHttpInfo(String providerId) throws ApiException {
        com.squareup.okhttp.Call call = autotaskRetrieveAllAlertConfigurationsValidateBeforeCall(providerId, null, null);
        Type localVarReturnType = new TypeToken<AutotaskTicketingAlertConfigurationList>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get all Autotask ticketing alert configurations for a provider (asynchronously)
     * Get all Autotask ticketing alert configurations for a provider.
     * @param providerId  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call autotaskRetrieveAllAlertConfigurationsAsync(String providerId, final ApiCallback<AutotaskTicketingAlertConfigurationList> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = autotaskRetrieveAllAlertConfigurationsValidateBeforeCall(providerId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AutotaskTicketingAlertConfigurationList>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for autotaskRetrieveCompanies
     * @param UUID  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call autotaskRetrieveCompaniesCall(String UUID, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/integrations/autotask/{UUID}/companies"
            .replaceAll("\\{" + "UUID" + "\\}", apiClient.escapeString(UUID.toString()));

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
    private com.squareup.okhttp.Call autotaskRetrieveCompaniesValidateBeforeCall(String UUID, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'UUID' is set
        if (UUID == null) {
            throw new ApiException("Missing the required parameter 'UUID' when calling autotaskRetrieveCompanies(Async)");
        }
        
        com.squareup.okhttp.Call call = autotaskRetrieveCompaniesCall(UUID, fields, filter, limit, skip, sort, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Retrieve Autotask Companies
     * Retrieves a list of Autotask companies for the given Autotask id. You must be associated to the same provider as the Autotask integration to use this endpoint.
     * @param UUID  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @return AutotaskCompanyResp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AutotaskCompanyResp autotaskRetrieveCompanies(String UUID, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort) throws ApiException {
        ApiResponse<AutotaskCompanyResp> resp = autotaskRetrieveCompaniesWithHttpInfo(UUID, fields, filter, limit, skip, sort);
        return resp.getData();
    }

    /**
     * Retrieve Autotask Companies
     * Retrieves a list of Autotask companies for the given Autotask id. You must be associated to the same provider as the Autotask integration to use this endpoint.
     * @param UUID  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @return ApiResponse&lt;AutotaskCompanyResp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<AutotaskCompanyResp> autotaskRetrieveCompaniesWithHttpInfo(String UUID, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort) throws ApiException {
        com.squareup.okhttp.Call call = autotaskRetrieveCompaniesValidateBeforeCall(UUID, fields, filter, limit, skip, sort, null, null);
        Type localVarReturnType = new TypeToken<AutotaskCompanyResp>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Retrieve Autotask Companies (asynchronously)
     * Retrieves a list of Autotask companies for the given Autotask id. You must be associated to the same provider as the Autotask integration to use this endpoint.
     * @param UUID  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call autotaskRetrieveCompaniesAsync(String UUID, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort, final ApiCallback<AutotaskCompanyResp> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = autotaskRetrieveCompaniesValidateBeforeCall(UUID, fields, filter, limit, skip, sort, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AutotaskCompanyResp>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for autotaskRetrieveCompanyTypes
     * @param UUID  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call autotaskRetrieveCompanyTypesCall(String UUID, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/integrations/autotask/{UUID}/companytypes"
            .replaceAll("\\{" + "UUID" + "\\}", apiClient.escapeString(UUID.toString()));

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
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call autotaskRetrieveCompanyTypesValidateBeforeCall(String UUID, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'UUID' is set
        if (UUID == null) {
            throw new ApiException("Missing the required parameter 'UUID' when calling autotaskRetrieveCompanyTypes(Async)");
        }
        
        com.squareup.okhttp.Call call = autotaskRetrieveCompanyTypesCall(UUID, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Retrieve Autotask Company Types
     * Retrieves a list of user defined company types from Autotask for the given Autotask id.
     * @param UUID  (required)
     * @return AutotaskCompanyTypeResp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AutotaskCompanyTypeResp autotaskRetrieveCompanyTypes(String UUID) throws ApiException {
        ApiResponse<AutotaskCompanyTypeResp> resp = autotaskRetrieveCompanyTypesWithHttpInfo(UUID);
        return resp.getData();
    }

    /**
     * Retrieve Autotask Company Types
     * Retrieves a list of user defined company types from Autotask for the given Autotask id.
     * @param UUID  (required)
     * @return ApiResponse&lt;AutotaskCompanyTypeResp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<AutotaskCompanyTypeResp> autotaskRetrieveCompanyTypesWithHttpInfo(String UUID) throws ApiException {
        com.squareup.okhttp.Call call = autotaskRetrieveCompanyTypesValidateBeforeCall(UUID, null, null);
        Type localVarReturnType = new TypeToken<AutotaskCompanyTypeResp>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Retrieve Autotask Company Types (asynchronously)
     * Retrieves a list of user defined company types from Autotask for the given Autotask id.
     * @param UUID  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call autotaskRetrieveCompanyTypesAsync(String UUID, final ApiCallback<AutotaskCompanyTypeResp> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = autotaskRetrieveCompanyTypesValidateBeforeCall(UUID, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AutotaskCompanyTypeResp>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for autotaskRetrieveContracts
     * @param UUID  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call autotaskRetrieveContractsCall(String UUID, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/integrations/autotask/{UUID}/contracts"
            .replaceAll("\\{" + "UUID" + "\\}", apiClient.escapeString(UUID.toString()));

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
    private com.squareup.okhttp.Call autotaskRetrieveContractsValidateBeforeCall(String UUID, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'UUID' is set
        if (UUID == null) {
            throw new ApiException("Missing the required parameter 'UUID' when calling autotaskRetrieveContracts(Async)");
        }
        
        com.squareup.okhttp.Call call = autotaskRetrieveContractsCall(UUID, fields, filter, limit, skip, sort, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Retrieve Autotask Contracts
     * Retrieves a list of Autotask contracts for the given Autotask integration id. You must be associated to the same provider as the Autotask integration to use this endpoint.
     * @param UUID  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @return InlineResponse2003
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public InlineResponse2003 autotaskRetrieveContracts(String UUID, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort) throws ApiException {
        ApiResponse<InlineResponse2003> resp = autotaskRetrieveContractsWithHttpInfo(UUID, fields, filter, limit, skip, sort);
        return resp.getData();
    }

    /**
     * Retrieve Autotask Contracts
     * Retrieves a list of Autotask contracts for the given Autotask integration id. You must be associated to the same provider as the Autotask integration to use this endpoint.
     * @param UUID  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @return ApiResponse&lt;InlineResponse2003&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<InlineResponse2003> autotaskRetrieveContractsWithHttpInfo(String UUID, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort) throws ApiException {
        com.squareup.okhttp.Call call = autotaskRetrieveContractsValidateBeforeCall(UUID, fields, filter, limit, skip, sort, null, null);
        Type localVarReturnType = new TypeToken<InlineResponse2003>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Retrieve Autotask Contracts (asynchronously)
     * Retrieves a list of Autotask contracts for the given Autotask integration id. You must be associated to the same provider as the Autotask integration to use this endpoint.
     * @param UUID  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call autotaskRetrieveContractsAsync(String UUID, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort, final ApiCallback<InlineResponse2003> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = autotaskRetrieveContractsValidateBeforeCall(UUID, fields, filter, limit, skip, sort, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<InlineResponse2003>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for autotaskRetrieveContractsFields
     * @param UUID  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call autotaskRetrieveContractsFieldsCall(String UUID, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/integrations/autotask/{UUID}/contracts/fields"
            .replaceAll("\\{" + "UUID" + "\\}", apiClient.escapeString(UUID.toString()));

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
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call autotaskRetrieveContractsFieldsValidateBeforeCall(String UUID, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'UUID' is set
        if (UUID == null) {
            throw new ApiException("Missing the required parameter 'UUID' when calling autotaskRetrieveContractsFields(Async)");
        }
        
        com.squareup.okhttp.Call call = autotaskRetrieveContractsFieldsCall(UUID, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Retrieve Autotask Contract Fields
     * Retrieves a list of Autotask contract fields for the given Autotask integration id. You must be associated to the same provider as the Autotask integration to use this endpoint.
     * @param UUID  (required)
     * @return InlineResponse2004
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public InlineResponse2004 autotaskRetrieveContractsFields(String UUID) throws ApiException {
        ApiResponse<InlineResponse2004> resp = autotaskRetrieveContractsFieldsWithHttpInfo(UUID);
        return resp.getData();
    }

    /**
     * Retrieve Autotask Contract Fields
     * Retrieves a list of Autotask contract fields for the given Autotask integration id. You must be associated to the same provider as the Autotask integration to use this endpoint.
     * @param UUID  (required)
     * @return ApiResponse&lt;InlineResponse2004&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<InlineResponse2004> autotaskRetrieveContractsFieldsWithHttpInfo(String UUID) throws ApiException {
        com.squareup.okhttp.Call call = autotaskRetrieveContractsFieldsValidateBeforeCall(UUID, null, null);
        Type localVarReturnType = new TypeToken<InlineResponse2004>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Retrieve Autotask Contract Fields (asynchronously)
     * Retrieves a list of Autotask contract fields for the given Autotask integration id. You must be associated to the same provider as the Autotask integration to use this endpoint.
     * @param UUID  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call autotaskRetrieveContractsFieldsAsync(String UUID, final ApiCallback<InlineResponse2004> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = autotaskRetrieveContractsFieldsValidateBeforeCall(UUID, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<InlineResponse2004>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for autotaskRetrieveMappings
     * @param UUID  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call autotaskRetrieveMappingsCall(String UUID, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/integrations/autotask/{UUID}/mappings"
            .replaceAll("\\{" + "UUID" + "\\}", apiClient.escapeString(UUID.toString()));

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
    private com.squareup.okhttp.Call autotaskRetrieveMappingsValidateBeforeCall(String UUID, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'UUID' is set
        if (UUID == null) {
            throw new ApiException("Missing the required parameter 'UUID' when calling autotaskRetrieveMappings(Async)");
        }
        
        com.squareup.okhttp.Call call = autotaskRetrieveMappingsCall(UUID, fields, filter, limit, skip, sort, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Retrieve Autotask mappings
     * Retrieves the list of mappings for this Autotask integration. You must be associated to the same provider as the Autotask integration to use this api.
     * @param UUID  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @return InlineResponse2006
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public InlineResponse2006 autotaskRetrieveMappings(String UUID, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort) throws ApiException {
        ApiResponse<InlineResponse2006> resp = autotaskRetrieveMappingsWithHttpInfo(UUID, fields, filter, limit, skip, sort);
        return resp.getData();
    }

    /**
     * Retrieve Autotask mappings
     * Retrieves the list of mappings for this Autotask integration. You must be associated to the same provider as the Autotask integration to use this api.
     * @param UUID  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @return ApiResponse&lt;InlineResponse2006&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<InlineResponse2006> autotaskRetrieveMappingsWithHttpInfo(String UUID, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort) throws ApiException {
        com.squareup.okhttp.Call call = autotaskRetrieveMappingsValidateBeforeCall(UUID, fields, filter, limit, skip, sort, null, null);
        Type localVarReturnType = new TypeToken<InlineResponse2006>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Retrieve Autotask mappings (asynchronously)
     * Retrieves the list of mappings for this Autotask integration. You must be associated to the same provider as the Autotask integration to use this api.
     * @param UUID  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call autotaskRetrieveMappingsAsync(String UUID, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort, final ApiCallback<InlineResponse2006> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = autotaskRetrieveMappingsValidateBeforeCall(UUID, fields, filter, limit, skip, sort, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<InlineResponse2006>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for autotaskRetrieveServices
     * @param UUID  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call autotaskRetrieveServicesCall(String UUID, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/integrations/autotask/{UUID}/contracts/services"
            .replaceAll("\\{" + "UUID" + "\\}", apiClient.escapeString(UUID.toString()));

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
    private com.squareup.okhttp.Call autotaskRetrieveServicesValidateBeforeCall(String UUID, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'UUID' is set
        if (UUID == null) {
            throw new ApiException("Missing the required parameter 'UUID' when calling autotaskRetrieveServices(Async)");
        }
        
        com.squareup.okhttp.Call call = autotaskRetrieveServicesCall(UUID, fields, filter, limit, skip, sort, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Retrieve Autotask Contract Services
     * Retrieves a list of Autotask contract services for the given Autotask integration id. You must be associated to the same provider as the Autotask integration to use this endpoint.
     * @param UUID  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @return InlineResponse2005
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public InlineResponse2005 autotaskRetrieveServices(String UUID, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort) throws ApiException {
        ApiResponse<InlineResponse2005> resp = autotaskRetrieveServicesWithHttpInfo(UUID, fields, filter, limit, skip, sort);
        return resp.getData();
    }

    /**
     * Retrieve Autotask Contract Services
     * Retrieves a list of Autotask contract services for the given Autotask integration id. You must be associated to the same provider as the Autotask integration to use this endpoint.
     * @param UUID  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @return ApiResponse&lt;InlineResponse2005&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<InlineResponse2005> autotaskRetrieveServicesWithHttpInfo(String UUID, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort) throws ApiException {
        com.squareup.okhttp.Call call = autotaskRetrieveServicesValidateBeforeCall(UUID, fields, filter, limit, skip, sort, null, null);
        Type localVarReturnType = new TypeToken<InlineResponse2005>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Retrieve Autotask Contract Services (asynchronously)
     * Retrieves a list of Autotask contract services for the given Autotask integration id. You must be associated to the same provider as the Autotask integration to use this endpoint.
     * @param UUID  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call autotaskRetrieveServicesAsync(String UUID, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort, final ApiCallback<InlineResponse2005> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = autotaskRetrieveServicesValidateBeforeCall(UUID, fields, filter, limit, skip, sort, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<InlineResponse2005>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for autotaskRetrieveSettings
     * @param UUID  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call autotaskRetrieveSettingsCall(String UUID, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/integrations/autotask/{UUID}/settings"
            .replaceAll("\\{" + "UUID" + "\\}", apiClient.escapeString(UUID.toString()));

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
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call autotaskRetrieveSettingsValidateBeforeCall(String UUID, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'UUID' is set
        if (UUID == null) {
            throw new ApiException("Missing the required parameter 'UUID' when calling autotaskRetrieveSettings(Async)");
        }
        
        com.squareup.okhttp.Call call = autotaskRetrieveSettingsCall(UUID, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Retrieve Autotask Integration settings
     * Retrieve the Autotask integration settings. You must be associated to the same provider as the Autotask integration to use this endpoint.
     * @param UUID  (required)
     * @return AutotaskSettings
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AutotaskSettings autotaskRetrieveSettings(String UUID) throws ApiException {
        ApiResponse<AutotaskSettings> resp = autotaskRetrieveSettingsWithHttpInfo(UUID);
        return resp.getData();
    }

    /**
     * Retrieve Autotask Integration settings
     * Retrieve the Autotask integration settings. You must be associated to the same provider as the Autotask integration to use this endpoint.
     * @param UUID  (required)
     * @return ApiResponse&lt;AutotaskSettings&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<AutotaskSettings> autotaskRetrieveSettingsWithHttpInfo(String UUID) throws ApiException {
        com.squareup.okhttp.Call call = autotaskRetrieveSettingsValidateBeforeCall(UUID, null, null);
        Type localVarReturnType = new TypeToken<AutotaskSettings>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Retrieve Autotask Integration settings (asynchronously)
     * Retrieve the Autotask integration settings. You must be associated to the same provider as the Autotask integration to use this endpoint.
     * @param UUID  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call autotaskRetrieveSettingsAsync(String UUID, final ApiCallback<AutotaskSettings> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = autotaskRetrieveSettingsValidateBeforeCall(UUID, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AutotaskSettings>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for autotaskUpdateAlertConfiguration
     * @param providerId  (required)
     * @param alertUUID  (required)
     * @param body  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call autotaskUpdateAlertConfigurationCall(String providerId, String alertUUID, AutotaskTicketingAlertConfigurationRequest body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/providers/{provider_id}/integrations/autotask/alerts/{alert_UUID}/configuration"
            .replaceAll("\\{" + "provider_id" + "\\}", apiClient.escapeString(providerId.toString()))
            .replaceAll("\\{" + "alert_UUID" + "\\}", apiClient.escapeString(alertUUID.toString()));

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
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call autotaskUpdateAlertConfigurationValidateBeforeCall(String providerId, String alertUUID, AutotaskTicketingAlertConfigurationRequest body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'providerId' is set
        if (providerId == null) {
            throw new ApiException("Missing the required parameter 'providerId' when calling autotaskUpdateAlertConfiguration(Async)");
        }
        // verify the required parameter 'alertUUID' is set
        if (alertUUID == null) {
            throw new ApiException("Missing the required parameter 'alertUUID' when calling autotaskUpdateAlertConfiguration(Async)");
        }
        
        com.squareup.okhttp.Call call = autotaskUpdateAlertConfigurationCall(providerId, alertUUID, body, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Update an Autotask ticketing alert&#x27;s configuration
     * Update an Autotask ticketing alert&#x27;s configuration
     * @param providerId  (required)
     * @param alertUUID  (required)
     * @param body  (optional)
     * @return AutotaskTicketingAlertConfiguration
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AutotaskTicketingAlertConfiguration autotaskUpdateAlertConfiguration(String providerId, String alertUUID, AutotaskTicketingAlertConfigurationRequest body) throws ApiException {
        ApiResponse<AutotaskTicketingAlertConfiguration> resp = autotaskUpdateAlertConfigurationWithHttpInfo(providerId, alertUUID, body);
        return resp.getData();
    }

    /**
     * Update an Autotask ticketing alert&#x27;s configuration
     * Update an Autotask ticketing alert&#x27;s configuration
     * @param providerId  (required)
     * @param alertUUID  (required)
     * @param body  (optional)
     * @return ApiResponse&lt;AutotaskTicketingAlertConfiguration&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<AutotaskTicketingAlertConfiguration> autotaskUpdateAlertConfigurationWithHttpInfo(String providerId, String alertUUID, AutotaskTicketingAlertConfigurationRequest body) throws ApiException {
        com.squareup.okhttp.Call call = autotaskUpdateAlertConfigurationValidateBeforeCall(providerId, alertUUID, body, null, null);
        Type localVarReturnType = new TypeToken<AutotaskTicketingAlertConfiguration>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Update an Autotask ticketing alert&#x27;s configuration (asynchronously)
     * Update an Autotask ticketing alert&#x27;s configuration
     * @param providerId  (required)
     * @param alertUUID  (required)
     * @param body  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call autotaskUpdateAlertConfigurationAsync(String providerId, String alertUUID, AutotaskTicketingAlertConfigurationRequest body, final ApiCallback<AutotaskTicketingAlertConfiguration> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = autotaskUpdateAlertConfigurationValidateBeforeCall(providerId, alertUUID, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AutotaskTicketingAlertConfiguration>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for autotaskUpdateConfiguration
     * @param UUID  (required)
     * @param body  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call autotaskUpdateConfigurationCall(String UUID, AutotaskIntegrationPatchReq body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/integrations/autotask/{UUID}"
            .replaceAll("\\{" + "UUID" + "\\}", apiClient.escapeString(UUID.toString()));

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
        return apiClient.buildCall(localVarPath, "PATCH", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call autotaskUpdateConfigurationValidateBeforeCall(String UUID, AutotaskIntegrationPatchReq body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'UUID' is set
        if (UUID == null) {
            throw new ApiException("Missing the required parameter 'UUID' when calling autotaskUpdateConfiguration(Async)");
        }
        
        com.squareup.okhttp.Call call = autotaskUpdateConfigurationCall(UUID, body, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Update Autotask Integration configuration
     * Update the Autotask integration configuration. A 422 Unprocessable Entity response means the server failed to validate with Autotask.
     * @param UUID  (required)
     * @param body  (optional)
     * @return AutotaskIntegration
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AutotaskIntegration autotaskUpdateConfiguration(String UUID, AutotaskIntegrationPatchReq body) throws ApiException {
        ApiResponse<AutotaskIntegration> resp = autotaskUpdateConfigurationWithHttpInfo(UUID, body);
        return resp.getData();
    }

    /**
     * Update Autotask Integration configuration
     * Update the Autotask integration configuration. A 422 Unprocessable Entity response means the server failed to validate with Autotask.
     * @param UUID  (required)
     * @param body  (optional)
     * @return ApiResponse&lt;AutotaskIntegration&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<AutotaskIntegration> autotaskUpdateConfigurationWithHttpInfo(String UUID, AutotaskIntegrationPatchReq body) throws ApiException {
        com.squareup.okhttp.Call call = autotaskUpdateConfigurationValidateBeforeCall(UUID, body, null, null);
        Type localVarReturnType = new TypeToken<AutotaskIntegration>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Update Autotask Integration configuration (asynchronously)
     * Update the Autotask integration configuration. A 422 Unprocessable Entity response means the server failed to validate with Autotask.
     * @param UUID  (required)
     * @param body  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call autotaskUpdateConfigurationAsync(String UUID, AutotaskIntegrationPatchReq body, final ApiCallback<AutotaskIntegration> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = autotaskUpdateConfigurationValidateBeforeCall(UUID, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AutotaskIntegration>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for connectwiseCreateConfiguration
     * @param providerId  (required)
     * @param body  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call connectwiseCreateConfigurationCall(String providerId, ConnectwiseIntegrationReq body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/providers/{provider_id}/integrations/connectwise"
            .replaceAll("\\{" + "provider_id" + "\\}", apiClient.escapeString(providerId.toString()));

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
    private com.squareup.okhttp.Call connectwiseCreateConfigurationValidateBeforeCall(String providerId, ConnectwiseIntegrationReq body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'providerId' is set
        if (providerId == null) {
            throw new ApiException("Missing the required parameter 'providerId' when calling connectwiseCreateConfiguration(Async)");
        }
        
        com.squareup.okhttp.Call call = connectwiseCreateConfigurationCall(providerId, body, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Creates a new ConnectWise integration for the provider
     * Creates a new ConnectWise integration for the provider. You must be associated with the provider to use this route. A 422 Unprocessable Entity response means the server failed to validate with ConnectWise.
     * @param providerId  (required)
     * @param body  (optional)
     * @return InlineResponse201
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public InlineResponse201 connectwiseCreateConfiguration(String providerId, ConnectwiseIntegrationReq body) throws ApiException {
        ApiResponse<InlineResponse201> resp = connectwiseCreateConfigurationWithHttpInfo(providerId, body);
        return resp.getData();
    }

    /**
     * Creates a new ConnectWise integration for the provider
     * Creates a new ConnectWise integration for the provider. You must be associated with the provider to use this route. A 422 Unprocessable Entity response means the server failed to validate with ConnectWise.
     * @param providerId  (required)
     * @param body  (optional)
     * @return ApiResponse&lt;InlineResponse201&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<InlineResponse201> connectwiseCreateConfigurationWithHttpInfo(String providerId, ConnectwiseIntegrationReq body) throws ApiException {
        com.squareup.okhttp.Call call = connectwiseCreateConfigurationValidateBeforeCall(providerId, body, null, null);
        Type localVarReturnType = new TypeToken<InlineResponse201>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Creates a new ConnectWise integration for the provider (asynchronously)
     * Creates a new ConnectWise integration for the provider. You must be associated with the provider to use this route. A 422 Unprocessable Entity response means the server failed to validate with ConnectWise.
     * @param providerId  (required)
     * @param body  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call connectwiseCreateConfigurationAsync(String providerId, ConnectwiseIntegrationReq body, final ApiCallback<InlineResponse201> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = connectwiseCreateConfigurationValidateBeforeCall(providerId, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<InlineResponse201>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for connectwiseDeleteConfiguration
     * @param UUID  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call connectwiseDeleteConfigurationCall(String UUID, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/integrations/connectwise/{UUID}"
            .replaceAll("\\{" + "UUID" + "\\}", apiClient.escapeString(UUID.toString()));

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
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call connectwiseDeleteConfigurationValidateBeforeCall(String UUID, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'UUID' is set
        if (UUID == null) {
            throw new ApiException("Missing the required parameter 'UUID' when calling connectwiseDeleteConfiguration(Async)");
        }
        
        com.squareup.okhttp.Call call = connectwiseDeleteConfigurationCall(UUID, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Delete ConnectWise Integration
     * Removes a ConnectWise integration.
     * @param UUID  (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void connectwiseDeleteConfiguration(String UUID) throws ApiException {
        connectwiseDeleteConfigurationWithHttpInfo(UUID);
    }

    /**
     * Delete ConnectWise Integration
     * Removes a ConnectWise integration.
     * @param UUID  (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> connectwiseDeleteConfigurationWithHttpInfo(String UUID) throws ApiException {
        com.squareup.okhttp.Call call = connectwiseDeleteConfigurationValidateBeforeCall(UUID, null, null);
        return apiClient.execute(call);
    }

    /**
     * Delete ConnectWise Integration (asynchronously)
     * Removes a ConnectWise integration.
     * @param UUID  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call connectwiseDeleteConfigurationAsync(String UUID, final ApiCallback<Void> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = connectwiseDeleteConfigurationValidateBeforeCall(UUID, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for connectwiseGetConfiguration
     * @param UUID  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call connectwiseGetConfigurationCall(String UUID, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/integrations/connectwise/{UUID}"
            .replaceAll("\\{" + "UUID" + "\\}", apiClient.escapeString(UUID.toString()));

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
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call connectwiseGetConfigurationValidateBeforeCall(String UUID, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'UUID' is set
        if (UUID == null) {
            throw new ApiException("Missing the required parameter 'UUID' when calling connectwiseGetConfiguration(Async)");
        }
        
        com.squareup.okhttp.Call call = connectwiseGetConfigurationCall(UUID, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Retrieve ConnectWise Integration Configuration
     * Retrieves configuration for given ConnectWise integration id. You must be associated to the provider the integration is tied to in order to use this api.
     * @param UUID  (required)
     * @return ConnectwiseIntegration
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ConnectwiseIntegration connectwiseGetConfiguration(String UUID) throws ApiException {
        ApiResponse<ConnectwiseIntegration> resp = connectwiseGetConfigurationWithHttpInfo(UUID);
        return resp.getData();
    }

    /**
     * Retrieve ConnectWise Integration Configuration
     * Retrieves configuration for given ConnectWise integration id. You must be associated to the provider the integration is tied to in order to use this api.
     * @param UUID  (required)
     * @return ApiResponse&lt;ConnectwiseIntegration&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ConnectwiseIntegration> connectwiseGetConfigurationWithHttpInfo(String UUID) throws ApiException {
        com.squareup.okhttp.Call call = connectwiseGetConfigurationValidateBeforeCall(UUID, null, null);
        Type localVarReturnType = new TypeToken<ConnectwiseIntegration>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Retrieve ConnectWise Integration Configuration (asynchronously)
     * Retrieves configuration for given ConnectWise integration id. You must be associated to the provider the integration is tied to in order to use this api.
     * @param UUID  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call connectwiseGetConfigurationAsync(String UUID, final ApiCallback<ConnectwiseIntegration> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = connectwiseGetConfigurationValidateBeforeCall(UUID, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ConnectwiseIntegration>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for connectwisePatchMappings
     * @param UUID  (required)
     * @param body  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call connectwisePatchMappingsCall(String UUID, ConnectWiseMappingRequest body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/integrations/connectwise/{UUID}/mappings"
            .replaceAll("\\{" + "UUID" + "\\}", apiClient.escapeString(UUID.toString()));

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
        return apiClient.buildCall(localVarPath, "PATCH", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call connectwisePatchMappingsValidateBeforeCall(String UUID, ConnectWiseMappingRequest body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'UUID' is set
        if (UUID == null) {
            throw new ApiException("Missing the required parameter 'UUID' when calling connectwisePatchMappings(Async)");
        }
        
        com.squareup.okhttp.Call call = connectwisePatchMappingsCall(UUID, body, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Create, edit, and/or delete ConnectWise Mappings
     * Create, edit, and/or delete mappings between Jumpcloud organizations and ConnectWise companies/agreements/additions. You must be associated to the same provider as the ConnectWise integration to use this api.
     * @param UUID  (required)
     * @param body  (optional)
     * @return ConnectWiseMappingRequest
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ConnectWiseMappingRequest connectwisePatchMappings(String UUID, ConnectWiseMappingRequest body) throws ApiException {
        ApiResponse<ConnectWiseMappingRequest> resp = connectwisePatchMappingsWithHttpInfo(UUID, body);
        return resp.getData();
    }

    /**
     * Create, edit, and/or delete ConnectWise Mappings
     * Create, edit, and/or delete mappings between Jumpcloud organizations and ConnectWise companies/agreements/additions. You must be associated to the same provider as the ConnectWise integration to use this api.
     * @param UUID  (required)
     * @param body  (optional)
     * @return ApiResponse&lt;ConnectWiseMappingRequest&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ConnectWiseMappingRequest> connectwisePatchMappingsWithHttpInfo(String UUID, ConnectWiseMappingRequest body) throws ApiException {
        com.squareup.okhttp.Call call = connectwisePatchMappingsValidateBeforeCall(UUID, body, null, null);
        Type localVarReturnType = new TypeToken<ConnectWiseMappingRequest>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Create, edit, and/or delete ConnectWise Mappings (asynchronously)
     * Create, edit, and/or delete mappings between Jumpcloud organizations and ConnectWise companies/agreements/additions. You must be associated to the same provider as the ConnectWise integration to use this api.
     * @param UUID  (required)
     * @param body  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call connectwisePatchMappingsAsync(String UUID, ConnectWiseMappingRequest body, final ApiCallback<ConnectWiseMappingRequest> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = connectwisePatchMappingsValidateBeforeCall(UUID, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ConnectWiseMappingRequest>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for connectwisePatchSettings
     * @param UUID  (required)
     * @param body  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call connectwisePatchSettingsCall(String UUID, ConnectWiseSettingsPatchReq body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/integrations/connectwise/{UUID}/settings"
            .replaceAll("\\{" + "UUID" + "\\}", apiClient.escapeString(UUID.toString()));

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
        return apiClient.buildCall(localVarPath, "PATCH", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call connectwisePatchSettingsValidateBeforeCall(String UUID, ConnectWiseSettingsPatchReq body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'UUID' is set
        if (UUID == null) {
            throw new ApiException("Missing the required parameter 'UUID' when calling connectwisePatchSettings(Async)");
        }
        
        com.squareup.okhttp.Call call = connectwisePatchSettingsCall(UUID, body, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Create, edit, and/or delete ConnectWise Integration settings
     * Create, edit, and/or delete ConnectWiseIntegration settings. You must be associated to the same provider as the ConnectWise integration to use this endpoint.
     * @param UUID  (required)
     * @param body  (optional)
     * @return ConnectWiseSettings
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ConnectWiseSettings connectwisePatchSettings(String UUID, ConnectWiseSettingsPatchReq body) throws ApiException {
        ApiResponse<ConnectWiseSettings> resp = connectwisePatchSettingsWithHttpInfo(UUID, body);
        return resp.getData();
    }

    /**
     * Create, edit, and/or delete ConnectWise Integration settings
     * Create, edit, and/or delete ConnectWiseIntegration settings. You must be associated to the same provider as the ConnectWise integration to use this endpoint.
     * @param UUID  (required)
     * @param body  (optional)
     * @return ApiResponse&lt;ConnectWiseSettings&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ConnectWiseSettings> connectwisePatchSettingsWithHttpInfo(String UUID, ConnectWiseSettingsPatchReq body) throws ApiException {
        com.squareup.okhttp.Call call = connectwisePatchSettingsValidateBeforeCall(UUID, body, null, null);
        Type localVarReturnType = new TypeToken<ConnectWiseSettings>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Create, edit, and/or delete ConnectWise Integration settings (asynchronously)
     * Create, edit, and/or delete ConnectWiseIntegration settings. You must be associated to the same provider as the ConnectWise integration to use this endpoint.
     * @param UUID  (required)
     * @param body  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call connectwisePatchSettingsAsync(String UUID, ConnectWiseSettingsPatchReq body, final ApiCallback<ConnectWiseSettings> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = connectwisePatchSettingsValidateBeforeCall(UUID, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ConnectWiseSettings>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for connectwiseRetrieveAdditions
     * @param UUID  (required)
     * @param agreementID  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call connectwiseRetrieveAdditionsCall(String UUID, String agreementID, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/integrations/connectwise/{UUID}/agreements/{agreement_ID}/additions"
            .replaceAll("\\{" + "UUID" + "\\}", apiClient.escapeString(UUID.toString()))
            .replaceAll("\\{" + "agreement_ID" + "\\}", apiClient.escapeString(agreementID.toString()));

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
    private com.squareup.okhttp.Call connectwiseRetrieveAdditionsValidateBeforeCall(String UUID, String agreementID, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'UUID' is set
        if (UUID == null) {
            throw new ApiException("Missing the required parameter 'UUID' when calling connectwiseRetrieveAdditions(Async)");
        }
        // verify the required parameter 'agreementID' is set
        if (agreementID == null) {
            throw new ApiException("Missing the required parameter 'agreementID' when calling connectwiseRetrieveAdditions(Async)");
        }
        
        com.squareup.okhttp.Call call = connectwiseRetrieveAdditionsCall(UUID, agreementID, fields, filter, limit, skip, sort, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Retrieve ConnectWise Additions
     * Retrieves a list of ConnectWise additions for the given ConnectWise id and Agreement id. You must be associated to the same provider as the ConnectWise integration to use this endpoint.
     * @param UUID  (required)
     * @param agreementID  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @return InlineResponse2008
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public InlineResponse2008 connectwiseRetrieveAdditions(String UUID, String agreementID, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort) throws ApiException {
        ApiResponse<InlineResponse2008> resp = connectwiseRetrieveAdditionsWithHttpInfo(UUID, agreementID, fields, filter, limit, skip, sort);
        return resp.getData();
    }

    /**
     * Retrieve ConnectWise Additions
     * Retrieves a list of ConnectWise additions for the given ConnectWise id and Agreement id. You must be associated to the same provider as the ConnectWise integration to use this endpoint.
     * @param UUID  (required)
     * @param agreementID  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @return ApiResponse&lt;InlineResponse2008&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<InlineResponse2008> connectwiseRetrieveAdditionsWithHttpInfo(String UUID, String agreementID, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort) throws ApiException {
        com.squareup.okhttp.Call call = connectwiseRetrieveAdditionsValidateBeforeCall(UUID, agreementID, fields, filter, limit, skip, sort, null, null);
        Type localVarReturnType = new TypeToken<InlineResponse2008>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Retrieve ConnectWise Additions (asynchronously)
     * Retrieves a list of ConnectWise additions for the given ConnectWise id and Agreement id. You must be associated to the same provider as the ConnectWise integration to use this endpoint.
     * @param UUID  (required)
     * @param agreementID  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call connectwiseRetrieveAdditionsAsync(String UUID, String agreementID, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort, final ApiCallback<InlineResponse2008> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = connectwiseRetrieveAdditionsValidateBeforeCall(UUID, agreementID, fields, filter, limit, skip, sort, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<InlineResponse2008>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for connectwiseRetrieveAgreements
     * @param UUID  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call connectwiseRetrieveAgreementsCall(String UUID, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/integrations/connectwise/{UUID}/agreements"
            .replaceAll("\\{" + "UUID" + "\\}", apiClient.escapeString(UUID.toString()));

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
    private com.squareup.okhttp.Call connectwiseRetrieveAgreementsValidateBeforeCall(String UUID, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'UUID' is set
        if (UUID == null) {
            throw new ApiException("Missing the required parameter 'UUID' when calling connectwiseRetrieveAgreements(Async)");
        }
        
        com.squareup.okhttp.Call call = connectwiseRetrieveAgreementsCall(UUID, fields, filter, limit, skip, sort, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Retrieve ConnectWise Agreements
     * Retrieves a list of ConnectWise agreements for the given ConnectWise id. You must be associated to the same provider as the ConnectWise integration to use this endpoint.
     * @param UUID  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @return InlineResponse2007
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public InlineResponse2007 connectwiseRetrieveAgreements(String UUID, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort) throws ApiException {
        ApiResponse<InlineResponse2007> resp = connectwiseRetrieveAgreementsWithHttpInfo(UUID, fields, filter, limit, skip, sort);
        return resp.getData();
    }

    /**
     * Retrieve ConnectWise Agreements
     * Retrieves a list of ConnectWise agreements for the given ConnectWise id. You must be associated to the same provider as the ConnectWise integration to use this endpoint.
     * @param UUID  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @return ApiResponse&lt;InlineResponse2007&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<InlineResponse2007> connectwiseRetrieveAgreementsWithHttpInfo(String UUID, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort) throws ApiException {
        com.squareup.okhttp.Call call = connectwiseRetrieveAgreementsValidateBeforeCall(UUID, fields, filter, limit, skip, sort, null, null);
        Type localVarReturnType = new TypeToken<InlineResponse2007>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Retrieve ConnectWise Agreements (asynchronously)
     * Retrieves a list of ConnectWise agreements for the given ConnectWise id. You must be associated to the same provider as the ConnectWise integration to use this endpoint.
     * @param UUID  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call connectwiseRetrieveAgreementsAsync(String UUID, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort, final ApiCallback<InlineResponse2007> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = connectwiseRetrieveAgreementsValidateBeforeCall(UUID, fields, filter, limit, skip, sort, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<InlineResponse2007>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for connectwiseRetrieveAllAlertConfigurationOptions
     * @param providerId  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call connectwiseRetrieveAllAlertConfigurationOptionsCall(String providerId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/providers/{provider_id}/integrations/connectwise/alerts/configuration/options"
            .replaceAll("\\{" + "provider_id" + "\\}", apiClient.escapeString(providerId.toString()));

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
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call connectwiseRetrieveAllAlertConfigurationOptionsValidateBeforeCall(String providerId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'providerId' is set
        if (providerId == null) {
            throw new ApiException("Missing the required parameter 'providerId' when calling connectwiseRetrieveAllAlertConfigurationOptions(Async)");
        }
        
        com.squareup.okhttp.Call call = connectwiseRetrieveAllAlertConfigurationOptionsCall(providerId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get all ConnectWise ticketing alert configuration options for a provider
     * Get all ConnectWise ticketing alert configuration options for a provider.
     * @param providerId  (required)
     * @return ConnectWiseTicketingAlertConfigurationOptions
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ConnectWiseTicketingAlertConfigurationOptions connectwiseRetrieveAllAlertConfigurationOptions(String providerId) throws ApiException {
        ApiResponse<ConnectWiseTicketingAlertConfigurationOptions> resp = connectwiseRetrieveAllAlertConfigurationOptionsWithHttpInfo(providerId);
        return resp.getData();
    }

    /**
     * Get all ConnectWise ticketing alert configuration options for a provider
     * Get all ConnectWise ticketing alert configuration options for a provider.
     * @param providerId  (required)
     * @return ApiResponse&lt;ConnectWiseTicketingAlertConfigurationOptions&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ConnectWiseTicketingAlertConfigurationOptions> connectwiseRetrieveAllAlertConfigurationOptionsWithHttpInfo(String providerId) throws ApiException {
        com.squareup.okhttp.Call call = connectwiseRetrieveAllAlertConfigurationOptionsValidateBeforeCall(providerId, null, null);
        Type localVarReturnType = new TypeToken<ConnectWiseTicketingAlertConfigurationOptions>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get all ConnectWise ticketing alert configuration options for a provider (asynchronously)
     * Get all ConnectWise ticketing alert configuration options for a provider.
     * @param providerId  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call connectwiseRetrieveAllAlertConfigurationOptionsAsync(String providerId, final ApiCallback<ConnectWiseTicketingAlertConfigurationOptions> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = connectwiseRetrieveAllAlertConfigurationOptionsValidateBeforeCall(providerId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ConnectWiseTicketingAlertConfigurationOptions>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for connectwiseRetrieveAllAlertConfigurations
     * @param providerId  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call connectwiseRetrieveAllAlertConfigurationsCall(String providerId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/providers/{provider_id}/integrations/connectwise/alerts/configuration"
            .replaceAll("\\{" + "provider_id" + "\\}", apiClient.escapeString(providerId.toString()));

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
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call connectwiseRetrieveAllAlertConfigurationsValidateBeforeCall(String providerId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'providerId' is set
        if (providerId == null) {
            throw new ApiException("Missing the required parameter 'providerId' when calling connectwiseRetrieveAllAlertConfigurations(Async)");
        }
        
        com.squareup.okhttp.Call call = connectwiseRetrieveAllAlertConfigurationsCall(providerId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get all ConnectWise ticketing alert configurations for a provider
     * Get all ConnectWise ticketing alert configurations for a provider.
     * @param providerId  (required)
     * @return ConnectWiseTicketingAlertConfigurationList
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ConnectWiseTicketingAlertConfigurationList connectwiseRetrieveAllAlertConfigurations(String providerId) throws ApiException {
        ApiResponse<ConnectWiseTicketingAlertConfigurationList> resp = connectwiseRetrieveAllAlertConfigurationsWithHttpInfo(providerId);
        return resp.getData();
    }

    /**
     * Get all ConnectWise ticketing alert configurations for a provider
     * Get all ConnectWise ticketing alert configurations for a provider.
     * @param providerId  (required)
     * @return ApiResponse&lt;ConnectWiseTicketingAlertConfigurationList&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ConnectWiseTicketingAlertConfigurationList> connectwiseRetrieveAllAlertConfigurationsWithHttpInfo(String providerId) throws ApiException {
        com.squareup.okhttp.Call call = connectwiseRetrieveAllAlertConfigurationsValidateBeforeCall(providerId, null, null);
        Type localVarReturnType = new TypeToken<ConnectWiseTicketingAlertConfigurationList>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get all ConnectWise ticketing alert configurations for a provider (asynchronously)
     * Get all ConnectWise ticketing alert configurations for a provider.
     * @param providerId  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call connectwiseRetrieveAllAlertConfigurationsAsync(String providerId, final ApiCallback<ConnectWiseTicketingAlertConfigurationList> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = connectwiseRetrieveAllAlertConfigurationsValidateBeforeCall(providerId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ConnectWiseTicketingAlertConfigurationList>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for connectwiseRetrieveCompanies
     * @param UUID  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call connectwiseRetrieveCompaniesCall(String UUID, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/integrations/connectwise/{UUID}/companies"
            .replaceAll("\\{" + "UUID" + "\\}", apiClient.escapeString(UUID.toString()));

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
    private com.squareup.okhttp.Call connectwiseRetrieveCompaniesValidateBeforeCall(String UUID, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'UUID' is set
        if (UUID == null) {
            throw new ApiException("Missing the required parameter 'UUID' when calling connectwiseRetrieveCompanies(Async)");
        }
        
        com.squareup.okhttp.Call call = connectwiseRetrieveCompaniesCall(UUID, fields, filter, limit, skip, sort, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Retrieve ConnectWise Companies
     * Retrieves a list of ConnectWise companies for the given ConnectWise id. You must be associated to the same provider as the ConnectWise integration to use this endpoint.
     * @param UUID  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @return ConnectwiseCompanyResp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ConnectwiseCompanyResp connectwiseRetrieveCompanies(String UUID, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort) throws ApiException {
        ApiResponse<ConnectwiseCompanyResp> resp = connectwiseRetrieveCompaniesWithHttpInfo(UUID, fields, filter, limit, skip, sort);
        return resp.getData();
    }

    /**
     * Retrieve ConnectWise Companies
     * Retrieves a list of ConnectWise companies for the given ConnectWise id. You must be associated to the same provider as the ConnectWise integration to use this endpoint.
     * @param UUID  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @return ApiResponse&lt;ConnectwiseCompanyResp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ConnectwiseCompanyResp> connectwiseRetrieveCompaniesWithHttpInfo(String UUID, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort) throws ApiException {
        com.squareup.okhttp.Call call = connectwiseRetrieveCompaniesValidateBeforeCall(UUID, fields, filter, limit, skip, sort, null, null);
        Type localVarReturnType = new TypeToken<ConnectwiseCompanyResp>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Retrieve ConnectWise Companies (asynchronously)
     * Retrieves a list of ConnectWise companies for the given ConnectWise id. You must be associated to the same provider as the ConnectWise integration to use this endpoint.
     * @param UUID  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call connectwiseRetrieveCompaniesAsync(String UUID, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort, final ApiCallback<ConnectwiseCompanyResp> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = connectwiseRetrieveCompaniesValidateBeforeCall(UUID, fields, filter, limit, skip, sort, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ConnectwiseCompanyResp>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for connectwiseRetrieveCompanyTypes
     * @param UUID  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call connectwiseRetrieveCompanyTypesCall(String UUID, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/integrations/connectwise/{UUID}/companytypes"
            .replaceAll("\\{" + "UUID" + "\\}", apiClient.escapeString(UUID.toString()));

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
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call connectwiseRetrieveCompanyTypesValidateBeforeCall(String UUID, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'UUID' is set
        if (UUID == null) {
            throw new ApiException("Missing the required parameter 'UUID' when calling connectwiseRetrieveCompanyTypes(Async)");
        }
        
        com.squareup.okhttp.Call call = connectwiseRetrieveCompanyTypesCall(UUID, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Retrieve ConnectWise Company Types
     * Retrieves a list of user defined company types from ConnectWise for the given ConnectWise id.
     * @param UUID  (required)
     * @return ConnectwiseCompanyTypeResp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ConnectwiseCompanyTypeResp connectwiseRetrieveCompanyTypes(String UUID) throws ApiException {
        ApiResponse<ConnectwiseCompanyTypeResp> resp = connectwiseRetrieveCompanyTypesWithHttpInfo(UUID);
        return resp.getData();
    }

    /**
     * Retrieve ConnectWise Company Types
     * Retrieves a list of user defined company types from ConnectWise for the given ConnectWise id.
     * @param UUID  (required)
     * @return ApiResponse&lt;ConnectwiseCompanyTypeResp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ConnectwiseCompanyTypeResp> connectwiseRetrieveCompanyTypesWithHttpInfo(String UUID) throws ApiException {
        com.squareup.okhttp.Call call = connectwiseRetrieveCompanyTypesValidateBeforeCall(UUID, null, null);
        Type localVarReturnType = new TypeToken<ConnectwiseCompanyTypeResp>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Retrieve ConnectWise Company Types (asynchronously)
     * Retrieves a list of user defined company types from ConnectWise for the given ConnectWise id.
     * @param UUID  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call connectwiseRetrieveCompanyTypesAsync(String UUID, final ApiCallback<ConnectwiseCompanyTypeResp> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = connectwiseRetrieveCompanyTypesValidateBeforeCall(UUID, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ConnectwiseCompanyTypeResp>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for connectwiseRetrieveMappings
     * @param UUID  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call connectwiseRetrieveMappingsCall(String UUID, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/integrations/connectwise/{UUID}/mappings"
            .replaceAll("\\{" + "UUID" + "\\}", apiClient.escapeString(UUID.toString()));

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
    private com.squareup.okhttp.Call connectwiseRetrieveMappingsValidateBeforeCall(String UUID, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'UUID' is set
        if (UUID == null) {
            throw new ApiException("Missing the required parameter 'UUID' when calling connectwiseRetrieveMappings(Async)");
        }
        
        com.squareup.okhttp.Call call = connectwiseRetrieveMappingsCall(UUID, fields, filter, limit, skip, sort, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Retrieve ConnectWise mappings
     * Retrieves the list of mappings for this ConnectWise integration. You must be associated to the same provider as the ConnectWise integration to use this api.
     * @param UUID  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @return InlineResponse2009
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public InlineResponse2009 connectwiseRetrieveMappings(String UUID, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort) throws ApiException {
        ApiResponse<InlineResponse2009> resp = connectwiseRetrieveMappingsWithHttpInfo(UUID, fields, filter, limit, skip, sort);
        return resp.getData();
    }

    /**
     * Retrieve ConnectWise mappings
     * Retrieves the list of mappings for this ConnectWise integration. You must be associated to the same provider as the ConnectWise integration to use this api.
     * @param UUID  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @return ApiResponse&lt;InlineResponse2009&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<InlineResponse2009> connectwiseRetrieveMappingsWithHttpInfo(String UUID, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort) throws ApiException {
        com.squareup.okhttp.Call call = connectwiseRetrieveMappingsValidateBeforeCall(UUID, fields, filter, limit, skip, sort, null, null);
        Type localVarReturnType = new TypeToken<InlineResponse2009>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Retrieve ConnectWise mappings (asynchronously)
     * Retrieves the list of mappings for this ConnectWise integration. You must be associated to the same provider as the ConnectWise integration to use this api.
     * @param UUID  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call connectwiseRetrieveMappingsAsync(String UUID, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort, final ApiCallback<InlineResponse2009> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = connectwiseRetrieveMappingsValidateBeforeCall(UUID, fields, filter, limit, skip, sort, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<InlineResponse2009>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for connectwiseRetrieveSettings
     * @param UUID  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call connectwiseRetrieveSettingsCall(String UUID, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/integrations/connectwise/{UUID}/settings"
            .replaceAll("\\{" + "UUID" + "\\}", apiClient.escapeString(UUID.toString()));

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
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call connectwiseRetrieveSettingsValidateBeforeCall(String UUID, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'UUID' is set
        if (UUID == null) {
            throw new ApiException("Missing the required parameter 'UUID' when calling connectwiseRetrieveSettings(Async)");
        }
        
        com.squareup.okhttp.Call call = connectwiseRetrieveSettingsCall(UUID, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Retrieve ConnectWise Integration settings
     * Retrieve the ConnectWise integration settings. You must be associated to the same provider as the ConnectWise integration to use this endpoint.
     * @param UUID  (required)
     * @return ConnectWiseSettings
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ConnectWiseSettings connectwiseRetrieveSettings(String UUID) throws ApiException {
        ApiResponse<ConnectWiseSettings> resp = connectwiseRetrieveSettingsWithHttpInfo(UUID);
        return resp.getData();
    }

    /**
     * Retrieve ConnectWise Integration settings
     * Retrieve the ConnectWise integration settings. You must be associated to the same provider as the ConnectWise integration to use this endpoint.
     * @param UUID  (required)
     * @return ApiResponse&lt;ConnectWiseSettings&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ConnectWiseSettings> connectwiseRetrieveSettingsWithHttpInfo(String UUID) throws ApiException {
        com.squareup.okhttp.Call call = connectwiseRetrieveSettingsValidateBeforeCall(UUID, null, null);
        Type localVarReturnType = new TypeToken<ConnectWiseSettings>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Retrieve ConnectWise Integration settings (asynchronously)
     * Retrieve the ConnectWise integration settings. You must be associated to the same provider as the ConnectWise integration to use this endpoint.
     * @param UUID  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call connectwiseRetrieveSettingsAsync(String UUID, final ApiCallback<ConnectWiseSettings> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = connectwiseRetrieveSettingsValidateBeforeCall(UUID, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ConnectWiseSettings>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for connectwiseUpdateAlertConfiguration
     * @param providerId  (required)
     * @param alertUUID  (required)
     * @param body  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call connectwiseUpdateAlertConfigurationCall(String providerId, String alertUUID, ConnectWiseTicketingAlertConfigurationRequest body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/providers/{provider_id}/integrations/connectwise/alerts/{alert_UUID}/configuration"
            .replaceAll("\\{" + "provider_id" + "\\}", apiClient.escapeString(providerId.toString()))
            .replaceAll("\\{" + "alert_UUID" + "\\}", apiClient.escapeString(alertUUID.toString()));

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
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call connectwiseUpdateAlertConfigurationValidateBeforeCall(String providerId, String alertUUID, ConnectWiseTicketingAlertConfigurationRequest body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'providerId' is set
        if (providerId == null) {
            throw new ApiException("Missing the required parameter 'providerId' when calling connectwiseUpdateAlertConfiguration(Async)");
        }
        // verify the required parameter 'alertUUID' is set
        if (alertUUID == null) {
            throw new ApiException("Missing the required parameter 'alertUUID' when calling connectwiseUpdateAlertConfiguration(Async)");
        }
        
        com.squareup.okhttp.Call call = connectwiseUpdateAlertConfigurationCall(providerId, alertUUID, body, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Update a ConnectWise ticketing alert&#x27;s configuration
     * Update a ConnectWise ticketing alert&#x27;s configuration.
     * @param providerId  (required)
     * @param alertUUID  (required)
     * @param body  (optional)
     * @return ConnectWiseTicketingAlertConfiguration
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ConnectWiseTicketingAlertConfiguration connectwiseUpdateAlertConfiguration(String providerId, String alertUUID, ConnectWiseTicketingAlertConfigurationRequest body) throws ApiException {
        ApiResponse<ConnectWiseTicketingAlertConfiguration> resp = connectwiseUpdateAlertConfigurationWithHttpInfo(providerId, alertUUID, body);
        return resp.getData();
    }

    /**
     * Update a ConnectWise ticketing alert&#x27;s configuration
     * Update a ConnectWise ticketing alert&#x27;s configuration.
     * @param providerId  (required)
     * @param alertUUID  (required)
     * @param body  (optional)
     * @return ApiResponse&lt;ConnectWiseTicketingAlertConfiguration&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ConnectWiseTicketingAlertConfiguration> connectwiseUpdateAlertConfigurationWithHttpInfo(String providerId, String alertUUID, ConnectWiseTicketingAlertConfigurationRequest body) throws ApiException {
        com.squareup.okhttp.Call call = connectwiseUpdateAlertConfigurationValidateBeforeCall(providerId, alertUUID, body, null, null);
        Type localVarReturnType = new TypeToken<ConnectWiseTicketingAlertConfiguration>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Update a ConnectWise ticketing alert&#x27;s configuration (asynchronously)
     * Update a ConnectWise ticketing alert&#x27;s configuration.
     * @param providerId  (required)
     * @param alertUUID  (required)
     * @param body  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call connectwiseUpdateAlertConfigurationAsync(String providerId, String alertUUID, ConnectWiseTicketingAlertConfigurationRequest body, final ApiCallback<ConnectWiseTicketingAlertConfiguration> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = connectwiseUpdateAlertConfigurationValidateBeforeCall(providerId, alertUUID, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ConnectWiseTicketingAlertConfiguration>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for connectwiseUpdateConfiguration
     * @param UUID  (required)
     * @param body  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call connectwiseUpdateConfigurationCall(String UUID, ConnectwiseIntegrationPatchReq body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/integrations/connectwise/{UUID}"
            .replaceAll("\\{" + "UUID" + "\\}", apiClient.escapeString(UUID.toString()));

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
        return apiClient.buildCall(localVarPath, "PATCH", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call connectwiseUpdateConfigurationValidateBeforeCall(String UUID, ConnectwiseIntegrationPatchReq body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'UUID' is set
        if (UUID == null) {
            throw new ApiException("Missing the required parameter 'UUID' when calling connectwiseUpdateConfiguration(Async)");
        }
        
        com.squareup.okhttp.Call call = connectwiseUpdateConfigurationCall(UUID, body, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Update ConnectWise Integration configuration
     * Update the ConnectWise integration configuration. A 422 Unprocessable Entity response means the server failed to validate with ConnectWise.
     * @param UUID  (required)
     * @param body  (optional)
     * @return ConnectwiseIntegration
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ConnectwiseIntegration connectwiseUpdateConfiguration(String UUID, ConnectwiseIntegrationPatchReq body) throws ApiException {
        ApiResponse<ConnectwiseIntegration> resp = connectwiseUpdateConfigurationWithHttpInfo(UUID, body);
        return resp.getData();
    }

    /**
     * Update ConnectWise Integration configuration
     * Update the ConnectWise integration configuration. A 422 Unprocessable Entity response means the server failed to validate with ConnectWise.
     * @param UUID  (required)
     * @param body  (optional)
     * @return ApiResponse&lt;ConnectwiseIntegration&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ConnectwiseIntegration> connectwiseUpdateConfigurationWithHttpInfo(String UUID, ConnectwiseIntegrationPatchReq body) throws ApiException {
        com.squareup.okhttp.Call call = connectwiseUpdateConfigurationValidateBeforeCall(UUID, body, null, null);
        Type localVarReturnType = new TypeToken<ConnectwiseIntegration>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Update ConnectWise Integration configuration (asynchronously)
     * Update the ConnectWise integration configuration. A 422 Unprocessable Entity response means the server failed to validate with ConnectWise.
     * @param UUID  (required)
     * @param body  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call connectwiseUpdateConfigurationAsync(String UUID, ConnectwiseIntegrationPatchReq body, final ApiCallback<ConnectwiseIntegration> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = connectwiseUpdateConfigurationValidateBeforeCall(UUID, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ConnectwiseIntegration>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for mtpIntegrationRetrieveAlerts
     * @param providerId  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call mtpIntegrationRetrieveAlertsCall(String providerId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/providers/{provider_id}/integrations/ticketing/alerts"
            .replaceAll("\\{" + "provider_id" + "\\}", apiClient.escapeString(providerId.toString()));

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
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call mtpIntegrationRetrieveAlertsValidateBeforeCall(String providerId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'providerId' is set
        if (providerId == null) {
            throw new ApiException("Missing the required parameter 'providerId' when calling mtpIntegrationRetrieveAlerts(Async)");
        }
        
        com.squareup.okhttp.Call call = mtpIntegrationRetrieveAlertsCall(providerId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get all ticketing alerts available for a provider&#x27;s ticketing integration.
     * Get all ticketing alerts available for a provider&#x27;s ticketing integration.
     * @param providerId  (required)
     * @return TicketingIntegrationAlertsResp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public TicketingIntegrationAlertsResp mtpIntegrationRetrieveAlerts(String providerId) throws ApiException {
        ApiResponse<TicketingIntegrationAlertsResp> resp = mtpIntegrationRetrieveAlertsWithHttpInfo(providerId);
        return resp.getData();
    }

    /**
     * Get all ticketing alerts available for a provider&#x27;s ticketing integration.
     * Get all ticketing alerts available for a provider&#x27;s ticketing integration.
     * @param providerId  (required)
     * @return ApiResponse&lt;TicketingIntegrationAlertsResp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<TicketingIntegrationAlertsResp> mtpIntegrationRetrieveAlertsWithHttpInfo(String providerId) throws ApiException {
        com.squareup.okhttp.Call call = mtpIntegrationRetrieveAlertsValidateBeforeCall(providerId, null, null);
        Type localVarReturnType = new TypeToken<TicketingIntegrationAlertsResp>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get all ticketing alerts available for a provider&#x27;s ticketing integration. (asynchronously)
     * Get all ticketing alerts available for a provider&#x27;s ticketing integration.
     * @param providerId  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call mtpIntegrationRetrieveAlertsAsync(String providerId, final ApiCallback<TicketingIntegrationAlertsResp> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = mtpIntegrationRetrieveAlertsValidateBeforeCall(providerId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<TicketingIntegrationAlertsResp>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for mtpIntegrationRetrieveSyncErrors
     * @param UUID  (required)
     * @param integrationType  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call mtpIntegrationRetrieveSyncErrorsCall(String UUID, String integrationType, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/integrations/{integration_type}/{UUID}/errors"
            .replaceAll("\\{" + "UUID" + "\\}", apiClient.escapeString(UUID.toString()))
            .replaceAll("\\{" + "integration_type" + "\\}", apiClient.escapeString(integrationType.toString()));

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
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call mtpIntegrationRetrieveSyncErrorsValidateBeforeCall(String UUID, String integrationType, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'UUID' is set
        if (UUID == null) {
            throw new ApiException("Missing the required parameter 'UUID' when calling mtpIntegrationRetrieveSyncErrors(Async)");
        }
        // verify the required parameter 'integrationType' is set
        if (integrationType == null) {
            throw new ApiException("Missing the required parameter 'integrationType' when calling mtpIntegrationRetrieveSyncErrors(Async)");
        }
        
        com.squareup.okhttp.Call call = mtpIntegrationRetrieveSyncErrorsCall(UUID, integrationType, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Retrieve Recent Integration Sync Errors
     * Retrieves recent sync errors for given integration type and integration id. You must be associated to the provider the integration is tied to in order to use this api.
     * @param UUID  (required)
     * @param integrationType  (required)
     * @return IntegrationSyncErrorResp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public IntegrationSyncErrorResp mtpIntegrationRetrieveSyncErrors(String UUID, String integrationType) throws ApiException {
        ApiResponse<IntegrationSyncErrorResp> resp = mtpIntegrationRetrieveSyncErrorsWithHttpInfo(UUID, integrationType);
        return resp.getData();
    }

    /**
     * Retrieve Recent Integration Sync Errors
     * Retrieves recent sync errors for given integration type and integration id. You must be associated to the provider the integration is tied to in order to use this api.
     * @param UUID  (required)
     * @param integrationType  (required)
     * @return ApiResponse&lt;IntegrationSyncErrorResp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<IntegrationSyncErrorResp> mtpIntegrationRetrieveSyncErrorsWithHttpInfo(String UUID, String integrationType) throws ApiException {
        com.squareup.okhttp.Call call = mtpIntegrationRetrieveSyncErrorsValidateBeforeCall(UUID, integrationType, null, null);
        Type localVarReturnType = new TypeToken<IntegrationSyncErrorResp>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Retrieve Recent Integration Sync Errors (asynchronously)
     * Retrieves recent sync errors for given integration type and integration id. You must be associated to the provider the integration is tied to in order to use this api.
     * @param UUID  (required)
     * @param integrationType  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call mtpIntegrationRetrieveSyncErrorsAsync(String UUID, String integrationType, final ApiCallback<IntegrationSyncErrorResp> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = mtpIntegrationRetrieveSyncErrorsValidateBeforeCall(UUID, integrationType, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<IntegrationSyncErrorResp>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for providerOrganizationsUpdateOrg
     * @param providerId  (required)
     * @param id  (required)
     * @param body  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call providerOrganizationsUpdateOrgCall(String providerId, String id, Organization body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/providers/{provider_id}/organizations/{id}"
            .replaceAll("\\{" + "provider_id" + "\\}", apiClient.escapeString(providerId.toString()))
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
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call providerOrganizationsUpdateOrgValidateBeforeCall(String providerId, String id, Organization body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'providerId' is set
        if (providerId == null) {
            throw new ApiException("Missing the required parameter 'providerId' when calling providerOrganizationsUpdateOrg(Async)");
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling providerOrganizationsUpdateOrg(Async)");
        }
        
        com.squareup.okhttp.Call call = providerOrganizationsUpdateOrgCall(providerId, id, body, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Update Provider Organization
     * This endpoint updates a provider&#x27;s organization
     * @param providerId  (required)
     * @param id  (required)
     * @param body  (optional)
     * @return Organization
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Organization providerOrganizationsUpdateOrg(String providerId, String id, Organization body) throws ApiException {
        ApiResponse<Organization> resp = providerOrganizationsUpdateOrgWithHttpInfo(providerId, id, body);
        return resp.getData();
    }

    /**
     * Update Provider Organization
     * This endpoint updates a provider&#x27;s organization
     * @param providerId  (required)
     * @param id  (required)
     * @param body  (optional)
     * @return ApiResponse&lt;Organization&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Organization> providerOrganizationsUpdateOrgWithHttpInfo(String providerId, String id, Organization body) throws ApiException {
        com.squareup.okhttp.Call call = providerOrganizationsUpdateOrgValidateBeforeCall(providerId, id, body, null, null);
        Type localVarReturnType = new TypeToken<Organization>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Update Provider Organization (asynchronously)
     * This endpoint updates a provider&#x27;s organization
     * @param providerId  (required)
     * @param id  (required)
     * @param body  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call providerOrganizationsUpdateOrgAsync(String providerId, String id, Organization body, final ApiCallback<Organization> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = providerOrganizationsUpdateOrgValidateBeforeCall(providerId, id, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Organization>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for providersGetProvider
     * @param providerId  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call providersGetProviderCall(String providerId, List<String> fields, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/providers/{provider_id}"
            .replaceAll("\\{" + "provider_id" + "\\}", apiClient.escapeString(providerId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (fields != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "fields", fields));

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
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call providersGetProviderValidateBeforeCall(String providerId, List<String> fields, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'providerId' is set
        if (providerId == null) {
            throw new ApiException("Missing the required parameter 'providerId' when calling providersGetProvider(Async)");
        }
        
        com.squareup.okhttp.Call call = providersGetProviderCall(providerId, fields, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Retrieve Provider
     * This endpoint returns details about a provider
     * @param providerId  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @return Provider
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Provider providersGetProvider(String providerId, List<String> fields) throws ApiException {
        ApiResponse<Provider> resp = providersGetProviderWithHttpInfo(providerId, fields);
        return resp.getData();
    }

    /**
     * Retrieve Provider
     * This endpoint returns details about a provider
     * @param providerId  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @return ApiResponse&lt;Provider&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Provider> providersGetProviderWithHttpInfo(String providerId, List<String> fields) throws ApiException {
        com.squareup.okhttp.Call call = providersGetProviderValidateBeforeCall(providerId, fields, null, null);
        Type localVarReturnType = new TypeToken<Provider>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Retrieve Provider (asynchronously)
     * This endpoint returns details about a provider
     * @param providerId  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call providersGetProviderAsync(String providerId, List<String> fields, final ApiCallback<Provider> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = providersGetProviderValidateBeforeCall(providerId, fields, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Provider>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for providersListAdministrators
     * @param providerId  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call providersListAdministratorsCall(String providerId, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
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
    private com.squareup.okhttp.Call providersListAdministratorsValidateBeforeCall(String providerId, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'providerId' is set
        if (providerId == null) {
            throw new ApiException("Missing the required parameter 'providerId' when calling providersListAdministrators(Async)");
        }
        
        com.squareup.okhttp.Call call = providersListAdministratorsCall(providerId, fields, filter, limit, skip, sort, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List Provider Administrators
     * This endpoint returns a list of the Administrators associated with the Provider. You must be associated with the provider to use this route.
     * @param providerId  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @return InlineResponse20012
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public InlineResponse20012 providersListAdministrators(String providerId, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort) throws ApiException {
        ApiResponse<InlineResponse20012> resp = providersListAdministratorsWithHttpInfo(providerId, fields, filter, limit, skip, sort);
        return resp.getData();
    }

    /**
     * List Provider Administrators
     * This endpoint returns a list of the Administrators associated with the Provider. You must be associated with the provider to use this route.
     * @param providerId  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @return ApiResponse&lt;InlineResponse20012&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<InlineResponse20012> providersListAdministratorsWithHttpInfo(String providerId, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort) throws ApiException {
        com.squareup.okhttp.Call call = providersListAdministratorsValidateBeforeCall(providerId, fields, filter, limit, skip, sort, null, null);
        Type localVarReturnType = new TypeToken<InlineResponse20012>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List Provider Administrators (asynchronously)
     * This endpoint returns a list of the Administrators associated with the Provider. You must be associated with the provider to use this route.
     * @param providerId  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call providersListAdministratorsAsync(String providerId, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort, final ApiCallback<InlineResponse20012> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = providersListAdministratorsValidateBeforeCall(providerId, fields, filter, limit, skip, sort, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<InlineResponse20012>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for providersListOrganizations
     * @param providerId  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call providersListOrganizationsCall(String providerId, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/providers/{provider_id}/organizations"
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
    private com.squareup.okhttp.Call providersListOrganizationsValidateBeforeCall(String providerId, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'providerId' is set
        if (providerId == null) {
            throw new ApiException("Missing the required parameter 'providerId' when calling providersListOrganizations(Async)");
        }
        
        com.squareup.okhttp.Call call = providersListOrganizationsCall(providerId, fields, filter, limit, skip, sort, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List Provider Organizations
     * This endpoint returns a list of the Organizations associated with the Provider. You must be associated with the provider to use this route.
     * @param providerId  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @return InlineResponse20013
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public InlineResponse20013 providersListOrganizations(String providerId, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort) throws ApiException {
        ApiResponse<InlineResponse20013> resp = providersListOrganizationsWithHttpInfo(providerId, fields, filter, limit, skip, sort);
        return resp.getData();
    }

    /**
     * List Provider Organizations
     * This endpoint returns a list of the Organizations associated with the Provider. You must be associated with the provider to use this route.
     * @param providerId  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @return ApiResponse&lt;InlineResponse20013&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<InlineResponse20013> providersListOrganizationsWithHttpInfo(String providerId, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort) throws ApiException {
        com.squareup.okhttp.Call call = providersListOrganizationsValidateBeforeCall(providerId, fields, filter, limit, skip, sort, null, null);
        Type localVarReturnType = new TypeToken<InlineResponse20013>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List Provider Organizations (asynchronously)
     * This endpoint returns a list of the Organizations associated with the Provider. You must be associated with the provider to use this route.
     * @param providerId  (required)
     * @param fields The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  (optional)
     * @param filter A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call providersListOrganizationsAsync(String providerId, List<String> fields, List<String> filter, Integer limit, Integer skip, List<String> sort, final ApiCallback<InlineResponse20013> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = providersListOrganizationsValidateBeforeCall(providerId, fields, filter, limit, skip, sort, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<InlineResponse20013>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for providersPostAdmins
     * @param providerId  (required)
     * @param body  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call providersPostAdminsCall(String providerId, ProviderAdminReq body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/providers/{provider_id}/administrators"
            .replaceAll("\\{" + "provider_id" + "\\}", apiClient.escapeString(providerId.toString()));

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
    private com.squareup.okhttp.Call providersPostAdminsValidateBeforeCall(String providerId, ProviderAdminReq body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'providerId' is set
        if (providerId == null) {
            throw new ApiException("Missing the required parameter 'providerId' when calling providersPostAdmins(Async)");
        }
        
        com.squareup.okhttp.Call call = providersPostAdminsCall(providerId, body, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Create a new Provider Administrator
     * This endpoint allows you to create a provider administrator. You must be associated with the provider to use this route. You must provide either &#x60;role&#x60; or &#x60;roleName&#x60;.
     * @param providerId  (required)
     * @param body  (optional)
     * @return Administrator
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Administrator providersPostAdmins(String providerId, ProviderAdminReq body) throws ApiException {
        ApiResponse<Administrator> resp = providersPostAdminsWithHttpInfo(providerId, body);
        return resp.getData();
    }

    /**
     * Create a new Provider Administrator
     * This endpoint allows you to create a provider administrator. You must be associated with the provider to use this route. You must provide either &#x60;role&#x60; or &#x60;roleName&#x60;.
     * @param providerId  (required)
     * @param body  (optional)
     * @return ApiResponse&lt;Administrator&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Administrator> providersPostAdminsWithHttpInfo(String providerId, ProviderAdminReq body) throws ApiException {
        com.squareup.okhttp.Call call = providersPostAdminsValidateBeforeCall(providerId, body, null, null);
        Type localVarReturnType = new TypeToken<Administrator>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Create a new Provider Administrator (asynchronously)
     * This endpoint allows you to create a provider administrator. You must be associated with the provider to use this route. You must provide either &#x60;role&#x60; or &#x60;roleName&#x60;.
     * @param providerId  (required)
     * @param body  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call providersPostAdminsAsync(String providerId, ProviderAdminReq body, final ApiCallback<Administrator> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = providersPostAdminsValidateBeforeCall(providerId, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Administrator>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for providersRemoveAdministrator
     * @param providerId  (required)
     * @param id  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call providersRemoveAdministratorCall(String providerId, String id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/providers/{provider_id}/administrators/{id}"
            .replaceAll("\\{" + "provider_id" + "\\}", apiClient.escapeString(providerId.toString()))
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
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call providersRemoveAdministratorValidateBeforeCall(String providerId, String id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'providerId' is set
        if (providerId == null) {
            throw new ApiException("Missing the required parameter 'providerId' when calling providersRemoveAdministrator(Async)");
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling providersRemoveAdministrator(Async)");
        }
        
        com.squareup.okhttp.Call call = providersRemoveAdministratorCall(providerId, id, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Delete Provider Administrator
     * This endpoint removes an Administrator associated with the Provider. You must be associated with the provider to use this route.
     * @param providerId  (required)
     * @param id  (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void providersRemoveAdministrator(String providerId, String id) throws ApiException {
        providersRemoveAdministratorWithHttpInfo(providerId, id);
    }

    /**
     * Delete Provider Administrator
     * This endpoint removes an Administrator associated with the Provider. You must be associated with the provider to use this route.
     * @param providerId  (required)
     * @param id  (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> providersRemoveAdministratorWithHttpInfo(String providerId, String id) throws ApiException {
        com.squareup.okhttp.Call call = providersRemoveAdministratorValidateBeforeCall(providerId, id, null, null);
        return apiClient.execute(call);
    }

    /**
     * Delete Provider Administrator (asynchronously)
     * This endpoint removes an Administrator associated with the Provider. You must be associated with the provider to use this route.
     * @param providerId  (required)
     * @param id  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call providersRemoveAdministratorAsync(String providerId, String id, final ApiCallback<Void> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = providersRemoveAdministratorValidateBeforeCall(providerId, id, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for providersRetrieveIntegrations
     * @param providerId  (required)
     * @param filter A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call providersRetrieveIntegrationsCall(String providerId, List<String> filter, Integer limit, Integer skip, List<String> sort, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/providers/{provider_id}/integrations"
            .replaceAll("\\{" + "provider_id" + "\\}", apiClient.escapeString(providerId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));

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
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call providersRetrieveIntegrationsValidateBeforeCall(String providerId, List<String> filter, Integer limit, Integer skip, List<String> sort, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'providerId' is set
        if (providerId == null) {
            throw new ApiException("Missing the required parameter 'providerId' when calling providersRetrieveIntegrations(Async)");
        }
        
        com.squareup.okhttp.Call call = providersRetrieveIntegrationsCall(providerId, filter, limit, skip, sort, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Retrieve Integrations for Provider
     * Retrieves a list of integrations this provider has configured. You must be associated to the provider to use this endpoint.
     * @param providerId  (required)
     * @param filter A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @return IntegrationsResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public IntegrationsResponse providersRetrieveIntegrations(String providerId, List<String> filter, Integer limit, Integer skip, List<String> sort) throws ApiException {
        ApiResponse<IntegrationsResponse> resp = providersRetrieveIntegrationsWithHttpInfo(providerId, filter, limit, skip, sort);
        return resp.getData();
    }

    /**
     * Retrieve Integrations for Provider
     * Retrieves a list of integrations this provider has configured. You must be associated to the provider to use this endpoint.
     * @param providerId  (required)
     * @param filter A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @return ApiResponse&lt;IntegrationsResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<IntegrationsResponse> providersRetrieveIntegrationsWithHttpInfo(String providerId, List<String> filter, Integer limit, Integer skip, List<String> sort) throws ApiException {
        com.squareup.okhttp.Call call = providersRetrieveIntegrationsValidateBeforeCall(providerId, filter, limit, skip, sort, null, null);
        Type localVarReturnType = new TypeToken<IntegrationsResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Retrieve Integrations for Provider (asynchronously)
     * Retrieves a list of integrations this provider has configured. You must be associated to the provider to use this endpoint.
     * @param providerId  (required)
     * @param filter A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call providersRetrieveIntegrationsAsync(String providerId, List<String> filter, Integer limit, Integer skip, List<String> sort, final ApiCallback<IntegrationsResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = providersRetrieveIntegrationsValidateBeforeCall(providerId, filter, limit, skip, sort, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<IntegrationsResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for providersRetrieveInvoice
     * @param providerId  (required)
     * @param ID  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call providersRetrieveInvoiceCall(String providerId, String ID, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/providers/{provider_id}/invoices/{ID}"
            .replaceAll("\\{" + "provider_id" + "\\}", apiClient.escapeString(providerId.toString()))
            .replaceAll("\\{" + "ID" + "\\}", apiClient.escapeString(ID.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/pdf"
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
    private com.squareup.okhttp.Call providersRetrieveInvoiceValidateBeforeCall(String providerId, String ID, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'providerId' is set
        if (providerId == null) {
            throw new ApiException("Missing the required parameter 'providerId' when calling providersRetrieveInvoice(Async)");
        }
        // verify the required parameter 'ID' is set
        if (ID == null) {
            throw new ApiException("Missing the required parameter 'ID' when calling providersRetrieveInvoice(Async)");
        }
        
        com.squareup.okhttp.Call call = providersRetrieveInvoiceCall(providerId, ID, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Download a provider&#x27;s invoice.
     * Retrieves an invoice for this provider. You must be associated to the provider to use this endpoint.
     * @param providerId  (required)
     * @param ID  (required)
     * @return File
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public File providersRetrieveInvoice(String providerId, String ID) throws ApiException {
        ApiResponse<File> resp = providersRetrieveInvoiceWithHttpInfo(providerId, ID);
        return resp.getData();
    }

    /**
     * Download a provider&#x27;s invoice.
     * Retrieves an invoice for this provider. You must be associated to the provider to use this endpoint.
     * @param providerId  (required)
     * @param ID  (required)
     * @return ApiResponse&lt;File&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<File> providersRetrieveInvoiceWithHttpInfo(String providerId, String ID) throws ApiException {
        com.squareup.okhttp.Call call = providersRetrieveInvoiceValidateBeforeCall(providerId, ID, null, null);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Download a provider&#x27;s invoice. (asynchronously)
     * Retrieves an invoice for this provider. You must be associated to the provider to use this endpoint.
     * @param providerId  (required)
     * @param ID  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call providersRetrieveInvoiceAsync(String providerId, String ID, final ApiCallback<File> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = providersRetrieveInvoiceValidateBeforeCall(providerId, ID, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for providersRetrieveInvoices
     * @param providerId  (required)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call providersRetrieveInvoicesCall(String providerId, Integer skip, List<String> sort, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/providers/{provider_id}/invoices"
            .replaceAll("\\{" + "provider_id" + "\\}", apiClient.escapeString(providerId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call providersRetrieveInvoicesValidateBeforeCall(String providerId, Integer skip, List<String> sort, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'providerId' is set
        if (providerId == null) {
            throw new ApiException("Missing the required parameter 'providerId' when calling providersRetrieveInvoices(Async)");
        }
        
        com.squareup.okhttp.Call call = providersRetrieveInvoicesCall(providerId, skip, sort, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List a provider&#x27;s invoices.
     * Retrieves a list of invoices for this provider. You must be associated to the provider to use this endpoint.
     * @param providerId  (required)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @return ProviderInvoiceResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ProviderInvoiceResponse providersRetrieveInvoices(String providerId, Integer skip, List<String> sort, Integer limit) throws ApiException {
        ApiResponse<ProviderInvoiceResponse> resp = providersRetrieveInvoicesWithHttpInfo(providerId, skip, sort, limit);
        return resp.getData();
    }

    /**
     * List a provider&#x27;s invoices.
     * Retrieves a list of invoices for this provider. You must be associated to the provider to use this endpoint.
     * @param providerId  (required)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @return ApiResponse&lt;ProviderInvoiceResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ProviderInvoiceResponse> providersRetrieveInvoicesWithHttpInfo(String providerId, Integer skip, List<String> sort, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = providersRetrieveInvoicesValidateBeforeCall(providerId, skip, sort, limit, null, null);
        Type localVarReturnType = new TypeToken<ProviderInvoiceResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List a provider&#x27;s invoices. (asynchronously)
     * Retrieves a list of invoices for this provider. You must be associated to the provider to use this endpoint.
     * @param providerId  (required)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  (optional)
     * @param limit The number of records to return at once. Limited to 100. (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call providersRetrieveInvoicesAsync(String providerId, Integer skip, List<String> sort, Integer limit, final ApiCallback<ProviderInvoiceResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = providersRetrieveInvoicesValidateBeforeCall(providerId, skip, sort, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ProviderInvoiceResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
