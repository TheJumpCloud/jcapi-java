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
import io.swagger.client.model.ApplicationConfigConstantAttributes;
import io.swagger.client.model.ApplicationConfigDatabaseAttributes;
import io.swagger.client.model.ApplicationConfigIdpEntityId;
import java.io.IOException;

/**
 * ApplicationConfig
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-09-12T20:59:54.768Z")
public class ApplicationConfig {
  @SerializedName("idpEntityId")
  private ApplicationConfigIdpEntityId idpEntityId = null;

  @SerializedName("idpCertificate")
  private ApplicationConfigIdpEntityId idpCertificate = null;

  @SerializedName("spEntityId")
  private ApplicationConfigIdpEntityId spEntityId = null;

  @SerializedName("acsUrl")
  private ApplicationConfigIdpEntityId acsUrl = null;

  @SerializedName("constantAttributes")
  private ApplicationConfigConstantAttributes constantAttributes = null;

  @SerializedName("databaseAttributes")
  private ApplicationConfigDatabaseAttributes databaseAttributes = null;

  public ApplicationConfig idpEntityId(ApplicationConfigIdpEntityId idpEntityId) {
    this.idpEntityId = idpEntityId;
    return this;
  }

   /**
   * Get idpEntityId
   * @return idpEntityId
  **/
  @ApiModelProperty(value = "")
  public ApplicationConfigIdpEntityId getIdpEntityId() {
    return idpEntityId;
  }

  public void setIdpEntityId(ApplicationConfigIdpEntityId idpEntityId) {
    this.idpEntityId = idpEntityId;
  }

  public ApplicationConfig idpCertificate(ApplicationConfigIdpEntityId idpCertificate) {
    this.idpCertificate = idpCertificate;
    return this;
  }

   /**
   * Get idpCertificate
   * @return idpCertificate
  **/
  @ApiModelProperty(value = "")
  public ApplicationConfigIdpEntityId getIdpCertificate() {
    return idpCertificate;
  }

  public void setIdpCertificate(ApplicationConfigIdpEntityId idpCertificate) {
    this.idpCertificate = idpCertificate;
  }

  public ApplicationConfig spEntityId(ApplicationConfigIdpEntityId spEntityId) {
    this.spEntityId = spEntityId;
    return this;
  }

   /**
   * Get spEntityId
   * @return spEntityId
  **/
  @ApiModelProperty(value = "")
  public ApplicationConfigIdpEntityId getSpEntityId() {
    return spEntityId;
  }

  public void setSpEntityId(ApplicationConfigIdpEntityId spEntityId) {
    this.spEntityId = spEntityId;
  }

  public ApplicationConfig acsUrl(ApplicationConfigIdpEntityId acsUrl) {
    this.acsUrl = acsUrl;
    return this;
  }

   /**
   * Get acsUrl
   * @return acsUrl
  **/
  @ApiModelProperty(value = "")
  public ApplicationConfigIdpEntityId getAcsUrl() {
    return acsUrl;
  }

  public void setAcsUrl(ApplicationConfigIdpEntityId acsUrl) {
    this.acsUrl = acsUrl;
  }

  public ApplicationConfig constantAttributes(ApplicationConfigConstantAttributes constantAttributes) {
    this.constantAttributes = constantAttributes;
    return this;
  }

   /**
   * Get constantAttributes
   * @return constantAttributes
  **/
  @ApiModelProperty(value = "")
  public ApplicationConfigConstantAttributes getConstantAttributes() {
    return constantAttributes;
  }

  public void setConstantAttributes(ApplicationConfigConstantAttributes constantAttributes) {
    this.constantAttributes = constantAttributes;
  }

  public ApplicationConfig databaseAttributes(ApplicationConfigDatabaseAttributes databaseAttributes) {
    this.databaseAttributes = databaseAttributes;
    return this;
  }

   /**
   * Get databaseAttributes
   * @return databaseAttributes
  **/
  @ApiModelProperty(value = "")
  public ApplicationConfigDatabaseAttributes getDatabaseAttributes() {
    return databaseAttributes;
  }

  public void setDatabaseAttributes(ApplicationConfigDatabaseAttributes databaseAttributes) {
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
    ApplicationConfig applicationConfig = (ApplicationConfig) o;
    return Objects.equals(this.idpEntityId, applicationConfig.idpEntityId) &&
        Objects.equals(this.idpCertificate, applicationConfig.idpCertificate) &&
        Objects.equals(this.spEntityId, applicationConfig.spEntityId) &&
        Objects.equals(this.acsUrl, applicationConfig.acsUrl) &&
        Objects.equals(this.constantAttributes, applicationConfig.constantAttributes) &&
        Objects.equals(this.databaseAttributes, applicationConfig.databaseAttributes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idpEntityId, idpCertificate, spEntityId, acsUrl, constantAttributes, databaseAttributes);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApplicationConfig {\n");
    
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

