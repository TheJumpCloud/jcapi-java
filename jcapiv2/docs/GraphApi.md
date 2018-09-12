# GraphApi

All URIs are relative to *https://console.jumpcloud.com/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**graphActiveDirectoryAssociationsList**](GraphApi.md#graphActiveDirectoryAssociationsList) | **GET** /activedirectories/{activedirectory_id}/associations | List the associations of an Active Directory instance
[**graphActiveDirectoryAssociationsPost**](GraphApi.md#graphActiveDirectoryAssociationsPost) | **POST** /activedirectories/{activedirectory_id}/associations | Manage the associations of an Active Directory instance
[**graphActiveDirectoryTraverseUserGroup**](GraphApi.md#graphActiveDirectoryTraverseUserGroup) | **GET** /activedirectories/{activedirectory_id}/usergroups | List the User Groups bound to an Active Directory instance
[**graphApplicationAssociationsList**](GraphApi.md#graphApplicationAssociationsList) | **GET** /applications/{application_id}/associations | List the associations of an Application
[**graphApplicationAssociationsPost**](GraphApi.md#graphApplicationAssociationsPost) | **POST** /applications/{application_id}/associations | Manage the associations of an Application
[**graphApplicationTraverseUser**](GraphApi.md#graphApplicationTraverseUser) | **GET** /applications/{application_id}/users | List the Users bound to an Application
[**graphApplicationTraverseUserGroup**](GraphApi.md#graphApplicationTraverseUserGroup) | **GET** /applications/{application_id}/usergroups | List the User Groups bound to an Application
[**graphCommandAssociationsList**](GraphApi.md#graphCommandAssociationsList) | **GET** /commands/{command_id}/associations | List the associations of a Command
[**graphCommandAssociationsPost**](GraphApi.md#graphCommandAssociationsPost) | **POST** /commands/{command_id}/associations | Manage the associations of a Command
[**graphCommandTraverseSystem**](GraphApi.md#graphCommandTraverseSystem) | **GET** /commands/{command_id}/systems | List the Systems bound to a Command
[**graphCommandTraverseSystemGroup**](GraphApi.md#graphCommandTraverseSystemGroup) | **GET** /commands/{command_id}/systemgroups | List the System Groups bound to a Command
[**graphGSuiteAssociationsList**](GraphApi.md#graphGSuiteAssociationsList) | **GET** /gsuites/{gsuite_id}/associations | List the associations of a G Suite instance
[**graphGSuiteAssociationsPost**](GraphApi.md#graphGSuiteAssociationsPost) | **POST** /gsuites/{gsuite_id}/associations | Manage the associations of a G Suite instance
[**graphGSuiteTraverseUser**](GraphApi.md#graphGSuiteTraverseUser) | **GET** /gsuites/{gsuite_id}/users | List the Users bound to a G Suite instance
[**graphGSuiteTraverseUserGroup**](GraphApi.md#graphGSuiteTraverseUserGroup) | **GET** /gsuites/{gsuite_id}/usergroups | List the User Groups bound to a G Suite instance
[**graphLdapServerAssociationsList**](GraphApi.md#graphLdapServerAssociationsList) | **GET** /ldapservers/{ldapserver_id}/associations | List the associations of a LDAP Server
[**graphLdapServerAssociationsPost**](GraphApi.md#graphLdapServerAssociationsPost) | **POST** /ldapservers/{ldapserver_id}/associations | Manage the associations of a LDAP Server
[**graphLdapServerTraverseUser**](GraphApi.md#graphLdapServerTraverseUser) | **GET** /ldapservers/{ldapserver_id}/users | List the Users bound to a LDAP Server
[**graphLdapServerTraverseUserGroup**](GraphApi.md#graphLdapServerTraverseUserGroup) | **GET** /ldapservers/{ldapserver_id}/usergroups | List the User Groups bound to a LDAP Server
[**graphOffice365AssociationsList**](GraphApi.md#graphOffice365AssociationsList) | **GET** /office365s/{office365_id}/associations | List the associations of an Office 365 instance
[**graphOffice365AssociationsPost**](GraphApi.md#graphOffice365AssociationsPost) | **POST** /office365s/{office365_id}/associations | Manage the associations of an Office 365 instance
[**graphOffice365TraverseUser**](GraphApi.md#graphOffice365TraverseUser) | **GET** /office365s/{office365_id}/users | List the Users bound to an Office 365 instance
[**graphOffice365TraverseUserGroup**](GraphApi.md#graphOffice365TraverseUserGroup) | **GET** /office365s/{office365_id}/usergroups | List the User Groups bound to an Office 365 instance
[**graphPolicyAssociationsList**](GraphApi.md#graphPolicyAssociationsList) | **GET** /policies/{policy_id}/associations | List the associations of a Policy
[**graphPolicyAssociationsPost**](GraphApi.md#graphPolicyAssociationsPost) | **POST** /policies/{policy_id}/associations | Manage the associations of a Policy
[**graphPolicyTraverseSystem**](GraphApi.md#graphPolicyTraverseSystem) | **GET** /policies/{policy_id}/systems | List the Systems bound to a Policy
[**graphPolicyTraverseSystemGroup**](GraphApi.md#graphPolicyTraverseSystemGroup) | **GET** /policies/{policy_id}/systemgroups | List the System Groups bound to a Policy
[**graphRadiusServerAssociationsList**](GraphApi.md#graphRadiusServerAssociationsList) | **GET** /radiusservers/{radiusserver_id}/associations | List the associations of a RADIUS  Server
[**graphRadiusServerAssociationsPost**](GraphApi.md#graphRadiusServerAssociationsPost) | **POST** /radiusservers/{radiusserver_id}/associations | Manage the associations of a RADIUS Server
[**graphRadiusServerTraverseUser**](GraphApi.md#graphRadiusServerTraverseUser) | **GET** /radiusservers/{radiusserver_id}/users | List the Users bound to a RADIUS  Server
[**graphRadiusServerTraverseUserGroup**](GraphApi.md#graphRadiusServerTraverseUserGroup) | **GET** /radiusservers/{radiusserver_id}/usergroups | List the User Groups bound to a RADIUS  Server
[**graphSystemAssociationsList**](GraphApi.md#graphSystemAssociationsList) | **GET** /systems/{system_id}/associations | List the associations of a System
[**graphSystemAssociationsPost**](GraphApi.md#graphSystemAssociationsPost) | **POST** /systems/{system_id}/associations | Manage associations of a System
[**graphSystemGroupAssociationsList**](GraphApi.md#graphSystemGroupAssociationsList) | **GET** /systemgroups/{group_id}/associations | List the associations of a System Group
[**graphSystemGroupAssociationsPost**](GraphApi.md#graphSystemGroupAssociationsPost) | **POST** /systemgroups/{group_id}/associations | Manage the associations of a System Group
[**graphSystemGroupMemberOf**](GraphApi.md#graphSystemGroupMemberOf) | **GET** /systemgroups/{group_id}/memberof | List the System Group&#39;s parents
[**graphSystemGroupMembersList**](GraphApi.md#graphSystemGroupMembersList) | **GET** /systemgroups/{group_id}/members | List the members of a System Group
[**graphSystemGroupMembersPost**](GraphApi.md#graphSystemGroupMembersPost) | **POST** /systemgroups/{group_id}/members | Manage the members of a System Group
[**graphSystemGroupMembership**](GraphApi.md#graphSystemGroupMembership) | **GET** /systemgroups/{group_id}/membership | List the System Group&#39;s membership
[**graphSystemGroupTraverseCommand**](GraphApi.md#graphSystemGroupTraverseCommand) | **GET** /systemgroups/{group_id}/commands | List the Commands bound to a System Group
[**graphSystemGroupTraversePolicy**](GraphApi.md#graphSystemGroupTraversePolicy) | **GET** /systemgroups/{group_id}/policies | List the Policies bound to a System Group
[**graphSystemGroupTraverseUser**](GraphApi.md#graphSystemGroupTraverseUser) | **GET** /systemgroups/{group_id}/users | List the Users bound to a System Group
[**graphSystemGroupTraverseUserGroup**](GraphApi.md#graphSystemGroupTraverseUserGroup) | **GET** /systemgroups/{group_id}/usergroups | List the User Groups bound to a System Group
[**graphSystemMemberOf**](GraphApi.md#graphSystemMemberOf) | **GET** /systems/{system_id}/memberof | List the parent Groups of a System
[**graphSystemTraverseCommand**](GraphApi.md#graphSystemTraverseCommand) | **GET** /systems/{system_id}/commands | List the Commands bound to a System
[**graphSystemTraversePolicy**](GraphApi.md#graphSystemTraversePolicy) | **GET** /systems/{system_id}/policies | List the Policies bound to a System
[**graphSystemTraverseUser**](GraphApi.md#graphSystemTraverseUser) | **GET** /systems/{system_id}/users | List the Users bound to a System
[**graphSystemTraverseUserGroup**](GraphApi.md#graphSystemTraverseUserGroup) | **GET** /systems/{system_id}/usergroups | List the User Groups bound to a System
[**graphUserAssociationsList**](GraphApi.md#graphUserAssociationsList) | **GET** /users/{user_id}/associations | List the associations of a User
[**graphUserAssociationsPost**](GraphApi.md#graphUserAssociationsPost) | **POST** /users/{user_id}/associations | Manage the associations of a User
[**graphUserGroupAssociationsList**](GraphApi.md#graphUserGroupAssociationsList) | **GET** /usergroups/{group_id}/associations | List the associations of a User Group.
[**graphUserGroupAssociationsPost**](GraphApi.md#graphUserGroupAssociationsPost) | **POST** /usergroups/{group_id}/associations | Manage the associations of a User Group
[**graphUserGroupMemberOf**](GraphApi.md#graphUserGroupMemberOf) | **GET** /usergroups/{group_id}/memberof | List the User Group&#39;s parents
[**graphUserGroupMembersList**](GraphApi.md#graphUserGroupMembersList) | **GET** /usergroups/{group_id}/members | List the members of a User Group
[**graphUserGroupMembersPost**](GraphApi.md#graphUserGroupMembersPost) | **POST** /usergroups/{group_id}/members | Manage the members of a User Group
[**graphUserGroupMembership**](GraphApi.md#graphUserGroupMembership) | **GET** /usergroups/{group_id}/membership | List the User Group&#39;s membership
[**graphUserGroupTraverseActiveDirectory**](GraphApi.md#graphUserGroupTraverseActiveDirectory) | **GET** /usergroups/{group_id}/activedirectories | List the Active Directories bound to a User Group
[**graphUserGroupTraverseApplication**](GraphApi.md#graphUserGroupTraverseApplication) | **GET** /usergroups/{group_id}/applications | List the Applications bound to a User Group
[**graphUserGroupTraverseDirectory**](GraphApi.md#graphUserGroupTraverseDirectory) | **GET** /usergroups/{group_id}/directories | List the Directories bound to a User Group
[**graphUserGroupTraverseGSuite**](GraphApi.md#graphUserGroupTraverseGSuite) | **GET** /usergroups/{group_id}/gsuites | List the G Suite instances bound to a User Group
[**graphUserGroupTraverseLdapServer**](GraphApi.md#graphUserGroupTraverseLdapServer) | **GET** /usergroups/{group_id}/ldapservers | List the LDAP Servers bound to a User Group
[**graphUserGroupTraverseOffice365**](GraphApi.md#graphUserGroupTraverseOffice365) | **GET** /usergroups/{group_id}/office365s | List the Office 365 instances bound to a User Group
[**graphUserGroupTraverseRadiusServer**](GraphApi.md#graphUserGroupTraverseRadiusServer) | **GET** /usergroups/{group_id}/radiusservers | List the RADIUS Servers bound to a User Group
[**graphUserGroupTraverseSystem**](GraphApi.md#graphUserGroupTraverseSystem) | **GET** /usergroups/{group_id}/systems | List the Systems bound to a User Group
[**graphUserGroupTraverseSystemGroup**](GraphApi.md#graphUserGroupTraverseSystemGroup) | **GET** /usergroups/{group_id}/systemgroups | List the System Groups bound to User Groups
[**graphUserMemberOf**](GraphApi.md#graphUserMemberOf) | **GET** /users/{user_id}/memberof | List the parent Groups of a User
[**graphUserTraverseApplication**](GraphApi.md#graphUserTraverseApplication) | **GET** /users/{user_id}/applications | List the Applications bound to a User
[**graphUserTraverseDirectory**](GraphApi.md#graphUserTraverseDirectory) | **GET** /users/{user_id}/directories | List the Directories bound to a User
[**graphUserTraverseGSuite**](GraphApi.md#graphUserTraverseGSuite) | **GET** /users/{user_id}/gsuites | List the G Suite instances bound to a User
[**graphUserTraverseLdapServer**](GraphApi.md#graphUserTraverseLdapServer) | **GET** /users/{user_id}/ldapservers | List the LDAP servers bound to a User
[**graphUserTraverseOffice365**](GraphApi.md#graphUserTraverseOffice365) | **GET** /users/{user_id}/office365s | List the Office 365 instances bound to a User
[**graphUserTraverseRadiusServer**](GraphApi.md#graphUserTraverseRadiusServer) | **GET** /users/{user_id}/radiusservers | List the RADIUS Servers bound to a User
[**graphUserTraverseSystem**](GraphApi.md#graphUserTraverseSystem) | **GET** /users/{user_id}/systems | List the Systems bound to a User
[**graphUserTraverseSystemGroup**](GraphApi.md#graphUserTraverseSystemGroup) | **GET** /users/{user_id}/systemgroups | List the System Groups bound to a User
[**policystatusesList**](GraphApi.md#policystatusesList) | **GET** /systems/{system_id}/policystatuses | List the policy statuses for a system


<a name="graphActiveDirectoryAssociationsList"></a>
# **graphActiveDirectoryAssociationsList**
> List&lt;GraphConnection&gt; graphActiveDirectoryAssociationsList(activedirectoryId, targets, contentType, accept, limit, skip, xOrgId)

List the associations of an Active Directory instance

This endpoint returns the direct associations of this Active Directory instance.  A direct association can be a non-homogenous relationship between 2 different objects. For example Active Directory and Users.   #### Sample Request &#x60;&#x60;&#x60; curl -X GET &#39;https://console.jumpcloud.com/api/v2/activedirectories/{ActiveDirectory_ID}/associations?targets&#x3D;user \\   -H &#39;accept: application/json&#39; \\   -H &#39;content-type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String activedirectoryId = "activedirectoryId_example"; // String | 
List<String> targets = Arrays.asList("targets_example"); // List<String> | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphConnection> result = apiInstance.graphActiveDirectoryAssociationsList(activedirectoryId, targets, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphActiveDirectoryAssociationsList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **activedirectoryId** | **String**|  |
 **targets** | [**List&lt;String&gt;**](String.md)|  | [enum: active_directory, application, command, g_suite, ldap_server, office_365, policy, radius_server, system, system_group, user, user_group]
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphConnection&gt;**](GraphConnection.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphActiveDirectoryAssociationsPost"></a>
# **graphActiveDirectoryAssociationsPost**
> graphActiveDirectoryAssociationsPost(activedirectoryId, contentType, accept, body, xOrgId)

Manage the associations of an Active Directory instance

This endpoint allows you to manage the _direct_ associations of an Active Directory instance.  A direct association can be a non-homogenous relationship between 2 different objects. For example Active Directory and Users.  #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/activedirectories/{AD_Instance_ID}/associations \\   -H &#39;accept: application/json&#39; \\   -H &#39;content-type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{         \&quot;op\&quot;: \&quot;add\&quot;,         \&quot;type\&quot;: \&quot;user\&quot;,         \&quot;id\&quot;: \&quot;{User_ID}\&quot; } &#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String activedirectoryId = "activedirectoryId_example"; // String | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
GraphManagementReq body = new GraphManagementReq(); // GraphManagementReq | 
String xOrgId = "<<your org id>>"; // String | 
try {
    apiInstance.graphActiveDirectoryAssociationsPost(activedirectoryId, contentType, accept, body, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphActiveDirectoryAssociationsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **activedirectoryId** | **String**|  |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **body** | [**GraphManagementReq**](GraphManagementReq.md)|  | [optional]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphActiveDirectoryTraverseUserGroup"></a>
# **graphActiveDirectoryTraverseUserGroup**
> List&lt;GraphObjectWithPaths&gt; graphActiveDirectoryTraverseUserGroup(activedirectoryId, contentType, accept, limit, skip, xOrgId)

List the User Groups bound to an Active Directory instance

This endpoint will return all Users Groups bound to an Active Directory instance, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the group&#39;s type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this Active Directory instance to the corresponding User Group; this array represents all grouping and/or associations that would have to be removed to deprovision the User Group from this Active Directory instance.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/activedirectories/{ActiveDirectory_ID}/usergroups \\   -H &#39;accept: application/json&#39; \\   -H &#39;content-type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String activedirectoryId = "activedirectoryId_example"; // String | ObjectID of the Active Directory instance.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphActiveDirectoryTraverseUserGroup(activedirectoryId, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphActiveDirectoryTraverseUserGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **activedirectoryId** | **String**| ObjectID of the Active Directory instance. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphApplicationAssociationsList"></a>
# **graphApplicationAssociationsList**
> List&lt;GraphConnection&gt; graphApplicationAssociationsList(applicationId, targets, contentType, accept, limit, skip, xOrgId)

List the associations of an Application

This endpoint will return the _direct_ associations of an Application. A direct association can be a non-homogenous relationship between 2 different objects. for example Applications and User Groups.   #### Sample Request &#x60;&#x60;&#x60; curl -X GET &#39;https://console.jumpcloud.com/api/v2/applications/{Application_ID}/associations?targets&#x3D;user_group \\   -H &#39;accept: application/json&#39; \\   -H &#39;content-type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String applicationId = "applicationId_example"; // String | ObjectID of the Application.
List<String> targets = Arrays.asList("targets_example"); // List<String> | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphConnection> result = apiInstance.graphApplicationAssociationsList(applicationId, targets, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphApplicationAssociationsList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationId** | **String**| ObjectID of the Application. |
 **targets** | [**List&lt;String&gt;**](String.md)|  | [enum: active_directory, application, command, g_suite, ldap_server, office_365, policy, radius_server, system, system_group, user, user_group]
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphConnection&gt;**](GraphConnection.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphApplicationAssociationsPost"></a>
# **graphApplicationAssociationsPost**
> graphApplicationAssociationsPost(applicationId, contentType, accept, body, xOrgId)

Manage the associations of an Application

This endpoint allows you to manage the _direct_ associations of an Application. A direct association can be a non-homogenous relationship between 2 different objects. for example Application and User Groups.  #### Sample Request &#x60;&#x60;&#x60; curl -X POST &#39;https://console.jumpcloud.com/api/v2/applications/{Application_ID}/associations&#39; \\   -H &#39;accept: application/json&#39; \\   -H &#39;content-type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;user_group\&quot;,     \&quot;id\&quot;: \&quot;{Group_ID}\&quot; }&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String applicationId = "applicationId_example"; // String | ObjectID of the Application.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
GraphManagementReq body = new GraphManagementReq(); // GraphManagementReq | 
String xOrgId = "<<your org id>>"; // String | 
try {
    apiInstance.graphApplicationAssociationsPost(applicationId, contentType, accept, body, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphApplicationAssociationsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationId** | **String**| ObjectID of the Application. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **body** | [**GraphManagementReq**](GraphManagementReq.md)|  | [optional]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphApplicationTraverseUser"></a>
# **graphApplicationTraverseUser**
> List&lt;GraphObjectWithPaths&gt; graphApplicationTraverseUser(applicationId, contentType, accept, limit, skip, xOrgId)

List the Users bound to an Application

This endpoint will return all Users bound to an Application, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.   Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this Application to the corresponding User; this array represents all grouping and/or associations that would have to be removed to deprovision the User from this Application.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/applications/{Application_ID}/users \\   -H &#39;accept: application/json&#39; \\   -H &#39;content-type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String applicationId = "applicationId_example"; // String | ObjectID of the Application.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphApplicationTraverseUser(applicationId, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphApplicationTraverseUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationId** | **String**| ObjectID of the Application. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphApplicationTraverseUserGroup"></a>
# **graphApplicationTraverseUserGroup**
> List&lt;GraphObjectWithPaths&gt; graphApplicationTraverseUserGroup(applicationId, contentType, accept, limit, skip, xOrgId)

List the User Groups bound to an Application

This endpoint will return all Users Groups bound to an Application, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the group&#39;s type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates  each path from this Application to the corresponding User Group; this array represents all grouping and/or associations that would have to be removed to deprovision the User Group from this Application.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/applications/{Application_ID}/usergroups \\   -H &#39;accept: application/json&#39; \\   -H &#39;content-type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String applicationId = "applicationId_example"; // String | ObjectID of the Application.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphApplicationTraverseUserGroup(applicationId, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphApplicationTraverseUserGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationId** | **String**| ObjectID of the Application. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphCommandAssociationsList"></a>
# **graphCommandAssociationsList**
> List&lt;GraphConnection&gt; graphCommandAssociationsList(commandId, targets, contentType, accept, limit, skip, xOrgId)

List the associations of a Command

This endpoint will return the _direct_ associations of this Command.  A direct association can be a non-homogenous relationship between 2 different objects. for example Commands and User Groups.   #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/commands/{Command_ID}/associations?targets&#x3D;system_group \\   -H &#39;accept: application/json&#39; \\   -H &#39;content-type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String commandId = "commandId_example"; // String | ObjectID of the Command.
List<String> targets = Arrays.asList("targets_example"); // List<String> | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphConnection> result = apiInstance.graphCommandAssociationsList(commandId, targets, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphCommandAssociationsList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **commandId** | **String**| ObjectID of the Command. |
 **targets** | [**List&lt;String&gt;**](String.md)|  | [enum: active_directory, application, command, g_suite, ldap_server, office_365, policy, radius_server, system, system_group, user, user_group]
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphConnection&gt;**](GraphConnection.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphCommandAssociationsPost"></a>
# **graphCommandAssociationsPost**
> InlineResponse204 graphCommandAssociationsPost(commandId, contentType, accept, body, xOrgId)

Manage the associations of a Command

This endpoint will allow you to manage the _direct_ associations of this Command.  A direct association can be a non-homogenous relationship between 2 different objects. for example Commands and User Groups.   #### Sample Request &#x60;&#x60;&#x60;  curl -X POST https://console.jumpcloud.com/api/v2/commands/{Command_ID}/associations \\   -H &#39;accept: application/json&#39; \\   -H &#39;content-type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;system_group\&quot;,     \&quot;id\&quot;: \&quot;Group_ID\&quot; }&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String commandId = "commandId_example"; // String | ObjectID of the Command.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
GraphManagementReq body = new GraphManagementReq(); // GraphManagementReq | 
String xOrgId = "<<your org id>>"; // String | 
try {
    InlineResponse204 result = apiInstance.graphCommandAssociationsPost(commandId, contentType, accept, body, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphCommandAssociationsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **commandId** | **String**| ObjectID of the Command. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **body** | [**GraphManagementReq**](GraphManagementReq.md)|  | [optional]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**InlineResponse204**](InlineResponse204.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphCommandTraverseSystem"></a>
# **graphCommandTraverseSystem**
> List&lt;GraphObjectWithPaths&gt; graphCommandTraverseSystem(commandId, contentType, accept, limit, skip, xOrgId)

List the Systems bound to a Command

This endpoint will return all Systems bound to a Command, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this Command to the corresponding System; this array represents all grouping and/or associations that would have to be removed to deprovision the System from this Command.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/commands/{Command_ID}/systems \\   -H &#39;accept: application/json&#39; \\   -H &#39;content-type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String commandId = "commandId_example"; // String | ObjectID of the Command.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphCommandTraverseSystem(commandId, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphCommandTraverseSystem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **commandId** | **String**| ObjectID of the Command. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphCommandTraverseSystemGroup"></a>
# **graphCommandTraverseSystemGroup**
> List&lt;GraphObjectWithPaths&gt; graphCommandTraverseSystemGroup(commandId, contentType, accept, limit, skip, xOrgId)

List the System Groups bound to a Command

This endpoint will return all System Groups bound to a Command, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the group&#39;s type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this Command to the corresponding System Group; this array represents all grouping and/or associations that would have to be removed to deprovision the System Group from this Command.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/commands/{Command_ID}/systemgroups \\   -H &#39;accept: application/json&#39; \\   -H &#39;content-type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String commandId = "commandId_example"; // String | ObjectID of the Command.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphCommandTraverseSystemGroup(commandId, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphCommandTraverseSystemGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **commandId** | **String**| ObjectID of the Command. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphGSuiteAssociationsList"></a>
# **graphGSuiteAssociationsList**
> List&lt;GraphConnection&gt; graphGSuiteAssociationsList(gsuiteId, targets, contentType, accept, limit, skip, xOrgId)

List the associations of a G Suite instance

This endpoint returns the _direct_ associations of this G Suite instance.  A direct association can be a non-homogenous relationship between 2 different objects. for example G Suite and Users.   #### Sample Request &#x60;&#x60;&#x60; curl -X GET &#39;https://console.jumpcloud.com/api/v2/gsuites/{Gsuite_ID}/associations?targets&#x3D;user_group \\   -H &#39;accept: application/json&#39; \\   -H &#39;content-type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String gsuiteId = "gsuiteId_example"; // String | ObjectID of the G Suite instance.
List<String> targets = Arrays.asList("targets_example"); // List<String> | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphConnection> result = apiInstance.graphGSuiteAssociationsList(gsuiteId, targets, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphGSuiteAssociationsList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **gsuiteId** | **String**| ObjectID of the G Suite instance. |
 **targets** | [**List&lt;String&gt;**](String.md)|  | [enum: active_directory, application, command, g_suite, ldap_server, office_365, policy, radius_server, system, system_group, user, user_group]
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphConnection&gt;**](GraphConnection.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphGSuiteAssociationsPost"></a>
# **graphGSuiteAssociationsPost**
> graphGSuiteAssociationsPost(gsuiteId, body, xOrgId)

Manage the associations of a G Suite instance

This endpoint returns the _direct_ associations of this G Suite instance.  A direct association can be a non-homogenous relationship between 2 different objects. for example G Suite and Users.   #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/gsuites/{Gsuite_ID}/associations \\   -H &#39;accept: application/json&#39; \\   -H &#39;content-type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;user_group\&quot;,     \&quot;id\&quot;: \&quot;{Group_ID}\&quot; }&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String gsuiteId = "gsuiteId_example"; // String | ObjectID of the G Suite instance.
GraphManagementReq body = new GraphManagementReq(); // GraphManagementReq | 
String xOrgId = "<<your org id>>"; // String | 
try {
    apiInstance.graphGSuiteAssociationsPost(gsuiteId, body, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphGSuiteAssociationsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **gsuiteId** | **String**| ObjectID of the G Suite instance. |
 **body** | [**GraphManagementReq**](GraphManagementReq.md)|  | [optional]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphGSuiteTraverseUser"></a>
# **graphGSuiteTraverseUser**
> List&lt;GraphObjectWithPaths&gt; graphGSuiteTraverseUser(gsuiteId, contentType, accept, limit, skip, xOrgId)

List the Users bound to a G Suite instance

This endpoint will return all Users bound to a G Suite instance, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this G Suite instance to the corresponding User; this array represents all grouping and/or associations that would have to be removed to deprovision the User from this G Suite instance.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60;   curl -X GET https://console.jumpcloud.com/api/v2/gsuites/{Gsuite_ID}/users \\   -H &#39;accept: application/json&#39; \\   -H &#39;content-type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String gsuiteId = "gsuiteId_example"; // String | ObjectID of the G Suite instance.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphGSuiteTraverseUser(gsuiteId, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphGSuiteTraverseUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **gsuiteId** | **String**| ObjectID of the G Suite instance. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphGSuiteTraverseUserGroup"></a>
# **graphGSuiteTraverseUserGroup**
> List&lt;GraphObjectWithPaths&gt; graphGSuiteTraverseUserGroup(gsuiteId, contentType, accept, limit, skip, xOrgId)

List the User Groups bound to a G Suite instance

This endpoint will return all User Groups bound to an G Suite instance, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the group&#39;s type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this G Suite instance to the corresponding User Group; this array represents all grouping and/or associations that would have to be removed to deprovision the User Group from this G Suite instance.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60;   curl -X GET https://console.jumpcloud.com/api/v2/gsuites/{GSuite_ID}/usergroups \\   -H &#39;accept: application/json&#39; \\   -H &#39;content-type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String gsuiteId = "gsuiteId_example"; // String | ObjectID of the G Suite instance.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphGSuiteTraverseUserGroup(gsuiteId, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphGSuiteTraverseUserGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **gsuiteId** | **String**| ObjectID of the G Suite instance. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphLdapServerAssociationsList"></a>
# **graphLdapServerAssociationsList**
> List&lt;GraphConnection&gt; graphLdapServerAssociationsList(ldapserverId, targets, contentType, accept, limit, skip, xOrgId)

List the associations of a LDAP Server

This endpoint returns the _direct_ associations of this LDAP Server.  A direct association can be a non-homogenous relationship between 2 different objects. for example LDAP and Users.  #### Sample Request  &#x60;&#x60;&#x60;  curl -X GET &#39;https://console.jumpcloud.com/api/v2/ldapservers/{LDAP_ID}/associations?targets&#x3D;user_group \\   -H &#39;accept: application/json&#39; \\   -H &#39;content-type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String ldapserverId = "ldapserverId_example"; // String | ObjectID of the LDAP Server.
List<String> targets = Arrays.asList("targets_example"); // List<String> | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphConnection> result = apiInstance.graphLdapServerAssociationsList(ldapserverId, targets, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphLdapServerAssociationsList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ldapserverId** | **String**| ObjectID of the LDAP Server. |
 **targets** | [**List&lt;String&gt;**](String.md)|  | [enum: active_directory, application, command, g_suite, ldap_server, office_365, policy, radius_server, system, system_group, user, user_group]
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphConnection&gt;**](GraphConnection.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphLdapServerAssociationsPost"></a>
# **graphLdapServerAssociationsPost**
> graphLdapServerAssociationsPost(ldapserverId, contentType, accept, body, xOrgId)

Manage the associations of a LDAP Server

This endpoint allows you to manage the _direct_ associations of a LDAP Server.  A direct association can be a non-homogenous relationship between 2 different objects. for example LDAP and Users.  #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/ldapservers/{LDAP_ID}/associations \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;user\&quot;,     \&quot;id\&quot;: \&quot;{User_ID}\&quot; }&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String ldapserverId = "ldapserverId_example"; // String | ObjectID of the LDAP Server.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
GraphManagementReq body = new GraphManagementReq(); // GraphManagementReq | 
String xOrgId = "<<your org id>>"; // String | 
try {
    apiInstance.graphLdapServerAssociationsPost(ldapserverId, contentType, accept, body, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphLdapServerAssociationsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ldapserverId** | **String**| ObjectID of the LDAP Server. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **body** | [**GraphManagementReq**](GraphManagementReq.md)|  | [optional]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphLdapServerTraverseUser"></a>
# **graphLdapServerTraverseUser**
> List&lt;GraphObjectWithPaths&gt; graphLdapServerTraverseUser(ldapserverId, contentType, accept, limit, skip, xOrgId)

List the Users bound to a LDAP Server

This endpoint will return all Users bound to an LDAP Server, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this LDAP server instance to the corresponding User; this array represents all grouping and/or associations that would have to be removed to deprovision the User from this LDAP server instance.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/ldapservers/{LDAP_ID}/users \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String ldapserverId = "ldapserverId_example"; // String | ObjectID of the LDAP Server.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphLdapServerTraverseUser(ldapserverId, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphLdapServerTraverseUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ldapserverId** | **String**| ObjectID of the LDAP Server. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphLdapServerTraverseUserGroup"></a>
# **graphLdapServerTraverseUserGroup**
> List&lt;GraphObjectWithPaths&gt; graphLdapServerTraverseUserGroup(ldapserverId, contentType, accept, limit, skip, xOrgId)

List the User Groups bound to a LDAP Server

This endpoint will return all Users Groups bound to a LDAP Server, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the group&#39;s type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this LDAP server instance to the corresponding User Group; this array represents all grouping and/or associations that would have to be removed to deprovision the User Group from this LDAP server instance.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/ldapservers/{LDAP_ID}/usergroups \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String ldapserverId = "ldapserverId_example"; // String | ObjectID of the LDAP Server.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphLdapServerTraverseUserGroup(ldapserverId, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphLdapServerTraverseUserGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ldapserverId** | **String**| ObjectID of the LDAP Server. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphOffice365AssociationsList"></a>
# **graphOffice365AssociationsList**
> List&lt;GraphConnection&gt; graphOffice365AssociationsList(office365Id, targets, contentType, accept, limit, skip, xOrgId)

List the associations of an Office 365 instance

This endpoint returns _direct_ associations of an Office 365 instance.   A direct association can be a non-homogenous relationship between 2 different objects. for example Office 365 and Users.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET &#39;https://console.jumpcloud.com/api/v2/office365s/{O365_ID}/associations?targets&#x3D;user_group \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;  &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String office365Id = "office365Id_example"; // String | ObjectID of the Office 365 instance.
List<String> targets = Arrays.asList("targets_example"); // List<String> | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphConnection> result = apiInstance.graphOffice365AssociationsList(office365Id, targets, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphOffice365AssociationsList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **office365Id** | **String**| ObjectID of the Office 365 instance. |
 **targets** | [**List&lt;String&gt;**](String.md)|  | [enum: active_directory, application, command, g_suite, ldap_server, office_365, policy, radius_server, system, system_group, user, user_group]
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphConnection&gt;**](GraphConnection.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphOffice365AssociationsPost"></a>
# **graphOffice365AssociationsPost**
> graphOffice365AssociationsPost(office365Id, contentType, accept, body, xOrgId)

Manage the associations of an Office 365 instance

This endpoint allows you to manage the _direct_ associations of a Office 365 instance.  A direct association can be a non-homogenous relationship between 2 different objects. for example Office 365 and Users.  #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/office365s/{O365_ID}/associations \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;user_group\&quot;,     \&quot;id\&quot;: \&quot;{Group_ID}\&quot; }&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String office365Id = "office365Id_example"; // String | ObjectID of the Office 365 instance.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
GraphManagementReq body = new GraphManagementReq(); // GraphManagementReq | 
String xOrgId = "<<your org id>>"; // String | 
try {
    apiInstance.graphOffice365AssociationsPost(office365Id, contentType, accept, body, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphOffice365AssociationsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **office365Id** | **String**| ObjectID of the Office 365 instance. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **body** | [**GraphManagementReq**](GraphManagementReq.md)|  | [optional]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphOffice365TraverseUser"></a>
# **graphOffice365TraverseUser**
> List&lt;GraphObjectWithPaths&gt; graphOffice365TraverseUser(office365Id, contentType, accept, limit, skip, xOrgId)

List the Users bound to an Office 365 instance

This endpoint will return all Users bound to an Office 365 instance, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this Office 365 instance to the corresponding User; this array represents all grouping and/or associations that would have to be removed to deprovision the User from this Office 365 instance.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/office365s/{O365_ID}/users \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String office365Id = "office365Id_example"; // String | ObjectID of the Office 365 suite.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphOffice365TraverseUser(office365Id, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphOffice365TraverseUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **office365Id** | **String**| ObjectID of the Office 365 suite. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphOffice365TraverseUserGroup"></a>
# **graphOffice365TraverseUserGroup**
> List&lt;GraphObjectWithPaths&gt; graphOffice365TraverseUserGroup(office365Id, contentType, accept, limit, skip, xOrgId)

List the User Groups bound to an Office 365 instance

This endpoint will return all Users Groups bound to an Office 365 instance, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the group&#39;s type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this Office 365 instance to the corresponding User Group; this array represents all grouping and/or associations that would have to be removed to deprovision the User Group from this Office 365 instance.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60;   curl -X GET https://console.jumpcloud.com/api/v2/office365s/{O365_ID/usergroups \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String office365Id = "office365Id_example"; // String | ObjectID of the Office 365 suite.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphOffice365TraverseUserGroup(office365Id, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphOffice365TraverseUserGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **office365Id** | **String**| ObjectID of the Office 365 suite. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphPolicyAssociationsList"></a>
# **graphPolicyAssociationsList**
> List&lt;GraphConnection&gt; graphPolicyAssociationsList(policyId, targets, contentType, accept, limit, skip, xOrgId)

List the associations of a Policy

This endpoint returns the _direct_ associations of a Policy.  A direct association can be a non-homogenous relationship between 2 different objects. for example Policies and Systems.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET &#39;https://console.jumpcloud.com/api/v2/policies/{Policy_ID}/associations?targets&#x3D;system_group \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String policyId = "policyId_example"; // String | ObjectID of the Policy.
List<String> targets = Arrays.asList("targets_example"); // List<String> | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphConnection> result = apiInstance.graphPolicyAssociationsList(policyId, targets, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphPolicyAssociationsList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **policyId** | **String**| ObjectID of the Policy. |
 **targets** | [**List&lt;String&gt;**](String.md)|  | [enum: active_directory, application, command, g_suite, ldap_server, office_365, policy, radius_server, system, system_group, user, user_group]
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphConnection&gt;**](GraphConnection.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphPolicyAssociationsPost"></a>
# **graphPolicyAssociationsPost**
> graphPolicyAssociationsPost(policyId, contentType, accept, body, xOrgId)

Manage the associations of a Policy

This endpoint allows you to manage the _direct_ associations of a Policy.  A direct association can be a non-homogenous relationship between 2 different objects. for example Policies and Systems.  #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/policies/{Policy_ID}/associations/ \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;system_group\&quot;,     \&quot;id\&quot;: \&quot;{Group_ID}\&quot; }&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String policyId = "policyId_example"; // String | ObjectID of the Policy.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
GraphManagementReq body = new GraphManagementReq(); // GraphManagementReq | 
String xOrgId = "<<your org id>>"; // String | 
try {
    apiInstance.graphPolicyAssociationsPost(policyId, contentType, accept, body, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphPolicyAssociationsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **policyId** | **String**| ObjectID of the Policy. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **body** | [**GraphManagementReq**](GraphManagementReq.md)|  | [optional]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphPolicyTraverseSystem"></a>
# **graphPolicyTraverseSystem**
> List&lt;GraphObjectWithPaths&gt; graphPolicyTraverseSystem(policyId, contentType, accept, limit, skip, xOrgId)

List the Systems bound to a Policy

This endpoint will return all Systems bound to a Policy, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.   Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this Policy to the corresponding System; this array represents all grouping and/or associations that would have to be removed to deprovision the System from this Policy.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/policies/{Policy_ID}/systems \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String policyId = "policyId_example"; // String | ObjectID of the Command.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphPolicyTraverseSystem(policyId, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphPolicyTraverseSystem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **policyId** | **String**| ObjectID of the Command. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphPolicyTraverseSystemGroup"></a>
# **graphPolicyTraverseSystemGroup**
> List&lt;GraphObjectWithPaths&gt; graphPolicyTraverseSystemGroup(policyId, contentType, accept, limit, skip, xOrgId)

List the System Groups bound to a Policy

This endpoint will return all Systems Groups bound to a Policy, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the group&#39;s type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this Policy to the corresponding System Group; this array represents all grouping and/or associations that would have to be removed to deprovision the System Group from this Policy.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET  https://console.jumpcloud.com/api/v2/policies/{Policy_ID}/systemgroups \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String policyId = "policyId_example"; // String | ObjectID of the Command.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphPolicyTraverseSystemGroup(policyId, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphPolicyTraverseSystemGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **policyId** | **String**| ObjectID of the Command. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphRadiusServerAssociationsList"></a>
# **graphRadiusServerAssociationsList**
> List&lt;GraphConnection&gt; graphRadiusServerAssociationsList(radiusserverId, targets, contentType, accept, limit, skip, xOrgId)

List the associations of a RADIUS  Server

This endpoint returns the _direct_ associations of a Radius Server.  A direct association can be a non-homogenous relationship between 2 different objects. for example Radius Servers and Users.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/radiusservers/{RADIUS_ID}/associations?targets&#x3D;user_group \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String radiusserverId = "radiusserverId_example"; // String | ObjectID of the Radius Server.
List<String> targets = Arrays.asList("targets_example"); // List<String> | 
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphConnection> result = apiInstance.graphRadiusServerAssociationsList(radiusserverId, targets, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphRadiusServerAssociationsList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **radiusserverId** | **String**| ObjectID of the Radius Server. |
 **targets** | [**List&lt;String&gt;**](String.md)|  | [enum: active_directory, application, command, g_suite, ldap_server, office_365, policy, radius_server, system, system_group, user, user_group]
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphConnection&gt;**](GraphConnection.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphRadiusServerAssociationsPost"></a>
# **graphRadiusServerAssociationsPost**
> graphRadiusServerAssociationsPost(radiusserverId, contentType, accept, body, xOrgId)

Manage the associations of a RADIUS Server

This endpoint allows you to manage the _direct_ associations of a Radius Server.  A direct association can be a non-homogenous relationship between 2 different objects. for example Radius Servers and Users.  #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/radiusservers/{RADIUS_ID}/associations \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{   \&quot;type\&quot;:\&quot;user\&quot;,  \&quot;id\&quot;:\&quot;{USER_ID}\&quot;,  \&quot;op\&quot;:\&quot;add\&quot;   }&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String radiusserverId = "radiusserverId_example"; // String | ObjectID of the Radius Server.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
GraphManagementReq body = new GraphManagementReq(); // GraphManagementReq | 
String xOrgId = "<<your org id>>"; // String | 
try {
    apiInstance.graphRadiusServerAssociationsPost(radiusserverId, contentType, accept, body, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphRadiusServerAssociationsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **radiusserverId** | **String**| ObjectID of the Radius Server. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **body** | [**GraphManagementReq**](GraphManagementReq.md)|  | [optional]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphRadiusServerTraverseUser"></a>
# **graphRadiusServerTraverseUser**
> List&lt;GraphObjectWithPaths&gt; graphRadiusServerTraverseUser(radiusserverId, contentType, accept, limit, skip, xOrgId)

List the Users bound to a RADIUS  Server

This endpoint will return all Users bound to a RADIUS Server, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.   Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this RADIUS server instance to the corresponding User; this array represents all grouping and/or associations that would have to be removed to deprovision the User from this RADIUS server instance.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.   #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/ldapservers/{LDAP_ID}/users \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;   &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String radiusserverId = "radiusserverId_example"; // String | ObjectID of the Radius Server.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphRadiusServerTraverseUser(radiusserverId, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphRadiusServerTraverseUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **radiusserverId** | **String**| ObjectID of the Radius Server. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphRadiusServerTraverseUserGroup"></a>
# **graphRadiusServerTraverseUserGroup**
> List&lt;GraphObjectWithPaths&gt; graphRadiusServerTraverseUserGroup(radiusserverId, contentType, accept, limit, skip, xOrgId)

List the User Groups bound to a RADIUS  Server

This endpoint will return all Users Groups bound to a RADIUS Server, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.   Each element will contain the group&#39;s type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this RADIUS server instance to the corresponding User Group; this array represents all grouping and/or associations that would have to be removed to deprovision the User Group from this RADIUS server instance.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/radiusservers/{RADIUS_ID}/usergroups \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String radiusserverId = "radiusserverId_example"; // String | ObjectID of the Radius Server.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphRadiusServerTraverseUserGroup(radiusserverId, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphRadiusServerTraverseUserGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **radiusserverId** | **String**| ObjectID of the Radius Server. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphSystemAssociationsList"></a>
# **graphSystemAssociationsList**
> List&lt;GraphConnection&gt; graphSystemAssociationsList(systemId, contentType, accept, targets, limit, skip, date, authorization, xOrgId)

List the associations of a System

This endpoint returns the _direct_ associations of a System.  A direct association can be a non-homogenous relationship between 2 different objects. for example Systems and Users.   #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systems/{System_ID}/associations?targets&#x3D;user \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;  &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String systemId = "systemId_example"; // String | ObjectID of the System.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
List<String> targets = Arrays.asList("targets_example"); // List<String> | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String date = "date_example"; // String | Current date header for the System Context API
String authorization = "authorization_example"; // String | Authorization header for the System Context API
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphConnection> result = apiInstance.graphSystemAssociationsList(systemId, contentType, accept, targets, limit, skip, date, authorization, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphSystemAssociationsList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **systemId** | **String**| ObjectID of the System. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **targets** | [**List&lt;String&gt;**](String.md)|  | [enum: active_directory, application, command, g_suite, ldap_server, office_365, policy, radius_server, user, user_group]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **date** | **String**| Current date header for the System Context API | [optional]
 **authorization** | **String**| Authorization header for the System Context API | [optional]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphConnection&gt;**](GraphConnection.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphSystemAssociationsPost"></a>
# **graphSystemAssociationsPost**
> graphSystemAssociationsPost(systemId, contentType, accept, body, date, authorization, xOrgId)

Manage associations of a System

This endpoint allows you to manage the _direct_ associations of a System.  A direct association can be a non-homogenous relationship between 2 different objects. for example Systems and Users.   #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/systems/{System_ID}/associations \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{    \&quot;attributes\&quot;: {       \&quot;sudo\&quot;: {          \&quot;enabled\&quot;: true,          \&quot;withoutPassword\&quot;: false       }    },      \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;user\&quot;,     \&quot;id\&quot;: \&quot;UserID\&quot; }&#39;  &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String systemId = "systemId_example"; // String | ObjectID of the System.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
SystemGraphManagementReq body = new SystemGraphManagementReq(); // SystemGraphManagementReq | 
String date = "date_example"; // String | Current date header for the System Context API
String authorization = "authorization_example"; // String | Authorization header for the System Context API
String xOrgId = "<<your org id>>"; // String | 
try {
    apiInstance.graphSystemAssociationsPost(systemId, contentType, accept, body, date, authorization, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphSystemAssociationsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **systemId** | **String**| ObjectID of the System. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **body** | [**SystemGraphManagementReq**](SystemGraphManagementReq.md)|  | [optional]
 **date** | **String**| Current date header for the System Context API | [optional]
 **authorization** | **String**| Authorization header for the System Context API | [optional]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphSystemGroupAssociationsList"></a>
# **graphSystemGroupAssociationsList**
> List&lt;GraphConnection&gt; graphSystemGroupAssociationsList(groupId, contentType, accept, targets, limit, skip, xOrgId)

List the associations of a System Group

This endpoint returns the _direct_ associations of a System Group.  A direct association can be a non-homogenous relationship between 2 different objects. for example System Groups and Users.   #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systemgroups/{GroupID}/associations?targets&#x3D;user \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the System Group.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
List<String> targets = Arrays.asList("targets_example"); // List<String> | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphConnection> result = apiInstance.graphSystemGroupAssociationsList(groupId, contentType, accept, targets, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphSystemGroupAssociationsList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| ObjectID of the System Group. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **targets** | [**List&lt;String&gt;**](String.md)|  | [enum: active_directory, application, command, g_suite, ldap_server, office_365, policy, radius_server, user, user_group]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphConnection&gt;**](GraphConnection.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphSystemGroupAssociationsPost"></a>
# **graphSystemGroupAssociationsPost**
> graphSystemGroupAssociationsPost(groupId, contentType, accept, body, xOrgId)

Manage the associations of a System Group

This endpoint allows you to manage the _direct_ associations of a System Group.  A direct association can be a non-homogenous relationship between 2 different objects. for example System Groups and Users.   #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/systemgroups/{GroupID}/associations \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;user\&quot;,     \&quot;id\&quot;: \&quot;{UserID}\&quot; }&#39;  &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the System Group.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
SystemGroupGraphManagementReq body = new SystemGroupGraphManagementReq(); // SystemGroupGraphManagementReq | 
String xOrgId = "<<your org id>>"; // String | 
try {
    apiInstance.graphSystemGroupAssociationsPost(groupId, contentType, accept, body, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphSystemGroupAssociationsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| ObjectID of the System Group. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **body** | [**SystemGroupGraphManagementReq**](SystemGroupGraphManagementReq.md)|  | [optional]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphSystemGroupMemberOf"></a>
# **graphSystemGroupMemberOf**
> List&lt;GraphObjectWithPaths&gt; graphSystemGroupMemberOf(groupId, contentType, accept, filter, limit, skip, sort, xOrgId)

List the System Group&#39;s parents

This endpoint returns all System Groups a System Group is a member of.  This endpoint is not yet public as we haven&#39;t completed the code yet.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the System Group.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
List<String> filter = Arrays.asList("filter_example"); // List<String> | Supported operators are: eq, ne, gt, ge, lt, le, between, search, in
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> sort = Arrays.asList("sort_example"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphSystemGroupMemberOf(groupId, contentType, accept, filter, limit, skip, sort, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphSystemGroupMemberOf");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| ObjectID of the System Group. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **filter** | [**List&lt;String&gt;**](String.md)| Supported operators are: eq, ne, gt, ge, lt, le, between, search, in | [optional]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **sort** | [**List&lt;String&gt;**](String.md)| The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  | [optional]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphSystemGroupMembersList"></a>
# **graphSystemGroupMembersList**
> List&lt;GraphConnection&gt; graphSystemGroupMembersList(groupId, contentType, accept, limit, skip, xOrgId)

List the members of a System Group

This endpoint returns the system members of a System Group.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systemgroups/{Group_ID}/members \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;  &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the System Group.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphConnection> result = apiInstance.graphSystemGroupMembersList(groupId, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphSystemGroupMembersList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| ObjectID of the System Group. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphConnection&gt;**](GraphConnection.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphSystemGroupMembersPost"></a>
# **graphSystemGroupMembersPost**
> graphSystemGroupMembersPost(groupId, contentType, accept, body, date, authorization, xOrgId)

Manage the members of a System Group

This endpoint allows you to manage the system members of a System Group.  #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/systemgroups/{Group_ID}/members \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY&#39; \\   -d &#39;{     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;system\&quot;,     \&quot;id\&quot;: \&quot;{System_ID\&quot; }&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the System Group.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
SystemGroupMembersReq body = new SystemGroupMembersReq(); // SystemGroupMembersReq | 
String date = "date_example"; // String | Current date header for the System Context API
String authorization = "authorization_example"; // String | Authorization header for the System Context API
String xOrgId = "<<your org id>>"; // String | 
try {
    apiInstance.graphSystemGroupMembersPost(groupId, contentType, accept, body, date, authorization, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphSystemGroupMembersPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| ObjectID of the System Group. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **body** | [**SystemGroupMembersReq**](SystemGroupMembersReq.md)|  | [optional]
 **date** | **String**| Current date header for the System Context API | [optional]
 **authorization** | **String**| Authorization header for the System Context API | [optional]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphSystemGroupMembership"></a>
# **graphSystemGroupMembership**
> List&lt;GraphObjectWithPaths&gt; graphSystemGroupMembership(groupId, contentType, accept, limit, skip, sort, filter, xOrgId)

List the System Group&#39;s membership

This endpoint returns all Systems that are a member of this System Group.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systemgroups/{Group_ID/membership \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;  &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the System Group.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> sort = Arrays.asList("sort_example"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
List<String> filter = Arrays.asList("filter_example"); // List<String> | Supported operators are: eq, ne, gt, ge, lt, le, between, search, in
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphSystemGroupMembership(groupId, contentType, accept, limit, skip, sort, filter, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphSystemGroupMembership");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| ObjectID of the System Group. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **sort** | [**List&lt;String&gt;**](String.md)| The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  | [optional]
 **filter** | [**List&lt;String&gt;**](String.md)| Supported operators are: eq, ne, gt, ge, lt, le, between, search, in | [optional]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphSystemGroupTraverseCommand"></a>
# **graphSystemGroupTraverseCommand**
> List&lt;GraphObjectWithPaths&gt; graphSystemGroupTraverseCommand(groupId, contentType, accept, limit, skip, xOrgId)

List the Commands bound to a System Group

This endpoint will return all Commands bound to a System Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the group&#39;s type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this System Group to the corresponding Command; this array represents all grouping and/or associations that would have to be removed to deprovision the Command from this System Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systemgroups/{GroupID}/commands \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the System Group.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphSystemGroupTraverseCommand(groupId, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphSystemGroupTraverseCommand");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| ObjectID of the System Group. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphSystemGroupTraversePolicy"></a>
# **graphSystemGroupTraversePolicy**
> List&lt;GraphObjectWithPaths&gt; graphSystemGroupTraversePolicy(groupId, contentType, accept, limit, skip, xOrgId)

List the Policies bound to a System Group

This endpoint will return all Policies bound to a System Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this System Group to the corresponding Policy; this array represents all grouping and/or associations that would have to be removed to deprovision the Policy from this System Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  This endpoint is not public yet as we haven&#39;t finished the code.  ##### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systemgroups/{GroupID}/policies \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the System Group.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphSystemGroupTraversePolicy(groupId, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphSystemGroupTraversePolicy");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| ObjectID of the System Group. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphSystemGroupTraverseUser"></a>
# **graphSystemGroupTraverseUser**
> List&lt;GraphObjectWithPaths&gt; graphSystemGroupTraverseUser(groupId, contentType, accept, limit, skip, xOrgId)

List the Users bound to a System Group

This endpoint will return all Users bound to a System Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this System Group to the corresponding User; this array represents all grouping and/or associations that would have to be removed to deprovision the User from this System Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systemgroups/{GroupID}/users \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the System Group.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphSystemGroupTraverseUser(groupId, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphSystemGroupTraverseUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| ObjectID of the System Group. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphSystemGroupTraverseUserGroup"></a>
# **graphSystemGroupTraverseUserGroup**
> List&lt;GraphObjectWithPaths&gt; graphSystemGroupTraverseUserGroup(groupId, contentType, accept, limit, skip, xOrgId)

List the User Groups bound to a System Group

This endpoint will return all User Groups bound to a System Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this System Group to the corresponding User Group; this array represents all grouping and/or associations that would have to be removed to deprovision the User Group from this System Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systemgroups/{GroupID}/usergroups \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;  &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the System Group.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphSystemGroupTraverseUserGroup(groupId, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphSystemGroupTraverseUserGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| ObjectID of the System Group. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphSystemMemberOf"></a>
# **graphSystemMemberOf**
> List&lt;GraphObjectWithPaths&gt; graphSystemMemberOf(systemId, contentType, accept, filter, limit, skip, date, authorization, sort, xOrgId)

List the parent Groups of a System

This endpoint returns all the System Groups a System is a member of.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systems/{System_ID}/memberof \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;  &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String systemId = "systemId_example"; // String | ObjectID of the System.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
List<String> filter = Arrays.asList("filter_example"); // List<String> | Supported operators are: eq, ne, gt, ge, lt, le, between, search, in
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String date = "date_example"; // String | Current date header for the System Context API
String authorization = "authorization_example"; // String | Authorization header for the System Context API
List<String> sort = Arrays.asList("sort_example"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphSystemMemberOf(systemId, contentType, accept, filter, limit, skip, date, authorization, sort, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphSystemMemberOf");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **systemId** | **String**| ObjectID of the System. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **filter** | [**List&lt;String&gt;**](String.md)| Supported operators are: eq, ne, gt, ge, lt, le, between, search, in | [optional]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **date** | **String**| Current date header for the System Context API | [optional]
 **authorization** | **String**| Authorization header for the System Context API | [optional]
 **sort** | [**List&lt;String&gt;**](String.md)| The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  | [optional]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphSystemTraverseCommand"></a>
# **graphSystemTraverseCommand**
> List&lt;GraphObjectWithPaths&gt; graphSystemTraverseCommand(systemId, contentType, accept, limit, skip, xOrgId)

List the Commands bound to a System

This endpoint will return all Commands bound to a System, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this System to the corresponding Command; this array represents all grouping and/or associations that would have to be removed to deprovision the Command from this System.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systems/{System_ID}/commands \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;  &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String systemId = "systemId_example"; // String | ObjectID of the System.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphSystemTraverseCommand(systemId, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphSystemTraverseCommand");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **systemId** | **String**| ObjectID of the System. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphSystemTraversePolicy"></a>
# **graphSystemTraversePolicy**
> List&lt;GraphObjectWithPaths&gt; graphSystemTraversePolicy(systemId, contentType, accept, limit, skip, xOrgId)

List the Policies bound to a System

This endpoint will return all Policies bound to a System, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.   Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this System to the corresponding Policy; this array represents all grouping and/or associations that would have to be removed to deprovision the Policy from this System.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  This endpoint is not yet public as we have finish the code.  ##### Sample Request  &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/{System_ID}/policies \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;  &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String systemId = "systemId_example"; // String | ObjectID of the System.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphSystemTraversePolicy(systemId, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphSystemTraversePolicy");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **systemId** | **String**| ObjectID of the System. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphSystemTraverseUser"></a>
# **graphSystemTraverseUser**
> List&lt;GraphObjectWithPaths&gt; graphSystemTraverseUser(systemId, contentType, accept, limit, skip, date, authorization, xOrgId)

List the Users bound to a System

This endpoint will return all Users bound to a System, either directly or indirectly essentially traversing the JumpCloud Graph for your Organization.   Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this System to the corresponding User; this array represents all grouping and/or associations that would have to be removed to deprovision the User from this System.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systems/{System_ID}/users \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;  &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String systemId = "systemId_example"; // String | ObjectID of the System.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String date = "date_example"; // String | Current date header for the System Context API
String authorization = "authorization_example"; // String | Authorization header for the System Context API
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphSystemTraverseUser(systemId, contentType, accept, limit, skip, date, authorization, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphSystemTraverseUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **systemId** | **String**| ObjectID of the System. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **date** | **String**| Current date header for the System Context API | [optional]
 **authorization** | **String**| Authorization header for the System Context API | [optional]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphSystemTraverseUserGroup"></a>
# **graphSystemTraverseUserGroup**
> List&lt;GraphObjectWithPaths&gt; graphSystemTraverseUserGroup(systemId, contentType, accept, limit, skip, date, authorization, xOrgId)

List the User Groups bound to a System

This endpoint will return all User Groups bound to a System, either directly or indirectly essentially traversing the JumpCloud Graph for your Organization.   Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this System to the corresponding User Group; this array represents all grouping and/or associations that would have to be removed to deprovision the User Group from this System.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systems/{System_ID}/usergroups \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;  &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String systemId = "systemId_example"; // String | ObjectID of the System.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String date = "date_example"; // String | Current date header for the System Context API
String authorization = "authorization_example"; // String | Authorization header for the System Context API
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphSystemTraverseUserGroup(systemId, contentType, accept, limit, skip, date, authorization, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphSystemTraverseUserGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **systemId** | **String**| ObjectID of the System. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **date** | **String**| Current date header for the System Context API | [optional]
 **authorization** | **String**| Authorization header for the System Context API | [optional]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphUserAssociationsList"></a>
# **graphUserAssociationsList**
> List&lt;GraphConnection&gt; graphUserAssociationsList(userId, contentType, accept, targets, limit, skip, xOrgId)

List the associations of a User

This endpoint returns the _direct_ associations of a User.  A direct association can be a non-homogenous relationship between 2 different objects. for example Users and Systems.   #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/users/{UserID}/associations?targets&#x3D;system_group \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;  &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String userId = "userId_example"; // String | ObjectID of the User.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
List<String> targets = Arrays.asList("targets_example"); // List<String> | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphConnection> result = apiInstance.graphUserAssociationsList(userId, contentType, accept, targets, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphUserAssociationsList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| ObjectID of the User. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **targets** | [**List&lt;String&gt;**](String.md)|  | [enum: active_directory, application, command, g_suite, ldap_server, office_365, policy, radius_server, system, system_group]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphConnection&gt;**](GraphConnection.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphUserAssociationsPost"></a>
# **graphUserAssociationsPost**
> graphUserAssociationsPost(userId, contentType, accept, body, xOrgId)

Manage the associations of a User

This endpoint allows you to manage the _direct_ associations of a User.  A direct association can be a non-homogenous relationship between 2 different objects. for example Users and Systems.   #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/users/{UserID}/associations \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{    \&quot;attributes\&quot;: {       \&quot;sudo\&quot;: {          \&quot;enabled\&quot;: true,          \&quot;withoutPassword\&quot;: false       }    },     \&quot;op\&quot;: \&quot;add\&quot;,    \&quot;type\&quot;: \&quot;system_group\&quot;,    \&quot;id\&quot;: \&quot;{GroupID}\&quot; }&#39;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String userId = "userId_example"; // String | ObjectID of the User.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
UserGraphManagementReq body = new UserGraphManagementReq(); // UserGraphManagementReq | 
String xOrgId = "<<your org id>>"; // String | 
try {
    apiInstance.graphUserAssociationsPost(userId, contentType, accept, body, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphUserAssociationsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| ObjectID of the User. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **body** | [**UserGraphManagementReq**](UserGraphManagementReq.md)|  | [optional]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphUserGroupAssociationsList"></a>
# **graphUserGroupAssociationsList**
> List&lt;GraphConnection&gt; graphUserGroupAssociationsList(groupId, contentType, accept, targets, limit, skip, xOrgId)

List the associations of a User Group.

This endpoint returns the _direct_ associations of this User Group.  A direct association can be a non-homogenous relationship between 2 different objects. for example User Groups and Users.   #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/associations?targets&#x3D;system \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the User Group.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
List<String> targets = Arrays.asList("targets_example"); // List<String> | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphConnection> result = apiInstance.graphUserGroupAssociationsList(groupId, contentType, accept, targets, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphUserGroupAssociationsList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| ObjectID of the User Group. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **targets** | [**List&lt;String&gt;**](String.md)|  | [enum: active_directory, application, command, g_suite, ldap_server, office_365, policy, radius_server, system, system_group]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphConnection&gt;**](GraphConnection.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphUserGroupAssociationsPost"></a>
# **graphUserGroupAssociationsPost**
> graphUserGroupAssociationsPost(groupId, contentType, accept, body, xOrgId)

Manage the associations of a User Group

This endpoint manages the _direct_ associations of this User Group.  A direct association can be a non-homogenous relationship between 2 different objects. for example User Groups and Users.   #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/associations \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;system\&quot;,     \&quot;id\&quot;: \&quot;{SystemID}\&quot; }&#39;  &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the User Group.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
UserGroupGraphManagementReq body = new UserGroupGraphManagementReq(); // UserGroupGraphManagementReq | 
String xOrgId = "<<your org id>>"; // String | 
try {
    apiInstance.graphUserGroupAssociationsPost(groupId, contentType, accept, body, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphUserGroupAssociationsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| ObjectID of the User Group. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **body** | [**UserGroupGraphManagementReq**](UserGroupGraphManagementReq.md)|  | [optional]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphUserGroupMemberOf"></a>
# **graphUserGroupMemberOf**
> List&lt;GraphObjectWithPaths&gt; graphUserGroupMemberOf(groupId, contentType, accept, filter, limit, skip, sort, xOrgId)

List the User Group&#39;s parents

This endpoint returns all User Groups a User Group is a member of.  #### Sample Request &#x60;&#x60;&#x60; https://console.jumpcloud.com/api/v2/usergroups/{group_id}/membersof &#x60;&#x60;&#x60;  Not public yet, as the code is not finished,

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the User Group.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
List<String> filter = Arrays.asList("filter_example"); // List<String> | Supported operators are: eq, ne, gt, ge, lt, le, between, search, in
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> sort = Arrays.asList("sort_example"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphUserGroupMemberOf(groupId, contentType, accept, filter, limit, skip, sort, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphUserGroupMemberOf");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| ObjectID of the User Group. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **filter** | [**List&lt;String&gt;**](String.md)| Supported operators are: eq, ne, gt, ge, lt, le, between, search, in | [optional]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **sort** | [**List&lt;String&gt;**](String.md)| The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  | [optional]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphUserGroupMembersList"></a>
# **graphUserGroupMembersList**
> List&lt;GraphConnection&gt; graphUserGroupMembersList(groupId, contentType, accept, limit, skip, xOrgId)

List the members of a User Group

This endpoint returns the user members of a User Group.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/members \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the User Group.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphConnection> result = apiInstance.graphUserGroupMembersList(groupId, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphUserGroupMembersList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| ObjectID of the User Group. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphConnection&gt;**](GraphConnection.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphUserGroupMembersPost"></a>
# **graphUserGroupMembersPost**
> graphUserGroupMembersPost(groupId, contentType, accept, body, xOrgId)

Manage the members of a User Group

This endpoint allows you to manage the user members of a User Group.  #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/members \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; \\   -d &#39;{     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;user\&quot;,     \&quot;id\&quot;: \&quot;{User_ID}\&quot; }&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the User Group.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
UserGroupMembersReq body = new UserGroupMembersReq(); // UserGroupMembersReq | 
String xOrgId = "<<your org id>>"; // String | 
try {
    apiInstance.graphUserGroupMembersPost(groupId, contentType, accept, body, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphUserGroupMembersPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| ObjectID of the User Group. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **body** | [**UserGroupMembersReq**](UserGroupMembersReq.md)|  | [optional]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphUserGroupMembership"></a>
# **graphUserGroupMembership**
> List&lt;GraphObjectWithPaths&gt; graphUserGroupMembership(groupId, contentType, accept, filter, limit, skip, sort, xOrgId)

List the User Group&#39;s membership

This endpoint returns all users members that are a member of this User Group.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/membership \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the User Group.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
List<String> filter = Arrays.asList("filter_example"); // List<String> | Supported operators are: eq, ne, gt, ge, lt, le, between, search, in
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> sort = Arrays.asList("sort_example"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphUserGroupMembership(groupId, contentType, accept, filter, limit, skip, sort, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphUserGroupMembership");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| ObjectID of the User Group. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **filter** | [**List&lt;String&gt;**](String.md)| Supported operators are: eq, ne, gt, ge, lt, le, between, search, in | [optional]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **sort** | [**List&lt;String&gt;**](String.md)| The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  | [optional]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphUserGroupTraverseActiveDirectory"></a>
# **graphUserGroupTraverseActiveDirectory**
> List&lt;GraphObjectWithPaths&gt; graphUserGroupTraverseActiveDirectory(groupId, contentType, accept, limit, skip, xOrgId)

List the Active Directories bound to a User Group

This endpoint will return all Active Directory Instances bound to a User Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.   The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User Group to the corresponding Active Directory; this array represents all grouping and/or associations that would have to be removed to deprovision the Active Directory from this User Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/activedirectories \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the User Group.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphUserGroupTraverseActiveDirectory(groupId, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphUserGroupTraverseActiveDirectory");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| ObjectID of the User Group. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphUserGroupTraverseApplication"></a>
# **graphUserGroupTraverseApplication**
> List&lt;GraphObjectWithPaths&gt; graphUserGroupTraverseApplication(groupId, contentType, accept, limit, skip, xOrgId)

List the Applications bound to a User Group

This endpoint will return all Applications bound to a User Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User Group to the corresponding Application; this array represents all grouping and/or associations that would have to be removed to deprovision the Application from this User Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/applications \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the User Group.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphUserGroupTraverseApplication(groupId, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphUserGroupTraverseApplication");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| ObjectID of the User Group. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphUserGroupTraverseDirectory"></a>
# **graphUserGroupTraverseDirectory**
> List&lt;GraphObjectWithPaths&gt; graphUserGroupTraverseDirectory(groupId, contentType, accept, limit, skip, xOrgId)

List the Directories bound to a User Group

This endpoint will return all Directories bound to a User Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User Group to the corresponding Directory; this array represents all grouping and/or associations that would have to be removed to deprovision the Directories from this User Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/directories \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;  &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the User Group.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphUserGroupTraverseDirectory(groupId, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphUserGroupTraverseDirectory");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| ObjectID of the User Group. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphUserGroupTraverseGSuite"></a>
# **graphUserGroupTraverseGSuite**
> List&lt;GraphObjectWithPaths&gt; graphUserGroupTraverseGSuite(groupId, contentType, accept, limit, skip, xOrgId)

List the G Suite instances bound to a User Group

This endpoint will return all Gsuite Instances bound to a User Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User Group to the corresponding G Suite instance; this array represents all grouping and/or associations that would have to be removed to deprovision the G Suite instance from this User Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID/gsuites \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;  &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the User Group.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphUserGroupTraverseGSuite(groupId, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphUserGroupTraverseGSuite");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| ObjectID of the User Group. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphUserGroupTraverseLdapServer"></a>
# **graphUserGroupTraverseLdapServer**
> List&lt;GraphObjectWithPaths&gt; graphUserGroupTraverseLdapServer(groupId, contentType, accept, limit, skip, xOrgId)

List the LDAP Servers bound to a User Group

This endpoint will return all LDAP Servers bound to a User Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User Group to the corresponding LDAP Server; this array represents all grouping and/or associations that would have to be removed to deprovision the LDAP Server from this User Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/ldapservers \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the User Group.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphUserGroupTraverseLdapServer(groupId, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphUserGroupTraverseLdapServer");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| ObjectID of the User Group. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphUserGroupTraverseOffice365"></a>
# **graphUserGroupTraverseOffice365**
> List&lt;GraphObjectWithPaths&gt; graphUserGroupTraverseOffice365(groupId, contentType, accept, limit, skip, xOrgId)

List the Office 365 instances bound to a User Group

This endpoint will return all Office 365 instances bound to a User Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User Group to the corresponding Office 365 instance; this array represents all grouping and/or associations that would have to be removed to deprovision the Office 365 instance from this User Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/office365s \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the User Group.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphUserGroupTraverseOffice365(groupId, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphUserGroupTraverseOffice365");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| ObjectID of the User Group. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphUserGroupTraverseRadiusServer"></a>
# **graphUserGroupTraverseRadiusServer**
> List&lt;GraphObjectWithPaths&gt; graphUserGroupTraverseRadiusServer(groupId, contentType, accept, limit, skip, xOrgId)

List the RADIUS Servers bound to a User Group

This endpoint will return all RADIUS servers bound to a User Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.    Each element will contain the type, id, attributes and paths  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User Group to the corresponding RADIUS Server; this array represents all grouping and/or associations that would have to be removed to deprovision the RADIUS Server from this User Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/radiusservers \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;  &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the User Group.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphUserGroupTraverseRadiusServer(groupId, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphUserGroupTraverseRadiusServer");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| ObjectID of the User Group. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphUserGroupTraverseSystem"></a>
# **graphUserGroupTraverseSystem**
> List&lt;GraphObjectWithPaths&gt; graphUserGroupTraverseSystem(groupId, contentType, accept, limit, skip, xOrgId)

List the Systems bound to a User Group

This endpoint will return all Systems bound to a User Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.    Each element will contain the type, id, attributes and paths  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User Group to the corresponding System; this array represents all grouping and/or associations that would have to be removed to deprovision the System from this User Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/systems \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the User Group.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphUserGroupTraverseSystem(groupId, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphUserGroupTraverseSystem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| ObjectID of the User Group. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphUserGroupTraverseSystemGroup"></a>
# **graphUserGroupTraverseSystemGroup**
> List&lt;GraphObjectWithPaths&gt; graphUserGroupTraverseSystemGroup(groupId, contentType, accept, limit, skip, xOrgId)

List the System Groups bound to User Groups

This endpoint will return all System Groups bound to a User Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.    Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User Group to the corresponding System Group; this array represents all grouping and/or associations that would have to be removed to deprovision the System Group from this User Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/systemgroups \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the User Group.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphUserGroupTraverseSystemGroup(groupId, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphUserGroupTraverseSystemGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| ObjectID of the User Group. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphUserMemberOf"></a>
# **graphUserMemberOf**
> List&lt;GraphObjectWithPaths&gt; graphUserMemberOf(userId, contentType, accept, filter, limit, skip, sort, xOrgId)

List the parent Groups of a User

This endpoint returns all the User Groups a User is a member of.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/users/{UserID}/memberof \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String userId = "userId_example"; // String | ObjectID of the User.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
List<String> filter = Arrays.asList("filter_example"); // List<String> | Supported operators are: eq, ne, gt, ge, lt, le, between, search, in
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> sort = Arrays.asList("sort_example"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphUserMemberOf(userId, contentType, accept, filter, limit, skip, sort, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphUserMemberOf");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| ObjectID of the User. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **filter** | [**List&lt;String&gt;**](String.md)| Supported operators are: eq, ne, gt, ge, lt, le, between, search, in | [optional]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **sort** | [**List&lt;String&gt;**](String.md)| The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  | [optional]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphUserTraverseApplication"></a>
# **graphUserTraverseApplication**
> List&lt;GraphObjectWithPaths&gt; graphUserTraverseApplication(userId, contentType, accept, limit, skip, xOrgId)

List the Applications bound to a User

This endpoint will return all Applications bound to a User, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.   Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User to the corresponding Application; this array represents all grouping and/or associations that would have to be removed to deprovision the Application from this User.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/users/{UserID}/applications \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String userId = "userId_example"; // String | ObjectID of the User.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphUserTraverseApplication(userId, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphUserTraverseApplication");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| ObjectID of the User. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphUserTraverseDirectory"></a>
# **graphUserTraverseDirectory**
> List&lt;GraphObjectWithPaths&gt; graphUserTraverseDirectory(userId, contentType, accept, limit, skip, xOrgId)

List the Directories bound to a User

This endpoint will return all Directories bound to a User, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.   Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User to the corresponding Directory; this array represents all grouping and/or associations that would have to be removed to deprovision the Directory from this User.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/users/{UserID}/directories \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String userId = "userId_example"; // String | ObjectID of the User.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphUserTraverseDirectory(userId, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphUserTraverseDirectory");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| ObjectID of the User. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphUserTraverseGSuite"></a>
# **graphUserTraverseGSuite**
> List&lt;GraphObjectWithPaths&gt; graphUserTraverseGSuite(userId, contentType, accept, limit, skip, xOrgId)

List the G Suite instances bound to a User

This endpoint will return all G-Suite Instances bound to a User, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.   Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User to the corresponding G Suite instance; this array represents all grouping and/or associations that would have to be removed to deprovision the G Suite instance from this User.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/users/{UserID}/gsuites \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String userId = "userId_example"; // String | ObjectID of the User.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphUserTraverseGSuite(userId, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphUserTraverseGSuite");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| ObjectID of the User. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphUserTraverseLdapServer"></a>
# **graphUserTraverseLdapServer**
> List&lt;GraphObjectWithPaths&gt; graphUserTraverseLdapServer(userId, contentType, accept, limit, skip, xOrgId)

List the LDAP servers bound to a User

This endpoint will return all LDAP Servers bound to a User, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.   Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User to the corresponding LDAP Server; this array represents all grouping and/or associations that would have to be removed to deprovision the LDAP Server from this User.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/users/{UserID}/ldapservers \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String userId = "userId_example"; // String | ObjectID of the User.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphUserTraverseLdapServer(userId, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphUserTraverseLdapServer");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| ObjectID of the User. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphUserTraverseOffice365"></a>
# **graphUserTraverseOffice365**
> List&lt;GraphObjectWithPaths&gt; graphUserTraverseOffice365(userId, contentType, accept, limit, skip, xOrgId)

List the Office 365 instances bound to a User

This endpoint will return all Office 365 Instances bound to a User, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.   Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User to the corresponding Office 365 instance; this array represents all grouping and/or associations that would have to be removed to deprovision the Office 365 instance from this User.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/users/{UserID}/office365s \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String userId = "userId_example"; // String | ObjectID of the User.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphUserTraverseOffice365(userId, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphUserTraverseOffice365");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| ObjectID of the User. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphUserTraverseRadiusServer"></a>
# **graphUserTraverseRadiusServer**
> List&lt;GraphObjectWithPaths&gt; graphUserTraverseRadiusServer(userId, contentType, accept, limit, skip, xOrgId)

List the RADIUS Servers bound to a User

This endpoint will return all RADIUS Servers bound to a User, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.    Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User to the corresponding RADIUS Server; this array represents all grouping and/or associations that would have to be removed to deprovision the RADIUS Server from this User.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/users/{UserID}/radiusservers \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String userId = "userId_example"; // String | ObjectID of the User.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphUserTraverseRadiusServer(userId, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphUserTraverseRadiusServer");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| ObjectID of the User. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphUserTraverseSystem"></a>
# **graphUserTraverseSystem**
> List&lt;GraphObjectWithPaths&gt; graphUserTraverseSystem(userId, contentType, accept, limit, skip, xOrgId)

List the Systems bound to a User

This endpoint will return all Systems bound to a User, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.   Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User to the corresponding System; this array represents all grouping and/or associations that would have to be removed to deprovision the System from this User.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/users/{UserID}/systems\\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String userId = "userId_example"; // String | ObjectID of the User.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphUserTraverseSystem(userId, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphUserTraverseSystem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| ObjectID of the User. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="graphUserTraverseSystemGroup"></a>
# **graphUserTraverseSystemGroup**
> List&lt;GraphObjectWithPaths&gt; graphUserTraverseSystemGroup(userId, contentType, accept, limit, skip, xOrgId)

List the System Groups bound to a User

This endpoint will return all System Groups bound to a User, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.   Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User to the corresponding System Group; this array represents all grouping and/or associations that would have to be removed to deprovision the System Group from this User.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/users/{UserID}/systemgroups\\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String userId = "userId_example"; // String | ObjectID of the User.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "<<your org id>>"; // String | 
try {
    List<GraphObjectWithPaths> result = apiInstance.graphUserTraverseSystemGroup(userId, contentType, accept, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphUserTraverseSystemGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| ObjectID of the User. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="policystatusesList"></a>
# **policystatusesList**
> List&lt;PolicyResult&gt; policystatusesList(systemId, contentType, accept, fields, filter, limit, skip, sort, xOrgId)

List the policy statuses for a system

This endpoint returns the policy results for a particular system.  ##### Sample Request  &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systems/{System_ID}/policystatuses \\   -H &#39;Accept: application/json&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -H &#39;x-api-key: {API_KEY}&#39;  &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.GraphApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: x-api-key
ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x_api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x_api_key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String systemId = "systemId_example"; // String | ObjectID of the System.
String contentType = "application/json"; // String | 
String accept = "application/json"; // String | 
List<String> fields = Arrays.asList("fields_example"); // List<String> | The comma separated fields included in the returned records. If omitted the default list of fields will be returned. 
List<String> filter = Arrays.asList("filter_example"); // List<String> | Supported operators are: eq, ne, gt, ge, lt, le, between, search, in
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> sort = Arrays.asList("sort_example"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
String xOrgId = "<<your org id>>"; // String | 
try {
    List<PolicyResult> result = apiInstance.policystatusesList(systemId, contentType, accept, fields, filter, limit, skip, sort, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#policystatusesList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **systemId** | **String**| ObjectID of the System. |
 **contentType** | **String**|  | [default to application/json]
 **accept** | **String**|  | [default to application/json]
 **fields** | [**List&lt;String&gt;**](String.md)| The comma separated fields included in the returned records. If omitted the default list of fields will be returned.  | [optional]
 **filter** | [**List&lt;String&gt;**](String.md)| Supported operators are: eq, ne, gt, ge, lt, le, between, search, in | [optional]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0]
 **sort** | [**List&lt;String&gt;**](String.md)| The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  | [optional]
 **xOrgId** | **String**|  | [optional] [default to &lt;&lt;your org id&gt;&gt;]

### Return type

[**List&lt;PolicyResult&gt;**](PolicyResult.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

