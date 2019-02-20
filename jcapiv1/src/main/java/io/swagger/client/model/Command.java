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
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Command
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-02-20T21:32:24.213Z")
public class Command {
  @SerializedName("name")
  private String name = null;

  @SerializedName("command")
  private String command = null;

  @SerializedName("commandType")
  private String commandType = null;

  @SerializedName("commandRunners")
  private List<String> commandRunners = null;

  @SerializedName("user")
  private String user = null;

  @SerializedName("sudo")
  private Boolean sudo = null;

  @SerializedName("systems")
  private List<String> systems = null;

  @SerializedName("launchType")
  private String launchType = null;

  @SerializedName("listensTo")
  private String listensTo = null;

  @SerializedName("scheduleRepeatType")
  private String scheduleRepeatType = null;

  @SerializedName("schedule")
  private String schedule = null;

  @SerializedName("files")
  private List<String> files = null;

  @SerializedName("timeout")
  private String timeout = null;

  @SerializedName("organization")
  private String organization = null;

  public Command name(String name) {
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

  public Command command(String command) {
    this.command = command;
    return this;
  }

   /**
   * The command to execute on the server.
   * @return command
  **/
  @ApiModelProperty(required = true, value = "The command to execute on the server.")
  public String getCommand() {
    return command;
  }

  public void setCommand(String command) {
    this.command = command;
  }

  public Command commandType(String commandType) {
    this.commandType = commandType;
    return this;
  }

   /**
   * The Command OS
   * @return commandType
  **/
  @ApiModelProperty(value = "The Command OS")
  public String getCommandType() {
    return commandType;
  }

  public void setCommandType(String commandType) {
    this.commandType = commandType;
  }

  public Command commandRunners(List<String> commandRunners) {
    this.commandRunners = commandRunners;
    return this;
  }

  public Command addCommandRunnersItem(String commandRunnersItem) {
    if (this.commandRunners == null) {
      this.commandRunners = new ArrayList<String>();
    }
    this.commandRunners.add(commandRunnersItem);
    return this;
  }

   /**
   * An array of IDs of the Command Runner Users that can execute this command.
   * @return commandRunners
  **/
  @ApiModelProperty(value = "An array of IDs of the Command Runner Users that can execute this command.")
  public List<String> getCommandRunners() {
    return commandRunners;
  }

  public void setCommandRunners(List<String> commandRunners) {
    this.commandRunners = commandRunners;
  }

  public Command user(String user) {
    this.user = user;
    return this;
  }

   /**
   * The ID of the system user to run the command as.
   * @return user
  **/
  @ApiModelProperty(required = true, value = "The ID of the system user to run the command as.")
  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public Command sudo(Boolean sudo) {
    this.sudo = sudo;
    return this;
  }

   /**
   * 
   * @return sudo
  **/
  @ApiModelProperty(value = "")
  public Boolean isSudo() {
    return sudo;
  }

  public void setSudo(Boolean sudo) {
    this.sudo = sudo;
  }

  public Command systems(List<String> systems) {
    this.systems = systems;
    return this;
  }

  public Command addSystemsItem(String systemsItem) {
    if (this.systems == null) {
      this.systems = new ArrayList<String>();
    }
    this.systems.add(systemsItem);
    return this;
  }

   /**
   * An array of system IDs to run the command on. Not available if you are using Groups.
   * @return systems
  **/
  @ApiModelProperty(value = "An array of system IDs to run the command on. Not available if you are using Groups.")
  public List<String> getSystems() {
    return systems;
  }

  public void setSystems(List<String> systems) {
    this.systems = systems;
  }

  public Command launchType(String launchType) {
    this.launchType = launchType;
    return this;
  }

   /**
   * How the command will execute.
   * @return launchType
  **/
  @ApiModelProperty(value = "How the command will execute.")
  public String getLaunchType() {
    return launchType;
  }

  public void setLaunchType(String launchType) {
    this.launchType = launchType;
  }

  public Command listensTo(String listensTo) {
    this.listensTo = listensTo;
    return this;
  }

   /**
   * 
   * @return listensTo
  **/
  @ApiModelProperty(value = "")
  public String getListensTo() {
    return listensTo;
  }

  public void setListensTo(String listensTo) {
    this.listensTo = listensTo;
  }

  public Command scheduleRepeatType(String scheduleRepeatType) {
    this.scheduleRepeatType = scheduleRepeatType;
    return this;
  }

   /**
   * When the command will repeat.
   * @return scheduleRepeatType
  **/
  @ApiModelProperty(value = "When the command will repeat.")
  public String getScheduleRepeatType() {
    return scheduleRepeatType;
  }

  public void setScheduleRepeatType(String scheduleRepeatType) {
    this.scheduleRepeatType = scheduleRepeatType;
  }

  public Command schedule(String schedule) {
    this.schedule = schedule;
    return this;
  }

   /**
   * A crontab that consists of: [ (seconds) (minutes) (hours) (days of month) (months) (weekdays) ] or [ immediate ]. If you send this as an empty string, it will run immediately. 
   * @return schedule
  **/
  @ApiModelProperty(value = "A crontab that consists of: [ (seconds) (minutes) (hours) (days of month) (months) (weekdays) ] or [ immediate ]. If you send this as an empty string, it will run immediately. ")
  public String getSchedule() {
    return schedule;
  }

  public void setSchedule(String schedule) {
    this.schedule = schedule;
  }

  public Command files(List<String> files) {
    this.files = files;
    return this;
  }

  public Command addFilesItem(String filesItem) {
    if (this.files == null) {
      this.files = new ArrayList<String>();
    }
    this.files.add(filesItem);
    return this;
  }

   /**
   * An array of file IDs to include with the command.
   * @return files
  **/
  @ApiModelProperty(value = "An array of file IDs to include with the command.")
  public List<String> getFiles() {
    return files;
  }

  public void setFiles(List<String> files) {
    this.files = files;
  }

  public Command timeout(String timeout) {
    this.timeout = timeout;
    return this;
  }

   /**
   * The time in seconds to allow the command to run for.
   * @return timeout
  **/
  @ApiModelProperty(value = "The time in seconds to allow the command to run for.")
  public String getTimeout() {
    return timeout;
  }

  public void setTimeout(String timeout) {
    this.timeout = timeout;
  }

  public Command organization(String organization) {
    this.organization = organization;
    return this;
  }

   /**
   * The ID of the organization.
   * @return organization
  **/
  @ApiModelProperty(value = "The ID of the organization.")
  public String getOrganization() {
    return organization;
  }

  public void setOrganization(String organization) {
    this.organization = organization;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Command command = (Command) o;
    return Objects.equals(this.name, command.name) &&
        Objects.equals(this.command, command.command) &&
        Objects.equals(this.commandType, command.commandType) &&
        Objects.equals(this.commandRunners, command.commandRunners) &&
        Objects.equals(this.user, command.user) &&
        Objects.equals(this.sudo, command.sudo) &&
        Objects.equals(this.systems, command.systems) &&
        Objects.equals(this.launchType, command.launchType) &&
        Objects.equals(this.listensTo, command.listensTo) &&
        Objects.equals(this.scheduleRepeatType, command.scheduleRepeatType) &&
        Objects.equals(this.schedule, command.schedule) &&
        Objects.equals(this.files, command.files) &&
        Objects.equals(this.timeout, command.timeout) &&
        Objects.equals(this.organization, command.organization);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, command, commandType, commandRunners, user, sudo, systems, launchType, listensTo, scheduleRepeatType, schedule, files, timeout, organization);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Command {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    command: ").append(toIndentedString(command)).append("\n");
    sb.append("    commandType: ").append(toIndentedString(commandType)).append("\n");
    sb.append("    commandRunners: ").append(toIndentedString(commandRunners)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    sudo: ").append(toIndentedString(sudo)).append("\n");
    sb.append("    systems: ").append(toIndentedString(systems)).append("\n");
    sb.append("    launchType: ").append(toIndentedString(launchType)).append("\n");
    sb.append("    listensTo: ").append(toIndentedString(listensTo)).append("\n");
    sb.append("    scheduleRepeatType: ").append(toIndentedString(scheduleRepeatType)).append("\n");
    sb.append("    schedule: ").append(toIndentedString(schedule)).append("\n");
    sb.append("    files: ").append(toIndentedString(files)).append("\n");
    sb.append("    timeout: ").append(toIndentedString(timeout)).append("\n");
    sb.append("    organization: ").append(toIndentedString(organization)).append("\n");
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

