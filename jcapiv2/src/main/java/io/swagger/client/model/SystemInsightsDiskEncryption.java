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
 * SystemInsightsDiskEncryption
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-08-09T16:30:22.486Z")
public class SystemInsightsDiskEncryption {
  @SerializedName("name")
  private String name = null;

  @SerializedName("uuid")
  private String uuid = null;

  @SerializedName("encrypted")
  private Integer encrypted = null;

  @SerializedName("type")
  private String type = null;

  @SerializedName("uid")
  private String uid = null;

  @SerializedName("user_uuid")
  private String userUuid = null;

  @SerializedName("encryption_status")
  private String encryptionStatus = null;

  @SerializedName("jc_collection_time")
  private String jcCollectionTime = null;

  @SerializedName("jc_system_id")
  private String jcSystemId = null;

  public SystemInsightsDiskEncryption name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public SystemInsightsDiskEncryption uuid(String uuid) {
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

  public SystemInsightsDiskEncryption encrypted(Integer encrypted) {
    this.encrypted = encrypted;
    return this;
  }

   /**
   * Get encrypted
   * @return encrypted
  **/
  @ApiModelProperty(value = "")
  public Integer getEncrypted() {
    return encrypted;
  }

  public void setEncrypted(Integer encrypted) {
    this.encrypted = encrypted;
  }

  public SystemInsightsDiskEncryption type(String type) {
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

  public SystemInsightsDiskEncryption uid(String uid) {
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

  public SystemInsightsDiskEncryption userUuid(String userUuid) {
    this.userUuid = userUuid;
    return this;
  }

   /**
   * Get userUuid
   * @return userUuid
  **/
  @ApiModelProperty(value = "")
  public String getUserUuid() {
    return userUuid;
  }

  public void setUserUuid(String userUuid) {
    this.userUuid = userUuid;
  }

  public SystemInsightsDiskEncryption encryptionStatus(String encryptionStatus) {
    this.encryptionStatus = encryptionStatus;
    return this;
  }

   /**
   * Get encryptionStatus
   * @return encryptionStatus
  **/
  @ApiModelProperty(value = "")
  public String getEncryptionStatus() {
    return encryptionStatus;
  }

  public void setEncryptionStatus(String encryptionStatus) {
    this.encryptionStatus = encryptionStatus;
  }

  public SystemInsightsDiskEncryption jcCollectionTime(String jcCollectionTime) {
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

  public SystemInsightsDiskEncryption jcSystemId(String jcSystemId) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SystemInsightsDiskEncryption systemInsightsDiskEncryption = (SystemInsightsDiskEncryption) o;
    return Objects.equals(this.name, systemInsightsDiskEncryption.name) &&
        Objects.equals(this.uuid, systemInsightsDiskEncryption.uuid) &&
        Objects.equals(this.encrypted, systemInsightsDiskEncryption.encrypted) &&
        Objects.equals(this.type, systemInsightsDiskEncryption.type) &&
        Objects.equals(this.uid, systemInsightsDiskEncryption.uid) &&
        Objects.equals(this.userUuid, systemInsightsDiskEncryption.userUuid) &&
        Objects.equals(this.encryptionStatus, systemInsightsDiskEncryption.encryptionStatus) &&
        Objects.equals(this.jcCollectionTime, systemInsightsDiskEncryption.jcCollectionTime) &&
        Objects.equals(this.jcSystemId, systemInsightsDiskEncryption.jcSystemId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, uuid, encrypted, type, uid, userUuid, encryptionStatus, jcCollectionTime, jcSystemId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemInsightsDiskEncryption {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    encrypted: ").append(toIndentedString(encrypted)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    uid: ").append(toIndentedString(uid)).append("\n");
    sb.append("    userUuid: ").append(toIndentedString(userUuid)).append("\n");
    sb.append("    encryptionStatus: ").append(toIndentedString(encryptionStatus)).append("\n");
    sb.append("    jcCollectionTime: ").append(toIndentedString(jcCollectionTime)).append("\n");
    sb.append("    jcSystemId: ").append(toIndentedString(jcSystemId)).append("\n");
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

