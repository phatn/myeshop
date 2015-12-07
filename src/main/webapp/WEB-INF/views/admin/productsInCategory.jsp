<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.7/css/bootstrap-dialog.min.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Main content -->
<section class="content"> 
	<c:if test="${not empty message}">
		<div class="alert alert-success" role="alert">
	  		<strong>${message}</strong>
		</div>
	</c:if>
  <div class="row">
    <div class="col-xs-12">
      <div class="box">
        <div class="box-header">
          <h3 class="box-title">Products</h3>
          <p style="float:right">
          	<button class="btn btn-success" type="button" name="product_create" onclick="product_button_create()">Create</button>
          </p>
        </div><!-- /.box-header -->
        <div class="box-body">
          <table id="category_info" class="table table-bordered table-hover">
            <thead>
              <tr>
                <th>No.</th> 
                <th>Image</th>
                <th>Name</th>
                <th>Description</th>
                <th>Available</th>
                <th>Feature Seller</th>
                <th>New Release</th>
                <th>Clearance</th>
                <th>Price</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
            <c:choose>
            	<c:when test="${not empty products}">
            		<c:forEach items="${products}" var="product" varStatus="loop">
						<tr>
			                <td>${loop.index + 1}</td> 
			                <td><img width="60px" 
							src="<c:url value= "/resources/images/uploads/products/small/"/>${product.smallImage.image}" alt="Product Image"> </td>
			                <td>${product.attributeName.attributeValue.value}</td>
			                <td><c:if test="${not empty product.description}"><textarea rows="" cols="">${product.description}</textarea></c:if></td>
			                <td><input type="checkbox" <c:if test="${product.available}">checked="checked"</c:if> disabled="disabled"/></td>
			                <td><input type="checkbox" <c:if test="${product.featuredSeller}">checked="checked"</c:if> disabled="disabled"/></td>
			                <td><input type="checkbox" <c:if test="${product.newRelease}">checked="checked"</c:if> disabled="disabled"/></td>
			                <td><input type="checkbox" <c:if test="${product.clearance}">checked="checked"</c:if> disabled="disabled"/></td>
			                <td>${product.productPrice}</td>
			                <td>
			                	<form action="<c:url value="/admin/product/edit/${product.id}"/>">
			                		<%-- <input type="hidden" name="categoryId" value="${categoryId}" /> --%>
			                		<button class="btn btn-info btn-xs" type="submit">Edit</button>
			                	</form>
			                	<form id="frm_product_delete_${product.id}" action="<c:url value="/admin/product/delete/${product.id}"/>" method="post">
			                		<input type="hidden" name="categoryId" value="${categoryId}" />
			                		<button class="btn btn-danger btn-xs" type="button" onclick="product_button_delete('${product.id}')">Delete</button>
			                	</form>
			                </td>
			              </tr>      
			    	</c:forEach>	
            	</c:when>
            	<c:otherwise>
            		<tr>
						<td colspan="10">No products found</td>
					</tr>
            	</c:otherwise>
            </c:choose>
            </tbody>
          </table>
        </div><!-- /.box-body -->
      </div><!-- /.box -->

    </div><!-- /.col -->
  </div><!-- /.row -->
</section><!-- /.content -->

<!-- jQuery 2.1.4 -->
 <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
 <!-- Bootstrap 3.3.5 -->
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
 <!-- DataTables -->
 <script src="<c:url value = "/resources/admin/plugins/datatables/jquery.dataTables.min.js" />" ></script>
 <script src="<c:url value = "/resources/admin/plugins/datatables/dataTables.bootstrap.min.js" /> "></script>
 <!-- SlimScroll -->
 <script src="<c:url value = "/resources/admin/plugins/slimScroll/jquery.slimscroll.min.js" />" ></script>
 <!-- FastClick -->
 <script src="<c:url value = "/resources/admin/plugins/fastclick/fastclick.min.js" />" ></script>
 <!-- AdminLTE App -->
 <script src="<c:url value = "/resources/admin/dist/js/app.min.js" />" ></script>
 <!-- AdminLTE for demo purposes -->
 <script src="<c:url value = "/resources/admin/dist/js/demo.js" />" ></script>
 
 <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.7/js/bootstrap-dialog.min.js"></script>

<script>

// Delete category
function product_button_delete(product_id) {
	BootstrapDialog.confirm({
      title: 'WARNING',
      message: 'Are you sure you want to delete?',
      type: BootstrapDialog.TYPE_WARNING, // <-- Default value is BootstrapDialog.TYPE_PRIMARY
      closable: true, // <-- Default value is false
      draggable: false, // <-- Default value is false
      btnCancelLabel: 'Cancel', // <-- Default value is 'Cancel',
      btnOKLabel: 'OK', // <-- Default value is 'OK',
      btnOKClass: 'btn-warning', // <-- If you didn't specify it, dialog type will be used,
      callback: function(result) {
          // result will be true if button was click, while it will be false if users close the dialog directly.
          if(result) {
        	  // Delete category
        	  var frm_product_delete = "#frm_product_delete_" + product_id;
    		$(frm_product_delete).submit();
          }else {
              // Do not execute any action and close the popup
          }
      }
  });
}

// Edit category
function product_button_edit(productId) {
	window.location="<c:url value='/admin/product/edit/' />" + productId;
}

function product_button_create() {
	window.location="<c:url value='/admin/product/create' />";
}

$(function () {
	window.setTimeout(function() {
	    $(".alert").fadeTo(1500, 0).slideUp(500, function(){
	        $(this).remove(); 
	    });
	}, 5000);
	
	// Table paging
	$('#category-info').DataTable({
    	"paging": true,
    	"lengthChange": false,
    	"searching": false,
    	"ordering": true,
    	"info": true,
    	"autoWidth": false
  	});
		
});
</script>