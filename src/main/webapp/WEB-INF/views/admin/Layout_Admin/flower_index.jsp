<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
						<h1>Quản lý danh sách sản phẩm</h1>
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
								<h3 class="card-title">Thông tin sản phẩm</h3>
							</div>
							<!-- /.card-header -->
							<div class="card-body">
								<form method="post"
									action="${pageContext.request.contextPath }/admin/flowerindex">
									<table id="example2" class="table table-bordered table-hover">

										<label
											style="padding-left: 25%; display: flex; align-items: center">Search:<input
											style="width: 50%;" name="searchname" type="search"
											class="form-control form-control-sm"
											placeholder="search with name flower"">
											<button class="btn btn-navbar" type="submit">
												<i class="fas fa-search"></i>
											</button></label>
										</form>
										<thead>
											<tr>
												<th style="text-align: center;">Mã hoa</th>
												<th style="text-align: center;">Hình ảnh</th>
												<th style="text-align: center;">Tên hoa</th>
												<th style="text-align: center;">Giá</th>
												<th style="text-align: center;">Số lượng còn</th>
												<th style="text-align: center;"></th>
											</tr>
										</thead>
										<tbody>

											<c:forEach items="${list_flower}" var="list_flower">
												<tr align="center">
													<td><c:out value="${list_flower.flowerid}" /></td>
													<td><img style="width: 20vw; height: 20vh;"
														src="<c:out  value="${list_flower.url}" />" alt=""
														class="img-fluid w-100"></td>
													<td><c:out value="${list_flower.name}" /></td>

													<td><span
														>
															<fmt:formatNumber value="${list_flower.price}"
																pattern="###,### VNĐ" />
													</span></td>
													<td><c:out value="${list_flower.stock}" /></td>

													 <td><c:url var="editUrl"
															value="/admin/update?id=${list_flower.flowerid}" /><a id=flowerid
														href="${editUrl}" class="btn btn-warning">Update</a></td>
													<%-- <td><c:url var="deleteUrl"
															value="/user/delete?id=${user.id}" /><a id="delete"
														href="${deleteUrl}" class="btn btn-danger">Delete</a></td>  --%>
												</tr>
											</c:forEach>
										</tbody>
										<tfoot>
											<tr>
												<th style="text-align: center;">Mã hoa</th>
												<th style="text-align: center;">Hình ảnh</th>
												<th style="text-align: center;">Tên hoa</th>
												<th style="text-align: center;">Giá</th>
												<th style="text-align: center;">Số lượng còn</th>
												<th style="text-align: center;"></th>
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
