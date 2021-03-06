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
 * SystemInsightsGroups
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-11-21T20:17:34.763Z")
public class SystemInsightsGroups {
  @SerializedName("collection_time")
  private String collectionTime = null;

  @SerializedName("comment")
  private String comment = null;

  @SerializedName("gid")
  private String gid = null;

  @SerializedName("gid_signed")
  private String gidSigned = null;

  @SerializedName("group_sid")
  private String groupSid = null;

  @SerializedName("groupname")
  private String groupname = null;

  @SerializedName("system_id")
  private String systemId = null;

  public SystemInsightsGroups collectionTime(String collectionTime) {
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

  public SystemInsightsGroups comment(String comment) {
    this.comment = comment;
    return this;
  }

   /**
   * Get comment
   * @return comment
  **/
  @ApiModelProperty(value = "")
  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public SystemInsightsGroups gid(String gid) {
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

  public SystemInsightsGroups gidSigned(String gidSigned) {
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

  public SystemInsightsGroups groupSid(String groupSid) {
    this.groupSid = groupSid;
    return this;
  }

   /**
   * Get groupSid
   * @return groupSid
  **/
  @ApiModelProperty(value = "")
  public String getGroupSid() {
    return groupSid;
  }

  public void setGroupSid(String groupSid) {
    this.groupSid = groupSid;
  }

  public SystemInsightsGroups groupname(String groupname) {
    this.groupname = groupname;
    return this;
  }

   /**
   * Get groupname
   * @return groupname
  **/
  @ApiModelProperty(value = "")
  public String getGroupname() {
    return groupname;
  }

  public void setGroupname(String groupname) {
    this.groupname = groupname;
  }

  public SystemInsightsGroups systemId(String systemId) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SystemInsightsGroups systemInsightsGroups = (SystemInsightsGroups) o;
    return Objects.equals(this.collectionTime, systemInsightsGroups.collectionTime) &&
        Objects.equals(this.comment, systemInsightsGroups.comment) &&
        Objects.equals(this.gid, systemInsightsGroups.gid) &&
        Objects.equals(this.gidSigned, systemInsightsGroups.gidSigned) &&
        Objects.equals(this.groupSid, systemInsightsGroups.groupSid) &&
        Objects.equals(this.groupname, systemInsightsGroups.groupname) &&
        Objects.equals(this.systemId, systemInsightsGroups.systemId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(collectionTime, comment, gid, gidSigned, groupSid, groupname, systemId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemInsightsGroups {\n");
    
    sb.append("    collectionTime: ").append(toIndentedString(collectionTime)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    gid: ").append(toIndentedString(gid)).append("\n");
    sb.append("    gidSigned: ").append(toIndentedString(gidSigned)).append("\n");
    sb.append("    groupSid: ").append(toIndentedString(groupSid)).append("\n");
    sb.append("    groupname: ").append(toIndentedString(groupname)).append("\n");
    sb.append("    systemId: ").append(toIndentedString(systemId)).append("\n");
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

