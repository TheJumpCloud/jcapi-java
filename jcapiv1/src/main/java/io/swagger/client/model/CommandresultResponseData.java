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
import java.io.IOException;

/**
 * CommandresultResponseData
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-11-21T20:17:09.332Z")
public class CommandresultResponseData {
  @SerializedName("exitCode")
  private Integer exitCode = null;

  @SerializedName("output")
  private String output = null;

  public CommandresultResponseData exitCode(Integer exitCode) {
    this.exitCode = exitCode;
    return this;
  }

   /**
   * The stderr output from the command that ran.
   * @return exitCode
  **/
  @ApiModelProperty(value = "The stderr output from the command that ran.")
  public Integer getExitCode() {
    return exitCode;
  }

  public void setExitCode(Integer exitCode) {
    this.exitCode = exitCode;
  }

  public CommandresultResponseData output(String output) {
    this.output = output;
    return this;
  }

   /**
   * The output of the command that was executed.
   * @return output
  **/
  @ApiModelProperty(value = "The output of the command that was executed.")
  public String getOutput() {
    return output;
  }

  public void setOutput(String output) {
    this.output = output;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommandresultResponseData commandresultResponseData = (CommandresultResponseData) o;
    return Objects.equals(this.exitCode, commandresultResponseData.exitCode) &&
        Objects.equals(this.output, commandresultResponseData.output);
  }

  @Override
  public int hashCode() {
    return Objects.hash(exitCode, output);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommandresultResponseData {\n");
    
    sb.append("    exitCode: ").append(toIndentedString(exitCode)).append("\n");
    sb.append("    output: ").append(toIndentedString(output)).append("\n");
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

