package ru.sample.forum;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Date;

import java.sql.Timestamp;

import javax.ejb.EJB;

import javax.servlet.*;
import javax.servlet.http.*;

import ru.sample.model.ForumWork;
import ru.sample.model.entity.Messages;
import ru.sample.model.entity.Person;

public class InsertMessage extends HttpServlet {
    
    @EJB
    private ForumWork f;
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException,
                                                            IOException {
        String text = "";
        try {
            text = request.getParameter("text");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Messages m = new Messages();
        m.setNick(((Person)request.getSession().getAttribute("person")).getId());
        m.setData(""+new Date(System.currentTimeMillis()));
        m.setText(text);
        m.setD(new Timestamp(System.currentTimeMillis()));
        f.persistMessages(m);
        request.getRequestDispatcher("start").forward(request, response);
    }
}
