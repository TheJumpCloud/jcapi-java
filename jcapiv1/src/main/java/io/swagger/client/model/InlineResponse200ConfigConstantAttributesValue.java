/*
 * JumpCloud APIs
 * V1 & V2 versions of JumpCloud's API. The previous version of JumpCloud's API. This set of endpoints allows JumpCloud customers to manage commands, systems, & system users.
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
 * InlineResponse200ConfigConstantAttributesValue
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-09T19:50:51.514Z")
public class InlineResponse200ConfigConstantAttributesValue {
  @SerializedName("visible")
  private Boolean visible = null;

  @SerializedName("readOnly")
  private Boolean readOnly = null;

  public InlineResponse200ConfigConstantAttributesValue visible(Boolean visible) {
    this.visible = visible;
    return this;
  }

   /**
   * Get visible
   * @return visible
  **/
  @ApiModelProperty(value = "")
  public Boolean isVisible() {
    return visible;
  }

  public void setVisible(Boolean visible) {
    this.visible = visible;
  }

  public InlineResponse200ConfigConstantAttributesValue readOnly(Boolean readOnly) {
    this.readOnly = readOnly;
    return this;
  }

   /**
   * Get readOnly
   * @return readOnly
  **/
  @ApiModelProperty(value = "")
  public Boolean isReadOnly() {
    return readOnly;
  }

  public void setReadOnly(Boolean readOnly) {
    this.readOnly = readOnly;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse200ConfigConstantAttributesValue inlineResponse200ConfigConstantAttributesValue = (InlineResponse200ConfigConstantAttributesValue) o;
    return Objects.equals(this.visible, inlineResponse200ConfigConstantAttributesValue.visible) &&
        Objects.equals(this.readOnly, inlineResponse200ConfigConstantAttributesValue.readOnly);
  }

  @Override
  public int hashCode() {
    return Objects.hash(visible, readOnly);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse200ConfigConstantAttributesValue {\n");
    
    sb.append("    visible: ").append(toIndentedString(visible)).append("\n");
    sb.append("    readOnly: ").append(toIndentedString(readOnly)).append("\n");
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

