# ActiveDirectoryAgentGetOutput

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**connectKey** | **String** | The connect key to use when installing the Agent on a Domain Controller. |  [optional]
**contactAt** | **String** |  |  [optional]
**hostname** | **String** |  |  [optional]
**id** | **String** | ObjectID of this Active Directory Agent. | 
**sourceIp** | **String** |  |  [optional]
**state** | [**StateEnum**](#StateEnum) |  |  [optional]
**version** | **String** |  |  [optional]

<a name="StateEnum"></a>
## Enum: StateEnum
Name | Value
---- | -----
UNSEALED | &quot;unsealed&quot;
ACTIVE | &quot;active&quot;
INACTIVE | &quot;inactive&quot;
