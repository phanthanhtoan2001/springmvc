
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page session="true"%>
<%@ page import="com.laptrinhjavaweb.model.User"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="utf-8">
<title>Detail - Chi tiết sản phẩm</title>
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
</head>
<body>



	<header class="header-top bg-grey justify-content-center">
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
									class="nav-link dropdown-toggle" href="${pageContext.request.contextPath }/flower/list" id="navbarDropdown"
									role="button" data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false"> Trang chủ </a></li>
								<li class="nav-item dropdown"><a
									class="nav-link dropdown-toggle" href="#" id="navbarDropdown2"
									role="button" data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false"> Giới thiệu </a></li>

								<!--  <li class="nav-item"><a href="about.html" class="nav-link"></a></li>
								<li class="nav-item"><a href="fashion.html"
									class="nav-link">Sản phẩm</a></li>-->
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

								<li class="nav-item"><a href="${pageContext.request.contextPath }cart/index"
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
							} else {
							%>
							<li class="list-inline-item"><a
								href="${pageContext.request.contextPath }/user/logout"><%=temp.getName()%>
									Logout</a></li>
							<%
							}
							%>

						</ul>
					</div>
				</div>
			</div>
		</div>
	</header>
	<section class="pt-5 padding-bottom">
		<form modelAttribute="userAttr">
			<div class="container">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

						<div class="row">
							<div class="col-md-6">
								<img src="${userAttr.url}" alt="" class="img-fluid w-100">
							</div>
							<div class="col-md-6">
								<h5 class="text-uppercase letter-spacing mb-4"></h5>
								<h1>Tên sản phẩm: ${userAttr.name}</h1>
								<h4  id="price"> </h4>
								  <script>
								  let number = ${userAttr.price};
								  let formattedNumber = number.toLocaleString('vi-VN', {style: 'currency', currency: 'VND'});
								document.getElementById("price").innerHTML = formattedNumber;
								</script>


 
								
								<h4>Mô tả: ${userAttr.description}</h4>
								<a type="button" class="btn btn-primary mt-3" href="${pageContext.request.contextPath }/cart/buy/${userAttr.flowerid}">Thêm
									vào giỏ hàng</a>
							</div>
						</div>

					</div>
				</div>
			</div>
		</form>
	</section>


	<section class="footer-2 section-padding gray-bg pb-5">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-6">
					<div class="subscribe-footer text-center">
						<div class="form-group mb-0">
							<h2 class="mb-3">Subscribe Newsletter</h2>
							<p class="mb-4">Subscribe my Newsletter for new blog posts ,
								tips and info.
							<p>
							<div class="form-group form-row align-items-center mb-0">
								<div class="col-sm-9">
									<input type="email" class="form-control"
										placeholder="Email Address">
								</div>
								<div class="col-sm-3">
									<a href="#" class="btn btn-dark ">Subscribe</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="footer-btm mt-5 pt-4 border-top">
				<div class="row">
					<div class="col-lg-12">
						<ul class="list-inline footer-socials-2 text-center">
							<li class="list-inline-item"><a href="#">Privacy policy</a></li>
							<li class="list-inline-item"><a href="#">Support</a></li>
							<li class="list-inline-item"><a href="#">About</a></li>
							<li class="list-inline-item"><a href="#">Contact</a></li>
							<li class="list-inline-item"><a href="#">Terms</a></li>
							<li class="list-inline-item"><a href="#">Category</a></li>
						</ul>
					</div>
				</div>
				<div class="row justify-content-center">
					<div class="col-lg-6">
						<div class="copyright text-center ">
							@ copyright all reserved to <a href="https://themefisher.com/">themefisher.com</a>-2019
							Distribution <a href="https://themewagon.com">ThemeWagon.</a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>



</body>
</html>