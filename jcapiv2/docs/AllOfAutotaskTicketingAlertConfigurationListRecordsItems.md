# AllOfAutotaskTicketingAlertConfigurationListRecordsItems

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**category** | **String** |  |  [optional]
**description** | **String** |  |  [optional]
**destination** | [**DestinationEnum**](#DestinationEnum) |  |  [optional]
**displayName** | **String** |  |  [optional]
**dueDays** | **Integer** |  |  [optional]
**id** | **Integer** |  |  [optional]
**priority** | [**AutotaskTicketingAlertConfigurationPriority**](AutotaskTicketingAlertConfigurationPriority.md) |  |  [optional]
**queue** | [**AutotaskTicketingAlertConfigurationPriority**](AutotaskTicketingAlertConfigurationPriority.md) |  |  [optional]
**resource** | [**AutotaskTicketingAlertConfigurationResource**](AutotaskTicketingAlertConfigurationResource.md) |  |  [optional]
**shouldCreateTickets** | **Boolean** |  |  [optional]
**source** | [**AutotaskTicketingAlertConfigurationPriority**](AutotaskTicketingAlertConfigurationPriority.md) |  |  [optional]
**status** | [**AutotaskTicketingAlertConfigurationPriority**](AutotaskTicketingAlertConfigurationPriority.md) |  |  [optional]

<a name="DestinationEnum"></a>
## Enum: DestinationEnum
Name | Value
---- | -----
QUEUE | &quot;queue&quot;
RESOURCE | &quot;resource&quot;
