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
import java.util.ArrayList;
import java.util.List;

/**
 * Systemuserbindingsput
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-11-21T20:17:09.332Z")
public class Systemuserbindingsput {
  @SerializedName("add")
  private List<String> add = new ArrayList<String>();

  @SerializedName("remove")
  private List<String> remove = new ArrayList<String>();

  public Systemuserbindingsput add(List<String> add) {
    this.add = add;
    return this;
  }

  public Systemuserbindingsput addAddItem(String addItem) {
    this.add.add(addItem);
    return this;
  }

   /**
   * The list of systemuser ids to be added to this system.
   * @return add
  **/
  @ApiModelProperty(required = true, value = "The list of systemuser ids to be added to this system.")
  public List<String> getAdd() {
    return add;
  }

  public void setAdd(List<String> add) {
    this.add = add;
  }

  public Systemuserbindingsput remove(List<String> remove) {
    this.remove = remove;
    return this;
  }

  public Systemuserbindingsput addRemoveItem(String removeItem) {
    this.remove.add(removeItem);
    return this;
  }

   /**
   * The list of systemuser ids to be removed from this system.
   * @return remove
  **/
  @ApiModelProperty(required = true, value = "The list of systemuser ids to be removed from this system.")
  public List<String> getRemove() {
    return remove;
  }

  public void setRemove(List<String> remove) {
    this.remove = remove;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Systemuserbindingsput systemuserbindingsput = (Systemuserbindingsput) o;
    return Objects.equals(this.add, systemuserbindingsput.add) &&
        Objects.equals(this.remove, systemuserbindingsput.remove);
  }

  @Override
  public int hashCode() {
    return Objects.hash(add, remove);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Systemuserbindingsput {\n");
    
    sb.append("    add: ").append(toIndentedString(add)).append("\n");
    sb.append("    remove: ").append(toIndentedString(remove)).append("\n");
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

