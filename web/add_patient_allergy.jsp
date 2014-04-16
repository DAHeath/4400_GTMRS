<%@ page import="utility.StringUtils" %>
<%@ page import="patient.PatientAllergy" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <form action="save_patient_allergy" method="post">
        <% for(String attributeName: PatientAllergy.attributeNames) { %>
        <%= StringUtils.removeUnderscoresAndAddCaps(attributeName)%>
        <input type="<%= StringUtils.getAppropriateForm(attributeName) %>"
               name="<%= attributeName %>" /><br>
        <% } %>
    <input type="submit" name="Add Allergy"/>
</form>
</body>
</html>
