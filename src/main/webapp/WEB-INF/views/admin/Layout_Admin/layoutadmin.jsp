<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>S2T - Trang quản lý</title>

<!-- Favicon -->

<link href="<c:url value='/template/images_admin/logo/favicon.png'/>">

<!-- page css -->

<link rel="stylesheet" type="text/css"
	href="<c:url value='/template/vendors_admin/bootstrap-datepicker/bootstrap-datepicker.min.css'/>">
<!-- Core css -->

<link rel="stylesheet" type="text/css"
	href="<c:url value='/template/css_admin/app.min.css'/>">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>


<style>
.header .nav-wrap {
	justify-content: space-between;
}
</style>
</head>
<body>
	<div class="app">
		<div class="layout">
			<!-- Header START -->
			<div class="header">
				<div class="logo logo-dark">
					<a asp-action="Index" asp-controller="Home" asp-area="Admin"> <img
						src=<c:url value='/template/Image/icon/logo_rmbg.png'/> alt="Logo">
						<img
						src="https://cdn.discordapp.com/attachments/850673875595690014/1079949960071626782/PNgj0mssRC35XXCycRWriRxQX7NLHwKfa12DLSfvTM4MhILZpA95vFYZ5y49lQAAAABJRU5ErkJggg.png"
						alt="Logo"> <img class="logo-fold"
						src=<c:url value='/template/Image/icon/logo_rmbg.png'/> alt="Logo">
					</a>
				</div>
				<div class="logo logo-white">
					<a href="index.html"> <img
						src=<c:url value='/template/images_admin/logo/logo-white.png'/> s
						alt="Logo"> <img class="logo-fold"
						src=<c:url value='/template/Image/logo_rmbg.png'/> alt="Logo">
					</a>
				</div>
				<div class="nav-wrap">
					<ul class="nav-left">
						<li class="desktop-toggle"><a href="javascript:void(0);">
								<i class="anticon"></i>
						</a></li>
						<li class="mobile-toggle"><a href="javascript:void(0);">
								<i class="anticon"></i>
						</a></li>
						<li><span class="nav-left" style="font-weight: 400;"><strong>Hello</strong></span>
						</li>
					</ul>
					<ul class="nav-right">
						<li class="dropdown dropdown-animated scale-left">
							<div class="pointer" data-toggle="dropdown">
								<div class="avatar avatar-image  m-h-10 m-r-15">
									<img
										src=<c:url value='/template/images_admin/avatars/thumb-3.jpg'/>
										alt=""> <i class="anticon anticon-user"
										style="color: #333;"></i>
								</div>
							</div>
							<div class="p-b-15 p-t-20 dropdown-menu pop-profile">
								<!-- <a asp-area="Admin" asp-controller="EditProfile"
									asp-action="Index" class="dropdown-item d-block p-h-15 p-v-10">
									<div class="d-flex align-items-center justify-content-between">
										<div>
											<i class="anticon opacity-04 font-size-16 anticon-user"></i>
											<span class="m-l-10">Thông tin cá nhân</span>
										</div>
										<i class="anticon font-size-10 anticon-right"></i>
									</div>
								</a>  -->
								<a asp-action="Login" asp-controller="Userfunc" asp-area=""
									class="dropdown-item d-block p-h-15 p-v-10">
									<div class="d-flex align-items-center justify-content-between">
										<div>
											<i class="anticon opacity-04 font-size-16 anticon-logout"></i>
											<span class="m-l-10">Đăng xuất</span>
										</div>
										<i class="anticon font-size-10 anticon-right"></i>
									</div>
								</a>
							</div>
						</li>
					</ul>
				</div>
			</div>
			<!-- Header END -->
			<!-- Side Nav START -->
			<!-- 	@await Html.PartialAsync("_Side_Nav_PartialView") -->
			<div class="side-nav">
				<div class="side-nav-inner">
					<ul class="side-nav-menu scrollable">
						<li class="nav-item "><a class="dropdown-toggle"
							asp-action="Index" asp-controller="Home" asp-area="Admin"> <span
								class="icon-holder"> <i class="fas fa-home"></i>
							</span> <span class="title">Trang chủ</span> <span class="arrow">
									<i class="arrow-icon"></i>
							</span>
						</a></li>

						<li class="nav-item dropdown"><a class="dropdown-toggle"
							href="javascript:void(0);"> <span class="icon-holder">
									<i class="anticon anticon-build"></i>
							</span> <span class="title">Quản lý sản phẩm</span> <span class="arrow">
									<i class="arrow-icon"></i>
							</span>
						</a>
							<ul class="dropdown-menu">
								<li><a asp-area="Admin" asp-controller="Products"
									asp-action="Index">Sản phẩm</a></li>
								<li><a asp-area="Admin" asp-controller="ProductLanguages"
									asp-action="Index">Ngôn ngữ của sản phẩm</a></li>
								<li><a asp-area="Admin" asp-controller="GroupCategories"
									asp-action="Index">Nhóm danh mục</a></li>
								<li><a asp-area="Admin" asp-controller="GroupProducts"
									asp-action="Index">Danh mục sản phẩm</a></li>
								<li><a asp-area="Admin" asp-controller="Authors"
									asp-action="Index">Tác giả</a></li>
								<li><a asp-area="Admin" asp-controller="Suppliers"
									asp-action="Index">Nhà cung cấp</a></li>
								<li><a asp-area="Admin" asp-controller="Publishers"
									asp-action="Index">Nhà xuất bản</a></li>
								<li><a asp-area="Admin" asp-controller="Batches"
									asp-action="Index">Lô hàng</a></li>
								<li><a asp-area="Admin" asp-controller="Genres"
									asp-action="Index">Thể loại</a></li>
								<li><a asp-area="Admin" asp-controller="Series"
									asp-action="Index">Series</a></li>
							</ul></li>
						<li class="nav-item dropdown"><a class="dropdown-toggle"
							href="javascript:void(0);"> <span class="icon-holder">
									<i class="anticon anticon-hdd"></i>
							</span> <span class="title">Quản lý khách hàng</span> <span
								class="arrow"> <i class="arrow-icon"></i>
							</span>
						</a>
							<ul class="dropdown-menu">
								<li><a asp-area="Admin" asp-controller="Comments"
									asp-action="Index">Bình luận</a></li>
								<li><a asp-area="Admin" asp-controller="Customer"
									asp-action="Index">Khách hàng</a></li>
								<li><a asp-area="Admin" asp-controller="Staff"
									asp-action="Index">Nhân viên</a></li>

								<li><a asp-area="Admin" asp-controller="Bills"
									asp-action="Index">Duyệt đơn hàng</a></li>

							</ul></li>
						<li class="nav-item dropdown"><a class="dropdown-toggle"
							href="javascript:void(0);"> <span class="icon-holder">
									<i class="anticon anticon-pie-chart"></i>
							</span> <span class="title">Quản lý doanh số</span> <span class="arrow">
									<i class="arrow-icon"></i>
							</span>
						</a>
							<ul class="dropdown-menu">

								<li><a asp-area="Admin" asp-controller="BestSeller"
									asp-action="Index_Storage">Thống kê nhập hàng</a></li>
							</ul></li>
						<li class="nav-item dropdown"><a class="dropdown-toggle"
							href="javascript:void(0);"> <span class="icon-holder">
									<i class="anticon anticon-table"></i>
							</span> <span class="title">Quản lý hệ thống</span> <span class="arrow">
									<i class="arrow-icon"></i>
							</span>
						</a>
							<ul class="dropdown-menu">
								<li><a asp-area="Admin" asp-controller="ProductStates"
									asp-action="Index">Trạng thái sản phẩm</a></li>
								<li><a asp-area="Admin" asp-controller="BillStatus"
									asp-action="Index">Trạng thái hóa đơn</a></li>
								<li><a asp-area="Admin" asp-controller="UserRoles"
									asp-action="Index">Chức vụ</a></li>
								<li><a asp-area="Admin"
									asp-controller="FeatureBasisDetails" asp-action="Index">Quyền
										hệ thống</a></li>
							</ul></li>
						<li class="nav-item dropdown"><a class="dropdown-toggle"
							href="javascript:void(0);"> <span class="icon-holder">
									<i class="anticon anticon-form"></i>
							</span> <span class="title">Quản lý tin tức</span> <span class="arrow">
									<i class="arrow-icon"></i>
							</span>
						</a>
							<ul class="dropdown-menu">
								<li><a asp-area="Admin" asp-controller="Banners"
									asp-action="Index">Thay đổi quảng cáo</a></li>
							</ul></li>

					</ul>
				</div>
			</div>
			<!-- Side Nav END -->
			<!-- Page Container START -->
			<div class="page-container">

				<!-- Content Wrapper START -->
				<div class="main-content">
					<h1>asdasd</h1>
					<h1>asdasd</h1>
					<h1>asdasd</h1>
					<h1>asdasd</h1>
					<h1>asdasd</h1>

					<h1>asdasd</h1>
					<h1>asdasd</h1>
					<h1>asdasd</h1>
					<h1>asdasd</h1>

				</div>
				<!-- Content Wrapper END -->


			</div>
			<!-- Page Container END -->
			<!-- Search Start-->
			<div class="modal modal-left fade search" id="search-drawer">
				<div class="modal-dialog">
					<div class="modal-content">
						<div
							class="modal-header justify-content-between align-items-center">
							<h5 class="modal-title">Search</h5>
							<button type="button" class="close" data-dismiss="modal">
								<i class="anticon anticon-close"></i>
							</button>
						</div>
						<div class="modal-body scrollable">
							<div class="input-affix">
								<i class="prefix-icon anticon anticon-search"></i> <input
									type="text" class="form-control" placeholder="Search">
							</div>
							<div class="m-t-30">
								<h5 class="m-b-20">Files</h5>
								<div class="d-flex m-b-30">
									<div class="avatar avatar-cyan avatar-icon">
										<i class="anticon anticon-file-excel"></i>
									</div>
									<div class="m-l-15">
										<a href="javascript:void(0);"
											class="text-dark m-b-0 font-weight-semibold">Quater
											Report.exl</a>
										<p class="m-b-0 text-muted font-size-13">by Finance</p>
									</div>
								</div>
								<div class="d-flex m-b-30">
									<div class="avatar avatar-blue avatar-icon">
										<i class="anticon anticon-file-word"></i>
									</div>
									<div class="m-l-15">
										<a href="javascript:void(0);"
											class="text-dark m-b-0 font-weight-semibold">Documentaion.docx</a>
										<p class="m-b-0 text-muted font-size-13">by Developers</p>
									</div>
								</div>
								<div class="d-flex m-b-30">
									<div class="avatar avatar-purple avatar-icon">
										<i class="anticon anticon-file-text"></i>
									</div>
									<div class="m-l-15">
										<a href="javascript:void(0);"
											class="text-dark m-b-0 font-weight-semibold">Recipe.txt</a>
										<p class="m-b-0 text-muted font-size-13">by The Chef</p>
									</div>
								</div>
								<div class="d-flex m-b-30">
									<div class="avatar avatar-red avatar-icon">
										<i class="anticon anticon-file-pdf"></i>
									</div>
									<div class="m-l-15">
										<a href="javascript:void(0);"
											class="text-dark m-b-0 font-weight-semibold">Project
											Requirement.pdf</a>
										<p class="m-b-0 text-muted font-size-13">by Project
											Manager</p>
									</div>
								</div>
							</div>
							<div class="m-t-30">
								<h5 class="m-b-20">Members</h5>
								<div class="d-flex m-b-30">
									<div class="avatar avatar-image">
										<img
											src=<c:url value='/template/images_admin/avatars/thumb-1.jpg'/>
											alt="">
									</div>
									<div class="m-l-15">
										<a href="javascript:void(0);"
											class="text-dark m-b-0 font-weight-semibold">Erin
											Gonzales</a>
										<p class="m-b-0 text-muted font-size-13">UI/UX Designer</p>
									</div>
								</div>
								<div class="d-flex m-b-30">
									<div class="avatar avatar-image">
										<img
											src=<c:url value='/template//images_admin/avatars/thumb-2.jpg'/>
											alt="">
									</div>
									<div class="m-l-15">
										<a href="javascript:void(0);"
											class="text-dark m-b-0 font-weight-semibold">Darryl Day</a>
										<p class="m-b-0 text-muted font-size-13">Software Engineer</p>
									</div>
								</div>
								<div class="d-flex m-b-30">
									<div class="avatar avatar-image">
										<img
											src=<c:url value='/template/images_admin/avatars/thumb-3.jpg'/>
											alt="">
									</div>
									<div class="m-l-15">
										<a href="javascript:void(0);"
											class="text-dark m-b-0 font-weight-semibold">Marshall
											Nichols</a>
										<p class="m-b-0 text-muted font-size-13">Data Analyst</p>
									</div>
								</div>
							</div>
							<div class="m-t-30">
								<h5 class="m-b-20">News</h5>
								<div class="d-flex m-b-30">
									<div class="avatar avatar-image">
										<img
											src=<c:url value='/template/images_admin/others/img-1.jpg'/>
											alt="">
									</div>
									<div class="m-l-15">
										<a href="javascript:void(0);"
											class="text-dark m-b-0 font-weight-semibold">5 Best
											Handwriting Fonts</a>
										<p class="m-b-0 text-muted font-size-13">
											<i class="anticon anticon-clock-circle"></i> <span
												class="m-l-5">25 Nov 2018</span>
										</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- Search End-->
			<!-- Quick View START -->
			<div class="modal modal-right fade quick-view" id="quick-view">
				<div class="modal-dialog">
					<div class="modal-content">
						<div
							class="modal-header justify-content-between align-items-center">
							<h5 class="modal-title">Theme Config</h5>
						</div>
						<div class="modal-body scrollable">
							<div class="m-b-30">
								<h5 class="m-b-0">Header Color</h5>
								<p>Config header background color</p>
								<div class="theme-configurator d-flex m-t-10">
									<div class="radio">
										<input id="header-default" name="header-theme" type="radio"
											checked value="default"> <label for="header-default"></label>
									</div>
									<div class="radio">
										<input id="header-primary" name="header-theme" type="radio"
											value="primary"> <label for="header-primary"></label>
									</div>
									<div class="radio">
										<input id="header-success" name="header-theme" type="radio"
											value="success"> <label for="header-success"></label>
									</div>
									<div class="radio">
										<input id="header-secondary" name="header-theme" type="radio"
											value="secondary"> <label for="header-secondary"></label>
									</div>
									<div class="radio">
										<input id="header-danger" name="header-theme" type="radio"
											value="danger"> <label for="header-danger"></label>
									</div>
								</div>
							</div>
							<hr>
							<div>
								<h5 class="m-b-0">Side Nav Dark</h5>
								<p>Change Side Nav to dark</p>
								<div class="switch d-inline">
									<input type="checkbox" name="side-nav-theme-toogle"
										id="side-nav-theme-toogle"> <label
										for="side-nav-theme-toogle"></label>
								</div>
							</div>
							<hr>
							<div>
								<h5 class="m-b-0">Folded Menu</h5>
								<p>Toggle Folded Menu</p>
								<div class="switch d-inline">
									<input type="checkbox" name="side-nav-fold-toogle"
										id="side-nav-fold-toogle"> <label
										for="side-nav-fold-toogle"></label>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- Quick View END -->

		</div>
	</div>


	<!-- Core Vendors JS -->

	<script src=<c:url value='/template/js_admin/vendors.min.js'/>"></script>

	<!-- page js -->

	<script
		src=<c:url value='/template/vendors_admin/chartjs/Chart.min.js'/>"></script>
	<script
		src=<c:url value='/template/js_admin/pages/dashboard-e-commerce.js'/>"></script>

	<!-- Core JS -->

	<script src=<c:url value='/template/js_admin/app.min.js'/>"></script>

	<!-- page js -->

	<script
		src=<c:url value='/template/vendors_admin/jquery-validation/jquery.validate.min.js'/>"></script>

</body>

</html>