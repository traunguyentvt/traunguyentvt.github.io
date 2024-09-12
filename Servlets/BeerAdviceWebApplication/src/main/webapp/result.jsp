<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
  <title>Beer Advisor</title>
</head>

<body>

<h1>Beer Recommendations</h1>

<c:choose>
  <c:when test="${not empty brands}">
    <c:forEach var="brand" items="${brands}">
      try: ${brand}
      <p></p>
    </c:forEach>
  </c:when>
  <c:otherwise>
    <p>No Beer recommendations available.</p>
  </c:otherwise>
</c:choose>

<a href="index.jsp">Go Back</a>

</body>

</html>