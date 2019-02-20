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

/**
 * CommandslistResults
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-02-20T21:32:24.213Z")
public class CommandslistResults {
  @SerializedName("name")
  private String name = null;

  @SerializedName("command")
  private String command = null;

  @SerializedName("commandType")
  private String commandType = null;

  @SerializedName("launchType")
  private String launchType = null;

  @SerializedName("listensTo")
  private String listensTo = null;

  @SerializedName("schedule")
  private String schedule = null;

  @SerializedName("trigger")
  private String trigger = null;

  @SerializedName("scheduleRepeatType")
  private String scheduleRepeatType = null;

  @SerializedName("organization")
  private String organization = null;

  @SerializedName("_id")
  private String id = null;

  public CommandslistResults name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of the Command.
   * @return name
  **/
  @ApiModelProperty(value = "The name of the Command.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CommandslistResults command(String command) {
    this.command = command;
    return this;
  }

   /**
   * The Command to execute.
   * @return command
  **/
  @ApiModelProperty(value = "The Command to execute.")
  public String getCommand() {
    return command;
  }

  public void setCommand(String command) {
    this.command = command;
  }

  public CommandslistResults commandType(String commandType) {
    this.commandType = commandType;
    return this;
  }

   /**
   * The Command OS.
   * @return commandType
  **/
  @ApiModelProperty(value = "The Command OS.")
  public String getCommandType() {
    return commandType;
  }

  public void setCommandType(String commandType) {
    this.commandType = commandType;
  }

  public CommandslistResults launchType(String launchType) {
    this.launchType = launchType;
    return this;
  }

   /**
   * How the Command is executed.
   * @return launchType
  **/
  @ApiModelProperty(value = "How the Command is executed.")
  public String getLaunchType() {
    return launchType;
  }

  public void setLaunchType(String launchType) {
    this.launchType = launchType;
  }

  public CommandslistResults listensTo(String listensTo) {
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

  public CommandslistResults schedule(String schedule) {
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

  public CommandslistResults trigger(String trigger) {
    this.trigger = trigger;
    return this;
  }

   /**
   * Trigger to execute command.
   * @return trigger
  **/
  @ApiModelProperty(value = "Trigger to execute command.")
  public String getTrigger() {
    return trigger;
  }

  public void setTrigger(String trigger) {
    this.trigger = trigger;
  }

  public CommandslistResults scheduleRepeatType(String scheduleRepeatType) {
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

  public CommandslistResults organization(String organization) {
    this.organization = organization;
    return this;
  }

   /**
   * The ID of the Organization.
   * @return organization
  **/
  @ApiModelProperty(value = "The ID of the Organization.")
  public String getOrganization() {
    return organization;
  }

  public void setOrganization(String organization) {
    this.organization = organization;
  }

  public CommandslistResults id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The ID of the command.
   * @return id
  **/
  @ApiModelProperty(value = "The ID of the command.")
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
    CommandslistResults commandslistResults = (CommandslistResults) o;
    return Objects.equals(this.name, commandslistResults.name) &&
        Objects.equals(this.command, commandslistResults.command) &&
        Objects.equals(this.commandType, commandslistResults.commandType) &&
        Objects.equals(this.launchType, commandslistResults.launchType) &&
        Objects.equals(this.listensTo, commandslistResults.listensTo) &&
        Objects.equals(this.schedule, commandslistResults.schedule) &&
        Objects.equals(this.trigger, commandslistResults.trigger) &&
        Objects.equals(this.scheduleRepeatType, commandslistResults.scheduleRepeatType) &&
        Objects.equals(this.organization, commandslistResults.organization) &&
        Objects.equals(this.id, commandslistResults.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, command, commandType, launchType, listensTo, schedule, trigger, scheduleRepeatType, organization, id);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommandslistResults {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    command: ").append(toIndentedString(command)).append("\n");
    sb.append("    commandType: ").append(toIndentedString(commandType)).append("\n");
    sb.append("    launchType: ").append(toIndentedString(launchType)).append("\n");
    sb.append("    listensTo: ").append(toIndentedString(listensTo)).append("\n");
    sb.append("    schedule: ").append(toIndentedString(schedule)).append("\n");
    sb.append("    trigger: ").append(toIndentedString(trigger)).append("\n");
    sb.append("    scheduleRepeatType: ").append(toIndentedString(scheduleRepeatType)).append("\n");
    sb.append("    organization: ").append(toIndentedString(organization)).append("\n");
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

