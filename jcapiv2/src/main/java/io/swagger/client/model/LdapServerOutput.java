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
import io.swagger.client.model.LdapServerInput;
import java.io.IOException;

/**
 * LdapServerOutput
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-03-28T17:13:26.727Z")
public class LdapServerOutput {
  @SerializedName("name")
  private String name = null;

  @SerializedName("id")
  private String id = null;

  public LdapServerOutput name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of this LDAP server
   * @return name
  **/
  @ApiModelProperty(value = "The name of this LDAP server")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LdapServerOutput id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Unique identifier of this LDAP server
   * @return id
  **/
  @ApiModelProperty(required = true, value = "Unique identifier of this LDAP server")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LdapServerOutput ldapServerOutput = (LdapServerOutput) o;
    return Objects.equals(this.name, ldapServerOutput.name) &&
        Objects.equals(this.id, ldapServerOutput.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, id);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LdapServerOutput {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

