<%@page import="cs.mbti.SnsDto"%>
<%@page import="cs.mbti.CommentDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cs.mbti.MbtiDao"%>
<%@page import="cs.mbti.LoginDto"%>
<%@page import="cs.mbti.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    %>
<%
	request.setCharacterEncoding("utf-8");

	String id2 = (String)session.getAttribute("id");
	int sid = Integer.parseInt(request.getParameter("sid"));
	SnsDto dto = new SnsDto();
	MbtiDao dao = new MbtiDao();
	SnsDto dtos = dao.readSDate(sid);
	


//int dtoss = Integer.parseInt(dto.getBoradview());
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
    <style>
        div.brt {
            position: relative;
            top: 20px;
            right: 530px;
        }
    </style>
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
         <h1><%=dtos.getFid()%>님이 보낸 쪽지</h1>
                    <p>
                        <div class="col-md-8 col-md-offset-2">
                            <form class="row">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th>제목</th>
                                            <th style="text-align:left;">
                                                <h6><%=dtos.getStitle() %></h6>
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr height="20">
                                            <th>보낸사람</th>
                                            <th style="text-align:left;">
                                                <h6><%=dtos.getFid()%></h6>
                                            </th>
                                        </tr>
                                        <br>
                                        <tr height="20">
                                            <th>작성날짜</th>
                                            <th style="text-align:left;">
                                                <h6><%=dtos.getSdate() %></h6>
                                            </th>
                                        </tr>
                                    </tbody>
                                    <tfoot>
                                        <tr height="300">
                                            <th width="150">내용</th>
                                            <th colspan="2" style="text-align:left;">
                                                <h6><%=dtos.getContent() %></h6>
                                            </th>
                                        </tr>
                                    </tfoot>
                                </table>
                                <button type="button" class="btn btn-primary" onclick="location.href= 'Sns.do'" style="border-radius: 12px;">확인</button>
                                <button type="button" class="btn btn-primary" onclick="location.href= 'S_delete.do?sid=<%=sid %>'" style="border-radius: 12px;">삭제</button>
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