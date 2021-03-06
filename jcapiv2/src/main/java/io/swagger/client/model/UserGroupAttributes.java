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
import io.swagger.client.model.UserGroupAttributesPosixGroups;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * UserGroupAttributes
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-11-21T20:17:34.763Z")
public class UserGroupAttributes {
  @SerializedName("posixGroups")
  private List<UserGroupAttributesPosixGroups> posixGroups = null;

  @SerializedName("sambaEnabled")
  private Boolean sambaEnabled = null;

  public UserGroupAttributes posixGroups(List<UserGroupAttributesPosixGroups> posixGroups) {
    this.posixGroups = posixGroups;
    return this;
  }

  public UserGroupAttributes addPosixGroupsItem(UserGroupAttributesPosixGroups posixGroupsItem) {
    if (this.posixGroups == null) {
      this.posixGroups = new ArrayList<UserGroupAttributesPosixGroups>();
    }
    this.posixGroups.add(posixGroupsItem);
    return this;
  }

   /**
   * Get posixGroups
   * @return posixGroups
  **/
  @ApiModelProperty(value = "")
  public List<UserGroupAttributesPosixGroups> getPosixGroups() {
    return posixGroups;
  }

  public void setPosixGroups(List<UserGroupAttributesPosixGroups> posixGroups) {
    this.posixGroups = posixGroups;
  }

  public UserGroupAttributes sambaEnabled(Boolean sambaEnabled) {
    this.sambaEnabled = sambaEnabled;
    return this;
  }

   /**
   * Get sambaEnabled
   * @return sambaEnabled
  **/
  @ApiModelProperty(value = "")
  public Boolean isSambaEnabled() {
    return sambaEnabled;
  }

  public void setSambaEnabled(Boolean sambaEnabled) {
    this.sambaEnabled = sambaEnabled;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserGroupAttributes userGroupAttributes = (UserGroupAttributes) o;
    return Objects.equals(this.posixGroups, userGroupAttributes.posixGroups) &&
        Objects.equals(this.sambaEnabled, userGroupAttributes.sambaEnabled);
  }

  @Override
  public int hashCode() {
    return Objects.hash(posixGroups, sambaEnabled);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserGroupAttributes {\n");
    
    sb.append("    posixGroups: ").append(toIndentedString(posixGroups)).append("\n");
    sb.append("    sambaEnabled: ").append(toIndentedString(sambaEnabled)).append("\n");
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

