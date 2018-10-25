
# Command

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **String** |  |  [optional]
**command** | **String** | The command to execute on the server. | 
**commandType** | **String** | The Command OS |  [optional]
**commandRunners** | **List&lt;String&gt;** | An array of IDs of the Command Runner Users that can execute this command. |  [optional]
**user** | **String** | The ID of the system user to run the command as. | 
**sudo** | **Boolean** |  |  [optional]
**systems** | **List&lt;String&gt;** | An array of system IDs to run the command on. Not available if you are using Groups. |  [optional]
**launchType** | **String** | How the command will execute. |  [optional]
**listensTo** | **String** |  |  [optional]
**scheduleRepeatType** | **String** | When the command will repeat. |  [optional]
**schedule** | **String** | A crontab that consists of: [ (seconds) (minutes) (hours) (days of month) (months) (weekdays) ] or [ immediate ]. If you send this as an empty string, it will run immediately.  |  [optional]
**files** | **List&lt;String&gt;** | An array of file IDs to include with the command. |  [optional]
**timeout** | **String** | The time in seconds to allow the command to run for. |  [optional]
**organization** | **String** | The ID of the organization. |  [optional]



