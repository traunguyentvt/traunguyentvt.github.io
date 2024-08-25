<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Simple Calculator</h1>
<form action="calculate" method="post">
    <input type="number" name="add1" required /> +
    <input type="number" name="add2" required />
    <p/>
    <input type="number" name="mul1" required /> *
    <input type="number" name="mul2" required />
    <p/>
    <input type="submit" value="Submit" />
</form>
</body>
</html>
