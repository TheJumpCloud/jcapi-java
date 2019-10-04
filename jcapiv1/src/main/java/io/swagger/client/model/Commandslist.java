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
import io.swagger.client.model.CommandslistResults;
import java.io.IOException;

/**
 * Commandslist
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-09-26T20:17:55.126Z")
public class Commandslist {
  @SerializedName("results")
  private CommandslistResults results = null;

  @SerializedName("totalCount")
  private Integer totalCount = null;

  public Commandslist results(CommandslistResults results) {
    this.results = results;
    return this;
  }

   /**
   * Get results
   * @return results
  **/
  @ApiModelProperty(value = "")
  public CommandslistResults getResults() {
    return results;
  }

  public void setResults(CommandslistResults results) {
    this.results = results;
  }

  public Commandslist totalCount(Integer totalCount) {
    this.totalCount = totalCount;
    return this;
  }

   /**
   * The total number of commands
   * @return totalCount
  **/
  @ApiModelProperty(value = "The total number of commands")
  public Integer getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(Integer totalCount) {
    this.totalCount = totalCount;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Commandslist commandslist = (Commandslist) o;
    return Objects.equals(this.results, commandslist.results) &&
        Objects.equals(this.totalCount, commandslist.totalCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(results, totalCount);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Commandslist {\n");
    
    sb.append("    results: ").append(toIndentedString(results)).append("\n");
    sb.append("    totalCount: ").append(toIndentedString(totalCount)).append("\n");
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

