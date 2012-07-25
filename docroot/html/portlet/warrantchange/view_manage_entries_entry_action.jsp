
<%
ResultRow row = (ResultRow)request.getAttribute("SEARCH_CONTAINER_RESULT_ROW");

Warrant entry = (Warrant)row.getObject();
%>

<liferay-ui:icon-menu>
	
		<portlet:renderURL var="editURL">
			<portlet:param name="struts_action" value="/announcements/edit_entry" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="entryId" value="<%= String.valueOf(entry.getEntryId()) %>" />
		</portlet:renderURL>

		<liferay-ui:icon
			image="edit"
			url="<%= editURL %>"
		/>
	
		<portlet:actionURL var="deleteURL">
			<portlet:param name="struts_action" value="/announcements/edit_entry" />
			<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.DELETE %>" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="entryId" value="<%= String.valueOf(entry.getEntryId()) %>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete
			url="<%= deleteURL %>"
		/>
	
</liferay-ui:icon-menu>