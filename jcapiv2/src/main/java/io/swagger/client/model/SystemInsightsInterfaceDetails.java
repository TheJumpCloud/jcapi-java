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
 * SystemInsightsInterfaceDetails
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-10-19T07:49:49.516358Z[Etc/UTC]")
public class SystemInsightsInterfaceDetails {
  @SerializedName("collisions")
  private String collisions = null;

  @SerializedName("connection_id")
  private String connectionId = null;

  @SerializedName("connection_status")
  private String connectionStatus = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("dhcp_enabled")
  private Integer dhcpEnabled = null;

  @SerializedName("dhcp_lease_expires")
  private String dhcpLeaseExpires = null;

  @SerializedName("dhcp_lease_obtained")
  private String dhcpLeaseObtained = null;

  @SerializedName("dhcp_server")
  private String dhcpServer = null;

  @SerializedName("dns_domain")
  private String dnsDomain = null;

  @SerializedName("dns_domain_suffix_search_order")
  private String dnsDomainSuffixSearchOrder = null;

  @SerializedName("dns_host_name")
  private String dnsHostName = null;

  @SerializedName("dns_server_search_order")
  private String dnsServerSearchOrder = null;

  @SerializedName("enabled")
  private Integer enabled = null;

  @SerializedName("flags")
  private Integer flags = null;

  @SerializedName("friendly_name")
  private String friendlyName = null;

  @SerializedName("ibytes")
  private String ibytes = null;

  @SerializedName("idrops")
  private String idrops = null;

  @SerializedName("ierrors")
  private String ierrors = null;

  @SerializedName("interface")
  private String _interface = null;

  @SerializedName("ipackets")
  private String ipackets = null;

  @SerializedName("last_change")
  private String lastChange = null;

  @SerializedName("link_speed")
  private String linkSpeed = null;

  @SerializedName("mac")
  private String mac = null;

  @SerializedName("manufacturer")
  private String manufacturer = null;

  @SerializedName("metric")
  private Integer metric = null;

  @SerializedName("mtu")
  private Integer mtu = null;

  @SerializedName("obytes")
  private String obytes = null;

  @SerializedName("odrops")
  private String odrops = null;

  @SerializedName("oerrors")
  private String oerrors = null;

  @SerializedName("opackets")
  private String opackets = null;

  @SerializedName("pci_slot")
  private String pciSlot = null;

  @SerializedName("physical_adapter")
  private Integer physicalAdapter = null;

  @SerializedName("service")
  private String service = null;

  @SerializedName("speed")
  private Integer speed = null;

  @SerializedName("system_id")
  private String systemId = null;

  @SerializedName("type")
  private Integer type = null;

  public SystemInsightsInterfaceDetails collisions(String collisions) {
    this.collisions = collisions;
    return this;
  }

   /**
   * Get collisions
   * @return collisions
  **/
  @Schema(description = "")
  public String getCollisions() {
    return collisions;
  }

  public void setCollisions(String collisions) {
    this.collisions = collisions;
  }

  public SystemInsightsInterfaceDetails connectionId(String connectionId) {
    this.connectionId = connectionId;
    return this;
  }

   /**
   * Get connectionId
   * @return connectionId
  **/
  @Schema(description = "")
  public String getConnectionId() {
    return connectionId;
  }

  public void setConnectionId(String connectionId) {
    this.connectionId = connectionId;
  }

  public SystemInsightsInterfaceDetails connectionStatus(String connectionStatus) {
    this.connectionStatus = connectionStatus;
    return this;
  }

   /**
   * Get connectionStatus
   * @return connectionStatus
  **/
  @Schema(description = "")
  public String getConnectionStatus() {
    return connectionStatus;
  }

  public void setConnectionStatus(String connectionStatus) {
    this.connectionStatus = connectionStatus;
  }

