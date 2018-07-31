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
import io.swagger.client.model.ActiveDirectoryInput;
import java.io.IOException;

/**
 * ActiveDirectoryOutput
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-07-31T21:42:20.775Z")
public class ActiveDirectoryOutput {
  @SerializedName("domain")
  private String domain = null;

  @SerializedName("id")
  private String id = null;

  public ActiveDirectoryOutput domain(String domain) {
    this.domain = domain;
    return this;
  }

   /**
   * Domain name for this Active Directory instance.
   * @return domain
  **/
  @ApiModelProperty(value = "Domain name for this Active Directory instance.")
  public String getDomain() {
    return domain;
  }

  public void setDomain(String domain) {
    this.domain = domain;
  }

  public ActiveDirectoryOutput id(String id) {
    this.id = id;
    return this;
  }

   /**
   * ObjectID of this Active Directory instance.
   * @return id
  **/
  @ApiModelProperty(required = true, value = "ObjectID of this Active Directory instance.")
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
    ActiveDirectoryOutput activeDirectoryOutput = (ActiveDirectoryOutput) o;
    return Objects.equals(this.domain, activeDirectoryOutput.domain) &&
        Objects.equals(this.id, activeDirectoryOutput.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(domain, id);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ActiveDirectoryOutput {\n");
    
    sb.append("    domain: ").append(toIndentedString(domain)).append("\n");
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

