
# SystemGroupMembersReq

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The ObjectID of member being added or removed. | 
**op** | [**OpEnum**](#OpEnum) | How to modify the membership connection. | 
**type** | [**TypeEnum**](#TypeEnum) | The member type. | 


<a name="OpEnum"></a>
## Enum: OpEnum
Name | Value
---- | -----
ADD | &quot;add&quot;
REMOVE | &quot;remove&quot;


<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
SYSTEM | &quot;system&quot;



