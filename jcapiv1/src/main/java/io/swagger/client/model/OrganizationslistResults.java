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
 * OrganizationslistResults
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-09-26T20:17:55.126Z")
public class OrganizationslistResults {
  @SerializedName("_id")
  private String id = null;

  @SerializedName("displayName")
  private String displayName = null;

  @SerializedName("logoUrl")
  private String logoUrl = null;

  public OrganizationslistResults id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The ID of the organization.
   * @return id
  **/
  @ApiModelProperty(value = "The ID of the organization.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public OrganizationslistResults displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }

   /**
   * The name of the organization.
   * @return displayName
  **/
  @ApiModelProperty(value = "The name of the organization.")
  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public OrganizationslistResults logoUrl(String logoUrl) {
    this.logoUrl = logoUrl;
    return this;
  }

   /**
   * The organization logo image URL. 
   * @return logoUrl
  **/
  @ApiModelProperty(value = "The organization logo image URL. ")
  public String getLogoUrl() {
    return logoUrl;
  }

  public void setLogoUrl(String logoUrl) {
    this.logoUrl = logoUrl;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrganizationslistResults organizationslistResults = (OrganizationslistResults) o;
    return Objects.equals(this.id, organizationslistResults.id) &&
        Objects.equals(this.displayName, organizationslistResults.displayName) &&
        Objects.equals(this.logoUrl, organizationslistResults.logoUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, displayName, logoUrl);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrganizationslistResults {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    logoUrl: ").append(toIndentedString(logoUrl)).append("\n");
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

