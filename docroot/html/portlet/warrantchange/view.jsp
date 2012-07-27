
<%@page import="com.liferay.util.NumberFormatUtil"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page import="javax.portlet.PortletPreferences" %>
<%@ page import="com.liferay.portal.service.permission.OrganizationPermissionUtil" %><%@
page import="com.liferay.portal.service.permission.RolePermissionUtil" %><%@
page import="com.liferay.portal.service.permission.UserGroupPermissionUtil" %>

<%@ page import="com.liferay.portal.service.permission.OrganizationPermissionUtil" %><%@
page import="com.liferay.portal.service.permission.RolePermissionUtil" %><%@
page import="com.liferay.portal.service.permission.UserGroupPermissionUtil" %>

<%@ page import="com.liferay.taglib.ui.LanguageTag" %>

<%@ page import="com.liferay.portal.NoSuchUserException" %><%@
page import="com.liferay.portal.kernel.bean.BeanParamUtil" %><%@
page import="com.liferay.portal.kernel.bean.BeanPropertiesUtil" %><%@
page import="com.liferay.portal.kernel.cal.Recurrence" %><%@
page import="com.liferay.portal.kernel.captcha.CaptchaMaxChallengesException" %><%@
page import="com.liferay.portal.kernel.captcha.CaptchaTextException" %><%@
page import="com.liferay.portal.kernel.configuration.Filter" %><%@
page import="com.liferay.portal.kernel.dao.orm.QueryUtil" %><%@
page import="com.liferay.portal.kernel.dao.search.AlwaysTrueRowChecker" %><%@
page import="com.liferay.portal.kernel.dao.search.DisplayTerms" %><%@
page import="com.liferay.portal.kernel.dao.search.JSPSearchEntry" %><%@
page import="com.liferay.portal.kernel.dao.search.ResultRow" %><%@
page import="com.liferay.portal.kernel.dao.search.RowChecker" %><%@
page import="com.liferay.portal.kernel.dao.search.SearchContainer" %><%@
page import="com.liferay.portal.kernel.dao.search.SearchEntry" %><%@
page import="com.liferay.portal.kernel.dao.search.TextSearchEntry" %><%@
page import="com.liferay.portal.kernel.exception.PortalException" %><%@
page import="com.liferay.portal.kernel.exception.SystemException" %><%@
page import="com.liferay.portal.kernel.io.unsync.UnsyncStringReader" %><%@
page import="com.liferay.portal.kernel.json.JSONArray" %><%@
page import="com.liferay.portal.kernel.json.JSONFactoryUtil" %><%@
page import="com.liferay.portal.kernel.json.JSONObject" %><%@
page import="com.liferay.portal.kernel.language.LanguageUtil" %><%@
page import="com.liferay.portal.kernel.language.LanguageWrapper" %><%@
page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil" %><%@
page import="com.liferay.portal.kernel.log.Log" %><%@
page import="com.liferay.portal.kernel.log.LogFactoryUtil" %><%@
page import="com.liferay.portal.kernel.log.LogUtil" %><%@
page import="com.liferay.portal.kernel.messaging.DestinationNames" %><%@
page import="com.liferay.portal.kernel.messaging.MessageBusUtil" %><%@
page import="com.liferay.portal.kernel.portlet.DynamicRenderRequest" %><%@
page import="com.liferay.portal.kernel.portlet.LiferayPortletMode" %><%@
page import="com.liferay.portal.kernel.portlet.LiferayPortletRequest" %><%@
page import="com.liferay.portal.kernel.portlet.LiferayPortletResponse" %><%@
page import="com.liferay.portal.kernel.portlet.LiferayPortletURL" %><%@
page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %><%@
page import="com.liferay.portal.kernel.search.Field" %><%@
page import="com.liferay.portal.kernel.servlet.BrowserSnifferUtil" %><%@
page import="com.liferay.portal.kernel.servlet.ServletContextUtil" %><%@
page import="com.liferay.portal.kernel.servlet.SessionErrors" %><%@
page import="com.liferay.portal.kernel.servlet.SessionMessages" %><%@
page import="com.liferay.portal.kernel.servlet.StringServletResponse" %><%@
page import="com.liferay.portal.kernel.staging.LayoutStagingUtil" %><%@
page import="com.liferay.portal.kernel.upload.UploadException" %><%@
page import="com.liferay.portal.kernel.util.ArrayUtil" %><%@
page import="com.liferay.portal.kernel.util.BooleanWrapper" %><%@
page import="com.liferay.portal.kernel.util.CalendarFactoryUtil" %><%@
page import="com.liferay.portal.kernel.util.CalendarUtil" %><%@
page import="com.liferay.portal.kernel.util.CharPool" %><%@
page import="com.liferay.portal.kernel.util.Constants" %><%@
page import="com.liferay.portal.kernel.util.ContentTypes" %><%@
page import="com.liferay.portal.kernel.util.DateUtil" %><%@
page import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil" %><%@
page import="com.liferay.portal.kernel.util.FileUtil" %><%@
page import="com.liferay.portal.kernel.util.GetterUtil" %><%@
page import="com.liferay.portal.kernel.util.HtmlUtil" %><%@
page import="com.liferay.portal.kernel.util.Http" %><%@
page import="com.liferay.portal.kernel.util.HttpUtil" %><%@
page import="com.liferay.portal.kernel.util.IntegerWrapper" %><%@
page import="com.liferay.portal.kernel.util.JavaConstants" %><%@
page import="com.liferay.portal.kernel.util.KeyValuePair" %><%@
page import="com.liferay.portal.kernel.util.KeyValuePairComparator" %><%@
page import="com.liferay.portal.kernel.util.ListUtil" %><%@
page import="com.liferay.portal.kernel.util.LocaleUtil" %><%@
page import="com.liferay.portal.kernel.util.LocalizationUtil" %><%@
page import="com.liferay.portal.kernel.util.MathUtil" %><%@
page import="com.liferay.portal.kernel.util.ObjectValuePair" %><%@
page import="com.liferay.portal.kernel.util.OrderByComparator" %><%@
page import="com.liferay.portal.kernel.util.OrderedProperties" %><%@
page import="com.liferay.portal.kernel.util.ParamUtil" %><%@
page import="com.liferay.portal.kernel.util.PrefsParamUtil" %><%@
page import="com.liferay.portal.kernel.util.PropertiesParamUtil" %><%@
page import="com.liferay.portal.kernel.util.PropertiesUtil" %><%@
page import="com.liferay.portal.kernel.util.PropsKeys" %><%@
page import="com.liferay.portal.kernel.util.ReleaseInfo" %><%@
page import="com.liferay.portal.kernel.util.ResourceBundleUtil" %><%@
page import="com.liferay.portal.kernel.util.ServerDetector" %><%@
page import="com.liferay.portal.kernel.util.SetUtil" %><%@
page import="com.liferay.portal.kernel.util.SortedArrayList" %><%@
page import="com.liferay.portal.kernel.util.StringBundler" %><%@
page import="com.liferay.portal.kernel.util.StringComparator" %><%@
page import="com.liferay.portal.kernel.util.StringPool" %><%@
page import="com.liferay.portal.kernel.util.StringUtil" %><%@
page import="com.liferay.portal.kernel.util.TextFormatter" %><%@
page import="com.liferay.portal.kernel.util.Time" %><%@
page import="com.liferay.portal.kernel.util.TimeZoneUtil" %><%@
page import="com.liferay.portal.kernel.util.Tuple" %><%@
page import="com.liferay.portal.kernel.util.UnicodeFormatter" %><%@
page import="com.liferay.portal.kernel.util.UnicodeProperties" %><%@
page import="com.liferay.portal.kernel.util.Validator" %><%@
page import="com.liferay.portal.kernel.workflow.WorkflowConstants" %>
<%@page import="com.liferay.portal.theme.PortletDisplay" %>
<%@page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@page import="com.liferay.portal.model.*" %>
<%@page import="com.liferay.portlet.PortletURLUtil" %>
<%@page import="com.warrantchange.service.*" %>
<%@page import="com.warrantchange.model.*" %>

