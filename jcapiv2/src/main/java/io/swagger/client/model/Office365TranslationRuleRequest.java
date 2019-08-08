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
import io.swagger.client.model.Office365BuiltinTranslation;
import java.io.IOException;

/**
 * Office365TranslationRuleRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-08-08T01:06:48.987Z")
public class Office365TranslationRuleRequest {
  @SerializedName("builtIn")
  private Office365BuiltinTranslation builtIn = null;

  public Office365TranslationRuleRequest builtIn(Office365BuiltinTranslation builtIn) {
    this.builtIn = builtIn;
    return this;
  }

   /**
   * Get builtIn
   * @return builtIn
  **/
  @ApiModelProperty(value = "")
  public Office365BuiltinTranslation getBuiltIn() {
    return builtIn;
  }

  public void setBuiltIn(Office365BuiltinTranslation builtIn) {
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
    Office365TranslationRuleRequest office365TranslationRuleRequest = (Office365TranslationRuleRequest) o;
    return Objects.equals(this.builtIn, office365TranslationRuleRequest.builtIn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(builtIn);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Office365TranslationRuleRequest {\n");
    
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

