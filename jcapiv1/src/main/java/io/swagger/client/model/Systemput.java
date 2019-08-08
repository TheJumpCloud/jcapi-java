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
import io.swagger.client.model.SystemputAgentBoundMessages;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Systemput
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-08-08T00:50:04.431Z")
public class Systemput {
  @SerializedName("displayName")
  private String displayName = null;

  @SerializedName("allowSshPasswordAuthentication")
  private Boolean allowSshPasswordAuthentication = null;

  @SerializedName("allowSshRootLogin")
  private Boolean allowSshRootLogin = null;

  @SerializedName("allowMultiFactorAuthentication")
  private Boolean allowMultiFactorAuthentication = null;

  @SerializedName("allowPublicKeyAuthentication")
  private Boolean allowPublicKeyAuthentication = null;

  @SerializedName("agentBoundMessages")
  private List<SystemputAgentBoundMessages> agentBoundMessages = null;

  @SerializedName("tags")
  private List<String> tags = null;

  public Systemput displayName(String displayName) {
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

  public Systemput allowSshPasswordAuthentication(Boolean allowSshPasswordAuthentication) {
    this.allowSshPasswordAuthentication = allowSshPasswordAuthentication;
    return this;
  }

   /**
   * Get allowSshPasswordAuthentication
   * @return allowSshPasswordAuthentication
  **/
  @ApiModelProperty(value = "")
  public Boolean isAllowSshPasswordAuthentication() {
    return allowSshPasswordAuthentication;
  }

  public void setAllowSshPasswordAuthentication(Boolean allowSshPasswordAuthentication) {
    this.allowSshPasswordAuthentication = allowSshPasswordAuthentication;
  }

  public Systemput allowSshRootLogin(Boolean allowSshRootLogin) {
    this.allowSshRootLogin = allowSshRootLogin;
    return this;
  }

   /**
   * Get allowSshRootLogin
   * @return allowSshRootLogin
  **/
  @ApiModelProperty(value = "")
  public Boolean isAllowSshRootLogin() {
    return allowSshRootLogin;
  }

  public void setAllowSshRootLogin(Boolean allowSshRootLogin) {
    this.allowSshRootLogin = allowSshRootLogin;
  }

  public Systemput allowMultiFactorAuthentication(Boolean allowMultiFactorAuthentication) {
    this.allowMultiFactorAuthentication = allowMultiFactorAuthentication;
    return this;
  }

   /**
   * Get allowMultiFactorAuthentication
   * @return allowMultiFactorAuthentication
  **/
  @ApiModelProperty(value = "")
  public Boolean isAllowMultiFactorAuthentication() {
    return allowMultiFactorAuthentication;
  }

  public void setAllowMultiFactorAuthentication(Boolean allowMultiFactorAuthentication) {
    this.allowMultiFactorAuthentication = allowMultiFactorAuthentication;
  }

  public Systemput allowPublicKeyAuthentication(Boolean allowPublicKeyAuthentication) {
    this.allowPublicKeyAuthentication = allowPublicKeyAuthentication;
    return this;
  }

   /**
   * Get allowPublicKeyAuthentication
   * @return allowPublicKeyAuthentication
  **/
  @ApiModelProperty(value = "")
  public Boolean isAllowPublicKeyAuthentication() {
    return allowPublicKeyAuthentication;
  }

  public void setAllowPublicKeyAuthentication(Boolean allowPublicKeyAuthentication) {
    this.allowPublicKeyAuthentication = allowPublicKeyAuthentication;
  }

  public Systemput agentBoundMessages(List<SystemputAgentBoundMessages> agentBoundMessages) {
    this.agentBoundMessages = agentBoundMessages;
    return this;
  }

  public Systemput addAgentBoundMessagesItem(SystemputAgentBoundMessages agentBoundMessagesItem) {
    if (this.agentBoundMessages == null) {
      this.agentBoundMessages = new ArrayList<SystemputAgentBoundMessages>();
    }
    this.agentBoundMessages.add(agentBoundMessagesItem);
    return this;
  }

   /**
   * Get agentBoundMessages
   * @return agentBoundMessages
  **/
  @ApiModelProperty(value = "")
  public List<SystemputAgentBoundMessages> getAgentBoundMessages() {
    return agentBoundMessages;
  }

  public void setAgentBoundMessages(List<SystemputAgentBoundMessages> agentBoundMessages) {
    this.agentBoundMessages = agentBoundMessages;
  }

  public Systemput tags(List<String> tags) {
    this.tags = tags;
    return this;
  }

  public Systemput addTagsItem(String tagsItem) {
    if (this.tags == null) {
      this.tags = new ArrayList<String>();
    }
    this.tags.add(tagsItem);
    return this;
  }

   /**
   * Get tags
   * @return tags
  **/
  @ApiModelProperty(value = "")
  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Systemput systemput = (Systemput) o;
    return Objects.equals(this.displayName, systemput.displayName) &&
        Objects.equals(this.allowSshPasswordAuthentication, systemput.allowSshPasswordAuthentication) &&
        Objects.equals(this.allowSshRootLogin, systemput.allowSshRootLogin) &&
        Objects.equals(this.allowMultiFactorAuthentication, systemput.allowMultiFactorAuthentication) &&
        Objects.equals(this.allowPublicKeyAuthentication, systemput.allowPublicKeyAuthentication) &&
        Objects.equals(this.agentBoundMessages, systemput.agentBoundMessages) &&
        Objects.equals(this.tags, systemput.tags);
  }

  @Override
  public int hashCode() {
    return Objects.hash(displayName, allowSshPasswordAuthentication, allowSshRootLogin, allowMultiFactorAuthentication, allowPublicKeyAuthentication, agentBoundMessages, tags);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Systemput {\n");
    
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    allowSshPasswordAuthentication: ").append(toIndentedString(allowSshPasswordAuthentication)).append("\n");
    sb.append("    allowSshRootLogin: ").append(toIndentedString(allowSshRootLogin)).append("\n");
    sb.append("    allowMultiFactorAuthentication: ").append(toIndentedString(allowMultiFactorAuthentication)).append("\n");
    sb.append("    allowPublicKeyAuthentication: ").append(toIndentedString(allowPublicKeyAuthentication)).append("\n");
    sb.append("    agentBoundMessages: ").append(toIndentedString(agentBoundMessages)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
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

