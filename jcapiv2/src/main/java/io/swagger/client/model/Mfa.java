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
 * Mfa
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-02-15T22:16:49.168Z")
public class Mfa {
  @SerializedName("exclusion")
  private Boolean exclusion = null;

  @SerializedName("exclusionUntil")
  private OffsetDateTime exclusionUntil = null;

  @SerializedName("configured")
  private Boolean configured = null;

  public Mfa exclusion(Boolean exclusion) {
    this.exclusion = exclusion;
    return this;
  }

   /**
   * Get exclusion
   * @return exclusion
  **/
  @ApiModelProperty(value = "")
  public Boolean isExclusion() {
    return exclusion;
  }

  public void setExclusion(Boolean exclusion) {
    this.exclusion = exclusion;
  }

  public Mfa exclusionUntil(OffsetDateTime exclusionUntil) {
    this.exclusionUntil = exclusionUntil;
    return this;
  }

   /**
   * Get exclusionUntil
   * @return exclusionUntil
  **/
  @ApiModelProperty(value = "")
  public OffsetDateTime getExclusionUntil() {
    return exclusionUntil;
  }

  public void setExclusionUntil(OffsetDateTime exclusionUntil) {
    this.exclusionUntil = exclusionUntil;
  }

  public Mfa configured(Boolean configured) {
    this.configured = configured;
    return this;
  }

   /**
   * Get configured
   * @return configured
  **/
  @ApiModelProperty(value = "")
  public Boolean isConfigured() {
    return configured;
  }

  public void setConfigured(Boolean configured) {
    this.configured = configured;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Mfa mfa = (Mfa) o;
    return Objects.equals(this.exclusion, mfa.exclusion) &&
        Objects.equals(this.exclusionUntil, mfa.exclusionUntil) &&
        Objects.equals(this.configured, mfa.configured);
  }

  @Override
  public int hashCode() {
    return Objects.hash(exclusion, exclusionUntil, configured);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Mfa {\n");
    
    sb.append("    exclusion: ").append(toIndentedString(exclusion)).append("\n");
    sb.append("    exclusionUntil: ").append(toIndentedString(exclusionUntil)).append("\n");
    sb.append("    configured: ").append(toIndentedString(configured)).append("\n");
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

