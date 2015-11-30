<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@	taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<form id="shoppingCart" action="" method="post">
	<table class="cartDetail">
		<thead style="background-color: #443266; color: #fff">
			<tr>
				<th><spring:message code="nameProduct.label"/></th>
				<th><spring:message code="image.label"/></th>
				<th><spring:message code="totalPrice.label"/></th>
				<th><spring:message code="quantity.label"/></th>
				<th></th>
			</tr>
		</thead>
		
		<c:choose> 
			<c:when test="${fn:length(cart.cartItems) > 0}">
		    	<c:forEach items="${cart.cartItems}" var="item">
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
						<input type="text" name="quantities" value="${item.quantity}" style="width: 30px; text-align: center;">
						<input type="hidden" name="productIds" value="${item.product.id}"/>	
					</td>
					<td><a href="<c:url value="/cart/remove/"/>${item.product.id}"><img class="deleteCartItem" alt="" src="<c:url value="/resources/images/delete-cart-item.png" />" /></a></td>
				</tr>
				</c:forEach>
	  		</c:when>
		  	<c:otherwise>
		  		<tr>
		    	<td colspan="5"><strong><spring:message code="emptyCart.label"/></strong></td>
		    	</tr>
		  	</c:otherwise>
		</c:choose>
		<tr>
			<td colspan="2" align="right"><spring:message code="total.label"/></td>
			<td colspan="3">${cart.grandTotal}</td>
		</tr>
	</table>
	<c:if test="${fn:length(cart.cartItems) > 0}">
		<div>
			<button id="updateCart" style="margin-left: 5px" class="btn btn-success btn-sm cartAction"><spring:message code="updateCart.label"/></button>
			<button id="checkout" style="margin-left: 5px" class="btn btn-success btn-sm cartAction"><spring:message code="checkout.label"/></button>
			<a class="btn btn-success btn-sm cartAction" href="<c:url value="/"/>"><spring:message code="continueShopping.label"/></a>
		</div>
	</c:if>
</form>
	
	
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	
    $("#leftSide").css("display", "none");
  	$("#mainContent").css("margin-left", "0");
    
    $(".categoryMenu").mouseenter(function() {
    	$(this).css("cursor", "pointer");
   		$("#leftSide").css("display", "block");
    }).mouseleave(function() {
    	$("#leftSide").css("display", "none");
    });
    
    // Handle update cart
    $("#updateCart").click(function(){
    	var updateURL = "<c:url value='/cart/update' />";
    	$("#shoppingCart").attr("action", updateURL).submit();
    	return false;
    });
    
    // Handle checkout
	$("#checkout").click(function(){
		var checkoutURL = "<c:url value='/customer/checkout' />";
		$("#shoppingCart").attr("action", checkoutURL).submit();
		return false;
    });
});
</script>


