<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
	<c:choose>
		<c:when test="${!empty sessionScope.loginId}">
			<p>${sessionScope.loginId}님 반갑습니다~</p>
			<c:if test="${sessionScope.loginId eq 'admin'}">
				<button onclick="location.href='memberList'">회원목록</button>
			</c:if>
			<button onclick="location.href='toMemberMod?mid=${sessionScope.loginId}'">정보수정</button>
			<button onclick="location.href='logout'">로그아웃</button>
		</c:when>
		<c:otherwise>
			<button onclick="location.href='toLogin'">로그인</button>
			<button onclick="location.href='toJoin'">회원가입</button>
		</c:otherwise>
	</c:choose>
</body>
</html>
