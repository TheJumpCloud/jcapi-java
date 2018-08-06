/*
 * JumpCloud APIs
 * V1 & V2 versions of JumpCloud's API. The previous version of JumpCloud's API. This set of endpoints allows JumpCloud customers to manage commands, systems, & system users.
 *
 * OpenAPI spec version: 1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Systemuserreturn
 */
<<<<<<< HEAD
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-08-06T18:14:17.283Z")
=======
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-06-11T23:05:15.891Z")
>>>>>>> master
public class Systemuserreturn {
  @SerializedName("email")
  private String email = null;

  @SerializedName("username")
  private String username = null;

  @SerializedName("allow_public_key")
  private Boolean allowPublicKey = null;

  @SerializedName("public_key")
  private String publicKey = null;

  @SerializedName("ssh_keys")
  private List<String> sshKeys = null;

  @SerializedName("sudo")
  private Boolean sudo = null;

  @SerializedName("enable_managed_uid")
  private Boolean enableManagedUid = null;

  @SerializedName("unix_uid")
  private Integer unixUid = null;

  @SerializedName("unix_guid")
  private Integer unixGuid = null;

  @SerializedName("activated")
  private Boolean activated = null;

  @SerializedName("tags")
  private List<String> tags = null;

  @SerializedName("password_expired")
  private Boolean passwordExpired = null;

  @SerializedName("account_locked")
  private Boolean accountLocked = null;

  @SerializedName("passwordless_sudo")
  private Boolean passwordlessSudo = null;

  @SerializedName("externally_managed")
  private Boolean externallyManaged = null;

  @SerializedName("external_dn")
  private String externalDn = null;

  @SerializedName("external_source_type")
  private String externalSourceType = null;

  @SerializedName("firstname")
  private String firstname = null;

  @SerializedName("lastname")
  private String lastname = null;

  @SerializedName("ldap_binding_user")
  private Boolean ldapBindingUser = null;

  @SerializedName("enable_user_portal_multifactor")
  private Boolean enableUserPortalMultifactor = null;

  @SerializedName("totp_enabled")
  private Boolean totpEnabled = null;

  @SerializedName("attributes")
  private List<Object> attributes = null;

  @SerializedName("created")
  private String created = null;

  @SerializedName("samba_service_user")
  private Boolean sambaServiceUser = null;

  @SerializedName("id")
  private String id = null;

  @SerializedName("organization")
  private String organization = null;

  @SerializedName("addresses")
  private List<String> addresses = null;

  @SerializedName("jobTitle")
  private String jobTitle = null;

  @SerializedName("department")
  private String department = null;

  @SerializedName("phoneNumbers")
  private List<String> phoneNumbers = null;

  @SerializedName("relationships")
  private List<Object> relationships = null;

  @SerializedName("badLoginAttempts")
  private Integer badLoginAttempts = null;

  @SerializedName("password_never_expires")
  private Boolean passwordNeverExpires = null;

  public Systemuserreturn email(String email) {
    this.email = email;
    return this;
  }

   /**
   * Get email
   * @return email
  **/
  @ApiModelProperty(value = "")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Systemuserreturn username(String username) {
    this.username = username;
    return this;
  }

   /**
   * Get username
   * @return username
  **/
  @ApiModelProperty(value = "")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Systemuserreturn allowPublicKey(Boolean allowPublicKey) {
    this.allowPublicKey = allowPublicKey;
    return this;
  }

   /**
   * Get allowPublicKey
   * @return allowPublicKey
  **/
  @ApiModelProperty(value = "")
  public Boolean isAllowPublicKey() {
    return allowPublicKey;
  }

  public void setAllowPublicKey(Boolean allowPublicKey) {
    this.allowPublicKey = allowPublicKey;
  }

  public Systemuserreturn publicKey(String publicKey) {
    this.publicKey = publicKey;
    return this;
  }

   /**
   * Get publicKey
   * @return publicKey
  **/
  @ApiModelProperty(value = "")
  public String getPublicKey() {
    return publicKey;
  }

  public void setPublicKey(String publicKey) {
    this.publicKey = publicKey;
  }

  public Systemuserreturn sshKeys(List<String> sshKeys) {
    this.sshKeys = sshKeys;
    return this;
  }

  public Systemuserreturn addSshKeysItem(String sshKeysItem) {
    if (this.sshKeys == null) {
      this.sshKeys = new ArrayList<String>();
    }
    this.sshKeys.add(sshKeysItem);
    return this;
  }

