
# Radiusserver

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** |  |  [optional]
**mfa** | [**MfaEnum**](#MfaEnum) |  |  [optional]
**name** | **String** |  |  [optional]
**networkSourceIp** | **String** |  |  [optional]
**organization** | **String** |  |  [optional]
**sharedSecret** | **String** |  |  [optional]
**tagNames** | **List&lt;String&gt;** |  |  [optional]
**tags** | **List&lt;String&gt;** |  |  [optional]
**userLockoutAction** | **String** |  |  [optional]
**userPasswordExpirationAction** | **String** |  |  [optional]


<a name="MfaEnum"></a>
## Enum: MfaEnum
Name | Value
---- | -----
DISABLED | &quot;DISABLED&quot;
ENABLED | &quot;ENABLED&quot;
REQUIRED | &quot;REQUIRED&quot;
ALWAYS | &quot;ALWAYS&quot;



