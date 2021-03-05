<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h3>게시판 목록</h3> <h3><a href="${pageContext.request.contextPath }/boarder/write.jsp">글작성</a></h3>
<c:if test="${not empty list }">
<table border="1">
<tr>
<th>num</th><th>writer</th><th>w_date</th><th>title</th><th>content</th>
</tr>
<c:forEach var="b" items="${list }">
<tr>
<td>${b.num }</td><td>${b.writer }</td><td>${b.w_date }</td><td>${b.title }</td><td>${b.content }</td>
</tr>
</c:forEach>
</table>

</c:if>

</body>
</html>