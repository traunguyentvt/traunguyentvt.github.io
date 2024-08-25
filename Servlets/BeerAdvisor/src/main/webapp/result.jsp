<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Beer Advisor</title>
</head>
<body>
<h1>Beer Recommendations</h1>

<!-- Processing the form data and displaying recommendations -->
<%
    List<String> brands = (List<String>) request.getAttribute("brands");
    if (brands != null) {  // Check if form has been submitted
        for (String brand : brands) {
            out.println("try: " + brand + "<p/>");
        }
    }
%>

<a href="index.jsp">Go Back</a>

</body>
</html>
