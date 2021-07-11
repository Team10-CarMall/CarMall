package com.team10.user.annotation;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.team10.util.TokenUtils.checkToken;

@WebFilter(urlPatterns = {"/commodity/index.html"}, filterName = "LoginFilter")
public class LoginFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String token = request.getHeader("token");
        if (token == null && checkToken()) {
            String location = "/user/login";
            response.sendRedirect(location);
            System.out.println("成功拦截");
        } else {
            chain.doFilter(request, response);
        }
    }

    public void init(FilterConfig arg0) throws ServletException {

    }
}