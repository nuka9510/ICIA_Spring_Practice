<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container justfy-content-center col-md-8 mt-5">
	<table class="table">
		<tr>
			<td rowspan="2">
				<img alt="" src="resources/memberProfile/${memberInfo.getMprofilename()}" width="200px">
			</td>
			<th>아이디 : </th>
			<td>${memberInfo.getMid()}</td>
		</tr>
		<tr>
			<th>작성한 글 갯수 : </th>
			<td>${boardCount}</td>
		</tr>
		<tr>
			<th colspan="2">이름 : </th>
			<td>${memberInfo.getMname()}</td>
		</tr>
		<tr>
			<th colspan="2">연락처 : </th>
			<td>${memberInfo.getMphone()}</td>
		</tr>
		<tr>
			<th colspan="2">이메일 : </th>
			<td>${memberInfo.getMemail()}</td>
		</tr>
		<tr>
			<th colspan="2">우편번호 : </th>
			<td>${memberInfo.getMpostcode()}</td>
		</tr>
		<tr>
			<th colspan="2">주소 : </th>
			<td>${memberInfo.getMaddress()} ${memberInfo.getMdetailAddress()} ${memberInfo.getMextraAddress()}</td>
		</tr>
		<tr>
			<td colspan="3" class="text-end">
				<c:if test="${sessionScope.signInId eq memberInfo.getMid() and sessionScope.signInId ne 'admin'}">
					<button class="btn btn-primary btn-md" onclick="memberMod('${memberInfo.getMpassword()}', '${memberInfo.getMid()}')">정보수정</button>
				</c:if>
				<c:if test="${sessionScope.signInId eq 'admin' and memberInfo.getMid() ne 'admin'}">
					<button class="btn btn-primary btn-md" onclick="location.href='memberDel?main=memberList&mid=${memberInfo.getMid()}'">삭제</button>
				</c:if>
			</td>
		</tr>
	</table>
</div>
<script type="text/javascript">
	function memberMod(mpassword, mid){
		if(prompt("비밀번호를 입력해주세요") == mpassword){
			location.href = "toMemberMod?main=memberMod&mid="+mid;
		}else{
			alert("비밀번호가 틀립니다.");
		}
	}
</script>