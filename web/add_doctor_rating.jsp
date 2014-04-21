<%@ page import="doctor.DoctorRating" %>
<%@ page import="utility.StringUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <form action="save_doctor_rating" method="post">
        <% for(String attributeName: DoctorRating.attributeNames) { %>
        <%= StringUtils.removeUnderscoresAndAddCaps(attributeName)%>
    <input type="<%= StringUtils.getAppropriateForm(attributeName) %>"
           name="<%= attributeName %>" /><br>
        <% } %>
    <input type="submit" name="Add Rating"/>
</body>
</html>