<%@ page import="java.io.Serializable" %>

<%@ page import="java.math.BigDecimal" %>

<%@ page import="java.text.DateFormat" %><%@
page import="java.text.DecimalFormat" %><%@
page import="java.text.Format" %><%@
page import="java.text.NumberFormat" %><%@
page import="java.text.SimpleDateFormat" %>

<%@ page import="java.util.ArrayList" %><%@
page import="java.util.Arrays" %><%@
page import="java.util.Calendar" %><%@
page import="java.util.Collection" %><%@
page import="java.util.Collections" %><%@
page import="java.util.Currency" %><%@
page import="java.util.Date" %><%@
page import="java.util.Enumeration" %><%@
page import="java.util.GregorianCalendar" %><%@
page import="java.util.HashMap" %><%@
page import="java.util.HashSet" %><%@
page import="java.util.Iterator" %><%@
page import="java.util.LinkedHashMap" %><%@
page import="java.util.LinkedHashSet" %><%@
page import="java.util.List" %><%@
page import="java.util.Locale" %><%@
page import="java.util.Map" %><%@
page import="java.util.Properties" %><%@
page import="java.util.ResourceBundle" %><%@
page import="java.util.Set" %><%@
page import="java.util.Stack" %><%@
page import="java.util.TimeZone" %><%@
page import="java.util.TreeMap" %><%@
page import="java.util.TreeSet" %>

