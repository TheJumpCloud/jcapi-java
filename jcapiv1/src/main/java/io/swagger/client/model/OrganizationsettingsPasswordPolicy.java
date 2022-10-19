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
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
/**
 * OrganizationsettingsPasswordPolicy
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-10-19T07:50:09.958678Z[Etc/UTC]")
public class OrganizationsettingsPasswordPolicy {
  @SerializedName("allowUsernameSubstring")
  private Boolean allowUsernameSubstring = null;

  @SerializedName("daysAfterExpirationToSelfRecover")
  private Integer daysAfterExpirationToSelfRecover = null;

  @SerializedName("daysBeforeExpirationToForceReset")
  private Integer daysBeforeExpirationToForceReset = null;

  @SerializedName("effectiveDate")
  private String effectiveDate = null;

  @SerializedName("enableDaysAfterExpirationToSelfRecover")
  private Boolean enableDaysAfterExpirationToSelfRecover = null;

  @SerializedName("enableDaysBeforeExpirationToForceReset")
  private Boolean enableDaysBeforeExpirationToForceReset = null;

  @SerializedName("enableLockoutTimeInSeconds")
  private Boolean enableLockoutTimeInSeconds = null;

  @SerializedName("enableMaxHistory")
  private Boolean enableMaxHistory = null;

  @SerializedName("enableMaxLoginAttempts")
  private Boolean enableMaxLoginAttempts = null;

  @SerializedName("enableMinChangePeriodInDays")
  private Boolean enableMinChangePeriodInDays = null;

  @SerializedName("enableMinLength")
  private Boolean enableMinLength = null;

  @SerializedName("enablePasswordExpirationInDays")
  private Boolean enablePasswordExpirationInDays = null;

  @SerializedName("enableRecoveryEmail")
  private Boolean enableRecoveryEmail = null;

  @SerializedName("enableResetLockoutCounter")
  private Boolean enableResetLockoutCounter = null;

  @SerializedName("gracePeriodDate")
  private String gracePeriodDate = null;

  @SerializedName("lockoutTimeInSeconds")
  private Integer lockoutTimeInSeconds = null;

  @SerializedName("maxHistory")
  private Integer maxHistory = null;

  @SerializedName("maxLoginAttempts")
  private Integer maxLoginAttempts = null;

  @SerializedName("minChangePeriodInDays")
  private Integer minChangePeriodInDays = null;

  @SerializedName("minLength")
  private Integer minLength = null;

  @SerializedName("needsLowercase")
  private Boolean needsLowercase = null;

  @SerializedName("needsNumeric")
  private Boolean needsNumeric = null;

  @SerializedName("needsSymbolic")
  private Boolean needsSymbolic = null;

  @SerializedName("needsUppercase")
  private Boolean needsUppercase = null;

  @SerializedName("passwordExpirationInDays")
  private Integer passwordExpirationInDays = null;

  @SerializedName("resetLockoutCounterMinutes")
  private Integer resetLockoutCounterMinutes = null;

  public OrganizationsettingsPasswordPolicy allowUsernameSubstring(Boolean allowUsernameSubstring) {
    this.allowUsernameSubstring = allowUsernameSubstring;
    return this;
  }

   /**
   * Get allowUsernameSubstring
   * @return allowUsernameSubstring
  **/
  @Schema(description = "")
  public Boolean isAllowUsernameSubstring() {
    return allowUsernameSubstring;
  }

  public void setAllowUsernameSubstring(Boolean allowUsernameSubstring) {
    this.allowUsernameSubstring = allowUsernameSubstring;
  }

  public OrganizationsettingsPasswordPolicy daysAfterExpirationToSelfRecover(Integer daysAfterExpirationToSelfRecover) {
    this.daysAfterExpirationToSelfRecover = daysAfterExpirationToSelfRecover;
    return this;
  }

   /**
   * Deprecated field used for the legacy grace period feature.
   * @return daysAfterExpirationToSelfRecover
  **/
  @Schema(description = "Deprecated field used for the legacy grace period feature.")
  public Integer getDaysAfterExpirationToSelfRecover() {
    return daysAfterExpirationToSelfRecover;
  }

  public void setDaysAfterExpirationToSelfRecover(Integer daysAfterExpirationToSelfRecover) {
    this.daysAfterExpirationToSelfRecover = daysAfterExpirationToSelfRecover;
  }

  public OrganizationsettingsPasswordPolicy daysBeforeExpirationToForceReset(Integer daysBeforeExpirationToForceReset) {
    this.daysBeforeExpirationToForceReset = daysBeforeExpirationToForceReset;
    return this;
  }

   /**
   * Get daysBeforeExpirationToForceReset
   * minimum: 1
   * @return daysBeforeExpirationToForceReset
  **/
  @Schema(description = "")
  public Integer getDaysBeforeExpirationToForceReset() {
    return daysBeforeExpirationToForceReset;
  }

  public void setDaysBeforeExpirationToForceReset(Integer daysBeforeExpirationToForceReset) {
    this.daysBeforeExpirationToForceReset = daysBeforeExpirationToForceReset;
  }

  public OrganizationsettingsPasswordPolicy effectiveDate(String effectiveDate) {
    this.effectiveDate = effectiveDate;
    return this;
  }

   /**
   * Get effectiveDate
   * @return effectiveDate
  **/
  @Schema(description = "")
  public String getEffectiveDate() {
    return effectiveDate;
  }

  public void setEffectiveDate(String effectiveDate) {
    this.effectiveDate = effectiveDate;
  }

  public OrganizationsettingsPasswordPolicy enableDaysAfterExpirationToSelfRecover(Boolean enableDaysAfterExpirationToSelfRecover) {
    this.enableDaysAfterExpirationToSelfRecover = enableDaysAfterExpirationToSelfRecover;
    return this;
  }

   /**
   * Get enableDaysAfterExpirationToSelfRecover
   * @return enableDaysAfterExpirationToSelfRecover
  **/
  @Schema(description = "")
  public Boolean isEnableDaysAfterExpirationToSelfRecover() {
    return enableDaysAfterExpirationToSelfRecover;
  }

  public void setEnableDaysAfterExpirationToSelfRecover(Boolean enableDaysAfterExpirationToSelfRecover) {
    this.enableDaysAfterExpirationToSelfRecover = enableDaysAfterExpirationToSelfRecover;
  }

  public OrganizationsettingsPasswordPolicy enableDaysBeforeExpirationToForceReset(Boolean enableDaysBeforeExpirationToForceReset) {
    this.enableDaysBeforeExpirationToForceReset = enableDaysBeforeExpirationToForceReset;
    return this;
  }

   /**
   * Get enableDaysBeforeExpirationToForceReset
   * @return enableDaysBeforeExpirationToForceReset
  **/
  @Schema(description = "")
  public Boolean isEnableDaysBeforeExpirationToForceReset() {
    return enableDaysBeforeExpirationToForceReset;
  }

  public void setEnableDaysBeforeExpirationToForceReset(Boolean enableDaysBeforeExpirationToForceReset) {
    this.enableDaysBeforeExpirationToForceReset = enableDaysBeforeExpirationToForceReset;
  }

  public OrganizationsettingsPasswordPolicy enableLockoutTimeInSeconds(Boolean enableLockoutTimeInSeconds) {
    this.enableLockoutTimeInSeconds = enableLockoutTimeInSeconds;
    return this;
  }

   /**
   * Get enableLockoutTimeInSeconds
   * @return enableLockoutTimeInSeconds
  **/
  @Schema(description = "")
  public Boolean isEnableLockoutTimeInSeconds() {
    return enableLockoutTimeInSeconds;
  }

  public void setEnableLockoutTimeInSeconds(Boolean enableLockoutTimeInSeconds) {
    this.enableLockoutTimeInSeconds = enableLockoutTimeInSeconds;
  }

  public OrganizationsettingsPasswordPolicy enableMaxHistory(Boolean enableMaxHistory) {
    this.enableMaxHistory = enableMaxHistory;
    return this;
  }

   /**
   * Get enableMaxHistory
   * @return enableMaxHistory
  **/
  @Schema(description = "")
  public Boolean isEnableMaxHistory() {
    return enableMaxHistory;
  }

  public void setEnableMaxHistory(Boolean enableMaxHistory) {
    this.enableMaxHistory = enableMaxHistory;
  }

  public OrganizationsettingsPasswordPolicy enableMaxLoginAttempts(Boolean enableMaxLoginAttempts) {
    this.enableMaxLoginAttempts = enableMaxLoginAttempts;
    return this;
  }

   /**
   * Get enableMaxLoginAttempts
   * @return enableMaxLoginAttempts
  **/
  @Schema(description = "")
  public Boolean isEnableMaxLoginAttempts() {
    return enableMaxLoginAttempts;
  }

  public void setEnableMaxLoginAttempts(Boolean enableMaxLoginAttempts) {
    this.enableMaxLoginAttempts = enableMaxLoginAttempts;
  }

  public OrganizationsettingsPasswordPolicy enableMinChangePeriodInDays(Boolean enableMinChangePeriodInDays) {
    this.enableMinChangePeriodInDays = enableMinChangePeriodInDays;
    return this;
  }

   /**
   * Get enableMinChangePeriodInDays
   * @return enableMinChangePeriodInDays
  **/
  @Schema(description = "")
  public Boolean isEnableMinChangePeriodInDays() {
    return enableMinChangePeriodInDays;
  }

  public void setEnableMinChangePeriodInDays(Boolean enableMinChangePeriodInDays) {
    this.enableMinChangePeriodInDays = enableMinChangePeriodInDays;
  }

  public OrganizationsettingsPasswordPolicy enableMinLength(Boolean enableMinLength) {
    this.enableMinLength = enableMinLength;
    return this;
  }

   /**
   * Get enableMinLength
   * @return enableMinLength
  **/
  @Schema(description = "")
  public Boolean isEnableMinLength() {
    return enableMinLength;
  }

  public void setEnableMinLength(Boolean enableMinLength) {
    this.enableMinLength = enableMinLength;
  }

  public OrganizationsettingsPasswordPolicy enablePasswordExpirationInDays(Boolean enablePasswordExpirationInDays) {
    this.enablePasswordExpirationInDays = enablePasswordExpirationInDays;
    return this;
  }

   /**
   * Get enablePasswordExpirationInDays
   * @return enablePasswordExpirationInDays
  **/
  @Schema(description = "")
  public Boolean isEnablePasswordExpirationInDays() {
    return enablePasswordExpirationInDays;
  }

  public void setEnablePasswordExpirationInDays(Boolean enablePasswordExpirationInDays) {
    this.enablePasswordExpirationInDays = enablePasswordExpirationInDays;
  }

  public OrganizationsettingsPasswordPolicy enableRecoveryEmail(Boolean enableRecoveryEmail) {
    this.enableRecoveryEmail = enableRecoveryEmail;
    return this;
  }

   /**
   * Get enableRecoveryEmail
   * @return enableRecoveryEmail
  **/
  @Schema(description = "")
  public Boolean isEnableRecoveryEmail() {
    return enableRecoveryEmail;
  }

  public void setEnableRecoveryEmail(Boolean enableRecoveryEmail) {
    this.enableRecoveryEmail = enableRecoveryEmail;
  }

  public OrganizationsettingsPasswordPolicy enableResetLockoutCounter(Boolean enableResetLockoutCounter) {
    this.enableResetLockoutCounter = enableResetLockoutCounter;
    return this;
  }

   /**
   * Get enableResetLockoutCounter
   * @return enableResetLockoutCounter
  **/
  @Schema(description = "")
  public Boolean isEnableResetLockoutCounter() {
    return enableResetLockoutCounter;
  }

  public void setEnableResetLockoutCounter(Boolean enableResetLockoutCounter) {
    this.enableResetLockoutCounter = enableResetLockoutCounter;
  }

  public OrganizationsettingsPasswordPolicy gracePeriodDate(String gracePeriodDate) {
    this.gracePeriodDate = gracePeriodDate;
    return this;
  }

   /**
   * Get gracePeriodDate
   * @return gracePeriodDate
  **/
  @Schema(description = "")
  public String getGracePeriodDate() {
    return gracePeriodDate;
  }

  public void setGracePeriodDate(String gracePeriodDate) {
    this.gracePeriodDate = gracePeriodDate;
  }

  public OrganizationsettingsPasswordPolicy lockoutTimeInSeconds(Integer lockoutTimeInSeconds) {
    this.lockoutTimeInSeconds = lockoutTimeInSeconds;
    return this;
  }

   /**
   * Get lockoutTimeInSeconds
   * minimum: 300
   * maximum: 5400
   * @return lockoutTimeInSeconds
  **/
  @Schema(description = "")
  public Integer getLockoutTimeInSeconds() {
    return lockoutTimeInSeconds;
  }

  public void setLockoutTimeInSeconds(Integer lockoutTimeInSeconds) {
    this.lockoutTimeInSeconds = lockoutTimeInSeconds;
  }

  public OrganizationsettingsPasswordPolicy maxHistory(Integer maxHistory) {
    this.maxHistory = maxHistory;
    return this;
  }

   /**
   * Get maxHistory
   * minimum: 1
   * maximum: 24
   * @return maxHistory
  **/
  @Schema(description = "")
  public Integer getMaxHistory() {
    return maxHistory;
  }

  public void setMaxHistory(Integer maxHistory) {
    this.maxHistory = maxHistory;
  }

  public OrganizationsettingsPasswordPolicy maxLoginAttempts(Integer maxLoginAttempts) {
    this.maxLoginAttempts = maxLoginAttempts;
    return this;
  }

   /**
   * Get maxLoginAttempts
   * minimum: 1
   * @return maxLoginAttempts
  **/
  @Schema(description = "")
  public Integer getMaxLoginAttempts() {
    return maxLoginAttempts;
  }

  public void setMaxLoginAttempts(Integer maxLoginAttempts) {
    this.maxLoginAttempts = maxLoginAttempts;
  }

  public OrganizationsettingsPasswordPolicy minChangePeriodInDays(Integer minChangePeriodInDays) {
    this.minChangePeriodInDays = minChangePeriodInDays;
    return this;
  }

   /**
   * Get minChangePeriodInDays
   * @return minChangePeriodInDays
  **/
  @Schema(description = "")
  public Integer getMinChangePeriodInDays() {
    return minChangePeriodInDays;
  }

  public void setMinChangePeriodInDays(Integer minChangePeriodInDays) {
    this.minChangePeriodInDays = minChangePeriodInDays;
  }

  public OrganizationsettingsPasswordPolicy minLength(Integer minLength) {
    this.minLength = minLength;
    return this;
  }

   /**
   * Get minLength
   * @return minLength
  **/
  @Schema(description = "")
  public Integer getMinLength() {
    return minLength;
  }

  public void setMinLength(Integer minLength) {
    this.minLength = minLength;
  }

  public OrganizationsettingsPasswordPolicy needsLowercase(Boolean needsLowercase) {
    this.needsLowercase = needsLowercase;
    return this;
  }

   /**
   * Get needsLowercase
   * @return needsLowercase
  **/
  @Schema(description = "")
  public Boolean isNeedsLowercase() {
    return needsLowercase;
  }

  public void setNeedsLowercase(Boolean needsLowercase) {
    this.needsLowercase = needsLowercase;
  }

  public OrganizationsettingsPasswordPolicy needsNumeric(Boolean needsNumeric) {
    this.needsNumeric = needsNumeric;
    return this;
  }

   /**
   * Get needsNumeric
   * @return needsNumeric
  **/
  @Schema(description = "")
  public Boolean isNeedsNumeric() {
    return needsNumeric;
  }

  public void setNeedsNumeric(Boolean needsNumeric) {
    this.needsNumeric = needsNumeric;
  }

  public OrganizationsettingsPasswordPolicy needsSymbolic(Boolean needsSymbolic) {
    this.needsSymbolic = needsSymbolic;
    return this;
  }

   /**
   * Get needsSymbolic
   * @return needsSymbolic
  **/
  @Schema(description = "")
  public Boolean isNeedsSymbolic() {
    return needsSymbolic;
  }

  public void setNeedsSymbolic(Boolean needsSymbolic) {
    this.needsSymbolic = needsSymbolic;
  }

  public OrganizationsettingsPasswordPolicy needsUppercase(Boolean needsUppercase) {
    this.needsUppercase = needsUppercase;
    return this;
  }

   /**
   * Get needsUppercase
   * @return needsUppercase
  **/
  @Schema(description = "")
  public Boolean isNeedsUppercase() {
    return needsUppercase;
  }

  public void setNeedsUppercase(Boolean needsUppercase) {
    this.needsUppercase = needsUppercase;
  }

  public OrganizationsettingsPasswordPolicy passwordExpirationInDays(Integer passwordExpirationInDays) {
    this.passwordExpirationInDays = passwordExpirationInDays;
    return this;
  }

   /**
   * Get passwordExpirationInDays
   * minimum: 1
   * @return passwordExpirationInDays
  **/
  @Schema(description = "")
  public Integer getPasswordExpirationInDays() {
    return passwordExpirationInDays;
  }

  public void setPasswordExpirationInDays(Integer passwordExpirationInDays) {
    this.passwordExpirationInDays = passwordExpirationInDays;
  }

  public OrganizationsettingsPasswordPolicy resetLockoutCounterMinutes(Integer resetLockoutCounterMinutes) {
    this.resetLockoutCounterMinutes = resetLockoutCounterMinutes;
    return this;
  }

   /**
   * Get resetLockoutCounterMinutes
   * minimum: 1
   * @return resetLockoutCounterMinutes
  **/
  @Schema(description = "")
  public Integer getResetLockoutCounterMinutes() {
    return resetLockoutCounterMinutes;
  }

  public void setResetLockoutCounterMinutes(Integer resetLockoutCounterMinutes) {
    this.resetLockoutCounterMinutes = resetLockoutCounterMinutes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrganizationsettingsPasswordPolicy organizationsettingsPasswordPolicy = (OrganizationsettingsPasswordPolicy) o;
    return Objects.equals(this.allowUsernameSubstring, organizationsettingsPasswordPolicy.allowUsernameSubstring) &&
        Objects.equals(this.daysAfterExpirationToSelfRecover, organizationsettingsPasswordPolicy.daysAfterExpirationToSelfRecover) &&
        Objects.equals(this.daysBeforeExpirationToForceReset, organizationsettingsPasswordPolicy.daysBeforeExpirationToForceReset) &&
        Objects.equals(this.effectiveDate, organizationsettingsPasswordPolicy.effectiveDate) &&
        Objects.equals(this.enableDaysAfterExpirationToSelfRecover, organizationsettingsPasswordPolicy.enableDaysAfterExpirationToSelfRecover) &&
        Objects.equals(this.enableDaysBeforeExpirationToForceReset, organizationsettingsPasswordPolicy.enableDaysBeforeExpirationToForceReset) &&
        Objects.equals(this.enableLockoutTimeInSeconds, organizationsettingsPasswordPolicy.enableLockoutTimeInSeconds) &&
        Objects.equals(this.enableMaxHistory, organizationsettingsPasswordPolicy.enableMaxHistory) &&
        Objects.equals(this.enableMaxLoginAttempts, organizationsettingsPasswordPolicy.enableMaxLoginAttempts) &&
        Objects.equals(this.enableMinChangePeriodInDays, organizationsettingsPasswordPolicy.enableMinChangePeriodInDays) &&
        Objects.equals(this.enableMinLength, organizationsettingsPasswordPolicy.enableMinLength) &&
        Objects.equals(this.enablePasswordExpirationInDays, organizationsettingsPasswordPolicy.enablePasswordExpirationInDays) &&
        Objects.equals(this.enableRecoveryEmail, organizationsettingsPasswordPolicy.enableRecoveryEmail) &&
        Objects.equals(this.enableResetLockoutCounter, organizationsettingsPasswordPolicy.enableResetLockoutCounter) &&
        Objects.equals(this.gracePeriodDate, organizationsettingsPasswordPolicy.gracePeriodDate) &&
        Objects.equals(this.lockoutTimeInSeconds, organizationsettingsPasswordPolicy.lockoutTimeInSeconds) &&
        Objects.equals(this.maxHistory, organizationsettingsPasswordPolicy.maxHistory) &&
        Objects.equals(this.maxLoginAttempts, organizationsettingsPasswordPolicy.maxLoginAttempts) &&
        Objects.equals(this.minChangePeriodInDays, organizationsettingsPasswordPolicy.minChangePeriodInDays) &&
        Objects.equals(this.minLength, organizationsettingsPasswordPolicy.minLength) &&
        Objects.equals(this.needsLowercase, organizationsettingsPasswordPolicy.needsLowercase) &&
        Objects.equals(this.needsNumeric, organizationsettingsPasswordPolicy.needsNumeric) &&
        Objects.equals(this.needsSymbolic, organizationsettingsPasswordPolicy.needsSymbolic) &&
        Objects.equals(this.needsUppercase, organizationsettingsPasswordPolicy.needsUppercase) &&
        Objects.equals(this.passwordExpirationInDays, organizationsettingsPasswordPolicy.passwordExpirationInDays) &&
        Objects.equals(this.resetLockoutCounterMinutes, organizationsettingsPasswordPolicy.resetLockoutCounterMinutes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(allowUsernameSubstring, daysAfterExpirationToSelfRecover, daysBeforeExpirationToForceReset, effectiveDate, enableDaysAfterExpirationToSelfRecover, enableDaysBeforeExpirationToForceReset, enableLockoutTimeInSeconds, enableMaxHistory, enableMaxLoginAttempts, enableMinChangePeriodInDays, enableMinLength, enablePasswordExpirationInDays, enableRecoveryEmail, enableResetLockoutCounter, gracePeriodDate, lockoutTimeInSeconds, maxHistory, maxLoginAttempts, minChangePeriodInDays, minLength, needsLowercase, needsNumeric, needsSymbolic, needsUppercase, passwordExpirationInDays, resetLockoutCounterMinutes);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrganizationsettingsPasswordPolicy {\n");
    
    sb.append("    allowUsernameSubstring: ").append(toIndentedString(allowUsernameSubstring)).append("\n");
    sb.append("    daysAfterExpirationToSelfRecover: ").append(toIndentedString(daysAfterExpirationToSelfRecover)).append("\n");
    sb.append("    daysBeforeExpirationToForceReset: ").append(toIndentedString(daysBeforeExpirationToForceReset)).append("\n");
    sb.append("    effectiveDate: ").append(toIndentedString(effectiveDate)).append("\n");
    sb.append("    enableDaysAfterExpirationToSelfRecover: ").append(toIndentedString(enableDaysAfterExpirationToSelfRecover)).append("\n");
    sb.append("    enableDaysBeforeExpirationToForceReset: ").append(toIndentedString(enableDaysBeforeExpirationToForceReset)).append("\n");
    sb.append("    enableLockoutTimeInSeconds: ").append(toIndentedString(enableLockoutTimeInSeconds)).append("\n");
    sb.append("    enableMaxHistory: ").append(toIndentedString(enableMaxHistory)).append("\n");
    sb.append("    enableMaxLoginAttempts: ").append(toIndentedString(enableMaxLoginAttempts)).append("\n");
    sb.append("    enableMinChangePeriodInDays: ").append(toIndentedString(enableMinChangePeriodInDays)).append("\n");
    sb.append("    enableMinLength: ").append(toIndentedString(enableMinLength)).append("\n");
    sb.append("    enablePasswordExpirationInDays: ").append(toIndentedString(enablePasswordExpirationInDays)).append("\n");
    sb.append("    enableRecoveryEmail: ").append(toIndentedString(enableRecoveryEmail)).append("\n");
    sb.append("    enableResetLockoutCounter: ").append(toIndentedString(enableResetLockoutCounter)).append("\n");
    sb.append("    gracePeriodDate: ").append(toIndentedString(gracePeriodDate)).append("\n");
    sb.append("    lockoutTimeInSeconds: ").append(toIndentedString(lockoutTimeInSeconds)).append("\n");
    sb.append("    maxHistory: ").append(toIndentedString(maxHistory)).append("\n");
    sb.append("    maxLoginAttempts: ").append(toIndentedString(maxLoginAttempts)).append("\n");
    sb.append("    minChangePeriodInDays: ").append(toIndentedString(minChangePeriodInDays)).append("\n");
    sb.append("    minLength: ").append(toIndentedString(minLength)).append("\n");
    sb.append("    needsLowercase: ").append(toIndentedString(needsLowercase)).append("\n");
    sb.append("    needsNumeric: ").append(toIndentedString(needsNumeric)).append("\n");
    sb.append("    needsSymbolic: ").append(toIndentedString(needsSymbolic)).append("\n");
    sb.append("    needsUppercase: ").append(toIndentedString(needsUppercase)).append("\n");
    sb.append("    passwordExpirationInDays: ").append(toIndentedString(passwordExpirationInDays)).append("\n");
    sb.append("    resetLockoutCounterMinutes: ").append(toIndentedString(resetLockoutCounterMinutes)).append("\n");
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
