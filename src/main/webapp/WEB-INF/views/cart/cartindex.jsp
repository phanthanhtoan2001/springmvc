<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link href="<c:url value="/resources/css/cartindex.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/font-awesome.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.bundle.js" />"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart Page</title>
</head>
<body>
	<div class="card">
		<div class="row">
			<div class="col-md-8 cart">
				<div class="title">
					<div class="row">
						<div class="col">
							<h4>
								<b>Shopping Cart</b>
							</h4>
						</div>
						<c:set var="count" value="${sessionScope.cart.size()}"></c:set>
						<div class="col align-self-center text-right text-muted">${count }
							items</div>
					</div>
				</div>
				<c:set var="total" value="0"></c:set>
				<c:forEach var="item" items="${sessionScope.cart }">
					<c:set var="total"
						value="${total + item.flower.price * item.quantity }"></c:set>
					<div class="row border-top border-bottom">
						<div class="row main align-items-center">
							<hr>
							<div class="col-2">
								<img class="img-fluid" src="https://i.imgur.com/1GrakTl.jpg">
							</div>
							<div class="col">
								<div class="row text-muted">${item.flower.flowerid }</div>
								<div class="row">${item.flower.name }</div>
							</div>
							<div class="col">
								<a
									href="${pageContext.request.contextPath }/cart/update/${item.flower.flowerid }/MINUS ">-</a><a
									href="#" class="border">${item.quantity }</a><a
									href="${pageContext.request.contextPath }/cart/update/${item.flower.flowerid }/PLUS">+</a>
							</div>
							<div class="col">
								&euro; ${item.flower.price * item.quantity } <span><a
									href="${pageContext.request.contextPath }/cart/remove/${item.flower.flowerid }"
									onclick="return confirm('Are you sure?')">Remove</a></span>
							</div>
						</div>
					</div>
				</c:forEach>
				<!-- 				<div class="row"> -->
				<!-- 					<div class="row main align-items-center"> -->
				<!-- 						<div class="col-2"> -->
				<!-- 							<img class="img-fluid" src="https://i.imgur.com/ba3tvGm.jpg"> -->
				<!-- 						</div> -->
				<!-- 						<div class="col"> -->
				<!-- 							<div class="row text-muted">Shirt</div> -->
				<!-- 							<div class="row">Cotton T-shirt</div> -->
				<!-- 						</div> -->
				<!-- 						<div class="col"> -->
				<!-- 							<a href="#">-</a><a href="#" class="border">1</a><a href="#">+</a> -->
				<!-- 						</div> -->
				<!-- 						<div class="col"> -->
				<!-- 							&euro; 44.00 <span class="close">&#10005;</span> -->
				<!-- 						</div> -->
				<!-- 					</div> -->
				<!-- 				</div> -->
				<!-- 				<div class="row border-top border-bottom"> -->
				<!-- 					<div class="row main align-items-center"> -->
				<!-- 						<div class="col-2"> -->
				<!-- 							<img class="img-fluid" src="https://i.imgur.com/pHQ3xT3.jpg"> -->
				<!-- 						</div> -->
				<!-- 						<div class="col"> -->
				<!-- 							<div class="row text-muted">Shirt</div> -->
				<!-- 							<div class="row">Cotton T-shirt</div> -->
				<!-- 						</div> -->
				<!-- 						<div class="col"> -->
				<!-- 							<a href="#">-</a><a href="#" class="border">1</a><a href="#">+</a> -->
				<!-- 						</div> -->
				<!-- 						<div class="col"> -->
				<!-- 							&euro; 44.00 <span class="close">&#10005;</span> -->
				<!-- 						</div> -->
				<!-- 					</div> -->
				<!-- 				</div> -->
				<div class="back-to-shop">
					<a href="${pageContext.request.contextPath }/flower">&leftarrow;</a><span
						class="text-muted">continue shopping</span>
				</div>
			</div>
			<div class="col-md-4 summary">
				<div>
					<h5>
						<b>Summary</b>
					</h5>
				</div>
				<hr>
				<div class="row">
					<div class="col" style="padding-left: 0;">ITEMS ${count }</div>
					<div class="col text-right">&euro; ${total }</div>
				</div>
				<form>
					<p>SHIPPING</p>
					<select><option class="text-muted">Standard-Delivery-
							&euro;5.00</option></select>
					<p>GIVE CODE</p>
					<input id="code" placeholder="Enter your code">
				</form>
				<div class="row"
					style="border-top: 1px solid rgba(0, 0, 0, .1); padding: 2vh 0;">
					<div class="col">TOTAL PRICE</div>
					<div class="col text-right">&euro; ${total }</div>
				</div>
				<a href="${pageContext.request.contextPath }/payment" class="btn">CHECKOUT</a>
<!-- 				<button class="btn">CHECKOUT</button> -->
			</div>
		</div>

	</div>
</body>
</html>