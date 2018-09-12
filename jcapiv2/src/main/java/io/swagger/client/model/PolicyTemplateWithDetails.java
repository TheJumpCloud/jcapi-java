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
import io.swagger.client.model.PolicyTemplateConfigField;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The shallow information about a Policy Template.
 */
@ApiModel(description = "The shallow information about a Policy Template.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-09-12T21:14:00.825Z")
public class PolicyTemplateWithDetails {
  @SerializedName("id")
  private String id = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("displayName")
  private String displayName = null;

  /**
   * Gets or Sets osMetaFamily
   */
  @JsonAdapter(OsMetaFamilyEnum.Adapter.class)
  public enum OsMetaFamilyEnum {
    LINUX("linux"),
    
    DARWIN("darwin"),
    
    WINDOWS("windows");

    private String value;

    OsMetaFamilyEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static OsMetaFamilyEnum fromValue(String text) {
      for (OsMetaFamilyEnum b : OsMetaFamilyEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<OsMetaFamilyEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final OsMetaFamilyEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public OsMetaFamilyEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return OsMetaFamilyEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("osMetaFamily")
  private OsMetaFamilyEnum osMetaFamily = null;

  @SerializedName("configFields")
  private List<PolicyTemplateConfigField> configFields = null;

  @SerializedName("activation")
  private String activation = null;

  @SerializedName("behavior")
  private String behavior = null;

  public PolicyTemplateWithDetails id(String id) {
    this.id = id;
    return this;
  }

   /**
   * ObjectId uniquely indetifying a Policy Template.
   * @return id
  **/
  @ApiModelProperty(value = "ObjectId uniquely indetifying a Policy Template.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public PolicyTemplateWithDetails name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The unique name for the Policy Template.
   * @return name
  **/
  @ApiModelProperty(value = "The unique name for the Policy Template.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PolicyTemplateWithDetails description(String description) {
    this.description = description;
    return this;
  }

   /**
   * The default description for the Policy.
   * @return description
  **/
  @ApiModelProperty(value = "The default description for the Policy.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public PolicyTemplateWithDetails displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }

   /**
   * The default display name for the Policy.
   * @return displayName
  **/
  @ApiModelProperty(value = "The default display name for the Policy.")
  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public PolicyTemplateWithDetails osMetaFamily(OsMetaFamilyEnum osMetaFamily) {
    this.osMetaFamily = osMetaFamily;
    return this;
  }

   /**
   * Get osMetaFamily
   * @return osMetaFamily
  **/
  @ApiModelProperty(value = "")
  public OsMetaFamilyEnum getOsMetaFamily() {
    return osMetaFamily;
  }

  public void setOsMetaFamily(OsMetaFamilyEnum osMetaFamily) {
    this.osMetaFamily = osMetaFamily;
  }

  public PolicyTemplateWithDetails configFields(List<PolicyTemplateConfigField> configFields) {
    this.configFields = configFields;
    return this;
  }

  public PolicyTemplateWithDetails addConfigFieldsItem(PolicyTemplateConfigField configFieldsItem) {
    if (this.configFields == null) {
      this.configFields = new ArrayList<PolicyTemplateConfigField>();
    }
    this.configFields.add(configFieldsItem);
    return this;
  }

   /**
   * An unordered list of all the fields that can be configured for this Policy Template.
   * @return configFields
  **/
  @ApiModelProperty(value = "An unordered list of all the fields that can be configured for this Policy Template.")
  public List<PolicyTemplateConfigField> getConfigFields() {
    return configFields;
  }

  public void setConfigFields(List<PolicyTemplateConfigField> configFields) {
    this.configFields = configFields;
  }

  public PolicyTemplateWithDetails activation(String activation) {
    this.activation = activation;
    return this;
  }

   /**
   * Requirements before the policy can be activated.
   * @return activation
  **/
  @ApiModelProperty(value = "Requirements before the policy can be activated.")
  public String getActivation() {
    return activation;
  }

  public void setActivation(String activation) {
    this.activation = activation;
  }

  public PolicyTemplateWithDetails behavior(String behavior) {
    this.behavior = behavior;
    return this;
  }

   /**
   * Specifics about the behavior of the policy.
   * @return behavior
  **/
  @ApiModelProperty(value = "Specifics about the behavior of the policy.")
  public String getBehavior() {
    return behavior;
  }

  public void setBehavior(String behavior) {
    this.behavior = behavior;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PolicyTemplateWithDetails policyTemplateWithDetails = (PolicyTemplateWithDetails) o;
    return Objects.equals(this.id, policyTemplateWithDetails.id) &&
        Objects.equals(this.name, policyTemplateWithDetails.name) &&
        Objects.equals(this.description, policyTemplateWithDetails.description) &&
        Objects.equals(this.displayName, policyTemplateWithDetails.displayName) &&
        Objects.equals(this.osMetaFamily, policyTemplateWithDetails.osMetaFamily) &&
        Objects.equals(this.configFields, policyTemplateWithDetails.configFields) &&
        Objects.equals(this.activation, policyTemplateWithDetails.activation) &&
        Objects.equals(this.behavior, policyTemplateWithDetails.behavior);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, displayName, osMetaFamily, configFields, activation, behavior);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PolicyTemplateWithDetails {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    osMetaFamily: ").append(toIndentedString(osMetaFamily)).append("\n");
    sb.append("    configFields: ").append(toIndentedString(configFields)).append("\n");
    sb.append("    activation: ").append(toIndentedString(activation)).append("\n");
    sb.append("    behavior: ").append(toIndentedString(behavior)).append("\n");
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

