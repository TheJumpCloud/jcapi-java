# GraphApi

All URIs are relative to *https://console.jumpcloud.com/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**graphActiveDirectoryAssociationsList**](GraphApi.md#graphActiveDirectoryAssociationsList) | **GET** /activedirectories/{activedirectory_id}/associations | List the associations of an Active Directory instance
[**graphActiveDirectoryAssociationsPost**](GraphApi.md#graphActiveDirectoryAssociationsPost) | **POST** /activedirectories/{activedirectory_id}/associations | Manage the associations of an Active Directory instance
[**graphActiveDirectoryTraverseUser**](GraphApi.md#graphActiveDirectoryTraverseUser) | **GET** /activedirectories/{activedirectory_id}/users | List the Users bound to an Active Directory instance
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
[**graphPolicyGroupAssociationsList**](GraphApi.md#graphPolicyGroupAssociationsList) | **GET** /policygroups/{group_id}/associations | List the associations of a Policy Group.
[**graphPolicyGroupAssociationsPost**](GraphApi.md#graphPolicyGroupAssociationsPost) | **POST** /policygroups/{group_id}/associations | Manage the associations of a Policy Group
[**graphPolicyGroupMembersList**](GraphApi.md#graphPolicyGroupMembersList) | **GET** /policygroups/{group_id}/members | List the members of a Policy Group
[**graphPolicyGroupMembersPost**](GraphApi.md#graphPolicyGroupMembersPost) | **POST** /policygroups/{group_id}/members | Manage the members of a Policy Group
[**graphPolicyGroupMembership**](GraphApi.md#graphPolicyGroupMembership) | **GET** /policygroups/{group_id}/membership | List the Policy Group&#x27;s membership
[**graphPolicyGroupTraverseSystem**](GraphApi.md#graphPolicyGroupTraverseSystem) | **GET** /policygroups/{group_id}/systems | List the Systems bound to a Policy Group
[**graphPolicyGroupTraverseSystemGroup**](GraphApi.md#graphPolicyGroupTraverseSystemGroup) | **GET** /policygroups/{group_id}/systemgroups | List the System Groups bound to Policy Groups
[**graphPolicyMemberOf**](GraphApi.md#graphPolicyMemberOf) | **GET** /policies/{policy_id}/memberof | List the parent Groups of a Policy
[**graphPolicyTraverseSystem**](GraphApi.md#graphPolicyTraverseSystem) | **GET** /policies/{policy_id}/systems | List the Systems bound to a Policy
[**graphPolicyTraverseSystemGroup**](GraphApi.md#graphPolicyTraverseSystemGroup) | **GET** /policies/{policy_id}/systemgroups | List the System Groups bound to a Policy
[**graphRadiusServerAssociationsList**](GraphApi.md#graphRadiusServerAssociationsList) | **GET** /radiusservers/{radiusserver_id}/associations | List the associations of a RADIUS  Server
[**graphRadiusServerAssociationsPost**](GraphApi.md#graphRadiusServerAssociationsPost) | **POST** /radiusservers/{radiusserver_id}/associations | Manage the associations of a RADIUS Server
[**graphRadiusServerTraverseUser**](GraphApi.md#graphRadiusServerTraverseUser) | **GET** /radiusservers/{radiusserver_id}/users | List the Users bound to a RADIUS  Server
[**graphRadiusServerTraverseUserGroup**](GraphApi.md#graphRadiusServerTraverseUserGroup) | **GET** /radiusservers/{radiusserver_id}/usergroups | List the User Groups bound to a RADIUS  Server
[**graphSoftwareappsAssociationsList**](GraphApi.md#graphSoftwareappsAssociationsList) | **GET** /softwareapps/{software_app_id}/associations | List the associations of a Software Application
[**graphSoftwareappsAssociationsPost**](GraphApi.md#graphSoftwareappsAssociationsPost) | **POST** /softwareapps/{software_app_id}/associations | Manage the associations of a software application.
[**graphSoftwareappsTraverseSystem**](GraphApi.md#graphSoftwareappsTraverseSystem) | **GET** /softwareapps/{software_app_id}/systems | List the Systems bound to a Software App.
[**graphSoftwareappsTraverseSystemGroup**](GraphApi.md#graphSoftwareappsTraverseSystemGroup) | **GET** /softwareapps/{software_app_id}/systemgroups | List the System Groups bound to a Software App.
[**graphSystemAssociationsList**](GraphApi.md#graphSystemAssociationsList) | **GET** /systems/{system_id}/associations | List the associations of a System
[**graphSystemAssociationsPost**](GraphApi.md#graphSystemAssociationsPost) | **POST** /systems/{system_id}/associations | Manage associations of a System
[**graphSystemGroupAssociationsList**](GraphApi.md#graphSystemGroupAssociationsList) | **GET** /systemgroups/{group_id}/associations | List the associations of a System Group
[**graphSystemGroupAssociationsPost**](GraphApi.md#graphSystemGroupAssociationsPost) | **POST** /systemgroups/{group_id}/associations | Manage the associations of a System Group
[**graphSystemGroupMembersList**](GraphApi.md#graphSystemGroupMembersList) | **GET** /systemgroups/{group_id}/members | List the members of a System Group
[**graphSystemGroupMembersPost**](GraphApi.md#graphSystemGroupMembersPost) | **POST** /systemgroups/{group_id}/members | Manage the members of a System Group
[**graphSystemGroupMembership**](GraphApi.md#graphSystemGroupMembership) | **GET** /systemgroups/{group_id}/membership | List the System Group&#x27;s membership
[**graphSystemGroupTraverseCommand**](GraphApi.md#graphSystemGroupTraverseCommand) | **GET** /systemgroups/{group_id}/commands | List the Commands bound to a System Group
[**graphSystemGroupTraversePolicy**](GraphApi.md#graphSystemGroupTraversePolicy) | **GET** /systemgroups/{group_id}/policies | List the Policies bound to a System Group
[**graphSystemGroupTraversePolicyGroup**](GraphApi.md#graphSystemGroupTraversePolicyGroup) | **GET** /systemgroups/{group_id}/policygroups | List the Policy Groups bound to a System Group
[**graphSystemGroupTraverseUser**](GraphApi.md#graphSystemGroupTraverseUser) | **GET** /systemgroups/{group_id}/users | List the Users bound to a System Group
[**graphSystemGroupTraverseUserGroup**](GraphApi.md#graphSystemGroupTraverseUserGroup) | **GET** /systemgroups/{group_id}/usergroups | List the User Groups bound to a System Group
[**graphSystemMemberOf**](GraphApi.md#graphSystemMemberOf) | **GET** /systems/{system_id}/memberof | List the parent Groups of a System
[**graphSystemTraverseCommand**](GraphApi.md#graphSystemTraverseCommand) | **GET** /systems/{system_id}/commands | List the Commands bound to a System
[**graphSystemTraversePolicy**](GraphApi.md#graphSystemTraversePolicy) | **GET** /systems/{system_id}/policies | List the Policies bound to a System
[**graphSystemTraversePolicyGroup**](GraphApi.md#graphSystemTraversePolicyGroup) | **GET** /systems/{system_id}/policygroups | List the Policy Groups bound to a System
[**graphSystemTraverseUser**](GraphApi.md#graphSystemTraverseUser) | **GET** /systems/{system_id}/users | List the Users bound to a System
[**graphSystemTraverseUserGroup**](GraphApi.md#graphSystemTraverseUserGroup) | **GET** /systems/{system_id}/usergroups | List the User Groups bound to a System
[**graphUserAssociationsList**](GraphApi.md#graphUserAssociationsList) | **GET** /users/{user_id}/associations | List the associations of a User
[**graphUserAssociationsPost**](GraphApi.md#graphUserAssociationsPost) | **POST** /users/{user_id}/associations | Manage the associations of a User
[**graphUserGroupAssociationsList**](GraphApi.md#graphUserGroupAssociationsList) | **GET** /usergroups/{group_id}/associations | List the associations of a User Group.
[**graphUserGroupAssociationsPost**](GraphApi.md#graphUserGroupAssociationsPost) | **POST** /usergroups/{group_id}/associations | Manage the associations of a User Group
[**graphUserGroupMembersList**](GraphApi.md#graphUserGroupMembersList) | **GET** /usergroups/{group_id}/members | List the members of a User Group
[**graphUserGroupMembersPost**](GraphApi.md#graphUserGroupMembersPost) | **POST** /usergroups/{group_id}/members | Manage the members of a User Group
[**graphUserGroupMembership**](GraphApi.md#graphUserGroupMembership) | **GET** /usergroups/{group_id}/membership | List the User Group&#x27;s membership
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
[**graphUserTraverseActiveDirectory**](GraphApi.md#graphUserTraverseActiveDirectory) | **GET** /users/{user_id}/activedirectories | List the Active Directory instances bound to a User
[**graphUserTraverseApplication**](GraphApi.md#graphUserTraverseApplication) | **GET** /users/{user_id}/applications | List the Applications bound to a User
[**graphUserTraverseDirectory**](GraphApi.md#graphUserTraverseDirectory) | **GET** /users/{user_id}/directories | List the Directories bound to a User
[**graphUserTraverseGSuite**](GraphApi.md#graphUserTraverseGSuite) | **GET** /users/{user_id}/gsuites | List the G Suite instances bound to a User
[**graphUserTraverseLdapServer**](GraphApi.md#graphUserTraverseLdapServer) | **GET** /users/{user_id}/ldapservers | List the LDAP servers bound to a User
[**graphUserTraverseOffice365**](GraphApi.md#graphUserTraverseOffice365) | **GET** /users/{user_id}/office365s | List the Office 365 instances bound to a User
[**graphUserTraverseRadiusServer**](GraphApi.md#graphUserTraverseRadiusServer) | **GET** /users/{user_id}/radiusservers | List the RADIUS Servers bound to a User
[**graphUserTraverseSystem**](GraphApi.md#graphUserTraverseSystem) | **GET** /users/{user_id}/systems | List the Systems bound to a User
[**graphUserTraverseSystemGroup**](GraphApi.md#graphUserTraverseSystemGroup) | **GET** /users/{user_id}/systemgroups | List the System Groups bound to a User
[**policystatusesSystemsList**](GraphApi.md#policystatusesSystemsList) | **GET** /systems/{system_id}/policystatuses | List the policy statuses for a system

<a name="graphActiveDirectoryAssociationsList"></a>
# **graphActiveDirectoryAssociationsList**
> List&lt;GraphConnection&gt; graphActiveDirectoryAssociationsList(activedirectoryId, targets, limit, skip, xOrgId)

List the associations of an Active Directory instance

This endpoint returns the direct associations of this Active Directory instance.  A direct association can be a non-homogeneous relationship between 2 different objects, for example Active Directory and Users.   #### Sample Request &#x60;&#x60;&#x60; curl -X GET &#x27;https://console.jumpcloud.com/api/v2/activedirectories/{ActiveDirectory_ID}/associations?targets&#x3D;user \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String activedirectoryId = "activedirectoryId_example"; // String | 
List<String> targets = Arrays.asList("targets_example"); // List<String> | Targets which a \"active_directory\" can be associated to.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    List<GraphConnection> result = apiInstance.graphActiveDirectoryAssociationsList(activedirectoryId, targets, limit, skip, xOrgId);
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
 **targets** | [**List&lt;String&gt;**](String.md)| Targets which a \&quot;active_directory\&quot; can be associated to. | [enum: user, user_group]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**List&lt;GraphConnection&gt;**](GraphConnection.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphActiveDirectoryAssociationsPost"></a>
# **graphActiveDirectoryAssociationsPost**
> graphActiveDirectoryAssociationsPost(activedirectoryId, body, xOrgId)

Manage the associations of an Active Directory instance

This endpoint allows you to manage the _direct_ associations of an Active Directory instance.  A direct association can be a non-homogeneous relationship between 2 different objects, for example Active Directory and Users.  #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/activedirectories/{AD_Instance_ID}/associations \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;user\&quot;,     \&quot;id\&quot;: \&quot;{User_ID}\&quot;   }&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String activedirectoryId = "activedirectoryId_example"; // String | 
GraphOperationActiveDirectory body = new GraphOperationActiveDirectory(); // GraphOperationActiveDirectory | 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    apiInstance.graphActiveDirectoryAssociationsPost(activedirectoryId, body, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphActiveDirectoryAssociationsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **activedirectoryId** | **String**|  |
 **body** | [**GraphOperationActiveDirectory**](GraphOperationActiveDirectory.md)|  | [optional]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="graphActiveDirectoryTraverseUser"></a>
# **graphActiveDirectoryTraverseUser**
> List&lt;GraphObjectWithPaths&gt; graphActiveDirectoryTraverseUser(activedirectoryId, filter, limit, xOrgId, skip)

List the Users bound to an Active Directory instance

This endpoint will return all Users bound to an Active Directory instance, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this Active Directory instance to the corresponding User; this array represents all grouping and/or associations that would have to be removed to deprovision the User from this Active Directory instance.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/activedirectories/{ActiveDirectory_ID}/users \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String activedirectoryId = "activedirectoryId_example"; // String | ObjectID of the Active Directory instance.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
try {
    List<GraphObjectWithPaths> result = apiInstance.graphActiveDirectoryTraverseUser(activedirectoryId, filter, limit, xOrgId, skip);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphActiveDirectoryTraverseUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **activedirectoryId** | **String**| ObjectID of the Active Directory instance. |
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphActiveDirectoryTraverseUserGroup"></a>
# **graphActiveDirectoryTraverseUserGroup**
> List&lt;GraphObjectWithPaths&gt; graphActiveDirectoryTraverseUserGroup(activedirectoryId, limit, xOrgId, skip, filter)

List the User Groups bound to an Active Directory instance

This endpoint will return all Users Groups bound to an Active Directory instance, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the group&#x27;s type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this Active Directory instance to the corresponding User Group; this array represents all grouping and/or associations that would have to be removed to deprovision the User Group from this Active Directory instance.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/activedirectories/{ActiveDirectory_ID}/usergroups \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String activedirectoryId = "activedirectoryId_example"; // String | ObjectID of the Active Directory instance.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
try {
    List<GraphObjectWithPaths> result = apiInstance.graphActiveDirectoryTraverseUserGroup(activedirectoryId, limit, xOrgId, skip, filter);
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
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphApplicationAssociationsList"></a>
# **graphApplicationAssociationsList**
> List&lt;GraphConnection&gt; graphApplicationAssociationsList(applicationId, targets, limit, skip, xOrgId)

List the associations of an Application

This endpoint will return the _direct_ associations of an Application. A direct association can be a non-homogeneous relationship between 2 different objects, for example Applications and User Groups.   #### Sample Request &#x60;&#x60;&#x60; curl -X GET &#x27;https://console.jumpcloud.com/api/v2/applications/{Application_ID}/associations?targets&#x3D;user_group \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String applicationId = "applicationId_example"; // String | ObjectID of the Application.
List<String> targets = Arrays.asList("targets_example"); // List<String> | Targets which a \"application\" can be associated to.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    List<GraphConnection> result = apiInstance.graphApplicationAssociationsList(applicationId, targets, limit, skip, xOrgId);
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
 **targets** | [**List&lt;String&gt;**](String.md)| Targets which a \&quot;application\&quot; can be associated to. | [enum: user, user_group]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**List&lt;GraphConnection&gt;**](GraphConnection.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphApplicationAssociationsPost"></a>
# **graphApplicationAssociationsPost**
> graphApplicationAssociationsPost(applicationId, body, xOrgId)

Manage the associations of an Application

This endpoint allows you to manage the _direct_ associations of an Application. A direct association can be a non-homogeneous relationship between 2 different objects, for example Application and User Groups.  #### Sample Request &#x60;&#x60;&#x60; curl -X POST &#x27;https://console.jumpcloud.com/api/v2/applications/{Application_ID}/associations&#x27; \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;user_group\&quot;,     \&quot;id\&quot;: \&quot;{Group_ID}\&quot;   }&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String applicationId = "applicationId_example"; // String | ObjectID of the Application.
GraphOperationApplication body = new GraphOperationApplication(); // GraphOperationApplication | 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    apiInstance.graphApplicationAssociationsPost(applicationId, body, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphApplicationAssociationsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationId** | **String**| ObjectID of the Application. |
 **body** | [**GraphOperationApplication**](GraphOperationApplication.md)|  | [optional]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="graphApplicationTraverseUser"></a>
# **graphApplicationTraverseUser**
> List&lt;GraphObjectWithPaths&gt; graphApplicationTraverseUser(applicationId, limit, xOrgId, skip, filter)

List the Users bound to an Application

This endpoint will return all Users bound to an Application, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this Application to the corresponding User; this array represents all grouping and/or associations that would have to be removed to deprovision the User from this Application.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/applications/{Application_ID}/users \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String applicationId = "applicationId_example"; // String | ObjectID of the Application.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
try {
    List<GraphObjectWithPaths> result = apiInstance.graphApplicationTraverseUser(applicationId, limit, xOrgId, skip, filter);
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
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphApplicationTraverseUserGroup"></a>
# **graphApplicationTraverseUserGroup**
> List&lt;GraphObjectWithPaths&gt; graphApplicationTraverseUserGroup(applicationId, limit, xOrgId, skip, filter)

List the User Groups bound to an Application

This endpoint will return all Users Groups bound to an Application, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the group&#x27;s type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates  each path from this Application to the corresponding User Group; this array represents all grouping and/or associations that would have to be removed to deprovision the User Group from this Application.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/applications/{Application_ID}/usergroups \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String applicationId = "applicationId_example"; // String | ObjectID of the Application.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
try {
    List<GraphObjectWithPaths> result = apiInstance.graphApplicationTraverseUserGroup(applicationId, limit, xOrgId, skip, filter);
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
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphCommandAssociationsList"></a>
# **graphCommandAssociationsList**
> List&lt;GraphConnection&gt; graphCommandAssociationsList(commandId, targets, limit, skip, xOrgId)

List the associations of a Command

This endpoint will return the _direct_ associations of this Command.  A direct association can be a non-homogeneous relationship between 2 different objects, for example Commands and User Groups.   #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/commands/{Command_ID}/associations?targets&#x3D;system_group \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String commandId = "commandId_example"; // String | ObjectID of the Command.
List<String> targets = Arrays.asList("targets_example"); // List<String> | Targets which a \"command\" can be associated to.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    List<GraphConnection> result = apiInstance.graphCommandAssociationsList(commandId, targets, limit, skip, xOrgId);
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
 **targets** | [**List&lt;String&gt;**](String.md)| Targets which a \&quot;command\&quot; can be associated to. | [enum: system, system_group]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**List&lt;GraphConnection&gt;**](GraphConnection.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphCommandAssociationsPost"></a>
# **graphCommandAssociationsPost**
> graphCommandAssociationsPost(commandId, body, xOrgId)

Manage the associations of a Command

This endpoint will allow you to manage the _direct_ associations of this Command.  A direct association can be a non-homogeneous relationship between 2 different objects, for example Commands and User Groups.   #### Sample Request &#x60;&#x60;&#x60;  curl -X POST https://console.jumpcloud.com/api/v2/commands/{Command_ID}/associations \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;system_group\&quot;,     \&quot;id\&quot;: \&quot;Group_ID\&quot;   }&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String commandId = "commandId_example"; // String | ObjectID of the Command.
GraphOperationCommand body = new GraphOperationCommand(); // GraphOperationCommand | 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    apiInstance.graphCommandAssociationsPost(commandId, body, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphCommandAssociationsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **commandId** | **String**| ObjectID of the Command. |
 **body** | [**GraphOperationCommand**](GraphOperationCommand.md)|  | [optional]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="graphCommandTraverseSystem"></a>
# **graphCommandTraverseSystem**
> List&lt;GraphObjectWithPaths&gt; graphCommandTraverseSystem(commandId, limit, xOrgId, skip, filter)

List the Systems bound to a Command

This endpoint will return all Systems bound to a Command, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this Command to the corresponding System; this array represents all grouping and/or associations that would have to be removed to deprovision the System from this Command.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/commands/{Command_ID}/systems \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String commandId = "commandId_example"; // String | ObjectID of the Command.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
try {
    List<GraphObjectWithPaths> result = apiInstance.graphCommandTraverseSystem(commandId, limit, xOrgId, skip, filter);
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
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphCommandTraverseSystemGroup"></a>
# **graphCommandTraverseSystemGroup**
> List&lt;GraphObjectWithPaths&gt; graphCommandTraverseSystemGroup(commandId, limit, xOrgId, skip, filter)

List the System Groups bound to a Command

This endpoint will return all System Groups bound to a Command, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the group&#x27;s type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this Command to the corresponding System Group; this array represents all grouping and/or associations that would have to be removed to deprovision the System Group from this Command.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/commands/{Command_ID}/systemgroups \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String commandId = "commandId_example"; // String | ObjectID of the Command.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
try {
    List<GraphObjectWithPaths> result = apiInstance.graphCommandTraverseSystemGroup(commandId, limit, xOrgId, skip, filter);
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
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphGSuiteAssociationsList"></a>
# **graphGSuiteAssociationsList**
> List&lt;GraphConnection&gt; graphGSuiteAssociationsList(gsuiteId, targets, limit, skip, xOrgId)

List the associations of a G Suite instance

This endpoint returns the _direct_ associations of this G Suite instance.  A direct association can be a non-homogeneous relationship between 2 different objects, for example G Suite and Users.   #### Sample Request &#x60;&#x60;&#x60; curl -X GET &#x27;https://console.jumpcloud.com/api/v2/gsuites/{Gsuite_ID}/associations?targets&#x3D;user_group \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String gsuiteId = "gsuiteId_example"; // String | ObjectID of the G Suite instance.
List<String> targets = Arrays.asList("targets_example"); // List<String> | Targets which a \"g_suite\" can be associated to.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    List<GraphConnection> result = apiInstance.graphGSuiteAssociationsList(gsuiteId, targets, limit, skip, xOrgId);
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
 **targets** | [**List&lt;String&gt;**](String.md)| Targets which a \&quot;g_suite\&quot; can be associated to. | [enum: user, user_group]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**List&lt;GraphConnection&gt;**](GraphConnection.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphGSuiteAssociationsPost"></a>
# **graphGSuiteAssociationsPost**
> graphGSuiteAssociationsPost(gsuiteId, body, xOrgId)

Manage the associations of a G Suite instance

This endpoint returns the _direct_ associations of this G Suite instance.  A direct association can be a non-homogeneous relationship between 2 different objects, for example G Suite and Users.   #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/gsuites/{Gsuite_ID}/associations \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;user_group\&quot;,     \&quot;id\&quot;: \&quot;{Group_ID}\&quot;   }&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String gsuiteId = "gsuiteId_example"; // String | ObjectID of the G Suite instance.
GraphOperationGSuite body = new GraphOperationGSuite(); // GraphOperationGSuite | 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
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
 **body** | [**GraphOperationGSuite**](GraphOperationGSuite.md)|  | [optional]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="graphGSuiteTraverseUser"></a>
# **graphGSuiteTraverseUser**
> List&lt;GraphObjectWithPaths&gt; graphGSuiteTraverseUser(gsuiteId, limit, xOrgId, skip, filter)

List the Users bound to a G Suite instance

This endpoint will return all Users bound to a G Suite instance, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this G Suite instance to the corresponding User; this array represents all grouping and/or associations that would have to be removed to deprovision the User from this G Suite instance.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60;   curl -X GET https://console.jumpcloud.com/api/v2/gsuites/{Gsuite_ID}/users \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String gsuiteId = "gsuiteId_example"; // String | ObjectID of the G Suite instance.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
try {
    List<GraphObjectWithPaths> result = apiInstance.graphGSuiteTraverseUser(gsuiteId, limit, xOrgId, skip, filter);
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
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphGSuiteTraverseUserGroup"></a>
# **graphGSuiteTraverseUserGroup**
> List&lt;GraphObjectWithPaths&gt; graphGSuiteTraverseUserGroup(gsuiteId, limit, xOrgId, skip, filter)

List the User Groups bound to a G Suite instance

This endpoint will return all User Groups bound to an G Suite instance, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the group&#x27;s type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this G Suite instance to the corresponding User Group; this array represents all grouping and/or associations that would have to be removed to deprovision the User Group from this G Suite instance.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60;   curl -X GET https://console.jumpcloud.com/api/v2/gsuites/{GSuite_ID}/usergroups \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String gsuiteId = "gsuiteId_example"; // String | ObjectID of the G Suite instance.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
try {
    List<GraphObjectWithPaths> result = apiInstance.graphGSuiteTraverseUserGroup(gsuiteId, limit, xOrgId, skip, filter);
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
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphLdapServerAssociationsList"></a>
# **graphLdapServerAssociationsList**
> List&lt;GraphConnection&gt; graphLdapServerAssociationsList(ldapserverId, targets, limit, skip, xOrgId)

List the associations of a LDAP Server

This endpoint returns the _direct_ associations of this LDAP Server.  A direct association can be a non-homogeneous relationship between 2 different objects, for example LDAP and Users.  #### Sample Request  &#x60;&#x60;&#x60;  curl -X GET &#x27;https://console.jumpcloud.com/api/v2/ldapservers/{LDAP_ID}/associations?targets&#x3D;user_group \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String ldapserverId = "ldapserverId_example"; // String | ObjectID of the LDAP Server.
List<String> targets = Arrays.asList("targets_example"); // List<String> | Targets which a \"ldap_server\" can be associated to.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    List<GraphConnection> result = apiInstance.graphLdapServerAssociationsList(ldapserverId, targets, limit, skip, xOrgId);
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
 **targets** | [**List&lt;String&gt;**](String.md)| Targets which a \&quot;ldap_server\&quot; can be associated to. | [enum: user, user_group]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**List&lt;GraphConnection&gt;**](GraphConnection.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphLdapServerAssociationsPost"></a>
# **graphLdapServerAssociationsPost**
> graphLdapServerAssociationsPost(ldapserverId, body, xOrgId)

Manage the associations of a LDAP Server

This endpoint allows you to manage the _direct_ associations of a LDAP Server.  A direct association can be a non-homogeneous relationship between 2 different objects, for example LDAP and Users.  #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/ldapservers/{LDAP_ID}/associations \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;user\&quot;,     \&quot;id\&quot;: \&quot;{User_ID}\&quot;   }&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String ldapserverId = "ldapserverId_example"; // String | ObjectID of the LDAP Server.
GraphOperationLdapServer body = new GraphOperationLdapServer(); // GraphOperationLdapServer | 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    apiInstance.graphLdapServerAssociationsPost(ldapserverId, body, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphLdapServerAssociationsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ldapserverId** | **String**| ObjectID of the LDAP Server. |
 **body** | [**GraphOperationLdapServer**](GraphOperationLdapServer.md)|  | [optional]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="graphLdapServerTraverseUser"></a>
# **graphLdapServerTraverseUser**
> List&lt;GraphObjectWithPaths&gt; graphLdapServerTraverseUser(ldapserverId, limit, xOrgId, skip, filter)

List the Users bound to a LDAP Server

This endpoint will return all Users bound to an LDAP Server, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this LDAP server instance to the corresponding User; this array represents all grouping and/or associations that would have to be removed to deprovision the User from this LDAP server instance.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/ldapservers/{LDAP_ID}/users \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String ldapserverId = "ldapserverId_example"; // String | ObjectID of the LDAP Server.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
try {
    List<GraphObjectWithPaths> result = apiInstance.graphLdapServerTraverseUser(ldapserverId, limit, xOrgId, skip, filter);
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
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphLdapServerTraverseUserGroup"></a>
# **graphLdapServerTraverseUserGroup**
> List&lt;GraphObjectWithPaths&gt; graphLdapServerTraverseUserGroup(ldapserverId, limit, xOrgId, skip, filter)

List the User Groups bound to a LDAP Server

This endpoint will return all Users Groups bound to a LDAP Server, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the group&#x27;s type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this LDAP server instance to the corresponding User Group; this array represents all grouping and/or associations that would have to be removed to deprovision the User Group from this LDAP server instance.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/ldapservers/{LDAP_ID}/usergroups \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String ldapserverId = "ldapserverId_example"; // String | ObjectID of the LDAP Server.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
try {
    List<GraphObjectWithPaths> result = apiInstance.graphLdapServerTraverseUserGroup(ldapserverId, limit, xOrgId, skip, filter);
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
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphOffice365AssociationsList"></a>
# **graphOffice365AssociationsList**
> List&lt;GraphConnection&gt; graphOffice365AssociationsList(office365Id, targets, limit, skip, xOrgId)

List the associations of an Office 365 instance

This endpoint returns _direct_ associations of an Office 365 instance.   A direct association can be a non-homogeneous relationship between 2 different objects, for example Office 365 and Users.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET &#x27;https://console.jumpcloud.com/api/v2/office365s/{OFFICE365_ID}/associations?targets&#x3D;user_group&#x27; \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27;  &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String office365Id = "office365Id_example"; // String | ObjectID of the Office 365 instance.
List<String> targets = Arrays.asList("targets_example"); // List<String> | Targets which a \"office_365\" can be associated to.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    List<GraphConnection> result = apiInstance.graphOffice365AssociationsList(office365Id, targets, limit, skip, xOrgId);
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
 **targets** | [**List&lt;String&gt;**](String.md)| Targets which a \&quot;office_365\&quot; can be associated to. | [enum: user, user_group]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**List&lt;GraphConnection&gt;**](GraphConnection.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphOffice365AssociationsPost"></a>
# **graphOffice365AssociationsPost**
> graphOffice365AssociationsPost(office365Id, body, xOrgId)

Manage the associations of an Office 365 instance

This endpoint allows you to manage the _direct_ associations of a Office 365 instance.  A direct association can be a non-homogeneous relationship between 2 different objects, for example Office 365 and Users.  #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/office365s/{OFFICE365_ID}/associations \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;user_group\&quot;,     \&quot;id\&quot;: \&quot;{Group_ID}\&quot;   }&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String office365Id = "office365Id_example"; // String | ObjectID of the Office 365 instance.
GraphOperationOffice365 body = new GraphOperationOffice365(); // GraphOperationOffice365 | 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    apiInstance.graphOffice365AssociationsPost(office365Id, body, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphOffice365AssociationsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **office365Id** | **String**| ObjectID of the Office 365 instance. |
 **body** | [**GraphOperationOffice365**](GraphOperationOffice365.md)|  | [optional]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="graphOffice365TraverseUser"></a>
# **graphOffice365TraverseUser**
> List&lt;GraphObjectWithPaths&gt; graphOffice365TraverseUser(office365Id, limit, xOrgId, skip, filter)

List the Users bound to an Office 365 instance

This endpoint will return all Users bound to an Office 365 instance, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this Office 365 instance to the corresponding User; this array represents all grouping and/or associations that would have to be removed to deprovision the User from this Office 365 instance.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/office365s/{OFFICE365_ID}/users \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String office365Id = "office365Id_example"; // String | ObjectID of the Office 365 suite.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
try {
    List<GraphObjectWithPaths> result = apiInstance.graphOffice365TraverseUser(office365Id, limit, xOrgId, skip, filter);
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
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphOffice365TraverseUserGroup"></a>
# **graphOffice365TraverseUserGroup**
> List&lt;GraphObjectWithPaths&gt; graphOffice365TraverseUserGroup(office365Id, limit, xOrgId, skip, filter)

List the User Groups bound to an Office 365 instance

This endpoint will return all Users Groups bound to an Office 365 instance, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the group&#x27;s type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this Office 365 instance to the corresponding User Group; this array represents all grouping and/or associations that would have to be removed to deprovision the User Group from this Office 365 instance.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60;   curl -X GET https://console.jumpcloud.com/api/v2/office365s/{OFFICE365_ID/usergroups \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String office365Id = "office365Id_example"; // String | ObjectID of the Office 365 suite.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
try {
    List<GraphObjectWithPaths> result = apiInstance.graphOffice365TraverseUserGroup(office365Id, limit, xOrgId, skip, filter);
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
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphPolicyAssociationsList"></a>
# **graphPolicyAssociationsList**
> List&lt;GraphConnection&gt; graphPolicyAssociationsList(policyId, targets, limit, skip, xOrgId)

List the associations of a Policy

This endpoint returns the _direct_ associations of a Policy.  A direct association can be a non-homogeneous relationship between 2 different objects, for example Policies and Systems.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET &#x27;https://console.jumpcloud.com/api/v2/policies/{Policy_ID}/associations?targets&#x3D;system_group \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String policyId = "policyId_example"; // String | ObjectID of the Policy.
List<String> targets = Arrays.asList("targets_example"); // List<String> | Targets which a \"policy\" can be associated to.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    List<GraphConnection> result = apiInstance.graphPolicyAssociationsList(policyId, targets, limit, skip, xOrgId);
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
 **targets** | [**List&lt;String&gt;**](String.md)| Targets which a \&quot;policy\&quot; can be associated to. | [enum: system, system_group]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**List&lt;GraphConnection&gt;**](GraphConnection.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphPolicyAssociationsPost"></a>
# **graphPolicyAssociationsPost**
> graphPolicyAssociationsPost(policyId, body, xOrgId)

Manage the associations of a Policy

This endpoint allows you to manage the _direct_ associations of a Policy.  A direct association can be a non-homogeneous relationship between 2 different objects, for example Policies and Systems.  #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/policies/{Policy_ID}/associations/ \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;system_group\&quot;,     \&quot;id\&quot;: \&quot;{Group_ID}\&quot;   }&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String policyId = "policyId_example"; // String | ObjectID of the Policy.
GraphOperationPolicy body = new GraphOperationPolicy(); // GraphOperationPolicy | 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    apiInstance.graphPolicyAssociationsPost(policyId, body, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphPolicyAssociationsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **policyId** | **String**| ObjectID of the Policy. |
 **body** | [**GraphOperationPolicy**](GraphOperationPolicy.md)|  | [optional]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="graphPolicyGroupAssociationsList"></a>
# **graphPolicyGroupAssociationsList**
> List&lt;GraphConnection&gt; graphPolicyGroupAssociationsList(groupId, targets, limit, skip, xOrgId)

List the associations of a Policy Group.

This endpoint returns the _direct_ associations of this Policy Group.  A direct association can be a non-homogeneous relationship between 2 different objects, for example Policy Groups and Policies.   #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/policygroups/{GroupID}/associations?targets&#x3D;system \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the Policy Group.
List<String> targets = Arrays.asList("targets_example"); // List<String> | Targets which a \"policy_group\" can be associated to.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    List<GraphConnection> result = apiInstance.graphPolicyGroupAssociationsList(groupId, targets, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphPolicyGroupAssociationsList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| ObjectID of the Policy Group. |
 **targets** | [**List&lt;String&gt;**](String.md)| Targets which a \&quot;policy_group\&quot; can be associated to. | [enum: system, system_group]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**List&lt;GraphConnection&gt;**](GraphConnection.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphPolicyGroupAssociationsPost"></a>
# **graphPolicyGroupAssociationsPost**
> graphPolicyGroupAssociationsPost(groupId, body, xOrgId)

Manage the associations of a Policy Group

This endpoint manages the _direct_ associations of this Policy Group.  A direct association can be a non-homogeneous relationship between 2 different objects, for example Policy Groups and Policies.   #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/policygroups/{GroupID}/associations \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;system\&quot;,     \&quot;id\&quot;: \&quot;{SystemID}\&quot;   }&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the Policy Group.
GraphOperationPolicyGroup body = new GraphOperationPolicyGroup(); // GraphOperationPolicyGroup | 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    apiInstance.graphPolicyGroupAssociationsPost(groupId, body, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphPolicyGroupAssociationsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| ObjectID of the Policy Group. |
 **body** | [**GraphOperationPolicyGroup**](GraphOperationPolicyGroup.md)|  | [optional]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="graphPolicyGroupMembersList"></a>
# **graphPolicyGroupMembersList**
> List&lt;GraphConnection&gt; graphPolicyGroupMembersList(groupId, limit, skip, xOrgId)

List the members of a Policy Group

This endpoint returns the Policy members of a Policy Group.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/policygroups/{GroupID}/members \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the Policy Group.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    List<GraphConnection> result = apiInstance.graphPolicyGroupMembersList(groupId, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphPolicyGroupMembersList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| ObjectID of the Policy Group. |
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**List&lt;GraphConnection&gt;**](GraphConnection.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphPolicyGroupMembersPost"></a>
# **graphPolicyGroupMembersPost**
> graphPolicyGroupMembersPost(groupId, body, xOrgId)

Manage the members of a Policy Group

This endpoint allows you to manage the Policy members of a Policy Group.  #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/policygroups/{GroupID}/members \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;policy\&quot;,     \&quot;id\&quot;: \&quot;{Policy_ID}\&quot;   }&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the Policy Group.
GraphOperationPolicyGroupMember body = new GraphOperationPolicyGroupMember(); // GraphOperationPolicyGroupMember | 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    apiInstance.graphPolicyGroupMembersPost(groupId, body, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphPolicyGroupMembersPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| ObjectID of the Policy Group. |
 **body** | [**GraphOperationPolicyGroupMember**](GraphOperationPolicyGroupMember.md)|  | [optional]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="graphPolicyGroupMembership"></a>
# **graphPolicyGroupMembership**
> List&lt;GraphObjectWithPaths&gt; graphPolicyGroupMembership(groupId, filter, limit, skip, sort, xOrgId)

List the Policy Group&#x27;s membership

This endpoint returns all Policy members that are a member of this Policy Group.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/policygroups/{GroupID}/membership \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the Policy Group.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> sort = Arrays.asList("sort_example"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    List<GraphObjectWithPaths> result = apiInstance.graphPolicyGroupMembership(groupId, filter, limit, skip, sort, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphPolicyGroupMembership");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| ObjectID of the Policy Group. |
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **sort** | [**List&lt;String&gt;**](String.md)| The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  | [optional]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphPolicyGroupTraverseSystem"></a>
# **graphPolicyGroupTraverseSystem**
> List&lt;GraphObjectWithPaths&gt; graphPolicyGroupTraverseSystem(groupId, limit, xOrgId, skip, filter)

List the Systems bound to a Policy Group

This endpoint will return all Systems bound to a Policy Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this Policy Group to the corresponding System; this array represents all grouping and/or associations that would have to be removed to deprovision the System from this Policy Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/policygroups/{GroupID}/systems \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the Policy Group.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
try {
    List<GraphObjectWithPaths> result = apiInstance.graphPolicyGroupTraverseSystem(groupId, limit, xOrgId, skip, filter);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphPolicyGroupTraverseSystem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| ObjectID of the Policy Group. |
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphPolicyGroupTraverseSystemGroup"></a>
# **graphPolicyGroupTraverseSystemGroup**
> List&lt;GraphObjectWithPaths&gt; graphPolicyGroupTraverseSystemGroup(groupId, limit, xOrgId, skip, filter)

List the System Groups bound to Policy Groups

This endpoint will return all System Groups bound to a Policy Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this Policy Group to the corresponding System Group; this array represents all grouping and/or associations that would have to be removed to deprovision the System Group from this Policy Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/policygroups/{GroupID}/systemgroups \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the Policy Group.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
try {
    List<GraphObjectWithPaths> result = apiInstance.graphPolicyGroupTraverseSystemGroup(groupId, limit, xOrgId, skip, filter);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphPolicyGroupTraverseSystemGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| ObjectID of the Policy Group. |
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphPolicyMemberOf"></a>
# **graphPolicyMemberOf**
> List&lt;GraphObjectWithPaths&gt; graphPolicyMemberOf(policyId, filter, limit, skip, date, authorization, sort, xOrgId)

List the parent Groups of a Policy

This endpoint returns all the Policy Groups a Policy is a member of.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/policies/{Policy_ID}/memberof \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27;  &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String policyId = "policyId_example"; // String | ObjectID of the Policy.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String date = "date_example"; // String | Current date header for the System Context API
String authorization = "authorization_example"; // String | Authorization header for the System Context API
List<String> sort = Arrays.asList("sort_example"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    List<GraphObjectWithPaths> result = apiInstance.graphPolicyMemberOf(policyId, filter, limit, skip, date, authorization, sort, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphPolicyMemberOf");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **policyId** | **String**| ObjectID of the Policy. |
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **date** | **String**| Current date header for the System Context API | [optional]
 **authorization** | **String**| Authorization header for the System Context API | [optional]
 **sort** | [**List&lt;String&gt;**](String.md)| The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  | [optional]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphPolicyTraverseSystem"></a>
# **graphPolicyTraverseSystem**
> List&lt;GraphObjectWithPaths&gt; graphPolicyTraverseSystem(policyId, limit, xOrgId, skip, filter)

List the Systems bound to a Policy

This endpoint will return all Systems bound to a Policy, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this Policy to the corresponding System; this array represents all grouping and/or associations that would have to be removed to deprovision the System from this Policy.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/policies/{Policy_ID}/systems \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String policyId = "policyId_example"; // String | ObjectID of the Command.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
try {
    List<GraphObjectWithPaths> result = apiInstance.graphPolicyTraverseSystem(policyId, limit, xOrgId, skip, filter);
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
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphPolicyTraverseSystemGroup"></a>
# **graphPolicyTraverseSystemGroup**
> List&lt;GraphObjectWithPaths&gt; graphPolicyTraverseSystemGroup(policyId, limit, xOrgId, skip, filter)

List the System Groups bound to a Policy

This endpoint will return all Systems Groups bound to a Policy, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the group&#x27;s type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this Policy to the corresponding System Group; this array represents all grouping and/or associations that would have to be removed to deprovision the System Group from this Policy.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET  https://console.jumpcloud.com/api/v2/policies/{Policy_ID}/systemgroups \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String policyId = "policyId_example"; // String | ObjectID of the Command.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
try {
    List<GraphObjectWithPaths> result = apiInstance.graphPolicyTraverseSystemGroup(policyId, limit, xOrgId, skip, filter);
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
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphRadiusServerAssociationsList"></a>
# **graphRadiusServerAssociationsList**
> List&lt;GraphConnection&gt; graphRadiusServerAssociationsList(radiusserverId, targets, limit, skip, xOrgId)

List the associations of a RADIUS  Server

This endpoint returns the _direct_ associations of a Radius Server.  A direct association can be a non-homogeneous relationship between 2 different objects, for example Radius Servers and Users.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/radiusservers/{RADIUS_ID}/associations?targets&#x3D;user_group \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String radiusserverId = "radiusserverId_example"; // String | ObjectID of the Radius Server.
List<String> targets = Arrays.asList("targets_example"); // List<String> | Targets which a \"radius_server\" can be associated to.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    List<GraphConnection> result = apiInstance.graphRadiusServerAssociationsList(radiusserverId, targets, limit, skip, xOrgId);
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
 **targets** | [**List&lt;String&gt;**](String.md)| Targets which a \&quot;radius_server\&quot; can be associated to. | [enum: user, user_group]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**List&lt;GraphConnection&gt;**](GraphConnection.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphRadiusServerAssociationsPost"></a>
# **graphRadiusServerAssociationsPost**
> graphRadiusServerAssociationsPost(radiusserverId, body, xOrgId)

Manage the associations of a RADIUS Server

This endpoint allows you to manage the _direct_ associations of a Radius Server.  A direct association can be a non-homogeneous relationship between 2 different objects, for example Radius Servers and Users.  #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/radiusservers/{RADIUS_ID}/associations \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{   \&quot;type\&quot;:\&quot;user\&quot;,  \&quot;id\&quot;:\&quot;{USER_ID}\&quot;,  \&quot;op\&quot;:\&quot;add\&quot;   }&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String radiusserverId = "radiusserverId_example"; // String | ObjectID of the Radius Server.
GraphOperationRadiusServer body = new GraphOperationRadiusServer(); // GraphOperationRadiusServer | 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    apiInstance.graphRadiusServerAssociationsPost(radiusserverId, body, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphRadiusServerAssociationsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **radiusserverId** | **String**| ObjectID of the Radius Server. |
 **body** | [**GraphOperationRadiusServer**](GraphOperationRadiusServer.md)|  | [optional]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="graphRadiusServerTraverseUser"></a>
# **graphRadiusServerTraverseUser**
> List&lt;GraphObjectWithPaths&gt; graphRadiusServerTraverseUser(radiusserverId, limit, xOrgId, skip, filter)

List the Users bound to a RADIUS  Server

This endpoint will return all Users bound to a RADIUS Server, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this RADIUS server instance to the corresponding User; this array represents all grouping and/or associations that would have to be removed to deprovision the User from this RADIUS server instance.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.   #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/ldapservers/{LDAP_ID}/users \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27;   &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String radiusserverId = "radiusserverId_example"; // String | ObjectID of the Radius Server.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
try {
    List<GraphObjectWithPaths> result = apiInstance.graphRadiusServerTraverseUser(radiusserverId, limit, xOrgId, skip, filter);
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
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphRadiusServerTraverseUserGroup"></a>
# **graphRadiusServerTraverseUserGroup**
> List&lt;GraphObjectWithPaths&gt; graphRadiusServerTraverseUserGroup(radiusserverId, limit, xOrgId, skip, filter)

List the User Groups bound to a RADIUS  Server

This endpoint will return all Users Groups bound to a RADIUS Server, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the group&#x27;s type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this RADIUS server instance to the corresponding User Group; this array represents all grouping and/or associations that would have to be removed to deprovision the User Group from this RADIUS server instance.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/radiusservers/{RADIUS_ID}/usergroups \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String radiusserverId = "radiusserverId_example"; // String | ObjectID of the Radius Server.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
try {
    List<GraphObjectWithPaths> result = apiInstance.graphRadiusServerTraverseUserGroup(radiusserverId, limit, xOrgId, skip, filter);
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
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphSoftwareappsAssociationsList"></a>
# **graphSoftwareappsAssociationsList**
> List&lt;GraphConnection&gt; graphSoftwareappsAssociationsList(softwareAppId, targets, limit, skip, xOrgId)

List the associations of a Software Application

This endpoint will return the _direct_ associations of a Software Application. A direct association can be a non-homogeneous relationship between 2 different objects, for example Software Application and System Groups.   #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/softwareapps/{software_app_id}/associations?targets&#x3D;system_group \\   -H &#x27;accept: application/json&#x27; \\   -H &#x27;content-type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String softwareAppId = "softwareAppId_example"; // String | ObjectID of the Software App.
List<String> targets = Arrays.asList("targets_example"); // List<String> | Targets which a \"software_app\" can be associated to.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    List<GraphConnection> result = apiInstance.graphSoftwareappsAssociationsList(softwareAppId, targets, limit, skip, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphSoftwareappsAssociationsList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **softwareAppId** | **String**| ObjectID of the Software App. |
 **targets** | [**List&lt;String&gt;**](String.md)| Targets which a \&quot;software_app\&quot; can be associated to. | [enum: system, system_group]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**List&lt;GraphConnection&gt;**](GraphConnection.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphSoftwareappsAssociationsPost"></a>
# **graphSoftwareappsAssociationsPost**
> graphSoftwareappsAssociationsPost(softwareAppId, body, xOrgId)

Manage the associations of a software application.

This endpoint allows you to associate or disassociate a software application to a system or system group.  #### Sample Request &#x60;&#x60;&#x60; $ curl -X POST https://console.jumpcloud.com/api/v2/softwareapps/{software_app_id}/associations \\ -H &#x27;Accept: application/json&#x27; \\ -H &#x27;Content-Type: application/json&#x27; \\ -H &#x27;x-api-key: {API_KEY}&#x27; \\ -d &#x27;{   \&quot;id\&quot;: \&quot;&lt;object_id&gt;\&quot;,   \&quot;op\&quot;: \&quot;add\&quot;,   \&quot;type\&quot;: \&quot;system\&quot;  }&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String softwareAppId = "softwareAppId_example"; // String | ObjectID of the Software App.
GraphOperationSoftwareApp body = new GraphOperationSoftwareApp(); // GraphOperationSoftwareApp | 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    apiInstance.graphSoftwareappsAssociationsPost(softwareAppId, body, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphSoftwareappsAssociationsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **softwareAppId** | **String**| ObjectID of the Software App. |
 **body** | [**GraphOperationSoftwareApp**](GraphOperationSoftwareApp.md)|  | [optional]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="graphSoftwareappsTraverseSystem"></a>
# **graphSoftwareappsTraverseSystem**
> List&lt;GraphObjectWithPaths&gt; graphSoftwareappsTraverseSystem(softwareAppId, limit, xOrgId, skip, filter)

List the Systems bound to a Software App.

This endpoint will return all Systems bound to a Software App, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this Software App to the corresponding System; this array represents all grouping and/or associations that would have to be removed to deprovision the System from this Software App.  See &#x60;/associations&#x60; endpoint to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/softwareapps/{software_app_id}/systems \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String softwareAppId = "softwareAppId_example"; // String | ObjectID of the Software App.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
try {
    List<GraphObjectWithPaths> result = apiInstance.graphSoftwareappsTraverseSystem(softwareAppId, limit, xOrgId, skip, filter);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphSoftwareappsTraverseSystem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **softwareAppId** | **String**| ObjectID of the Software App. |
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphSoftwareappsTraverseSystemGroup"></a>
# **graphSoftwareappsTraverseSystemGroup**
> List&lt;GraphObjectWithPaths&gt; graphSoftwareappsTraverseSystemGroup(softwareAppId, limit, xOrgId, skip, filter)

List the System Groups bound to a Software App.

This endpoint will return all Systems Groups bound to a Software App, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the group&#x27;s type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this Software App to the corresponding System Group; this array represents all grouping and/or associations that would have to be removed to deprovision the System Group from this Software App.  See &#x60;/associations&#x60; endpoint to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET  https://console.jumpcloud.com/api/v2/softwareapps/{software_app_id}/systemgroups \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String softwareAppId = "softwareAppId_example"; // String | ObjectID of the Software App.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
try {
    List<GraphObjectWithPaths> result = apiInstance.graphSoftwareappsTraverseSystemGroup(softwareAppId, limit, xOrgId, skip, filter);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphSoftwareappsTraverseSystemGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **softwareAppId** | **String**| ObjectID of the Software App. |
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphSystemAssociationsList"></a>
# **graphSystemAssociationsList**
> List&lt;GraphConnection&gt; graphSystemAssociationsList(systemId, targets, limit, skip, date, authorization, xOrgId)

List the associations of a System

This endpoint returns the _direct_ associations of a System.  A direct association can be a non-homogeneous relationship between 2 different objects, for example Systems and Users.   #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systems/{System_ID}/associations?targets&#x3D;user \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27;  &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String systemId = "systemId_example"; // String | ObjectID of the System.
List<String> targets = Arrays.asList("targets_example"); // List<String> | Targets which a \"system\" can be associated to.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String date = "date_example"; // String | Current date header for the System Context API
String authorization = "authorization_example"; // String | Authorization header for the System Context API
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    List<GraphConnection> result = apiInstance.graphSystemAssociationsList(systemId, targets, limit, skip, date, authorization, xOrgId);
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
 **targets** | [**List&lt;String&gt;**](String.md)| Targets which a \&quot;system\&quot; can be associated to. | [enum: command, policy, policy_group, user, user_group]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **date** | **String**| Current date header for the System Context API | [optional]
 **authorization** | **String**| Authorization header for the System Context API | [optional]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**List&lt;GraphConnection&gt;**](GraphConnection.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphSystemAssociationsPost"></a>
# **graphSystemAssociationsPost**
> graphSystemAssociationsPost(systemId, body, date, authorization, xOrgId)

Manage associations of a System

This endpoint allows you to manage the _direct_ associations of a System.  A direct association can be a non-homogeneous relationship between 2 different objects, for example Systems and Users.   #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/systems/{System_ID}/associations \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{     \&quot;attributes\&quot;: {       \&quot;sudo\&quot;: {         \&quot;enabled\&quot;: true,         \&quot;withoutPassword\&quot;: false       }     },     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;user\&quot;,     \&quot;id\&quot;: \&quot;UserID\&quot;   }&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String systemId = "systemId_example"; // String | ObjectID of the System.
GraphOperationSystem body = new GraphOperationSystem(); // GraphOperationSystem | 
String date = "date_example"; // String | Current date header for the System Context API
String authorization = "authorization_example"; // String | Authorization header for the System Context API
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    apiInstance.graphSystemAssociationsPost(systemId, body, date, authorization, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphSystemAssociationsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **systemId** | **String**| ObjectID of the System. |
 **body** | [**GraphOperationSystem**](GraphOperationSystem.md)|  | [optional]
 **date** | **String**| Current date header for the System Context API | [optional]
 **authorization** | **String**| Authorization header for the System Context API | [optional]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="graphSystemGroupAssociationsList"></a>
# **graphSystemGroupAssociationsList**
> List&lt;GraphConnection&gt; graphSystemGroupAssociationsList(groupId, targets, limit, skip, xOrgId)

List the associations of a System Group

This endpoint returns the _direct_ associations of a System Group.  A direct association can be a non-homogeneous relationship between 2 different objects, for example System Groups and Users.   #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systemgroups/{GroupID}/associations?targets&#x3D;user \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the System Group.
List<String> targets = Arrays.asList("targets_example"); // List<String> | Targets which a \"system_group\" can be associated to.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    List<GraphConnection> result = apiInstance.graphSystemGroupAssociationsList(groupId, targets, limit, skip, xOrgId);
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
 **targets** | [**List&lt;String&gt;**](String.md)| Targets which a \&quot;system_group\&quot; can be associated to. | [enum: command, policy, policy_group, user, user_group]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**List&lt;GraphConnection&gt;**](GraphConnection.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphSystemGroupAssociationsPost"></a>
# **graphSystemGroupAssociationsPost**
> graphSystemGroupAssociationsPost(groupId, body, xOrgId)

Manage the associations of a System Group

This endpoint allows you to manage the _direct_ associations of a System Group.  A direct association can be a non-homogeneous relationship between 2 different objects, for example System Groups and Users.   #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/systemgroups/{GroupID}/associations \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;user\&quot;,     \&quot;id\&quot;: \&quot;{UserID}\&quot;   }&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the System Group.
GraphOperationSystemGroup body = new GraphOperationSystemGroup(); // GraphOperationSystemGroup | 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    apiInstance.graphSystemGroupAssociationsPost(groupId, body, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphSystemGroupAssociationsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| ObjectID of the System Group. |
 **body** | [**GraphOperationSystemGroup**](GraphOperationSystemGroup.md)|  | [optional]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="graphSystemGroupMembersList"></a>
# **graphSystemGroupMembersList**
> List&lt;GraphConnection&gt; graphSystemGroupMembersList(groupId, limit, skip, xOrgId)

List the members of a System Group

This endpoint returns the system members of a System Group.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systemgroups/{Group_ID}/members \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27;  &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the System Group.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    List<GraphConnection> result = apiInstance.graphSystemGroupMembersList(groupId, limit, skip, xOrgId);
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
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**List&lt;GraphConnection&gt;**](GraphConnection.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphSystemGroupMembersPost"></a>
# **graphSystemGroupMembersPost**
> graphSystemGroupMembersPost(groupId, body, date, authorization, xOrgId)

Manage the members of a System Group

This endpoint allows you to manage the system members of a System Group.  #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/systemgroups/{Group_ID}/members \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;system\&quot;,     \&quot;id\&quot;: \&quot;{System_ID}\&quot;   }&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the System Group.
GraphOperationSystemGroupMember body = new GraphOperationSystemGroupMember(); // GraphOperationSystemGroupMember | 
String date = "date_example"; // String | Current date header for the System Context API
String authorization = "authorization_example"; // String | Authorization header for the System Context API
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    apiInstance.graphSystemGroupMembersPost(groupId, body, date, authorization, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphSystemGroupMembersPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| ObjectID of the System Group. |
 **body** | [**GraphOperationSystemGroupMember**](GraphOperationSystemGroupMember.md)|  | [optional]
 **date** | **String**| Current date header for the System Context API | [optional]
 **authorization** | **String**| Authorization header for the System Context API | [optional]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="graphSystemGroupMembership"></a>
# **graphSystemGroupMembership**
> List&lt;GraphObjectWithPaths&gt; graphSystemGroupMembership(groupId, limit, skip, sort, filter, xOrgId)

List the System Group&#x27;s membership

This endpoint returns all Systems that are a member of this System Group.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systemgroups/{Group_ID/membership \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27;  &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the System Group.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> sort = Arrays.asList("sort_example"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    List<GraphObjectWithPaths> result = apiInstance.graphSystemGroupMembership(groupId, limit, skip, sort, filter, xOrgId);
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
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **sort** | [**List&lt;String&gt;**](String.md)| The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  | [optional]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphSystemGroupTraverseCommand"></a>
# **graphSystemGroupTraverseCommand**
> List&lt;GraphObjectWithPaths&gt; graphSystemGroupTraverseCommand(groupId, limit, xOrgId, skip, filter)

List the Commands bound to a System Group

This endpoint will return all Commands bound to a System Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the group&#x27;s type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this System Group to the corresponding Command; this array represents all grouping and/or associations that would have to be removed to deprovision the Command from this System Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systemgroups/{GroupID}/commands \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the System Group.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
try {
    List<GraphObjectWithPaths> result = apiInstance.graphSystemGroupTraverseCommand(groupId, limit, xOrgId, skip, filter);
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
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphSystemGroupTraversePolicy"></a>
# **graphSystemGroupTraversePolicy**
> List&lt;GraphObjectWithPaths&gt; graphSystemGroupTraversePolicy(groupId, limit, xOrgId, skip, filter)

List the Policies bound to a System Group

This endpoint will return all Policies bound to a System Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this System Group to the corresponding Policy; this array represents all grouping and/or associations that would have to be removed to deprovision the Policy from this System Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  This endpoint is not public yet as we haven&#x27;t finished the code.  ##### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systemgroups/{GroupID}/policies \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the System Group.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
try {
    List<GraphObjectWithPaths> result = apiInstance.graphSystemGroupTraversePolicy(groupId, limit, xOrgId, skip, filter);
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
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphSystemGroupTraversePolicyGroup"></a>
# **graphSystemGroupTraversePolicyGroup**
> List&lt;GraphObjectWithPaths&gt; graphSystemGroupTraversePolicyGroup(groupId, limit, xOrgId, skip, filter)

List the Policy Groups bound to a System Group

This endpoint will return all Policy Groups bound to a System Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this System Group to the corresponding Policy Group; this array represents all grouping and/or associations that would have to be removed to deprovision the Policy Group from this System Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systemgroups/{GroupID}/policygroups \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27;  &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the System Group.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
try {
    List<GraphObjectWithPaths> result = apiInstance.graphSystemGroupTraversePolicyGroup(groupId, limit, xOrgId, skip, filter);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphSystemGroupTraversePolicyGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| ObjectID of the System Group. |
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphSystemGroupTraverseUser"></a>
# **graphSystemGroupTraverseUser**
> List&lt;GraphObjectWithPaths&gt; graphSystemGroupTraverseUser(groupId, limit, xOrgId, skip, filter)

List the Users bound to a System Group

This endpoint will return all Users bound to a System Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this System Group to the corresponding User; this array represents all grouping and/or associations that would have to be removed to deprovision the User from this System Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systemgroups/{GroupID}/users \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the System Group.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
try {
    List<GraphObjectWithPaths> result = apiInstance.graphSystemGroupTraverseUser(groupId, limit, xOrgId, skip, filter);
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
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphSystemGroupTraverseUserGroup"></a>
# **graphSystemGroupTraverseUserGroup**
> List&lt;GraphObjectWithPaths&gt; graphSystemGroupTraverseUserGroup(groupId, limit, xOrgId, skip, filter)

List the User Groups bound to a System Group

This endpoint will return all User Groups bound to a System Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this System Group to the corresponding User Group; this array represents all grouping and/or associations that would have to be removed to deprovision the User Group from this System Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systemgroups/{GroupID}/usergroups \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27;  &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the System Group.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
try {
    List<GraphObjectWithPaths> result = apiInstance.graphSystemGroupTraverseUserGroup(groupId, limit, xOrgId, skip, filter);
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
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphSystemMemberOf"></a>
# **graphSystemMemberOf**
> List&lt;GraphObjectWithPaths&gt; graphSystemMemberOf(systemId, filter, limit, skip, date, authorization, sort, xOrgId)

List the parent Groups of a System

This endpoint returns all the System Groups a System is a member of.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systems/{System_ID}/memberof \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27;  &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String systemId = "systemId_example"; // String | ObjectID of the System.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String date = "date_example"; // String | Current date header for the System Context API
String authorization = "authorization_example"; // String | Authorization header for the System Context API
List<String> sort = Arrays.asList("sort_example"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    List<GraphObjectWithPaths> result = apiInstance.graphSystemMemberOf(systemId, filter, limit, skip, date, authorization, sort, xOrgId);
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
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **date** | **String**| Current date header for the System Context API | [optional]
 **authorization** | **String**| Authorization header for the System Context API | [optional]
 **sort** | [**List&lt;String&gt;**](String.md)| The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  | [optional]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphSystemTraverseCommand"></a>
# **graphSystemTraverseCommand**
> List&lt;GraphObjectWithPaths&gt; graphSystemTraverseCommand(systemId, limit, xOrgId, skip, filter)

List the Commands bound to a System

This endpoint will return all Commands bound to a System, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this System to the corresponding Command; this array represents all grouping and/or associations that would have to be removed to deprovision the Command from this System.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systems/{System_ID}/commands \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27;  &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String systemId = "systemId_example"; // String | ObjectID of the System.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
try {
    List<GraphObjectWithPaths> result = apiInstance.graphSystemTraverseCommand(systemId, limit, xOrgId, skip, filter);
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
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphSystemTraversePolicy"></a>
# **graphSystemTraversePolicy**
> List&lt;GraphObjectWithPaths&gt; graphSystemTraversePolicy(systemId, limit, xOrgId, skip, filter)

List the Policies bound to a System

This endpoint will return all Policies bound to a System, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this System to the corresponding Policy; this array represents all grouping and/or associations that would have to be removed to deprovision the Policy from this System.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  This endpoint is not yet public as we have finish the code.  ##### Sample Request  &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/{System_ID}/policies \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27;  &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String systemId = "systemId_example"; // String | ObjectID of the System.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
try {
    List<GraphObjectWithPaths> result = apiInstance.graphSystemTraversePolicy(systemId, limit, xOrgId, skip, filter);
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
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphSystemTraversePolicyGroup"></a>
# **graphSystemTraversePolicyGroup**
> List&lt;GraphObjectWithPaths&gt; graphSystemTraversePolicyGroup(systemId, limit, xOrgId, skip, date, authorization, filter)

List the Policy Groups bound to a System

This endpoint will return all Policy Groups bound to a System, either directly or indirectly essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this System to the corresponding Policy Group; this array represents all grouping and/or associations that would have to be removed to deprovision the Policy Group from this System.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systems/{System_ID}/policygroups \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27;  &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String systemId = "systemId_example"; // String | ObjectID of the System.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
String date = "date_example"; // String | Current date header for the System Context API
String authorization = "authorization_example"; // String | Authorization header for the System Context API
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
try {
    List<GraphObjectWithPaths> result = apiInstance.graphSystemTraversePolicyGroup(systemId, limit, xOrgId, skip, date, authorization, filter);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphSystemTraversePolicyGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **systemId** | **String**| ObjectID of the System. |
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **date** | **String**| Current date header for the System Context API | [optional]
 **authorization** | **String**| Authorization header for the System Context API | [optional]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphSystemTraverseUser"></a>
# **graphSystemTraverseUser**
> List&lt;GraphObjectWithPaths&gt; graphSystemTraverseUser(systemId, limit, xOrgId, skip, date, authorization, filter)

List the Users bound to a System

This endpoint will return all Users bound to a System, either directly or indirectly essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this System to the corresponding User; this array represents all grouping and/or associations that would have to be removed to deprovision the User from this System.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systems/{System_ID}/users \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27;  &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String systemId = "systemId_example"; // String | ObjectID of the System.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
String date = "date_example"; // String | Current date header for the System Context API
String authorization = "authorization_example"; // String | Authorization header for the System Context API
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
try {
    List<GraphObjectWithPaths> result = apiInstance.graphSystemTraverseUser(systemId, limit, xOrgId, skip, date, authorization, filter);
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
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **date** | **String**| Current date header for the System Context API | [optional]
 **authorization** | **String**| Authorization header for the System Context API | [optional]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphSystemTraverseUserGroup"></a>
# **graphSystemTraverseUserGroup**
> List&lt;GraphObjectWithPaths&gt; graphSystemTraverseUserGroup(systemId, limit, xOrgId, skip, date, authorization, filter)

List the User Groups bound to a System

This endpoint will return all User Groups bound to a System, either directly or indirectly essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this System to the corresponding User Group; this array represents all grouping and/or associations that would have to be removed to deprovision the User Group from this System.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systems/{System_ID}/usergroups \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27;  &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String systemId = "systemId_example"; // String | ObjectID of the System.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
String date = "date_example"; // String | Current date header for the System Context API
String authorization = "authorization_example"; // String | Authorization header for the System Context API
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
try {
    List<GraphObjectWithPaths> result = apiInstance.graphSystemTraverseUserGroup(systemId, limit, xOrgId, skip, date, authorization, filter);
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
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **date** | **String**| Current date header for the System Context API | [optional]
 **authorization** | **String**| Authorization header for the System Context API | [optional]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphUserAssociationsList"></a>
# **graphUserAssociationsList**
> List&lt;GraphConnection&gt; graphUserAssociationsList(userId, targets, limit, skip, xOrgId)

List the associations of a User

This endpoint returns the _direct_ associations of a User.  A direct association can be a non-homogeneous relationship between 2 different objects, for example Users and Systems.   #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/users/{UserID}/associations?targets&#x3D;system_group \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27;  &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String userId = "userId_example"; // String | ObjectID of the User.
List<String> targets = Arrays.asList("targets_example"); // List<String> | Targets which a \"user\" can be associated to.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    List<GraphConnection> result = apiInstance.graphUserAssociationsList(userId, targets, limit, skip, xOrgId);
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
 **targets** | [**List&lt;String&gt;**](String.md)| Targets which a \&quot;user\&quot; can be associated to. | [enum: active_directory, application, g_suite, ldap_server, office_365, radius_server, system, system_group]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**List&lt;GraphConnection&gt;**](GraphConnection.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphUserAssociationsPost"></a>
# **graphUserAssociationsPost**
> graphUserAssociationsPost(userId, body, xOrgId)

Manage the associations of a User

This endpoint allows you to manage the _direct_ associations of a User.  A direct association can be a non-homogeneous relationship between 2 different objects, for example Users and Systems.   #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/users/{UserID}/associations \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{     \&quot;attributes\&quot;: {       \&quot;sudo\&quot;: {       \&quot;enabled\&quot;: true,         \&quot;withoutPassword\&quot;: false       }     },     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;system_group\&quot;,     \&quot;id\&quot;: \&quot;{GroupID}\&quot;   }&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String userId = "userId_example"; // String | ObjectID of the User.
GraphOperationUser body = new GraphOperationUser(); // GraphOperationUser | 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    apiInstance.graphUserAssociationsPost(userId, body, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphUserAssociationsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| ObjectID of the User. |
 **body** | [**GraphOperationUser**](GraphOperationUser.md)|  | [optional]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="graphUserGroupAssociationsList"></a>
# **graphUserGroupAssociationsList**
> List&lt;GraphConnection&gt; graphUserGroupAssociationsList(groupId, targets, limit, skip, xOrgId)

List the associations of a User Group.

This endpoint returns the _direct_ associations of this User Group.  A direct association can be a non-homogeneous relationship between 2 different objects, for example User Groups and Users.   #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/associations?targets&#x3D;system \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the User Group.
List<String> targets = Arrays.asList("targets_example"); // List<String> | Targets which a \"user_group\" can be associated to.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    List<GraphConnection> result = apiInstance.graphUserGroupAssociationsList(groupId, targets, limit, skip, xOrgId);
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
 **targets** | [**List&lt;String&gt;**](String.md)| Targets which a \&quot;user_group\&quot; can be associated to. | [enum: active_directory, application, g_suite, ldap_server, office_365, radius_server, system, system_group]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**List&lt;GraphConnection&gt;**](GraphConnection.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphUserGroupAssociationsPost"></a>
# **graphUserGroupAssociationsPost**
> graphUserGroupAssociationsPost(groupId, body, xOrgId)

Manage the associations of a User Group

This endpoint manages the _direct_ associations of this User Group.  A direct association can be a non-homogeneous relationship between 2 different objects, for example User Groups and Users.   #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/associations \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;system\&quot;,     \&quot;id\&quot;: \&quot;{SystemID}\&quot;   }&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the User Group.
GraphOperationUserGroup body = new GraphOperationUserGroup(); // GraphOperationUserGroup | 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    apiInstance.graphUserGroupAssociationsPost(groupId, body, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphUserGroupAssociationsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| ObjectID of the User Group. |
 **body** | [**GraphOperationUserGroup**](GraphOperationUserGroup.md)|  | [optional]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="graphUserGroupMembersList"></a>
# **graphUserGroupMembersList**
> List&lt;GraphConnection&gt; graphUserGroupMembersList(groupId, limit, skip, xOrgId)

List the members of a User Group

This endpoint returns the user members of a User Group.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/members \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the User Group.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    List<GraphConnection> result = apiInstance.graphUserGroupMembersList(groupId, limit, skip, xOrgId);
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
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**List&lt;GraphConnection&gt;**](GraphConnection.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphUserGroupMembersPost"></a>
# **graphUserGroupMembersPost**
> graphUserGroupMembersPost(groupId, body, xOrgId)

Manage the members of a User Group

This endpoint allows you to manage the user members of a User Group.  #### Sample Request &#x60;&#x60;&#x60; curl -X POST https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/members \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; \\   -d &#x27;{     \&quot;op\&quot;: \&quot;add\&quot;,     \&quot;type\&quot;: \&quot;user\&quot;,     \&quot;id\&quot;: \&quot;{User_ID}\&quot;   }&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the User Group.
GraphOperationUserGroupMember body = new GraphOperationUserGroupMember(); // GraphOperationUserGroupMember | 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    apiInstance.graphUserGroupMembersPost(groupId, body, xOrgId);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphUserGroupMembersPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| ObjectID of the User Group. |
 **body** | [**GraphOperationUserGroupMember**](GraphOperationUserGroupMember.md)|  | [optional]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

null (empty response body)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="graphUserGroupMembership"></a>
# **graphUserGroupMembership**
> List&lt;GraphObjectWithPaths&gt; graphUserGroupMembership(groupId, filter, limit, skip, sort, xOrgId)

List the User Group&#x27;s membership

This endpoint returns all users members that are a member of this User Group.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/membership \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the User Group.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> sort = Arrays.asList("sort_example"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    List<GraphObjectWithPaths> result = apiInstance.graphUserGroupMembership(groupId, filter, limit, skip, sort, xOrgId);
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
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **sort** | [**List&lt;String&gt;**](String.md)| The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  | [optional]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphUserGroupTraverseActiveDirectory"></a>
# **graphUserGroupTraverseActiveDirectory**
> List&lt;GraphObjectWithPaths&gt; graphUserGroupTraverseActiveDirectory(groupId, limit, xOrgId, skip, filter)

List the Active Directories bound to a User Group

This endpoint will return all Active Directory Instances bound to a User Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User Group to the corresponding Active Directory; this array represents all grouping and/or associations that would have to be removed to deprovision the Active Directory from this User Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/activedirectories \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the User Group.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
try {
    List<GraphObjectWithPaths> result = apiInstance.graphUserGroupTraverseActiveDirectory(groupId, limit, xOrgId, skip, filter);
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
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphUserGroupTraverseApplication"></a>
# **graphUserGroupTraverseApplication**
> List&lt;GraphObjectWithPaths&gt; graphUserGroupTraverseApplication(groupId, limit, xOrgId, skip, filter)

List the Applications bound to a User Group

This endpoint will return all Applications bound to a User Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User Group to the corresponding Application; this array represents all grouping and/or associations that would have to be removed to deprovision the Application from this User Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/applications \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the User Group.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
try {
    List<GraphObjectWithPaths> result = apiInstance.graphUserGroupTraverseApplication(groupId, limit, xOrgId, skip, filter);
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
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphUserGroupTraverseDirectory"></a>
# **graphUserGroupTraverseDirectory**
> List&lt;GraphObjectWithPaths&gt; graphUserGroupTraverseDirectory(groupId, limit, xOrgId, skip, filter)

List the Directories bound to a User Group

This endpoint will return all Directories bound to a User Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User Group to the corresponding Directory; this array represents all grouping and/or associations that would have to be removed to deprovision the Directories from this User Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/directories \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27;  &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the User Group.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
try {
    List<GraphObjectWithPaths> result = apiInstance.graphUserGroupTraverseDirectory(groupId, limit, xOrgId, skip, filter);
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
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphUserGroupTraverseGSuite"></a>
# **graphUserGroupTraverseGSuite**
> List&lt;GraphObjectWithPaths&gt; graphUserGroupTraverseGSuite(groupId, limit, xOrgId, skip, filter)

List the G Suite instances bound to a User Group

This endpoint will return all G Suite Instances bound to a User Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User Group to the corresponding G Suite instance; this array represents all grouping and/or associations that would have to be removed to deprovision the G Suite instance from this User Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID/gsuites \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27;  &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the User Group.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
try {
    List<GraphObjectWithPaths> result = apiInstance.graphUserGroupTraverseGSuite(groupId, limit, xOrgId, skip, filter);
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
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphUserGroupTraverseLdapServer"></a>
# **graphUserGroupTraverseLdapServer**
> List&lt;GraphObjectWithPaths&gt; graphUserGroupTraverseLdapServer(groupId, limit, xOrgId, skip, filter)

List the LDAP Servers bound to a User Group

This endpoint will return all LDAP Servers bound to a User Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User Group to the corresponding LDAP Server; this array represents all grouping and/or associations that would have to be removed to deprovision the LDAP Server from this User Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/ldapservers \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the User Group.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
try {
    List<GraphObjectWithPaths> result = apiInstance.graphUserGroupTraverseLdapServer(groupId, limit, xOrgId, skip, filter);
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
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphUserGroupTraverseOffice365"></a>
# **graphUserGroupTraverseOffice365**
> List&lt;GraphObjectWithPaths&gt; graphUserGroupTraverseOffice365(groupId, limit, xOrgId, skip, filter)

List the Office 365 instances bound to a User Group

This endpoint will return all Office 365 instances bound to a User Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User Group to the corresponding Office 365 instance; this array represents all grouping and/or associations that would have to be removed to deprovision the Office 365 instance from this User Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/office365s \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the User Group.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
try {
    List<GraphObjectWithPaths> result = apiInstance.graphUserGroupTraverseOffice365(groupId, limit, xOrgId, skip, filter);
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
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphUserGroupTraverseRadiusServer"></a>
# **graphUserGroupTraverseRadiusServer**
> List&lt;GraphObjectWithPaths&gt; graphUserGroupTraverseRadiusServer(groupId, limit, xOrgId, skip, filter)

List the RADIUS Servers bound to a User Group

This endpoint will return all RADIUS servers bound to a User Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User Group to the corresponding RADIUS Server; this array represents all grouping and/or associations that would have to be removed to deprovision the RADIUS Server from this User Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/radiusservers \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27;  &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the User Group.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
try {
    List<GraphObjectWithPaths> result = apiInstance.graphUserGroupTraverseRadiusServer(groupId, limit, xOrgId, skip, filter);
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
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphUserGroupTraverseSystem"></a>
# **graphUserGroupTraverseSystem**
> List&lt;GraphObjectWithPaths&gt; graphUserGroupTraverseSystem(groupId, limit, xOrgId, skip, filter)

List the Systems bound to a User Group

This endpoint will return all Systems bound to a User Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User Group to the corresponding System; this array represents all grouping and/or associations that would have to be removed to deprovision the System from this User Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/systems \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the User Group.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
try {
    List<GraphObjectWithPaths> result = apiInstance.graphUserGroupTraverseSystem(groupId, limit, xOrgId, skip, filter);
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
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphUserGroupTraverseSystemGroup"></a>
# **graphUserGroupTraverseSystemGroup**
> List&lt;GraphObjectWithPaths&gt; graphUserGroupTraverseSystemGroup(groupId, limit, xOrgId, skip, filter)

List the System Groups bound to User Groups

This endpoint will return all System Groups bound to a User Group, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User Group to the corresponding System Group; this array represents all grouping and/or associations that would have to be removed to deprovision the System Group from this User Group.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/usergroups/{GroupID}/systemgroups \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String groupId = "groupId_example"; // String | ObjectID of the User Group.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
try {
    List<GraphObjectWithPaths> result = apiInstance.graphUserGroupTraverseSystemGroup(groupId, limit, xOrgId, skip, filter);
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
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphUserMemberOf"></a>
# **graphUserMemberOf**
> List&lt;GraphObjectWithPaths&gt; graphUserMemberOf(userId, filter, limit, skip, sort, xOrgId)

List the parent Groups of a User

This endpoint returns all the User Groups a User is a member of.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/users/{UserID}/memberof \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String userId = "userId_example"; // String | ObjectID of the User.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> sort = Arrays.asList("sort_example"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    List<GraphObjectWithPaths> result = apiInstance.graphUserMemberOf(userId, filter, limit, skip, sort, xOrgId);
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
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **sort** | [**List&lt;String&gt;**](String.md)| The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  | [optional]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphUserTraverseActiveDirectory"></a>
# **graphUserTraverseActiveDirectory**
> List&lt;GraphObjectWithPaths&gt; graphUserTraverseActiveDirectory(userId, filter, limit, xOrgId, skip)

List the Active Directory instances bound to a User

This endpoint will return all Active Directory Instances bound to a User, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User to the corresponding Active Directory instance; this array represents all grouping and/or associations that would have to be removed to deprovision the Active Directory instance from this User.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/users/{UserID}/activedirectories \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String userId = "userId_example"; // String | ObjectID of the User.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
try {
    List<GraphObjectWithPaths> result = apiInstance.graphUserTraverseActiveDirectory(userId, filter, limit, xOrgId, skip);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#graphUserTraverseActiveDirectory");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| ObjectID of the User. |
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphUserTraverseApplication"></a>
# **graphUserTraverseApplication**
> List&lt;GraphObjectWithPaths&gt; graphUserTraverseApplication(userId, limit, xOrgId, skip, filter)

List the Applications bound to a User

This endpoint will return all Applications bound to a User, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User to the corresponding Application; this array represents all grouping and/or associations that would have to be removed to deprovision the Application from this User.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/users/{UserID}/applications \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String userId = "userId_example"; // String | ObjectID of the User.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
try {
    List<GraphObjectWithPaths> result = apiInstance.graphUserTraverseApplication(userId, limit, xOrgId, skip, filter);
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
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphUserTraverseDirectory"></a>
# **graphUserTraverseDirectory**
> List&lt;GraphObjectWithPaths&gt; graphUserTraverseDirectory(userId, limit, xOrgId, skip, filter)

List the Directories bound to a User

This endpoint will return all Directories bound to a User, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User to the corresponding Directory; this array represents all grouping and/or associations that would have to be removed to deprovision the Directory from this User.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/users/{UserID}/directories \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String userId = "userId_example"; // String | ObjectID of the User.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
try {
    List<GraphObjectWithPaths> result = apiInstance.graphUserTraverseDirectory(userId, limit, xOrgId, skip, filter);
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
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphUserTraverseGSuite"></a>
# **graphUserTraverseGSuite**
> List&lt;GraphObjectWithPaths&gt; graphUserTraverseGSuite(userId, limit, xOrgId, skip, filter)

List the G Suite instances bound to a User

This endpoint will return all G-Suite Instances bound to a User, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User to the corresponding G Suite instance; this array represents all grouping and/or associations that would have to be removed to deprovision the G Suite instance from this User.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/users/{UserID}/gsuites \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String userId = "userId_example"; // String | ObjectID of the User.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
try {
    List<GraphObjectWithPaths> result = apiInstance.graphUserTraverseGSuite(userId, limit, xOrgId, skip, filter);
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
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphUserTraverseLdapServer"></a>
# **graphUserTraverseLdapServer**
> List&lt;GraphObjectWithPaths&gt; graphUserTraverseLdapServer(userId, limit, xOrgId, skip, filter)

List the LDAP servers bound to a User

This endpoint will return all LDAP Servers bound to a User, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User to the corresponding LDAP Server; this array represents all grouping and/or associations that would have to be removed to deprovision the LDAP Server from this User.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/users/{UserID}/ldapservers \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String userId = "userId_example"; // String | ObjectID of the User.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
try {
    List<GraphObjectWithPaths> result = apiInstance.graphUserTraverseLdapServer(userId, limit, xOrgId, skip, filter);
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
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphUserTraverseOffice365"></a>
# **graphUserTraverseOffice365**
> List&lt;GraphObjectWithPaths&gt; graphUserTraverseOffice365(userId, limit, xOrgId, skip, filter)

List the Office 365 instances bound to a User

This endpoint will return all Office 365 Instances bound to a User, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User to the corresponding Office 365 instance; this array represents all grouping and/or associations that would have to be removed to deprovision the Office 365 instance from this User.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/users/{UserID}/office365s \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String userId = "userId_example"; // String | ObjectID of the User.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
try {
    List<GraphObjectWithPaths> result = apiInstance.graphUserTraverseOffice365(userId, limit, xOrgId, skip, filter);
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
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphUserTraverseRadiusServer"></a>
# **graphUserTraverseRadiusServer**
> List&lt;GraphObjectWithPaths&gt; graphUserTraverseRadiusServer(userId, limit, xOrgId, skip, filter)

List the RADIUS Servers bound to a User

This endpoint will return all RADIUS Servers bound to a User, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User to the corresponding RADIUS Server; this array represents all grouping and/or associations that would have to be removed to deprovision the RADIUS Server from this User.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/users/{UserID}/radiusservers \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String userId = "userId_example"; // String | ObjectID of the User.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
try {
    List<GraphObjectWithPaths> result = apiInstance.graphUserTraverseRadiusServer(userId, limit, xOrgId, skip, filter);
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
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphUserTraverseSystem"></a>
# **graphUserTraverseSystem**
> List&lt;GraphObjectWithPaths&gt; graphUserTraverseSystem(userId, limit, xOrgId, skip, filter)

List the Systems bound to a User

This endpoint will return all Systems bound to a User, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User to the corresponding System; this array represents all grouping and/or associations that would have to be removed to deprovision the System from this User.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/users/{UserID}/systems\\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String userId = "userId_example"; // String | ObjectID of the User.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
try {
    List<GraphObjectWithPaths> result = apiInstance.graphUserTraverseSystem(userId, limit, xOrgId, skip, filter);
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
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="graphUserTraverseSystemGroup"></a>
# **graphUserTraverseSystemGroup**
> List&lt;GraphObjectWithPaths&gt; graphUserTraverseSystemGroup(userId, limit, xOrgId, skip, filter)

List the System Groups bound to a User

This endpoint will return all System Groups bound to a User, either directly or indirectly, essentially traversing the JumpCloud Graph for your Organization.  Each element will contain the type, id, attributes and paths.  The &#x60;attributes&#x60; object is a key/value hash of compiled graph attributes for all paths followed.  The &#x60;paths&#x60; array enumerates each path from this User to the corresponding System Group; this array represents all grouping and/or associations that would have to be removed to deprovision the System Group from this User.  See &#x60;/members&#x60; and &#x60;/associations&#x60; endpoints to manage those collections.  #### Sample Request &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/users/{UserID}/systemgroups\\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27; &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String userId = "userId_example"; // String | ObjectID of the User.
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
try {
    List<GraphObjectWithPaths> result = apiInstance.graphUserTraverseSystemGroup(userId, limit, xOrgId, skip, filter);
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
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]

### Return type

[**List&lt;GraphObjectWithPaths&gt;**](GraphObjectWithPaths.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="policystatusesSystemsList"></a>
# **policystatusesSystemsList**
> List&lt;PolicyResult&gt; policystatusesSystemsList(systemId, fields, filter, limit, skip, sort, xOrgId)

List the policy statuses for a system

This endpoint returns the policy results for a particular system.  ##### Sample Request  &#x60;&#x60;&#x60; curl -X GET https://console.jumpcloud.com/api/v2/systems/{System_ID}/policystatuses \\   -H &#x27;Accept: application/json&#x27; \\   -H &#x27;Content-Type: application/json&#x27; \\   -H &#x27;x-api-key: {API_KEY}&#x27;  &#x60;&#x60;&#x60;

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
ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
x-api-key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//x-api-key.setApiKeyPrefix("Token");

GraphApi apiInstance = new GraphApi();
String systemId = "systemId_example"; // String | ObjectID of the System.
List<String> fields = Arrays.asList("fields_example"); // List<String> | The comma separated fields included in the returned records. If omitted, the default list of fields will be returned. 
List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
Integer skip = 0; // Integer | The offset into the records to return.
List<String> sort = Arrays.asList("sort_example"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
try {
    List<PolicyResult> result = apiInstance.policystatusesSystemsList(systemId, fields, filter, limit, skip, sort, xOrgId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GraphApi#policystatusesSystemsList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **systemId** | **String**| ObjectID of the System. |
 **fields** | [**List&lt;String&gt;**](String.md)| The comma separated fields included in the returned records. If omitted, the default list of fields will be returned.  | [optional]
 **filter** | [**List&lt;String&gt;**](String.md)| A filter to apply to the query.  **Filter structure**: &#x60;&lt;field&gt;:&lt;operator&gt;:&lt;value&gt;&#x60;.  **field** &#x3D; Populate with a valid field from an endpoint response.  **operator** &#x3D;  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** &#x3D; Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** &#x60;GET /api/v2/groups?filter&#x3D;name:eq:Test+Group&#x60; | [optional]
 **limit** | **Integer**| The number of records to return at once. Limited to 100. | [optional] [default to 10]
 **skip** | **Integer**| The offset into the records to return. | [optional] [default to 0] [enum: ]
 **sort** | [**List&lt;String&gt;**](String.md)| The comma separated fields used to sort the collection. Default sort is ascending, prefix with &#x60;-&#x60; to sort descending.  | [optional]
 **xOrgId** | **String**| Organization identifier that can be obtained from console settings. | [optional]

### Return type

[**List&lt;PolicyResult&gt;**](PolicyResult.md)

### Authorization

[x-api-key](../README.md#x-api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

