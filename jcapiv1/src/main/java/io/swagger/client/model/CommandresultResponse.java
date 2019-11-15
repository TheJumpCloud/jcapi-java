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
import io.swagger.client.model.CommandresultResponseData;
import java.io.IOException;

/**
 * CommandresultResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-11-15T20:11:11.958Z")
public class CommandresultResponse {
  @SerializedName("data")
  private CommandresultResponseData data = null;

  @SerializedName("error")
  private String error = null;

  @SerializedName("id")
  private String id = null;

  public CommandresultResponse data(CommandresultResponseData data) {
    this.data = data;
    return this;
  }

   /**
   * Get data
   * @return data
  **/
  @ApiModelProperty(value = "")
  public CommandresultResponseData getData() {
    return data;
  }

  public void setData(CommandresultResponseData data) {
    this.data = data;
  }

  public CommandresultResponse error(String error) {
    this.error = error;
    return this;
  }

   /**
   * The stderr output from the command that ran.
   * @return error
  **/
  @ApiModelProperty(value = "The stderr output from the command that ran.")
  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public CommandresultResponse id(String id) {
    this.id = id;
    return this;
  }

   /**
   * ID of the response.
   * @return id
  **/
  @ApiModelProperty(value = "ID of the response.")
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
    CommandresultResponse commandresultResponse = (CommandresultResponse) o;
    return Objects.equals(this.data, commandresultResponse.data) &&
        Objects.equals(this.error, commandresultResponse.error) &&
        Objects.equals(this.id, commandresultResponse.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, error, id);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommandresultResponse {\n");
    
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
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

