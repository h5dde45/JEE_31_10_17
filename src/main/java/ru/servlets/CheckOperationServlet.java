package ru.servlets;

import ru.calc.TestObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "CheckOperationServlet", urlPatterns = "/CheckOperation")
public class CheckOperationServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<title>CheckOperation</title>");

        try {
            HttpSession session = request.getSession(true);
            ArrayList<String> listOperation = (ArrayList<String>) session.getAttribute("formula");
            out.println("<h2>Id сессии: " + session.getId() + "</h2>");
            for (String s : listOperation) {
                out.println("<h3>" + s + "</h2>");
            }
            out.println("<h3>" + ((TestObject)request.getServletContext().
                    getAttribute("obj")).getName() + "</h2>");

        } catch (Exception e) {
            out.println("<h3 style=\"color:red\">Ошибка</h3>");
        } finally {
            out.close();
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }
}
