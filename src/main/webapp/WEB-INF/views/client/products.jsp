<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@	taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="productsBox">
	<div class="categoryHeader">${categoryName}</div>
	<div>
		<c:if test="${not empty products}">
			<c:forEach items="${products}" var="product">
				<div class="item col-xs-3 col-lg-3">
					<div class="productItem thumbnail">
						<a href="<c:url value="/product/${product.id}"/>">
							<img class="group list-group-image prodImage" 
							src="<c:url value= "/resources/images/uploads/products/small/"/>${product.smallImage.image}" alt=""> 
						</a>
						<h4 class="group inner list-group-item-heading"><a href="<c:url value="/product/${product.id}"/>">${product.attributeName.attributeValue.value }</a></h4>
						<p class="group inner list-group-item-text"></p>
						
						<div class="row">
							<div class="col-xs-12 col-md-6">
							    <p class="lead">${product.productPrice}</p>
							</div>
							<div class="col-xs-12 col-md-6">
								<a class="btn btn-sm btn-success" href="#">Add to Cart</a>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
			<c:if test="${totalPages > 1}">
			<div class="paging">
			  	<ul class="pagination">
			  		<c:if test="${currentPage > 1}">
			  			<li><a href="?page=${currentPage -1 }" title="<spring:message code="prev.label" /> ">&laquo;</a></li>
			  		</c:if>
			  		<c:forEach items="${pages}" var="page" varStatus="loop">
			  			<li <c:if test="${page == currentPage}">class="active"</c:if> ><a href="?page=${page}" title="<spring:message code="page.label" /> ${page}">${page}</a></li>
			  		</c:forEach>
			  		<c:if test="${currentPage < totalPages}">
			  			<li><a href="?page=${currentPage + 1 }" title="<spring:message code="next.label" /> ">&raquo;</a></li>
			  		</c:if>
				</ul>
			</div>
			</c:if>
		</c:if>
		<c:if test="${empty products}">
			<h2 style="color:red">No products found.</h2>
		</c:if>
	</div>
</div>