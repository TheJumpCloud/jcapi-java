# GsuitePatchInput

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**groupsEnabled** | **Boolean** |  |  [optional]
**name** | **String** |  |  [optional]
**userLockoutAction** | [**UserLockoutActionEnum**](#UserLockoutActionEnum) |  |  [optional]
**userPasswordExpirationAction** | [**UserPasswordExpirationActionEnum**](#UserPasswordExpirationActionEnum) |  |  [optional]

<a name="UserLockoutActionEnum"></a>
## Enum: UserLockoutActionEnum
Name | Value
---- | -----
SUSPEND | &quot;suspend&quot;
MAINTAIN | &quot;maintain&quot;

<a name="UserPasswordExpirationActionEnum"></a>
## Enum: UserPasswordExpirationActionEnum
Name | Value
---- | -----
SUSPEND | &quot;suspend&quot;
MAINTAIN | &quot;maintain&quot;
REMOVE_ACCESS | &quot;remove_access&quot;
