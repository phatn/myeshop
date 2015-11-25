<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@	taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#featuredSeller">Featured Sellers</a></li>
    <li><a data-toggle="tab" href="#newRelease">New Releases</a></li>
    <li><a data-toggle="tab" href="#clearance">Clearance</a></li>
</ul>
<div style="height: 10px;"></div>
<div class="tab-content">
	<div id="featuredSeller" class="row list-group tab-pane fade in active">
    	<c:forEach items="${featuredProducts}" var="product">
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
							<form method="post" action="<c:url value="/cart/addToCart/"/>${product.id}">
								<button type="submit" class="btn btn-success btn-sm"><spring:message code="addToCart.label"/></button>
							</form>
						</div>
					</div>
				
			</div>
		</div>
		</c:forEach>
	</div>
    <div id="newRelease" class="row list-group tab-pane fade">
	</div>
    <div id="clearance" class="row list-group tab-pane fade">
	</div>
</div>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script>
$('[data-toggle="tab"]').click(function(e) {
	if($(this).attr('href') != '#featuredSeller') {
    var $this = $(this);
    var loadUrl = $this.attr('href');
    console.log("loadUrl = " + loadUrl);
	var url =  '<c:url value ="/api/product/" />' + loadUrl.replace('#','');
    $.ajax({
        	url: url,
        	type: 'GET',
        	dataType: 'json',
        	contentType: 'application/json',
        	success: function(data) {
        		
        		var products = data;
        		content = '';
        		for(var i = 0; i < products.length; i++) {
        			content += '<div class="item col-xs-3 col-lg-3">';
            		content += 	'<div class="productItem thumbnail">';
            		content += '<a href="<c:url value= "/product/"/>' + products[i].id + '">';
            		content += '<img class="group list-group-image prodImage" ';
            		content += 'src="<c:url value= "/resources/images/uploads/products/small/"/>' + products[i].smallImage.image + '" atl ="">';
            		content += '</a>';
            		content += '<h4 class="group inner list-group-item-heading">';
            		content += '<a href="<c:url value= "/product/"/>' + products[i].id + '">';
            		content += products[i].attributeName.attributeValue.value;
            		content += '</a></h4>';
            		content += '<p class="group inner list-group-item-text"></p>';
            		content += '<div class="row">';
            		content += '<div class="col-xs-12 col-md-6">';
            		content += '<p class="lead">' + products[i].productPrice + '</p>';
            		content += '</div>';
            		content += '<div class="col-xs-12 col-md-6">';
					content += '<form method="post" action="<c:url value="/cart/addToCart/"/>' + products[i].id + '">';
            		content += '<button type="submit" class="btn btn-success btn-sm"><spring:message code="addToCart.label"/></button>';
            		content += '</form>'
            		content += '</div>';
            		content += '</div>';
            		content += '</div>';
            		content += '</div>';
        		}
        		$(loadUrl).html(content);
        	},
        	error: function(jqXHR, textStatus, errorThrown){
            	alert('jqXHR:' + jqXHR + ', textStatus: ' + textStatus + 'errorThrown: ' + errorThrown);
            }
        });
	}
});
</script>
