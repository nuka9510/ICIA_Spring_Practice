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
		BoardList
	</h1>
	<table>
		<tr>
			<th>글번호</th>
			<td>${boardView.getBnumber()}</td>
			<th>글작성일자</th>
			<td>${boardView.getBdate()}</td>
		</tr>
		<tr>
			<th>글작성자</th>
			<td colspan="3">${boardView.getBwriter()}</td>
		</tr>
		<tr>
			<th>글내용</th>
			<td>
				<textarea rows="10" cols="20" readonly="readonly">${boardView.getBcontents()}</textarea>
			</td>
		</tr>
	</table>
	<button onclick="location.href='./'">홈으로</button>
	<button onclick="location.href='boardList'">글목록</button>
	<button onclick="location.href='toBoardMod?boardView=${boardView}'">글수정</button>
	<button onclick="boardDel(${boardView.getBpassword()})">글삭제</button>
</body>
<script type="text/javascript">
	function boardDel(bpassword){
		if(prompt("글비밀번호를 입력해주세요") == bpassword){
			location.href = "boardDel";
		}else{
			alert("비밀번호가 틀립니다.");
		}
	}
</script>
</html>