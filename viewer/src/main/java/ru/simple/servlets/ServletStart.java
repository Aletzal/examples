package ru.simple.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Admin on 06.07.17.
 */
@WebServlet(urlPatterns = "/servletstart", name = "ServletStart")
public class ServletStart extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
    private String name = "";
    private String pass = "";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            name = request.getParameter("name");
            pass = request.getParameter("password");
        } catch (Exception e){
            System.out.println(e);
        }

        response.setContentType(CONTENT_TYPE);
//        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("Servlet Start");
        out.println("Введенное имя = <b>" + name + "</b> Введенный пароль = <b>" + pass + "</b>");
        out.println("</body></html>");
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
