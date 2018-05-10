
# PolicyResult

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**policyID** | **String** | ObjectId uniquely identifying the parent Policy. |  [optional]
**systemID** | **String** | ObjectId uniquely identifying the parent System. |  [optional]
**id** | **String** | ObjectId uniquely identifying a Policy Result. |  [optional]
**startedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The start of the policy application. |  [optional]
**endedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The end of the policy application. |  [optional]
**success** | **Boolean** | True if the policy was successfully applied; false otherwise. |  [optional]
**exitStatus** | **Integer** | The 32-bit unsigned exit status from the applying the policy. |  [optional]
**stdErr** | **String** | The STDERR output from applying the policy. |  [optional]
**stdOut** | **String** | The STDOUT output from applying the policy. |  [optional]



