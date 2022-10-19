/*
 * JumpCloud API
 * # Overview  JumpCloud's V1 API. This set of endpoints allows JumpCloud customers to manage commands, systems, and system users.  # API Key  ## Access Your API Key  To locate your API Key:  1. Log into the [JumpCloud Admin Console](https://console.jumpcloud.com/). 2. Go to the username drop down located in the top-right of the Console. 3. Retrieve your API key from API Settings.  ## API Key Considerations  This API key is associated to the currently logged in administrator. Other admins will have different API keys.  **WARNING** Please keep this API key secret, as it grants full access to any data accessible via your JumpCloud console account.  You can also reset your API key in the same location in the JumpCloud Admin Console.  ## Recycling or Resetting Your API Key  In order to revoke access with the current API key, simply reset your API key. This will render all calls using the previous API key inaccessible.  Your API key will be passed in as a header with the header name \"x-api-key\".  ```bash curl -H \"x-api-key: [YOUR_API_KEY_HERE]\" \"https://console.jumpcloud.com/api/systemusers\" ```  # System Context  * [Introduction](#introduction) * [Supported endpoints](#supported-endpoints) * [Response codes](#response-codes) * [Authentication](#authentication) * [Additional examples](#additional-examples) * [Third party](#third-party)  ## Introduction  JumpCloud System Context Authorization is an alternative way to authenticate with a subset of JumpCloud's REST APIs. Using this method, a system can manage its information and resource associations, allowing modern auto provisioning environments to scale as needed.  **Notes:**   * The following documentation applies to Linux Operating Systems only.  * Systems that have been automatically enrolled using Apple's Device Enrollment Program (DEP) or systems enrolled using the User Portal install are not eligible to use the System Context API to prevent unauthorized access to system groups and resources. If a script that utilizes the System Context API is invoked on a system enrolled in this way, it will display an error.  ## Supported Endpoints  JumpCloud System Context Authorization can be used in conjunction with Systems endpoints found in the V1 API and certain System Group endpoints found in the v2 API.  * A system may fetch, alter, and delete metadata about itself, including manipulating a system's Group and Systemuser associations,   * `/api/systems/{system_id}` | [`GET`](https://docs.jumpcloud.com/api/1.0/index.html#operation/systems_get) [`PUT`](https://docs.jumpcloud.com/api/1.0/index.html#operation/systems_put) * A system may delete itself from your JumpCloud organization   * `/api/systems/{system_id}` | [`DELETE`](https://docs.jumpcloud.com/api/1.0/index.html#operation/systems_delete) * A system may fetch its direct resource associations under v2 (Groups)   * `/api/v2/systems/{system_id}/memberof` | [`GET`](https://docs.jumpcloud.com/api/2.0/index.html#operation/graph_systemGroupMembership)   * `/api/v2/systems/{system_id}/associations` | [`GET`](https://docs.jumpcloud.com/api/2.0/index.html#operation/graph_systemAssociationsList)   * `/api/v2/systems/{system_id}/users` | [`GET`](https://docs.jumpcloud.com/api/2.0/index.html#operation/graph_systemTraverseUser) * A system may alter its direct resource associations under v2 (Groups)   * `/api/v2/systems/{system_id}/associations` | [`POST`](https://docs.jumpcloud.com/api/2.0/index.html#operation/graph_systemAssociationsPost) * A system may alter its System Group associations   * `/api/v2/systemgroups/{group_id}/members` | [`POST`](https://docs.jumpcloud.com/api/2.0/index.html#operation/graph_systemGroupMembersPost)     * _NOTE_ If a system attempts to alter the system group membership of a different system the request will be rejected  ## Response Codes  If endpoints other than those described above are called using the System Context API, the server will return a `401` response.  ## Authentication  To allow for secure access to our APIs, you must authenticate each API request. JumpCloud System Context Authorization uses [HTTP Signatures](https://tools.ietf.org/html/draft-cavage-http-signatures-00) to authenticate API requests. The HTTP Signatures sent with each request are similar to the signatures used by the Amazon Web Services REST API. To help with the request-signing process, we have provided an [example bash script](https://github.com/TheJumpCloud/SystemContextAPI/blob/master/examples/shell/SigningExample.sh). This example API request simply requests the entire system record. You must be root, or have permissions to access the contents of the `/opt/jc` directory to generate a signature.  Here is a breakdown of the example script with explanations.  First, the script extracts the systemKey from the JSON formatted `/opt/jc/jcagent.conf` file.  ```bash #!/bin/bash conf=\"`cat /opt/jc/jcagent.conf`\" regex=\"systemKey\\\":\\\"(\\w+)\\\"\"  if [[ $conf =~ $regex ]] ; then   systemKey=\"${BASH_REMATCH[1]}\" fi ```  Then, the script retrieves the current date in the correct format.  ```bash now=`date -u \"+%a, %d %h %Y %H:%M:%S GMT\"`; ```  Next, we build a signing string to demonstrate the expected signature format. The signed string must consist of the [request-line](https://tools.ietf.org/html/rfc2616#page-35) and the date header, separated by a newline character.  ```bash signstr=\"GET /api/systems/${systemKey} HTTP/1.1\\ndate: ${now}\" ```  The next step is to calculate and apply the signature. This is a two-step process:  1. Create a signature from the signing string using the JumpCloud Agent private key: ``printf \"$signstr\" | openssl dgst -sha256 -sign /opt/jc/client.key`` 2. Then Base64-encode the signature string and trim off the newline characters: ``| openssl enc -e -a | tr -d '\\n'``  The combined steps above result in:  ```bash signature=`printf \"$signstr\" | openssl dgst -sha256 -sign /opt/jc/client.key | openssl enc -e -a | tr -d '\\n'` ; ```  Finally, we make sure the API call sending the signature has the same Authorization and Date header values, HTTP method, and URL that were used in the signing string.  ```bash curl -iq \\   -H \"Accept: application/json\" \\   -H \"Content-Type: application/json\" \\   -H \"Date: ${now}\" \\   -H \"Authorization: Signature keyId=\\\"system/${systemKey}\\\",headers=\\\"request-line date\\\",algorithm=\\\"rsa-sha256\\\",signature=\\\"${signature}\\\"\" \\   --url https://console.jumpcloud.com/api/systems/${systemKey} ```  ### Input Data  All PUT and POST methods should use the HTTP Content-Type header with a value of 'application/json'. PUT methods are used for updating a record. POST methods are used to create a record.  The following example demonstrates how to update the `displayName` of the system.  ```bash signstr=\"PUT /api/systems/${systemKey} HTTP/1.1\\ndate: ${now}\" signature=`printf \"$signstr\" | openssl dgst -sha256 -sign /opt/jc/client.key | openssl enc -e -a | tr -d '\\n'` ;  curl -iq \\   -d \"{\\\"displayName\\\" : \\\"updated-system-name-1\\\"}\" \\   -X \"PUT\" \\   -H \"Content-Type: application/json\" \\   -H \"Accept: application/json\" \\   -H \"Date: ${now}\" \\   -H \"Authorization: Signature keyId=\\\"system/${systemKey}\\\",headers=\\\"request-line date\\\",algorithm=\\\"rsa-sha256\\\",signature=\\\"${signature}\\\"\" \\   --url https://console.jumpcloud.com/api/systems/${systemKey} ```  ### Output Data  All results will be formatted as JSON.  Here is an abbreviated example of response output:  ```json {   \"_id\": \"525ee96f52e144993e000015\",   \"agentServer\": \"lappy386\",   \"agentVersion\": \"0.9.42\",   \"arch\": \"x86_64\",   \"connectionKey\": \"127.0.0.1_51812\",   \"displayName\": \"ubuntu-1204\",   \"firstContact\": \"2013-10-16T19:30:55.611Z\",   \"hostname\": \"ubuntu-1204\"   ... ```  ## Additional Examples  ### Signing Authentication Example  This example demonstrates how to make an authenticated request to fetch the JumpCloud record for this system.  [SigningExample.sh](https://github.com/TheJumpCloud/SystemContextAPI/blob/master/examples/shell/SigningExample.sh)  ### Shutdown Hook  This example demonstrates how to make an authenticated request on system shutdown. Using an init.d script registered at run level 0, you can call the System Context API as the system is shutting down.  [Instance-shutdown-initd](https://github.com/TheJumpCloud/SystemContextAPI/blob/master/examples/instance-shutdown-initd) is an example of an init.d script that only runs at system shutdown.  After customizing the [instance-shutdown-initd](https://github.com/TheJumpCloud/SystemContextAPI/blob/master/examples/instance-shutdown-initd) script, you should install it on the system(s) running the JumpCloud agent.  1. Copy the modified [instance-shutdown-initd](https://github.com/TheJumpCloud/SystemContextAPI/blob/master/examples/instance-shutdown-initd) to `/etc/init.d/instance-shutdown`. 2. On Ubuntu systems, run `update-rc.d instance-shutdown defaults`. On RedHat/CentOS systems, run `chkconfig --add instance-shutdown`.  ## Third Party  ### Chef Cookbooks  [https://github.com/nshenry03/jumpcloud](https://github.com/nshenry03/jumpcloud)  [https://github.com/cjs226/jumpcloud](https://github.com/cjs226/jumpcloud)  # Multi-Tenant Portal Headers  Multi-Tenant Organization API Headers are available for JumpCloud Admins to use when making API requests from Organizations that have multiple managed organizations.  The `x-org-id` is a required header for all multi-tenant admins when making API requests to JumpCloud. This header will define to which organization you would like to make the request.  **NOTE** Single Tenant Admins do not need to provide this header when making an API request.  ## Header Value  `x-org-id`  ## API Response Codes  * `400` Malformed ID. * `400` x-org-id and Organization path ID do not match. * `401` ID not included for multi-tenant admin * `403` ID included on unsupported route. * `404` Organization ID Not Found.  ```bash curl -X GET https://console.jumpcloud.com/api/v2/directories \\   -H 'accept: application/json' \\   -H 'content-type: application/json' \\   -H 'x-api-key: {API_KEY}' \\   -H 'x-org-id: {ORG_ID}'  ```  ## To Obtain an Individual Organization ID via the UI  As a prerequisite, your Primary Organization will need to be setup for Multi-Tenancy. This provides access to the Multi-Tenant Organization Admin Portal.  1. Log into JumpCloud [Admin Console](https://console.jumpcloud.com). If you are a multi-tenant Admin, you will automatically be routed to the Multi-Tenant Admin Portal. 2. From the Multi-Tenant Portal's primary navigation bar, select the Organization you'd like to access. 3. You will automatically be routed to that Organization's Admin Console. 4. Go to Settings in the sub-tenant's primary navigation. 5. You can obtain your Organization ID below your Organization's Contact Information on the Settings page.  ## To Obtain All Organization IDs via the API  * You can make an API request to this endpoint using the API key of your Primary Organization.  `https://console.jumpcloud.com/api/organizations/` This will return all your managed organizations.  ```bash curl -X GET \\   https://console.jumpcloud.com/api/organizations/ \\   -H 'Accept: application/json' \\   -H 'Content-Type: application/json' \\   -H 'x-api-key: {API_KEY}' ```  # SDKs  You can find language specific SDKs that can help you kickstart your Integration with JumpCloud in the following GitHub repositories:  * [Python](https://github.com/TheJumpCloud/jcapi-python) * [Go](https://github.com/TheJumpCloud/jcapi-go) * [Ruby](https://github.com/TheJumpCloud/jcapi-ruby) * [Java](https://github.com/TheJumpCloud/jcapi-java) 
 *
 * OpenAPI spec version: 1.0
 * Contact: support@jumpcloud.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * Radiusserverput
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-10-19T07:50:09.958678Z[Etc/UTC]")
public class Radiusserverput {
  @SerializedName("_id")
  private String _id = null;

  /**
   * Gets or Sets authIdp
   */
  @JsonAdapter(AuthIdpEnum.Adapter.class)
  public enum AuthIdpEnum {
    JUMPCLOUD("JUMPCLOUD"),
    AZURE("AZURE");

    private String value;

    AuthIdpEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static AuthIdpEnum fromValue(String input) {
      for (AuthIdpEnum b : AuthIdpEnum.values()) {
        if (b.value.equals(input)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<AuthIdpEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final AuthIdpEnum enumeration) throws IOException {
        jsonWriter.value(String.valueOf(enumeration.getValue()));
      }

      @Override
      public AuthIdpEnum read(final JsonReader jsonReader) throws IOException {
        Object value = jsonReader.nextString();
        return AuthIdpEnum.fromValue((String)(value));
      }
    }
  }  @SerializedName("authIdp")
  private AuthIdpEnum authIdp = null;

  @SerializedName("deviceCertEnabled")
  private Boolean deviceCertEnabled = null;

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
    public static MfaEnum fromValue(String input) {
      for (MfaEnum b : MfaEnum.values()) {
        if (b.value.equals(input)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<MfaEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final MfaEnum enumeration) throws IOException {
        jsonWriter.value(String.valueOf(enumeration.getValue()));
      }

      @Override
      public MfaEnum read(final JsonReader jsonReader) throws IOException {
        Object value = jsonReader.nextString();
        return MfaEnum.fromValue((String)(value));
      }
    }
  }  @SerializedName("mfa")
  private MfaEnum mfa = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("networkSourceIp")
  private String networkSourceIp = null;

  @SerializedName("tagNames")
  private List<String> tagNames = null;

  @SerializedName("userCertEnabled")
  private Boolean userCertEnabled = null;

  @SerializedName("userLockoutAction")
  private String userLockoutAction = null;

  @SerializedName("userPasswordEnabled")
  private Boolean userPasswordEnabled = null;

  @SerializedName("userPasswordExpirationAction")
  private String userPasswordExpirationAction = null;

  public Radiusserverput _id(String _id) {
    this._id = _id;
    return this;
  }

   /**
   * Get _id
   * @return _id
  **/
  @Schema(description = "")
  public String getId() {
    return _id;
  }

  public void setId(String _id) {
    this._id = _id;
  }

  public Radiusserverput authIdp(AuthIdpEnum authIdp) {
    this.authIdp = authIdp;
    return this;
  }

   /**
   * Get authIdp
   * @return authIdp
  **/
  @Schema(description = "")
  public AuthIdpEnum getAuthIdp() {
    return authIdp;
  }

  public void setAuthIdp(AuthIdpEnum authIdp) {
    this.authIdp = authIdp;
  }

  public Radiusserverput deviceCertEnabled(Boolean deviceCertEnabled) {
    this.deviceCertEnabled = deviceCertEnabled;
    return this;
  }

   /**
   * Get deviceCertEnabled
   * @return deviceCertEnabled
  **/
  @Schema(description = "")
  public Boolean isDeviceCertEnabled() {
    return deviceCertEnabled;
  }

  public void setDeviceCertEnabled(Boolean deviceCertEnabled) {
    this.deviceCertEnabled = deviceCertEnabled;
  }

  public Radiusserverput mfa(MfaEnum mfa) {
    this.mfa = mfa;
    return this;
  }

   /**
   * Get mfa
   * @return mfa
  **/
  @Schema(description = "")
  public MfaEnum getMfa() {
    return mfa;
  }

  public void setMfa(MfaEnum mfa) {
    this.mfa = mfa;
  }

  public Radiusserverput name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @Schema(description = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Radiusserverput networkSourceIp(String networkSourceIp) {
    this.networkSourceIp = networkSourceIp;
    return this;
  }

   /**
   * Get networkSourceIp
   * @return networkSourceIp
  **/
  @Schema(description = "")
  public String getNetworkSourceIp() {
    return networkSourceIp;
  }

  public void setNetworkSourceIp(String networkSourceIp) {
    this.networkSourceIp = networkSourceIp;
  }

  public Radiusserverput tagNames(List<String> tagNames) {
    this.tagNames = tagNames;
    return this;
  }

  public Radiusserverput addTagNamesItem(String tagNamesItem) {
    if (this.tagNames == null) {
      this.tagNames = new ArrayList<String>();
    }
    this.tagNames.add(tagNamesItem);
    return this;
  }

   /**
   * Get tagNames
   * @return tagNames
  **/
  @Schema(description = "")
  public List<String> getTagNames() {
    return tagNames;
  }

  public void setTagNames(List<String> tagNames) {
    this.tagNames = tagNames;
  }

  public Radiusserverput userCertEnabled(Boolean userCertEnabled) {
    this.userCertEnabled = userCertEnabled;
    return this;
  }

   /**
   * Get userCertEnabled
   * @return userCertEnabled
  **/
  @Schema(description = "")
  public Boolean isUserCertEnabled() {
    return userCertEnabled;
  }

  public void setUserCertEnabled(Boolean userCertEnabled) {
    this.userCertEnabled = userCertEnabled;
  }

  public Radiusserverput userLockoutAction(String userLockoutAction) {
    this.userLockoutAction = userLockoutAction;
    return this;
  }

   /**
   * Get userLockoutAction
   * @return userLockoutAction
  **/
  @Schema(description = "")
  public String getUserLockoutAction() {
    return userLockoutAction;
  }

  public void setUserLockoutAction(String userLockoutAction) {
    this.userLockoutAction = userLockoutAction;
  }

  public Radiusserverput userPasswordEnabled(Boolean userPasswordEnabled) {
    this.userPasswordEnabled = userPasswordEnabled;
    return this;
  }

   /**
   * Get userPasswordEnabled
   * @return userPasswordEnabled
  **/
  @Schema(description = "")
  public Boolean isUserPasswordEnabled() {
    return userPasswordEnabled;
  }

  public void setUserPasswordEnabled(Boolean userPasswordEnabled) {
    this.userPasswordEnabled = userPasswordEnabled;
  }

  public Radiusserverput userPasswordExpirationAction(String userPasswordExpirationAction) {
    this.userPasswordExpirationAction = userPasswordExpirationAction;
    return this;
  }

   /**
   * Get userPasswordExpirationAction
   * @return userPasswordExpirationAction
  **/
  @Schema(description = "")
  public String getUserPasswordExpirationAction() {
    return userPasswordExpirationAction;
  }

  public void setUserPasswordExpirationAction(String userPasswordExpirationAction) {
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
    Radiusserverput radiusserverput = (Radiusserverput) o;
    return Objects.equals(this._id, radiusserverput._id) &&
        Objects.equals(this.authIdp, radiusserverput.authIdp) &&
        Objects.equals(this.deviceCertEnabled, radiusserverput.deviceCertEnabled) &&
        Objects.equals(this.mfa, radiusserverput.mfa) &&
        Objects.equals(this.name, radiusserverput.name) &&
        Objects.equals(this.networkSourceIp, radiusserverput.networkSourceIp) &&
        Objects.equals(this.tagNames, radiusserverput.tagNames) &&
        Objects.equals(this.userCertEnabled, radiusserverput.userCertEnabled) &&
        Objects.equals(this.userLockoutAction, radiusserverput.userLockoutAction) &&
        Objects.equals(this.userPasswordEnabled, radiusserverput.userPasswordEnabled) &&
        Objects.equals(this.userPasswordExpirationAction, radiusserverput.userPasswordExpirationAction);
  }

  @Override
  public int hashCode() {
    return Objects.hash(_id, authIdp, deviceCertEnabled, mfa, name, networkSourceIp, tagNames, userCertEnabled, userLockoutAction, userPasswordEnabled, userPasswordExpirationAction);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Radiusserverput {\n");
    
    sb.append("    _id: ").append(toIndentedString(_id)).append("\n");
    sb.append("    authIdp: ").append(toIndentedString(authIdp)).append("\n");
    sb.append("    deviceCertEnabled: ").append(toIndentedString(deviceCertEnabled)).append("\n");
    sb.append("    mfa: ").append(toIndentedString(mfa)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    networkSourceIp: ").append(toIndentedString(networkSourceIp)).append("\n");
    sb.append("    tagNames: ").append(toIndentedString(tagNames)).append("\n");
    sb.append("    userCertEnabled: ").append(toIndentedString(userCertEnabled)).append("\n");
    sb.append("    userLockoutAction: ").append(toIndentedString(userLockoutAction)).append("\n");
    sb.append("    userPasswordEnabled: ").append(toIndentedString(userPasswordEnabled)).append("\n");
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
