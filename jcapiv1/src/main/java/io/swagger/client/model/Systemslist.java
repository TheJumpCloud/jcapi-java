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
import io.swagger.client.model.System;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Systemslist
 */
<<<<<<< HEAD
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-08-06T18:14:17.283Z")
=======
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-06-11T23:05:15.891Z")
>>>>>>> master
public class Systemslist {
  @SerializedName("totalCount")
  private Integer totalCount = null;

  @SerializedName("results")
  private List<System> results = null;

  public Systemslist totalCount(Integer totalCount) {
    this.totalCount = totalCount;
    return this;
  }

   /**
   * The total number of systems.
   * @return totalCount
  **/
  @ApiModelProperty(value = "The total number of systems.")
  public Integer getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(Integer totalCount) {
    this.totalCount = totalCount;
  }

  public Systemslist results(List<System> results) {
    this.results = results;
    return this;
  }

  public Systemslist addResultsItem(System resultsItem) {
    if (this.results == null) {
      this.results = new ArrayList<System>();
    }
    this.results.add(resultsItem);
    return this;
  }

   /**
   * The list of systems.
   * @return results
  **/
  @ApiModelProperty(value = "The list of systems.")
  public List<System> getResults() {
    return results;
  }

  public void setResults(List<System> results) {
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
    Systemslist systemslist = (Systemslist) o;
    return Objects.equals(this.totalCount, systemslist.totalCount) &&
        Objects.equals(this.results, systemslist.results);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalCount, results);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Systemslist {\n");
    
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

