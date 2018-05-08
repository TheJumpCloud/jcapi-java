/*
 * JumpCloud APIs
 * V1 & V2 versions of JumpCloud's API. The next version of JumpCloud's API. This set of endpoints allows JumpCloud customers to manage objects, groupings and mappings. The most recent version of JumpCloud's API. This set of endpoints allows JumpCloud customers to manage objects, groupings and mappings.
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
import io.swagger.client.model.SystemGraphManagementReqAttributesSudo;
import java.io.IOException;

/**
 * The graph connection&#39;s attributes
 */
@ApiModel(description = "The graph connection's attributes")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-08T19:05:12.311Z")
public class SystemGraphManagementReqAttributes {
  @SerializedName("sudo")
  private SystemGraphManagementReqAttributesSudo sudo = null;

  public SystemGraphManagementReqAttributes sudo(SystemGraphManagementReqAttributesSudo sudo) {
    this.sudo = sudo;
    return this;
  }

   /**
   * Get sudo
   * @return sudo
  **/
  @ApiModelProperty(value = "")
  public SystemGraphManagementReqAttributesSudo getSudo() {
    return sudo;
  }

  public void setSudo(SystemGraphManagementReqAttributesSudo sudo) {
    this.sudo = sudo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SystemGraphManagementReqAttributes systemGraphManagementReqAttributes = (SystemGraphManagementReqAttributes) o;
    return Objects.equals(this.sudo, systemGraphManagementReqAttributes.sudo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sudo);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemGraphManagementReqAttributes {\n");
    
    sb.append("    sudo: ").append(toIndentedString(sudo)).append("\n");
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