   /**
   * Get sshKeys
   * @return sshKeys
  **/
  @ApiModelProperty(value = "")
  public List<String> getSshKeys() {
    return sshKeys;
  }

  public void setSshKeys(List<String> sshKeys) {
    this.sshKeys = sshKeys;
  }

  public Systemuserreturn sudo(Boolean sudo) {
    this.sudo = sudo;
    return this;
  }

   /**
   * Get sudo
   * @return sudo
  **/
  @ApiModelProperty(value = "")
  public Boolean isSudo() {
    return sudo;
  }

  public void setSudo(Boolean sudo) {
    this.sudo = sudo;
  }

  public Systemuserreturn enableManagedUid(Boolean enableManagedUid) {
    this.enableManagedUid = enableManagedUid;
    return this;
  }

   /**
   * Get enableManagedUid
   * @return enableManagedUid
  **/
  @ApiModelProperty(value = "")
  public Boolean isEnableManagedUid() {
    return enableManagedUid;
  }

  public void setEnableManagedUid(Boolean enableManagedUid) {
    this.enableManagedUid = enableManagedUid;
  }

  public Systemuserreturn unixUid(Integer unixUid) {
    this.unixUid = unixUid;
    return this;
  }

   /**
   * Get unixUid
   * minimum: 0
   * @return unixUid
  **/
  @ApiModelProperty(value = "")
  public Integer getUnixUid() {
    return unixUid;
  }

  public void setUnixUid(Integer unixUid) {
    this.unixUid = unixUid;
  }

  public Systemuserreturn unixGuid(Integer unixGuid) {
    this.unixGuid = unixGuid;
    return this;
  }

   /**
   * Get unixGuid
   * minimum: 0
   * @return unixGuid
  **/
  @ApiModelProperty(value = "")
  public Integer getUnixGuid() {
    return unixGuid;
  }

  public void setUnixGuid(Integer unixGuid) {
    this.unixGuid = unixGuid;
  }

  public Systemuserreturn activated(Boolean activated) {
    this.activated = activated;
    return this;
  }

   /**
   * Get activated
   * @return activated
  **/
  @ApiModelProperty(value = "")
  public Boolean isActivated() {
    return activated;
  }

