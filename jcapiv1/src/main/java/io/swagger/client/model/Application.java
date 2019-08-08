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
import io.swagger.client.model.ApplicationConfig;
import java.io.IOException;

/**
 * Application
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-08-08T01:09:36.870Z")
public class Application {
  @SerializedName("_id")
  private String id = null;

  @SerializedName("active")
  private Boolean active = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("displayName")
  private String displayName = null;

  @SerializedName("displayLabel")
  private String displayLabel = null;

  @SerializedName("organization")
  private String organization = null;

  @SerializedName("ssoUrl")
  private String ssoUrl = null;

  @SerializedName("learnMore")
  private String learnMore = null;

  @SerializedName("config")
  private ApplicationConfig config = null;

  public Application id(String id) {
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

  public Application active(Boolean active) {
    this.active = active;
    return this;
  }

   /**
   * Get active
   * @return active
  **/
  @ApiModelProperty(value = "")
  public Boolean isActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public Application name(String name) {
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

  public Application displayName(String displayName) {
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

  public Application displayLabel(String displayLabel) {
    this.displayLabel = displayLabel;
    return this;
  }

   /**
   * Get displayLabel
   * @return displayLabel
  **/
  @ApiModelProperty(value = "")
  public String getDisplayLabel() {
    return displayLabel;
  }

  public void setDisplayLabel(String displayLabel) {
    this.displayLabel = displayLabel;
  }

  public Application organization(String organization) {
    this.organization = organization;
    return this;
  }

   /**
   * Get organization
   * @return organization
  **/
  @ApiModelProperty(value = "")
  public String getOrganization() {
    return organization;
  }

  public void setOrganization(String organization) {
    this.organization = organization;
  }

  public Application ssoUrl(String ssoUrl) {
    this.ssoUrl = ssoUrl;
    return this;
  }

   /**
   * Get ssoUrl
   * @return ssoUrl
  **/
  @ApiModelProperty(value = "")
  public String getSsoUrl() {
    return ssoUrl;
  }

  public void setSsoUrl(String ssoUrl) {
    this.ssoUrl = ssoUrl;
  }

  public Application learnMore(String learnMore) {
    this.learnMore = learnMore;
    return this;
  }

   /**
   * Get learnMore
   * @return learnMore
  **/
  @ApiModelProperty(value = "")
  public String getLearnMore() {
    return learnMore;
  }

  public void setLearnMore(String learnMore) {
    this.learnMore = learnMore;
  }

  public Application config(ApplicationConfig config) {
    this.config = config;
    return this;
  }

   /**
   * Get config
   * @return config
  **/
  @ApiModelProperty(value = "")
  public ApplicationConfig getConfig() {
    return config;
  }

  public void setConfig(ApplicationConfig config) {
    this.config = config;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Application application = (Application) o;
    return Objects.equals(this.id, application.id) &&
        Objects.equals(this.active, application.active) &&
        Objects.equals(this.name, application.name) &&
        Objects.equals(this.displayName, application.displayName) &&
        Objects.equals(this.displayLabel, application.displayLabel) &&
        Objects.equals(this.organization, application.organization) &&
        Objects.equals(this.ssoUrl, application.ssoUrl) &&
        Objects.equals(this.learnMore, application.learnMore) &&
        Objects.equals(this.config, application.config);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, active, name, displayName, displayLabel, organization, ssoUrl, learnMore, config);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Application {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    displayLabel: ").append(toIndentedString(displayLabel)).append("\n");
    sb.append("    organization: ").append(toIndentedString(organization)).append("\n");
    sb.append("    ssoUrl: ").append(toIndentedString(ssoUrl)).append("\n");
    sb.append("    learnMore: ").append(toIndentedString(learnMore)).append("\n");
    sb.append("    config: ").append(toIndentedString(config)).append("\n");
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

