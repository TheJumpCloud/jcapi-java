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
 * SystemInsightsSystemInfo
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-08-09T16:30:22.486Z")
public class SystemInsightsSystemInfo {
  @SerializedName("hostname")
  private String hostname = null;

  @SerializedName("uuid")
  private String uuid = null;

  @SerializedName("cpu_type")
  private String cpuType = null;

  @SerializedName("cpu_subtype")
  private String cpuSubtype = null;

  @SerializedName("cpu_brand")
  private String cpuBrand = null;

  @SerializedName("cpu_physical_cores")
  private Integer cpuPhysicalCores = null;

  @SerializedName("cpu_logical_cores")
  private Integer cpuLogicalCores = null;

  @SerializedName("cpu_microcode")
  private String cpuMicrocode = null;

  @SerializedName("physical_memory")
  private String physicalMemory = null;

  @SerializedName("hardware_vendor")
  private String hardwareVendor = null;

  @SerializedName("hardware_model")
  private String hardwareModel = null;

  @SerializedName("hardware_version")
  private String hardwareVersion = null;

  @SerializedName("hardware_serial")
  private String hardwareSerial = null;

  @SerializedName("computer_name")
  private String computerName = null;

  @SerializedName("local_hostname")
  private String localHostname = null;

  @SerializedName("jc_collection_time")
  private String jcCollectionTime = null;

  @SerializedName("jc_system_id")
  private String jcSystemId = null;

  public SystemInsightsSystemInfo hostname(String hostname) {
    this.hostname = hostname;
    return this;
  }

   /**
   * Get hostname
   * @return hostname
  **/
  @ApiModelProperty(value = "")
  public String getHostname() {
    return hostname;
  }

  public void setHostname(String hostname) {
    this.hostname = hostname;
  }

  public SystemInsightsSystemInfo uuid(String uuid) {
    this.uuid = uuid;
    return this;
  }

   /**
   * Get uuid
   * @return uuid
  **/
  @ApiModelProperty(value = "")
  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public SystemInsightsSystemInfo cpuType(String cpuType) {
    this.cpuType = cpuType;
    return this;
  }

   /**
   * Get cpuType
   * @return cpuType
  **/
  @ApiModelProperty(value = "")
  public String getCpuType() {
    return cpuType;
  }

  public void setCpuType(String cpuType) {
    this.cpuType = cpuType;
  }

  public SystemInsightsSystemInfo cpuSubtype(String cpuSubtype) {
    this.cpuSubtype = cpuSubtype;
    return this;
  }

   /**
   * Get cpuSubtype
   * @return cpuSubtype
  **/
  @ApiModelProperty(value = "")
  public String getCpuSubtype() {
    return cpuSubtype;
  }

  public void setCpuSubtype(String cpuSubtype) {
    this.cpuSubtype = cpuSubtype;
  }

  public SystemInsightsSystemInfo cpuBrand(String cpuBrand) {
    this.cpuBrand = cpuBrand;
    return this;
  }

   /**
   * Get cpuBrand
   * @return cpuBrand
  **/
  @ApiModelProperty(value = "")
  public String getCpuBrand() {
    return cpuBrand;
  }

  public void setCpuBrand(String cpuBrand) {
    this.cpuBrand = cpuBrand;
  }

  public SystemInsightsSystemInfo cpuPhysicalCores(Integer cpuPhysicalCores) {
    this.cpuPhysicalCores = cpuPhysicalCores;
    return this;
  }

   /**
   * Get cpuPhysicalCores
   * @return cpuPhysicalCores
  **/
  @ApiModelProperty(value = "")
  public Integer getCpuPhysicalCores() {
    return cpuPhysicalCores;
  }

  public void setCpuPhysicalCores(Integer cpuPhysicalCores) {
    this.cpuPhysicalCores = cpuPhysicalCores;
  }

  public SystemInsightsSystemInfo cpuLogicalCores(Integer cpuLogicalCores) {
    this.cpuLogicalCores = cpuLogicalCores;
    return this;
  }

   /**
   * Get cpuLogicalCores
   * @return cpuLogicalCores
  **/
  @ApiModelProperty(value = "")
  public Integer getCpuLogicalCores() {
    return cpuLogicalCores;
  }

  public void setCpuLogicalCores(Integer cpuLogicalCores) {
    this.cpuLogicalCores = cpuLogicalCores;
  }

  public SystemInsightsSystemInfo cpuMicrocode(String cpuMicrocode) {
    this.cpuMicrocode = cpuMicrocode;
    return this;
  }

   /**
   * Get cpuMicrocode
   * @return cpuMicrocode
  **/
  @ApiModelProperty(value = "")
  public String getCpuMicrocode() {
    return cpuMicrocode;
  }

  public void setCpuMicrocode(String cpuMicrocode) {
    this.cpuMicrocode = cpuMicrocode;
  }

  public SystemInsightsSystemInfo physicalMemory(String physicalMemory) {
    this.physicalMemory = physicalMemory;
    return this;
  }

   /**
   * Get physicalMemory
   * @return physicalMemory
  **/
  @ApiModelProperty(value = "")
  public String getPhysicalMemory() {
    return physicalMemory;
  }

  public void setPhysicalMemory(String physicalMemory) {
    this.physicalMemory = physicalMemory;
  }

  public SystemInsightsSystemInfo hardwareVendor(String hardwareVendor) {
    this.hardwareVendor = hardwareVendor;
    return this;
  }

   /**
   * Get hardwareVendor
   * @return hardwareVendor
  **/
  @ApiModelProperty(value = "")
  public String getHardwareVendor() {
    return hardwareVendor;
  }

  public void setHardwareVendor(String hardwareVendor) {
    this.hardwareVendor = hardwareVendor;
  }

  public SystemInsightsSystemInfo hardwareModel(String hardwareModel) {
    this.hardwareModel = hardwareModel;
    return this;
  }

   /**
   * Get hardwareModel
   * @return hardwareModel
  **/
  @ApiModelProperty(value = "")
  public String getHardwareModel() {
    return hardwareModel;
  }

  public void setHardwareModel(String hardwareModel) {
    this.hardwareModel = hardwareModel;
  }

  public SystemInsightsSystemInfo hardwareVersion(String hardwareVersion) {
    this.hardwareVersion = hardwareVersion;
    return this;
  }

   /**
   * Get hardwareVersion
   * @return hardwareVersion
  **/
  @ApiModelProperty(value = "")
  public String getHardwareVersion() {
    return hardwareVersion;
  }

  public void setHardwareVersion(String hardwareVersion) {
    this.hardwareVersion = hardwareVersion;
  }

  public SystemInsightsSystemInfo hardwareSerial(String hardwareSerial) {
    this.hardwareSerial = hardwareSerial;
    return this;
  }

   /**
   * Get hardwareSerial
   * @return hardwareSerial
  **/
  @ApiModelProperty(value = "")
  public String getHardwareSerial() {
    return hardwareSerial;
  }

  public void setHardwareSerial(String hardwareSerial) {
    this.hardwareSerial = hardwareSerial;
  }

  public SystemInsightsSystemInfo computerName(String computerName) {
    this.computerName = computerName;
    return this;
  }

   /**
   * Get computerName
   * @return computerName
  **/
  @ApiModelProperty(value = "")
  public String getComputerName() {
    return computerName;
  }

  public void setComputerName(String computerName) {
    this.computerName = computerName;
  }

  public SystemInsightsSystemInfo localHostname(String localHostname) {
    this.localHostname = localHostname;
    return this;
  }

   /**
   * Get localHostname
   * @return localHostname
  **/
  @ApiModelProperty(value = "")
  public String getLocalHostname() {
    return localHostname;
  }

  public void setLocalHostname(String localHostname) {
    this.localHostname = localHostname;
  }

  public SystemInsightsSystemInfo jcCollectionTime(String jcCollectionTime) {
    this.jcCollectionTime = jcCollectionTime;
    return this;
  }

   /**
   * Get jcCollectionTime
   * @return jcCollectionTime
  **/
  @ApiModelProperty(value = "")
  public String getJcCollectionTime() {
    return jcCollectionTime;
  }

  public void setJcCollectionTime(String jcCollectionTime) {
    this.jcCollectionTime = jcCollectionTime;
  }

  public SystemInsightsSystemInfo jcSystemId(String jcSystemId) {
    this.jcSystemId = jcSystemId;
    return this;
  }

   /**
   * Get jcSystemId
   * @return jcSystemId
  **/
  @ApiModelProperty(value = "")
  public String getJcSystemId() {
    return jcSystemId;
  }

  public void setJcSystemId(String jcSystemId) {
    this.jcSystemId = jcSystemId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SystemInsightsSystemInfo systemInsightsSystemInfo = (SystemInsightsSystemInfo) o;
    return Objects.equals(this.hostname, systemInsightsSystemInfo.hostname) &&
        Objects.equals(this.uuid, systemInsightsSystemInfo.uuid) &&
        Objects.equals(this.cpuType, systemInsightsSystemInfo.cpuType) &&
        Objects.equals(this.cpuSubtype, systemInsightsSystemInfo.cpuSubtype) &&
        Objects.equals(this.cpuBrand, systemInsightsSystemInfo.cpuBrand) &&
        Objects.equals(this.cpuPhysicalCores, systemInsightsSystemInfo.cpuPhysicalCores) &&
        Objects.equals(this.cpuLogicalCores, systemInsightsSystemInfo.cpuLogicalCores) &&
        Objects.equals(this.cpuMicrocode, systemInsightsSystemInfo.cpuMicrocode) &&
        Objects.equals(this.physicalMemory, systemInsightsSystemInfo.physicalMemory) &&
        Objects.equals(this.hardwareVendor, systemInsightsSystemInfo.hardwareVendor) &&
        Objects.equals(this.hardwareModel, systemInsightsSystemInfo.hardwareModel) &&
        Objects.equals(this.hardwareVersion, systemInsightsSystemInfo.hardwareVersion) &&
        Objects.equals(this.hardwareSerial, systemInsightsSystemInfo.hardwareSerial) &&
        Objects.equals(this.computerName, systemInsightsSystemInfo.computerName) &&
        Objects.equals(this.localHostname, systemInsightsSystemInfo.localHostname) &&
        Objects.equals(this.jcCollectionTime, systemInsightsSystemInfo.jcCollectionTime) &&
        Objects.equals(this.jcSystemId, systemInsightsSystemInfo.jcSystemId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hostname, uuid, cpuType, cpuSubtype, cpuBrand, cpuPhysicalCores, cpuLogicalCores, cpuMicrocode, physicalMemory, hardwareVendor, hardwareModel, hardwareVersion, hardwareSerial, computerName, localHostname, jcCollectionTime, jcSystemId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemInsightsSystemInfo {\n");
    
    sb.append("    hostname: ").append(toIndentedString(hostname)).append("\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    cpuType: ").append(toIndentedString(cpuType)).append("\n");
    sb.append("    cpuSubtype: ").append(toIndentedString(cpuSubtype)).append("\n");
    sb.append("    cpuBrand: ").append(toIndentedString(cpuBrand)).append("\n");
    sb.append("    cpuPhysicalCores: ").append(toIndentedString(cpuPhysicalCores)).append("\n");
    sb.append("    cpuLogicalCores: ").append(toIndentedString(cpuLogicalCores)).append("\n");
    sb.append("    cpuMicrocode: ").append(toIndentedString(cpuMicrocode)).append("\n");
    sb.append("    physicalMemory: ").append(toIndentedString(physicalMemory)).append("\n");
    sb.append("    hardwareVendor: ").append(toIndentedString(hardwareVendor)).append("\n");
    sb.append("    hardwareModel: ").append(toIndentedString(hardwareModel)).append("\n");
    sb.append("    hardwareVersion: ").append(toIndentedString(hardwareVersion)).append("\n");
    sb.append("    hardwareSerial: ").append(toIndentedString(hardwareSerial)).append("\n");
    sb.append("    computerName: ").append(toIndentedString(computerName)).append("\n");
    sb.append("    localHostname: ").append(toIndentedString(localHostname)).append("\n");
    sb.append("    jcCollectionTime: ").append(toIndentedString(jcCollectionTime)).append("\n");
    sb.append("    jcSystemId: ").append(toIndentedString(jcSystemId)).append("\n");
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