  public void setActivated(Boolean activated) {
    this.activated = activated;
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
  @ApiModelProperty(value = "")
  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  public Systemuserreturn passwordExpired(Boolean passwordExpired) {
    this.passwordExpired = passwordExpired;
    return this;
  }

   /**
   * Get passwordExpired
   * @return passwordExpired
  **/
  @ApiModelProperty(value = "")
  public Boolean isPasswordExpired() {
    return passwordExpired;
  }

  public void setPasswordExpired(Boolean passwordExpired) {
    this.passwordExpired = passwordExpired;
  }

  public Systemuserreturn accountLocked(Boolean accountLocked) {
    this.accountLocked = accountLocked;
    return this;
  }

   /**
   * Get accountLocked
   * @return accountLocked
  **/
  @ApiModelProperty(value = "")
  public Boolean isAccountLocked() {
    return accountLocked;
  }

  public void setAccountLocked(Boolean accountLocked) {
    this.accountLocked = accountLocked;
  }

  public Systemuserreturn passwordlessSudo(Boolean passwordlessSudo) {
    this.passwordlessSudo = passwordlessSudo;
    return this;
  }

   /**
   * Get passwordlessSudo
   * @return passwordlessSudo
  **/
  @ApiModelProperty(value = "")
  public Boolean isPasswordlessSudo() {
    return passwordlessSudo;
  }

  public void setPasswordlessSudo(Boolean passwordlessSudo) {
    this.passwordlessSudo = passwordlessSudo;
  }

  public Systemuserreturn externallyManaged(Boolean externallyManaged) {
    this.externallyManaged = externallyManaged;
    return this;
  }

   /**
   * Get externallyManaged
   * @return externallyManaged
  **/
  @ApiModelProperty(value = "")
  public Boolean isExternallyManaged() {
    return externallyManaged;
  }

  public void setExternallyManaged(Boolean externallyManaged) {
    this.externallyManaged = externallyManaged;
  }

  public Systemuserreturn externalDn(String externalDn) {
    this.externalDn = externalDn;
    return this;
  }

   /**
   * Get externalDn
   * @return externalDn
  **/
  @ApiModelProperty(value = "")
  public String getExternalDn() {
    return externalDn;
  }

  public void setExternalDn(String externalDn) {
    this.externalDn = externalDn;
  }

  public Systemuserreturn externalSourceType(String externalSourceType) {
    this.externalSourceType = externalSourceType;
    return this;
  }

   /**
   * Get externalSourceType
   * @return externalSourceType
  **/
  @ApiModelProperty(value = "")
  public String getExternalSourceType() {
    return externalSourceType;
  }

  public void setExternalSourceType(String externalSourceType) {
    this.externalSourceType = externalSourceType;
  }

  public Systemuserreturn firstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

   /**
   * Get firstname
   * @return firstname
  **/
  @ApiModelProperty(value = "")
  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public Systemuserreturn lastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

   /**
   * Get lastname
   * @return lastname
  **/
  @ApiModelProperty(value = "")
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
  @ApiModelProperty(value = "")
  public Boolean isLdapBindingUser() {
    return ldapBindingUser;
  }

  public void setLdapBindingUser(Boolean ldapBindingUser) {
    this.ldapBindingUser = ldapBindingUser;
  }

  public Systemuserreturn enableUserPortalMultifactor(Boolean enableUserPortalMultifactor) {
    this.enableUserPortalMultifactor = enableUserPortalMultifactor;
    return this;
  }

   /**
   * Get enableUserPortalMultifactor
   * @return enableUserPortalMultifactor
  **/
  @ApiModelProperty(value = "")
  public Boolean isEnableUserPortalMultifactor() {
    return enableUserPortalMultifactor;
  }

  public void setEnableUserPortalMultifactor(Boolean enableUserPortalMultifactor) {
    this.enableUserPortalMultifactor = enableUserPortalMultifactor;
  }

  public Systemuserreturn totpEnabled(Boolean totpEnabled) {
    this.totpEnabled = totpEnabled;
    return this;
  }

   /**
   * Get totpEnabled
   * @return totpEnabled
  **/
  @ApiModelProperty(value = "")
  public Boolean isTotpEnabled() {
    return totpEnabled;
  }

  public void setTotpEnabled(Boolean totpEnabled) {
    this.totpEnabled = totpEnabled;
  }

  public Systemuserreturn attributes(List<Object> attributes) {
    this.attributes = attributes;
    return this;
  }

  public Systemuserreturn addAttributesItem(Object attributesItem) {
    if (this.attributes == null) {
      this.attributes = new ArrayList<Object>();
    }
    this.attributes.add(attributesItem);
    return this;
  }

   /**
   * Get attributes
   * @return attributes
  **/
  @ApiModelProperty(value = "")
  public List<Object> getAttributes() {
    return attributes;
  }

  public void setAttributes(List<Object> attributes) {
    this.attributes = attributes;
  }

  public Systemuserreturn created(String created) {
    this.created = created;
    return this;
  }

   /**
   * Get created
   * @return created
  **/
  @ApiModelProperty(value = "")
  public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }

  public Systemuserreturn sambaServiceUser(Boolean sambaServiceUser) {
    this.sambaServiceUser = sambaServiceUser;
    return this;
  }

   /**
   * Get sambaServiceUser
   * @return sambaServiceUser
  **/
  @ApiModelProperty(value = "")
  public Boolean isSambaServiceUser() {
    return sambaServiceUser;
  }

  public void setSambaServiceUser(Boolean sambaServiceUser) {
    this.sambaServiceUser = sambaServiceUser;
  }

  public Systemuserreturn id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Systemuserreturn organization(String organization) {
    this.organization = organization;
    return this;
  }

   /**
   * Get organization
   * @return organization
  **/
  @ApiModelProperty(value = "")
  public String getOrganization() {
    return organization;
  }

  public void setOrganization(String organization) {
    this.organization = organization;
  }

  public Systemuserreturn addresses(List<String> addresses) {
    this.addresses = addresses;
    return this;
  }

  public Systemuserreturn addAddressesItem(String addressesItem) {
    if (this.addresses == null) {
      this.addresses = new ArrayList<String>();
    }
    this.addresses.add(addressesItem);
    return this;
  }

   /**
   * Get addresses
   * @return addresses
  **/
  @ApiModelProperty(value = "")
  public List<String> getAddresses() {
    return addresses;
  }

  public void setAddresses(List<String> addresses) {
    this.addresses = addresses;
  }

