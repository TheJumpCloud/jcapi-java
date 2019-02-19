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
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * Sshkeylist
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-02-19T17:05:05.739Z")
public class Sshkeylist {
  @SerializedName("create_date")
  private String createDate = null;

  @SerializedName("_id")
  private String id = null;

  @SerializedName("public_key")
  private String publicKey = null;

  @SerializedName("name")
  private String name = null;

  public Sshkeylist createDate(String createDate) {
    this.createDate = createDate;
    return this;
  }

   /**
   * The date the SSH key was created.
   * @return createDate
  **/
  @ApiModelProperty(value = "The date the SSH key was created.")
  public String getCreateDate() {
    return createDate;
  }

  public void setCreateDate(String createDate) {
    this.createDate = createDate;
  }

  public Sshkeylist id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The ID of the SSH key.
   * @return id
  **/
  @ApiModelProperty(value = "The ID of the SSH key.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Sshkeylist publicKey(String publicKey) {
    this.publicKey = publicKey;
    return this;
  }

   /**
   * The Public SSH key.
   * @return publicKey
  **/
  @ApiModelProperty(value = "The Public SSH key.")
  public String getPublicKey() {
    return publicKey;
  }

  public void setPublicKey(String publicKey) {
    this.publicKey = publicKey;
  }

  public Sshkeylist name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of the SSH key.
   * @return name
  **/
  @ApiModelProperty(value = "The name of the SSH key.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Sshkeylist sshkeylist = (Sshkeylist) o;
    return Objects.equals(this.createDate, sshkeylist.createDate) &&
        Objects.equals(this.id, sshkeylist.id) &&
        Objects.equals(this.publicKey, sshkeylist.publicKey) &&
        Objects.equals(this.name, sshkeylist.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(createDate, id, publicKey, name);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Sshkeylist {\n");
    
    sb.append("    createDate: ").append(toIndentedString(createDate)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    publicKey: ").append(toIndentedString(publicKey)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

