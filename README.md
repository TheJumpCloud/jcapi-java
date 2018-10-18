## JCAPI-Java

### Description

This repository contains the Java client code for the JumpCloud API v1 and v2.
The code is automatically generated using Swagger Codegen. For instructions on
how to generate the code, see the [Contributing](CONTRIBUTING.md) section.

### Installing the Java Client

To install the API client library to your local Maven repository, go to the
appropriate API client folder ([jcapiv1](jcapiv1) or [jcapiv2](jcapiv2)) and
simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of
the repository and execute:

```shell
mvn deploy
```

Refer to the
[official Maven documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html)
for more information.

### Authentication and Authorization

All endpoints support authentication via API key: see the
[Authentication & Authorization](https://docs.jumpcloud.com/2.0/authentication-and-authorization/authentication-and-authorization-overview)
section in our API documentation.

Some systems endpoints (in both API v1 and v2) also support
[System Context Authorization](https://docs.jumpcloud.com/2.0/authentication-and-authorization/system-context)
which allows an individual system to manage its information and resource
associations.

### Usage Examples

For more detailed instructions, refer to each API version's respective README
file ([README for API v1](jcapiv1/README.md) and
[README for API v2](jcapiv2/README.md)) and the generated documentation under
each folder.

#### API v1 Example

1. Follow the instructions in the
  [Installing the Java Client](#installing-the-java-client) section for
  [jcapiv1](jcapiv1).

2. Add this dependency to your project's POM:

  ```xml
  <dependency>
    <groupId>com.jumpcloud</groupId>
    <artifactId>jcapi-java-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
  </dependency>
  ```

3. Copy the dependencies to your project:

  **Note:** There are several ways to include the JCAPI-Java client and its
  dependencies in your project at runtime. The following is one way using
  `maven-dependency-plugin`, which will copy all the dependent JAR files to
  your project's build directory.

  Add the following plugin definition to your project's POM:

  ```xml
  <plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-dependency-plugin</artifactId>
  <executions>
    <execution>
      <id>copy-dependencies</id>
      <phase>package</phase>
      <goals>
        <goal>copy-dependencies</goal>
      </goals>
      <configuration>
        <outputDirectory>${project.build.directory}</outputDirectory>
        <overWriteReleases>false</overWriteReleases>
        <overWriteSnapshots>true</overWriteSnapshots>
      </configuration>
    </execution>
  </executions>
  </plugin>
  ```

4. Add the following example code to your project as
  `SystemusersApiExample.java` (replace the placeholder values with your
  actual values):

  ```java
  import io.swagger.client.ApiClient;
  import io.swagger.client.ApiException;
  import io.swagger.client.Configuration;
  import io.swagger.client.api.SystemusersApi;
  import io.swagger.client.auth.ApiKeyAuth;
  import io.swagger.client.model.Systemuserput;
  import io.swagger.client.model.Systemuserreturn;
  import io.swagger.client.model.Systemuserslist;

  public class SystemusersApiExample {
    public static void main(String[] args) {
      String apiKey = "YOUR_API_KEY";
      String systemUserId = "SYSTEM_USER_ID_TO_UPDATE";
      String xOrgId = ""; // Only required of administrators that manage multiple organizations

      String contentType = "application/json";
      String accept = "application/json";

      // Set up the configuration object with your API key for authorization
      ApiClient defaultClient = Configuration.getDefaultApiClient();
      ApiKeyAuth xApiKey = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
      xApiKey.setApiKey(apiKey);

      // Instantiate the API object for the group of endpoints you need to use,
      // for instance the system users API
      SystemusersApi systemUsersApi = new SystemusersApi();

      // Example 1: Make an API call to retrieve system users

      Integer limit = null;
      Integer skip = null;
      String sort = null;
      String fields = null;
      String filter = null;

      try {
        Systemuserslist users = systemUsersApi.systemusersList(
            contentType, accept, limit, skip, sort, fields, filter, xOrgId);
        System.out.println(users);
      } catch (ApiException e) {
        System.err.println("Exception when calling SystemusersApi#systemusersList");
        e.printStackTrace();
      }

      // Example 2: Make an API call to update a system user

      Systemuserput putRequest = new Systemuserput();
      putRequest.setLastname("Updated Last Name");

      try {
        Systemuserreturn user = systemUsersApi.systemusersPut(
            systemUserId, contentType, accept, putRequest, xOrgId);
        System.out.println(user);
      } catch (ApiException e) {
        System.err.println("Exception when calling SystemusersApi#systemusersPut");
        e.printStackTrace();
      }
    }
  }

  ```

5. Generate your project's JAR by executing:

  ```shell
  mvn package
  ```

  Or, depending on your workflow:

  ```shell
  mvn clean package
  ```

6. Execute the code with the following command (assuming you used
  `maven-dependency-plugin` as described above):

  ```shell
  java -cp "target/*" SystemusersApiExample
  ```

#### API v2 Example

Follow the instructions in the [API v1 Example](#api-v1-example) section but
instead of installing the Java client for [jcapiv1](jcapiv1), install it for
[jcapiv2](jcapiv2), and instead of adding the API v1 example code, add the
following example code to your project as `UserGroupsApiExample.java` (replace the
placeholder values with your actual values):

```java
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.Configuration;
import io.swagger.client.api.UserGroupsApi;
import io.swagger.client.auth.ApiKeyAuth;
import io.swagger.client.model.UserGroup;
import java.util.List;

public class UserGroupsApiExample {
  public static void main(String[] args) {
    String apiKey = "YOUR_API_KEY";
    String xOrgId = ""; // Only required of administrators that manage multiple organizations

    String contentType = "application/json";
    String accept = "application/json";

    // Set up the configuration object with your API key for authorization
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    ApiKeyAuth xApiKey = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
    xApiKey.setApiKey(apiKey);

    // Instantiate the API object for the group of endpoints you need to use,
    // for instance the system users API
    UserGroupsApi userGroupsApi = new UserGroupsApi();

    // Make an API call to retrieve user groups

    List<String> fields = null;
    List<String> filter = null;
    Integer limit = null;
    Integer skip = null;
    List<String> sort = null;

    try {
      List<UserGroup> userGroups = userGroupsApi.groupsUserList(
          contentType, accept, fields, filter, limit, skip, sort, xOrgId);
      System.out.println(userGroups);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserGroupsApi#groupsUserList");
      e.printStackTrace();
    }
  }
}

```

#### System Context Authorization Example

Follow the instructions in the [API v1 Example](#api-v1-example) section but
instead of installing the Java client for [jcapiv1](jcapiv1), install it for
[jcapiv2](jcapiv2), and instead of adding the API v1 example code, add the
following example code to your project as `SystemsApiExample.java` (replace the
placeholder values with your actual values):

```java
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.api.SystemsApi;
import io.swagger.client.model.GraphObjectWithPaths;
import java.util.List;

public class SystemsApiExample {
  public static void main(String[] args) {
    // Set headers for System Context Authorization. For detailed instructions on
    // how to generate these headers, refer to:
    // https://docs.jumpcloud.com/2.0/authentication-and-authorization/system-context
    String systemId = "YOUR_SYSTEM_ID";
    // The current date on the system, e.g. "Thu, 23 Jan 1996 00:00:00 GMT"
    String systemDate = "YOUR_SYSTEM_DATE";
    String systemSignature = "YOUR_SYTEM_SIGNATURE";
    String systemContextAuth = String.format(
        "Signature "
            + "keyId=\"system/%s\","
            + "headers=\"request-line date\","
            + "algorithm=\"rsa-sha256\","
            + "signature=\"%s\"",
        systemId, systemSignature);
    String xOrgId = ""; // Only required of administrators that manage multiple organizations

    String contentType = "application/json";
    String accept = "application/json";

    // Instantiate the API object for the group of endpoints you need to use,
    // for instance the systems API
    SystemsApi systemsApi = new SystemsApi();

    // Make an API call to retrieve all system groups this system is a member of

    List<String> filter = null;
    Integer limit = null;
    Integer skip = null;
    List<String> sort = null;

    try {
      List<GraphObjectWithPaths> systemGroups = systemsApi.graphSystemMemberOf(
          systemId, contentType, accept, filter, limit,
          skip, systemDate, systemContextAuth, sort, xOrgId);
      System.out.println(systemGroups);
    } catch (ApiException e) {
      System.err.println("Exception when calling SystemsApi#graphSystemMemberOf");
      e.printStackTrace();
    }
  }
}

```
