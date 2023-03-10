<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="true"%>
<%@ page import="com.laptrinhjavaweb.model.User"%>

<!DOCTYPE html>

<html lang="en">

<head>
<meta charset="utf-8">
<title>${pageTitle}</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- theme meta -->
<meta name="theme-name" content="revolve" />

<!--Favicon-->
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">

<!-- THEME CSS
	================================================== -->
<!-- Bootstrap -->
<link
	href="${pageContext.request.contextPath}/template/Resources/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/template/Resources/themify-icons.css"
	rel="stylesheet" type="text/css" />
<!-- Themify -->
<link
	href="${pageContext.request.contextPath}/template/Resources/slick-theme.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/template/Resources/slick.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/template/Resources/owl.carousel.min.css"
	rel="stylesheet" type="text/css" />
<!-- Slick Carousel -->
<link
	href="${pageContext.request.contextPath}/template/Resources/owl.theme.default.min.css"
	rel="stylesheet" type="text/css" />

<link
	href="${pageContext.request.contextPath}/template/Resources/magnific-popup.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/template/Resources/style.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/template/fontawesome-free-6.3.0-web/css/all.min.css">

<c:url var="slickCssUrl"
	value="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.css" />
<link rel="stylesheet" type="text/css" href="${slickCssUrl}" />

<c:url var="jqueryUrl"
	value="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js" />
<script type="text/javascript" src="${jqueryUrl}"></script>

<c:url var="slickJsUrl"
	value="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.js" />
<script type="text/javascript" src="${slickJsUrl}"></script>
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/2.0.1/css/toastr.css"
	rel="stylesheet" />

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/2.0.1/js/toastr.js"></script>
<style>
.pagination li a {
	color: #495057;
	background-color: #fff;
	border: 1px solid #dee2e6;
}

.pagination li.active a {
	color: #fff;
	background-color: #007bff;
	border-color: #007bff;
}

.pagination li a:hover:not(.active) {
	color: #007bff;
	background-color: #e9ecef;
	border-color: #dee2e6;
}
</style>




</head>

<body>

	<header class="header-top bg-grey justify-content-center" style="    margin-bottom: 100px;
	">
		<div class="container">
			<div class="row align-items-center">
				<div class="col-lg-2 col-md-4 text-center d-none d-lg-block">
					<c:url var="list" value="/flower/list" />
					<a class="navbar-brand " href="${list}"> <img
						src="https://res.cloudinary.com/ddt8drwas/image/upload/v1677545485/templatemo_logo_pxgzbv.png"
						alt="" class="img-fluid">
					</a>
				</div>

				<div class="col-lg-8 col-md-12">
					<nav class="navbar navbar-expand-lg navigation-2 navigation">


						<div class="collapse navbar-collapse" id="navbar-collapse">
							<ul id="menu" class="menu navbar-nav mx-auto">
								<li class="nav-item dropdown"><a
									class="nav-link dropdown-toggle"
									href="${pageContext.request.contextPath }/flower/list"
									id="navbarDropdown" role="button" data-toggle="dropdown"
									aria-haspopup="true" aria-expanded="false"> Trang chủ </a></li>
								<li class="nav-item dropdown"><a
									class="nav-link dropdown-toggle" href="#" id="navbarDropdown2"
									role="button" data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false"> Giới thiệu </a></li>

								<li class="nav-item dropdown"><a
									class="nav-link dropdown-toggle" href="#" id="navbarDropdown3"
									role="button" data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false"> Sản phẩm </a>
									<div class="dropdown-menu" aria-labelledby="navbarDropdown3">
										<a class="dropdown-item" href="post-video.html"> Formats</a> <a
											class="dropdown-item" href="post-audio.html">Audio Format</a>
										<a class="dropdown-item" href="post-link.html">Quote
											Format</a> <a class="dropdown-item" href="post-gallery.html">Gallery
											Format</a> <a class="dropdown-item" href="post-image.html">Image
											Format</a>
									</div></li>

								<li class="nav-item"><a
									href="${pageContext.request.contextPath }/cart/index"
									class="nav-link">Giỏ Hàng</a></li>
							</ul>


						</div>
					</nav>
				</div>
			
				<div class="col-lg-2 col-md-4 col-6">
					<div class="header-socials-2 text-right d-none d-lg-block">
						<ul class="list-inline mb-0">
							<%
							User temp = (User) session.getAttribute("loginsession");
							
							if (temp == null) {
							%>
							<li class="list-inline-item"><a
								href="${pageContext.request.contextPath }/user/login"> Login
							</a></li>
							<%
							}

							else {
							%>
							<li class="list-inline-item"><a
								href="${pageContext.request.contextPath }/user/logout">
									Logout</a></li>
							<%

							%>
							<li class="list-inline-item"><a
								href="${pageContext.request.contextPath }/user/edit?id=<%=temp.getId()%>"><%=temp.getName()%>
							</a></li>

							<%
							}
							%>



						</ul>
					</div>
				</div>
			</div>
		</div>
	</header>

	<!--------------------------------------->


	<!--------------------------------------->













	<!-- ------------------------------------- -->




</body>

</html>