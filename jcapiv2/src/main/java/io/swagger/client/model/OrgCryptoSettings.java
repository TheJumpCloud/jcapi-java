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
import io.swagger.client.model.OrgcryptosettingsSshKeys;
import java.io.IOException;

/**
 * OrgCryptoSettings
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-09-23T20:31:04.187Z")
public class OrgCryptoSettings {
  @SerializedName("sshKeys")
  private OrgcryptosettingsSshKeys sshKeys = null;

  public OrgCryptoSettings sshKeys(OrgcryptosettingsSshKeys sshKeys) {
    this.sshKeys = sshKeys;
    return this;
  }

   /**
   * Get sshKeys
   * @return sshKeys
  **/
  @ApiModelProperty(value = "")
  public OrgcryptosettingsSshKeys getSshKeys() {
    return sshKeys;
  }

  public void setSshKeys(OrgcryptosettingsSshKeys sshKeys) {
    this.sshKeys = sshKeys;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrgCryptoSettings orgCryptoSettings = (OrgCryptoSettings) o;
    return Objects.equals(this.sshKeys, orgCryptoSettings.sshKeys);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sshKeys);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrgCryptoSettings {\n");
    
    sb.append("    sshKeys: ").append(toIndentedString(sshKeys)).append("\n");
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

