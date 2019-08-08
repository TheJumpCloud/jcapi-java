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
import io.swagger.client.model.OrganizationslistResults;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Organizationslist
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-08-08T00:57:43.512Z")
public class Organizationslist {
  @SerializedName("totalCount")
  private Integer totalCount = null;

  @SerializedName("results")
  private List<OrganizationslistResults> results = null;

  public Organizationslist totalCount(Integer totalCount) {
    this.totalCount = totalCount;
    return this;
  }

   /**
   * The total number of organizations. 
   * @return totalCount
  **/
  @ApiModelProperty(value = "The total number of organizations. ")
  public Integer getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(Integer totalCount) {
    this.totalCount = totalCount;
  }

  public Organizationslist results(List<OrganizationslistResults> results) {
    this.results = results;
    return this;
  }

  public Organizationslist addResultsItem(OrganizationslistResults resultsItem) {
    if (this.results == null) {
      this.results = new ArrayList<OrganizationslistResults>();
    }
    this.results.add(resultsItem);
    return this;
  }

   /**
   * The list of organizations.
   * @return results
  **/
  @ApiModelProperty(value = "The list of organizations.")
  public List<OrganizationslistResults> getResults() {
    return results;
  }

  public void setResults(List<OrganizationslistResults> results) {
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
    Organizationslist organizationslist = (Organizationslist) o;
    return Objects.equals(this.totalCount, organizationslist.totalCount) &&
        Objects.equals(this.results, organizationslist.results);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalCount, results);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Organizationslist {\n");
    
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

