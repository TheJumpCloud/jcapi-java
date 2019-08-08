
# Radiusserver

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** |  |  [optional]
**organization** | **String** |  |  [optional]
**networkSourceIp** | **String** |  |  [optional]
**sharedSecret** | **String** |  |  [optional]
**name** | **String** |  |  [optional]
**tags** | **List&lt;String&gt;** |  |  [optional]
**tagNames** | **List&lt;String&gt;** |  |  [optional]
**userLockoutAction** | **String** |  |  [optional]
**userPasswordExpirationAction** | **String** |  |  [optional]
**mfa** | [**MfaEnum**](#MfaEnum) |  |  [optional]


<a name="MfaEnum"></a>
## Enum: MfaEnum
Name | Value
---- | -----
DISABLED | &quot;DISABLED&quot;
ENABLED | &quot;ENABLED&quot;
REQUIRED | &quot;REQUIRED&quot;
ALWAYS | &quot;ALWAYS&quot;



