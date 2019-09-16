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
 * SystemInsightsBitlockerInfo
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-09-16T17:47:24.539Z")
public class SystemInsightsBitlockerInfo {
  @SerializedName("collection_time")
  private String collectionTime = null;

  @SerializedName("conversion_status")
  private Integer conversionStatus = null;

  @SerializedName("devide_id")
  private String devideId = null;

  @SerializedName("drive_letter")
  private String driveLetter = null;

  @SerializedName("encryption_method")
  private String encryptionMethod = null;

  @SerializedName("persistent_volume_id")
  private String persistentVolumeId = null;

  @SerializedName("protection_status")
  private Integer protectionStatus = null;

  @SerializedName("system_id")
  private String systemId = null;

  public SystemInsightsBitlockerInfo collectionTime(String collectionTime) {
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

  public SystemInsightsBitlockerInfo conversionStatus(Integer conversionStatus) {
    this.conversionStatus = conversionStatus;
    return this;
  }

   /**
   * Get conversionStatus
   * @return conversionStatus
  **/
  @ApiModelProperty(value = "")
  public Integer getConversionStatus() {
    return conversionStatus;
  }

  public void setConversionStatus(Integer conversionStatus) {
    this.conversionStatus = conversionStatus;
  }

  public SystemInsightsBitlockerInfo devideId(String devideId) {
    this.devideId = devideId;
    return this;
  }

   /**
   * Get devideId
   * @return devideId
  **/
  @ApiModelProperty(value = "")
  public String getDevideId() {
    return devideId;
  }

  public void setDevideId(String devideId) {
    this.devideId = devideId;
  }

  public SystemInsightsBitlockerInfo driveLetter(String driveLetter) {
    this.driveLetter = driveLetter;
    return this;
  }

   /**
   * Get driveLetter
   * @return driveLetter
  **/
  @ApiModelProperty(value = "")
  public String getDriveLetter() {
    return driveLetter;
  }

  public void setDriveLetter(String driveLetter) {
    this.driveLetter = driveLetter;
  }

  public SystemInsightsBitlockerInfo encryptionMethod(String encryptionMethod) {
    this.encryptionMethod = encryptionMethod;
    return this;
  }

   /**
   * Get encryptionMethod
   * @return encryptionMethod
  **/
  @ApiModelProperty(value = "")
  public String getEncryptionMethod() {
    return encryptionMethod;
  }

  public void setEncryptionMethod(String encryptionMethod) {
    this.encryptionMethod = encryptionMethod;
  }

  public SystemInsightsBitlockerInfo persistentVolumeId(String persistentVolumeId) {
    this.persistentVolumeId = persistentVolumeId;
    return this;
  }

   /**
   * Get persistentVolumeId
   * @return persistentVolumeId
  **/
  @ApiModelProperty(value = "")
  public String getPersistentVolumeId() {
    return persistentVolumeId;
  }

  public void setPersistentVolumeId(String persistentVolumeId) {
    this.persistentVolumeId = persistentVolumeId;
  }

  public SystemInsightsBitlockerInfo protectionStatus(Integer protectionStatus) {
    this.protectionStatus = protectionStatus;
    return this;
  }

   /**
   * Get protectionStatus
   * @return protectionStatus
  **/
  @ApiModelProperty(value = "")
  public Integer getProtectionStatus() {
    return protectionStatus;
  }

  public void setProtectionStatus(Integer protectionStatus) {
    this.protectionStatus = protectionStatus;
  }

  public SystemInsightsBitlockerInfo systemId(String systemId) {
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
    SystemInsightsBitlockerInfo systemInsightsBitlockerInfo = (SystemInsightsBitlockerInfo) o;
    return Objects.equals(this.collectionTime, systemInsightsBitlockerInfo.collectionTime) &&
        Objects.equals(this.conversionStatus, systemInsightsBitlockerInfo.conversionStatus) &&
        Objects.equals(this.devideId, systemInsightsBitlockerInfo.devideId) &&
        Objects.equals(this.driveLetter, systemInsightsBitlockerInfo.driveLetter) &&
        Objects.equals(this.encryptionMethod, systemInsightsBitlockerInfo.encryptionMethod) &&
        Objects.equals(this.persistentVolumeId, systemInsightsBitlockerInfo.persistentVolumeId) &&
        Objects.equals(this.protectionStatus, systemInsightsBitlockerInfo.protectionStatus) &&
        Objects.equals(this.systemId, systemInsightsBitlockerInfo.systemId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(collectionTime, conversionStatus, devideId, driveLetter, encryptionMethod, persistentVolumeId, protectionStatus, systemId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemInsightsBitlockerInfo {\n");
    
    sb.append("    collectionTime: ").append(toIndentedString(collectionTime)).append("\n");
    sb.append("    conversionStatus: ").append(toIndentedString(conversionStatus)).append("\n");
    sb.append("    devideId: ").append(toIndentedString(devideId)).append("\n");
    sb.append("    driveLetter: ").append(toIndentedString(driveLetter)).append("\n");
    sb.append("    encryptionMethod: ").append(toIndentedString(encryptionMethod)).append("\n");
    sb.append("    persistentVolumeId: ").append(toIndentedString(persistentVolumeId)).append("\n");
    sb.append("    protectionStatus: ").append(toIndentedString(protectionStatus)).append("\n");
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

