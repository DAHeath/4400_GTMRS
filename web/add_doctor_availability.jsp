<%@ page import="doctor.DoctorAvailability" %>
<%@ page import="utility.StringUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <form action="save/doctor_availability" method="post">
        <% for(String attributeName: DoctorAvailability.attributeNames) { %>
        <%= StringUtils.removeUnderscoresAndAddCaps(attributeName)%>
        <input type="<%= StringUtils.getAppropriateForm(attributeName) %>"
           name="<%= attributeName %>" /><br>
        <% } %>
    <input type="submit" name="Add Allergy"/>
</body>
</html>
