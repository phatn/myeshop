<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@	taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<style>
	/* CSS used here will be applied after bootstrap.css */
	.carousel {
		margin-top: 0;
	}
	.item .thumb {
		cursor: pointer;
		float: left;
	}
	.item .thumb img {
		height: 25%;
		margin: 2px;
	}
	.item img {
		max-width: 450px;
  		max-height: 350px;
	}
  </style>
<div>
	<div class="packshotAndReviews">
		<div class="gallery">
			<div class="medium">
				<div id="carousel" class="carousel slide" data-ride="carousel" data-interval="false">
		            <div class="carousel-inner">
		            	<c:forEach items="${product.mediumImages}" var="mediumImage" varStatus="loop">
		            		 <div class="item <c:if test="${loop.index == 0}">active</c:if> ">
								<img src="<c:url value= "/resources/images/uploads/products/medium/"/>${mediumImage.image}" alt="" />
							</div>
						</c:forEach>
		            </div>
        		</div> 
			</div>
			<div class="thumbnail">
				<div class="clearfix">
	        		<div id="thumbcarousel" class="carousel slide" data-interval="false">
			            <div class="carousel-inner">
			            	<c:if test="${fn:length(product.tinyImages) < 5}">
			            		<div class="item active">
				            		<c:forEach items="${product.tinyImages}" var="tinyImage" varStatus="loop">
										<div data-target="#carousel" data-slide-to="{loop.index}" class="thumb">
											<img src="<c:url value= "/resources/images/uploads/products/tiny/"/>${tinyImage.image}" alt="" />
										</div>
									</c:forEach>
			                	</div>
			            	</c:if>
			            	<c:if test="${fn:length(product.tinyImages) >= 5}">
			            		<div class="item active">
				            		<c:forEach items="${product.tinyImages}" var="tinyImage" varStatus="loop">
				            			<c:if test="${loop.index < 4 }">
											<div data-target="#carousel" data-slide-to="${loop.index}" class="thumb">
												<img src="<c:url value= "/resources/images/uploads/products/tiny/"/>${tinyImage.image}" alt="" />
											</div>
										</c:if>
									</c:forEach>
			                	</div>
			            		<div class="item">
			            			<c:forEach items="${product.tinyImages}" var="tinyImage" varStatus="loop">
			            				<c:if test="${loop.index >= 4 }">
											<div data-target="#carousel" data-slide-to="${loop.index}" class="thumb">
												<img src="<c:url value= "/resources/images/uploads/products/tiny/"/>${tinyImage.image}" alt="" />
											</div>
										</c:if>
									</c:forEach>
			                	</div>
			            	</c:if>
						</div>
			            <a class="left carousel-control" href="#thumbcarousel" role="button" data-slide="prev">
			                <span class="glyphicon glyphicon-chevron-left"></span>
			            </a>
			            <a class="right carousel-control" href="#thumbcarousel" role="button" data-slide="next">
			                <span class="glyphicon glyphicon-chevron-right"></span>
			            </a>
				</div> 
	    		</div>
			</div>
		</div>
	</div>
	
	<div class="productCommon">
		<div class="basicInfos">
			<h1>${product.attributeName.attributeValue.value }</h1>
			<span><spring:message code="sku.lable"/> ${product.sku }</span>
			<div class="addToCart">
				<div style="float: left; padding-top: 20px;" class="current">${product.productPrice}</div>
				<div style="float: right; padding-top: 25px;">
					<form method="post" action="<c:url value="/cart/addToCart/"/>${product.id}">
						<spring:message code="qty.lable"/>: <input name="quantity" value="1" class="quantity" type="text">
						 <button type="submit" class="btn btn-success btn-sm"><spring:message code="addToCart.label"/></button>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="classDetails">
	<ul class="nav nav-tabs">
	    <li class="active"><a data-toggle="tab" href="#overview">Overview</a></li>
	    <li><a data-toggle="tab" href="#specifications">Specifications</a></li>
	    <li><a data-toggle="tab" href="#relatedProducts">Related Products</a></li>
	    <li><a data-toggle="tab" href="#shipping">Shipping</a></li>
	    <li><a data-toggle="tab" href="#review">Review</a></li>
	</ul>
	<div class="tab-content">
	<div id="overview" class="row list-group tab-pane fade in active">
	</div>
    <div id="specifications" class="row list-group tab-pane fade tabSpec">
	</div>
    <div id="relatedProducts" class="row list-group tab-pane fade">
    
	</div>
	<div id="shipping" class="row list-group tab-pane fade">
    
	</div>
	<div id="review" class="row list-group tab-pane fade">
    
	</div>
</div>
</div>
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
    $(".item img").click(function(){
    	$(".item img").removeClass("tinyProductActive");
    	$(this).addClass("tinyProductActive");
    });
    
});

$('[data-toggle="tab"]').click(function(e) {
	var section = $(this).attr('href');
	if(section != '#overview') {
		if(section == '#specifications') {
	    var $this = $(this);
	    var loadUrl = $this.attr('href');
	    console.log("loadUrl = " + loadUrl);
		var url =  '<c:url value ="/api/product/specification/" />' + ${product.id};
	    $.ajax({
	        	url: url,
	        	type: 'GET',
	        	dataType: 'json',
	        	contentType: 'application/json',
	        	success: function(data) {
	        		
	        		var product = data;
	        		content = '';
	       			content += '<div class="overTop">';
	       			content += 'SKU# ' + product.sku;
	       			content += '</div>';
	           		content += '<div class="tabBlock">';
	           		content += '<table class="prodDetails">';
	            	for(var i = 0; i < product.attributes.length; i++) {
	            		content += '<tr>';
	            		content += '<td>' + product.attributes[i].name + '</td>';
	            		content += '<td>' + product.attributes[i].attributeValue.value + '</td>';
	            		content += '</tr>';
	        		}
	            	content += '</table>';
	        		content += '</div>';
	        		$(loadUrl).html(content);
	        	},
	        	error: function(jqXHR, textStatus, errorThrown){
	            	alert('jqXHR:' + jqXHR + ', textStatus: ' + textStatus + 'errorThrown: ' + errorThrown);
	            }
	        });
		} else if(section == '#relatedProducts') {
			console.log("Enter relatedProducts");
			var $this = $(this);
		    var loadUrl = $this.attr('href');
		    console.log("loadUrl = " + loadUrl);
			var url =  '<c:url value ="/api/product/relatedProducts/" />' + ${product.id};
		    $.ajax({
		        	url: url,
		        	type: 'GET',
		        	dataType: 'json',
		        	contentType: 'application/json',
		        	success: function(data) {
		        		
		        		var products = data;
		        		content = '';
		        		content += '<div style="margin-left: 10px">'
		       			content += '<table>'
		            	for(var i = 0; i < products.length; i++) {
		            		content += '<tr>';
		            		content += '<td>' + products[i].attributeName.attributeValue.value + '</td>';
		            		content += '</tr>';
		        		}
		            	content += '</table>';
		        		content += '</div>';
		        		$(loadUrl).html(content);
		        	},
		        	error: function(jqXHR, textStatus, errorThrown){
		            	alert('jqXHR:' + jqXHR + ', textStatus: ' + textStatus + 'errorThrown: ' + errorThrown);
		            }
		        });
		} else if(section == '#shipping') {
			
		} else if(section == '#review') {
			
		}
	}
});
</script>


