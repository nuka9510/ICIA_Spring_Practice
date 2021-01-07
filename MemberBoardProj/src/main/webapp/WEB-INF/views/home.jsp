<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/assets/bootstrap-icons-1.2.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="resources/assets/dist/css/bootstrap.min.css">
    <script src="resources/assets/dist/js/bootstrap.bundle.min.js"></script>
	<title>Home</title>
</head>
<body>
    <header id="top">
    	<%@ include file="mainNav.jsp" %>
    </header>
    <main>
    	<c:choose>
    		<c:when test="${empty param.main}">
    			<%@ include file="front.jsp" %>
    		</c:when>
    		<c:when test="${param.main eq 'signIn'}">
    			<%@ include file="member/SignIn.jsp" %>
    		</c:when>
    		<c:when test="${param.main eq 'signUp'}">
    			<%@ include file="member/SignUp.jsp" %>
    		</c:when>
    		<c:when test="${param.main eq 'memberList'}">
    			<%@ include file="member/MemberList.jsp" %>
    		</c:when>
    		<c:when test="${param.main eq 'memberInfo'}">
    			<%@ include file="member/MemberInfo.jsp" %>
    		</c:when>
    		<c:when test="${param.main eq 'memberMod'}">
    			<%@ include file="member/MemberMod.jsp" %>
    		</c:when>
    		<c:when test="${param.main eq 'boardList'}">
    			<%@ include file="board/BoardList.jsp" %>
    		</c:when>
    		<c:when test="${param.main eq 'boardWrite'}">
    			<%@ include file="board/BoardWrite.jsp" %>
    		</c:when>
    		<c:when test="${param.main eq 'boardView'}">
    			<%@ include file="board/BoardView.jsp" %>
    		</c:when>
    		<c:when test="${param.main eq 'boardMod'}">
    			<%@ include file="board/BoardMod.jsp" %>
    		</c:when>
    		<c:otherwise>
    			<h1>${param.main}미구현</h1>
    		</c:otherwise>
    	</c:choose>
    </main>
    <div class="position-fixed bottom-0 end-0">
        <a href="#top" style="color: black;">
            <i class="bi bi-arrow-up-short" style="font-size: 50px;"></i>
        </a>
    </div>
    <footer>
    	<%@ include file="footer.jsp" %>
    </footer>
</body>
</html>
