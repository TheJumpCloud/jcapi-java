# AppleMDM

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**ades** | [**ADES**](ADES.md) |  |  [optional]
**allowMobileUserEnrollment** | **Boolean** | A toggle to allow mobile device enrollment for an organization. |  [optional]
**apnsCertExpiry** | **String** | The expiration date and time for the APNS Certificate. |  [optional]
**apnsPushTopic** | **String** | The push topic assigned to this enrollment by Apple after uploading the Signed CSR plist. |  [optional]
**defaultIosUserEnrollmentDeviceGroupID** | **String** | ObjectId uniquely identifying the MDM default iOS user enrollment device group. |  [optional]
**defaultSystemGroupID** | **String** | ObjectId uniquely identifying the MDM default System Group. |  [optional]
**dep** | [**DEP**](DEP.md) |  |  [optional]
**depAccessTokenExpiry** | **String** | The expiration date and time for the DEP Access Token. This aligns with the DEP Server Token State. |  [optional]
**depServerTokenState** | [**DepServerTokenStateEnum**](#DepServerTokenStateEnum) | The state of the dep server token, presence and expiry. |  [optional]
**id** | **String** | ObjectId uniquely identifying an MDM Enrollment, | 
**name** | **String** | A friendly name to identify this enrollment.  Not required to be unique. |  [optional]

<a name="DepServerTokenStateEnum"></a>
## Enum: DepServerTokenStateEnum
Name | Value
---- | -----
UNKNOWN | &quot;unknown&quot;
MISSING | &quot;missing&quot;
VALID | &quot;valid&quot;
EXPIRED | &quot;expired&quot;
