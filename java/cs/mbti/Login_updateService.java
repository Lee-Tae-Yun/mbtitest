package cs.mbti;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

public class Login_updateService implements A_mbtiService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//값 가져오기
		String id = request.getParameter("id");
	   	String pwd = request.getParameter("pwd");
	   	String name = request.getParameter("name");
	   	String chacter = request.getParameter("chacter");
	   	String udate = request.getParameter("udate");
	   	String pNumber = request.getParameter("pNumber");
	   	String email = request.getParameter("email");
	   	String gender = request.getParameter("gender");
	   	String filename = request.getParameter("filename");
		
	   	MbtiDao dao = new MbtiDao();
	   	LoginDto dto = new LoginDto(id,pwd, name, chacter, udate, pNumber, email, gender,filename);
	   	dao.update(dto);
	   	
	   	try {
	        response.setContentType("text/html; charset=utf-8");
	        PrintWriter w = response.getWriter();
	        w.write("<script>alert('회원 정보수정완료!!!');location.href='LoginUpdate.do';</script>");
	        w.flush();
	        w.close();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }

	}

}