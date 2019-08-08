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
 * SystemInsightsChromeExtensions
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-08-08T01:09:43.537Z")
public class SystemInsightsChromeExtensions {
  @SerializedName("uid")
  private String uid = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("identifier")
  private String identifier = null;

  @SerializedName("version")
  private String version = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("locale")
  private String locale = null;

  @SerializedName("update_url")
  private String updateUrl = null;

  @SerializedName("author")
  private String author = null;

  @SerializedName("persistent")
  private Integer persistent = null;

  @SerializedName("path")
  private String path = null;

  @SerializedName("permissions")
  private String permissions = null;

  @SerializedName("jc_collection_time")
  private String jcCollectionTime = null;

  @SerializedName("jc_system_id")
  private String jcSystemId = null;

  @SerializedName("jc_organization_id")
  private String jcOrganizationId = null;

  public SystemInsightsChromeExtensions uid(String uid) {
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

  public SystemInsightsChromeExtensions name(String name) {
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

  public SystemInsightsChromeExtensions identifier(String identifier) {
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

  public SystemInsightsChromeExtensions version(String version) {
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

  public SystemInsightsChromeExtensions description(String description) {
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

  public SystemInsightsChromeExtensions locale(String locale) {
    this.locale = locale;
    return this;
  }

   /**
   * Get locale
   * @return locale
  **/
  @ApiModelProperty(value = "")
  public String getLocale() {
    return locale;
  }

  public void setLocale(String locale) {
    this.locale = locale;
  }

  public SystemInsightsChromeExtensions updateUrl(String updateUrl) {
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

  public SystemInsightsChromeExtensions author(String author) {
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

  public SystemInsightsChromeExtensions persistent(Integer persistent) {
    this.persistent = persistent;
    return this;
  }

   /**
   * Get persistent
   * @return persistent
  **/
  @ApiModelProperty(value = "")
  public Integer getPersistent() {
    return persistent;
  }

  public void setPersistent(Integer persistent) {
    this.persistent = persistent;
  }

  public SystemInsightsChromeExtensions path(String path) {
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

  public SystemInsightsChromeExtensions permissions(String permissions) {
    this.permissions = permissions;
    return this;
  }

   /**
   * Get permissions
   * @return permissions
  **/
  @ApiModelProperty(value = "")
  public String getPermissions() {
    return permissions;
  }

  public void setPermissions(String permissions) {
    this.permissions = permissions;
  }

  public SystemInsightsChromeExtensions jcCollectionTime(String jcCollectionTime) {
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

  public SystemInsightsChromeExtensions jcSystemId(String jcSystemId) {
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

  public SystemInsightsChromeExtensions jcOrganizationId(String jcOrganizationId) {
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
    SystemInsightsChromeExtensions systemInsightsChromeExtensions = (SystemInsightsChromeExtensions) o;
    return Objects.equals(this.uid, systemInsightsChromeExtensions.uid) &&
        Objects.equals(this.name, systemInsightsChromeExtensions.name) &&
        Objects.equals(this.identifier, systemInsightsChromeExtensions.identifier) &&
        Objects.equals(this.version, systemInsightsChromeExtensions.version) &&
        Objects.equals(this.description, systemInsightsChromeExtensions.description) &&
        Objects.equals(this.locale, systemInsightsChromeExtensions.locale) &&
        Objects.equals(this.updateUrl, systemInsightsChromeExtensions.updateUrl) &&
        Objects.equals(this.author, systemInsightsChromeExtensions.author) &&
        Objects.equals(this.persistent, systemInsightsChromeExtensions.persistent) &&
        Objects.equals(this.path, systemInsightsChromeExtensions.path) &&
        Objects.equals(this.permissions, systemInsightsChromeExtensions.permissions) &&
        Objects.equals(this.jcCollectionTime, systemInsightsChromeExtensions.jcCollectionTime) &&
        Objects.equals(this.jcSystemId, systemInsightsChromeExtensions.jcSystemId) &&
        Objects.equals(this.jcOrganizationId, systemInsightsChromeExtensions.jcOrganizationId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uid, name, identifier, version, description, locale, updateUrl, author, persistent, path, permissions, jcCollectionTime, jcSystemId, jcOrganizationId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemInsightsChromeExtensions {\n");
    
    sb.append("    uid: ").append(toIndentedString(uid)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    identifier: ").append(toIndentedString(identifier)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    locale: ").append(toIndentedString(locale)).append("\n");
    sb.append("    updateUrl: ").append(toIndentedString(updateUrl)).append("\n");
    sb.append("    author: ").append(toIndentedString(author)).append("\n");
    sb.append("    persistent: ").append(toIndentedString(persistent)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    permissions: ").append(toIndentedString(permissions)).append("\n");
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

