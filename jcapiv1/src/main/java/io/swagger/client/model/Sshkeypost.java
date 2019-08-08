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
 * Sshkeypost
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-08-08T00:57:43.512Z")
public class Sshkeypost {
  @SerializedName("public_key")
  private String publicKey = null;

  @SerializedName("name")
  private String name = null;

  public Sshkeypost publicKey(String publicKey) {
    this.publicKey = publicKey;
    return this;
  }

   /**
   * The Public SSH key.
   * @return publicKey
  **/
  @ApiModelProperty(required = true, value = "The Public SSH key.")
  public String getPublicKey() {
    return publicKey;
  }

  public void setPublicKey(String publicKey) {
    this.publicKey = publicKey;
  }

  public Sshkeypost name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of the SSH key.
   * @return name
  **/
  @ApiModelProperty(required = true, value = "The name of the SSH key.")
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
    Sshkeypost sshkeypost = (Sshkeypost) o;
    return Objects.equals(this.publicKey, sshkeypost.publicKey) &&
        Objects.equals(this.name, sshkeypost.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(publicKey, name);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Sshkeypost {\n");
    
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

