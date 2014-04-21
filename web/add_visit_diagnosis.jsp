<%@ page import="utility.StringUtils" %>
<%@ page import="visit.VisitDiagnosis" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <form action="save_visit_diagnosis" method="post">
        <% for(String attributeName: VisitDiagnosis.attributeNames) { %>
        <%= StringUtils.removeUnderscoresAndAddCaps(attributeName)%>
        <input type="<%= StringUtils.getAppropriateForm(attributeName) %>"
           name="<%= attributeName %>" /><br>
        <% } %>
    <input type="submit" name="Add Diagnosis"/>
</body>
</html>
