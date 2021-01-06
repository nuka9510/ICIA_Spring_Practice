<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container justfy-content-center col-md-8 mt-5">
	<table class="table">
		<tr>
			<th>글번호</th>
			<th>글제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:forEach items="${boardList}" var="i">
			<tr>
				<td>${i.getBnumber()}</td>
				<td><a href="boardView?main=boardView&bnumber=${i.getBnumber()}">${i.getBtitle()}</a></td>
				<td>${i.getBwriter()}</td>
				<td>${i.getBdate()}</td>
				<td>${i.getBhits()}</td>
			</tr>
		</c:forEach>
		<tfoot>
			<c:if test="${!empty sessionScope.signInId}">
				<tr>
					<td colspan="5" style="text-align: right;">
						<button class="btn btn-primary btn-md" onclick="location.href='./?main=boardWrite'">글작성</button>
					</td>
				</tr>
			</c:if>
		</tfoot>
	</table>
</div>