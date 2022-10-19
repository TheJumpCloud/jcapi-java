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
import io.swagger.client.model.Organizationentitlement;
import io.swagger.client.model.Organizationsettings;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
/**
 * Organization
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-10-19T07:50:09.958678Z[Etc/UTC]")
public class Organization {
  @SerializedName("_id")
  private String _id = null;

  @SerializedName("accountsReceivable")
  private String accountsReceivable = null;

  @SerializedName("created")
  private String created = null;

  @SerializedName("displayName")
  private String displayName = null;

  @SerializedName("entitlement")
  private Organizationentitlement entitlement = null;

  @SerializedName("hasCreditCard")
  private Boolean hasCreditCard = null;

  @SerializedName("hasStripeCustomerId")
  private Boolean hasStripeCustomerId = null;

  @SerializedName("lastEstimateCalculationTimeStamp")
  private String lastEstimateCalculationTimeStamp = null;

  @SerializedName("lastSfdcSyncStatus")
  private Object lastSfdcSyncStatus = null;

  @SerializedName("logoUrl")
  private String logoUrl = null;

  @SerializedName("provider")
  private String provider = null;

  @SerializedName("settings")
  private Organizationsettings settings = null;

  @SerializedName("totalBillingEstimate")
  private Integer totalBillingEstimate = null;

  public Organization _id(String _id) {
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

  public Organization accountsReceivable(String accountsReceivable) {
    this.accountsReceivable = accountsReceivable;
    return this;
  }

   /**
   * Get accountsReceivable
   * @return accountsReceivable
  **/
  @Schema(description = "")
  public String getAccountsReceivable() {
    return accountsReceivable;
  }

  public void setAccountsReceivable(String accountsReceivable) {
    this.accountsReceivable = accountsReceivable;
  }

  public Organization created(String created) {
    this.created = created;
    return this;
  }

   /**
   * Get created
   * @return created
  **/
  @Schema(description = "")
  public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }

  public Organization displayName(String displayName) {
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

  public Organization entitlement(Organizationentitlement entitlement) {
    this.entitlement = entitlement;
    return this;
  }

   /**
   * Get entitlement
   * @return entitlement
  **/
  @Schema(description = "")
  public Organizationentitlement getEntitlement() {
    return entitlement;
  }

  public void setEntitlement(Organizationentitlement entitlement) {
    this.entitlement = entitlement;
  }

  public Organization hasCreditCard(Boolean hasCreditCard) {
    this.hasCreditCard = hasCreditCard;
    return this;
  }

   /**
   * Get hasCreditCard
   * @return hasCreditCard
  **/
  @Schema(description = "")
  public Boolean isHasCreditCard() {
    return hasCreditCard;
  }

  public void setHasCreditCard(Boolean hasCreditCard) {
    this.hasCreditCard = hasCreditCard;
  }

  public Organization hasStripeCustomerId(Boolean hasStripeCustomerId) {
    this.hasStripeCustomerId = hasStripeCustomerId;
    return this;
  }

   /**
   * Get hasStripeCustomerId
   * @return hasStripeCustomerId
  **/
  @Schema(description = "")
  public Boolean isHasStripeCustomerId() {
    return hasStripeCustomerId;
  }

  public void setHasStripeCustomerId(Boolean hasStripeCustomerId) {
    this.hasStripeCustomerId = hasStripeCustomerId;
  }

  public Organization lastEstimateCalculationTimeStamp(String lastEstimateCalculationTimeStamp) {
    this.lastEstimateCalculationTimeStamp = lastEstimateCalculationTimeStamp;
    return this;
  }

   /**
   * Get lastEstimateCalculationTimeStamp
   * @return lastEstimateCalculationTimeStamp
  **/
  @Schema(description = "")
  public String getLastEstimateCalculationTimeStamp() {
    return lastEstimateCalculationTimeStamp;
  }

  public void setLastEstimateCalculationTimeStamp(String lastEstimateCalculationTimeStamp) {
    this.lastEstimateCalculationTimeStamp = lastEstimateCalculationTimeStamp;
  }

  public Organization lastSfdcSyncStatus(Object lastSfdcSyncStatus) {
    this.lastSfdcSyncStatus = lastSfdcSyncStatus;
    return this;
  }

   /**
   * Get lastSfdcSyncStatus
   * @return lastSfdcSyncStatus
  **/
  @Schema(description = "")
  public Object getLastSfdcSyncStatus() {
    return lastSfdcSyncStatus;
  }

  public void setLastSfdcSyncStatus(Object lastSfdcSyncStatus) {
    this.lastSfdcSyncStatus = lastSfdcSyncStatus;
  }

  public Organization logoUrl(String logoUrl) {
    this.logoUrl = logoUrl;
    return this;
  }

   /**
   * Get logoUrl
   * @return logoUrl
  **/
  @Schema(description = "")
  public String getLogoUrl() {
    return logoUrl;
  }

  public void setLogoUrl(String logoUrl) {
    this.logoUrl = logoUrl;
  }

  public Organization provider(String provider) {
    this.provider = provider;
    return this;
  }

   /**
   * Get provider
   * @return provider
  **/
  @Schema(description = "")
  public String getProvider() {
    return provider;
  }

  public void setProvider(String provider) {
    this.provider = provider;
  }

  public Organization settings(Organizationsettings settings) {
    this.settings = settings;
    return this;
  }

   /**
   * Get settings
   * @return settings
  **/
  @Schema(description = "")
  public Organizationsettings getSettings() {
    return settings;
  }

  public void setSettings(Organizationsettings settings) {
    this.settings = settings;
  }

  public Organization totalBillingEstimate(Integer totalBillingEstimate) {
    this.totalBillingEstimate = totalBillingEstimate;
    return this;
  }

   /**
   * Get totalBillingEstimate
   * @return totalBillingEstimate
  **/
  @Schema(description = "")
  public Integer getTotalBillingEstimate() {
    return totalBillingEstimate;
  }

  public void setTotalBillingEstimate(Integer totalBillingEstimate) {
    this.totalBillingEstimate = totalBillingEstimate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Organization organization = (Organization) o;
    return Objects.equals(this._id, organization._id) &&
        Objects.equals(this.accountsReceivable, organization.accountsReceivable) &&
        Objects.equals(this.created, organization.created) &&
        Objects.equals(this.displayName, organization.displayName) &&
        Objects.equals(this.entitlement, organization.entitlement) &&
        Objects.equals(this.hasCreditCard, organization.hasCreditCard) &&
        Objects.equals(this.hasStripeCustomerId, organization.hasStripeCustomerId) &&
        Objects.equals(this.lastEstimateCalculationTimeStamp, organization.lastEstimateCalculationTimeStamp) &&
        Objects.equals(this.lastSfdcSyncStatus, organization.lastSfdcSyncStatus) &&
        Objects.equals(this.logoUrl, organization.logoUrl) &&
        Objects.equals(this.provider, organization.provider) &&
        Objects.equals(this.settings, organization.settings) &&
        Objects.equals(this.totalBillingEstimate, organization.totalBillingEstimate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(_id, accountsReceivable, created, displayName, entitlement, hasCreditCard, hasStripeCustomerId, lastEstimateCalculationTimeStamp, lastSfdcSyncStatus, logoUrl, provider, settings, totalBillingEstimate);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Organization {\n");
    
    sb.append("    _id: ").append(toIndentedString(_id)).append("\n");
    sb.append("    accountsReceivable: ").append(toIndentedString(accountsReceivable)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    entitlement: ").append(toIndentedString(entitlement)).append("\n");
    sb.append("    hasCreditCard: ").append(toIndentedString(hasCreditCard)).append("\n");
    sb.append("    hasStripeCustomerId: ").append(toIndentedString(hasStripeCustomerId)).append("\n");
    sb.append("    lastEstimateCalculationTimeStamp: ").append(toIndentedString(lastEstimateCalculationTimeStamp)).append("\n");
    sb.append("    lastSfdcSyncStatus: ").append(toIndentedString(lastSfdcSyncStatus)).append("\n");
    sb.append("    logoUrl: ").append(toIndentedString(logoUrl)).append("\n");
    sb.append("    provider: ").append(toIndentedString(provider)).append("\n");
    sb.append("    settings: ").append(toIndentedString(settings)).append("\n");
    sb.append("    totalBillingEstimate: ").append(toIndentedString(totalBillingEstimate)).append("\n");
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
