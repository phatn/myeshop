<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@	taglib prefix="spring"	uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="welcome">
	<div class="logo"><a href="<c:url value="/"/>"><img alt="Logo" src="<c:url value="/resources/images/my-eshop.png" />"></a></div>
	<div class="checkoutStep"><spring:message code="checkout.step1.label" /></div>
</div>
<div style="clear: both; height: 30px;"></div>
<h1><spring:message code="checkout.step1.shippingAdress.label" /></h1>
<div style="clear: both; height: 30px;"></div>
<div>
		<table class="deliveryInfo" style="width: 50%">
			<tr>
				<td>Name</td>
				<td>${order.customer.fullName}</td>
			</tr>
			<tr>
				<td>Email</td>
				<td>${order.customer.emailAddress}</td>
			</tr>
			<tr>
				<td>Company</td>
				<td>${order.customer.billing.companyAddress}</td>
			</tr>
			<tr>
				<td>Address</td>
				<td>${order.customer.billing.address}</td>
			</tr>
			<tr>
				<td>Phone</td>
				<td>${order.customer.billing.phone}</td>
			</tr>
		</table>
	<form action="<c:url value="/checkout/step1/billing" /> " method="post">
		<div style="padding-top: 10px;"></div>
		<button type="submit" class="btn btn-success">Continue</button>
	</form>
</div>
<br/><br/>
<div style="float: left; width: 50%;">
	<h2>Submit this address</h2>
	<c:url var="submitDeliveryUrl" value="/checkout/step1/delivery" />
	<form:form class="form-horizontal" action="${submitDeliveryUrl}" modelAttribute="delivery" method="post">
		<!-- First Name -->
		<div class="form-group">
			<label for="inputFirstName" class="control-label col-xs-3"><spring:message code="firstName.label" /> </label>
        	<div class="col-xs-9">
            	<form:input type="text" path="firstName" class="form-control" id="inputFirstName" />
            	<form:errors path="firstName" cssClass="text-danger" />
        	</div>
		</div>
		
		<!-- Last Name -->
		<div class="form-group">
			<label for="inputLastName" class="control-label col-xs-3"><spring:message code="lastName.label" /> </label>
        	<div class="col-xs-9">
            	<form:input type="text" path="lastName" class="form-control" id="inputLastName" />
            	<form:errors path="lastName" cssClass="text-danger" />
        	</div>
		</div>
		
		<!-- Company -->
		<div class="form-group">
			<label for="inputCompany" class="control-label col-xs-3"><spring:message code="company.label" /> </label>
        	<div class="col-xs-9">
            	<form:input type="text" path="company" class="form-control" id="inputCompany" />
            	<form:errors path="company" cssClass="text-danger" />
        	</div>
		</div>
		
		<!-- Address -->
		<div class="form-group">
			<label for="inputAddress" class="control-label col-xs-3"><spring:message code="address.label" /> </label>
        	<div class="col-xs-9">
            	<form:input type="text" path="address" class="form-control" id="inputAddress" />
            	<form:errors path="address" cssClass="text-danger" />
        	</div>
		</div>
		
		<!-- Phone -->
		<div class="form-group">
			<label for="inputPhone" class="control-label col-xs-3"><spring:message code="phone.label" /> </label>
        	<div class="col-xs-9">
            	<form:input type="text" path="phone" class="form-control" id="inputPhone" />
            	<form:errors path="phone" cssClass="text-danger" />
        	</div>
		</div>
		<div class="form-group">
        	<div class="col-xs-offset-3 col-xs-9">
            	<button type="submit" class="btn btn-success"><spring:message code="delivery.this.address.label" /> </button>
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
});
</script>
