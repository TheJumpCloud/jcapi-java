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
import java.util.Arrays;
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
 * Tag
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-02-20T21:32:24.213Z")
public class Tag {
  @SerializedName("_id")
  private String id = null;

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

  @SerializedName("expired")
  private Boolean expired = null;

  @SerializedName("groupGid")
  private String groupGid = null;

  @SerializedName("groupName")
  private String groupName = null;

  public Tag id(String id) {
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

  public Tag name(String name) {
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

  public Tag systems(List<String> systems) {
    this.systems = systems;
    return this;
  }

  public Tag addSystemsItem(String systemsItem) {
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

  public Tag systemusers(List<String> systemusers) {
    this.systemusers = systemusers;
    return this;
  }

  public Tag addSystemusersItem(String systemusersItem) {
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

  public Tag regularExpressions(List<String> regularExpressions) {
    this.regularExpressions = regularExpressions;
    return this;
  }

  public Tag addRegularExpressionsItem(String regularExpressionsItem) {
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

  public Tag externallyManaged(Boolean externallyManaged) {
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

  public Tag externalDN(String externalDN) {
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

  public Tag externalSourceType(String externalSourceType) {
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

  public Tag sendToLDAP(Boolean sendToLDAP) {
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

  public Tag expired(Boolean expired) {
    this.expired = expired;
    return this;
  }

   /**
   * Get expired
   * @return expired
  **/
  @ApiModelProperty(value = "")
  public Boolean isExpired() {
    return expired;
  }

  public void setExpired(Boolean expired) {
    this.expired = expired;
  }

  public Tag groupGid(String groupGid) {
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

  public Tag groupName(String groupName) {
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
    Tag tag = (Tag) o;
    return Objects.equals(this.id, tag.id) &&
        Objects.equals(this.name, tag.name) &&
        Objects.equals(this.systems, tag.systems) &&
        Objects.equals(this.systemusers, tag.systemusers) &&
        Objects.equals(this.regularExpressions, tag.regularExpressions) &&
        Objects.equals(this.externallyManaged, tag.externallyManaged) &&
        Objects.equals(this.externalDN, tag.externalDN) &&
        Objects.equals(this.externalSourceType, tag.externalSourceType) &&
        Objects.equals(this.sendToLDAP, tag.sendToLDAP) &&
        Objects.equals(this.expired, tag.expired) &&
        Objects.equals(this.groupGid, tag.groupGid) &&
        Objects.equals(this.groupName, tag.groupName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, systems, systemusers, regularExpressions, externallyManaged, externalDN, externalSourceType, sendToLDAP, expired, groupGid, groupName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Tag {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    systems: ").append(toIndentedString(systems)).append("\n");
    sb.append("    systemusers: ").append(toIndentedString(systemusers)).append("\n");
    sb.append("    regularExpressions: ").append(toIndentedString(regularExpressions)).append("\n");
    sb.append("    externallyManaged: ").append(toIndentedString(externallyManaged)).append("\n");
    sb.append("    externalDN: ").append(toIndentedString(externalDN)).append("\n");
    sb.append("    externalSourceType: ").append(toIndentedString(externalSourceType)).append("\n");
    sb.append("    sendToLDAP: ").append(toIndentedString(sendToLDAP)).append("\n");
    sb.append("    expired: ").append(toIndentedString(expired)).append("\n");
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

