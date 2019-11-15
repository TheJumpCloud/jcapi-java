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
 * SystemInsightsWindowsCrashes
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-11-15T20:11:23.142Z")
public class SystemInsightsWindowsCrashes {
  @SerializedName("build_number")
  private Integer buildNumber = null;

  @SerializedName("command_line")
  private String commandLine = null;

  @SerializedName("crash_path")
  private String crashPath = null;

  @SerializedName("current_directory")
  private String currentDirectory = null;

  @SerializedName("datetime")
  private String datetime = null;

  @SerializedName("exception_address")
  private String exceptionAddress = null;

  @SerializedName("exception_code")
  private String exceptionCode = null;

  @SerializedName("exception_message")
  private String exceptionMessage = null;

  @SerializedName("machine_name")
  private String machineName = null;

  @SerializedName("major_version")
  private Integer majorVersion = null;

  @SerializedName("minor_version")
  private Integer minorVersion = null;

  @SerializedName("module")
  private String module = null;

  @SerializedName("path")
  private String path = null;

  @SerializedName("pid")
  private String pid = null;

  @SerializedName("process_uptime")
  private String processUptime = null;

  @SerializedName("registers")
  private String registers = null;

  @SerializedName("stack_trace")
  private String stackTrace = null;

  @SerializedName("tid")
  private String tid = null;

  @SerializedName("type")
  private String type = null;

  @SerializedName("username")
  private String username = null;

  @SerializedName("version")
  private String version = null;

  public SystemInsightsWindowsCrashes buildNumber(Integer buildNumber) {
    this.buildNumber = buildNumber;
    return this;
  }

   /**
   * Get buildNumber
   * @return buildNumber
  **/
  @ApiModelProperty(value = "")
  public Integer getBuildNumber() {
    return buildNumber;
  }

  public void setBuildNumber(Integer buildNumber) {
    this.buildNumber = buildNumber;
  }

  public SystemInsightsWindowsCrashes commandLine(String commandLine) {
    this.commandLine = commandLine;
    return this;
  }

   /**
   * Get commandLine
   * @return commandLine
  **/
  @ApiModelProperty(value = "")
  public String getCommandLine() {
    return commandLine;
  }

  public void setCommandLine(String commandLine) {
    this.commandLine = commandLine;
  }

  public SystemInsightsWindowsCrashes crashPath(String crashPath) {
    this.crashPath = crashPath;
    return this;
  }

   /**
   * Get crashPath
   * @return crashPath
  **/
  @ApiModelProperty(value = "")
  public String getCrashPath() {
    return crashPath;
  }

  public void setCrashPath(String crashPath) {
    this.crashPath = crashPath;
  }

  public SystemInsightsWindowsCrashes currentDirectory(String currentDirectory) {
    this.currentDirectory = currentDirectory;
    return this;
  }

   /**
   * Get currentDirectory
   * @return currentDirectory
  **/
  @ApiModelProperty(value = "")
  public String getCurrentDirectory() {
    return currentDirectory;
  }

  public void setCurrentDirectory(String currentDirectory) {
    this.currentDirectory = currentDirectory;
  }

  public SystemInsightsWindowsCrashes datetime(String datetime) {
    this.datetime = datetime;
    return this;
  }

   /**
   * Get datetime
   * @return datetime
  **/
  @ApiModelProperty(value = "")
  public String getDatetime() {
    return datetime;
  }

  public void setDatetime(String datetime) {
    this.datetime = datetime;
  }

  public SystemInsightsWindowsCrashes exceptionAddress(String exceptionAddress) {
    this.exceptionAddress = exceptionAddress;
    return this;
  }

   /**
   * Get exceptionAddress
   * @return exceptionAddress
  **/
  @ApiModelProperty(value = "")
  public String getExceptionAddress() {
    return exceptionAddress;
  }

  public void setExceptionAddress(String exceptionAddress) {
    this.exceptionAddress = exceptionAddress;
  }

  public SystemInsightsWindowsCrashes exceptionCode(String exceptionCode) {
    this.exceptionCode = exceptionCode;
    return this;
  }

