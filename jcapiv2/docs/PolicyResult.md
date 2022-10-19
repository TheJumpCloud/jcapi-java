# PolicyResult

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**detail** | **String** | Details pertaining to the policy result. |  [optional]
**endedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The end of the policy application. |  [optional]
**exitStatus** | **Integer** | The 32-bit unsigned exit status from the applying the policy. |  [optional]
**id** | **String** | ObjectId uniquely identifying a Policy Result. |  [optional]
**policyID** | **String** | ObjectId uniquely identifying the parent Policy. |  [optional]
**startedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The start of the policy application. |  [optional]
**state** | **String** | Enumeration describing the state of the policy. Success, failed, or pending. |  [optional]
**stdErr** | **String** | The STDERR output from applying the policy. |  [optional]
**stdOut** | **String** | The STDOUT output from applying the policy. |  [optional]
**success** | **Boolean** | True if the policy was successfully applied; false otherwise. |  [optional]
**systemID** | **String** | ObjectId uniquely identifying the parent System. |  [optional]
