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
 * SystemInsightsEtcHosts
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-11-21T20:17:34.763Z")
public class SystemInsightsEtcHosts {
  @SerializedName("address")
  private String address = null;

  @SerializedName("collection_time")
  private String collectionTime = null;

  @SerializedName("hostnames")
  private String hostnames = null;

  @SerializedName("system_id")
  private String systemId = null;

  public SystemInsightsEtcHosts address(String address) {
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

  public SystemInsightsEtcHosts collectionTime(String collectionTime) {
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

  public SystemInsightsEtcHosts hostnames(String hostnames) {
    this.hostnames = hostnames;
    return this;
  }

   /**
   * Get hostnames
   * @return hostnames
  **/
  @ApiModelProperty(value = "")
  public String getHostnames() {
    return hostnames;
  }

  public void setHostnames(String hostnames) {
    this.hostnames = hostnames;
  }

  public SystemInsightsEtcHosts systemId(String systemId) {
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
    SystemInsightsEtcHosts systemInsightsEtcHosts = (SystemInsightsEtcHosts) o;
    return Objects.equals(this.address, systemInsightsEtcHosts.address) &&
        Objects.equals(this.collectionTime, systemInsightsEtcHosts.collectionTime) &&
        Objects.equals(this.hostnames, systemInsightsEtcHosts.hostnames) &&
        Objects.equals(this.systemId, systemInsightsEtcHosts.systemId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, collectionTime, hostnames, systemId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemInsightsEtcHosts {\n");
    
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    collectionTime: ").append(toIndentedString(collectionTime)).append("\n");
    sb.append("    hostnames: ").append(toIndentedString(hostnames)).append("\n");
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

