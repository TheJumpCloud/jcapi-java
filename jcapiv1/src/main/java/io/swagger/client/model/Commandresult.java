/*
 * JumpCloud APIs
 * V1 & V2 versions of JumpCloud's API. The previous version of JumpCloud's API. This set of endpoints allows JumpCloud customers to manage commands, systems, & system users.
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
import io.swagger.client.model.CommandresultResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Commandresult
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-09T19:50:51.514Z")
public class Commandresult {
  @SerializedName("command")
  private String command = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("system")
  private String system = null;

  @SerializedName("organization")
  private String organization = null;

  @SerializedName("workflowId")
  private String workflowId = null;

  @SerializedName("workflowInstanceId")
  private String workflowInstanceId = null;

  @SerializedName("user")
  private String user = null;

  @SerializedName("sudo")
  private Boolean sudo = null;

  @SerializedName("files")
  private List<String> files = null;

  @SerializedName("requestTime")
  private Integer requestTime = null;

  @SerializedName("responseTime")
  private Integer responseTime = null;

  @SerializedName("response")
  private CommandresultResponse response = null;

  @SerializedName("_id")
  private String id = null;

  public Commandresult command(String command) {
    this.command = command;
    return this;
  }

   /**
   * The command that was executed on the system.
   * @return command
  **/
  @ApiModelProperty(value = "The command that was executed on the system.")
  public String getCommand() {
    return command;
  }

  public void setCommand(String command) {
    this.command = command;
  }

  public Commandresult name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of the command.
   * @return name
  **/
  @ApiModelProperty(value = "The name of the command.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Commandresult system(String system) {
    this.system = system;
    return this;
  }

   /**
   * The id of the system the command was executed on.
   * @return system
  **/
  @ApiModelProperty(value = "The id of the system the command was executed on.")
  public String getSystem() {
    return system;
  }

  public void setSystem(String system) {
    this.system = system;
  }

  public Commandresult organization(String organization) {
    this.organization = organization;
    return this;
  }

   /**
   * The id of the organization.
   * @return organization
  **/
  @ApiModelProperty(value = "The id of the organization.")
  public String getOrganization() {
    return organization;
  }

  public void setOrganization(String organization) {
    this.organization = organization;
  }

  public Commandresult workflowId(String workflowId) {
    this.workflowId = workflowId;
    return this;
  }

   /**
   * Get workflowId
   * @return workflowId
  **/
  @ApiModelProperty(value = "")
  public String getWorkflowId() {
    return workflowId;
  }

  public void setWorkflowId(String workflowId) {
    this.workflowId = workflowId;
  }

  public Commandresult workflowInstanceId(String workflowInstanceId) {
    this.workflowInstanceId = workflowInstanceId;
    return this;
  }

   /**
   * Get workflowInstanceId
   * @return workflowInstanceId
  **/
  @ApiModelProperty(value = "")
  public String getWorkflowInstanceId() {
    return workflowInstanceId;
  }

  public void setWorkflowInstanceId(String workflowInstanceId) {
    this.workflowInstanceId = workflowInstanceId;
  }

  public Commandresult user(String user) {
    this.user = user;
    return this;
  }

   /**
   * The user the command ran as.
   * @return user
  **/
  @ApiModelProperty(value = "The user the command ran as.")
  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public Commandresult sudo(Boolean sudo) {
    this.sudo = sudo;
    return this;
  }

   /**
   * If the user had sudo rights
   * @return sudo
  **/
  @ApiModelProperty(value = "If the user had sudo rights")
  public Boolean isSudo() {
    return sudo;
  }

  public void setSudo(Boolean sudo) {
    this.sudo = sudo;
  }

  public Commandresult files(List<String> files) {
    this.files = files;
    return this;
  }

  public Commandresult addFilesItem(String filesItem) {
    if (this.files == null) {
      this.files = new ArrayList<String>();
    }
    this.files.add(filesItem);
    return this;
  }

   /**
   * An array of file ids that were included in the command
   * @return files
  **/
  @ApiModelProperty(value = "An array of file ids that were included in the command")
  public List<String> getFiles() {
    return files;
  }

  public void setFiles(List<String> files) {
    this.files = files;
  }

  public Commandresult requestTime(Integer requestTime) {
    this.requestTime = requestTime;
    return this;
  }

   /**
   * The time that the command was sent.
   * @return requestTime
  **/
  @ApiModelProperty(value = "The time that the command was sent.")
  public Integer getRequestTime() {
    return requestTime;
  }

  public void setRequestTime(Integer requestTime) {
    this.requestTime = requestTime;
  }

  public Commandresult responseTime(Integer responseTime) {
    this.responseTime = responseTime;
    return this;
  }

   /**
   * The time that the command was completed.
   * @return responseTime
  **/
  @ApiModelProperty(value = "The time that the command was completed.")
  public Integer getResponseTime() {
    return responseTime;
  }

  public void setResponseTime(Integer responseTime) {
    this.responseTime = responseTime;
  }

  public Commandresult response(CommandresultResponse response) {
    this.response = response;
    return this;
  }

   /**
   * Get response
   * @return response
  **/
  @ApiModelProperty(value = "")
  public CommandresultResponse getResponse() {
    return response;
  }

  public void setResponse(CommandresultResponse response) {
    this.response = response;
  }

  public Commandresult id(String id) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Commandresult commandresult = (Commandresult) o;
    return Objects.equals(this.command, commandresult.command) &&
        Objects.equals(this.name, commandresult.name) &&
        Objects.equals(this.system, commandresult.system) &&
        Objects.equals(this.organization, commandresult.organization) &&
        Objects.equals(this.workflowId, commandresult.workflowId) &&
        Objects.equals(this.workflowInstanceId, commandresult.workflowInstanceId) &&
        Objects.equals(this.user, commandresult.user) &&
        Objects.equals(this.sudo, commandresult.sudo) &&
        Objects.equals(this.files, commandresult.files) &&
        Objects.equals(this.requestTime, commandresult.requestTime) &&
        Objects.equals(this.responseTime, commandresult.responseTime) &&
        Objects.equals(this.response, commandresult.response) &&
        Objects.equals(this.id, commandresult.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(command, name, system, organization, workflowId, workflowInstanceId, user, sudo, files, requestTime, responseTime, response, id);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Commandresult {\n");
    
    sb.append("    command: ").append(toIndentedString(command)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    system: ").append(toIndentedString(system)).append("\n");
    sb.append("    organization: ").append(toIndentedString(organization)).append("\n");
    sb.append("    workflowId: ").append(toIndentedString(workflowId)).append("\n");
    sb.append("    workflowInstanceId: ").append(toIndentedString(workflowInstanceId)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    sudo: ").append(toIndentedString(sudo)).append("\n");
    sb.append("    files: ").append(toIndentedString(files)).append("\n");
    sb.append("    requestTime: ").append(toIndentedString(requestTime)).append("\n");
    sb.append("    responseTime: ").append(toIndentedString(responseTime)).append("\n");
    sb.append("    response: ").append(toIndentedString(response)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

