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
import io.swagger.client.model.SambaDomainInput;
import java.io.IOException;

/**
 * SambaDomainOutput
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-01-15T23:52:11.874Z")
public class SambaDomainOutput {
  @SerializedName("name")
  private String name = null;

  @SerializedName("sid")
  private String sid = null;

  @SerializedName("id")
  private String id = null;

  public SambaDomainOutput name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name of this domain&#39;s WorkGroup
   * @return name
  **/
  @ApiModelProperty(required = true, value = "Name of this domain's WorkGroup")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public SambaDomainOutput sid(String sid) {
    this.sid = sid;
    return this;
  }

   /**
   * Security identifier of this domain
   * @return sid
  **/
  @ApiModelProperty(required = true, value = "Security identifier of this domain")
  public String getSid() {
    return sid;
  }

  public void setSid(String sid) {
    this.sid = sid;
  }

  public SambaDomainOutput id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Unique identifier of this domain
   * @return id
  **/
  @ApiModelProperty(required = true, value = "Unique identifier of this domain")
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
    SambaDomainOutput sambaDomainOutput = (SambaDomainOutput) o;
    return Objects.equals(this.name, sambaDomainOutput.name) &&
        Objects.equals(this.sid, sambaDomainOutput.sid) &&
        Objects.equals(this.id, sambaDomainOutput.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, sid, id);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SambaDomainOutput {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    sid: ").append(toIndentedString(sid)).append("\n");
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

