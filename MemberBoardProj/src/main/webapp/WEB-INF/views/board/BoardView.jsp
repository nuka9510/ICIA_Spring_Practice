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
			<button class="btn btn-primary btn-md" onclick="location.href='boardList?main=boardList'">글목록</button>
			<button class="btn btn-primary btn-md" onclick="location.href='toBoardMod?main=boardMod&bnumber=${boardView.getBnumber()}'">글수정</button>
			<button class="btn btn-primary btn-md" onclick="boardDel('${boardView.getBpassword()}', '${boardView.getBnumber()}')">글삭제</button>
		</div>
	</div>
</div>
<script type="text/javascript">
	function boardDel(bpassword, bnumber){
		if(prompt("글비밀번호를 입력해주세요") == bpassword){
			location.href = "boardDel?main=boardList&bnumber="+bnumber;
		}else{
			alert("비밀번호가 틀립니다.");
		}
	}
</script>