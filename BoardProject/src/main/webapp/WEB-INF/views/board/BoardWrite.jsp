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
		BoardWrite
	</h1>
	<form action="boardWrite" method="POST" enctype="multipart/form-data">
		<table>
			<tr>
				<th>
					작성자
				</th>
				<td>
					<input type="text" name="bwriter" required="required">
				</td>
			</tr>
			<tr>
				<th>
					글비밀번호
				</th>
				<td>
					<input type="password" name="bpassword" required="required">
				</td>
			</tr>
			<tr>
				<th>
					글제목
				</th>
				<td>
					<input type="text" name="btitle" required="required">
				</td>
			</tr>
			<tr>
				<th>
					글내용
				</th>
				<td>
					<textarea rows="10" cols="20" name="bcontents"></textarea>
				</td>
			</tr>
			<tr>
				<th>
					파일
				</th>
				<td>
					<input type="file" name="bfile">
				</td>
			</tr>
		</table>
		<input type="submit">
	</form>
	<button onclick="location.href='./'">홈으로</button>
</body>
</html>