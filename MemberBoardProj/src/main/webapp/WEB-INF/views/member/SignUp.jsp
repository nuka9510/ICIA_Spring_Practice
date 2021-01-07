<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container mt-5 mt-5">
    <div class="row justify-content-center container-fluid">
        <h1 class="text-center">SignUp</h1>
        <form action="signUp" method="POST" onsubmit="return checkValue(document.getElementById('MB_PW'), document.getElementById('pwCheck'))" enctype="multipart/form-data">
            <div class="col-md-4 container-fluid">
                <label for="MB_ID" class="form-label">아이디</label>
                <div class="input-group">
                    <input type="text" class="form-control" id="MB_ID" name="mid" aria-describedby="idCheck" onchange="idChange(document.getElementById('idCheckResult'))" required>
                    <div class="btn btn-outline-secondary" id="idCheck" onclick="idCheckfunc(document.getElementById('MB_ID'), document.getElementById('idCheckResult'))">중복확인</div>
                </div>
                <span id="idCheckResult" class="d-block"></span>
                
                <label for="MB_PW">비밀번호</label>
                <div class="input-group">
                    <input type="password" class="form-control" id="MB_PW" name="mpassword" onkeyup="pwReg(this, document.getElementById('pwCheck'), document.getElementById('pwReg'), document.getElementById('pwCheckResult'))" placeholder="영문, 숫자 포함 8~20자" required>
                </div>
                <span id="pwReg" class="d-block"></span>
                
                <label for="pwCheck">비밀번호 확인</label>
                <div class="input-group">
                    <input type="password" class="form-control" id="pwCheck" onkeyup="pwCheckfunc(document.getElementById('MB_PW'), this, document.getElementById('pwCheckResult'))" required>
                </div>
                <span id="pwCheckResult" class="d-block"></span>
                
                <label for="MB_NAME">이름</label>
                <div class="input-group">
                    <input type="text" class="form-control" id="MB_NAME" name="mname" required>
                </div>
                
                <label for="MB_PHONE">연락처</label>
                <div class="input-group">
                    <input type="text" class="form-control" id="MB_PHONE" name="mphone" placeholder="'-'제외" maxlength="11" onkeyup="phoneCheck(this, document.getElementById('phoneCheckResult'))" required>
                </div>
                <span id="phoneCheckResult" class="d-block"></span>
                
                <label for="MB_MAIL">이메일</label>
                <div class="input-group">
                    <input type="email" class="form-control" id="MB_MAIL" name="memail" required>
                </div>
                
                <label for="sample6_postcode">주소</label>
                <div class="input-proup">
                	<div class="input-group">
		                <input type="text" class="form-control" id="sample6_postcode" name="mpostcode" aria-describedby="postcodeFind" placeholder="우편번호">
						<div class="btn btn-outline-secondary btn-md" id="postcodeFind" onclick="sample6_execDaumPostcode()">우편번호 찾기</div>
					</div>
					<input type="text" class="form-control" id="sample6_address" name="maddress" placeholder="주소">
					<input type="text" class="form-control" id="sample6_detailAddress" name="mdetailAddress" placeholder="상세주소">
					<input type="text" class="form-control" id="sample6_extraAddress" name="mextraAddress" placeholder="참고항목">
                </div>
                
                <label for="MB_PROFILE">프로필 사진</label>
                <div class="input-group">
                    <input type="file" class="form-control" id="MB_PROFILE" name="mprofile">
                </div>
                
                <div class="mt-2 text-center">
                    <input type="hidden" name="main" value="signIn">
                    <button type="submit" class="btn btn-primary btn-md">회원가입</button>
                    <input type="reset" class="btn btn-primary btn-md" value="다시작성">
                </div>
            </div>
        </form>
    </div>
</div>
<script src="resources/assets/js/signUp.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
</script>