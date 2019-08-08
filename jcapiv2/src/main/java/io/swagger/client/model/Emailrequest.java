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
 * Emailrequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-08-08T01:00:26.426Z")
public class Emailrequest {
  /**
   * Gets or Sets emailType
   */
  @JsonAdapter(EmailTypeEnum.Adapter.class)
  public enum EmailTypeEnum {
    ACTIVATION("activation");

    private String value;

    EmailTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static EmailTypeEnum fromValue(String text) {
      for (EmailTypeEnum b : EmailTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<EmailTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final EmailTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public EmailTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return EmailTypeEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("emailType")
  private EmailTypeEnum emailType = null;

  public Emailrequest emailType(EmailTypeEnum emailType) {
    this.emailType = emailType;
    return this;
  }

   /**
   * Get emailType
   * @return emailType
  **/
  @ApiModelProperty(value = "")
  public EmailTypeEnum getEmailType() {
    return emailType;
  }

  public void setEmailType(EmailTypeEnum emailType) {
    this.emailType = emailType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Emailrequest emailrequest = (Emailrequest) o;
    return Objects.equals(this.emailType, emailrequest.emailType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(emailType);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Emailrequest {\n");
    
    sb.append("    emailType: ").append(toIndentedString(emailType)).append("\n");
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

