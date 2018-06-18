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
import io.swagger.client.model.SystemNetworkInterfaces;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * System
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-06-11T23:05:15.891Z")
public class System {
  @SerializedName("organization")
  private String organization = null;

  @SerializedName("created")
  private String created = null;

  @SerializedName("lastContact")
  private String lastContact = null;

  @SerializedName("os")
  private String os = null;

  @SerializedName("version")
  private String version = null;

  @SerializedName("arch")
  private String arch = null;

  @SerializedName("networkInterfaces")
  private List<SystemNetworkInterfaces> networkInterfaces = null;

  @SerializedName("hostname")
  private String hostname = null;

  @SerializedName("displayName")
  private String displayName = null;

  @SerializedName("systemTimezone")
  private Integer systemTimezone = null;

  @SerializedName("templateName")
  private String templateName = null;

  @SerializedName("remoteIP")
  private String remoteIP = null;

  @SerializedName("active")
  private Boolean active = null;

  @SerializedName("sshdParams")
  private List<String> sshdParams = null;

  @SerializedName("allowSshPasswordAuthentication")
  private Boolean allowSshPasswordAuthentication = null;

  @SerializedName("allowSshRootLogin")
  private Boolean allowSshRootLogin = null;

  @SerializedName("allowMultiFactorAuthentication")
  private Boolean allowMultiFactorAuthentication = null;

  @SerializedName("allowPublicKeyAuthentication")
  private Boolean allowPublicKeyAuthentication = null;

  @SerializedName("modifySSHDConfig")
  private Boolean modifySSHDConfig = null;

  @SerializedName("agentVersion")
  private String agentVersion = null;

  @SerializedName("connectionHistory")
  private List<Object> connectionHistory = null;

  @SerializedName("sshRootEnabled")
  private Boolean sshRootEnabled = null;

  @SerializedName("tags")
  private List<String> tags = null;

  @SerializedName("_id")
  private String id = null;

