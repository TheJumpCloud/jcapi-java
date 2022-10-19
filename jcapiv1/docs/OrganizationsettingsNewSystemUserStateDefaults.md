# OrganizationsettingsNewSystemUserStateDefaults

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**applicationImport** | [**ApplicationImportEnum**](#ApplicationImportEnum) | The default user state for a user created using the [Bulk Users Create](https://docs.jumpcloud.com/api/2.0/index.html#operation/bulk_usersCreate) endpoint. See endpoint documentation for more details. |  [optional]
**csvImport** | [**CsvImportEnum**](#CsvImportEnum) | The default user state for a user created using the [Bulk Users Create](https://docs.jumpcloud.com/api/2.0/index.html#operation/bulk_usersCreate) endpoint. See endpoint documentation for more details. |  [optional]
**manualEntry** | [**ManualEntryEnum**](#ManualEntryEnum) | The default state for a user that is created using the [Create a system user](https://docs.jumpcloud.com/api/1.0/index.html#operation/systemusers_post) endpoint. See endpoint documentation for more details. |  [optional]

<a name="ApplicationImportEnum"></a>
## Enum: ApplicationImportEnum
Name | Value
---- | -----
ACTIVATED | &quot;ACTIVATED&quot;
STAGED | &quot;STAGED&quot;

<a name="CsvImportEnum"></a>
## Enum: CsvImportEnum
Name | Value
---- | -----
ACTIVATED | &quot;ACTIVATED&quot;
STAGED | &quot;STAGED&quot;

<a name="ManualEntryEnum"></a>
## Enum: ManualEntryEnum
Name | Value
---- | -----
ACTIVATED | &quot;ACTIVATED&quot;
STAGED | &quot;STAGED&quot;
