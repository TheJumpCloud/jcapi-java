# Radiusserverput

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**_id** | **String** |  |  [optional]
**authIdp** | [**AuthIdpEnum**](#AuthIdpEnum) |  |  [optional]
**deviceCertEnabled** | **Boolean** |  |  [optional]
**mfa** | [**MfaEnum**](#MfaEnum) |  |  [optional]
**name** | **String** |  |  [optional]
**networkSourceIp** | **String** |  |  [optional]
**tagNames** | **List&lt;String&gt;** |  |  [optional]
**userCertEnabled** | **Boolean** |  |  [optional]
**userLockoutAction** | **String** |  |  [optional]
**userPasswordEnabled** | **Boolean** |  |  [optional]
**userPasswordExpirationAction** | **String** |  |  [optional]

<a name="AuthIdpEnum"></a>
## Enum: AuthIdpEnum
Name | Value
---- | -----
JUMPCLOUD | &quot;JUMPCLOUD&quot;
AZURE | &quot;AZURE&quot;

<a name="MfaEnum"></a>
## Enum: MfaEnum
Name | Value
---- | -----
DISABLED | &quot;DISABLED&quot;
ENABLED | &quot;ENABLED&quot;
REQUIRED | &quot;REQUIRED&quot;
ALWAYS | &quot;ALWAYS&quot;
