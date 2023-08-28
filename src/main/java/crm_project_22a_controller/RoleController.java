package crm_project_22a_controller;

import java.io.IOException;

import crm_project_22a_service.RoleService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "roleController", urlPatterns = {"/role", "/role-add"})
public class RoleController extends HttpServlet{
	
	private RoleService roleServive = new RoleService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		
		switch (path) {
		
			case "/role":
				req.getRequestDispatcher("role-table.jsp").forward(req, resp);
				break;	
				
			case "/role-add":
				
				req.getRequestDispatcher("role-add.jsp").forward(req, resp);
				break;	
				
			default:
				break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		
		switch (path) {
			case "/role-add":
				String tenQuyen = req.getParameter("tenQuyen");
				String mota = req.getParameter("moTa");
				boolean isSuccess = roleServive.insert(tenQuyen, mota);
				req.setAttribute("isSuccess", isSuccess);
				req.getRequestDispatcher("role-add.jsp").forward(req, resp);
				break;	
				
			default:
				break;
		}
		
		
	}
}
