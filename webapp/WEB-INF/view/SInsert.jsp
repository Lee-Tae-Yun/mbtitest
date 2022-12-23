<%@page import="cs.mbti.LoginDto"%>
<%@page import="cs.mbti.MbtiDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    %>
<%
    	String id2 = (String)session.getAttribute("id"); //보내는사람ID
		String id3 = request.getParameter("Lid"); //받는사람 ID
		MbtiDao dao = new MbtiDao(); 
		LoginDto Fdate = new LoginDto(); //빈객체 가져오
		LoginDto Tdate = new LoginDto();
		
		Fdate = dao.readDate(id2);
		Tdate = dao.readDate(id3);
    %>

<!DOCTYPE html>
<html>

<head>
    <title>게시판 글쓰기</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Free singlepage web template created by GraphBerry">
    <meta name="keywords" content="HTML5, Bootstrap 3, CSS3, javascript, PHP, Responsive, Mobile">
    <meta name="author" content="GraphBerry.com" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==" crossorigin="anonymous">
    <link href='http://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href="css/font-awesome.css">
    <link rel="stylesheet" type="text/css" href="css/magnific-popup.css">
    <link rel="stylesheet" type="text/css" href="css/aaa.css">
</head>

<body>
    <header>
        <div class="primary-menu">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">메뉴</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li><a href="index.do">홈</a></li>
                    <%if(id2 == null){%>
                    <li><a href="SignUp.do">회원가입</a></li>
                    <li><a href="Login.do">로그인</a></li>
                    <%}else{%>
                    <li><a href="LoginUpdate.do">마이페이지</a></li>
                    <li><a href="LogOutPop.do">로그아웃</a></li>
                    <li><a href="Sns.do">메시지</a></li>
                    <li><a href="Board.do">게시판</a></li>
                    <li><a href="Tran.do">검사해석</a></li>
                    <%}%>
            </ul>
        </div>
   </div>

     <div class="container">
         <div class="row">
         <h1>쪽지쓰기</h1>
         <p>
            <div class="col-md-8 col-md-offset-2">
				  <form action="S_insert.do" class="row">
				  <table class="table" style="width:50%;margin-left:auto;margin-right:auto;">
	                  <thead >
	                      <tr>
	                          <th width="10px">FROM</th>
	                          <th width="150" style="text-align:left;">
	                              <h6><%=id2+"&nbsp;&nbsp;&nbsp;"+Fdate.getName()%></h6>
	                          </th>
	                      </tr>
	                      <tr>
	                          <th width="10px">TO</th>
	                          <th width="150" style="text-align:left;">
	                              <h6><%=id3+"&nbsp;&nbsp;&nbsp;"+Tdate.getName() %></h6>
	                          </th>
	                      </tr>
	                  </thead>
                   </table>
		    		<div class="form-group" >
				      <label for="id">= 제목 =</label>
				      <input type="text" class="form-control" placeholder="Enter MAX Title 20" name="stitle" maxlength='20' style="border-radius: 30px; width: 350px; height: 50px; margin:auto;" required>
				    </div> 
				       
				    <div class="form-group">
				      <label for="pwd">= 내용  =</label>
				      <textarea class="form-control" placeholder="Enter MAX 400" name="content" maxlength='400' style="resize: none; border-radius: 30px; width: 350px; height: 350px; margin:auto;"  required></textarea>
				    </div>
				    
                    <input type="hidden" id="fid" name="fid" value="<%=id2 %>">
                    <input type="hidden" id="tid" name="tid" value="<%=id3 %>">
				    
				    <button type="submit" class="btn btn-primary" style="border-radius: 12px;">확인</button>
				    <button type="button" class="btn btn-primary"  onclick="location.href='Sns.do'" style="border-radius: 12px;">뒤로가기</button>
				  </form>
			 </div>
          </div>
      </div>

	
</header>

<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="js/jquery.mixitup.js"></script>
<script type="text/javascript" src="js/jquery.magnific-popup.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js" integrity="sha512-K1qjQ+NcF2TYO/eI3M6v8EiNYZfA95pQumfvcVrTHtwQVDG+aHRqLi/ETn2uB+1JqwYqVG3LIvdm9lj6imS/pQ==" crossorigin="anonymous"></script>
<script type="text/javascript" src="js/smooth-scroll.js"></script>
<script src="js/custom.js"></script>
</body>
</html>
   