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

<h3><%= id %>�� �α��� ����</h3>
<h3><a href="/helloWeb/member/List">��� ȸ�� ��� ����</a></h3>
<h3><a href="/helloWeb/member/MyInfo?id=<%= id %>">����������</a></h3>
<h3><a href="/helloWeb/member/Out?id=<%= id %>">Ż��</a></h3>
</body>
</html>