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
 * GSuiteTranslationRule
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-01-07T20:19:37.978Z")
public class GSuiteTranslationRule {
  @SerializedName("builtIn")
  private GSuiteBuiltinTranslation builtIn = null;

  @SerializedName("id")
  private String id = null;

  public GSuiteTranslationRule builtIn(GSuiteBuiltinTranslation builtIn) {
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

  public GSuiteTranslationRule id(String id) {
    this.id = id;
    return this;
  }

   /**
   * ObjectId uniquely identifying a Translation Rule.
   * @return id
  **/
  @ApiModelProperty(value = "ObjectId uniquely identifying a Translation Rule.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GSuiteTranslationRule gsuiteTranslationRule = (GSuiteTranslationRule) o;
    return Objects.equals(this.builtIn, gsuiteTranslationRule.builtIn) &&
        Objects.equals(this.id, gsuiteTranslationRule.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(builtIn, id);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GSuiteTranslationRule {\n");
    
    sb.append("    builtIn: ").append(toIndentedString(builtIn)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

