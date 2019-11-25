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
 * SystemInsightsBrowserPlugins
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-11-21T20:17:34.763Z")
public class SystemInsightsBrowserPlugins {
  @SerializedName("collection_time")
  private String collectionTime = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("development_region")
  private String developmentRegion = null;

  @SerializedName("disabled")
  private Integer disabled = null;

  @SerializedName("identifier")
  private String identifier = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("native")
  private Integer _native = null;

  @SerializedName("path")
  private String path = null;

  @SerializedName("sdk")
  private String sdk = null;

  @SerializedName("system_id")
  private String systemId = null;

  @SerializedName("uid")
  private String uid = null;

  @SerializedName("version")
  private String version = null;

  public SystemInsightsBrowserPlugins collectionTime(String collectionTime) {
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

  public SystemInsightsBrowserPlugins description(String description) {
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

  public SystemInsightsBrowserPlugins developmentRegion(String developmentRegion) {
    this.developmentRegion = developmentRegion;
    return this;
  }

   /**
   * Get developmentRegion
   * @return developmentRegion
  **/
  @ApiModelProperty(value = "")
  public String getDevelopmentRegion() {
    return developmentRegion;
  }

  public void setDevelopmentRegion(String developmentRegion) {
    this.developmentRegion = developmentRegion;
  }

  public SystemInsightsBrowserPlugins disabled(Integer disabled) {
    this.disabled = disabled;
    return this;
  }

   /**
   * Get disabled
   * @return disabled
  **/
  @ApiModelProperty(value = "")
  public Integer getDisabled() {
    return disabled;
  }

  public void setDisabled(Integer disabled) {
    this.disabled = disabled;
  }

  public SystemInsightsBrowserPlugins identifier(String identifier) {
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

  public SystemInsightsBrowserPlugins name(String name) {
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

  public SystemInsightsBrowserPlugins _native(Integer _native) {
    this._native = _native;
    return this;
  }

   /**
   * Get _native
   * @return _native
  **/
  @ApiModelProperty(value = "")
  public Integer getNative() {
    return _native;
  }

  public void setNative(Integer _native) {
    this._native = _native;
  }

  public SystemInsightsBrowserPlugins path(String path) {
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

  public SystemInsightsBrowserPlugins sdk(String sdk) {
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

  public SystemInsightsBrowserPlugins systemId(String systemId) {
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

  public SystemInsightsBrowserPlugins uid(String uid) {
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

  public SystemInsightsBrowserPlugins version(String version) {
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
    SystemInsightsBrowserPlugins systemInsightsBrowserPlugins = (SystemInsightsBrowserPlugins) o;
    return Objects.equals(this.collectionTime, systemInsightsBrowserPlugins.collectionTime) &&
        Objects.equals(this.description, systemInsightsBrowserPlugins.description) &&
        Objects.equals(this.developmentRegion, systemInsightsBrowserPlugins.developmentRegion) &&
        Objects.equals(this.disabled, systemInsightsBrowserPlugins.disabled) &&
        Objects.equals(this.identifier, systemInsightsBrowserPlugins.identifier) &&
        Objects.equals(this.name, systemInsightsBrowserPlugins.name) &&
        Objects.equals(this._native, systemInsightsBrowserPlugins._native) &&
        Objects.equals(this.path, systemInsightsBrowserPlugins.path) &&
        Objects.equals(this.sdk, systemInsightsBrowserPlugins.sdk) &&
        Objects.equals(this.systemId, systemInsightsBrowserPlugins.systemId) &&
        Objects.equals(this.uid, systemInsightsBrowserPlugins.uid) &&
        Objects.equals(this.version, systemInsightsBrowserPlugins.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(collectionTime, description, developmentRegion, disabled, identifier, name, _native, path, sdk, systemId, uid, version);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemInsightsBrowserPlugins {\n");
    
    sb.append("    collectionTime: ").append(toIndentedString(collectionTime)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    developmentRegion: ").append(toIndentedString(developmentRegion)).append("\n");
    sb.append("    disabled: ").append(toIndentedString(disabled)).append("\n");
    sb.append("    identifier: ").append(toIndentedString(identifier)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    _native: ").append(toIndentedString(_native)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    sdk: ").append(toIndentedString(sdk)).append("\n");
    sb.append("    systemId: ").append(toIndentedString(systemId)).append("\n");
    sb.append("    uid: ").append(toIndentedString(uid)).append("\n");
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

