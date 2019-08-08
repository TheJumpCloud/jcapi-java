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
import io.swagger.client.model.LdapServerInput;
import java.io.IOException;

/**
 * LdapServerOutput
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-08-08T01:09:43.537Z")
public class LdapServerOutput {
  @SerializedName("name")
  private String name = null;

  /**
   * action to take; one of &#39;remove&#39; or &#39;disable&#39;
   */
  @JsonAdapter(UserLockoutActionEnum.Adapter.class)
  public enum UserLockoutActionEnum {
    DISABLE("disable"),
    
    REMOVE("remove");

    private String value;

    UserLockoutActionEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static UserLockoutActionEnum fromValue(String text) {
      for (UserLockoutActionEnum b : UserLockoutActionEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<UserLockoutActionEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final UserLockoutActionEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public UserLockoutActionEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return UserLockoutActionEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("userLockoutAction")
  private UserLockoutActionEnum userLockoutAction = null;

  /**
   * action to take; one of &#39;remove&#39; or &#39;disable&#39;
   */
  @JsonAdapter(UserPasswordExpirationActionEnum.Adapter.class)
  public enum UserPasswordExpirationActionEnum {
    DISABLE("disable"),
    
    REMOVE("remove");

    private String value;

    UserPasswordExpirationActionEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static UserPasswordExpirationActionEnum fromValue(String text) {
      for (UserPasswordExpirationActionEnum b : UserPasswordExpirationActionEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<UserPasswordExpirationActionEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final UserPasswordExpirationActionEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public UserPasswordExpirationActionEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return UserPasswordExpirationActionEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("userPasswordExpirationAction")
  private UserPasswordExpirationActionEnum userPasswordExpirationAction = null;

  @SerializedName("id")
  private String id = null;

  public LdapServerOutput name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of this LDAP server
   * @return name
  **/
  @ApiModelProperty(value = "The name of this LDAP server")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LdapServerOutput userLockoutAction(UserLockoutActionEnum userLockoutAction) {
    this.userLockoutAction = userLockoutAction;
    return this;
  }

   /**
   * action to take; one of &#39;remove&#39; or &#39;disable&#39;
   * @return userLockoutAction
  **/
  @ApiModelProperty(value = "action to take; one of 'remove' or 'disable'")
  public UserLockoutActionEnum getUserLockoutAction() {
    return userLockoutAction;
  }

  public void setUserLockoutAction(UserLockoutActionEnum userLockoutAction) {
    this.userLockoutAction = userLockoutAction;
  }

  public LdapServerOutput userPasswordExpirationAction(UserPasswordExpirationActionEnum userPasswordExpirationAction) {
    this.userPasswordExpirationAction = userPasswordExpirationAction;
    return this;
  }

   /**
   * action to take; one of &#39;remove&#39; or &#39;disable&#39;
   * @return userPasswordExpirationAction
  **/
  @ApiModelProperty(value = "action to take; one of 'remove' or 'disable'")
  public UserPasswordExpirationActionEnum getUserPasswordExpirationAction() {
    return userPasswordExpirationAction;
  }

  public void setUserPasswordExpirationAction(UserPasswordExpirationActionEnum userPasswordExpirationAction) {
    this.userPasswordExpirationAction = userPasswordExpirationAction;
  }

  public LdapServerOutput id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Unique identifier of this LDAP server
   * @return id
  **/
  @ApiModelProperty(required = true, value = "Unique identifier of this LDAP server")
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
    LdapServerOutput ldapServerOutput = (LdapServerOutput) o;
    return Objects.equals(this.name, ldapServerOutput.name) &&
        Objects.equals(this.userLockoutAction, ldapServerOutput.userLockoutAction) &&
        Objects.equals(this.userPasswordExpirationAction, ldapServerOutput.userPasswordExpirationAction) &&
        Objects.equals(this.id, ldapServerOutput.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, userLockoutAction, userPasswordExpirationAction, id);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LdapServerOutput {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    userLockoutAction: ").append(toIndentedString(userLockoutAction)).append("\n");
    sb.append("    userPasswordExpirationAction: ").append(toIndentedString(userPasswordExpirationAction)).append("\n");
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

