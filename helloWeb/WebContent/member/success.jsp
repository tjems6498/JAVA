<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
  String id = request.getParameter("id");
%>

<h3><%= id %>님 로그인 성공</h3>
<h3><a href="/helloWeb/member/List">모든 회원 목록 보기</a></h3>
<h3><a href="/helloWeb/member/MyInfo?id=<%= id %>">내정보보기</a></h3>
<h3><a href="/helloWeb/member/Out?id=<%= id %>">탈퇴</a></h3>
</body>
</html>