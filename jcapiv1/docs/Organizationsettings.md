
# Organizationsettings

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**contactEmail** | **String** |  |  [optional]
**contactName** | **String** |  |  [optional]
**disableLdap** | **Boolean** |  |  [optional]
**disableUM** | **Boolean** |  |  [optional]
**duplicateLDAPGroups** | **Boolean** |  |  [optional]
**emailDisclaimer** | **String** |  |  [optional]
**enableManagedUID** | **Boolean** |  |  [optional]
**features** | [**OrganizationsettingsFeatures**](OrganizationsettingsFeatures.md) |  |  [optional]
**logo** | **String** |  |  [optional]
**name** | **String** |  |  [optional]
**passwordCompliance** | [**PasswordComplianceEnum**](#PasswordComplianceEnum) |  |  [optional]
**passwordPolicy** | [**OrganizationsettingsPasswordPolicy**](OrganizationsettingsPasswordPolicy.md) |  |  [optional]
**showIntro** | **Boolean** |  |  [optional]
**systemUserPasswordExpirationInDays** | **Integer** |  |  [optional]
**systemUsersCanEdit** | **Boolean** |  |  [optional]
**userPortal** | [**OrganizationsettingsUserPortal**](OrganizationsettingsUserPortal.md) |  |  [optional]


<a name="PasswordComplianceEnum"></a>
## Enum: PasswordComplianceEnum
Name | Value
---- | -----
CUSTOM | &quot;custom&quot;
PCI3 | &quot;pci3&quot;
WINDOWS | &quot;windows&quot;



