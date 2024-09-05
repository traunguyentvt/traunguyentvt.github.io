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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Quiz quiz = (Quiz) session.getAttribute("quiz");
        if (quiz == null) {
            quiz = new Quiz();
        }
        session.setAttribute("quiz", quiz);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Quiz quiz = (Quiz) session.getAttribute("quiz");
        if (quiz == null) {
            quiz = new Quiz();
        }
        session.setAttribute("quiz", quiz);

        String answerStr = request.getParameter("answer");
        String ageStr = request.getParameter("age");
        if (ageStr == null) {
            ageStr = "";
        }
        session.setAttribute("age", ageStr);

        boolean isValidAge = false;

        if (ageStr.isEmpty()) {
            session.setAttribute("age_error_msg", "Your age is required.");
        } else {
            try {
                int age = Integer.parseInt(ageStr);
                if (age >= 4 && age <= 100) {
                    session.removeAttribute("age_error_msg");
                    isValidAge = true;
                } else {
                    session.setAttribute("age_error_msg", "Your age should be between 4 and 100.");
                }
            } catch (NumberFormatException e) {
                // Handle invalid input gracefully
                session.setAttribute("age_error_msg", "Your age must be an integer.");
            }
        }

        if (isValidAge) {
            if (answerStr == null || answerStr.isEmpty()) {
                session.setAttribute("error_msg", "The answer is required.");
            } else {
                try {
                    int answer = Integer.parseInt(answerStr);
                    session.removeAttribute("error_msg");
                    if (quiz.checkAnswer(answer)) {
                        quiz.getNextQuestion();
                    } else {
                        quiz.currentTryAgain += 1;
                        if (quiz.currentTryAgain >= quiz.maxTryAgain) {
                            quiz.getNextQuestion();
                        }
                    }

                } catch (NumberFormatException e) {
                    // Handle invalid input gracefully
                    session.setAttribute("error_msg", "The answer must be an integer.");
                }
            }
        }

        response.sendRedirect("index.jsp");
    }
}
