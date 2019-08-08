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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-08-08T01:06:48.987Z")
public class SystemInsightsUsers {
  @SerializedName("uid")
  private String uid = null;

  @SerializedName("gid")
  private String gid = null;

  @SerializedName("uid_signed")
  private String uidSigned = null;

  @SerializedName("gid_signed")
  private String gidSigned = null;

  @SerializedName("username")
  private String username = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("directory")
  private String directory = null;

  @SerializedName("shell")
  private String shell = null;

  @SerializedName("uuid")
  private String uuid = null;

  @SerializedName("type")
  private String type = null;

  @SerializedName("jc_collection_time")
  private String jcCollectionTime = null;

  @SerializedName("jc_system_id")
  private String jcSystemId = null;

  @SerializedName("jc_organization_id")
  private String jcOrganizationId = null;

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

  public SystemInsightsUsers jcCollectionTime(String jcCollectionTime) {
    this.jcCollectionTime = jcCollectionTime;
    return this;
  }

   /**
   * Get jcCollectionTime
   * @return jcCollectionTime
  **/
  @ApiModelProperty(value = "")
  public String getJcCollectionTime() {
    return jcCollectionTime;
  }

  public void setJcCollectionTime(String jcCollectionTime) {
    this.jcCollectionTime = jcCollectionTime;
  }

  public SystemInsightsUsers jcSystemId(String jcSystemId) {
    this.jcSystemId = jcSystemId;
    return this;
  }

   /**
   * Get jcSystemId
   * @return jcSystemId
  **/
  @ApiModelProperty(value = "")
  public String getJcSystemId() {
    return jcSystemId;
  }

  public void setJcSystemId(String jcSystemId) {
    this.jcSystemId = jcSystemId;
  }

  public SystemInsightsUsers jcOrganizationId(String jcOrganizationId) {
    this.jcOrganizationId = jcOrganizationId;
    return this;
  }

   /**
   * Get jcOrganizationId
   * @return jcOrganizationId
  **/
  @ApiModelProperty(value = "")
  public String getJcOrganizationId() {
    return jcOrganizationId;
  }

  public void setJcOrganizationId(String jcOrganizationId) {
    this.jcOrganizationId = jcOrganizationId;
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
    return Objects.equals(this.uid, systemInsightsUsers.uid) &&
        Objects.equals(this.gid, systemInsightsUsers.gid) &&
        Objects.equals(this.uidSigned, systemInsightsUsers.uidSigned) &&
        Objects.equals(this.gidSigned, systemInsightsUsers.gidSigned) &&
        Objects.equals(this.username, systemInsightsUsers.username) &&
        Objects.equals(this.description, systemInsightsUsers.description) &&
        Objects.equals(this.directory, systemInsightsUsers.directory) &&
        Objects.equals(this.shell, systemInsightsUsers.shell) &&
        Objects.equals(this.uuid, systemInsightsUsers.uuid) &&
        Objects.equals(this.type, systemInsightsUsers.type) &&
        Objects.equals(this.jcCollectionTime, systemInsightsUsers.jcCollectionTime) &&
        Objects.equals(this.jcSystemId, systemInsightsUsers.jcSystemId) &&
        Objects.equals(this.jcOrganizationId, systemInsightsUsers.jcOrganizationId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uid, gid, uidSigned, gidSigned, username, description, directory, shell, uuid, type, jcCollectionTime, jcSystemId, jcOrganizationId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemInsightsUsers {\n");
    
    sb.append("    uid: ").append(toIndentedString(uid)).append("\n");
    sb.append("    gid: ").append(toIndentedString(gid)).append("\n");
    sb.append("    uidSigned: ").append(toIndentedString(uidSigned)).append("\n");
    sb.append("    gidSigned: ").append(toIndentedString(gidSigned)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    directory: ").append(toIndentedString(directory)).append("\n");
    sb.append("    shell: ").append(toIndentedString(shell)).append("\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    jcCollectionTime: ").append(toIndentedString(jcCollectionTime)).append("\n");
    sb.append("    jcSystemId: ").append(toIndentedString(jcSystemId)).append("\n");
    sb.append("    jcOrganizationId: ").append(toIndentedString(jcOrganizationId)).append("\n");
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

