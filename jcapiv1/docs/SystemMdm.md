# SystemMdm

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**dep** | **Boolean** |  |  [optional]
**enrollmentType** | [**EnrollmentTypeEnum**](#EnrollmentTypeEnum) |  |  [optional]
**internal** | [**SystemMdmInternal**](SystemMdmInternal.md) |  |  [optional]
**profileIdentifier** | **String** |  |  [optional]
**userApproved** | **Boolean** |  |  [optional]
**vendor** | [**VendorEnum**](#VendorEnum) |  |  [optional]

<a name="EnrollmentTypeEnum"></a>
## Enum: EnrollmentTypeEnum
Name | Value
---- | -----
UNKNOWN | &quot;unknown&quot;
AUTOMATED_DEVICE | &quot;automated device&quot;
DEVICE | &quot;device&quot;
USER | &quot;user&quot;

<a name="VendorEnum"></a>
## Enum: VendorEnum
Name | Value
---- | -----
UNKNOWN | &quot;unknown&quot;
NONE | &quot;none&quot;
INTERNAL | &quot;internal&quot;
EXTERNAL | &quot;external&quot;
