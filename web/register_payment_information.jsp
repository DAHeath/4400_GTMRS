<%@ page import="payment.PaymentInformation" %>
<%@ page import="utility.StringUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <form action="save_payment_information" method="post">
    <% for(String attributeName: PaymentInformation.attributeNames) { %>
    <%= StringUtils.removeUnderscoresAndAddCaps(attributeName)%>
    <input type="<%= StringUtils.getAppropriateForm(attributeName) %>"
           name="<%= attributeName %>" /><br>
    <% } %>
    <input type="submit" name="Register"/>
</form>

</body>
</html>
