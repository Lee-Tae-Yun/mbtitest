package cs.mbti;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class Login_fileupdateService implements A_mbtiService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//값 가져오기
		String id = request.getParameter("id3");
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
	   	System.out.printf("%s,%s",filename,id);
	   	dao.Pro_update(filename,id);
	   	
	   	
	   	
	   	

	}

}