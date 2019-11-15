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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-11-15T20:11:23.142Z")
public class SystemInsightsChromeExtensions {
  @SerializedName("author")
  private String author = null;

  @SerializedName("collection_time")
  private String collectionTime = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("identifier")
  private String identifier = null;

  @SerializedName("locale")
  private String locale = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("path")
  private String path = null;

  @SerializedName("permissions")
  private String permissions = null;

  @SerializedName("persistent")
  private Integer persistent = null;

  @SerializedName("system_id")
  private String systemId = null;

  @SerializedName("uid")
  private String uid = null;

  @SerializedName("update_url")
  private String updateUrl = null;

  @SerializedName("version")
  private String version = null;

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

  public SystemInsightsChromeExtensions collectionTime(String collectionTime) {
    this.collectionTime = collectionTime;
    return this;
  }

   /**
   * Get collectionTime
   * @return collectionTime
  **/
  @ApiModelProperty(value = "")
  public String getCollectionTime() {
    return collectionTime;
  }

  public void setCollectionTime(String collectionTime) {
    this.collectionTime = collectionTime;
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

  public SystemInsightsChromeExtensions systemId(String systemId) {
    this.systemId = systemId;
    return this;
  }

   /**
   * Get systemId
   * @return systemId
  **/
  @ApiModelProperty(value = "")
  public String getSystemId() {
    return systemId;
  }

  public void setSystemId(String systemId) {
    this.systemId = systemId;
  }

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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SystemInsightsChromeExtensions systemInsightsChromeExtensions = (SystemInsightsChromeExtensions) o;
    return Objects.equals(this.author, systemInsightsChromeExtensions.author) &&
        Objects.equals(this.collectionTime, systemInsightsChromeExtensions.collectionTime) &&
        Objects.equals(this.description, systemInsightsChromeExtensions.description) &&
        Objects.equals(this.identifier, systemInsightsChromeExtensions.identifier) &&
        Objects.equals(this.locale, systemInsightsChromeExtensions.locale) &&
        Objects.equals(this.name, systemInsightsChromeExtensions.name) &&
        Objects.equals(this.path, systemInsightsChromeExtensions.path) &&
        Objects.equals(this.permissions, systemInsightsChromeExtensions.permissions) &&
        Objects.equals(this.persistent, systemInsightsChromeExtensions.persistent) &&
        Objects.equals(this.systemId, systemInsightsChromeExtensions.systemId) &&
        Objects.equals(this.uid, systemInsightsChromeExtensions.uid) &&
        Objects.equals(this.updateUrl, systemInsightsChromeExtensions.updateUrl) &&
        Objects.equals(this.version, systemInsightsChromeExtensions.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(author, collectionTime, description, identifier, locale, name, path, permissions, persistent, systemId, uid, updateUrl, version);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemInsightsChromeExtensions {\n");
    
    sb.append("    author: ").append(toIndentedString(author)).append("\n");
    sb.append("    collectionTime: ").append(toIndentedString(collectionTime)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    identifier: ").append(toIndentedString(identifier)).append("\n");
    sb.append("    locale: ").append(toIndentedString(locale)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    permissions: ").append(toIndentedString(permissions)).append("\n");
    sb.append("    persistent: ").append(toIndentedString(persistent)).append("\n");
    sb.append("    systemId: ").append(toIndentedString(systemId)).append("\n");
    sb.append("    uid: ").append(toIndentedString(uid)).append("\n");
    sb.append("    updateUrl: ").append(toIndentedString(updateUrl)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
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

