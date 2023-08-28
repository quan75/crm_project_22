package crm_project_22a_repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import crm_project_22a_config.MysqlConfig;
import crm_project_22a_entity.LoaiThanhVien;

public class LoaiThanhVienRepository {

	public int insert(String ten, String mota) {
		int count = 0;
		String query = "INSERT INTO LoaiThanhVien (ten, mota) VALUES(?, ?)";
		Connection connection = MysqlConfig.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, ten);
			statement.setString(2, mota);
			
			count = statement.executeUpdate();
		}catch (Exception e) {
			System.out.println("Lỗi thêm dữ liệu " + e.getLocalizedMessage());
		}
		return count;
	}
	
	public List<LoaiThanhVien> getAllLoaiThanhVien() {
		List<LoaiThanhVien> list = new ArrayList<LoaiThanhVien>();
		
		String query = "SELECT * FROM LoaiThanhVien ltv";
		Connection connection = MysqlConfig.getConnection();
		try {
			PreparedStatement  statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				LoaiThanhVien loaiThanhVien = new LoaiThanhVien();
				loaiThanhVien.setId(resultSet.getInt("id"));
				loaiThanhVien.setTen(resultSet.getString("ten"));
				loaiThanhVien.setMota(resultSet.getString("mota"));
				
				list.add(loaiThanhVien);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (Exception e2) {
				
			}
		}
		
		return list;
	}
	
	public int deleteById(int id) {
		int count = 0;
		String query = "DELETE FROM LoaiThanhVien WHERE id = ?";
		
		Connection connection = MysqlConfig.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			
			count = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
}