  public SystemInsightsInterfaceDetails description(String description) {
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

  public SystemInsightsInterfaceDetails dhcpEnabled(Integer dhcpEnabled) {
    this.dhcpEnabled = dhcpEnabled;
    return this;
  }

   /**
   * Get dhcpEnabled
   * @return dhcpEnabled
  **/
  @Schema(description = "")
  public Integer getDhcpEnabled() {
    return dhcpEnabled;
  }

  public void setDhcpEnabled(Integer dhcpEnabled) {
    this.dhcpEnabled = dhcpEnabled;
  }

  public SystemInsightsInterfaceDetails dhcpLeaseExpires(String dhcpLeaseExpires) {
    this.dhcpLeaseExpires = dhcpLeaseExpires;
    return this;
  }

   /**
   * Get dhcpLeaseExpires
   * @return dhcpLeaseExpires
  **/
  @Schema(description = "")
  public String getDhcpLeaseExpires() {
    return dhcpLeaseExpires;
  }

  public void setDhcpLeaseExpires(String dhcpLeaseExpires) {
    this.dhcpLeaseExpires = dhcpLeaseExpires;
  }

  public SystemInsightsInterfaceDetails dhcpLeaseObtained(String dhcpLeaseObtained) {
    this.dhcpLeaseObtained = dhcpLeaseObtained;
    return this;
  }

   /**
   * Get dhcpLeaseObtained
   * @return dhcpLeaseObtained
  **/
  @Schema(description = "")
  public String getDhcpLeaseObtained() {
    return dhcpLeaseObtained;
  }

  public void setDhcpLeaseObtained(String dhcpLeaseObtained) {
    this.dhcpLeaseObtained = dhcpLeaseObtained;
  }

  public SystemInsightsInterfaceDetails dhcpServer(String dhcpServer) {
    this.dhcpServer = dhcpServer;
    return this;
  }

   /**
   * Get dhcpServer
   * @return dhcpServer
  **/
  @Schema(description = "")
  public String getDhcpServer() {
    return dhcpServer;
  }

  public void setDhcpServer(String dhcpServer) {
    this.dhcpServer = dhcpServer;
  }

  public SystemInsightsInterfaceDetails dnsDomain(String dnsDomain) {
    this.dnsDomain = dnsDomain;
    return this;
  }

   /**
   * Get dnsDomain
   * @return dnsDomain
  **/
  @Schema(description = "")
  public String getDnsDomain() {
    return dnsDomain;
  }

  public void setDnsDomain(String dnsDomain) {
    this.dnsDomain = dnsDomain;
  }

  public SystemInsightsInterfaceDetails dnsDomainSuffixSearchOrder(String dnsDomainSuffixSearchOrder) {
    this.dnsDomainSuffixSearchOrder = dnsDomainSuffixSearchOrder;
    return this;
  }

   /**
   * Get dnsDomainSuffixSearchOrder
   * @return dnsDomainSuffixSearchOrder
  **/
  @Schema(description = "")
  public String getDnsDomainSuffixSearchOrder() {
    return dnsDomainSuffixSearchOrder;
  }

  public void setDnsDomainSuffixSearchOrder(String dnsDomainSuffixSearchOrder) {
    this.dnsDomainSuffixSearchOrder = dnsDomainSuffixSearchOrder;
  }

  public SystemInsightsInterfaceDetails dnsHostName(String dnsHostName) {
    this.dnsHostName = dnsHostName;
    return this;
  }

   /**
   * Get dnsHostName
   * @return dnsHostName
  **/
  @Schema(description = "")
  public String getDnsHostName() {
    return dnsHostName;
  }

  public void setDnsHostName(String dnsHostName) {
    this.dnsHostName = dnsHostName;
  }

  public SystemInsightsInterfaceDetails dnsServerSearchOrder(String dnsServerSearchOrder) {
    this.dnsServerSearchOrder = dnsServerSearchOrder;
    return this;
  }

   /**
   * Get dnsServerSearchOrder
   * @return dnsServerSearchOrder
  **/
  @Schema(description = "")
  public String getDnsServerSearchOrder() {
    return dnsServerSearchOrder;
  }

  public void setDnsServerSearchOrder(String dnsServerSearchOrder) {
    this.dnsServerSearchOrder = dnsServerSearchOrder;
  }

  public SystemInsightsInterfaceDetails enabled(Integer enabled) {
    this.enabled = enabled;
    return this;
  }

   /**
   * Get enabled
   * @return enabled
  **/
  @Schema(description = "")
  public Integer getEnabled() {
    return enabled;
  }

  public void setEnabled(Integer enabled) {
    this.enabled = enabled;
  }

  public SystemInsightsInterfaceDetails flags(Integer flags) {
    this.flags = flags;
    return this;
  }

   /**
   * Get flags
   * @return flags
  **/
  @Schema(description = "")
  public Integer getFlags() {
    return flags;
  }

  public void setFlags(Integer flags) {
    this.flags = flags;
  }

  public SystemInsightsInterfaceDetails friendlyName(String friendlyName) {
    this.friendlyName = friendlyName;
    return this;
  }

   /**
   * Get friendlyName
   * @return friendlyName
  **/
  @Schema(description = "")
  public String getFriendlyName() {
    return friendlyName;
  }

  public void setFriendlyName(String friendlyName) {
    this.friendlyName = friendlyName;
  }

  public SystemInsightsInterfaceDetails ibytes(String ibytes) {
    this.ibytes = ibytes;
    return this;
  }

   /**
   * Get ibytes
   * @return ibytes
  **/
  @Schema(description = "")
  public String getIbytes() {
    return ibytes;
  }

  public void setIbytes(String ibytes) {
    this.ibytes = ibytes;
  }

  public SystemInsightsInterfaceDetails idrops(String idrops) {
    this.idrops = idrops;
    return this;
  }

   /**
   * Get idrops
   * @return idrops
  **/
  @Schema(description = "")
  public String getIdrops() {
    return idrops;
  }

  public void setIdrops(String idrops) {
    this.idrops = idrops;
  }

  public SystemInsightsInterfaceDetails ierrors(String ierrors) {
    this.ierrors = ierrors;
    return this;
  }

   /**
   * Get ierrors
   * @return ierrors
  **/
  @Schema(description = "")
  public String getIerrors() {
    return ierrors;
  }

  public void setIerrors(String ierrors) {
    this.ierrors = ierrors;
  }

  public SystemInsightsInterfaceDetails _interface(String _interface) {
    this._interface = _interface;
    return this;
  }

   /**
   * Get _interface
   * @return _interface
  **/
  @Schema(description = "")
  public String getInterface() {
    return _interface;
  }

  public void setInterface(String _interface) {
    this._interface = _interface;
  }

  public SystemInsightsInterfaceDetails ipackets(String ipackets) {
    this.ipackets = ipackets;
    return this;
  }

   /**
   * Get ipackets
   * @return ipackets
  **/
  @Schema(description = "")
  public String getIpackets() {
    return ipackets;
  }

  public void setIpackets(String ipackets) {
    this.ipackets = ipackets;
  }

  public SystemInsightsInterfaceDetails lastChange(String lastChange) {
    this.lastChange = lastChange;
    return this;
  }

   /**
   * Get lastChange
   * @return lastChange
  **/
  @Schema(description = "")
  public String getLastChange() {
    return lastChange;
  }

  public void setLastChange(String lastChange) {
    this.lastChange = lastChange;
  }

  public SystemInsightsInterfaceDetails linkSpeed(String linkSpeed) {
    this.linkSpeed = linkSpeed;
    return this;
  }

   /**
   * Get linkSpeed
   * @return linkSpeed
  **/
  @Schema(description = "")
  public String getLinkSpeed() {
    return linkSpeed;
  }

  public void setLinkSpeed(String linkSpeed) {
    this.linkSpeed = linkSpeed;
  }

  public SystemInsightsInterfaceDetails mac(String mac) {
    this.mac = mac;
    return this;
  }

   /**
   * Get mac
   * @return mac
  **/
  @Schema(description = "")
  public String getMac() {
    return mac;
  }

  public void setMac(String mac) {
    this.mac = mac;
  }

  public SystemInsightsInterfaceDetails manufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
    return this;
  }

