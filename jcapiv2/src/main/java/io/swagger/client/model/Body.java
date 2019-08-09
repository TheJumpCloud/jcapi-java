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
import io.swagger.client.model.LdapServerAction;
import java.io.IOException;

/**
 * Body
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-08-09T16:30:22.486Z")
public class Body {
  @SerializedName("id")
  private String id = null;

  @SerializedName("userLockoutAction")
  private LdapServerAction userLockoutAction = null;

  @SerializedName("userPasswordExpirationAction")
  private LdapServerAction userPasswordExpirationAction = null;

  public Body id(String id) {
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

  public Body userLockoutAction(LdapServerAction userLockoutAction) {
    this.userLockoutAction = userLockoutAction;
    return this;
  }

   /**
   * Get userLockoutAction
   * @return userLockoutAction
  **/
  @ApiModelProperty(value = "")
  public LdapServerAction getUserLockoutAction() {
    return userLockoutAction;
  }

  public void setUserLockoutAction(LdapServerAction userLockoutAction) {
    this.userLockoutAction = userLockoutAction;
  }

  public Body userPasswordExpirationAction(LdapServerAction userPasswordExpirationAction) {
    this.userPasswordExpirationAction = userPasswordExpirationAction;
    return this;
  }

   /**
   * Get userPasswordExpirationAction
   * @return userPasswordExpirationAction
  **/
  @ApiModelProperty(value = "")
  public LdapServerAction getUserPasswordExpirationAction() {
    return userPasswordExpirationAction;
  }

  public void setUserPasswordExpirationAction(LdapServerAction userPasswordExpirationAction) {
    this.userPasswordExpirationAction = userPasswordExpirationAction;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Body body = (Body) o;
    return Objects.equals(this.id, body.id) &&
        Objects.equals(this.userLockoutAction, body.userLockoutAction) &&
        Objects.equals(this.userPasswordExpirationAction, body.userPasswordExpirationAction);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userLockoutAction, userPasswordExpirationAction);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Body {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    userLockoutAction: ").append(toIndentedString(userLockoutAction)).append("\n");
    sb.append("    userPasswordExpirationAction: ").append(toIndentedString(userPasswordExpirationAction)).append("\n");
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
