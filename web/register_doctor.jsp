<%@ page import="doctor.Doctor" %>
<%@ page import="utility.StringUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <form action="save_doctor" method="post">
        <% for(String attributeName: Doctor.attributeNames) { %>
        <%= StringUtils.removeUnderscoresAndAddCaps(attributeName)%>
        <input type="<%= StringUtils.getAppropriateForm(attributeName) %>"
               name="<%= attributeName %>" /><br>
        <% } %>
    <input type="submit" name="Register"/>
</form>
</body>
</html>
