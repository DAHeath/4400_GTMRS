<%@ page import="utility.StringUtils" %>
<%@ page import="visit.Visit" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<body>
    <form action="save_visit" method="post">
        <% for(String attributeName: Visit.attributeNames) { %>
        <%= StringUtils.removeUnderscoresAndAddCaps(attributeName)%>
        <input type="<%= StringUtils.getAppropriateForm(attributeName) %>"
           name="<%= attributeName %>" /><br>
        <% } %>
    <input type="submit" name="Register"/>
</body>
</html>
