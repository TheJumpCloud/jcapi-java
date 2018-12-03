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
import io.swagger.client.model.PolicyTemplateConfigFieldTooltip;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * PolicyTemplateConfigField
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-12-03T22:10:14.942Z")
public class PolicyTemplateConfigField {
  @SerializedName("id")
  private String id = null;

  /**
   * The default rendering for this field.
   */
  @JsonAdapter(DisplayTypeEnum.Adapter.class)
  public enum DisplayTypeEnum {
    CHECKBOX("checkbox"),
    
    DATE("date"),
    
    EMAIL("email"),
    
    NUMBER("number"),
    
    SELECT("select"),
    
    TEXT("text"),
    
    TEXTAREA("textarea");

    private String value;

    DisplayTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static DisplayTypeEnum fromValue(String text) {
      for (DisplayTypeEnum b : DisplayTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<DisplayTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final DisplayTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public DisplayTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return DisplayTypeEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("displayType")
  private DisplayTypeEnum displayType = null;

  @SerializedName("label")
  private String label = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("position")
  private BigDecimal position = null;

  @SerializedName("readOnly")
  private Boolean readOnly = null;

  @SerializedName("required")
  private Boolean required = null;

  @SerializedName("tooltip")
  private PolicyTemplateConfigFieldTooltip tooltip = null;

  public PolicyTemplateConfigField id(String id) {
    this.id = id;
    return this;
  }

   /**
   * ObjectId uniquely identifying a Policy Template Configuration Field
   * @return id
  **/
  @ApiModelProperty(required = true, value = "ObjectId uniquely identifying a Policy Template Configuration Field")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public PolicyTemplateConfigField displayType(DisplayTypeEnum displayType) {
    this.displayType = displayType;
    return this;
  }

   /**
   * The default rendering for this field.
   * @return displayType
  **/
  @ApiModelProperty(value = "The default rendering for this field.")
  public DisplayTypeEnum getDisplayType() {
    return displayType;
  }

  public void setDisplayType(DisplayTypeEnum displayType) {
    this.displayType = displayType;
  }

  public PolicyTemplateConfigField label(String label) {
    this.label = label;
    return this;
  }

   /**
   * The default label for this field.
   * @return label
  **/
  @ApiModelProperty(value = "The default label for this field.")
  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public PolicyTemplateConfigField name(String name) {
    this.name = name;
    return this;
  }

   /**
   * A unique name identifying this config field.
   * @return name
  **/
  @ApiModelProperty(required = true, value = "A unique name identifying this config field.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PolicyTemplateConfigField position(BigDecimal position) {
    this.position = position;
    return this;
  }

   /**
   * The default position to render this field.
   * @return position
  **/
  @ApiModelProperty(value = "The default position to render this field.")
  public BigDecimal getPosition() {
    return position;
  }

  public void setPosition(BigDecimal position) {
    this.position = position;
  }

  public PolicyTemplateConfigField readOnly(Boolean readOnly) {
    this.readOnly = readOnly;
    return this;
  }

   /**
   * If an admin is allowed to modify this field.
   * @return readOnly
  **/
  @ApiModelProperty(value = "If an admin is allowed to modify this field.")
  public Boolean isReadOnly() {
    return readOnly;
  }

  public void setReadOnly(Boolean readOnly) {
    this.readOnly = readOnly;
  }

  public PolicyTemplateConfigField required(Boolean required) {
    this.required = required;
    return this;
  }

   /**
   * If this field is required for this field.
   * @return required
  **/
  @ApiModelProperty(value = "If this field is required for this field.")
  public Boolean isRequired() {
    return required;
  }

  public void setRequired(Boolean required) {
    this.required = required;
  }

  public PolicyTemplateConfigField tooltip(PolicyTemplateConfigFieldTooltip tooltip) {
    this.tooltip = tooltip;
    return this;
  }

   /**
   * Get tooltip
   * @return tooltip
  **/
  @ApiModelProperty(value = "")
  public PolicyTemplateConfigFieldTooltip getTooltip() {
    return tooltip;
  }

  public void setTooltip(PolicyTemplateConfigFieldTooltip tooltip) {
    this.tooltip = tooltip;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PolicyTemplateConfigField policyTemplateConfigField = (PolicyTemplateConfigField) o;
    return Objects.equals(this.id, policyTemplateConfigField.id) &&
        Objects.equals(this.displayType, policyTemplateConfigField.displayType) &&
        Objects.equals(this.label, policyTemplateConfigField.label) &&
        Objects.equals(this.name, policyTemplateConfigField.name) &&
        Objects.equals(this.position, policyTemplateConfigField.position) &&
        Objects.equals(this.readOnly, policyTemplateConfigField.readOnly) &&
        Objects.equals(this.required, policyTemplateConfigField.required) &&
        Objects.equals(this.tooltip, policyTemplateConfigField.tooltip);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, displayType, label, name, position, readOnly, required, tooltip);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PolicyTemplateConfigField {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    displayType: ").append(toIndentedString(displayType)).append("\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    position: ").append(toIndentedString(position)).append("\n");
    sb.append("    readOnly: ").append(toIndentedString(readOnly)).append("\n");
    sb.append("    required: ").append(toIndentedString(required)).append("\n");
    sb.append("    tooltip: ").append(toIndentedString(tooltip)).append("\n");
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