   /**
   * Get exceptionCode
   * @return exceptionCode
  **/
  @ApiModelProperty(value = "")
  public String getExceptionCode() {
    return exceptionCode;
  }

  public void setExceptionCode(String exceptionCode) {
    this.exceptionCode = exceptionCode;
  }

  public SystemInsightsWindowsCrashes exceptionMessage(String exceptionMessage) {
    this.exceptionMessage = exceptionMessage;
    return this;
  }

   /**
   * Get exceptionMessage
   * @return exceptionMessage
  **/
  @ApiModelProperty(value = "")
  public String getExceptionMessage() {
    return exceptionMessage;
  }

  public void setExceptionMessage(String exceptionMessage) {
    this.exceptionMessage = exceptionMessage;
  }

  public SystemInsightsWindowsCrashes machineName(String machineName) {
    this.machineName = machineName;
    return this;
  }

   /**
   * Get machineName
   * @return machineName
  **/
  @ApiModelProperty(value = "")
  public String getMachineName() {
    return machineName;
  }

  public void setMachineName(String machineName) {
    this.machineName = machineName;
  }

  public SystemInsightsWindowsCrashes majorVersion(Integer majorVersion) {
    this.majorVersion = majorVersion;
    return this;
  }

   /**
   * Get majorVersion
   * @return majorVersion
  **/
  @ApiModelProperty(value = "")
  public Integer getMajorVersion() {
    return majorVersion;
  }

  public void setMajorVersion(Integer majorVersion) {
    this.majorVersion = majorVersion;
  }

  public SystemInsightsWindowsCrashes minorVersion(Integer minorVersion) {
    this.minorVersion = minorVersion;
    return this;
  }

   /**
   * Get minorVersion
   * @return minorVersion
  **/
  @ApiModelProperty(value = "")
  public Integer getMinorVersion() {
    return minorVersion;
  }

  public void setMinorVersion(Integer minorVersion) {
    this.minorVersion = minorVersion;
  }

  public SystemInsightsWindowsCrashes module(String module) {
    this.module = module;
    return this;
  }

   /**
   * Get module
   * @return module
  **/
  @ApiModelProperty(value = "")
  public String getModule() {
    return module;
  }

  public void setModule(String module) {
    this.module = module;
  }

