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
import io.swagger.client.model.PolicyTemplateConfigFieldTooltipVariables;
import java.io.IOException;

/**
 * PolicyTemplateConfigFieldTooltip
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-12-03T22:10:14.942Z")
public class PolicyTemplateConfigFieldTooltip {
  @SerializedName("template")
  private String template = null;

  @SerializedName("variables")
  private PolicyTemplateConfigFieldTooltipVariables variables = null;

  public PolicyTemplateConfigFieldTooltip template(String template) {
    this.template = template;
    return this;
  }

   /**
   * Get template
   * @return template
  **/
  @ApiModelProperty(value = "")
  public String getTemplate() {
    return template;
  }

  public void setTemplate(String template) {
    this.template = template;
  }

  public PolicyTemplateConfigFieldTooltip variables(PolicyTemplateConfigFieldTooltipVariables variables) {
    this.variables = variables;
    return this;
  }

   /**
   * Get variables
   * @return variables
  **/
  @ApiModelProperty(value = "")
  public PolicyTemplateConfigFieldTooltipVariables getVariables() {
    return variables;
  }

  public void setVariables(PolicyTemplateConfigFieldTooltipVariables variables) {
    this.variables = variables;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PolicyTemplateConfigFieldTooltip policyTemplateConfigFieldTooltip = (PolicyTemplateConfigFieldTooltip) o;
    return Objects.equals(this.template, policyTemplateConfigFieldTooltip.template) &&
        Objects.equals(this.variables, policyTemplateConfigFieldTooltip.variables);
  }

  @Override
  public int hashCode() {
    return Objects.hash(template, variables);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PolicyTemplateConfigFieldTooltip {\n");
    
    sb.append("    template: ").append(toIndentedString(template)).append("\n");
    sb.append("    variables: ").append(toIndentedString(variables)).append("\n");
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

