package cs.mbti;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sns_insertService implements A_mbtiService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String fid = request.getParameter("fid");
		String tid = request.getParameter("tid");
		String stitle = request.getParameter("stitle");
		String content = request.getParameter("content");
		  // 현재 날짜/시간
        LocalDateTime now = LocalDateTime.now();
        // 포맷팅
        String sdate = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        
        MbtiDao dao = new MbtiDao();
        SnsDto dto = new SnsDto(null,fid,tid,stitle,content,0,sdate);
        dao.sinsert(dto);
	}

}
