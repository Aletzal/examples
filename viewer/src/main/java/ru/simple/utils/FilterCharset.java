package ru.simple.utils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * Created by Admin on 06.07.17.
 */
@WebFilter(
        urlPatterns = "/*",
        filterName = "FilterCharset",
        description = "Filters encoding of all pages",
        initParams = {
                @WebInitParam(name = "codepage", value = "UTF8")
        }
)
public class FilterCharset implements Filter {
    private FilterConfig _filterconfig = null;
    public void destroy() {
        _filterconfig = null;
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        chain.doFilter(req, resp);
        req.setCharacterEncoding(_filterconfig.getInitParameter("codepage"));
        chain.doFilter(req,resp);
    }

    public void init(FilterConfig config) throws ServletException {
        _filterconfig = config;
    }

}