   /**
   * Get manufacturer
   * @return manufacturer
  **/
  @Schema(description = "")
  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public SystemInsightsInterfaceDetails metric(Integer metric) {
    this.metric = metric;
    return this;
  }

   /**
   * Get metric
   * @return metric
  **/
  @Schema(description = "")
  public Integer getMetric() {
    return metric;
  }

  public void setMetric(Integer metric) {
    this.metric = metric;
  }

  public SystemInsightsInterfaceDetails mtu(Integer mtu) {
    this.mtu = mtu;
    return this;
  }

   /**
   * Get mtu
   * @return mtu
  **/
  @Schema(description = "")
  public Integer getMtu() {
    return mtu;
  }

  public void setMtu(Integer mtu) {
    this.mtu = mtu;
  }

  public SystemInsightsInterfaceDetails obytes(String obytes) {
    this.obytes = obytes;
    return this;
  }

   /**
   * Get obytes
   * @return obytes
  **/
  @Schema(description = "")
  public String getObytes() {
    return obytes;
  }

  public void setObytes(String obytes) {
    this.obytes = obytes;
  }

  public SystemInsightsInterfaceDetails odrops(String odrops) {
    this.odrops = odrops;
    return this;
  }

   /**
   * Get odrops
   * @return odrops
  **/
  @Schema(description = "")
  public String getOdrops() {
    return odrops;
  }

