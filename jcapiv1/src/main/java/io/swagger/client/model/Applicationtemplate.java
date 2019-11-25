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
import io.swagger.client.model.ApplicationtemplateJit;
import java.io.IOException;

/**
 * Applicationtemplate
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-11-21T20:17:09.332Z")
public class Applicationtemplate {
  @SerializedName("_id")
  private String id = null;

  @SerializedName("beta")
  private Boolean beta = null;

  @SerializedName("color")
  private String color = null;

  @SerializedName("config")
  private ApplicationConfig config = null;

  @SerializedName("displayLabel")
  private String displayLabel = null;

  @SerializedName("displayName")
  private String displayName = null;

  @SerializedName("isConfigured")
  private Boolean isConfigured = null;

  @SerializedName("jit")
  private ApplicationtemplateJit jit = null;

  @SerializedName("learnMore")
  private String learnMore = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("ssoUrl")
  private String ssoUrl = null;

  public Applicationtemplate id(String id) {
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

  public Applicationtemplate beta(Boolean beta) {
    this.beta = beta;
    return this;
  }

   /**
   * Get beta
   * @return beta
  **/
  @ApiModelProperty(value = "")
  public Boolean isBeta() {
    return beta;
  }

  public void setBeta(Boolean beta) {
    this.beta = beta;
  }

  public Applicationtemplate color(String color) {
    this.color = color;
    return this;
  }

   /**
   * Get color
   * @return color
  **/
  @ApiModelProperty(value = "")
  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public Applicationtemplate config(ApplicationConfig config) {
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

  public Applicationtemplate displayLabel(String displayLabel) {
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

  public Applicationtemplate displayName(String displayName) {
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

  public Applicationtemplate isConfigured(Boolean isConfigured) {
    this.isConfigured = isConfigured;
    return this;
  }

   /**
   * Get isConfigured
   * @return isConfigured
  **/
  @ApiModelProperty(value = "")
  public Boolean isIsConfigured() {
    return isConfigured;
  }

  public void setIsConfigured(Boolean isConfigured) {
    this.isConfigured = isConfigured;
  }

  public Applicationtemplate jit(ApplicationtemplateJit jit) {
    this.jit = jit;
    return this;
  }

   /**
   * Get jit
   * @return jit
  **/
  @ApiModelProperty(value = "")
  public ApplicationtemplateJit getJit() {
    return jit;
  }

  public void setJit(ApplicationtemplateJit jit) {
    this.jit = jit;
  }

  public Applicationtemplate learnMore(String learnMore) {
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

  public Applicationtemplate name(String name) {
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

  public Applicationtemplate ssoUrl(String ssoUrl) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Applicationtemplate applicationtemplate = (Applicationtemplate) o;
    return Objects.equals(this.id, applicationtemplate.id) &&
        Objects.equals(this.beta, applicationtemplate.beta) &&
        Objects.equals(this.color, applicationtemplate.color) &&
        Objects.equals(this.config, applicationtemplate.config) &&
        Objects.equals(this.displayLabel, applicationtemplate.displayLabel) &&
        Objects.equals(this.displayName, applicationtemplate.displayName) &&
        Objects.equals(this.isConfigured, applicationtemplate.isConfigured) &&
        Objects.equals(this.jit, applicationtemplate.jit) &&
        Objects.equals(this.learnMore, applicationtemplate.learnMore) &&
        Objects.equals(this.name, applicationtemplate.name) &&
        Objects.equals(this.ssoUrl, applicationtemplate.ssoUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, beta, color, config, displayLabel, displayName, isConfigured, jit, learnMore, name, ssoUrl);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Applicationtemplate {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    beta: ").append(toIndentedString(beta)).append("\n");
    sb.append("    color: ").append(toIndentedString(color)).append("\n");
    sb.append("    config: ").append(toIndentedString(config)).append("\n");
    sb.append("    displayLabel: ").append(toIndentedString(displayLabel)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    isConfigured: ").append(toIndentedString(isConfigured)).append("\n");
    sb.append("    jit: ").append(toIndentedString(jit)).append("\n");
    sb.append("    learnMore: ").append(toIndentedString(learnMore)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    ssoUrl: ").append(toIndentedString(ssoUrl)).append("\n");
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

