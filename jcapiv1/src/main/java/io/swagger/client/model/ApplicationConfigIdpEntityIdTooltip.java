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
import io.swagger.client.model.ApplicationConfigIdpEntityIdTooltipVariables;
import java.io.IOException;

/**
 * ApplicationConfigIdpEntityIdTooltip
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-02-28T17:52:37.291Z")
public class ApplicationConfigIdpEntityIdTooltip {
  @SerializedName("template")
  private String template = null;

  @SerializedName("variables")
  private ApplicationConfigIdpEntityIdTooltipVariables variables = null;

  public ApplicationConfigIdpEntityIdTooltip template(String template) {
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

  public ApplicationConfigIdpEntityIdTooltip variables(ApplicationConfigIdpEntityIdTooltipVariables variables) {
    this.variables = variables;
    return this;
  }

   /**
   * Get variables
   * @return variables
  **/
  @ApiModelProperty(value = "")
  public ApplicationConfigIdpEntityIdTooltipVariables getVariables() {
    return variables;
  }

  public void setVariables(ApplicationConfigIdpEntityIdTooltipVariables variables) {
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
    ApplicationConfigIdpEntityIdTooltip applicationConfigIdpEntityIdTooltip = (ApplicationConfigIdpEntityIdTooltip) o;
    return Objects.equals(this.template, applicationConfigIdpEntityIdTooltip.template) &&
        Objects.equals(this.variables, applicationConfigIdpEntityIdTooltip.variables);
  }

  @Override
  public int hashCode() {
    return Objects.hash(template, variables);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApplicationConfigIdpEntityIdTooltip {\n");
    
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

