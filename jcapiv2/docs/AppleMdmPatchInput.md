# AppleMdmPatchInput

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**ades** | [**ADES**](ADES.md) |  |  [optional]
**allowMobileUserEnrollment** | **Boolean** | A toggle to allow mobile device enrollment for an organization. |  [optional]
**appleSignedCert** | **String** | A signed certificate obtained from Apple after providing Apple with the plist file provided on POST. |  [optional]
**defaultIosUserEnrollmentDeviceGroupID** | **String** | ObjectId uniquely identifying the MDM default iOS user enrollment device group. |  [optional]
**defaultSystemGroupID** | **String** | ObjectId uniquely identifying the MDM default System Group. |  [optional]
**dep** | [**DEP**](DEP.md) |  |  [optional]
**encryptedDepServerToken** | **String** | The S/MIME encoded DEP Server Token returned by Apple Business Manager when creating an MDM instance. |  [optional]
**name** | **String** | A new name for the Apple MDM configuration. |  [optional]
