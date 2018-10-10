/*
 * JumpCloud APIs
 *  JumpCloud's V1 API. This set of endpoints allows JumpCloud customers to manage commands, systems, & system users.
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
import io.swagger.client.model.SystemuserputpostAddresses;
import io.swagger.client.model.SystemuserputpostPhoneNumbers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Systemuserputpost
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-10-10T23:14:24.693Z")
public class Systemuserputpost {
  @SerializedName("email")
  private String email = null;

  @SerializedName("username")
  private String username = null;

  @SerializedName("allow_public_key")
  private Boolean allowPublicKey = null;

  @SerializedName("public_key")
  private String publicKey = null;

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

  @SerializedName("attributes")
  private List<Object> attributes = null;

  @SerializedName("samba_service_user")
  private Boolean sambaServiceUser = null;

  @SerializedName("addresses")
  private List<SystemuserputpostAddresses> addresses = null;

  @SerializedName("jobTitle")
  private String jobTitle = null;

  @SerializedName("department")
  private String department = null;

  @SerializedName("phoneNumbers")
  private List<SystemuserputpostPhoneNumbers> phoneNumbers = null;

  @SerializedName("relationships")
  private List<Object> relationships = null;

  @SerializedName("password")
  private String password = null;

  @SerializedName("password_never_expires")
  private Boolean passwordNeverExpires = null;

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

  public Systemuserputpost email(String email) {
    this.email = email;
    return this;
  }

   /**
   * Get email
   * @return email
  **/
  @ApiModelProperty(required = true, value = "")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Systemuserputpost username(String username) {
    this.username = username;
    return this;
  }

   /**
   * Get username
   * @return username
  **/
  @ApiModelProperty(required = true, value = "")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Systemuserputpost allowPublicKey(Boolean allowPublicKey) {
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

  public Systemuserputpost publicKey(String publicKey) {
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

  public Systemuserputpost sudo(Boolean sudo) {
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

  public Systemuserputpost enableManagedUid(Boolean enableManagedUid) {
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

  public Systemuserputpost unixUid(Integer unixUid) {
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

  public Systemuserputpost unixGuid(Integer unixGuid) {
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

  public Systemuserputpost activated(Boolean activated) {
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

  public Systemuserputpost tags(List<String> tags) {
    this.tags = tags;
    return this;
  }

  public Systemuserputpost addTagsItem(String tagsItem) {
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

  public Systemuserputpost accountLocked(Boolean accountLocked) {
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

  public Systemuserputpost passwordlessSudo(Boolean passwordlessSudo) {
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

  public Systemuserputpost externallyManaged(Boolean externallyManaged) {
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

  public Systemuserputpost externalDn(String externalDn) {
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

  public Systemuserputpost externalSourceType(String externalSourceType) {
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

  public Systemuserputpost firstname(String firstname) {
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

  public Systemuserputpost lastname(String lastname) {
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

  public Systemuserputpost ldapBindingUser(Boolean ldapBindingUser) {
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

  public Systemuserputpost enableUserPortalMultifactor(Boolean enableUserPortalMultifactor) {
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

  public Systemuserputpost attributes(List<Object> attributes) {
    this.attributes = attributes;
    return this;
  }

  public Systemuserputpost addAttributesItem(Object attributesItem) {
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

  public Systemuserputpost sambaServiceUser(Boolean sambaServiceUser) {
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

  public Systemuserputpost addresses(List<SystemuserputpostAddresses> addresses) {
    this.addresses = addresses;
    return this;
  }

  public Systemuserputpost addAddressesItem(SystemuserputpostAddresses addressesItem) {
    if (this.addresses == null) {
      this.addresses = new ArrayList<SystemuserputpostAddresses>();
    }
    this.addresses.add(addressesItem);
    return this;
  }

   /**
   * Get addresses
   * @return addresses
  **/
  @ApiModelProperty(value = "")
  public List<SystemuserputpostAddresses> getAddresses() {
    return addresses;
  }

  public void setAddresses(List<SystemuserputpostAddresses> addresses) {
    this.addresses = addresses;
  }

  public Systemuserputpost jobTitle(String jobTitle) {
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

  public Systemuserputpost department(String department) {
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

  public Systemuserputpost phoneNumbers(List<SystemuserputpostPhoneNumbers> phoneNumbers) {
    this.phoneNumbers = phoneNumbers;
    return this;
  }

  public Systemuserputpost addPhoneNumbersItem(SystemuserputpostPhoneNumbers phoneNumbersItem) {
    if (this.phoneNumbers == null) {
      this.phoneNumbers = new ArrayList<SystemuserputpostPhoneNumbers>();
    }
    this.phoneNumbers.add(phoneNumbersItem);
    return this;
  }

   /**
   * Get phoneNumbers
   * @return phoneNumbers
  **/
  @ApiModelProperty(value = "")
  public List<SystemuserputpostPhoneNumbers> getPhoneNumbers() {
    return phoneNumbers;
  }

  public void setPhoneNumbers(List<SystemuserputpostPhoneNumbers> phoneNumbers) {
    this.phoneNumbers = phoneNumbers;
  }

  public Systemuserputpost relationships(List<Object> relationships) {
    this.relationships = relationships;
    return this;
  }

  public Systemuserputpost addRelationshipsItem(Object relationshipsItem) {
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

  public Systemuserputpost password(String password) {
    this.password = password;
    return this;
  }

   /**
   * Get password
   * @return password
  **/
  @ApiModelProperty(value = "")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Systemuserputpost passwordNeverExpires(Boolean passwordNeverExpires) {
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

  public Systemuserputpost middlename(String middlename) {
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

  public Systemuserputpost displayname(String displayname) {
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

  public Systemuserputpost description(String description) {
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

  public Systemuserputpost location(String location) {
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

  public Systemuserputpost costCenter(String costCenter) {
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

  public Systemuserputpost employeeType(String employeeType) {
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

  public Systemuserputpost company(String company) {
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

  public Systemuserputpost employeeIdentifier(String employeeIdentifier) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Systemuserputpost systemuserputpost = (Systemuserputpost) o;
    return Objects.equals(this.email, systemuserputpost.email) &&
        Objects.equals(this.username, systemuserputpost.username) &&
        Objects.equals(this.allowPublicKey, systemuserputpost.allowPublicKey) &&
        Objects.equals(this.publicKey, systemuserputpost.publicKey) &&
        Objects.equals(this.sudo, systemuserputpost.sudo) &&
        Objects.equals(this.enableManagedUid, systemuserputpost.enableManagedUid) &&
        Objects.equals(this.unixUid, systemuserputpost.unixUid) &&
        Objects.equals(this.unixGuid, systemuserputpost.unixGuid) &&
        Objects.equals(this.activated, systemuserputpost.activated) &&
        Objects.equals(this.tags, systemuserputpost.tags) &&
        Objects.equals(this.accountLocked, systemuserputpost.accountLocked) &&
        Objects.equals(this.passwordlessSudo, systemuserputpost.passwordlessSudo) &&
        Objects.equals(this.externallyManaged, systemuserputpost.externallyManaged) &&
        Objects.equals(this.externalDn, systemuserputpost.externalDn) &&
        Objects.equals(this.externalSourceType, systemuserputpost.externalSourceType) &&
        Objects.equals(this.firstname, systemuserputpost.firstname) &&
        Objects.equals(this.lastname, systemuserputpost.lastname) &&
        Objects.equals(this.ldapBindingUser, systemuserputpost.ldapBindingUser) &&
        Objects.equals(this.enableUserPortalMultifactor, systemuserputpost.enableUserPortalMultifactor) &&
        Objects.equals(this.attributes, systemuserputpost.attributes) &&
        Objects.equals(this.sambaServiceUser, systemuserputpost.sambaServiceUser) &&
        Objects.equals(this.addresses, systemuserputpost.addresses) &&
        Objects.equals(this.jobTitle, systemuserputpost.jobTitle) &&
        Objects.equals(this.department, systemuserputpost.department) &&
        Objects.equals(this.phoneNumbers, systemuserputpost.phoneNumbers) &&
        Objects.equals(this.relationships, systemuserputpost.relationships) &&
        Objects.equals(this.password, systemuserputpost.password) &&
        Objects.equals(this.passwordNeverExpires, systemuserputpost.passwordNeverExpires) &&
        Objects.equals(this.middlename, systemuserputpost.middlename) &&
        Objects.equals(this.displayname, systemuserputpost.displayname) &&
        Objects.equals(this.description, systemuserputpost.description) &&
        Objects.equals(this.location, systemuserputpost.location) &&
        Objects.equals(this.costCenter, systemuserputpost.costCenter) &&
        Objects.equals(this.employeeType, systemuserputpost.employeeType) &&
        Objects.equals(this.company, systemuserputpost.company) &&
        Objects.equals(this.employeeIdentifier, systemuserputpost.employeeIdentifier);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, username, allowPublicKey, publicKey, sudo, enableManagedUid, unixUid, unixGuid, activated, tags, accountLocked, passwordlessSudo, externallyManaged, externalDn, externalSourceType, firstname, lastname, ldapBindingUser, enableUserPortalMultifactor, attributes, sambaServiceUser, addresses, jobTitle, department, phoneNumbers, relationships, password, passwordNeverExpires, middlename, displayname, description, location, costCenter, employeeType, company, employeeIdentifier);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Systemuserputpost {\n");
    
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    allowPublicKey: ").append(toIndentedString(allowPublicKey)).append("\n");
    sb.append("    publicKey: ").append(toIndentedString(publicKey)).append("\n");
    sb.append("    sudo: ").append(toIndentedString(sudo)).append("\n");
    sb.append("    enableManagedUid: ").append(toIndentedString(enableManagedUid)).append("\n");
    sb.append("    unixUid: ").append(toIndentedString(unixUid)).append("\n");
    sb.append("    unixGuid: ").append(toIndentedString(unixGuid)).append("\n");
    sb.append("    activated: ").append(toIndentedString(activated)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    accountLocked: ").append(toIndentedString(accountLocked)).append("\n");
    sb.append("    passwordlessSudo: ").append(toIndentedString(passwordlessSudo)).append("\n");
    sb.append("    externallyManaged: ").append(toIndentedString(externallyManaged)).append("\n");
    sb.append("    externalDn: ").append(toIndentedString(externalDn)).append("\n");
    sb.append("    externalSourceType: ").append(toIndentedString(externalSourceType)).append("\n");
    sb.append("    firstname: ").append(toIndentedString(firstname)).append("\n");
    sb.append("    lastname: ").append(toIndentedString(lastname)).append("\n");
    sb.append("    ldapBindingUser: ").append(toIndentedString(ldapBindingUser)).append("\n");
    sb.append("    enableUserPortalMultifactor: ").append(toIndentedString(enableUserPortalMultifactor)).append("\n");
    sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
    sb.append("    sambaServiceUser: ").append(toIndentedString(sambaServiceUser)).append("\n");
    sb.append("    addresses: ").append(toIndentedString(addresses)).append("\n");
    sb.append("    jobTitle: ").append(toIndentedString(jobTitle)).append("\n");
    sb.append("    department: ").append(toIndentedString(department)).append("\n");
    sb.append("    phoneNumbers: ").append(toIndentedString(phoneNumbers)).append("\n");
    sb.append("    relationships: ").append(toIndentedString(relationships)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    passwordNeverExpires: ").append(toIndentedString(passwordNeverExpires)).append("\n");
    sb.append("    middlename: ").append(toIndentedString(middlename)).append("\n");
    sb.append("    displayname: ").append(toIndentedString(displayname)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    costCenter: ").append(toIndentedString(costCenter)).append("\n");
    sb.append("    employeeType: ").append(toIndentedString(employeeType)).append("\n");
    sb.append("    company: ").append(toIndentedString(company)).append("\n");
    sb.append("    employeeIdentifier: ").append(toIndentedString(employeeIdentifier)).append("\n");
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

