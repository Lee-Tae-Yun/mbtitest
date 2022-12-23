package cs.mbti;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Comment_deleteService implements A_mbtiService{
	//댓글 삭제
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int cnum = Integer.parseInt(request.getParameter("cnum"));
		MbtiDao dao = new MbtiDao();
		dao.cdelete(cnum);
	}
	//게시물로 가기
}
