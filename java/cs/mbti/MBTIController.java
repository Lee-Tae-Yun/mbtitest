package cs.mbti;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@MultipartConfig(maxFileSize = 10*1024*1024)
@WebServlet("*.do")
public class MBTIController extends HttpServlet {
	   private static final long serialVersionUID = 1L;
	    
	    protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	       request.setCharacterEncoding("utf-8");
	       String viewPage = null;
	       
	       String uri = request.getRequestURI();
	       String com = uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf(".do"));
	       //화면 부분 ---------------------------------
	       //메인페이지
	       if(com != null && com.trim().equals("MBTI")) {
	     	   viewPage = "/WEB-INF/view/MBTI.html";
	        }
	       else if(com != null && com.trim().equals("index")) {
	     	   viewPage = "/WEB-INF/view/index.jsp";
	        }
	       //로그인
	       else if(com != null && com.trim().equals("Login")) {
	     	   viewPage = "/WEB-INF/view/Login.jsp";
	        }
	       //회원가입 
	       else if(com != null && com.trim().equals("SignUp")) {
	     	   viewPage = "/WEB-INF/view/SignUp.jsp";
	        }
	       //마이페이지 
	       else if(com != null && com.trim().equals("LoginUpdate")) {
	     	   viewPage = "/WEB-INF/view/LoginUpdate.jsp";
	        }
	       //게시판 
	       else if(com != null && com.trim().equals("Board")) {
	     	   viewPage = "/WEB-INF/view/Board.jsp";
	        }
	       //로그아웃 팝업 
	       else if(com != null && com.trim().equals("LogOutPop")) {
	     	   viewPage = "/WEB-INF/view/LogOutPop.jsp";
	        }
	       //메시지
	       else if(com != null && com.trim().equals("Sns")) {
	     	   viewPage = "/WEB-INF/view/Sns.jsp";
	       }
	       //메시지 입력 
	       else if(com != null && com.trim().equals("SInsert")) {
	     	   viewPage = "/WEB-INF/view/SInsert.jsp";
	       }
	       //검사해석
	       else if(com != null && com.trim().equals("Tran")) {
	     	   viewPage = "/WEB-INF/view/Tran.jsp";
	        }
	       //로그인 팝업 
	       else if(com != null && com.trim().equals("LoginPop")) {
	     	   viewPage = "/WEB-INF/view/LoginPop.jsp";
	        }
	       //프로필사진 변경
	       else if(com != null && com.trim().equals("profile")) {
	     	   viewPage = "/WEB-INF/view/profile.jsp";
	        }
	       
	       //MBTI 검사지
	       else if(com != null && com.trim().equals("MTest")) {
	     	   viewPage = "/WEB-INF/view/MTest.jsp";
	        }
	       //게시판 입력
	       else if(com != null && com.trim().equals("BInsert")) {
	     	   viewPage = "/WEB-INF/view/BInsert.jsp";
	        }
	       //한개의 게시물 상세 조회
	       else if(com != null && com.trim().equals("BOneList")) {
	     	   viewPage = "/WEB-INF/view/BOneList.jsp";
	        }
	       //게시글 수정
	       else if(com != null && com.trim().equals("BUpdate")) {
	     	   viewPage = "/WEB-INF/view/BUpdate.jsp";
	        }
	       //회원탈퇴
	       else if(com != null && com.trim().equals("Drop")) {
	     	   viewPage = "/WEB-INF/view/Drop.jsp";
	        }
	       //회원리스트 
	       else if(com != null && com.trim().equals("LoginList")) {
	     	   viewPage = "/WEB-INF/view/LoginList.jsp";
	        }
	       //MBTI 검사결과 
	       else if(com != null && com.trim().equals("Result")) {
	     	   viewPage = "/WEB-INF/view/Result.jsp";
	        }
	       //로그인확인 팝업 
	       else if(com != null && com.trim().equals("LoginPop")) {
	     	   viewPage = "/WEB-INF/view/LoginPop.jsp";
	        }
	       //보낸 메시지함 
	       else if(com != null && com.trim().equals("SnsGiveList")) {
	     	   viewPage = "/WEB-INF/view/SnsGiveList.jsp";
	        }
	       //받은 메시지함 
	       else if(com != null && com.trim().equals("SnsGetList")) {
	     	   viewPage = "/WEB-INF/view/SnsGetList.jsp";
	        }
	       //메시지 상세보기 
	       else if(com != null && com.trim().equals("SOneList")) {
	     	   viewPage = "/WEB-INF/view/SOneList.jsp";
	        }
	       
	       //서비스 부분----------------------------------------------------
	       //게시글 추가
	       else if(com != null && com.trim().equals("B_insert")) {
	     	   A_mbtiService sevice = new Board_insertService();
	     	   sevice.execute(request,response);
	     	   viewPage = "Board.do";
	        }
	       //게시글 수정
	       else if(com != null && com.trim().equals("B_update")) {
	     	   A_mbtiService sevice = new Board_updateService();
	     	   sevice.execute(request,response);
	     	   viewPage = "BOneList.do";
	        }
	       //게시글 삭제
	       else if(com != null && com.trim().equals("B_delete")) {
	     	   A_mbtiService sevice = new Board_deleteService();
	     	   sevice.execute(request,response);
	     	   viewPage = "Board.do";
	        }
	       //댓글 입력
	       else if(com != null && com.trim().equals("C_insert")) {
	     	   A_mbtiService sevice = new Comment_insertService();
	     	   sevice.execute(request,response);
	     	   viewPage = "BOneList.do";
	        }
	       //댓글 삭제
	       else if(com != null && com.trim().equals("C_delete")) {
	     	   A_mbtiService sevice = new Comment_deleteService();
	     	   sevice.execute(request,response);
	     	   viewPage = "BOneList.do";
	        }
	       //회원가입
	       else if(com != null && com.trim().equals("L_insert")) {
	     	   A_mbtiService sevice = new Login_insertService();
	     	   sevice.execute(request,response);
	     	   viewPage = "index.do";
	        }
	       //로그인 체크 
	       else if(com != null && com.trim().equals("LoginCS")) {
	     	   A_mbtiService sevice = new LoginCService();
	     	   sevice.execute(request,response);
	     	   viewPage = "index.do";
	        }
	       //회원정보수정 
	       else if(com != null && com.trim().equals("L_update")) {
	     	   A_mbtiService sevice = new Login_updateService();
	     	   sevice.execute(request,response);
	     	   viewPage = "LoginUpdate.do";
	        }
	       //회원탈퇴 
	       else if(com != null && com.trim().equals("L_delete")) {
	     	   A_mbtiService sevice = new Login_deleteService();
	     	   sevice.execute(request,response);
	     	   viewPage = "index.do";
	        }
	       //메시지 보내기 
	       else if(com != null && com.trim().equals("S_insert")) {
	     	   A_mbtiService sevice = new Sns_insertService();
	     	   sevice.execute(request,response);
	     	   viewPage = "Sns.do";
	        }
	       //메시지 삭제
	       else if(com != null && com.trim().equals("S_delete")) {
	     	   A_mbtiService sevice = new Sns_delectService();
	     	   sevice.execute(request,response);
	     	   viewPage = "Sns.do";
	        }
	       //메시지 읽음 처리 
	       else if(com != null && com.trim().equals("S_update")) {
	     	   A_mbtiService sevice = new Sns_updateService();
	     	   sevice.execute(request,response);
	     	   viewPage = "SOneList.do";
	        }
	       //프로필 사진 변경 처리 
	       else if(com != null && com.trim().equals("U_profile")) {
	     	   A_mbtiService sevice = new Login_fileupdateService();
	     	   sevice.execute(request,response);
	     	   viewPage = "index.do";
	        }
	       
	   	RequestDispatcher rd = request.getRequestDispatcher(viewPage);
        rd.forward(request, response);
    }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doHandle(request,response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doHandle(request,response);
   }
}