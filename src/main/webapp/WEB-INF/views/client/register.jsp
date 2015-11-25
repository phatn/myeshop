<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@	taglib prefix="spring"	uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url var="submitRegistrationUrl" value="/customer/register" />

<div class="welcome">
	<div class="logo"><a href="<c:url value="/"/>"><img alt="Logo" src="<c:url value="/resources/images/my-eshop.png" />"></a></div>
</div>
<div style="clear: both; height: 30px;"></div>
<div class="resigterSection" style="width: 40%">
	<div class="registerTitle"><spring:message code="resigterTitle.label"/> </div>
	<form:form class="form-horizontal" action="${submitRegistrationUrl}" modelAttribute="customer" method="post">
		<!-- User name -->
		<div class="form-group">
			<label for="inputUserName" class="control-label col-xs-4"><spring:message code="username.label" /> </label>
        	<div class="col-xs-8">
            	<form:input type="text" path="userName" class="form-control" id="inputUserName" />
            	<form:errors path="userName" cssClass="text-danger" />
        	</div>
		</div>
		
		<!-- First name -->
		<div class="form-group">
			<label for="inputFirstName" class="control-label col-xs-4"><spring:message code="firstName.label" /> </label>
        	<div class="col-xs-8">
            	<form:input type="text" path="firstName" class="form-control" id="inputFirstName" />
        	</div>
		</div>
		
		<!-- Last name -->
		<div class="form-group">
			<label for="inputLastName" class="control-label col-xs-4"><spring:message code="lastName.label" /> </label>
        	<div class="col-xs-8">
            	<form:input type="text" path="lastName" class="form-control" id="inputLastName" />
        	</div>
		</div>
		
		<!-- Email -->
		<div class="form-group">
			<label for="inputEmail" class="control-label col-xs-4"><spring:message code="email.label" /> </label>
        	<div class="col-xs-8">
            	<form:input type="text" path="email" class="form-control" id="inputEmail" />
            	<form:errors path="email" cssClass="text-danger" />
        	</div>
		</div>
		
		<!-- Password -->
		<div class="form-group">
			<label for="inputPassword" class="control-label col-xs-4"><spring:message code="password.label" /> </label>
        	<div class="col-xs-8">
            	<form:input type="password" path="password" class="form-control" id="inputPassword" />
            	<form:errors path="password" cssClass="text-danger" />
        	</div>
		</div>
		
		<!-- Confirm Password -->
		<div class="form-group">
			<label for="inputConfirmPassword" class="control-label col-xs-4"><spring:message code="confirmPassword.label" /> </label>
        	<div class="col-xs-8">
            	<form:input type="password" path="confirmPassword" class="form-control" id="inputConfirmPassword" />
            	<form:errors path="confirmPassword" cssClass="text-danger" />
        	</div>
		</div>
		
		<!-- Company -->
		<div class="form-group">
			<label for="inputCompany" class="control-label col-xs-4"><spring:message code="company.label" /> </label>
        	<div class="col-xs-8">
            	<form:input type="text" path="company" class="form-control" id="inputCompany" />
        	</div>
		</div>
		
		<!-- Address -->
		<div class="form-group">
			<label for="inputAddress" class="control-label col-xs-4"><spring:message code="address.label" /> </label>
        	<div class="col-xs-8">
            	<form:input type="text" path="address" class="form-control" id="inputAddress" />
        	</div>
		</div>
		
		<!-- Phone -->
		<div class="form-group">
			<label for="inputPhone" class="control-label col-xs-4"><spring:message code="phone.label" /> </label>
        	<div class="col-xs-8">
            	<form:input type="text" path="phone" class="form-control" id="inputPhone" />
        	</div>
		</div>
		
		<!-- Mobile phone -->
		<div class="form-group">
			<label for="inputMobilePhone" class="control-label col-xs-4"><spring:message code="mobilePhone.label" /> </label>
        	<div class="col-xs-8">
            	<form:input type="text" path="mobilePhone" class="form-control" id="inputMobilePhone" />
        	</div>
		</div>
		
		<!-- Gender -->
		<div class="form-group">
			<label class="control-label col-xs-4"><spring:message code="gender.label" /> </label>
			<div class="col-xs-8 radioGroup">
				<form:radiobutton id="radMale" path="gender"	value="Male" />
				<label style="font-weight: normal;" for="radMale"><spring:message code="male.label" /></label>&nbsp;&nbsp;
				<form:radiobutton id="radFemale" path="gender"	value="Female" />
				<label style="font-weight: normal;" for="radFemale"><spring:message code="female.label" /></label>
			</div>
		</div>
		
		<!-- Captcha Image -->
		<div class="form-group">
			<label for="inputCaptcha" class="control-label col-xs-4"><spring:message code="captcha.label" /> </label>
        	<div class="col-xs-8">
            	<img id="captcha_id" name="imgCaptcha" src="captcha.jpg">
            	<a href="javascript:;" title="Change captcha text"
                        onclick="document.getElementById('captcha_id').src = 'captcha.jpg?' + Math.random();  return false">
                            <img src="<c:url value="/resources/images/captcha-refresh.png" />"> </a>
        	</div>
		</div>
		
		<!-- Captcha Text -->
		<div class="form-group">
			<label for="inputCaptcha" class="control-label col-xs-4"><spring:message code="enterImageText.label" /> </label>
        	<div class="col-xs-8">
            	<form:input type="text" path="captcha" class="form-control" id="inputCaptcha" />
            	<c:if test="${not empty captchaMsg}">
            		<span class="text-danger"><spring:message code="${captchaMsg}"/></span>
            	</c:if>
        	</div>
		</div>
		
		
		<div class="form-group">
        	<div class="col-xs-offset-2 col-xs-8">
            	<button type="submit" class="btn btn-primary"><spring:message code="signup.label" /> </button>
        	</div>
    	</div>
	</form:form>
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
