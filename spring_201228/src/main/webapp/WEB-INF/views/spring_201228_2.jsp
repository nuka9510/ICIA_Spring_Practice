<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>
	spring_201228_2.jsp 
</h1>

<P>  The time on the server is ${serverTime}. </P>
<p> ${mav1} </p>
<p> ${mav2} </p>

<p> ${param.param1} </p>
<p> ${param.param2} </p>
<a href="./">home.jsp로 이동</a>

<form action="insert" method="POST">
	<input type="text" name="data1">
	<input type="submit">
</form>
</body>
</html>