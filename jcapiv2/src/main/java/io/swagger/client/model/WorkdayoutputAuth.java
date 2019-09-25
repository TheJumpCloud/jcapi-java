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
import io.swagger.client.model.AuthInfo;
import java.io.IOException;

/**
 * WorkdayoutputAuth
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-09-25T16:18:04.122Z")
public class WorkdayoutputAuth {
  @SerializedName("basic")
  private AuthInfo basic = null;

  @SerializedName("oauth")
  private AuthInfo oauth = null;

  public WorkdayoutputAuth basic(AuthInfo basic) {
    this.basic = basic;
    return this;
  }

   /**
   * Get basic
   * @return basic
  **/
  @ApiModelProperty(value = "")
  public AuthInfo getBasic() {
    return basic;
  }

  public void setBasic(AuthInfo basic) {
    this.basic = basic;
  }

  public WorkdayoutputAuth oauth(AuthInfo oauth) {
    this.oauth = oauth;
    return this;
  }

   /**
   * Get oauth
   * @return oauth
  **/
  @ApiModelProperty(value = "")
  public AuthInfo getOauth() {
    return oauth;
  }

  public void setOauth(AuthInfo oauth) {
    this.oauth = oauth;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WorkdayoutputAuth workdayoutputAuth = (WorkdayoutputAuth) o;
    return Objects.equals(this.basic, workdayoutputAuth.basic) &&
        Objects.equals(this.oauth, workdayoutputAuth.oauth);
  }

  @Override
  public int hashCode() {
    return Objects.hash(basic, oauth);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WorkdayoutputAuth {\n");
    
    sb.append("    basic: ").append(toIndentedString(basic)).append("\n");
    sb.append("    oauth: ").append(toIndentedString(oauth)).append("\n");
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

