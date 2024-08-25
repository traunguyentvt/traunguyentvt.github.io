package nvntrau.com;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class FirstServlet extends HttpServlet {
    protected void doGet (HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
        out.print("<html><head><title>Test</title></head><body>");
        out.print("<form method='post'>");
        out.print("<p>Please click the button</p>");
        out.print("<input type='submit' value='Click me'/>");
        out.print("</form>");
        out.print("</body></html>");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.print("<html><head><title>Test</title></head><body>");
        out.print("<p>Postback received</p>");
        out.print("</body></html>");
    }
}
