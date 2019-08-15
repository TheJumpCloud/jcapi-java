
# LdapServerInput

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **String** | The name of this LDAP server |  [optional]
**userLockoutAction** | [**UserLockoutActionEnum**](#UserLockoutActionEnum) | action to take; one of &#39;remove&#39; or &#39;disable&#39; |  [optional]
**userPasswordExpirationAction** | [**UserPasswordExpirationActionEnum**](#UserPasswordExpirationActionEnum) | action to take; one of &#39;remove&#39; or &#39;disable&#39; |  [optional]


<a name="UserLockoutActionEnum"></a>
## Enum: UserLockoutActionEnum
Name | Value
---- | -----
DISABLE | &quot;disable&quot;
REMOVE | &quot;remove&quot;


<a name="UserPasswordExpirationActionEnum"></a>
## Enum: UserPasswordExpirationActionEnum
Name | Value
---- | -----
DISABLE | &quot;disable&quot;
REMOVE | &quot;remove&quot;



