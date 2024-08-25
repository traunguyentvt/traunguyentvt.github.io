<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
</head>
<body>

<h1>Calculation Result</h1>

<%
    String sumResult = (String) request.getAttribute("sumResult");
    String mulResult = (String) request.getAttribute("mulResult");
    String errorMessage = (String) request.getAttribute("errorMessage");
%>

<% if (errorMessage != null && !errorMessage.isEmpty()) { %>
<p style="color: red;"><%= errorMessage %></p>
<% } %>

<% if (sumResult != null && !sumResult.isEmpty()) { %>
<p><%= sumResult %></p>
<% } %>

<% if (mulResult != null && !mulResult.isEmpty()) { %>
<p><%= mulResult %></p>
<% } %>

<a href="index.jsp">Go Back</a>

</body>
</html>