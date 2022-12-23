package cs.mbti;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class Login_insertService implements A_mbtiService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		   //클라이언트에서 전달된 데이터
		   String id = request.getParameter("id");
		   String pwd = request.getParameter("pwd");
		   String name = request.getParameter("name");
		   String chacter = request.getParameter("chacter");
		   String udate = request.getParameter("udate");
		   String pNumber = request.getParameter("pNumber");
		   String email = request.getParameter("email");
		   String gender = request.getParameter("gender");
		   String filename = null;
		   String dir = null;
		   
		   String contentType = request.getContentType();
			System.out.println("contetType :"+contentType);
			
			if (contentType != null && contentType.startsWith("multipart/")) {
				dir = request.getServletContext().getRealPath("profile");
				System.out.println("dir :"+dir);
			}
			File f = new File(dir);
			if(f.exists())
				f.mkdir();
			
			Collection<Part> parts = request.getParts();
			
			for(Part p : parts) {
				if(p.getHeader("Content-Disposition").contains("filename=")) {
					if(p.getSize()>0) {
						filename = p.getSubmittedFileName();
						String filepath = dir + File.separator + filename;
						p.write(filepath);
						p.delete();
						
						System.out.println("filepath :"+filepath);
					}
				}
			}
		   
		   
		   MbtiDao dao = new MbtiDao();
		   LoginDto dto = new LoginDto(id, pwd, name, chacter, udate, pNumber, email, gender,filename);
		   dao.insert(dto);
		   
		   try {
		        response.setContentType("text/html; charset=utf-8");
		        PrintWriter w = response.getWriter();
		        w.write("<script>alert('회원가입을 축하드립니다!!!');location.href='index.do';</script>");
		        w.flush();
		        w.close();
		    } catch(Exception e) {
		        e.printStackTrace();
		    }

	}

}