package ru.sample.forum;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;

import java.sql.DriverManager;

import java.util.Properties;

import java.util.TreeSet;

import javax.ejb.EJB;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

import javax.servlet.*;
import javax.servlet.http.*;

import javax.sql.DataSource;

import ru.sample.model.ForumWork;
import ru.sample.model.entity.Person;

public class LoginCheck extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
    @EJB
    private ForumWork f;
    
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException,
                                                            IOException {
        String user = "";
        String password = "";
        try {
            user = request.getParameter("user");
            password = request.getParameter("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>LoginCheck</title></head>");
        out.println("<body>");
//        HttpSession sess= request.getSession(true);
//
//          out.println("<br/>--------------------------------------------");
//          out.println("<br/>" + sess.getId());
//            
//
//        out.println("<p>The servlet has received a POST. This is the reply.</p>");
//        out.println("<br/>" + user + " / " + password);
////          Переменная типа Context для доступа к JNDI
        Context ctx = null;
        Connection conn = null;
        try {
//            Получаем доступ к контексту JNDI, для связи и БД
//          ctx = new InitialContext();
//            Контекст содуржит дерево имен, чтобы их прочитать, обращаемся к корню ""
//          NamingEnumeration ne = ctx.list("");
//            Печатаем имена, опубликованные в этом контексте
//          while (ne.hasMoreElements()){
//              out.println("<br/>" + ne.nextElement());
//          }
//          conn = ((DataSource) ctx.lookup("jdbc/test_db")).getConnection(user,password);
//          Properties connInfo = new Properties();
// Кодировка Cp866
//          connInfo.put("user",user);
//          connInfo.put("password", password);
//          conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", connInfo);
//          out.println("----------------------------------------------------");
//          out.println("<br/> EJB ForumWork interface: " + f.getPerson(user,password));
//          out.println("<br/>----------------------------------------------------");
            Person p = f.getPerson(user, password);
// Получаем атрибут persons и проверяем принадлежит ли ему p            
            TreeSet a = (TreeSet)this.getServletContext().getAttribute("persons");
            if (a.contains(p)) {
                throw new Exception ("В форуме двойник");
            } else {
                a.add(p);
            request.getSession().setAttribute("person", p);
            response.sendRedirect("start");
            }
//          out.println("<br/>" + conn.getMetaData().getDatabaseProductName() + "  " + conn.getMetaData().getDatabaseProductVersion());
            
//          Создаем в глобальном контексте каталог myvar и переменную counter и присваиваем ей значение 0 типа long
//          Создаем в глобальном контексте переменную counter и присваиваем ей значение 0 типа long  
//          try {
//                ctx.bind("counter", 1L);
////            Exception будет, если такая переменная есть, тогда заменим ее
//            } catch (Exception exx) {
//                ctx.rebind("counter", ((Long)ctx.lookup("counter")) + 1);
//            }
//          out.println("<br/>");
//          out.println("----------------------------------------");
//            out.println(ctx.lookup("counter"));
//          out.println("<br/>");
//          out.println("----------------------------------------");  
//          out.println("<br/>");
//            java:comp/env - ЛОКАЛЬНЫЙ environment контекст JNDI любого приложения на сервере приложений
//            В этот контекст можно поместить нужную информацию
//          ne = ctx.list("java:comp/env");
//          while (ne.hasMoreElements()){
//            out.println("<br/>" + ne.nextElement());
//          }  
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
            request.setAttribute("error1", "Ошибка, вы не авторизованы: " + e.getMessage() + " " + user + "/" + password);
            request.getRequestDispatcher("error").forward(request, response);
//            response.sendRedirect("error");
            return;            
        } 
// finally {
//            try {
//                conn.close();
//            } catch (Exception e) {
//                // TODO: Add catch code
//                e.printStackTrace();
//            }
//            try {
//                ctx.close();
//            } catch (Exception ne) {
//                // TODO: Add catch code
//                ne.printStackTrace();
//            }
//        }
        out.println("</body></html>");
        out.close();
    }
}
