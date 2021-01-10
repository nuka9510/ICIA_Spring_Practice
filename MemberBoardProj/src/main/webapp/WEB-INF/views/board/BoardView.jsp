<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container text-center mt-5 mt-5">
    <div class="row justify-content-center container-fluid col-md-8 m-auto">
    	<div>
			<table class="table">
				<tr>
					<th>글번호</th>
					<td>${boardView.getBnumber()}</td>
				</tr>
				<tr>
					<th>글작성일자</th>
					<td>${boardView.getBdate()}</td>
				</tr>
				<tr>
					<th>글제목</th>
					<td>${boardView.getBtitle()}</td>
				</tr>
				<tr>
					<th>글작성자</th>
					<td>${boardView.getBwriter()}</td>
				</tr>
				<tr>
					<th>글내용</th>
					<td>
						<c:if test="${!empty boardView.getBfilename()}">
							<img src="resources/uploadFile/${boardView.getBfilename()}" width="300px"><br />
						</c:if>
						<textarea rows="10" cols="20" readonly="readonly" style="border: none; resize: none;">${boardView.getBcontents()}</textarea>
					</td>
				</tr>
			</table>
		</div>
		<div class="container justify-content-center">
			<button class="btn btn-primary btn-md" onclick="location.href='boardList?main=boardList&nowPage=${param.nowPage}&searchOrder=${param.searchOrder}&searchType=${param.searchType}&searchWord=${param.searchWord}'">글목록</button>
			<c:if test="${boardView.getBwriter() eq sessionScope.signInId}">
				<button class="btn btn-primary btn-md" onclick="location.href='toBoardMod?main=boardMod&bnumber=${boardView.getBnumber()}&nowPage=${param.nowPage}'">글수정</button>
			</c:if>
			<c:if test="${boardView.getBwriter() eq sessionScope.signInId or sessionScope.signInId eq 'admin'}">
				<button class="btn btn-primary btn-md" onclick="location.href='boardDel?main=boardList&bnumber=${boardView.getBnumber()}&nowPage=${param.nowPage}'">글삭제</button>
			</c:if>
		</div>
		<table>
			<tr>
				<td>
					<label for="ccontents" class="form-label">댓글</label>
					<input class="form-control" type="text" id="ccontents">
				</td>
			</tr>
			<tr>
				<td style="text-align: right;">
					<button class="btn btn-primary btn-md" onclick="commentWrite('${sessionScope.signInId}', document.getElementById('ccontents'), '${boardView.getBnumber()}', document.getElementById('commentListResult'))">댓글 작성</button>
				</td>
			</tr>
		</table>
		<table class="table text-center" id="commentListResult"></table>
	</div>
</div>
<script type="text/javascript">
	window.onload = function(){
		 commentList('${boardView.getBnumber()}', document.getElementById("commentListResult"));
	}
	function commentWrite(cwriter, ccontents, bnumber, result){
		var httpRequest = new XMLHttpRequest();
		httpRequest.onreadystatechange = function(){
			if(httpRequest.readyState == XMLHttpRequest.DONE && httpRequest.status == 200){
				ccontents.value = "";
				resultCommentList(httpRequest.response, result);
			}
		}
		httpRequest.open("POST", "commentWrite", true);
		httpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		httpRequest.responseType = "json";
		httpRequest.send("cwriter="+cwriter+"&ccontents="+ccontents.value+"&cbnumber="+bnumber);
	}
	function commentList(bnumber, result){
		var httpRequest = new XMLHttpRequest();
		httpRequest.onreadystatechange = function(){
			if(httpRequest.readyState == XMLHttpRequest.DONE && httpRequest.status == 200){
				resultCommentList(httpRequest.response, result);
			}
		}
		httpRequest.open("GET", "commentList?cbnumber="+bnumber, true);
		httpRequest.responseType = "json";
		httpRequest.send();
	}
	function commentDel(bnumber, cnumber, result){
		var httpRequest = new XMLHttpRequest();
		httpRequest.onreadystatechange = function(){
			if(httpRequest.readyState == XMLHttpRequest.DONE && httpRequest.status == 200){
				resultCommentList(httpRequest.response, result);
			}
		}
		httpRequest.open("POST", "commentDel", true);
		httpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		httpRequest.responseType = "json";
		httpRequest.send("cnumber="+cnumber+"&cbnumber="+bnumber);
	}
	function resultCommentList(commentList, result){
		var out = "<tr>"+
						"<th>"+
							"작성자"+
						"</th>"+
						"<th colspan='2'>"+
							"내용"+
						"</th>"+
					"</tr>";
		for (var i in commentList) {
			out += "<tr>"+
						"<td>"+
							commentList[i].cwriter+
						"</td>"+
						"<td>"+
							commentList[i].ccontents+
						"</td>"+
						"<td>";
			if(commentList[i].cwriter == '${sessionScope.signInId}' || '${sessionScope.signInId}' == 'admin'){
				out +=  	"<button class='btn btn-primary btn-md' onclick='commentDel(${boardView.getBnumber()}, "+commentList[i].cnumber+", document.getElementById(&#39;commentListResult&#39;))'>삭제</button>";
			}
			out +=  	"</td>"+
					"</tr>";
		}
		result.innerHTML = out;
	}
</script>