package ru.sample.forum;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

public class LogOff extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=windows-1251";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void service(HttpServletRequest request,
                        HttpServletResponse response) throws ServletException,
                                                             IOException {
        request.getSession().invalidate();
        response.sendRedirect("start");
    }
}
