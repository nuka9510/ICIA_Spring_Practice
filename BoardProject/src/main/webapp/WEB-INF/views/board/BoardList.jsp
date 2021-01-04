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
	<h1>
		BoardList
	</h1>
	<table>
		<tr>
			<th>글번호</th>
			<th>작성자</th>
			<th>글제목</th>
			<th>글작성일자</th>
			<th>조회수</th>
		</tr>
		<c:forEach items="${boardList}" var="i">
			<tr>
				<td>${i.getBnumber()}</td>
				<td>${i.getBwriter()}</td>
				<td><a href='boardView?bnumber=${i.getBnumber()}&nowPage=${page.getNowPage()}'>${i.getBtitle()}</a></td>
				<td>${i.getBdate()}</td>
				<td>${i.getBhits()}</td>
			</tr>
		</c:forEach>
		<tfoot>
			<tr>
				<td colspan="5" style="text-align: center;">
					<c:choose>
						<c:when test="${page.getNowPage() eq '1'}">
							
						</c:when>
						<c:otherwise>
							<a href="boardList?nowPage=${page.getStartPage()-1}">[이전]</a>
						</c:otherwise>
					</c:choose>
					<c:forEach begin="${page.getStartPage()}" end="${page.getEndPage()}" step="1" var="i">
						<c:choose>
							<c:when test="${i eq page.getNowPage()}">
								${i}
							</c:when>
							<c:otherwise>
								<a href="boardList?nowPage=${i}">${i}</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:choose>
						<c:when test="${page.getNowPage() eq page.getLastPage()}">
							
						</c:when>
						<c:otherwise>
							<a href="boardList?nowPage=${page.getEndPage()+1}">[다음]</a>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</tfoot>
	</table>
	<button onclick="location.href='./'">홈으로</button>
</body>
</html>