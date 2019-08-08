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
import java.io.IOException;

/**
 * An instance of a policy template.
 */
@ApiModel(description = "An instance of a policy template.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-08-08T01:06:48.987Z")
public class Policy {
  @SerializedName("id")
  private String id = null;

  @SerializedName("template")
  private PolicyTemplate template = null;

  @SerializedName("name")
  private String name = null;

  public Policy id(String id) {
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

  public Policy template(PolicyTemplate template) {
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

  public Policy name(String name) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Policy policy = (Policy) o;
    return Objects.equals(this.id, policy.id) &&
        Objects.equals(this.template, policy.template) &&
        Objects.equals(this.name, policy.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, template, name);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Policy {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    template: ").append(toIndentedString(template)).append("\n");
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

