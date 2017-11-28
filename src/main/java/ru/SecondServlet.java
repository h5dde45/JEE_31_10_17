package ru;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class SecondServlet extends HttpServlet {

    int count;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println(config.getInitParameter("initParam"));
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        count++;
        request.getSession().setAttribute("count",count);

        try (PrintWriter out = response.getWriter()) {
            Enumeration<String> parameterNames = request.getParameterNames();

            while (parameterNames.hasMoreElements()){
                String param = parameterNames.nextElement();
                out.println("<h4>" + param+" = "+
                        request.getParameter(param)+ "</h4>");
            }
            out.println("<h4>" + request.getSession().getAttribute("count")+ "</h4>");
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }
}
