<%@page import="javax.portlet.RenderRequest"%>
<%@ include file="/init.jsp" %>


<p>
	<b><liferay-ui:message key="com_example_configuration_comexampleconfigurationmvcportletPortlet.caption"/></b>
</p>
<%
ColorConfiguration configuration = (ColorConfiguration) GetterUtil.getObject(
    renderRequest.getAttribute(ColorConfiguration.class.getName()));

String favoriteColor = "notset";
if (configuration!=null) {
 favoriteColor = configuration.favoriteColor();
}%>

<p>Favorite color: <span style="color: <%= favoriteColor %>;"><%= favoriteColor %></span></p>