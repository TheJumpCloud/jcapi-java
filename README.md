## JCAPI-Java

### Description

This repository contains the Java client code for the JumpCloud API v1 and v2.
It also provides the tools to generate the client code from the API yaml files, using swagger-codegen.
For detailed instructions on how to generate the code, see the [Contributing](CONTRIBUTING.md) section.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official maven documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Getting Started

1. Add this dependency to your project's POM:

   ```xml
<dependency>
    <groupId>com.jumpcloud</groupId>
    <artifactId>jcapi-java-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

   **Note:** There are several ways to include the JCAPI-Java Client and its dependencies in your project at runtime. The following is one way using the `maven-dependency-plugin` plugin, which will copy all the dependent jar files to your project's build directory.

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

2. Add the following example code to your project as `ApplicationsApiExample.java` (replace the text `YOUR API KEY` with the value of your actual API key):

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
        ApiKeyAuth x_api_key = (ApiKeyAuth) defaultClient.getAuthentication("x-api-key");
        x_api_key.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //x_api_key.setApiKeyPrefix("Token");

        ApplicationsApi apiInstance = new ApplicationsApi();
        String contentType = "application/json"; // String |
        String accept = "application/json"; // String |
        String fields = ""; // String | The comma separated fileds included in the returned records. If omitted the default list of fields will be returned.
        Integer limit = 10; // Integer | The number of records to return at once.
        Integer skip = 0; // Integer | The offset into the records to return.
        String sort = ""; // String | The comma separated fields used to sort the collection. Default sort is ascending, prefix with - to sort descending.
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

3. Generate your project's JAR by executing:

    ```shell
    mvn package
    ```

4. Execute the code with the following command (assuming you used the `maven-dependency-plugin` plugin as described above):

   ```shell
   java -cp "target/*" ApplicationsApiExample
   ```

### Authentication and Authorization

All endpoints support authentication via API key: see the [Authentication and Authorization](https://docs.jumpcloud.com/2.0/authentication-and-authorization/authentication-and-authorization-overview) section in our API docs.

Some Systems endpoints (in both API v1 and v2) also support the [System Context authorization](https://docs.jumpcloud.com/2.0/authentication-and-authorization/system-context) which allows an individual system to manage its information and resource associations.

### Usage Examples

For more detailed instructions, refer to each API's respective README file ([README for API v1](jcapiv1/README.md) and [README for API v2](jcapiv2/README.md)) and the generated docs under each folder.

#### API v1 example:

#### API v2 example:
