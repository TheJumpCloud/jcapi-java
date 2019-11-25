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
 * EnrollmentProfile
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-11-21T20:17:34.763Z")
public class EnrollmentProfile {
  @SerializedName("appleMdmId")
  private String appleMdmId = null;

  @SerializedName("id")
  private String id = null;

  public EnrollmentProfile appleMdmId(String appleMdmId) {
    this.appleMdmId = appleMdmId;
    return this;
  }

   /**
   * Get appleMdmId
   * @return appleMdmId
  **/
  @ApiModelProperty(value = "")
  public String getAppleMdmId() {
    return appleMdmId;
  }

  public void setAppleMdmId(String appleMdmId) {
    this.appleMdmId = appleMdmId;
  }

  public EnrollmentProfile id(String id) {
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
    EnrollmentProfile enrollmentProfile = (EnrollmentProfile) o;
    return Objects.equals(this.appleMdmId, enrollmentProfile.appleMdmId) &&
        Objects.equals(this.id, enrollmentProfile.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(appleMdmId, id);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EnrollmentProfile {\n");
    
    sb.append("    appleMdmId: ").append(toIndentedString(appleMdmId)).append("\n");
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