  public void setOdrops(String odrops) {
    this.odrops = odrops;
  }

  public SystemInsightsInterfaceDetails oerrors(String oerrors) {
    this.oerrors = oerrors;
    return this;
  }

   /**
   * Get oerrors
   * @return oerrors
  **/
  @Schema(description = "")
  public String getOerrors() {
    return oerrors;
  }

  public void setOerrors(String oerrors) {
    this.oerrors = oerrors;
  }

  public SystemInsightsInterfaceDetails opackets(String opackets) {
    this.opackets = opackets;
    return this;
  }

   /**
   * Get opackets
   * @return opackets
  **/
  @Schema(description = "")
  public String getOpackets() {
    return opackets;
  }

  public void setOpackets(String opackets) {
    this.opackets = opackets;
  }

  public SystemInsightsInterfaceDetails pciSlot(String pciSlot) {
    this.pciSlot = pciSlot;
    return this;
  }

   /**
   * Get pciSlot
   * @return pciSlot
  **/
  @Schema(description = "")
  public String getPciSlot() {
    return pciSlot;
  }

  public void setPciSlot(String pciSlot) {
    this.pciSlot = pciSlot;
  }

  public SystemInsightsInterfaceDetails physicalAdapter(Integer physicalAdapter) {
    this.physicalAdapter = physicalAdapter;
    return this;
  }

   /**
   * Get physicalAdapter
   * @return physicalAdapter
  **/
  @Schema(description = "")
  public Integer getPhysicalAdapter() {
    return physicalAdapter;
  }

  public void setPhysicalAdapter(Integer physicalAdapter) {
    this.physicalAdapter = physicalAdapter;
  }

  public SystemInsightsInterfaceDetails service(String service) {
    this.service = service;
    return this;
  }

   /**
   * Get service
   * @return service
  **/
  @Schema(description = "")
  public String getService() {
    return service;
  }

  public void setService(String service) {
    this.service = service;
  }

  public SystemInsightsInterfaceDetails speed(Integer speed) {
    this.speed = speed;
    return this;
  }

