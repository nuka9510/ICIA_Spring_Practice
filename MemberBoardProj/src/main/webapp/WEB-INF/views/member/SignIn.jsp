<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="resources/assets/css/signin.css">
<div class="form-signin text-center mt-5 pt-5">
	<form action="signIn" method="POST">
		<a href="./?main=${param.from}"><img src="" alt="Logo"></a>
		
		<label for="MB_ID" class="visually-hidden">ID</label>
		<input type="text" id="MB_ID" name="mid" class="form-control" placeholder="ID" required autofocus>
		
		<label for="MB_PW" class="visually-hidden">Password</label>
		<input type="password" id="MB_PW" name="mpassword" class="form-control" placeholder="Password" required>
		
		<input type="hidden" name="main" value="${param.from}">
		<button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
		
		<label>
			<a href="toSignUp?main=signUp&from=${param.from}" style="text-decoration: none;">SignUp</a>
		</label>
	</form>
</div>