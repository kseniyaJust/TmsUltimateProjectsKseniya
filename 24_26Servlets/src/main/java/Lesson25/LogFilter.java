package Lesson25;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.time.LocalDateTime;

@WebFilter("/books/*")
public class LogFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest  hsr= (HttpServletRequest) servletRequest;
        System.out.println("LogFilter: " + hsr.getRequestURI()+ " " + LocalDateTime.now());
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
