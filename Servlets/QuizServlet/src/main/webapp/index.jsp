<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="nvntrau.com.Quiz" %>
<html>
<head>
    <title>Quiz</title>
</head>
<body>
<h1>The Number Quiz</h1>

<%
    // Retrieve the quiz object from the session
    Quiz quiz = (Quiz) session.getAttribute("quiz");

    // Safeguard in case quiz is null (should not happen if servlet is correct)
    if (quiz == null) {
        quiz = new Quiz();
//        out.println("<p>There was an error initializing the quiz. Please restart the quiz.</p>");
    }
%>
<p>Your current score is: <%= quiz.getScore() %></p>

<%
    if (quiz.hasNextQuestion()) {
%>
<p>Guess the next number in the sequence:</p>
<p><%= quiz.getCurrentQuestion() %></p>
<form method="post" action="QuizServlet">
    Your answer: <input type="number" name="answer" required />
    <input type="submit" value="Submit" />
</form>
<%
} else {
%>
<p>You have completed the Number Quiz with a score of <%= quiz.getScore() %> out of <%= quiz.getTotalQuestions() %>.</p>
<%
    }
%>

</body>
</html>
