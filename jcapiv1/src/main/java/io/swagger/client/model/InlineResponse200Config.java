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
import io.swagger.client.model.InlineResponse200ConfigConstantAttributes;
import io.swagger.client.model.InlineResponse200ConfigDatabaseAttributes;
import io.swagger.client.model.InlineResponse200ConfigIdpEntityId;
import java.io.IOException;

/**
 * InlineResponse200Config
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-09T20:34:34.535Z")
public class InlineResponse200Config {
  @SerializedName("idpEntityId")
  private InlineResponse200ConfigIdpEntityId idpEntityId = null;

  @SerializedName("idpCertificate")
  private InlineResponse200ConfigIdpEntityId idpCertificate = null;

  @SerializedName("spEntityId")
  private InlineResponse200ConfigIdpEntityId spEntityId = null;

  @SerializedName("acsUrl")
  private InlineResponse200ConfigIdpEntityId acsUrl = null;

  @SerializedName("constantAttributes")
  private InlineResponse200ConfigConstantAttributes constantAttributes = null;

  @SerializedName("databaseAttributes")
  private InlineResponse200ConfigDatabaseAttributes databaseAttributes = null;

  public InlineResponse200Config idpEntityId(InlineResponse200ConfigIdpEntityId idpEntityId) {
    this.idpEntityId = idpEntityId;
    return this;
  }

   /**
   * Get idpEntityId
   * @return idpEntityId
  **/
  @ApiModelProperty(value = "")
  public InlineResponse200ConfigIdpEntityId getIdpEntityId() {
    return idpEntityId;
  }

  public void setIdpEntityId(InlineResponse200ConfigIdpEntityId idpEntityId) {
    this.idpEntityId = idpEntityId;
  }

  public InlineResponse200Config idpCertificate(InlineResponse200ConfigIdpEntityId idpCertificate) {
    this.idpCertificate = idpCertificate;
    return this;
  }

   /**
   * Get idpCertificate
   * @return idpCertificate
  **/
  @ApiModelProperty(value = "")
  public InlineResponse200ConfigIdpEntityId getIdpCertificate() {
    return idpCertificate;
  }

  public void setIdpCertificate(InlineResponse200ConfigIdpEntityId idpCertificate) {
    this.idpCertificate = idpCertificate;
  }

  public InlineResponse200Config spEntityId(InlineResponse200ConfigIdpEntityId spEntityId) {
    this.spEntityId = spEntityId;
    return this;
  }

   /**
   * Get spEntityId
   * @return spEntityId
  **/
  @ApiModelProperty(value = "")
  public InlineResponse200ConfigIdpEntityId getSpEntityId() {
    return spEntityId;
  }

  public void setSpEntityId(InlineResponse200ConfigIdpEntityId spEntityId) {
    this.spEntityId = spEntityId;
  }

  public InlineResponse200Config acsUrl(InlineResponse200ConfigIdpEntityId acsUrl) {
    this.acsUrl = acsUrl;
    return this;
  }

   /**
   * Get acsUrl
   * @return acsUrl
  **/
  @ApiModelProperty(value = "")
  public InlineResponse200ConfigIdpEntityId getAcsUrl() {
    return acsUrl;
  }

  public void setAcsUrl(InlineResponse200ConfigIdpEntityId acsUrl) {
    this.acsUrl = acsUrl;
  }

  public InlineResponse200Config constantAttributes(InlineResponse200ConfigConstantAttributes constantAttributes) {
    this.constantAttributes = constantAttributes;
    return this;
  }

   /**
   * Get constantAttributes
   * @return constantAttributes
  **/
  @ApiModelProperty(value = "")
  public InlineResponse200ConfigConstantAttributes getConstantAttributes() {
    return constantAttributes;
  }

  public void setConstantAttributes(InlineResponse200ConfigConstantAttributes constantAttributes) {
    this.constantAttributes = constantAttributes;
  }

  public InlineResponse200Config databaseAttributes(InlineResponse200ConfigDatabaseAttributes databaseAttributes) {
    this.databaseAttributes = databaseAttributes;
    return this;
  }

   /**
   * Get databaseAttributes
   * @return databaseAttributes
  **/
  @ApiModelProperty(value = "")
  public InlineResponse200ConfigDatabaseAttributes getDatabaseAttributes() {
    return databaseAttributes;
  }

  public void setDatabaseAttributes(InlineResponse200ConfigDatabaseAttributes databaseAttributes) {
    this.databaseAttributes = databaseAttributes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse200Config inlineResponse200Config = (InlineResponse200Config) o;
    return Objects.equals(this.idpEntityId, inlineResponse200Config.idpEntityId) &&
        Objects.equals(this.idpCertificate, inlineResponse200Config.idpCertificate) &&
        Objects.equals(this.spEntityId, inlineResponse200Config.spEntityId) &&
        Objects.equals(this.acsUrl, inlineResponse200Config.acsUrl) &&
        Objects.equals(this.constantAttributes, inlineResponse200Config.constantAttributes) &&
        Objects.equals(this.databaseAttributes, inlineResponse200Config.databaseAttributes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idpEntityId, idpCertificate, spEntityId, acsUrl, constantAttributes, databaseAttributes);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse200Config {\n");
    
    sb.append("    idpEntityId: ").append(toIndentedString(idpEntityId)).append("\n");
    sb.append("    idpCertificate: ").append(toIndentedString(idpCertificate)).append("\n");
    sb.append("    spEntityId: ").append(toIndentedString(spEntityId)).append("\n");
    sb.append("    acsUrl: ").append(toIndentedString(acsUrl)).append("\n");
    sb.append("    constantAttributes: ").append(toIndentedString(constantAttributes)).append("\n");
    sb.append("    databaseAttributes: ").append(toIndentedString(databaseAttributes)).append("\n");
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

