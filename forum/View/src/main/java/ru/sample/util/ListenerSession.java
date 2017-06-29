package ru.sample.util;

import java.util.TreeSet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
// Следит за сессией, за созданием и уничтожением сессии
public class ListenerSession implements HttpSessionListener {
    private HttpSession session = null;

    public void sessionCreated(HttpSessionEvent event) {
        session  = event.getSession();
    }

    public void sessionDestroyed(HttpSessionEvent event) {
        try {
            session = event.getSession();
            ((TreeSet)session.getServletContext().getAttribute("persons")).remove(session.getAttribute("person"));
        } catch (Exception e) {
        }
    }
}
