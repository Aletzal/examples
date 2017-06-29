package ru.sample.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnectionFactory;

import javax.naming.Context;

import javax.naming.InitialContext;

import javax.naming.NamingException;

import javax.servlet.*;
import javax.servlet.http.*;

public class Report extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=UTF-8";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void service(HttpServletRequest request,
                        HttpServletResponse response) throws ServletException,
                                                             IOException {
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>report</title></head>");
        out.println("<body>");
//        out.println("<p>The servlet has received a POST or GET. This is the reply.</p>");
//        
        Context ctx = null;
        TopicConnectionFactory factory = null;
        Topic topic = null;
        Connection conn = null;
        Session sess = null;
        MessageProducer prod = null;
        try{
            ctx = new InitialContext();
            factory = (TopicConnectionFactory)ctx.lookup("jms/TopicFactory");
            topic = (Topic)ctx.lookup("jms/ForumTopic");
//            out.println("<br/>" + factory);
//            out.println("<br/>" + topic);
            conn = factory.createConnection();
            sess = conn.createSession(false,Session.AUTO_ACKNOWLEDGE);
            prod = sess.createProducer(topic);
            TextMessage m = sess.createTextMessage("" + 10);
//////            ObjectMessage m = sess.createObjectMessage(new String("qqqqq"));
////            ObjectMessage m = sess.createObjectMessage();
//////            m.setObject(new String("sssss"));
////            m.setObject(new A1());
            prod.send(m);
            out.println("<br/>Отчет в работе");
            
          } catch (Exception ex) {
          out.println("<br/>Error================" + ex);
          } finally {
            try {
              prod.close();
            } catch (Exception e) {
              
            }
            try {
              sess.close();
            } catch (Exception e) {
              
            }
            try {
              conn.close();
            } catch (Exception e) {
              
            }
            try {
              ctx.close();
            } catch (Exception e) {
              
            }
          }
//        
        
        
        out.println("</body></html>");
        out.close();
    }
}
// on JSP page
//  <%@page import="ru.sample.util.Report"%>
//  <%= Report.getValue() %>

