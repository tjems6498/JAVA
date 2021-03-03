<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
function a(){
	alert("일반버튼 클릭됨");
}
</script>
</head>
<body>
<h3>회원가입</h3>
<!-- 폼양식: 사용자 입력 인터페이스. 서버 전송 -->
<!-- <form action="서버페이지" method=get/post> -->
<!-- get: url? 뒤에 전송 파라메터를 붙여서 보냄. 보안에 취약. 길이에 제약. -->
<!-- post: 전송 패킷 헤더에 담아 보냄. 데이터가 url에 노출 안됨. 길이에 제약 없음 -->
<form action="SignUp" method="post">
id:<input type="text" name="id"><br>
pwd:<input type="password" name="pwd"><br>
name:<input type="text" name="name"><br>
email:<input type="text" name="email"><br>

<!-- 성별: <input type="radio" name="gen" value="f">여자 -->
<!-- <input type="radio" name="gen" value="m">남자<br> -->
<!-- 취미: <input type="checkbox" name="hobby" value="1">수영 -->
<!-- <input type="checkbox" name="hobby" value="2">낚시 -->
<!-- <input type="checkbox" name="hobby" value="3">여행 -->
<!-- <input type="checkbox" name="hobby" value="4">축구  <br> -->
<!-- <select name="grade"> -->
<!-- <option value="g1">1학년</option> -->
<!-- <option value="g2">2학년</option> -->
<!-- <option value="g3">3학년</option> -->
<!-- <option value="g4">4학년</option> -->
<!-- </select><br> -->
<!-- <textarea name="info" cols=45 rows="10">가입인사 입력</textarea><br> -->
<input type="submit" value="회원가입">
<input type="reset" value="초기화">
<!-- <input type="button" value="일반버튼" onclick="a()"> -->
</form>
</body>
</html>