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
import io.swagger.client.model.PolicyRequestTemplate;
import io.swagger.client.model.PolicyValue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * An instance of a policy template.
 */
@ApiModel(description = "An instance of a policy template.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-10-12T03:32:23.898Z")
public class PolicyRequest {
  @SerializedName("name")
  private String name = null;

  @SerializedName("values")
  private List<PolicyValue> values = null;

  @SerializedName("template")
  private PolicyRequestTemplate template = null;

  public PolicyRequest name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The description for this specific Policy.
   * @return name
  **/
  @ApiModelProperty(required = true, value = "The description for this specific Policy.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PolicyRequest values(List<PolicyValue> values) {
    this.values = values;
    return this;
  }

  public PolicyRequest addValuesItem(PolicyValue valuesItem) {
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

  public PolicyRequest template(PolicyRequestTemplate template) {
    this.template = template;
    return this;
  }

   /**
   * Get template
   * @return template
  **/
  @ApiModelProperty(value = "")
  public PolicyRequestTemplate getTemplate() {
    return template;
  }

  public void setTemplate(PolicyRequestTemplate template) {
    this.template = template;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PolicyRequest policyRequest = (PolicyRequest) o;
    return Objects.equals(this.name, policyRequest.name) &&
        Objects.equals(this.values, policyRequest.values) &&
        Objects.equals(this.template, policyRequest.template);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, values, template);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PolicyRequest {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    values: ").append(toIndentedString(values)).append("\n");
    sb.append("    template: ").append(toIndentedString(template)).append("\n");
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

