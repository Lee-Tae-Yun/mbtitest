package cs.mbti;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login_deleteService implements A_mbtiService{
	//회원탈퇴
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		String id2 = (String)session.getAttribute("id");
		MbtiDao dao = new MbtiDao();
		dao.delete(id2);
		session.invalidate();
		}

}