
# SystemGraphManagementReq

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**attributes** | [**SystemGraphManagementReqAttributes**](SystemGraphManagementReqAttributes.md) |  |  [optional]
**id** | **String** | The ObjectID of graph object being added or removed as an association. | 
**op** | [**OpEnum**](#OpEnum) | How to modify the graph connection. | 
**type** | [**TypeEnum**](#TypeEnum) |  | 


<a name="OpEnum"></a>
## Enum: OpEnum
Name | Value
---- | -----
ADD | &quot;add&quot;
REMOVE | &quot;remove&quot;
UPDATE | &quot;update&quot;


<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
ACTIVE_DIRECTORY | &quot;active_directory&quot;
APPLICATION | &quot;application&quot;
COMMAND | &quot;command&quot;
G_SUITE | &quot;g_suite&quot;
LDAP_SERVER | &quot;ldap_server&quot;
OFFICE_365 | &quot;office_365&quot;
POLICY | &quot;policy&quot;
RADIUS_SERVER | &quot;radius_server&quot;
USER | &quot;user&quot;
USER_GROUP | &quot;user_group&quot;



