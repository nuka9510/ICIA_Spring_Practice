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
				상세정보
			</td>
			<td>
				상세정보(Ajax)
			</td>
			<td>
				삭제
			</td>
		</tr>
		<c:forEach items="${memberList}" var="i">
			<tr>
				<td>
					${i.getMid()}
				</td>
				<td>
					${i.getMname()}
				</td>
				<td>
					${i.getMphone()}
				</td>
				<td>
					${i.getMemail()}
				</td>
				<td>
					${i.getMbirth()}
				</td>
				<td>
					<button onclick="location.href='memberInfo?mid=${i.getMid()}'">조회</button>
				</td>
				<td>
					<button onclick="memberInfo('${i.getMid()}', document.getElementById('memberInfoResult'))">조회(Ajax)</button>
				</td>
				<td>
					<c:if test="${i.getMid() ne 'admin'}">
						<button onclick="location.href='memberDel?mid=${i.getMid()}'">삭제</button>
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
	<span id="memberInfoResult"></span>
	<button onclick="location.href='./'">홈으로</button>
</body>
<script type="text/javascript">
	function memberInfo(mid, result){
		var httpRequest = new XMLHttpRequest();
		httpRequest.onreadystatechange = function(){
			if(httpRequest.readyState == XMLHttpRequest.DONE && httpRequest.status == 200){
				result.innerHTML = "<table>"+
										"<tr>"+
											"<td>아이디</td>"+
											"<td>비밀번호</td>"+
											"<td>이름</td>"+
											"<td>연락처</td>"+
											"<td>이메일</td>"+
											"<td>생년월일</td>"+
										"</tr>"+
										"<tr>"+
											"<td>"+httpRequest.response.mid+"</td>"+
											"<td>"+httpRequest.response.mpassword+"</td>"+
											"<td>"+httpRequest.response.mname+"</td>"+
											"<td>"+httpRequest.response.mphone+"</td>"+
											"<td>"+httpRequest.response.memail+"</td>"+
											"<td>"+httpRequest.response.mbirth+"</td>"+
										"</tr>"+
									"</table>";
			}
		}
		httpRequest.open("POST", "memberInfoAjax", true);
		httpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		httpRequest.responseType = "json";
		httpRequest.send("mid="+mid);
	}
</script>
</html>