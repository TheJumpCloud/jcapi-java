
# PolicyTemplateWithDetails

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | ObjectId uniquely indetifying a Policy Template. |  [optional]
**name** | **String** | The unique name for the Policy Template. |  [optional]
**description** | **String** | The default description for the Policy. |  [optional]
**displayName** | **String** | The default display name for the Policy. |  [optional]
**osMetaFamily** | [**OsMetaFamilyEnum**](#OsMetaFamilyEnum) |  |  [optional]
**configFields** | [**List&lt;PolicyTemplateConfigField&gt;**](PolicyTemplateConfigField.md) | An unordered list of all the fields that can be configured for this Policy Template. |  [optional]
**activation** | **String** | Requirements before the policy can be activated. |  [optional]
**behavior** | **String** | Specifics about the behavior of the policy. |  [optional]


<a name="OsMetaFamilyEnum"></a>
## Enum: OsMetaFamilyEnum
Name | Value
---- | -----
LINUX | &quot;linux&quot;
DARWIN | &quot;darwin&quot;
WINDOWS | &quot;windows&quot;


