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
import io.swagger.client.model.GSuiteBuiltinTranslation;
import java.io.IOException;

/**
 * GSuiteTranslationRuleRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-03-28T15:13:46.946Z")
public class GSuiteTranslationRuleRequest {
  @SerializedName("builtIn")
  private GSuiteBuiltinTranslation builtIn = null;

  public GSuiteTranslationRuleRequest builtIn(GSuiteBuiltinTranslation builtIn) {
    this.builtIn = builtIn;
    return this;
  }

   /**
   * Get builtIn
   * @return builtIn
  **/
  @ApiModelProperty(value = "")
  public GSuiteBuiltinTranslation getBuiltIn() {
    return builtIn;
  }

  public void setBuiltIn(GSuiteBuiltinTranslation builtIn) {
    this.builtIn = builtIn;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GSuiteTranslationRuleRequest gsuiteTranslationRuleRequest = (GSuiteTranslationRuleRequest) o;
    return Objects.equals(this.builtIn, gsuiteTranslationRuleRequest.builtIn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(builtIn);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GSuiteTranslationRuleRequest {\n");
    
    sb.append("    builtIn: ").append(toIndentedString(builtIn)).append("\n");
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

