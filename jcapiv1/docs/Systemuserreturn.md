# Systemuserreturn

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**_id** | **String** |  |  [optional]
**accountLocked** | **Boolean** |  |  [optional]
**accountLockedDate** | **String** |  |  [optional]
**activated** | **Boolean** |  |  [optional]
**addresses** | [**List&lt;SystemuserreturnAddresses&gt;**](SystemuserreturnAddresses.md) |  |  [optional]
**allowPublicKey** | **Boolean** |  |  [optional]
**alternateEmail** | **String** |  |  [optional]
**attributes** | [**List&lt;SystemuserputAttributes&gt;**](SystemuserputAttributes.md) |  |  [optional]
**badLoginAttempts** | **Integer** |  |  [optional]
**company** | **String** |  |  [optional]
**costCenter** | **String** |  |  [optional]
**created** | **String** |  |  [optional]
**creationSource** | **String** |  |  [optional]
**department** | **String** |  |  [optional]
**description** | **String** |  |  [optional]
**disableDeviceMaxLoginAttempts** | **Boolean** |  |  [optional]
**displayname** | **String** |  |  [optional]
**email** | **String** |  |  [optional]
**employeeIdentifier** | **String** | Must be unique per user.  |  [optional]
**employeeType** | **String** |  |  [optional]
**enableManagedUid** | **Boolean** |  |  [optional]
**enableUserPortalMultifactor** | **Boolean** |  |  [optional]
**externalDn** | **String** |  |  [optional]
**externalPasswordExpirationDate** | **String** |  |  [optional]
**externalSourceType** | **String** |  |  [optional]
**externallyManaged** | **Boolean** |  |  [optional]
**firstname** | **String** |  |  [optional]
**jobTitle** | **String** |  |  [optional]
**lastname** | **String** |  |  [optional]
**ldapBindingUser** | **Boolean** |  |  [optional]
**location** | **String** |  |  [optional]
**managedAppleId** | **String** |  |  [optional]
**manager** | **String** | Relation with another systemuser to identify the last as a manager. |  [optional]
**mfa** | [**Mfa**](Mfa.md) |  |  [optional]
**mfaEnrollment** | [**MfaEnrollment**](MfaEnrollment.md) |  |  [optional]
**middlename** | **String** |  |  [optional]
**organization** | **String** |  |  [optional]
**passwordExpirationDate** | **String** |  |  [optional]
**passwordExpired** | **Boolean** |  |  [optional]
**passwordNeverExpires** | **Boolean** |  |  [optional]
**passwordlessSudo** | **Boolean** |  |  [optional]
**phoneNumbers** | [**List&lt;SystemuserreturnPhoneNumbers&gt;**](SystemuserreturnPhoneNumbers.md) |  |  [optional]
**publicKey** | **String** |  |  [optional]
**recoveryEmail** | [**SystemuserreturnRecoveryEmail**](SystemuserreturnRecoveryEmail.md) |  |  [optional]
**relationships** | [**List&lt;SystemuserputRelationships&gt;**](SystemuserputRelationships.md) |  |  [optional]
**sambaServiceUser** | **Boolean** |  |  [optional]
**sshKeys** | [**List&lt;Sshkeylist&gt;**](Sshkeylist.md) |  |  [optional]
**state** | [**StateEnum**](#StateEnum) |  |  [optional]
**sudo** | **Boolean** |  |  [optional]
**suspended** | **Boolean** |  |  [optional]
**tags** | **List&lt;String&gt;** |  |  [optional]
**totpEnabled** | **Boolean** |  |  [optional]
**unixGuid** | **Integer** |  |  [optional]
**unixUid** | **Integer** |  |  [optional]
**username** | **String** |  |  [optional]

<a name="StateEnum"></a>
## Enum: StateEnum
Name | Value
---- | -----
STAGED | &quot;STAGED&quot;
ACTIVATED | &quot;ACTIVATED&quot;
SUSPENDED | &quot;SUSPENDED&quot;
