<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/admin/Layout_Admin/head_admin.jsp"%>
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
						<h1>Quản lý thông tin khách hàng</h1>
					</div>
					
				</div>
			</div>
			<!-- /.container-fluid -->
		</section>

		<!-- Main content -->
		<section class="content">
			<div class="container-fluid">
				<div class="row">
					<div class="col-12">
						<div class="card">
							<div class="card-header">
								<h3 class="card-title">Dữ liệu thông tin khách hàng</h3>
							</div>
							<!-- /.card-header -->
							<div class="card-body">
								<form method="post"
									action="${pageContext.request.contextPath }/admin/customer">
									<table id="example2" class="table table-bordered table-hover">
										<label style="padding-left: 25%; display: flex;align-items: center">Search:<input
											style="width: 50%;" name="searchemail" type="search"
											class="form-control form-control-sm"
											placeholder="Search with email"">
											<button class="btn btn-navbar" type="submit">
												<i class="fas fa-search"></i>
											</button></label>
										</form>
										<thead>
											<tr>
												<th style="text-align: center;">Tên tài khoản</th>
												<th style="text-align: center;">Email</th>
												<th style="text-align: center;">Địa chỉ</th>
												<th style="text-align: center;">Số điện thoại</th>
												<th style="text-align: center;">Chức vụ</th>
											</tr>
										</thead>
										<tbody>

											<c:forEach items="${list_customer}" var="list_customer">
												<tr align="center">
													<td><c:out value="${list_customer.name}" /></td>
													<td><c:out value="${list_customer.email}" /></td>
													<td><c:out value="${list_customer.address}" /></td>
													<td><c:out value="${list_customer.phonenum}" /></td>
													<td><c:out value="${list_customer.roles}" /></td>

													<%-- <td><c:url var="editUrl"
															value="/user/edit?id=${user.id}" /><a id="update"
														href="${editUrl}" class="btn btn-warning">Update</a></td>
													<td><c:url var="deleteUrl"
															value="/user/delete?id=${user.id}" /><a id="delete"
														href="${deleteUrl}" class="btn btn-danger">Delete</a></td> --%>
												</tr>
											</c:forEach>
										</tbody>
										<tfoot>
											<tr>
												<th style="text-align: center;">Tên tài khoản</th>
												<th style="text-align: center;">Email</th>
												<th style="text-align: center;">Địa chỉ</th>
												<th style="text-align: center;">Số điện thoại</th>
												<th style="text-align: center;">Chức vụ</th>
											</tr>
										</tfoot>
									</table>
							</div>
							<!-- /.card-body -->
						</div>

					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.container-fluid -->
		</section>
		<!-- /.content -->
</body>
<%@include file="/WEB-INF/views/admin/Layout_Admin/footer_admin.jsp"%>
<script
	src="${pageContext.request.contextPath }/template/css_js_plug_admin/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script
	src="${pageContext.request.contextPath }/template/css_js_plug_admin/bootstrap/js/bootstrap.bundle.min.js"></script>
<script
	src="${pageContext.request.contextPath }/template/css_js_plug_admin/datatables/jquery.dataTables.min.js"></script>
<script
	src="${pageContext.request.contextPath }/template/css_js_plug_admin/datatables-bs4/dataTables.bootstrap4.min.js"></script>
<script
	src="${pageContext.request.contextPath }/template/css_js_plug_admin/datatables-responsive/dataTables.responsive.min.js"></script>
<script
	src="${pageContext.request.contextPath }/template/css_js_plug_admin/datatables-responsive/responsive.bootstrap4.min.js"></script>
<script
	src="${pageContext.request.contextPath }/template/css_js_plug_admin/datatables-buttons/dataTables.buttons.min.js"></script>
<script
	src="${pageContext.request.contextPath }/template/css_js_plug_admin/datatables-buttons/buttons.bootstrap4.min.js"></script>
<script
	src="${pageContext.request.contextPath }/template/css_js_plug_admin/jszip/jszip.min.js"></script>
<script
	src="${pageContext.request.contextPath }/template/css_js_plug_admin/pdfmake/pdfmake.min.js"></script>
<script
	src="${pageContext.request.contextPath }/template/css_js_plug_admin/pdfmake/vfs_fonts.js"></script>
<script
	src="${pageContext.request.contextPath }/template/css_js_plug_admin/datatables-buttons/js/buttons.html5.min.js"></script>
<script
	src="${pageContext.request.contextPath }/template/css_js_plug_admin/datatables-buttons/js/buttons.print.min.js"></script>
<script
	src="${pageContext.request.contextPath }/template/css_js_plug_admin/datatables-buttons/js/buttons.colVis.min.js"></script>
<script>
	$(function() {

		$('#example2').DataTable({
			"paging" : true,
			"lengthChange" : false,
			"searching" : false,
			"ordering" : true,
			"info" : true,
			"autoWidth" : false,
			"responsive" : true,
		});
	});
</script>
</html>
