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
import io.swagger.client.model.WorkdayoutputAuth;
import java.io.IOException;

/**
 * WorkdayOutput
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-02-15T22:16:49.168Z")
public class WorkdayOutput {
  @SerializedName("id")
  private String id = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("reportUrl")
  private String reportUrl = null;

  @SerializedName("lastImport")
  private String lastImport = null;

  @SerializedName("auth")
  private WorkdayoutputAuth auth = null;

  public WorkdayOutput id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public WorkdayOutput name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public WorkdayOutput reportUrl(String reportUrl) {
    this.reportUrl = reportUrl;
    return this;
  }

   /**
   * Get reportUrl
   * @return reportUrl
  **/
  @ApiModelProperty(value = "")
  public String getReportUrl() {
    return reportUrl;
  }

  public void setReportUrl(String reportUrl) {
    this.reportUrl = reportUrl;
  }

  public WorkdayOutput lastImport(String lastImport) {
    this.lastImport = lastImport;
    return this;
  }

   /**
   * Get lastImport
   * @return lastImport
  **/
  @ApiModelProperty(value = "")
  public String getLastImport() {
    return lastImport;
  }

  public void setLastImport(String lastImport) {
    this.lastImport = lastImport;
  }

  public WorkdayOutput auth(WorkdayoutputAuth auth) {
    this.auth = auth;
    return this;
  }

   /**
   * Get auth
   * @return auth
  **/
  @ApiModelProperty(value = "")
  public WorkdayoutputAuth getAuth() {
    return auth;
  }

  public void setAuth(WorkdayoutputAuth auth) {
    this.auth = auth;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WorkdayOutput workdayOutput = (WorkdayOutput) o;
    return Objects.equals(this.id, workdayOutput.id) &&
        Objects.equals(this.name, workdayOutput.name) &&
        Objects.equals(this.reportUrl, workdayOutput.reportUrl) &&
        Objects.equals(this.lastImport, workdayOutput.lastImport) &&
        Objects.equals(this.auth, workdayOutput.auth);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, reportUrl, lastImport, auth);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WorkdayOutput {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    reportUrl: ").append(toIndentedString(reportUrl)).append("\n");
    sb.append("    lastImport: ").append(toIndentedString(lastImport)).append("\n");
    sb.append("    auth: ").append(toIndentedString(auth)).append("\n");
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

