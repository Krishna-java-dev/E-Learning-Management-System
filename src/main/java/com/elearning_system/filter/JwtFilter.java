package com.elearning_system.filter;

import com.elearning_system.util.JwtUtil;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtFilter implements Filter {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String path = req.getRequestURI();

        // allow login/register
        if (path.contains("/auth")) {
            chain.doFilter(request, response);
            return;
        }

        String token = req.getHeader("Authorization");

        try {
            if (token == null || token.isEmpty()) {
                res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                res.getWriter().write("Missing Token");
                return;
            }

            jwtUtil.extractEmail(token);

        } catch (Exception e) {
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            res.getWriter().write("Invalid Token");
            return;
        }

        chain.doFilter(request, response);
    }
}