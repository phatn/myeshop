<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.7/css/bootstrap-dialog.min.css">
<!-- Main content -->
<section class="content"> 
  <div class="row">
     	<div class="col-md-8 col-md-offset-2">
			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">Edit Category</h3>
				</div>
				<c:url var="submitEditUrl" value="/admin/category/edit" />
				<form:form role="form"  action="${submitEditUrl}" modelAttribute="category" method="post">
					<div class="box-body">
						<div class="form-group">
							<label for="exampleInputEmail1">Name</label>
							<form:input type="text" path="name" class="form-control" id="inputName" placeholder="Enter Name..." />
            				<form:errors path="name" cssClass="text-danger" />
						</div>
						<div class="form-group">
							<label for="txtAreaDescription">Description</label>
							<form:textarea path="description" class="form-control" id="txtAreaDescription" placeholder="Enter Description" rows="3" />
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Self URL</label>
							<form:input type="text" path="sefUrl" class="form-control" id="inputSelfURL" placeholder="Enter self url..." />
							<form:errors path="sefUrl" cssClass="text-danger" />
						</div>
						<div class="form-group">
							<label for="inputCode">Code</label>
							<form:input type="text" path="code" class="form-control" id="inputCode" placeholder="Enter Code..." />
            				<form:errors path="code" cssClass="text-danger" />
						</div>
						<!-- <div class="form-group">
							<label for="exampleInputFile">Image</label>
							<input id="exampleInputFile" type="file">
							<p class="help-block">Upload image for this category.</p>
						</div> -->
						<!-- <div class="checkbox">
							<label>
								<input type="checkbox">
								Check me out
							</label>
						</div> -->
					</div>
					<form:input type="hidden" path="id" class="form-control" id="inputId" value="${category.id}" />
					<input type="hidden" name="categoryId" value="${category.id}"/>
					<div class="box-footer">
						<button class="btn btn-primary" type="submit">Submit</button>
					</div>
				</form:form>
			</div>
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
function category_button_delete(action, category_name) {
	BootstrapDialog.confirm({
      title: 'WARNING',
      message: 'Warning! Delete ' + category_name + " category?",
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
              alert('Yup.');
          }else {
              alert('Nope.');
          }
      }
  });
}

$(function () {
	
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