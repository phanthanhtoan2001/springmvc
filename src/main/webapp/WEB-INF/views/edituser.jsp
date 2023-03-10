<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>User Form</title>

</head>
<body>


	<jsp:include page="user/layoutshare.jsp" />

	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<div class="container-fluid">
				<div class="row mb-2">
					<div class="col-sm-6">
						<h1>Thông Tin cá nhân</h1>
					</div>

				</div>
			</div>
			<!-- /.container-fluid -->
		</section>

		<!-- Main content -->
		<section class="content" style="margin-top:10px; margin-bottom:20px">
			<div class="container-fluid">
				<div class="row">
					<!-- left column -->
					<div class="col-md-20" style="width: 100%;">
						<!-- general form elements -->
						<div class="card card-primary">
							<div class="card-header">
								<h3 class="card-title">Chỉnh sửa thông tin cá nhân</h3>
							</div>
							<!-- /.card-header -->
							<!-- form start -->
							<form method="post" modelAttribute="edituser" 
								action="${pageContext.request.contextPath }/user/updateinfor"
								accept-charset="UTF-8">
								<div class="card-body">
									<div class="form-group">
										<input style="display: none;" type="text" class="form-control"
											value="${edituser.id}" id="id" name="id"
											placeholder="Nhập tên hoa">
									</div>
									<div class="form-group">
										<label for="exampleInputEmail1">Tên </label> <input
											type="text" class="form-control" value="${edituser.name}"
											id="name" name="name" placeholder="Họ và tên">
									</div>
									<div class="form-group">
										<label for="exampleInputPassword1">Số điện thoại</label> <input
											type="text" class="form-control" value="${edituser.email}"
											id="phonenum" name="email" placeholder="Địa chỉ email">
									</div>
									<div class="form-group">
										<label for="exampleInputPassword1">Mật khẩu</label> <input
											value="${edituser.password}" type="password"
											class="form-control" id="flowerstock" name="password" readonly
											placeholder="Địa chỉ">
									</div>
									<div class="form-group">
										<label for="exampleInputPassword1">Số điện thoại</label> <input
											type="text" class="form-control" value="${edituser.phonenum}"
											id="phonenum" name="phonenum" placeholder="Số điện thoại">
									</div>
									<div class="form-group">
										<label for="exampleInputPassword1">Địa chỉ</label> <input
											value="${edituser.address}" type="text" class="form-control"
											id="flowerstock" name="address" placeholder="Địa chỉ">
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
	<jsp:include page="user/footer.jsp" />
	
</body>

</html>
