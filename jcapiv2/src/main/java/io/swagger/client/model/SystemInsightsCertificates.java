/*
 * JumpCloud API
 * # Overview  JumpCloud's V2 API. This set of endpoints allows JumpCloud customers to manage objects, groupings and mappings and interact with the JumpCloud Graph.  # Directory Objects  This API offers the ability to interact with some of our core features; otherwise known as Directory Objects. The Directory Objects are:  * Commands * Policies * Policy Groups * Applications * Systems * Users * User Groups * System Groups * Radius Servers * Directories: Office 365, LDAP,G-Suite, Active Directory * Duo accounts and applications.  The Directory Object is an important concept to understand in order to successfully use JumpCloud API.  ## JumpCloud Graph  We've also introduced the concept of the JumpCloud Graph along with  Directory Objects. The Graph is a powerful aspect of our platform which will enable you to associate objects with each other, or establish membership for certain objects to become members of other objects.  Specific `GET` endpoints will allow you to traverse the JumpCloud Graph to return all indirect and directly bound objects in your organization.  | ![alt text](https://s3.amazonaws.com/jumpcloud-kb/Knowledge+Base+Photos/API+Docs/jumpcloud_graph.png \"JumpCloud Graph Model Example\") | |:--:| | **This diagram highlights our association and membership model as it relates to Directory Objects.** |  # API Key  ## Access Your API Key  To locate your API Key:  1. Log into the [JumpCloud Admin Console](https://console.jumpcloud.com/). 2. Go to the username drop down located in the top-right of the Console. 3. Retrieve your API key from API Settings.  ## API Key Considerations  This API key is associated to the currently logged in administrator. Other admins will have different API keys.  **WARNING** Please keep this API key secret, as it grants full access to any data accessible via your JumpCloud console account.  You can also reset your API key in the same location in the JumpCloud Admin Console.  ## Recycling or Resetting Your API Key  In order to revoke access with the current API key, simply reset your API key. This will render all calls using the previous API key inaccessible.  Your API key will be passed in as a header with the header name \"x-api-key\".  ```bash curl -H \"x-api-key: [YOUR_API_KEY_HERE]\" \"https://console.jumpcloud.com/api/v2/systemgroups\" ```  # System Context  * [Introduction](#introduction) * [Supported endpoints](#supported-endpoints) * [Response codes](#response-codes) * [Authentication](#authentication) * [Additional examples](#additional-examples) * [Third party](#third-party)  ## Introduction  JumpCloud System Context Authorization is an alternative way to authenticate with a subset of JumpCloud's REST APIs. Using this method, a system can manage its information and resource associations, allowing modern auto provisioning environments to scale as needed.  **Notes:**   * The following documentation applies to Linux Operating Systems only.  * Systems that have been automatically enrolled using Apple's Device Enrollment Program (DEP) or systems enrolled using the User Portal install are not eligible to use the System Context API to prevent unauthorized access to system groups and resources. If a script that utilizes the System Context API is invoked on a system enrolled in this way, it will display an error.  ## Supported Endpoints  JumpCloud System Context Authorization can be used in conjunction with Systems endpoints found in the V1 API and certain System Group endpoints found in the v2 API.  * A system may fetch, alter, and delete metadata about itself, including manipulating a system's Group and Systemuser associations,   * `/api/systems/{system_id}` | [`GET`](https://docs.jumpcloud.com/api/1.0/index.html#operation/systems_get) [`PUT`](https://docs.jumpcloud.com/api/1.0/index.html#operation/systems_put) * A system may delete itself from your JumpCloud organization   * `/api/systems/{system_id}` | [`DELETE`](https://docs.jumpcloud.com/api/1.0/index.html#operation/systems_delete) * A system may fetch its direct resource associations under v2 (Groups)   * `/api/v2/systems/{system_id}/memberof` | [`GET`](https://docs.jumpcloud.com/api/2.0/index.html#operation/graph_systemGroupMembership)   * `/api/v2/systems/{system_id}/associations` | [`GET`](https://docs.jumpcloud.com/api/2.0/index.html#operation/graph_systemAssociationsList)   * `/api/v2/systems/{system_id}/users` | [`GET`](https://docs.jumpcloud.com/api/2.0/index.html#operation/graph_systemTraverseUser) * A system may alter its direct resource associations under v2 (Groups)   * `/api/v2/systems/{system_id}/associations` | [`POST`](https://docs.jumpcloud.com/api/2.0/index.html#operation/graph_systemAssociationsPost) * A system may alter its System Group associations   * `/api/v2/systemgroups/{group_id}/members` | [`POST`](https://docs.jumpcloud.com/api/2.0/index.html#operation/graph_systemGroupMembersPost)     * _NOTE_ If a system attempts to alter the system group membership of a different system the request will be rejected  ## Response Codes  If endpoints other than those described above are called using the System Context API, the server will return a `401` response.  ## Authentication  To allow for secure access to our APIs, you must authenticate each API request. JumpCloud System Context Authorization uses [HTTP Signatures](https://tools.ietf.org/html/draft-cavage-http-signatures-00) to authenticate API requests. The HTTP Signatures sent with each request are similar to the signatures used by the Amazon Web Services REST API. To help with the request-signing process, we have provided an [example bash script](https://github.com/TheJumpCloud/SystemContextAPI/blob/master/examples/shell/SigningExample.sh). This example API request simply requests the entire system record. You must be root, or have permissions to access the contents of the `/opt/jc` directory to generate a signature.  Here is a breakdown of the example script with explanations.  First, the script extracts the systemKey from the JSON formatted `/opt/jc/jcagent.conf` file.  ```bash #!/bin/bash conf=\"`cat /opt/jc/jcagent.conf`\" regex=\"systemKey\\\":\\\"(\\w+)\\\"\"  if [[ $conf =~ $regex ]] ; then   systemKey=\"${BASH_REMATCH[1]}\" fi ```  Then, the script retrieves the current date in the correct format.  ```bash now=`date -u \"+%a, %d %h %Y %H:%M:%S GMT\"`; ```  Next, we build a signing string to demonstrate the expected signature format. The signed string must consist of the [request-line](https://tools.ietf.org/html/rfc2616#page-35) and the date header, separated by a newline character.  ```bash signstr=\"GET /api/systems/${systemKey} HTTP/1.1\\ndate: ${now}\" ```  The next step is to calculate and apply the signature. This is a two-step process:  1. Create a signature from the signing string using the JumpCloud Agent private key: ``printf \"$signstr\" | openssl dgst -sha256 -sign /opt/jc/client.key`` 2. Then Base64-encode the signature string and trim off the newline characters: ``| openssl enc -e -a | tr -d '\\n'``  The combined steps above result in:  ```bash signature=`printf \"$signstr\" | openssl dgst -sha256 -sign /opt/jc/client.key | openssl enc -e -a | tr -d '\\n'` ; ```  Finally, we make sure the API call sending the signature has the same Authorization and Date header values, HTTP method, and URL that were used in the signing string.  ```bash curl -iq \\   -H \"Accept: application/json\" \\   -H \"Content-Type: application/json\" \\   -H \"Date: ${now}\" \\   -H \"Authorization: Signature keyId=\\\"system/${systemKey}\\\",headers=\\\"request-line date\\\",algorithm=\\\"rsa-sha256\\\",signature=\\\"${signature}\\\"\" \\   --url https://console.jumpcloud.com/api/systems/${systemKey} ```  ### Input Data  All PUT and POST methods should use the HTTP Content-Type header with a value of 'application/json'. PUT methods are used for updating a record. POST methods are used to create a record.  The following example demonstrates how to update the `displayName` of the system.  ```bash signstr=\"PUT /api/systems/${systemKey} HTTP/1.1\\ndate: ${now}\" signature=`printf \"$signstr\" | openssl dgst -sha256 -sign /opt/jc/client.key | openssl enc -e -a | tr -d '\\n'` ;  curl -iq \\   -d \"{\\\"displayName\\\" : \\\"updated-system-name-1\\\"}\" \\   -X \"PUT\" \\   -H \"Content-Type: application/json\" \\   -H \"Accept: application/json\" \\   -H \"Date: ${now}\" \\   -H \"Authorization: Signature keyId=\\\"system/${systemKey}\\\",headers=\\\"request-line date\\\",algorithm=\\\"rsa-sha256\\\",signature=\\\"${signature}\\\"\" \\   --url https://console.jumpcloud.com/api/systems/${systemKey} ```  ### Output Data  All results will be formatted as JSON.  Here is an abbreviated example of response output:  ```json {   \"_id\": \"525ee96f52e144993e000015\",   \"agentServer\": \"lappy386\",   \"agentVersion\": \"0.9.42\",   \"arch\": \"x86_64\",   \"connectionKey\": \"127.0.0.1_51812\",   \"displayName\": \"ubuntu-1204\",   \"firstContact\": \"2013-10-16T19:30:55.611Z\",   \"hostname\": \"ubuntu-1204\"   ... ```  ## Additional Examples  ### Signing Authentication Example  This example demonstrates how to make an authenticated request to fetch the JumpCloud record for this system.  [SigningExample.sh](https://github.com/TheJumpCloud/SystemContextAPI/blob/master/examples/shell/SigningExample.sh)  ### Shutdown Hook  This example demonstrates how to make an authenticated request on system shutdown. Using an init.d script registered at run level 0, you can call the System Context API as the system is shutting down.  [Instance-shutdown-initd](https://github.com/TheJumpCloud/SystemContextAPI/blob/master/examples/instance-shutdown-initd) is an example of an init.d script that only runs at system shutdown.  After customizing the [instance-shutdown-initd](https://github.com/TheJumpCloud/SystemContextAPI/blob/master/examples/instance-shutdown-initd) script, you should install it on the system(s) running the JumpCloud agent.  1. Copy the modified [instance-shutdown-initd](https://github.com/TheJumpCloud/SystemContextAPI/blob/master/examples/instance-shutdown-initd) to `/etc/init.d/instance-shutdown`. 2. On Ubuntu systems, run `update-rc.d instance-shutdown defaults`. On RedHat/CentOS systems, run `chkconfig --add instance-shutdown`.  ## Third Party  ### Chef Cookbooks  [https://github.com/nshenry03/jumpcloud](https://github.com/nshenry03/jumpcloud)  [https://github.com/cjs226/jumpcloud](https://github.com/cjs226/jumpcloud)  # Multi-Tenant Portal Headers  Multi-Tenant Organization API Headers are available for JumpCloud Admins to use when making API requests from Organizations that have multiple managed organizations.  The `x-org-id` is a required header for all multi-tenant admins when making API requests to JumpCloud. This header will define to which organization you would like to make the request.  **NOTE** Single Tenant Admins do not need to provide this header when making an API request.  ## Header Value  `x-org-id`  ## API Response Codes  * `400` Malformed ID. * `400` x-org-id and Organization path ID do not match. * `401` ID not included for multi-tenant admin * `403` ID included on unsupported route. * `404` Organization ID Not Found.  ```bash curl -X GET https://console.jumpcloud.com/api/v2/directories \\   -H 'accept: application/json' \\   -H 'content-type: application/json' \\   -H 'x-api-key: {API_KEY}' \\   -H 'x-org-id: {ORG_ID}'  ```  ## To Obtain an Individual Organization ID via the UI  As a prerequisite, your Primary Organization will need to be setup for Multi-Tenancy. This provides access to the Multi-Tenant Organization Admin Portal.  1. Log into JumpCloud [Admin Console](https://console.jumpcloud.com). If you are a multi-tenant Admin, you will automatically be routed to the Multi-Tenant Admin Portal. 2. From the Multi-Tenant Portal's primary navigation bar, select the Organization you'd like to access. 3. You will automatically be routed to that Organization's Admin Console. 4. Go to Settings in the sub-tenant's primary navigation. 5. You can obtain your Organization ID below your Organization's Contact Information on the Settings page.  ## To Obtain All Organization IDs via the API  * You can make an API request to this endpoint using the API key of your Primary Organization.  `https://console.jumpcloud.com/api/organizations/` This will return all your managed organizations.  ```bash curl -X GET \\   https://console.jumpcloud.com/api/organizations/ \\   -H 'Accept: application/json' \\   -H 'Content-Type: application/json' \\   -H 'x-api-key: {API_KEY}' ```  # SDKs  You can find language specific SDKs that can help you kickstart your Integration with JumpCloud in the following GitHub repositories:  * [Python](https://github.com/TheJumpCloud/jcapi-python) * [Go](https://github.com/TheJumpCloud/jcapi-go) * [Ruby](https://github.com/TheJumpCloud/jcapi-ruby) * [Java](https://github.com/TheJumpCloud/jcapi-java) 
 *
 * OpenAPI spec version: 2.0
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
/**
 * SystemInsightsCertificates
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-10-19T07:49:49.516358Z[Etc/UTC]")
public class SystemInsightsCertificates {
  @SerializedName("authority_key_id")
  private String authorityKeyId = null;

  @SerializedName("ca")
  private Integer ca = null;

  @SerializedName("common_name")
  private String commonName = null;

  @SerializedName("issuer")
  private String issuer = null;

  @SerializedName("key_algorithm")
  private String keyAlgorithm = null;

  @SerializedName("key_strength")
  private String keyStrength = null;

  @SerializedName("key_usage")
  private String keyUsage = null;

  @SerializedName("not_valid_after")
  private String notValidAfter = null;

  @SerializedName("not_valid_before")
  private String notValidBefore = null;

  @SerializedName("path")
  private String path = null;

  @SerializedName("self_signed")
  private Integer selfSigned = null;

  @SerializedName("serial")
  private String serial = null;

  @SerializedName("sha1")
  private String sha1 = null;

  @SerializedName("sid")
  private String sid = null;

  @SerializedName("signing_algorithm")
  private String signingAlgorithm = null;

  @SerializedName("store")
  private String store = null;

  @SerializedName("store_id")
  private String storeId = null;

  @SerializedName("store_location")
  private String storeLocation = null;

  @SerializedName("subject")
  private String subject = null;

  @SerializedName("subject_key_id")
  private String subjectKeyId = null;

  @SerializedName("system_id")
  private String systemId = null;

  @SerializedName("username")
  private String username = null;

  public SystemInsightsCertificates authorityKeyId(String authorityKeyId) {
    this.authorityKeyId = authorityKeyId;
    return this;
  }

   /**
   * Get authorityKeyId
   * @return authorityKeyId
  **/
  @Schema(description = "")
  public String getAuthorityKeyId() {
    return authorityKeyId;
  }

  public void setAuthorityKeyId(String authorityKeyId) {
    this.authorityKeyId = authorityKeyId;
  }

  public SystemInsightsCertificates ca(Integer ca) {
    this.ca = ca;
    return this;
  }

   /**
   * Get ca
   * @return ca
  **/
  @Schema(description = "")
  public Integer getCa() {
    return ca;
  }

  public void setCa(Integer ca) {
    this.ca = ca;
  }

  public SystemInsightsCertificates commonName(String commonName) {
    this.commonName = commonName;
    return this;
  }

   /**
   * Get commonName
   * @return commonName
  **/
  @Schema(description = "")
  public String getCommonName() {
    return commonName;
  }

  public void setCommonName(String commonName) {
    this.commonName = commonName;
  }

  public SystemInsightsCertificates issuer(String issuer) {
    this.issuer = issuer;
    return this;
  }

   /**
   * Get issuer
   * @return issuer
  **/
  @Schema(description = "")
  public String getIssuer() {
    return issuer;
  }

  public void setIssuer(String issuer) {
    this.issuer = issuer;
  }

  public SystemInsightsCertificates keyAlgorithm(String keyAlgorithm) {
    this.keyAlgorithm = keyAlgorithm;
    return this;
  }

   /**
   * Get keyAlgorithm
   * @return keyAlgorithm
  **/
  @Schema(description = "")
  public String getKeyAlgorithm() {
    return keyAlgorithm;
  }

  public void setKeyAlgorithm(String keyAlgorithm) {
    this.keyAlgorithm = keyAlgorithm;
  }

  public SystemInsightsCertificates keyStrength(String keyStrength) {
    this.keyStrength = keyStrength;
    return this;
  }

   /**
   * Get keyStrength
   * @return keyStrength
  **/
  @Schema(description = "")
  public String getKeyStrength() {
    return keyStrength;
  }

  public void setKeyStrength(String keyStrength) {
    this.keyStrength = keyStrength;
  }

  public SystemInsightsCertificates keyUsage(String keyUsage) {
    this.keyUsage = keyUsage;
    return this;
  }

   /**
   * Get keyUsage
   * @return keyUsage
  **/
  @Schema(description = "")
  public String getKeyUsage() {
    return keyUsage;
  }

  public void setKeyUsage(String keyUsage) {
    this.keyUsage = keyUsage;
  }

  public SystemInsightsCertificates notValidAfter(String notValidAfter) {
    this.notValidAfter = notValidAfter;
    return this;
  }

   /**
   * Get notValidAfter
   * @return notValidAfter
  **/
  @Schema(description = "")
  public String getNotValidAfter() {
    return notValidAfter;
  }

  public void setNotValidAfter(String notValidAfter) {
    this.notValidAfter = notValidAfter;
  }

  public SystemInsightsCertificates notValidBefore(String notValidBefore) {
    this.notValidBefore = notValidBefore;
    return this;
  }

   /**
   * Get notValidBefore
   * @return notValidBefore
  **/
  @Schema(description = "")
  public String getNotValidBefore() {
    return notValidBefore;
  }

  public void setNotValidBefore(String notValidBefore) {
    this.notValidBefore = notValidBefore;
  }

  public SystemInsightsCertificates path(String path) {
    this.path = path;
    return this;
  }

   /**
   * Get path
   * @return path
  **/
  @Schema(description = "")
  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public SystemInsightsCertificates selfSigned(Integer selfSigned) {
    this.selfSigned = selfSigned;
    return this;
  }

   /**
   * Get selfSigned
   * @return selfSigned
  **/
  @Schema(description = "")
  public Integer getSelfSigned() {
    return selfSigned;
  }

  public void setSelfSigned(Integer selfSigned) {
    this.selfSigned = selfSigned;
  }

  public SystemInsightsCertificates serial(String serial) {
    this.serial = serial;
    return this;
  }

   /**
   * Get serial
   * @return serial
  **/
  @Schema(description = "")
  public String getSerial() {
    return serial;
  }

  public void setSerial(String serial) {
    this.serial = serial;
  }

  public SystemInsightsCertificates sha1(String sha1) {
    this.sha1 = sha1;
    return this;
  }

   /**
   * Get sha1
   * @return sha1
  **/
  @Schema(description = "")
  public String getSha1() {
    return sha1;
  }

  public void setSha1(String sha1) {
    this.sha1 = sha1;
  }

  public SystemInsightsCertificates sid(String sid) {
    this.sid = sid;
    return this;
  }

   /**
   * Get sid
   * @return sid
  **/
  @Schema(description = "")
  public String getSid() {
    return sid;
  }

  public void setSid(String sid) {
    this.sid = sid;
  }

  public SystemInsightsCertificates signingAlgorithm(String signingAlgorithm) {
    this.signingAlgorithm = signingAlgorithm;
    return this;
  }

   /**
   * Get signingAlgorithm
   * @return signingAlgorithm
  **/
  @Schema(description = "")
  public String getSigningAlgorithm() {
    return signingAlgorithm;
  }

  public void setSigningAlgorithm(String signingAlgorithm) {
    this.signingAlgorithm = signingAlgorithm;
  }

  public SystemInsightsCertificates store(String store) {
    this.store = store;
    return this;
  }

   /**
   * Get store
   * @return store
  **/
  @Schema(description = "")
  public String getStore() {
    return store;
  }

  public void setStore(String store) {
    this.store = store;
  }

  public SystemInsightsCertificates storeId(String storeId) {
    this.storeId = storeId;
    return this;
  }

   /**
   * Get storeId
   * @return storeId
  **/
  @Schema(description = "")
  public String getStoreId() {
    return storeId;
  }

  public void setStoreId(String storeId) {
    this.storeId = storeId;
  }

  public SystemInsightsCertificates storeLocation(String storeLocation) {
    this.storeLocation = storeLocation;
    return this;
  }

   /**
   * Get storeLocation
   * @return storeLocation
  **/
  @Schema(description = "")
  public String getStoreLocation() {
    return storeLocation;
  }

  public void setStoreLocation(String storeLocation) {
    this.storeLocation = storeLocation;
  }

  public SystemInsightsCertificates subject(String subject) {
    this.subject = subject;
    return this;
  }

   /**
   * Get subject
   * @return subject
  **/
  @Schema(description = "")
  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public SystemInsightsCertificates subjectKeyId(String subjectKeyId) {
    this.subjectKeyId = subjectKeyId;
    return this;
  }

   /**
   * Get subjectKeyId
   * @return subjectKeyId
  **/
  @Schema(description = "")
  public String getSubjectKeyId() {
    return subjectKeyId;
  }

  public void setSubjectKeyId(String subjectKeyId) {
    this.subjectKeyId = subjectKeyId;
  }

  public SystemInsightsCertificates systemId(String systemId) {
    this.systemId = systemId;
    return this;
  }

   /**
   * Get systemId
   * @return systemId
  **/
  @Schema(description = "")
  public String getSystemId() {
    return systemId;
  }

  public void setSystemId(String systemId) {
    this.systemId = systemId;
  }

  public SystemInsightsCertificates username(String username) {
    this.username = username;
    return this;
  }

   /**
   * Get username
   * @return username
  **/
  @Schema(description = "")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SystemInsightsCertificates systemInsightsCertificates = (SystemInsightsCertificates) o;
    return Objects.equals(this.authorityKeyId, systemInsightsCertificates.authorityKeyId) &&
        Objects.equals(this.ca, systemInsightsCertificates.ca) &&
        Objects.equals(this.commonName, systemInsightsCertificates.commonName) &&
        Objects.equals(this.issuer, systemInsightsCertificates.issuer) &&
        Objects.equals(this.keyAlgorithm, systemInsightsCertificates.keyAlgorithm) &&
        Objects.equals(this.keyStrength, systemInsightsCertificates.keyStrength) &&
        Objects.equals(this.keyUsage, systemInsightsCertificates.keyUsage) &&
        Objects.equals(this.notValidAfter, systemInsightsCertificates.notValidAfter) &&
        Objects.equals(this.notValidBefore, systemInsightsCertificates.notValidBefore) &&
        Objects.equals(this.path, systemInsightsCertificates.path) &&
        Objects.equals(this.selfSigned, systemInsightsCertificates.selfSigned) &&
        Objects.equals(this.serial, systemInsightsCertificates.serial) &&
        Objects.equals(this.sha1, systemInsightsCertificates.sha1) &&
        Objects.equals(this.sid, systemInsightsCertificates.sid) &&
        Objects.equals(this.signingAlgorithm, systemInsightsCertificates.signingAlgorithm) &&
        Objects.equals(this.store, systemInsightsCertificates.store) &&
        Objects.equals(this.storeId, systemInsightsCertificates.storeId) &&
        Objects.equals(this.storeLocation, systemInsightsCertificates.storeLocation) &&
        Objects.equals(this.subject, systemInsightsCertificates.subject) &&
        Objects.equals(this.subjectKeyId, systemInsightsCertificates.subjectKeyId) &&
        Objects.equals(this.systemId, systemInsightsCertificates.systemId) &&
        Objects.equals(this.username, systemInsightsCertificates.username);
  }

  @Override
  public int hashCode() {
    return Objects.hash(authorityKeyId, ca, commonName, issuer, keyAlgorithm, keyStrength, keyUsage, notValidAfter, notValidBefore, path, selfSigned, serial, sha1, sid, signingAlgorithm, store, storeId, storeLocation, subject, subjectKeyId, systemId, username);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemInsightsCertificates {\n");
    
    sb.append("    authorityKeyId: ").append(toIndentedString(authorityKeyId)).append("\n");
    sb.append("    ca: ").append(toIndentedString(ca)).append("\n");
    sb.append("    commonName: ").append(toIndentedString(commonName)).append("\n");
    sb.append("    issuer: ").append(toIndentedString(issuer)).append("\n");
    sb.append("    keyAlgorithm: ").append(toIndentedString(keyAlgorithm)).append("\n");
    sb.append("    keyStrength: ").append(toIndentedString(keyStrength)).append("\n");
    sb.append("    keyUsage: ").append(toIndentedString(keyUsage)).append("\n");
    sb.append("    notValidAfter: ").append(toIndentedString(notValidAfter)).append("\n");
    sb.append("    notValidBefore: ").append(toIndentedString(notValidBefore)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    selfSigned: ").append(toIndentedString(selfSigned)).append("\n");
    sb.append("    serial: ").append(toIndentedString(serial)).append("\n");
    sb.append("    sha1: ").append(toIndentedString(sha1)).append("\n");
    sb.append("    sid: ").append(toIndentedString(sid)).append("\n");
    sb.append("    signingAlgorithm: ").append(toIndentedString(signingAlgorithm)).append("\n");
    sb.append("    store: ").append(toIndentedString(store)).append("\n");
    sb.append("    storeId: ").append(toIndentedString(storeId)).append("\n");
    sb.append("    storeLocation: ").append(toIndentedString(storeLocation)).append("\n");
    sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
    sb.append("    subjectKeyId: ").append(toIndentedString(subjectKeyId)).append("\n");
    sb.append("    systemId: ").append(toIndentedString(systemId)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
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
