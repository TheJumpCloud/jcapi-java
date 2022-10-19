# OSRestriction

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**appleRestrictions** | [**OSRestrictionAppleRestrictions**](OSRestrictionAppleRestrictions.md) |  |  [optional]
**deprecatedVersion** | **String** | The version of the OS in which the policy was deprecated |  [optional]
**earliestVersion** | **String** | The earliest version of the OS in which the policy can be applied |  [optional]
**osName** | **String** | The name of the OS in which this restriction applies |  [optional]
**supportedEnrollmentTypes** | [**List&lt;SupportedEnrollmentTypesEnum&gt;**](#List&lt;SupportedEnrollmentTypesEnum&gt;) | This field is deprecated and will be ignored. Use appleRestrictions.supportedEnrollmentTypes instead |  [optional]

<a name="List<SupportedEnrollmentTypesEnum>"></a>
## Enum: List&lt;SupportedEnrollmentTypesEnum&gt;
Name | Value
---- | -----
AUTOMATED | &quot;automated&quot;
DEVICE | &quot;device&quot;
USER | &quot;user&quot;