   /**
   * Get speed
   * @return speed
  **/
  @Schema(description = "")
  public Integer getSpeed() {
    return speed;
  }

  public void setSpeed(Integer speed) {
    this.speed = speed;
  }

  public SystemInsightsInterfaceDetails systemId(String systemId) {
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

  public SystemInsightsInterfaceDetails type(Integer type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @Schema(description = "")
  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SystemInsightsInterfaceDetails systemInsightsInterfaceDetails = (SystemInsightsInterfaceDetails) o;
    return Objects.equals(this.collisions, systemInsightsInterfaceDetails.collisions) &&
        Objects.equals(this.connectionId, systemInsightsInterfaceDetails.connectionId) &&
        Objects.equals(this.connectionStatus, systemInsightsInterfaceDetails.connectionStatus) &&
        Objects.equals(this.description, systemInsightsInterfaceDetails.description) &&
        Objects.equals(this.dhcpEnabled, systemInsightsInterfaceDetails.dhcpEnabled) &&
        Objects.equals(this.dhcpLeaseExpires, systemInsightsInterfaceDetails.dhcpLeaseExpires) &&
        Objects.equals(this.dhcpLeaseObtained, systemInsightsInterfaceDetails.dhcpLeaseObtained) &&
        Objects.equals(this.dhcpServer, systemInsightsInterfaceDetails.dhcpServer) &&
        Objects.equals(this.dnsDomain, systemInsightsInterfaceDetails.dnsDomain) &&
        Objects.equals(this.dnsDomainSuffixSearchOrder, systemInsightsInterfaceDetails.dnsDomainSuffixSearchOrder) &&
        Objects.equals(this.dnsHostName, systemInsightsInterfaceDetails.dnsHostName) &&
        Objects.equals(this.dnsServerSearchOrder, systemInsightsInterfaceDetails.dnsServerSearchOrder) &&
        Objects.equals(this.enabled, systemInsightsInterfaceDetails.enabled) &&
        Objects.equals(this.flags, systemInsightsInterfaceDetails.flags) &&
        Objects.equals(this.friendlyName, systemInsightsInterfaceDetails.friendlyName) &&
        Objects.equals(this.ibytes, systemInsightsInterfaceDetails.ibytes) &&
        Objects.equals(this.idrops, systemInsightsInterfaceDetails.idrops) &&
        Objects.equals(this.ierrors, systemInsightsInterfaceDetails.ierrors) &&
        Objects.equals(this._interface, systemInsightsInterfaceDetails._interface) &&
        Objects.equals(this.ipackets, systemInsightsInterfaceDetails.ipackets) &&
        Objects.equals(this.lastChange, systemInsightsInterfaceDetails.lastChange) &&
        Objects.equals(this.linkSpeed, systemInsightsInterfaceDetails.linkSpeed) &&
        Objects.equals(this.mac, systemInsightsInterfaceDetails.mac) &&
        Objects.equals(this.manufacturer, systemInsightsInterfaceDetails.manufacturer) &&
        Objects.equals(this.metric, systemInsightsInterfaceDetails.metric) &&
        Objects.equals(this.mtu, systemInsightsInterfaceDetails.mtu) &&
        Objects.equals(this.obytes, systemInsightsInterfaceDetails.obytes) &&
        Objects.equals(this.odrops, systemInsightsInterfaceDetails.odrops) &&
        Objects.equals(this.oerrors, systemInsightsInterfaceDetails.oerrors) &&
        Objects.equals(this.opackets, systemInsightsInterfaceDetails.opackets) &&
        Objects.equals(this.pciSlot, systemInsightsInterfaceDetails.pciSlot) &&
        Objects.equals(this.physicalAdapter, systemInsightsInterfaceDetails.physicalAdapter) &&
        Objects.equals(this.service, systemInsightsInterfaceDetails.service) &&
        Objects.equals(this.speed, systemInsightsInterfaceDetails.speed) &&
        Objects.equals(this.systemId, systemInsightsInterfaceDetails.systemId) &&
        Objects.equals(this.type, systemInsightsInterfaceDetails.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(collisions, connectionId, connectionStatus, description, dhcpEnabled, dhcpLeaseExpires, dhcpLeaseObtained, dhcpServer, dnsDomain, dnsDomainSuffixSearchOrder, dnsHostName, dnsServerSearchOrder, enabled, flags, friendlyName, ibytes, idrops, ierrors, _interface, ipackets, lastChange, linkSpeed, mac, manufacturer, metric, mtu, obytes, odrops, oerrors, opackets, pciSlot, physicalAdapter, service, speed, systemId, type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemInsightsInterfaceDetails {\n");
    
    sb.append("    collisions: ").append(toIndentedString(collisions)).append("\n");
    sb.append("    connectionId: ").append(toIndentedString(connectionId)).append("\n");
    sb.append("    connectionStatus: ").append(toIndentedString(connectionStatus)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    dhcpEnabled: ").append(toIndentedString(dhcpEnabled)).append("\n");
    sb.append("    dhcpLeaseExpires: ").append(toIndentedString(dhcpLeaseExpires)).append("\n");
    sb.append("    dhcpLeaseObtained: ").append(toIndentedString(dhcpLeaseObtained)).append("\n");
    sb.append("    dhcpServer: ").append(toIndentedString(dhcpServer)).append("\n");
    sb.append("    dnsDomain: ").append(toIndentedString(dnsDomain)).append("\n");
    sb.append("    dnsDomainSuffixSearchOrder: ").append(toIndentedString(dnsDomainSuffixSearchOrder)).append("\n");
    sb.append("    dnsHostName: ").append(toIndentedString(dnsHostName)).append("\n");
    sb.append("    dnsServerSearchOrder: ").append(toIndentedString(dnsServerSearchOrder)).append("\n");
    sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
    sb.append("    flags: ").append(toIndentedString(flags)).append("\n");
    sb.append("    friendlyName: ").append(toIndentedString(friendlyName)).append("\n");
    sb.append("    ibytes: ").append(toIndentedString(ibytes)).append("\n");
    sb.append("    idrops: ").append(toIndentedString(idrops)).append("\n");
    sb.append("    ierrors: ").append(toIndentedString(ierrors)).append("\n");
    sb.append("    _interface: ").append(toIndentedString(_interface)).append("\n");
    sb.append("    ipackets: ").append(toIndentedString(ipackets)).append("\n");
    sb.append("    lastChange: ").append(toIndentedString(lastChange)).append("\n");
    sb.append("    linkSpeed: ").append(toIndentedString(linkSpeed)).append("\n");
    sb.append("    mac: ").append(toIndentedString(mac)).append("\n");
    sb.append("    manufacturer: ").append(toIndentedString(manufacturer)).append("\n");
    sb.append("    metric: ").append(toIndentedString(metric)).append("\n");
    sb.append("    mtu: ").append(toIndentedString(mtu)).append("\n");
    sb.append("    obytes: ").append(toIndentedString(obytes)).append("\n");
    sb.append("    odrops: ").append(toIndentedString(odrops)).append("\n");
    sb.append("    oerrors: ").append(toIndentedString(oerrors)).append("\n");
    sb.append("    opackets: ").append(toIndentedString(opackets)).append("\n");
    sb.append("    pciSlot: ").append(toIndentedString(pciSlot)).append("\n");
    sb.append("    physicalAdapter: ").append(toIndentedString(physicalAdapter)).append("\n");
    sb.append("    service: ").append(toIndentedString(service)).append("\n");
    sb.append("    speed: ").append(toIndentedString(speed)).append("\n");
    sb.append("    systemId: ").append(toIndentedString(systemId)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
