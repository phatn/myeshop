<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.7/css/bootstrap-dialog.min.css">
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
          <h3 class="box-title">Category</h3>
          <p style="float:right">
          	<button class="btn btn-success" type="button" name="category_create" onclick="category_button_create()">Create</button>
          </p>
        </div><!-- /.box-header -->
        <div class="box-body">
          <table id="category-info" class="table table-bordered table-hover">
            <thead>
              <tr>
                <th>No.</th> 
                <th>Name</th>
               <!--  <th>Image</th> -->
                <th>Description</th>
                <th>Sef-URL</th>
                <th>Code</th>
                <th>Products</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
            <c:choose>
            	<c:when test="${not empty categories}">
            		<c:forEach items="${categories}" var="cat" varStatus="loop">
						<tr>
			                <td>${loop.index + 1}</td> 
			                <td>${cat.description.name}</td>
			              <%--   <td>${cat.categoryImage}</td> --%>
			                <td>${cat.description.description}</td>
			                <td>${cat.description.sefUrl}</td>
			                <td>${cat.code}</td>
			                <td><a href="<c:url value="/admin/category/listProducts/${cat.id}"/>">View Products</a> </td>
			                <td>
			                	<button class="btn btn-info btn-xs" type="button" onclick="category_button_edit('${cat.id}')">Edit</button>
			                	<form id="frm_cat_delete_${cat.id}" action="<c:url value="/admin/category/delete/${cat.id}"/>" method="post">
			                		<input type="hidden" name="categoryName" value="${cat.description.name}" />
			                		<button class="btn btn-danger btn-xs" type="button" onclick="category_button_delete('${cat.id}','${cat.description.name}')">Delete</button>
								</form>
			                </td>
			              </tr>      
			    	</c:forEach>	
            	</c:when>
            	<c:otherwise>
            		<tr>
						<td colspan="7">Empty category</td>
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
function category_button_delete(category_id, category_name) {
	BootstrapDialog.confirm({
      title: 'WARNING',
      message: 'Are you sure you want to delete <strong>' + category_name + "</strong>?",
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
        	  //window.location="<c:url value='/admin/category/delete/' />" + categoryId + "/" + category_name;
        	  var frm_cat_delete = "#frm_cat_delete_" + category_id;
        	  $(frm_cat_delete).submit();
          }else {
              // Do not execute any action and close the popup
          }
      }
  });
}

// Edit category
function category_button_edit(categoryId) {
	window.location="<c:url value='/admin/category/edit/' />" + categoryId;
}

function category_button_create() {
	window.location="<c:url value='/admin/category/create' />";
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