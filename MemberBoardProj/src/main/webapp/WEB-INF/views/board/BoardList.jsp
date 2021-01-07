<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container justfy-content-center col-md-8 mt-5">
	<table class="table">
		<thead>
			<tr>
				<td colspan="5">
					<form action="boardList" class="mb-0">
						<div class="container-fluid">
							<div class="row justify-content-end">
								<div class="input-group w-50">
									<select class="form-select-sm w-25 rounded-start" name="searchType" id="button-addon2">
										<option value="btitle" selected>글제목</option>
										<option value="bwriter">작성자</option>
									</select>
									<input type="hidden" name="main" value="boardList">
									<input type="hidden" name="nowPage" value="1">
									<input type="hidden" name="searchOrder" value="bnumber">
									<input type="text" name="searchWord" class="form-control" aria-describedby="button-addon2">
									<button class="btn btn-outline-secondary" type="submit" id="button-addon2">검색</button>
								</div>
							</div>
						</div>
					</form>
				</td>
			</tr>
		</thead>
		<tr>
			<th><a class="text-dark" href="boardList?main=boardList&nowPage=1&searchOrder=bnumber&searchType=${search.getSearchType()}&searchWord=${search.getSearchWord()}">글번호</a></th>
			<th>글제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th><a class="text-dark" href="boardList?main=boardList&nowPage=1&searchOrder=bhits&searchType=${search.getSearchType()}&searchWord=${search.getSearchWord()}">조회수</a></th>
		</tr>
		<c:forEach items="${boardList}" var="i">
			<tr>
				<td>${i.getBnumber()}</td>
				<td><a href="boardView?main=boardView&bnumber=${i.getBnumber()}&nowPage=${page.getNowPage()}">${i.getBtitle()}</a></td>
				<td><a class="text-dark" href="memberInfo?main=memberInfo&mid=${i.getBwriter()}">${i.getBwriter()}</a></td>
				<td>${i.getBdate()}</td>
				<td>${i.getBhits()}</td>
			</tr>
		</c:forEach>
		<tfoot>
			<c:if test="${!empty sessionScope.signInId}">
				<tr>
					<td colspan="5" style="text-align: center;">
						<c:choose>
							<c:when test="${page.getStartPage() eq '1'}">
								
							</c:when>
							<c:otherwise>
								<a href="boardList?main=boardList&nowPage=${page.getStartPage()-1}&searchOrder=${search.getSearchOrder()}&searchType=${search.getSearchType()}&searchWord=${search.getSearchWord()}">[이전]</a>
							</c:otherwise>
						</c:choose>
						<c:forEach begin="${page.getStartPage()}" end="${page.getEndPage()}" step="1" var="i">
							<c:choose>
								<c:when test="${i eq page.getNowPage()}">
									${i}
								</c:when>
								<c:otherwise>
									<a href="boardList?main=boardList&nowPage=${i}&searchOrder=${search.getSearchOrder()}&searchType=${search.getSearchType()}&searchWord=${search.getSearchWord()}">${i}</a>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:choose>
							<c:when test="${page.getEndPage() eq page.getLastPage()}">
								
							</c:when>
							<c:otherwise>
								<a href="boardList?main=boardList&nowPage=${page.getEndPage()+1}&searchOrder=${search.getSearchOrder()}&searchType=${search.getSearchType()}&searchWord=${search.getSearchWord()}">[다음]</a>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr>
					<td colspan="5" style="text-align: right;">
						<button class="btn btn-primary btn-md" onclick="location.href='./?main=boardWrite'">글작성</button>
					</td>
				</tr>
			</c:if>
		</tfoot>
	</table>
</div>