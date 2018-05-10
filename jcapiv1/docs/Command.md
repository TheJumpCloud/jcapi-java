
# Command

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **String** |  |  [optional]
**command** | **String** | The command to execute on the server. | 
**user** | **String** | The ID of the system user to run the command as. | 
**systems** | **List&lt;String&gt;** | An array of system IDs to run the command on. Not available if you are using Groups. |  [optional]
**schedule** | **String** | A crontab that consists of: [ (seconds) (minutes) (hours) (days of month) (months) (weekdays) ] or [ immediate ]. If you send this as an empty string, it will run immediately.  |  [optional]
**files** | **List&lt;String&gt;** | An array of file IDs to include with the command. |  [optional]
**tags** | **List&lt;String&gt;** | An array of tag IDs to run the command on. Not available if you are using Groups. |  [optional]
**timeout** | **String** | The time in seconds to allow the command to run for. |  [optional]



