<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h3>내정보</h3>

<table border="1">

<tr>
<th>id</th>
<th>pwd</th>
<th>name</th>
<th>email</th>
</tr>

<tr>
<td>${m.id }</td>
<td>${m.pwd }</td>
<td>${m.name }</td>
<td>${m.email }</td>
</tr>

</table>

</body>
</html>