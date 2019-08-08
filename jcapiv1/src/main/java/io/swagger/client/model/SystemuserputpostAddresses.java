/*
 * JumpCloud APIs
 *  JumpCloud's V1 API. This set of endpoints allows JumpCloud customers to manage commands, systems, & system users.
 *
 * OpenAPI spec version: 1.0
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
 * SystemuserputpostAddresses
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-08-08T01:09:36.870Z")
public class SystemuserputpostAddresses {
  @SerializedName("type")
  private String type = null;

  @SerializedName("poBox")
  private String poBox = null;

  @SerializedName("extendedAddress")
  private String extendedAddress = null;

  @SerializedName("streetAddress")
  private String streetAddress = null;

  @SerializedName("locality")
  private String locality = null;

  @SerializedName("region")
  private String region = null;

  @SerializedName("postalCode")
  private String postalCode = null;

  @SerializedName("country")
  private String country = null;

  public SystemuserputpostAddresses type(String type) {
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

  public SystemuserputpostAddresses poBox(String poBox) {
    this.poBox = poBox;
    return this;
  }

   /**
   * Get poBox
   * @return poBox
  **/
  @ApiModelProperty(value = "")
  public String getPoBox() {
    return poBox;
  }

  public void setPoBox(String poBox) {
    this.poBox = poBox;
  }

  public SystemuserputpostAddresses extendedAddress(String extendedAddress) {
    this.extendedAddress = extendedAddress;
    return this;
  }

   /**
   * Get extendedAddress
   * @return extendedAddress
  **/
  @ApiModelProperty(value = "")
  public String getExtendedAddress() {
    return extendedAddress;
  }

  public void setExtendedAddress(String extendedAddress) {
    this.extendedAddress = extendedAddress;
  }

  public SystemuserputpostAddresses streetAddress(String streetAddress) {
    this.streetAddress = streetAddress;
    return this;
  }

   /**
   * Get streetAddress
   * @return streetAddress
  **/
  @ApiModelProperty(value = "")
  public String getStreetAddress() {
    return streetAddress;
  }

  public void setStreetAddress(String streetAddress) {
    this.streetAddress = streetAddress;
  }

  public SystemuserputpostAddresses locality(String locality) {
    this.locality = locality;
    return this;
  }

   /**
   * Get locality
   * @return locality
  **/
  @ApiModelProperty(value = "")
  public String getLocality() {
    return locality;
  }

  public void setLocality(String locality) {
    this.locality = locality;
  }

  public SystemuserputpostAddresses region(String region) {
    this.region = region;
    return this;
  }

   /**
   * Get region
   * @return region
  **/
  @ApiModelProperty(value = "")
  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public SystemuserputpostAddresses postalCode(String postalCode) {
    this.postalCode = postalCode;
    return this;
  }

   /**
   * Get postalCode
   * @return postalCode
  **/
  @ApiModelProperty(value = "")
  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public SystemuserputpostAddresses country(String country) {
    this.country = country;
    return this;
  }

   /**
   * Get country
   * @return country
  **/
  @ApiModelProperty(value = "")
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SystemuserputpostAddresses systemuserputpostAddresses = (SystemuserputpostAddresses) o;
    return Objects.equals(this.type, systemuserputpostAddresses.type) &&
        Objects.equals(this.poBox, systemuserputpostAddresses.poBox) &&
        Objects.equals(this.extendedAddress, systemuserputpostAddresses.extendedAddress) &&
        Objects.equals(this.streetAddress, systemuserputpostAddresses.streetAddress) &&
        Objects.equals(this.locality, systemuserputpostAddresses.locality) &&
        Objects.equals(this.region, systemuserputpostAddresses.region) &&
        Objects.equals(this.postalCode, systemuserputpostAddresses.postalCode) &&
        Objects.equals(this.country, systemuserputpostAddresses.country);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, poBox, extendedAddress, streetAddress, locality, region, postalCode, country);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemuserputpostAddresses {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    poBox: ").append(toIndentedString(poBox)).append("\n");
    sb.append("    extendedAddress: ").append(toIndentedString(extendedAddress)).append("\n");
    sb.append("    streetAddress: ").append(toIndentedString(streetAddress)).append("\n");
    sb.append("    locality: ").append(toIndentedString(locality)).append("\n");
    sb.append("    region: ").append(toIndentedString(region)).append("\n");
    sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
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

