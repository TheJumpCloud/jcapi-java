# Systemuserput

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accountLocked** | **Boolean** |  |  [optional]
**addresses** | [**List&lt;SystemuserputAddresses&gt;**](SystemuserputAddresses.md) | type, poBox, extendedAddress, streetAddress, locality, region, postalCode, country |  [optional]
**allowPublicKey** | **Boolean** |  |  [optional]
**alternateEmail** | **String** |  |  [optional]
**attributes** | [**List&lt;SystemuserputAttributes&gt;**](SystemuserputAttributes.md) |  |  [optional]
**company** | **String** |  |  [optional]
**costCenter** | **String** |  |  [optional]
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
**middlename** | **String** |  |  [optional]
**password** | **String** |  |  [optional]
**passwordNeverExpires** | **Boolean** |  |  [optional]
**phoneNumbers** | [**List&lt;SystemuserputPhoneNumbers&gt;**](SystemuserputPhoneNumbers.md) |  |  [optional]
**publicKey** | **String** |  |  [optional]
**relationships** | [**List&lt;SystemuserputRelationships&gt;**](SystemuserputRelationships.md) |  |  [optional]
**sambaServiceUser** | **Boolean** |  |  [optional]
**sshKeys** | [**List&lt;Sshkeypost&gt;**](Sshkeypost.md) |  |  [optional]
**state** | [**StateEnum**](#StateEnum) |  |  [optional]
**sudo** | **Boolean** |  |  [optional]
**suspended** | **Boolean** |  |  [optional]
**tags** | **List&lt;String&gt;** |  |  [optional]
**unixGuid** | **Integer** |  |  [optional]
**unixUid** | **Integer** |  |  [optional]
**username** | **String** |  |  [optional]

<a name="StateEnum"></a>
## Enum: StateEnum
Name | Value
---- | -----
ACTIVATED | &quot;ACTIVATED&quot;
SUSPENDED | &quot;SUSPENDED&quot;
