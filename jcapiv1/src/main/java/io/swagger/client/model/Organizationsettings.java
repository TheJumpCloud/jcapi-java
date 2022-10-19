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
import io.swagger.client.model.OrganizationsettingsDisplayPreferences;
import io.swagger.client.model.OrganizationsettingsFeatures;
import io.swagger.client.model.OrganizationsettingsNewSystemUserStateDefaults;
import io.swagger.client.model.OrganizationsettingsPasswordPolicy;
import io.swagger.client.model.OrganizationsettingsUserPortal;
import io.swagger.client.model.TrustedappConfigGet;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
/**
 * Organizationsettings
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-10-19T07:50:09.958678Z[Etc/UTC]")
public class Organizationsettings {
  @SerializedName("agentVersion")
  private String agentVersion = null;

  @SerializedName("betaFeatures")
  private Object betaFeatures = null;

  @SerializedName("contactEmail")
  private String contactEmail = null;

  @SerializedName("contactName")
  private String contactName = null;

  @SerializedName("deviceIdentificationEnabled")
  private Boolean deviceIdentificationEnabled = null;

  @SerializedName("disableCommandRunner")
  private Boolean disableCommandRunner = null;

  @SerializedName("disableGoogleLogin")
  private Boolean disableGoogleLogin = null;

  @SerializedName("disableLdap")
  private Boolean disableLdap = null;

  @SerializedName("disableUM")
  private Boolean disableUM = null;

  @SerializedName("displayPreferences")
  private OrganizationsettingsDisplayPreferences displayPreferences = null;

  @SerializedName("duplicateLDAPGroups")
  private Boolean duplicateLDAPGroups = null;

  @SerializedName("emailDisclaimer")
  private String emailDisclaimer = null;

  @SerializedName("enableGoogleApps")
  private Boolean enableGoogleApps = null;

  @SerializedName("enableManagedUID")
  private Boolean enableManagedUID = null;

  @SerializedName("enableO365")
  private Boolean enableO365 = null;

  @SerializedName("enableUserPortalAgentInstall")
  private Boolean enableUserPortalAgentInstall = null;

  @SerializedName("features")
  private OrganizationsettingsFeatures features = null;

  @SerializedName("growthData")
  private Object growthData = null;

  @SerializedName("logo")
  private String logo = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("newSystemUserStateDefaults")
  private OrganizationsettingsNewSystemUserStateDefaults newSystemUserStateDefaults = null;

  /**
   * Gets or Sets passwordCompliance
   */
  @JsonAdapter(PasswordComplianceEnum.Adapter.class)
  public enum PasswordComplianceEnum {
    CUSTOM("custom"),
    PCI3("pci3"),
    WINDOWS("windows");

    private String value;

    PasswordComplianceEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static PasswordComplianceEnum fromValue(String input) {
      for (PasswordComplianceEnum b : PasswordComplianceEnum.values()) {
        if (b.value.equals(input)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<PasswordComplianceEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final PasswordComplianceEnum enumeration) throws IOException {
        jsonWriter.value(String.valueOf(enumeration.getValue()));
      }

      @Override
      public PasswordComplianceEnum read(final JsonReader jsonReader) throws IOException {
        Object value = jsonReader.nextString();
        return PasswordComplianceEnum.fromValue((String)(value));
      }
    }
  }  @SerializedName("passwordCompliance")
  private PasswordComplianceEnum passwordCompliance = null;

  @SerializedName("passwordPolicy")
  private OrganizationsettingsPasswordPolicy passwordPolicy = null;

  @SerializedName("pendingDelete")
  private Boolean pendingDelete = null;

  @SerializedName("showIntro")
  private Boolean showIntro = null;

  @SerializedName("systemUserPasswordExpirationInDays")
  private Integer systemUserPasswordExpirationInDays = null;

  @SerializedName("systemUsersCanEdit")
  private Boolean systemUsersCanEdit = null;

  @SerializedName("systemUsersCap")
  private Integer systemUsersCap = null;

  @SerializedName("trustedAppConfig")
  private TrustedappConfigGet trustedAppConfig = null;

  @SerializedName("userPortal")
  private OrganizationsettingsUserPortal userPortal = null;

  public Organizationsettings agentVersion(String agentVersion) {
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

  public Organizationsettings betaFeatures(Object betaFeatures) {
    this.betaFeatures = betaFeatures;
    return this;
  }

   /**
   * Get betaFeatures
   * @return betaFeatures
  **/
  @Schema(description = "")
  public Object getBetaFeatures() {
    return betaFeatures;
  }

  public void setBetaFeatures(Object betaFeatures) {
    this.betaFeatures = betaFeatures;
  }

  public Organizationsettings contactEmail(String contactEmail) {
    this.contactEmail = contactEmail;
    return this;
  }

   /**
   * Get contactEmail
   * @return contactEmail
  **/
  @Schema(description = "")
  public String getContactEmail() {
    return contactEmail;
  }

  public void setContactEmail(String contactEmail) {
    this.contactEmail = contactEmail;
  }

  public Organizationsettings contactName(String contactName) {
    this.contactName = contactName;
    return this;
  }

   /**
   * Get contactName
   * @return contactName
  **/
  @Schema(description = "")
  public String getContactName() {
    return contactName;
  }

  public void setContactName(String contactName) {
    this.contactName = contactName;
  }

  public Organizationsettings deviceIdentificationEnabled(Boolean deviceIdentificationEnabled) {
    this.deviceIdentificationEnabled = deviceIdentificationEnabled;
    return this;
  }

   /**
   * Get deviceIdentificationEnabled
   * @return deviceIdentificationEnabled
  **/
  @Schema(description = "")
  public Boolean isDeviceIdentificationEnabled() {
    return deviceIdentificationEnabled;
  }

  public void setDeviceIdentificationEnabled(Boolean deviceIdentificationEnabled) {
    this.deviceIdentificationEnabled = deviceIdentificationEnabled;
  }

  public Organizationsettings disableCommandRunner(Boolean disableCommandRunner) {
    this.disableCommandRunner = disableCommandRunner;
    return this;
  }

   /**
   * Get disableCommandRunner
   * @return disableCommandRunner
  **/
  @Schema(description = "")
  public Boolean isDisableCommandRunner() {
    return disableCommandRunner;
  }

  public void setDisableCommandRunner(Boolean disableCommandRunner) {
    this.disableCommandRunner = disableCommandRunner;
  }

  public Organizationsettings disableGoogleLogin(Boolean disableGoogleLogin) {
    this.disableGoogleLogin = disableGoogleLogin;
    return this;
  }

   /**
   * Get disableGoogleLogin
   * @return disableGoogleLogin
  **/
  @Schema(description = "")
  public Boolean isDisableGoogleLogin() {
    return disableGoogleLogin;
  }

  public void setDisableGoogleLogin(Boolean disableGoogleLogin) {
    this.disableGoogleLogin = disableGoogleLogin;
  }

  public Organizationsettings disableLdap(Boolean disableLdap) {
    this.disableLdap = disableLdap;
    return this;
  }

   /**
   * Get disableLdap
   * @return disableLdap
  **/
  @Schema(description = "")
  public Boolean isDisableLdap() {
    return disableLdap;
  }

  public void setDisableLdap(Boolean disableLdap) {
    this.disableLdap = disableLdap;
  }

  public Organizationsettings disableUM(Boolean disableUM) {
    this.disableUM = disableUM;
    return this;
  }

   /**
   * Get disableUM
   * @return disableUM
  **/
  @Schema(description = "")
  public Boolean isDisableUM() {
    return disableUM;
  }

  public void setDisableUM(Boolean disableUM) {
    this.disableUM = disableUM;
  }

  public Organizationsettings displayPreferences(OrganizationsettingsDisplayPreferences displayPreferences) {
    this.displayPreferences = displayPreferences;
    return this;
  }

   /**
   * Get displayPreferences
   * @return displayPreferences
  **/
  @Schema(description = "")
  public OrganizationsettingsDisplayPreferences getDisplayPreferences() {
    return displayPreferences;
  }

  public void setDisplayPreferences(OrganizationsettingsDisplayPreferences displayPreferences) {
    this.displayPreferences = displayPreferences;
  }

  public Organizationsettings duplicateLDAPGroups(Boolean duplicateLDAPGroups) {
    this.duplicateLDAPGroups = duplicateLDAPGroups;
    return this;
  }

   /**
   * Get duplicateLDAPGroups
   * @return duplicateLDAPGroups
  **/
  @Schema(description = "")
  public Boolean isDuplicateLDAPGroups() {
    return duplicateLDAPGroups;
  }

  public void setDuplicateLDAPGroups(Boolean duplicateLDAPGroups) {
    this.duplicateLDAPGroups = duplicateLDAPGroups;
  }

  public Organizationsettings emailDisclaimer(String emailDisclaimer) {
    this.emailDisclaimer = emailDisclaimer;
    return this;
  }

   /**
   * Get emailDisclaimer
   * @return emailDisclaimer
  **/
  @Schema(description = "")
  public String getEmailDisclaimer() {
    return emailDisclaimer;
  }

  public void setEmailDisclaimer(String emailDisclaimer) {
    this.emailDisclaimer = emailDisclaimer;
  }

  public Organizationsettings enableGoogleApps(Boolean enableGoogleApps) {
    this.enableGoogleApps = enableGoogleApps;
    return this;
  }

   /**
   * Get enableGoogleApps
   * @return enableGoogleApps
  **/
  @Schema(description = "")
  public Boolean isEnableGoogleApps() {
    return enableGoogleApps;
  }

  public void setEnableGoogleApps(Boolean enableGoogleApps) {
    this.enableGoogleApps = enableGoogleApps;
  }

  public Organizationsettings enableManagedUID(Boolean enableManagedUID) {
    this.enableManagedUID = enableManagedUID;
    return this;
  }

   /**
   * Get enableManagedUID
   * @return enableManagedUID
  **/
  @Schema(description = "")
  public Boolean isEnableManagedUID() {
    return enableManagedUID;
  }

  public void setEnableManagedUID(Boolean enableManagedUID) {
    this.enableManagedUID = enableManagedUID;
  }

  public Organizationsettings enableO365(Boolean enableO365) {
    this.enableO365 = enableO365;
    return this;
  }

   /**
   * Get enableO365
   * @return enableO365
  **/
  @Schema(description = "")
  public Boolean isEnableO365() {
    return enableO365;
  }

  public void setEnableO365(Boolean enableO365) {
    this.enableO365 = enableO365;
  }

  public Organizationsettings enableUserPortalAgentInstall(Boolean enableUserPortalAgentInstall) {
    this.enableUserPortalAgentInstall = enableUserPortalAgentInstall;
    return this;
  }

   /**
   * Get enableUserPortalAgentInstall
   * @return enableUserPortalAgentInstall
  **/
  @Schema(description = "")
  public Boolean isEnableUserPortalAgentInstall() {
    return enableUserPortalAgentInstall;
  }

  public void setEnableUserPortalAgentInstall(Boolean enableUserPortalAgentInstall) {
    this.enableUserPortalAgentInstall = enableUserPortalAgentInstall;
  }

  public Organizationsettings features(OrganizationsettingsFeatures features) {
    this.features = features;
    return this;
  }

   /**
   * Get features
   * @return features
  **/
  @Schema(description = "")
  public OrganizationsettingsFeatures getFeatures() {
    return features;
  }

  public void setFeatures(OrganizationsettingsFeatures features) {
    this.features = features;
  }

  public Organizationsettings growthData(Object growthData) {
    this.growthData = growthData;
    return this;
  }

   /**
   * Object containing Optimizely experimentIds and states corresponding to them
   * @return growthData
  **/
  @Schema(description = "Object containing Optimizely experimentIds and states corresponding to them")
  public Object getGrowthData() {
    return growthData;
  }

  public void setGrowthData(Object growthData) {
    this.growthData = growthData;
  }

  public Organizationsettings logo(String logo) {
    this.logo = logo;
    return this;
  }

   /**
   * Get logo
   * @return logo
  **/
  @Schema(description = "")
  public String getLogo() {
    return logo;
  }

  public void setLogo(String logo) {
    this.logo = logo;
  }

  public Organizationsettings name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @Schema(description = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Organizationsettings newSystemUserStateDefaults(OrganizationsettingsNewSystemUserStateDefaults newSystemUserStateDefaults) {
    this.newSystemUserStateDefaults = newSystemUserStateDefaults;
    return this;
  }

   /**
   * Get newSystemUserStateDefaults
   * @return newSystemUserStateDefaults
  **/
  @Schema(description = "")
  public OrganizationsettingsNewSystemUserStateDefaults getNewSystemUserStateDefaults() {
    return newSystemUserStateDefaults;
  }

  public void setNewSystemUserStateDefaults(OrganizationsettingsNewSystemUserStateDefaults newSystemUserStateDefaults) {
    this.newSystemUserStateDefaults = newSystemUserStateDefaults;
  }

  public Organizationsettings passwordCompliance(PasswordComplianceEnum passwordCompliance) {
    this.passwordCompliance = passwordCompliance;
    return this;
  }

   /**
   * Get passwordCompliance
   * @return passwordCompliance
  **/
  @Schema(description = "")
  public PasswordComplianceEnum getPasswordCompliance() {
    return passwordCompliance;
  }

  public void setPasswordCompliance(PasswordComplianceEnum passwordCompliance) {
    this.passwordCompliance = passwordCompliance;
  }

  public Organizationsettings passwordPolicy(OrganizationsettingsPasswordPolicy passwordPolicy) {
    this.passwordPolicy = passwordPolicy;
    return this;
  }

   /**
   * Get passwordPolicy
   * @return passwordPolicy
  **/
  @Schema(description = "")
  public OrganizationsettingsPasswordPolicy getPasswordPolicy() {
    return passwordPolicy;
  }

  public void setPasswordPolicy(OrganizationsettingsPasswordPolicy passwordPolicy) {
    this.passwordPolicy = passwordPolicy;
  }

  public Organizationsettings pendingDelete(Boolean pendingDelete) {
    this.pendingDelete = pendingDelete;
    return this;
  }

   /**
   * Get pendingDelete
   * @return pendingDelete
  **/
  @Schema(description = "")
  public Boolean isPendingDelete() {
    return pendingDelete;
  }

  public void setPendingDelete(Boolean pendingDelete) {
    this.pendingDelete = pendingDelete;
  }

  public Organizationsettings showIntro(Boolean showIntro) {
    this.showIntro = showIntro;
    return this;
  }

   /**
   * Get showIntro
   * @return showIntro
  **/
  @Schema(description = "")
  public Boolean isShowIntro() {
    return showIntro;
  }

  public void setShowIntro(Boolean showIntro) {
    this.showIntro = showIntro;
  }

  public Organizationsettings systemUserPasswordExpirationInDays(Integer systemUserPasswordExpirationInDays) {
    this.systemUserPasswordExpirationInDays = systemUserPasswordExpirationInDays;
    return this;
  }

   /**
   * Get systemUserPasswordExpirationInDays
   * @return systemUserPasswordExpirationInDays
  **/
  @Schema(description = "")
  public Integer getSystemUserPasswordExpirationInDays() {
    return systemUserPasswordExpirationInDays;
  }

  public void setSystemUserPasswordExpirationInDays(Integer systemUserPasswordExpirationInDays) {
    this.systemUserPasswordExpirationInDays = systemUserPasswordExpirationInDays;
  }

  public Organizationsettings systemUsersCanEdit(Boolean systemUsersCanEdit) {
    this.systemUsersCanEdit = systemUsersCanEdit;
    return this;
  }

   /**
   * Get systemUsersCanEdit
   * @return systemUsersCanEdit
  **/
  @Schema(description = "")
  public Boolean isSystemUsersCanEdit() {
    return systemUsersCanEdit;
  }

  public void setSystemUsersCanEdit(Boolean systemUsersCanEdit) {
    this.systemUsersCanEdit = systemUsersCanEdit;
  }

  public Organizationsettings systemUsersCap(Integer systemUsersCap) {
    this.systemUsersCap = systemUsersCap;
    return this;
  }

   /**
   * Get systemUsersCap
   * minimum: 0
   * @return systemUsersCap
  **/
  @Schema(description = "")
  public Integer getSystemUsersCap() {
    return systemUsersCap;
  }

  public void setSystemUsersCap(Integer systemUsersCap) {
    this.systemUsersCap = systemUsersCap;
  }

  public Organizationsettings trustedAppConfig(TrustedappConfigGet trustedAppConfig) {
    this.trustedAppConfig = trustedAppConfig;
    return this;
  }

   /**
   * Get trustedAppConfig
   * @return trustedAppConfig
  **/
  @Schema(description = "")
  public TrustedappConfigGet getTrustedAppConfig() {
    return trustedAppConfig;
  }

  public void setTrustedAppConfig(TrustedappConfigGet trustedAppConfig) {
    this.trustedAppConfig = trustedAppConfig;
  }

  public Organizationsettings userPortal(OrganizationsettingsUserPortal userPortal) {
    this.userPortal = userPortal;
    return this;
  }

   /**
   * Get userPortal
   * @return userPortal
  **/
  @Schema(description = "")
  public OrganizationsettingsUserPortal getUserPortal() {
    return userPortal;
  }

  public void setUserPortal(OrganizationsettingsUserPortal userPortal) {
    this.userPortal = userPortal;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Organizationsettings organizationsettings = (Organizationsettings) o;
    return Objects.equals(this.agentVersion, organizationsettings.agentVersion) &&
        Objects.equals(this.betaFeatures, organizationsettings.betaFeatures) &&
        Objects.equals(this.contactEmail, organizationsettings.contactEmail) &&
        Objects.equals(this.contactName, organizationsettings.contactName) &&
        Objects.equals(this.deviceIdentificationEnabled, organizationsettings.deviceIdentificationEnabled) &&
        Objects.equals(this.disableCommandRunner, organizationsettings.disableCommandRunner) &&
        Objects.equals(this.disableGoogleLogin, organizationsettings.disableGoogleLogin) &&
        Objects.equals(this.disableLdap, organizationsettings.disableLdap) &&
        Objects.equals(this.disableUM, organizationsettings.disableUM) &&
        Objects.equals(this.displayPreferences, organizationsettings.displayPreferences) &&
        Objects.equals(this.duplicateLDAPGroups, organizationsettings.duplicateLDAPGroups) &&
        Objects.equals(this.emailDisclaimer, organizationsettings.emailDisclaimer) &&
        Objects.equals(this.enableGoogleApps, organizationsettings.enableGoogleApps) &&
        Objects.equals(this.enableManagedUID, organizationsettings.enableManagedUID) &&
        Objects.equals(this.enableO365, organizationsettings.enableO365) &&
        Objects.equals(this.enableUserPortalAgentInstall, organizationsettings.enableUserPortalAgentInstall) &&
        Objects.equals(this.features, organizationsettings.features) &&
        Objects.equals(this.growthData, organizationsettings.growthData) &&
        Objects.equals(this.logo, organizationsettings.logo) &&
        Objects.equals(this.name, organizationsettings.name) &&
        Objects.equals(this.newSystemUserStateDefaults, organizationsettings.newSystemUserStateDefaults) &&
        Objects.equals(this.passwordCompliance, organizationsettings.passwordCompliance) &&
        Objects.equals(this.passwordPolicy, organizationsettings.passwordPolicy) &&
        Objects.equals(this.pendingDelete, organizationsettings.pendingDelete) &&
        Objects.equals(this.showIntro, organizationsettings.showIntro) &&
        Objects.equals(this.systemUserPasswordExpirationInDays, organizationsettings.systemUserPasswordExpirationInDays) &&
        Objects.equals(this.systemUsersCanEdit, organizationsettings.systemUsersCanEdit) &&
        Objects.equals(this.systemUsersCap, organizationsettings.systemUsersCap) &&
        Objects.equals(this.trustedAppConfig, organizationsettings.trustedAppConfig) &&
        Objects.equals(this.userPortal, organizationsettings.userPortal);
  }

  @Override
  public int hashCode() {
    return Objects.hash(agentVersion, betaFeatures, contactEmail, contactName, deviceIdentificationEnabled, disableCommandRunner, disableGoogleLogin, disableLdap, disableUM, displayPreferences, duplicateLDAPGroups, emailDisclaimer, enableGoogleApps, enableManagedUID, enableO365, enableUserPortalAgentInstall, features, growthData, logo, name, newSystemUserStateDefaults, passwordCompliance, passwordPolicy, pendingDelete, showIntro, systemUserPasswordExpirationInDays, systemUsersCanEdit, systemUsersCap, trustedAppConfig, userPortal);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Organizationsettings {\n");
    
    sb.append("    agentVersion: ").append(toIndentedString(agentVersion)).append("\n");
    sb.append("    betaFeatures: ").append(toIndentedString(betaFeatures)).append("\n");
    sb.append("    contactEmail: ").append(toIndentedString(contactEmail)).append("\n");
    sb.append("    contactName: ").append(toIndentedString(contactName)).append("\n");
    sb.append("    deviceIdentificationEnabled: ").append(toIndentedString(deviceIdentificationEnabled)).append("\n");
    sb.append("    disableCommandRunner: ").append(toIndentedString(disableCommandRunner)).append("\n");
    sb.append("    disableGoogleLogin: ").append(toIndentedString(disableGoogleLogin)).append("\n");
    sb.append("    disableLdap: ").append(toIndentedString(disableLdap)).append("\n");
    sb.append("    disableUM: ").append(toIndentedString(disableUM)).append("\n");
    sb.append("    displayPreferences: ").append(toIndentedString(displayPreferences)).append("\n");
    sb.append("    duplicateLDAPGroups: ").append(toIndentedString(duplicateLDAPGroups)).append("\n");
    sb.append("    emailDisclaimer: ").append(toIndentedString(emailDisclaimer)).append("\n");
    sb.append("    enableGoogleApps: ").append(toIndentedString(enableGoogleApps)).append("\n");
    sb.append("    enableManagedUID: ").append(toIndentedString(enableManagedUID)).append("\n");
    sb.append("    enableO365: ").append(toIndentedString(enableO365)).append("\n");
    sb.append("    enableUserPortalAgentInstall: ").append(toIndentedString(enableUserPortalAgentInstall)).append("\n");
    sb.append("    features: ").append(toIndentedString(features)).append("\n");
    sb.append("    growthData: ").append(toIndentedString(growthData)).append("\n");
    sb.append("    logo: ").append(toIndentedString(logo)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    newSystemUserStateDefaults: ").append(toIndentedString(newSystemUserStateDefaults)).append("\n");
    sb.append("    passwordCompliance: ").append(toIndentedString(passwordCompliance)).append("\n");
    sb.append("    passwordPolicy: ").append(toIndentedString(passwordPolicy)).append("\n");
    sb.append("    pendingDelete: ").append(toIndentedString(pendingDelete)).append("\n");
    sb.append("    showIntro: ").append(toIndentedString(showIntro)).append("\n");
    sb.append("    systemUserPasswordExpirationInDays: ").append(toIndentedString(systemUserPasswordExpirationInDays)).append("\n");
    sb.append("    systemUsersCanEdit: ").append(toIndentedString(systemUsersCanEdit)).append("\n");
    sb.append("    systemUsersCap: ").append(toIndentedString(systemUsersCap)).append("\n");
    sb.append("    trustedAppConfig: ").append(toIndentedString(trustedAppConfig)).append("\n");
    sb.append("    userPortal: ").append(toIndentedString(userPortal)).append("\n");
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
