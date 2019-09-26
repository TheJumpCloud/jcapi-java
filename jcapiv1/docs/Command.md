
# Command

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**command** | **String** | The command to execute on the server. | 
**commandRunners** | **List&lt;String&gt;** | An array of IDs of the Command Runner Users that can execute this command. |  [optional]
**commandType** | **String** | The Command OS |  [optional]
**files** | **List&lt;String&gt;** | An array of file IDs to include with the command. |  [optional]
**launchType** | **String** | How the command will execute. |  [optional]
**listensTo** | **String** |  |  [optional]
**name** | **String** |  |  [optional]
**organization** | **String** | The ID of the organization. |  [optional]
**schedule** | **String** | A crontab that consists of: [ (seconds) (minutes) (hours) (days of month) (months) (weekdays) ] or [ immediate ]. If you send this as an empty string, it will run immediately.  |  [optional]
**scheduleRepeatType** | **String** | When the command will repeat. |  [optional]
**sudo** | **Boolean** |  |  [optional]
**systems** | **List&lt;String&gt;** | An array of system IDs to run the command on. Not available if you are using Groups. |  [optional]
**timeout** | **String** | The time in seconds to allow the command to run for. |  [optional]
**user** | **String** | The ID of the system user to run the command as. | 