<%@ page import="javax.portlet.MimeResponse" %><%@
page import="javax.portlet.PortletConfig" %><%@
page import="javax.portlet.PortletContext" %><%@
page import="javax.portlet.PortletException" %><%@
page import="javax.portlet.PortletMode" %><%@
page import="javax.portlet.PortletPreferences" %><%@
page import="javax.portlet.PortletRequest" %><%@
page import="javax.portlet.PortletResponse" %><%@
page import="javax.portlet.PortletURL" %><%@
page import="javax.portlet.ResourceURL" %><%@
page import="javax.portlet.UnavailableException" %><%@
page import="javax.portlet.ValidatorException" %><%@
page import="javax.portlet.WindowState" %>

<portlet:defineObjects />

<% 
WindowState windowState = null;
PortletMode portletMode = null;
PortletURL currentURLObj = null;

windowState = renderRequest.getWindowState();
portletMode = renderRequest.getPortletMode();

if(!portletMode.equals(PortletMode.VIEW)){
	return;
}
	
currentURLObj = PortletURLUtil.getCurrent(renderRequest, renderResponse);
String currentURL = currentURLObj.toString();

PortletPreferences prefs = renderRequest.getPreferences(); 
String greeting = (String)prefs.getValue( "greeting", "List of available Warrants"); 

String portletResource = ParamUtil.getString(request, "portletResource");

ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(com.liferay.portal.kernel.util.WebKeys.THEME_DISPLAY);

User user = themeDisplay.getUser();
Locale locale = null;
if(user != null){
	locale = user.getLocale();
}

TimeZone timeZone = TimeZoneUtil.getDefault();

Format dateFormatDate = FastDateFormatFactoryUtil.getDateTime(locale, timeZone);

Locale[] availableLocales = LanguageUtil.getAvailableLocales();
String[] availableLanguageIds = LocaleUtil.toLanguageIds(availableLocales);
 
String[] languageIds = StringUtil.split(prefs.getValue("languageIds", StringUtil.merge(availableLanguageIds)));
int displayStyle = GetterUtil.getInteger(prefs.getValue("displayStyle", StringPool.BLANK));

languageIds = new String[]{locale.toString()};

themeDisplay.setIncludeServiceJs(true);

currentURLObj.setParameter("struts_action", "/warrantchange/view");

%>

