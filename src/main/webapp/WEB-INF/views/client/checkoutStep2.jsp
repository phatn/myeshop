<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@	taglib prefix="spring"	uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="welcome">
	<div class="logo"><a href="<c:url value="/"/>"><img alt="Logo" src="<c:url value="/resources/images/my-eshop.png" />"></a></div>
	<div class="checkoutStep"><spring:message code="checkout.step1.label" /></div>
</div>
<div style="clear: both; height: 30px;"></div>
<div class="checkoutStep"><spring:message code="checkout.step2.reviewOrder" /></div>
<div>
	<h1>Customer information</h1>
	<form id="checkoutOrder" action="" method="post">
	<table class="cartDetail">
		<tr>
			<td>First Name</td>
			<td>${order.customer.firstName}</td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td>${order.customer.lastName}</td>
		</tr>
		<tr>
			<td>User Name</td>
			<td>${order.customer.userName}</td>
		</tr>
		
		<tr>
			<td>Email Address</td>
			<td>${order.customer.emailAddress}</td>
		</tr>
	</table>
</form>
</div>
<c:if test="${deliveryAddress == 'DELIVERY'}">
<div style="clear: both; height: 30px;"></div>
<div class="checkoutStep"><spring:message code="checkout.step2.reviewOrder" /></div>
<div>
	<h1>Delivery Address information</h1>
	<form id="checkoutOrder" action="" method="post">
		<table class="cartDetail">
				<tr>
					<td>First Name</td>
					<td>${customer.delivery.firstName}</td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td>${customer.delivery.LastName}</td>
				</tr>
				<tr>
					<td>User Name</td>
					<td>${customer.delivery.userName}</td>
				</tr>
				<tr>
					<td>Address</td>
					<td>${customer.delivery.address}</td>
				</tr>
				<tr>
					<td>Phone</td>
					<td>${customer.delivery.phone}</td>
				</tr>
			</table>
	
</form>
</div>
</c:if>
<div>
	<c:url var="submitPaypal" value="/checkout/paypal" />
	<form action="${submitPaypal}" method="post">
	<h1>Order details</h1>
	<table class="cartDetail">
		<thead style="background-color: #443266; color: #fff">
			<tr>
				<th><spring:message code="nameProduct.label"/></th>
				<th><spring:message code="image.label"/></th>
				<th><spring:message code="totalPrice.label"/></th>
				<th><spring:message code="quantity.label"/></th>
			</tr>
		</thead>
		<c:forEach items="${order.orderLines}" var="item">
		<tr>
			<td>${item.product.attributeName.attributeValue.value}</td>
			<td><img width="65px" alt="" src="<c:url value="/resources/images/uploads/products/small/${item.product.smallImage.image}"/>"></td>
			<td>
				<c:choose>
					<c:when test="${item.quantity > 1}">
						${item.totalPrice}<br/>
						(${item.product.productPrice} each)
					</c:when>
					<c:otherwise>
						${item.totalPrice}
					</c:otherwise>
				</c:choose>
			</td>
			<td>
				${item.quantity}
			</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="2" align="right"><spring:message code="total.label"/></td>
			<td colspan="3">${order.grandTotal}</td>
		</tr>
		</table>
		<button type="submit" class="btn_paypal"><img src="https://www.paypalobjects.com/webstatic/en_US/i/buttons/checkout-logo-large.png" alt="Check out with PayPal" /></button>
	</form>
</div>

<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
    $("#header").removeAttr("id");
    $("#mainContent").css("margin-left", "0");
});
</script>
