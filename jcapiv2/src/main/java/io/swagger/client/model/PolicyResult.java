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
import org.threeten.bp.OffsetDateTime;

/**
 * PolicyResult
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-11-21T20:17:34.763Z")
public class PolicyResult {
  @SerializedName("detail")
  private String detail = null;

  @SerializedName("endedAt")
  private OffsetDateTime endedAt = null;

  @SerializedName("exitStatus")
  private Integer exitStatus = null;

  @SerializedName("id")
  private String id = null;

  @SerializedName("policyID")
  private String policyID = null;

  @SerializedName("startedAt")
  private OffsetDateTime startedAt = null;

  @SerializedName("state")
  private String state = null;

  @SerializedName("stdErr")
  private String stdErr = null;

  @SerializedName("stdOut")
  private String stdOut = null;

  @SerializedName("success")
  private Boolean success = null;

  @SerializedName("systemID")
  private String systemID = null;

  public PolicyResult detail(String detail) {
    this.detail = detail;
    return this;
  }

   /**
   * Details pertaining to the policy result.
   * @return detail
  **/
  @ApiModelProperty(value = "Details pertaining to the policy result.")
  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  public PolicyResult endedAt(OffsetDateTime endedAt) {
    this.endedAt = endedAt;
    return this;
  }

   /**
   * The end of the policy application.
   * @return endedAt
  **/
  @ApiModelProperty(value = "The end of the policy application.")
  public OffsetDateTime getEndedAt() {
    return endedAt;
  }

  public void setEndedAt(OffsetDateTime endedAt) {
    this.endedAt = endedAt;
  }

  public PolicyResult exitStatus(Integer exitStatus) {
    this.exitStatus = exitStatus;
    return this;
  }

   /**
   * The 32-bit unsigned exit status from the applying the policy.
   * @return exitStatus
  **/
  @ApiModelProperty(value = "The 32-bit unsigned exit status from the applying the policy.")
  public Integer getExitStatus() {
    return exitStatus;
  }

  public void setExitStatus(Integer exitStatus) {
    this.exitStatus = exitStatus;
  }

  public PolicyResult id(String id) {
    this.id = id;
    return this;
  }

   /**
   * ObjectId uniquely identifying a Policy Result.
   * @return id
  **/
  @ApiModelProperty(value = "ObjectId uniquely identifying a Policy Result.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public PolicyResult policyID(String policyID) {
    this.policyID = policyID;
    return this;
  }

   /**
   * ObjectId uniquely identifying the parent Policy.
   * @return policyID
  **/
  @ApiModelProperty(value = "ObjectId uniquely identifying the parent Policy.")
  public String getPolicyID() {
    return policyID;
  }

  public void setPolicyID(String policyID) {
    this.policyID = policyID;
  }

  public PolicyResult startedAt(OffsetDateTime startedAt) {
    this.startedAt = startedAt;
    return this;
  }

   /**
   * The start of the policy application.
   * @return startedAt
  **/
  @ApiModelProperty(value = "The start of the policy application.")
  public OffsetDateTime getStartedAt() {
    return startedAt;
  }

  public void setStartedAt(OffsetDateTime startedAt) {
    this.startedAt = startedAt;
  }

  public PolicyResult state(String state) {
    this.state = state;
    return this;
  }

   /**
   * Enumeration describing the state of the policy. Success, failed, or pending.
   * @return state
  **/
  @ApiModelProperty(value = "Enumeration describing the state of the policy. Success, failed, or pending.")
  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public PolicyResult stdErr(String stdErr) {
    this.stdErr = stdErr;
    return this;
  }

   /**
   * The STDERR output from applying the policy.
   * @return stdErr
  **/
  @ApiModelProperty(value = "The STDERR output from applying the policy.")
  public String getStdErr() {
    return stdErr;
  }

  public void setStdErr(String stdErr) {
    this.stdErr = stdErr;
  }

  public PolicyResult stdOut(String stdOut) {
    this.stdOut = stdOut;
    return this;
  }

   /**
   * The STDOUT output from applying the policy.
   * @return stdOut
  **/
  @ApiModelProperty(value = "The STDOUT output from applying the policy.")
  public String getStdOut() {
    return stdOut;
  }

  public void setStdOut(String stdOut) {
    this.stdOut = stdOut;
  }

  public PolicyResult success(Boolean success) {
    this.success = success;
    return this;
  }

   /**
   * True if the policy was successfully applied; false otherwise.
   * @return success
  **/
  @ApiModelProperty(value = "True if the policy was successfully applied; false otherwise.")
  public Boolean isSuccess() {
    return success;
  }

  public void setSuccess(Boolean success) {
    this.success = success;
  }

  public PolicyResult systemID(String systemID) {
    this.systemID = systemID;
    return this;
  }

   /**
   * ObjectId uniquely identifying the parent System.
   * @return systemID
  **/
  @ApiModelProperty(value = "ObjectId uniquely identifying the parent System.")
  public String getSystemID() {
    return systemID;
  }

  public void setSystemID(String systemID) {
    this.systemID = systemID;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PolicyResult policyResult = (PolicyResult) o;
    return Objects.equals(this.detail, policyResult.detail) &&
        Objects.equals(this.endedAt, policyResult.endedAt) &&
        Objects.equals(this.exitStatus, policyResult.exitStatus) &&
        Objects.equals(this.id, policyResult.id) &&
        Objects.equals(this.policyID, policyResult.policyID) &&
        Objects.equals(this.startedAt, policyResult.startedAt) &&
        Objects.equals(this.state, policyResult.state) &&
        Objects.equals(this.stdErr, policyResult.stdErr) &&
        Objects.equals(this.stdOut, policyResult.stdOut) &&
        Objects.equals(this.success, policyResult.success) &&
        Objects.equals(this.systemID, policyResult.systemID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(detail, endedAt, exitStatus, id, policyID, startedAt, state, stdErr, stdOut, success, systemID);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PolicyResult {\n");
    
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
    sb.append("    endedAt: ").append(toIndentedString(endedAt)).append("\n");
    sb.append("    exitStatus: ").append(toIndentedString(exitStatus)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    policyID: ").append(toIndentedString(policyID)).append("\n");
    sb.append("    startedAt: ").append(toIndentedString(startedAt)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    stdErr: ").append(toIndentedString(stdErr)).append("\n");
    sb.append("    stdOut: ").append(toIndentedString(stdOut)).append("\n");
    sb.append("    success: ").append(toIndentedString(success)).append("\n");
    sb.append("    systemID: ").append(toIndentedString(systemID)).append("\n");
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

