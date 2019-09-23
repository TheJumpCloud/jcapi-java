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
 * SystemInsightsKernelInfo
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-09-23T20:31:04.187Z")
public class SystemInsightsKernelInfo {
  @SerializedName("arguments")
  private String arguments = null;

  @SerializedName("collection_time")
  private String collectionTime = null;

  @SerializedName("device")
  private String device = null;

  @SerializedName("path")
  private String path = null;

  @SerializedName("system_id")
  private String systemId = null;

  @SerializedName("version")
  private String version = null;

  public SystemInsightsKernelInfo arguments(String arguments) {
    this.arguments = arguments;
    return this;
  }

   /**
   * Get arguments
   * @return arguments
  **/
  @ApiModelProperty(value = "")
  public String getArguments() {
    return arguments;
  }

  public void setArguments(String arguments) {
    this.arguments = arguments;
  }

  public SystemInsightsKernelInfo collectionTime(String collectionTime) {
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

  public SystemInsightsKernelInfo device(String device) {
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

  public SystemInsightsKernelInfo path(String path) {
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

  public SystemInsightsKernelInfo systemId(String systemId) {
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

  public SystemInsightsKernelInfo version(String version) {
    this.version = version;
    return this;
  }

   /**
   * Get version
   * @return version
  **/
  @ApiModelProperty(value = "")
  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SystemInsightsKernelInfo systemInsightsKernelInfo = (SystemInsightsKernelInfo) o;
    return Objects.equals(this.arguments, systemInsightsKernelInfo.arguments) &&
        Objects.equals(this.collectionTime, systemInsightsKernelInfo.collectionTime) &&
        Objects.equals(this.device, systemInsightsKernelInfo.device) &&
        Objects.equals(this.path, systemInsightsKernelInfo.path) &&
        Objects.equals(this.systemId, systemInsightsKernelInfo.systemId) &&
        Objects.equals(this.version, systemInsightsKernelInfo.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(arguments, collectionTime, device, path, systemId, version);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemInsightsKernelInfo {\n");
    
    sb.append("    arguments: ").append(toIndentedString(arguments)).append("\n");
    sb.append("    collectionTime: ").append(toIndentedString(collectionTime)).append("\n");
    sb.append("    device: ").append(toIndentedString(device)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    systemId: ").append(toIndentedString(systemId)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
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

