# Filter

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**field** | **String** | Name of field in filter target object. | 
**operator** | [**OperatorEnum**](#OperatorEnum) | Filter comparison operator. | 
**value** | **String** | Filter comparison value. | 

<a name="OperatorEnum"></a>
## Enum: OperatorEnum
Name | Value
---- | -----
EQ | &quot;eq&quot;
NE | &quot;ne&quot;
GT | &quot;gt&quot;
GE | &quot;ge&quot;
LT | &quot;lt&quot;
LE | &quot;le&quot;
BETWEEN | &quot;between&quot;
SEARCH | &quot;search&quot;
IN | &quot;in&quot;
