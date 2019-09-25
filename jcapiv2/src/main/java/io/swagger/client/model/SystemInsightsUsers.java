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
import java.io.IOException;

/**
 * SystemInsightsUsers
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-09-25T16:18:04.122Z")
public class SystemInsightsUsers {
  @SerializedName("collection_time")
  private String collectionTime = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("directory")
  private String directory = null;

  @SerializedName("gid")
  private String gid = null;

  @SerializedName("gid_signed")
  private String gidSigned = null;

  @SerializedName("shell")
  private String shell = null;

  @SerializedName("system_id")
  private String systemId = null;

  @SerializedName("type")
  private String type = null;

  @SerializedName("uid")
  private String uid = null;

  @SerializedName("uid_signed")
  private String uidSigned = null;

  @SerializedName("username")
  private String username = null;

  @SerializedName("uuid")
  private String uuid = null;

  public SystemInsightsUsers collectionTime(String collectionTime) {
    this.collectionTime = collectionTime;
    return this;
  }

   /**
   * Get collectionTime
   * @return collectionTime
  **/
  @ApiModelProperty(value = "")
  public String getCollectionTime() {
    return collectionTime;
  }

  public void setCollectionTime(String collectionTime) {
    this.collectionTime = collectionTime;
  }

  public SystemInsightsUsers description(String description) {
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

  public SystemInsightsUsers directory(String directory) {
    this.directory = directory;
    return this;
  }

   /**
   * Get directory
   * @return directory
  **/
  @ApiModelProperty(value = "")
  public String getDirectory() {
    return directory;
  }

  public void setDirectory(String directory) {
    this.directory = directory;
  }

  public SystemInsightsUsers gid(String gid) {
    this.gid = gid;
    return this;
  }

   /**
   * Get gid
   * @return gid
  **/
  @ApiModelProperty(value = "")
  public String getGid() {
    return gid;
  }

  public void setGid(String gid) {
    this.gid = gid;
  }

  public SystemInsightsUsers gidSigned(String gidSigned) {
    this.gidSigned = gidSigned;
    return this;
  }

   /**
   * Get gidSigned
   * @return gidSigned
  **/
  @ApiModelProperty(value = "")
  public String getGidSigned() {
    return gidSigned;
  }

  public void setGidSigned(String gidSigned) {
    this.gidSigned = gidSigned;
  }

  public SystemInsightsUsers shell(String shell) {
    this.shell = shell;
    return this;
  }

   /**
   * Get shell
   * @return shell
  **/
  @ApiModelProperty(value = "")
  public String getShell() {
    return shell;
  }

  public void setShell(String shell) {
    this.shell = shell;
  }

  public SystemInsightsUsers systemId(String systemId) {
    this.systemId = systemId;
    return this;
  }

   /**
   * Get systemId
   * @return systemId
  **/
  @ApiModelProperty(value = "")
  public String getSystemId() {
    return systemId;
  }

  public void setSystemId(String systemId) {
    this.systemId = systemId;
  }

  public SystemInsightsUsers type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(value = "")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public SystemInsightsUsers uid(String uid) {
    this.uid = uid;
    return this;
  }

   /**
   * Get uid
   * @return uid
  **/
  @ApiModelProperty(value = "")
  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }

  public SystemInsightsUsers uidSigned(String uidSigned) {
    this.uidSigned = uidSigned;
    return this;
  }

   /**
   * Get uidSigned
   * @return uidSigned
  **/
  @ApiModelProperty(value = "")
  public String getUidSigned() {
    return uidSigned;
  }

  public void setUidSigned(String uidSigned) {
    this.uidSigned = uidSigned;
  }

  public SystemInsightsUsers username(String username) {
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

  public SystemInsightsUsers uuid(String uuid) {
    this.uuid = uuid;
    return this;
  }

   /**
   * Get uuid
   * @return uuid
  **/
  @ApiModelProperty(value = "")
  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SystemInsightsUsers systemInsightsUsers = (SystemInsightsUsers) o;
    return Objects.equals(this.collectionTime, systemInsightsUsers.collectionTime) &&
        Objects.equals(this.description, systemInsightsUsers.description) &&
        Objects.equals(this.directory, systemInsightsUsers.directory) &&
        Objects.equals(this.gid, systemInsightsUsers.gid) &&
        Objects.equals(this.gidSigned, systemInsightsUsers.gidSigned) &&
        Objects.equals(this.shell, systemInsightsUsers.shell) &&
        Objects.equals(this.systemId, systemInsightsUsers.systemId) &&
        Objects.equals(this.type, systemInsightsUsers.type) &&
        Objects.equals(this.uid, systemInsightsUsers.uid) &&
        Objects.equals(this.uidSigned, systemInsightsUsers.uidSigned) &&
        Objects.equals(this.username, systemInsightsUsers.username) &&
        Objects.equals(this.uuid, systemInsightsUsers.uuid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(collectionTime, description, directory, gid, gidSigned, shell, systemId, type, uid, uidSigned, username, uuid);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemInsightsUsers {\n");
    
    sb.append("    collectionTime: ").append(toIndentedString(collectionTime)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    directory: ").append(toIndentedString(directory)).append("\n");
    sb.append("    gid: ").append(toIndentedString(gid)).append("\n");
    sb.append("    gidSigned: ").append(toIndentedString(gidSigned)).append("\n");
    sb.append("    shell: ").append(toIndentedString(shell)).append("\n");
    sb.append("    systemId: ").append(toIndentedString(systemId)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    uid: ").append(toIndentedString(uid)).append("\n");
    sb.append("    uidSigned: ").append(toIndentedString(uidSigned)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
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

