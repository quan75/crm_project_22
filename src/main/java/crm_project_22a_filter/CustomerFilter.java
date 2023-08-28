package crm_project_22a_filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter(filterName = "customerFilter", urlPatterns = {"role-add"})
public class CustomerFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		String path = servletRequest.getServletPath();
		HttpSession session = servletRequest.getSession();
		String roleName = (String) session.getAttribute("roleName");
		String contextPath = servletRequest.getContextPath();
		
		switch (path) {
			case "/role-add":
				if(roleName != null && roleName.toUpperCase().equals("ADMIN")) {
					chain.doFilter(servletRequest, response);
				}else {
					servletResponse.sendRedirect(contextPath + "/");
				}
				break;
	
			default:
				break;
		}
	}
	
}
