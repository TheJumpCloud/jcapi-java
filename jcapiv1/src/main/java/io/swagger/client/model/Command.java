/*
 * JumpCloud API
 * # Overview  JumpCloud's V1 API. This set of endpoints allows JumpCloud customers to manage commands, systems, and system users.  # API Key  ## Access Your API Key  To locate your API Key:  1. Log into the [JumpCloud Admin Console](https://console.jumpcloud.com/). 2. Go to the username drop down located in the top-right of the Console. 3. Retrieve your API key from API Settings.  ## API Key Considerations  This API key is associated to the currently logged in administrator. Other admins will have different API keys.  **WARNING** Please keep this API key secret, as it grants full access to any data accessible via your JumpCloud console account.  You can also reset your API key in the same location in the JumpCloud Admin Console.  ## Recycling or Resetting Your API Key  In order to revoke access with the current API key, simply reset your API key. This will render all calls using the previous API key inaccessible.  Your API key will be passed in as a header with the header name \"x-api-key\".  ```bash curl -H \"x-api-key: [YOUR_API_KEY_HERE]\" \"https://console.jumpcloud.com/api/systemusers\" ```  # System Context  * [Introduction](#introduction) * [Supported endpoints](#supported-endpoints) * [Response codes](#response-codes) * [Authentication](#authentication) * [Additional examples](#additional-examples) * [Third party](#third-party)  ## Introduction  JumpCloud System Context Authorization is an alternative way to authenticate with a subset of JumpCloud's REST APIs. Using this method, a system can manage its information and resource associations, allowing modern auto provisioning environments to scale as needed.  **Notes:**   * The following documentation applies to Linux Operating Systems only.  * Systems that have been automatically enrolled using Apple's Device Enrollment Program (DEP) or systems enrolled using the User Portal install are not eligible to use the System Context API to prevent unauthorized access to system groups and resources. If a script that utilizes the System Context API is invoked on a system enrolled in this way, it will display an error.  ## Supported Endpoints  JumpCloud System Context Authorization can be used in conjunction with Systems endpoints found in the V1 API and certain System Group endpoints found in the v2 API.  * A system may fetch, alter, and delete metadata about itself, including manipulating a system's Group and Systemuser associations,   * `/api/systems/{system_id}` | [`GET`](https://docs.jumpcloud.com/api/1.0/index.html#operation/systems_get) [`PUT`](https://docs.jumpcloud.com/api/1.0/index.html#operation/systems_put) * A system may delete itself from your JumpCloud organization   * `/api/systems/{system_id}` | [`DELETE`](https://docs.jumpcloud.com/api/1.0/index.html#operation/systems_delete) * A system may fetch its direct resource associations under v2 (Groups)   * `/api/v2/systems/{system_id}/memberof` | [`GET`](https://docs.jumpcloud.com/api/2.0/index.html#operation/graph_systemGroupMembership)   * `/api/v2/systems/{system_id}/associations` | [`GET`](https://docs.jumpcloud.com/api/2.0/index.html#operation/graph_systemAssociationsList)   * `/api/v2/systems/{system_id}/users` | [`GET`](https://docs.jumpcloud.com/api/2.0/index.html#operation/graph_systemTraverseUser) * A system may alter its direct resource associations under v2 (Groups)   * `/api/v2/systems/{system_id}/associations` | [`POST`](https://docs.jumpcloud.com/api/2.0/index.html#operation/graph_systemAssociationsPost) * A system may alter its System Group associations   * `/api/v2/systemgroups/{group_id}/members` | [`POST`](https://docs.jumpcloud.com/api/2.0/index.html#operation/graph_systemGroupMembersPost)     * _NOTE_ If a system attempts to alter the system group membership of a different system the request will be rejected  ## Response Codes  If endpoints other than those described above are called using the System Context API, the server will return a `401` response.  ## Authentication  To allow for secure access to our APIs, you must authenticate each API request. JumpCloud System Context Authorization uses [HTTP Signatures](https://tools.ietf.org/html/draft-cavage-http-signatures-00) to authenticate API requests. The HTTP Signatures sent with each request are similar to the signatures used by the Amazon Web Services REST API. To help with the request-signing process, we have provided an [example bash script](https://github.com/TheJumpCloud/SystemContextAPI/blob/master/examples/shell/SigningExample.sh). This example API request simply requests the entire system record. You must be root, or have permissions to access the contents of the `/opt/jc` directory to generate a signature.  Here is a breakdown of the example script with explanations.  First, the script extracts the systemKey from the JSON formatted `/opt/jc/jcagent.conf` file.  ```bash #!/bin/bash conf=\"`cat /opt/jc/jcagent.conf`\" regex=\"systemKey\\\":\\\"(\\w+)\\\"\"  if [[ $conf =~ $regex ]] ; then   systemKey=\"${BASH_REMATCH[1]}\" fi ```  Then, the script retrieves the current date in the correct format.  ```bash now=`date -u \"+%a, %d %h %Y %H:%M:%S GMT\"`; ```  Next, we build a signing string to demonstrate the expected signature format. The signed string must consist of the [request-line](https://tools.ietf.org/html/rfc2616#page-35) and the date header, separated by a newline character.  ```bash signstr=\"GET /api/systems/${systemKey} HTTP/1.1\\ndate: ${now}\" ```  The next step is to calculate and apply the signature. This is a two-step process:  1. Create a signature from the signing string using the JumpCloud Agent private key: ``printf \"$signstr\" | openssl dgst -sha256 -sign /opt/jc/client.key`` 2. Then Base64-encode the signature string and trim off the newline characters: ``| openssl enc -e -a | tr -d '\\n'``  The combined steps above result in:  ```bash signature=`printf \"$signstr\" | openssl dgst -sha256 -sign /opt/jc/client.key | openssl enc -e -a | tr -d '\\n'` ; ```  Finally, we make sure the API call sending the signature has the same Authorization and Date header values, HTTP method, and URL that were used in the signing string.  ```bash curl -iq \\   -H \"Accept: application/json\" \\   -H \"Content-Type: application/json\" \\   -H \"Date: ${now}\" \\   -H \"Authorization: Signature keyId=\\\"system/${systemKey}\\\",headers=\\\"request-line date\\\",algorithm=\\\"rsa-sha256\\\",signature=\\\"${signature}\\\"\" \\   --url https://console.jumpcloud.com/api/systems/${systemKey} ```  ### Input Data  All PUT and POST methods should use the HTTP Content-Type header with a value of 'application/json'. PUT methods are used for updating a record. POST methods are used to create a record.  The following example demonstrates how to update the `displayName` of the system.  ```bash signstr=\"PUT /api/systems/${systemKey} HTTP/1.1\\ndate: ${now}\" signature=`printf \"$signstr\" | openssl dgst -sha256 -sign /opt/jc/client.key | openssl enc -e -a | tr -d '\\n'` ;  curl -iq \\   -d \"{\\\"displayName\\\" : \\\"updated-system-name-1\\\"}\" \\   -X \"PUT\" \\   -H \"Content-Type: application/json\" \\   -H \"Accept: application/json\" \\   -H \"Date: ${now}\" \\   -H \"Authorization: Signature keyId=\\\"system/${systemKey}\\\",headers=\\\"request-line date\\\",algorithm=\\\"rsa-sha256\\\",signature=\\\"${signature}\\\"\" \\   --url https://console.jumpcloud.com/api/systems/${systemKey} ```  ### Output Data  All results will be formatted as JSON.  Here is an abbreviated example of response output:  ```json {   \"_id\": \"525ee96f52e144993e000015\",   \"agentServer\": \"lappy386\",   \"agentVersion\": \"0.9.42\",   \"arch\": \"x86_64\",   \"connectionKey\": \"127.0.0.1_51812\",   \"displayName\": \"ubuntu-1204\",   \"firstContact\": \"2013-10-16T19:30:55.611Z\",   \"hostname\": \"ubuntu-1204\"   ... ```  ## Additional Examples  ### Signing Authentication Example  This example demonstrates how to make an authenticated request to fetch the JumpCloud record for this system.  [SigningExample.sh](https://github.com/TheJumpCloud/SystemContextAPI/blob/master/examples/shell/SigningExample.sh)  ### Shutdown Hook  This example demonstrates how to make an authenticated request on system shutdown. Using an init.d script registered at run level 0, you can call the System Context API as the system is shutting down.  [Instance-shutdown-initd](https://github.com/TheJumpCloud/SystemContextAPI/blob/master/examples/instance-shutdown-initd) is an example of an init.d script that only runs at system shutdown.  After customizing the [instance-shutdown-initd](https://github.com/TheJumpCloud/SystemContextAPI/blob/master/examples/instance-shutdown-initd) script, you should install it on the system(s) running the JumpCloud agent.  1. Copy the modified [instance-shutdown-initd](https://github.com/TheJumpCloud/SystemContextAPI/blob/master/examples/instance-shutdown-initd) to `/etc/init.d/instance-shutdown`. 2. On Ubuntu systems, run `update-rc.d instance-shutdown defaults`. On RedHat/CentOS systems, run `chkconfig --add instance-shutdown`.  ## Third Party  ### Chef Cookbooks  [https://github.com/nshenry03/jumpcloud](https://github.com/nshenry03/jumpcloud)  [https://github.com/cjs226/jumpcloud](https://github.com/cjs226/jumpcloud)  # Multi-Tenant Portal Headers  Multi-Tenant Organization API Headers are available for JumpCloud Admins to use when making API requests from Organizations that have multiple managed organizations.  The `x-org-id` is a required header for all multi-tenant admins when making API requests to JumpCloud. This header will define to which organization you would like to make the request.  **NOTE** Single Tenant Admins do not need to provide this header when making an API request.  ## Header Value  `x-org-id`  ## API Response Codes  * `400` Malformed ID. * `400` x-org-id and Organization path ID do not match. * `401` ID not included for multi-tenant admin * `403` ID included on unsupported route. * `404` Organization ID Not Found.  ```bash curl -X GET https://console.jumpcloud.com/api/v2/directories \\   -H 'accept: application/json' \\   -H 'content-type: application/json' \\   -H 'x-api-key: {API_KEY}' \\   -H 'x-org-id: {ORG_ID}'  ```  ## To Obtain an Individual Organization ID via the UI  As a prerequisite, your Primary Organization will need to be setup for Multi-Tenancy. This provides access to the Multi-Tenant Organization Admin Portal.  1. Log into JumpCloud [Admin Console](https://console.jumpcloud.com). If you are a multi-tenant Admin, you will automatically be routed to the Multi-Tenant Admin Portal. 2. From the Multi-Tenant Portal's primary navigation bar, select the Organization you'd like to access. 3. You will automatically be routed to that Organization's Admin Console. 4. Go to Settings in the sub-tenant's primary navigation. 5. You can obtain your Organization ID below your Organization's Contact Information on the Settings page.  ## To Obtain All Organization IDs via the API  * You can make an API request to this endpoint using the API key of your Primary Organization.  `https://console.jumpcloud.com/api/organizations/` This will return all your managed organizations.  ```bash curl -X GET \\   https://console.jumpcloud.com/api/organizations/ \\   -H 'Accept: application/json' \\   -H 'Content-Type: application/json' \\   -H 'x-api-key: {API_KEY}' ```  # SDKs  You can find language specific SDKs that can help you kickstart your Integration with JumpCloud in the following GitHub repositories:  * [Python](https://github.com/TheJumpCloud/jcapi-python) * [Go](https://github.com/TheJumpCloud/jcapi-go) * [Ruby](https://github.com/TheJumpCloud/jcapi-ruby) * [Java](https://github.com/TheJumpCloud/jcapi-java) 
 *
 * OpenAPI spec version: 1.0
 * Contact: support@jumpcloud.com
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
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * Command
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-10-19T07:50:09.958678Z[Etc/UTC]")
public class Command {
  @SerializedName("command")
  private String command = null;

  @SerializedName("commandRunners")
  private List<String> commandRunners = null;

  @SerializedName("commandType")
  private String commandType = "linux";

  @SerializedName("files")
  private List<String> files = null;

  @SerializedName("launchType")
  private String launchType = null;

  @SerializedName("listensTo")
  private String listensTo = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("organization")
  private String organization = null;

  @SerializedName("schedule")
  private String schedule = null;

  @SerializedName("scheduleRepeatType")
  private String scheduleRepeatType = null;

  @SerializedName("scheduleYear")
  private Integer scheduleYear = null;

  @SerializedName("shell")
  private String shell = null;

  @SerializedName("sudo")
  private Boolean sudo = null;

  @SerializedName("systems")
  private List<String> systems = null;

  @SerializedName("template")
  private String template = null;

  @SerializedName("timeToLiveSeconds")
  private Integer timeToLiveSeconds = null;

  @SerializedName("timeout")
  private String timeout = null;

  @SerializedName("trigger")
  private String trigger = null;

  @SerializedName("user")
  private String user = null;

  public Command command(String command) {
    this.command = command;
    return this;
  }

   /**
   * The command to execute on the server.
   * @return command
  **/
  @Schema(required = true, description = "The command to execute on the server.")
  public String getCommand() {
    return command;
  }

  public void setCommand(String command) {
    this.command = command;
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
  @Schema(description = "An array of IDs of the Command Runner Users that can execute this command.")
  public List<String> getCommandRunners() {
    return commandRunners;
  }

  public void setCommandRunners(List<String> commandRunners) {
    this.commandRunners = commandRunners;
  }

  public Command commandType(String commandType) {
    this.commandType = commandType;
    return this;
  }

   /**
   * The Command OS
   * @return commandType
  **/
  @Schema(required = true, description = "The Command OS")
  public String getCommandType() {
    return commandType;
  }

  public void setCommandType(String commandType) {
    this.commandType = commandType;
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
  @Schema(description = "An array of file IDs to include with the command.")
  public List<String> getFiles() {
    return files;
  }

  public void setFiles(List<String> files) {
    this.files = files;
  }

  public Command launchType(String launchType) {
    this.launchType = launchType;
    return this;
  }

   /**
   * How the command will execute.
   * @return launchType
  **/
  @Schema(description = "How the command will execute.")
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
   * Get listensTo
   * @return listensTo
  **/
  @Schema(description = "")
  public String getListensTo() {
    return listensTo;
  }

  public void setListensTo(String listensTo) {
    this.listensTo = listensTo;
  }

  public Command name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @Schema(required = true, description = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Command organization(String organization) {
    this.organization = organization;
    return this;
  }

   /**
   * The ID of the organization.
   * @return organization
  **/
  @Schema(description = "The ID of the organization.")
  public String getOrganization() {
    return organization;
  }

  public void setOrganization(String organization) {
    this.organization = organization;
  }

  public Command schedule(String schedule) {
    this.schedule = schedule;
    return this;
  }

   /**
   * A crontab that consists of: [ (seconds) (minutes) (hours) (days of month) (months) (weekdays) ] or [ immediate ]. If you send this as an empty string, it will run immediately. 
   * @return schedule
  **/
  @Schema(description = "A crontab that consists of: [ (seconds) (minutes) (hours) (days of month) (months) (weekdays) ] or [ immediate ]. If you send this as an empty string, it will run immediately. ")
  public String getSchedule() {
    return schedule;
  }

  public void setSchedule(String schedule) {
    this.schedule = schedule;
  }

  public Command scheduleRepeatType(String scheduleRepeatType) {
    this.scheduleRepeatType = scheduleRepeatType;
    return this;
  }

   /**
   * When the command will repeat.
   * @return scheduleRepeatType
  **/
  @Schema(description = "When the command will repeat.")
  public String getScheduleRepeatType() {
    return scheduleRepeatType;
  }

  public void setScheduleRepeatType(String scheduleRepeatType) {
    this.scheduleRepeatType = scheduleRepeatType;
  }

  public Command scheduleYear(Integer scheduleYear) {
    this.scheduleYear = scheduleYear;
    return this;
  }

   /**
   * The year that a scheduled command will launch in.
   * @return scheduleYear
  **/
  @Schema(description = "The year that a scheduled command will launch in.")
  public Integer getScheduleYear() {
    return scheduleYear;
  }

  public void setScheduleYear(Integer scheduleYear) {
    this.scheduleYear = scheduleYear;
  }

  public Command shell(String shell) {
    this.shell = shell;
    return this;
  }

   /**
   * The shell used to run the command.
   * @return shell
  **/
  @Schema(description = "The shell used to run the command.")
  public String getShell() {
    return shell;
  }

  public void setShell(String shell) {
    this.shell = shell;
  }

  public Command sudo(Boolean sudo) {
    this.sudo = sudo;
    return this;
  }

   /**
   * Get sudo
   * @return sudo
  **/
  @Schema(description = "")
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
  @Schema(description = "An array of system IDs to run the command on. Not available if you are using Groups.")
  public List<String> getSystems() {
    return systems;
  }

  public void setSystems(List<String> systems) {
    this.systems = systems;
  }

  public Command template(String template) {
    this.template = template;
    return this;
  }

   /**
   * The template this command was created from
   * @return template
  **/
  @Schema(description = "The template this command was created from")
  public String getTemplate() {
    return template;
  }

  public void setTemplate(String template) {
    this.template = template;
  }

  public Command timeToLiveSeconds(Integer timeToLiveSeconds) {
    this.timeToLiveSeconds = timeToLiveSeconds;
    return this;
  }

   /**
   * Time in seconds a command can wait in the queue to be run before timing out
   * @return timeToLiveSeconds
  **/
  @Schema(description = "Time in seconds a command can wait in the queue to be run before timing out")
  public Integer getTimeToLiveSeconds() {
    return timeToLiveSeconds;
  }

  public void setTimeToLiveSeconds(Integer timeToLiveSeconds) {
    this.timeToLiveSeconds = timeToLiveSeconds;
  }

  public Command timeout(String timeout) {
    this.timeout = timeout;
    return this;
  }

   /**
   * The time in seconds to allow the command to run for.
   * @return timeout
  **/
  @Schema(description = "The time in seconds to allow the command to run for.")
  public String getTimeout() {
    return timeout;
  }

  public void setTimeout(String timeout) {
    this.timeout = timeout;
  }

  public Command trigger(String trigger) {
    this.trigger = trigger;
    return this;
  }

   /**
   * The name of the command trigger.
   * @return trigger
  **/
  @Schema(description = "The name of the command trigger.")
  public String getTrigger() {
    return trigger;
  }

  public void setTrigger(String trigger) {
    this.trigger = trigger;
  }

  public Command user(String user) {
    this.user = user;
    return this;
  }

   /**
   * The ID of the system user to run the command as. This field is required when creating a command with a commandType of \&quot;mac\&quot; or \&quot;linux\&quot;.
   * @return user
  **/
  @Schema(description = "The ID of the system user to run the command as. This field is required when creating a command with a commandType of \"mac\" or \"linux\".")
  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
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
    return Objects.equals(this.command, command.command) &&
        Objects.equals(this.commandRunners, command.commandRunners) &&
        Objects.equals(this.commandType, command.commandType) &&
        Objects.equals(this.files, command.files) &&
        Objects.equals(this.launchType, command.launchType) &&
        Objects.equals(this.listensTo, command.listensTo) &&
        Objects.equals(this.name, command.name) &&
        Objects.equals(this.organization, command.organization) &&
        Objects.equals(this.schedule, command.schedule) &&
        Objects.equals(this.scheduleRepeatType, command.scheduleRepeatType) &&
        Objects.equals(this.scheduleYear, command.scheduleYear) &&
        Objects.equals(this.shell, command.shell) &&
        Objects.equals(this.sudo, command.sudo) &&
        Objects.equals(this.systems, command.systems) &&
        Objects.equals(this.template, command.template) &&
        Objects.equals(this.timeToLiveSeconds, command.timeToLiveSeconds) &&
        Objects.equals(this.timeout, command.timeout) &&
        Objects.equals(this.trigger, command.trigger) &&
        Objects.equals(this.user, command.user);
  }

  @Override
  public int hashCode() {
    return Objects.hash(command, commandRunners, commandType, files, launchType, listensTo, name, organization, schedule, scheduleRepeatType, scheduleYear, shell, sudo, systems, template, timeToLiveSeconds, timeout, trigger, user);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Command {\n");
    
    sb.append("    command: ").append(toIndentedString(command)).append("\n");
    sb.append("    commandRunners: ").append(toIndentedString(commandRunners)).append("\n");
    sb.append("    commandType: ").append(toIndentedString(commandType)).append("\n");
    sb.append("    files: ").append(toIndentedString(files)).append("\n");
    sb.append("    launchType: ").append(toIndentedString(launchType)).append("\n");
    sb.append("    listensTo: ").append(toIndentedString(listensTo)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    organization: ").append(toIndentedString(organization)).append("\n");
    sb.append("    schedule: ").append(toIndentedString(schedule)).append("\n");
    sb.append("    scheduleRepeatType: ").append(toIndentedString(scheduleRepeatType)).append("\n");
    sb.append("    scheduleYear: ").append(toIndentedString(scheduleYear)).append("\n");
    sb.append("    shell: ").append(toIndentedString(shell)).append("\n");
    sb.append("    sudo: ").append(toIndentedString(sudo)).append("\n");
    sb.append("    systems: ").append(toIndentedString(systems)).append("\n");
    sb.append("    template: ").append(toIndentedString(template)).append("\n");
    sb.append("    timeToLiveSeconds: ").append(toIndentedString(timeToLiveSeconds)).append("\n");
    sb.append("    timeout: ").append(toIndentedString(timeout)).append("\n");
    sb.append("    trigger: ").append(toIndentedString(trigger)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
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
