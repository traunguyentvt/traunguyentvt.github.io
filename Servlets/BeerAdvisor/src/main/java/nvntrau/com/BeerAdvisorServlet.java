package nvntrau.com;

import java.util.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/select")
public class BeerAdvisorServlet extends HttpServlet {

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException {
        String color = request.getParameter("color");
        List<String> brands = BeerExpert.getBrands(color);

        // Set attributes for the JSP page
        request.setAttribute("brands", brands);

        // Forward the request to the result.jsp page
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}
