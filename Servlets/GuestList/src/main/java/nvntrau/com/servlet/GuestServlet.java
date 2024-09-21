package nvntrau.com.servlet;

import com.google.gson.Gson;
import nvntrau.com.model.Guest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "guestServlet", urlPatterns = {"*.ajax"})
public class GuestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("guest.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        List<Guest> guestList = (List<Guest>) session.getAttribute("guestList");
        if (guestList == null) {
            guestList = new ArrayList<>();
            session.setAttribute("guestList", guestList);
        }

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        guestList.add(new Guest(firstName, lastName));

        String jsonResponse = new Gson().toJson(guestList);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        out.write(jsonResponse);
    }

}
