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
 * Tagpost
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-11-15T20:11:11.958Z")
public class Tagpost {
  @SerializedName("externalDN")
  private String externalDN = null;

  @SerializedName("externalSourceType")
  private String externalSourceType = null;

  @SerializedName("externallyManaged")
  private Boolean externallyManaged = null;

  @SerializedName("groupGid")
  private String groupGid = null;

  @SerializedName("groupName")
  private String groupName = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("regularExpressions")
  private List<String> regularExpressions = null;

  @SerializedName("sendToLDAP")
  private Boolean sendToLDAP = null;

  @SerializedName("systems")
  private List<String> systems = null;

  @SerializedName("systemusers")
  private List<String> systemusers = null;

  public Tagpost externalDN(String externalDN) {
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

  public Tagpost externalSourceType(String externalSourceType) {
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

  public Tagpost externallyManaged(Boolean externallyManaged) {
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

  public Tagpost groupGid(String groupGid) {
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

  public Tagpost groupName(String groupName) {
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

  public Tagpost name(String name) {
    this.name = name;
    return this;
  }

   /**
   * A unique name for the Tag.
   * @return name
  **/
  @ApiModelProperty(required = true, value = "A unique name for the Tag.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Tagpost regularExpressions(List<String> regularExpressions) {
    this.regularExpressions = regularExpressions;
    return this;
  }

  public Tagpost addRegularExpressionsItem(String regularExpressionsItem) {
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

  public Tagpost sendToLDAP(Boolean sendToLDAP) {
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

  public Tagpost systems(List<String> systems) {
    this.systems = systems;
    return this;
  }

  public Tagpost addSystemsItem(String systemsItem) {
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

  public Tagpost systemusers(List<String> systemusers) {
    this.systemusers = systemusers;
    return this;
  }

  public Tagpost addSystemusersItem(String systemusersItem) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Tagpost tagpost = (Tagpost) o;
    return Objects.equals(this.externalDN, tagpost.externalDN) &&
        Objects.equals(this.externalSourceType, tagpost.externalSourceType) &&
        Objects.equals(this.externallyManaged, tagpost.externallyManaged) &&
        Objects.equals(this.groupGid, tagpost.groupGid) &&
        Objects.equals(this.groupName, tagpost.groupName) &&
        Objects.equals(this.name, tagpost.name) &&
        Objects.equals(this.regularExpressions, tagpost.regularExpressions) &&
        Objects.equals(this.sendToLDAP, tagpost.sendToLDAP) &&
        Objects.equals(this.systems, tagpost.systems) &&
        Objects.equals(this.systemusers, tagpost.systemusers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(externalDN, externalSourceType, externallyManaged, groupGid, groupName, name, regularExpressions, sendToLDAP, systems, systemusers);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Tagpost {\n");
    
    sb.append("    externalDN: ").append(toIndentedString(externalDN)).append("\n");
    sb.append("    externalSourceType: ").append(toIndentedString(externalSourceType)).append("\n");
    sb.append("    externallyManaged: ").append(toIndentedString(externallyManaged)).append("\n");
    sb.append("    groupGid: ").append(toIndentedString(groupGid)).append("\n");
    sb.append("    groupName: ").append(toIndentedString(groupName)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    regularExpressions: ").append(toIndentedString(regularExpressions)).append("\n");
    sb.append("    sendToLDAP: ").append(toIndentedString(sendToLDAP)).append("\n");
    sb.append("    systems: ").append(toIndentedString(systems)).append("\n");
    sb.append("    systemusers: ").append(toIndentedString(systemusers)).append("\n");
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

