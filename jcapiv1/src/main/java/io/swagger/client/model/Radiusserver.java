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
import java.util.Arrays;
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
 * Radiusserver
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-02-20T21:32:24.213Z")
public class Radiusserver {
  @SerializedName("_id")
  private String id = null;

  @SerializedName("organization")
  private String organization = null;

  @SerializedName("networkSourceIp")
  private String networkSourceIp = null;

  @SerializedName("sharedSecret")
  private String sharedSecret = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("tags")
  private List<String> tags = null;

  @SerializedName("tagNames")
  private List<String> tagNames = null;

  public Radiusserver id(String id) {
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

  public Radiusserver organization(String organization) {
    this.organization = organization;
    return this;
  }

   /**
   * Get organization
   * @return organization
  **/
  @ApiModelProperty(value = "")
  public String getOrganization() {
    return organization;
  }

  public void setOrganization(String organization) {
    this.organization = organization;
  }

  public Radiusserver networkSourceIp(String networkSourceIp) {
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

  public Radiusserver sharedSecret(String sharedSecret) {
    this.sharedSecret = sharedSecret;
    return this;
  }

   /**
   * Get sharedSecret
   * @return sharedSecret
  **/
  @ApiModelProperty(value = "")
  public String getSharedSecret() {
    return sharedSecret;
  }

  public void setSharedSecret(String sharedSecret) {
    this.sharedSecret = sharedSecret;
  }

  public Radiusserver name(String name) {
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

  public Radiusserver tags(List<String> tags) {
    this.tags = tags;
    return this;
  }

  public Radiusserver addTagsItem(String tagsItem) {
    if (this.tags == null) {
      this.tags = new ArrayList<String>();
    }
    this.tags.add(tagsItem);
    return this;
  }

   /**
   * Get tags
   * @return tags
  **/
  @ApiModelProperty(value = "")
  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  public Radiusserver tagNames(List<String> tagNames) {
    this.tagNames = tagNames;
    return this;
  }

  public Radiusserver addTagNamesItem(String tagNamesItem) {
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
    Radiusserver radiusserver = (Radiusserver) o;
    return Objects.equals(this.id, radiusserver.id) &&
        Objects.equals(this.organization, radiusserver.organization) &&
        Objects.equals(this.networkSourceIp, radiusserver.networkSourceIp) &&
        Objects.equals(this.sharedSecret, radiusserver.sharedSecret) &&
        Objects.equals(this.name, radiusserver.name) &&
        Objects.equals(this.tags, radiusserver.tags) &&
        Objects.equals(this.tagNames, radiusserver.tagNames);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, organization, networkSourceIp, sharedSecret, name, tags, tagNames);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Radiusserver {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    organization: ").append(toIndentedString(organization)).append("\n");
    sb.append("    networkSourceIp: ").append(toIndentedString(networkSourceIp)).append("\n");
    sb.append("    sharedSecret: ").append(toIndentedString(sharedSecret)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
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

