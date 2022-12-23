package cs.mbti;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Comment_insertService implements A_mbtiService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		

		MbtiDao dao = new  MbtiDao();

		HttpSession session = request.getSession();
		String id2 = (String)session.getAttribute("id");
	   	request.setCharacterEncoding("utf-8");
	   	LoginDto dtos = dao.readDate(id2);
	   	int bid = Integer.parseInt(request.getParameter("no"));
	   	BoardDto dtoss = dao.readBDate(bid);
	    // 현재 날짜/시간
        LocalDateTime now = LocalDateTime.now();
        // 포맷팅
        String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
	   	//클라이언트에서 전달된 데이터
	   	String cnum = "";
	   	String uid = id2;
	   	String cbid = request.getParameter("no"); 
	   	String cname = dtos.getName();
	   	String cmt  = request.getParameter("comment");
	   	String chacter = dtos.getChacter();
	   	String cdate = formatedNow;
	   
	   CommentDto dto = new CommentDto(cnum,uid,cbid,cname,cmt,chacter,cdate);
	   dao.insertC(dto);

	}

}
