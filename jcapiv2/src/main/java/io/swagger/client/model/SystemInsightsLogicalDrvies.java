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
 * SystemInsightsLogicalDrvies
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-09-25T16:18:04.122Z")
public class SystemInsightsLogicalDrvies {
  @SerializedName("boot_partition")
  private Integer bootPartition = null;

  @SerializedName("collection_time")
  private String collectionTime = null;

  @SerializedName("device_id")
  private String deviceId = null;

  @SerializedName("file_system")
  private String fileSystem = null;

  @SerializedName("free_space")
  private String freeSpace = null;

  @SerializedName("size")
  private String size = null;

  @SerializedName("system_id")
  private String systemId = null;

  @SerializedName("type")
  private String type = null;

  public SystemInsightsLogicalDrvies bootPartition(Integer bootPartition) {
    this.bootPartition = bootPartition;
    return this;
  }

   /**
   * Get bootPartition
   * @return bootPartition
  **/
  @ApiModelProperty(value = "")
  public Integer getBootPartition() {
    return bootPartition;
  }

  public void setBootPartition(Integer bootPartition) {
    this.bootPartition = bootPartition;
  }

  public SystemInsightsLogicalDrvies collectionTime(String collectionTime) {
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

  public SystemInsightsLogicalDrvies deviceId(String deviceId) {
    this.deviceId = deviceId;
    return this;
  }

   /**
   * Get deviceId
   * @return deviceId
  **/
  @ApiModelProperty(value = "")
  public String getDeviceId() {
    return deviceId;
  }

  public void setDeviceId(String deviceId) {
    this.deviceId = deviceId;
  }

  public SystemInsightsLogicalDrvies fileSystem(String fileSystem) {
    this.fileSystem = fileSystem;
    return this;
  }

   /**
   * Get fileSystem
   * @return fileSystem
  **/
  @ApiModelProperty(value = "")
  public String getFileSystem() {
    return fileSystem;
  }

  public void setFileSystem(String fileSystem) {
    this.fileSystem = fileSystem;
  }

  public SystemInsightsLogicalDrvies freeSpace(String freeSpace) {
    this.freeSpace = freeSpace;
    return this;
  }

   /**
   * Get freeSpace
   * @return freeSpace
  **/
  @ApiModelProperty(value = "")
  public String getFreeSpace() {
    return freeSpace;
  }

  public void setFreeSpace(String freeSpace) {
    this.freeSpace = freeSpace;
  }

  public SystemInsightsLogicalDrvies size(String size) {
    this.size = size;
    return this;
  }

   /**
   * Get size
   * @return size
  **/
  @ApiModelProperty(value = "")
  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public SystemInsightsLogicalDrvies systemId(String systemId) {
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

  public SystemInsightsLogicalDrvies type(String type) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SystemInsightsLogicalDrvies systemInsightsLogicalDrvies = (SystemInsightsLogicalDrvies) o;
    return Objects.equals(this.bootPartition, systemInsightsLogicalDrvies.bootPartition) &&
        Objects.equals(this.collectionTime, systemInsightsLogicalDrvies.collectionTime) &&
        Objects.equals(this.deviceId, systemInsightsLogicalDrvies.deviceId) &&
        Objects.equals(this.fileSystem, systemInsightsLogicalDrvies.fileSystem) &&
        Objects.equals(this.freeSpace, systemInsightsLogicalDrvies.freeSpace) &&
        Objects.equals(this.size, systemInsightsLogicalDrvies.size) &&
        Objects.equals(this.systemId, systemInsightsLogicalDrvies.systemId) &&
        Objects.equals(this.type, systemInsightsLogicalDrvies.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bootPartition, collectionTime, deviceId, fileSystem, freeSpace, size, systemId, type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemInsightsLogicalDrvies {\n");
    
    sb.append("    bootPartition: ").append(toIndentedString(bootPartition)).append("\n");
    sb.append("    collectionTime: ").append(toIndentedString(collectionTime)).append("\n");
    sb.append("    deviceId: ").append(toIndentedString(deviceId)).append("\n");
    sb.append("    fileSystem: ").append(toIndentedString(fileSystem)).append("\n");
    sb.append("    freeSpace: ").append(toIndentedString(freeSpace)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    systemId: ").append(toIndentedString(systemId)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
