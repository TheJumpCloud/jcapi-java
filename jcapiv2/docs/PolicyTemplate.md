
# PolicyTemplate

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | ObjectId uniquely identifying a Policy Template. |  [optional]
**name** | **String** | The unique name for the Policy Template. |  [optional]
**description** | **String** | The default description for the Policy. |  [optional]
**displayName** | **String** | The default display name for the Policy. |  [optional]
**osMetaFamily** | [**OsMetaFamilyEnum**](#OsMetaFamilyEnum) |  |  [optional]
**activation** | **String** | Requirements before the policy can be activated. |  [optional]
**behavior** | **String** | Specifics about the behavior of the policy. |  [optional]
**state** | **String** | String describing the release status of the policy template. |  [optional]


<a name="OsMetaFamilyEnum"></a>
## Enum: OsMetaFamilyEnum
Name | Value
---- | -----
LINUX | &quot;linux&quot;
DARWIN | &quot;darwin&quot;
WINDOWS | &quot;windows&quot;



