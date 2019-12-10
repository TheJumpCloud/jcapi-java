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
 * SystemInsightsUsbDevices
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-12-09T23:54:01.559Z")
public class SystemInsightsUsbDevices {
  @SerializedName("class")
  private String propertyClass = null;

  @SerializedName("collection_time")
  private String collectionTime = null;

  @SerializedName("model")
  private String model = null;

  @SerializedName("model_id")
  private String modelId = null;

  @SerializedName("protocol")
  private String protocol = null;

  @SerializedName("removable")
  private Integer removable = null;

  @SerializedName("serial")
  private String serial = null;

  @SerializedName("subclass")
  private String subclass = null;

  @SerializedName("system_id")
  private String systemId = null;

  @SerializedName("usb_address")
  private Integer usbAddress = null;

  @SerializedName("usb_port")
  private Integer usbPort = null;

  @SerializedName("vendor")
  private String vendor = null;

  @SerializedName("vendor_id")
  private String vendorId = null;

  @SerializedName("version")
  private String version = null;

  public SystemInsightsUsbDevices propertyClass(String propertyClass) {
    this.propertyClass = propertyClass;
    return this;
  }

   /**
   * Get propertyClass
   * @return propertyClass
  **/
  @ApiModelProperty(value = "")
  public String getPropertyClass() {
    return propertyClass;
  }

  public void setPropertyClass(String propertyClass) {
    this.propertyClass = propertyClass;
  }

  public SystemInsightsUsbDevices collectionTime(String collectionTime) {
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

  public SystemInsightsUsbDevices model(String model) {
    this.model = model;
    return this;
  }

   /**
   * Get model
   * @return model
  **/
  @ApiModelProperty(value = "")
  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public SystemInsightsUsbDevices modelId(String modelId) {
    this.modelId = modelId;
    return this;
  }

   /**
   * Get modelId
   * @return modelId
  **/
  @ApiModelProperty(value = "")
  public String getModelId() {
    return modelId;
  }

  public void setModelId(String modelId) {
    this.modelId = modelId;
  }

  public SystemInsightsUsbDevices protocol(String protocol) {
    this.protocol = protocol;
    return this;
  }

   /**
   * Get protocol
   * @return protocol
  **/
  @ApiModelProperty(value = "")
  public String getProtocol() {
    return protocol;
  }

  public void setProtocol(String protocol) {
    this.protocol = protocol;
  }

  public SystemInsightsUsbDevices removable(Integer removable) {
    this.removable = removable;
    return this;
  }

   /**
   * Get removable
   * @return removable
  **/
  @ApiModelProperty(value = "")
  public Integer getRemovable() {
    return removable;
  }

  public void setRemovable(Integer removable) {
    this.removable = removable;
  }

  public SystemInsightsUsbDevices serial(String serial) {
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

  public SystemInsightsUsbDevices subclass(String subclass) {
    this.subclass = subclass;
    return this;
  }

   /**
   * Get subclass
   * @return subclass
  **/
  @ApiModelProperty(value = "")
  public String getSubclass() {
    return subclass;
  }

  public void setSubclass(String subclass) {
    this.subclass = subclass;
  }

  public SystemInsightsUsbDevices systemId(String systemId) {
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

  public SystemInsightsUsbDevices usbAddress(Integer usbAddress) {
    this.usbAddress = usbAddress;
    return this;
  }

   /**
   * Get usbAddress
   * @return usbAddress
  **/
  @ApiModelProperty(value = "")
  public Integer getUsbAddress() {
    return usbAddress;
  }

  public void setUsbAddress(Integer usbAddress) {
    this.usbAddress = usbAddress;
  }

  public SystemInsightsUsbDevices usbPort(Integer usbPort) {
    this.usbPort = usbPort;
    return this;
  }

   /**
   * Get usbPort
   * @return usbPort
  **/
  @ApiModelProperty(value = "")
  public Integer getUsbPort() {
    return usbPort;
  }

  public void setUsbPort(Integer usbPort) {
    this.usbPort = usbPort;
  }

  public SystemInsightsUsbDevices vendor(String vendor) {
    this.vendor = vendor;
    return this;
  }

   /**
   * Get vendor
   * @return vendor
  **/
  @ApiModelProperty(value = "")
  public String getVendor() {
    return vendor;
  }

  public void setVendor(String vendor) {
    this.vendor = vendor;
  }

  public SystemInsightsUsbDevices vendorId(String vendorId) {
    this.vendorId = vendorId;
    return this;
  }

   /**
   * Get vendorId
   * @return vendorId
  **/
  @ApiModelProperty(value = "")
  public String getVendorId() {
    return vendorId;
  }

  public void setVendorId(String vendorId) {
    this.vendorId = vendorId;
  }

  public SystemInsightsUsbDevices version(String version) {
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
    SystemInsightsUsbDevices systemInsightsUsbDevices = (SystemInsightsUsbDevices) o;
    return Objects.equals(this.propertyClass, systemInsightsUsbDevices.propertyClass) &&
        Objects.equals(this.collectionTime, systemInsightsUsbDevices.collectionTime) &&
        Objects.equals(this.model, systemInsightsUsbDevices.model) &&
        Objects.equals(this.modelId, systemInsightsUsbDevices.modelId) &&
        Objects.equals(this.protocol, systemInsightsUsbDevices.protocol) &&
        Objects.equals(this.removable, systemInsightsUsbDevices.removable) &&
        Objects.equals(this.serial, systemInsightsUsbDevices.serial) &&
        Objects.equals(this.subclass, systemInsightsUsbDevices.subclass) &&
        Objects.equals(this.systemId, systemInsightsUsbDevices.systemId) &&
        Objects.equals(this.usbAddress, systemInsightsUsbDevices.usbAddress) &&
        Objects.equals(this.usbPort, systemInsightsUsbDevices.usbPort) &&
        Objects.equals(this.vendor, systemInsightsUsbDevices.vendor) &&
        Objects.equals(this.vendorId, systemInsightsUsbDevices.vendorId) &&
        Objects.equals(this.version, systemInsightsUsbDevices.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(propertyClass, collectionTime, model, modelId, protocol, removable, serial, subclass, systemId, usbAddress, usbPort, vendor, vendorId, version);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemInsightsUsbDevices {\n");
    
    sb.append("    propertyClass: ").append(toIndentedString(propertyClass)).append("\n");
    sb.append("    collectionTime: ").append(toIndentedString(collectionTime)).append("\n");
    sb.append("    model: ").append(toIndentedString(model)).append("\n");
    sb.append("    modelId: ").append(toIndentedString(modelId)).append("\n");
    sb.append("    protocol: ").append(toIndentedString(protocol)).append("\n");
    sb.append("    removable: ").append(toIndentedString(removable)).append("\n");
    sb.append("    serial: ").append(toIndentedString(serial)).append("\n");
    sb.append("    subclass: ").append(toIndentedString(subclass)).append("\n");
    sb.append("    systemId: ").append(toIndentedString(systemId)).append("\n");
    sb.append("    usbAddress: ").append(toIndentedString(usbAddress)).append("\n");
    sb.append("    usbPort: ").append(toIndentedString(usbPort)).append("\n");
    sb.append("    vendor: ").append(toIndentedString(vendor)).append("\n");
    sb.append("    vendorId: ").append(toIndentedString(vendorId)).append("\n");
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

