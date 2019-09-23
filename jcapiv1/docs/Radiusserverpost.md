
# Radiusserverpost

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**mfa** | [**MfaEnum**](#MfaEnum) |  |  [optional]
**name** | **String** |  | 
**networkSourceIp** | **String** |  | 
**sharedSecret** | **String** | RADIUS shared secret between the server and client. | 
**tagNames** | **List&lt;String&gt;** |  |  [optional]
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



