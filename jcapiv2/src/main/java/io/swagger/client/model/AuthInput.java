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
import io.swagger.client.model.AuthinputBasic;
import io.swagger.client.model.AuthinputOauth;
import java.io.IOException;

/**
 * AuthInput
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-10-11T00:36:09.560Z")
public class AuthInput {
  @SerializedName("oauth")
  private AuthinputOauth oauth = null;

  @SerializedName("basic")
  private AuthinputBasic basic = null;

  public AuthInput oauth(AuthinputOauth oauth) {
    this.oauth = oauth;
    return this;
  }

   /**
   * Get oauth
   * @return oauth
  **/
  @ApiModelProperty(value = "")
  public AuthinputOauth getOauth() {
    return oauth;
  }

  public void setOauth(AuthinputOauth oauth) {
    this.oauth = oauth;
  }

  public AuthInput basic(AuthinputBasic basic) {
    this.basic = basic;
    return this;
  }

   /**
   * Get basic
   * @return basic
  **/
  @ApiModelProperty(value = "")
  public AuthinputBasic getBasic() {
    return basic;
  }

  public void setBasic(AuthinputBasic basic) {
    this.basic = basic;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthInput authInput = (AuthInput) o;
    return Objects.equals(this.oauth, authInput.oauth) &&
        Objects.equals(this.basic, authInput.basic);
  }

  @Override
  public int hashCode() {
    return Objects.hash(oauth, basic);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthInput {\n");
    
    sb.append("    oauth: ").append(toIndentedString(oauth)).append("\n");
    sb.append("    basic: ").append(toIndentedString(basic)).append("\n");
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

