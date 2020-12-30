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
	<table>
		<tr>
			<td>
				아이디
			</td>
			<td>
				비밀번호
			</td>
			<td>
				이름
			</td>
			<td>
				연락처
			</td>
			<td>
				이메일
			</td>
			<td>
				생년월일
			</td>
			<td>
				삭제
			</td>
		</tr>
		<tr>
			<td>
				${memberInfo.getMid()}
			</td>
			<td>
				${memberInfo.getMpassword()}
			</td>
			<td>
				${memberInfo.getMname()}
			</td>
			<td>
				${memberInfo.getMphone()}
			</td>
			<td>
				${memberInfo.getMemail()}
			</td>
			<td>
				${memberInfo.getMbirth()}
			</td>
			<td>
				<c:if test="${memberInfo.getMid() ne 'admin'}">
					<button onclick="location.href='memberDel?mid=${memberInfo.getMid()}'">삭제</button>
				</c:if>
			</td>
		</tr>
	</table>
	<button onclick="location.href='./'">홈으로</button>
</body>
</html>