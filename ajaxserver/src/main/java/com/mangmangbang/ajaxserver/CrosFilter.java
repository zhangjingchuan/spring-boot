package com.mangmangbang.ajaxserver;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * created by zhangjingchuan on 2020/1/14
 */
public class CrosFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse rep = (HttpServletResponse) servletResponse;

        rep.setHeader("Access-Control-Allow-Origin","http://localhost:8081");
        rep.setHeader("Access-Control-Allow-Method","GET");
        rep.setHeader("Access-Control-Allow-Headers","Content-Type");
        rep.setHeader("Access-Control-Max-Age","3600");

        filterChain.doFilter(servletRequest,servletResponse);
    }
}