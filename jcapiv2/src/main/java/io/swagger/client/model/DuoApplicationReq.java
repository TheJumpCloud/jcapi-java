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
 * DuoApplicationReq
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-11-21T20:17:34.763Z")
public class DuoApplicationReq {
  @SerializedName("apiHost")
  private String apiHost = null;

  @SerializedName("integrationKey")
  private String integrationKey = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("secretKey")
  private String secretKey = null;

  public DuoApplicationReq apiHost(String apiHost) {
    this.apiHost = apiHost;
    return this;
  }

   /**
   * Get apiHost
   * @return apiHost
  **/
  @ApiModelProperty(required = true, value = "")
  public String getApiHost() {
    return apiHost;
  }

  public void setApiHost(String apiHost) {
    this.apiHost = apiHost;
  }

  public DuoApplicationReq integrationKey(String integrationKey) {
    this.integrationKey = integrationKey;
    return this;
  }

   /**
   * Get integrationKey
   * @return integrationKey
  **/
  @ApiModelProperty(required = true, value = "")
  public String getIntegrationKey() {
    return integrationKey;
  }

  public void setIntegrationKey(String integrationKey) {
    this.integrationKey = integrationKey;
  }

  public DuoApplicationReq name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DuoApplicationReq secretKey(String secretKey) {
    this.secretKey = secretKey;
    return this;
  }

   /**
   * Get secretKey
   * @return secretKey
  **/
  @ApiModelProperty(required = true, value = "")
  public String getSecretKey() {
    return secretKey;
  }

  public void setSecretKey(String secretKey) {
    this.secretKey = secretKey;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DuoApplicationReq duoApplicationReq = (DuoApplicationReq) o;
    return Objects.equals(this.apiHost, duoApplicationReq.apiHost) &&
        Objects.equals(this.integrationKey, duoApplicationReq.integrationKey) &&
        Objects.equals(this.name, duoApplicationReq.name) &&
        Objects.equals(this.secretKey, duoApplicationReq.secretKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(apiHost, integrationKey, name, secretKey);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DuoApplicationReq {\n");
    
    sb.append("    apiHost: ").append(toIndentedString(apiHost)).append("\n");
    sb.append("    integrationKey: ").append(toIndentedString(integrationKey)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    secretKey: ").append(toIndentedString(secretKey)).append("\n");
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

