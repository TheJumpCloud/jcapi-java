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
import io.swagger.client.model.ApplicationConfigIdpEntityIdTooltip;
import java.io.IOException;

/**
 * ApplicationConfigIdpEntityId
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-08-08T01:13:22.675Z")
public class ApplicationConfigIdpEntityId {
  @SerializedName("label")
  private String label = null;

  @SerializedName("readOnly")
  private Boolean readOnly = null;

  @SerializedName("tooltip")
  private ApplicationConfigIdpEntityIdTooltip tooltip = null;

  @SerializedName("type")
  private String type = null;

  @SerializedName("value")
  private String value = null;

  @SerializedName("visible")
  private Boolean visible = null;

  @SerializedName("required")
  private Boolean required = null;

  @SerializedName("position")
  private Integer position = null;

  public ApplicationConfigIdpEntityId label(String label) {
    this.label = label;
    return this;
  }

   /**
   * Get label
   * @return label
  **/
  @ApiModelProperty(value = "")
  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public ApplicationConfigIdpEntityId readOnly(Boolean readOnly) {
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

  public ApplicationConfigIdpEntityId tooltip(ApplicationConfigIdpEntityIdTooltip tooltip) {
    this.tooltip = tooltip;
    return this;
  }

   /**
   * Get tooltip
   * @return tooltip
  **/
  @ApiModelProperty(value = "")
  public ApplicationConfigIdpEntityIdTooltip getTooltip() {
    return tooltip;
  }

  public void setTooltip(ApplicationConfigIdpEntityIdTooltip tooltip) {
    this.tooltip = tooltip;
  }

  public ApplicationConfigIdpEntityId type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(value = "")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public ApplicationConfigIdpEntityId value(String value) {
    this.value = value;
    return this;
  }

   /**
   * Get value
   * @return value
  **/
  @ApiModelProperty(value = "")
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public ApplicationConfigIdpEntityId visible(Boolean visible) {
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

  public ApplicationConfigIdpEntityId required(Boolean required) {
    this.required = required;
    return this;
  }

   /**
   * Get required
   * @return required
  **/
  @ApiModelProperty(value = "")
  public Boolean isRequired() {
    return required;
  }

  public void setRequired(Boolean required) {
    this.required = required;
  }

  public ApplicationConfigIdpEntityId position(Integer position) {
    this.position = position;
    return this;
  }

   /**
   * Get position
   * @return position
  **/
  @ApiModelProperty(value = "")
  public Integer getPosition() {
    return position;
  }

  public void setPosition(Integer position) {
    this.position = position;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApplicationConfigIdpEntityId applicationConfigIdpEntityId = (ApplicationConfigIdpEntityId) o;
    return Objects.equals(this.label, applicationConfigIdpEntityId.label) &&
        Objects.equals(this.readOnly, applicationConfigIdpEntityId.readOnly) &&
        Objects.equals(this.tooltip, applicationConfigIdpEntityId.tooltip) &&
        Objects.equals(this.type, applicationConfigIdpEntityId.type) &&
        Objects.equals(this.value, applicationConfigIdpEntityId.value) &&
        Objects.equals(this.visible, applicationConfigIdpEntityId.visible) &&
        Objects.equals(this.required, applicationConfigIdpEntityId.required) &&
        Objects.equals(this.position, applicationConfigIdpEntityId.position);
  }

  @Override
  public int hashCode() {
    return Objects.hash(label, readOnly, tooltip, type, value, visible, required, position);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApplicationConfigIdpEntityId {\n");
    
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    readOnly: ").append(toIndentedString(readOnly)).append("\n");
    sb.append("    tooltip: ").append(toIndentedString(tooltip)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    visible: ").append(toIndentedString(visible)).append("\n");
    sb.append("    required: ").append(toIndentedString(required)).append("\n");
    sb.append("    position: ").append(toIndentedString(position)).append("\n");
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

