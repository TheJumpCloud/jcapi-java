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
 * OrgcryptosettingsSshKeys
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-08-08T01:13:28.293Z")
public class OrgcryptosettingsSshKeys {
  @SerializedName("validate")
  private Boolean validate = null;

  @SerializedName("validateKeySize")
  private Boolean validateKeySize = null;

  @SerializedName("keySize")
  private Integer keySize = null;

  public OrgcryptosettingsSshKeys validate(Boolean validate) {
    this.validate = validate;
    return this;
  }

   /**
   * Get validate
   * @return validate
  **/
  @ApiModelProperty(value = "")
  public Boolean isValidate() {
    return validate;
  }

  public void setValidate(Boolean validate) {
    this.validate = validate;
  }

  public OrgcryptosettingsSshKeys validateKeySize(Boolean validateKeySize) {
    this.validateKeySize = validateKeySize;
    return this;
  }

   /**
   * Get validateKeySize
   * @return validateKeySize
  **/
  @ApiModelProperty(value = "")
  public Boolean isValidateKeySize() {
    return validateKeySize;
  }

  public void setValidateKeySize(Boolean validateKeySize) {
    this.validateKeySize = validateKeySize;
  }

  public OrgcryptosettingsSshKeys keySize(Integer keySize) {
    this.keySize = keySize;
    return this;
  }

   /**
   * Get keySize
   * @return keySize
  **/
  @ApiModelProperty(value = "")
  public Integer getKeySize() {
    return keySize;
  }

  public void setKeySize(Integer keySize) {
    this.keySize = keySize;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrgcryptosettingsSshKeys orgcryptosettingsSshKeys = (OrgcryptosettingsSshKeys) o;
    return Objects.equals(this.validate, orgcryptosettingsSshKeys.validate) &&
        Objects.equals(this.validateKeySize, orgcryptosettingsSshKeys.validateKeySize) &&
        Objects.equals(this.keySize, orgcryptosettingsSshKeys.keySize);
  }

  @Override
  public int hashCode() {
    return Objects.hash(validate, validateKeySize, keySize);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrgcryptosettingsSshKeys {\n");
    
    sb.append("    validate: ").append(toIndentedString(validate)).append("\n");
    sb.append("    validateKeySize: ").append(toIndentedString(validateKeySize)).append("\n");
    sb.append("    keySize: ").append(toIndentedString(keySize)).append("\n");
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

