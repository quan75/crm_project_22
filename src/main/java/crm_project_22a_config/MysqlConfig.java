package crm_project_22a_config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConfig {
	
	//Tạo kết nối với CSDL
		public static Connection getConnection() {
			Connection connection = null;
			//Khai báo driver sử dụng dành cho CSDL tương ứng
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/crm", "root", "011092");
//				System.out.println("Kết nối thành công");
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println("Lỗi kết nối CSDL " + e.getLocalizedMessage());
				e.printStackTrace();
			}
			
			return connection;
		}
}
