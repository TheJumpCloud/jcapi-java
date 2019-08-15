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
import io.swagger.client.model.GraphConnection;
import io.swagger.client.model.GraphType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * GraphObjectWithPaths
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-08-09T16:30:22.486Z")
public class GraphObjectWithPaths {
  @SerializedName("type")
  private GraphType type = null;

  @SerializedName("id")
  private String id = null;

  @SerializedName("paths")
  private List<List<GraphConnection>> paths = new ArrayList<List<GraphConnection>>();

  public GraphObjectWithPaths type(GraphType type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(required = true, value = "")
  public GraphType getType() {
    return type;
  }

  public void setType(GraphType type) {
    this.type = type;
  }

  public GraphObjectWithPaths id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Object ID of this graph object.
   * @return id
  **/
  @ApiModelProperty(required = true, value = "Object ID of this graph object.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public GraphObjectWithPaths paths(List<List<GraphConnection>> paths) {
    this.paths = paths;
    return this;
  }

  public GraphObjectWithPaths addPathsItem(List<GraphConnection> pathsItem) {
    this.paths.add(pathsItem);
    return this;
  }

   /**
   * A path through the graph between two graph objects.
   * @return paths
  **/
  @ApiModelProperty(required = true, value = "A path through the graph between two graph objects.")
  public List<List<GraphConnection>> getPaths() {
    return paths;
  }

  public void setPaths(List<List<GraphConnection>> paths) {
    this.paths = paths;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GraphObjectWithPaths graphObjectWithPaths = (GraphObjectWithPaths) o;
    return Objects.equals(this.type, graphObjectWithPaths.type) &&
        Objects.equals(this.id, graphObjectWithPaths.id) &&
        Objects.equals(this.paths, graphObjectWithPaths.paths);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, id, paths);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GraphObjectWithPaths {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    paths: ").append(toIndentedString(paths)).append("\n");
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

