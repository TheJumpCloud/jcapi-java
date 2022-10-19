# RadiusserversIdBody

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**deviceCertEnabled** | **Boolean** |  |  [optional]
**mfa** | [**MfaEnum**](#MfaEnum) |  |  [optional]
**name** | **String** |  | 
**networkSourceIp** | **String** |  | 
**sharedSecret** | **String** |  | 
**tags** | **List&lt;String&gt;** |  |  [optional]
**userCertEnabled** | **Boolean** |  |  [optional]
**userLockoutAction** | **String** |  |  [optional]
**userPasswordEnabled** | **Boolean** |  |  [optional]
**userPasswordExpirationAction** | **String** |  |  [optional]

<a name="MfaEnum"></a>
## Enum: MfaEnum
Name | Value
---- | -----
DISABLED | &quot;DISABLED&quot;
ENABLED | &quot;ENABLED&quot;
REQUIRED | &quot;REQUIRED&quot;
ALWAYS | &quot;ALWAYS&quot;
