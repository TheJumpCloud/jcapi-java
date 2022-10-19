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

package io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
/**
 * SystemInsightsSystemInfo
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-10-19T07:49:49.516358Z[Etc/UTC]")
public class SystemInsightsSystemInfo {
  @SerializedName("collection_time")
  private String collectionTime = null;

  @SerializedName("computer_name")
  private String computerName = null;

  @SerializedName("cpu_brand")
  private String cpuBrand = null;

  @SerializedName("cpu_logical_cores")
  private Integer cpuLogicalCores = null;

  @SerializedName("cpu_microcode")
  private String cpuMicrocode = null;

  @SerializedName("cpu_physical_cores")
  private Integer cpuPhysicalCores = null;

  @SerializedName("cpu_subtype")
  private String cpuSubtype = null;

  @SerializedName("cpu_type")
  private String cpuType = null;

  @SerializedName("hardware_model")
  private String hardwareModel = null;

  @SerializedName("hardware_serial")
  private String hardwareSerial = null;

  @SerializedName("hardware_vendor")
  private String hardwareVendor = null;

  @SerializedName("hardware_version")
  private String hardwareVersion = null;

  @SerializedName("hostname")
  private String hostname = null;

  @SerializedName("local_hostname")
  private String localHostname = null;

  @SerializedName("physical_memory")
  private String physicalMemory = null;

  @SerializedName("system_id")
  private String systemId = null;

  @SerializedName("uuid")
  private String uuid = null;

  public SystemInsightsSystemInfo collectionTime(String collectionTime) {
    this.collectionTime = collectionTime;
    return this;
  }

   /**
   * Get collectionTime
   * @return collectionTime
  **/
  @Schema(description = "")
  public String getCollectionTime() {
    return collectionTime;
  }

  public void setCollectionTime(String collectionTime) {
    this.collectionTime = collectionTime;
  }

  public SystemInsightsSystemInfo computerName(String computerName) {
    this.computerName = computerName;
    return this;
  }

   /**
   * Get computerName
   * @return computerName
  **/
  @Schema(description = "")
  public String getComputerName() {
    return computerName;
  }

  public void setComputerName(String computerName) {
    this.computerName = computerName;
  }

  public SystemInsightsSystemInfo cpuBrand(String cpuBrand) {
    this.cpuBrand = cpuBrand;
    return this;
  }

   /**
   * Get cpuBrand
   * @return cpuBrand
  **/
  @Schema(description = "")
  public String getCpuBrand() {
    return cpuBrand;
  }

  public void setCpuBrand(String cpuBrand) {
    this.cpuBrand = cpuBrand;
  }

  public SystemInsightsSystemInfo cpuLogicalCores(Integer cpuLogicalCores) {
    this.cpuLogicalCores = cpuLogicalCores;
    return this;
  }

   /**
   * Get cpuLogicalCores
   * @return cpuLogicalCores
  **/
  @Schema(description = "")
  public Integer getCpuLogicalCores() {
    return cpuLogicalCores;
  }

  public void setCpuLogicalCores(Integer cpuLogicalCores) {
    this.cpuLogicalCores = cpuLogicalCores;
  }

  public SystemInsightsSystemInfo cpuMicrocode(String cpuMicrocode) {
    this.cpuMicrocode = cpuMicrocode;
    return this;
  }

   /**
   * Get cpuMicrocode
   * @return cpuMicrocode
  **/
  @Schema(description = "")
  public String getCpuMicrocode() {
    return cpuMicrocode;
  }

  public void setCpuMicrocode(String cpuMicrocode) {
    this.cpuMicrocode = cpuMicrocode;
  }

  public SystemInsightsSystemInfo cpuPhysicalCores(Integer cpuPhysicalCores) {
    this.cpuPhysicalCores = cpuPhysicalCores;
    return this;
  }

   /**
   * Get cpuPhysicalCores
   * @return cpuPhysicalCores
  **/
  @Schema(description = "")
  public Integer getCpuPhysicalCores() {
    return cpuPhysicalCores;
  }

  public void setCpuPhysicalCores(Integer cpuPhysicalCores) {
    this.cpuPhysicalCores = cpuPhysicalCores;
  }

  public SystemInsightsSystemInfo cpuSubtype(String cpuSubtype) {
    this.cpuSubtype = cpuSubtype;
    return this;
  }

   /**
   * Get cpuSubtype
   * @return cpuSubtype
  **/
  @Schema(description = "")
  public String getCpuSubtype() {
    return cpuSubtype;
  }

  public void setCpuSubtype(String cpuSubtype) {
    this.cpuSubtype = cpuSubtype;
  }

  public SystemInsightsSystemInfo cpuType(String cpuType) {
    this.cpuType = cpuType;
    return this;
  }

   /**
   * Get cpuType
   * @return cpuType
  **/
  @Schema(description = "")
  public String getCpuType() {
    return cpuType;
  }

  public void setCpuType(String cpuType) {
    this.cpuType = cpuType;
  }

  public SystemInsightsSystemInfo hardwareModel(String hardwareModel) {
    this.hardwareModel = hardwareModel;
    return this;
  }

   /**
   * Get hardwareModel
   * @return hardwareModel
  **/
  @Schema(description = "")
  public String getHardwareModel() {
    return hardwareModel;
  }

  public void setHardwareModel(String hardwareModel) {
    this.hardwareModel = hardwareModel;
  }

  public SystemInsightsSystemInfo hardwareSerial(String hardwareSerial) {
    this.hardwareSerial = hardwareSerial;
    return this;
  }

   /**
   * Get hardwareSerial
   * @return hardwareSerial
  **/
  @Schema(description = "")
  public String getHardwareSerial() {
    return hardwareSerial;
  }

  public void setHardwareSerial(String hardwareSerial) {
    this.hardwareSerial = hardwareSerial;
  }

  public SystemInsightsSystemInfo hardwareVendor(String hardwareVendor) {
    this.hardwareVendor = hardwareVendor;
    return this;
  }

   /**
   * Get hardwareVendor
   * @return hardwareVendor
  **/
  @Schema(description = "")
  public String getHardwareVendor() {
    return hardwareVendor;
  }

  public void setHardwareVendor(String hardwareVendor) {
    this.hardwareVendor = hardwareVendor;
  }

  public SystemInsightsSystemInfo hardwareVersion(String hardwareVersion) {
    this.hardwareVersion = hardwareVersion;
    return this;
  }

   /**
   * Get hardwareVersion
   * @return hardwareVersion
  **/
  @Schema(description = "")
  public String getHardwareVersion() {
    return hardwareVersion;
  }

  public void setHardwareVersion(String hardwareVersion) {
    this.hardwareVersion = hardwareVersion;
  }

  public SystemInsightsSystemInfo hostname(String hostname) {
    this.hostname = hostname;
    return this;
  }

   /**
   * Get hostname
   * @return hostname
  **/
  @Schema(description = "")
  public String getHostname() {
    return hostname;
  }

  public void setHostname(String hostname) {
    this.hostname = hostname;
  }

  public SystemInsightsSystemInfo localHostname(String localHostname) {
    this.localHostname = localHostname;
    return this;
  }

   /**
   * Get localHostname
   * @return localHostname
  **/
  @Schema(description = "")
  public String getLocalHostname() {
    return localHostname;
  }

  public void setLocalHostname(String localHostname) {
    this.localHostname = localHostname;
  }

  public SystemInsightsSystemInfo physicalMemory(String physicalMemory) {
    this.physicalMemory = physicalMemory;
    return this;
  }

   /**
   * Get physicalMemory
   * @return physicalMemory
  **/
  @Schema(description = "")
  public String getPhysicalMemory() {
    return physicalMemory;
  }

  public void setPhysicalMemory(String physicalMemory) {
    this.physicalMemory = physicalMemory;
  }

  public SystemInsightsSystemInfo systemId(String systemId) {
    this.systemId = systemId;
    return this;
  }

   /**
   * Get systemId
   * @return systemId
  **/
  @Schema(description = "")
  public String getSystemId() {
    return systemId;
  }

  public void setSystemId(String systemId) {
    this.systemId = systemId;
  }

  public SystemInsightsSystemInfo uuid(String uuid) {
    this.uuid = uuid;
    return this;
  }

   /**
   * Get uuid
   * @return uuid
  **/
  @Schema(description = "")
  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SystemInsightsSystemInfo systemInsightsSystemInfo = (SystemInsightsSystemInfo) o;
    return Objects.equals(this.collectionTime, systemInsightsSystemInfo.collectionTime) &&
        Objects.equals(this.computerName, systemInsightsSystemInfo.computerName) &&
        Objects.equals(this.cpuBrand, systemInsightsSystemInfo.cpuBrand) &&
        Objects.equals(this.cpuLogicalCores, systemInsightsSystemInfo.cpuLogicalCores) &&
        Objects.equals(this.cpuMicrocode, systemInsightsSystemInfo.cpuMicrocode) &&
        Objects.equals(this.cpuPhysicalCores, systemInsightsSystemInfo.cpuPhysicalCores) &&
        Objects.equals(this.cpuSubtype, systemInsightsSystemInfo.cpuSubtype) &&
        Objects.equals(this.cpuType, systemInsightsSystemInfo.cpuType) &&
        Objects.equals(this.hardwareModel, systemInsightsSystemInfo.hardwareModel) &&
        Objects.equals(this.hardwareSerial, systemInsightsSystemInfo.hardwareSerial) &&
        Objects.equals(this.hardwareVendor, systemInsightsSystemInfo.hardwareVendor) &&
        Objects.equals(this.hardwareVersion, systemInsightsSystemInfo.hardwareVersion) &&
        Objects.equals(this.hostname, systemInsightsSystemInfo.hostname) &&
        Objects.equals(this.localHostname, systemInsightsSystemInfo.localHostname) &&
        Objects.equals(this.physicalMemory, systemInsightsSystemInfo.physicalMemory) &&
        Objects.equals(this.systemId, systemInsightsSystemInfo.systemId) &&
        Objects.equals(this.uuid, systemInsightsSystemInfo.uuid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(collectionTime, computerName, cpuBrand, cpuLogicalCores, cpuMicrocode, cpuPhysicalCores, cpuSubtype, cpuType, hardwareModel, hardwareSerial, hardwareVendor, hardwareVersion, hostname, localHostname, physicalMemory, systemId, uuid);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemInsightsSystemInfo {\n");
    
    sb.append("    collectionTime: ").append(toIndentedString(collectionTime)).append("\n");
    sb.append("    computerName: ").append(toIndentedString(computerName)).append("\n");
    sb.append("    cpuBrand: ").append(toIndentedString(cpuBrand)).append("\n");
    sb.append("    cpuLogicalCores: ").append(toIndentedString(cpuLogicalCores)).append("\n");
    sb.append("    cpuMicrocode: ").append(toIndentedString(cpuMicrocode)).append("\n");
    sb.append("    cpuPhysicalCores: ").append(toIndentedString(cpuPhysicalCores)).append("\n");
    sb.append("    cpuSubtype: ").append(toIndentedString(cpuSubtype)).append("\n");
    sb.append("    cpuType: ").append(toIndentedString(cpuType)).append("\n");
    sb.append("    hardwareModel: ").append(toIndentedString(hardwareModel)).append("\n");
    sb.append("    hardwareSerial: ").append(toIndentedString(hardwareSerial)).append("\n");
    sb.append("    hardwareVendor: ").append(toIndentedString(hardwareVendor)).append("\n");
    sb.append("    hardwareVersion: ").append(toIndentedString(hardwareVersion)).append("\n");
    sb.append("    hostname: ").append(toIndentedString(hostname)).append("\n");
    sb.append("    localHostname: ").append(toIndentedString(localHostname)).append("\n");
    sb.append("    physicalMemory: ").append(toIndentedString(physicalMemory)).append("\n");
    sb.append("    systemId: ").append(toIndentedString(systemId)).append("\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
