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
	spring_201228_1.jsp
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="./">home.jsp로 이동</a>

<form action="param" method="POST">
	첫번 째 : <input type="text" name="param1"> <br/>
	두번 째 : <input type="text" name="param2"> <br/>
	<input type="submit">
</form>
</body>
</html>