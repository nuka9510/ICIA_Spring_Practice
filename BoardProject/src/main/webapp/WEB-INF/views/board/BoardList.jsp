<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
		BoardList
	</h1>
	<table>
		<tr>
			<th>글번호</th>
			<th>작성자</th>
			<th>글제목</th>
			<th>글작성일자</th>
			<th>조회수</th>
		</tr>
		<c:forEach items="${boardList}" var="i">
			<tr>
				<td>${i.getBnumber()}</td>
				<td>${i.getBwriter()}</td>
				<td><a href='boardView?bnumber=${i.getBnumber()}'>${i.getBtitle()}</a></td>
				<td>${i.getBdate()}</td>
				<td>${i.getBhits()}</td>
			</tr>
		</c:forEach>
	</table>
	<button onclick="location.href='./'">홈으로</button>
</body>
</html>