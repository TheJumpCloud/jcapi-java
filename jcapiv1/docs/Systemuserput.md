
# Systemuserput

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**email** | **String** |  | 
**username** | **String** |  | 
**allowPublicKey** | **Boolean** |  |  [optional]
**publicKey** | **String** |  |  [optional]
**sshKeys** | [**List&lt;Sshkeypost&gt;**](Sshkeypost.md) |  |  [optional]
**sudo** | **Boolean** |  |  [optional]
**enableManagedUid** | **Boolean** |  |  [optional]
**unixUid** | **Integer** |  |  [optional]
**unixGuid** | **Integer** |  |  [optional]
**tags** | **List&lt;String&gt;** |  |  [optional]
**accountLocked** | **Boolean** |  |  [optional]
**externallyManaged** | **Boolean** |  |  [optional]
**externalDn** | **String** |  |  [optional]
**externalSourceType** | **String** |  |  [optional]
**firstname** | **String** |  |  [optional]
**lastname** | **String** |  |  [optional]
**ldapBindingUser** | **Boolean** |  |  [optional]
**enableUserPortalMultifactor** | **Boolean** |  |  [optional]
**attributes** | **List&lt;Object&gt;** |  |  [optional]
**sambaServiceUser** | **Boolean** |  |  [optional]
**addresses** | [**List&lt;SystemuserputAddresses&gt;**](SystemuserputAddresses.md) | type, poBox, extendedAddress, streetAddress, locality, region, postalCode, country |  [optional]
**jobTitle** | **String** |  |  [optional]
**department** | **String** |  |  [optional]
**phoneNumbers** | [**List&lt;SystemuserputPhoneNumbers&gt;**](SystemuserputPhoneNumbers.md) |  |  [optional]
**relationships** | **List&lt;Object&gt;** |  |  [optional]
**password** | **String** |  |  [optional]
**passwordNeverExpires** | **Boolean** |  |  [optional]
**middlename** | **String** |  |  [optional]
**displayname** | **String** |  |  [optional]
**description** | **String** |  |  [optional]
**location** | **String** |  |  [optional]
**costCenter** | **String** |  |  [optional]
**employeeType** | **String** |  |  [optional]
**company** | **String** |  |  [optional]
**employeeIdentifier** | **String** | Must be unique per user.  |  [optional]
**mfa** | [**Mfa**](Mfa.md) |  |  [optional]



