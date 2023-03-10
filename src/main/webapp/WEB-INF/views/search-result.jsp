
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>





<!DOCTYPE html>

<html lang="en">

<head>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

</head>

<body>



	<jsp:include page="user/layoutshare.jsp" />

	<!--------------------------------------->
	<div class="d-flex justify-content-center"
		style="margin-top: 50px; margin-bottom: 50px">
		<form class="form-inline" action="<c:url value='/flower/search'/>"
			id="search-form" style="background-color: #666; padding: 10px; border-radius: 25px;">
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
					<div class="row" id="search-results">
						<c:if test="${ not empty result}">
							<c:forEach items="${result}" var="flower">


								<div class="col-lg-3 col-md-6">
									<article class="post-grid mb-5">
										<c:url var="detailUrl"
											value="/flower/detail?id=${flower.flowerid}" />
										<a class="post-thumb mb-4 d-block" href="${detailUrl}"> <img
											style="width: 35vw; height: 35vh;"
											src="<c:out  value="${flower.url}" />" alt=""
											class="img-fluid w-100">
										</a> <span
											class="cat-name text-color font-sm font-extra text-uppercase letter-spacing">Lifestyle</span>
										<h3 class="post-title mt-1">
											<a
												href="${pageContext.request.contextPath }/flower/detail?id=${flower.flowerid}"><c:out
													value="${flower.name}" /></a>
										</h3>
										<span class="text-muted letter-spacing text-uppercase font-sm">
											<fmt:formatNumber value="${flower.price}"
												pattern="###,### VNĐ" />
										</span>
									</article>
								</div>
							</c:forEach>

						</c:if>
						<c:if test="${empty result}">
							<p style="text-align: center">Không tìm thấy sản phẩm!</p>
							<img
								src="https://res.cloudinary.com/dju4wtxj8/image/upload/v1678268475/zaijncz7lystwwacs5um.png"
								alt="Không có sản phảm">
						</c:if>
					</div>
				</div>

			</div>
		</div>
	</section>

	<jsp:include page="user/footer.jsp" />


</body>

</html>