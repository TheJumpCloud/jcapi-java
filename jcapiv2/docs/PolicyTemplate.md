# PolicyTemplate

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**activation** | **String** | Requirements before the policy can be activated. |  [optional]
**alert** | **String** | Text to describe any risk associated with this policy. |  [optional]
**behavior** | **String** | Specifics about the behavior of the policy. |  [optional]
**deliveryTypes** | [**List&lt;DeliveryTypesEnum&gt;**](#List&lt;DeliveryTypesEnum&gt;) | The supported delivery mechanisms for this policy template. |  [optional]
**description** | **String** | The default description for the Policy. |  [optional]
**displayName** | **String** | The default display name for the Policy. |  [optional]
**id** | **String** | ObjectId uniquely identifying a Policy Template. |  [optional]
**name** | **String** | The unique name for the Policy Template. |  [optional]
**osMetaFamily** | [**OsMetaFamilyEnum**](#OsMetaFamilyEnum) |  |  [optional]
**osRestrictions** | [**List&lt;OSRestriction&gt;**](OSRestriction.md) |  |  [optional]
**reference** | **String** | URL to visit for further information. |  [optional]
**state** | **String** | String describing the release status of the policy template. |  [optional]

<a name="List<DeliveryTypesEnum>"></a>
## Enum: List&lt;DeliveryTypesEnum&gt;
Name | Value
---- | -----
AGENT | &quot;agent&quot;
MDM | &quot;mdm&quot;

<a name="OsMetaFamilyEnum"></a>
## Enum: OsMetaFamilyEnum
Name | Value
---- | -----
LINUX | &quot;linux&quot;
DARWIN | &quot;darwin&quot;
WINDOWS | &quot;windows&quot;
IOS | &quot;ios&quot;
UNIVERSAL | &quot;universal&quot;
