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
import java.io.IOException;

/**
 * OrganizationsettingsPasswordPolicy
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-12-09T23:53:52.741Z")
public class OrganizationsettingsPasswordPolicy {
  @SerializedName("allowUsernameSubstring")
  private Boolean allowUsernameSubstring = null;

  @SerializedName("daysAfterExpirationToSelfRecover")
  private Integer daysAfterExpirationToSelfRecover = null;

  @SerializedName("daysBeforeExpirationToForceReset")
  private Integer daysBeforeExpirationToForceReset = null;

  @SerializedName("enableDaysAfterExpirationToSelfRecover")
  private Boolean enableDaysAfterExpirationToSelfRecover = null;

  @SerializedName("enableDaysBeforeExpirationToForceReset")
  private Boolean enableDaysBeforeExpirationToForceReset = null;

  @SerializedName("enableLockoutTimeInSeconds")
  private Boolean enableLockoutTimeInSeconds = null;

  @SerializedName("enableMaxHistory")
  private Boolean enableMaxHistory = null;

  @SerializedName("enableMaxLoginAttempts")
  private Boolean enableMaxLoginAttempts = null;

  @SerializedName("enableMinChangePeriodInDays")
  private Boolean enableMinChangePeriodInDays = null;

  @SerializedName("enableMinLength")
  private Boolean enableMinLength = null;

  @SerializedName("enablePasswordExpirationInDays")
  private Boolean enablePasswordExpirationInDays = null;

  @SerializedName("lockoutTimeInSeconds")
  private Integer lockoutTimeInSeconds = null;

  @SerializedName("maxHistory")
  private Integer maxHistory = null;

  @SerializedName("maxLoginAttempts")
  private Integer maxLoginAttempts = null;

  @SerializedName("minChangePeriodInDays")
  private Integer minChangePeriodInDays = null;

  @SerializedName("minLength")
  private Integer minLength = null;

  @SerializedName("needsLowercase")
  private Boolean needsLowercase = null;

  @SerializedName("needsNumeric")
  private Boolean needsNumeric = null;

  @SerializedName("needsSymbolic")
  private Boolean needsSymbolic = null;

  @SerializedName("needsUppercase")
  private Boolean needsUppercase = null;

  @SerializedName("passwordExpirationInDays")
  private Integer passwordExpirationInDays = null;

  public OrganizationsettingsPasswordPolicy allowUsernameSubstring(Boolean allowUsernameSubstring) {
    this.allowUsernameSubstring = allowUsernameSubstring;
    return this;
  }

   /**
   * Get allowUsernameSubstring
   * @return allowUsernameSubstring
  **/
  @ApiModelProperty(value = "")
  public Boolean isAllowUsernameSubstring() {
    return allowUsernameSubstring;
  }

  public void setAllowUsernameSubstring(Boolean allowUsernameSubstring) {
    this.allowUsernameSubstring = allowUsernameSubstring;
  }

  public OrganizationsettingsPasswordPolicy daysAfterExpirationToSelfRecover(Integer daysAfterExpirationToSelfRecover) {
    this.daysAfterExpirationToSelfRecover = daysAfterExpirationToSelfRecover;
    return this;
  }

   /**
   * Get daysAfterExpirationToSelfRecover
   * minimum: 1
   * @return daysAfterExpirationToSelfRecover
  **/
  @ApiModelProperty(value = "")
  public Integer getDaysAfterExpirationToSelfRecover() {
    return daysAfterExpirationToSelfRecover;
  }

  public void setDaysAfterExpirationToSelfRecover(Integer daysAfterExpirationToSelfRecover) {
    this.daysAfterExpirationToSelfRecover = daysAfterExpirationToSelfRecover;
  }

  public OrganizationsettingsPasswordPolicy daysBeforeExpirationToForceReset(Integer daysBeforeExpirationToForceReset) {
    this.daysBeforeExpirationToForceReset = daysBeforeExpirationToForceReset;
    return this;
  }

   /**
   * Get daysBeforeExpirationToForceReset
   * minimum: 1
   * @return daysBeforeExpirationToForceReset
  **/
  @ApiModelProperty(value = "")
  public Integer getDaysBeforeExpirationToForceReset() {
    return daysBeforeExpirationToForceReset;
  }

  public void setDaysBeforeExpirationToForceReset(Integer daysBeforeExpirationToForceReset) {
    this.daysBeforeExpirationToForceReset = daysBeforeExpirationToForceReset;
  }

  public OrganizationsettingsPasswordPolicy enableDaysAfterExpirationToSelfRecover(Boolean enableDaysAfterExpirationToSelfRecover) {
    this.enableDaysAfterExpirationToSelfRecover = enableDaysAfterExpirationToSelfRecover;
    return this;
  }

   /**
   * Get enableDaysAfterExpirationToSelfRecover
   * @return enableDaysAfterExpirationToSelfRecover
  **/
  @ApiModelProperty(value = "")
  public Boolean isEnableDaysAfterExpirationToSelfRecover() {
    return enableDaysAfterExpirationToSelfRecover;
  }

  public void setEnableDaysAfterExpirationToSelfRecover(Boolean enableDaysAfterExpirationToSelfRecover) {
    this.enableDaysAfterExpirationToSelfRecover = enableDaysAfterExpirationToSelfRecover;
  }

  public OrganizationsettingsPasswordPolicy enableDaysBeforeExpirationToForceReset(Boolean enableDaysBeforeExpirationToForceReset) {
    this.enableDaysBeforeExpirationToForceReset = enableDaysBeforeExpirationToForceReset;
    return this;
  }

   /**
   * Get enableDaysBeforeExpirationToForceReset
   * @return enableDaysBeforeExpirationToForceReset
  **/
  @ApiModelProperty(value = "")
  public Boolean isEnableDaysBeforeExpirationToForceReset() {
    return enableDaysBeforeExpirationToForceReset;
  }

  public void setEnableDaysBeforeExpirationToForceReset(Boolean enableDaysBeforeExpirationToForceReset) {
    this.enableDaysBeforeExpirationToForceReset = enableDaysBeforeExpirationToForceReset;
  }

  public OrganizationsettingsPasswordPolicy enableLockoutTimeInSeconds(Boolean enableLockoutTimeInSeconds) {
    this.enableLockoutTimeInSeconds = enableLockoutTimeInSeconds;
    return this;
  }

   /**
   * Get enableLockoutTimeInSeconds
   * @return enableLockoutTimeInSeconds
  **/
  @ApiModelProperty(value = "")
  public Boolean isEnableLockoutTimeInSeconds() {
    return enableLockoutTimeInSeconds;
  }

  public void setEnableLockoutTimeInSeconds(Boolean enableLockoutTimeInSeconds) {
    this.enableLockoutTimeInSeconds = enableLockoutTimeInSeconds;
  }

  public OrganizationsettingsPasswordPolicy enableMaxHistory(Boolean enableMaxHistory) {
    this.enableMaxHistory = enableMaxHistory;
    return this;
  }

   /**
   * Get enableMaxHistory
   * @return enableMaxHistory
  **/
  @ApiModelProperty(value = "")
  public Boolean isEnableMaxHistory() {
    return enableMaxHistory;
  }

  public void setEnableMaxHistory(Boolean enableMaxHistory) {
    this.enableMaxHistory = enableMaxHistory;
  }

  public OrganizationsettingsPasswordPolicy enableMaxLoginAttempts(Boolean enableMaxLoginAttempts) {
    this.enableMaxLoginAttempts = enableMaxLoginAttempts;
    return this;
  }

   /**
   * Get enableMaxLoginAttempts
   * @return enableMaxLoginAttempts
  **/
  @ApiModelProperty(value = "")
  public Boolean isEnableMaxLoginAttempts() {
    return enableMaxLoginAttempts;
  }

  public void setEnableMaxLoginAttempts(Boolean enableMaxLoginAttempts) {
    this.enableMaxLoginAttempts = enableMaxLoginAttempts;
  }

  public OrganizationsettingsPasswordPolicy enableMinChangePeriodInDays(Boolean enableMinChangePeriodInDays) {
    this.enableMinChangePeriodInDays = enableMinChangePeriodInDays;
    return this;
  }

   /**
   * Get enableMinChangePeriodInDays
   * @return enableMinChangePeriodInDays
  **/
  @ApiModelProperty(value = "")
  public Boolean isEnableMinChangePeriodInDays() {
    return enableMinChangePeriodInDays;
  }

  public void setEnableMinChangePeriodInDays(Boolean enableMinChangePeriodInDays) {
    this.enableMinChangePeriodInDays = enableMinChangePeriodInDays;
  }

  public OrganizationsettingsPasswordPolicy enableMinLength(Boolean enableMinLength) {
    this.enableMinLength = enableMinLength;
    return this;
  }

   /**
   * Get enableMinLength
   * @return enableMinLength
  **/
  @ApiModelProperty(value = "")
  public Boolean isEnableMinLength() {
    return enableMinLength;
  }

  public void setEnableMinLength(Boolean enableMinLength) {
    this.enableMinLength = enableMinLength;
  }

  public OrganizationsettingsPasswordPolicy enablePasswordExpirationInDays(Boolean enablePasswordExpirationInDays) {
    this.enablePasswordExpirationInDays = enablePasswordExpirationInDays;
    return this;
  }

   /**
   * Get enablePasswordExpirationInDays
   * @return enablePasswordExpirationInDays
  **/
  @ApiModelProperty(value = "")
  public Boolean isEnablePasswordExpirationInDays() {
    return enablePasswordExpirationInDays;
  }

  public void setEnablePasswordExpirationInDays(Boolean enablePasswordExpirationInDays) {
    this.enablePasswordExpirationInDays = enablePasswordExpirationInDays;
  }

  public OrganizationsettingsPasswordPolicy lockoutTimeInSeconds(Integer lockoutTimeInSeconds) {
    this.lockoutTimeInSeconds = lockoutTimeInSeconds;
    return this;
  }

   /**
   * Get lockoutTimeInSeconds
   * @return lockoutTimeInSeconds
  **/
  @ApiModelProperty(value = "")
  public Integer getLockoutTimeInSeconds() {
    return lockoutTimeInSeconds;
  }

  public void setLockoutTimeInSeconds(Integer lockoutTimeInSeconds) {
    this.lockoutTimeInSeconds = lockoutTimeInSeconds;
  }

  public OrganizationsettingsPasswordPolicy maxHistory(Integer maxHistory) {
    this.maxHistory = maxHistory;
    return this;
  }

   /**
   * Get maxHistory
   * minimum: 1
   * maximum: 10
   * @return maxHistory
  **/
  @ApiModelProperty(value = "")
  public Integer getMaxHistory() {
    return maxHistory;
  }

  public void setMaxHistory(Integer maxHistory) {
    this.maxHistory = maxHistory;
  }

  public OrganizationsettingsPasswordPolicy maxLoginAttempts(Integer maxLoginAttempts) {
    this.maxLoginAttempts = maxLoginAttempts;
    return this;
  }

   /**
   * Get maxLoginAttempts
   * minimum: 0
   * @return maxLoginAttempts
  **/
  @ApiModelProperty(value = "")
  public Integer getMaxLoginAttempts() {
    return maxLoginAttempts;
  }

  public void setMaxLoginAttempts(Integer maxLoginAttempts) {
    this.maxLoginAttempts = maxLoginAttempts;
  }

  public OrganizationsettingsPasswordPolicy minChangePeriodInDays(Integer minChangePeriodInDays) {
    this.minChangePeriodInDays = minChangePeriodInDays;
    return this;
  }

   /**
   * Get minChangePeriodInDays
   * @return minChangePeriodInDays
  **/
  @ApiModelProperty(value = "")
  public Integer getMinChangePeriodInDays() {
    return minChangePeriodInDays;
  }

  public void setMinChangePeriodInDays(Integer minChangePeriodInDays) {
    this.minChangePeriodInDays = minChangePeriodInDays;
  }

  public OrganizationsettingsPasswordPolicy minLength(Integer minLength) {
    this.minLength = minLength;
    return this;
  }

   /**
   * Get minLength
   * @return minLength
  **/
  @ApiModelProperty(value = "")
  public Integer getMinLength() {
    return minLength;
  }

  public void setMinLength(Integer minLength) {
    this.minLength = minLength;
  }

  public OrganizationsettingsPasswordPolicy needsLowercase(Boolean needsLowercase) {
    this.needsLowercase = needsLowercase;
    return this;
  }

   /**
   * Get needsLowercase
   * @return needsLowercase
  **/
  @ApiModelProperty(value = "")
  public Boolean isNeedsLowercase() {
    return needsLowercase;
  }

  public void setNeedsLowercase(Boolean needsLowercase) {
    this.needsLowercase = needsLowercase;
  }

  public OrganizationsettingsPasswordPolicy needsNumeric(Boolean needsNumeric) {
    this.needsNumeric = needsNumeric;
    return this;
  }

   /**
   * Get needsNumeric
   * @return needsNumeric
  **/
  @ApiModelProperty(value = "")
  public Boolean isNeedsNumeric() {
    return needsNumeric;
  }

  public void setNeedsNumeric(Boolean needsNumeric) {
    this.needsNumeric = needsNumeric;
  }

  public OrganizationsettingsPasswordPolicy needsSymbolic(Boolean needsSymbolic) {
    this.needsSymbolic = needsSymbolic;
    return this;
  }

   /**
   * Get needsSymbolic
   * @return needsSymbolic
  **/
  @ApiModelProperty(value = "")
  public Boolean isNeedsSymbolic() {
    return needsSymbolic;
  }

  public void setNeedsSymbolic(Boolean needsSymbolic) {
    this.needsSymbolic = needsSymbolic;
  }

  public OrganizationsettingsPasswordPolicy needsUppercase(Boolean needsUppercase) {
    this.needsUppercase = needsUppercase;
    return this;
  }

   /**
   * Get needsUppercase
   * @return needsUppercase
  **/
  @ApiModelProperty(value = "")
  public Boolean isNeedsUppercase() {
    return needsUppercase;
  }

  public void setNeedsUppercase(Boolean needsUppercase) {
    this.needsUppercase = needsUppercase;
  }

  public OrganizationsettingsPasswordPolicy passwordExpirationInDays(Integer passwordExpirationInDays) {
    this.passwordExpirationInDays = passwordExpirationInDays;
    return this;
  }

   /**
   * Get passwordExpirationInDays
   * minimum: 1
   * @return passwordExpirationInDays
  **/
  @ApiModelProperty(value = "")
  public Integer getPasswordExpirationInDays() {
    return passwordExpirationInDays;
  }

  public void setPasswordExpirationInDays(Integer passwordExpirationInDays) {
    this.passwordExpirationInDays = passwordExpirationInDays;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrganizationsettingsPasswordPolicy organizationsettingsPasswordPolicy = (OrganizationsettingsPasswordPolicy) o;
    return Objects.equals(this.allowUsernameSubstring, organizationsettingsPasswordPolicy.allowUsernameSubstring) &&
        Objects.equals(this.daysAfterExpirationToSelfRecover, organizationsettingsPasswordPolicy.daysAfterExpirationToSelfRecover) &&
        Objects.equals(this.daysBeforeExpirationToForceReset, organizationsettingsPasswordPolicy.daysBeforeExpirationToForceReset) &&
        Objects.equals(this.enableDaysAfterExpirationToSelfRecover, organizationsettingsPasswordPolicy.enableDaysAfterExpirationToSelfRecover) &&
        Objects.equals(this.enableDaysBeforeExpirationToForceReset, organizationsettingsPasswordPolicy.enableDaysBeforeExpirationToForceReset) &&
        Objects.equals(this.enableLockoutTimeInSeconds, organizationsettingsPasswordPolicy.enableLockoutTimeInSeconds) &&
        Objects.equals(this.enableMaxHistory, organizationsettingsPasswordPolicy.enableMaxHistory) &&
        Objects.equals(this.enableMaxLoginAttempts, organizationsettingsPasswordPolicy.enableMaxLoginAttempts) &&
        Objects.equals(this.enableMinChangePeriodInDays, organizationsettingsPasswordPolicy.enableMinChangePeriodInDays) &&
        Objects.equals(this.enableMinLength, organizationsettingsPasswordPolicy.enableMinLength) &&
        Objects.equals(this.enablePasswordExpirationInDays, organizationsettingsPasswordPolicy.enablePasswordExpirationInDays) &&
        Objects.equals(this.lockoutTimeInSeconds, organizationsettingsPasswordPolicy.lockoutTimeInSeconds) &&
        Objects.equals(this.maxHistory, organizationsettingsPasswordPolicy.maxHistory) &&
        Objects.equals(this.maxLoginAttempts, organizationsettingsPasswordPolicy.maxLoginAttempts) &&
        Objects.equals(this.minChangePeriodInDays, organizationsettingsPasswordPolicy.minChangePeriodInDays) &&
        Objects.equals(this.minLength, organizationsettingsPasswordPolicy.minLength) &&
        Objects.equals(this.needsLowercase, organizationsettingsPasswordPolicy.needsLowercase) &&
        Objects.equals(this.needsNumeric, organizationsettingsPasswordPolicy.needsNumeric) &&
        Objects.equals(this.needsSymbolic, organizationsettingsPasswordPolicy.needsSymbolic) &&
        Objects.equals(this.needsUppercase, organizationsettingsPasswordPolicy.needsUppercase) &&
        Objects.equals(this.passwordExpirationInDays, organizationsettingsPasswordPolicy.passwordExpirationInDays);
  }

  @Override
  public int hashCode() {
    return Objects.hash(allowUsernameSubstring, daysAfterExpirationToSelfRecover, daysBeforeExpirationToForceReset, enableDaysAfterExpirationToSelfRecover, enableDaysBeforeExpirationToForceReset, enableLockoutTimeInSeconds, enableMaxHistory, enableMaxLoginAttempts, enableMinChangePeriodInDays, enableMinLength, enablePasswordExpirationInDays, lockoutTimeInSeconds, maxHistory, maxLoginAttempts, minChangePeriodInDays, minLength, needsLowercase, needsNumeric, needsSymbolic, needsUppercase, passwordExpirationInDays);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrganizationsettingsPasswordPolicy {\n");
    
    sb.append("    allowUsernameSubstring: ").append(toIndentedString(allowUsernameSubstring)).append("\n");
    sb.append("    daysAfterExpirationToSelfRecover: ").append(toIndentedString(daysAfterExpirationToSelfRecover)).append("\n");
    sb.append("    daysBeforeExpirationToForceReset: ").append(toIndentedString(daysBeforeExpirationToForceReset)).append("\n");
    sb.append("    enableDaysAfterExpirationToSelfRecover: ").append(toIndentedString(enableDaysAfterExpirationToSelfRecover)).append("\n");
    sb.append("    enableDaysBeforeExpirationToForceReset: ").append(toIndentedString(enableDaysBeforeExpirationToForceReset)).append("\n");
    sb.append("    enableLockoutTimeInSeconds: ").append(toIndentedString(enableLockoutTimeInSeconds)).append("\n");
    sb.append("    enableMaxHistory: ").append(toIndentedString(enableMaxHistory)).append("\n");
    sb.append("    enableMaxLoginAttempts: ").append(toIndentedString(enableMaxLoginAttempts)).append("\n");
    sb.append("    enableMinChangePeriodInDays: ").append(toIndentedString(enableMinChangePeriodInDays)).append("\n");
    sb.append("    enableMinLength: ").append(toIndentedString(enableMinLength)).append("\n");
    sb.append("    enablePasswordExpirationInDays: ").append(toIndentedString(enablePasswordExpirationInDays)).append("\n");
    sb.append("    lockoutTimeInSeconds: ").append(toIndentedString(lockoutTimeInSeconds)).append("\n");
    sb.append("    maxHistory: ").append(toIndentedString(maxHistory)).append("\n");
    sb.append("    maxLoginAttempts: ").append(toIndentedString(maxLoginAttempts)).append("\n");
    sb.append("    minChangePeriodInDays: ").append(toIndentedString(minChangePeriodInDays)).append("\n");
    sb.append("    minLength: ").append(toIndentedString(minLength)).append("\n");
    sb.append("    needsLowercase: ").append(toIndentedString(needsLowercase)).append("\n");
    sb.append("    needsNumeric: ").append(toIndentedString(needsNumeric)).append("\n");
    sb.append("    needsSymbolic: ").append(toIndentedString(needsSymbolic)).append("\n");
    sb.append("    needsUppercase: ").append(toIndentedString(needsUppercase)).append("\n");
    sb.append("    passwordExpirationInDays: ").append(toIndentedString(passwordExpirationInDays)).append("\n");
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

