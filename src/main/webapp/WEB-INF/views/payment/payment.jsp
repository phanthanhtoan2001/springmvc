<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Jekyll v3.8.5">
<title>Thanh toán</title>

<link href="<c:url value="/resources/css/bootstrap.min.4.3.1.css" />"
	rel="stylesheet">

<link rel="canonical"
	href="https://getbootstrap.com/docs/4.3/examples/checkout/">

<!-- <!-- Bootstrap core CSS -->

<!-- <link href="/docs/4.3/dist/css/bootstrap.min.css" rel="stylesheet" -->
<!-- 	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" -->
<!-- 	crossorigin="anonymous"> -->


<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>
<!-- Custom styles for this template -->
<link href="form-validation.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/2.0.1/css/toastr.css"
	rel="stylesheet" />

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/2.0.1/js/toastr.js"></script>
<%@include file="/WEB-INF/views/user/headerpreminum.jsp"%>
</head>
<body class="bg-light">
	<div class="container">
<!-- 		<div class="py-5 text-center"> -->
<!-- 			<img class="d-block mx-auto mb-4" -->
<!-- 				src="https://getbootstrap.com/docs/4.3/assets/brand/bootstrap-solid.svg" -->
<!-- 				alt="" width="72" height="72"> -->
<!-- 			<h2>Checkout form</h2> -->
<!-- 			<p class="lead">Below is an example form built entirely with -->
<!-- 				Bootstrap’s form controls. Each required form group has a validation -->
<!-- 				state that can be triggered by attempting to submit the form without -->
<!-- 				completing it.</p> -->
<!-- 		</div> -->

		<div class="row">
			<div class="col-md-4 order-md-2 mb-4">
				<h4 class="d-flex justify-content-between align-items-center mb-3">
					<span class="text-muted">Giỏ hàng của bạn</span> <span
						class="badge badge-secondary badge-pill">${sessionScope.cart.size()}</span>
				</h4>
				<ul class="list-group mb-3">
					<c:set var="total" value="0"></c:set>
					<c:forEach var="item" items="${sessionScope.cart }">
						<c:set var="total"
							value="${total + item.flower.price * item.quantity }"></c:set>
						<li
							class="list-group-item d-flex justify-content-between lh-condensed">
							<div>
								<h6 class="my-0">${item.flower.name }x${item.quantity}</h6>
								<small class="text-muted">${item.flower.description}</small>
							</div> <span class="text-muted">
							 <fmt:formatNumber type = "number"
       pattern = "#,##0"  value = "${item.flower.price * item.quantity }" /> VNĐ
							
							
							
							</span>
						</li>
					</c:forEach>
					<li class="list-group-item d-flex justify-content-between bg-light">
						<div class="text-success">
							<c:set var="discount" value="0"></c:set>
							<h6 class="my-0">Mã giảm giá</h6>
							<small>EXAMPLECODE</small>
						</div> <span class="text-success">
						 - <fmt:formatNumber type = "number"
       pattern = "#,##0"  value = "${discount }" /> VNĐ
						
						</span>
					</li>
					<li class="list-group-item d-flex justify-content-between"><span>Tổng
							</span> <strong>
							
							
							 <fmt:formatNumber type = "number"
       pattern = "#,##0"  value = "${total }" /> VNĐ
							</strong></li>
				</ul>

				<form class="card p-2">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Promo code">
						<div class="input-group-append">
							<button type="submit" class="btn btn-secondary">đổi mã giảm giá</button>
						</div>
					</div>
				</form>
			</div>
			<div class="col-md-8 order-md-1">
				<h4 class="mb-3">Thông tin giao hàng</h4>
				<form class="needs-validation" novalidate action="payment/checkout"  >
					<c:set var="items" value="${sessionScope.loginsession }"></c:set>

					<div class="row">
						<div class="col-md-6 mb-3">
							<label for="fullname">Họ và tên</label> <input type="text"
								class="form-control" id="firstName" name="firstName" placeholder="Nguyen Van A"
								value="${items.name}" required>
							<div class="invalid-feedback">Vui lòng điền tên hợp lệ.</div>
						</div>
						
					</div>

					<div class="mb-3">
						<label for="PhoneNum">Số điện thoại</label>
						<div class="input-group">
							<!--             <div class="input-group-prepend"> -->
							<!--               <span class="input-group-text">@</span> -->
							<!--             </div> -->
							<input type="text" class="form-control" id="PhoneNum" name="PhoneNum"
								placeholder="01235456789" value="${items.phonenum}" required>
							<div class="invalid-feedback" style="width: 100%;">Vui lòng điền số điện thoại.</div>
						</div>
					</div>

					<div class="mb-3">
						<label for="email">Email </label> <input type="email"
							class="form-control" id="email" name="email" placeholder="you@example.com"
							value="${items.email }" required>
						<div class="invalid-feedback">Vui lòng điền đúng định dạng Email.</div>
					</div>

					<div class="mb-3">
						<label for="address">Địa chỉ</label> <input type="text"
							class="form-control" id="address" name="address" placeholder="1234/789 đường...quận...huyện"
							value="${items.address}" required>
						<div class="invalid-feedback">Vui lòng điền địa chỉ.</div>
					</div>

					<div class="mb-3">
						<label for="address2">Địa chỉ thứ 2 <span class="text-muted">(không bắt buộc)</span></label>
						<input type="text" class="form-control" id="address2" name="address2"
							placeholder="căn hộ hoặc chung cư">
					</div>

					<hr class="mb-4">

					<h4 class="mb-3">Cách thanh toán</h4>