  public System organization(String organization) {
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

  public System created(String created) {
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

  public System lastContact(String lastContact) {
    this.lastContact = lastContact;
    return this;
  }

   /**
   * Get lastContact
   * @return lastContact
  **/
  @ApiModelProperty(value = "")
  public String getLastContact() {
    return lastContact;
  }

  public void setLastContact(String lastContact) {
    this.lastContact = lastContact;
  }

  public System os(String os) {
    this.os = os;
    return this;
  }

   /**
   * Get os
   * @return os
  **/
  @ApiModelProperty(value = "")
  public String getOs() {
    return os;
  }

  public void setOs(String os) {
    this.os = os;
  }

  public System version(String version) {
    this.version = version;
    return this;
  }

   /**
   * Get version
   * @return version
  **/
  @ApiModelProperty(value = "")
  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public System arch(String arch) {
    this.arch = arch;
    return this;
  }

   /**
   * Get arch
   * @return arch
  **/
  @ApiModelProperty(value = "")
  public String getArch() {
    return arch;
  }

  public void setArch(String arch) {
    this.arch = arch;
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
  @ApiModelProperty(value = "")
  public List<SystemNetworkInterfaces> getNetworkInterfaces() {
    return networkInterfaces;
  }

  public void setNetworkInterfaces(List<SystemNetworkInterfaces> networkInterfaces) {
    this.networkInterfaces = networkInterfaces;
  }

  public System hostname(String hostname) {
    this.hostname = hostname;
    return this;
  }

   /**
   * Get hostname
   * @return hostname
  **/
  @ApiModelProperty(value = "")
  public String getHostname() {
    return hostname;
  }

  public void setHostname(String hostname) {
    this.hostname = hostname;
  }

  public System displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }

   /**
   * Get displayName
   * @return displayName
  **/
  @ApiModelProperty(value = "")
  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public System systemTimezone(Integer systemTimezone) {
    this.systemTimezone = systemTimezone;
    return this;
  }

   /**
   * Get systemTimezone
   * @return systemTimezone
  **/
  @ApiModelProperty(value = "")
  public Integer getSystemTimezone() {
    return systemTimezone;
  }

  public void setSystemTimezone(Integer systemTimezone) {
    this.systemTimezone = systemTimezone;
  }

  public System templateName(String templateName) {
    this.templateName = templateName;
    return this;
  }

   /**
   * Get templateName
   * @return templateName
  **/
  @ApiModelProperty(value = "")
  public String getTemplateName() {
    return templateName;
  }

  public void setTemplateName(String templateName) {
    this.templateName = templateName;
  }

  public System remoteIP(String remoteIP) {
    this.remoteIP = remoteIP;
    return this;
  }

   /**
   * Get remoteIP
   * @return remoteIP
  **/
  @ApiModelProperty(value = "")
  public String getRemoteIP() {
    return remoteIP;
  }

  public void setRemoteIP(String remoteIP) {
    this.remoteIP = remoteIP;
  }

  public System active(Boolean active) {
    this.active = active;
    return this;
  }

   /**
   * Get active
   * @return active
  **/
  @ApiModelProperty(value = "")
  public Boolean isActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public System sshdParams(List<String> sshdParams) {
    this.sshdParams = sshdParams;
    return this;
  }

  public System addSshdParamsItem(String sshdParamsItem) {
    if (this.sshdParams == null) {
      this.sshdParams = new ArrayList<String>();
    }
    this.sshdParams.add(sshdParamsItem);
    return this;
  }

   /**
   * Get sshdParams
   * @return sshdParams
  **/
  @ApiModelProperty(value = "")
  public List<String> getSshdParams() {
    return sshdParams;
  }

  public void setSshdParams(List<String> sshdParams) {
    this.sshdParams = sshdParams;
  }

  public System allowSshPasswordAuthentication(Boolean allowSshPasswordAuthentication) {
    this.allowSshPasswordAuthentication = allowSshPasswordAuthentication;
    return this;
  }

   /**
   * Get allowSshPasswordAuthentication
   * @return allowSshPasswordAuthentication
  **/
  @ApiModelProperty(value = "")
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
  @ApiModelProperty(value = "")
  public Boolean isAllowSshRootLogin() {
    return allowSshRootLogin;
  }

  public void setAllowSshRootLogin(Boolean allowSshRootLogin) {
    this.allowSshRootLogin = allowSshRootLogin;
  }

  public System allowMultiFactorAuthentication(Boolean allowMultiFactorAuthentication) {
    this.allowMultiFactorAuthentication = allowMultiFactorAuthentication;
    return this;
  }

   /**
   * Get allowMultiFactorAuthentication
   * @return allowMultiFactorAuthentication
  **/
  @ApiModelProperty(value = "")
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
  @ApiModelProperty(value = "")
  public Boolean isAllowPublicKeyAuthentication() {
    return allowPublicKeyAuthentication;
  }

  public void setAllowPublicKeyAuthentication(Boolean allowPublicKeyAuthentication) {
    this.allowPublicKeyAuthentication = allowPublicKeyAuthentication;
  }

  public System modifySSHDConfig(Boolean modifySSHDConfig) {
    this.modifySSHDConfig = modifySSHDConfig;
    return this;
  }

   /**
   * Get modifySSHDConfig
   * @return modifySSHDConfig
  **/
  @ApiModelProperty(value = "")
  public Boolean isModifySSHDConfig() {
    return modifySSHDConfig;
  }

  public void setModifySSHDConfig(Boolean modifySSHDConfig) {
    this.modifySSHDConfig = modifySSHDConfig;
  }

  public System agentVersion(String agentVersion) {
    this.agentVersion = agentVersion;
    return this;
  }

   /**
   * Get agentVersion
   * @return agentVersion
  **/
  @ApiModelProperty(value = "")
  public String getAgentVersion() {
    return agentVersion;
  }

  public void setAgentVersion(String agentVersion) {
    this.agentVersion = agentVersion;
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
  @ApiModelProperty(value = "")
  public List<Object> getConnectionHistory() {
    return connectionHistory;
  }

  public void setConnectionHistory(List<Object> connectionHistory) {
    this.connectionHistory = connectionHistory;
  }

  public System sshRootEnabled(Boolean sshRootEnabled) {
    this.sshRootEnabled = sshRootEnabled;
    return this;
  }

   /**
   * Get sshRootEnabled
   * @return sshRootEnabled
  **/
  @ApiModelProperty(value = "")
  public Boolean isSshRootEnabled() {
    return sshRootEnabled;
  }

  public void setSshRootEnabled(Boolean sshRootEnabled) {
    this.sshRootEnabled = sshRootEnabled;
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
  @ApiModelProperty(value = "")
  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  public System id(String id) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    System system = (System) o;
    return Objects.equals(this.organization, system.organization) &&
        Objects.equals(this.created, system.created) &&
        Objects.equals(this.lastContact, system.lastContact) &&
        Objects.equals(this.os, system.os) &&
        Objects.equals(this.version, system.version) &&
        Objects.equals(this.arch, system.arch) &&
        Objects.equals(this.networkInterfaces, system.networkInterfaces) &&
        Objects.equals(this.hostname, system.hostname) &&
        Objects.equals(this.displayName, system.displayName) &&
        Objects.equals(this.systemTimezone, system.systemTimezone) &&
        Objects.equals(this.templateName, system.templateName) &&
        Objects.equals(this.remoteIP, system.remoteIP) &&
        Objects.equals(this.active, system.active) &&
        Objects.equals(this.sshdParams, system.sshdParams) &&
        Objects.equals(this.allowSshPasswordAuthentication, system.allowSshPasswordAuthentication) &&
        Objects.equals(this.allowSshRootLogin, system.allowSshRootLogin) &&
        Objects.equals(this.allowMultiFactorAuthentication, system.allowMultiFactorAuthentication) &&
        Objects.equals(this.allowPublicKeyAuthentication, system.allowPublicKeyAuthentication) &&
        Objects.equals(this.modifySSHDConfig, system.modifySSHDConfig) &&
        Objects.equals(this.agentVersion, system.agentVersion) &&
        Objects.equals(this.connectionHistory, system.connectionHistory) &&
        Objects.equals(this.sshRootEnabled, system.sshRootEnabled) &&
        Objects.equals(this.tags, system.tags) &&
        Objects.equals(this.id, system.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(organization, created, lastContact, os, version, arch, networkInterfaces, hostname, displayName, systemTimezone, templateName, remoteIP, active, sshdParams, allowSshPasswordAuthentication, allowSshRootLogin, allowMultiFactorAuthentication, allowPublicKeyAuthentication, modifySSHDConfig, agentVersion, connectionHistory, sshRootEnabled, tags, id);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class System {\n");
    
    sb.append("    organization: ").append(toIndentedString(organization)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    lastContact: ").append(toIndentedString(lastContact)).append("\n");
    sb.append("    os: ").append(toIndentedString(os)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    arch: ").append(toIndentedString(arch)).append("\n");
    sb.append("    networkInterfaces: ").append(toIndentedString(networkInterfaces)).append("\n");
    sb.append("    hostname: ").append(toIndentedString(hostname)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    systemTimezone: ").append(toIndentedString(systemTimezone)).append("\n");
    sb.append("    templateName: ").append(toIndentedString(templateName)).append("\n");
    sb.append("    remoteIP: ").append(toIndentedString(remoteIP)).append("\n");
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    sshdParams: ").append(toIndentedString(sshdParams)).append("\n");
    sb.append("    allowSshPasswordAuthentication: ").append(toIndentedString(allowSshPasswordAuthentication)).append("\n");
    sb.append("    allowSshRootLogin: ").append(toIndentedString(allowSshRootLogin)).append("\n");
    sb.append("    allowMultiFactorAuthentication: ").append(toIndentedString(allowMultiFactorAuthentication)).append("\n");
    sb.append("    allowPublicKeyAuthentication: ").append(toIndentedString(allowPublicKeyAuthentication)).append("\n");
    sb.append("    modifySSHDConfig: ").append(toIndentedString(modifySSHDConfig)).append("\n");
    sb.append("    agentVersion: ").append(toIndentedString(agentVersion)).append("\n");
    sb.append("    connectionHistory: ").append(toIndentedString(connectionHistory)).append("\n");
    sb.append("    sshRootEnabled: ").append(toIndentedString(sshRootEnabled)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

