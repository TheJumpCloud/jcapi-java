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
import java.util.ArrayList;
import java.util.List;

/**
 * See [V1 system user update](https://docs.jumpcloud.com/1.0/systemusers/update-a-system-user) for full list of attributes.
 */
@ApiModel(description = "See [V1 system user update](https://docs.jumpcloud.com/1.0/systemusers/update-a-system-user) for full list of attributes.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-09-16T17:47:24.539Z")
public class BulkUserUpdate {
  @SerializedName("attributes")
  private List<Object> attributes = null;

  @SerializedName("email")
  private String email = null;

  @SerializedName("firstname")
  private String firstname = null;

  @SerializedName("id")
  private String id = null;

  @SerializedName("lastname")
  private String lastname = null;

  @SerializedName("username")
  private String username = null;

  public BulkUserUpdate attributes(List<Object> attributes) {
    this.attributes = attributes;
    return this;
  }

  public BulkUserUpdate addAttributesItem(Object attributesItem) {
    if (this.attributes == null) {
      this.attributes = new ArrayList<Object>();
    }
    this.attributes.add(attributesItem);
    return this;
  }

   /**
   * Map of additional attributes.
   * @return attributes
  **/
  @ApiModelProperty(value = "Map of additional attributes.")
  public List<Object> getAttributes() {
    return attributes;
  }

  public void setAttributes(List<Object> attributes) {
    this.attributes = attributes;
  }

  public BulkUserUpdate email(String email) {
    this.email = email;
    return this;
  }

   /**
   * Get email
   * @return email
  **/
  @ApiModelProperty(value = "")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public BulkUserUpdate firstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

   /**
   * Get firstname
   * @return firstname
  **/
  @ApiModelProperty(value = "")
  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public BulkUserUpdate id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Object ID of the systemuser being updated
   * @return id
  **/
  @ApiModelProperty(value = "Object ID of the systemuser being updated")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public BulkUserUpdate lastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

   /**
   * Get lastname
   * @return lastname
  **/
  @ApiModelProperty(value = "")
  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public BulkUserUpdate username(String username) {
    this.username = username;
    return this;
  }

   /**
   * Get username
   * @return username
  **/
  @ApiModelProperty(value = "")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BulkUserUpdate bulkUserUpdate = (BulkUserUpdate) o;
    return Objects.equals(this.attributes, bulkUserUpdate.attributes) &&
        Objects.equals(this.email, bulkUserUpdate.email) &&
        Objects.equals(this.firstname, bulkUserUpdate.firstname) &&
        Objects.equals(this.id, bulkUserUpdate.id) &&
        Objects.equals(this.lastname, bulkUserUpdate.lastname) &&
        Objects.equals(this.username, bulkUserUpdate.username);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attributes, email, firstname, id, lastname, username);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BulkUserUpdate {\n");
    
    sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    firstname: ").append(toIndentedString(firstname)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    lastname: ").append(toIndentedString(lastname)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
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