  public Systemuserreturn jobTitle(String jobTitle) {
    this.jobTitle = jobTitle;
    return this;
  }

   /**
   * Get jobTitle
   * @return jobTitle
  **/
  @ApiModelProperty(value = "")
  public String getJobTitle() {
    return jobTitle;
  }

  public void setJobTitle(String jobTitle) {
    this.jobTitle = jobTitle;
  }

  public Systemuserreturn department(String department) {
    this.department = department;
    return this;
  }

   /**
   * Get department
   * @return department
  **/
  @ApiModelProperty(value = "")
  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public Systemuserreturn phoneNumbers(List<String> phoneNumbers) {
    this.phoneNumbers = phoneNumbers;
    return this;
  }

  public Systemuserreturn addPhoneNumbersItem(String phoneNumbersItem) {
    if (this.phoneNumbers == null) {
      this.phoneNumbers = new ArrayList<String>();
    }
    this.phoneNumbers.add(phoneNumbersItem);
    return this;
  }

   /**
   * Get phoneNumbers
   * @return phoneNumbers
  **/
  @ApiModelProperty(value = "")
  public List<String> getPhoneNumbers() {
    return phoneNumbers;
  }

  public void setPhoneNumbers(List<String> phoneNumbers) {
    this.phoneNumbers = phoneNumbers;
  }

  public Systemuserreturn relationships(List<Object> relationships) {
    this.relationships = relationships;
    return this;
  }

  public Systemuserreturn addRelationshipsItem(Object relationshipsItem) {
    if (this.relationships == null) {
      this.relationships = new ArrayList<Object>();
    }
    this.relationships.add(relationshipsItem);
    return this;
  }

   /**
   * Get relationships
   * @return relationships
  **/
  @ApiModelProperty(value = "")
  public List<Object> getRelationships() {
    return relationships;
  }

  public void setRelationships(List<Object> relationships) {
    this.relationships = relationships;
  }

  public Systemuserreturn badLoginAttempts(Integer badLoginAttempts) {
    this.badLoginAttempts = badLoginAttempts;
    return this;
  }

   /**
   * Get badLoginAttempts
   * minimum: 1
   * @return badLoginAttempts
  **/
  @ApiModelProperty(value = "")
  public Integer getBadLoginAttempts() {
    return badLoginAttempts;
  }

  public void setBadLoginAttempts(Integer badLoginAttempts) {
    this.badLoginAttempts = badLoginAttempts;
  }

  public Systemuserreturn passwordNeverExpires(Boolean passwordNeverExpires) {
    this.passwordNeverExpires = passwordNeverExpires;
    return this;
  }

   /**
   * Get passwordNeverExpires
   * @return passwordNeverExpires
  **/
  @ApiModelProperty(value = "")
  public Boolean isPasswordNeverExpires() {
    return passwordNeverExpires;
  }

