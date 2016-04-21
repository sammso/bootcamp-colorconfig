<%@page import="javax.portlet.RenderRequest"%>
<%@ include file="/init.jsp" %>


<p>
	<b><liferay-ui:message key="com_example_configuration_comexampleconfigurationmvcportletPortlet.caption"/></b>
</p>

<%
    boolean noConfig = Validator.isNull(favoriteColor);
%>

<c:choose>
    <c:when test="<%= noConfig %>">
        <p>
            Please select use the portlet configuration to select a favorite color.
        </p>
    </c:when>

    <c:otherwise>

        <p style="color: <%= favoriteColor %>">
            <%= favoriteColor %>!
        </p>
    </c:otherwise>
</c:choose>