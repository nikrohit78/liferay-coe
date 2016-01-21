<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />



	<portlet:renderURL var="viewEntryURL" >	
		<portlet:param name="mvcPath" value="/html/guestbook/view.jsp"/>
	</portlet:renderURL>
	
	<portlet:actionURL name="addEntry" var="addEntryURL"></portlet:actionURL>
	
	<aui:form action="<%= addEntryURL %>" name="<portlet:namespace />fm">	
		<aui:fieldset>
			<aui:input name="name"></aui:input>
			<aui:input name="message"></aui:input>
		</aui:fieldset>			
		<aui:button-row>
			<aui:button type="submit"></aui:button>
			<aui:button onClick="<%= viewEntryURL.toString() %>" type="cancel"></aui:button>
		</aui:button-row>	
	</aui:form>