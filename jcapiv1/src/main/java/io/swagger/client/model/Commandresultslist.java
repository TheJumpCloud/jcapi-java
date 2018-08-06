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
import io.swagger.client.model.Commandresult;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Commandresultslist
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-08-06T18:14:17.283Z")
public class Commandresultslist {
  @SerializedName("totalCount")
  private Integer totalCount = null;

  @SerializedName("results")
  private List<Commandresult> results = null;

  public Commandresultslist totalCount(Integer totalCount) {
    this.totalCount = totalCount;
    return this;
  }

   /**
   * The total number of command results
   * @return totalCount
  **/
  @ApiModelProperty(value = "The total number of command results")
  public Integer getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(Integer totalCount) {
    this.totalCount = totalCount;
  }

  public Commandresultslist results(List<Commandresult> results) {
    this.results = results;
    return this;
  }

  public Commandresultslist addResultsItem(Commandresult resultsItem) {
    if (this.results == null) {
      this.results = new ArrayList<Commandresult>();
    }
    this.results.add(resultsItem);
    return this;
  }

   /**
   * The list of command results
   * @return results
  **/
  @ApiModelProperty(value = "The list of command results")
  public List<Commandresult> getResults() {
    return results;
  }

  public void setResults(List<Commandresult> results) {
    this.results = results;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Commandresultslist commandresultslist = (Commandresultslist) o;
    return Objects.equals(this.totalCount, commandresultslist.totalCount) &&
        Objects.equals(this.results, commandresultslist.results);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalCount, results);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Commandresultslist {\n");
    
    sb.append("    totalCount: ").append(toIndentedString(totalCount)).append("\n");
    sb.append("    results: ").append(toIndentedString(results)).append("\n");
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

