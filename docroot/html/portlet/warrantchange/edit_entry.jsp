
<%
String redirect = ParamUtil.getString(request, "redirect");

Warrant entry = (Warrant)request.getAttribute("WARRANT");

long entryId = BeanParamUtil.getLong(entry, request, "id");

String content = BeanParamUtil.getString(entry, request, "content");
%>

<aui:form method="post" name="fm" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "saveEntry();" %>'>
	<aui:input name="<%= Constants.CMD %>" type="hidden" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="entryId" type="hidden" value="<%= entryId %>" />
	<aui:input name="alert" type="hidden" value="<%= portletName.equals(PortletKeys.ALERTS) %>" />

	<liferay-ui:header
		backURL="<%= redirect %>"
		title="entry"
	/>

<%-- 	<liferay-ui:error exception="<%= EntryContentException.class %>" message="please-enter-valid-content" />
	<liferay-ui:error exception="<%= EntryDisplayDateException.class %>" message="please-enter-a-valid-display-date" />
	<liferay-ui:error exception="<%= EntryExpirationDateException.class %>" message="please-enter-a-valid-expiration-date" />
	<liferay-ui:error exception="<%= EntryTitleException.class %>" message="please-enter-a-valid-title" />
	<liferay-ui:error exception="<%= EntryURLException.class %>" message="please-enter-a-valid-url" />
 --%>
	<aui:model-context bean="<%= entry %>" model="<%= Warrant.class %>" />

	<aui:fieldset>

		<aui:input name="title" />

		<aui:input name="url" />

		<aui:field-wrapper label="content">
			<liferay-ui:input-editor editorImpl="<%= EDITOR_WYSIWYG_IMPL_KEY %>" />

			<aui:input name="content" type="hidden" />
		</aui:field-wrapper>

		<aui:select name="type">

			<%
			for (String curType : AnnouncementsEntryConstants.TYPES) {
			%>

				<aui:option label="<%= curType %>" />

			<%
			}
			%>

		</aui:select>

		<aui:select name="priority">
			<aui:option label="normal" value="0" />
			<aui:option label="important" value="1" />
		</aui:select>

		<aui:input name="displayDate" />

		<aui:input name="expirationDate" />
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button href="<%= redirect %>" type="cancel" />
	</aui:button-row>
</aui:form>

<aui:script>
	function <portlet:namespace />getContent() {
		return window.<portlet:namespace />editor.getHTML();
	}

	function <portlet:namespace />initEditor() {
		return "<%= UnicodeFormatter.toString(content) %>";
	}

	function <portlet:namespace />saveEntry() {
		document.<portlet:namespace />fm.action = '<portlet:actionURL><portlet:param name="struts_action" value="/announcements/edit_entry" /></portlet:actionURL>';
		document.<portlet:namespace />fm.target = '';
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= (entry == null) ? Constants.ADD : Constants.UPDATE %>";
		document.<portlet:namespace />fm.<portlet:namespace />content.value = <portlet:namespace />getContent();
		submitForm(document.<portlet:namespace />fm);
	}

	<c:if test="<%= windowState.equals(WindowState.MAXIMIZED) %>">
		Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace />title);
	</c:if>
</aui:script>

<%!
public static final String EDITOR_WYSIWYG_IMPL_KEY = "editor.wysiwyg.portal-web.docroot.html.portlet.announcements.edit_entry.jsp";
%>