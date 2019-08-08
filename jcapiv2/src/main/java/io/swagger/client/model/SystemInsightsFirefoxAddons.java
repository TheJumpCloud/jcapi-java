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
 * SystemInsightsFirefoxAddons
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-08-08T00:50:10.834Z")
public class SystemInsightsFirefoxAddons {
  @SerializedName("uid")
  private String uid = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("identifier")
  private String identifier = null;

  @SerializedName("creator")
  private String creator = null;

  @SerializedName("type")
  private String type = null;

  @SerializedName("version")
  private String version = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("source_url")
  private String sourceUrl = null;

  @SerializedName("visible")
  private Integer visible = null;

  @SerializedName("active")
  private Integer active = null;

  @SerializedName("disabled")
  private Integer disabled = null;

  @SerializedName("autoupdate")
  private Integer autoupdate = null;

  @SerializedName("location")
  private String location = null;

  @SerializedName("path")
  private String path = null;

  @SerializedName("jc_collection_time")
  private String jcCollectionTime = null;

  @SerializedName("jc_system_id")
  private String jcSystemId = null;

  @SerializedName("jc_organization_id")
  private String jcOrganizationId = null;

  public SystemInsightsFirefoxAddons uid(String uid) {
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

  public SystemInsightsFirefoxAddons name(String name) {
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

  public SystemInsightsFirefoxAddons identifier(String identifier) {
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

  public SystemInsightsFirefoxAddons creator(String creator) {
    this.creator = creator;
    return this;
  }

   /**
   * Get creator
   * @return creator
  **/
  @ApiModelProperty(value = "")
  public String getCreator() {
    return creator;
  }

  public void setCreator(String creator) {
    this.creator = creator;
  }

  public SystemInsightsFirefoxAddons type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(value = "")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public SystemInsightsFirefoxAddons version(String version) {
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

  public SystemInsightsFirefoxAddons description(String description) {
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

  public SystemInsightsFirefoxAddons sourceUrl(String sourceUrl) {
    this.sourceUrl = sourceUrl;
    return this;
  }

   /**
   * Get sourceUrl
   * @return sourceUrl
  **/
  @ApiModelProperty(value = "")
  public String getSourceUrl() {
    return sourceUrl;
  }

  public void setSourceUrl(String sourceUrl) {
    this.sourceUrl = sourceUrl;
  }

  public SystemInsightsFirefoxAddons visible(Integer visible) {
    this.visible = visible;
    return this;
  }

   /**
   * Get visible
   * @return visible
  **/
  @ApiModelProperty(value = "")
  public Integer getVisible() {
    return visible;
  }

  public void setVisible(Integer visible) {
    this.visible = visible;
  }

  public SystemInsightsFirefoxAddons active(Integer active) {
    this.active = active;
    return this;
  }

   /**
   * Get active
   * @return active
  **/
  @ApiModelProperty(value = "")
  public Integer getActive() {
    return active;
  }

  public void setActive(Integer active) {
    this.active = active;
  }

  public SystemInsightsFirefoxAddons disabled(Integer disabled) {
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

  public SystemInsightsFirefoxAddons autoupdate(Integer autoupdate) {
    this.autoupdate = autoupdate;
    return this;
  }

   /**
   * Get autoupdate
   * @return autoupdate
  **/
  @ApiModelProperty(value = "")
  public Integer getAutoupdate() {
    return autoupdate;
  }

  public void setAutoupdate(Integer autoupdate) {
    this.autoupdate = autoupdate;
  }

  public SystemInsightsFirefoxAddons location(String location) {
    this.location = location;
    return this;
  }

   /**
   * Get location
   * @return location
  **/
  @ApiModelProperty(value = "")
  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public SystemInsightsFirefoxAddons path(String path) {
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

  public SystemInsightsFirefoxAddons jcCollectionTime(String jcCollectionTime) {
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

  public SystemInsightsFirefoxAddons jcSystemId(String jcSystemId) {
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

  public SystemInsightsFirefoxAddons jcOrganizationId(String jcOrganizationId) {
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
    SystemInsightsFirefoxAddons systemInsightsFirefoxAddons = (SystemInsightsFirefoxAddons) o;
    return Objects.equals(this.uid, systemInsightsFirefoxAddons.uid) &&
        Objects.equals(this.name, systemInsightsFirefoxAddons.name) &&
        Objects.equals(this.identifier, systemInsightsFirefoxAddons.identifier) &&
        Objects.equals(this.creator, systemInsightsFirefoxAddons.creator) &&
        Objects.equals(this.type, systemInsightsFirefoxAddons.type) &&
        Objects.equals(this.version, systemInsightsFirefoxAddons.version) &&
        Objects.equals(this.description, systemInsightsFirefoxAddons.description) &&
        Objects.equals(this.sourceUrl, systemInsightsFirefoxAddons.sourceUrl) &&
        Objects.equals(this.visible, systemInsightsFirefoxAddons.visible) &&
        Objects.equals(this.active, systemInsightsFirefoxAddons.active) &&
        Objects.equals(this.disabled, systemInsightsFirefoxAddons.disabled) &&
        Objects.equals(this.autoupdate, systemInsightsFirefoxAddons.autoupdate) &&
        Objects.equals(this.location, systemInsightsFirefoxAddons.location) &&
        Objects.equals(this.path, systemInsightsFirefoxAddons.path) &&
        Objects.equals(this.jcCollectionTime, systemInsightsFirefoxAddons.jcCollectionTime) &&
        Objects.equals(this.jcSystemId, systemInsightsFirefoxAddons.jcSystemId) &&
        Objects.equals(this.jcOrganizationId, systemInsightsFirefoxAddons.jcOrganizationId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uid, name, identifier, creator, type, version, description, sourceUrl, visible, active, disabled, autoupdate, location, path, jcCollectionTime, jcSystemId, jcOrganizationId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemInsightsFirefoxAddons {\n");
    
    sb.append("    uid: ").append(toIndentedString(uid)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    identifier: ").append(toIndentedString(identifier)).append("\n");
    sb.append("    creator: ").append(toIndentedString(creator)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    sourceUrl: ").append(toIndentedString(sourceUrl)).append("\n");
    sb.append("    visible: ").append(toIndentedString(visible)).append("\n");
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    disabled: ").append(toIndentedString(disabled)).append("\n");
    sb.append("    autoupdate: ").append(toIndentedString(autoupdate)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
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

