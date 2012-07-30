
<liferay-ui:header
	backURL="javascript:history.go(-1);"
	title="error"
/>

<liferay-ui:error exception="<%= NoSuchEntryException.class %>" message="the-entry-could-not-be-found" />
<liferay-ui:error exception="<%= PrincipalException.class %>" message="you-do-not-have-the-required-permissions" />