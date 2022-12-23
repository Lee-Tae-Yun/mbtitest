package cs.mbti;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Board_updateService implements A_mbtiService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		  // 현재 날짜/시간
        LocalDateTime now = LocalDateTime.now();
        // 포맷팅
        String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

		//값 가져오기
		String bid = request.getParameter("bid");
		String ch4 = request.getParameter("ch4");
	   	String btitle = request.getParameter("btitle");
	   	String borad = request.getParameter("borad");
	   	String bdate = formatedNow;
	   	
		
	   	MbtiDao dao = new MbtiDao();
	   	dao.bupdate(btitle, borad, bdate, bid);
		
	}

}
