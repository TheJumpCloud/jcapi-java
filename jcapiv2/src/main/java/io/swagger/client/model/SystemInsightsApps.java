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
import java.math.BigDecimal;

/**
 * SystemInsightsApps
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-09-23T20:31:04.187Z")
public class SystemInsightsApps {
  @SerializedName("applescript_enabled")
  private String applescriptEnabled = null;

  @SerializedName("bundle_executable")
  private String bundleExecutable = null;

  @SerializedName("bundle_identifier")
  private String bundleIdentifier = null;

  @SerializedName("bundle_name")
  private String bundleName = null;

  @SerializedName("bundle_package_type")
  private String bundlePackageType = null;

  @SerializedName("bundle_short_version")
  private String bundleShortVersion = null;

  @SerializedName("bundle_version")
  private String bundleVersion = null;

  @SerializedName("category")
  private String category = null;

  @SerializedName("collection_time")
  private String collectionTime = null;

  @SerializedName("compiler")
  private String compiler = null;

  @SerializedName("copyright")
  private String copyright = null;

  @SerializedName("development_region")
  private String developmentRegion = null;

  @SerializedName("display_name")
  private String displayName = null;

  @SerializedName("element")
  private String element = null;

  @SerializedName("environment")
  private String environment = null;

  @SerializedName("info_string")
  private String infoString = null;

  @SerializedName("last_opened_time")
  private BigDecimal lastOpenedTime = null;

  @SerializedName("minimum_system_version")
  private String minimumSystemVersion = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("path")
  private String path = null;

  @SerializedName("system_id")
  private String systemId = null;

  public SystemInsightsApps applescriptEnabled(String applescriptEnabled) {
    this.applescriptEnabled = applescriptEnabled;
    return this;
  }

   /**
   * Get applescriptEnabled
   * @return applescriptEnabled
  **/
  @ApiModelProperty(value = "")
  public String getApplescriptEnabled() {
    return applescriptEnabled;
  }

  public void setApplescriptEnabled(String applescriptEnabled) {
    this.applescriptEnabled = applescriptEnabled;
  }

  public SystemInsightsApps bundleExecutable(String bundleExecutable) {
    this.bundleExecutable = bundleExecutable;
    return this;
  }

   /**
   * Get bundleExecutable
   * @return bundleExecutable
  **/
  @ApiModelProperty(value = "")
  public String getBundleExecutable() {
    return bundleExecutable;
  }

  public void setBundleExecutable(String bundleExecutable) {
    this.bundleExecutable = bundleExecutable;
  }

  public SystemInsightsApps bundleIdentifier(String bundleIdentifier) {
    this.bundleIdentifier = bundleIdentifier;
    return this;
  }

   /**
   * Get bundleIdentifier
   * @return bundleIdentifier
  **/
  @ApiModelProperty(value = "")
  public String getBundleIdentifier() {
    return bundleIdentifier;
  }

  public void setBundleIdentifier(String bundleIdentifier) {
    this.bundleIdentifier = bundleIdentifier;
  }

  public SystemInsightsApps bundleName(String bundleName) {
    this.bundleName = bundleName;
    return this;
  }

   /**
   * Get bundleName
   * @return bundleName
  **/
  @ApiModelProperty(value = "")
  public String getBundleName() {
    return bundleName;
  }

  public void setBundleName(String bundleName) {
    this.bundleName = bundleName;
  }

  public SystemInsightsApps bundlePackageType(String bundlePackageType) {
    this.bundlePackageType = bundlePackageType;
    return this;
  }

   /**
   * Get bundlePackageType
   * @return bundlePackageType
  **/
  @ApiModelProperty(value = "")
  public String getBundlePackageType() {
    return bundlePackageType;
  }

  public void setBundlePackageType(String bundlePackageType) {
    this.bundlePackageType = bundlePackageType;
  }

  public SystemInsightsApps bundleShortVersion(String bundleShortVersion) {
    this.bundleShortVersion = bundleShortVersion;
    return this;
  }

   /**
   * Get bundleShortVersion
   * @return bundleShortVersion
  **/
  @ApiModelProperty(value = "")
  public String getBundleShortVersion() {
    return bundleShortVersion;
  }

  public void setBundleShortVersion(String bundleShortVersion) {
    this.bundleShortVersion = bundleShortVersion;
  }

  public SystemInsightsApps bundleVersion(String bundleVersion) {
    this.bundleVersion = bundleVersion;
    return this;
  }

   /**
   * Get bundleVersion
   * @return bundleVersion
  **/
  @ApiModelProperty(value = "")
  public String getBundleVersion() {
    return bundleVersion;
  }

  public void setBundleVersion(String bundleVersion) {
    this.bundleVersion = bundleVersion;
  }

  public SystemInsightsApps category(String category) {
    this.category = category;
    return this;
  }

   /**
   * Get category
   * @return category
  **/
  @ApiModelProperty(value = "")
  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public SystemInsightsApps collectionTime(String collectionTime) {
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

  public SystemInsightsApps compiler(String compiler) {
    this.compiler = compiler;
    return this;
  }

   /**
   * Get compiler
   * @return compiler
  **/
  @ApiModelProperty(value = "")
  public String getCompiler() {
    return compiler;
  }

  public void setCompiler(String compiler) {
    this.compiler = compiler;
  }

  public SystemInsightsApps copyright(String copyright) {
    this.copyright = copyright;
    return this;
  }

   /**
   * Get copyright
   * @return copyright
  **/
  @ApiModelProperty(value = "")
  public String getCopyright() {
    return copyright;
  }

  public void setCopyright(String copyright) {
    this.copyright = copyright;
  }

  public SystemInsightsApps developmentRegion(String developmentRegion) {
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

  public SystemInsightsApps displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }

   /**
   * Get displayName
   * @return displayName
  **/
  @ApiModelProperty(value = "")
  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public SystemInsightsApps element(String element) {
    this.element = element;
    return this;
  }

   /**
   * Get element
   * @return element
  **/
  @ApiModelProperty(value = "")
  public String getElement() {
    return element;
  }

  public void setElement(String element) {
    this.element = element;
  }

  public SystemInsightsApps environment(String environment) {
    this.environment = environment;
    return this;
  }

   /**
   * Get environment
   * @return environment
  **/
  @ApiModelProperty(value = "")
  public String getEnvironment() {
    return environment;
  }

  public void setEnvironment(String environment) {
    this.environment = environment;
  }

  public SystemInsightsApps infoString(String infoString) {
    this.infoString = infoString;
    return this;
  }

   /**
   * Get infoString
   * @return infoString
  **/
  @ApiModelProperty(value = "")
  public String getInfoString() {
    return infoString;
  }

  public void setInfoString(String infoString) {
    this.infoString = infoString;
  }

  public SystemInsightsApps lastOpenedTime(BigDecimal lastOpenedTime) {
    this.lastOpenedTime = lastOpenedTime;
    return this;
  }

   /**
   * Get lastOpenedTime
   * @return lastOpenedTime
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getLastOpenedTime() {
    return lastOpenedTime;
  }

  public void setLastOpenedTime(BigDecimal lastOpenedTime) {
    this.lastOpenedTime = lastOpenedTime;
  }

  public SystemInsightsApps minimumSystemVersion(String minimumSystemVersion) {
    this.minimumSystemVersion = minimumSystemVersion;
    return this;
  }

   /**
   * Get minimumSystemVersion
   * @return minimumSystemVersion
  **/
  @ApiModelProperty(value = "")
  public String getMinimumSystemVersion() {
    return minimumSystemVersion;
  }

  public void setMinimumSystemVersion(String minimumSystemVersion) {
    this.minimumSystemVersion = minimumSystemVersion;
  }

  public SystemInsightsApps name(String name) {
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

  public SystemInsightsApps path(String path) {
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

  public SystemInsightsApps systemId(String systemId) {
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
    SystemInsightsApps systemInsightsApps = (SystemInsightsApps) o;
    return Objects.equals(this.applescriptEnabled, systemInsightsApps.applescriptEnabled) &&
        Objects.equals(this.bundleExecutable, systemInsightsApps.bundleExecutable) &&
        Objects.equals(this.bundleIdentifier, systemInsightsApps.bundleIdentifier) &&
        Objects.equals(this.bundleName, systemInsightsApps.bundleName) &&
        Objects.equals(this.bundlePackageType, systemInsightsApps.bundlePackageType) &&
        Objects.equals(this.bundleShortVersion, systemInsightsApps.bundleShortVersion) &&
        Objects.equals(this.bundleVersion, systemInsightsApps.bundleVersion) &&
        Objects.equals(this.category, systemInsightsApps.category) &&
        Objects.equals(this.collectionTime, systemInsightsApps.collectionTime) &&
        Objects.equals(this.compiler, systemInsightsApps.compiler) &&
        Objects.equals(this.copyright, systemInsightsApps.copyright) &&
        Objects.equals(this.developmentRegion, systemInsightsApps.developmentRegion) &&
        Objects.equals(this.displayName, systemInsightsApps.displayName) &&
        Objects.equals(this.element, systemInsightsApps.element) &&
        Objects.equals(this.environment, systemInsightsApps.environment) &&
        Objects.equals(this.infoString, systemInsightsApps.infoString) &&
        Objects.equals(this.lastOpenedTime, systemInsightsApps.lastOpenedTime) &&
        Objects.equals(this.minimumSystemVersion, systemInsightsApps.minimumSystemVersion) &&
        Objects.equals(this.name, systemInsightsApps.name) &&
        Objects.equals(this.path, systemInsightsApps.path) &&
        Objects.equals(this.systemId, systemInsightsApps.systemId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(applescriptEnabled, bundleExecutable, bundleIdentifier, bundleName, bundlePackageType, bundleShortVersion, bundleVersion, category, collectionTime, compiler, copyright, developmentRegion, displayName, element, environment, infoString, lastOpenedTime, minimumSystemVersion, name, path, systemId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemInsightsApps {\n");
    
    sb.append("    applescriptEnabled: ").append(toIndentedString(applescriptEnabled)).append("\n");
    sb.append("    bundleExecutable: ").append(toIndentedString(bundleExecutable)).append("\n");
    sb.append("    bundleIdentifier: ").append(toIndentedString(bundleIdentifier)).append("\n");
    sb.append("    bundleName: ").append(toIndentedString(bundleName)).append("\n");
    sb.append("    bundlePackageType: ").append(toIndentedString(bundlePackageType)).append("\n");
    sb.append("    bundleShortVersion: ").append(toIndentedString(bundleShortVersion)).append("\n");
    sb.append("    bundleVersion: ").append(toIndentedString(bundleVersion)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    collectionTime: ").append(toIndentedString(collectionTime)).append("\n");
    sb.append("    compiler: ").append(toIndentedString(compiler)).append("\n");
    sb.append("    copyright: ").append(toIndentedString(copyright)).append("\n");
    sb.append("    developmentRegion: ").append(toIndentedString(developmentRegion)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    element: ").append(toIndentedString(element)).append("\n");
    sb.append("    environment: ").append(toIndentedString(environment)).append("\n");
    sb.append("    infoString: ").append(toIndentedString(infoString)).append("\n");
    sb.append("    lastOpenedTime: ").append(toIndentedString(lastOpenedTime)).append("\n");
    sb.append("    minimumSystemVersion: ").append(toIndentedString(minimumSystemVersion)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
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

