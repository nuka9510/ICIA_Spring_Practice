<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container justfy-content-center col-md-8 mt-5">
	<table class="table">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>연락처</th>
			<th>이메일</th>
			<th>상세조회</th>
			<td>삭제</td>
		</tr>
		<c:forEach items="${memberList}" var="i">
			<tr>
				<td>${i.getMid()}</td>
				<td>${i.getMname()}</td>
				<td>${i.getMphone()}</td>
				<td>${i.getMemail()}</td>
				<td><button class="btn btn-primary btn-md" onclick="location.href='memberInfo?main=memberInfo&mid=${i.getMid()}'">상세조회</button></td>
				<td>
					<c:if test="${i.getMid() ne 'admin'}">
						<button class="btn btn-primary btn-md" onclick="location.href='memberDel?main=memberList&mid=${i.getMid()}'">삭제</button>
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>