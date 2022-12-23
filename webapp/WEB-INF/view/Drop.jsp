<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>회원탈퇴</title>
</head>

<body>
    <script>
        var result = confirm("정말 회원탈퇴 하시겠습니까?");

        if (result) {
            location.href = "L_delete.do";
        } else {
            location.href = "index.do";
        }
    </script>

</body>

</html>