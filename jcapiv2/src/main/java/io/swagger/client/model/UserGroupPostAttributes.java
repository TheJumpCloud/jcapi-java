/*
 * JumpCloud APIs
 * V1 & V2 versions of JumpCloud's API. The next version of JumpCloud's API. This set of endpoints allows JumpCloud customers to manage objects, groupings and mappings. The most recent version of JumpCloud's API. This set of endpoints allows JumpCloud customers to manage objects, groupings and mappings.
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
import io.swagger.client.model.UserGroupPostAttributesPosixGroups;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The group object&#39;s attributes.
 */
@ApiModel(description = "The group object's attributes.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-09T19:52:32.725Z")
public class UserGroupPostAttributes {
  @SerializedName("posixGroups")
  private List<UserGroupPostAttributesPosixGroups> posixGroups = null;

  @SerializedName("sambaEnabled")
  private Boolean sambaEnabled = null;

  public UserGroupPostAttributes posixGroups(List<UserGroupPostAttributesPosixGroups> posixGroups) {
    this.posixGroups = posixGroups;
    return this;
  }

  public UserGroupPostAttributes addPosixGroupsItem(UserGroupPostAttributesPosixGroups posixGroupsItem) {
    if (this.posixGroups == null) {
      this.posixGroups = new ArrayList<UserGroupPostAttributesPosixGroups>();
    }
    this.posixGroups.add(posixGroupsItem);
    return this;
  }

   /**
   * Get posixGroups
   * @return posixGroups
  **/
  @ApiModelProperty(value = "")
  public List<UserGroupPostAttributesPosixGroups> getPosixGroups() {
    return posixGroups;
  }

  public void setPosixGroups(List<UserGroupPostAttributesPosixGroups> posixGroups) {
    this.posixGroups = posixGroups;
  }

  public UserGroupPostAttributes sambaEnabled(Boolean sambaEnabled) {
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
    UserGroupPostAttributes userGroupPostAttributes = (UserGroupPostAttributes) o;
    return Objects.equals(this.posixGroups, userGroupPostAttributes.posixGroups) &&
        Objects.equals(this.sambaEnabled, userGroupPostAttributes.sambaEnabled);
  }

  @Override
  public int hashCode() {
    return Objects.hash(posixGroups, sambaEnabled);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserGroupPostAttributes {\n");
    
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
