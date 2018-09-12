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
 * SystemGraphManagementReqAttributesSudo
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-09-12T21:14:00.825Z")
public class SystemGraphManagementReqAttributesSudo {
  @SerializedName("enabled")
  private Boolean enabled = null;

  @SerializedName("withoutPassword")
  private Boolean withoutPassword = null;

  public SystemGraphManagementReqAttributesSudo enabled(Boolean enabled) {
    this.enabled = enabled;
    return this;
  }

   /**
   * Get enabled
   * @return enabled
  **/
  @ApiModelProperty(value = "")
  public Boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  public SystemGraphManagementReqAttributesSudo withoutPassword(Boolean withoutPassword) {
    this.withoutPassword = withoutPassword;
    return this;
  }

   /**
   * Get withoutPassword
   * @return withoutPassword
  **/
  @ApiModelProperty(value = "")
  public Boolean isWithoutPassword() {
    return withoutPassword;
  }

  public void setWithoutPassword(Boolean withoutPassword) {
    this.withoutPassword = withoutPassword;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SystemGraphManagementReqAttributesSudo systemGraphManagementReqAttributesSudo = (SystemGraphManagementReqAttributesSudo) o;
    return Objects.equals(this.enabled, systemGraphManagementReqAttributesSudo.enabled) &&
        Objects.equals(this.withoutPassword, systemGraphManagementReqAttributesSudo.withoutPassword);
  }

  @Override
  public int hashCode() {
    return Objects.hash(enabled, withoutPassword);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemGraphManagementReqAttributesSudo {\n");
    
    sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
    sb.append("    withoutPassword: ").append(toIndentedString(withoutPassword)).append("\n");
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

