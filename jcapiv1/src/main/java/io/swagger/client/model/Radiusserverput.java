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
import java.util.ArrayList;
import java.util.List;

/**
 * Radiusserverput
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-03-26T18:00:07.970Z")
public class Radiusserverput {
  @SerializedName("_id")
  private String id = null;

  @SerializedName("networkSourceIp")
  private String networkSourceIp = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("tagNames")
  private List<String> tagNames = null;

  public Radiusserverput id(String id) {
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

  public Radiusserverput networkSourceIp(String networkSourceIp) {
    this.networkSourceIp = networkSourceIp;
    return this;
  }

   /**
   * Get networkSourceIp
   * @return networkSourceIp
  **/
  @ApiModelProperty(value = "")
  public String getNetworkSourceIp() {
    return networkSourceIp;
  }

  public void setNetworkSourceIp(String networkSourceIp) {
    this.networkSourceIp = networkSourceIp;
  }

  public Radiusserverput name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Radiusserverput tagNames(List<String> tagNames) {
    this.tagNames = tagNames;
    return this;
  }

  public Radiusserverput addTagNamesItem(String tagNamesItem) {
    if (this.tagNames == null) {
      this.tagNames = new ArrayList<String>();
    }
    this.tagNames.add(tagNamesItem);
    return this;
  }

   /**
   * Get tagNames
   * @return tagNames
  **/
  @ApiModelProperty(value = "")
  public List<String> getTagNames() {
    return tagNames;
  }

  public void setTagNames(List<String> tagNames) {
    this.tagNames = tagNames;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Radiusserverput radiusserverput = (Radiusserverput) o;
    return Objects.equals(this.id, radiusserverput.id) &&
        Objects.equals(this.networkSourceIp, radiusserverput.networkSourceIp) &&
        Objects.equals(this.name, radiusserverput.name) &&
        Objects.equals(this.tagNames, radiusserverput.tagNames);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, networkSourceIp, name, tagNames);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Radiusserverput {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    networkSourceIp: ").append(toIndentedString(networkSourceIp)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    tagNames: ").append(toIndentedString(tagNames)).append("\n");
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

