<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.js"></script>
</head>
<body>
	<form action="join" method="POST">
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="mid" required="required" onkeyup="idDuplicate(this, document.getElementById('idDuplicateResult'))"><span id="idDuplicateResult"></span></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="mpassword" required="required"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="mname" required="required"></td>
			</tr>
			<tr>
				<th>phone</th>
				<td><input type="text" name="mphone" placeholder="'-'제외" required="required"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="email" name="memail" required="required"></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><input type="date" name="mbirth" required="required"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit">
				</td>
			</tr>
		</table>
	</form>
	<button onclick="location.href='./'">홈으로</button>
</body>
<script type="text/javascript">
	var idDuplicateResult = false;
	
	function idDuplicate(mid, result){
		console.log(mid.value);
		var httpRequest = new XMLHttpRequest();
		httpRequest.onreadystatechange = function(){
			if(httpRequest.readyState == XMLHttpRequest.DONE && httpRequest.status == 200){
				if(mid.value != ""){
					if(httpRequest.response=="true"){
						result.style.color = "green";
						result.innerHTML = "사용가능 아이디 입니다.";
					}else if(httpRequest.responseText=="false"){
						result.style.color = "red";
						result.innerHTML = "이미 사용중인 아이디 입니다.";
					}
				}else{
					result.style.color = "black";
					result.innerHTML = "아이디를 입력해주세요"
				}
			}
			if(httpRequest.readyState == XMLHttpRequest.DONE && httpRequest.status == 404){
				alert("Error");
			}
		}
		httpRequest.open("POST", "idDuplicate", true);
		httpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		httpRequest.responseType = "text"
		httpRequest.send("mid="+mid.value);
	}
</script>
</html>