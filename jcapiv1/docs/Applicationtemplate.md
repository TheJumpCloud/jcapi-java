# Applicationtemplate

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**_id** | **String** |  |  [optional]
**active** | **Boolean** |  |  [optional]
**beta** | **Boolean** |  |  [optional]
**color** | [**ColorEnum**](#ColorEnum) |  |  [optional]
**config** | [**ApplicationConfig**](ApplicationConfig.md) |  |  [optional]
**displayLabel** | **String** |  |  [optional]
**displayName** | **String** |  |  [optional]
**isConfigured** | **Boolean** |  |  [optional]
**jit** | [**ApplicationtemplateJit**](ApplicationtemplateJit.md) |  |  [optional]
**keywords** | **List&lt;String&gt;** |  |  [optional]
**learnMore** | **String** |  |  [optional]
**logo** | [**ApplicationtemplateLogo**](ApplicationtemplateLogo.md) |  |  [optional]
**name** | **String** |  |  [optional]
**oidc** | [**ApplicationtemplateOidc**](ApplicationtemplateOidc.md) |  |  [optional]
**provision** | [**ApplicationtemplateProvision**](ApplicationtemplateProvision.md) |  |  [optional]
**sso** | [**Sso**](Sso.md) |  |  [optional]
**ssoUrl** | **String** |  |  [optional]
**status** | [**StatusEnum**](#StatusEnum) |  |  [optional]
**test** | **String** |  |  [optional]

<a name="ColorEnum"></a>
## Enum: ColorEnum
Name | Value
---- | -----
EMPTY | &quot;&quot;
_202D38 | &quot;#202D38&quot;
_005466 | &quot;#005466&quot;
_3E8696 | &quot;#3E8696&quot;
_006CAC | &quot;#006CAC&quot;
_0617AC | &quot;#0617AC&quot;
_7C6ADA | &quot;#7C6ADA&quot;
_D5779D | &quot;#D5779D&quot;
_9E2F00 | &quot;#9E2F00&quot;
_FFB000 | &quot;#FFB000&quot;
_58C469 | &quot;#58C469&quot;
_57C49F | &quot;#57C49F&quot;
_FF6C03 | &quot;#FF6C03&quot;

<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
EMPTY | &quot;&quot;
END_OF_LIFE | &quot;end_of_life&quot;
END_OF_SUPPORT | &quot;end_of_support&quot;
BETA | &quot;beta&quot;
