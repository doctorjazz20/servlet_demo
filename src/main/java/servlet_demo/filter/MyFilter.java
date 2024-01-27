package servlet_demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(servletNames = {"FIRST_SERVLET", "COOKIE_SERVLET"})
public class MyFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("MyFilter initialized");
	}

	@Override
	public void destroy() {
		System.out.println("MyFilter destroyed");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("before request ");
		chain.doFilter(request, response);
		System.out.println("after request");
		
	}

}
