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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Command
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-09T19:50:51.514Z")
public class Command {
  @SerializedName("name")
  private String name = null;

  @SerializedName("command")
  private String command = null;

  @SerializedName("user")
  private String user = null;

  @SerializedName("systems")
  private List<String> systems = null;

  @SerializedName("schedule")
  private String schedule = null;

  @SerializedName("files")
  private List<String> files = null;

  @SerializedName("tags")
  private List<String> tags = null;

  @SerializedName("timeout")
  private String timeout = null;

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

  public Command tags(List<String> tags) {
    this.tags = tags;
    return this;
  }

  public Command addTagsItem(String tagsItem) {
    if (this.tags == null) {
      this.tags = new ArrayList<String>();
    }
    this.tags.add(tagsItem);
    return this;
  }

   /**
   * An array of tag IDs to run the command on. Not available if you are using Groups.
   * @return tags
  **/
  @ApiModelProperty(value = "An array of tag IDs to run the command on. Not available if you are using Groups.")
  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
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
        Objects.equals(this.user, command.user) &&
        Objects.equals(this.systems, command.systems) &&
        Objects.equals(this.schedule, command.schedule) &&
        Objects.equals(this.files, command.files) &&
        Objects.equals(this.tags, command.tags) &&
        Objects.equals(this.timeout, command.timeout);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, command, user, systems, schedule, files, tags, timeout);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Command {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    command: ").append(toIndentedString(command)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    systems: ").append(toIndentedString(systems)).append("\n");
    sb.append("    schedule: ").append(toIndentedString(schedule)).append("\n");
    sb.append("    files: ").append(toIndentedString(files)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    timeout: ").append(toIndentedString(timeout)).append("\n");
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

