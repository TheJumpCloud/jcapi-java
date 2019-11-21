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
 * SystemInsightsDiskInfo
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-11-21T20:17:34.763Z")
public class SystemInsightsDiskInfo {
  @SerializedName("collection_time")
  private String collectionTime = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("disk_index")
  private Integer diskIndex = null;

  @SerializedName("disk_size")
  private String diskSize = null;

  @SerializedName("hardware_model")
  private String hardwareModel = null;

  @SerializedName("id")
  private String id = null;

  @SerializedName("manufacturer")
  private String manufacturer = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("partitions")
  private Integer partitions = null;

  @SerializedName("pnp_device_id")
  private String pnpDeviceId = null;

  @SerializedName("serial")
  private String serial = null;

  @SerializedName("system_id")
  private String systemId = null;

  @SerializedName("type")
  private String type = null;

  public SystemInsightsDiskInfo collectionTime(String collectionTime) {
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

  public SystemInsightsDiskInfo description(String description) {
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

  public SystemInsightsDiskInfo diskIndex(Integer diskIndex) {
    this.diskIndex = diskIndex;
    return this;
  }

   /**
   * Get diskIndex
   * @return diskIndex
  **/
  @ApiModelProperty(value = "")
  public Integer getDiskIndex() {
    return diskIndex;
  }

  public void setDiskIndex(Integer diskIndex) {
    this.diskIndex = diskIndex;
  }

  public SystemInsightsDiskInfo diskSize(String diskSize) {
    this.diskSize = diskSize;
    return this;
  }

   /**
   * Get diskSize
   * @return diskSize
  **/
  @ApiModelProperty(value = "")
  public String getDiskSize() {
    return diskSize;
  }

  public void setDiskSize(String diskSize) {
    this.diskSize = diskSize;
  }

  public SystemInsightsDiskInfo hardwareModel(String hardwareModel) {
    this.hardwareModel = hardwareModel;
    return this;
  }

   /**
   * Get hardwareModel
   * @return hardwareModel
  **/
  @ApiModelProperty(value = "")
  public String getHardwareModel() {
    return hardwareModel;
  }

  public void setHardwareModel(String hardwareModel) {
    this.hardwareModel = hardwareModel;
  }

  public SystemInsightsDiskInfo id(String id) {
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

  public SystemInsightsDiskInfo manufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
    return this;
  }

   /**
   * Get manufacturer
   * @return manufacturer
  **/
  @ApiModelProperty(value = "")
  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public SystemInsightsDiskInfo name(String name) {
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

  public SystemInsightsDiskInfo partitions(Integer partitions) {
    this.partitions = partitions;
    return this;
  }

   /**
   * Get partitions
   * @return partitions
  **/
  @ApiModelProperty(value = "")
  public Integer getPartitions() {
    return partitions;
  }

  public void setPartitions(Integer partitions) {
    this.partitions = partitions;
  }

  public SystemInsightsDiskInfo pnpDeviceId(String pnpDeviceId) {
    this.pnpDeviceId = pnpDeviceId;
    return this;
  }

   /**
   * Get pnpDeviceId
   * @return pnpDeviceId
  **/
  @ApiModelProperty(value = "")
  public String getPnpDeviceId() {
    return pnpDeviceId;
  }

  public void setPnpDeviceId(String pnpDeviceId) {
    this.pnpDeviceId = pnpDeviceId;
  }

  public SystemInsightsDiskInfo serial(String serial) {
    this.serial = serial;
    return this;
  }

   /**
   * Get serial
   * @return serial
  **/
  @ApiModelProperty(value = "")
  public String getSerial() {
    return serial;
  }

  public void setSerial(String serial) {
    this.serial = serial;
  }

  public SystemInsightsDiskInfo systemId(String systemId) {
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

  public SystemInsightsDiskInfo type(String type) {
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
    SystemInsightsDiskInfo systemInsightsDiskInfo = (SystemInsightsDiskInfo) o;
    return Objects.equals(this.collectionTime, systemInsightsDiskInfo.collectionTime) &&
        Objects.equals(this.description, systemInsightsDiskInfo.description) &&
        Objects.equals(this.diskIndex, systemInsightsDiskInfo.diskIndex) &&
        Objects.equals(this.diskSize, systemInsightsDiskInfo.diskSize) &&
        Objects.equals(this.hardwareModel, systemInsightsDiskInfo.hardwareModel) &&
        Objects.equals(this.id, systemInsightsDiskInfo.id) &&
        Objects.equals(this.manufacturer, systemInsightsDiskInfo.manufacturer) &&
        Objects.equals(this.name, systemInsightsDiskInfo.name) &&
        Objects.equals(this.partitions, systemInsightsDiskInfo.partitions) &&
        Objects.equals(this.pnpDeviceId, systemInsightsDiskInfo.pnpDeviceId) &&
        Objects.equals(this.serial, systemInsightsDiskInfo.serial) &&
        Objects.equals(this.systemId, systemInsightsDiskInfo.systemId) &&
        Objects.equals(this.type, systemInsightsDiskInfo.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(collectionTime, description, diskIndex, diskSize, hardwareModel, id, manufacturer, name, partitions, pnpDeviceId, serial, systemId, type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemInsightsDiskInfo {\n");
    
    sb.append("    collectionTime: ").append(toIndentedString(collectionTime)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    diskIndex: ").append(toIndentedString(diskIndex)).append("\n");
    sb.append("    diskSize: ").append(toIndentedString(diskSize)).append("\n");
    sb.append("    hardwareModel: ").append(toIndentedString(hardwareModel)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    manufacturer: ").append(toIndentedString(manufacturer)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    partitions: ").append(toIndentedString(partitions)).append("\n");
    sb.append("    pnpDeviceId: ").append(toIndentedString(pnpDeviceId)).append("\n");
    sb.append("    serial: ").append(toIndentedString(serial)).append("\n");
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

