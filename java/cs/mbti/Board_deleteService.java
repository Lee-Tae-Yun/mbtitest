package cs.mbti;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Board_deleteService implements A_mbtiService{
	//게시판 삭제
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String bid = request.getParameter("bid");
		MbtiDao dao = new MbtiDao();
		dao.bdelete(bid);
	}
	//게시판으로 돌아가기

}
