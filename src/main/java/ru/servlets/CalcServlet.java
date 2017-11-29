package ru.servlets;

import ru.calc.OperationType;
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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CalcServlet", urlPatterns = "/CalcServlet")
public class CalcServlet extends HttpServlet {
//    ArrayList<String> listOperation = new ArrayList<>();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Map<String, List> sessionMap = (Map<String, List>) request.getServletContext()
                .getAttribute("sessionMap");

        if (sessionMap == null) {
            sessionMap = new LinkedHashMap<>();
        }

        PrintWriter out = response.getWriter();
        out.println("<title>CalcServlet</title>");

        try {
            double one = Double.parseDouble(request.getParameter("one"));
            double two = Double.parseDouble(request.getParameter("two"));
            String operation = request.getParameter("operation");

            HttpSession session = request.getSession(true);
            request.getServletContext().setAttribute("obj", new TestObject("NewName"));


            OperationType operationType = OperationType.valueOf(operation.toUpperCase());
            double result = calcResult(operationType, one, two);
            ArrayList<String> listOperation;

            if (session.isNew()) {
                listOperation = new ArrayList<>();
//                listOperation.clear();
            } else {
                listOperation = (ArrayList<String>) session.getAttribute("formula");
            }

            listOperation.add(one + " " + operationType.getValue() + " "
                    + two + " = " + result);
            session.setAttribute("formula", listOperation);

            out.println("<table cellpadding=\"20\">");
            out.println("<tr>");
            out.println("<td>");

            out.println("<h2>Id сессии: " + session.getId() + "</h2>");
//            out.println("<h2>Кол-во операций: " + listOperation.size() + "</h2>");

            for (String s : listOperation) {
                out.println("<h3>" + s + "</h2>");
            }
            out.println("</td>");
            sessionMap.put(session.getId(), listOperation);
            this.getServletContext().setAttribute("sessionMap", sessionMap);
            out.println("<td>");
            for (Map.Entry<String, List> entry : sessionMap.entrySet()) {
                List listOper = entry.getValue();
                out.println("<h2>Id сессии: " + entry.getKey() + "</h2>");
                for (Object s : listOper) {
                    out.println("<h3>" + s + "</h2>");
                }
            }
            out.println("</td>");
            out.println("</tr>");
            out.println("</table>");
        } catch (Exception e) {
//            out.println("<h3 style=\"color:red\">Ошибка</h3>");
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
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
