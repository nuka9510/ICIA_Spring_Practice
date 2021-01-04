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
		BoardMod
	</h1>
	<form action="boardMod" onsubmit="return pwCheck('${boardInfo.getBpassword()}', document.getElementById('bpassword'))" method="POST">
		<table>
			<tr>
				<th>
					작성자
				</th>
				<td>
					<input type="text" name="bwriter" value="${boardInfo.getBwriter()}" readonly="readonly">
				</td>
			</tr>
			<tr>
				<th>
					글비밀번호
				</th>
				<td>
					<input type="password" name="bpassword" id="bpassword" required="required">
				</td>
			</tr>
			<tr>
				<th>
					글제목
				</th>
				<td>
					<input type="text" name="btitle" value="${boardInfo.getBtitle()}" required="required">
				</td>
			</tr>
			<tr>
				<th>
					글내용
				</th>
				<td>
					<textarea rows="10" cols="20" name="bcontents">${boardInfo.getBcontents()}</textarea>
				</td>
			</tr>
		</table>
		<input type="hidden" name="bnumber" value="${boardInfo.getBnumber()}">
		<input type="submit">
	</form>
	<button onclick="location.href='./'">홈으로</button>
</body>
<script type="text/javascript">
	function pwCheck(pw, checkPw){
		if(pw == checkPw.value){
			return true;
		}else{
			alert("글 비밀번호가 일치하지 않습니다.");
			return false;
		}
	}
</script>
</html>