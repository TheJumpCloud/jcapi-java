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
 * SystemInsightsInterfaceAddresses
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-08-08T01:06:48.987Z")
public class SystemInsightsInterfaceAddresses {
  @SerializedName("interface")
  private String _interface = null;

  @SerializedName("address")
  private String address = null;

  @SerializedName("mask")
  private String mask = null;

  @SerializedName("broadcast")
  private String broadcast = null;

  @SerializedName("point_to_point")
  private String pointToPoint = null;

  @SerializedName("type")
  private String type = null;

  @SerializedName("friendly_name")
  private String friendlyName = null;

  @SerializedName("jc_collection_time")
  private String jcCollectionTime = null;

  @SerializedName("jc_system_id")
  private String jcSystemId = null;

  @SerializedName("jc_organization_id")
  private String jcOrganizationId = null;

  public SystemInsightsInterfaceAddresses _interface(String _interface) {
    this._interface = _interface;
    return this;
  }

   /**
   * Get _interface
   * @return _interface
  **/
  @ApiModelProperty(value = "")
  public String getInterface() {
    return _interface;
  }

  public void setInterface(String _interface) {
    this._interface = _interface;
  }

  public SystemInsightsInterfaceAddresses address(String address) {
    this.address = address;
    return this;
  }

   /**
   * Get address
   * @return address
  **/
  @ApiModelProperty(value = "")
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public SystemInsightsInterfaceAddresses mask(String mask) {
    this.mask = mask;
    return this;
  }

   /**
   * Get mask
   * @return mask
  **/
  @ApiModelProperty(value = "")
  public String getMask() {
    return mask;
  }

  public void setMask(String mask) {
    this.mask = mask;
  }

  public SystemInsightsInterfaceAddresses broadcast(String broadcast) {
    this.broadcast = broadcast;
    return this;
  }

   /**
   * Get broadcast
   * @return broadcast
  **/
  @ApiModelProperty(value = "")
  public String getBroadcast() {
    return broadcast;
  }

  public void setBroadcast(String broadcast) {
    this.broadcast = broadcast;
  }

  public SystemInsightsInterfaceAddresses pointToPoint(String pointToPoint) {
    this.pointToPoint = pointToPoint;
    return this;
  }

   /**
   * Get pointToPoint
   * @return pointToPoint
  **/
  @ApiModelProperty(value = "")
  public String getPointToPoint() {
    return pointToPoint;
  }

  public void setPointToPoint(String pointToPoint) {
    this.pointToPoint = pointToPoint;
  }

  public SystemInsightsInterfaceAddresses type(String type) {
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

  public SystemInsightsInterfaceAddresses friendlyName(String friendlyName) {
    this.friendlyName = friendlyName;
    return this;
  }

   /**
   * Get friendlyName
   * @return friendlyName
  **/
  @ApiModelProperty(value = "")
  public String getFriendlyName() {
    return friendlyName;
  }

  public void setFriendlyName(String friendlyName) {
    this.friendlyName = friendlyName;
  }

  public SystemInsightsInterfaceAddresses jcCollectionTime(String jcCollectionTime) {
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

  public SystemInsightsInterfaceAddresses jcSystemId(String jcSystemId) {
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

  public SystemInsightsInterfaceAddresses jcOrganizationId(String jcOrganizationId) {
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
    SystemInsightsInterfaceAddresses systemInsightsInterfaceAddresses = (SystemInsightsInterfaceAddresses) o;
    return Objects.equals(this._interface, systemInsightsInterfaceAddresses._interface) &&
        Objects.equals(this.address, systemInsightsInterfaceAddresses.address) &&
        Objects.equals(this.mask, systemInsightsInterfaceAddresses.mask) &&
        Objects.equals(this.broadcast, systemInsightsInterfaceAddresses.broadcast) &&
        Objects.equals(this.pointToPoint, systemInsightsInterfaceAddresses.pointToPoint) &&
        Objects.equals(this.type, systemInsightsInterfaceAddresses.type) &&
        Objects.equals(this.friendlyName, systemInsightsInterfaceAddresses.friendlyName) &&
        Objects.equals(this.jcCollectionTime, systemInsightsInterfaceAddresses.jcCollectionTime) &&
        Objects.equals(this.jcSystemId, systemInsightsInterfaceAddresses.jcSystemId) &&
        Objects.equals(this.jcOrganizationId, systemInsightsInterfaceAddresses.jcOrganizationId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(_interface, address, mask, broadcast, pointToPoint, type, friendlyName, jcCollectionTime, jcSystemId, jcOrganizationId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemInsightsInterfaceAddresses {\n");
    
    sb.append("    _interface: ").append(toIndentedString(_interface)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    mask: ").append(toIndentedString(mask)).append("\n");
    sb.append("    broadcast: ").append(toIndentedString(broadcast)).append("\n");
    sb.append("    pointToPoint: ").append(toIndentedString(pointToPoint)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    friendlyName: ").append(toIndentedString(friendlyName)).append("\n");
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

