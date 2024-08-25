package nvntrau.com;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/QuizServlet")
public class QuizServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Quiz quiz = (Quiz) session.getAttribute("quiz");

        // Initialize the Quiz object if it's not already in the session
        if (quiz == null) {
            quiz = new Quiz();
        }
        session.setAttribute("quiz", quiz);

        // Forward to the JSP page
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Quiz quiz = (Quiz) session.getAttribute("quiz");

        // If quiz is null, initialize it (this is a safeguard)
        if (quiz == null) {
            quiz = new Quiz();
        }
        session.setAttribute("quiz", quiz);

        String answerStr = request.getParameter("answer");
        try {
            int answer = Integer.parseInt(answerStr);
            quiz.checkAnswer(answer);
            quiz.nextQuestion();
        } catch (NumberFormatException e) {
            // Handle invalid input gracefully
        }

        // Redirect to GET method to update the page
        response.sendRedirect("QuizServlet");
    }
}
