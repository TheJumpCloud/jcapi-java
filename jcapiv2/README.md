# jcapi-java-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>com.jumpcloud</groupId>
    <artifactId>jcapi-java-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "com.jumpcloud:jcapi-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/jcapi-java-client-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.ActiveDirectoryApi;

import java.io.File;
import java.util.*;

public class ActiveDirectoryApiExample {

    public static void main(String[] args) {
        
        ActiveDirectoryApi apiInstance = new ActiveDirectoryApi();
        String activedirectoryId = "activedirectoryId_example"; // String | 
        String agentId = "agentId_example"; // String | 
        String contentType = "application/json"; // String | 
        String accept = "application/json"; // String | 
        String xOrgId = ""; // String | 
        try {
            apiInstance.activedirectoriesAgentsDelete(activedirectoryId, agentId, contentType, accept, xOrgId);
        } catch (ApiException e) {
            System.err.println("Exception when calling ActiveDirectoryApi#activedirectoriesAgentsDelete");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://console.jumpcloud.com/api/v2*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*ActiveDirectoryApi* | [**activedirectoriesAgentsDelete**](docs/ActiveDirectoryApi.md#activedirectoriesAgentsDelete) | **DELETE** /activedirectories/{activedirectory_id}/agents/{agent_id} | Delete Active Directory Agent
*ActiveDirectoryApi* | [**activedirectoriesAgentsGet**](docs/ActiveDirectoryApi.md#activedirectoriesAgentsGet) | **GET** /activedirectories/{activedirectory_id}/agents/{agent_id} | Get Active Directory Agent
*ActiveDirectoryApi* | [**activedirectoriesAgentsList**](docs/ActiveDirectoryApi.md#activedirectoriesAgentsList) | **GET** /activedirectories/{activedirectory_id}/agents | List Active Directory Agents
*ActiveDirectoryApi* | [**activedirectoriesAgentsPost**](docs/ActiveDirectoryApi.md#activedirectoriesAgentsPost) | **POST** /activedirectories/{activedirectory_id}/agents | Create a new Active Directory Agent
*ActiveDirectoryApi* | [**activedirectoriesDelete**](docs/ActiveDirectoryApi.md#activedirectoriesDelete) | **DELETE** /activedirectories/{id} | Delete an Active Directory
*ActiveDirectoryApi* | [**activedirectoriesGet**](docs/ActiveDirectoryApi.md#activedirectoriesGet) | **GET** /activedirectories/{id} | Get an Active Directory
*ActiveDirectoryApi* | [**activedirectoriesList**](docs/ActiveDirectoryApi.md#activedirectoriesList) | **GET** /activedirectories | List Active Directories
*ActiveDirectoryApi* | [**activedirectoriesPost**](docs/ActiveDirectoryApi.md#activedirectoriesPost) | **POST** /activedirectories | Create a new Active Directory
*ActiveDirectoryApi* | [**graphActiveDirectoryAssociationsList**](docs/ActiveDirectoryApi.md#graphActiveDirectoryAssociationsList) | **GET** /activedirectories/{activedirectory_id}/associations | List the associations of an Active Directory instance
*ActiveDirectoryApi* | [**graphActiveDirectoryAssociationsPost**](docs/ActiveDirectoryApi.md#graphActiveDirectoryAssociationsPost) | **POST** /activedirectories/{activedirectory_id}/associations | Manage the associations of an Active Directory instance
*ActiveDirectoryApi* | [**graphActiveDirectoryTraverseUserGroup**](docs/ActiveDirectoryApi.md#graphActiveDirectoryTraverseUserGroup) | **GET** /activedirectories/{activedirectory_id}/usergroups | List the User Groups bound to an Active Directory instance
*ApplicationsApi* | [**graphApplicationAssociationsList**](docs/ApplicationsApi.md#graphApplicationAssociationsList) | **GET** /applications/{application_id}/associations | List the associations of an Application
*ApplicationsApi* | [**graphApplicationAssociationsPost**](docs/ApplicationsApi.md#graphApplicationAssociationsPost) | **POST** /applications/{application_id}/associations | Manage the associations of an Application
*ApplicationsApi* | [**graphApplicationTraverseUser**](docs/ApplicationsApi.md#graphApplicationTraverseUser) | **GET** /applications/{application_id}/users | List the Users bound to an Application
*ApplicationsApi* | [**graphApplicationTraverseUserGroup**](docs/ApplicationsApi.md#graphApplicationTraverseUserGroup) | **GET** /applications/{application_id}/usergroups | List the User Groups bound to an Application
*BulkJobRequestsApi* | [**bulkUsersCreate**](docs/BulkJobRequestsApi.md#bulkUsersCreate) | **POST** /bulk/users | Bulk Users Create
*BulkJobRequestsApi* | [**bulkUsersCreateResults**](docs/BulkJobRequestsApi.md#bulkUsersCreateResults) | **GET** /bulk/users/{job_id}/results | List Bulk Users Results
*BulkJobRequestsApi* | [**bulkUsersUpdate**](docs/BulkJobRequestsApi.md#bulkUsersUpdate) | **PATCH** /bulk/users | Bulk Users Update
*BulkJobRequestsApi* | [**jobsGet**](docs/BulkJobRequestsApi.md#jobsGet) | **GET** /jobs/{id} | Get Job (incomplete)
*BulkJobRequestsApi* | [**jobsResults**](docs/BulkJobRequestsApi.md#jobsResults) | **GET** /jobs/{id}/results | List Job Results
*CommandsApi* | [**graphCommandAssociationsList**](docs/CommandsApi.md#graphCommandAssociationsList) | **GET** /commands/{command_id}/associations | List the associations of a Command
*CommandsApi* | [**graphCommandAssociationsPost**](docs/CommandsApi.md#graphCommandAssociationsPost) | **POST** /commands/{command_id}/associations | Manage the associations of a Command
*CommandsApi* | [**graphCommandTraverseSystem**](docs/CommandsApi.md#graphCommandTraverseSystem) | **GET** /commands/{command_id}/systems | List the Systems bound to a Command
*CommandsApi* | [**graphCommandTraverseSystemGroup**](docs/CommandsApi.md#graphCommandTraverseSystemGroup) | **GET** /commands/{command_id}/systemgroups | List the System Groups bound to a Command
*DirectoriesApi* | [**directoriesList**](docs/DirectoriesApi.md#directoriesList) | **GET** /directories | List All Directories
*DuoApi* | [**duoAccountGet**](docs/DuoApi.md#duoAccountGet) | **GET** /duo/accounts/{id} | Get a Duo Acount
*DuoApi* | [**duoAccountList**](docs/DuoApi.md#duoAccountList) | **GET** /duo/accounts | List Duo Acounts
*DuoApi* | [**duoAccountPost**](docs/DuoApi.md#duoAccountPost) | **POST** /duo/accounts | Create Duo Account
*DuoApi* | [**duoApplicationGet**](docs/DuoApi.md#duoApplicationGet) | **GET** /duo/accounts/{account_id}/applications/{application_id} | Get a Duo application
*DuoApi* | [**duoApplicationList**](docs/DuoApi.md#duoApplicationList) | **GET** /duo/accounts/{account_id}/applications | List Duo Applications
*DuoApi* | [**duoApplicationPost**](docs/DuoApi.md#duoApplicationPost) | **POST** /duo/accounts/{account_id}/applications | Create Duo Application
*FdeApi* | [**systemsGetFDEKey**](docs/FdeApi.md#systemsGetFDEKey) | **GET** /systems/{system_id}/fdekey | Get System FDE Key
*GSuiteApi* | [**graphGSuiteAssociationsList**](docs/GSuiteApi.md#graphGSuiteAssociationsList) | **GET** /gsuites/{gsuite_id}/associations | List the associations of a G Suite instance
*GSuiteApi* | [**graphGSuiteAssociationsPost**](docs/GSuiteApi.md#graphGSuiteAssociationsPost) | **POST** /gsuites/{gsuite_id}/associations | Manage the associations of a G Suite instance
*GSuiteApi* | [**graphGSuiteTraverseUser**](docs/GSuiteApi.md#graphGSuiteTraverseUser) | **GET** /gsuites/{gsuite_id}/users | List the Users bound to a G Suite instance
*GSuiteApi* | [**graphGSuiteTraverseUserGroup**](docs/GSuiteApi.md#graphGSuiteTraverseUserGroup) | **GET** /gsuites/{gsuite_id}/usergroups | List the User Groups bound to a G Suite instance
*GSuiteApi* | [**gsuitesGet**](docs/GSuiteApi.md#gsuitesGet) | **GET** /gsuites/{id} | Get G Suite
*GSuiteApi* | [**gsuitesPatch**](docs/GSuiteApi.md#gsuitesPatch) | **PATCH** /gsuites/{id} | Update existing G Suite
*GSuiteApi* | [**translationRulesGSuiteDelete**](docs/GSuiteApi.md#translationRulesGSuiteDelete) | **DELETE** /gsuites/{gsuite_id}/translationrules/{id} | Deletes a G Suite translation rule
*GSuiteApi* | [**translationRulesGSuiteGet**](docs/GSuiteApi.md#translationRulesGSuiteGet) | **GET** /gsuites/{gsuite_id}/translationrules/{id} | Gets a specific G Suite translation rule
*GSuiteApi* | [**translationRulesGSuiteList**](docs/GSuiteApi.md#translationRulesGSuiteList) | **GET** /gsuites/{gsuite_id}/translationrules | List all the G Suite Translation Rules
*GSuiteApi* | [**translationRulesGSuitePost**](docs/GSuiteApi.md#translationRulesGSuitePost) | **POST** /gsuites/{gsuite_id}/translationrules | Create a new G Suite Translation Rule
*GraphApi* | [**graphActiveDirectoryAssociationsList**](docs/GraphApi.md#graphActiveDirectoryAssociationsList) | **GET** /activedirectories/{activedirectory_id}/associations | List the associations of an Active Directory instance
*GraphApi* | [**graphActiveDirectoryAssociationsPost**](docs/GraphApi.md#graphActiveDirectoryAssociationsPost) | **POST** /activedirectories/{activedirectory_id}/associations | Manage the associations of an Active Directory instance
*GraphApi* | [**graphActiveDirectoryTraverseUserGroup**](docs/GraphApi.md#graphActiveDirectoryTraverseUserGroup) | **GET** /activedirectories/{activedirectory_id}/usergroups | List the User Groups bound to an Active Directory instance
*GraphApi* | [**graphApplicationAssociationsList**](docs/GraphApi.md#graphApplicationAssociationsList) | **GET** /applications/{application_id}/associations | List the associations of an Application
*GraphApi* | [**graphApplicationAssociationsPost**](docs/GraphApi.md#graphApplicationAssociationsPost) | **POST** /applications/{application_id}/associations | Manage the associations of an Application
*GraphApi* | [**graphApplicationTraverseUser**](docs/GraphApi.md#graphApplicationTraverseUser) | **GET** /applications/{application_id}/users | List the Users bound to an Application
*GraphApi* | [**graphApplicationTraverseUserGroup**](docs/GraphApi.md#graphApplicationTraverseUserGroup) | **GET** /applications/{application_id}/usergroups | List the User Groups bound to an Application
*GraphApi* | [**graphCommandAssociationsList**](docs/GraphApi.md#graphCommandAssociationsList) | **GET** /commands/{command_id}/associations | List the associations of a Command
*GraphApi* | [**graphCommandAssociationsPost**](docs/GraphApi.md#graphCommandAssociationsPost) | **POST** /commands/{command_id}/associations | Manage the associations of a Command
*GraphApi* | [**graphCommandTraverseSystem**](docs/GraphApi.md#graphCommandTraverseSystem) | **GET** /commands/{command_id}/systems | List the Systems bound to a Command
*GraphApi* | [**graphCommandTraverseSystemGroup**](docs/GraphApi.md#graphCommandTraverseSystemGroup) | **GET** /commands/{command_id}/systemgroups | List the System Groups bound to a Command
*GraphApi* | [**graphGSuiteAssociationsList**](docs/GraphApi.md#graphGSuiteAssociationsList) | **GET** /gsuites/{gsuite_id}/associations | List the associations of a G Suite instance
*GraphApi* | [**graphGSuiteAssociationsPost**](docs/GraphApi.md#graphGSuiteAssociationsPost) | **POST** /gsuites/{gsuite_id}/associations | Manage the associations of a G Suite instance
*GraphApi* | [**graphGSuiteTraverseUser**](docs/GraphApi.md#graphGSuiteTraverseUser) | **GET** /gsuites/{gsuite_id}/users | List the Users bound to a G Suite instance
*GraphApi* | [**graphGSuiteTraverseUserGroup**](docs/GraphApi.md#graphGSuiteTraverseUserGroup) | **GET** /gsuites/{gsuite_id}/usergroups | List the User Groups bound to a G Suite instance
*GraphApi* | [**graphLdapServerAssociationsList**](docs/GraphApi.md#graphLdapServerAssociationsList) | **GET** /ldapservers/{ldapserver_id}/associations | List the associations of a LDAP Server
*GraphApi* | [**graphLdapServerAssociationsPost**](docs/GraphApi.md#graphLdapServerAssociationsPost) | **POST** /ldapservers/{ldapserver_id}/associations | Manage the associations of a LDAP Server
*GraphApi* | [**graphLdapServerTraverseUser**](docs/GraphApi.md#graphLdapServerTraverseUser) | **GET** /ldapservers/{ldapserver_id}/users | List the Users bound to a LDAP Server
*GraphApi* | [**graphLdapServerTraverseUserGroup**](docs/GraphApi.md#graphLdapServerTraverseUserGroup) | **GET** /ldapservers/{ldapserver_id}/usergroups | List the User Groups bound to a LDAP Server
*GraphApi* | [**graphOffice365AssociationsList**](docs/GraphApi.md#graphOffice365AssociationsList) | **GET** /office365s/{office365_id}/associations | List the associations of an Office 365 instance
*GraphApi* | [**graphOffice365AssociationsPost**](docs/GraphApi.md#graphOffice365AssociationsPost) | **POST** /office365s/{office365_id}/associations | Manage the associations of an Office 365 instance
*GraphApi* | [**graphOffice365TraverseUser**](docs/GraphApi.md#graphOffice365TraverseUser) | **GET** /office365s/{office365_id}/users | List the Users bound to an Office 365 instance
*GraphApi* | [**graphOffice365TraverseUserGroup**](docs/GraphApi.md#graphOffice365TraverseUserGroup) | **GET** /office365s/{office365_id}/usergroups | List the User Groups bound to an Office 365 instance
*GraphApi* | [**graphPolicyAssociationsList**](docs/GraphApi.md#graphPolicyAssociationsList) | **GET** /policies/{policy_id}/associations | List the associations of a Policy
*GraphApi* | [**graphPolicyAssociationsPost**](docs/GraphApi.md#graphPolicyAssociationsPost) | **POST** /policies/{policy_id}/associations | Manage the associations of a Policy
*GraphApi* | [**graphPolicyTraverseSystem**](docs/GraphApi.md#graphPolicyTraverseSystem) | **GET** /policies/{policy_id}/systems | List the Systems bound to a Policy
*GraphApi* | [**graphPolicyTraverseSystemGroup**](docs/GraphApi.md#graphPolicyTraverseSystemGroup) | **GET** /policies/{policy_id}/systemgroups | List the System Groups bound to a Policy
*GraphApi* | [**graphRadiusServerAssociationsList**](docs/GraphApi.md#graphRadiusServerAssociationsList) | **GET** /radiusservers/{radiusserver_id}/associations | List the associations of a RADIUS  Server
*GraphApi* | [**graphRadiusServerAssociationsPost**](docs/GraphApi.md#graphRadiusServerAssociationsPost) | **POST** /radiusservers/{radiusserver_id}/associations | Manage the associations of a RADIUS Server
*GraphApi* | [**graphRadiusServerTraverseUser**](docs/GraphApi.md#graphRadiusServerTraverseUser) | **GET** /radiusservers/{radiusserver_id}/users | List the Users bound to a RADIUS  Server
*GraphApi* | [**graphRadiusServerTraverseUserGroup**](docs/GraphApi.md#graphRadiusServerTraverseUserGroup) | **GET** /radiusservers/{radiusserver_id}/usergroups | List the User Groups bound to a RADIUS  Server
*GraphApi* | [**graphSystemAssociationsList**](docs/GraphApi.md#graphSystemAssociationsList) | **GET** /systems/{system_id}/associations | List the associations of a System
*GraphApi* | [**graphSystemAssociationsPost**](docs/GraphApi.md#graphSystemAssociationsPost) | **POST** /systems/{system_id}/associations | Manage associations of a System
*GraphApi* | [**graphSystemGroupAssociationsList**](docs/GraphApi.md#graphSystemGroupAssociationsList) | **GET** /systemgroups/{group_id}/associations | List the associations of a System Group
*GraphApi* | [**graphSystemGroupAssociationsPost**](docs/GraphApi.md#graphSystemGroupAssociationsPost) | **POST** /systemgroups/{group_id}/associations | Manage the associations of a System Group
*GraphApi* | [**graphSystemGroupMemberOf**](docs/GraphApi.md#graphSystemGroupMemberOf) | **GET** /systemgroups/{group_id}/memberof | List the System Group&#39;s parents
*GraphApi* | [**graphSystemGroupMembersList**](docs/GraphApi.md#graphSystemGroupMembersList) | **GET** /systemgroups/{group_id}/members | List the members of a System Group
*GraphApi* | [**graphSystemGroupMembersPost**](docs/GraphApi.md#graphSystemGroupMembersPost) | **POST** /systemgroups/{group_id}/members | Manage the members of a System Group
*GraphApi* | [**graphSystemGroupMembership**](docs/GraphApi.md#graphSystemGroupMembership) | **GET** /systemgroups/{group_id}/membership | List the System Group&#39;s membership
*GraphApi* | [**graphSystemGroupTraverseCommand**](docs/GraphApi.md#graphSystemGroupTraverseCommand) | **GET** /systemgroups/{group_id}/commands | List the Commands bound to a System Group
*GraphApi* | [**graphSystemGroupTraversePolicy**](docs/GraphApi.md#graphSystemGroupTraversePolicy) | **GET** /systemgroups/{group_id}/policies | List the Policies bound to a System Group
*GraphApi* | [**graphSystemGroupTraverseUser**](docs/GraphApi.md#graphSystemGroupTraverseUser) | **GET** /systemgroups/{group_id}/users | List the Users bound to a System Group
*GraphApi* | [**graphSystemGroupTraverseUserGroup**](docs/GraphApi.md#graphSystemGroupTraverseUserGroup) | **GET** /systemgroups/{group_id}/usergroups | List the User Groups bound to a System Group
*GraphApi* | [**graphSystemMemberOf**](docs/GraphApi.md#graphSystemMemberOf) | **GET** /systems/{system_id}/memberof | List the parent Groups of a System
*GraphApi* | [**graphSystemTraverseCommand**](docs/GraphApi.md#graphSystemTraverseCommand) | **GET** /systems/{system_id}/commands | List the Commands bound to a System
*GraphApi* | [**graphSystemTraversePolicy**](docs/GraphApi.md#graphSystemTraversePolicy) | **GET** /systems/{system_id}/policies | List the Policies bound to a System
*GraphApi* | [**graphSystemTraverseUser**](docs/GraphApi.md#graphSystemTraverseUser) | **GET** /systems/{system_id}/users | List the Users bound to a System
*GraphApi* | [**graphSystemTraverseUserGroup**](docs/GraphApi.md#graphSystemTraverseUserGroup) | **GET** /systems/{system_id}/usergroups | List the User Groups bound to a System
*GraphApi* | [**graphUserAssociationsList**](docs/GraphApi.md#graphUserAssociationsList) | **GET** /users/{user_id}/associations | List the associations of a User
*GraphApi* | [**graphUserAssociationsPost**](docs/GraphApi.md#graphUserAssociationsPost) | **POST** /users/{user_id}/associations | Manage the associations of a User
*GraphApi* | [**graphUserGroupAssociationsList**](docs/GraphApi.md#graphUserGroupAssociationsList) | **GET** /usergroups/{group_id}/associations | List the associations of a User Group.
*GraphApi* | [**graphUserGroupAssociationsPost**](docs/GraphApi.md#graphUserGroupAssociationsPost) | **POST** /usergroups/{group_id}/associations | Manage the associations of a User Group
*GraphApi* | [**graphUserGroupMemberOf**](docs/GraphApi.md#graphUserGroupMemberOf) | **GET** /usergroups/{group_id}/memberof | List the User Group&#39;s parents
*GraphApi* | [**graphUserGroupMembersList**](docs/GraphApi.md#graphUserGroupMembersList) | **GET** /usergroups/{group_id}/members | List the members of a User Group
*GraphApi* | [**graphUserGroupMembersPost**](docs/GraphApi.md#graphUserGroupMembersPost) | **POST** /usergroups/{group_id}/members | Manage the members of a User Group
*GraphApi* | [**graphUserGroupMembership**](docs/GraphApi.md#graphUserGroupMembership) | **GET** /usergroups/{group_id}/membership | List the User Group&#39;s membership
*GraphApi* | [**graphUserGroupTraverseActiveDirectory**](docs/GraphApi.md#graphUserGroupTraverseActiveDirectory) | **GET** /usergroups/{group_id}/activedirectories | List the Active Directories bound to a User Group
*GraphApi* | [**graphUserGroupTraverseApplication**](docs/GraphApi.md#graphUserGroupTraverseApplication) | **GET** /usergroups/{group_id}/applications | List the Applications bound to a User Group
*GraphApi* | [**graphUserGroupTraverseDirectory**](docs/GraphApi.md#graphUserGroupTraverseDirectory) | **GET** /usergroups/{group_id}/directories | List the Directories bound to a User Group
*GraphApi* | [**graphUserGroupTraverseGSuite**](docs/GraphApi.md#graphUserGroupTraverseGSuite) | **GET** /usergroups/{group_id}/gsuites | List the G Suite instances bound to a User Group
*GraphApi* | [**graphUserGroupTraverseLdapServer**](docs/GraphApi.md#graphUserGroupTraverseLdapServer) | **GET** /usergroups/{group_id}/ldapservers | List the LDAP Servers bound to a User Group
*GraphApi* | [**graphUserGroupTraverseOffice365**](docs/GraphApi.md#graphUserGroupTraverseOffice365) | **GET** /usergroups/{group_id}/office365s | List the Office 365 instances bound to a User Group
*GraphApi* | [**graphUserGroupTraverseRadiusServer**](docs/GraphApi.md#graphUserGroupTraverseRadiusServer) | **GET** /usergroups/{group_id}/radiusservers | List the RADIUS Servers bound to a User Group
*GraphApi* | [**graphUserGroupTraverseSystem**](docs/GraphApi.md#graphUserGroupTraverseSystem) | **GET** /usergroups/{group_id}/systems | List the Systems bound to a User Group
*GraphApi* | [**graphUserGroupTraverseSystemGroup**](docs/GraphApi.md#graphUserGroupTraverseSystemGroup) | **GET** /usergroups/{group_id}/systemgroups | List the System Groups bound to User Groups
*GraphApi* | [**graphUserMemberOf**](docs/GraphApi.md#graphUserMemberOf) | **GET** /users/{user_id}/memberof | List the parent Groups of a User
*GraphApi* | [**graphUserTraverseApplication**](docs/GraphApi.md#graphUserTraverseApplication) | **GET** /users/{user_id}/applications | List the Applications bound to a User
*GraphApi* | [**graphUserTraverseDirectory**](docs/GraphApi.md#graphUserTraverseDirectory) | **GET** /users/{user_id}/directories | List the Directories bound to a User
*GraphApi* | [**graphUserTraverseGSuite**](docs/GraphApi.md#graphUserTraverseGSuite) | **GET** /users/{user_id}/gsuites | List the G Suite instances bound to a User
*GraphApi* | [**graphUserTraverseLdapServer**](docs/GraphApi.md#graphUserTraverseLdapServer) | **GET** /users/{user_id}/ldapservers | List the LDAP servers bound to a User
*GraphApi* | [**graphUserTraverseOffice365**](docs/GraphApi.md#graphUserTraverseOffice365) | **GET** /users/{user_id}/office365s | List the Office 365 instances bound to a User
*GraphApi* | [**graphUserTraverseRadiusServer**](docs/GraphApi.md#graphUserTraverseRadiusServer) | **GET** /users/{user_id}/radiusservers | List the RADIUS Servers bound to a User
*GraphApi* | [**graphUserTraverseSystem**](docs/GraphApi.md#graphUserTraverseSystem) | **GET** /users/{user_id}/systems | List the Systems bound to a User
*GraphApi* | [**graphUserTraverseSystemGroup**](docs/GraphApi.md#graphUserTraverseSystemGroup) | **GET** /users/{user_id}/systemgroups | List the System Groups bound to a User
*GraphApi* | [**policystatusesList**](docs/GraphApi.md#policystatusesList) | **GET** /systems/{system_id}/policystatuses | List the policy statuses for a system
*GroupsApi* | [**groupsList**](docs/GroupsApi.md#groupsList) | **GET** /groups | List All Groups
*LdapServersApi* | [**graphLdapServerAssociationsList**](docs/LdapServersApi.md#graphLdapServerAssociationsList) | **GET** /ldapservers/{ldapserver_id}/associations | List the associations of a LDAP Server
*LdapServersApi* | [**graphLdapServerAssociationsPost**](docs/LdapServersApi.md#graphLdapServerAssociationsPost) | **POST** /ldapservers/{ldapserver_id}/associations | Manage the associations of a LDAP Server
*LdapServersApi* | [**graphLdapServerTraverseUser**](docs/LdapServersApi.md#graphLdapServerTraverseUser) | **GET** /ldapservers/{ldapserver_id}/users | List the Users bound to a LDAP Server
*LdapServersApi* | [**graphLdapServerTraverseUserGroup**](docs/LdapServersApi.md#graphLdapServerTraverseUserGroup) | **GET** /ldapservers/{ldapserver_id}/usergroups | List the User Groups bound to a LDAP Server
*LdapServersApi* | [**ldapserversGet**](docs/LdapServersApi.md#ldapserversGet) | **GET** /ldapservers/{id} | Get LDAP Server
*LdapServersApi* | [**ldapserversList**](docs/LdapServersApi.md#ldapserversList) | **GET** /ldapservers | List LDAP Servers
*LdapServersApi* | [**ldapserversPatch**](docs/LdapServersApi.md#ldapserversPatch) | **PATCH** /ldapservers/{id} | Update existing LDAP server
*Office365Api* | [**graphOffice365AssociationsList**](docs/Office365Api.md#graphOffice365AssociationsList) | **GET** /office365s/{office365_id}/associations | List the associations of an Office 365 instance
*Office365Api* | [**graphOffice365AssociationsPost**](docs/Office365Api.md#graphOffice365AssociationsPost) | **POST** /office365s/{office365_id}/associations | Manage the associations of an Office 365 instance
*Office365Api* | [**graphOffice365TraverseUser**](docs/Office365Api.md#graphOffice365TraverseUser) | **GET** /office365s/{office365_id}/users | List the Users bound to an Office 365 instance
*Office365Api* | [**graphOffice365TraverseUserGroup**](docs/Office365Api.md#graphOffice365TraverseUserGroup) | **GET** /office365s/{office365_id}/usergroups | List the User Groups bound to an Office 365 instance
*Office365Api* | [**translationRulesOffice365Delete**](docs/Office365Api.md#translationRulesOffice365Delete) | **DELETE** /office365s/{office365_id}/translationrules/{id} | Deletes a Office 365 translation rule
*Office365Api* | [**translationRulesOffice365Get**](docs/Office365Api.md#translationRulesOffice365Get) | **GET** /office365s/{office365_id}/translationrules/{id} | Gets a specific Office 365 translation rule
*Office365Api* | [**translationRulesOffice365List**](docs/Office365Api.md#translationRulesOffice365List) | **GET** /office365s/{office365_id}/translationrules | List all the Office 365 Translation Rules
*Office365Api* | [**translationRulesOffice365Post**](docs/Office365Api.md#translationRulesOffice365Post) | **POST** /office365s/{office365_id}/translationrules | Create a new Office 365 Translation Rule
*OrganizationsApi* | [**orgCryptoGet**](docs/OrganizationsApi.md#orgCryptoGet) | **GET** /organizations/{id}/crypto | Get Crypto Settings
*OrganizationsApi* | [**orgCryptoPut**](docs/OrganizationsApi.md#orgCryptoPut) | **PUT** /organizations/{id}/crypto | Edit Crypto Settings
*PoliciesApi* | [**graphPolicyAssociationsList**](docs/PoliciesApi.md#graphPolicyAssociationsList) | **GET** /policies/{policy_id}/associations | List the associations of a Policy
*PoliciesApi* | [**graphPolicyAssociationsPost**](docs/PoliciesApi.md#graphPolicyAssociationsPost) | **POST** /policies/{policy_id}/associations | Manage the associations of a Policy
*PoliciesApi* | [**graphPolicyTraverseSystem**](docs/PoliciesApi.md#graphPolicyTraverseSystem) | **GET** /policies/{policy_id}/systems | List the Systems bound to a Policy
*PoliciesApi* | [**graphPolicyTraverseSystemGroup**](docs/PoliciesApi.md#graphPolicyTraverseSystemGroup) | **GET** /policies/{policy_id}/systemgroups | List the System Groups bound to a Policy
*PoliciesApi* | [**policiesDelete**](docs/PoliciesApi.md#policiesDelete) | **DELETE** /policies/{id} | Deletes a Policy
*PoliciesApi* | [**policiesGet**](docs/PoliciesApi.md#policiesGet) | **GET** /policies/{id} | Gets a specific Policy.
*PoliciesApi* | [**policiesList**](docs/PoliciesApi.md#policiesList) | **GET** /policies | Lists all the Policies
*PoliciesApi* | [**policiesPost**](docs/PoliciesApi.md#policiesPost) | **POST** /policies | Create a new Policy
*PoliciesApi* | [**policiesPut**](docs/PoliciesApi.md#policiesPut) | **PUT** /policies/{id} | Update an existing Policy
*PoliciesApi* | [**policyresultsGet**](docs/PoliciesApi.md#policyresultsGet) | **GET** /policyresults/{id} | Get a specific Policy Result.
*PoliciesApi* | [**policyresultsList**](docs/PoliciesApi.md#policyresultsList) | **GET** /policies/{policy_id}/policyresults | Lists all the policy results of a policy.
*PoliciesApi* | [**policyresultsList_0**](docs/PoliciesApi.md#policyresultsList_0) | **GET** /policyresults | Lists all the policy results for an organization.
*PoliciesApi* | [**policystatusesList**](docs/PoliciesApi.md#policystatusesList) | **GET** /policies/{policy_id}/policystatuses | Lists the latest policy results of a policy.
*PoliciesApi* | [**policystatusesList_0**](docs/PoliciesApi.md#policystatusesList_0) | **GET** /systems/{system_id}/policystatuses | List the policy statuses for a system
*PoliciesApi* | [**policytemplatesGet**](docs/PoliciesApi.md#policytemplatesGet) | **GET** /policytemplates/{id} | Get a specific Policy Template
*PoliciesApi* | [**policytemplatesList**](docs/PoliciesApi.md#policytemplatesList) | **GET** /policytemplates | Lists all of the Policy Templates
*PolicytemplatesApi* | [**policytemplatesGet**](docs/PolicytemplatesApi.md#policytemplatesGet) | **GET** /policytemplates/{id} | Get a specific Policy Template
*PolicytemplatesApi* | [**policytemplatesList**](docs/PolicytemplatesApi.md#policytemplatesList) | **GET** /policytemplates | Lists all of the Policy Templates
*ProvidersApi* | [**providersListAdministrators**](docs/ProvidersApi.md#providersListAdministrators) | **GET** /providers/{provider_id}/administrators | List Provider Administrators
*ProvidersApi* | [**providersPostAdmins**](docs/ProvidersApi.md#providersPostAdmins) | **POST** /providers/{provider_id}/administrators | Create a new Provider Administrator
*RadiusServersApi* | [**graphRadiusServerAssociationsList**](docs/RadiusServersApi.md#graphRadiusServerAssociationsList) | **GET** /radiusservers/{radiusserver_id}/associations | List the associations of a RADIUS  Server
*RadiusServersApi* | [**graphRadiusServerAssociationsPost**](docs/RadiusServersApi.md#graphRadiusServerAssociationsPost) | **POST** /radiusservers/{radiusserver_id}/associations | Manage the associations of a RADIUS Server
*RadiusServersApi* | [**graphRadiusServerTraverseUser**](docs/RadiusServersApi.md#graphRadiusServerTraverseUser) | **GET** /radiusservers/{radiusserver_id}/users | List the Users bound to a RADIUS  Server
*RadiusServersApi* | [**graphRadiusServerTraverseUserGroup**](docs/RadiusServersApi.md#graphRadiusServerTraverseUserGroup) | **GET** /radiusservers/{radiusserver_id}/usergroups | List the User Groups bound to a RADIUS  Server
*SambaDomainsApi* | [**ldapserversSambaDomainsDelete**](docs/SambaDomainsApi.md#ldapserversSambaDomainsDelete) | **DELETE** /ldapservers/{ldapserver_id}/sambadomains/{id} | Delete Samba Domain
*SambaDomainsApi* | [**ldapserversSambaDomainsGet**](docs/SambaDomainsApi.md#ldapserversSambaDomainsGet) | **GET** /ldapservers/{ldapserver_id}/sambadomains/{id} | Get Samba Domain
*SambaDomainsApi* | [**ldapserversSambaDomainsList**](docs/SambaDomainsApi.md#ldapserversSambaDomainsList) | **GET** /ldapservers/{ldapserver_id}/sambadomains | List Samba Domains
*SambaDomainsApi* | [**ldapserversSambaDomainsPost**](docs/SambaDomainsApi.md#ldapserversSambaDomainsPost) | **POST** /ldapservers/{ldapserver_id}/sambadomains | Create Samba Domain
*SambaDomainsApi* | [**ldapserversSambaDomainsPut**](docs/SambaDomainsApi.md#ldapserversSambaDomainsPut) | **PUT** /ldapservers/{ldapserver_id}/sambadomains/{id} | Update Samba Domain
*SystemGroupAssociationsApi* | [**graphSystemGroupAssociationsList**](docs/SystemGroupAssociationsApi.md#graphSystemGroupAssociationsList) | **GET** /systemgroups/{group_id}/associations | List the associations of a System Group
*SystemGroupAssociationsApi* | [**graphSystemGroupAssociationsPost**](docs/SystemGroupAssociationsApi.md#graphSystemGroupAssociationsPost) | **POST** /systemgroups/{group_id}/associations | Manage the associations of a System Group
*SystemGroupAssociationsApi* | [**graphSystemGroupTraverseCommand**](docs/SystemGroupAssociationsApi.md#graphSystemGroupTraverseCommand) | **GET** /systemgroups/{group_id}/commands | List the Commands bound to a System Group
*SystemGroupAssociationsApi* | [**graphSystemGroupTraversePolicy**](docs/SystemGroupAssociationsApi.md#graphSystemGroupTraversePolicy) | **GET** /systemgroups/{group_id}/policies | List the Policies bound to a System Group
*SystemGroupAssociationsApi* | [**graphSystemGroupTraverseUser**](docs/SystemGroupAssociationsApi.md#graphSystemGroupTraverseUser) | **GET** /systemgroups/{group_id}/users | List the Users bound to a System Group
*SystemGroupAssociationsApi* | [**graphSystemGroupTraverseUserGroup**](docs/SystemGroupAssociationsApi.md#graphSystemGroupTraverseUserGroup) | **GET** /systemgroups/{group_id}/usergroups | List the User Groups bound to a System Group
*SystemGroupMembersMembershipApi* | [**graphSystemGroupMemberOf**](docs/SystemGroupMembersMembershipApi.md#graphSystemGroupMemberOf) | **GET** /systemgroups/{group_id}/memberof | List the System Group&#39;s parents
*SystemGroupMembersMembershipApi* | [**graphSystemGroupMembersList**](docs/SystemGroupMembersMembershipApi.md#graphSystemGroupMembersList) | **GET** /systemgroups/{group_id}/members | List the members of a System Group
*SystemGroupMembersMembershipApi* | [**graphSystemGroupMembersPost**](docs/SystemGroupMembersMembershipApi.md#graphSystemGroupMembersPost) | **POST** /systemgroups/{group_id}/members | Manage the members of a System Group
*SystemGroupMembersMembershipApi* | [**graphSystemGroupMembership**](docs/SystemGroupMembersMembershipApi.md#graphSystemGroupMembership) | **GET** /systemgroups/{group_id}/membership | List the System Group&#39;s membership
*SystemGroupsApi* | [**graphSystemGroupAssociationsList**](docs/SystemGroupsApi.md#graphSystemGroupAssociationsList) | **GET** /systemgroups/{group_id}/associations | List the associations of a System Group
*SystemGroupsApi* | [**graphSystemGroupAssociationsPost**](docs/SystemGroupsApi.md#graphSystemGroupAssociationsPost) | **POST** /systemgroups/{group_id}/associations | Manage the associations of a System Group
*SystemGroupsApi* | [**graphSystemGroupMemberOf**](docs/SystemGroupsApi.md#graphSystemGroupMemberOf) | **GET** /systemgroups/{group_id}/memberof | List the System Group&#39;s parents
*SystemGroupsApi* | [**graphSystemGroupMembersList**](docs/SystemGroupsApi.md#graphSystemGroupMembersList) | **GET** /systemgroups/{group_id}/members | List the members of a System Group
*SystemGroupsApi* | [**graphSystemGroupMembersPost**](docs/SystemGroupsApi.md#graphSystemGroupMembersPost) | **POST** /systemgroups/{group_id}/members | Manage the members of a System Group
*SystemGroupsApi* | [**graphSystemGroupMembership**](docs/SystemGroupsApi.md#graphSystemGroupMembership) | **GET** /systemgroups/{group_id}/membership | List the System Group&#39;s membership
*SystemGroupsApi* | [**graphSystemGroupTraversePolicy**](docs/SystemGroupsApi.md#graphSystemGroupTraversePolicy) | **GET** /systemgroups/{group_id}/policies | List the Policies bound to a System Group
*SystemGroupsApi* | [**graphSystemGroupTraverseUser**](docs/SystemGroupsApi.md#graphSystemGroupTraverseUser) | **GET** /systemgroups/{group_id}/users | List the Users bound to a System Group
*SystemGroupsApi* | [**graphSystemGroupTraverseUserGroup**](docs/SystemGroupsApi.md#graphSystemGroupTraverseUserGroup) | **GET** /systemgroups/{group_id}/usergroups | List the User Groups bound to a System Group
*SystemGroupsApi* | [**groupsSystemDelete**](docs/SystemGroupsApi.md#groupsSystemDelete) | **DELETE** /systemgroups/{id} | Delete a System Group
*SystemGroupsApi* | [**groupsSystemGet**](docs/SystemGroupsApi.md#groupsSystemGet) | **GET** /systemgroups/{id} | View an individual System Group details
*SystemGroupsApi* | [**groupsSystemList**](docs/SystemGroupsApi.md#groupsSystemList) | **GET** /systemgroups | List all System Groups
*SystemGroupsApi* | [**groupsSystemPatch**](docs/SystemGroupsApi.md#groupsSystemPatch) | **PATCH** /systemgroups/{id} | Partial update a System Group
*SystemGroupsApi* | [**groupsSystemPost**](docs/SystemGroupsApi.md#groupsSystemPost) | **POST** /systemgroups | Create a new System Group
*SystemGroupsApi* | [**groupsSystemPut**](docs/SystemGroupsApi.md#groupsSystemPut) | **PUT** /systemgroups/{id} | Update a System Group
*SystemInsightsApi* | [**systeminsightsListApps**](docs/SystemInsightsApi.md#systeminsightsListApps) | **GET** /systeminsights/apps | List System Insights Apps
*SystemInsightsApi* | [**systeminsightsListApps_0**](docs/SystemInsightsApi.md#systeminsightsListApps_0) | **GET** /systeminsights/{system_id}/apps | List System Insights System Apps
*SystemInsightsApi* | [**systeminsightsListBitlockerInfo**](docs/SystemInsightsApi.md#systeminsightsListBitlockerInfo) | **GET** /systeminsights/bitlocker_info | List System Insights Bitlocker Info
*SystemInsightsApi* | [**systeminsightsListBitlockerInfo_0**](docs/SystemInsightsApi.md#systeminsightsListBitlockerInfo_0) | **GET** /systeminsights/{system_id}/bitlocker_info | List System Insights System Bitlocker Info
*SystemInsightsApi* | [**systeminsightsListBrowserPlugins**](docs/SystemInsightsApi.md#systeminsightsListBrowserPlugins) | **GET** /systeminsights/browser_plugins | List System Insights Browser Plugins
*SystemInsightsApi* | [**systeminsightsListBrowserPlugins_0**](docs/SystemInsightsApi.md#systeminsightsListBrowserPlugins_0) | **GET** /systeminsights/{system_id}/browser_plugins | List System Insights System Browser Plugins
*SystemInsightsApi* | [**systeminsightsListChromeExtensions**](docs/SystemInsightsApi.md#systeminsightsListChromeExtensions) | **GET** /systeminsights/chrome_extensions | List System Insights Chrome Extensions
*SystemInsightsApi* | [**systeminsightsListChromeExtensions_0**](docs/SystemInsightsApi.md#systeminsightsListChromeExtensions_0) | **GET** /systeminsights/{system_id}/chrome_extensions | List System Insights System Chrome Extensions
*SystemInsightsApi* | [**systeminsightsListDiskEncryption**](docs/SystemInsightsApi.md#systeminsightsListDiskEncryption) | **GET** /systeminsights/disk_encryption | List System Insights Disk Encryption
*SystemInsightsApi* | [**systeminsightsListDiskEncryption_0**](docs/SystemInsightsApi.md#systeminsightsListDiskEncryption_0) | **GET** /systeminsights/{system_id}/disk_encryption | List System Insights System Disk Encryption
*SystemInsightsApi* | [**systeminsightsListDiskInfo**](docs/SystemInsightsApi.md#systeminsightsListDiskInfo) | **GET** /systeminsights/disk_info | List System Insights Disk Info
*SystemInsightsApi* | [**systeminsightsListDiskInfo_0**](docs/SystemInsightsApi.md#systeminsightsListDiskInfo_0) | **GET** /systeminsights/{system_id}/disk_info | List System Insights System Disk Info
*SystemInsightsApi* | [**systeminsightsListEtcHosts**](docs/SystemInsightsApi.md#systeminsightsListEtcHosts) | **GET** /systeminsights/etc_hosts | List System Insights Etc Hosts
*SystemInsightsApi* | [**systeminsightsListEtcHosts_0**](docs/SystemInsightsApi.md#systeminsightsListEtcHosts_0) | **GET** /systeminsights/{system_id}/etc_hosts | List System Insights System Etc Hosts
*SystemInsightsApi* | [**systeminsightsListFirefoxAddons**](docs/SystemInsightsApi.md#systeminsightsListFirefoxAddons) | **GET** /systeminsights/firefox_addons | List System Insights Firefox Addons
*SystemInsightsApi* | [**systeminsightsListFirefoxAddons_0**](docs/SystemInsightsApi.md#systeminsightsListFirefoxAddons_0) | **GET** /systeminsights/{system_id}/firefox_addons | List System Insights System Firefox Addons
*SystemInsightsApi* | [**systeminsightsListGroups**](docs/SystemInsightsApi.md#systeminsightsListGroups) | **GET** /systeminsights/groups | List System Insights Groups
*SystemInsightsApi* | [**systeminsightsListGroups_0**](docs/SystemInsightsApi.md#systeminsightsListGroups_0) | **GET** /systeminsights/{system_id}/groups | List System Insights System Groups
*SystemInsightsApi* | [**systeminsightsListInterfaceAddresses**](docs/SystemInsightsApi.md#systeminsightsListInterfaceAddresses) | **GET** /systeminsights/interface_addresses | List System Insights Interface Addresses
*SystemInsightsApi* | [**systeminsightsListInterfaceAddresses_0**](docs/SystemInsightsApi.md#systeminsightsListInterfaceAddresses_0) | **GET** /systeminsights/{system_id}/interface_addresses | List System Insights System Interface Addresses
*SystemInsightsApi* | [**systeminsightsListKernelInfo**](docs/SystemInsightsApi.md#systeminsightsListKernelInfo) | **GET** /systeminsights/kernel_info | List System Insights Kernel Info
*SystemInsightsApi* | [**systeminsightsListKernelInfo_0**](docs/SystemInsightsApi.md#systeminsightsListKernelInfo_0) | **GET** /systeminsights/{system_id}/kernel_info | List System Insights System Kernel Info
*SystemInsightsApi* | [**systeminsightsListLogicalDrives**](docs/SystemInsightsApi.md#systeminsightsListLogicalDrives) | **GET** /systeminsights/logical_drives | List System Insights Logical Drives
*SystemInsightsApi* | [**systeminsightsListLogicalDrives_0**](docs/SystemInsightsApi.md#systeminsightsListLogicalDrives_0) | **GET** /systeminsights/{system_id}/logical_drives | List System Insights System Logical Drives
*SystemInsightsApi* | [**systeminsightsListMounts**](docs/SystemInsightsApi.md#systeminsightsListMounts) | **GET** /systeminsights/mounts | List System Insights Mounts
*SystemInsightsApi* | [**systeminsightsListMounts_0**](docs/SystemInsightsApi.md#systeminsightsListMounts_0) | **GET** /systeminsights/{system_id}/mounts | List System Insights System Mounts
*SystemInsightsApi* | [**systeminsightsListOsVersion**](docs/SystemInsightsApi.md#systeminsightsListOsVersion) | **GET** /systeminsights/os_version | List System Insights OS Version
*SystemInsightsApi* | [**systeminsightsListOsVersion_0**](docs/SystemInsightsApi.md#systeminsightsListOsVersion_0) | **GET** /systeminsights/{system_id}/os_version | List System Insights System OS Version
*SystemInsightsApi* | [**systeminsightsListPatches**](docs/SystemInsightsApi.md#systeminsightsListPatches) | **GET** /systeminsights/patches | List System Insights Patches
*SystemInsightsApi* | [**systeminsightsListPatches_0**](docs/SystemInsightsApi.md#systeminsightsListPatches_0) | **GET** /systeminsights/{system_id}/patches | List System Insights System Patches
*SystemInsightsApi* | [**systeminsightsListPrograms**](docs/SystemInsightsApi.md#systeminsightsListPrograms) | **GET** /systeminsights/programs | List System Insights Programs
*SystemInsightsApi* | [**systeminsightsListPrograms_0**](docs/SystemInsightsApi.md#systeminsightsListPrograms_0) | **GET** /systeminsights/{system_id}/programs | List System Insights System Programs
*SystemInsightsApi* | [**systeminsightsListSafariExtensions**](docs/SystemInsightsApi.md#systeminsightsListSafariExtensions) | **GET** /systeminsights/safari_extensions | List System Insights Safari Extensions
*SystemInsightsApi* | [**systeminsightsListSafariExtensions_0**](docs/SystemInsightsApi.md#systeminsightsListSafariExtensions_0) | **GET** /systeminsights/{system_id}/safari_extensions | List System Insights System Safari Extensions
*SystemInsightsApi* | [**systeminsightsListSystemControls**](docs/SystemInsightsApi.md#systeminsightsListSystemControls) | **GET** /systeminsights/system_controls | List System Insights System Control
*SystemInsightsApi* | [**systeminsightsListSystemControls_0**](docs/SystemInsightsApi.md#systeminsightsListSystemControls_0) | **GET** /systeminsights/{system_id}/system_controls | List System Insights System System Controls
*SystemInsightsApi* | [**systeminsightsListSystemInfo**](docs/SystemInsightsApi.md#systeminsightsListSystemInfo) | **GET** /systeminsights/system_info | List System Insights System Info
*SystemInsightsApi* | [**systeminsightsListSystemInfo_0**](docs/SystemInsightsApi.md#systeminsightsListSystemInfo_0) | **GET** /systeminsights/{system_id}/system_info | List System Insights System System Info
*SystemInsightsApi* | [**systeminsightsListUptime**](docs/SystemInsightsApi.md#systeminsightsListUptime) | **GET** /systeminsights/uptime | List System Insights Uptime
*SystemInsightsApi* | [**systeminsightsListUptime_0**](docs/SystemInsightsApi.md#systeminsightsListUptime_0) | **GET** /systeminsights/{system_id}/uptime | List System Insights System Uptime
*SystemInsightsApi* | [**systeminsightsListUsers**](docs/SystemInsightsApi.md#systeminsightsListUsers) | **GET** /systeminsights/users | List System Insights Users
*SystemInsightsApi* | [**systeminsightsListUsers_0**](docs/SystemInsightsApi.md#systeminsightsListUsers_0) | **GET** /systeminsights/{system_id}/users | List System Insights System Users
*SystemsApi* | [**graphSystemAssociationsList**](docs/SystemsApi.md#graphSystemAssociationsList) | **GET** /systems/{system_id}/associations | List the associations of a System
*SystemsApi* | [**graphSystemAssociationsPost**](docs/SystemsApi.md#graphSystemAssociationsPost) | **POST** /systems/{system_id}/associations | Manage associations of a System
*SystemsApi* | [**graphSystemMemberOf**](docs/SystemsApi.md#graphSystemMemberOf) | **GET** /systems/{system_id}/memberof | List the parent Groups of a System
*SystemsApi* | [**graphSystemTraverseCommand**](docs/SystemsApi.md#graphSystemTraverseCommand) | **GET** /systems/{system_id}/commands | List the Commands bound to a System
*SystemsApi* | [**graphSystemTraversePolicy**](docs/SystemsApi.md#graphSystemTraversePolicy) | **GET** /systems/{system_id}/policies | List the Policies bound to a System
*SystemsApi* | [**graphSystemTraverseUser**](docs/SystemsApi.md#graphSystemTraverseUser) | **GET** /systems/{system_id}/users | List the Users bound to a System
*SystemsApi* | [**graphSystemTraverseUserGroup**](docs/SystemsApi.md#graphSystemTraverseUserGroup) | **GET** /systems/{system_id}/usergroups | List the User Groups bound to a System
*SystemsApi* | [**systemsGetFDEKey**](docs/SystemsApi.md#systemsGetFDEKey) | **GET** /systems/{system_id}/fdekey | Get System FDE Key
*UserGroupAssociationsApi* | [**graphUserGroupAssociationsList**](docs/UserGroupAssociationsApi.md#graphUserGroupAssociationsList) | **GET** /usergroups/{group_id}/associations | List the associations of a User Group.
*UserGroupAssociationsApi* | [**graphUserGroupAssociationsPost**](docs/UserGroupAssociationsApi.md#graphUserGroupAssociationsPost) | **POST** /usergroups/{group_id}/associations | Manage the associations of a User Group
*UserGroupAssociationsApi* | [**graphUserGroupTraverseActiveDirectory**](docs/UserGroupAssociationsApi.md#graphUserGroupTraverseActiveDirectory) | **GET** /usergroups/{group_id}/activedirectories | List the Active Directories bound to a User Group
*UserGroupAssociationsApi* | [**graphUserGroupTraverseApplication**](docs/UserGroupAssociationsApi.md#graphUserGroupTraverseApplication) | **GET** /usergroups/{group_id}/applications | List the Applications bound to a User Group
*UserGroupAssociationsApi* | [**graphUserGroupTraverseDirectory**](docs/UserGroupAssociationsApi.md#graphUserGroupTraverseDirectory) | **GET** /usergroups/{group_id}/directories | List the Directories bound to a User Group
*UserGroupAssociationsApi* | [**graphUserGroupTraverseGSuite**](docs/UserGroupAssociationsApi.md#graphUserGroupTraverseGSuite) | **GET** /usergroups/{group_id}/gsuites | List the G Suite instances bound to a User Group
*UserGroupAssociationsApi* | [**graphUserGroupTraverseLdapServer**](docs/UserGroupAssociationsApi.md#graphUserGroupTraverseLdapServer) | **GET** /usergroups/{group_id}/ldapservers | List the LDAP Servers bound to a User Group
*UserGroupAssociationsApi* | [**graphUserGroupTraverseOffice365**](docs/UserGroupAssociationsApi.md#graphUserGroupTraverseOffice365) | **GET** /usergroups/{group_id}/office365s | List the Office 365 instances bound to a User Group
*UserGroupAssociationsApi* | [**graphUserGroupTraverseRadiusServer**](docs/UserGroupAssociationsApi.md#graphUserGroupTraverseRadiusServer) | **GET** /usergroups/{group_id}/radiusservers | List the RADIUS Servers bound to a User Group
*UserGroupAssociationsApi* | [**graphUserGroupTraverseSystem**](docs/UserGroupAssociationsApi.md#graphUserGroupTraverseSystem) | **GET** /usergroups/{group_id}/systems | List the Systems bound to a User Group
*UserGroupAssociationsApi* | [**graphUserGroupTraverseSystemGroup**](docs/UserGroupAssociationsApi.md#graphUserGroupTraverseSystemGroup) | **GET** /usergroups/{group_id}/systemgroups | List the System Groups bound to User Groups
*UserGroupMembersMembershipApi* | [**graphUserGroupMemberOf**](docs/UserGroupMembersMembershipApi.md#graphUserGroupMemberOf) | **GET** /usergroups/{group_id}/memberof | List the User Group&#39;s parents
*UserGroupMembersMembershipApi* | [**graphUserGroupMembersList**](docs/UserGroupMembersMembershipApi.md#graphUserGroupMembersList) | **GET** /usergroups/{group_id}/members | List the members of a User Group
*UserGroupMembersMembershipApi* | [**graphUserGroupMembersPost**](docs/UserGroupMembersMembershipApi.md#graphUserGroupMembersPost) | **POST** /usergroups/{group_id}/members | Manage the members of a User Group
*UserGroupMembersMembershipApi* | [**graphUserGroupMembership**](docs/UserGroupMembersMembershipApi.md#graphUserGroupMembership) | **GET** /usergroups/{group_id}/membership | List the User Group&#39;s membership
*UserGroupsApi* | [**graphUserGroupAssociationsList**](docs/UserGroupsApi.md#graphUserGroupAssociationsList) | **GET** /usergroups/{group_id}/associations | List the associations of a User Group.
*UserGroupsApi* | [**graphUserGroupAssociationsPost**](docs/UserGroupsApi.md#graphUserGroupAssociationsPost) | **POST** /usergroups/{group_id}/associations | Manage the associations of a User Group
*UserGroupsApi* | [**graphUserGroupMemberOf**](docs/UserGroupsApi.md#graphUserGroupMemberOf) | **GET** /usergroups/{group_id}/memberof | List the User Group&#39;s parents
*UserGroupsApi* | [**graphUserGroupMembersList**](docs/UserGroupsApi.md#graphUserGroupMembersList) | **GET** /usergroups/{group_id}/members | List the members of a User Group
*UserGroupsApi* | [**graphUserGroupMembersPost**](docs/UserGroupsApi.md#graphUserGroupMembersPost) | **POST** /usergroups/{group_id}/members | Manage the members of a User Group
*UserGroupsApi* | [**graphUserGroupMembership**](docs/UserGroupsApi.md#graphUserGroupMembership) | **GET** /usergroups/{group_id}/membership | List the User Group&#39;s membership
*UserGroupsApi* | [**graphUserGroupTraverseActiveDirectory**](docs/UserGroupsApi.md#graphUserGroupTraverseActiveDirectory) | **GET** /usergroups/{group_id}/activedirectories | List the Active Directories bound to a User Group
*UserGroupsApi* | [**graphUserGroupTraverseApplication**](docs/UserGroupsApi.md#graphUserGroupTraverseApplication) | **GET** /usergroups/{group_id}/applications | List the Applications bound to a User Group
*UserGroupsApi* | [**graphUserGroupTraverseDirectory**](docs/UserGroupsApi.md#graphUserGroupTraverseDirectory) | **GET** /usergroups/{group_id}/directories | List the Directories bound to a User Group
*UserGroupsApi* | [**graphUserGroupTraverseGSuite**](docs/UserGroupsApi.md#graphUserGroupTraverseGSuite) | **GET** /usergroups/{group_id}/gsuites | List the G Suite instances bound to a User Group
*UserGroupsApi* | [**graphUserGroupTraverseLdapServer**](docs/UserGroupsApi.md#graphUserGroupTraverseLdapServer) | **GET** /usergroups/{group_id}/ldapservers | List the LDAP Servers bound to a User Group
*UserGroupsApi* | [**graphUserGroupTraverseOffice365**](docs/UserGroupsApi.md#graphUserGroupTraverseOffice365) | **GET** /usergroups/{group_id}/office365s | List the Office 365 instances bound to a User Group
*UserGroupsApi* | [**graphUserGroupTraverseRadiusServer**](docs/UserGroupsApi.md#graphUserGroupTraverseRadiusServer) | **GET** /usergroups/{group_id}/radiusservers | List the RADIUS Servers bound to a User Group
*UserGroupsApi* | [**graphUserGroupTraverseSystem**](docs/UserGroupsApi.md#graphUserGroupTraverseSystem) | **GET** /usergroups/{group_id}/systems | List the Systems bound to a User Group
*UserGroupsApi* | [**graphUserGroupTraverseSystemGroup**](docs/UserGroupsApi.md#graphUserGroupTraverseSystemGroup) | **GET** /usergroups/{group_id}/systemgroups | List the System Groups bound to User Groups
*UserGroupsApi* | [**groupsUserDelete**](docs/UserGroupsApi.md#groupsUserDelete) | **DELETE** /usergroups/{id} | Delete a User Group
*UserGroupsApi* | [**groupsUserGet**](docs/UserGroupsApi.md#groupsUserGet) | **GET** /usergroups/{id} | View an individual User Group details
*UserGroupsApi* | [**groupsUserList**](docs/UserGroupsApi.md#groupsUserList) | **GET** /usergroups | List all User Groups
*UserGroupsApi* | [**groupsUserPatch**](docs/UserGroupsApi.md#groupsUserPatch) | **PATCH** /usergroups/{id} | Partial update a User Group
*UserGroupsApi* | [**groupsUserPost**](docs/UserGroupsApi.md#groupsUserPost) | **POST** /usergroups | Create a new User Group
*UserGroupsApi* | [**groupsUserPut**](docs/UserGroupsApi.md#groupsUserPut) | **PUT** /usergroups/{id} | Update a User Group
*UsersApi* | [**graphUserAssociationsList**](docs/UsersApi.md#graphUserAssociationsList) | **GET** /users/{user_id}/associations | List the associations of a User
*UsersApi* | [**graphUserAssociationsPost**](docs/UsersApi.md#graphUserAssociationsPost) | **POST** /users/{user_id}/associations | Manage the associations of a User
*UsersApi* | [**graphUserMemberOf**](docs/UsersApi.md#graphUserMemberOf) | **GET** /users/{user_id}/memberof | List the parent Groups of a User
*UsersApi* | [**graphUserTraverseApplication**](docs/UsersApi.md#graphUserTraverseApplication) | **GET** /users/{user_id}/applications | List the Applications bound to a User
*UsersApi* | [**graphUserTraverseDirectory**](docs/UsersApi.md#graphUserTraverseDirectory) | **GET** /users/{user_id}/directories | List the Directories bound to a User
*UsersApi* | [**graphUserTraverseGSuite**](docs/UsersApi.md#graphUserTraverseGSuite) | **GET** /users/{user_id}/gsuites | List the G Suite instances bound to a User
*UsersApi* | [**graphUserTraverseLdapServer**](docs/UsersApi.md#graphUserTraverseLdapServer) | **GET** /users/{user_id}/ldapservers | List the LDAP servers bound to a User
*UsersApi* | [**graphUserTraverseOffice365**](docs/UsersApi.md#graphUserTraverseOffice365) | **GET** /users/{user_id}/office365s | List the Office 365 instances bound to a User
*UsersApi* | [**graphUserTraverseRadiusServer**](docs/UsersApi.md#graphUserTraverseRadiusServer) | **GET** /users/{user_id}/radiusservers | List the RADIUS Servers bound to a User
*UsersApi* | [**graphUserTraverseSystem**](docs/UsersApi.md#graphUserTraverseSystem) | **GET** /users/{user_id}/systems | List the Systems bound to a User
*UsersApi* | [**graphUserTraverseSystemGroup**](docs/UsersApi.md#graphUserTraverseSystemGroup) | **GET** /users/{user_id}/systemgroups | List the System Groups bound to a User
*UsersApi* | [**usersSendEmails**](docs/UsersApi.md#usersSendEmails) | **POST** /users/{user_id}/emails | Send User Emails
*WorkdayImportApi* | [**workdaysAuthorize**](docs/WorkdayImportApi.md#workdaysAuthorize) | **POST** /workdays/{workday_id}/auth | Authorize Workday
*WorkdayImportApi* | [**workdaysDeauthorize**](docs/WorkdayImportApi.md#workdaysDeauthorize) | **DELETE** /workdays/{workday_id}/auth | Deauthorize Workday
*WorkdayImportApi* | [**workdaysDelete**](docs/WorkdayImportApi.md#workdaysDelete) | **DELETE** /workdays/{id} | Delete Workday
*WorkdayImportApi* | [**workdaysGet**](docs/WorkdayImportApi.md#workdaysGet) | **GET** /workdays/{id} | Get Workday
*WorkdayImportApi* | [**workdaysImport**](docs/WorkdayImportApi.md#workdaysImport) | **POST** /workdays/{workday_id}/import | Workday Import
*WorkdayImportApi* | [**workdaysImportresults**](docs/WorkdayImportApi.md#workdaysImportresults) | **GET** /workdays/{id}/import/{job_id}/results | List Import Results
*WorkdayImportApi* | [**workdaysList**](docs/WorkdayImportApi.md#workdaysList) | **GET** /workdays | List Workdays
*WorkdayImportApi* | [**workdaysPost**](docs/WorkdayImportApi.md#workdaysPost) | **POST** /workdays | Create new Workday
*WorkdayImportApi* | [**workdaysPut**](docs/WorkdayImportApi.md#workdaysPut) | **PUT** /workdays/{id} | Update Workday
*WorkdayImportApi* | [**workdaysSettings**](docs/WorkdayImportApi.md#workdaysSettings) | **GET** /workdays/settings | Get Workday Settings (incomplete)
*WorkdayImportApi* | [**workdaysWorkers**](docs/WorkdayImportApi.md#workdaysWorkers) | **GET** /workdays/{workday_id}/workers | List Workday Workers


## Documentation for Models

 - [ActiveDirectoryAgentGetOutput](docs/ActiveDirectoryAgentGetOutput.md)
 - [ActiveDirectoryAgentInput](docs/ActiveDirectoryAgentInput.md)
 - [ActiveDirectoryAgentListOutput](docs/ActiveDirectoryAgentListOutput.md)
 - [ActiveDirectoryInput](docs/ActiveDirectoryInput.md)
 - [Administrator](docs/Administrator.md)
 - [AuthInfo](docs/AuthInfo.md)
 - [AuthInput](docs/AuthInput.md)
 - [AuthInputObject](docs/AuthInputObject.md)
 - [AuthinputBasic](docs/AuthinputBasic.md)
 - [AuthinputOauth](docs/AuthinputOauth.md)
 - [Body](docs/Body.md)
 - [BulkUserCreate](docs/BulkUserCreate.md)
 - [BulkUserUpdate](docs/BulkUserUpdate.md)
 - [Directory](docs/Directory.md)
 - [DuoAccount](docs/DuoAccount.md)
 - [DuoApplication](docs/DuoApplication.md)
 - [DuoApplicationReq](docs/DuoApplicationReq.md)
 - [DuoRegistrationApplication](docs/DuoRegistrationApplication.md)
 - [DuoRegistrationApplicationReq](docs/DuoRegistrationApplicationReq.md)
 - [Emailrequest](docs/Emailrequest.md)
 - [Error](docs/Error.md)
 - [Errorresponse](docs/Errorresponse.md)
 - [GSuiteBuiltinTranslation](docs/GSuiteBuiltinTranslation.md)
 - [GSuiteTranslationRule](docs/GSuiteTranslationRule.md)
 - [GSuiteTranslationRuleRequest](docs/GSuiteTranslationRuleRequest.md)
 - [GraphConnection](docs/GraphConnection.md)
 - [GraphManagementReq](docs/GraphManagementReq.md)
 - [GraphObject](docs/GraphObject.md)
 - [GraphObjectWithPaths](docs/GraphObjectWithPaths.md)
 - [GraphType](docs/GraphType.md)
 - [Group](docs/Group.md)
 - [GroupType](docs/GroupType.md)
 - [GsuiteOutput](docs/GsuiteOutput.md)
 - [GsuitePatchInput](docs/GsuitePatchInput.md)
 - [InlineResponse200](docs/InlineResponse200.md)
 - [InlineResponse2001](docs/InlineResponse2001.md)
 - [InlineResponse400](docs/InlineResponse400.md)
 - [JobDetails](docs/JobDetails.md)
 - [JobId](docs/JobId.md)
 - [JobWorkresult](docs/JobWorkresult.md)
 - [LdapServerAction](docs/LdapServerAction.md)
 - [LdapServerInput](docs/LdapServerInput.md)
 - [Mfa](docs/Mfa.md)
 - [OauthCodeInput](docs/OauthCodeInput.md)
 - [Office365BuiltinTranslation](docs/Office365BuiltinTranslation.md)
 - [Office365TranslationRule](docs/Office365TranslationRule.md)
 - [Office365TranslationRuleRequest](docs/Office365TranslationRuleRequest.md)
 - [OrgCryptoSettings](docs/OrgCryptoSettings.md)
 - [OrgcryptosettingsSshKeys](docs/OrgcryptosettingsSshKeys.md)
 - [Policy](docs/Policy.md)
 - [PolicyRequest](docs/PolicyRequest.md)
 - [PolicyRequestTemplate](docs/PolicyRequestTemplate.md)
 - [PolicyResult](docs/PolicyResult.md)
 - [PolicyTemplate](docs/PolicyTemplate.md)
 - [PolicyTemplateConfigField](docs/PolicyTemplateConfigField.md)
 - [PolicyTemplateConfigFieldTooltip](docs/PolicyTemplateConfigFieldTooltip.md)
 - [PolicyTemplateConfigFieldTooltipVariables](docs/PolicyTemplateConfigFieldTooltipVariables.md)
 - [PolicyTemplateWithDetails](docs/PolicyTemplateWithDetails.md)
 - [PolicyValue](docs/PolicyValue.md)
 - [PolicyWithDetails](docs/PolicyWithDetails.md)
 - [Provider](docs/Provider.md)
 - [ProviderAdminReq](docs/ProviderAdminReq.md)
 - [ProviderContact](docs/ProviderContact.md)
 - [SambaDomainInput](docs/SambaDomainInput.md)
 - [Sshkeylist](docs/Sshkeylist.md)
 - [SystemGraphManagementReq](docs/SystemGraphManagementReq.md)
 - [SystemGraphManagementReqAttributes](docs/SystemGraphManagementReqAttributes.md)
 - [SystemGraphManagementReqAttributesSudo](docs/SystemGraphManagementReqAttributesSudo.md)
 - [SystemGroup](docs/SystemGroup.md)
 - [SystemGroupData](docs/SystemGroupData.md)
 - [SystemGroupGraphManagementReq](docs/SystemGroupGraphManagementReq.md)
 - [SystemGroupMembersReq](docs/SystemGroupMembersReq.md)
 - [SystemInsightsApps](docs/SystemInsightsApps.md)
 - [SystemInsightsBitlockerInfo](docs/SystemInsightsBitlockerInfo.md)
 - [SystemInsightsBrowserPlugins](docs/SystemInsightsBrowserPlugins.md)
 - [SystemInsightsChromeExtensions](docs/SystemInsightsChromeExtensions.md)
 - [SystemInsightsDiskEncryption](docs/SystemInsightsDiskEncryption.md)
 - [SystemInsightsDiskInfo](docs/SystemInsightsDiskInfo.md)
 - [SystemInsightsEtcHosts](docs/SystemInsightsEtcHosts.md)
 - [SystemInsightsFirefoxAddons](docs/SystemInsightsFirefoxAddons.md)
 - [SystemInsightsGroups](docs/SystemInsightsGroups.md)
 - [SystemInsightsInterfaceAddresses](docs/SystemInsightsInterfaceAddresses.md)
 - [SystemInsightsKernelInfo](docs/SystemInsightsKernelInfo.md)
 - [SystemInsightsLogicalDrvies](docs/SystemInsightsLogicalDrvies.md)
 - [SystemInsightsMounts](docs/SystemInsightsMounts.md)
 - [SystemInsightsOsVersion](docs/SystemInsightsOsVersion.md)
 - [SystemInsightsPatches](docs/SystemInsightsPatches.md)
 - [SystemInsightsPrograms](docs/SystemInsightsPrograms.md)
 - [SystemInsightsSafariExtensions](docs/SystemInsightsSafariExtensions.md)
 - [SystemInsightsSystemControls](docs/SystemInsightsSystemControls.md)
 - [SystemInsightsSystemInfo](docs/SystemInsightsSystemInfo.md)
 - [SystemInsightsUptime](docs/SystemInsightsUptime.md)
 - [SystemInsightsUsers](docs/SystemInsightsUsers.md)
 - [Systemfdekey](docs/Systemfdekey.md)
 - [Systemuser](docs/Systemuser.md)
 - [Systemuserputpost](docs/Systemuserputpost.md)
 - [SystemuserputpostAddresses](docs/SystemuserputpostAddresses.md)
 - [SystemuserputpostPhoneNumbers](docs/SystemuserputpostPhoneNumbers.md)
 - [UserGraphManagementReq](docs/UserGraphManagementReq.md)
 - [UserGroup](docs/UserGroup.md)
 - [UserGroupGraphManagementReq](docs/UserGroupGraphManagementReq.md)
 - [UserGroupMembersReq](docs/UserGroupMembersReq.md)
 - [UserGroupPost](docs/UserGroupPost.md)
 - [UserGroupPostAttributes](docs/UserGroupPostAttributes.md)
 - [UserGroupPostAttributesPosixGroups](docs/UserGroupPostAttributesPosixGroups.md)
 - [UserGroupPut](docs/UserGroupPut.md)
 - [UserGroupPutAttributes](docs/UserGroupPutAttributes.md)
 - [WorkdayFields](docs/WorkdayFields.md)
 - [WorkdayInput](docs/WorkdayInput.md)
 - [WorkdayOutput](docs/WorkdayOutput.md)
 - [WorkdayRequest](docs/WorkdayRequest.md)
 - [WorkdayWorker](docs/WorkdayWorker.md)
 - [WorkdayoutputAuth](docs/WorkdayoutputAuth.md)
 - [ActiveDirectoryOutput](docs/ActiveDirectoryOutput.md)
 - [LdapServerOutput](docs/LdapServerOutput.md)
 - [SambaDomainOutput](docs/SambaDomainOutput.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### x-api-key

- **Type**: API key
- **API key parameter name**: x-api-key
- **Location**: HTTP header


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author



