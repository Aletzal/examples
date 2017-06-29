package ru.sample.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Filter1 implements Filter {
    private FilterConfig _filterConfig = null;

    public void init(FilterConfig filterConfig) throws ServletException {
        _filterConfig = filterConfig;
    }

    public void destroy() {
        _filterConfig = null;
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException,
                                                   ServletException {
//    При создании фильтра было указано /*, значит перед всеми сервлетами запрос проходит через фильтр
//    и мы устанавливаем кодировку UTF8, чтобы сервлеты работали с этой кодировкой, т.к. JVM использует кодировку UTF16
        request.setCharacterEncoding(_filterConfig.getInitParameter("codepage"));
        chain.doFilter(request, response);
    }
}
