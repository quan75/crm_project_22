package crm_project_22a_api;

import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;

import crm_project_22a_entity.LoaiThanhVien;
import crm_project_22a_payload.response.BaseResponse;
import crm_project_22a_service.RoleService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "apiRoleController", urlPatterns = {"/api/role/deleted"})
public class ApiRoleController extends HttpServlet{
	
	private Gson gson = new Gson();
	private RoleService roleService = new RoleService();
	
	// Thêm, Xóa, Sữa, Lấy dữ liệu
	// POST: thêm dữ liệu
	// DELETE: xóa dữ liệu
	// GET: lấy dữ liệu
	// PUT: Update dữ liệu
	
//	@Override
//	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		super.doDelete(req, resp);
//	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		
		boolean isSuccess = roleService.deleteRoleById(id);
		
		BaseResponse response = new BaseResponse();
		response.setStatusCode(200);
		response.setMessage(isSuccess ? "Xóa thành công" : "Xóa thất bại");
		response.setData(isSuccess) ;
		
		String json = gson.toJson(response);
//		String json = "{\"id\":2,\"ten\":\"ADMIN\",\"mota\":\"Test dữ liệu\"}";
//		
//		LoaiThanhVien loaiThanhVien = gson.fromJson(json, LoaiThanhVien.class);
		
//		LoaiThanhVien loaiThanhVien = new LoaiThanhVien();
//		loaiThanhVien.setId(2);
//		loaiThanhVien.setMota("Test dữ liệu json");
//		loaiThanhVien.setTen("ADMIN");
		
//		String dataJSON = gson.toJson(loaiThanhVien);
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		
		out.print(json);
		out.flush();
		
	}
}
