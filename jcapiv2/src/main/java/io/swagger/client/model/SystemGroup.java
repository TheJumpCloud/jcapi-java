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

/**
 * SystemGroup
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-10-10T17:00:05.530Z")
public class SystemGroup {
  @SerializedName("id")
  private String id = null;

  /**
   * The type of the group; always &#39;system&#39; for a System Group.
   */
  @JsonAdapter(TypeEnum.Adapter.class)
  public enum TypeEnum {
    GROUP("system_group");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static TypeEnum fromValue(String text) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<TypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TypeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return TypeEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("type")
  private TypeEnum type = null;

  @SerializedName("name")
  private String name = null;

  public SystemGroup id(String id) {
    this.id = id;
    return this;
  }

   /**
   * ObjectId uniquely identifying a System Group.
   * @return id
  **/
  @ApiModelProperty(value = "ObjectId uniquely identifying a System Group.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public SystemGroup type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * The type of the group; always &#39;system&#39; for a System Group.
   * @return type
  **/
  @ApiModelProperty(value = "The type of the group; always 'system' for a System Group.")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public SystemGroup name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Display name of a System Group.
   * @return name
  **/
  @ApiModelProperty(value = "Display name of a System Group.")
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
    SystemGroup systemGroup = (SystemGroup) o;
    return Objects.equals(this.id, systemGroup.id) &&
        Objects.equals(this.type, systemGroup.type) &&
        Objects.equals(this.name, systemGroup.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, type, name);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemGroup {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

