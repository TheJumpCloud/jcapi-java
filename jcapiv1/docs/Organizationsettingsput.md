# Organizationsettingsput

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**contactEmail** | **String** |  |  [optional]
**contactName** | **String** |  |  [optional]
**deviceIdentificationEnabled** | **Boolean** |  |  [optional]
**disableGoogleLogin** | **Boolean** |  |  [optional]
**disableLdap** | **Boolean** |  |  [optional]
**disableUM** | **Boolean** |  |  [optional]
**duplicateLDAPGroups** | **Boolean** |  |  [optional]
**emailDisclaimer** | **String** |  |  [optional]
**enableManagedUID** | **Boolean** |  |  [optional]
**features** | [**OrganizationsettingsFeatures**](OrganizationsettingsFeatures.md) |  |  [optional]
**growthData** | **Object** | Object containing Optimizely experimentIds and states corresponding to them |  [optional]
**logo** | **String** |  |  [optional]
**name** | **String** |  |  [optional]
**newSystemUserStateDefaults** | [**OrganizationsettingsputNewSystemUserStateDefaults**](OrganizationsettingsputNewSystemUserStateDefaults.md) |  |  [optional]
**passwordCompliance** | [**PasswordComplianceEnum**](#PasswordComplianceEnum) |  |  [optional]
**passwordPolicy** | [**OrganizationsettingsputPasswordPolicy**](OrganizationsettingsputPasswordPolicy.md) |  |  [optional]
**showIntro** | **Boolean** |  |  [optional]
**systemUserPasswordExpirationInDays** | **Integer** |  |  [optional]
**systemUsersCanEdit** | **Boolean** |  |  [optional]
**systemUsersCap** | **Integer** |  |  [optional]
**trustedAppConfig** | [**TrustedappConfigPut**](TrustedappConfigPut.md) |  |  [optional]
**userPortal** | [**OrganizationsettingsUserPortal**](OrganizationsettingsUserPortal.md) |  |  [optional]

<a name="PasswordComplianceEnum"></a>
## Enum: PasswordComplianceEnum
Name | Value
---- | -----
CUSTOM | &quot;custom&quot;
PCI3 | &quot;pci3&quot;
WINDOWS | &quot;windows&quot;
