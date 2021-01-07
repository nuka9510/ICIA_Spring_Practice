<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container-fluid">
		<a class="navbar-brand" href="./"><img src="" alt="Logo"></a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
			<div>
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<c:choose>
					<c:when test="${empty sessionScope.signInId}">
						<li class="nav-item">
							<a class="nav-link" href="./?main=signIn&from=${param.main}">SignIn</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="./?main=signUp">SignUp</a>
						</li>
					</c:when>
					<c:otherwise>
						<li class="nav-item">
							<span class="nav-link">${sessionScope.signInId}님</span>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="memberInfo?main=memberInfo&mid=${sessionScope.signInId}">MyPage</a>
						</li>
						<c:if test="${sessionScope.signInId eq 'admin'}">
							<li class="nav-item">
								<a class="nav-link" href="memberList?main=memberList">MemberList</a>
							</li>
						</c:if>
						<li class="nav-item">
							<a class="nav-link" href="boardList?main=boardList&nowPage=1&searchOrder=bnumber">BoardList</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="signOut?main=${param.main}">SignOut</a>
						</li>
					</c:otherwise>
				</c:choose>
			</ul>
			</div>
		</div>
	</div>
</nav>