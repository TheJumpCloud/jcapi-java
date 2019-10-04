
# PolicyTemplateConfigField

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**displayType** | [**DisplayTypeEnum**](#DisplayTypeEnum) | The default rendering for this field. |  [optional]
**id** | **String** | ObjectId uniquely identifying a Policy Template Configuration Field | 
**label** | **String** | The default label for this field. |  [optional]
**name** | **String** | A unique name identifying this config field. | 
**position** | [**BigDecimal**](BigDecimal.md) | The default position to render this field. |  [optional]
**readOnly** | **Boolean** | If an admin is allowed to modify this field. |  [optional]
**required** | **Boolean** | If this field is required for this field. |  [optional]
**tooltip** | [**PolicyTemplateConfigFieldTooltip**](PolicyTemplateConfigFieldTooltip.md) |  |  [optional]


<a name="DisplayTypeEnum"></a>
## Enum: DisplayTypeEnum
Name | Value
---- | -----
CHECKBOX | &quot;checkbox&quot;
DATE | &quot;date&quot;
EMAIL | &quot;email&quot;
NUMBER | &quot;number&quot;
SELECT | &quot;select&quot;
TEXT | &quot;text&quot;
TEXTAREA | &quot;textarea&quot;



