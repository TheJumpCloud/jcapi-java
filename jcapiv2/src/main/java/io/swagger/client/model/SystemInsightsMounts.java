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
 * SystemInsightsMounts
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-08-09T16:30:22.486Z")
public class SystemInsightsMounts {
  @SerializedName("device")
  private String device = null;

  @SerializedName("device_alias")
  private String deviceAlias = null;

  @SerializedName("path")
  private String path = null;

  @SerializedName("type")
  private String type = null;

  @SerializedName("blocks_size")
  private String blocksSize = null;

  @SerializedName("blocks")
  private String blocks = null;

  @SerializedName("blocks_free")
  private String blocksFree = null;

  @SerializedName("blocks_available")
  private String blocksAvailable = null;

  @SerializedName("inodes")
  private String inodes = null;

  @SerializedName("inodes_free")
  private String inodesFree = null;

  @SerializedName("flags")
  private String flags = null;

  @SerializedName("jc_collection_time")
  private String jcCollectionTime = null;

  @SerializedName("jc_system_id")
  private String jcSystemId = null;

  public SystemInsightsMounts device(String device) {
    this.device = device;
    return this;
  }

   /**
   * Get device
   * @return device
  **/
  @ApiModelProperty(value = "")
  public String getDevice() {
    return device;
  }

  public void setDevice(String device) {
    this.device = device;
  }

  public SystemInsightsMounts deviceAlias(String deviceAlias) {
    this.deviceAlias = deviceAlias;
    return this;
  }

   /**
   * Get deviceAlias
   * @return deviceAlias
  **/
  @ApiModelProperty(value = "")
  public String getDeviceAlias() {
    return deviceAlias;
  }

  public void setDeviceAlias(String deviceAlias) {
    this.deviceAlias = deviceAlias;
  }

  public SystemInsightsMounts path(String path) {
    this.path = path;
    return this;
  }

   /**
   * Get path
   * @return path
  **/
  @ApiModelProperty(value = "")
  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public SystemInsightsMounts type(String type) {
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

  public SystemInsightsMounts blocksSize(String blocksSize) {
    this.blocksSize = blocksSize;
    return this;
  }

   /**
   * Get blocksSize
   * @return blocksSize
  **/
  @ApiModelProperty(value = "")
  public String getBlocksSize() {
    return blocksSize;
  }

  public void setBlocksSize(String blocksSize) {
    this.blocksSize = blocksSize;
  }

  public SystemInsightsMounts blocks(String blocks) {
    this.blocks = blocks;
    return this;
  }

   /**
   * Get blocks
   * @return blocks
  **/
  @ApiModelProperty(value = "")
  public String getBlocks() {
    return blocks;
  }

  public void setBlocks(String blocks) {
    this.blocks = blocks;
  }

  public SystemInsightsMounts blocksFree(String blocksFree) {
    this.blocksFree = blocksFree;
    return this;
  }

   /**
   * Get blocksFree
   * @return blocksFree
  **/
  @ApiModelProperty(value = "")
  public String getBlocksFree() {
    return blocksFree;
  }

  public void setBlocksFree(String blocksFree) {
    this.blocksFree = blocksFree;
  }

  public SystemInsightsMounts blocksAvailable(String blocksAvailable) {
    this.blocksAvailable = blocksAvailable;
    return this;
  }

   /**
   * Get blocksAvailable
   * @return blocksAvailable
  **/
  @ApiModelProperty(value = "")
  public String getBlocksAvailable() {
    return blocksAvailable;
  }

  public void setBlocksAvailable(String blocksAvailable) {
    this.blocksAvailable = blocksAvailable;
  }

  public SystemInsightsMounts inodes(String inodes) {
    this.inodes = inodes;
    return this;
  }

   /**
   * Get inodes
   * @return inodes
  **/
  @ApiModelProperty(value = "")
  public String getInodes() {
    return inodes;
  }

  public void setInodes(String inodes) {
    this.inodes = inodes;
  }

  public SystemInsightsMounts inodesFree(String inodesFree) {
    this.inodesFree = inodesFree;
    return this;
  }

   /**
   * Get inodesFree
   * @return inodesFree
  **/
  @ApiModelProperty(value = "")
  public String getInodesFree() {
    return inodesFree;
  }

  public void setInodesFree(String inodesFree) {
    this.inodesFree = inodesFree;
  }

  public SystemInsightsMounts flags(String flags) {
    this.flags = flags;
    return this;
  }

   /**
   * Get flags
   * @return flags
  **/
  @ApiModelProperty(value = "")
  public String getFlags() {
    return flags;
  }

  public void setFlags(String flags) {
    this.flags = flags;
  }

  public SystemInsightsMounts jcCollectionTime(String jcCollectionTime) {
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

  public SystemInsightsMounts jcSystemId(String jcSystemId) {
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
    SystemInsightsMounts systemInsightsMounts = (SystemInsightsMounts) o;
    return Objects.equals(this.device, systemInsightsMounts.device) &&
        Objects.equals(this.deviceAlias, systemInsightsMounts.deviceAlias) &&
        Objects.equals(this.path, systemInsightsMounts.path) &&
        Objects.equals(this.type, systemInsightsMounts.type) &&
        Objects.equals(this.blocksSize, systemInsightsMounts.blocksSize) &&
        Objects.equals(this.blocks, systemInsightsMounts.blocks) &&
        Objects.equals(this.blocksFree, systemInsightsMounts.blocksFree) &&
        Objects.equals(this.blocksAvailable, systemInsightsMounts.blocksAvailable) &&
        Objects.equals(this.inodes, systemInsightsMounts.inodes) &&
        Objects.equals(this.inodesFree, systemInsightsMounts.inodesFree) &&
        Objects.equals(this.flags, systemInsightsMounts.flags) &&
        Objects.equals(this.jcCollectionTime, systemInsightsMounts.jcCollectionTime) &&
        Objects.equals(this.jcSystemId, systemInsightsMounts.jcSystemId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(device, deviceAlias, path, type, blocksSize, blocks, blocksFree, blocksAvailable, inodes, inodesFree, flags, jcCollectionTime, jcSystemId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemInsightsMounts {\n");
    
    sb.append("    device: ").append(toIndentedString(device)).append("\n");
    sb.append("    deviceAlias: ").append(toIndentedString(deviceAlias)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    blocksSize: ").append(toIndentedString(blocksSize)).append("\n");
    sb.append("    blocks: ").append(toIndentedString(blocks)).append("\n");
    sb.append("    blocksFree: ").append(toIndentedString(blocksFree)).append("\n");
    sb.append("    blocksAvailable: ").append(toIndentedString(blocksAvailable)).append("\n");
    sb.append("    inodes: ").append(toIndentedString(inodes)).append("\n");
    sb.append("    inodesFree: ").append(toIndentedString(inodesFree)).append("\n");
    sb.append("    flags: ").append(toIndentedString(flags)).append("\n");
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

