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
import io.swagger.client.model.OrganizationsettingsFeaturesSystemInsights;
import java.io.IOException;

/**
 * OrganizationsettingsFeatures
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-12-09T23:53:52.741Z")
public class OrganizationsettingsFeatures {
  @SerializedName("systemInsights")
  private OrganizationsettingsFeaturesSystemInsights systemInsights = null;

  public OrganizationsettingsFeatures systemInsights(OrganizationsettingsFeaturesSystemInsights systemInsights) {
    this.systemInsights = systemInsights;
    return this;
  }

   /**
   * Get systemInsights
   * @return systemInsights
  **/
  @ApiModelProperty(value = "")
  public OrganizationsettingsFeaturesSystemInsights getSystemInsights() {
    return systemInsights;
  }

  public void setSystemInsights(OrganizationsettingsFeaturesSystemInsights systemInsights) {
    this.systemInsights = systemInsights;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrganizationsettingsFeatures organizationsettingsFeatures = (OrganizationsettingsFeatures) o;
    return Objects.equals(this.systemInsights, organizationsettingsFeatures.systemInsights);
  }

  @Override
  public int hashCode() {
    return Objects.hash(systemInsights);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrganizationsettingsFeatures {\n");
    
    sb.append("    systemInsights: ").append(toIndentedString(systemInsights)).append("\n");
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

