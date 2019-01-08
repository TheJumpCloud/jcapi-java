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
import io.swagger.client.model.UserGroupPutAttributes;
import java.io.IOException;

/**
 * UserGroupPut
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-01-08T20:00:43.436Z")
public class UserGroupPut {
  @SerializedName("attributes")
  private UserGroupPutAttributes attributes = null;

  @SerializedName("name")
  private String name = null;

  public UserGroupPut attributes(UserGroupPutAttributes attributes) {
    this.attributes = attributes;
    return this;
  }

   /**
   * Get attributes
   * @return attributes
  **/
  @ApiModelProperty(value = "")
  public UserGroupPutAttributes getAttributes() {
    return attributes;
  }

  public void setAttributes(UserGroupPutAttributes attributes) {
    this.attributes = attributes;
  }

  public UserGroupPut name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Display name of a User Group.
   * @return name
  **/
  @ApiModelProperty(required = true, value = "Display name of a User Group.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserGroupPut userGroupPut = (UserGroupPut) o;
    return Objects.equals(this.attributes, userGroupPut.attributes) &&
        Objects.equals(this.name, userGroupPut.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attributes, name);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserGroupPut {\n");
    
    sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

