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
import io.swagger.client.model.PolicyTemplate;
import io.swagger.client.model.PolicyTemplateConfigField;
import io.swagger.client.model.PolicyValue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * An instance of a policy template.
 */
@ApiModel(description = "An instance of a policy template.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-10-13T22:23:51.102Z")
public class PolicyWithDetails {
  @SerializedName("id")
  private String id = null;

  @SerializedName("template")
  private PolicyTemplate template = null;

  @SerializedName("configFields")
  private List<PolicyTemplateConfigField> configFields = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("values")
  private List<PolicyValue> values = null;

  public PolicyWithDetails id(String id) {
    this.id = id;
    return this;
  }

   /**
   * ObjectId uniquely identifying a Policy.
   * @return id
  **/
  @ApiModelProperty(value = "ObjectId uniquely identifying a Policy.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public PolicyWithDetails template(PolicyTemplate template) {
    this.template = template;
    return this;
  }

   /**
   * Get template
   * @return template
  **/
  @ApiModelProperty(value = "")
  public PolicyTemplate getTemplate() {
    return template;
  }

  public void setTemplate(PolicyTemplate template) {
    this.template = template;
  }

  public PolicyWithDetails configFields(List<PolicyTemplateConfigField> configFields) {
    this.configFields = configFields;
    return this;
  }

  public PolicyWithDetails addConfigFieldsItem(PolicyTemplateConfigField configFieldsItem) {
    if (this.configFields == null) {
      this.configFields = new ArrayList<PolicyTemplateConfigField>();
    }
    this.configFields.add(configFieldsItem);
    return this;
  }

   /**
   * Get configFields
   * @return configFields
  **/
  @ApiModelProperty(value = "")
  public List<PolicyTemplateConfigField> getConfigFields() {
    return configFields;
  }

  public void setConfigFields(List<PolicyTemplateConfigField> configFields) {
    this.configFields = configFields;
  }

  public PolicyWithDetails name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The description for this specific Policy.
   * @return name
  **/
  @ApiModelProperty(value = "The description for this specific Policy.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PolicyWithDetails values(List<PolicyValue> values) {
    this.values = values;
    return this;
  }

  public PolicyWithDetails addValuesItem(PolicyValue valuesItem) {
    if (this.values == null) {
      this.values = new ArrayList<PolicyValue>();
    }
    this.values.add(valuesItem);
    return this;
  }

   /**
   * Get values
   * @return values
  **/
  @ApiModelProperty(value = "")
  public List<PolicyValue> getValues() {
    return values;
  }

  public void setValues(List<PolicyValue> values) {
    this.values = values;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PolicyWithDetails policyWithDetails = (PolicyWithDetails) o;
    return Objects.equals(this.id, policyWithDetails.id) &&
        Objects.equals(this.template, policyWithDetails.template) &&
        Objects.equals(this.configFields, policyWithDetails.configFields) &&
        Objects.equals(this.name, policyWithDetails.name) &&
        Objects.equals(this.values, policyWithDetails.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, template, configFields, name, values);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PolicyWithDetails {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    template: ").append(toIndentedString(template)).append("\n");
    sb.append("    configFields: ").append(toIndentedString(configFields)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    values: ").append(toIndentedString(values)).append("\n");
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

