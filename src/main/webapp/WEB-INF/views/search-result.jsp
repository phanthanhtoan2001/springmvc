
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>





<!DOCTYPE html>

<html lang="en">

<head>
<meta charset="utf-8">
<title>Home - Trang chủ</title>
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






</head>

<body>

	<header class="header-top bg-grey justify-content-center">
		<div class="container">
			<div class="row align-items-center">
				<div class="col-lg-2 col-md-4 text-center d-none d-lg-block">
					<c:url var="list" value="/home/list" />
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
									class="nav-link dropdown-toggle" href="/home/list"
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

								<li class="nav-item"><a href="contact.html"
									class="nav-link">Giỏ Hàng</a></li>
							</ul>


						</div>
					</nav>
				</div>

				<div class="col-lg-2 col-md-4 col-6">
					<div class="header-socials-2 text-right d-none d-lg-block">
						<ul class="list-inline mb-0">
							<li class="list-inline-item"><a href="#"> Logout</a></li>
							<li class="list-inline-item"><a href="#">  Login
							</a></li>

						</ul>
					</div>
				</div>
			</div>
		</div>


	</header>


	<!--------------------------------------->


	<div class="slider">
		>
		<div>
			<img
				src="https://res.cloudinary.com/ddt8drwas/image/upload/v1677564085/07_l_cr0m9m.jpg">
		</div>
		<div>
			<img
				src="https://res.cloudinary.com/ddt8drwas/image/upload/v1677564085/04_l_fnzeui.jpg">
		</div>
		<div>
			<img
				src="https://res.cloudinary.com/ddt8drwas/image/upload/v1677564085/image_01_l_t32ugb.jpg">
		</div>
		<div>
			<img
				src="https://res.cloudinary.com/ddt8drwas/image/upload/v1677564084/02_l_p0hv0k.jpg">
		</div>
		<div>
			<img
				src="https://res.cloudinary.com/ddt8drwas/image/upload/v1677564085/05_l_ehrmbg.jpg">
		</div>

	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			$('.slider').slick({
				autoplay : true,
				autoplaySpeed : 1000,
				arrows : false,
				dots : false,
				slidesToShow : 3,
				slidesToScroll : 1,
				centerMode : true,
				centerPadding : '0px',
				responsive : [ {
					breakpoint : 992,
					settings : {
						slidesToShow : 2
					}
				}, {
					breakpoint : 768,
					settings : {
						slidesToShow : 1
					}
				} ]
			});
		});
	</script>

	<!--------------------------------------->
	<div class="d-flex justify-content-center"
		style="margin-top: 50px; margin-bottom: 50px">
		<form class="form-inline" action="<c:url value='/home/search'/>"
			style="background-color: #666; padding: 10px; border-radius: 25px;">
			<div class="form-group mx-sm-3 mb-2">
				<label for="keyword" class="sr-only">Search</label> <input
					type="text" class="form-control" name="keyword"
					placeholder="Search">
			</div>
			<button type="submit" class="btn btn-primary mb-2">Search</button>
		</form>
	</div>


	<section class="section-padding">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="row">
						<c:if test="${ empty result}">
							<c:forEach items="${result}" var="flower">
								<div class="col-lg-3 col-md-6">
									<article class="post-grid mb-5">
										<c:url var="detailUrl"
											value="/home/detail?id=${flower.flowerid}" />
										<a class="post-thumb mb-4 d-block" href="${detailUrl}"> <img
											src="<c:out value="${flower.image}" />" alt=""
											class="img-fluid w-100">
										</a> <span
											class=" cat-name text-color font-sm font-extra text-uppercase letter-spacing">Lifestyle</span>
										<h3 class="post-title mt-1">
											<a href="#"><c:out value="${flower.name}" /></a>
										</h3>
										<span class="text-muted letter-spacing text-uppercase font-sm">
											<c:set var="formattedPrice">
												<fmt:formatNumber value="${flower.price}"
													pattern="###,### VNĐ" />
											</c:set> <c:out value="${formattedPrice}" />
										</span>
									</article>
								</div>
							</c:forEach>
						</c:if>
						<c:if test="${not empty result}">
							<p>Không tìm thấy sản phẩm!</p>
						</c:if>
					</div>
				</div>

				<div class="m-auto">
					<div class="pagination mt-5 pt-4">
						<ul class="list-inline ">
							<li class="list-inline-item"><a href="#" class="active">1</a></li>
							<li class="list-inline-item"><a href="#">2</a></li>
							<li class="list-inline-item"><a href="#">3</a></li>
							<li class="list-inline-item"><a href="#" class="prev-posts"><i
									class="ti-arrow-right"></i></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
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