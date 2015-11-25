<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@	taglib prefix="spring"	uri="http://www.springframework.org/tags" %>

<div class="welcome">
	<div class="logo"><a href="<c:url value="/"/>"><img alt="Logo" src="<c:url value="/resources/images/my-eshop.png" />"></a></div>
</div>
<div style="clear: both; height: 30px;"></div>
<div class="adminSignInSection">	
	<div class="adminSigInBox">
		<div class="panel panel-default" style="width: 30%">
			<div class="panel-heading">
				<h3	class="panel-title"><spring:message code="signin.label"/> </h3>
			</div>
			<div class="panel-body">
				<c:if test="${not empty errorAdmin}">
					<div class="alert alert-danger">
						<spring:message code="AbstractUserDetailsAuthenticationProvider.badCredentials"/> <br />
					</div>
				</c:if>
				<form action="<c:url value="/admin/j_spring_security_check" />" method="post">
					<fieldset>
						<div class="form-group">
							<input class="form-control" placeholder="<spring:message code="username.label"/>" 
								name="j_username" type="text" />
						</div>
						<div class="form-group">
							<input class="form-control" placeholder="<spring:message code="password.label"/>" 
								name="j_password" type="password" value=""/>
						</div>
						<div class="form-group">
							<input type="checkbox" name="_spring_security_remember_me" />&nbsp;<spring:message code="rememberme.label"/>
						</div>
						<div class="form-group">
							<a href="<c:url value="/forgotpassword"/> " ><spring:message code="forgot.password.label"/></a>
						</div>
						<input class="btn btn-lg btn-success btn-block" type="submit" value="<spring:message code="login.label"/>"/>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</div>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
    $("#header").removeAttr("id");
    $("#mainContent").css("margin-left", "0");
    $("input[name='j_username']").focus();
});
</script>
