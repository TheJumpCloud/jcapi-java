# UserGroup

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**attributes** | [**GroupAttributesUserGroup**](GroupAttributesUserGroup.md) |  |  [optional]
**description** | **String** | Description of a User Group |  [optional]
**email** | **String** | Email address of a User Group |  [optional]
**id** | **String** | ObjectId uniquely identifying a User Group. |  [optional]
**memberQuery** | [**FilterQuery**](FilterQuery.md) |  |  [optional]
**memberQueryExemptions** | [**List&lt;GraphObject&gt;**](GraphObject.md) | Array of GraphObjects exempted from the query |  [optional]
**memberSuggestionsNotify** | **Boolean** | True if notification emails are to be sent for membership suggestions. |  [optional]
**membershipAutomated** | **Boolean** | True if membership of this group is automatically updated based on the Member Query and Member Query Exemptions, if configured |  [optional]
**name** | **String** | Display name of a User Group. |  [optional]
**suggestionCounts** | [**SuggestionCounts**](SuggestionCounts.md) |  |  [optional]
**type** | [**TypeEnum**](#TypeEnum) | The type of the group. |  [optional]

<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
USER_GROUP | &quot;user_group&quot;
