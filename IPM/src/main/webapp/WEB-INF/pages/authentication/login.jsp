<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="login-box">
	<div class="login-logo">
		<a href="https://ou.edu.vn"><b
			style="font-size: 45px">IPM</b></a>
	</div>
	<div class="login-box-body">
		<p class="login-box-msg">Sign in to start your session</p>

		<c:if test="${param.error == 'true'}">
			<div class="alert alert-error" id="view-error">
				<strong>Login Failed:</strong> Invalid email or password
			</div>
		</c:if>

		<c:url value="/j_spring_security_check" var="login_action" />
		<form action="${login_action}" method="post">
			<div class="form-group has-feedback">
				<input type="email" class="form-control" placeholder="Email"
					name="email"> <span
					class="glyphicon glyphicon-envelope form-control-feedback"></span>
			</div>
			<div class="form-group has-feedback">
				<input type="password" class="form-control" placeholder="Password"
					name="password"> <span
					class="glyphicon glyphicon-lock form-control-feedback"></span>
			</div>
			<div class="row">
				<div class="col-xs-8">
					<a href="#">Forgot password?</a>
				</div>
				<div class="col-xs-4">
					<button type="submit" class="btn btn-primary btn-block btn-flat">Sign
						In</button>
				</div>
			</div>
		</form>
		<br>
	</div>
</div>
