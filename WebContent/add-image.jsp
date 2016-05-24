<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:insertTemplate template="./templates/main-template.jsp" >

	<tiles:putAttribute name="content">
	
		<div class="col-lg-12">
            <h1 class="page-header">Add an image</h1>
        </div>

		<div class="col-md-12 center-block">
			<div class="col-lg-3 col-md-4 col-xs-6 thumb">
	            <a class="thumbnail" href="#">
	            	<!-- http://placehold.it/400x300 -->
	                <img id="preview-image" class="img-responsive" src="http://placehold.it/400x300" alt="">
	            </a>
	            <form action="<%=request.getContextPath() %>/ImageUploadAction" method="post" enctype="multipart/form-data">
	            	<input name="file" type="file" class="form-control" onchange="readURL(this);" />
					<br/>
					
					<input type="text" name="description" placeholder="Description" class="form-control"/>
					<br/>
		            
		            <input type="submit" class="btn btn-primary" value="submit">
	            </form>
	        </div>
		</div>
	
	</tiles:putAttribute>
	
	<tiles:putAttribute name="javascript-source">
	
	<script type="text/javascript">
		function readURL(input) {
			if (input.files && input.files[0]) {
				var reader = new FileReader();
				
				reader.onload = function(e) {
					$('#preview-image').attr('src', e.target.result);
				};
				reader.readAsDataURL(input.files[0]);
			}
		}
	
	</script>
	
	</tiles:putAttribute>
	
</tiles:insertTemplate>