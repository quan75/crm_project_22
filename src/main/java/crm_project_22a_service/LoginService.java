package crm_project_22a_service;

import java.util.List;

import crm_project_22a_entity.NguoiDung;
import crm_project_22a_repository.NguoiDungRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

/**
 * Tên class của Service phải thể hiện nó xử lý logic code cho Controller nào
 * ví dụ: LoginController thì sẽ có LoginService
 * Tên hàm trong Service phải đặt gợi nhớ tới tính năng đang xử lý
 */
public class LoginService {
	
	private NguoiDungRepository nguoiDungRepository = new NguoiDungRepository();
	
	public boolean checkLogin(HttpServletRequest request, String email, String password) {
		List<NguoiDung> listNguoiDung = nguoiDungRepository.findByEmailAndPassword(email, password);
		if(listNguoiDung.size() > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("roleName", listNguoiDung.get(0).getLoaiThanhVien().getTen());
		}
		
		return listNguoiDung.size() > 0;
	}
}
