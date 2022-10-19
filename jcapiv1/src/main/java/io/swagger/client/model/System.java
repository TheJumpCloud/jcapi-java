/*
 * JumpCloud API
 * # Overview  JumpCloud's V1 API. This set of endpoints allows JumpCloud customers to manage commands, systems, and system users.  # API Key  ## Access Your API Key  To locate your API Key:  1. Log into the [JumpCloud Admin Console](https://console.jumpcloud.com/). 2. Go to the username drop down located in the top-right of the Console. 3. Retrieve your API key from API Settings.  ## API Key Considerations  This API key is associated to the currently logged in administrator. Other admins will have different API keys.  **WARNING** Please keep this API key secret, as it grants full access to any data accessible via your JumpCloud console account.  You can also reset your API key in the same location in the JumpCloud Admin Console.  ## Recycling or Resetting Your API Key  In order to revoke access with the current API key, simply reset your API key. This will render all calls using the previous API key inaccessible.  Your API key will be passed in as a header with the header name \"x-api-key\".  ```bash curl -H \"x-api-key: [YOUR_API_KEY_HERE]\" \"https://console.jumpcloud.com/api/systemusers\" ```  # System Context  * [Introduction](#introduction) * [Supported endpoints](#supported-endpoints) * [Response codes](#response-codes) * [Authentication](#authentication) * [Additional examples](#additional-examples) * [Third party](#third-party)  ## Introduction  JumpCloud System Context Authorization is an alternative way to authenticate with a subset of JumpCloud's REST APIs. Using this method, a system can manage its information and resource associations, allowing modern auto provisioning environments to scale as needed.  **Notes:**   * The following documentation applies to Linux Operating Systems only.  * Systems that have been automatically enrolled using Apple's Device Enrollment Program (DEP) or systems enrolled using the User Portal install are not eligible to use the System Context API to prevent unauthorized access to system groups and resources. If a script that utilizes the System Context API is invoked on a system enrolled in this way, it will display an error.  ## Supported Endpoints  JumpCloud System Context Authorization can be used in conjunction with Systems endpoints found in the V1 API and certain System Group endpoints found in the v2 API.  * A system may fetch, alter, and delete metadata about itself, including manipulating a system's Group and Systemuser associations,   * `/api/systems/{system_id}` | [`GET`](https://docs.jumpcloud.com/api/1.0/index.html#operation/systems_get) [`PUT`](https://docs.jumpcloud.com/api/1.0/index.html#operation/systems_put) * A system may delete itself from your JumpCloud organization   * `/api/systems/{system_id}` | [`DELETE`](https://docs.jumpcloud.com/api/1.0/index.html#operation/systems_delete) * A system may fetch its direct resource associations under v2 (Groups)   * `/api/v2/systems/{system_id}/memberof` | [`GET`](https://docs.jumpcloud.com/api/2.0/index.html#operation/graph_systemGroupMembership)   * `/api/v2/systems/{system_id}/associations` | [`GET`](https://docs.jumpcloud.com/api/2.0/index.html#operation/graph_systemAssociationsList)   * `/api/v2/systems/{system_id}/users` | [`GET`](https://docs.jumpcloud.com/api/2.0/index.html#operation/graph_systemTraverseUser) * A system may alter its direct resource associations under v2 (Groups)   * `/api/v2/systems/{system_id}/associations` | [`POST`](https://docs.jumpcloud.com/api/2.0/index.html#operation/graph_systemAssociationsPost) * A system may alter its System Group associations   * `/api/v2/systemgroups/{group_id}/members` | [`POST`](https://docs.jumpcloud.com/api/2.0/index.html#operation/graph_systemGroupMembersPost)     * _NOTE_ If a system attempts to alter the system group membership of a different system the request will be rejected  ## Response Codes  If endpoints other than those described above are called using the System Context API, the server will return a `401` response.  ## Authentication  To allow for secure access to our APIs, you must authenticate each API request. JumpCloud System Context Authorization uses [HTTP Signatures](https://tools.ietf.org/html/draft-cavage-http-signatures-00) to authenticate API requests. The HTTP Signatures sent with each request are similar to the signatures used by the Amazon Web Services REST API. To help with the request-signing process, we have provided an [example bash script](https://github.com/TheJumpCloud/SystemContextAPI/blob/master/examples/shell/SigningExample.sh). This example API request simply requests the entire system record. You must be root, or have permissions to access the contents of the `/opt/jc` directory to generate a signature.  Here is a breakdown of the example script with explanations.  First, the script extracts the systemKey from the JSON formatted `/opt/jc/jcagent.conf` file.  ```bash #!/bin/bash conf=\"`cat /opt/jc/jcagent.conf`\" regex=\"systemKey\\\":\\\"(\\w+)\\\"\"  if [[ $conf =~ $regex ]] ; then   systemKey=\"${BASH_REMATCH[1]}\" fi ```  Then, the script retrieves the current date in the correct format.  ```bash now=`date -u \"+%a, %d %h %Y %H:%M:%S GMT\"`; ```  Next, we build a signing string to demonstrate the expected signature format. The signed string must consist of the [request-line](https://tools.ietf.org/html/rfc2616#page-35) and the date header, separated by a newline character.  ```bash signstr=\"GET /api/systems/${systemKey} HTTP/1.1\\ndate: ${now}\" ```  The next step is to calculate and apply the signature. This is a two-step process:  1. Create a signature from the signing string using the JumpCloud Agent private key: ``printf \"$signstr\" | openssl dgst -sha256 -sign /opt/jc/client.key`` 2. Then Base64-encode the signature string and trim off the newline characters: ``| openssl enc -e -a | tr -d '\\n'``  The combined steps above result in:  ```bash signature=`printf \"$signstr\" | openssl dgst -sha256 -sign /opt/jc/client.key | openssl enc -e -a | tr -d '\\n'` ; ```  Finally, we make sure the API call sending the signature has the same Authorization and Date header values, HTTP method, and URL that were used in the signing string.  ```bash curl -iq \\   -H \"Accept: application/json\" \\   -H \"Content-Type: application/json\" \\   -H \"Date: ${now}\" \\   -H \"Authorization: Signature keyId=\\\"system/${systemKey}\\\",headers=\\\"request-line date\\\",algorithm=\\\"rsa-sha256\\\",signature=\\\"${signature}\\\"\" \\   --url https://console.jumpcloud.com/api/systems/${systemKey} ```  ### Input Data  All PUT and POST methods should use the HTTP Content-Type header with a value of 'application/json'. PUT methods are used for updating a record. POST methods are used to create a record.  The following example demonstrates how to update the `displayName` of the system.  ```bash signstr=\"PUT /api/systems/${systemKey} HTTP/1.1\\ndate: ${now}\" signature=`printf \"$signstr\" | openssl dgst -sha256 -sign /opt/jc/client.key | openssl enc -e -a | tr -d '\\n'` ;  curl -iq \\   -d \"{\\\"displayName\\\" : \\\"updated-system-name-1\\\"}\" \\   -X \"PUT\" \\   -H \"Content-Type: application/json\" \\   -H \"Accept: application/json\" \\   -H \"Date: ${now}\" \\   -H \"Authorization: Signature keyId=\\\"system/${systemKey}\\\",headers=\\\"request-line date\\\",algorithm=\\\"rsa-sha256\\\",signature=\\\"${signature}\\\"\" \\   --url https://console.jumpcloud.com/api/systems/${systemKey} ```  ### Output Data  All results will be formatted as JSON.  Here is an abbreviated example of response output:  ```json {   \"_id\": \"525ee96f52e144993e000015\",   \"agentServer\": \"lappy386\",   \"agentVersion\": \"0.9.42\",   \"arch\": \"x86_64\",   \"connectionKey\": \"127.0.0.1_51812\",   \"displayName\": \"ubuntu-1204\",   \"firstContact\": \"2013-10-16T19:30:55.611Z\",   \"hostname\": \"ubuntu-1204\"   ... ```  ## Additional Examples  ### Signing Authentication Example  This example demonstrates how to make an authenticated request to fetch the JumpCloud record for this system.  [SigningExample.sh](https://github.com/TheJumpCloud/SystemContextAPI/blob/master/examples/shell/SigningExample.sh)  ### Shutdown Hook  This example demonstrates how to make an authenticated request on system shutdown. Using an init.d script registered at run level 0, you can call the System Context API as the system is shutting down.  [Instance-shutdown-initd](https://github.com/TheJumpCloud/SystemContextAPI/blob/master/examples/instance-shutdown-initd) is an example of an init.d script that only runs at system shutdown.  After customizing the [instance-shutdown-initd](https://github.com/TheJumpCloud/SystemContextAPI/blob/master/examples/instance-shutdown-initd) script, you should install it on the system(s) running the JumpCloud agent.  1. Copy the modified [instance-shutdown-initd](https://github.com/TheJumpCloud/SystemContextAPI/blob/master/examples/instance-shutdown-initd) to `/etc/init.d/instance-shutdown`. 2. On Ubuntu systems, run `update-rc.d instance-shutdown defaults`. On RedHat/CentOS systems, run `chkconfig --add instance-shutdown`.  ## Third Party  ### Chef Cookbooks  [https://github.com/nshenry03/jumpcloud](https://github.com/nshenry03/jumpcloud)  [https://github.com/cjs226/jumpcloud](https://github.com/cjs226/jumpcloud)  # Multi-Tenant Portal Headers  Multi-Tenant Organization API Headers are available for JumpCloud Admins to use when making API requests from Organizations that have multiple managed organizations.  The `x-org-id` is a required header for all multi-tenant admins when making API requests to JumpCloud. This header will define to which organization you would like to make the request.  **NOTE** Single Tenant Admins do not need to provide this header when making an API request.  ## Header Value  `x-org-id`  ## API Response Codes  * `400` Malformed ID. * `400` x-org-id and Organization path ID do not match. * `401` ID not included for multi-tenant admin * `403` ID included on unsupported route. * `404` Organization ID Not Found.  ```bash curl -X GET https://console.jumpcloud.com/api/v2/directories \\   -H 'accept: application/json' \\   -H 'content-type: application/json' \\   -H 'x-api-key: {API_KEY}' \\   -H 'x-org-id: {ORG_ID}'  ```  ## To Obtain an Individual Organization ID via the UI  As a prerequisite, your Primary Organization will need to be setup for Multi-Tenancy. This provides access to the Multi-Tenant Organization Admin Portal.  1. Log into JumpCloud [Admin Console](https://console.jumpcloud.com). If you are a multi-tenant Admin, you will automatically be routed to the Multi-Tenant Admin Portal. 2. From the Multi-Tenant Portal's primary navigation bar, select the Organization you'd like to access. 3. You will automatically be routed to that Organization's Admin Console. 4. Go to Settings in the sub-tenant's primary navigation. 5. You can obtain your Organization ID below your Organization's Contact Information on the Settings page.  ## To Obtain All Organization IDs via the API  * You can make an API request to this endpoint using the API key of your Primary Organization.  `https://console.jumpcloud.com/api/organizations/` This will return all your managed organizations.  ```bash curl -X GET \\   https://console.jumpcloud.com/api/organizations/ \\   -H 'Accept: application/json' \\   -H 'Content-Type: application/json' \\   -H 'x-api-key: {API_KEY}' ```  # SDKs  You can find language specific SDKs that can help you kickstart your Integration with JumpCloud in the following GitHub repositories:  * [Python](https://github.com/TheJumpCloud/jcapi-python) * [Go](https://github.com/TheJumpCloud/jcapi-go) * [Ruby](https://github.com/TheJumpCloud/jcapi-ruby) * [Java](https://github.com/TheJumpCloud/jcapi-java) 
 *
 * OpenAPI spec version: 1.0
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
import io.swagger.client.model.Fde;
import io.swagger.client.model.SystemBuiltInCommands;
import io.swagger.client.model.SystemDomainInfo;
import io.swagger.client.model.SystemMdm;
import io.swagger.client.model.SystemNetworkInterfaces;
import io.swagger.client.model.SystemOsVersionDetail;
import io.swagger.client.model.SystemProvisionMetadata;
import io.swagger.client.model.SystemServiceAccountState;
import io.swagger.client.model.SystemSshdParams;
import io.swagger.client.model.SystemSystemInsights;
import io.swagger.client.model.SystemUserMetrics;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.OffsetDateTime;
/**
 * System
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-10-19T07:50:09.958678Z[Etc/UTC]")
public class System {
  @SerializedName("_id")
  private String _id = null;

  @SerializedName("active")
  private Boolean active = null;

  @SerializedName("agentVersion")
  private String agentVersion = null;

  @SerializedName("allowMultiFactorAuthentication")
  private Boolean allowMultiFactorAuthentication = null;

  @SerializedName("allowPublicKeyAuthentication")
  private Boolean allowPublicKeyAuthentication = null;

  @SerializedName("allowSshPasswordAuthentication")
  private Boolean allowSshPasswordAuthentication = null;

  @SerializedName("allowSshRootLogin")
  private Boolean allowSshRootLogin = null;

  @SerializedName("amazonInstanceID")
  private String amazonInstanceID = null;

  @SerializedName("arch")
  private String arch = null;

  @SerializedName("azureAdJoined")
  private Boolean azureAdJoined = null;

  @SerializedName("builtInCommands")
  private List<SystemBuiltInCommands> builtInCommands = null;

  @SerializedName("connectionHistory")
  private List<Object> connectionHistory = null;

  @SerializedName("created")
  private OffsetDateTime created = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("displayManager")
  private String displayManager = null;

  @SerializedName("displayName")
  private String displayName = null;

  @SerializedName("domainInfo")
  private SystemDomainInfo domainInfo = null;

  @SerializedName("fde")
  private Fde fde = null;

  @SerializedName("fileSystem")
  private String fileSystem = null;

  @SerializedName("hasServiceAccount")
  private Boolean hasServiceAccount = null;

  @SerializedName("hostname")
  private String hostname = null;

  @SerializedName("lastContact")
  private OffsetDateTime lastContact = null;

  @SerializedName("mdm")
  private SystemMdm mdm = null;

  @SerializedName("modifySSHDConfig")
  private Boolean modifySSHDConfig = null;

  @SerializedName("networkInterfaces")
  private List<SystemNetworkInterfaces> networkInterfaces = null;

  @SerializedName("organization")
  private String organization = null;

  @SerializedName("os")
  private String os = null;

  @SerializedName("osFamily")
  private String osFamily = null;

  @SerializedName("osVersionDetail")
  private SystemOsVersionDetail osVersionDetail = null;

  @SerializedName("provisionMetadata")
  private SystemProvisionMetadata provisionMetadata = null;

  @SerializedName("remoteIP")
  private String remoteIP = null;

  @SerializedName("serialNumber")
  private String serialNumber = null;

  @SerializedName("serviceAccountState")
  private SystemServiceAccountState serviceAccountState = null;

  @SerializedName("sshRootEnabled")
  private Boolean sshRootEnabled = null;

  @SerializedName("sshdParams")
  private List<SystemSshdParams> sshdParams = null;

  @SerializedName("systemInsights")
  private SystemSystemInsights systemInsights = null;

  @SerializedName("systemTimezone")
  private Integer systemTimezone = null;

  @SerializedName("tags")
  private List<String> tags = null;

  @SerializedName("templateName")
  private String templateName = null;

  @SerializedName("userMetrics")
  private List<SystemUserMetrics> userMetrics = null;

  @SerializedName("version")
  private String version = null;

  public System _id(String _id) {
    this._id = _id;
    return this;
  }

   /**
   * Get _id
   * @return _id
  **/
  @Schema(description = "")
  public String getId() {
    return _id;
  }

  public void setId(String _id) {
    this._id = _id;
  }

  public System active(Boolean active) {
    this.active = active;
    return this;
  }

   /**
   * Get active
   * @return active
  **/
  @Schema(description = "")
  public Boolean isActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public System agentVersion(String agentVersion) {
    this.agentVersion = agentVersion;
    return this;
  }

   /**
   * Get agentVersion
   * @return agentVersion
  **/
  @Schema(description = "")
  public String getAgentVersion() {
    return agentVersion;
  }

  public void setAgentVersion(String agentVersion) {
    this.agentVersion = agentVersion;
  }

  public System allowMultiFactorAuthentication(Boolean allowMultiFactorAuthentication) {
    this.allowMultiFactorAuthentication = allowMultiFactorAuthentication;
    return this;
  }

   /**
   * Get allowMultiFactorAuthentication
   * @return allowMultiFactorAuthentication
  **/
  @Schema(description = "")
  public Boolean isAllowMultiFactorAuthentication() {
    return allowMultiFactorAuthentication;
  }

  public void setAllowMultiFactorAuthentication(Boolean allowMultiFactorAuthentication) {
    this.allowMultiFactorAuthentication = allowMultiFactorAuthentication;
  }

  public System allowPublicKeyAuthentication(Boolean allowPublicKeyAuthentication) {
    this.allowPublicKeyAuthentication = allowPublicKeyAuthentication;
    return this;
  }

   /**
   * Get allowPublicKeyAuthentication
   * @return allowPublicKeyAuthentication
  **/
  @Schema(description = "")
  public Boolean isAllowPublicKeyAuthentication() {
    return allowPublicKeyAuthentication;
  }

  public void setAllowPublicKeyAuthentication(Boolean allowPublicKeyAuthentication) {
    this.allowPublicKeyAuthentication = allowPublicKeyAuthentication;
  }

  public System allowSshPasswordAuthentication(Boolean allowSshPasswordAuthentication) {
    this.allowSshPasswordAuthentication = allowSshPasswordAuthentication;
    return this;
  }

   /**
   * Get allowSshPasswordAuthentication
   * @return allowSshPasswordAuthentication
  **/
  @Schema(description = "")
  public Boolean isAllowSshPasswordAuthentication() {
    return allowSshPasswordAuthentication;
  }

  public void setAllowSshPasswordAuthentication(Boolean allowSshPasswordAuthentication) {
    this.allowSshPasswordAuthentication = allowSshPasswordAuthentication;
  }

  public System allowSshRootLogin(Boolean allowSshRootLogin) {
    this.allowSshRootLogin = allowSshRootLogin;
    return this;
  }

   /**
   * Get allowSshRootLogin
   * @return allowSshRootLogin
  **/
  @Schema(description = "")
  public Boolean isAllowSshRootLogin() {
    return allowSshRootLogin;
  }

  public void setAllowSshRootLogin(Boolean allowSshRootLogin) {
    this.allowSshRootLogin = allowSshRootLogin;
  }

  public System amazonInstanceID(String amazonInstanceID) {
    this.amazonInstanceID = amazonInstanceID;
    return this;
  }

   /**
   * Get amazonInstanceID
   * @return amazonInstanceID
  **/
  @Schema(description = "")
  public String getAmazonInstanceID() {
    return amazonInstanceID;
  }

  public void setAmazonInstanceID(String amazonInstanceID) {
    this.amazonInstanceID = amazonInstanceID;
  }

  public System arch(String arch) {
    this.arch = arch;
    return this;
  }

   /**
   * Get arch
   * @return arch
  **/
  @Schema(description = "")
  public String getArch() {
    return arch;
  }

  public void setArch(String arch) {
    this.arch = arch;
  }

  public System azureAdJoined(Boolean azureAdJoined) {
    this.azureAdJoined = azureAdJoined;
    return this;
  }

   /**
   * Get azureAdJoined
   * @return azureAdJoined
  **/
  @Schema(description = "")
  public Boolean isAzureAdJoined() {
    return azureAdJoined;
  }

  public void setAzureAdJoined(Boolean azureAdJoined) {
    this.azureAdJoined = azureAdJoined;
  }

   /**
   * Get builtInCommands
   * @return builtInCommands
  **/
  @Schema(description = "")
  public List<SystemBuiltInCommands> getBuiltInCommands() {
    return builtInCommands;
  }

  public System connectionHistory(List<Object> connectionHistory) {
    this.connectionHistory = connectionHistory;
    return this;
  }

  public System addConnectionHistoryItem(Object connectionHistoryItem) {
    if (this.connectionHistory == null) {
      this.connectionHistory = new ArrayList<Object>();
    }
    this.connectionHistory.add(connectionHistoryItem);
    return this;
  }

   /**
   * Get connectionHistory
   * @return connectionHistory
  **/
  @Schema(description = "")
  public List<Object> getConnectionHistory() {
    return connectionHistory;
  }

  public void setConnectionHistory(List<Object> connectionHistory) {
    this.connectionHistory = connectionHistory;
  }

  public System created(OffsetDateTime created) {
    this.created = created;
    return this;
  }

   /**
   * Get created
   * @return created
  **/
  @Schema(description = "")
  public OffsetDateTime getCreated() {
    return created;
  }

  public void setCreated(OffsetDateTime created) {
    this.created = created;
  }

  public System description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @Schema(description = "")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public System displayManager(String displayManager) {
    this.displayManager = displayManager;
    return this;
  }

   /**
   * Get displayManager
   * @return displayManager
  **/
  @Schema(description = "")
  public String getDisplayManager() {
    return displayManager;
  }

  public void setDisplayManager(String displayManager) {
    this.displayManager = displayManager;
  }

  public System displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }

   /**
   * Get displayName
   * @return displayName
  **/
  @Schema(description = "")
  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public System domainInfo(SystemDomainInfo domainInfo) {
    this.domainInfo = domainInfo;
    return this;
  }

   /**
   * Get domainInfo
   * @return domainInfo
  **/
  @Schema(description = "")
  public SystemDomainInfo getDomainInfo() {
    return domainInfo;
  }

  public void setDomainInfo(SystemDomainInfo domainInfo) {
    this.domainInfo = domainInfo;
  }

  public System fde(Fde fde) {
    this.fde = fde;
    return this;
  }

   /**
   * Get fde
   * @return fde
  **/
  @Schema(description = "")
  public Fde getFde() {
    return fde;
  }

  public void setFde(Fde fde) {
    this.fde = fde;
  }

  public System fileSystem(String fileSystem) {
    this.fileSystem = fileSystem;
    return this;
  }

   /**
   * Get fileSystem
   * @return fileSystem
  **/
  @Schema(description = "")
  public String getFileSystem() {
    return fileSystem;
  }

  public void setFileSystem(String fileSystem) {
    this.fileSystem = fileSystem;
  }

  public System hasServiceAccount(Boolean hasServiceAccount) {
    this.hasServiceAccount = hasServiceAccount;
    return this;
  }

   /**
   * Get hasServiceAccount
   * @return hasServiceAccount
  **/
  @Schema(description = "")
  public Boolean isHasServiceAccount() {
    return hasServiceAccount;
  }

  public void setHasServiceAccount(Boolean hasServiceAccount) {
    this.hasServiceAccount = hasServiceAccount;
  }

  public System hostname(String hostname) {
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

  public System lastContact(OffsetDateTime lastContact) {
    this.lastContact = lastContact;
    return this;
  }

   /**
   * Get lastContact
   * @return lastContact
  **/
  @Schema(description = "")
  public OffsetDateTime getLastContact() {
    return lastContact;
  }

  public void setLastContact(OffsetDateTime lastContact) {
    this.lastContact = lastContact;
  }

  public System mdm(SystemMdm mdm) {
    this.mdm = mdm;
    return this;
  }

   /**
   * Get mdm
   * @return mdm
  **/
  @Schema(description = "")
  public SystemMdm getMdm() {
    return mdm;
  }

  public void setMdm(SystemMdm mdm) {
    this.mdm = mdm;
  }

  public System modifySSHDConfig(Boolean modifySSHDConfig) {
    this.modifySSHDConfig = modifySSHDConfig;
    return this;
  }

   /**
   * Get modifySSHDConfig
   * @return modifySSHDConfig
  **/
  @Schema(description = "")
  public Boolean isModifySSHDConfig() {
    return modifySSHDConfig;
  }

  public void setModifySSHDConfig(Boolean modifySSHDConfig) {
    this.modifySSHDConfig = modifySSHDConfig;
  }

  public System networkInterfaces(List<SystemNetworkInterfaces> networkInterfaces) {
    this.networkInterfaces = networkInterfaces;
    return this;
  }

  public System addNetworkInterfacesItem(SystemNetworkInterfaces networkInterfacesItem) {
    if (this.networkInterfaces == null) {
      this.networkInterfaces = new ArrayList<SystemNetworkInterfaces>();
    }
    this.networkInterfaces.add(networkInterfacesItem);
    return this;
  }

   /**
   * Get networkInterfaces
   * @return networkInterfaces
  **/
  @Schema(description = "")
  public List<SystemNetworkInterfaces> getNetworkInterfaces() {
    return networkInterfaces;
  }

  public void setNetworkInterfaces(List<SystemNetworkInterfaces> networkInterfaces) {
    this.networkInterfaces = networkInterfaces;
  }

  public System organization(String organization) {
    this.organization = organization;
    return this;
  }

   /**
   * Get organization
   * @return organization
  **/
  @Schema(description = "")
  public String getOrganization() {
    return organization;
  }

  public void setOrganization(String organization) {
    this.organization = organization;
  }

  public System os(String os) {
    this.os = os;
    return this;
  }

   /**
   * Get os
   * @return os
  **/
  @Schema(description = "")
  public String getOs() {
    return os;
  }

  public void setOs(String os) {
    this.os = os;
  }

  public System osFamily(String osFamily) {
    this.osFamily = osFamily;
    return this;
  }

   /**
   * Get osFamily
   * @return osFamily
  **/
  @Schema(description = "")
  public String getOsFamily() {
    return osFamily;
  }

  public void setOsFamily(String osFamily) {
    this.osFamily = osFamily;
  }

  public System osVersionDetail(SystemOsVersionDetail osVersionDetail) {
    this.osVersionDetail = osVersionDetail;
    return this;
  }

   /**
   * Get osVersionDetail
   * @return osVersionDetail
  **/
  @Schema(description = "")
  public SystemOsVersionDetail getOsVersionDetail() {
    return osVersionDetail;
  }

  public void setOsVersionDetail(SystemOsVersionDetail osVersionDetail) {
    this.osVersionDetail = osVersionDetail;
  }

  public System provisionMetadata(SystemProvisionMetadata provisionMetadata) {
    this.provisionMetadata = provisionMetadata;
    return this;
  }

   /**
   * Get provisionMetadata
   * @return provisionMetadata
  **/
  @Schema(description = "")
  public SystemProvisionMetadata getProvisionMetadata() {
    return provisionMetadata;
  }

  public void setProvisionMetadata(SystemProvisionMetadata provisionMetadata) {
    this.provisionMetadata = provisionMetadata;
  }

  public System remoteIP(String remoteIP) {
    this.remoteIP = remoteIP;
    return this;
  }

   /**
   * Get remoteIP
   * @return remoteIP
  **/
  @Schema(description = "")
  public String getRemoteIP() {
    return remoteIP;
  }

  public void setRemoteIP(String remoteIP) {
    this.remoteIP = remoteIP;
  }

  public System serialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
    return this;
  }

   /**
   * Get serialNumber
   * @return serialNumber
  **/
  @Schema(description = "")
  public String getSerialNumber() {
    return serialNumber;
  }

  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  public System serviceAccountState(SystemServiceAccountState serviceAccountState) {
    this.serviceAccountState = serviceAccountState;
    return this;
  }

   /**
   * Get serviceAccountState
   * @return serviceAccountState
  **/
  @Schema(description = "")
  public SystemServiceAccountState getServiceAccountState() {
    return serviceAccountState;
  }

  public void setServiceAccountState(SystemServiceAccountState serviceAccountState) {
    this.serviceAccountState = serviceAccountState;
  }

  public System sshRootEnabled(Boolean sshRootEnabled) {
    this.sshRootEnabled = sshRootEnabled;
    return this;
  }

   /**
   * Get sshRootEnabled
   * @return sshRootEnabled
  **/
  @Schema(description = "")
  public Boolean isSshRootEnabled() {
    return sshRootEnabled;
  }

  public void setSshRootEnabled(Boolean sshRootEnabled) {
    this.sshRootEnabled = sshRootEnabled;
  }

  public System sshdParams(List<SystemSshdParams> sshdParams) {
    this.sshdParams = sshdParams;
    return this;
  }

  public System addSshdParamsItem(SystemSshdParams sshdParamsItem) {
    if (this.sshdParams == null) {
      this.sshdParams = new ArrayList<SystemSshdParams>();
    }
    this.sshdParams.add(sshdParamsItem);
    return this;
  }

   /**
   * Get sshdParams
   * @return sshdParams
  **/
  @Schema(description = "")
  public List<SystemSshdParams> getSshdParams() {
    return sshdParams;
  }

  public void setSshdParams(List<SystemSshdParams> sshdParams) {
    this.sshdParams = sshdParams;
  }

  public System systemInsights(SystemSystemInsights systemInsights) {
    this.systemInsights = systemInsights;
    return this;
  }

   /**
   * Get systemInsights
   * @return systemInsights
  **/
  @Schema(description = "")
  public SystemSystemInsights getSystemInsights() {
    return systemInsights;
  }

  public void setSystemInsights(SystemSystemInsights systemInsights) {
    this.systemInsights = systemInsights;
  }

  public System systemTimezone(Integer systemTimezone) {
    this.systemTimezone = systemTimezone;
    return this;
  }

   /**
   * Get systemTimezone
   * @return systemTimezone
  **/
  @Schema(description = "")
  public Integer getSystemTimezone() {
    return systemTimezone;
  }

  public void setSystemTimezone(Integer systemTimezone) {
    this.systemTimezone = systemTimezone;
  }

  public System tags(List<String> tags) {
    this.tags = tags;
    return this;
  }

  public System addTagsItem(String tagsItem) {
    if (this.tags == null) {
      this.tags = new ArrayList<String>();
    }
    this.tags.add(tagsItem);
    return this;
  }

   /**
   * Get tags
   * @return tags
  **/
  @Schema(description = "")
  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  public System templateName(String templateName) {
    this.templateName = templateName;
    return this;
  }

   /**
   * Get templateName
   * @return templateName
  **/
  @Schema(description = "")
  public String getTemplateName() {
    return templateName;
  }

  public void setTemplateName(String templateName) {
    this.templateName = templateName;
  }

  public System userMetrics(List<SystemUserMetrics> userMetrics) {
    this.userMetrics = userMetrics;
    return this;
  }

  public System addUserMetricsItem(SystemUserMetrics userMetricsItem) {
    if (this.userMetrics == null) {
      this.userMetrics = new ArrayList<SystemUserMetrics>();
    }
    this.userMetrics.add(userMetricsItem);
    return this;
  }

   /**
   * Get userMetrics
   * @return userMetrics
  **/
  @Schema(description = "")
  public List<SystemUserMetrics> getUserMetrics() {
    return userMetrics;
  }

  public void setUserMetrics(List<SystemUserMetrics> userMetrics) {
    this.userMetrics = userMetrics;
  }

  public System version(String version) {
    this.version = version;
    return this;
  }

   /**
   * Get version
   * @return version
  **/
  @Schema(description = "")
  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    System system = (System) o;
    return Objects.equals(this._id, system._id) &&
        Objects.equals(this.active, system.active) &&
        Objects.equals(this.agentVersion, system.agentVersion) &&
        Objects.equals(this.allowMultiFactorAuthentication, system.allowMultiFactorAuthentication) &&
        Objects.equals(this.allowPublicKeyAuthentication, system.allowPublicKeyAuthentication) &&
        Objects.equals(this.allowSshPasswordAuthentication, system.allowSshPasswordAuthentication) &&
        Objects.equals(this.allowSshRootLogin, system.allowSshRootLogin) &&
        Objects.equals(this.amazonInstanceID, system.amazonInstanceID) &&
        Objects.equals(this.arch, system.arch) &&
        Objects.equals(this.azureAdJoined, system.azureAdJoined) &&
        Objects.equals(this.builtInCommands, system.builtInCommands) &&
        Objects.equals(this.connectionHistory, system.connectionHistory) &&
        Objects.equals(this.created, system.created) &&
        Objects.equals(this.description, system.description) &&
        Objects.equals(this.displayManager, system.displayManager) &&
        Objects.equals(this.displayName, system.displayName) &&
        Objects.equals(this.domainInfo, system.domainInfo) &&
        Objects.equals(this.fde, system.fde) &&
        Objects.equals(this.fileSystem, system.fileSystem) &&
        Objects.equals(this.hasServiceAccount, system.hasServiceAccount) &&
        Objects.equals(this.hostname, system.hostname) &&
        Objects.equals(this.lastContact, system.lastContact) &&
        Objects.equals(this.mdm, system.mdm) &&
        Objects.equals(this.modifySSHDConfig, system.modifySSHDConfig) &&
        Objects.equals(this.networkInterfaces, system.networkInterfaces) &&
        Objects.equals(this.organization, system.organization) &&
        Objects.equals(this.os, system.os) &&
        Objects.equals(this.osFamily, system.osFamily) &&
        Objects.equals(this.osVersionDetail, system.osVersionDetail) &&
        Objects.equals(this.provisionMetadata, system.provisionMetadata) &&
        Objects.equals(this.remoteIP, system.remoteIP) &&
        Objects.equals(this.serialNumber, system.serialNumber) &&
        Objects.equals(this.serviceAccountState, system.serviceAccountState) &&
        Objects.equals(this.sshRootEnabled, system.sshRootEnabled) &&
        Objects.equals(this.sshdParams, system.sshdParams) &&
        Objects.equals(this.systemInsights, system.systemInsights) &&
        Objects.equals(this.systemTimezone, system.systemTimezone) &&
        Objects.equals(this.tags, system.tags) &&
        Objects.equals(this.templateName, system.templateName) &&
        Objects.equals(this.userMetrics, system.userMetrics) &&
        Objects.equals(this.version, system.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(_id, active, agentVersion, allowMultiFactorAuthentication, allowPublicKeyAuthentication, allowSshPasswordAuthentication, allowSshRootLogin, amazonInstanceID, arch, azureAdJoined, builtInCommands, connectionHistory, created, description, displayManager, displayName, domainInfo, fde, fileSystem, hasServiceAccount, hostname, lastContact, mdm, modifySSHDConfig, networkInterfaces, organization, os, osFamily, osVersionDetail, provisionMetadata, remoteIP, serialNumber, serviceAccountState, sshRootEnabled, sshdParams, systemInsights, systemTimezone, tags, templateName, userMetrics, version);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class System {\n");
    
    sb.append("    _id: ").append(toIndentedString(_id)).append("\n");
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    agentVersion: ").append(toIndentedString(agentVersion)).append("\n");
    sb.append("    allowMultiFactorAuthentication: ").append(toIndentedString(allowMultiFactorAuthentication)).append("\n");
    sb.append("    allowPublicKeyAuthentication: ").append(toIndentedString(allowPublicKeyAuthentication)).append("\n");
    sb.append("    allowSshPasswordAuthentication: ").append(toIndentedString(allowSshPasswordAuthentication)).append("\n");
    sb.append("    allowSshRootLogin: ").append(toIndentedString(allowSshRootLogin)).append("\n");
    sb.append("    amazonInstanceID: ").append(toIndentedString(amazonInstanceID)).append("\n");
    sb.append("    arch: ").append(toIndentedString(arch)).append("\n");
    sb.append("    azureAdJoined: ").append(toIndentedString(azureAdJoined)).append("\n");
    sb.append("    builtInCommands: ").append(toIndentedString(builtInCommands)).append("\n");
    sb.append("    connectionHistory: ").append(toIndentedString(connectionHistory)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    displayManager: ").append(toIndentedString(displayManager)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    domainInfo: ").append(toIndentedString(domainInfo)).append("\n");
    sb.append("    fde: ").append(toIndentedString(fde)).append("\n");
    sb.append("    fileSystem: ").append(toIndentedString(fileSystem)).append("\n");
    sb.append("    hasServiceAccount: ").append(toIndentedString(hasServiceAccount)).append("\n");
    sb.append("    hostname: ").append(toIndentedString(hostname)).append("\n");
    sb.append("    lastContact: ").append(toIndentedString(lastContact)).append("\n");
    sb.append("    mdm: ").append(toIndentedString(mdm)).append("\n");
    sb.append("    modifySSHDConfig: ").append(toIndentedString(modifySSHDConfig)).append("\n");
    sb.append("    networkInterfaces: ").append(toIndentedString(networkInterfaces)).append("\n");
    sb.append("    organization: ").append(toIndentedString(organization)).append("\n");
    sb.append("    os: ").append(toIndentedString(os)).append("\n");
    sb.append("    osFamily: ").append(toIndentedString(osFamily)).append("\n");
    sb.append("    osVersionDetail: ").append(toIndentedString(osVersionDetail)).append("\n");
    sb.append("    provisionMetadata: ").append(toIndentedString(provisionMetadata)).append("\n");
    sb.append("    remoteIP: ").append(toIndentedString(remoteIP)).append("\n");
    sb.append("    serialNumber: ").append(toIndentedString(serialNumber)).append("\n");
    sb.append("    serviceAccountState: ").append(toIndentedString(serviceAccountState)).append("\n");
    sb.append("    sshRootEnabled: ").append(toIndentedString(sshRootEnabled)).append("\n");
    sb.append("    sshdParams: ").append(toIndentedString(sshdParams)).append("\n");
    sb.append("    systemInsights: ").append(toIndentedString(systemInsights)).append("\n");
    sb.append("    systemTimezone: ").append(toIndentedString(systemTimezone)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    templateName: ").append(toIndentedString(templateName)).append("\n");
    sb.append("    userMetrics: ").append(toIndentedString(userMetrics)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
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
