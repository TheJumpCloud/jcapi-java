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
import org.threeten.bp.OffsetDateTime;

/**
 * Body1
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-09-25T16:17:57.759Z")
public class Body1 {
  @SerializedName("exclusion")
  private Boolean exclusion = null;

  @SerializedName("exclusionUntil")
  private OffsetDateTime exclusionUntil = null;

  public Body1 exclusion(Boolean exclusion) {
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

  public Body1 exclusionUntil(OffsetDateTime exclusionUntil) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Body1 body1 = (Body1) o;
    return Objects.equals(this.exclusion, body1.exclusion) &&
        Objects.equals(this.exclusionUntil, body1.exclusionUntil);
  }

  @Override
  public int hashCode() {
    return Objects.hash(exclusion, exclusionUntil);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Body1 {\n");
    
    sb.append("    exclusion: ").append(toIndentedString(exclusion)).append("\n");
    sb.append("    exclusionUntil: ").append(toIndentedString(exclusionUntil)).append("\n");
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

