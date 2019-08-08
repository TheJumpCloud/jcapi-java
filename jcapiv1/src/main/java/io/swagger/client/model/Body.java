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
 * Body
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-08-08T00:50:04.431Z")
public class Body {
  @SerializedName("name")
  private String name = null;

  @SerializedName("networkSourceIp")
  private String networkSourceIp = null;

  @SerializedName("tags")
  private List<String> tags = null;

  @SerializedName("userLockoutAction")
  private String userLockoutAction = null;

  @SerializedName("userPasswordExpirationAction")
  private String userPasswordExpirationAction = null;

  /**
   * Gets or Sets mfa
   */
  @JsonAdapter(MfaEnum.Adapter.class)
  public enum MfaEnum {
    DISABLED("DISABLED"),
    
    ENABLED("ENABLED"),
    
    REQUIRED("REQUIRED"),
    
    ALWAYS("ALWAYS");

    private String value;

    MfaEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static MfaEnum fromValue(String text) {
      for (MfaEnum b : MfaEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<MfaEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final MfaEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public MfaEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return MfaEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("mfa")
  private MfaEnum mfa = null;

  public Body name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Body networkSourceIp(String networkSourceIp) {
    this.networkSourceIp = networkSourceIp;
    return this;
  }

   /**
   * Get networkSourceIp
   * @return networkSourceIp
  **/
  @ApiModelProperty(required = true, value = "")
  public String getNetworkSourceIp() {
    return networkSourceIp;
  }

  public void setNetworkSourceIp(String networkSourceIp) {
    this.networkSourceIp = networkSourceIp;
  }

  public Body tags(List<String> tags) {
    this.tags = tags;
    return this;
  }

  public Body addTagsItem(String tagsItem) {
    if (this.tags == null) {
      this.tags = new ArrayList<String>();
    }
    this.tags.add(tagsItem);
    return this;
  }

   /**
   * Get tags
   * @return tags
  **/
  @ApiModelProperty(value = "")
  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  public Body userLockoutAction(String userLockoutAction) {
    this.userLockoutAction = userLockoutAction;
    return this;
  }

   /**
   * Get userLockoutAction
   * @return userLockoutAction
  **/
  @ApiModelProperty(value = "")
  public String getUserLockoutAction() {
    return userLockoutAction;
  }

  public void setUserLockoutAction(String userLockoutAction) {
    this.userLockoutAction = userLockoutAction;
  }

  public Body userPasswordExpirationAction(String userPasswordExpirationAction) {
    this.userPasswordExpirationAction = userPasswordExpirationAction;
    return this;
  }

   /**
   * Get userPasswordExpirationAction
   * @return userPasswordExpirationAction
  **/
  @ApiModelProperty(value = "")
  public String getUserPasswordExpirationAction() {
    return userPasswordExpirationAction;
  }

  public void setUserPasswordExpirationAction(String userPasswordExpirationAction) {
    this.userPasswordExpirationAction = userPasswordExpirationAction;
  }

  public Body mfa(MfaEnum mfa) {
    this.mfa = mfa;
    return this;
  }

   /**
   * Get mfa
   * @return mfa
  **/
  @ApiModelProperty(value = "")
  public MfaEnum getMfa() {
    return mfa;
  }

  public void setMfa(MfaEnum mfa) {
    this.mfa = mfa;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Body body = (Body) o;
    return Objects.equals(this.name, body.name) &&
        Objects.equals(this.networkSourceIp, body.networkSourceIp) &&
        Objects.equals(this.tags, body.tags) &&
        Objects.equals(this.userLockoutAction, body.userLockoutAction) &&
        Objects.equals(this.userPasswordExpirationAction, body.userPasswordExpirationAction) &&
        Objects.equals(this.mfa, body.mfa);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, networkSourceIp, tags, userLockoutAction, userPasswordExpirationAction, mfa);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Body {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    networkSourceIp: ").append(toIndentedString(networkSourceIp)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    userLockoutAction: ").append(toIndentedString(userLockoutAction)).append("\n");
    sb.append("    userPasswordExpirationAction: ").append(toIndentedString(userPasswordExpirationAction)).append("\n");
    sb.append("    mfa: ").append(toIndentedString(mfa)).append("\n");
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

