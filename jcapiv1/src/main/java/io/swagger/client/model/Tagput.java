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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Tagput
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-08-08T19:23:48.289Z")
public class Tagput {
  @SerializedName("name")
  private String name = null;

  @SerializedName("systems")
  private List<String> systems = null;

  @SerializedName("systemusers")
  private List<String> systemusers = null;

  @SerializedName("regularExpressions")
  private List<String> regularExpressions = null;

  @SerializedName("externallyManaged")
  private Boolean externallyManaged = null;

  @SerializedName("externalDN")
  private String externalDN = null;

  @SerializedName("externalSourceType")
  private String externalSourceType = null;

  @SerializedName("sendToLDAP")
  private Boolean sendToLDAP = null;

  @SerializedName("groupGid")
  private String groupGid = null;

  @SerializedName("groupName")
  private String groupName = null;

  public Tagput name(String name) {
    this.name = name;
    return this;
  }

   /**
   * A unique name for the Tag.
   * @return name
  **/
  @ApiModelProperty(value = "A unique name for the Tag.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Tagput systems(List<String> systems) {
    this.systems = systems;
    return this;
  }

  public Tagput addSystemsItem(String systemsItem) {
    if (this.systems == null) {
      this.systems = new ArrayList<String>();
    }
    this.systems.add(systemsItem);
    return this;
  }

   /**
   * An array of system ids that are associated to the Tag.
   * @return systems
  **/
  @ApiModelProperty(value = "An array of system ids that are associated to the Tag.")
  public List<String> getSystems() {
    return systems;
  }

  public void setSystems(List<String> systems) {
    this.systems = systems;
  }

  public Tagput systemusers(List<String> systemusers) {
    this.systemusers = systemusers;
    return this;
  }

  public Tagput addSystemusersItem(String systemusersItem) {
    if (this.systemusers == null) {
      this.systemusers = new ArrayList<String>();
    }
    this.systemusers.add(systemusersItem);
    return this;
  }

   /**
   * An array of system user ids that are associated to the Tag.
   * @return systemusers
  **/
  @ApiModelProperty(value = "An array of system user ids that are associated to the Tag.")
  public List<String> getSystemusers() {
    return systemusers;
  }

  public void setSystemusers(List<String> systemusers) {
    this.systemusers = systemusers;
  }

  public Tagput regularExpressions(List<String> regularExpressions) {
    this.regularExpressions = regularExpressions;
    return this;
  }

  public Tagput addRegularExpressionsItem(String regularExpressionsItem) {
    if (this.regularExpressions == null) {
      this.regularExpressions = new ArrayList<String>();
    }
    this.regularExpressions.add(regularExpressionsItem);
    return this;
  }

   /**
   * Get regularExpressions
   * @return regularExpressions
  **/
  @ApiModelProperty(value = "")
  public List<String> getRegularExpressions() {
    return regularExpressions;
  }

  public void setRegularExpressions(List<String> regularExpressions) {
    this.regularExpressions = regularExpressions;
  }

  public Tagput externallyManaged(Boolean externallyManaged) {
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

  public Tagput externalDN(String externalDN) {
    this.externalDN = externalDN;
    return this;
  }

   /**
   * Get externalDN
   * @return externalDN
  **/
  @ApiModelProperty(value = "")
  public String getExternalDN() {
    return externalDN;
  }

  public void setExternalDN(String externalDN) {
    this.externalDN = externalDN;
  }

  public Tagput externalSourceType(String externalSourceType) {
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

  public Tagput sendToLDAP(Boolean sendToLDAP) {
    this.sendToLDAP = sendToLDAP;
    return this;
  }

   /**
   * Get sendToLDAP
   * @return sendToLDAP
  **/
  @ApiModelProperty(value = "")
  public Boolean isSendToLDAP() {
    return sendToLDAP;
  }

  public void setSendToLDAP(Boolean sendToLDAP) {
    this.sendToLDAP = sendToLDAP;
  }

  public Tagput groupGid(String groupGid) {
    this.groupGid = groupGid;
    return this;
  }

   /**
   * Get groupGid
   * @return groupGid
  **/
  @ApiModelProperty(value = "")
  public String getGroupGid() {
    return groupGid;
  }

  public void setGroupGid(String groupGid) {
    this.groupGid = groupGid;
  }

  public Tagput groupName(String groupName) {
    this.groupName = groupName;
    return this;
  }

   /**
   * Get groupName
   * @return groupName
  **/
  @ApiModelProperty(value = "")
  public String getGroupName() {
    return groupName;
  }

  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Tagput tagput = (Tagput) o;
    return Objects.equals(this.name, tagput.name) &&
        Objects.equals(this.systems, tagput.systems) &&
        Objects.equals(this.systemusers, tagput.systemusers) &&
        Objects.equals(this.regularExpressions, tagput.regularExpressions) &&
        Objects.equals(this.externallyManaged, tagput.externallyManaged) &&
        Objects.equals(this.externalDN, tagput.externalDN) &&
        Objects.equals(this.externalSourceType, tagput.externalSourceType) &&
        Objects.equals(this.sendToLDAP, tagput.sendToLDAP) &&
        Objects.equals(this.groupGid, tagput.groupGid) &&
        Objects.equals(this.groupName, tagput.groupName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, systems, systemusers, regularExpressions, externallyManaged, externalDN, externalSourceType, sendToLDAP, groupGid, groupName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Tagput {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    systems: ").append(toIndentedString(systems)).append("\n");
    sb.append("    systemusers: ").append(toIndentedString(systemusers)).append("\n");
    sb.append("    regularExpressions: ").append(toIndentedString(regularExpressions)).append("\n");
    sb.append("    externallyManaged: ").append(toIndentedString(externallyManaged)).append("\n");
    sb.append("    externalDN: ").append(toIndentedString(externalDN)).append("\n");
    sb.append("    externalSourceType: ").append(toIndentedString(externalSourceType)).append("\n");
    sb.append("    sendToLDAP: ").append(toIndentedString(sendToLDAP)).append("\n");
    sb.append("    groupGid: ").append(toIndentedString(groupGid)).append("\n");
    sb.append("    groupName: ").append(toIndentedString(groupName)).append("\n");
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

