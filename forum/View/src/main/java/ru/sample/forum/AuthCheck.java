package ru.sample.forum;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Date;

import javax.ejb.EJB;

import javax.servlet.*;
import javax.servlet.http.*;

import ru.sample.model.ForumWork;

public class AuthCheck extends HttpServlet {
//      private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
//    Обьявляем переменную типа ForumWorkдля доступа к сообщениям
    @EJB        
    private ForumWork f;
    
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void service(HttpServletRequest request,
                        HttpServletResponse response) throws ServletException,
                                                             IOException {
//      response.setContentType(CONTENT_TYPE);
//      PrintWriter out = response.getWriter();
//      out.println("<html>");
//      out.println("<head><title>AuthCheck</title></head>");
//      out.println("<body>");
//      out.println("<p>AUTH_CHECK: The servlet has received a POST or GET. This is the reply.</p>");
//      out.println("</body></html>");
// Returns the current HttpSession associated with this request or, if there is no current session and create is true, returns a new session.
      HttpSession sess= request.getSession(true);
      if (sess.getAttribute("person") != null) {
// request - перенаправление происходит на стороне сервера приложений, response - на стороне браузера
//        Получаем список List содержащий 10 обьектов Messages
        request.setAttribute("top10", f.getTopTen());
        request.getRequestDispatcher("info.jsp").forward(request, response);
//          response.sendRedirect("info");        
      } else {
        request.getRequestDispatcher("login.html").forward(request, response);
//          response.sendRedirect("login.html");
      }
//      out.println("<br/> Session id = " + sess.getId());
//      out.println("<br/> Session created time = " + new Date(sess.getCreationTime()));
//      out.println("<br/> Last access time = " + new Date(sess.getLastAccessedTime()));
//      out.println("<br/> Session isNew = " + sess.isNew());
//      out.close();
    }
}

















