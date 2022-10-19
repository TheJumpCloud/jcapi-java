# ApplicationtemplateOidc

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**grantTypes** | [**List&lt;GrantTypesEnum&gt;**](#List&lt;GrantTypesEnum&gt;) | The grant types allowed. Currently only authorization_code is allowed. |  [optional]
**redirectUris** | **List&lt;String&gt;** | List of allowed redirectUris |  [optional]
**ssoUrl** | **String** | The relying party url to trigger an oidc login. |  [optional]
**tokenEndpointAuthMethod** | [**TokenEndpointAuthMethodEnum**](#TokenEndpointAuthMethodEnum) | Method that the client uses to authenticate when requesting a token. If &#x27;none&#x27;, then the client must use PKCE. If &#x27;client_secret_post&#x27;, then the secret is passed in the post body when requesting the token. |  [optional]

<a name="List<GrantTypesEnum>"></a>
## Enum: List&lt;GrantTypesEnum&gt;
Name | Value
---- | -----
AUTHORIZATION_CODE | &quot;authorization_code&quot;

<a name="TokenEndpointAuthMethodEnum"></a>
## Enum: TokenEndpointAuthMethodEnum
Name | Value
---- | -----
NONE | &quot;none&quot;
CLIENT_SECRET_POST | &quot;client_secret_post&quot;
