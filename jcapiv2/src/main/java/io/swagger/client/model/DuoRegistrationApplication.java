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
 * DuoRegistrationApplication
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-09-16T17:47:24.539Z")
public class DuoRegistrationApplication {
  @SerializedName("apiHost")
  private String apiHost = null;

  @SerializedName("integrationKey")
  private String integrationKey = null;

  @SerializedName("secretKey")
  private String secretKey = null;

  public DuoRegistrationApplication apiHost(String apiHost) {
    this.apiHost = apiHost;
    return this;
  }

   /**
   * Duo Application host name.
   * @return apiHost
  **/
  @ApiModelProperty(required = true, value = "Duo Application host name.")
  public String getApiHost() {
    return apiHost;
  }

  public void setApiHost(String apiHost) {
    this.apiHost = apiHost;
  }

  public DuoRegistrationApplication integrationKey(String integrationKey) {
    this.integrationKey = integrationKey;
    return this;
  }

   /**
   * Duo Application integration key.
   * @return integrationKey
  **/
  @ApiModelProperty(required = true, value = "Duo Application integration key.")
  public String getIntegrationKey() {
    return integrationKey;
  }

  public void setIntegrationKey(String integrationKey) {
    this.integrationKey = integrationKey;
  }

  public DuoRegistrationApplication secretKey(String secretKey) {
    this.secretKey = secretKey;
    return this;
  }

   /**
   * Duo Application secret key.
   * @return secretKey
  **/
  @ApiModelProperty(required = true, value = "Duo Application secret key.")
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
    DuoRegistrationApplication duoRegistrationApplication = (DuoRegistrationApplication) o;
    return Objects.equals(this.apiHost, duoRegistrationApplication.apiHost) &&
        Objects.equals(this.integrationKey, duoRegistrationApplication.integrationKey) &&
        Objects.equals(this.secretKey, duoRegistrationApplication.secretKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(apiHost, integrationKey, secretKey);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DuoRegistrationApplication {\n");
    
    sb.append("    apiHost: ").append(toIndentedString(apiHost)).append("\n");
    sb.append("    integrationKey: ").append(toIndentedString(integrationKey)).append("\n");
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

