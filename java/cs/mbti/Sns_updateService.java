package cs.mbti;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sns_updateService implements A_mbtiService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int sid = Integer.parseInt(request.getParameter("sid"));
	  	MbtiDao dao = new MbtiDao();
	  	dao.updateReadCheck(sid);
		
	}

}
