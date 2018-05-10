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
import io.swagger.client.api.ApplicationsApi;

import java.io.File;
import java.util.*;

public class ApplicationsApiExample {

    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        
        // Configure API key authorization: x-api-key
        ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
        x-api-key.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //x-api-key.setApiKeyPrefix("Token");

        ApplicationsApi apiInstance = new ApplicationsApi();
        String contentType = "application/json"; // String | 
        String accept = "application/json"; // String | 
        String fields = "fields_example"; // String | The comma separated fileds included in the returned records. If omitted the default list of fields will be returned.
        Integer limit = 56; // Integer | The number of records to return at once.
        Integer skip = 56; // Integer | The offset into the records to return.
        String sort = "The comma separated fields used to sort the collection. Default sort is ascending, prefix with - to sort descending."; // String | 
        try {
            InlineResponse200 result = apiInstance.applicationsList(contentType, accept, fields, limit, skip, sort);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ApplicationsApi#applicationsList");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://console.jumpcloud.com/api*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*ApplicationsApi* | [**applicationsList**](docs/ApplicationsApi.md#applicationsList) | **GET** /applications | Applications
*CommandResultsApi* | [**commandResultsDelete**](docs/CommandResultsApi.md#commandResultsDelete) | **DELETE** /commandresults/{id} | Delete a Command result
*CommandResultsApi* | [**commandResultsGet**](docs/CommandResultsApi.md#commandResultsGet) | **GET** /commandresults/{id} | List an individual Command result
*CommandResultsApi* | [**commandResultsList**](docs/CommandResultsApi.md#commandResultsList) | **GET** /commandresults | List all Command Results
*CommandTriggersApi* | [**commandTriggerWebhookPost**](docs/CommandTriggersApi.md#commandTriggerWebhookPost) | **POST** /command/trigger/{triggername} | Launch a command via a Trigger
*CommandsApi* | [**commandFileGet**](docs/CommandsApi.md#commandFileGet) | **GET** /files/command/{id} | Get a Command File
*CommandsApi* | [**commandsDelete**](docs/CommandsApi.md#commandsDelete) | **DELETE** /commands/{id} | Delete a Command
*CommandsApi* | [**commandsGet**](docs/CommandsApi.md#commandsGet) | **GET** /commands/{id} | List an individual Command
*CommandsApi* | [**commandsList**](docs/CommandsApi.md#commandsList) | **GET** /commands/ | List All Commands
*CommandsApi* | [**commandsPost**](docs/CommandsApi.md#commandsPost) | **POST** /commands/ | Create A Command
*CommandsApi* | [**commandsPut**](docs/CommandsApi.md#commandsPut) | **PUT** /commands/{id} | Update a Command
*RadiusServersApi* | [**radiusServersList**](docs/RadiusServersApi.md#radiusServersList) | **GET** /radiusservers | List Radius Servers
*RadiusServersApi* | [**radiusServersPost**](docs/RadiusServersApi.md#radiusServersPost) | **POST** /radiusservers | Create a Radius Server
*RadiusServersApi* | [**radiusServersPut**](docs/RadiusServersApi.md#radiusServersPut) | **PUT** /radiusservers:id | Update Radius Servers
*SearchApi* | [**searchSystemsPost**](docs/SearchApi.md#searchSystemsPost) | **POST** /search/systems | Search Systems
*SearchApi* | [**searchSystemusersPost**](docs/SearchApi.md#searchSystemusersPost) | **POST** /search/systemusers | Search System Users
*SystemsApi* | [**systemsDelete**](docs/SystemsApi.md#systemsDelete) | **DELETE** /systems/{id} | Delete a System
*SystemsApi* | [**systemsGet**](docs/SystemsApi.md#systemsGet) | **GET** /systems/{id} | List an individual system
*SystemsApi* | [**systemsList**](docs/SystemsApi.md#systemsList) | **GET** /systems | List All Systems
*SystemsApi* | [**systemsPut**](docs/SystemsApi.md#systemsPut) | **PUT** /systems/{id} | Update a system
*SystemsApi* | [**systemsSystemusersBindingList**](docs/SystemsApi.md#systemsSystemusersBindingList) | **GET** /systems/{id}/systemusers | List system user bindings
*SystemsApi* | [**systemsSystemusersBindingPut**](docs/SystemsApi.md#systemsSystemusersBindingPut) | **PUT** /systems/{id}/systemusers | Update a system&#39;s or user&#39;s binding
*SystemusersApi* | [**systemusersDelete**](docs/SystemusersApi.md#systemusersDelete) | **DELETE** /systemusers/{id} | Delete a system user
*SystemusersApi* | [**systemusersGet**](docs/SystemusersApi.md#systemusersGet) | **GET** /systemusers/{id} | List a system user
*SystemusersApi* | [**systemusersList**](docs/SystemusersApi.md#systemusersList) | **GET** /systemusers | List all system users
*SystemusersApi* | [**systemusersPost**](docs/SystemusersApi.md#systemusersPost) | **POST** /systemusers | Create a system user
*SystemusersApi* | [**systemusersPut**](docs/SystemusersApi.md#systemusersPut) | **PUT** /systemusers/{id} | Update a system user
*SystemusersApi* | [**systemusersSystemsBindingList**](docs/SystemusersApi.md#systemusersSystemsBindingList) | **GET** /systemusers/{id}/systems | List system user binding
*SystemusersApi* | [**systemusersSystemsBindingPut**](docs/SystemusersApi.md#systemusersSystemsBindingPut) | **PUT** /systemusers/{id}/systems | Update a system user binding
*TagsApi* | [**tagsDelete**](docs/TagsApi.md#tagsDelete) | **DELETE** /tags/{name} | Delete a Tag
*TagsApi* | [**tagsGet**](docs/TagsApi.md#tagsGet) | **GET** /Tags/{name} | List a Tag
*TagsApi* | [**tagsList**](docs/TagsApi.md#tagsList) | **GET** /tags | List All Tags
*TagsApi* | [**tagsPost**](docs/TagsApi.md#tagsPost) | **POST** /tags | Create a Tag
*TagsApi* | [**tagsPut**](docs/TagsApi.md#tagsPut) | **PUT** /Tag/{name} | Update a Tag


## Documentation for Models

 - [Application](docs/Application.md)
 - [ApplicationConfig](docs/ApplicationConfig.md)
 - [ApplicationConfigConstantAttributes](docs/ApplicationConfigConstantAttributes.md)
 - [ApplicationConfigConstantAttributesValue](docs/ApplicationConfigConstantAttributesValue.md)
 - [Applicationslist](docs/Applicationslist.md)
 - [Body](docs/Body.md)
 - [Command](docs/Command.md)
 - [Commandfilereturn](docs/Commandfilereturn.md)
 - [Commandresult](docs/Commandresult.md)
 - [CommandresultResponse](docs/CommandresultResponse.md)
 - [CommandresultResponseData](docs/CommandresultResponseData.md)
 - [Commandresultslist](docs/Commandresultslist.md)
 - [Commandslist](docs/Commandslist.md)
 - [InlineResponse200](docs/InlineResponse200.md)
 - [InlineResponse200Config](docs/InlineResponse200Config.md)
 - [InlineResponse200ConfigConstantAttributes](docs/InlineResponse200ConfigConstantAttributes.md)
 - [InlineResponse200ConfigConstantAttributesValue](docs/InlineResponse200ConfigConstantAttributesValue.md)
 - [InlineResponse200ConfigDatabaseAttributes](docs/InlineResponse200ConfigDatabaseAttributes.md)
 - [InlineResponse200ConfigIdpEntityId](docs/InlineResponse200ConfigIdpEntityId.md)
 - [InlineResponse200ConfigIdpEntityIdTooltip](docs/InlineResponse200ConfigIdpEntityIdTooltip.md)
 - [InlineResponse200ConfigIdpEntityIdTooltipVariables](docs/InlineResponse200ConfigIdpEntityIdTooltipVariables.md)
 - [InlineResponse200Results](docs/InlineResponse200Results.md)
 - [Radiusserver](docs/Radiusserver.md)
 - [Radiusserverpost](docs/Radiusserverpost.md)
 - [Radiusserverput](docs/Radiusserverput.md)
 - [Radiusserverslist](docs/Radiusserverslist.md)
 - [Search](docs/Search.md)
 - [System](docs/System.md)
 - [SystemNetworkInterfaces](docs/SystemNetworkInterfaces.md)
 - [Systemput](docs/Systemput.md)
 - [SystemputAgentBoundMessages](docs/SystemputAgentBoundMessages.md)
 - [Systemslist](docs/Systemslist.md)
 - [Systemuser](docs/Systemuser.md)
 - [Systemuserbinding](docs/Systemuserbinding.md)
 - [Systemuserbindingsput](docs/Systemuserbindingsput.md)
 - [Systemuserput](docs/Systemuserput.md)
 - [Systemuserputpost](docs/Systemuserputpost.md)
 - [Systemuserreturn](docs/Systemuserreturn.md)
 - [Systemuserslist](docs/Systemuserslist.md)
 - [Tag](docs/Tag.md)
 - [Tagpost](docs/Tagpost.md)
 - [Tagput](docs/Tagput.md)
 - [Tagslist](docs/Tagslist.md)
 - [Usersystembinding](docs/Usersystembinding.md)
 - [Usersystembindingsput](docs/Usersystembindingsput.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### x-api-key

- **Type**: API key
- **API key parameter name**: x-api-key
- **Location**: HTTP header


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author



