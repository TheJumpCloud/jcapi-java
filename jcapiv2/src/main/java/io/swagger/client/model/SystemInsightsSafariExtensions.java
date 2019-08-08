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

/**
 * SystemInsightsSafariExtensions
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-08-08T01:17:54.297Z")
public class SystemInsightsSafariExtensions {
  @SerializedName("uid")
  private String uid = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("identifier")
  private String identifier = null;

  @SerializedName("version")
  private String version = null;

  @SerializedName("sdk")
  private String sdk = null;

  @SerializedName("update_url")
  private String updateUrl = null;

  @SerializedName("author")
  private String author = null;

  @SerializedName("developer_id")
  private String developerId = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("path")
  private String path = null;

  @SerializedName("jc_collection_time")
  private String jcCollectionTime = null;

  @SerializedName("jc_system_id")
  private String jcSystemId = null;

  @SerializedName("jc_organization_id")
  private String jcOrganizationId = null;

  public SystemInsightsSafariExtensions uid(String uid) {
    this.uid = uid;
    return this;
  }

   /**
   * Get uid
   * @return uid
  **/
  @ApiModelProperty(value = "")
  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }

  public SystemInsightsSafariExtensions name(String name) {
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

  public SystemInsightsSafariExtensions identifier(String identifier) {
    this.identifier = identifier;
    return this;
  }

   /**
   * Get identifier
   * @return identifier
  **/
  @ApiModelProperty(value = "")
  public String getIdentifier() {
    return identifier;
  }

  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }

  public SystemInsightsSafariExtensions version(String version) {
    this.version = version;
    return this;
  }

   /**
   * Get version
   * @return version
  **/
  @ApiModelProperty(value = "")
  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public SystemInsightsSafariExtensions sdk(String sdk) {
    this.sdk = sdk;
    return this;
  }

   /**
   * Get sdk
   * @return sdk
  **/
  @ApiModelProperty(value = "")
  public String getSdk() {
    return sdk;
  }

  public void setSdk(String sdk) {
    this.sdk = sdk;
  }

  public SystemInsightsSafariExtensions updateUrl(String updateUrl) {
    this.updateUrl = updateUrl;
    return this;
  }

   /**
   * Get updateUrl
   * @return updateUrl
  **/
  @ApiModelProperty(value = "")
  public String getUpdateUrl() {
    return updateUrl;
  }

  public void setUpdateUrl(String updateUrl) {
    this.updateUrl = updateUrl;
  }

  public SystemInsightsSafariExtensions author(String author) {
    this.author = author;
    return this;
  }

   /**
   * Get author
   * @return author
  **/
  @ApiModelProperty(value = "")
  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public SystemInsightsSafariExtensions developerId(String developerId) {
    this.developerId = developerId;
    return this;
  }

   /**
   * Get developerId
   * @return developerId
  **/
  @ApiModelProperty(value = "")
  public String getDeveloperId() {
    return developerId;
  }

  public void setDeveloperId(String developerId) {
    this.developerId = developerId;
  }

  public SystemInsightsSafariExtensions description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(value = "")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public SystemInsightsSafariExtensions path(String path) {
    this.path = path;
    return this;
  }

   /**
   * Get path
   * @return path
  **/
  @ApiModelProperty(value = "")
  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public SystemInsightsSafariExtensions jcCollectionTime(String jcCollectionTime) {
    this.jcCollectionTime = jcCollectionTime;
    return this;
  }

   /**
   * Get jcCollectionTime
   * @return jcCollectionTime
  **/
  @ApiModelProperty(value = "")
  public String getJcCollectionTime() {
    return jcCollectionTime;
  }

  public void setJcCollectionTime(String jcCollectionTime) {
    this.jcCollectionTime = jcCollectionTime;
  }

  public SystemInsightsSafariExtensions jcSystemId(String jcSystemId) {
    this.jcSystemId = jcSystemId;
    return this;
  }

   /**
   * Get jcSystemId
   * @return jcSystemId
  **/
  @ApiModelProperty(value = "")
  public String getJcSystemId() {
    return jcSystemId;
  }

  public void setJcSystemId(String jcSystemId) {
    this.jcSystemId = jcSystemId;
  }

  public SystemInsightsSafariExtensions jcOrganizationId(String jcOrganizationId) {
    this.jcOrganizationId = jcOrganizationId;
    return this;
  }

   /**
   * Get jcOrganizationId
   * @return jcOrganizationId
  **/
  @ApiModelProperty(value = "")
  public String getJcOrganizationId() {
    return jcOrganizationId;
  }

  public void setJcOrganizationId(String jcOrganizationId) {
    this.jcOrganizationId = jcOrganizationId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SystemInsightsSafariExtensions systemInsightsSafariExtensions = (SystemInsightsSafariExtensions) o;
    return Objects.equals(this.uid, systemInsightsSafariExtensions.uid) &&
        Objects.equals(this.name, systemInsightsSafariExtensions.name) &&
        Objects.equals(this.identifier, systemInsightsSafariExtensions.identifier) &&
        Objects.equals(this.version, systemInsightsSafariExtensions.version) &&
        Objects.equals(this.sdk, systemInsightsSafariExtensions.sdk) &&
        Objects.equals(this.updateUrl, systemInsightsSafariExtensions.updateUrl) &&
        Objects.equals(this.author, systemInsightsSafariExtensions.author) &&
        Objects.equals(this.developerId, systemInsightsSafariExtensions.developerId) &&
        Objects.equals(this.description, systemInsightsSafariExtensions.description) &&
        Objects.equals(this.path, systemInsightsSafariExtensions.path) &&
        Objects.equals(this.jcCollectionTime, systemInsightsSafariExtensions.jcCollectionTime) &&
        Objects.equals(this.jcSystemId, systemInsightsSafariExtensions.jcSystemId) &&
        Objects.equals(this.jcOrganizationId, systemInsightsSafariExtensions.jcOrganizationId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uid, name, identifier, version, sdk, updateUrl, author, developerId, description, path, jcCollectionTime, jcSystemId, jcOrganizationId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemInsightsSafariExtensions {\n");
    
    sb.append("    uid: ").append(toIndentedString(uid)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    identifier: ").append(toIndentedString(identifier)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    sdk: ").append(toIndentedString(sdk)).append("\n");
    sb.append("    updateUrl: ").append(toIndentedString(updateUrl)).append("\n");
    sb.append("    author: ").append(toIndentedString(author)).append("\n");
    sb.append("    developerId: ").append(toIndentedString(developerId)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    jcCollectionTime: ").append(toIndentedString(jcCollectionTime)).append("\n");
    sb.append("    jcSystemId: ").append(toIndentedString(jcSystemId)).append("\n");
    sb.append("    jcOrganizationId: ").append(toIndentedString(jcOrganizationId)).append("\n");
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

