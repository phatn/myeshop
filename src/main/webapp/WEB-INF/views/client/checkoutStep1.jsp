<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@	taglib prefix="spring"	uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="welcome">
	<div class="logo"><a href="<c:url value="/"/>"><img alt="Logo" src="<c:url value="/resources/images/my-eshop.png" />"></a></div>
	<div class="checkoutStep"><spring:message code="checkout.step1.label" /></div>
</div>
<div style="clear: both; height: 30px;"></div>
<div class="checkoutStep"><spring:message code="checkout.step1.shippingAdress.label" /></div>
<div>
	<table>
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
			<td>${order.customer.company}</td>
		</tr>
		<tr>
			<td>Date of Birth</td>
			<td>${order.customer.dateOfBirth}</td>
		</tr>
	</table>
</div>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
    $("#header").removeAttr("id");
    $("#mainContent").css("margin-left", "0");
});
</script>
