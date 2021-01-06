<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container mt-5 mt-5">
    <div class="row justify-content-center container-fluid">
        <form action="boardWrite" method="POST" enctype="multipart/form-data">
            <div class="col-md-4 container-fluid">
                
                <label for="btitle" class="form-label">글제목</label>
                <div class="input-group">
                    <input type="text" class="form-control" id="btitle" name="btitle" required>
                </div>
                
                <label for="bpassword">비밀번호</label>
                <div class="input-group">
                    <input type="password" class="form-control" id="bpassword" name="bpassword" required>
                </div>
                <span id="pwReg" class="d-block"></span>
                
                <label for="bcontents">글내용</label>
                <div class="input-group">
                    <textarea class="form-control" id="bcontents" name="bcontents" rows="10" cols="20"></textarea>
                </div>
                
                <label for="bfile">첨부파일</label>
                <div class="input-group">
                    <input type="file" class="form-control" id="bfile" name="bfile">
                </div>
                
                <div class="mt-2 text-center">
                	<input type="hidden" name="bwriter" value="${sessionScope.signInId}">
                    <input type="hidden" name="main" value="boardList">
                    <button type="submit" class="btn btn-primary btn-md">글작성</button>
                    <input type="reset" class="btn btn-primary btn-md" value="다시작성">
                </div>
            </div>
        </form>
    </div>
</div>