<c:choose>
	<c:when test="<%= !themeDisplay.isSignedIn() %>">
		<p> You have to Login to use the Warrant Change application!</p>
	</c:when>
	<c:otherwise>
	
		<p>Welcome! UserId:<%= themeDisplay.getUserId() %>
			<liferay-ui:language languageIds="<%= languageIds %>" displayStyle="<%= displayStyle %>" />
		</p>
		<p><%= greeting %></p>
		
		<aui:form action="<%= currentURLObj.toString() %>" method="post" name="fm">

			<aui:button onClick='<%= renderResponse.getNamespace() + "addEntry()" %>' value="add-entry" />
		
				<div class="separator"><!-- --></div>
		
				<%
				PortletURL iteratorURL = PortletURLUtil.clone(currentURLObj, renderResponse);
		
				List<String> headerNames = new ArrayList<String>();
		
				headerNames.add("userId");
				headerNames.add("country");
				headerNames.add("summary");
				headerNames.add("quantity");
				headerNames.add("price");
				headerNames.add("sent");
				headerNames.add("modified");
				
		
				SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, iteratorURL, headerNames, "no-entries-were-found");
		
				int total = WarrantLocalServiceUtil.getWarrantsCount();
		
				searchContainer.setTotal(total);
		
				List<Warrant> results = WarrantLocalServiceUtil.findWarrants(searchContainer.getStart(), searchContainer.getEnd());
		
				searchContainer.setResults(results);
		
				List resultRows = searchContainer.getResultRows();
		
				for (int i = 0; i < results.size(); i++) {
					Warrant entry = results.get(i);
		
					entry = entry.toEscapedModel();
					
					User u = UserLocalServiceUtil.getUser(entry.getUserId());
		
					ResultRow row = new ResultRow(entry, entry.getId(), i);
					
					PortletURL deleteURL = renderResponse.createActionURL();
					
					deleteURL.setParameter("redirect", currentURL);
					deleteURL.setParameter(Constants.CMD, Constants.DELETE);
					deleteURL.setParameter("entryId", String.valueOf(entry.getId()));
					
					PortletURL rowURL = renderResponse.createRenderURL();
		
					rowURL.setParameter("jspPage", "/html/portlet/warrantchange/edit.jsp");
					/* rowURL.setParameter("struts_action", "/warrantchange/edit_entry"); */
					rowURL.setParameter("redirect", currentURL);
					rowURL.setParameter("entryId", String.valueOf(entry.getId()));
		
					// UserId
					row.addText(String.valueOf(entry.getUserId()), rowURL);
					
					//Country
					//request.setAttribute("languageIds", u.getLocale().getLanguage());
					//row.addJSP("right", SearchEntry.DEFAULT_VALIGN, "html/taglib/ui/language/page.jsp",);
					row.addText(u.getLocale().getDisplayCountry(), rowURL);
					
					// Summ
					row.addText(entry.getSummary(), rowURL);
		
					// Qty
					row.addText(String.valueOf(entry.getQuantity()), rowURL);
		
					//Price
					row.addText(NumberFormat.getCurrencyInstance(u.getLocale()).format(entry.getPrice()), rowURL);
					
					// Modified date
					row.addText(dateFormatDate.format(entry.getModifiedDate()), rowURL);
					/* row.addText(DateFormat.getModifiedDate(), rowURL); */
		
					// Create date
					row.addText(dateFormatDate.format(entry.getCreateDate()), rowURL);
					
					// Action
					//row.addText("right", SearchEntry.DEFAULT_VALIGN, "Delete", deleteURL);
					//row.addJSP("right", SearchEntry.DEFAULT_VALIGN, "entry_action.jspf");
		
					// Add result row
					resultRows.add(row);
				}
				%>
		
				<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />

		</aui:form>
		
		<aui:script>
			function <portlet:namespace />addEntry() {
				location.href = '<portlet:renderURL> <portlet:param name="jspPage" value="/html/portlet/warrantchange/edit.jsp" /><portlet:param name="struts_action" value="/warrantchange/edit_entry" /><portlet:param name="redirect" value="<%= currentURL %>" /></portlet:renderURL>';
			}
		</aui:script>
	
	</c:otherwise>
</c:choose>

