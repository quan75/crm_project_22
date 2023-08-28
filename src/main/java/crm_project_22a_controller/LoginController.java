package crm_project_22a_controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import crm_project_22a_config.MysqlConfig;
import crm_project_22a_entity.NguoiDung;
import crm_project_22a_service.LoginService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "loginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet{
	
	private LoginService loginService = new LoginService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String matkhau = req.getParameter("password");
		
		boolean isSuccess = loginService.checkLogin(req, email, matkhau);
		
		if(isSuccess) {
			System.out.println("Đăng nhập thành công");
		}else {
			System.out.println("Đăng nhập thất bại");
		}
		
		req.getRequestDispatcher("login.jsp").forward(req, resp);
		
		
		//		//Nhận tham số
//		String email = req.getParameter("email");
//		String matkhau = req.getParameter("password");
//		
//		//Chuẩn bị câu query
//		String query = "SELECT *\n"
//				+ "FROM NguoiDung nd\n"
//				+ "WHERE nd.email = ? AND nd.matkhau = ?";
//		
//		//Mở kết nối tới CSDL
//		Connection connection = MysqlConfig.getConnection();
//		List<NguoiDung> listNguoiDung = new ArrayList<NguoiDung>();
//		
//		
//		try {
//			//Truyền câu query vào Connection
//			PreparedStatement statement = connection.prepareStatement(query);
//			//Truyền giá trị tham số vào câu query nếu có
//			statement.setString(1, email);
//			statement.setString(2, matkhau);
//			
//			//Thực thi câu query
//			/**
//			 * excecuteQuery: Khi câu truy vấn là lấy dữ liệu SELECT
//			 * executeUpdate: Không phải là câu lấy dữ liệu. INSERT, DELETE, UPDATE....
//			 */
//			 ResultSet resultSet = statement.executeQuery();
//			 
//			 //Duyệt dữ liệu từ resultSet
//			 while(resultSet.next()) {
//				 NguoiDung nguoiDung = new NguoiDung();
////				 resultSet.getInt("id"); //Lấy giá trị của cột id trong CSDL khi duyệt qua từng dòng
//				 nguoiDung.setId(resultSet.getInt("id"));
//				 nguoiDung.setFullname(resultSet.getString("fullname"));
//				 nguoiDung.setEmail(resultSet.getString("email"));
//				 
//				 listNguoiDung.add(nguoiDung);
//			 }
//			 
//			 if(listNguoiDung.size() > 0) {
//				 System.out.println("Đăng nhập thành công");
//			 }else {
//				 System.out.println("Đăng nhập thất bại");
//			 }
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Lỗi thực thi câu query " + e.getLocalizedMessage());
//		} finally {
//			if(connection != null) {
//				try {
//					connection.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					System.out.println("Lỗi đóng kết nối " + e.getLocalizedMessage());
//				}
//			}
//		}
		
		
//		PrintWriter printWriter = resp.getWriter();
//		printWriter.write("Hello");
//		printWriter.close();
	}
}