  public SystemInsightsWindowsCrashes path(String path) {
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

  public SystemInsightsWindowsCrashes pid(String pid) {
    this.pid = pid;
    return this;
  }

   /**
   * Get pid
   * @return pid
  **/
  @ApiModelProperty(value = "")
  public String getPid() {
    return pid;
  }

  public void setPid(String pid) {
    this.pid = pid;
  }

  public SystemInsightsWindowsCrashes processUptime(String processUptime) {
    this.processUptime = processUptime;
    return this;
  }

   /**
   * Get processUptime
   * @return processUptime
  **/
  @ApiModelProperty(value = "")
  public String getProcessUptime() {
    return processUptime;
  }

  public void setProcessUptime(String processUptime) {
    this.processUptime = processUptime;
  }

  public SystemInsightsWindowsCrashes registers(String registers) {
    this.registers = registers;
    return this;
  }

   /**
   * Get registers
   * @return registers
  **/
  @ApiModelProperty(value = "")
  public String getRegisters() {
    return registers;
  }

  public void setRegisters(String registers) {
    this.registers = registers;
  }

  public SystemInsightsWindowsCrashes stackTrace(String stackTrace) {
    this.stackTrace = stackTrace;
    return this;
  }

   /**
   * Get stackTrace
   * @return stackTrace
  **/
  @ApiModelProperty(value = "")
  public String getStackTrace() {
    return stackTrace;
  }

  public void setStackTrace(String stackTrace) {
    this.stackTrace = stackTrace;
  }

  public SystemInsightsWindowsCrashes tid(String tid) {
    this.tid = tid;
    return this;
  }

   /**
   * Get tid
   * @return tid
  **/
  @ApiModelProperty(value = "")
  public String getTid() {
    return tid;
  }

  public void setTid(String tid) {
    this.tid = tid;
  }

  public SystemInsightsWindowsCrashes type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(value = "")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public SystemInsightsWindowsCrashes username(String username) {
    this.username = username;
    return this;
  }

   /**
   * Get username
   * @return username
  **/
  @ApiModelProperty(value = "")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public SystemInsightsWindowsCrashes version(String version) {
    this.version = version;
    return this;
  }

   /**
   * Get version
   * @return version
  **/
  @ApiModelProperty(value = "")
  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SystemInsightsWindowsCrashes systemInsightsWindowsCrashes = (SystemInsightsWindowsCrashes) o;
    return Objects.equals(this.buildNumber, systemInsightsWindowsCrashes.buildNumber) &&
        Objects.equals(this.commandLine, systemInsightsWindowsCrashes.commandLine) &&
        Objects.equals(this.crashPath, systemInsightsWindowsCrashes.crashPath) &&
        Objects.equals(this.currentDirectory, systemInsightsWindowsCrashes.currentDirectory) &&
        Objects.equals(this.datetime, systemInsightsWindowsCrashes.datetime) &&
        Objects.equals(this.exceptionAddress, systemInsightsWindowsCrashes.exceptionAddress) &&
        Objects.equals(this.exceptionCode, systemInsightsWindowsCrashes.exceptionCode) &&
        Objects.equals(this.exceptionMessage, systemInsightsWindowsCrashes.exceptionMessage) &&
        Objects.equals(this.machineName, systemInsightsWindowsCrashes.machineName) &&
        Objects.equals(this.majorVersion, systemInsightsWindowsCrashes.majorVersion) &&
        Objects.equals(this.minorVersion, systemInsightsWindowsCrashes.minorVersion) &&
        Objects.equals(this.module, systemInsightsWindowsCrashes.module) &&
        Objects.equals(this.path, systemInsightsWindowsCrashes.path) &&
        Objects.equals(this.pid, systemInsightsWindowsCrashes.pid) &&
        Objects.equals(this.processUptime, systemInsightsWindowsCrashes.processUptime) &&
        Objects.equals(this.registers, systemInsightsWindowsCrashes.registers) &&
        Objects.equals(this.stackTrace, systemInsightsWindowsCrashes.stackTrace) &&
        Objects.equals(this.tid, systemInsightsWindowsCrashes.tid) &&
        Objects.equals(this.type, systemInsightsWindowsCrashes.type) &&
        Objects.equals(this.username, systemInsightsWindowsCrashes.username) &&
        Objects.equals(this.version, systemInsightsWindowsCrashes.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(buildNumber, commandLine, crashPath, currentDirectory, datetime, exceptionAddress, exceptionCode, exceptionMessage, machineName, majorVersion, minorVersion, module, path, pid, processUptime, registers, stackTrace, tid, type, username, version);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemInsightsWindowsCrashes {\n");
    
    sb.append("    buildNumber: ").append(toIndentedString(buildNumber)).append("\n");
    sb.append("    commandLine: ").append(toIndentedString(commandLine)).append("\n");
    sb.append("    crashPath: ").append(toIndentedString(crashPath)).append("\n");
    sb.append("    currentDirectory: ").append(toIndentedString(currentDirectory)).append("\n");
    sb.append("    datetime: ").append(toIndentedString(datetime)).append("\n");
    sb.append("    exceptionAddress: ").append(toIndentedString(exceptionAddress)).append("\n");
    sb.append("    exceptionCode: ").append(toIndentedString(exceptionCode)).append("\n");
    sb.append("    exceptionMessage: ").append(toIndentedString(exceptionMessage)).append("\n");
    sb.append("    machineName: ").append(toIndentedString(machineName)).append("\n");
    sb.append("    majorVersion: ").append(toIndentedString(majorVersion)).append("\n");
    sb.append("    minorVersion: ").append(toIndentedString(minorVersion)).append("\n");
    sb.append("    module: ").append(toIndentedString(module)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    pid: ").append(toIndentedString(pid)).append("\n");
    sb.append("    processUptime: ").append(toIndentedString(processUptime)).append("\n");
    sb.append("    registers: ").append(toIndentedString(registers)).append("\n");
    sb.append("    stackTrace: ").append(toIndentedString(stackTrace)).append("\n");
    sb.append("    tid: ").append(toIndentedString(tid)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
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

