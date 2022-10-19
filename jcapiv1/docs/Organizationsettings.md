# Organizationsettings

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**agentVersion** | **String** |  |  [optional]
**betaFeatures** | **Object** |  |  [optional]
**contactEmail** | **String** |  |  [optional]
**contactName** | **String** |  |  [optional]
**deviceIdentificationEnabled** | **Boolean** |  |  [optional]
**disableCommandRunner** | **Boolean** |  |  [optional]
**disableGoogleLogin** | **Boolean** |  |  [optional]
**disableLdap** | **Boolean** |  |  [optional]
**disableUM** | **Boolean** |  |  [optional]
**displayPreferences** | [**OrganizationsettingsDisplayPreferences**](OrganizationsettingsDisplayPreferences.md) |  |  [optional]
**duplicateLDAPGroups** | **Boolean** |  |  [optional]
**emailDisclaimer** | **String** |  |  [optional]
**enableGoogleApps** | **Boolean** |  |  [optional]
**enableManagedUID** | **Boolean** |  |  [optional]
**enableO365** | **Boolean** |  |  [optional]
**enableUserPortalAgentInstall** | **Boolean** |  |  [optional]
**features** | [**OrganizationsettingsFeatures**](OrganizationsettingsFeatures.md) |  |  [optional]
**growthData** | **Object** | Object containing Optimizely experimentIds and states corresponding to them |  [optional]
**logo** | **String** |  |  [optional]
**name** | **String** |  |  [optional]
**newSystemUserStateDefaults** | [**OrganizationsettingsNewSystemUserStateDefaults**](OrganizationsettingsNewSystemUserStateDefaults.md) |  |  [optional]
**passwordCompliance** | [**PasswordComplianceEnum**](#PasswordComplianceEnum) |  |  [optional]
**passwordPolicy** | [**OrganizationsettingsPasswordPolicy**](OrganizationsettingsPasswordPolicy.md) |  |  [optional]
**pendingDelete** | **Boolean** |  |  [optional]
**showIntro** | **Boolean** |  |  [optional]
**systemUserPasswordExpirationInDays** | **Integer** |  |  [optional]
**systemUsersCanEdit** | **Boolean** |  |  [optional]
**systemUsersCap** | **Integer** |  |  [optional]
**trustedAppConfig** | [**TrustedappConfigGet**](TrustedappConfigGet.md) |  |  [optional]
**userPortal** | [**OrganizationsettingsUserPortal**](OrganizationsettingsUserPortal.md) |  |  [optional]

<a name="PasswordComplianceEnum"></a>
## Enum: PasswordComplianceEnum
Name | Value
---- | -----
CUSTOM | &quot;custom&quot;
PCI3 | &quot;pci3&quot;
WINDOWS | &quot;windows&quot;
