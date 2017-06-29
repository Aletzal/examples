package ru.sample.forum;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Date;

import java.util.TreeSet;

import javax.servlet.*;
import javax.servlet.http.*;

public class Start extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("-----=====>>>>>)))))}}}}}" + new Date());
// Добавим в контекст приложения атрибут persons, содержащий дерево уникальных наборов объектов (для проверки объектов типа Person)
        this.getServletContext().setAttribute("persons", new TreeSet());
    }

    public void service(HttpServletRequest request,
                        HttpServletResponse response) throws ServletException,
                                                             IOException {

      //  getRequestDispatcher(arg0) - ���������� ���������, ������� ��������� ������� � �������        
            request.getRequestDispatcher("authcheck").forward(request, response);
    }
}
