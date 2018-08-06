/*
 * JumpCloud APIs
 * V1 & V2 versions of JumpCloud's API. The previous version of JumpCloud's API. This set of endpoints allows JumpCloud customers to manage commands, systems, & system users.
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
 * CommandfilereturnResults
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-08-06T18:14:17.283Z")
public class CommandfilereturnResults {
  @SerializedName("name")
  private String name = null;

  @SerializedName("destination")
  private String destination = null;

  @SerializedName("_id")
  private String id = null;

  public CommandfilereturnResults name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The file name.
   * @return name
  **/
  @ApiModelProperty(value = "The file name.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CommandfilereturnResults destination(String destination) {
    this.destination = destination;
    return this;
  }

   /**
   * the location where the file willl be stored.
   * @return destination
  **/
  @ApiModelProperty(value = "the location where the file willl be stored.")
  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  public CommandfilereturnResults id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The ID of the file.
   * @return id
  **/
  @ApiModelProperty(value = "The ID of the file.")
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
    CommandfilereturnResults commandfilereturnResults = (CommandfilereturnResults) o;
    return Objects.equals(this.name, commandfilereturnResults.name) &&
        Objects.equals(this.destination, commandfilereturnResults.destination) &&
        Objects.equals(this.id, commandfilereturnResults.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, destination, id);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommandfilereturnResults {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    destination: ").append(toIndentedString(destination)).append("\n");
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

