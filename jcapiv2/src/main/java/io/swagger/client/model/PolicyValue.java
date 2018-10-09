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
import java.io.IOException;

/**
 * PolicyValue
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-10-09T22:21:18.591Z")
public class PolicyValue {
  @SerializedName("configFieldID")
  private String configFieldID = null;

  public PolicyValue configFieldID(String configFieldID) {
    this.configFieldID = configFieldID;
    return this;
  }

   /**
   * The ObjectId of the corresponding Policy Template configuration field.
   * @return configFieldID
  **/
  @ApiModelProperty(value = "The ObjectId of the corresponding Policy Template configuration field.")
  public String getConfigFieldID() {
    return configFieldID;
  }

  public void setConfigFieldID(String configFieldID) {
    this.configFieldID = configFieldID;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PolicyValue policyValue = (PolicyValue) o;
    return Objects.equals(this.configFieldID, policyValue.configFieldID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(configFieldID);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PolicyValue {\n");
    
    sb.append("    configFieldID: ").append(toIndentedString(configFieldID)).append("\n");
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

