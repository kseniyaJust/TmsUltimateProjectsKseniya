package Lesson24.ageServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/age")
public class AdultOrNotServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            resp.setContentType("text/html");
            int age = Integer.parseInt(req.getParameter("age"));
            if(age>17){
                resp.getWriter().println("<h1>Adult</h1>");
            }
            else {
                resp.getWriter().println("<h1>Not adult</h1>");
            }
        }catch (NumberFormatException e){
            resp.getWriter().println("<h1>Wrong integer</h1>");
        }

    }
}
