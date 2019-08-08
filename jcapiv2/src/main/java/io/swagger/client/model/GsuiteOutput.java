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
 * GsuiteOutput
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-08-08T19:23:54.955Z")
public class GsuiteOutput {
  @SerializedName("id")
  private String id = null;

  /**
   * Gets or Sets userLockoutAction
   */
  @JsonAdapter(UserLockoutActionEnum.Adapter.class)
  public enum UserLockoutActionEnum {
    SUSPEND("suspend"),
    
    MAINTAIN("maintain");

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
   * Gets or Sets userPasswordExpirationAction
   */
  @JsonAdapter(UserPasswordExpirationActionEnum.Adapter.class)
  public enum UserPasswordExpirationActionEnum {
    SUSPEND("suspend"),
    
    MAINTAIN("maintain");

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

  public GsuiteOutput id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public GsuiteOutput userLockoutAction(UserLockoutActionEnum userLockoutAction) {
    this.userLockoutAction = userLockoutAction;
    return this;
  }

   /**
   * Get userLockoutAction
   * @return userLockoutAction
  **/
  @ApiModelProperty(value = "")
  public UserLockoutActionEnum getUserLockoutAction() {
    return userLockoutAction;
  }

  public void setUserLockoutAction(UserLockoutActionEnum userLockoutAction) {
    this.userLockoutAction = userLockoutAction;
  }

  public GsuiteOutput userPasswordExpirationAction(UserPasswordExpirationActionEnum userPasswordExpirationAction) {
    this.userPasswordExpirationAction = userPasswordExpirationAction;
    return this;
  }

   /**
   * Get userPasswordExpirationAction
   * @return userPasswordExpirationAction
  **/
  @ApiModelProperty(value = "")
  public UserPasswordExpirationActionEnum getUserPasswordExpirationAction() {
    return userPasswordExpirationAction;
  }

  public void setUserPasswordExpirationAction(UserPasswordExpirationActionEnum userPasswordExpirationAction) {
    this.userPasswordExpirationAction = userPasswordExpirationAction;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GsuiteOutput gsuiteOutput = (GsuiteOutput) o;
    return Objects.equals(this.id, gsuiteOutput.id) &&
        Objects.equals(this.userLockoutAction, gsuiteOutput.userLockoutAction) &&
        Objects.equals(this.userPasswordExpirationAction, gsuiteOutput.userPasswordExpirationAction);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userLockoutAction, userPasswordExpirationAction);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GsuiteOutput {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    userLockoutAction: ").append(toIndentedString(userLockoutAction)).append("\n");
    sb.append("    userPasswordExpirationAction: ").append(toIndentedString(userPasswordExpirationAction)).append("\n");
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

