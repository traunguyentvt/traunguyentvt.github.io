<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="nvntrau.com.Quiz" %>

<html>

<head>
    <title>Quiz</title>

    <script type="text/javascript">
        function showHint(message) {
            alert(message);
        }
    </script>

</head>

<body>

<h1>The Number Quiz</h1>

<%
    Quiz quiz = (Quiz)session.getAttribute("quiz");
    if (quiz == null) {
        quiz = new Quiz();
    }
%>

<form method="post" action="QuizServlet">

    <%
        String age = (String) session.getAttribute("age");
        if (age == null) {
            age = "";
        }
    %>

    Your age: <input type="text" name="age" value="<%= age %>"/>
    <%
        String age_error_msg = (String) session.getAttribute("age_error_msg");
        if (age_error_msg != null && !age_error_msg.isEmpty()) {
    %>
    <p style="color: red"> <%= age_error_msg %> </p>
    <%
        }
    %>

    <p>Your current score is: <%= quiz.getScore() %> </p>

<%
    if (quiz.hasNextQuestion()) {
%>
    <p>Guess the next number in the sequence:</p>
    <p> <%= quiz.getCurrentQuestion() %> <button onclick="showHint('<%= quiz.getHint() %>')">***Hint</button> </p>

    Your answer: <input type="text" name="answer" />
    <input type="submit" value="Submit" />

<%
    String error_msg = (String) session.getAttribute("error_msg");
    if (error_msg != null && !error_msg.isEmpty()) {
%>
    <p style="color: red"> <%= error_msg %> </p>
<%
    }
%>

<%
    } else {
%>
    <p>You have completed the Number Quiz with a score of <%= quiz.getScore() %> out of <%= quiz.getTotalScores() %> </p>
    <p style="color: red"> <%= quiz.getGrade() %> </p>
<%
    }
%>

</form>

</body>

</html>
