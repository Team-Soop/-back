package com.team_soop.soop.security.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class PermitAllFilter extends GenericFilter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 이 주소 단어들이 포함되어있으면
        // isPermitAll true
        // 이 주소 외 단어들
        // isPermitAll false
        List<String> antMatchers = List.of(
                "/login",
                "/error",
                "/server",
                "/auth",
                "/oauth2",
                "/mail/authenticate"
        );

        String uri = request.getRequestURI();
        request.setAttribute("isPermitAll", false);

        for(String antMatcher : antMatchers) {
            if(uri.startsWith(antMatcher)) {
                request.setAttribute("isPermitAll", true);
            }
        }

        filterChain.doFilter(request, response);

    }
}
