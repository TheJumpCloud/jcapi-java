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
import java.util.ArrayList;
import java.util.List;

/**
 * JobDetails
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-03-28T17:13:26.727Z")
public class JobDetails {
  @SerializedName("id")
  private String id = null;

  @SerializedName("adminId")
  private String adminId = null;

  @SerializedName("workUnitsCount")
  private Integer workUnitsCount = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("status")
  private String status = null;

  @SerializedName("meta")
  private Object meta = null;

  @SerializedName("updatedAt")
  private String updatedAt = null;

  @SerializedName("persistedFields")
  private List<String> persistedFields = null;

  public JobDetails id(String id) {
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

  public JobDetails adminId(String adminId) {
    this.adminId = adminId;
    return this;
  }

   /**
   * Get adminId
   * @return adminId
  **/
  @ApiModelProperty(value = "")
  public String getAdminId() {
    return adminId;
  }

  public void setAdminId(String adminId) {
    this.adminId = adminId;
  }

  public JobDetails workUnitsCount(Integer workUnitsCount) {
    this.workUnitsCount = workUnitsCount;
    return this;
  }

   /**
   * Get workUnitsCount
   * @return workUnitsCount
  **/
  @ApiModelProperty(value = "")
  public Integer getWorkUnitsCount() {
    return workUnitsCount;
  }

  public void setWorkUnitsCount(Integer workUnitsCount) {
    this.workUnitsCount = workUnitsCount;
  }

  public JobDetails name(String name) {
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

  public JobDetails status(String status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public JobDetails meta(Object meta) {
    this.meta = meta;
    return this;
  }

   /**
   * Get meta
   * @return meta
  **/
  @ApiModelProperty(value = "")
  public Object getMeta() {
    return meta;
  }

  public void setMeta(Object meta) {
    this.meta = meta;
  }

  public JobDetails updatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

   /**
   * Get updatedAt
   * @return updatedAt
  **/
  @ApiModelProperty(value = "")
  public String getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }

  public JobDetails persistedFields(List<String> persistedFields) {
    this.persistedFields = persistedFields;
    return this;
  }

  public JobDetails addPersistedFieldsItem(String persistedFieldsItem) {
    if (this.persistedFields == null) {
      this.persistedFields = new ArrayList<String>();
    }
    this.persistedFields.add(persistedFieldsItem);
    return this;
  }

   /**
   * Get persistedFields
   * @return persistedFields
  **/
  @ApiModelProperty(value = "")
  public List<String> getPersistedFields() {
    return persistedFields;
  }

  public void setPersistedFields(List<String> persistedFields) {
    this.persistedFields = persistedFields;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JobDetails jobDetails = (JobDetails) o;
    return Objects.equals(this.id, jobDetails.id) &&
        Objects.equals(this.adminId, jobDetails.adminId) &&
        Objects.equals(this.workUnitsCount, jobDetails.workUnitsCount) &&
        Objects.equals(this.name, jobDetails.name) &&
        Objects.equals(this.status, jobDetails.status) &&
        Objects.equals(this.meta, jobDetails.meta) &&
        Objects.equals(this.updatedAt, jobDetails.updatedAt) &&
        Objects.equals(this.persistedFields, jobDetails.persistedFields);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, adminId, workUnitsCount, name, status, meta, updatedAt, persistedFields);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JobDetails {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    adminId: ").append(toIndentedString(adminId)).append("\n");
    sb.append("    workUnitsCount: ").append(toIndentedString(workUnitsCount)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    meta: ").append(toIndentedString(meta)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    persistedFields: ").append(toIndentedString(persistedFields)).append("\n");
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

