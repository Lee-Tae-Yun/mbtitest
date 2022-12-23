<%@page import="cs.mbti.MbtiDao"%>
<%@page import="cs.mbti.LoginDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    %>


<!DOCTYPE html>
<html>

<head>
    <title>회원정보 수정</title>
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
    <%
    String id2 = (String)session.getAttribute("id");
    		LoginDto dto = new LoginDto();
       		MbtiDao dao = new MbtiDao();
       		LoginDto dtos = dao.readDate(id2);
    %>
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
        <h1>MBTI 회원정보 수정</h1>
         <p>
            <div class="col-md-8 col-md-offset-2">
				  <form action="L_update.do" class="row">
			    <div class="form-group">
			      <label for="id">= 아이디 =</label>
			      <input type="text" class="form-control" placeholder="Enter MAX ID 20" name="id" maxlength='20' value="<%=id2 %>" style="border-radius: 30px; width: 350px; height: 50px; margin:auto;" required>
            </div>

            <div class="form-group">
                <label for="pwd">= 비밀번호 =</label>
                <input type="password" class="form-control" placeholder="Enter MAX PW 20" name="pwd" maxlength='20' value="<%=dtos.getPwd() %>" style="border-radius: 30px; width: 350px; height: 50px; margin:auto;" required>
            </div>

            <div class="form-group">
                <label for="name">= 이름 =</label>
                <input type="text" class="form-control" placeholder="Enter NAME" name="name" maxlength='20' value="<%=dtos.getName() %>" style="border-radius: 30px; width: 350px; height: 50px; margin:auto;" required>
            </div>
            
            <div class="form-group">
                <label for="filename">= 프로필사진 =</label>
                <input type="text" class="form-control" placeholder="Photo" name="filename" maxlength='20' value="<%=dtos.getFilename() %>" style="border-radius: 30px; width: 350px; height: 50px; margin:auto;" readonly>
            </div>
            
            
            <div class="form-group">
                <label for="chacter">= 성격유형 =</label>
                <input type="text" class="form-control" placeholder="Enter MBTI" name="chacter" maxlength='20' value="<%=dtos.getChacter() %>" style="border-radius: 30px; width: 350px; height: 50px; margin:auto;" readonly>
            </div>

            <div class="form-group">
                <label for="udate">= 생년월일 =</label>
                <input type="date" class="form-control" name="udate" value="<%=dtos.getUdate() %>" style="border-radius: 30px; width: 350px; height: 50px; margin:auto;" required>
            </div>

            <div class="form-group">
                <label for="pNumber">= 전화번호 =</label>
                <input type="text" class="form-control" placeholder="Ex)010-1234-5678" name="pNumber" maxlength='13' value="<%=dtos.getpNumber() %>" style="border-radius: 30px; width: 350px; height: 50px; margin:auto;" required>
            </div>

            <div class="form-group">
                <label for="email">= 이메일 =</label>
                <input type="email" class="form-control" placeholder="Enter MAX EMAIL 50" name="email" maxlength='50' value="<%=dtos.getEmail() %>" style="border-radius: 30px; width: 350px; height: 50px; margin:auto;" required>
            </div>

            <%   if(dtos.getGender().equals("남자")){%>
            <div class="form-group">
                <label for="gender">= 성별 =</label>
                <input type="radio" required class="form-control" name="gender" value="남자" checked>남자
                <input type="radio" required class="form-control" name="gender" value="여자">여자
            </div>
            <%}
			 else{ %>
            <div class="form-group">
                <label for="gender">성별 :</label>
                <input type="radio" required class="form-control" name="gender" value="남자">남자
                <input type="radio" required class="form-control" name="gender" value="여자" checked>여자
            </div>
            <%
				}
			%>

            <button type="submit" class="btn btn-primary" style="border-radius: 12px;">확인</button>
            <button type="button" class="btn btn-primary" onclick="location.href='profile.do?id3=<%=dtos.getId() %>'" style="border-radius: 12px;">프로필 사진 변경하기</button>
            <button type="button" class="btn btn-primary" onclick="location.href='Drop.do'" style="border-radius: 12px;">회원 탈퇴하기</button>
            <button type="button" class="btn btn-primary" onclick="location.href='index.do'" style="border-radius: 12px;">뒤로가기</button>
            </form>
        </div>
        </div>
        </div>

        <div class="container">



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