<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="spring_201228_1">spring_201228_1.jsp로 이동</a>
<a href="selectDB">DB 조회하기</a>
<c:if test="${!empty selectDB}">
	DB 조회 결과 : ${selectDB}
</c:if>
</body>
</html>
