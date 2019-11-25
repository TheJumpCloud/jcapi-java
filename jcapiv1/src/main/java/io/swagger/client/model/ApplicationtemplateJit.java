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
 * ApplicationtemplateJit
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-11-21T20:17:09.332Z")
public class ApplicationtemplateJit {
  @SerializedName("attributes")
  private Object attributes = null;

  @SerializedName("createOnly")
  private Boolean createOnly = null;

  public ApplicationtemplateJit attributes(Object attributes) {
    this.attributes = attributes;
    return this;
  }

   /**
   * Get attributes
   * @return attributes
  **/
  @ApiModelProperty(value = "")
  public Object getAttributes() {
    return attributes;
  }

  public void setAttributes(Object attributes) {
    this.attributes = attributes;
  }

  public ApplicationtemplateJit createOnly(Boolean createOnly) {
    this.createOnly = createOnly;
    return this;
  }

   /**
   * Get createOnly
   * @return createOnly
  **/
  @ApiModelProperty(value = "")
  public Boolean isCreateOnly() {
    return createOnly;
  }

  public void setCreateOnly(Boolean createOnly) {
    this.createOnly = createOnly;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApplicationtemplateJit applicationtemplateJit = (ApplicationtemplateJit) o;
    return Objects.equals(this.attributes, applicationtemplateJit.attributes) &&
        Objects.equals(this.createOnly, applicationtemplateJit.createOnly);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attributes, createOnly);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApplicationtemplateJit {\n");
    
    sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
    sb.append("    createOnly: ").append(toIndentedString(createOnly)).append("\n");
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

