<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="vi">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Jekyll v3.8.5">
<title>Payment</title>

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
</head>
<body class="bg-light">
	<div class="container">
		<div class="py-5 text-center">
			<img class="d-block mx-auto mb-4"
				src="https://getbootstrap.com/docs/4.3/assets/brand/bootstrap-solid.svg"
				alt="" width="72" height="72">
			<h2>Checkout form</h2>
			<p class="lead">Below is an example form built entirely with
				Bootstrap’s form controls. Each required form group has a validation
				state that can be triggered by attempting to submit the form without
				completing it.</p>
		</div>

		<div class="row">
			<div class="col-md-4 order-md-2 mb-4">
				<h4 class="d-flex justify-content-between align-items-center mb-3">
					<span class="text-muted">Your cart</span> <span
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
								<small class="text-muted">Brief description</small>
							</div> <span class="text-muted">&euro; ${item.flower.price * item.quantity }</span>
						</li>
					</c:forEach>
					<li class="list-group-item d-flex justify-content-between bg-light">
						<div class="text-success">
							<c:set var="discount" value="0"></c:set>
							<h6 class="my-0">Promo code</h6>
							<small>EXAMPLECODE</small>
						</div> <span class="text-success">&euro; -${discount }</span>
					</li>
					<li class="list-group-item d-flex justify-content-between"><span>Total
							(USD)</span> <strong>&euro; ${total }</strong></li>
				</ul>

				<form class="card p-2">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Promo code">
						<div class="input-group-append">
							<button type="submit" class="btn btn-secondary">Redeem</button>
						</div>
					</div>
				</form>
			</div>
			<div class="col-md-8 order-md-1">
				<h4 class="mb-3">Billing address</h4>
				<form class="needs-validation" novalidate action="payment/checkout"  >
					<c:set var="items" value="${sessionScope.loginsession }"></c:set>

					<div class="row">
						<div class="col-md-6 mb-3">
							<label for="fullname">Full name</label> <input type="text"
								class="form-control" id="firstName" name="firstName" placeholder="Nguyen Van A"
								value="${items.name}" required>
							<div class="invalid-feedback">Valid name is required.</div>
						</div>
						
					</div>

					<div class="mb-3">
						<label for="PhoneNum">Tel</label>
						<div class="input-group">
							<!--             <div class="input-group-prepend"> -->
							<!--               <span class="input-group-text">@</span> -->
							<!--             </div> -->
							<input type="text" class="form-control" id="PhoneNum" name="PhoneNum"
								placeholder="01235456789" value="${items.phonenum}" required>
							<div class="invalid-feedback" style="width: 100%;">Your
								Phone Number is required.</div>
						</div>
					</div>

					<div class="mb-3">
						<label for="email">Email </label> <input type="email"
							class="form-control" id="email" name="email" placeholder="you@example.com"
							value="${items.email }" required>
						<div class="invalid-feedback">Please enter a valid email
							address for shipping updates.</div>
					</div>

					<div class="mb-3">
						<label for="address">Address</label> <input type="text"
							class="form-control" id="address" name="address" placeholder="1234 Main St"
							value="${items.address}" required>
						<div class="invalid-feedback">Please enter your shipping
							address.</div>
					</div>

					<div class="mb-3">
						<label for="address2">Address 2 <span class="text-muted">(Optional)</span></label>
						<input type="text" class="form-control" id="address2" name="address2"
							placeholder="Apartment or suite">
					</div>

					<hr class="mb-4">

					<h4 class="mb-3">Payment</h4>

<%-- 					<a href="${pageContext.request.contextPath }/payment/checkout" --%>
<!-- 						class="btn btn-primary btn-lg btn-block">Checkout with Cash on -->
<!-- 						delivery</a>  -->
						<button class="btn btn-primary btn-lg btn-block" type="submit">Continue
											to checkout</button>
						<a
						href="${pageContext.request.contextPath }/payment/paymentmomo"
						class="btn btn-primary btn-lg btn-block">Checkout with momo</a>
										
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
</html>
