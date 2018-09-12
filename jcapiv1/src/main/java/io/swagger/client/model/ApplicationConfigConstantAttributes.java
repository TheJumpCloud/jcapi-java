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
import io.swagger.client.model.ApplicationConfigConstantAttributesValue;
import io.swagger.client.model.ApplicationConfigIdpEntityIdTooltip;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ApplicationConfigConstantAttributes
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-09-12T20:59:54.768Z")
public class ApplicationConfigConstantAttributes {
  @SerializedName("label")
  private String label = null;

  @SerializedName("readOnly")
  private Boolean readOnly = null;

  @SerializedName("tooltip")
  private ApplicationConfigIdpEntityIdTooltip tooltip = null;

  @SerializedName("type")
  private String type = null;

  @SerializedName("value")
  private List<ApplicationConfigConstantAttributesValue> value = null;

  @SerializedName("visible")
  private Boolean visible = null;

  @SerializedName("mutable")
  private Boolean mutable = null;

  @SerializedName("required")
  private Boolean required = null;

  @SerializedName("position")
  private Integer position = null;

  public ApplicationConfigConstantAttributes label(String label) {
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

  public ApplicationConfigConstantAttributes readOnly(Boolean readOnly) {
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

  public ApplicationConfigConstantAttributes tooltip(ApplicationConfigIdpEntityIdTooltip tooltip) {
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

  public ApplicationConfigConstantAttributes type(String type) {
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

  public ApplicationConfigConstantAttributes value(List<ApplicationConfigConstantAttributesValue> value) {
    this.value = value;
    return this;
  }

  public ApplicationConfigConstantAttributes addValueItem(ApplicationConfigConstantAttributesValue valueItem) {
    if (this.value == null) {
      this.value = new ArrayList<ApplicationConfigConstantAttributesValue>();
    }
    this.value.add(valueItem);
    return this;
  }

   /**
   * Get value
   * @return value
  **/
  @ApiModelProperty(value = "")
  public List<ApplicationConfigConstantAttributesValue> getValue() {
    return value;
  }

  public void setValue(List<ApplicationConfigConstantAttributesValue> value) {
    this.value = value;
  }

  public ApplicationConfigConstantAttributes visible(Boolean visible) {
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

  public ApplicationConfigConstantAttributes mutable(Boolean mutable) {
    this.mutable = mutable;
    return this;
  }

   /**
   * Get mutable
   * @return mutable
  **/
  @ApiModelProperty(value = "")
  public Boolean isMutable() {
    return mutable;
  }

  public void setMutable(Boolean mutable) {
    this.mutable = mutable;
  }

  public ApplicationConfigConstantAttributes required(Boolean required) {
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

  public ApplicationConfigConstantAttributes position(Integer position) {
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
    ApplicationConfigConstantAttributes applicationConfigConstantAttributes = (ApplicationConfigConstantAttributes) o;
    return Objects.equals(this.label, applicationConfigConstantAttributes.label) &&
        Objects.equals(this.readOnly, applicationConfigConstantAttributes.readOnly) &&
        Objects.equals(this.tooltip, applicationConfigConstantAttributes.tooltip) &&
        Objects.equals(this.type, applicationConfigConstantAttributes.type) &&
        Objects.equals(this.value, applicationConfigConstantAttributes.value) &&
        Objects.equals(this.visible, applicationConfigConstantAttributes.visible) &&
        Objects.equals(this.mutable, applicationConfigConstantAttributes.mutable) &&
        Objects.equals(this.required, applicationConfigConstantAttributes.required) &&
        Objects.equals(this.position, applicationConfigConstantAttributes.position);
  }

  @Override
  public int hashCode() {
    return Objects.hash(label, readOnly, tooltip, type, value, visible, mutable, required, position);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApplicationConfigConstantAttributes {\n");
    
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    readOnly: ").append(toIndentedString(readOnly)).append("\n");
    sb.append("    tooltip: ").append(toIndentedString(tooltip)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    visible: ").append(toIndentedString(visible)).append("\n");
    sb.append("    mutable: ").append(toIndentedString(mutable)).append("\n");
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

