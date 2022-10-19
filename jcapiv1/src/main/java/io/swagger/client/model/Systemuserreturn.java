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
import io.swagger.client.model.Mfa;
import io.swagger.client.model.MfaEnrollment;
import io.swagger.client.model.Sshkeylist;
import io.swagger.client.model.SystemuserputAttributes;
import io.swagger.client.model.SystemuserputRelationships;
import io.swagger.client.model.SystemuserreturnAddresses;
import io.swagger.client.model.SystemuserreturnPhoneNumbers;
import io.swagger.client.model.SystemuserreturnRecoveryEmail;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * Systemuserreturn
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-10-19T07:50:09.958678Z[Etc/UTC]")
public class Systemuserreturn {
  @SerializedName("_id")
  private String _id = null;

  @SerializedName("account_locked")
  private Boolean accountLocked = null;

  @SerializedName("account_locked_date")
  private String accountLockedDate = null;

  @SerializedName("activated")
  private Boolean activated = null;

  @SerializedName("addresses")
  private List<SystemuserreturnAddresses> addresses = null;

  @SerializedName("allow_public_key")
  private Boolean allowPublicKey = null;

  @SerializedName("alternateEmail")
  private String alternateEmail = null;

  @SerializedName("attributes")
  private List<SystemuserputAttributes> attributes = null;

  @SerializedName("badLoginAttempts")
  private Integer badLoginAttempts = null;

  @SerializedName("company")
  private String company = null;

  @SerializedName("costCenter")
  private String costCenter = null;

  @SerializedName("created")
  private String created = null;

  @SerializedName("creationSource")
  private String creationSource = null;

  @SerializedName("department")
  private String department = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("disableDeviceMaxLoginAttempts")
  private Boolean disableDeviceMaxLoginAttempts = null;

  @SerializedName("displayname")
  private String displayname = null;

  @SerializedName("email")
  private String email = null;

  @SerializedName("employeeIdentifier")
  private String employeeIdentifier = null;

  @SerializedName("employeeType")
  private String employeeType = null;

  @SerializedName("enable_managed_uid")
  private Boolean enableManagedUid = null;

  @SerializedName("enable_user_portal_multifactor")
  private Boolean enableUserPortalMultifactor = null;

  @SerializedName("external_dn")
  private String externalDn = null;

  @SerializedName("external_password_expiration_date")
  private String externalPasswordExpirationDate = null;

  @SerializedName("external_source_type")
  private String externalSourceType = null;

  @SerializedName("externally_managed")
  private Boolean externallyManaged = null;

  @SerializedName("firstname")
  private String firstname = null;

  @SerializedName("jobTitle")
  private String jobTitle = null;

  @SerializedName("lastname")
  private String lastname = null;

  @SerializedName("ldap_binding_user")
  private Boolean ldapBindingUser = null;

  @SerializedName("location")
  private String location = null;

  @SerializedName("managedAppleId")
  private String managedAppleId = null;

  @SerializedName("manager")
  private String manager = null;

  @SerializedName("mfa")
  private Mfa mfa = null;

  @SerializedName("mfaEnrollment")
  private MfaEnrollment mfaEnrollment = null;

  @SerializedName("middlename")
  private String middlename = null;

  @SerializedName("organization")
  private String organization = null;

  @SerializedName("password_expiration_date")
  private String passwordExpirationDate = null;

  @SerializedName("password_expired")
  private Boolean passwordExpired = null;

  @SerializedName("password_never_expires")
  private Boolean passwordNeverExpires = null;

  @SerializedName("passwordless_sudo")
  private Boolean passwordlessSudo = null;

  @SerializedName("phoneNumbers")
  private List<SystemuserreturnPhoneNumbers> phoneNumbers = null;

  @SerializedName("public_key")
  private String publicKey = null;

  @SerializedName("recoveryEmail")
  private SystemuserreturnRecoveryEmail recoveryEmail = null;

  @SerializedName("relationships")
  private List<SystemuserputRelationships> relationships = null;

  @SerializedName("samba_service_user")
  private Boolean sambaServiceUser = null;

  @SerializedName("ssh_keys")
  private List<Sshkeylist> sshKeys = null;

  /**
   * Gets or Sets state
   */
  @JsonAdapter(StateEnum.Adapter.class)
  public enum StateEnum {
    STAGED("STAGED"),
    ACTIVATED("ACTIVATED"),
    SUSPENDED("SUSPENDED");

    private String value;

    StateEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static StateEnum fromValue(String input) {
      for (StateEnum b : StateEnum.values()) {
        if (b.value.equals(input)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<StateEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final StateEnum enumeration) throws IOException {
        jsonWriter.value(String.valueOf(enumeration.getValue()));
      }

      @Override
      public StateEnum read(final JsonReader jsonReader) throws IOException {
        Object value = jsonReader.nextString();
        return StateEnum.fromValue((String)(value));
      }
    }
  }  @SerializedName("state")
  private StateEnum state = null;

  @SerializedName("sudo")
  private Boolean sudo = null;

  @SerializedName("suspended")
  private Boolean suspended = null;

  @SerializedName("tags")
  private List<String> tags = null;

  @SerializedName("totp_enabled")
  private Boolean totpEnabled = null;

  @SerializedName("unix_guid")
  private Integer unixGuid = null;

  @SerializedName("unix_uid")
  private Integer unixUid = null;

  @SerializedName("username")
  private String username = null;

  public Systemuserreturn _id(String _id) {
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

  public Systemuserreturn accountLocked(Boolean accountLocked) {
    this.accountLocked = accountLocked;
    return this;
  }

   /**
   * Get accountLocked
   * @return accountLocked
  **/
  @Schema(description = "")
  public Boolean isAccountLocked() {
    return accountLocked;
  }

  public void setAccountLocked(Boolean accountLocked) {
    this.accountLocked = accountLocked;
  }

  public Systemuserreturn accountLockedDate(String accountLockedDate) {
    this.accountLockedDate = accountLockedDate;
    return this;
  }

   /**
   * Get accountLockedDate
   * @return accountLockedDate
  **/
  @Schema(description = "")
  public String getAccountLockedDate() {
    return accountLockedDate;
  }

  public void setAccountLockedDate(String accountLockedDate) {
    this.accountLockedDate = accountLockedDate;
  }

  public Systemuserreturn activated(Boolean activated) {
    this.activated = activated;
    return this;
  }

   /**
   * Get activated
   * @return activated
  **/
  @Schema(description = "")
  public Boolean isActivated() {
    return activated;
  }

  public void setActivated(Boolean activated) {
    this.activated = activated;
  }

  public Systemuserreturn addresses(List<SystemuserreturnAddresses> addresses) {
    this.addresses = addresses;
    return this;
  }

  public Systemuserreturn addAddressesItem(SystemuserreturnAddresses addressesItem) {
    if (this.addresses == null) {
      this.addresses = new ArrayList<SystemuserreturnAddresses>();
    }
    this.addresses.add(addressesItem);
    return this;
  }

   /**
   * Get addresses
   * @return addresses
  **/
  @Schema(description = "")
  public List<SystemuserreturnAddresses> getAddresses() {
    return addresses;
  }

  public void setAddresses(List<SystemuserreturnAddresses> addresses) {
    this.addresses = addresses;
  }

  public Systemuserreturn allowPublicKey(Boolean allowPublicKey) {
    this.allowPublicKey = allowPublicKey;
    return this;
  }

   /**
   * Get allowPublicKey
   * @return allowPublicKey
  **/
  @Schema(description = "")
  public Boolean isAllowPublicKey() {
    return allowPublicKey;
  }

  public void setAllowPublicKey(Boolean allowPublicKey) {
    this.allowPublicKey = allowPublicKey;
  }

  public Systemuserreturn alternateEmail(String alternateEmail) {
    this.alternateEmail = alternateEmail;
    return this;
  }

   /**
   * Get alternateEmail
   * @return alternateEmail
  **/
  @Schema(description = "")
  public String getAlternateEmail() {
    return alternateEmail;
  }

  public void setAlternateEmail(String alternateEmail) {
    this.alternateEmail = alternateEmail;
  }

  public Systemuserreturn attributes(List<SystemuserputAttributes> attributes) {
    this.attributes = attributes;
    return this;
  }

  public Systemuserreturn addAttributesItem(SystemuserputAttributes attributesItem) {
    if (this.attributes == null) {
      this.attributes = new ArrayList<SystemuserputAttributes>();
    }
    this.attributes.add(attributesItem);
    return this;
  }

   /**
   * Get attributes
   * @return attributes
  **/
  @Schema(description = "")
  public List<SystemuserputAttributes> getAttributes() {
    return attributes;
  }

  public void setAttributes(List<SystemuserputAttributes> attributes) {
    this.attributes = attributes;
  }

  public Systemuserreturn badLoginAttempts(Integer badLoginAttempts) {
    this.badLoginAttempts = badLoginAttempts;
    return this;
  }

   /**
   * Get badLoginAttempts
   * minimum: 0
   * @return badLoginAttempts
  **/
  @Schema(description = "")
  public Integer getBadLoginAttempts() {
    return badLoginAttempts;
  }

  public void setBadLoginAttempts(Integer badLoginAttempts) {
    this.badLoginAttempts = badLoginAttempts;
  }

  public Systemuserreturn company(String company) {
    this.company = company;
    return this;
  }

   /**
   * Get company
   * @return company
  **/
  @Schema(description = "")
  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public Systemuserreturn costCenter(String costCenter) {
    this.costCenter = costCenter;
    return this;
  }

   /**
   * Get costCenter
   * @return costCenter
  **/
  @Schema(description = "")
  public String getCostCenter() {
    return costCenter;
  }

  public void setCostCenter(String costCenter) {
    this.costCenter = costCenter;
  }

  public Systemuserreturn created(String created) {
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

  public Systemuserreturn creationSource(String creationSource) {
    this.creationSource = creationSource;
    return this;
  }

   /**
   * Get creationSource
   * @return creationSource
  **/
  @Schema(description = "")
  public String getCreationSource() {
    return creationSource;
  }

  public void setCreationSource(String creationSource) {
    this.creationSource = creationSource;
  }

  public Systemuserreturn department(String department) {
    this.department = department;
    return this;
  }

   /**
   * Get department
   * @return department
  **/
  @Schema(description = "")
  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public Systemuserreturn description(String description) {
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

  public Systemuserreturn disableDeviceMaxLoginAttempts(Boolean disableDeviceMaxLoginAttempts) {
    this.disableDeviceMaxLoginAttempts = disableDeviceMaxLoginAttempts;
    return this;
  }

   /**
   * Get disableDeviceMaxLoginAttempts
   * @return disableDeviceMaxLoginAttempts
  **/
  @Schema(description = "")
  public Boolean isDisableDeviceMaxLoginAttempts() {
    return disableDeviceMaxLoginAttempts;
  }

  public void setDisableDeviceMaxLoginAttempts(Boolean disableDeviceMaxLoginAttempts) {
    this.disableDeviceMaxLoginAttempts = disableDeviceMaxLoginAttempts;
  }

  public Systemuserreturn displayname(String displayname) {
    this.displayname = displayname;
    return this;
  }

   /**
   * Get displayname
   * @return displayname
  **/
  @Schema(description = "")
  public String getDisplayname() {
    return displayname;
  }

  public void setDisplayname(String displayname) {
    this.displayname = displayname;
  }

  public Systemuserreturn email(String email) {
    this.email = email;
    return this;
  }

   /**
   * Get email
   * @return email
  **/
  @Schema(description = "")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Systemuserreturn employeeIdentifier(String employeeIdentifier) {
    this.employeeIdentifier = employeeIdentifier;
    return this;
  }

   /**
   * Must be unique per user. 
   * @return employeeIdentifier
  **/
  @Schema(description = "Must be unique per user. ")
  public String getEmployeeIdentifier() {
    return employeeIdentifier;
  }

  public void setEmployeeIdentifier(String employeeIdentifier) {
    this.employeeIdentifier = employeeIdentifier;
  }

  public Systemuserreturn employeeType(String employeeType) {
    this.employeeType = employeeType;
    return this;
  }

   /**
   * Get employeeType
   * @return employeeType
  **/
  @Schema(description = "")
  public String getEmployeeType() {
    return employeeType;
  }

  public void setEmployeeType(String employeeType) {
    this.employeeType = employeeType;
  }

  public Systemuserreturn enableManagedUid(Boolean enableManagedUid) {
    this.enableManagedUid = enableManagedUid;
    return this;
  }

   /**
   * Get enableManagedUid
   * @return enableManagedUid
  **/
  @Schema(description = "")
  public Boolean isEnableManagedUid() {
    return enableManagedUid;
  }

  public void setEnableManagedUid(Boolean enableManagedUid) {
    this.enableManagedUid = enableManagedUid;
  }

  public Systemuserreturn enableUserPortalMultifactor(Boolean enableUserPortalMultifactor) {
    this.enableUserPortalMultifactor = enableUserPortalMultifactor;
    return this;
  }

   /**
   * Get enableUserPortalMultifactor
   * @return enableUserPortalMultifactor
  **/
  @Schema(description = "")
  public Boolean isEnableUserPortalMultifactor() {
    return enableUserPortalMultifactor;
  }

  public void setEnableUserPortalMultifactor(Boolean enableUserPortalMultifactor) {
    this.enableUserPortalMultifactor = enableUserPortalMultifactor;
  }

  public Systemuserreturn externalDn(String externalDn) {
    this.externalDn = externalDn;
    return this;
  }

   /**
   * Get externalDn
   * @return externalDn
  **/
  @Schema(description = "")
  public String getExternalDn() {
    return externalDn;
  }

  public void setExternalDn(String externalDn) {
    this.externalDn = externalDn;
  }

  public Systemuserreturn externalPasswordExpirationDate(String externalPasswordExpirationDate) {
    this.externalPasswordExpirationDate = externalPasswordExpirationDate;
    return this;
  }

   /**
   * Get externalPasswordExpirationDate
   * @return externalPasswordExpirationDate
  **/
  @Schema(description = "")
  public String getExternalPasswordExpirationDate() {
    return externalPasswordExpirationDate;
  }

  public void setExternalPasswordExpirationDate(String externalPasswordExpirationDate) {
    this.externalPasswordExpirationDate = externalPasswordExpirationDate;
  }

  public Systemuserreturn externalSourceType(String externalSourceType) {
    this.externalSourceType = externalSourceType;
    return this;
  }

   /**
   * Get externalSourceType
   * @return externalSourceType
  **/
  @Schema(description = "")
  public String getExternalSourceType() {
    return externalSourceType;
  }

  public void setExternalSourceType(String externalSourceType) {
    this.externalSourceType = externalSourceType;
  }

  public Systemuserreturn externallyManaged(Boolean externallyManaged) {
    this.externallyManaged = externallyManaged;
    return this;
  }

   /**
   * Get externallyManaged
   * @return externallyManaged
  **/
  @Schema(description = "")
  public Boolean isExternallyManaged() {
    return externallyManaged;
  }

  public void setExternallyManaged(Boolean externallyManaged) {
    this.externallyManaged = externallyManaged;
  }

  public Systemuserreturn firstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

   /**
   * Get firstname
   * @return firstname
  **/
  @Schema(description = "")
  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public Systemuserreturn jobTitle(String jobTitle) {
    this.jobTitle = jobTitle;
    return this;
  }

   /**
   * Get jobTitle
   * @return jobTitle
  **/
  @Schema(description = "")
  public String getJobTitle() {
    return jobTitle;
  }

  public void setJobTitle(String jobTitle) {
    this.jobTitle = jobTitle;
  }

  public Systemuserreturn lastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

   /**
   * Get lastname
   * @return lastname
  **/
  @Schema(description = "")
  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public Systemuserreturn ldapBindingUser(Boolean ldapBindingUser) {
    this.ldapBindingUser = ldapBindingUser;
    return this;
  }

   /**
   * Get ldapBindingUser
   * @return ldapBindingUser
  **/
  @Schema(description = "")
  public Boolean isLdapBindingUser() {
    return ldapBindingUser;
  }

  public void setLdapBindingUser(Boolean ldapBindingUser) {
    this.ldapBindingUser = ldapBindingUser;
  }

  public Systemuserreturn location(String location) {
    this.location = location;
    return this;
  }

   /**
   * Get location
   * @return location
  **/
  @Schema(description = "")
  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public Systemuserreturn managedAppleId(String managedAppleId) {
    this.managedAppleId = managedAppleId;
    return this;
  }

   /**
   * Get managedAppleId
   * @return managedAppleId
  **/
  @Schema(description = "")
  public String getManagedAppleId() {
    return managedAppleId;
  }

  public void setManagedAppleId(String managedAppleId) {
    this.managedAppleId = managedAppleId;
  }

  public Systemuserreturn manager(String manager) {
    this.manager = manager;
    return this;
  }

   /**
   * Relation with another systemuser to identify the last as a manager.
   * @return manager
  **/
  @Schema(description = "Relation with another systemuser to identify the last as a manager.")
  public String getManager() {
    return manager;
  }

  public void setManager(String manager) {
    this.manager = manager;
  }

  public Systemuserreturn mfa(Mfa mfa) {
    this.mfa = mfa;
    return this;
  }

   /**
   * Get mfa
   * @return mfa
  **/
  @Schema(description = "")
  public Mfa getMfa() {
    return mfa;
  }

  public void setMfa(Mfa mfa) {
    this.mfa = mfa;
  }

  public Systemuserreturn mfaEnrollment(MfaEnrollment mfaEnrollment) {
    this.mfaEnrollment = mfaEnrollment;
    return this;
  }

   /**
   * Get mfaEnrollment
   * @return mfaEnrollment
  **/
  @Schema(description = "")
  public MfaEnrollment getMfaEnrollment() {
    return mfaEnrollment;
  }

  public void setMfaEnrollment(MfaEnrollment mfaEnrollment) {
    this.mfaEnrollment = mfaEnrollment;
  }

  public Systemuserreturn middlename(String middlename) {
    this.middlename = middlename;
    return this;
  }

   /**
   * Get middlename
   * @return middlename
  **/
  @Schema(description = "")
  public String getMiddlename() {
    return middlename;
  }

  public void setMiddlename(String middlename) {
    this.middlename = middlename;
  }

  public Systemuserreturn organization(String organization) {
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

  public Systemuserreturn passwordExpirationDate(String passwordExpirationDate) {
    this.passwordExpirationDate = passwordExpirationDate;
    return this;
  }

   /**
   * Get passwordExpirationDate
   * @return passwordExpirationDate
  **/
  @Schema(description = "")
  public String getPasswordExpirationDate() {
    return passwordExpirationDate;
  }

  public void setPasswordExpirationDate(String passwordExpirationDate) {
    this.passwordExpirationDate = passwordExpirationDate;
  }

  public Systemuserreturn passwordExpired(Boolean passwordExpired) {
    this.passwordExpired = passwordExpired;
    return this;
  }

   /**
   * Get passwordExpired
   * @return passwordExpired
  **/
  @Schema(description = "")
  public Boolean isPasswordExpired() {
    return passwordExpired;
  }

  public void setPasswordExpired(Boolean passwordExpired) {
    this.passwordExpired = passwordExpired;
  }

  public Systemuserreturn passwordNeverExpires(Boolean passwordNeverExpires) {
    this.passwordNeverExpires = passwordNeverExpires;
    return this;
  }

   /**
   * Get passwordNeverExpires
   * @return passwordNeverExpires
  **/
  @Schema(description = "")
  public Boolean isPasswordNeverExpires() {
    return passwordNeverExpires;
  }

  public void setPasswordNeverExpires(Boolean passwordNeverExpires) {
    this.passwordNeverExpires = passwordNeverExpires;
  }

  public Systemuserreturn passwordlessSudo(Boolean passwordlessSudo) {
    this.passwordlessSudo = passwordlessSudo;
    return this;
  }

   /**
   * Get passwordlessSudo
   * @return passwordlessSudo
  **/
  @Schema(description = "")
  public Boolean isPasswordlessSudo() {
    return passwordlessSudo;
  }

  public void setPasswordlessSudo(Boolean passwordlessSudo) {
    this.passwordlessSudo = passwordlessSudo;
  }

  public Systemuserreturn phoneNumbers(List<SystemuserreturnPhoneNumbers> phoneNumbers) {
    this.phoneNumbers = phoneNumbers;
    return this;
  }

  public Systemuserreturn addPhoneNumbersItem(SystemuserreturnPhoneNumbers phoneNumbersItem) {
    if (this.phoneNumbers == null) {
      this.phoneNumbers = new ArrayList<SystemuserreturnPhoneNumbers>();
    }
    this.phoneNumbers.add(phoneNumbersItem);
    return this;
  }

   /**
   * Get phoneNumbers
   * @return phoneNumbers
  **/
  @Schema(description = "")
  public List<SystemuserreturnPhoneNumbers> getPhoneNumbers() {
    return phoneNumbers;
  }

  public void setPhoneNumbers(List<SystemuserreturnPhoneNumbers> phoneNumbers) {
    this.phoneNumbers = phoneNumbers;
  }

  public Systemuserreturn publicKey(String publicKey) {
    this.publicKey = publicKey;
    return this;
  }

   /**
   * Get publicKey
   * @return publicKey
  **/
  @Schema(description = "")
  public String getPublicKey() {
    return publicKey;
  }

  public void setPublicKey(String publicKey) {
    this.publicKey = publicKey;
  }

  public Systemuserreturn recoveryEmail(SystemuserreturnRecoveryEmail recoveryEmail) {
    this.recoveryEmail = recoveryEmail;
    return this;
  }

   /**
   * Get recoveryEmail
   * @return recoveryEmail
  **/
  @Schema(description = "")
  public SystemuserreturnRecoveryEmail getRecoveryEmail() {
    return recoveryEmail;
  }

  public void setRecoveryEmail(SystemuserreturnRecoveryEmail recoveryEmail) {
    this.recoveryEmail = recoveryEmail;
  }

  public Systemuserreturn relationships(List<SystemuserputRelationships> relationships) {
    this.relationships = relationships;
    return this;
  }

  public Systemuserreturn addRelationshipsItem(SystemuserputRelationships relationshipsItem) {
    if (this.relationships == null) {
      this.relationships = new ArrayList<SystemuserputRelationships>();
    }
    this.relationships.add(relationshipsItem);
    return this;
  }

   /**
   * Get relationships
   * @return relationships
  **/
  @Schema(description = "")
  public List<SystemuserputRelationships> getRelationships() {
    return relationships;
  }

  public void setRelationships(List<SystemuserputRelationships> relationships) {
    this.relationships = relationships;
  }

  public Systemuserreturn sambaServiceUser(Boolean sambaServiceUser) {
    this.sambaServiceUser = sambaServiceUser;
    return this;
  }

   /**
   * Get sambaServiceUser
   * @return sambaServiceUser
  **/
  @Schema(description = "")
  public Boolean isSambaServiceUser() {
    return sambaServiceUser;
  }

  public void setSambaServiceUser(Boolean sambaServiceUser) {
    this.sambaServiceUser = sambaServiceUser;
  }

  public Systemuserreturn sshKeys(List<Sshkeylist> sshKeys) {
    this.sshKeys = sshKeys;
    return this;
  }

  public Systemuserreturn addSshKeysItem(Sshkeylist sshKeysItem) {
    if (this.sshKeys == null) {
      this.sshKeys = new ArrayList<Sshkeylist>();
    }
    this.sshKeys.add(sshKeysItem);
    return this;
  }

   /**
   * Get sshKeys
   * @return sshKeys
  **/
  @Schema(description = "")
  public List<Sshkeylist> getSshKeys() {
    return sshKeys;
  }

  public void setSshKeys(List<Sshkeylist> sshKeys) {
    this.sshKeys = sshKeys;
  }

  public Systemuserreturn state(StateEnum state) {
    this.state = state;
    return this;
  }

   /**
   * Get state
   * @return state
  **/
  @Schema(description = "")
  public StateEnum getState() {
    return state;
  }

  public void setState(StateEnum state) {
    this.state = state;
  }

  public Systemuserreturn sudo(Boolean sudo) {
    this.sudo = sudo;
    return this;
  }

   /**
   * Get sudo
   * @return sudo
  **/
  @Schema(description = "")
  public Boolean isSudo() {
    return sudo;
  }

  public void setSudo(Boolean sudo) {
    this.sudo = sudo;
  }

  public Systemuserreturn suspended(Boolean suspended) {
    this.suspended = suspended;
    return this;
  }

   /**
   * Get suspended
   * @return suspended
  **/
  @Schema(description = "")
  public Boolean isSuspended() {
    return suspended;
  }

  public void setSuspended(Boolean suspended) {
    this.suspended = suspended;
  }

  public Systemuserreturn tags(List<String> tags) {
    this.tags = tags;
    return this;
  }

  public Systemuserreturn addTagsItem(String tagsItem) {
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

  public Systemuserreturn totpEnabled(Boolean totpEnabled) {
    this.totpEnabled = totpEnabled;
    return this;
  }

   /**
   * Get totpEnabled
   * @return totpEnabled
  **/
  @Schema(description = "")
  public Boolean isTotpEnabled() {
    return totpEnabled;
  }

  public void setTotpEnabled(Boolean totpEnabled) {
    this.totpEnabled = totpEnabled;
  }

  public Systemuserreturn unixGuid(Integer unixGuid) {
    this.unixGuid = unixGuid;
    return this;
  }

   /**
   * Get unixGuid
   * minimum: 1
   * @return unixGuid
  **/
  @Schema(description = "")
  public Integer getUnixGuid() {
    return unixGuid;
  }

  public void setUnixGuid(Integer unixGuid) {
    this.unixGuid = unixGuid;
  }

  public Systemuserreturn unixUid(Integer unixUid) {
    this.unixUid = unixUid;
    return this;
  }

   /**
   * Get unixUid
   * minimum: 1
   * @return unixUid
  **/
  @Schema(description = "")
  public Integer getUnixUid() {
    return unixUid;
  }

  public void setUnixUid(Integer unixUid) {
    this.unixUid = unixUid;
  }

  public Systemuserreturn username(String username) {
    this.username = username;
    return this;
  }

   /**
   * Get username
   * @return username
  **/
  @Schema(description = "")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Systemuserreturn systemuserreturn = (Systemuserreturn) o;
    return Objects.equals(this._id, systemuserreturn._id) &&
        Objects.equals(this.accountLocked, systemuserreturn.accountLocked) &&
        Objects.equals(this.accountLockedDate, systemuserreturn.accountLockedDate) &&
        Objects.equals(this.activated, systemuserreturn.activated) &&
        Objects.equals(this.addresses, systemuserreturn.addresses) &&
        Objects.equals(this.allowPublicKey, systemuserreturn.allowPublicKey) &&
        Objects.equals(this.alternateEmail, systemuserreturn.alternateEmail) &&
        Objects.equals(this.attributes, systemuserreturn.attributes) &&
        Objects.equals(this.badLoginAttempts, systemuserreturn.badLoginAttempts) &&
        Objects.equals(this.company, systemuserreturn.company) &&
        Objects.equals(this.costCenter, systemuserreturn.costCenter) &&
        Objects.equals(this.created, systemuserreturn.created) &&
        Objects.equals(this.creationSource, systemuserreturn.creationSource) &&
        Objects.equals(this.department, systemuserreturn.department) &&
        Objects.equals(this.description, systemuserreturn.description) &&
        Objects.equals(this.disableDeviceMaxLoginAttempts, systemuserreturn.disableDeviceMaxLoginAttempts) &&
        Objects.equals(this.displayname, systemuserreturn.displayname) &&
        Objects.equals(this.email, systemuserreturn.email) &&
        Objects.equals(this.employeeIdentifier, systemuserreturn.employeeIdentifier) &&
        Objects.equals(this.employeeType, systemuserreturn.employeeType) &&
        Objects.equals(this.enableManagedUid, systemuserreturn.enableManagedUid) &&
        Objects.equals(this.enableUserPortalMultifactor, systemuserreturn.enableUserPortalMultifactor) &&
        Objects.equals(this.externalDn, systemuserreturn.externalDn) &&
        Objects.equals(this.externalPasswordExpirationDate, systemuserreturn.externalPasswordExpirationDate) &&
        Objects.equals(this.externalSourceType, systemuserreturn.externalSourceType) &&
        Objects.equals(this.externallyManaged, systemuserreturn.externallyManaged) &&
        Objects.equals(this.firstname, systemuserreturn.firstname) &&
        Objects.equals(this.jobTitle, systemuserreturn.jobTitle) &&
        Objects.equals(this.lastname, systemuserreturn.lastname) &&
        Objects.equals(this.ldapBindingUser, systemuserreturn.ldapBindingUser) &&
        Objects.equals(this.location, systemuserreturn.location) &&
        Objects.equals(this.managedAppleId, systemuserreturn.managedAppleId) &&
        Objects.equals(this.manager, systemuserreturn.manager) &&
        Objects.equals(this.mfa, systemuserreturn.mfa) &&
        Objects.equals(this.mfaEnrollment, systemuserreturn.mfaEnrollment) &&
        Objects.equals(this.middlename, systemuserreturn.middlename) &&
        Objects.equals(this.organization, systemuserreturn.organization) &&
        Objects.equals(this.passwordExpirationDate, systemuserreturn.passwordExpirationDate) &&
        Objects.equals(this.passwordExpired, systemuserreturn.passwordExpired) &&
        Objects.equals(this.passwordNeverExpires, systemuserreturn.passwordNeverExpires) &&
        Objects.equals(this.passwordlessSudo, systemuserreturn.passwordlessSudo) &&
        Objects.equals(this.phoneNumbers, systemuserreturn.phoneNumbers) &&
        Objects.equals(this.publicKey, systemuserreturn.publicKey) &&
        Objects.equals(this.recoveryEmail, systemuserreturn.recoveryEmail) &&
        Objects.equals(this.relationships, systemuserreturn.relationships) &&
        Objects.equals(this.sambaServiceUser, systemuserreturn.sambaServiceUser) &&
        Objects.equals(this.sshKeys, systemuserreturn.sshKeys) &&
        Objects.equals(this.state, systemuserreturn.state) &&
        Objects.equals(this.sudo, systemuserreturn.sudo) &&
        Objects.equals(this.suspended, systemuserreturn.suspended) &&
        Objects.equals(this.tags, systemuserreturn.tags) &&
        Objects.equals(this.totpEnabled, systemuserreturn.totpEnabled) &&
        Objects.equals(this.unixGuid, systemuserreturn.unixGuid) &&
        Objects.equals(this.unixUid, systemuserreturn.unixUid) &&
        Objects.equals(this.username, systemuserreturn.username);
  }

  @Override
  public int hashCode() {
    return Objects.hash(_id, accountLocked, accountLockedDate, activated, addresses, allowPublicKey, alternateEmail, attributes, badLoginAttempts, company, costCenter, created, creationSource, department, description, disableDeviceMaxLoginAttempts, displayname, email, employeeIdentifier, employeeType, enableManagedUid, enableUserPortalMultifactor, externalDn, externalPasswordExpirationDate, externalSourceType, externallyManaged, firstname, jobTitle, lastname, ldapBindingUser, location, managedAppleId, manager, mfa, mfaEnrollment, middlename, organization, passwordExpirationDate, passwordExpired, passwordNeverExpires, passwordlessSudo, phoneNumbers, publicKey, recoveryEmail, relationships, sambaServiceUser, sshKeys, state, sudo, suspended, tags, totpEnabled, unixGuid, unixUid, username);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Systemuserreturn {\n");
    
    sb.append("    _id: ").append(toIndentedString(_id)).append("\n");
    sb.append("    accountLocked: ").append(toIndentedString(accountLocked)).append("\n");
    sb.append("    accountLockedDate: ").append(toIndentedString(accountLockedDate)).append("\n");
    sb.append("    activated: ").append(toIndentedString(activated)).append("\n");
    sb.append("    addresses: ").append(toIndentedString(addresses)).append("\n");
    sb.append("    allowPublicKey: ").append(toIndentedString(allowPublicKey)).append("\n");
    sb.append("    alternateEmail: ").append(toIndentedString(alternateEmail)).append("\n");
    sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
    sb.append("    badLoginAttempts: ").append(toIndentedString(badLoginAttempts)).append("\n");
    sb.append("    company: ").append(toIndentedString(company)).append("\n");
    sb.append("    costCenter: ").append(toIndentedString(costCenter)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    creationSource: ").append(toIndentedString(creationSource)).append("\n");
    sb.append("    department: ").append(toIndentedString(department)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    disableDeviceMaxLoginAttempts: ").append(toIndentedString(disableDeviceMaxLoginAttempts)).append("\n");
    sb.append("    displayname: ").append(toIndentedString(displayname)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    employeeIdentifier: ").append(toIndentedString(employeeIdentifier)).append("\n");
    sb.append("    employeeType: ").append(toIndentedString(employeeType)).append("\n");
    sb.append("    enableManagedUid: ").append(toIndentedString(enableManagedUid)).append("\n");
    sb.append("    enableUserPortalMultifactor: ").append(toIndentedString(enableUserPortalMultifactor)).append("\n");
    sb.append("    externalDn: ").append(toIndentedString(externalDn)).append("\n");
    sb.append("    externalPasswordExpirationDate: ").append(toIndentedString(externalPasswordExpirationDate)).append("\n");
    sb.append("    externalSourceType: ").append(toIndentedString(externalSourceType)).append("\n");
    sb.append("    externallyManaged: ").append(toIndentedString(externallyManaged)).append("\n");
    sb.append("    firstname: ").append(toIndentedString(firstname)).append("\n");
    sb.append("    jobTitle: ").append(toIndentedString(jobTitle)).append("\n");
    sb.append("    lastname: ").append(toIndentedString(lastname)).append("\n");
    sb.append("    ldapBindingUser: ").append(toIndentedString(ldapBindingUser)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    managedAppleId: ").append(toIndentedString(managedAppleId)).append("\n");
    sb.append("    manager: ").append(toIndentedString(manager)).append("\n");
    sb.append("    mfa: ").append(toIndentedString(mfa)).append("\n");
    sb.append("    mfaEnrollment: ").append(toIndentedString(mfaEnrollment)).append("\n");
    sb.append("    middlename: ").append(toIndentedString(middlename)).append("\n");
    sb.append("    organization: ").append(toIndentedString(organization)).append("\n");
    sb.append("    passwordExpirationDate: ").append(toIndentedString(passwordExpirationDate)).append("\n");
    sb.append("    passwordExpired: ").append(toIndentedString(passwordExpired)).append("\n");
    sb.append("    passwordNeverExpires: ").append(toIndentedString(passwordNeverExpires)).append("\n");
    sb.append("    passwordlessSudo: ").append(toIndentedString(passwordlessSudo)).append("\n");
    sb.append("    phoneNumbers: ").append(toIndentedString(phoneNumbers)).append("\n");
    sb.append("    publicKey: ").append(toIndentedString(publicKey)).append("\n");
    sb.append("    recoveryEmail: ").append(toIndentedString(recoveryEmail)).append("\n");
    sb.append("    relationships: ").append(toIndentedString(relationships)).append("\n");
    sb.append("    sambaServiceUser: ").append(toIndentedString(sambaServiceUser)).append("\n");
    sb.append("    sshKeys: ").append(toIndentedString(sshKeys)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    sudo: ").append(toIndentedString(sudo)).append("\n");
    sb.append("    suspended: ").append(toIndentedString(suspended)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    totpEnabled: ").append(toIndentedString(totpEnabled)).append("\n");
    sb.append("    unixGuid: ").append(toIndentedString(unixGuid)).append("\n");
    sb.append("    unixUid: ").append(toIndentedString(unixUid)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
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
