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
 * The group object&#39;s attributes.
 */
@ApiModel(description = "The group object's attributes.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-09-23T20:31:04.187Z")
public class UserGroupPutAttributes {
  @SerializedName("sambaEnabled")
  private Boolean sambaEnabled = null;

  public UserGroupPutAttributes sambaEnabled(Boolean sambaEnabled) {
    this.sambaEnabled = sambaEnabled;
    return this;
  }

   /**
   * Get sambaEnabled
   * @return sambaEnabled
  **/
  @ApiModelProperty(value = "")
  public Boolean isSambaEnabled() {
    return sambaEnabled;
  }

  public void setSambaEnabled(Boolean sambaEnabled) {
    this.sambaEnabled = sambaEnabled;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserGroupPutAttributes userGroupPutAttributes = (UserGroupPutAttributes) o;
    return Objects.equals(this.sambaEnabled, userGroupPutAttributes.sambaEnabled);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sambaEnabled);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserGroupPutAttributes {\n");
    
    sb.append("    sambaEnabled: ").append(toIndentedString(sambaEnabled)).append("\n");
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

