package nvntrau.com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculate")
public class CalculatorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve parameters from the form
        String add1 = request.getParameter("add1");
        String add2 = request.getParameter("add2");
        String mul1 = request.getParameter("mul1");
        String mul2 = request.getParameter("mul2");

        // Initialize variables for results and error messages
        String sumResult = "";
        String mulResult = "";
        String errorMessage = "";

        // Validate and perform addition if fields are not empty and are numeric
        if (isNumeric(add1) && isNumeric(add2)) {
            int sum = Integer.parseInt(add1) + Integer.parseInt(add2);
            sumResult = String.valueOf(sum);
        } else if (!add1.isEmpty() || !add2.isEmpty()) {
            errorMessage += "Please enter valid numbers for addition.<br>";
        }

        // Validate and perform multiplication if fields are not empty and are numeric
        if (isNumeric(mul1) && isNumeric(mul2)) {
            int product = Integer.parseInt(mul1) * Integer.parseInt(mul2);
            mulResult = String.valueOf(product);
        } else if (!mul1.isEmpty() || !mul2.isEmpty()) {
            errorMessage += "Please enter valid numbers for multiplication.<br>";
        }

        // Set attributes for the JSP page
        request.setAttribute("add1", add1);
        request.setAttribute("add2", add2);
        request.setAttribute("sumResult", sumResult);
        request.setAttribute("mul1", mul1);
        request.setAttribute("mul2", mul2);
        request.setAttribute("mulResult", mulResult);
        request.setAttribute("errorMessage", errorMessage);

        // Forward the request back to the index.jsp page
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

