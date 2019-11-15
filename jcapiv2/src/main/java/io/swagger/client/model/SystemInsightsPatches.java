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
 * SystemInsightsPatches
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-11-15T20:11:23.142Z")
public class SystemInsightsPatches {
  @SerializedName("caption")
  private String caption = null;

  @SerializedName("collection_time")
  private String collectionTime = null;

  @SerializedName("csname")
  private String csname = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("fix_comments")
  private String fixComments = null;

  @SerializedName("hotfix_id")
  private String hotfixId = null;

  @SerializedName("install_date")
  private String installDate = null;

  @SerializedName("installed_by")
  private String installedBy = null;

  @SerializedName("installed_on")
  private String installedOn = null;

  @SerializedName("system_id")
  private String systemId = null;

  public SystemInsightsPatches caption(String caption) {
    this.caption = caption;
    return this;
  }

   /**
   * Get caption
   * @return caption
  **/
  @ApiModelProperty(value = "")
  public String getCaption() {
    return caption;
  }

  public void setCaption(String caption) {
    this.caption = caption;
  }

  public SystemInsightsPatches collectionTime(String collectionTime) {
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

  public SystemInsightsPatches csname(String csname) {
    this.csname = csname;
    return this;
  }

   /**
   * Get csname
   * @return csname
  **/
  @ApiModelProperty(value = "")
  public String getCsname() {
    return csname;
  }

  public void setCsname(String csname) {
    this.csname = csname;
  }

  public SystemInsightsPatches description(String description) {
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

  public SystemInsightsPatches fixComments(String fixComments) {
    this.fixComments = fixComments;
    return this;
  }

   /**
   * Get fixComments
   * @return fixComments
  **/
  @ApiModelProperty(value = "")
  public String getFixComments() {
    return fixComments;
  }

  public void setFixComments(String fixComments) {
    this.fixComments = fixComments;
  }

  public SystemInsightsPatches hotfixId(String hotfixId) {
    this.hotfixId = hotfixId;
    return this;
  }

   /**
   * Get hotfixId
   * @return hotfixId
  **/
  @ApiModelProperty(value = "")
  public String getHotfixId() {
    return hotfixId;
  }

  public void setHotfixId(String hotfixId) {
    this.hotfixId = hotfixId;
  }

  public SystemInsightsPatches installDate(String installDate) {
    this.installDate = installDate;
    return this;
  }

   /**
   * Get installDate
   * @return installDate
  **/
  @ApiModelProperty(value = "")
  public String getInstallDate() {
    return installDate;
  }

  public void setInstallDate(String installDate) {
    this.installDate = installDate;
  }

  public SystemInsightsPatches installedBy(String installedBy) {
    this.installedBy = installedBy;
    return this;
  }

   /**
   * Get installedBy
   * @return installedBy
  **/
  @ApiModelProperty(value = "")
  public String getInstalledBy() {
    return installedBy;
  }

  public void setInstalledBy(String installedBy) {
    this.installedBy = installedBy;
  }

  public SystemInsightsPatches installedOn(String installedOn) {
    this.installedOn = installedOn;
    return this;
  }

   /**
   * Get installedOn
   * @return installedOn
  **/
  @ApiModelProperty(value = "")
  public String getInstalledOn() {
    return installedOn;
  }

  public void setInstalledOn(String installedOn) {
    this.installedOn = installedOn;
  }

  public SystemInsightsPatches systemId(String systemId) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SystemInsightsPatches systemInsightsPatches = (SystemInsightsPatches) o;
    return Objects.equals(this.caption, systemInsightsPatches.caption) &&
        Objects.equals(this.collectionTime, systemInsightsPatches.collectionTime) &&
        Objects.equals(this.csname, systemInsightsPatches.csname) &&
        Objects.equals(this.description, systemInsightsPatches.description) &&
        Objects.equals(this.fixComments, systemInsightsPatches.fixComments) &&
        Objects.equals(this.hotfixId, systemInsightsPatches.hotfixId) &&
        Objects.equals(this.installDate, systemInsightsPatches.installDate) &&
        Objects.equals(this.installedBy, systemInsightsPatches.installedBy) &&
        Objects.equals(this.installedOn, systemInsightsPatches.installedOn) &&
        Objects.equals(this.systemId, systemInsightsPatches.systemId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(caption, collectionTime, csname, description, fixComments, hotfixId, installDate, installedBy, installedOn, systemId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemInsightsPatches {\n");
    
    sb.append("    caption: ").append(toIndentedString(caption)).append("\n");
    sb.append("    collectionTime: ").append(toIndentedString(collectionTime)).append("\n");
    sb.append("    csname: ").append(toIndentedString(csname)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    fixComments: ").append(toIndentedString(fixComments)).append("\n");
    sb.append("    hotfixId: ").append(toIndentedString(hotfixId)).append("\n");
    sb.append("    installDate: ").append(toIndentedString(installDate)).append("\n");
    sb.append("    installedBy: ").append(toIndentedString(installedBy)).append("\n");
    sb.append("    installedOn: ").append(toIndentedString(installedOn)).append("\n");
    sb.append("    systemId: ").append(toIndentedString(systemId)).append("\n");
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