<%-- 					<a href="${pageContext.request.contextPath }/payment/checkout" --%>
<!-- 						class="btn btn-primary btn-lg btn-block">Checkout with Cash on -->
<!-- 						delivery</a>  -->
						<button class="btn btn-primary btn-lg btn-block" id="COD" >Thanh toán COD</button>
						<a
						href="${pageContext.request.contextPath }/payment/paymentmomo"
						class="btn btn-primary btn-lg btn-block">Thanh toán với momo</a>
										
				</form>
			</div>
		</div>

		<footer class="my-5 pt-5 text-muted text-center text-small">
			<p class="mb-1">&copy; 2017-2019 Company Name</p>
			<ul class="list-inline">
				<li class="list-inline-item"><a href="#">Privacy</a></li>
				<li class="list-inline-item"><a href="#">Terms</a></li>
				<li class="list-inline-item"><a href="#">Support</a></li>
			</ul>
		</footer>
	</div>
	
	<script type="text/javascript">
	toastr.options = {
			  "closeButton": false,
			  "debug": false,
			  "newestOnTop": false,
			  "progressBar": false,
			  "positionClass": "toast-top-right",
			  "preventDuplicates": false,
			  "onclick": null,
			  "showDuration": "300",
			  "hideDuration": "1000",
			  "timeOut": "5000",
			  "extendedTimeOut": "1000",
			  "showEasing": "swing",
			  "hideEasing": "linear",
			  "showMethod": "fadeIn",
			  "hideMethod": "fadeOut"
			}
	
		$(document).ready(function() {
			toastr.options.timeOut = 1500; // 1.5s
			toastr.info('Xin chào!');

			$('#COD').click(function() {

				toastr.success('Thanh toán thành công');

			});
		});
	</script>
	<script src="<c:url value="/resources/js/jquery-3.3.1.slim.min.js" />"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="/docs/4.3/assets/js/vendor/jquery-slim.min.js"><\/script>')
	</script>
	<script
		src="https://getbootstrap.com/docs/4.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o"
		crossorigin="anonymous"></script>
	<script src="<c:url value="/resources/js/bootstrap.bundle.js" />"></script>
	<script src="<c:url value="/resources/js/form-validation.js" />"></script>
</body>
<%@include file="/WEB-INF/views/user/footer.jsp"%>
</html>
