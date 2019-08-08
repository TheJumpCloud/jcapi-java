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
 * ActiveDirectoryAgentGetOutput
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-08-08T01:06:48.987Z")
public class ActiveDirectoryAgentGetOutput {
  @SerializedName("id")
  private String id = null;

  @SerializedName("connectKey")
  private String connectKey = null;

  public ActiveDirectoryAgentGetOutput id(String id) {
    this.id = id;
    return this;
  }

   /**
   * ObjectID of this Active Directory Agent.
   * @return id
  **/
  @ApiModelProperty(required = true, value = "ObjectID of this Active Directory Agent.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ActiveDirectoryAgentGetOutput connectKey(String connectKey) {
    this.connectKey = connectKey;
    return this;
  }

   /**
   * The connect key to use when installing the Agent on a Domain Controller.
   * @return connectKey
  **/
  @ApiModelProperty(value = "The connect key to use when installing the Agent on a Domain Controller.")
  public String getConnectKey() {
    return connectKey;
  }

  public void setConnectKey(String connectKey) {
    this.connectKey = connectKey;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ActiveDirectoryAgentGetOutput activeDirectoryAgentGetOutput = (ActiveDirectoryAgentGetOutput) o;
    return Objects.equals(this.id, activeDirectoryAgentGetOutput.id) &&
        Objects.equals(this.connectKey, activeDirectoryAgentGetOutput.connectKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, connectKey);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ActiveDirectoryAgentGetOutput {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    connectKey: ").append(toIndentedString(connectKey)).append("\n");
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

