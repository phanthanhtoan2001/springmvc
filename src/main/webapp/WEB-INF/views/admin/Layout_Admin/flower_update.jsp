<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/admin/Layout_Admin/head_admin.jsp"%>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/blueimp-file-upload/9.19.1/js/jquery.fileupload.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/cloudinary-core/2.12.0/cloudinary-core-shrinkwrap.min.js"></script>
<style>
#uploaded-image {
	display: block;
	margin: auto;
	max-width: 100%;
	height: auto;
}
</style>
<!-- DataTables -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/template/css_js_plug_admin/datatables-buttons/datatables-bs4/dataTables.bootstrap4.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/template/css_js_plug_admin/datatables-buttons/datatables-responsive/responsive.bootstrap4.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/template/css_js_plug_admin/datatables-buttons/datatables-buttons/buttons.bootstrap4.min.css">
</head>
<body>
	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<div class="container-fluid">
				<div class="row mb-2">
					<div class="col-sm-6">
						<h1>Cập nhật sản phẩm</h1>
					</div>

				</div>
			</div>
			<!-- /.container-fluid -->
		</section>

		<!-- Main content -->
		<section class="content">
			<div class="container-fluid">
				<div class="row">
					<!-- left column -->
					<div class="col-md-20" style="width: 100%;">
						<!-- general form elements -->
						<div class="card card-primary">
							<div class="card-header">
								<h3 class="card-title">Chỉnh sửa phẩm</h3>
							</div>
							<!-- /.card-header -->
							<!-- form start -->
							<form method="post" modelAttribute="flowerUpdate"
					action="${pageContext.request.contextPath }/admin/update" accept-charset="UTF-8">
								<div class="card-body">
								<div class="form-group">
									 <input style="display:none;"
											type="text" class="form-control" value="${flowerUpdate.flowerid}" id="flowerid" name="flowerid"
											placeholder="Nhập tên hoa">
									</div>
									<div class="form-group">
										<label for="exampleInputEmail1">Tên hoa</label> <input
											type="text" class="form-control" value="${flowerUpdate.name}" id="flowername" name="flowername"
											placeholder="Nhập tên hoa">
									</div>
									<div class="form-group">
										<label for="exampleInputPassword1">Giá</label> <input
											type="text" class="form-control" value="<fmt:formatNumber type="number" value="${flowerUpdate.price}" pattern="###"/>" id="flowerprice" name="flowerprice"
											placeholder="Nhập giá">
									</div>
									<div class="form-group">
										<label for="exampleInputPassword1" >Số lượng nhập</label> <input value="${flowerUpdate.stock}"
											type="text" class="form-control" id="flowerstock" name="flowerstock"
											placeholder="Nhập số lượng cần thêm vào">
									</div>
									<div class="form-group">
										<label for="exampleInputPassword1" >Mô tả</label> <input
											type="text" class="form-control" value="${flowerUpdate.description}" id="flowersdecrip" name="flowersdecrip"
											placeholder="Nhập mô tả cho hoa">
									</div>
									<div class="form-group">
										<label for="exampleInputFile">Hình ảnh</label>
										<div class="input-group">
											<div class="custom-file">
												<input type="file" class="custom-file-input" id="fileupload">
												<label class="custom-file-label" for="exampleInputFile">Chọn
													file để upload</label>
											</div>

										</div>
										<img style="margin: 1% 0 1% 30%;"
											src="${flowerUpdate.url}"
											width="400vw" height="200vh" id="image" />
											<input style="display:none;" value="${flowerUpdate.url}" type="text" class="form-control" id="geturlcloud" name="geturlcloud">
									
									</div>

								</div>
								<!-- /.card-body -->

								<div class="card-footer">
									<button type="submit" class="btn btn-primary">Cập nhật</button>
								</div>
							</form>
						</div>
						<!-- /.card -->

					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
		</section>
		<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->
</body>
<%@include file="/WEB-INF/views/admin/Layout_Admin/footer_admin.jsp"%>
<script type="text/javascript">

const CLOUDINARY_URL = 'https://api.cloudinary.com/v1_1/dju4wtxj8/image/upload';
const CLOUDINARY_UPLOAD_PRESET = 'ml_default';
const image = document.querySelector('#fileupload');
image.addEventListener('change', (e) => {

    const file = e.target.files[0];
    
    const formData = new FormData();
    formData.append('file', file);
    formData.append('upload_preset', CLOUDINARY_UPLOAD_PRESET);

    fetch(CLOUDINARY_URL, {
        method: 'POST',
        body: formData,
    })
        .then(response => response.json())
        .then((data) => {
            if (data.secure_url !== '') {
               
                const uploadedFileUrl = data.secure_url;
                localStorage.setItem('passportUrl', uploadedFileUrl)
                var url = data.secure_url;
          
                document.getElementById('image').src = url;
                document.getElementById('geturlcloud').value = url;
            }
            else { alert('upload thất bại'); }
        })
        .catch(err => console.error(err));
});
      
    </script>
<!-- <script>
  function uploadFile() {
    var file = $("#myFileInput")[0].files[0];
    var formData = new FormData();
    formData.append("file", file);
    formData.append("upload_preset", "your_upload_preset_here");

    $.ajax({
      url: "https://api.cloudinary.com/v1_1/dju4wtxj8/image/upload",
      type: "POST",
      data: formData,
      processData: false,
      contentType: false,
      success: function(response) {
        // Handle successful image upload here
        console.log(response);
        var imageUrl = response.secure_url;
        // Display uploaded image 
        var img = new Image();
        img.src = imageUrl;
        document.body.appendChild(img);
      },
      error: function(error) {
        // Handle image upload error here
        console.log(error);
      }
    });
  }
</script> -->
</html>
