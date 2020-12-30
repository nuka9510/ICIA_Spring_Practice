<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="memberMod" method="POST">
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="mid" value="${memberInfo.getMid()}" required="required" readonly="readonly"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="mpassword" required="required"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="mname" value="${memberInfo.getMname()}" required="required" readonly="readonly"></td>
			</tr>
			<tr>
				<th>phone</th>
				<td><input type="text" name="mphone" value="${memberInfo.getMphone()}" placeholder="'-'제외" required="required"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="email" name="memail" value="${memberInfo.getMemail()}" required="required"></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><input type="date" name="mbirth" value="${memberInfo.getMbirth()}" required="required" readonly="readonly"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>