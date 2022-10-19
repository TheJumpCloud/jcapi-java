# Commandresult

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**_id** | **String** | The ID of the command. |  [optional]
**command** | **String** | The command that was executed on the system. |  [optional]
**files** | **List&lt;String&gt;** | An array of file ids that were included in the command |  [optional]
**name** | **String** | The name of the command. |  [optional]
**organization** | **String** | The ID of the organization. |  [optional]
**requestTime** | [**OffsetDateTime**](OffsetDateTime.md) | The time that the command was sent. |  [optional]
**response** | [**CommandresultResponse**](CommandresultResponse.md) |  |  [optional]
**responseTime** | [**OffsetDateTime**](OffsetDateTime.md) | The time that the command was completed. |  [optional]
**sudo** | **Boolean** | If the user had sudo rights |  [optional]
**system** | **String** | The name of the system the command was executed on. |  [optional]
**systemId** | **String** | The id of the system the command was executed on. |  [optional]
**user** | **String** | The user the command ran as. |  [optional]
**workflowId** | **String** |  |  [optional]
**workflowInstanceId** | **String** |  |  [optional]
