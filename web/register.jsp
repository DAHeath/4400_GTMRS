<%@ page import="user.User" %>
<%@ page import="utility.StringUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <form action="save_user" method="post">
        <% for(String attributeName: User.attributeNames) { %>
            <%= StringUtils.removeUnderscoresAndAddCaps(attributeName)%>
            <input type="<%= StringUtils.getAppropriateForm(attributeName) %>"
                   name="<%= attributeName %>" /><br>
        <% } %>
        <input type="submit" name="Register"/>
    </form>
</body>
</html>
