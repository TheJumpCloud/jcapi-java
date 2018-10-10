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
import io.swagger.client.model.GraphType;
import java.io.IOException;

/**
 * GraphManagementReq
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-10-10T17:00:05.530Z")
public class GraphManagementReq {
  /**
   * How to modify the graph connection.
   */
  @JsonAdapter(OpEnum.Adapter.class)
  public enum OpEnum {
    ADD("add"),
    
    REMOVE("remove"),
    
    UPDATE("update");

    private String value;

    OpEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static OpEnum fromValue(String text) {
      for (OpEnum b : OpEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<OpEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final OpEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public OpEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return OpEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("op")
  private OpEnum op = null;

  @SerializedName("type")
  private GraphType type = null;

  @SerializedName("id")
  private String id = null;

  public GraphManagementReq op(OpEnum op) {
    this.op = op;
    return this;
  }

   /**
   * How to modify the graph connection.
   * @return op
  **/
  @ApiModelProperty(required = true, value = "How to modify the graph connection.")
  public OpEnum getOp() {
    return op;
  }

  public void setOp(OpEnum op) {
    this.op = op;
  }

  public GraphManagementReq type(GraphType type) {
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

  public GraphManagementReq id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The ObjectID of graph object being added or removed as an association.
   * @return id
  **/
  @ApiModelProperty(required = true, value = "The ObjectID of graph object being added or removed as an association.")
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
    GraphManagementReq graphManagementReq = (GraphManagementReq) o;
    return Objects.equals(this.op, graphManagementReq.op) &&
        Objects.equals(this.type, graphManagementReq.type) &&
        Objects.equals(this.id, graphManagementReq.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(op, type, id);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GraphManagementReq {\n");
    
    sb.append("    op: ").append(toIndentedString(op)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

