<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<portlet:defineObjects />

<jsp:useBean id="entries" class="java.util.ArrayList" scope="request"/>

This is the <b>Guestbook Mvn Demo</b> portlet in View mode.

	<portlet:renderURL var="addEntryURL" >	
		<portlet:param name="mvcPath" value="/html/guestbook/edit_entry.jsp"/>		
	</portlet:renderURL>
	
	<liferay-ui:search-container>
		<liferay-ui:search-container-results
			results="<%= entries %>"
		/>

		<liferay-ui:search-container-row
			className="com.guestbook.model.Entry"
			modelVar="entry"
		>
			<liferay-ui:search-container-column-text property="name" />	
			<liferay-ui:search-container-column-text property="message" />
		
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator />
	</liferay-ui:search-container>

	<aui:button-row cssClass="guestbook-buttons" >
		<aui:button onClick="<%= addEntryURL.toString() %>" value="Add Entry"></aui:button>
	</aui:button-row>
