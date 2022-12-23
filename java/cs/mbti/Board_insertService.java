package cs.mbti;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Board_insertService implements A_mbtiService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		MbtiDao dao = new MbtiDao();
		HttpSession session = request.getSession();
		String id2 = (String)session.getAttribute("id");
	   	request.setCharacterEncoding("utf-8");
	   	LoginDto dtos = dao.readDate(id2);	
	   	Date from = new Date();SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");String to = transFormat.format(from);
	   	//클라이언트에서 전달된 데이터
	   	String bid = "";
	   	String boradtype = dtos.getChacter();
	   	String btitle = request.getParameter("btitle");
	   	String borad = request.getParameter("borad");
	   	String bname = dtos.getName();
	   	String bdate = to;
	   	int boradview = 0;
	   	String uid = id2;
	   	BoardDto dto = new BoardDto(bid,uid,boradtype,btitle,borad,bname,bdate,boradview);
	   	dao.insertB(dto);

	}

}
