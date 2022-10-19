# jcapi-java-client

JumpCloud API
- API version: 2.0
  - Build date: 2022-10-19T07:49:49.516358Z[Etc/UTC]

# Overview  JumpCloud's V2 API. This set of endpoints allows JumpCloud customers to manage objects, groupings and mappings and interact with the JumpCloud Graph.  # Directory Objects  This API offers the ability to interact with some of our core features; otherwise known as Directory Objects. The Directory Objects are:  * Commands * Policies * Policy Groups * Applications * Systems * Users * User Groups * System Groups * Radius Servers * Directories: Office 365, LDAP,G-Suite, Active Directory * Duo accounts and applications.  The Directory Object is an important concept to understand in order to successfully use JumpCloud API.  ## JumpCloud Graph  We've also introduced the concept of the JumpCloud Graph along with  Directory Objects. The Graph is a powerful aspect of our platform which will enable you to associate objects with each other, or establish membership for certain objects to become members of other objects.  Specific `GET` endpoints will allow you to traverse the JumpCloud Graph to return all indirect and directly bound objects in your organization.  | ![alt text](https://s3.amazonaws.com/jumpcloud-kb/Knowledge+Base+Photos/API+Docs/jumpcloud_graph.png \"JumpCloud Graph Model Example\") | |:--:| | **This diagram highlights our association and membership model as it relates to Directory Objects.** |  # API Key  ## Access Your API Key  To locate your API Key:  1. Log into the [JumpCloud Admin Console](https://console.jumpcloud.com/). 2. Go to the username drop down located in the top-right of the Console. 3. Retrieve your API key from API Settings.  ## API Key Considerations  This API key is associated to the currently logged in administrator. Other admins will have different API keys.  **WARNING** Please keep this API key secret, as it grants full access to any data accessible via your JumpCloud console account.  You can also reset your API key in the same location in the JumpCloud Admin Console.  ## Recycling or Resetting Your API Key  In order to revoke access with the current API key, simply reset your API key. This will render all calls using the previous API key inaccessible.  Your API key will be passed in as a header with the header name \"x-api-key\".  ```bash curl -H \"x-api-key: [YOUR_API_KEY_HERE]\" \"https://console.jumpcloud.com/api/v2/systemgroups\" ```  # System Context  * [Introduction](#introduction) * [Supported endpoints](#supported-endpoints) * [Response codes](#response-codes) * [Authentication](#authentication) * [Additional examples](#additional-examples) * [Third party](#third-party)  ## Introduction  JumpCloud System Context Authorization is an alternative way to authenticate with a subset of JumpCloud's REST APIs. Using this method, a system can manage its information and resource associations, allowing modern auto provisioning environments to scale as needed.  **Notes:**   * The following documentation applies to Linux Operating Systems only.  * Systems that have been automatically enrolled using Apple's Device Enrollment Program (DEP) or systems enrolled using the User Portal install are not eligible to use the System Context API to prevent unauthorized access to system groups and resources. If a script that utilizes the System Context API is invoked on a system enrolled in this way, it will display an error.  ## Supported Endpoints  JumpCloud System Context Authorization can be used in conjunction with Systems endpoints found in the V1 API and certain System Group endpoints found in the v2 API.  * A system may fetch, alter, and delete metadata about itself, including manipulating a system's Group and Systemuser associations,   * `/api/systems/{system_id}` | [`GET`](https://docs.jumpcloud.com/api/1.0/index.html#operation/systems_get) [`PUT`](https://docs.jumpcloud.com/api/1.0/index.html#operation/systems_put) * A system may delete itself from your JumpCloud organization   * `/api/systems/{system_id}` | [`DELETE`](https://docs.jumpcloud.com/api/1.0/index.html#operation/systems_delete) * A system may fetch its direct resource associations under v2 (Groups)   * `/api/v2/systems/{system_id}/memberof` | [`GET`](https://docs.jumpcloud.com/api/2.0/index.html#operation/graph_systemGroupMembership)   * `/api/v2/systems/{system_id}/associations` | [`GET`](https://docs.jumpcloud.com/api/2.0/index.html#operation/graph_systemAssociationsList)   * `/api/v2/systems/{system_id}/users` | [`GET`](https://docs.jumpcloud.com/api/2.0/index.html#operation/graph_systemTraverseUser) * A system may alter its direct resource associations under v2 (Groups)   * `/api/v2/systems/{system_id}/associations` | [`POST`](https://docs.jumpcloud.com/api/2.0/index.html#operation/graph_systemAssociationsPost) * A system may alter its System Group associations   * `/api/v2/systemgroups/{group_id}/members` | [`POST`](https://docs.jumpcloud.com/api/2.0/index.html#operation/graph_systemGroupMembersPost)     * _NOTE_ If a system attempts to alter the system group membership of a different system the request will be rejected  ## Response Codes  If endpoints other than those described above are called using the System Context API, the server will return a `401` response.  ## Authentication  To allow for secure access to our APIs, you must authenticate each API request. JumpCloud System Context Authorization uses [HTTP Signatures](https://tools.ietf.org/html/draft-cavage-http-signatures-00) to authenticate API requests. The HTTP Signatures sent with each request are similar to the signatures used by the Amazon Web Services REST API. To help with the request-signing process, we have provided an [example bash script](https://github.com/TheJumpCloud/SystemContextAPI/blob/master/examples/shell/SigningExample.sh). This example API request simply requests the entire system record. You must be root, or have permissions to access the contents of the `/opt/jc` directory to generate a signature.  Here is a breakdown of the example script with explanations.  First, the script extracts the systemKey from the JSON formatted `/opt/jc/jcagent.conf` file.  ```bash #!/bin/bash conf=\"`cat /opt/jc/jcagent.conf`\" regex=\"systemKey\\\":\\\"(\\w+)\\\"\"  if [[ $conf =~ $regex ]] ; then   systemKey=\"${BASH_REMATCH[1]}\" fi ```  Then, the script retrieves the current date in the correct format.  ```bash now=`date -u \"+%a, %d %h %Y %H:%M:%S GMT\"`; ```  Next, we build a signing string to demonstrate the expected signature format. The signed string must consist of the [request-line](https://tools.ietf.org/html/rfc2616#page-35) and the date header, separated by a newline character.  ```bash signstr=\"GET /api/systems/${systemKey} HTTP/1.1\\ndate: ${now}\" ```  The next step is to calculate and apply the signature. This is a two-step process:  1. Create a signature from the signing string using the JumpCloud Agent private key: ``printf \"$signstr\" | openssl dgst -sha256 -sign /opt/jc/client.key`` 2. Then Base64-encode the signature string and trim off the newline characters: ``| openssl enc -e -a | tr -d '\\n'``  The combined steps above result in:  ```bash signature=`printf \"$signstr\" | openssl dgst -sha256 -sign /opt/jc/client.key | openssl enc -e -a | tr -d '\\n'` ; ```  Finally, we make sure the API call sending the signature has the same Authorization and Date header values, HTTP method, and URL that were used in the signing string.  ```bash curl -iq \\   -H \"Accept: application/json\" \\   -H \"Content-Type: application/json\" \\   -H \"Date: ${now}\" \\   -H \"Authorization: Signature keyId=\\\"system/${systemKey}\\\",headers=\\\"request-line date\\\",algorithm=\\\"rsa-sha256\\\",signature=\\\"${signature}\\\"\" \\   --url https://console.jumpcloud.com/api/systems/${systemKey} ```  ### Input Data  All PUT and POST methods should use the HTTP Content-Type header with a value of 'application/json'. PUT methods are used for updating a record. POST methods are used to create a record.  The following example demonstrates how to update the `displayName` of the system.  ```bash signstr=\"PUT /api/systems/${systemKey} HTTP/1.1\\ndate: ${now}\" signature=`printf \"$signstr\" | openssl dgst -sha256 -sign /opt/jc/client.key | openssl enc -e -a | tr -d '\\n'` ;  curl -iq \\   -d \"{\\\"displayName\\\" : \\\"updated-system-name-1\\\"}\" \\   -X \"PUT\" \\   -H \"Content-Type: application/json\" \\   -H \"Accept: application/json\" \\   -H \"Date: ${now}\" \\   -H \"Authorization: Signature keyId=\\\"system/${systemKey}\\\",headers=\\\"request-line date\\\",algorithm=\\\"rsa-sha256\\\",signature=\\\"${signature}\\\"\" \\   --url https://console.jumpcloud.com/api/systems/${systemKey} ```  ### Output Data  All results will be formatted as JSON.  Here is an abbreviated example of response output:  ```json {   \"_id\": \"525ee96f52e144993e000015\",   \"agentServer\": \"lappy386\",   \"agentVersion\": \"0.9.42\",   \"arch\": \"x86_64\",   \"connectionKey\": \"127.0.0.1_51812\",   \"displayName\": \"ubuntu-1204\",   \"firstContact\": \"2013-10-16T19:30:55.611Z\",   \"hostname\": \"ubuntu-1204\"   ... ```  ## Additional Examples  ### Signing Authentication Example  This example demonstrates how to make an authenticated request to fetch the JumpCloud record for this system.  [SigningExample.sh](https://github.com/TheJumpCloud/SystemContextAPI/blob/master/examples/shell/SigningExample.sh)  ### Shutdown Hook  This example demonstrates how to make an authenticated request on system shutdown. Using an init.d script registered at run level 0, you can call the System Context API as the system is shutting down.  [Instance-shutdown-initd](https://github.com/TheJumpCloud/SystemContextAPI/blob/master/examples/instance-shutdown-initd) is an example of an init.d script that only runs at system shutdown.  After customizing the [instance-shutdown-initd](https://github.com/TheJumpCloud/SystemContextAPI/blob/master/examples/instance-shutdown-initd) script, you should install it on the system(s) running the JumpCloud agent.  1. Copy the modified [instance-shutdown-initd](https://github.com/TheJumpCloud/SystemContextAPI/blob/master/examples/instance-shutdown-initd) to `/etc/init.d/instance-shutdown`. 2. On Ubuntu systems, run `update-rc.d instance-shutdown defaults`. On RedHat/CentOS systems, run `chkconfig --add instance-shutdown`.  ## Third Party  ### Chef Cookbooks  [https://github.com/nshenry03/jumpcloud](https://github.com/nshenry03/jumpcloud)  [https://github.com/cjs226/jumpcloud](https://github.com/cjs226/jumpcloud)  # Multi-Tenant Portal Headers  Multi-Tenant Organization API Headers are available for JumpCloud Admins to use when making API requests from Organizations that have multiple managed organizations.  The `x-org-id` is a required header for all multi-tenant admins when making API requests to JumpCloud. This header will define to which organization you would like to make the request.  **NOTE** Single Tenant Admins do not need to provide this header when making an API request.  ## Header Value  `x-org-id`  ## API Response Codes  * `400` Malformed ID. * `400` x-org-id and Organization path ID do not match. * `401` ID not included for multi-tenant admin * `403` ID included on unsupported route. * `404` Organization ID Not Found.  ```bash curl -X GET https://console.jumpcloud.com/api/v2/directories \\   -H 'accept: application/json' \\   -H 'content-type: application/json' \\   -H 'x-api-key: {API_KEY}' \\   -H 'x-org-id: {ORG_ID}'  ```  ## To Obtain an Individual Organization ID via the UI  As a prerequisite, your Primary Organization will need to be setup for Multi-Tenancy. This provides access to the Multi-Tenant Organization Admin Portal.  1. Log into JumpCloud [Admin Console](https://console.jumpcloud.com). If you are a multi-tenant Admin, you will automatically be routed to the Multi-Tenant Admin Portal. 2. From the Multi-Tenant Portal's primary navigation bar, select the Organization you'd like to access. 3. You will automatically be routed to that Organization's Admin Console. 4. Go to Settings in the sub-tenant's primary navigation. 5. You can obtain your Organization ID below your Organization's Contact Information on the Settings page.  ## To Obtain All Organization IDs via the API  * You can make an API request to this endpoint using the API key of your Primary Organization.  `https://console.jumpcloud.com/api/organizations/` This will return all your managed organizations.  ```bash curl -X GET \\   https://console.jumpcloud.com/api/organizations/ \\   -H 'Accept: application/json' \\   -H 'Content-Type: application/json' \\   -H 'x-api-key: {API_KEY}' ```  # SDKs  You can find language specific SDKs that can help you kickstart your Integration with JumpCloud in the following GitHub repositories:  * [Python](https://github.com/TheJumpCloud/jcapi-python) * [Go](https://github.com/TheJumpCloud/jcapi-go) * [Ruby](https://github.com/TheJumpCloud/jcapi-ruby) * [Java](https://github.com/TheJumpCloud/jcapi-java) 

  For more information, please visit [https://support.jumpcloud.com/support/s/](https://support.jumpcloud.com/support/s/)

*Automatically generated by the [Swagger Codegen](https://github.com/swagger-api/swagger-codegen)*


## Requirements

Building the API client library requires:
1. Java 1.7+
2. Maven/Gradle

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```

Refer to the [OSSRH Guide](http://central.sonatype.org/pages/ossrh-guide.html) for more information.

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

```shell
mvn clean package
```

Then manually install the following JARs:

* `target/jcapi-java-client-1.0.0.jar`
* `target/lib/*.jar`

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
        ApiClient defaultClient = Configuration.getDefaultApiClient();

        // Configure API key authorization: x-api-key
        ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
        x-api-key.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //x-api-key.setApiKeyPrefix("Token");

        ActiveDirectoryApi apiInstance = new ActiveDirectoryApi();
        String activedirectoryId = "activedirectoryId_example"; // String | 
        String agentId = "agentId_example"; // String | 
        String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
        try {
            apiInstance.activedirectoriesAgentsDelete(activedirectoryId, agentId, xOrgId);
        } catch (ApiException e) {
            System.err.println("Exception when calling ActiveDirectoryApi#activedirectoriesAgentsDelete");
            e.printStackTrace();
        }
    }
}
import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.ActiveDirectoryApi;

import java.io.File;
import java.util.*;

public class ActiveDirectoryApiExample {

    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();

        // Configure API key authorization: x-api-key
        ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
        x-api-key.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //x-api-key.setApiKeyPrefix("Token");

        ActiveDirectoryApi apiInstance = new ActiveDirectoryApi();
        String activedirectoryId = "activedirectoryId_example"; // String | 
        String agentId = "agentId_example"; // String | 
        String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
        try {
            ActiveDirectoryAgentListOutput result = apiInstance.activedirectoriesAgentsGet(activedirectoryId, agentId, xOrgId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ActiveDirectoryApi#activedirectoriesAgentsGet");
            e.printStackTrace();
        }
    }
}
import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.ActiveDirectoryApi;

import java.io.File;
import java.util.*;

public class ActiveDirectoryApiExample {

    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();

        // Configure API key authorization: x-api-key
        ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
        x-api-key.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //x-api-key.setApiKeyPrefix("Token");

        ActiveDirectoryApi apiInstance = new ActiveDirectoryApi();
        String activedirectoryId = "activedirectoryId_example"; // String | 
        Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
        Integer skip = 0; // Integer | The offset into the records to return.
        List<String> sort = Arrays.asList("sort_example"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
        String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
        try {
            List<ActiveDirectoryAgentListOutput> result = apiInstance.activedirectoriesAgentsList(activedirectoryId, limit, skip, sort, xOrgId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ActiveDirectoryApi#activedirectoriesAgentsList");
            e.printStackTrace();
        }
    }
}
import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.ActiveDirectoryApi;

import java.io.File;
import java.util.*;

public class ActiveDirectoryApiExample {

    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();

        // Configure API key authorization: x-api-key
        ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
        x-api-key.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //x-api-key.setApiKeyPrefix("Token");

        ActiveDirectoryApi apiInstance = new ActiveDirectoryApi();
        String activedirectoryId = "activedirectoryId_example"; // String | 
        ActiveDirectoryAgentInput body = new ActiveDirectoryAgentInput(); // ActiveDirectoryAgentInput | 
        String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
        try {
            ActiveDirectoryAgentGetOutput result = apiInstance.activedirectoriesAgentsPost(activedirectoryId, body, xOrgId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ActiveDirectoryApi#activedirectoriesAgentsPost");
            e.printStackTrace();
        }
    }
}
import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.ActiveDirectoryApi;

import java.io.File;
import java.util.*;

public class ActiveDirectoryApiExample {

    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();

        // Configure API key authorization: x-api-key
        ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
        x-api-key.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //x-api-key.setApiKeyPrefix("Token");

        ActiveDirectoryApi apiInstance = new ActiveDirectoryApi();
        String id = "id_example"; // String | ObjectID of this Active Directory instance.
        String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
        try {
            ActiveDirectoryOutput result = apiInstance.activedirectoriesDelete(id, xOrgId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ActiveDirectoryApi#activedirectoriesDelete");
            e.printStackTrace();
        }
    }
}
import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.ActiveDirectoryApi;

import java.io.File;
import java.util.*;

public class ActiveDirectoryApiExample {

    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();

        // Configure API key authorization: x-api-key
        ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
        x-api-key.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //x-api-key.setApiKeyPrefix("Token");

        ActiveDirectoryApi apiInstance = new ActiveDirectoryApi();
        String id = "id_example"; // String | ObjectID of this Active Directory instance.
        String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
        try {
            ActiveDirectoryOutput result = apiInstance.activedirectoriesGet(id, xOrgId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ActiveDirectoryApi#activedirectoriesGet");
            e.printStackTrace();
        }
    }
}
import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.ActiveDirectoryApi;

import java.io.File;
import java.util.*;

public class ActiveDirectoryApiExample {

    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();

        // Configure API key authorization: x-api-key
        ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
        x-api-key.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //x-api-key.setApiKeyPrefix("Token");

        ActiveDirectoryApi apiInstance = new ActiveDirectoryApi();
        List<String> fields = Arrays.asList("fields_example"); // List<String> | The comma separated fields included in the returned records. If omitted, the default list of fields will be returned. 
        List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
        Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
        Integer skip = 0; // Integer | The offset into the records to return.
        List<String> sort = Arrays.asList("sort_example"); // List<String> | The comma separated fields used to sort the collection. Default sort is ascending, prefix with `-` to sort descending. 
        String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
        try {
            List<ActiveDirectoryOutput> result = apiInstance.activedirectoriesList(fields, filter, limit, skip, sort, xOrgId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ActiveDirectoryApi#activedirectoriesList");
            e.printStackTrace();
        }
    }
}
import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.ActiveDirectoryApi;

import java.io.File;
import java.util.*;

public class ActiveDirectoryApiExample {

    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();

        // Configure API key authorization: x-api-key
        ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
        x-api-key.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //x-api-key.setApiKeyPrefix("Token");

        ActiveDirectoryApi apiInstance = new ActiveDirectoryApi();
        ActiveDirectoryInput body = new ActiveDirectoryInput(); // ActiveDirectoryInput | 
        String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
        try {
            ActiveDirectoryOutput result = apiInstance.activedirectoriesPost(body, xOrgId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ActiveDirectoryApi#activedirectoriesPost");
            e.printStackTrace();
        }
    }
}
import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.ActiveDirectoryApi;

import java.io.File;
import java.util.*;

public class ActiveDirectoryApiExample {

    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();

        // Configure API key authorization: x-api-key
        ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
        x-api-key.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //x-api-key.setApiKeyPrefix("Token");

        ActiveDirectoryApi apiInstance = new ActiveDirectoryApi();
        String activedirectoryId = "activedirectoryId_example"; // String | 
        List<String> targets = Arrays.asList("targets_example"); // List<String> | Targets which a \"active_directory\" can be associated to.
        Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
        Integer skip = 0; // Integer | The offset into the records to return.
        String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
        try {
            List<GraphConnection> result = apiInstance.graphActiveDirectoryAssociationsList(activedirectoryId, targets, limit, skip, xOrgId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ActiveDirectoryApi#graphActiveDirectoryAssociationsList");
            e.printStackTrace();
        }
    }
}
import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.ActiveDirectoryApi;

import java.io.File;
import java.util.*;

public class ActiveDirectoryApiExample {

    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();

        // Configure API key authorization: x-api-key
        ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
        x-api-key.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //x-api-key.setApiKeyPrefix("Token");

        ActiveDirectoryApi apiInstance = new ActiveDirectoryApi();
        String activedirectoryId = "activedirectoryId_example"; // String | 
        GraphOperationActiveDirectory body = new GraphOperationActiveDirectory(); // GraphOperationActiveDirectory | 
        String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
        try {
            apiInstance.graphActiveDirectoryAssociationsPost(activedirectoryId, body, xOrgId);
        } catch (ApiException e) {
            System.err.println("Exception when calling ActiveDirectoryApi#graphActiveDirectoryAssociationsPost");
            e.printStackTrace();
        }
    }
}
import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.ActiveDirectoryApi;

import java.io.File;
import java.util.*;

public class ActiveDirectoryApiExample {

    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();

        // Configure API key authorization: x-api-key
        ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
        x-api-key.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //x-api-key.setApiKeyPrefix("Token");

        ActiveDirectoryApi apiInstance = new ActiveDirectoryApi();
        String activedirectoryId = "activedirectoryId_example"; // String | ObjectID of the Active Directory instance.
        List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
        Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
        String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
        Integer skip = 0; // Integer | The offset into the records to return.
        try {
            List<GraphObjectWithPaths> result = apiInstance.graphActiveDirectoryTraverseUser(activedirectoryId, filter, limit, xOrgId, skip);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ActiveDirectoryApi#graphActiveDirectoryTraverseUser");
            e.printStackTrace();
        }
    }
}
import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.ActiveDirectoryApi;

import java.io.File;
import java.util.*;

public class ActiveDirectoryApiExample {

    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();

        // Configure API key authorization: x-api-key
        ApiKeyAuth x-api-key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
        x-api-key.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //x-api-key.setApiKeyPrefix("Token");

        ActiveDirectoryApi apiInstance = new ActiveDirectoryApi();
        String activedirectoryId = "activedirectoryId_example"; // String | ObjectID of the Active Directory instance.
        Integer limit = 10; // Integer | The number of records to return at once. Limited to 100.
        String xOrgId = "xOrgId_example"; // String | Organization identifier that can be obtained from console settings.
        Integer skip = 0; // Integer | The offset into the records to return.
        List<String> filter = Arrays.asList("filter_example"); // List<String> | A filter to apply to the query.  **Filter structure**: `<field>:<operator>:<value>`.  **field** = Populate with a valid field from an endpoint response.  **operator** =  Supported operators are: eq, ne, gt, ge, lt, le, between, search, in. _Note: v1 operators differ from v2 operators._  **value** = Populate with the value you want to search for. Is case sensitive. Supports wild cards.  **EX:** `GET /api/v2/groups?filter=name:eq:Test+Group`
        try {
            List<GraphObjectWithPaths> result = apiInstance.graphActiveDirectoryTraverseUserGroup(activedirectoryId, limit, xOrgId, skip, filter);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ActiveDirectoryApi#graphActiveDirectoryTraverseUserGroup");
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
*ActiveDirectoryApi* | [**graphActiveDirectoryTraverseUser**](docs/ActiveDirectoryApi.md#graphActiveDirectoryTraverseUser) | **GET** /activedirectories/{activedirectory_id}/users | List the Users bound to an Active Directory instance
*ActiveDirectoryApi* | [**graphActiveDirectoryTraverseUserGroup**](docs/ActiveDirectoryApi.md#graphActiveDirectoryTraverseUserGroup) | **GET** /activedirectories/{activedirectory_id}/usergroups | List the User Groups bound to an Active Directory instance
*AdministratorsApi* | [**administratorOrganizationsCreateByAdministrator**](docs/AdministratorsApi.md#administratorOrganizationsCreateByAdministrator) | **POST** /administrators/{id}/organizationlinks | Allow Adminstrator access to an Organization.
*AdministratorsApi* | [**administratorOrganizationsListByAdministrator**](docs/AdministratorsApi.md#administratorOrganizationsListByAdministrator) | **GET** /administrators/{id}/organizationlinks | List the association links between an Administrator and Organizations.
*AdministratorsApi* | [**administratorOrganizationsListByOrganization**](docs/AdministratorsApi.md#administratorOrganizationsListByOrganization) | **GET** /organizations/{id}/administratorlinks | List the association links between an Organization and Administrators.
*AdministratorsApi* | [**administratorOrganizationsRemoveByAdministrator**](docs/AdministratorsApi.md#administratorOrganizationsRemoveByAdministrator) | **DELETE** /administrators/{administrator_id}/organizationlinks/{id} | Remove association between an Administrator and an Organization.
*AppleMdmApi* | [**applemdmsCsrget**](docs/AppleMdmApi.md#applemdmsCsrget) | **GET** /applemdms/{apple_mdm_id}/csr | Get Apple MDM CSR Plist
*AppleMdmApi* | [**applemdmsDelete**](docs/AppleMdmApi.md#applemdmsDelete) | **DELETE** /applemdms/{id} | Delete an Apple MDM
*AppleMdmApi* | [**applemdmsDeletedevice**](docs/AppleMdmApi.md#applemdmsDeletedevice) | **DELETE** /applemdms/{apple_mdm_id}/devices/{device_id} | Remove an Apple MDM Device&#x27;s Enrollment
*AppleMdmApi* | [**applemdmsDepkeyget**](docs/AppleMdmApi.md#applemdmsDepkeyget) | **GET** /applemdms/{apple_mdm_id}/depkey | Get Apple MDM DEP Public Key
*AppleMdmApi* | [**applemdmsDevicesClearActivationLock**](docs/AppleMdmApi.md#applemdmsDevicesClearActivationLock) | **POST** /applemdms/{apple_mdm_id}/devices/{device_id}/clearActivationLock | Clears the Activation Lock for a Device
*AppleMdmApi* | [**applemdmsDevicesRefreshActivationLockInformation**](docs/AppleMdmApi.md#applemdmsDevicesRefreshActivationLockInformation) | **POST** /applemdms/{apple_mdm_id}/devices/{device_id}/refreshActivationLockInformation | Refresh activation lock information for a device
*AppleMdmApi* | [**applemdmsDeviceserase**](docs/AppleMdmApi.md#applemdmsDeviceserase) | **POST** /applemdms/{apple_mdm_id}/devices/{device_id}/erase | Erase Device
*AppleMdmApi* | [**applemdmsDeviceslist**](docs/AppleMdmApi.md#applemdmsDeviceslist) | **GET** /applemdms/{apple_mdm_id}/devices | List AppleMDM Devices
*AppleMdmApi* | [**applemdmsDeviceslock**](docs/AppleMdmApi.md#applemdmsDeviceslock) | **POST** /applemdms/{apple_mdm_id}/devices/{device_id}/lock | Lock Device
*AppleMdmApi* | [**applemdmsDevicesrestart**](docs/AppleMdmApi.md#applemdmsDevicesrestart) | **POST** /applemdms/{apple_mdm_id}/devices/{device_id}/restart | Restart Device
*AppleMdmApi* | [**applemdmsDevicesshutdown**](docs/AppleMdmApi.md#applemdmsDevicesshutdown) | **POST** /applemdms/{apple_mdm_id}/devices/{device_id}/shutdown | Shut Down Device
*AppleMdmApi* | [**applemdmsEnrollmentprofilesget**](docs/AppleMdmApi.md#applemdmsEnrollmentprofilesget) | **GET** /applemdms/{apple_mdm_id}/enrollmentprofiles/{id} | Get an Apple MDM Enrollment Profile
*AppleMdmApi* | [**applemdmsEnrollmentprofileslist**](docs/AppleMdmApi.md#applemdmsEnrollmentprofileslist) | **GET** /applemdms/{apple_mdm_id}/enrollmentprofiles | List Apple MDM Enrollment Profiles
*AppleMdmApi* | [**applemdmsGetdevice**](docs/AppleMdmApi.md#applemdmsGetdevice) | **GET** /applemdms/{apple_mdm_id}/devices/{device_id} | Details of an AppleMDM Device
*AppleMdmApi* | [**applemdmsList**](docs/AppleMdmApi.md#applemdmsList) | **GET** /applemdms | List Apple MDMs
*AppleMdmApi* | [**applemdmsPut**](docs/AppleMdmApi.md#applemdmsPut) | **PUT** /applemdms/{id} | Update an Apple MDM
*AppleMdmApi* | [**applemdmsRefreshdepdevices**](docs/AppleMdmApi.md#applemdmsRefreshdepdevices) | **POST** /applemdms/{apple_mdm_id}/refreshdepdevices | Refresh DEP Devices
*ApplicationsApi* | [**applicationsDeleteLogo**](docs/ApplicationsApi.md#applicationsDeleteLogo) | **DELETE** /applications/{application_id}/logo | Delete application image
*ApplicationsApi* | [**applicationsGet**](docs/ApplicationsApi.md#applicationsGet) | **GET** /applications/{application_id} | Get an Application
*ApplicationsApi* | [**applicationsPostLogo**](docs/ApplicationsApi.md#applicationsPostLogo) | **POST** /applications/{application_id}/logo | 
*ApplicationsApi* | [**graphApplicationAssociationsList**](docs/ApplicationsApi.md#graphApplicationAssociationsList) | **GET** /applications/{application_id}/associations | List the associations of an Application
*ApplicationsApi* | [**graphApplicationAssociationsPost**](docs/ApplicationsApi.md#graphApplicationAssociationsPost) | **POST** /applications/{application_id}/associations | Manage the associations of an Application
*ApplicationsApi* | [**graphApplicationTraverseUser**](docs/ApplicationsApi.md#graphApplicationTraverseUser) | **GET** /applications/{application_id}/users | List the Users bound to an Application
*ApplicationsApi* | [**graphApplicationTraverseUserGroup**](docs/ApplicationsApi.md#graphApplicationTraverseUserGroup) | **GET** /applications/{application_id}/usergroups | List the User Groups bound to an Application
*ApplicationsApi* | [**importUsers**](docs/ApplicationsApi.md#importUsers) | **GET** /applications/{application_id}/import/users | Get a list of users to import from an Application IdM service provider
*AuthenticationPoliciesApi* | [**authnpoliciesDelete**](docs/AuthenticationPoliciesApi.md#authnpoliciesDelete) | **DELETE** /authn/policies/{id} | Delete Authentication Policy
*AuthenticationPoliciesApi* | [**authnpoliciesGet**](docs/AuthenticationPoliciesApi.md#authnpoliciesGet) | **GET** /authn/policies/{id} | Get an authentication policy
*AuthenticationPoliciesApi* | [**authnpoliciesList**](docs/AuthenticationPoliciesApi.md#authnpoliciesList) | **GET** /authn/policies | List Authentication Policies
*AuthenticationPoliciesApi* | [**authnpoliciesPatch**](docs/AuthenticationPoliciesApi.md#authnpoliciesPatch) | **PATCH** /authn/policies/{id} | Patch Authentication Policy
*AuthenticationPoliciesApi* | [**authnpoliciesPost**](docs/AuthenticationPoliciesApi.md#authnpoliciesPost) | **POST** /authn/policies | Create an Authentication Policy
*BulkJobRequestsApi* | [**bulkUserStatesCreate**](docs/BulkJobRequestsApi.md#bulkUserStatesCreate) | **POST** /bulk/userstates | Create Scheduled Userstate Job
*BulkJobRequestsApi* | [**bulkUserStatesDelete**](docs/BulkJobRequestsApi.md#bulkUserStatesDelete) | **DELETE** /bulk/userstates/{id} | Delete Scheduled Userstate Job
*BulkJobRequestsApi* | [**bulkUserStatesGetNextScheduled**](docs/BulkJobRequestsApi.md#bulkUserStatesGetNextScheduled) | **GET** /bulk/userstates/eventlist/next | Gets the next scheduled state change for each user in a list of system users
*BulkJobRequestsApi* | [**bulkUserStatesList**](docs/BulkJobRequestsApi.md#bulkUserStatesList) | **GET** /bulk/userstates | List Scheduled Userstate Change Jobs
*BulkJobRequestsApi* | [**bulkUsersCreate**](docs/BulkJobRequestsApi.md#bulkUsersCreate) | **POST** /bulk/users | Bulk Users Create
*BulkJobRequestsApi* | [**bulkUsersCreateResults**](docs/BulkJobRequestsApi.md#bulkUsersCreateResults) | **GET** /bulk/users/{job_id}/results | List Bulk Users Results
*BulkJobRequestsApi* | [**bulkUsersUpdate**](docs/BulkJobRequestsApi.md#bulkUsersUpdate) | **PATCH** /bulk/users | Bulk Users Update
*CommandResultsApi* | [**commandsListResultsByWorkflow**](docs/CommandResultsApi.md#commandsListResultsByWorkflow) | **GET** /commandresult/workflows | List all Command Results by Workflow
*CommandsApi* | [**commandsCancelQueuedCommandsByWorkflowInstanceId**](docs/CommandsApi.md#commandsCancelQueuedCommandsByWorkflowInstanceId) | **DELETE** /commandqueue/{workflow_instance_id} | Cancel all queued commands for an organization by workflow instance Id
*CommandsApi* | [**commandsGetQueuedCommandsByWorkflow**](docs/CommandsApi.md#commandsGetQueuedCommandsByWorkflow) | **GET** /queuedcommand/workflows | Fetch the queued Commands for an Organization
*CommandsApi* | [**graphCommandAssociationsList**](docs/CommandsApi.md#graphCommandAssociationsList) | **GET** /commands/{command_id}/associations | List the associations of a Command
*CommandsApi* | [**graphCommandAssociationsPost**](docs/CommandsApi.md#graphCommandAssociationsPost) | **POST** /commands/{command_id}/associations | Manage the associations of a Command
*CommandsApi* | [**graphCommandTraverseSystem**](docs/CommandsApi.md#graphCommandTraverseSystem) | **GET** /commands/{command_id}/systems | List the Systems bound to a Command
*CommandsApi* | [**graphCommandTraverseSystemGroup**](docs/CommandsApi.md#graphCommandTraverseSystemGroup) | **GET** /commands/{command_id}/systemgroups | List the System Groups bound to a Command
*CustomEmailsApi* | [**customEmailsCreate**](docs/CustomEmailsApi.md#customEmailsCreate) | **POST** /customemails | Create custom email configuration
*CustomEmailsApi* | [**customEmailsDestroy**](docs/CustomEmailsApi.md#customEmailsDestroy) | **DELETE** /customemails/{custom_email_type} | Delete custom email configuration
*CustomEmailsApi* | [**customEmailsGetTemplates**](docs/CustomEmailsApi.md#customEmailsGetTemplates) | **GET** /customemail/templates | List custom email templates
*CustomEmailsApi* | [**customEmailsRead**](docs/CustomEmailsApi.md#customEmailsRead) | **GET** /customemails/{custom_email_type} | Get custom email configuration
*CustomEmailsApi* | [**customEmailsUpdate**](docs/CustomEmailsApi.md#customEmailsUpdate) | **PUT** /customemails/{custom_email_type} | Update custom email configuration
*DirectoriesApi* | [**directoriesList**](docs/DirectoriesApi.md#directoriesList) | **GET** /directories | List All Directories
*DuoApi* | [**duoAccountDelete**](docs/DuoApi.md#duoAccountDelete) | **DELETE** /duo/accounts/{id} | Delete a Duo Account
*DuoApi* | [**duoAccountGet**](docs/DuoApi.md#duoAccountGet) | **GET** /duo/accounts/{id} | Get a Duo Acount
*DuoApi* | [**duoAccountList**](docs/DuoApi.md#duoAccountList) | **GET** /duo/accounts | List Duo Accounts
*DuoApi* | [**duoAccountPost**](docs/DuoApi.md#duoAccountPost) | **POST** /duo/accounts | Create Duo Account
*DuoApi* | [**duoApplicationDelete**](docs/DuoApi.md#duoApplicationDelete) | **DELETE** /duo/accounts/{account_id}/applications/{application_id} | Delete a Duo Application
*DuoApi* | [**duoApplicationGet**](docs/DuoApi.md#duoApplicationGet) | **GET** /duo/accounts/{account_id}/applications/{application_id} | Get a Duo application
*DuoApi* | [**duoApplicationList**](docs/DuoApi.md#duoApplicationList) | **GET** /duo/accounts/{account_id}/applications | List Duo Applications
*DuoApi* | [**duoApplicationPost**](docs/DuoApi.md#duoApplicationPost) | **POST** /duo/accounts/{account_id}/applications | Create Duo Application
*DuoApi* | [**duoApplicationUpdate**](docs/DuoApi.md#duoApplicationUpdate) | **PUT** /duo/accounts/{account_id}/applications/{application_id} | Update Duo Application
*FdeApi* | [**systemsGetFDEKey**](docs/FdeApi.md#systemsGetFDEKey) | **GET** /systems/{system_id}/fdekey | Get System FDE Key
*GSuiteApi* | [**graphGSuiteAssociationsList**](docs/GSuiteApi.md#graphGSuiteAssociationsList) | **GET** /gsuites/{gsuite_id}/associations | List the associations of a G Suite instance
*GSuiteApi* | [**graphGSuiteAssociationsPost**](docs/GSuiteApi.md#graphGSuiteAssociationsPost) | **POST** /gsuites/{gsuite_id}/associations | Manage the associations of a G Suite instance
*GSuiteApi* | [**graphGSuiteTraverseUser**](docs/GSuiteApi.md#graphGSuiteTraverseUser) | **GET** /gsuites/{gsuite_id}/users | List the Users bound to a G Suite instance
*GSuiteApi* | [**graphGSuiteTraverseUserGroup**](docs/GSuiteApi.md#graphGSuiteTraverseUserGroup) | **GET** /gsuites/{gsuite_id}/usergroups | List the User Groups bound to a G Suite instance
*GSuiteApi* | [**gsuitesGet**](docs/GSuiteApi.md#gsuitesGet) | **GET** /gsuites/{id} | Get G Suite
*GSuiteApi* | [**gsuitesListImportJumpcloudUsers**](docs/GSuiteApi.md#gsuitesListImportJumpcloudUsers) | **GET** /gsuites/{gsuite_id}/import/jumpcloudusers | Get a list of users in Jumpcloud format to import from a Google Workspace account.
*GSuiteApi* | [**gsuitesListImportUsers**](docs/GSuiteApi.md#gsuitesListImportUsers) | **GET** /gsuites/{gsuite_id}/import/users | Get a list of users to import from a G Suite instance
*GSuiteApi* | [**gsuitesPatch**](docs/GSuiteApi.md#gsuitesPatch) | **PATCH** /gsuites/{id} | Update existing G Suite
*GSuiteApi* | [**translationRulesGSuiteDelete**](docs/GSuiteApi.md#translationRulesGSuiteDelete) | **DELETE** /gsuites/{gsuite_id}/translationrules/{id} | Deletes a G Suite translation rule
*GSuiteApi* | [**translationRulesGSuiteGet**](docs/GSuiteApi.md#translationRulesGSuiteGet) | **GET** /gsuites/{gsuite_id}/translationrules/{id} | Gets a specific G Suite translation rule
*GSuiteApi* | [**translationRulesGSuiteList**](docs/GSuiteApi.md#translationRulesGSuiteList) | **GET** /gsuites/{gsuite_id}/translationrules | List all the G Suite Translation Rules
*GSuiteApi* | [**translationRulesGSuitePost**](docs/GSuiteApi.md#translationRulesGSuitePost) | **POST** /gsuites/{gsuite_id}/translationrules | Create a new G Suite Translation Rule
*GSuiteImportApi* | [**gsuitesListImportJumpcloudUsers**](docs/GSuiteImportApi.md#gsuitesListImportJumpcloudUsers) | **GET** /gsuites/{gsuite_id}/import/jumpcloudusers | Get a list of users in Jumpcloud format to import from a Google Workspace account.
*GSuiteImportApi* | [**gsuitesListImportUsers**](docs/GSuiteImportApi.md#gsuitesListImportUsers) | **GET** /gsuites/{gsuite_id}/import/users | Get a list of users to import from a G Suite instance
*GraphApi* | [**graphActiveDirectoryAssociationsList**](docs/GraphApi.md#graphActiveDirectoryAssociationsList) | **GET** /activedirectories/{activedirectory_id}/associations | List the associations of an Active Directory instance
*GraphApi* | [**graphActiveDirectoryAssociationsPost**](docs/GraphApi.md#graphActiveDirectoryAssociationsPost) | **POST** /activedirectories/{activedirectory_id}/associations | Manage the associations of an Active Directory instance
*GraphApi* | [**graphActiveDirectoryTraverseUser**](docs/GraphApi.md#graphActiveDirectoryTraverseUser) | **GET** /activedirectories/{activedirectory_id}/users | List the Users bound to an Active Directory instance
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
*GraphApi* | [**graphPolicyGroupAssociationsList**](docs/GraphApi.md#graphPolicyGroupAssociationsList) | **GET** /policygroups/{group_id}/associations | List the associations of a Policy Group.
*GraphApi* | [**graphPolicyGroupAssociationsPost**](docs/GraphApi.md#graphPolicyGroupAssociationsPost) | **POST** /policygroups/{group_id}/associations | Manage the associations of a Policy Group
*GraphApi* | [**graphPolicyGroupMembersList**](docs/GraphApi.md#graphPolicyGroupMembersList) | **GET** /policygroups/{group_id}/members | List the members of a Policy Group
*GraphApi* | [**graphPolicyGroupMembersPost**](docs/GraphApi.md#graphPolicyGroupMembersPost) | **POST** /policygroups/{group_id}/members | Manage the members of a Policy Group
*GraphApi* | [**graphPolicyGroupMembership**](docs/GraphApi.md#graphPolicyGroupMembership) | **GET** /policygroups/{group_id}/membership | List the Policy Group&#x27;s membership
*GraphApi* | [**graphPolicyGroupTraverseSystem**](docs/GraphApi.md#graphPolicyGroupTraverseSystem) | **GET** /policygroups/{group_id}/systems | List the Systems bound to a Policy Group
*GraphApi* | [**graphPolicyGroupTraverseSystemGroup**](docs/GraphApi.md#graphPolicyGroupTraverseSystemGroup) | **GET** /policygroups/{group_id}/systemgroups | List the System Groups bound to Policy Groups
*GraphApi* | [**graphPolicyMemberOf**](docs/GraphApi.md#graphPolicyMemberOf) | **GET** /policies/{policy_id}/memberof | List the parent Groups of a Policy
*GraphApi* | [**graphPolicyTraverseSystem**](docs/GraphApi.md#graphPolicyTraverseSystem) | **GET** /policies/{policy_id}/systems | List the Systems bound to a Policy
*GraphApi* | [**graphPolicyTraverseSystemGroup**](docs/GraphApi.md#graphPolicyTraverseSystemGroup) | **GET** /policies/{policy_id}/systemgroups | List the System Groups bound to a Policy
*GraphApi* | [**graphRadiusServerAssociationsList**](docs/GraphApi.md#graphRadiusServerAssociationsList) | **GET** /radiusservers/{radiusserver_id}/associations | List the associations of a RADIUS  Server
*GraphApi* | [**graphRadiusServerAssociationsPost**](docs/GraphApi.md#graphRadiusServerAssociationsPost) | **POST** /radiusservers/{radiusserver_id}/associations | Manage the associations of a RADIUS Server
*GraphApi* | [**graphRadiusServerTraverseUser**](docs/GraphApi.md#graphRadiusServerTraverseUser) | **GET** /radiusservers/{radiusserver_id}/users | List the Users bound to a RADIUS  Server
*GraphApi* | [**graphRadiusServerTraverseUserGroup**](docs/GraphApi.md#graphRadiusServerTraverseUserGroup) | **GET** /radiusservers/{radiusserver_id}/usergroups | List the User Groups bound to a RADIUS  Server
*GraphApi* | [**graphSoftwareappsAssociationsList**](docs/GraphApi.md#graphSoftwareappsAssociationsList) | **GET** /softwareapps/{software_app_id}/associations | List the associations of a Software Application
*GraphApi* | [**graphSoftwareappsAssociationsPost**](docs/GraphApi.md#graphSoftwareappsAssociationsPost) | **POST** /softwareapps/{software_app_id}/associations | Manage the associations of a software application.
*GraphApi* | [**graphSoftwareappsTraverseSystem**](docs/GraphApi.md#graphSoftwareappsTraverseSystem) | **GET** /softwareapps/{software_app_id}/systems | List the Systems bound to a Software App.
*GraphApi* | [**graphSoftwareappsTraverseSystemGroup**](docs/GraphApi.md#graphSoftwareappsTraverseSystemGroup) | **GET** /softwareapps/{software_app_id}/systemgroups | List the System Groups bound to a Software App.
*GraphApi* | [**graphSystemAssociationsList**](docs/GraphApi.md#graphSystemAssociationsList) | **GET** /systems/{system_id}/associations | List the associations of a System
*GraphApi* | [**graphSystemAssociationsPost**](docs/GraphApi.md#graphSystemAssociationsPost) | **POST** /systems/{system_id}/associations | Manage associations of a System
*GraphApi* | [**graphSystemGroupAssociationsList**](docs/GraphApi.md#graphSystemGroupAssociationsList) | **GET** /systemgroups/{group_id}/associations | List the associations of a System Group
*GraphApi* | [**graphSystemGroupAssociationsPost**](docs/GraphApi.md#graphSystemGroupAssociationsPost) | **POST** /systemgroups/{group_id}/associations | Manage the associations of a System Group
*GraphApi* | [**graphSystemGroupMembersList**](docs/GraphApi.md#graphSystemGroupMembersList) | **GET** /systemgroups/{group_id}/members | List the members of a System Group
*GraphApi* | [**graphSystemGroupMembersPost**](docs/GraphApi.md#graphSystemGroupMembersPost) | **POST** /systemgroups/{group_id}/members | Manage the members of a System Group
*GraphApi* | [**graphSystemGroupMembership**](docs/GraphApi.md#graphSystemGroupMembership) | **GET** /systemgroups/{group_id}/membership | List the System Group&#x27;s membership
*GraphApi* | [**graphSystemGroupTraverseCommand**](docs/GraphApi.md#graphSystemGroupTraverseCommand) | **GET** /systemgroups/{group_id}/commands | List the Commands bound to a System Group
*GraphApi* | [**graphSystemGroupTraversePolicy**](docs/GraphApi.md#graphSystemGroupTraversePolicy) | **GET** /systemgroups/{group_id}/policies | List the Policies bound to a System Group
*GraphApi* | [**graphSystemGroupTraversePolicyGroup**](docs/GraphApi.md#graphSystemGroupTraversePolicyGroup) | **GET** /systemgroups/{group_id}/policygroups | List the Policy Groups bound to a System Group
*GraphApi* | [**graphSystemGroupTraverseUser**](docs/GraphApi.md#graphSystemGroupTraverseUser) | **GET** /systemgroups/{group_id}/users | List the Users bound to a System Group
*GraphApi* | [**graphSystemGroupTraverseUserGroup**](docs/GraphApi.md#graphSystemGroupTraverseUserGroup) | **GET** /systemgroups/{group_id}/usergroups | List the User Groups bound to a System Group
*GraphApi* | [**graphSystemMemberOf**](docs/GraphApi.md#graphSystemMemberOf) | **GET** /systems/{system_id}/memberof | List the parent Groups of a System
*GraphApi* | [**graphSystemTraverseCommand**](docs/GraphApi.md#graphSystemTraverseCommand) | **GET** /systems/{system_id}/commands | List the Commands bound to a System
*GraphApi* | [**graphSystemTraversePolicy**](docs/GraphApi.md#graphSystemTraversePolicy) | **GET** /systems/{system_id}/policies | List the Policies bound to a System
*GraphApi* | [**graphSystemTraversePolicyGroup**](docs/GraphApi.md#graphSystemTraversePolicyGroup) | **GET** /systems/{system_id}/policygroups | List the Policy Groups bound to a System
*GraphApi* | [**graphSystemTraverseUser**](docs/GraphApi.md#graphSystemTraverseUser) | **GET** /systems/{system_id}/users | List the Users bound to a System
*GraphApi* | [**graphSystemTraverseUserGroup**](docs/GraphApi.md#graphSystemTraverseUserGroup) | **GET** /systems/{system_id}/usergroups | List the User Groups bound to a System
*GraphApi* | [**graphUserAssociationsList**](docs/GraphApi.md#graphUserAssociationsList) | **GET** /users/{user_id}/associations | List the associations of a User
*GraphApi* | [**graphUserAssociationsPost**](docs/GraphApi.md#graphUserAssociationsPost) | **POST** /users/{user_id}/associations | Manage the associations of a User
*GraphApi* | [**graphUserGroupAssociationsList**](docs/GraphApi.md#graphUserGroupAssociationsList) | **GET** /usergroups/{group_id}/associations | List the associations of a User Group.
*GraphApi* | [**graphUserGroupAssociationsPost**](docs/GraphApi.md#graphUserGroupAssociationsPost) | **POST** /usergroups/{group_id}/associations | Manage the associations of a User Group
*GraphApi* | [**graphUserGroupMembersList**](docs/GraphApi.md#graphUserGroupMembersList) | **GET** /usergroups/{group_id}/members | List the members of a User Group
*GraphApi* | [**graphUserGroupMembersPost**](docs/GraphApi.md#graphUserGroupMembersPost) | **POST** /usergroups/{group_id}/members | Manage the members of a User Group
*GraphApi* | [**graphUserGroupMembership**](docs/GraphApi.md#graphUserGroupMembership) | **GET** /usergroups/{group_id}/membership | List the User Group&#x27;s membership
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
*GraphApi* | [**graphUserTraverseActiveDirectory**](docs/GraphApi.md#graphUserTraverseActiveDirectory) | **GET** /users/{user_id}/activedirectories | List the Active Directory instances bound to a User
*GraphApi* | [**graphUserTraverseApplication**](docs/GraphApi.md#graphUserTraverseApplication) | **GET** /users/{user_id}/applications | List the Applications bound to a User
*GraphApi* | [**graphUserTraverseDirectory**](docs/GraphApi.md#graphUserTraverseDirectory) | **GET** /users/{user_id}/directories | List the Directories bound to a User
*GraphApi* | [**graphUserTraverseGSuite**](docs/GraphApi.md#graphUserTraverseGSuite) | **GET** /users/{user_id}/gsuites | List the G Suite instances bound to a User
*GraphApi* | [**graphUserTraverseLdapServer**](docs/GraphApi.md#graphUserTraverseLdapServer) | **GET** /users/{user_id}/ldapservers | List the LDAP servers bound to a User
*GraphApi* | [**graphUserTraverseOffice365**](docs/GraphApi.md#graphUserTraverseOffice365) | **GET** /users/{user_id}/office365s | List the Office 365 instances bound to a User
*GraphApi* | [**graphUserTraverseRadiusServer**](docs/GraphApi.md#graphUserTraverseRadiusServer) | **GET** /users/{user_id}/radiusservers | List the RADIUS Servers bound to a User
*GraphApi* | [**graphUserTraverseSystem**](docs/GraphApi.md#graphUserTraverseSystem) | **GET** /users/{user_id}/systems | List the Systems bound to a User
*GraphApi* | [**graphUserTraverseSystemGroup**](docs/GraphApi.md#graphUserTraverseSystemGroup) | **GET** /users/{user_id}/systemgroups | List the System Groups bound to a User
*GraphApi* | [**policystatusesSystemsList**](docs/GraphApi.md#policystatusesSystemsList) | **GET** /systems/{system_id}/policystatuses | List the policy statuses for a system
*GroupsApi* | [**groupsList**](docs/GroupsApi.md#groupsList) | **GET** /groups | List All Groups
*ImageApi* | [**applicationsDeleteLogo**](docs/ImageApi.md#applicationsDeleteLogo) | **DELETE** /applications/{application_id}/logo | Delete application image
*IpListsApi* | [**iplistsDelete**](docs/IpListsApi.md#iplistsDelete) | **DELETE** /iplists/{id} | Delete an IP list
*IpListsApi* | [**iplistsGet**](docs/IpListsApi.md#iplistsGet) | **GET** /iplists/{id} | Get an IP list
*IpListsApi* | [**iplistsList**](docs/IpListsApi.md#iplistsList) | **GET** /iplists | List IP Lists
*IpListsApi* | [**iplistsPatch**](docs/IpListsApi.md#iplistsPatch) | **PATCH** /iplists/{id} | Update an IP list
*IpListsApi* | [**iplistsPost**](docs/IpListsApi.md#iplistsPost) | **POST** /iplists | Create IP List
*IpListsApi* | [**iplistsPut**](docs/IpListsApi.md#iplistsPut) | **PUT** /iplists/{id} | Replace an IP list
*LdapServersApi* | [**graphLdapServerAssociationsList**](docs/LdapServersApi.md#graphLdapServerAssociationsList) | **GET** /ldapservers/{ldapserver_id}/associations | List the associations of a LDAP Server
*LdapServersApi* | [**graphLdapServerAssociationsPost**](docs/LdapServersApi.md#graphLdapServerAssociationsPost) | **POST** /ldapservers/{ldapserver_id}/associations | Manage the associations of a LDAP Server
*LdapServersApi* | [**graphLdapServerTraverseUser**](docs/LdapServersApi.md#graphLdapServerTraverseUser) | **GET** /ldapservers/{ldapserver_id}/users | List the Users bound to a LDAP Server
*LdapServersApi* | [**graphLdapServerTraverseUserGroup**](docs/LdapServersApi.md#graphLdapServerTraverseUserGroup) | **GET** /ldapservers/{ldapserver_id}/usergroups | List the User Groups bound to a LDAP Server
*LdapServersApi* | [**ldapserversGet**](docs/LdapServersApi.md#ldapserversGet) | **GET** /ldapservers/{id} | Get LDAP Server
*LdapServersApi* | [**ldapserversList**](docs/LdapServersApi.md#ldapserversList) | **GET** /ldapservers | List LDAP Servers
*LdapServersApi* | [**ldapserversPatch**](docs/LdapServersApi.md#ldapserversPatch) | **PATCH** /ldapservers/{id} | Update existing LDAP server
*LogosApi* | [**logosGet**](docs/LogosApi.md#logosGet) | **GET** /logos/{id} | Get the logo associated with the specified id
*ManagedServiceProviderApi* | [**administratorOrganizationsCreateByAdministrator**](docs/ManagedServiceProviderApi.md#administratorOrganizationsCreateByAdministrator) | **POST** /administrators/{id}/organizationlinks | Allow Adminstrator access to an Organization.
*ManagedServiceProviderApi* | [**administratorOrganizationsListByAdministrator**](docs/ManagedServiceProviderApi.md#administratorOrganizationsListByAdministrator) | **GET** /administrators/{id}/organizationlinks | List the association links between an Administrator and Organizations.
*ManagedServiceProviderApi* | [**administratorOrganizationsListByOrganization**](docs/ManagedServiceProviderApi.md#administratorOrganizationsListByOrganization) | **GET** /organizations/{id}/administratorlinks | List the association links between an Organization and Administrators.
*ManagedServiceProviderApi* | [**administratorOrganizationsRemoveByAdministrator**](docs/ManagedServiceProviderApi.md#administratorOrganizationsRemoveByAdministrator) | **DELETE** /administrators/{administrator_id}/organizationlinks/{id} | Remove association between an Administrator and an Organization.
*ManagedServiceProviderApi* | [**providerOrganizationsUpdateOrg**](docs/ManagedServiceProviderApi.md#providerOrganizationsUpdateOrg) | **PUT** /providers/{provider_id}/organizations/{id} | Update Provider Organization
*ManagedServiceProviderApi* | [**providersGetProvider**](docs/ManagedServiceProviderApi.md#providersGetProvider) | **GET** /providers/{provider_id} | Retrieve Provider
*ManagedServiceProviderApi* | [**providersListAdministrators**](docs/ManagedServiceProviderApi.md#providersListAdministrators) | **GET** /providers/{provider_id}/administrators | List Provider Administrators
*ManagedServiceProviderApi* | [**providersListOrganizations**](docs/ManagedServiceProviderApi.md#providersListOrganizations) | **GET** /providers/{provider_id}/organizations | List Provider Organizations
*ManagedServiceProviderApi* | [**providersPostAdmins**](docs/ManagedServiceProviderApi.md#providersPostAdmins) | **POST** /providers/{provider_id}/administrators | Create a new Provider Administrator
*ManagedServiceProviderApi* | [**providersRetrieveInvoice**](docs/ManagedServiceProviderApi.md#providersRetrieveInvoice) | **GET** /providers/{provider_id}/invoices/{ID} | Download a provider&#x27;s invoice.
*ManagedServiceProviderApi* | [**providersRetrieveInvoices**](docs/ManagedServiceProviderApi.md#providersRetrieveInvoices) | **GET** /providers/{provider_id}/invoices | List a provider&#x27;s invoices.
*Office365Api* | [**graphOffice365AssociationsList**](docs/Office365Api.md#graphOffice365AssociationsList) | **GET** /office365s/{office365_id}/associations | List the associations of an Office 365 instance
*Office365Api* | [**graphOffice365AssociationsPost**](docs/Office365Api.md#graphOffice365AssociationsPost) | **POST** /office365s/{office365_id}/associations | Manage the associations of an Office 365 instance
*Office365Api* | [**graphOffice365TraverseUser**](docs/Office365Api.md#graphOffice365TraverseUser) | **GET** /office365s/{office365_id}/users | List the Users bound to an Office 365 instance
*Office365Api* | [**graphOffice365TraverseUserGroup**](docs/Office365Api.md#graphOffice365TraverseUserGroup) | **GET** /office365s/{office365_id}/usergroups | List the User Groups bound to an Office 365 instance
*Office365Api* | [**office365sGet**](docs/Office365Api.md#office365sGet) | **GET** /office365s/{office365_id} | Get Office 365 instance
*Office365Api* | [**office365sListImportUsers**](docs/Office365Api.md#office365sListImportUsers) | **GET** /office365s/{office365_id}/import/users | Get a list of users to import from an Office 365 instance
*Office365Api* | [**office365sPatch**](docs/Office365Api.md#office365sPatch) | **PATCH** /office365s/{office365_id} | Update existing Office 365 instance.
*Office365Api* | [**translationRulesOffice365Delete**](docs/Office365Api.md#translationRulesOffice365Delete) | **DELETE** /office365s/{office365_id}/translationrules/{id} | Deletes a Office 365 translation rule
*Office365Api* | [**translationRulesOffice365Get**](docs/Office365Api.md#translationRulesOffice365Get) | **GET** /office365s/{office365_id}/translationrules/{id} | Gets a specific Office 365 translation rule
*Office365Api* | [**translationRulesOffice365List**](docs/Office365Api.md#translationRulesOffice365List) | **GET** /office365s/{office365_id}/translationrules | List all the Office 365 Translation Rules
*Office365Api* | [**translationRulesOffice365Post**](docs/Office365Api.md#translationRulesOffice365Post) | **POST** /office365s/{office365_id}/translationrules | Create a new Office 365 Translation Rule
*Office365ImportApi* | [**office365sListImportUsers**](docs/Office365ImportApi.md#office365sListImportUsers) | **GET** /office365s/{office365_id}/import/users | Get a list of users to import from an Office 365 instance
*OrganizationsApi* | [**administratorOrganizationsCreateByAdministrator**](docs/OrganizationsApi.md#administratorOrganizationsCreateByAdministrator) | **POST** /administrators/{id}/organizationlinks | Allow Adminstrator access to an Organization.
*OrganizationsApi* | [**administratorOrganizationsListByAdministrator**](docs/OrganizationsApi.md#administratorOrganizationsListByAdministrator) | **GET** /administrators/{id}/organizationlinks | List the association links between an Administrator and Organizations.
*OrganizationsApi* | [**administratorOrganizationsListByOrganization**](docs/OrganizationsApi.md#administratorOrganizationsListByOrganization) | **GET** /organizations/{id}/administratorlinks | List the association links between an Organization and Administrators.
*OrganizationsApi* | [**administratorOrganizationsRemoveByAdministrator**](docs/OrganizationsApi.md#administratorOrganizationsRemoveByAdministrator) | **DELETE** /administrators/{administrator_id}/organizationlinks/{id} | Remove association between an Administrator and an Organization.
*OrganizationsApi* | [**organizationsListCases**](docs/OrganizationsApi.md#organizationsListCases) | **GET** /organizations/cases | Get all cases (Support/Feature requests) for organization
*PoliciesApi* | [**graphPolicyAssociationsList**](docs/PoliciesApi.md#graphPolicyAssociationsList) | **GET** /policies/{policy_id}/associations | List the associations of a Policy
*PoliciesApi* | [**graphPolicyAssociationsPost**](docs/PoliciesApi.md#graphPolicyAssociationsPost) | **POST** /policies/{policy_id}/associations | Manage the associations of a Policy
*PoliciesApi* | [**graphPolicyMemberOf**](docs/PoliciesApi.md#graphPolicyMemberOf) | **GET** /policies/{policy_id}/memberof | List the parent Groups of a Policy
*PoliciesApi* | [**graphPolicyTraverseSystem**](docs/PoliciesApi.md#graphPolicyTraverseSystem) | **GET** /policies/{policy_id}/systems | List the Systems bound to a Policy
*PoliciesApi* | [**graphPolicyTraverseSystemGroup**](docs/PoliciesApi.md#graphPolicyTraverseSystemGroup) | **GET** /policies/{policy_id}/systemgroups | List the System Groups bound to a Policy
*PoliciesApi* | [**policiesDelete**](docs/PoliciesApi.md#policiesDelete) | **DELETE** /policies/{id} | Deletes a Policy
*PoliciesApi* | [**policiesGet**](docs/PoliciesApi.md#policiesGet) | **GET** /policies/{id} | Gets a specific Policy.
*PoliciesApi* | [**policiesList**](docs/PoliciesApi.md#policiesList) | **GET** /policies | Lists all the Policies
*PoliciesApi* | [**policiesPost**](docs/PoliciesApi.md#policiesPost) | **POST** /policies | Create a new Policy
*PoliciesApi* | [**policiesPut**](docs/PoliciesApi.md#policiesPut) | **PUT** /policies/{id} | Update an existing Policy
*PoliciesApi* | [**policyresultsGet**](docs/PoliciesApi.md#policyresultsGet) | **GET** /policyresults/{id} | Get a specific Policy Result.
*PoliciesApi* | [**policyresultsList**](docs/PoliciesApi.md#policyresultsList) | **GET** /policies/{policy_id}/policyresults | Lists all the policy results of a policy.
*PoliciesApi* | [**policyresultsOrgList**](docs/PoliciesApi.md#policyresultsOrgList) | **GET** /policyresults | Lists all of the policy results for an organization.
*PoliciesApi* | [**policystatusesPoliciesList**](docs/PoliciesApi.md#policystatusesPoliciesList) | **GET** /policies/{policy_id}/policystatuses | Lists the latest policy results of a policy.
*PoliciesApi* | [**policystatusesSystemsList**](docs/PoliciesApi.md#policystatusesSystemsList) | **GET** /systems/{system_id}/policystatuses | List the policy statuses for a system
*PoliciesApi* | [**policytemplatesGet**](docs/PoliciesApi.md#policytemplatesGet) | **GET** /policytemplates/{id} | Get a specific Policy Template
*PoliciesApi* | [**policytemplatesList**](docs/PoliciesApi.md#policytemplatesList) | **GET** /policytemplates | Lists all of the Policy Templates
*PolicyGroupAssociationsApi* | [**graphPolicyGroupAssociationsList**](docs/PolicyGroupAssociationsApi.md#graphPolicyGroupAssociationsList) | **GET** /policygroups/{group_id}/associations | List the associations of a Policy Group.
*PolicyGroupAssociationsApi* | [**graphPolicyGroupAssociationsPost**](docs/PolicyGroupAssociationsApi.md#graphPolicyGroupAssociationsPost) | **POST** /policygroups/{group_id}/associations | Manage the associations of a Policy Group
*PolicyGroupAssociationsApi* | [**graphPolicyGroupTraverseSystem**](docs/PolicyGroupAssociationsApi.md#graphPolicyGroupTraverseSystem) | **GET** /policygroups/{group_id}/systems | List the Systems bound to a Policy Group
*PolicyGroupAssociationsApi* | [**graphPolicyGroupTraverseSystemGroup**](docs/PolicyGroupAssociationsApi.md#graphPolicyGroupTraverseSystemGroup) | **GET** /policygroups/{group_id}/systemgroups | List the System Groups bound to Policy Groups
*PolicyGroupMembersMembershipApi* | [**graphPolicyGroupMembersList**](docs/PolicyGroupMembersMembershipApi.md#graphPolicyGroupMembersList) | **GET** /policygroups/{group_id}/members | List the members of a Policy Group
*PolicyGroupMembersMembershipApi* | [**graphPolicyGroupMembersPost**](docs/PolicyGroupMembersMembershipApi.md#graphPolicyGroupMembersPost) | **POST** /policygroups/{group_id}/members | Manage the members of a Policy Group
*PolicyGroupMembersMembershipApi* | [**graphPolicyGroupMembership**](docs/PolicyGroupMembersMembershipApi.md#graphPolicyGroupMembership) | **GET** /policygroups/{group_id}/membership | List the Policy Group&#x27;s membership
*PolicyGroupsApi* | [**graphPolicyGroupAssociationsList**](docs/PolicyGroupsApi.md#graphPolicyGroupAssociationsList) | **GET** /policygroups/{group_id}/associations | List the associations of a Policy Group.
*PolicyGroupsApi* | [**graphPolicyGroupAssociationsPost**](docs/PolicyGroupsApi.md#graphPolicyGroupAssociationsPost) | **POST** /policygroups/{group_id}/associations | Manage the associations of a Policy Group
*PolicyGroupsApi* | [**graphPolicyGroupMembersList**](docs/PolicyGroupsApi.md#graphPolicyGroupMembersList) | **GET** /policygroups/{group_id}/members | List the members of a Policy Group
*PolicyGroupsApi* | [**graphPolicyGroupMembersPost**](docs/PolicyGroupsApi.md#graphPolicyGroupMembersPost) | **POST** /policygroups/{group_id}/members | Manage the members of a Policy Group
*PolicyGroupsApi* | [**graphPolicyGroupMembership**](docs/PolicyGroupsApi.md#graphPolicyGroupMembership) | **GET** /policygroups/{group_id}/membership | List the Policy Group&#x27;s membership
*PolicyGroupsApi* | [**graphPolicyGroupTraverseSystem**](docs/PolicyGroupsApi.md#graphPolicyGroupTraverseSystem) | **GET** /policygroups/{group_id}/systems | List the Systems bound to a Policy Group
*PolicyGroupsApi* | [**graphPolicyGroupTraverseSystemGroup**](docs/PolicyGroupsApi.md#graphPolicyGroupTraverseSystemGroup) | **GET** /policygroups/{group_id}/systemgroups | List the System Groups bound to Policy Groups
*PolicyGroupsApi* | [**groupsPolicyDelete**](docs/PolicyGroupsApi.md#groupsPolicyDelete) | **DELETE** /policygroups/{id} | Delete a Policy Group
*PolicyGroupsApi* | [**groupsPolicyGet**](docs/PolicyGroupsApi.md#groupsPolicyGet) | **GET** /policygroups/{id} | View an individual Policy Group details
*PolicyGroupsApi* | [**groupsPolicyList**](docs/PolicyGroupsApi.md#groupsPolicyList) | **GET** /policygroups | List all Policy Groups
*PolicyGroupsApi* | [**groupsPolicyPost**](docs/PolicyGroupsApi.md#groupsPolicyPost) | **POST** /policygroups | Create a new Policy Group
*PolicyGroupsApi* | [**groupsPolicyPut**](docs/PolicyGroupsApi.md#groupsPolicyPut) | **PUT** /policygroups/{id} | Update a Policy Group
*PolicytemplatesApi* | [**policytemplatesGet**](docs/PolicytemplatesApi.md#policytemplatesGet) | **GET** /policytemplates/{id} | Get a specific Policy Template
*PolicytemplatesApi* | [**policytemplatesList**](docs/PolicytemplatesApi.md#policytemplatesList) | **GET** /policytemplates | Lists all of the Policy Templates
*ProvidersApi* | [**autotaskCreateConfiguration**](docs/ProvidersApi.md#autotaskCreateConfiguration) | **POST** /providers/{provider_id}/integrations/autotask | Creates a new Autotask integration for the provider
*ProvidersApi* | [**autotaskDeleteConfiguration**](docs/ProvidersApi.md#autotaskDeleteConfiguration) | **DELETE** /integrations/autotask/{UUID} | Delete Autotask Integration
*ProvidersApi* | [**autotaskGetConfiguration**](docs/ProvidersApi.md#autotaskGetConfiguration) | **GET** /integrations/autotask/{UUID} | Retrieve Autotask Integration Configuration
*ProvidersApi* | [**autotaskPatchMappings**](docs/ProvidersApi.md#autotaskPatchMappings) | **PATCH** /integrations/autotask/{UUID}/mappings | Create, edit, and/or delete Autotask Mappings
*ProvidersApi* | [**autotaskPatchSettings**](docs/ProvidersApi.md#autotaskPatchSettings) | **PATCH** /integrations/autotask/{UUID}/settings | Create, edit, and/or delete Autotask Integration settings
*ProvidersApi* | [**autotaskRetrieveAllAlertConfigurationOptions**](docs/ProvidersApi.md#autotaskRetrieveAllAlertConfigurationOptions) | **GET** /providers/{provider_id}/integrations/autotask/alerts/configuration/options | Get all Autotask ticketing alert configuration options for a provider
*ProvidersApi* | [**autotaskRetrieveAllAlertConfigurations**](docs/ProvidersApi.md#autotaskRetrieveAllAlertConfigurations) | **GET** /providers/{provider_id}/integrations/autotask/alerts/configuration | Get all Autotask ticketing alert configurations for a provider
*ProvidersApi* | [**autotaskRetrieveCompanies**](docs/ProvidersApi.md#autotaskRetrieveCompanies) | **GET** /integrations/autotask/{UUID}/companies | Retrieve Autotask Companies
*ProvidersApi* | [**autotaskRetrieveCompanyTypes**](docs/ProvidersApi.md#autotaskRetrieveCompanyTypes) | **GET** /integrations/autotask/{UUID}/companytypes | Retrieve Autotask Company Types
*ProvidersApi* | [**autotaskRetrieveContracts**](docs/ProvidersApi.md#autotaskRetrieveContracts) | **GET** /integrations/autotask/{UUID}/contracts | Retrieve Autotask Contracts
*ProvidersApi* | [**autotaskRetrieveContractsFields**](docs/ProvidersApi.md#autotaskRetrieveContractsFields) | **GET** /integrations/autotask/{UUID}/contracts/fields | Retrieve Autotask Contract Fields
*ProvidersApi* | [**autotaskRetrieveMappings**](docs/ProvidersApi.md#autotaskRetrieveMappings) | **GET** /integrations/autotask/{UUID}/mappings | Retrieve Autotask mappings
*ProvidersApi* | [**autotaskRetrieveServices**](docs/ProvidersApi.md#autotaskRetrieveServices) | **GET** /integrations/autotask/{UUID}/contracts/services | Retrieve Autotask Contract Services
*ProvidersApi* | [**autotaskRetrieveSettings**](docs/ProvidersApi.md#autotaskRetrieveSettings) | **GET** /integrations/autotask/{UUID}/settings | Retrieve Autotask Integration settings
*ProvidersApi* | [**autotaskUpdateAlertConfiguration**](docs/ProvidersApi.md#autotaskUpdateAlertConfiguration) | **PUT** /providers/{provider_id}/integrations/autotask/alerts/{alert_UUID}/configuration | Update an Autotask ticketing alert&#x27;s configuration
*ProvidersApi* | [**autotaskUpdateConfiguration**](docs/ProvidersApi.md#autotaskUpdateConfiguration) | **PATCH** /integrations/autotask/{UUID} | Update Autotask Integration configuration
*ProvidersApi* | [**connectwiseCreateConfiguration**](docs/ProvidersApi.md#connectwiseCreateConfiguration) | **POST** /providers/{provider_id}/integrations/connectwise | Creates a new ConnectWise integration for the provider
*ProvidersApi* | [**connectwiseDeleteConfiguration**](docs/ProvidersApi.md#connectwiseDeleteConfiguration) | **DELETE** /integrations/connectwise/{UUID} | Delete ConnectWise Integration
*ProvidersApi* | [**connectwiseGetConfiguration**](docs/ProvidersApi.md#connectwiseGetConfiguration) | **GET** /integrations/connectwise/{UUID} | Retrieve ConnectWise Integration Configuration
*ProvidersApi* | [**connectwisePatchMappings**](docs/ProvidersApi.md#connectwisePatchMappings) | **PATCH** /integrations/connectwise/{UUID}/mappings | Create, edit, and/or delete ConnectWise Mappings
*ProvidersApi* | [**connectwisePatchSettings**](docs/ProvidersApi.md#connectwisePatchSettings) | **PATCH** /integrations/connectwise/{UUID}/settings | Create, edit, and/or delete ConnectWise Integration settings
*ProvidersApi* | [**connectwiseRetrieveAdditions**](docs/ProvidersApi.md#connectwiseRetrieveAdditions) | **GET** /integrations/connectwise/{UUID}/agreements/{agreement_ID}/additions | Retrieve ConnectWise Additions
*ProvidersApi* | [**connectwiseRetrieveAgreements**](docs/ProvidersApi.md#connectwiseRetrieveAgreements) | **GET** /integrations/connectwise/{UUID}/agreements | Retrieve ConnectWise Agreements
*ProvidersApi* | [**connectwiseRetrieveAllAlertConfigurationOptions**](docs/ProvidersApi.md#connectwiseRetrieveAllAlertConfigurationOptions) | **GET** /providers/{provider_id}/integrations/connectwise/alerts/configuration/options | Get all ConnectWise ticketing alert configuration options for a provider
*ProvidersApi* | [**connectwiseRetrieveAllAlertConfigurations**](docs/ProvidersApi.md#connectwiseRetrieveAllAlertConfigurations) | **GET** /providers/{provider_id}/integrations/connectwise/alerts/configuration | Get all ConnectWise ticketing alert configurations for a provider
*ProvidersApi* | [**connectwiseRetrieveCompanies**](docs/ProvidersApi.md#connectwiseRetrieveCompanies) | **GET** /integrations/connectwise/{UUID}/companies | Retrieve ConnectWise Companies
*ProvidersApi* | [**connectwiseRetrieveCompanyTypes**](docs/ProvidersApi.md#connectwiseRetrieveCompanyTypes) | **GET** /integrations/connectwise/{UUID}/companytypes | Retrieve ConnectWise Company Types
*ProvidersApi* | [**connectwiseRetrieveMappings**](docs/ProvidersApi.md#connectwiseRetrieveMappings) | **GET** /integrations/connectwise/{UUID}/mappings | Retrieve ConnectWise mappings
*ProvidersApi* | [**connectwiseRetrieveSettings**](docs/ProvidersApi.md#connectwiseRetrieveSettings) | **GET** /integrations/connectwise/{UUID}/settings | Retrieve ConnectWise Integration settings
*ProvidersApi* | [**connectwiseUpdateAlertConfiguration**](docs/ProvidersApi.md#connectwiseUpdateAlertConfiguration) | **PUT** /providers/{provider_id}/integrations/connectwise/alerts/{alert_UUID}/configuration | Update a ConnectWise ticketing alert&#x27;s configuration
*ProvidersApi* | [**connectwiseUpdateConfiguration**](docs/ProvidersApi.md#connectwiseUpdateConfiguration) | **PATCH** /integrations/connectwise/{UUID} | Update ConnectWise Integration configuration
*ProvidersApi* | [**mtpIntegrationRetrieveAlerts**](docs/ProvidersApi.md#mtpIntegrationRetrieveAlerts) | **GET** /providers/{provider_id}/integrations/ticketing/alerts | Get all ticketing alerts available for a provider&#x27;s ticketing integration.
*ProvidersApi* | [**mtpIntegrationRetrieveSyncErrors**](docs/ProvidersApi.md#mtpIntegrationRetrieveSyncErrors) | **GET** /integrations/{integration_type}/{UUID}/errors | Retrieve Recent Integration Sync Errors
*ProvidersApi* | [**providerOrganizationsUpdateOrg**](docs/ProvidersApi.md#providerOrganizationsUpdateOrg) | **PUT** /providers/{provider_id}/organizations/{id} | Update Provider Organization
*ProvidersApi* | [**providersGetProvider**](docs/ProvidersApi.md#providersGetProvider) | **GET** /providers/{provider_id} | Retrieve Provider
*ProvidersApi* | [**providersListAdministrators**](docs/ProvidersApi.md#providersListAdministrators) | **GET** /providers/{provider_id}/administrators | List Provider Administrators
*ProvidersApi* | [**providersListOrganizations**](docs/ProvidersApi.md#providersListOrganizations) | **GET** /providers/{provider_id}/organizations | List Provider Organizations
*ProvidersApi* | [**providersPostAdmins**](docs/ProvidersApi.md#providersPostAdmins) | **POST** /providers/{provider_id}/administrators | Create a new Provider Administrator
*ProvidersApi* | [**providersRemoveAdministrator**](docs/ProvidersApi.md#providersRemoveAdministrator) | **DELETE** /providers/{provider_id}/administrators/{id} | Delete Provider Administrator
*ProvidersApi* | [**providersRetrieveIntegrations**](docs/ProvidersApi.md#providersRetrieveIntegrations) | **GET** /providers/{provider_id}/integrations | Retrieve Integrations for Provider
*ProvidersApi* | [**providersRetrieveInvoice**](docs/ProvidersApi.md#providersRetrieveInvoice) | **GET** /providers/{provider_id}/invoices/{ID} | Download a provider&#x27;s invoice.
*ProvidersApi* | [**providersRetrieveInvoices**](docs/ProvidersApi.md#providersRetrieveInvoices) | **GET** /providers/{provider_id}/invoices | List a provider&#x27;s invoices.
*RadiusServersApi* | [**graphRadiusServerAssociationsList**](docs/RadiusServersApi.md#graphRadiusServerAssociationsList) | **GET** /radiusservers/{radiusserver_id}/associations | List the associations of a RADIUS  Server
*RadiusServersApi* | [**graphRadiusServerAssociationsPost**](docs/RadiusServersApi.md#graphRadiusServerAssociationsPost) | **POST** /radiusservers/{radiusserver_id}/associations | Manage the associations of a RADIUS Server
*RadiusServersApi* | [**graphRadiusServerTraverseUser**](docs/RadiusServersApi.md#graphRadiusServerTraverseUser) | **GET** /radiusservers/{radiusserver_id}/users | List the Users bound to a RADIUS  Server
*RadiusServersApi* | [**graphRadiusServerTraverseUserGroup**](docs/RadiusServersApi.md#graphRadiusServerTraverseUserGroup) | **GET** /radiusservers/{radiusserver_id}/usergroups | List the User Groups bound to a RADIUS  Server
*SambaDomainsApi* | [**ldapserversSambaDomainsDelete**](docs/SambaDomainsApi.md#ldapserversSambaDomainsDelete) | **DELETE** /ldapservers/{ldapserver_id}/sambadomains/{id} | Delete Samba Domain
*SambaDomainsApi* | [**ldapserversSambaDomainsGet**](docs/SambaDomainsApi.md#ldapserversSambaDomainsGet) | **GET** /ldapservers/{ldapserver_id}/sambadomains/{id} | Get Samba Domain
*SambaDomainsApi* | [**ldapserversSambaDomainsList**](docs/SambaDomainsApi.md#ldapserversSambaDomainsList) | **GET** /ldapservers/{ldapserver_id}/sambadomains | List Samba Domains
*SambaDomainsApi* | [**ldapserversSambaDomainsPost**](docs/SambaDomainsApi.md#ldapserversSambaDomainsPost) | **POST** /ldapservers/{ldapserver_id}/sambadomains | Create Samba Domain
*SambaDomainsApi* | [**ldapserversSambaDomainsPut**](docs/SambaDomainsApi.md#ldapserversSambaDomainsPut) | **PUT** /ldapservers/{ldapserver_id}/sambadomains/{id} | Update Samba Domain
*ScimImportApi* | [**importUsers**](docs/ScimImportApi.md#importUsers) | **GET** /applications/{application_id}/import/users | Get a list of users to import from an Application IdM service provider
*SoftwareAppsApi* | [**graphSoftwareappsAssociationsList**](docs/SoftwareAppsApi.md#graphSoftwareappsAssociationsList) | **GET** /softwareapps/{software_app_id}/associations | List the associations of a Software Application
*SoftwareAppsApi* | [**graphSoftwareappsAssociationsPost**](docs/SoftwareAppsApi.md#graphSoftwareappsAssociationsPost) | **POST** /softwareapps/{software_app_id}/associations | Manage the associations of a software application.
*SoftwareAppsApi* | [**graphSoftwareappsTraverseSystem**](docs/SoftwareAppsApi.md#graphSoftwareappsTraverseSystem) | **GET** /softwareapps/{software_app_id}/systems | List the Systems bound to a Software App.
*SoftwareAppsApi* | [**graphSoftwareappsTraverseSystemGroup**](docs/SoftwareAppsApi.md#graphSoftwareappsTraverseSystemGroup) | **GET** /softwareapps/{software_app_id}/systemgroups | List the System Groups bound to a Software App.
*SoftwareAppsApi* | [**softwareAppStatusesList**](docs/SoftwareAppsApi.md#softwareAppStatusesList) | **GET** /softwareapps/{software_app_id}/statuses | Get the status of the provided Software Application
*SoftwareAppsApi* | [**softwareAppsDelete**](docs/SoftwareAppsApi.md#softwareAppsDelete) | **DELETE** /softwareapps/{id} | Delete a configured Software Application
*SoftwareAppsApi* | [**softwareAppsGet**](docs/SoftwareAppsApi.md#softwareAppsGet) | **GET** /softwareapps/{id} | Retrieve a configured Software Application.
*SoftwareAppsApi* | [**softwareAppsList**](docs/SoftwareAppsApi.md#softwareAppsList) | **GET** /softwareapps | Get all configured Software Applications.
*SoftwareAppsApi* | [**softwareAppsPost**](docs/SoftwareAppsApi.md#softwareAppsPost) | **POST** /softwareapps | Create a Software Application that will be managed by JumpCloud.
*SoftwareAppsApi* | [**softwareAppsReclaimLicenses**](docs/SoftwareAppsApi.md#softwareAppsReclaimLicenses) | **POST** /softwareapps/{software_app_id}/reclaim-licenses | Reclaim Licenses for a Software Application.
*SoftwareAppsApi* | [**softwareAppsRetryInstallation**](docs/SoftwareAppsApi.md#softwareAppsRetryInstallation) | **POST** /softwareapps/{software_app_id}/retry-installation | Retry Installation for a Software Application
*SoftwareAppsApi* | [**softwareAppsUpdate**](docs/SoftwareAppsApi.md#softwareAppsUpdate) | **PUT** /softwareapps/{id} | Update a Software Application Configuration.
*SubscriptionsApi* | [**subscriptionsGet**](docs/SubscriptionsApi.md#subscriptionsGet) | **GET** /subscriptions | Lists all the Pricing &amp; Packaging Subscriptions
*SystemGroupAssociationsApi* | [**graphSystemGroupAssociationsList**](docs/SystemGroupAssociationsApi.md#graphSystemGroupAssociationsList) | **GET** /systemgroups/{group_id}/associations | List the associations of a System Group
*SystemGroupAssociationsApi* | [**graphSystemGroupAssociationsPost**](docs/SystemGroupAssociationsApi.md#graphSystemGroupAssociationsPost) | **POST** /systemgroups/{group_id}/associations | Manage the associations of a System Group
*SystemGroupAssociationsApi* | [**graphSystemGroupTraverseCommand**](docs/SystemGroupAssociationsApi.md#graphSystemGroupTraverseCommand) | **GET** /systemgroups/{group_id}/commands | List the Commands bound to a System Group
*SystemGroupAssociationsApi* | [**graphSystemGroupTraversePolicy**](docs/SystemGroupAssociationsApi.md#graphSystemGroupTraversePolicy) | **GET** /systemgroups/{group_id}/policies | List the Policies bound to a System Group
*SystemGroupAssociationsApi* | [**graphSystemGroupTraversePolicyGroup**](docs/SystemGroupAssociationsApi.md#graphSystemGroupTraversePolicyGroup) | **GET** /systemgroups/{group_id}/policygroups | List the Policy Groups bound to a System Group
*SystemGroupAssociationsApi* | [**graphSystemGroupTraverseUser**](docs/SystemGroupAssociationsApi.md#graphSystemGroupTraverseUser) | **GET** /systemgroups/{group_id}/users | List the Users bound to a System Group
*SystemGroupAssociationsApi* | [**graphSystemGroupTraverseUserGroup**](docs/SystemGroupAssociationsApi.md#graphSystemGroupTraverseUserGroup) | **GET** /systemgroups/{group_id}/usergroups | List the User Groups bound to a System Group
*SystemGroupMembersMembershipApi* | [**graphSystemGroupMembersList**](docs/SystemGroupMembersMembershipApi.md#graphSystemGroupMembersList) | **GET** /systemgroups/{group_id}/members | List the members of a System Group
*SystemGroupMembersMembershipApi* | [**graphSystemGroupMembersPost**](docs/SystemGroupMembersMembershipApi.md#graphSystemGroupMembersPost) | **POST** /systemgroups/{group_id}/members | Manage the members of a System Group
*SystemGroupMembersMembershipApi* | [**graphSystemGroupMembership**](docs/SystemGroupMembersMembershipApi.md#graphSystemGroupMembership) | **GET** /systemgroups/{group_id}/membership | List the System Group&#x27;s membership
*SystemGroupsApi* | [**graphSystemGroupAssociationsList**](docs/SystemGroupsApi.md#graphSystemGroupAssociationsList) | **GET** /systemgroups/{group_id}/associations | List the associations of a System Group
*SystemGroupsApi* | [**graphSystemGroupAssociationsPost**](docs/SystemGroupsApi.md#graphSystemGroupAssociationsPost) | **POST** /systemgroups/{group_id}/associations | Manage the associations of a System Group
*SystemGroupsApi* | [**graphSystemGroupMembersList**](docs/SystemGroupsApi.md#graphSystemGroupMembersList) | **GET** /systemgroups/{group_id}/members | List the members of a System Group
*SystemGroupsApi* | [**graphSystemGroupMembersPost**](docs/SystemGroupsApi.md#graphSystemGroupMembersPost) | **POST** /systemgroups/{group_id}/members | Manage the members of a System Group
*SystemGroupsApi* | [**graphSystemGroupMembership**](docs/SystemGroupsApi.md#graphSystemGroupMembership) | **GET** /systemgroups/{group_id}/membership | List the System Group&#x27;s membership
*SystemGroupsApi* | [**graphSystemGroupTraversePolicy**](docs/SystemGroupsApi.md#graphSystemGroupTraversePolicy) | **GET** /systemgroups/{group_id}/policies | List the Policies bound to a System Group
*SystemGroupsApi* | [**graphSystemGroupTraversePolicyGroup**](docs/SystemGroupsApi.md#graphSystemGroupTraversePolicyGroup) | **GET** /systemgroups/{group_id}/policygroups | List the Policy Groups bound to a System Group
*SystemGroupsApi* | [**graphSystemGroupTraverseUser**](docs/SystemGroupsApi.md#graphSystemGroupTraverseUser) | **GET** /systemgroups/{group_id}/users | List the Users bound to a System Group
*SystemGroupsApi* | [**graphSystemGroupTraverseUserGroup**](docs/SystemGroupsApi.md#graphSystemGroupTraverseUserGroup) | **GET** /systemgroups/{group_id}/usergroups | List the User Groups bound to a System Group
*SystemGroupsApi* | [**groupsSystemDelete**](docs/SystemGroupsApi.md#groupsSystemDelete) | **DELETE** /systemgroups/{id} | Delete a System Group
*SystemGroupsApi* | [**groupsSystemGet**](docs/SystemGroupsApi.md#groupsSystemGet) | **GET** /systemgroups/{id} | View an individual System Group details
*SystemGroupsApi* | [**groupsSystemList**](docs/SystemGroupsApi.md#groupsSystemList) | **GET** /systemgroups | List all System Groups
*SystemGroupsApi* | [**groupsSystemPost**](docs/SystemGroupsApi.md#groupsSystemPost) | **POST** /systemgroups | Create a new System Group
*SystemGroupsApi* | [**groupsSystemPut**](docs/SystemGroupsApi.md#groupsSystemPut) | **PUT** /systemgroups/{id} | Update a System Group
*SystemInsightsApi* | [**systeminsightsListAlf**](docs/SystemInsightsApi.md#systeminsightsListAlf) | **GET** /systeminsights/alf | List System Insights ALF
*SystemInsightsApi* | [**systeminsightsListAlfExceptions**](docs/SystemInsightsApi.md#systeminsightsListAlfExceptions) | **GET** /systeminsights/alf_exceptions | List System Insights ALF Exceptions
*SystemInsightsApi* | [**systeminsightsListAlfExplicitAuths**](docs/SystemInsightsApi.md#systeminsightsListAlfExplicitAuths) | **GET** /systeminsights/alf_explicit_auths | List System Insights ALF Explicit Authentications
*SystemInsightsApi* | [**systeminsightsListAppcompatShims**](docs/SystemInsightsApi.md#systeminsightsListAppcompatShims) | **GET** /systeminsights/appcompat_shims | List System Insights Application Compatibility Shims
*SystemInsightsApi* | [**systeminsightsListApps**](docs/SystemInsightsApi.md#systeminsightsListApps) | **GET** /systeminsights/apps | List System Insights Apps
*SystemInsightsApi* | [**systeminsightsListAuthorizedKeys**](docs/SystemInsightsApi.md#systeminsightsListAuthorizedKeys) | **GET** /systeminsights/authorized_keys | List System Insights Authorized Keys
*SystemInsightsApi* | [**systeminsightsListAzureInstanceMetadata**](docs/SystemInsightsApi.md#systeminsightsListAzureInstanceMetadata) | **GET** /systeminsights/azure_instance_metadata | List System Insights Azure Instance Metadata
*SystemInsightsApi* | [**systeminsightsListAzureInstanceTags**](docs/SystemInsightsApi.md#systeminsightsListAzureInstanceTags) | **GET** /systeminsights/azure_instance_tags | List System Insights Azure Instance Tags
*SystemInsightsApi* | [**systeminsightsListBattery**](docs/SystemInsightsApi.md#systeminsightsListBattery) | **GET** /systeminsights/battery | List System Insights Battery
*SystemInsightsApi* | [**systeminsightsListBitlockerInfo**](docs/SystemInsightsApi.md#systeminsightsListBitlockerInfo) | **GET** /systeminsights/bitlocker_info | List System Insights Bitlocker Info
*SystemInsightsApi* | [**systeminsightsListBrowserPlugins**](docs/SystemInsightsApi.md#systeminsightsListBrowserPlugins) | **GET** /systeminsights/browser_plugins | List System Insights Browser Plugins
*SystemInsightsApi* | [**systeminsightsListCertificates**](docs/SystemInsightsApi.md#systeminsightsListCertificates) | **GET** /systeminsights/certificates | List System Insights Certificates
*SystemInsightsApi* | [**systeminsightsListChassisInfo**](docs/SystemInsightsApi.md#systeminsightsListChassisInfo) | **GET** /systeminsights/chassis_info | List System Insights Chassis Info
*SystemInsightsApi* | [**systeminsightsListChromeExtensions**](docs/SystemInsightsApi.md#systeminsightsListChromeExtensions) | **GET** /systeminsights/chrome_extensions | List System Insights Chrome Extensions
*SystemInsightsApi* | [**systeminsightsListConnectivity**](docs/SystemInsightsApi.md#systeminsightsListConnectivity) | **GET** /systeminsights/connectivity | List System Insights Connectivity
*SystemInsightsApi* | [**systeminsightsListCrashes**](docs/SystemInsightsApi.md#systeminsightsListCrashes) | **GET** /systeminsights/crashes | List System Insights Crashes
*SystemInsightsApi* | [**systeminsightsListCupsDestinations**](docs/SystemInsightsApi.md#systeminsightsListCupsDestinations) | **GET** /systeminsights/cups_destinations | List System Insights CUPS Destinations
*SystemInsightsApi* | [**systeminsightsListDiskEncryption**](docs/SystemInsightsApi.md#systeminsightsListDiskEncryption) | **GET** /systeminsights/disk_encryption | List System Insights Disk Encryption
*SystemInsightsApi* | [**systeminsightsListDiskInfo**](docs/SystemInsightsApi.md#systeminsightsListDiskInfo) | **GET** /systeminsights/disk_info | List System Insights Disk Info
*SystemInsightsApi* | [**systeminsightsListDnsResolvers**](docs/SystemInsightsApi.md#systeminsightsListDnsResolvers) | **GET** /systeminsights/dns_resolvers | List System Insights DNS Resolvers
*SystemInsightsApi* | [**systeminsightsListEtcHosts**](docs/SystemInsightsApi.md#systeminsightsListEtcHosts) | **GET** /systeminsights/etc_hosts | List System Insights Etc Hosts
*SystemInsightsApi* | [**systeminsightsListFirefoxAddons**](docs/SystemInsightsApi.md#systeminsightsListFirefoxAddons) | **GET** /systeminsights/firefox_addons | List System Insights Firefox Addons
*SystemInsightsApi* | [**systeminsightsListGroups**](docs/SystemInsightsApi.md#systeminsightsListGroups) | **GET** /systeminsights/groups | List System Insights Groups
*SystemInsightsApi* | [**systeminsightsListIeExtensions**](docs/SystemInsightsApi.md#systeminsightsListIeExtensions) | **GET** /systeminsights/ie_extensions | List System Insights IE Extensions
*SystemInsightsApi* | [**systeminsightsListInterfaceAddresses**](docs/SystemInsightsApi.md#systeminsightsListInterfaceAddresses) | **GET** /systeminsights/interface_addresses | List System Insights Interface Addresses
*SystemInsightsApi* | [**systeminsightsListInterfaceDetails**](docs/SystemInsightsApi.md#systeminsightsListInterfaceDetails) | **GET** /systeminsights/interface_details | List System Insights Interface Details
*SystemInsightsApi* | [**systeminsightsListKernelInfo**](docs/SystemInsightsApi.md#systeminsightsListKernelInfo) | **GET** /systeminsights/kernel_info | List System Insights Kernel Info
*SystemInsightsApi* | [**systeminsightsListLaunchd**](docs/SystemInsightsApi.md#systeminsightsListLaunchd) | **GET** /systeminsights/launchd | List System Insights Launchd
*SystemInsightsApi* | [**systeminsightsListLinuxPackages**](docs/SystemInsightsApi.md#systeminsightsListLinuxPackages) | **GET** /systeminsights/linux_packages | List System Insights Linux Packages
*SystemInsightsApi* | [**systeminsightsListLoggedInUsers**](docs/SystemInsightsApi.md#systeminsightsListLoggedInUsers) | **GET** /systeminsights/logged_in_users | List System Insights Logged-In Users
*SystemInsightsApi* | [**systeminsightsListLogicalDrives**](docs/SystemInsightsApi.md#systeminsightsListLogicalDrives) | **GET** /systeminsights/logical_drives | List System Insights Logical Drives
*SystemInsightsApi* | [**systeminsightsListManagedPolicies**](docs/SystemInsightsApi.md#systeminsightsListManagedPolicies) | **GET** /systeminsights/managed_policies | List System Insights Managed Policies
*SystemInsightsApi* | [**systeminsightsListMounts**](docs/SystemInsightsApi.md#systeminsightsListMounts) | **GET** /systeminsights/mounts | List System Insights Mounts
*SystemInsightsApi* | [**systeminsightsListOsVersion**](docs/SystemInsightsApi.md#systeminsightsListOsVersion) | **GET** /systeminsights/os_version | List System Insights OS Version
*SystemInsightsApi* | [**systeminsightsListPatches**](docs/SystemInsightsApi.md#systeminsightsListPatches) | **GET** /systeminsights/patches | List System Insights Patches
*SystemInsightsApi* | [**systeminsightsListPrograms**](docs/SystemInsightsApi.md#systeminsightsListPrograms) | **GET** /systeminsights/programs | List System Insights Programs
*SystemInsightsApi* | [**systeminsightsListPythonPackages**](docs/SystemInsightsApi.md#systeminsightsListPythonPackages) | **GET** /systeminsights/python_packages | List System Insights Python Packages
*SystemInsightsApi* | [**systeminsightsListSafariExtensions**](docs/SystemInsightsApi.md#systeminsightsListSafariExtensions) | **GET** /systeminsights/safari_extensions | List System Insights Safari Extensions
*SystemInsightsApi* | [**systeminsightsListScheduledTasks**](docs/SystemInsightsApi.md#systeminsightsListScheduledTasks) | **GET** /systeminsights/scheduled_tasks | List System Insights Scheduled Tasks
*SystemInsightsApi* | [**systeminsightsListSecureboot**](docs/SystemInsightsApi.md#systeminsightsListSecureboot) | **GET** /systeminsights/secureboot | List System Insights Secure Boot
*SystemInsightsApi* | [**systeminsightsListServices**](docs/SystemInsightsApi.md#systeminsightsListServices) | **GET** /systeminsights/services | List System Insights Services
*SystemInsightsApi* | [**systeminsightsListShadow**](docs/SystemInsightsApi.md#systeminsightsListShadow) | **GET** /systeminsights/shadow | LIst System Insights Shadow
*SystemInsightsApi* | [**systeminsightsListSharedFolders**](docs/SystemInsightsApi.md#systeminsightsListSharedFolders) | **GET** /systeminsights/shared_folders | List System Insights Shared Folders
*SystemInsightsApi* | [**systeminsightsListSharedResources**](docs/SystemInsightsApi.md#systeminsightsListSharedResources) | **GET** /systeminsights/shared_resources | List System Insights Shared Resources
*SystemInsightsApi* | [**systeminsightsListSharingPreferences**](docs/SystemInsightsApi.md#systeminsightsListSharingPreferences) | **GET** /systeminsights/sharing_preferences | List System Insights Sharing Preferences
*SystemInsightsApi* | [**systeminsightsListSipConfig**](docs/SystemInsightsApi.md#systeminsightsListSipConfig) | **GET** /systeminsights/sip_config | List System Insights SIP Config
*SystemInsightsApi* | [**systeminsightsListStartupItems**](docs/SystemInsightsApi.md#systeminsightsListStartupItems) | **GET** /systeminsights/startup_items | List System Insights Startup Items
*SystemInsightsApi* | [**systeminsightsListSystemControls**](docs/SystemInsightsApi.md#systeminsightsListSystemControls) | **GET** /systeminsights/system_controls | List System Insights System Control
*SystemInsightsApi* | [**systeminsightsListSystemInfo**](docs/SystemInsightsApi.md#systeminsightsListSystemInfo) | **GET** /systeminsights/system_info | List System Insights System Info
*SystemInsightsApi* | [**systeminsightsListTpmInfo**](docs/SystemInsightsApi.md#systeminsightsListTpmInfo) | **GET** /systeminsights/tpm_info | List System Insights TPM Info
*SystemInsightsApi* | [**systeminsightsListUptime**](docs/SystemInsightsApi.md#systeminsightsListUptime) | **GET** /systeminsights/uptime | List System Insights Uptime
*SystemInsightsApi* | [**systeminsightsListUsbDevices**](docs/SystemInsightsApi.md#systeminsightsListUsbDevices) | **GET** /systeminsights/usb_devices | List System Insights USB Devices
*SystemInsightsApi* | [**systeminsightsListUserGroups**](docs/SystemInsightsApi.md#systeminsightsListUserGroups) | **GET** /systeminsights/user_groups | List System Insights User Groups
*SystemInsightsApi* | [**systeminsightsListUserSshKeys**](docs/SystemInsightsApi.md#systeminsightsListUserSshKeys) | **GET** /systeminsights/user_ssh_keys | List System Insights User SSH Keys
*SystemInsightsApi* | [**systeminsightsListUserassist**](docs/SystemInsightsApi.md#systeminsightsListUserassist) | **GET** /systeminsights/userassist | List System Insights User Assist
*SystemInsightsApi* | [**systeminsightsListUsers**](docs/SystemInsightsApi.md#systeminsightsListUsers) | **GET** /systeminsights/users | List System Insights Users
*SystemInsightsApi* | [**systeminsightsListWifiNetworks**](docs/SystemInsightsApi.md#systeminsightsListWifiNetworks) | **GET** /systeminsights/wifi_networks | List System Insights WiFi Networks
*SystemInsightsApi* | [**systeminsightsListWifiStatus**](docs/SystemInsightsApi.md#systeminsightsListWifiStatus) | **GET** /systeminsights/wifi_status | List System Insights WiFi Status
*SystemInsightsApi* | [**systeminsightsListWindowsSecurityCenter**](docs/SystemInsightsApi.md#systeminsightsListWindowsSecurityCenter) | **GET** /systeminsights/windows_security_center | List System Insights Windows Security Center
*SystemInsightsApi* | [**systeminsightsListWindowsSecurityProducts**](docs/SystemInsightsApi.md#systeminsightsListWindowsSecurityProducts) | **GET** /systeminsights/windows_security_products | List System Insights Windows Security Products
*SystemsApi* | [**graphSystemAssociationsList**](docs/SystemsApi.md#graphSystemAssociationsList) | **GET** /systems/{system_id}/associations | List the associations of a System
*SystemsApi* | [**graphSystemAssociationsPost**](docs/SystemsApi.md#graphSystemAssociationsPost) | **POST** /systems/{system_id}/associations | Manage associations of a System
*SystemsApi* | [**graphSystemMemberOf**](docs/SystemsApi.md#graphSystemMemberOf) | **GET** /systems/{system_id}/memberof | List the parent Groups of a System
*SystemsApi* | [**graphSystemTraverseCommand**](docs/SystemsApi.md#graphSystemTraverseCommand) | **GET** /systems/{system_id}/commands | List the Commands bound to a System
*SystemsApi* | [**graphSystemTraversePolicy**](docs/SystemsApi.md#graphSystemTraversePolicy) | **GET** /systems/{system_id}/policies | List the Policies bound to a System
*SystemsApi* | [**graphSystemTraversePolicyGroup**](docs/SystemsApi.md#graphSystemTraversePolicyGroup) | **GET** /systems/{system_id}/policygroups | List the Policy Groups bound to a System
*SystemsApi* | [**graphSystemTraverseUser**](docs/SystemsApi.md#graphSystemTraverseUser) | **GET** /systems/{system_id}/users | List the Users bound to a System
*SystemsApi* | [**graphSystemTraverseUserGroup**](docs/SystemsApi.md#graphSystemTraverseUserGroup) | **GET** /systems/{system_id}/usergroups | List the User Groups bound to a System
*SystemsApi* | [**systemsGetFDEKey**](docs/SystemsApi.md#systemsGetFDEKey) | **GET** /systems/{system_id}/fdekey | Get System FDE Key
*SystemsApi* | [**systemsListSoftwareAppsWithStatuses**](docs/SystemsApi.md#systemsListSoftwareAppsWithStatuses) | **GET** /systems/{system_id}/softwareappstatuses | List the associated Software Application Statuses of a System
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
*UserGroupMembersMembershipApi* | [**graphUserGroupMembersList**](docs/UserGroupMembersMembershipApi.md#graphUserGroupMembersList) | **GET** /usergroups/{group_id}/members | List the members of a User Group
*UserGroupMembersMembershipApi* | [**graphUserGroupMembersPost**](docs/UserGroupMembersMembershipApi.md#graphUserGroupMembersPost) | **POST** /usergroups/{group_id}/members | Manage the members of a User Group
*UserGroupMembersMembershipApi* | [**graphUserGroupMembership**](docs/UserGroupMembersMembershipApi.md#graphUserGroupMembership) | **GET** /usergroups/{group_id}/membership | List the User Group&#x27;s membership
*UserGroupsApi* | [**graphUserGroupAssociationsList**](docs/UserGroupsApi.md#graphUserGroupAssociationsList) | **GET** /usergroups/{group_id}/associations | List the associations of a User Group.
*UserGroupsApi* | [**graphUserGroupAssociationsPost**](docs/UserGroupsApi.md#graphUserGroupAssociationsPost) | **POST** /usergroups/{group_id}/associations | Manage the associations of a User Group
*UserGroupsApi* | [**graphUserGroupMembersList**](docs/UserGroupsApi.md#graphUserGroupMembersList) | **GET** /usergroups/{group_id}/members | List the members of a User Group
*UserGroupsApi* | [**graphUserGroupMembersPost**](docs/UserGroupsApi.md#graphUserGroupMembersPost) | **POST** /usergroups/{group_id}/members | Manage the members of a User Group
*UserGroupsApi* | [**graphUserGroupMembership**](docs/UserGroupsApi.md#graphUserGroupMembership) | **GET** /usergroups/{group_id}/membership | List the User Group&#x27;s membership
*UserGroupsApi* | [**graphUserGroupTraverseActiveDirectory**](docs/UserGroupsApi.md#graphUserGroupTraverseActiveDirectory) | **GET** /usergroups/{group_id}/activedirectories | List the Active Directories bound to a User Group
*UserGroupsApi* | [**graphUserGroupTraverseApplication**](docs/UserGroupsApi.md#graphUserGroupTraverseApplication) | **GET** /usergroups/{group_id}/applications | List the Applications bound to a User Group
*UserGroupsApi* | [**graphUserGroupTraverseDirectory**](docs/UserGroupsApi.md#graphUserGroupTraverseDirectory) | **GET** /usergroups/{group_id}/directories | List the Directories bound to a User Group
*UserGroupsApi* | [**graphUserGroupTraverseGSuite**](docs/UserGroupsApi.md#graphUserGroupTraverseGSuite) | **GET** /usergroups/{group_id}/gsuites | List the G Suite instances bound to a User Group
*UserGroupsApi* | [**graphUserGroupTraverseLdapServer**](docs/UserGroupsApi.md#graphUserGroupTraverseLdapServer) | **GET** /usergroups/{group_id}/ldapservers | List the LDAP Servers bound to a User Group
*UserGroupsApi* | [**graphUserGroupTraverseOffice365**](docs/UserGroupsApi.md#graphUserGroupTraverseOffice365) | **GET** /usergroups/{group_id}/office365s | List the Office 365 instances bound to a User Group
*UserGroupsApi* | [**graphUserGroupTraverseRadiusServer**](docs/UserGroupsApi.md#graphUserGroupTraverseRadiusServer) | **GET** /usergroups/{group_id}/radiusservers | List the RADIUS Servers bound to a User Group
*UserGroupsApi* | [**graphUserGroupTraverseSystem**](docs/UserGroupsApi.md#graphUserGroupTraverseSystem) | **GET** /usergroups/{group_id}/systems | List the Systems bound to a User Group
*UserGroupsApi* | [**graphUserGroupTraverseSystemGroup**](docs/UserGroupsApi.md#graphUserGroupTraverseSystemGroup) | **GET** /usergroups/{group_id}/systemgroups | List the System Groups bound to User Groups
*UserGroupsApi* | [**groupsSuggestionsGet**](docs/UserGroupsApi.md#groupsSuggestionsGet) | **GET** /usergroups/{group_id}/suggestions | List Suggestions for a User Group
*UserGroupsApi* | [**groupsSuggestionsPost**](docs/UserGroupsApi.md#groupsSuggestionsPost) | **POST** /usergroups/{group_id}/suggestions | List Suggestions for a User Group
*UserGroupsApi* | [**groupsUserDelete**](docs/UserGroupsApi.md#groupsUserDelete) | **DELETE** /usergroups/{id} | Delete a User Group
*UserGroupsApi* | [**groupsUserGet**](docs/UserGroupsApi.md#groupsUserGet) | **GET** /usergroups/{id} | View an individual User Group details
*UserGroupsApi* | [**groupsUserList**](docs/UserGroupsApi.md#groupsUserList) | **GET** /usergroups | List all User Groups
*UserGroupsApi* | [**groupsUserPost**](docs/UserGroupsApi.md#groupsUserPost) | **POST** /usergroups | Create a new User Group
*UserGroupsApi* | [**groupsUserPut**](docs/UserGroupsApi.md#groupsUserPut) | **PUT** /usergroups/{id} | Update a User Group
*UsersApi* | [**graphUserAssociationsList**](docs/UsersApi.md#graphUserAssociationsList) | **GET** /users/{user_id}/associations | List the associations of a User
*UsersApi* | [**graphUserAssociationsPost**](docs/UsersApi.md#graphUserAssociationsPost) | **POST** /users/{user_id}/associations | Manage the associations of a User
*UsersApi* | [**graphUserMemberOf**](docs/UsersApi.md#graphUserMemberOf) | **GET** /users/{user_id}/memberof | List the parent Groups of a User
*UsersApi* | [**graphUserTraverseActiveDirectory**](docs/UsersApi.md#graphUserTraverseActiveDirectory) | **GET** /users/{user_id}/activedirectories | List the Active Directory instances bound to a User
*UsersApi* | [**graphUserTraverseApplication**](docs/UsersApi.md#graphUserTraverseApplication) | **GET** /users/{user_id}/applications | List the Applications bound to a User
*UsersApi* | [**graphUserTraverseDirectory**](docs/UsersApi.md#graphUserTraverseDirectory) | **GET** /users/{user_id}/directories | List the Directories bound to a User
*UsersApi* | [**graphUserTraverseGSuite**](docs/UsersApi.md#graphUserTraverseGSuite) | **GET** /users/{user_id}/gsuites | List the G Suite instances bound to a User
*UsersApi* | [**graphUserTraverseLdapServer**](docs/UsersApi.md#graphUserTraverseLdapServer) | **GET** /users/{user_id}/ldapservers | List the LDAP servers bound to a User
*UsersApi* | [**graphUserTraverseOffice365**](docs/UsersApi.md#graphUserTraverseOffice365) | **GET** /users/{user_id}/office365s | List the Office 365 instances bound to a User
*UsersApi* | [**graphUserTraverseRadiusServer**](docs/UsersApi.md#graphUserTraverseRadiusServer) | **GET** /users/{user_id}/radiusservers | List the RADIUS Servers bound to a User
*UsersApi* | [**graphUserTraverseSystem**](docs/UsersApi.md#graphUserTraverseSystem) | **GET** /users/{user_id}/systems | List the Systems bound to a User
*UsersApi* | [**graphUserTraverseSystemGroup**](docs/UsersApi.md#graphUserTraverseSystemGroup) | **GET** /users/{user_id}/systemgroups | List the System Groups bound to a User
*UsersApi* | [**pushEndpointsDelete**](docs/UsersApi.md#pushEndpointsDelete) | **DELETE** /users/{user_id}/pushendpoints/{push_endpoint_id} | Delete a Push Endpoint associated with a User
*UsersApi* | [**pushEndpointsGet**](docs/UsersApi.md#pushEndpointsGet) | **GET** /users/{user_id}/pushendpoints/{push_endpoint_id} | Get a push endpoint associated with a User
*UsersApi* | [**pushEndpointsList**](docs/UsersApi.md#pushEndpointsList) | **GET** /users/{user_id}/pushendpoints | List Push Endpoints associated with a User
*UsersApi* | [**pushEndpointsPatch**](docs/UsersApi.md#pushEndpointsPatch) | **PATCH** /users/{user_id}/pushendpoints/{push_endpoint_id} | Update a push endpoint associated with a User
*WorkdayImportApi* | [**workdaysAuthorize**](docs/WorkdayImportApi.md#workdaysAuthorize) | **POST** /workdays/{workday_id}/auth | Authorize Workday
*WorkdayImportApi* | [**workdaysDeauthorize**](docs/WorkdayImportApi.md#workdaysDeauthorize) | **DELETE** /workdays/{workday_id}/auth | Deauthorize Workday
*WorkdayImportApi* | [**workdaysGet**](docs/WorkdayImportApi.md#workdaysGet) | **GET** /workdays/{id} | Get Workday
*WorkdayImportApi* | [**workdaysImport**](docs/WorkdayImportApi.md#workdaysImport) | **POST** /workdays/{workday_id}/import | Workday Import
*WorkdayImportApi* | [**workdaysImportresults**](docs/WorkdayImportApi.md#workdaysImportresults) | **GET** /workdays/{id}/import/{job_id}/results | List Import Results
*WorkdayImportApi* | [**workdaysList**](docs/WorkdayImportApi.md#workdaysList) | **GET** /workdays | List Workdays
*WorkdayImportApi* | [**workdaysPost**](docs/WorkdayImportApi.md#workdaysPost) | **POST** /workdays | Create new Workday
*WorkdayImportApi* | [**workdaysPut**](docs/WorkdayImportApi.md#workdaysPut) | **PUT** /workdays/{id} | Update Workday
*WorkdayImportApi* | [**workdaysWorkers**](docs/WorkdayImportApi.md#workdaysWorkers) | **GET** /workdays/{workday_id}/workers | List Workday Workers

## Documentation for Models

 - [ADE](docs/ADE.md)
 - [ADES](docs/ADES.md)
 - [ActiveDirectoryAgentGetOutput](docs/ActiveDirectoryAgentGetOutput.md)
 - [ActiveDirectoryAgentInput](docs/ActiveDirectoryAgentInput.md)
 - [ActiveDirectoryAgentListOutput](docs/ActiveDirectoryAgentListOutput.md)
 - [ActiveDirectoryInput](docs/ActiveDirectoryInput.md)
 - [ActiveDirectoryOutput](docs/ActiveDirectoryOutput.md)
 - [Address](docs/Address.md)
 - [Administrator](docs/Administrator.md)
 - [AdministratorOrganizationLink](docs/AdministratorOrganizationLink.md)
 - [AdministratorOrganizationLinkReq](docs/AdministratorOrganizationLinkReq.md)
 - [AllOfAutotaskTicketingAlertConfigurationListRecordsItems](docs/AllOfAutotaskTicketingAlertConfigurationListRecordsItems.md)
 - [AllOfConnectWiseTicketingAlertConfigurationListRecordsItems](docs/AllOfConnectWiseTicketingAlertConfigurationListRecordsItems.md)
 - [AnyValue](docs/AnyValue.md)
 - [AppleMDM](docs/AppleMDM.md)
 - [AppleMdmDevice](docs/AppleMdmDevice.md)
 - [AppleMdmDeviceInfo](docs/AppleMdmDeviceInfo.md)
 - [AppleMdmDeviceSecurityInfo](docs/AppleMdmDeviceSecurityInfo.md)
 - [AppleMdmPatchInput](docs/AppleMdmPatchInput.md)
 - [ApplicationIdLogoBody](docs/ApplicationIdLogoBody.md)
 - [AuthInfo](docs/AuthInfo.md)
 - [AuthInput](docs/AuthInput.md)
 - [AuthInputObject](docs/AuthInputObject.md)
 - [AuthinputBasic](docs/AuthinputBasic.md)
 - [AuthinputOauth](docs/AuthinputOauth.md)
 - [AuthnPolicy](docs/AuthnPolicy.md)
 - [AuthnPolicyEffect](docs/AuthnPolicyEffect.md)
 - [AuthnPolicyInput](docs/AuthnPolicyInput.md)
 - [AuthnPolicyObligations](docs/AuthnPolicyObligations.md)
 - [AuthnPolicyObligationsMfa](docs/AuthnPolicyObligationsMfa.md)
 - [AuthnPolicyObligationsUserVerification](docs/AuthnPolicyObligationsUserVerification.md)
 - [AuthnPolicyResourceTarget](docs/AuthnPolicyResourceTarget.md)
 - [AuthnPolicyTargets](docs/AuthnPolicyTargets.md)
 - [AuthnPolicyType](docs/AuthnPolicyType.md)
 - [AuthnPolicyUserAttributeFilter](docs/AuthnPolicyUserAttributeFilter.md)
 - [AuthnPolicyUserAttributeTarget](docs/AuthnPolicyUserAttributeTarget.md)
 - [AuthnPolicyUserGroupTarget](docs/AuthnPolicyUserGroupTarget.md)
 - [AuthnPolicyUserTarget](docs/AuthnPolicyUserTarget.md)
 - [AutotaskCompany](docs/AutotaskCompany.md)
 - [AutotaskCompanyResp](docs/AutotaskCompanyResp.md)
 - [AutotaskCompanyTypeResp](docs/AutotaskCompanyTypeResp.md)
 - [AutotaskContract](docs/AutotaskContract.md)
 - [AutotaskContractField](docs/AutotaskContractField.md)
 - [AutotaskContractFieldValues](docs/AutotaskContractFieldValues.md)
 - [AutotaskIntegration](docs/AutotaskIntegration.md)
 - [AutotaskIntegrationPatchReq](docs/AutotaskIntegrationPatchReq.md)
 - [AutotaskIntegrationReq](docs/AutotaskIntegrationReq.md)
 - [AutotaskMappingRequest](docs/AutotaskMappingRequest.md)
 - [AutotaskMappingRequestCompany](docs/AutotaskMappingRequestCompany.md)
 - [AutotaskMappingRequestContract](docs/AutotaskMappingRequestContract.md)
 - [AutotaskMappingRequestData](docs/AutotaskMappingRequestData.md)
 - [AutotaskMappingRequestOrganization](docs/AutotaskMappingRequestOrganization.md)
 - [AutotaskMappingRequestService](docs/AutotaskMappingRequestService.md)
 - [AutotaskMappingResponse](docs/AutotaskMappingResponse.md)
 - [AutotaskMappingResponseCompany](docs/AutotaskMappingResponseCompany.md)
 - [AutotaskMappingResponseContract](docs/AutotaskMappingResponseContract.md)
 - [AutotaskMappingResponseOrganization](docs/AutotaskMappingResponseOrganization.md)
 - [AutotaskMappingResponseService](docs/AutotaskMappingResponseService.md)
 - [AutotaskService](docs/AutotaskService.md)
 - [AutotaskSettings](docs/AutotaskSettings.md)
 - [AutotaskSettingsPatchReq](docs/AutotaskSettingsPatchReq.md)
 - [AutotaskTicketingAlertConfiguration](docs/AutotaskTicketingAlertConfiguration.md)
 - [AutotaskTicketingAlertConfigurationList](docs/AutotaskTicketingAlertConfigurationList.md)
 - [AutotaskTicketingAlertConfigurationOption](docs/AutotaskTicketingAlertConfigurationOption.md)
 - [AutotaskTicketingAlertConfigurationOptionValues](docs/AutotaskTicketingAlertConfigurationOptionValues.md)
 - [AutotaskTicketingAlertConfigurationOptions](docs/AutotaskTicketingAlertConfigurationOptions.md)
 - [AutotaskTicketingAlertConfigurationPriority](docs/AutotaskTicketingAlertConfigurationPriority.md)
 - [AutotaskTicketingAlertConfigurationRequest](docs/AutotaskTicketingAlertConfigurationRequest.md)
 - [AutotaskTicketingAlertConfigurationResource](docs/AutotaskTicketingAlertConfigurationResource.md)
 - [BillingIntegrationCompanyType](docs/BillingIntegrationCompanyType.md)
 - [BulkScheduledStatechangeCreate](docs/BulkScheduledStatechangeCreate.md)
 - [BulkUserCreate](docs/BulkUserCreate.md)
 - [BulkUserUpdate](docs/BulkUserUpdate.md)
 - [CommandResultList](docs/CommandResultList.md)
 - [CommandResultListResults](docs/CommandResultListResults.md)
 - [ConnectWiseMappingRequest](docs/ConnectWiseMappingRequest.md)
 - [ConnectWiseMappingRequestCompany](docs/ConnectWiseMappingRequestCompany.md)
 - [ConnectWiseMappingRequestData](docs/ConnectWiseMappingRequestData.md)
 - [ConnectWiseMappingRequestOrganization](docs/ConnectWiseMappingRequestOrganization.md)
 - [ConnectWiseMappingResponse](docs/ConnectWiseMappingResponse.md)
 - [ConnectWiseMappingResponseAddition](docs/ConnectWiseMappingResponseAddition.md)
 - [ConnectWiseSettings](docs/ConnectWiseSettings.md)
 - [ConnectWiseSettingsPatchReq](docs/ConnectWiseSettingsPatchReq.md)
 - [ConnectWiseTicketingAlertConfiguration](docs/ConnectWiseTicketingAlertConfiguration.md)
 - [ConnectWiseTicketingAlertConfigurationList](docs/ConnectWiseTicketingAlertConfigurationList.md)
 - [ConnectWiseTicketingAlertConfigurationOption](docs/ConnectWiseTicketingAlertConfigurationOption.md)
 - [ConnectWiseTicketingAlertConfigurationOptions](docs/ConnectWiseTicketingAlertConfigurationOptions.md)
 - [ConnectWiseTicketingAlertConfigurationRequest](docs/ConnectWiseTicketingAlertConfigurationRequest.md)
 - [ConnectwiseAddition](docs/ConnectwiseAddition.md)
 - [ConnectwiseAgreement](docs/ConnectwiseAgreement.md)
 - [ConnectwiseCompany](docs/ConnectwiseCompany.md)
 - [ConnectwiseCompanyResp](docs/ConnectwiseCompanyResp.md)
 - [ConnectwiseCompanyTypeResp](docs/ConnectwiseCompanyTypeResp.md)
 - [ConnectwiseIntegration](docs/ConnectwiseIntegration.md)
 - [ConnectwiseIntegrationPatchReq](docs/ConnectwiseIntegrationPatchReq.md)
 - [ConnectwiseIntegrationReq](docs/ConnectwiseIntegrationReq.md)
 - [CustomEmail](docs/CustomEmail.md)
 - [CustomEmailTemplate](docs/CustomEmailTemplate.md)
 - [CustomEmailTemplateField](docs/CustomEmailTemplateField.md)
 - [CustomEmailType](docs/CustomEmailType.md)
 - [DEP](docs/DEP.md)
 - [DEPSetupAssistantOption](docs/DEPSetupAssistantOption.md)
 - [DEPWelcomeScreen](docs/DEPWelcomeScreen.md)
 - [DeviceIdEraseBody](docs/DeviceIdEraseBody.md)
 - [DeviceIdLockBody](docs/DeviceIdLockBody.md)
 - [DeviceIdRestartBody](docs/DeviceIdRestartBody.md)
 - [Directory](docs/Directory.md)
 - [DuoAccount](docs/DuoAccount.md)
 - [DuoApplication](docs/DuoApplication.md)
 - [DuoApplicationReq](docs/DuoApplicationReq.md)
 - [DuoApplicationUpdateReq](docs/DuoApplicationUpdateReq.md)
 - [Error](docs/Error.md)
 - [ErrorDetails](docs/ErrorDetails.md)
 - [Feature](docs/Feature.md)
 - [Filter](docs/Filter.md)
 - [FilterQuery](docs/FilterQuery.md)
 - [GSuiteBuiltinTranslation](docs/GSuiteBuiltinTranslation.md)
 - [GSuiteDirectionTranslation](docs/GSuiteDirectionTranslation.md)
 - [GSuiteTranslationRule](docs/GSuiteTranslationRule.md)
 - [GSuiteTranslationRuleRequest](docs/GSuiteTranslationRuleRequest.md)
 - [GraphAttributeLdapGroups](docs/GraphAttributeLdapGroups.md)
 - [GraphAttributePosixGroups](docs/GraphAttributePosixGroups.md)
 - [GraphAttributePosixGroupsPosixGroups](docs/GraphAttributePosixGroupsPosixGroups.md)
 - [GraphAttributeRadius](docs/GraphAttributeRadius.md)
 - [GraphAttributeRadiusRadius](docs/GraphAttributeRadiusRadius.md)
 - [GraphAttributeRadiusRadiusReply](docs/GraphAttributeRadiusRadiusReply.md)
 - [GraphAttributeSambaEnabled](docs/GraphAttributeSambaEnabled.md)
 - [GraphAttributeSudo](docs/GraphAttributeSudo.md)
 - [GraphAttributeSudoSudo](docs/GraphAttributeSudoSudo.md)
 - [GraphAttributes](docs/GraphAttributes.md)
 - [GraphConnection](docs/GraphConnection.md)
 - [GraphObject](docs/GraphObject.md)
 - [GraphObjectWithPaths](docs/GraphObjectWithPaths.md)
 - [GraphOperation](docs/GraphOperation.md)
 - [GraphOperationActiveDirectory](docs/GraphOperationActiveDirectory.md)
 - [GraphOperationApplication](docs/GraphOperationApplication.md)
 - [GraphOperationCommand](docs/GraphOperationCommand.md)
 - [GraphOperationGSuite](docs/GraphOperationGSuite.md)
 - [GraphOperationLdapServer](docs/GraphOperationLdapServer.md)
 - [GraphOperationOffice365](docs/GraphOperationOffice365.md)
 - [GraphOperationPolicy](docs/GraphOperationPolicy.md)
 - [GraphOperationPolicyGroup](docs/GraphOperationPolicyGroup.md)
 - [GraphOperationPolicyGroupMember](docs/GraphOperationPolicyGroupMember.md)
 - [GraphOperationRadiusServer](docs/GraphOperationRadiusServer.md)
 - [GraphOperationSoftwareApp](docs/GraphOperationSoftwareApp.md)
 - [GraphOperationSystem](docs/GraphOperationSystem.md)
 - [GraphOperationSystemGroup](docs/GraphOperationSystemGroup.md)
 - [GraphOperationSystemGroupMember](docs/GraphOperationSystemGroupMember.md)
 - [GraphOperationUser](docs/GraphOperationUser.md)
 - [GraphOperationUserGroup](docs/GraphOperationUserGroup.md)
 - [GraphOperationUserGroupMember](docs/GraphOperationUserGroupMember.md)
 - [GraphType](docs/GraphType.md)
 - [Group](docs/Group.md)
 - [GroupAttributesUserGroup](docs/GroupAttributesUserGroup.md)
 - [GroupIdSuggestionsBody](docs/GroupIdSuggestionsBody.md)
 - [GroupType](docs/GroupType.md)
 - [GsuiteOutput](docs/GsuiteOutput.md)
 - [GsuitePatchInput](docs/GsuitePatchInput.md)
 - [IPList](docs/IPList.md)
 - [IPListRequest](docs/IPListRequest.md)
 - [ImportUser](docs/ImportUser.md)
 - [ImportUserAddress](docs/ImportUserAddress.md)
 - [ImportUserPhoneNumber](docs/ImportUserPhoneNumber.md)
 - [ImportUsersResponse](docs/ImportUsersResponse.md)
 - [InlineResponse200](docs/InlineResponse200.md)
 - [InlineResponse2001](docs/InlineResponse2001.md)
 - [InlineResponse20010](docs/InlineResponse20010.md)
 - [InlineResponse20011](docs/InlineResponse20011.md)
 - [InlineResponse20011Users](docs/InlineResponse20011Users.md)
 - [InlineResponse20012](docs/InlineResponse20012.md)
 - [InlineResponse20013](docs/InlineResponse20013.md)
 - [InlineResponse2002](docs/InlineResponse2002.md)
 - [InlineResponse2002Users](docs/InlineResponse2002Users.md)
 - [InlineResponse2003](docs/InlineResponse2003.md)
 - [InlineResponse2004](docs/InlineResponse2004.md)
 - [InlineResponse2005](docs/InlineResponse2005.md)
 - [InlineResponse2006](docs/InlineResponse2006.md)
 - [InlineResponse2007](docs/InlineResponse2007.md)
 - [InlineResponse2008](docs/InlineResponse2008.md)
 - [InlineResponse2009](docs/InlineResponse2009.md)
 - [InlineResponse201](docs/InlineResponse201.md)
 - [InlineResponse400](docs/InlineResponse400.md)
 - [Integration](docs/Integration.md)
 - [IntegrationSyncError](docs/IntegrationSyncError.md)
 - [IntegrationSyncErrorResp](docs/IntegrationSyncErrorResp.md)
 - [IntegrationType](docs/IntegrationType.md)
 - [IntegrationsResponse](docs/IntegrationsResponse.md)
 - [JobId](docs/JobId.md)
 - [JobWorkresult](docs/JobWorkresult.md)
 - [LdapGroup](docs/LdapGroup.md)
 - [LdapServerAction](docs/LdapServerAction.md)
 - [LdapServerInput](docs/LdapServerInput.md)
 - [LdapServerOutput](docs/LdapServerOutput.md)
 - [LdapserversIdBody](docs/LdapserversIdBody.md)
 - [MemberSuggestion](docs/MemberSuggestion.md)
 - [MemberSuggestionsPostResult](docs/MemberSuggestionsPostResult.md)
 - [OSRestriction](docs/OSRestriction.md)
 - [OSRestrictionAppleRestrictions](docs/OSRestrictionAppleRestrictions.md)
 - [Office365BuiltinTranslation](docs/Office365BuiltinTranslation.md)
 - [Office365DirectionTranslation](docs/Office365DirectionTranslation.md)
 - [Office365Output](docs/Office365Output.md)
 - [Office365PatchInput](docs/Office365PatchInput.md)
 - [Office365TranslationRule](docs/Office365TranslationRule.md)
 - [Office365TranslationRuleRequest](docs/Office365TranslationRuleRequest.md)
 - [Organization](docs/Organization.md)
 - [OrganizationCase](docs/OrganizationCase.md)
 - [OrganizationCasesResponse](docs/OrganizationCasesResponse.md)
 - [PhoneNumber](docs/PhoneNumber.md)
 - [Policy](docs/Policy.md)
 - [PolicyGroup](docs/PolicyGroup.md)
 - [PolicyGroupData](docs/PolicyGroupData.md)
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
 - [ProviderInvoice](docs/ProviderInvoice.md)
 - [ProviderInvoiceResponse](docs/ProviderInvoiceResponse.md)
 - [PushEndpointResponse](docs/PushEndpointResponse.md)
 - [PushEndpointResponseDevice](docs/PushEndpointResponseDevice.md)
 - [PushendpointsPushEndpointIdBody](docs/PushendpointsPushEndpointIdBody.md)
 - [PwmAllUsers](docs/PwmAllUsers.md)
 - [PwmAllUsersGroups](docs/PwmAllUsersGroups.md)
 - [PwmAllUsersResults](docs/PwmAllUsersResults.md)
 - [PwmOverviewAppVersions](docs/PwmOverviewAppVersions.md)
 - [PwmOverviewAppVersionsResults](docs/PwmOverviewAppVersionsResults.md)
 - [PwmOverviewMain](docs/PwmOverviewMain.md)
 - [PwmOverviewMainDevices](docs/PwmOverviewMainDevices.md)
 - [Query](docs/Query.md)
 - [QueuedCommandList](docs/QueuedCommandList.md)
 - [QueuedCommandListResults](docs/QueuedCommandListResults.md)
 - [SambaDomainInput](docs/SambaDomainInput.md)
 - [SambaDomainOutput](docs/SambaDomainOutput.md)
 - [ScheduledUserstateResult](docs/ScheduledUserstateResult.md)
 - [SetupAssistantOption](docs/SetupAssistantOption.md)
 - [SharedFolderAccessLevels](docs/SharedFolderAccessLevels.md)
 - [SharedFolderAccessLevelsResults](docs/SharedFolderAccessLevelsResults.md)
 - [SharedFolderDetails](docs/SharedFolderDetails.md)
 - [SharedFolderUsers](docs/SharedFolderUsers.md)
 - [SharedFolderUsersResults](docs/SharedFolderUsersResults.md)
 - [SharedFoldersList](docs/SharedFoldersList.md)
 - [SharedFoldersListResults](docs/SharedFoldersListResults.md)
 - [SoftwareApp](docs/SoftwareApp.md)
 - [SoftwareAppAppleVpp](docs/SoftwareAppAppleVpp.md)
 - [SoftwareAppReclaimLicenses](docs/SoftwareAppReclaimLicenses.md)
 - [SoftwareAppSettings](docs/SoftwareAppSettings.md)
 - [SoftwareAppStatus](docs/SoftwareAppStatus.md)
 - [SoftwareAppWithStatus](docs/SoftwareAppWithStatus.md)
 - [SoftwareAppsRetryInstallationRequest](docs/SoftwareAppsRetryInstallationRequest.md)
 - [Subscription](docs/Subscription.md)
 - [SuggestionCounts](docs/SuggestionCounts.md)
 - [SystemGroup](docs/SystemGroup.md)
 - [SystemGroupData](docs/SystemGroupData.md)
 - [SystemInsightsAlf](docs/SystemInsightsAlf.md)
 - [SystemInsightsAlfExceptions](docs/SystemInsightsAlfExceptions.md)
 - [SystemInsightsAlfExplicitAuths](docs/SystemInsightsAlfExplicitAuths.md)
 - [SystemInsightsAppcompatShims](docs/SystemInsightsAppcompatShims.md)
 - [SystemInsightsApps](docs/SystemInsightsApps.md)
 - [SystemInsightsAuthorizedKeys](docs/SystemInsightsAuthorizedKeys.md)
 - [SystemInsightsAzureInstanceMetadata](docs/SystemInsightsAzureInstanceMetadata.md)
 - [SystemInsightsAzureInstanceTags](docs/SystemInsightsAzureInstanceTags.md)
 - [SystemInsightsBattery](docs/SystemInsightsBattery.md)
 - [SystemInsightsBitlockerInfo](docs/SystemInsightsBitlockerInfo.md)
 - [SystemInsightsBrowserPlugins](docs/SystemInsightsBrowserPlugins.md)
 - [SystemInsightsCertificates](docs/SystemInsightsCertificates.md)
 - [SystemInsightsChassisInfo](docs/SystemInsightsChassisInfo.md)
 - [SystemInsightsChromeExtensions](docs/SystemInsightsChromeExtensions.md)
 - [SystemInsightsConnectivity](docs/SystemInsightsConnectivity.md)
 - [SystemInsightsCrashes](docs/SystemInsightsCrashes.md)
 - [SystemInsightsCupsDestinations](docs/SystemInsightsCupsDestinations.md)
 - [SystemInsightsDiskEncryption](docs/SystemInsightsDiskEncryption.md)
 - [SystemInsightsDiskInfo](docs/SystemInsightsDiskInfo.md)
 - [SystemInsightsDnsResolvers](docs/SystemInsightsDnsResolvers.md)
 - [SystemInsightsEtcHosts](docs/SystemInsightsEtcHosts.md)
 - [SystemInsightsFirefoxAddons](docs/SystemInsightsFirefoxAddons.md)
 - [SystemInsightsGroups](docs/SystemInsightsGroups.md)
 - [SystemInsightsIeExtensions](docs/SystemInsightsIeExtensions.md)
 - [SystemInsightsInterfaceAddresses](docs/SystemInsightsInterfaceAddresses.md)
 - [SystemInsightsInterfaceDetails](docs/SystemInsightsInterfaceDetails.md)
 - [SystemInsightsKernelInfo](docs/SystemInsightsKernelInfo.md)
 - [SystemInsightsLaunchd](docs/SystemInsightsLaunchd.md)
 - [SystemInsightsLinuxPackages](docs/SystemInsightsLinuxPackages.md)
 - [SystemInsightsLoggedInUsers](docs/SystemInsightsLoggedInUsers.md)
 - [SystemInsightsLogicalDrives](docs/SystemInsightsLogicalDrives.md)
 - [SystemInsightsManagedPolicies](docs/SystemInsightsManagedPolicies.md)
 - [SystemInsightsMounts](docs/SystemInsightsMounts.md)
 - [SystemInsightsOsVersion](docs/SystemInsightsOsVersion.md)
 - [SystemInsightsPatches](docs/SystemInsightsPatches.md)
 - [SystemInsightsPrograms](docs/SystemInsightsPrograms.md)
 - [SystemInsightsPythonPackages](docs/SystemInsightsPythonPackages.md)
 - [SystemInsightsSafariExtensions](docs/SystemInsightsSafariExtensions.md)
 - [SystemInsightsScheduledTasks](docs/SystemInsightsScheduledTasks.md)
 - [SystemInsightsSecureboot](docs/SystemInsightsSecureboot.md)
 - [SystemInsightsServices](docs/SystemInsightsServices.md)
 - [SystemInsightsShadow](docs/SystemInsightsShadow.md)
 - [SystemInsightsSharedFolders](docs/SystemInsightsSharedFolders.md)
 - [SystemInsightsSharedResources](docs/SystemInsightsSharedResources.md)
 - [SystemInsightsSharingPreferences](docs/SystemInsightsSharingPreferences.md)
 - [SystemInsightsSipConfig](docs/SystemInsightsSipConfig.md)
 - [SystemInsightsStartupItems](docs/SystemInsightsStartupItems.md)
 - [SystemInsightsSystemControls](docs/SystemInsightsSystemControls.md)
 - [SystemInsightsSystemInfo](docs/SystemInsightsSystemInfo.md)
 - [SystemInsightsTpmInfo](docs/SystemInsightsTpmInfo.md)
 - [SystemInsightsUptime](docs/SystemInsightsUptime.md)
 - [SystemInsightsUsbDevices](docs/SystemInsightsUsbDevices.md)
 - [SystemInsightsUserGroups](docs/SystemInsightsUserGroups.md)
 - [SystemInsightsUserSshKeys](docs/SystemInsightsUserSshKeys.md)
 - [SystemInsightsUserassist](docs/SystemInsightsUserassist.md)
 - [SystemInsightsUsers](docs/SystemInsightsUsers.md)
 - [SystemInsightsWifiNetworks](docs/SystemInsightsWifiNetworks.md)
 - [SystemInsightsWifiStatus](docs/SystemInsightsWifiStatus.md)
 - [SystemInsightsWindowsSecurityCenter](docs/SystemInsightsWindowsSecurityCenter.md)
 - [SystemInsightsWindowsSecurityProducts](docs/SystemInsightsWindowsSecurityProducts.md)
 - [Systemfdekey](docs/Systemfdekey.md)
 - [TicketingIntegrationAlert](docs/TicketingIntegrationAlert.md)
 - [TicketingIntegrationAlertsResp](docs/TicketingIntegrationAlertsResp.md)
 - [User](docs/User.md)
 - [UserGroup](docs/UserGroup.md)
 - [UserGroupPost](docs/UserGroupPost.md)
 - [UserGroupPut](docs/UserGroupPut.md)
 - [WorkdayFields](docs/WorkdayFields.md)
 - [WorkdayInput](docs/WorkdayInput.md)
 - [WorkdayOutput](docs/WorkdayOutput.md)
 - [WorkdayWorker](docs/WorkdayWorker.md)
 - [WorkdayoutputAuth](docs/WorkdayoutputAuth.md)

## Documentation for Authorization

Authentication schemes defined for the API:
### x-api-key

- **Type**: API key
- **API key parameter name**: x-api-key
- **Location**: HTTP header


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

support@jumpcloud.com
