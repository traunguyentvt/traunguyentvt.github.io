<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
    <script>
        function autoSubmit() {
            // let add1 = $("input[name='add1']").val()
            // let add2 = $("input[name='add2']").val()
            // let mul1 = $("input[name='mul1']").val()
            // let mul2 = $("input[name='mul2']").val()
            //
            // if ((!add1.isEmpty && !add2.isEmpty) || (!mul1.isEmpty && !mul2.isEmpty)) {
            //     console.log("add1 = " + add1 + ", add2 = " + add2 + ", mul1 = " + mul1 + ", mul2 = " + mul2)
                // document.getElementById("calculatorForm").submit();
                $("#calculatorForm").submit();
            // }
        }
    </script>
</head>
<body>
<h1>Improved Calculator</h1>

<form id="calculatorForm" action="calculate" method="post">
    <input type="number" name="add1" required value="<%= request.getAttribute("add1") != null ? request.getAttribute("add1") : "" %>" onkeyup="autoSubmit()" />
    +
    <input type="number" name="add2" required value="<%= request.getAttribute("add2") != null ? request.getAttribute("add2") : "" %>" onkeyup="autoSubmit()" />
    =
    <input type="number" name="sumResult" readonly value="<%= request.getAttribute("sumResult") != null ? request.getAttribute("sumResult") : "" %>" />

    <p/>

    <input type="number" name="mul1" required value="<%= request.getAttribute("mul1") != null ? request.getAttribute("mul1") : "" %>" onkeyup="autoSubmit()" />
    *
    <input type="number" name="mul2" required value="<%= request.getAttribute("mul2") != null ? request.getAttribute("mul2") : "" %>" onkeyup="autoSubmit()" />
    =
    <input type="number" name="mulResult" readonly value="<%= request.getAttribute("mulResult") != null ? request.getAttribute("mulResult") : "" %>" />

    <p/>

    <input type="submit" value="Submit" />
</form>

<%
    String errorMessage = (String) request.getAttribute("errorMessage");
    if (errorMessage != null && !errorMessage.isEmpty()) {
%>
<p style="color: red;"><%= errorMessage %></p>
<% } %>
</body>
</html>
