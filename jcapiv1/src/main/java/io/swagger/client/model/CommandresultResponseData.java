/*
 * JumpCloud APIs
 * V1 & V2 versions of JumpCloud's API. The previous version of JumpCloud's API. This set of endpoints allows JumpCloud customers to manage commands, systems, & system users.
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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-09T19:50:51.514Z")
public class CommandresultResponseData {
  @SerializedName("output")
  private String output = null;

  @SerializedName("exitCode")
  private Integer exitCode = null;

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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommandresultResponseData commandresultResponseData = (CommandresultResponseData) o;
    return Objects.equals(this.output, commandresultResponseData.output) &&
        Objects.equals(this.exitCode, commandresultResponseData.exitCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(output, exitCode);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommandresultResponseData {\n");
    
    sb.append("    output: ").append(toIndentedString(output)).append("\n");
    sb.append("    exitCode: ").append(toIndentedString(exitCode)).append("\n");
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
