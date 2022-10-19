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


import io.swagger.client.model.SystemInsightsAlf;
import io.swagger.client.model.SystemInsightsAlfExceptions;
import io.swagger.client.model.SystemInsightsAlfExplicitAuths;
import io.swagger.client.model.SystemInsightsAppcompatShims;
import io.swagger.client.model.SystemInsightsApps;
import io.swagger.client.model.SystemInsightsAuthorizedKeys;
import io.swagger.client.model.SystemInsightsAzureInstanceMetadata;
import io.swagger.client.model.SystemInsightsAzureInstanceTags;
import io.swagger.client.model.SystemInsightsBattery;
import io.swagger.client.model.SystemInsightsBitlockerInfo;
import io.swagger.client.model.SystemInsightsBrowserPlugins;
import io.swagger.client.model.SystemInsightsCertificates;
import io.swagger.client.model.SystemInsightsChassisInfo;
import io.swagger.client.model.SystemInsightsChromeExtensions;
import io.swagger.client.model.SystemInsightsConnectivity;
import io.swagger.client.model.SystemInsightsCrashes;
import io.swagger.client.model.SystemInsightsCupsDestinations;
import io.swagger.client.model.SystemInsightsDiskEncryption;
import io.swagger.client.model.SystemInsightsDiskInfo;
import io.swagger.client.model.SystemInsightsDnsResolvers;
import io.swagger.client.model.SystemInsightsEtcHosts;
import io.swagger.client.model.SystemInsightsFirefoxAddons;
import io.swagger.client.model.SystemInsightsGroups;
import io.swagger.client.model.SystemInsightsIeExtensions;
import io.swagger.client.model.SystemInsightsInterfaceAddresses;
import io.swagger.client.model.SystemInsightsInterfaceDetails;
import io.swagger.client.model.SystemInsightsKernelInfo;
import io.swagger.client.model.SystemInsightsLaunchd;
import io.swagger.client.model.SystemInsightsLinuxPackages;
import io.swagger.client.model.SystemInsightsLoggedInUsers;
import io.swagger.client.model.SystemInsightsLogicalDrives;
import io.swagger.client.model.SystemInsightsManagedPolicies;
import io.swagger.client.model.SystemInsightsMounts;
import io.swagger.client.model.SystemInsightsOsVersion;
import io.swagger.client.model.SystemInsightsPatches;
import io.swagger.client.model.SystemInsightsPrograms;
import io.swagger.client.model.SystemInsightsPythonPackages;
import io.swagger.client.model.SystemInsightsSafariExtensions;
import io.swagger.client.model.SystemInsightsScheduledTasks;
import io.swagger.client.model.SystemInsightsSecureboot;
import io.swagger.client.model.SystemInsightsServices;
import io.swagger.client.model.SystemInsightsShadow;
import io.swagger.client.model.SystemInsightsSharedFolders;
import io.swagger.client.model.SystemInsightsSharedResources;
import io.swagger.client.model.SystemInsightsSharingPreferences;
import io.swagger.client.model.SystemInsightsSipConfig;
import io.swagger.client.model.SystemInsightsStartupItems;
import io.swagger.client.model.SystemInsightsSystemControls;
import io.swagger.client.model.SystemInsightsSystemInfo;
import io.swagger.client.model.SystemInsightsTpmInfo;
import io.swagger.client.model.SystemInsightsUptime;
import io.swagger.client.model.SystemInsightsUsbDevices;
import io.swagger.client.model.SystemInsightsUserGroups;
import io.swagger.client.model.SystemInsightsUserSshKeys;
import io.swagger.client.model.SystemInsightsUserassist;
import io.swagger.client.model.SystemInsightsUsers;
import io.swagger.client.model.SystemInsightsWifiNetworks;
import io.swagger.client.model.SystemInsightsWifiStatus;
import io.swagger.client.model.SystemInsightsWindowsSecurityCenter;
import io.swagger.client.model.SystemInsightsWindowsSecurityProducts;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SystemInsightsApi {
    private ApiClient apiClient;

    public SystemInsightsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public SystemInsightsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for systeminsightsListAlf
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListAlfCall(String xOrgId, List<String> filter, Integer skip, List<String> sort, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/alf";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
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
    private com.squareup.okhttp.Call systeminsightsListAlfValidateBeforeCall(String xOrgId, List<String> filter, Integer skip, List<String> sort, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListAlfCall(xOrgId, filter, skip, sort, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights ALF
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;global_state&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsAlf&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsAlf> systeminsightsListAlf(String xOrgId, List<String> filter, Integer skip, List<String> sort, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsAlf>> resp = systeminsightsListAlfWithHttpInfo(xOrgId, filter, skip, sort, limit);
        return resp.getData();
    }

    /**
     * List System Insights ALF
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;global_state&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsAlf&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsAlf>> systeminsightsListAlfWithHttpInfo(String xOrgId, List<String> filter, Integer skip, List<String> sort, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListAlfValidateBeforeCall(xOrgId, filter, skip, sort, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsAlf>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights ALF (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;global_state&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListAlfAsync(String xOrgId, List<String> filter, Integer skip, List<String> sort, Integer limit, final ApiCallback<List<SystemInsightsAlf>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListAlfValidateBeforeCall(xOrgId, filter, skip, sort, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsAlf>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListAlfExceptions
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListAlfExceptionsCall(String xOrgId, List<String> filter, Integer skip, List<String> sort, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/alf_exceptions";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
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
    private com.squareup.okhttp.Call systeminsightsListAlfExceptionsValidateBeforeCall(String xOrgId, List<String> filter, Integer skip, List<String> sort, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListAlfExceptionsCall(xOrgId, filter, skip, sort, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights ALF Exceptions
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;state&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsAlfExceptions&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsAlfExceptions> systeminsightsListAlfExceptions(String xOrgId, List<String> filter, Integer skip, List<String> sort, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsAlfExceptions>> resp = systeminsightsListAlfExceptionsWithHttpInfo(xOrgId, filter, skip, sort, limit);
        return resp.getData();
    }

    /**
     * List System Insights ALF Exceptions
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;state&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsAlfExceptions&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsAlfExceptions>> systeminsightsListAlfExceptionsWithHttpInfo(String xOrgId, List<String> filter, Integer skip, List<String> sort, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListAlfExceptionsValidateBeforeCall(xOrgId, filter, skip, sort, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsAlfExceptions>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights ALF Exceptions (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;state&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListAlfExceptionsAsync(String xOrgId, List<String> filter, Integer skip, List<String> sort, Integer limit, final ApiCallback<List<SystemInsightsAlfExceptions>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListAlfExceptionsValidateBeforeCall(xOrgId, filter, skip, sort, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsAlfExceptions>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListAlfExplicitAuths
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListAlfExplicitAuthsCall(String xOrgId, List<String> filter, Integer skip, List<String> sort, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/alf_explicit_auths";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
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
    private com.squareup.okhttp.Call systeminsightsListAlfExplicitAuthsValidateBeforeCall(String xOrgId, List<String> filter, Integer skip, List<String> sort, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListAlfExplicitAuthsCall(xOrgId, filter, skip, sort, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights ALF Explicit Authentications
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;process&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsAlfExplicitAuths&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsAlfExplicitAuths> systeminsightsListAlfExplicitAuths(String xOrgId, List<String> filter, Integer skip, List<String> sort, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsAlfExplicitAuths>> resp = systeminsightsListAlfExplicitAuthsWithHttpInfo(xOrgId, filter, skip, sort, limit);
        return resp.getData();
    }

    /**
     * List System Insights ALF Explicit Authentications
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;process&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsAlfExplicitAuths&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsAlfExplicitAuths>> systeminsightsListAlfExplicitAuthsWithHttpInfo(String xOrgId, List<String> filter, Integer skip, List<String> sort, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListAlfExplicitAuthsValidateBeforeCall(xOrgId, filter, skip, sort, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsAlfExplicitAuths>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights ALF Explicit Authentications (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;process&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListAlfExplicitAuthsAsync(String xOrgId, List<String> filter, Integer skip, List<String> sort, Integer limit, final ApiCallback<List<SystemInsightsAlfExplicitAuths>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListAlfExplicitAuthsValidateBeforeCall(xOrgId, filter, skip, sort, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsAlfExplicitAuths>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListAppcompatShims
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListAppcompatShimsCall(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/appcompat_shims";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListAppcompatShimsValidateBeforeCall(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListAppcompatShimsCall(xOrgId, skip, sort, filter, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights Application Compatibility Shims
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;enabled&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsAppcompatShims&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsAppcompatShims> systeminsightsListAppcompatShims(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsAppcompatShims>> resp = systeminsightsListAppcompatShimsWithHttpInfo(xOrgId, skip, sort, filter, limit);
        return resp.getData();
    }

    /**
     * List System Insights Application Compatibility Shims
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;enabled&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsAppcompatShims&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsAppcompatShims>> systeminsightsListAppcompatShimsWithHttpInfo(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListAppcompatShimsValidateBeforeCall(xOrgId, skip, sort, filter, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsAppcompatShims>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights Application Compatibility Shims (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;enabled&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListAppcompatShimsAsync(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ApiCallback<List<SystemInsightsAppcompatShims>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListAppcompatShimsValidateBeforeCall(xOrgId, skip, sort, filter, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsAppcompatShims>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListApps
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListAppsCall(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/apps";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListAppsValidateBeforeCall(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListAppsCall(xOrgId, skip, sort, filter, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights Apps
     * Lists all apps for macOS devices. For Windows devices, use [List System Insights Programs](#operation/systeminsights_list_programs).  Valid filter fields are &#x60;system_id&#x60; and &#x60;bundle_name&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsApps&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsApps> systeminsightsListApps(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsApps>> resp = systeminsightsListAppsWithHttpInfo(xOrgId, skip, sort, filter, limit);
        return resp.getData();
    }

    /**
     * List System Insights Apps
     * Lists all apps for macOS devices. For Windows devices, use [List System Insights Programs](#operation/systeminsights_list_programs).  Valid filter fields are &#x60;system_id&#x60; and &#x60;bundle_name&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsApps&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsApps>> systeminsightsListAppsWithHttpInfo(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListAppsValidateBeforeCall(xOrgId, skip, sort, filter, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsApps>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights Apps (asynchronously)
     * Lists all apps for macOS devices. For Windows devices, use [List System Insights Programs](#operation/systeminsights_list_programs).  Valid filter fields are &#x60;system_id&#x60; and &#x60;bundle_name&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListAppsAsync(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ApiCallback<List<SystemInsightsApps>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListAppsValidateBeforeCall(xOrgId, skip, sort, filter, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsApps>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListAuthorizedKeys
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListAuthorizedKeysCall(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/authorized_keys";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListAuthorizedKeysValidateBeforeCall(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListAuthorizedKeysCall(xOrgId, skip, sort, filter, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights Authorized Keys
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;uid&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsAuthorizedKeys&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsAuthorizedKeys> systeminsightsListAuthorizedKeys(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsAuthorizedKeys>> resp = systeminsightsListAuthorizedKeysWithHttpInfo(xOrgId, skip, sort, filter, limit);
        return resp.getData();
    }

    /**
     * List System Insights Authorized Keys
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;uid&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsAuthorizedKeys&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsAuthorizedKeys>> systeminsightsListAuthorizedKeysWithHttpInfo(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListAuthorizedKeysValidateBeforeCall(xOrgId, skip, sort, filter, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsAuthorizedKeys>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights Authorized Keys (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;uid&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListAuthorizedKeysAsync(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ApiCallback<List<SystemInsightsAuthorizedKeys>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListAuthorizedKeysValidateBeforeCall(xOrgId, skip, sort, filter, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsAuthorizedKeys>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListAzureInstanceMetadata
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListAzureInstanceMetadataCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/azure_instance_metadata";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call systeminsightsListAzureInstanceMetadataValidateBeforeCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListAzureInstanceMetadataCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights Azure Instance Metadata
     * Valid filter fields are &#x60;system_id&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsAzureInstanceMetadata&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsAzureInstanceMetadata> systeminsightsListAzureInstanceMetadata(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsAzureInstanceMetadata>> resp = systeminsightsListAzureInstanceMetadataWithHttpInfo(skip, sort, filter, xOrgId, limit);
        return resp.getData();
    }

    /**
     * List System Insights Azure Instance Metadata
     * Valid filter fields are &#x60;system_id&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsAzureInstanceMetadata&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsAzureInstanceMetadata>> systeminsightsListAzureInstanceMetadataWithHttpInfo(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListAzureInstanceMetadataValidateBeforeCall(skip, sort, filter, xOrgId, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsAzureInstanceMetadata>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights Azure Instance Metadata (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListAzureInstanceMetadataAsync(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ApiCallback<List<SystemInsightsAzureInstanceMetadata>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListAzureInstanceMetadataValidateBeforeCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsAzureInstanceMetadata>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListAzureInstanceTags
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListAzureInstanceTagsCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/azure_instance_tags";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call systeminsightsListAzureInstanceTagsValidateBeforeCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListAzureInstanceTagsCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights Azure Instance Tags
     * Valid filter fields are &#x60;system_id&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsAzureInstanceTags&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsAzureInstanceTags> systeminsightsListAzureInstanceTags(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsAzureInstanceTags>> resp = systeminsightsListAzureInstanceTagsWithHttpInfo(skip, sort, filter, xOrgId, limit);
        return resp.getData();
    }

    /**
     * List System Insights Azure Instance Tags
     * Valid filter fields are &#x60;system_id&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsAzureInstanceTags&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsAzureInstanceTags>> systeminsightsListAzureInstanceTagsWithHttpInfo(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListAzureInstanceTagsValidateBeforeCall(skip, sort, filter, xOrgId, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsAzureInstanceTags>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights Azure Instance Tags (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListAzureInstanceTagsAsync(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ApiCallback<List<SystemInsightsAzureInstanceTags>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListAzureInstanceTagsValidateBeforeCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsAzureInstanceTags>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListBattery
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListBatteryCall(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/battery";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListBatteryValidateBeforeCall(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListBatteryCall(xOrgId, skip, sort, filter, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights Battery
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;health&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsBattery&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsBattery> systeminsightsListBattery(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsBattery>> resp = systeminsightsListBatteryWithHttpInfo(xOrgId, skip, sort, filter, limit);
        return resp.getData();
    }

    /**
     * List System Insights Battery
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;health&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsBattery&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsBattery>> systeminsightsListBatteryWithHttpInfo(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListBatteryValidateBeforeCall(xOrgId, skip, sort, filter, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsBattery>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights Battery (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;health&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListBatteryAsync(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ApiCallback<List<SystemInsightsBattery>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListBatteryValidateBeforeCall(xOrgId, skip, sort, filter, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsBattery>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListBitlockerInfo
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListBitlockerInfoCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/bitlocker_info";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListBitlockerInfoValidateBeforeCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListBitlockerInfoCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights Bitlocker Info
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;protection_status&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsBitlockerInfo&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsBitlockerInfo> systeminsightsListBitlockerInfo(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsBitlockerInfo>> resp = systeminsightsListBitlockerInfoWithHttpInfo(skip, sort, filter, xOrgId, limit);
        return resp.getData();
    }

    /**
     * List System Insights Bitlocker Info
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;protection_status&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsBitlockerInfo&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsBitlockerInfo>> systeminsightsListBitlockerInfoWithHttpInfo(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListBitlockerInfoValidateBeforeCall(skip, sort, filter, xOrgId, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsBitlockerInfo>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights Bitlocker Info (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;protection_status&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListBitlockerInfoAsync(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ApiCallback<List<SystemInsightsBitlockerInfo>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListBitlockerInfoValidateBeforeCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsBitlockerInfo>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListBrowserPlugins
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListBrowserPluginsCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/browser_plugins";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListBrowserPluginsValidateBeforeCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListBrowserPluginsCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights Browser Plugins
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;name&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsBrowserPlugins&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsBrowserPlugins> systeminsightsListBrowserPlugins(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsBrowserPlugins>> resp = systeminsightsListBrowserPluginsWithHttpInfo(skip, sort, filter, xOrgId, limit);
        return resp.getData();
    }

    /**
     * List System Insights Browser Plugins
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;name&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsBrowserPlugins&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsBrowserPlugins>> systeminsightsListBrowserPluginsWithHttpInfo(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListBrowserPluginsValidateBeforeCall(skip, sort, filter, xOrgId, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsBrowserPlugins>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights Browser Plugins (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;name&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListBrowserPluginsAsync(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ApiCallback<List<SystemInsightsBrowserPlugins>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListBrowserPluginsValidateBeforeCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsBrowserPlugins>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListCertificates
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60; Note: You can only filter by &#x60;system_id&#x60; and &#x60;common_name&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListCertificatesCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/certificates";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListCertificatesValidateBeforeCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListCertificatesCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights Certificates
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;common_name&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60; Note: You can only filter by &#x60;system_id&#x60; and &#x60;common_name&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsCertificates&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsCertificates> systeminsightsListCertificates(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsCertificates>> resp = systeminsightsListCertificatesWithHttpInfo(skip, sort, filter, xOrgId, limit);
        return resp.getData();
    }

    /**
     * List System Insights Certificates
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;common_name&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60; Note: You can only filter by &#x60;system_id&#x60; and &#x60;common_name&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsCertificates&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsCertificates>> systeminsightsListCertificatesWithHttpInfo(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListCertificatesValidateBeforeCall(skip, sort, filter, xOrgId, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsCertificates>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights Certificates (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;common_name&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60; Note: You can only filter by &#x60;system_id&#x60; and &#x60;common_name&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListCertificatesAsync(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ApiCallback<List<SystemInsightsCertificates>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListCertificatesValidateBeforeCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsCertificates>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListChassisInfo
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListChassisInfoCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/chassis_info";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call systeminsightsListChassisInfoValidateBeforeCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListChassisInfoCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights Chassis Info
     * Valid filter fields are &#x60;system_id&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsChassisInfo&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsChassisInfo> systeminsightsListChassisInfo(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsChassisInfo>> resp = systeminsightsListChassisInfoWithHttpInfo(skip, sort, filter, xOrgId, limit);
        return resp.getData();
    }

    /**
     * List System Insights Chassis Info
     * Valid filter fields are &#x60;system_id&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsChassisInfo&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsChassisInfo>> systeminsightsListChassisInfoWithHttpInfo(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListChassisInfoValidateBeforeCall(skip, sort, filter, xOrgId, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsChassisInfo>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights Chassis Info (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListChassisInfoAsync(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ApiCallback<List<SystemInsightsChassisInfo>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListChassisInfoValidateBeforeCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsChassisInfo>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListChromeExtensions
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListChromeExtensionsCall(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/chrome_extensions";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListChromeExtensionsValidateBeforeCall(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListChromeExtensionsCall(xOrgId, skip, sort, filter, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights Chrome Extensions
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;name&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsChromeExtensions&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsChromeExtensions> systeminsightsListChromeExtensions(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsChromeExtensions>> resp = systeminsightsListChromeExtensionsWithHttpInfo(xOrgId, skip, sort, filter, limit);
        return resp.getData();
    }

    /**
     * List System Insights Chrome Extensions
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;name&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsChromeExtensions&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsChromeExtensions>> systeminsightsListChromeExtensionsWithHttpInfo(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListChromeExtensionsValidateBeforeCall(xOrgId, skip, sort, filter, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsChromeExtensions>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights Chrome Extensions (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;name&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListChromeExtensionsAsync(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ApiCallback<List<SystemInsightsChromeExtensions>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListChromeExtensionsValidateBeforeCall(xOrgId, skip, sort, filter, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsChromeExtensions>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListConnectivity
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListConnectivityCall(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/connectivity";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListConnectivityValidateBeforeCall(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListConnectivityCall(xOrgId, skip, sort, filter, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights Connectivity
     * The only valid filter field is &#x60;system_id&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsConnectivity&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsConnectivity> systeminsightsListConnectivity(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsConnectivity>> resp = systeminsightsListConnectivityWithHttpInfo(xOrgId, skip, sort, filter, limit);
        return resp.getData();
    }

    /**
     * List System Insights Connectivity
     * The only valid filter field is &#x60;system_id&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsConnectivity&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsConnectivity>> systeminsightsListConnectivityWithHttpInfo(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListConnectivityValidateBeforeCall(xOrgId, skip, sort, filter, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsConnectivity>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights Connectivity (asynchronously)
     * The only valid filter field is &#x60;system_id&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListConnectivityAsync(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ApiCallback<List<SystemInsightsConnectivity>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListConnectivityValidateBeforeCall(xOrgId, skip, sort, filter, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsConnectivity>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListCrashes
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListCrashesCall(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/crashes";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListCrashesValidateBeforeCall(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListCrashesCall(xOrgId, skip, sort, filter, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights Crashes
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;identifier&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsCrashes&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsCrashes> systeminsightsListCrashes(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsCrashes>> resp = systeminsightsListCrashesWithHttpInfo(xOrgId, skip, sort, filter, limit);
        return resp.getData();
    }

    /**
     * List System Insights Crashes
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;identifier&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsCrashes&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsCrashes>> systeminsightsListCrashesWithHttpInfo(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListCrashesValidateBeforeCall(xOrgId, skip, sort, filter, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsCrashes>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights Crashes (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;identifier&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListCrashesAsync(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ApiCallback<List<SystemInsightsCrashes>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListCrashesValidateBeforeCall(xOrgId, skip, sort, filter, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsCrashes>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListCupsDestinations
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListCupsDestinationsCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/cups_destinations";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListCupsDestinationsValidateBeforeCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListCupsDestinationsCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights CUPS Destinations
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;name&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsCupsDestinations&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsCupsDestinations> systeminsightsListCupsDestinations(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsCupsDestinations>> resp = systeminsightsListCupsDestinationsWithHttpInfo(skip, sort, filter, xOrgId, limit);
        return resp.getData();
    }

    /**
     * List System Insights CUPS Destinations
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;name&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsCupsDestinations&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsCupsDestinations>> systeminsightsListCupsDestinationsWithHttpInfo(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListCupsDestinationsValidateBeforeCall(skip, sort, filter, xOrgId, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsCupsDestinations>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights CUPS Destinations (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;name&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListCupsDestinationsAsync(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ApiCallback<List<SystemInsightsCupsDestinations>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListCupsDestinationsValidateBeforeCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsCupsDestinations>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListDiskEncryption
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListDiskEncryptionCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/disk_encryption";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListDiskEncryptionValidateBeforeCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListDiskEncryptionCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights Disk Encryption
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;encryption_status&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsDiskEncryption&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsDiskEncryption> systeminsightsListDiskEncryption(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsDiskEncryption>> resp = systeminsightsListDiskEncryptionWithHttpInfo(skip, sort, filter, xOrgId, limit);
        return resp.getData();
    }

    /**
     * List System Insights Disk Encryption
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;encryption_status&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsDiskEncryption&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsDiskEncryption>> systeminsightsListDiskEncryptionWithHttpInfo(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListDiskEncryptionValidateBeforeCall(skip, sort, filter, xOrgId, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsDiskEncryption>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights Disk Encryption (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;encryption_status&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListDiskEncryptionAsync(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ApiCallback<List<SystemInsightsDiskEncryption>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListDiskEncryptionValidateBeforeCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsDiskEncryption>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListDiskInfo
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListDiskInfoCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/disk_info";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListDiskInfoValidateBeforeCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListDiskInfoCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights Disk Info
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;disk_index&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsDiskInfo&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsDiskInfo> systeminsightsListDiskInfo(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsDiskInfo>> resp = systeminsightsListDiskInfoWithHttpInfo(skip, sort, filter, xOrgId, limit);
        return resp.getData();
    }

    /**
     * List System Insights Disk Info
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;disk_index&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsDiskInfo&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsDiskInfo>> systeminsightsListDiskInfoWithHttpInfo(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListDiskInfoValidateBeforeCall(skip, sort, filter, xOrgId, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsDiskInfo>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights Disk Info (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;disk_index&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListDiskInfoAsync(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ApiCallback<List<SystemInsightsDiskInfo>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListDiskInfoValidateBeforeCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsDiskInfo>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListDnsResolvers
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListDnsResolversCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/dns_resolvers";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListDnsResolversValidateBeforeCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListDnsResolversCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights DNS Resolvers
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;type&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsDnsResolvers&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsDnsResolvers> systeminsightsListDnsResolvers(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsDnsResolvers>> resp = systeminsightsListDnsResolversWithHttpInfo(skip, sort, filter, xOrgId, limit);
        return resp.getData();
    }

    /**
     * List System Insights DNS Resolvers
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;type&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsDnsResolvers&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsDnsResolvers>> systeminsightsListDnsResolversWithHttpInfo(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListDnsResolversValidateBeforeCall(skip, sort, filter, xOrgId, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsDnsResolvers>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights DNS Resolvers (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;type&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListDnsResolversAsync(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ApiCallback<List<SystemInsightsDnsResolvers>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListDnsResolversValidateBeforeCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsDnsResolvers>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListEtcHosts
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListEtcHostsCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/etc_hosts";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListEtcHostsValidateBeforeCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListEtcHostsCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights Etc Hosts
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;address&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsEtcHosts&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsEtcHosts> systeminsightsListEtcHosts(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsEtcHosts>> resp = systeminsightsListEtcHostsWithHttpInfo(skip, sort, filter, xOrgId, limit);
        return resp.getData();
    }

    /**
     * List System Insights Etc Hosts
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;address&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsEtcHosts&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsEtcHosts>> systeminsightsListEtcHostsWithHttpInfo(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListEtcHostsValidateBeforeCall(skip, sort, filter, xOrgId, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsEtcHosts>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights Etc Hosts (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;address&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListEtcHostsAsync(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ApiCallback<List<SystemInsightsEtcHosts>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListEtcHostsValidateBeforeCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsEtcHosts>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListFirefoxAddons
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListFirefoxAddonsCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/firefox_addons";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListFirefoxAddonsValidateBeforeCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListFirefoxAddonsCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights Firefox Addons
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;name&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsFirefoxAddons&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsFirefoxAddons> systeminsightsListFirefoxAddons(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsFirefoxAddons>> resp = systeminsightsListFirefoxAddonsWithHttpInfo(skip, sort, filter, xOrgId, limit);
        return resp.getData();
    }

    /**
     * List System Insights Firefox Addons
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;name&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsFirefoxAddons&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsFirefoxAddons>> systeminsightsListFirefoxAddonsWithHttpInfo(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListFirefoxAddonsValidateBeforeCall(skip, sort, filter, xOrgId, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsFirefoxAddons>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights Firefox Addons (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;name&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListFirefoxAddonsAsync(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ApiCallback<List<SystemInsightsFirefoxAddons>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListFirefoxAddonsValidateBeforeCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsFirefoxAddons>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListGroups
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListGroupsCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/groups";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListGroupsValidateBeforeCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListGroupsCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights Groups
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;groupname&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsGroups&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsGroups> systeminsightsListGroups(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsGroups>> resp = systeminsightsListGroupsWithHttpInfo(skip, sort, filter, xOrgId, limit);
        return resp.getData();
    }

    /**
     * List System Insights Groups
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;groupname&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsGroups&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsGroups>> systeminsightsListGroupsWithHttpInfo(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListGroupsValidateBeforeCall(skip, sort, filter, xOrgId, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsGroups>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights Groups (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;groupname&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListGroupsAsync(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ApiCallback<List<SystemInsightsGroups>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListGroupsValidateBeforeCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsGroups>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListIeExtensions
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListIeExtensionsCall(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/ie_extensions";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListIeExtensionsValidateBeforeCall(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListIeExtensionsCall(xOrgId, skip, sort, filter, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights IE Extensions
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;name&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsIeExtensions&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsIeExtensions> systeminsightsListIeExtensions(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsIeExtensions>> resp = systeminsightsListIeExtensionsWithHttpInfo(xOrgId, skip, sort, filter, limit);
        return resp.getData();
    }

    /**
     * List System Insights IE Extensions
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;name&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsIeExtensions&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsIeExtensions>> systeminsightsListIeExtensionsWithHttpInfo(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListIeExtensionsValidateBeforeCall(xOrgId, skip, sort, filter, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsIeExtensions>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights IE Extensions (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;name&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListIeExtensionsAsync(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ApiCallback<List<SystemInsightsIeExtensions>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListIeExtensionsValidateBeforeCall(xOrgId, skip, sort, filter, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsIeExtensions>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListInterfaceAddresses
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListInterfaceAddressesCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/interface_addresses";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListInterfaceAddressesValidateBeforeCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListInterfaceAddressesCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights Interface Addresses
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;address&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsInterfaceAddresses&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsInterfaceAddresses> systeminsightsListInterfaceAddresses(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsInterfaceAddresses>> resp = systeminsightsListInterfaceAddressesWithHttpInfo(skip, sort, filter, xOrgId, limit);
        return resp.getData();
    }

    /**
     * List System Insights Interface Addresses
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;address&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsInterfaceAddresses&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsInterfaceAddresses>> systeminsightsListInterfaceAddressesWithHttpInfo(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListInterfaceAddressesValidateBeforeCall(skip, sort, filter, xOrgId, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsInterfaceAddresses>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights Interface Addresses (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;address&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListInterfaceAddressesAsync(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ApiCallback<List<SystemInsightsInterfaceAddresses>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListInterfaceAddressesValidateBeforeCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsInterfaceAddresses>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListInterfaceDetails
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListInterfaceDetailsCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/interface_details";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListInterfaceDetailsValidateBeforeCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListInterfaceDetailsCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights Interface Details
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;interface&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsInterfaceDetails&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsInterfaceDetails> systeminsightsListInterfaceDetails(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsInterfaceDetails>> resp = systeminsightsListInterfaceDetailsWithHttpInfo(skip, sort, filter, xOrgId, limit);
        return resp.getData();
    }

    /**
     * List System Insights Interface Details
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;interface&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsInterfaceDetails&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsInterfaceDetails>> systeminsightsListInterfaceDetailsWithHttpInfo(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListInterfaceDetailsValidateBeforeCall(skip, sort, filter, xOrgId, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsInterfaceDetails>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights Interface Details (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;interface&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListInterfaceDetailsAsync(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ApiCallback<List<SystemInsightsInterfaceDetails>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListInterfaceDetailsValidateBeforeCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsInterfaceDetails>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListKernelInfo
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListKernelInfoCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/kernel_info";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListKernelInfoValidateBeforeCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListKernelInfoCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights Kernel Info
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;version&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsKernelInfo&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsKernelInfo> systeminsightsListKernelInfo(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsKernelInfo>> resp = systeminsightsListKernelInfoWithHttpInfo(skip, sort, filter, xOrgId, limit);
        return resp.getData();
    }

    /**
     * List System Insights Kernel Info
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;version&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsKernelInfo&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsKernelInfo>> systeminsightsListKernelInfoWithHttpInfo(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListKernelInfoValidateBeforeCall(skip, sort, filter, xOrgId, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsKernelInfo>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights Kernel Info (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;version&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListKernelInfoAsync(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ApiCallback<List<SystemInsightsKernelInfo>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListKernelInfoValidateBeforeCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsKernelInfo>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListLaunchd
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListLaunchdCall(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/launchd";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListLaunchdValidateBeforeCall(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListLaunchdCall(xOrgId, skip, sort, filter, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights Launchd
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;name&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsLaunchd&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsLaunchd> systeminsightsListLaunchd(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsLaunchd>> resp = systeminsightsListLaunchdWithHttpInfo(xOrgId, skip, sort, filter, limit);
        return resp.getData();
    }

    /**
     * List System Insights Launchd
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;name&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsLaunchd&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsLaunchd>> systeminsightsListLaunchdWithHttpInfo(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListLaunchdValidateBeforeCall(xOrgId, skip, sort, filter, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsLaunchd>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights Launchd (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;name&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListLaunchdAsync(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ApiCallback<List<SystemInsightsLaunchd>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListLaunchdValidateBeforeCall(xOrgId, skip, sort, filter, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsLaunchd>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListLinuxPackages
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListLinuxPackagesCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/linux_packages";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListLinuxPackagesValidateBeforeCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListLinuxPackagesCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights Linux Packages
     * Lists all programs for Linux devices. For macOS devices, use [List System Insights System Apps](#operation/systeminsights_list_apps). For windows devices, use [List System Insights System Apps](#operation/systeminsights_list_programs).  Valid filter fields are &#x60;name&#x60; and &#x60;package_format&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsLinuxPackages&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsLinuxPackages> systeminsightsListLinuxPackages(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsLinuxPackages>> resp = systeminsightsListLinuxPackagesWithHttpInfo(skip, sort, filter, xOrgId, limit);
        return resp.getData();
    }

    /**
     * List System Insights Linux Packages
     * Lists all programs for Linux devices. For macOS devices, use [List System Insights System Apps](#operation/systeminsights_list_apps). For windows devices, use [List System Insights System Apps](#operation/systeminsights_list_programs).  Valid filter fields are &#x60;name&#x60; and &#x60;package_format&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsLinuxPackages&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsLinuxPackages>> systeminsightsListLinuxPackagesWithHttpInfo(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListLinuxPackagesValidateBeforeCall(skip, sort, filter, xOrgId, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsLinuxPackages>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights Linux Packages (asynchronously)
     * Lists all programs for Linux devices. For macOS devices, use [List System Insights System Apps](#operation/systeminsights_list_apps). For windows devices, use [List System Insights System Apps](#operation/systeminsights_list_programs).  Valid filter fields are &#x60;name&#x60; and &#x60;package_format&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListLinuxPackagesAsync(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ApiCallback<List<SystemInsightsLinuxPackages>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListLinuxPackagesValidateBeforeCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsLinuxPackages>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListLoggedInUsers
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListLoggedInUsersCall(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/logged_in_users";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListLoggedInUsersValidateBeforeCall(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListLoggedInUsersCall(xOrgId, skip, sort, filter, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights Logged-In Users
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;user&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsLoggedInUsers&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsLoggedInUsers> systeminsightsListLoggedInUsers(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsLoggedInUsers>> resp = systeminsightsListLoggedInUsersWithHttpInfo(xOrgId, skip, sort, filter, limit);
        return resp.getData();
    }

    /**
     * List System Insights Logged-In Users
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;user&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsLoggedInUsers&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsLoggedInUsers>> systeminsightsListLoggedInUsersWithHttpInfo(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListLoggedInUsersValidateBeforeCall(xOrgId, skip, sort, filter, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsLoggedInUsers>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights Logged-In Users (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;user&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListLoggedInUsersAsync(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ApiCallback<List<SystemInsightsLoggedInUsers>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListLoggedInUsersValidateBeforeCall(xOrgId, skip, sort, filter, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsLoggedInUsers>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListLogicalDrives
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListLogicalDrivesCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/logical_drives";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListLogicalDrivesValidateBeforeCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListLogicalDrivesCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights Logical Drives
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;device_id&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsLogicalDrives&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsLogicalDrives> systeminsightsListLogicalDrives(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsLogicalDrives>> resp = systeminsightsListLogicalDrivesWithHttpInfo(skip, sort, filter, xOrgId, limit);
        return resp.getData();
    }

    /**
     * List System Insights Logical Drives
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;device_id&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsLogicalDrives&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsLogicalDrives>> systeminsightsListLogicalDrivesWithHttpInfo(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListLogicalDrivesValidateBeforeCall(skip, sort, filter, xOrgId, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsLogicalDrives>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights Logical Drives (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;device_id&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListLogicalDrivesAsync(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ApiCallback<List<SystemInsightsLogicalDrives>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListLogicalDrivesValidateBeforeCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsLogicalDrives>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListManagedPolicies
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListManagedPoliciesCall(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/managed_policies";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListManagedPoliciesValidateBeforeCall(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListManagedPoliciesCall(xOrgId, skip, sort, filter, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights Managed Policies
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;domain&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsManagedPolicies&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsManagedPolicies> systeminsightsListManagedPolicies(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsManagedPolicies>> resp = systeminsightsListManagedPoliciesWithHttpInfo(xOrgId, skip, sort, filter, limit);
        return resp.getData();
    }

    /**
     * List System Insights Managed Policies
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;domain&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsManagedPolicies&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsManagedPolicies>> systeminsightsListManagedPoliciesWithHttpInfo(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListManagedPoliciesValidateBeforeCall(xOrgId, skip, sort, filter, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsManagedPolicies>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights Managed Policies (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;domain&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListManagedPoliciesAsync(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ApiCallback<List<SystemInsightsManagedPolicies>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListManagedPoliciesValidateBeforeCall(xOrgId, skip, sort, filter, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsManagedPolicies>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListMounts
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListMountsCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/mounts";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListMountsValidateBeforeCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListMountsCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights Mounts
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;path&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsMounts&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsMounts> systeminsightsListMounts(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsMounts>> resp = systeminsightsListMountsWithHttpInfo(skip, sort, filter, xOrgId, limit);
        return resp.getData();
    }

    /**
     * List System Insights Mounts
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;path&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsMounts&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsMounts>> systeminsightsListMountsWithHttpInfo(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListMountsValidateBeforeCall(skip, sort, filter, xOrgId, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsMounts>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights Mounts (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;path&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListMountsAsync(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ApiCallback<List<SystemInsightsMounts>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListMountsValidateBeforeCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsMounts>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListOsVersion
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListOsVersionCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/os_version";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListOsVersionValidateBeforeCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListOsVersionCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights OS Version
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;version&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsOsVersion&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsOsVersion> systeminsightsListOsVersion(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsOsVersion>> resp = systeminsightsListOsVersionWithHttpInfo(skip, sort, filter, xOrgId, limit);
        return resp.getData();
    }

    /**
     * List System Insights OS Version
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;version&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsOsVersion&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsOsVersion>> systeminsightsListOsVersionWithHttpInfo(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListOsVersionValidateBeforeCall(skip, sort, filter, xOrgId, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsOsVersion>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights OS Version (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;version&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListOsVersionAsync(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ApiCallback<List<SystemInsightsOsVersion>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListOsVersionValidateBeforeCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsOsVersion>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListPatches
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListPatchesCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/patches";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListPatchesValidateBeforeCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListPatchesCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights Patches
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;hotfix_id&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsPatches&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsPatches> systeminsightsListPatches(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsPatches>> resp = systeminsightsListPatchesWithHttpInfo(skip, sort, filter, xOrgId, limit);
        return resp.getData();
    }

    /**
     * List System Insights Patches
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;hotfix_id&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsPatches&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsPatches>> systeminsightsListPatchesWithHttpInfo(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListPatchesValidateBeforeCall(skip, sort, filter, xOrgId, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsPatches>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights Patches (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;hotfix_id&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListPatchesAsync(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ApiCallback<List<SystemInsightsPatches>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListPatchesValidateBeforeCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsPatches>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListPrograms
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListProgramsCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/programs";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListProgramsValidateBeforeCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListProgramsCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights Programs
     * Lists all programs for Windows devices. For macOS devices, use [List System Insights Apps](#operation/systeminsights_list_apps).  Valid filter fields are &#x60;system_id&#x60; and &#x60;name&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsPrograms&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsPrograms> systeminsightsListPrograms(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsPrograms>> resp = systeminsightsListProgramsWithHttpInfo(skip, sort, filter, xOrgId, limit);
        return resp.getData();
    }

    /**
     * List System Insights Programs
     * Lists all programs for Windows devices. For macOS devices, use [List System Insights Apps](#operation/systeminsights_list_apps).  Valid filter fields are &#x60;system_id&#x60; and &#x60;name&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsPrograms&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsPrograms>> systeminsightsListProgramsWithHttpInfo(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListProgramsValidateBeforeCall(skip, sort, filter, xOrgId, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsPrograms>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights Programs (asynchronously)
     * Lists all programs for Windows devices. For macOS devices, use [List System Insights Apps](#operation/systeminsights_list_apps).  Valid filter fields are &#x60;system_id&#x60; and &#x60;name&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListProgramsAsync(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ApiCallback<List<SystemInsightsPrograms>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListProgramsValidateBeforeCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsPrograms>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListPythonPackages
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListPythonPackagesCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/python_packages";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListPythonPackagesValidateBeforeCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListPythonPackagesCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights Python Packages
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;name&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsPythonPackages&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsPythonPackages> systeminsightsListPythonPackages(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsPythonPackages>> resp = systeminsightsListPythonPackagesWithHttpInfo(skip, sort, filter, xOrgId, limit);
        return resp.getData();
    }

    /**
     * List System Insights Python Packages
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;name&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsPythonPackages&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsPythonPackages>> systeminsightsListPythonPackagesWithHttpInfo(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListPythonPackagesValidateBeforeCall(skip, sort, filter, xOrgId, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsPythonPackages>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights Python Packages (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;name&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListPythonPackagesAsync(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ApiCallback<List<SystemInsightsPythonPackages>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListPythonPackagesValidateBeforeCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsPythonPackages>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListSafariExtensions
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListSafariExtensionsCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/safari_extensions";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListSafariExtensionsValidateBeforeCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListSafariExtensionsCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights Safari Extensions
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;name&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsSafariExtensions&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsSafariExtensions> systeminsightsListSafariExtensions(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsSafariExtensions>> resp = systeminsightsListSafariExtensionsWithHttpInfo(skip, sort, filter, xOrgId, limit);
        return resp.getData();
    }

    /**
     * List System Insights Safari Extensions
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;name&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsSafariExtensions&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsSafariExtensions>> systeminsightsListSafariExtensionsWithHttpInfo(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListSafariExtensionsValidateBeforeCall(skip, sort, filter, xOrgId, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsSafariExtensions>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights Safari Extensions (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;name&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListSafariExtensionsAsync(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ApiCallback<List<SystemInsightsSafariExtensions>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListSafariExtensionsValidateBeforeCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsSafariExtensions>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListScheduledTasks
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListScheduledTasksCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/scheduled_tasks";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListScheduledTasksValidateBeforeCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListScheduledTasksCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights Scheduled Tasks
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;enabled&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsScheduledTasks&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsScheduledTasks> systeminsightsListScheduledTasks(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsScheduledTasks>> resp = systeminsightsListScheduledTasksWithHttpInfo(skip, sort, filter, xOrgId, limit);
        return resp.getData();
    }

    /**
     * List System Insights Scheduled Tasks
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;enabled&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsScheduledTasks&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsScheduledTasks>> systeminsightsListScheduledTasksWithHttpInfo(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListScheduledTasksValidateBeforeCall(skip, sort, filter, xOrgId, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsScheduledTasks>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights Scheduled Tasks (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;enabled&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListScheduledTasksAsync(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ApiCallback<List<SystemInsightsScheduledTasks>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListScheduledTasksValidateBeforeCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsScheduledTasks>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListSecureboot
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListSecurebootCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/secureboot";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call systeminsightsListSecurebootValidateBeforeCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListSecurebootCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights Secure Boot
     * Valid filter fields are &#x60;system_id&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsSecureboot&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsSecureboot> systeminsightsListSecureboot(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsSecureboot>> resp = systeminsightsListSecurebootWithHttpInfo(skip, sort, filter, xOrgId, limit);
        return resp.getData();
    }

    /**
     * List System Insights Secure Boot
     * Valid filter fields are &#x60;system_id&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsSecureboot&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsSecureboot>> systeminsightsListSecurebootWithHttpInfo(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListSecurebootValidateBeforeCall(skip, sort, filter, xOrgId, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsSecureboot>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights Secure Boot (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListSecurebootAsync(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ApiCallback<List<SystemInsightsSecureboot>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListSecurebootValidateBeforeCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsSecureboot>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListServices
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListServicesCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/services";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListServicesValidateBeforeCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListServicesCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights Services
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;name&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsServices&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsServices> systeminsightsListServices(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsServices>> resp = systeminsightsListServicesWithHttpInfo(skip, sort, filter, xOrgId, limit);
        return resp.getData();
    }

    /**
     * List System Insights Services
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;name&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsServices&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsServices>> systeminsightsListServicesWithHttpInfo(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListServicesValidateBeforeCall(skip, sort, filter, xOrgId, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsServices>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights Services (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;name&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListServicesAsync(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ApiCallback<List<SystemInsightsServices>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListServicesValidateBeforeCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsServices>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListShadow
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListShadowCall(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/shadow";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListShadowValidateBeforeCall(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListShadowCall(xOrgId, skip, sort, filter, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * LIst System Insights Shadow
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;username&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsShadow&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsShadow> systeminsightsListShadow(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsShadow>> resp = systeminsightsListShadowWithHttpInfo(xOrgId, skip, sort, filter, limit);
        return resp.getData();
    }

    /**
     * LIst System Insights Shadow
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;username&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsShadow&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsShadow>> systeminsightsListShadowWithHttpInfo(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListShadowValidateBeforeCall(xOrgId, skip, sort, filter, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsShadow>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * LIst System Insights Shadow (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;username&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListShadowAsync(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ApiCallback<List<SystemInsightsShadow>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListShadowValidateBeforeCall(xOrgId, skip, sort, filter, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsShadow>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListSharedFolders
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListSharedFoldersCall(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/shared_folders";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListSharedFoldersValidateBeforeCall(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListSharedFoldersCall(xOrgId, skip, sort, filter, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights Shared Folders
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;name&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsSharedFolders&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsSharedFolders> systeminsightsListSharedFolders(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsSharedFolders>> resp = systeminsightsListSharedFoldersWithHttpInfo(xOrgId, skip, sort, filter, limit);
        return resp.getData();
    }

    /**
     * List System Insights Shared Folders
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;name&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsSharedFolders&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsSharedFolders>> systeminsightsListSharedFoldersWithHttpInfo(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListSharedFoldersValidateBeforeCall(xOrgId, skip, sort, filter, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsSharedFolders>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights Shared Folders (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;name&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListSharedFoldersAsync(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ApiCallback<List<SystemInsightsSharedFolders>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListSharedFoldersValidateBeforeCall(xOrgId, skip, sort, filter, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsSharedFolders>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListSharedResources
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListSharedResourcesCall(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/shared_resources";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call systeminsightsListSharedResourcesValidateBeforeCall(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListSharedResourcesCall(xOrgId, skip, sort, filter, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights Shared Resources
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;type&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsSharedResources&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsSharedResources> systeminsightsListSharedResources(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsSharedResources>> resp = systeminsightsListSharedResourcesWithHttpInfo(xOrgId, skip, sort, filter, limit);
        return resp.getData();
    }

    /**
     * List System Insights Shared Resources
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;type&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsSharedResources&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsSharedResources>> systeminsightsListSharedResourcesWithHttpInfo(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListSharedResourcesValidateBeforeCall(xOrgId, skip, sort, filter, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsSharedResources>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights Shared Resources (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;type&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListSharedResourcesAsync(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ApiCallback<List<SystemInsightsSharedResources>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListSharedResourcesValidateBeforeCall(xOrgId, skip, sort, filter, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsSharedResources>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListSharingPreferences
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListSharingPreferencesCall(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/sharing_preferences";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListSharingPreferencesValidateBeforeCall(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListSharingPreferencesCall(xOrgId, skip, sort, filter, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights Sharing Preferences
     * Only valid filed field is &#x60;system_id&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsSharingPreferences&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsSharingPreferences> systeminsightsListSharingPreferences(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsSharingPreferences>> resp = systeminsightsListSharingPreferencesWithHttpInfo(xOrgId, skip, sort, filter, limit);
        return resp.getData();
    }

    /**
     * List System Insights Sharing Preferences
     * Only valid filed field is &#x60;system_id&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsSharingPreferences&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsSharingPreferences>> systeminsightsListSharingPreferencesWithHttpInfo(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListSharingPreferencesValidateBeforeCall(xOrgId, skip, sort, filter, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsSharingPreferences>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights Sharing Preferences (asynchronously)
     * Only valid filed field is &#x60;system_id&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListSharingPreferencesAsync(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ApiCallback<List<SystemInsightsSharingPreferences>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListSharingPreferencesValidateBeforeCall(xOrgId, skip, sort, filter, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsSharingPreferences>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListSipConfig
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListSipConfigCall(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/sip_config";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListSipConfigValidateBeforeCall(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListSipConfigCall(xOrgId, skip, sort, filter, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights SIP Config
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;enabled&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsSipConfig&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsSipConfig> systeminsightsListSipConfig(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsSipConfig>> resp = systeminsightsListSipConfigWithHttpInfo(xOrgId, skip, sort, filter, limit);
        return resp.getData();
    }

    /**
     * List System Insights SIP Config
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;enabled&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsSipConfig&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsSipConfig>> systeminsightsListSipConfigWithHttpInfo(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListSipConfigValidateBeforeCall(xOrgId, skip, sort, filter, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsSipConfig>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights SIP Config (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;enabled&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListSipConfigAsync(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ApiCallback<List<SystemInsightsSipConfig>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListSipConfigValidateBeforeCall(xOrgId, skip, sort, filter, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsSipConfig>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListStartupItems
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListStartupItemsCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/startup_items";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListStartupItemsValidateBeforeCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListStartupItemsCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights Startup Items
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;name&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsStartupItems&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsStartupItems> systeminsightsListStartupItems(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsStartupItems>> resp = systeminsightsListStartupItemsWithHttpInfo(skip, sort, filter, xOrgId, limit);
        return resp.getData();
    }

    /**
     * List System Insights Startup Items
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;name&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsStartupItems&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsStartupItems>> systeminsightsListStartupItemsWithHttpInfo(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListStartupItemsValidateBeforeCall(skip, sort, filter, xOrgId, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsStartupItems>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights Startup Items (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;name&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListStartupItemsAsync(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ApiCallback<List<SystemInsightsStartupItems>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListStartupItemsValidateBeforeCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsStartupItems>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListSystemControls
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60; Note: You can only filter by &#x60;system_id&#x60; and &#x60;name&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListSystemControlsCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/system_controls";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListSystemControlsValidateBeforeCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListSystemControlsCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights System Control
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;name&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60; Note: You can only filter by &#x60;system_id&#x60; and &#x60;name&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsSystemControls&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsSystemControls> systeminsightsListSystemControls(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsSystemControls>> resp = systeminsightsListSystemControlsWithHttpInfo(skip, sort, filter, xOrgId, limit);
        return resp.getData();
    }

    /**
     * List System Insights System Control
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;name&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60; Note: You can only filter by &#x60;system_id&#x60; and &#x60;name&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsSystemControls&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsSystemControls>> systeminsightsListSystemControlsWithHttpInfo(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListSystemControlsValidateBeforeCall(skip, sort, filter, xOrgId, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsSystemControls>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights System Control (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;name&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60; Note: You can only filter by &#x60;system_id&#x60; and &#x60;name&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListSystemControlsAsync(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ApiCallback<List<SystemInsightsSystemControls>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListSystemControlsValidateBeforeCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsSystemControls>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListSystemInfo
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListSystemInfoCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/system_info";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListSystemInfoValidateBeforeCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListSystemInfoCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights System Info
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;cpu_subtype&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsSystemInfo&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsSystemInfo> systeminsightsListSystemInfo(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsSystemInfo>> resp = systeminsightsListSystemInfoWithHttpInfo(skip, sort, filter, xOrgId, limit);
        return resp.getData();
    }

    /**
     * List System Insights System Info
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;cpu_subtype&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsSystemInfo&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsSystemInfo>> systeminsightsListSystemInfoWithHttpInfo(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListSystemInfoValidateBeforeCall(skip, sort, filter, xOrgId, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsSystemInfo>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights System Info (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;cpu_subtype&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListSystemInfoAsync(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ApiCallback<List<SystemInsightsSystemInfo>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListSystemInfoValidateBeforeCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsSystemInfo>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListTpmInfo
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListTpmInfoCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/tpm_info";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (xOrgId != null)
        localVarHeaderParams.put("x-org-id", apiClient.parameterToString(xOrgId));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "text/html"
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

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call systeminsightsListTpmInfoValidateBeforeCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListTpmInfoCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights TPM Info
     * Valid filter fields are &#x60;system_id&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsTpmInfo&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsTpmInfo> systeminsightsListTpmInfo(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsTpmInfo>> resp = systeminsightsListTpmInfoWithHttpInfo(skip, sort, filter, xOrgId, limit);
        return resp.getData();
    }

    /**
     * List System Insights TPM Info
     * Valid filter fields are &#x60;system_id&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsTpmInfo&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsTpmInfo>> systeminsightsListTpmInfoWithHttpInfo(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListTpmInfoValidateBeforeCall(skip, sort, filter, xOrgId, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsTpmInfo>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights TPM Info (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListTpmInfoAsync(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ApiCallback<List<SystemInsightsTpmInfo>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListTpmInfoValidateBeforeCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsTpmInfo>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListUptime
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, gte, in. e.g: Filter for single value: &#x60;filter&#x3D;field:gte:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListUptimeCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/uptime";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListUptimeValidateBeforeCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListUptimeCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights Uptime
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;days&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, gte, in. e.g: Filter for single value: &#x60;filter&#x3D;field:gte:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsUptime&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsUptime> systeminsightsListUptime(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsUptime>> resp = systeminsightsListUptimeWithHttpInfo(skip, sort, filter, xOrgId, limit);
        return resp.getData();
    }

    /**
     * List System Insights Uptime
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;days&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, gte, in. e.g: Filter for single value: &#x60;filter&#x3D;field:gte:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsUptime&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsUptime>> systeminsightsListUptimeWithHttpInfo(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListUptimeValidateBeforeCall(skip, sort, filter, xOrgId, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsUptime>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights Uptime (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;days&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, gte, in. e.g: Filter for single value: &#x60;filter&#x3D;field:gte:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListUptimeAsync(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ApiCallback<List<SystemInsightsUptime>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListUptimeValidateBeforeCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsUptime>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListUsbDevices
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListUsbDevicesCall(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/usb_devices";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListUsbDevicesValidateBeforeCall(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListUsbDevicesCall(xOrgId, skip, sort, filter, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights USB Devices
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;model&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsUsbDevices&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsUsbDevices> systeminsightsListUsbDevices(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsUsbDevices>> resp = systeminsightsListUsbDevicesWithHttpInfo(xOrgId, skip, sort, filter, limit);
        return resp.getData();
    }

    /**
     * List System Insights USB Devices
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;model&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsUsbDevices&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsUsbDevices>> systeminsightsListUsbDevicesWithHttpInfo(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListUsbDevicesValidateBeforeCall(xOrgId, skip, sort, filter, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsUsbDevices>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights USB Devices (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;model&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListUsbDevicesAsync(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ApiCallback<List<SystemInsightsUsbDevices>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListUsbDevicesValidateBeforeCall(xOrgId, skip, sort, filter, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsUsbDevices>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListUserGroups
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListUserGroupsCall(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/user_groups";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListUserGroupsValidateBeforeCall(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListUserGroupsCall(xOrgId, skip, sort, filter, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights User Groups
     * Only valid filter field is &#x60;system_id&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsUserGroups&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsUserGroups> systeminsightsListUserGroups(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsUserGroups>> resp = systeminsightsListUserGroupsWithHttpInfo(xOrgId, skip, sort, filter, limit);
        return resp.getData();
    }

    /**
     * List System Insights User Groups
     * Only valid filter field is &#x60;system_id&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsUserGroups&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsUserGroups>> systeminsightsListUserGroupsWithHttpInfo(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListUserGroupsValidateBeforeCall(xOrgId, skip, sort, filter, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsUserGroups>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights User Groups (asynchronously)
     * Only valid filter field is &#x60;system_id&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListUserGroupsAsync(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ApiCallback<List<SystemInsightsUserGroups>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListUserGroupsValidateBeforeCall(xOrgId, skip, sort, filter, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsUserGroups>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListUserSshKeys
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListUserSshKeysCall(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/user_ssh_keys";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListUserSshKeysValidateBeforeCall(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListUserSshKeysCall(xOrgId, skip, sort, filter, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights User SSH Keys
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;uid&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsUserSshKeys&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsUserSshKeys> systeminsightsListUserSshKeys(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsUserSshKeys>> resp = systeminsightsListUserSshKeysWithHttpInfo(xOrgId, skip, sort, filter, limit);
        return resp.getData();
    }

    /**
     * List System Insights User SSH Keys
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;uid&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsUserSshKeys&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsUserSshKeys>> systeminsightsListUserSshKeysWithHttpInfo(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListUserSshKeysValidateBeforeCall(xOrgId, skip, sort, filter, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsUserSshKeys>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights User SSH Keys (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;uid&#x60;.
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListUserSshKeysAsync(String xOrgId, Integer skip, List<String> sort, List<String> filter, Integer limit, final ApiCallback<List<SystemInsightsUserSshKeys>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListUserSshKeysValidateBeforeCall(xOrgId, skip, sort, filter, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsUserSshKeys>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListUserassist
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListUserassistCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/userassist";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call systeminsightsListUserassistValidateBeforeCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListUserassistCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights User Assist
     * Valid filter fields are &#x60;system_id&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsUserassist&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsUserassist> systeminsightsListUserassist(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsUserassist>> resp = systeminsightsListUserassistWithHttpInfo(skip, sort, filter, xOrgId, limit);
        return resp.getData();
    }

    /**
     * List System Insights User Assist
     * Valid filter fields are &#x60;system_id&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsUserassist&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsUserassist>> systeminsightsListUserassistWithHttpInfo(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListUserassistValidateBeforeCall(skip, sort, filter, xOrgId, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsUserassist>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights User Assist (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListUserassistAsync(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ApiCallback<List<SystemInsightsUserassist>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListUserassistValidateBeforeCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsUserassist>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListUsers
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListUsersCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/users";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListUsersValidateBeforeCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListUsersCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights Users
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;username&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsUsers&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsUsers> systeminsightsListUsers(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsUsers>> resp = systeminsightsListUsersWithHttpInfo(skip, sort, filter, xOrgId, limit);
        return resp.getData();
    }

    /**
     * List System Insights Users
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;username&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsUsers&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsUsers>> systeminsightsListUsersWithHttpInfo(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListUsersValidateBeforeCall(skip, sort, filter, xOrgId, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsUsers>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights Users (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;username&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListUsersAsync(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ApiCallback<List<SystemInsightsUsers>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListUsersValidateBeforeCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsUsers>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListWifiNetworks
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListWifiNetworksCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/wifi_networks";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListWifiNetworksValidateBeforeCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListWifiNetworksCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights WiFi Networks
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;security_type&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsWifiNetworks&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsWifiNetworks> systeminsightsListWifiNetworks(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsWifiNetworks>> resp = systeminsightsListWifiNetworksWithHttpInfo(skip, sort, filter, xOrgId, limit);
        return resp.getData();
    }

    /**
     * List System Insights WiFi Networks
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;security_type&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsWifiNetworks&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsWifiNetworks>> systeminsightsListWifiNetworksWithHttpInfo(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListWifiNetworksValidateBeforeCall(skip, sort, filter, xOrgId, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsWifiNetworks>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights WiFi Networks (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;security_type&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListWifiNetworksAsync(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ApiCallback<List<SystemInsightsWifiNetworks>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListWifiNetworksValidateBeforeCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsWifiNetworks>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListWifiStatus
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListWifiStatusCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/wifi_status";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListWifiStatusValidateBeforeCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListWifiStatusCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights WiFi Status
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;security_type&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsWifiStatus&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsWifiStatus> systeminsightsListWifiStatus(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsWifiStatus>> resp = systeminsightsListWifiStatusWithHttpInfo(skip, sort, filter, xOrgId, limit);
        return resp.getData();
    }

    /**
     * List System Insights WiFi Status
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;security_type&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsWifiStatus&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsWifiStatus>> systeminsightsListWifiStatusWithHttpInfo(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListWifiStatusValidateBeforeCall(skip, sort, filter, xOrgId, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsWifiStatus>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights WiFi Status (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;security_type&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListWifiStatusAsync(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ApiCallback<List<SystemInsightsWifiStatus>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListWifiStatusValidateBeforeCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsWifiStatus>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListWindowsSecurityCenter
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListWindowsSecurityCenterCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/windows_security_center";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call systeminsightsListWindowsSecurityCenterValidateBeforeCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListWindowsSecurityCenterCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights Windows Security Center
     * Valid filter fields are &#x60;system_id&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsWindowsSecurityCenter&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsWindowsSecurityCenter> systeminsightsListWindowsSecurityCenter(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsWindowsSecurityCenter>> resp = systeminsightsListWindowsSecurityCenterWithHttpInfo(skip, sort, filter, xOrgId, limit);
        return resp.getData();
    }

    /**
     * List System Insights Windows Security Center
     * Valid filter fields are &#x60;system_id&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsWindowsSecurityCenter&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsWindowsSecurityCenter>> systeminsightsListWindowsSecurityCenterWithHttpInfo(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListWindowsSecurityCenterValidateBeforeCall(skip, sort, filter, xOrgId, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsWindowsSecurityCenter>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights Windows Security Center (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListWindowsSecurityCenterAsync(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ApiCallback<List<SystemInsightsWindowsSecurityCenter>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListWindowsSecurityCenterValidateBeforeCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsWindowsSecurityCenter>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for systeminsightsListWindowsSecurityProducts
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListWindowsSecurityProductsCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/systeminsights/windows_security_products";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (sort != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sort", sort));
        if (filter != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "filter", filter));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call systeminsightsListWindowsSecurityProductsValidateBeforeCall(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = systeminsightsListWindowsSecurityProductsCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List System Insights Windows Security Products
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;state&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return List&lt;SystemInsightsWindowsSecurityProducts&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SystemInsightsWindowsSecurityProducts> systeminsightsListWindowsSecurityProducts(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        ApiResponse<List<SystemInsightsWindowsSecurityProducts>> resp = systeminsightsListWindowsSecurityProductsWithHttpInfo(skip, sort, filter, xOrgId, limit);
        return resp.getData();
    }

    /**
     * List System Insights Windows Security Products
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;state&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @return ApiResponse&lt;List&lt;SystemInsightsWindowsSecurityProducts&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SystemInsightsWindowsSecurityProducts>> systeminsightsListWindowsSecurityProductsWithHttpInfo(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = systeminsightsListWindowsSecurityProductsValidateBeforeCall(skip, sort, filter, xOrgId, limit, null, null);
        Type localVarReturnType = new TypeToken<List<SystemInsightsWindowsSecurityProducts>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List System Insights Windows Security Products (asynchronously)
     * Valid filter fields are &#x60;system_id&#x60; and &#x60;state&#x60;.
     * @param skip The offset into the records to return. (optional, default to 0)
     * @param sort The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending. e.g: Sort by single field: &#x60;sort&#x3D;field&#x60; Sort descending by single field: &#x60;sort&#x3D;-field&#x60; Sort by multiple fields: &#x60;sort&#x3D;field1,-field2,field3&#x60;  (optional)
     * @param filter Supported operators are: eq, in. e.g: Filter for single value: &#x60;filter&#x3D;field:eq:value&#x60; Filter for any value in a list: (note \&quot;pipe\&quot; character: &#x60;|&#x60; separating values) &#x60;filter&#x3D;field:in:value1|value2|value3&#x60;  (optional)
     * @param xOrgId Organization identifier that can be obtained from console settings. (optional)
     * @param limit  (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call systeminsightsListWindowsSecurityProductsAsync(Integer skip, List<String> sort, List<String> filter, String xOrgId, Integer limit, final ApiCallback<List<SystemInsightsWindowsSecurityProducts>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = systeminsightsListWindowsSecurityProductsValidateBeforeCall(skip, sort, filter, xOrgId, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SystemInsightsWindowsSecurityProducts>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
