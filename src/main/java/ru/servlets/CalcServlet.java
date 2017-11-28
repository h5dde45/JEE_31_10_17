package ru.servlets;

import ru.calc.OperationType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "CalcServlet", urlPatterns = "/CalcServlet")
public class CalcServlet extends HttpServlet {
    private ArrayList<String> listOperation = new ArrayList<>();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<title>CalcServlet</title>");

        try {
            double one = Double.parseDouble(request.getParameter("one"));
            double two = Double.parseDouble(request.getParameter("two"));
            String operation = request.getParameter("operation");

            HttpSession session = request.getSession(true);
            OperationType operationType = OperationType.valueOf(operation.toUpperCase());
            double result = calcResult(operationType, one, two);

            if (session.isNew()) {
                listOperation.clear();
            } else {
                listOperation = (ArrayList<String>) session.getAttribute("formula");
            }

            listOperation.add(one + " " + operationType.getValue() + " "
                    + two + " = " + result);
            session.setAttribute("formula", listOperation);
            out.println("<h2>Id сессии: " + session.getId() + "</h2>");
            out.println("<h2>Кол-во операций: " + listOperation.size() + "</h2>");

            for (String s : listOperation) {
                out.println("<h3>" + s + "</h2>");
            }

        } catch (Exception e) {
            out.println("<h3 style=\"color:red\">Ошибка</h3>");
        } finally {
            out.close();
        }
    }

    private double calcResult(OperationType operationType, double one, double two) {
        switch (operationType) {
            case ADD:
                return one + two;
            case SUBTRACT:
                return one - two;
            case MULTIPLY:
                return one * two;
            case DIVIDE:
                return one / two;
        }

        return 0;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
