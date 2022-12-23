package cs.mbti;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCService implements A_mbtiService{
	//로그인 체크 
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//한글처리 
		request.setCharacterEncoding("utf-8");
		//값 가져오기
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		//DB연동 으로 테이블에서 가져온 ID와 PWD가 일치하는지 판별
		MbtiDao dao = new MbtiDao();
		int check = dao.checkUser(id, pwd);
		LoginDto dtos = dao.readDate(id);
		
		if (check == 1){
			String name = dtos.getName();
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			session.setAttribute("name",name);
			
			try {
		        response.setContentType("text/html; charset=utf-8");
		        PrintWriter w = response.getWriter();
		        w.write("<script>alert('로그인성공!!!');location.href='index.do';</script>");
		        w.flush();
		        w.close();
		    } catch(Exception e) {
		        e.printStackTrace();
		    }

		}
		else{
			try {
		        response.setContentType("text/html; charset=utf-8");
		        PrintWriter w = response.getWriter();
		        w.write("<script>alert('아이디또는 비밀번호가 틀렸습니다!!!');location.href='Login.do';</script>");
		        w.flush();
		        w.close();
		    } catch(Exception e) {
		        e.printStackTrace();
		    }

		}
	
	}
	

}
