package nvntrau.com;

import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/select")
public class BeerAdvisorServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String color = request.getParameter("color");
        List<String> brands = BeerExpert.getBrands(color);
        request.setAttribute("brands", brands);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }

}
