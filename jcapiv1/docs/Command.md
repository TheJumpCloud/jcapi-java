# Command

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**command** | **String** | The command to execute on the server. | 
**commandRunners** | **List&lt;String&gt;** | An array of IDs of the Command Runner Users that can execute this command. |  [optional]
**commandType** | **String** | The Command OS | 
**files** | **List&lt;String&gt;** | An array of file IDs to include with the command. |  [optional]
**launchType** | **String** | How the command will execute. |  [optional]
**listensTo** | **String** |  |  [optional]
**name** | **String** |  | 
**organization** | **String** | The ID of the organization. |  [optional]
**schedule** | **String** | A crontab that consists of: [ (seconds) (minutes) (hours) (days of month) (months) (weekdays) ] or [ immediate ]. If you send this as an empty string, it will run immediately.  |  [optional]
**scheduleRepeatType** | **String** | When the command will repeat. |  [optional]
**scheduleYear** | **Integer** | The year that a scheduled command will launch in. |  [optional]
**shell** | **String** | The shell used to run the command. |  [optional]
**sudo** | **Boolean** |  |  [optional]
**systems** | **List&lt;String&gt;** | An array of system IDs to run the command on. Not available if you are using Groups. |  [optional]
**template** | **String** | The template this command was created from |  [optional]
**timeToLiveSeconds** | **Integer** | Time in seconds a command can wait in the queue to be run before timing out |  [optional]
**timeout** | **String** | The time in seconds to allow the command to run for. |  [optional]
**trigger** | **String** | The name of the command trigger. |  [optional]
**user** | **String** | The ID of the system user to run the command as. This field is required when creating a command with a commandType of \&quot;mac\&quot; or \&quot;linux\&quot;. |  [optional]
