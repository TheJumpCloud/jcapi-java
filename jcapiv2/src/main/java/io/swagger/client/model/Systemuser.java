/*
 * JumpCloud APIs
 *  JumpCloud's V2 API. This set of endpoints allows JumpCloud customers to manage objects, groupings and mappings and interact with the JumpCloud Graph.
 *
 * OpenAPI spec version: 2.0
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
import io.swagger.client.model.Sshkeylist;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Systemuser
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-01-08T20:00:43.436Z")
public class Systemuser {
  @SerializedName("email")
  private String email = null;

  @SerializedName("username")
  private String username = null;

  @SerializedName("allow_public_key")
  private Boolean allowPublicKey = null;

  @SerializedName("public_key")
  private String publicKey = null;

  @SerializedName("ssh_keys")
  private List<Sshkeylist> sshKeys = null;

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

  @SerializedName("associatedTagCount")
  private Integer associatedTagCount = null;

  @SerializedName("totp_enabled")
  private Boolean totpEnabled = null;

  @SerializedName("password_expiration_date")
  private String passwordExpirationDate = null;

  @SerializedName("attributes")
  private List<Object> attributes = null;

  @SerializedName("created")
  private String created = null;

  @SerializedName("samba_service_user")
  private Boolean sambaServiceUser = null;

  @SerializedName("password_never_expires")
  private Boolean passwordNeverExpires = null;

  @SerializedName("_id")
  private String id = null;

  @SerializedName("middlename")
  private String middlename = null;

  @SerializedName("displayname")
  private String displayname = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("location")
  private String location = null;

  @SerializedName("costCenter")
  private String costCenter = null;

  @SerializedName("employeeType")
  private String employeeType = null;

  @SerializedName("company")
  private String company = null;

  @SerializedName("employeeIdentifier")
  private String employeeIdentifier = null;

  @SerializedName("jobTitle")
  private String jobTitle = null;

  @SerializedName("department")
  private String department = null;

  public Systemuser email(String email) {
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

  public Systemuser username(String username) {
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

  public Systemuser allowPublicKey(Boolean allowPublicKey) {
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

  public Systemuser publicKey(String publicKey) {
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

  public Systemuser sshKeys(List<Sshkeylist> sshKeys) {
    this.sshKeys = sshKeys;
    return this;
  }

  public Systemuser addSshKeysItem(Sshkeylist sshKeysItem) {
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
  @ApiModelProperty(value = "")
  public List<Sshkeylist> getSshKeys() {
    return sshKeys;
  }

  public void setSshKeys(List<Sshkeylist> sshKeys) {
    this.sshKeys = sshKeys;
  }

  public Systemuser sudo(Boolean sudo) {
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

  public Systemuser enableManagedUid(Boolean enableManagedUid) {
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

  public Systemuser unixUid(Integer unixUid) {
    this.unixUid = unixUid;
    return this;
  }

   /**
   * Get unixUid
   * minimum: 1
   * @return unixUid
  **/
  @ApiModelProperty(value = "")
  public Integer getUnixUid() {
    return unixUid;
  }

  public void setUnixUid(Integer unixUid) {
    this.unixUid = unixUid;
  }

  public Systemuser unixGuid(Integer unixGuid) {
    this.unixGuid = unixGuid;
    return this;
  }

   /**
   * Get unixGuid
   * minimum: 1
   * @return unixGuid
  **/
  @ApiModelProperty(value = "")
  public Integer getUnixGuid() {
    return unixGuid;
  }

  public void setUnixGuid(Integer unixGuid) {
    this.unixGuid = unixGuid;
  }

  public Systemuser activated(Boolean activated) {
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

  public Systemuser tags(List<String> tags) {
    this.tags = tags;
    return this;
  }

  public Systemuser addTagsItem(String tagsItem) {
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

  public Systemuser passwordExpired(Boolean passwordExpired) {
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

  public Systemuser accountLocked(Boolean accountLocked) {
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

  public Systemuser passwordlessSudo(Boolean passwordlessSudo) {
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

  public Systemuser externallyManaged(Boolean externallyManaged) {
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

  public Systemuser externalDn(String externalDn) {
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

  public Systemuser externalSourceType(String externalSourceType) {
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

  public Systemuser firstname(String firstname) {
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

  public Systemuser lastname(String lastname) {
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

  public Systemuser ldapBindingUser(Boolean ldapBindingUser) {
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

  public Systemuser enableUserPortalMultifactor(Boolean enableUserPortalMultifactor) {
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

  public Systemuser associatedTagCount(Integer associatedTagCount) {
    this.associatedTagCount = associatedTagCount;
    return this;
  }

   /**
   * Get associatedTagCount
   * minimum: 0
   * @return associatedTagCount
  **/
  @ApiModelProperty(value = "")
  public Integer getAssociatedTagCount() {
    return associatedTagCount;
  }

  public void setAssociatedTagCount(Integer associatedTagCount) {
    this.associatedTagCount = associatedTagCount;
  }

  public Systemuser totpEnabled(Boolean totpEnabled) {
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

  public Systemuser passwordExpirationDate(String passwordExpirationDate) {
    this.passwordExpirationDate = passwordExpirationDate;
    return this;
  }

   /**
   * Get passwordExpirationDate
   * @return passwordExpirationDate
  **/
  @ApiModelProperty(value = "")
  public String getPasswordExpirationDate() {
    return passwordExpirationDate;
  }

  public void setPasswordExpirationDate(String passwordExpirationDate) {
    this.passwordExpirationDate = passwordExpirationDate;
  }

  public Systemuser attributes(List<Object> attributes) {
    this.attributes = attributes;
    return this;
  }

  public Systemuser addAttributesItem(Object attributesItem) {
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

  public Systemuser created(String created) {
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

  public Systemuser sambaServiceUser(Boolean sambaServiceUser) {
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

  public Systemuser passwordNeverExpires(Boolean passwordNeverExpires) {
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

  public Systemuser id(String id) {
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

  public Systemuser middlename(String middlename) {
    this.middlename = middlename;
    return this;
  }

   /**
   * Get middlename
   * @return middlename
  **/
  @ApiModelProperty(value = "")
  public String getMiddlename() {
    return middlename;
  }

  public void setMiddlename(String middlename) {
    this.middlename = middlename;
  }

  public Systemuser displayname(String displayname) {
    this.displayname = displayname;
    return this;
  }

   /**
   * Get displayname
   * @return displayname
  **/
  @ApiModelProperty(value = "")
  public String getDisplayname() {
    return displayname;
  }

  public void setDisplayname(String displayname) {
    this.displayname = displayname;
  }

  public Systemuser description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(value = "")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Systemuser location(String location) {
    this.location = location;
    return this;
  }

   /**
   * Get location
   * @return location
  **/
  @ApiModelProperty(value = "")
  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public Systemuser costCenter(String costCenter) {
    this.costCenter = costCenter;
    return this;
  }

   /**
   * Get costCenter
   * @return costCenter
  **/
  @ApiModelProperty(value = "")
  public String getCostCenter() {
    return costCenter;
  }

  public void setCostCenter(String costCenter) {
    this.costCenter = costCenter;
  }

  public Systemuser employeeType(String employeeType) {
    this.employeeType = employeeType;
    return this;
  }

   /**
   * Get employeeType
   * @return employeeType
  **/
  @ApiModelProperty(value = "")
  public String getEmployeeType() {
    return employeeType;
  }

  public void setEmployeeType(String employeeType) {
    this.employeeType = employeeType;
  }

  public Systemuser company(String company) {
    this.company = company;
    return this;
  }

   /**
   * Get company
   * @return company
  **/
  @ApiModelProperty(value = "")
  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public Systemuser employeeIdentifier(String employeeIdentifier) {
    this.employeeIdentifier = employeeIdentifier;
    return this;
  }

   /**
   * Must be unique per user. 
   * @return employeeIdentifier
  **/
  @ApiModelProperty(value = "Must be unique per user. ")
  public String getEmployeeIdentifier() {
    return employeeIdentifier;
  }

  public void setEmployeeIdentifier(String employeeIdentifier) {
    this.employeeIdentifier = employeeIdentifier;
  }

  public Systemuser jobTitle(String jobTitle) {
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

  public Systemuser department(String department) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Systemuser systemuser = (Systemuser) o;
    return Objects.equals(this.email, systemuser.email) &&
        Objects.equals(this.username, systemuser.username) &&
        Objects.equals(this.allowPublicKey, systemuser.allowPublicKey) &&
        Objects.equals(this.publicKey, systemuser.publicKey) &&
        Objects.equals(this.sshKeys, systemuser.sshKeys) &&
        Objects.equals(this.sudo, systemuser.sudo) &&
        Objects.equals(this.enableManagedUid, systemuser.enableManagedUid) &&
        Objects.equals(this.unixUid, systemuser.unixUid) &&
        Objects.equals(this.unixGuid, systemuser.unixGuid) &&
        Objects.equals(this.activated, systemuser.activated) &&
        Objects.equals(this.tags, systemuser.tags) &&
        Objects.equals(this.passwordExpired, systemuser.passwordExpired) &&
        Objects.equals(this.accountLocked, systemuser.accountLocked) &&
        Objects.equals(this.passwordlessSudo, systemuser.passwordlessSudo) &&
        Objects.equals(this.externallyManaged, systemuser.externallyManaged) &&
        Objects.equals(this.externalDn, systemuser.externalDn) &&
        Objects.equals(this.externalSourceType, systemuser.externalSourceType) &&
        Objects.equals(this.firstname, systemuser.firstname) &&
        Objects.equals(this.lastname, systemuser.lastname) &&
        Objects.equals(this.ldapBindingUser, systemuser.ldapBindingUser) &&
        Objects.equals(this.enableUserPortalMultifactor, systemuser.enableUserPortalMultifactor) &&
        Objects.equals(this.associatedTagCount, systemuser.associatedTagCount) &&
        Objects.equals(this.totpEnabled, systemuser.totpEnabled) &&
        Objects.equals(this.passwordExpirationDate, systemuser.passwordExpirationDate) &&
        Objects.equals(this.attributes, systemuser.attributes) &&
        Objects.equals(this.created, systemuser.created) &&
        Objects.equals(this.sambaServiceUser, systemuser.sambaServiceUser) &&
        Objects.equals(this.passwordNeverExpires, systemuser.passwordNeverExpires) &&
        Objects.equals(this.id, systemuser.id) &&
        Objects.equals(this.middlename, systemuser.middlename) &&
        Objects.equals(this.displayname, systemuser.displayname) &&
        Objects.equals(this.description, systemuser.description) &&
        Objects.equals(this.location, systemuser.location) &&
        Objects.equals(this.costCenter, systemuser.costCenter) &&
        Objects.equals(this.employeeType, systemuser.employeeType) &&
        Objects.equals(this.company, systemuser.company) &&
        Objects.equals(this.employeeIdentifier, systemuser.employeeIdentifier) &&
        Objects.equals(this.jobTitle, systemuser.jobTitle) &&
        Objects.equals(this.department, systemuser.department);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, username, allowPublicKey, publicKey, sshKeys, sudo, enableManagedUid, unixUid, unixGuid, activated, tags, passwordExpired, accountLocked, passwordlessSudo, externallyManaged, externalDn, externalSourceType, firstname, lastname, ldapBindingUser, enableUserPortalMultifactor, associatedTagCount, totpEnabled, passwordExpirationDate, attributes, created, sambaServiceUser, passwordNeverExpires, id, middlename, displayname, description, location, costCenter, employeeType, company, employeeIdentifier, jobTitle, department);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Systemuser {\n");
    
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
    sb.append("    associatedTagCount: ").append(toIndentedString(associatedTagCount)).append("\n");
    sb.append("    totpEnabled: ").append(toIndentedString(totpEnabled)).append("\n");
    sb.append("    passwordExpirationDate: ").append(toIndentedString(passwordExpirationDate)).append("\n");
    sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    sambaServiceUser: ").append(toIndentedString(sambaServiceUser)).append("\n");
    sb.append("    passwordNeverExpires: ").append(toIndentedString(passwordNeverExpires)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    middlename: ").append(toIndentedString(middlename)).append("\n");
    sb.append("    displayname: ").append(toIndentedString(displayname)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    costCenter: ").append(toIndentedString(costCenter)).append("\n");
    sb.append("    employeeType: ").append(toIndentedString(employeeType)).append("\n");
    sb.append("    company: ").append(toIndentedString(company)).append("\n");
    sb.append("    employeeIdentifier: ").append(toIndentedString(employeeIdentifier)).append("\n");
    sb.append("    jobTitle: ").append(toIndentedString(jobTitle)).append("\n");
    sb.append("    department: ").append(toIndentedString(department)).append("\n");
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

