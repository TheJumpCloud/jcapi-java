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
import io.swagger.client.model.Application;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Applicationslist
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-08-09T16:30:16.716Z")
public class Applicationslist {
  @SerializedName("totalCount")
  private Integer totalCount = null;

  @SerializedName("results")
  private List<Application> results = null;

  public Applicationslist totalCount(Integer totalCount) {
    this.totalCount = totalCount;
    return this;
  }

   /**
   * The total number of applications.
   * @return totalCount
  **/
  @ApiModelProperty(value = "The total number of applications.")
  public Integer getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(Integer totalCount) {
    this.totalCount = totalCount;
  }

  public Applicationslist results(List<Application> results) {
    this.results = results;
    return this;
  }

  public Applicationslist addResultsItem(Application resultsItem) {
    if (this.results == null) {
      this.results = new ArrayList<Application>();
    }
    this.results.add(resultsItem);
    return this;
  }

   /**
   * The list of applications.
   * @return results
  **/
  @ApiModelProperty(value = "The list of applications.")
  public List<Application> getResults() {
    return results;
  }

  public void setResults(List<Application> results) {
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
    Applicationslist applicationslist = (Applicationslist) o;
    return Objects.equals(this.totalCount, applicationslist.totalCount) &&
        Objects.equals(this.results, applicationslist.results);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalCount, results);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Applicationslist {\n");
    
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

