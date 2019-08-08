
# Radiusserverpost

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**networkSourceIp** | **String** |  | 
**name** | **String** |  | 
**tagNames** | **List&lt;String&gt;** |  |  [optional]
**sharedSecret** | **String** | RADIUS shared secret between the server and client. | 
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