  public void setPasswordNeverExpires(Boolean passwordNeverExpires) {
    this.passwordNeverExpires = passwordNeverExpires;
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
    return Objects.equals(this.email, systemuserreturn.email) &&
        Objects.equals(this.username, systemuserreturn.username) &&
        Objects.equals(this.allowPublicKey, systemuserreturn.allowPublicKey) &&
        Objects.equals(this.publicKey, systemuserreturn.publicKey) &&
        Objects.equals(this.sshKeys, systemuserreturn.sshKeys) &&
        Objects.equals(this.sudo, systemuserreturn.sudo) &&
        Objects.equals(this.enableManagedUid, systemuserreturn.enableManagedUid) &&
        Objects.equals(this.unixUid, systemuserreturn.unixUid) &&
        Objects.equals(this.unixGuid, systemuserreturn.unixGuid) &&
        Objects.equals(this.activated, systemuserreturn.activated) &&
        Objects.equals(this.tags, systemuserreturn.tags) &&
        Objects.equals(this.passwordExpired, systemuserreturn.passwordExpired) &&
        Objects.equals(this.accountLocked, systemuserreturn.accountLocked) &&
        Objects.equals(this.passwordlessSudo, systemuserreturn.passwordlessSudo) &&
        Objects.equals(this.externallyManaged, systemuserreturn.externallyManaged) &&
        Objects.equals(this.externalDn, systemuserreturn.externalDn) &&
        Objects.equals(this.externalSourceType, systemuserreturn.externalSourceType) &&
        Objects.equals(this.firstname, systemuserreturn.firstname) &&
        Objects.equals(this.lastname, systemuserreturn.lastname) &&
        Objects.equals(this.ldapBindingUser, systemuserreturn.ldapBindingUser) &&
        Objects.equals(this.enableUserPortalMultifactor, systemuserreturn.enableUserPortalMultifactor) &&
        Objects.equals(this.totpEnabled, systemuserreturn.totpEnabled) &&
        Objects.equals(this.attributes, systemuserreturn.attributes) &&
        Objects.equals(this.created, systemuserreturn.created) &&
        Objects.equals(this.sambaServiceUser, systemuserreturn.sambaServiceUser) &&
        Objects.equals(this.id, systemuserreturn.id) &&
        Objects.equals(this.organization, systemuserreturn.organization) &&
        Objects.equals(this.addresses, systemuserreturn.addresses) &&
        Objects.equals(this.jobTitle, systemuserreturn.jobTitle) &&
        Objects.equals(this.department, systemuserreturn.department) &&
        Objects.equals(this.phoneNumbers, systemuserreturn.phoneNumbers) &&
        Objects.equals(this.relationships, systemuserreturn.relationships) &&
        Objects.equals(this.badLoginAttempts, systemuserreturn.badLoginAttempts) &&
        Objects.equals(this.passwordNeverExpires, systemuserreturn.passwordNeverExpires);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, username, allowPublicKey, publicKey, sshKeys, sudo, enableManagedUid, unixUid, unixGuid, activated, tags, passwordExpired, accountLocked, passwordlessSudo, externallyManaged, externalDn, externalSourceType, firstname, lastname, ldapBindingUser, enableUserPortalMultifactor, totpEnabled, attributes, created, sambaServiceUser, id, organization, addresses, jobTitle, department, phoneNumbers, relationships, badLoginAttempts, passwordNeverExpires);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Systemuserreturn {\n");
    
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    allowPublicKey: ").append(toIndentedString(allowPublicKey)).append("\n");
    sb.append("    publicKey: ").append(toIndentedString(publicKey)).append("\n");
    sb.append("    sshKeys: ").append(toIndentedString(sshKeys)).append("\n");
    sb.append("    sudo: ").append(toIndentedString(sudo)).append("\n");
    sb.append("    enableManagedUid: ").append(toIndentedString(enableManagedUid)).append("\n");
    sb.append("    unixUid: ").append(toIndentedString(unixUid)).append("\n");
    sb.append("    unixGuid: ").append(toIndentedString(unixGuid)).append("\n");
    sb.append("    activated: ").append(toIndentedString(activated)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    passwordExpired: ").append(toIndentedString(passwordExpired)).append("\n");
    sb.append("    accountLocked: ").append(toIndentedString(accountLocked)).append("\n");
    sb.append("    passwordlessSudo: ").append(toIndentedString(passwordlessSudo)).append("\n");
    sb.append("    externallyManaged: ").append(toIndentedString(externallyManaged)).append("\n");
    sb.append("    externalDn: ").append(toIndentedString(externalDn)).append("\n");
    sb.append("    externalSourceType: ").append(toIndentedString(externalSourceType)).append("\n");
    sb.append("    firstname: ").append(toIndentedString(firstname)).append("\n");
    sb.append("    lastname: ").append(toIndentedString(lastname)).append("\n");
    sb.append("    ldapBindingUser: ").append(toIndentedString(ldapBindingUser)).append("\n");
    sb.append("    enableUserPortalMultifactor: ").append(toIndentedString(enableUserPortalMultifactor)).append("\n");
    sb.append("    totpEnabled: ").append(toIndentedString(totpEnabled)).append("\n");
    sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    sambaServiceUser: ").append(toIndentedString(sambaServiceUser)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    organization: ").append(toIndentedString(organization)).append("\n");
    sb.append("    addresses: ").append(toIndentedString(addresses)).append("\n");
    sb.append("    jobTitle: ").append(toIndentedString(jobTitle)).append("\n");
    sb.append("    department: ").append(toIndentedString(department)).append("\n");
    sb.append("    phoneNumbers: ").append(toIndentedString(phoneNumbers)).append("\n");
    sb.append("    relationships: ").append(toIndentedString(relationships)).append("\n");
    sb.append("    badLoginAttempts: ").append(toIndentedString(badLoginAttempts)).append("\n");
    sb.append("    passwordNeverExpires: ").append(toIndentedString(passwordNeverExpires)).append("\n");
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

