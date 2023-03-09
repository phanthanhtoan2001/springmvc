<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.laptrinhjavaweb.model.User"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
 <link href="<c:url value="/resources/css/cartindexrework.css" />" 
 	rel="stylesheet"> 


<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/font-awesome.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.bundle.js" />"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Giỏ hàng</title>
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/2.0.1/css/toastr.css"
	rel="stylesheet" />

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/2.0.1/js/toastr.js"></script>
<%@include file="/WEB-INF/views/user/headerpreminum.jsp"%>
</head>

<body>
	<css> </css>
	<div class="card"
		style="height: 100vh; max-width: 100vw; width: 100%; box-shadow: 0 6px 20px 0 rgba(0, 0, 0, 0.19); border-radius: 1rem; border: transparent;">
		<div class="row">
			<div class="col-md-8 cart"
				style="background-color: #fff; height: 100vh; padding: 4vh 5vh; border-bottom-left-radius: 1rem; border-top-left-radius: 1rem;">
				<div class="title">
					<div class="row">
						<div class="col">
							<h1>
								<b>Giỏ hàng</b>
							</h1>
						</div>
						<c:set var="count" value="${sessionScope.cart.size()}"></c:set>
						<div class="col align-self-center text-right text-muted"
							style="font-size: x-large">${count } items</div>
					</div>
				</div>
				<c:set var="total" value="0"></c:set>
				<c:forEach var="item" items="${sessionScope.cart }">
					<c:set var="total"
						value="${total + item.flower.price * item.quantity }"></c:set>
					<div class="row border-top border-bottom" style="height: 200px">
						<div class="row main align-items-center" style="width: 10000px">
							<hr>
							<div class="col-2">
								<img class="img-fluid" style="width:1000px; height:150px"  src="${item.flower.url }">
							</div>
							<div class="col">
								<div class="row text-muted" style="font-size: x-large">${item.flower.flowerid }</div>
								<div class="row" style="font-size: x-large">${item.flower.name }</div>
							</div>
							<div class="col">
								<a 
									href="${pageContext.request.contextPath }/cart/update/${item.flower.flowerid }/MINUS " style="font-size: x-large">- </a><a
									href="#" class="border" style="font-size: x-large" >${item.quantity }</a><a
									href="${pageContext.request.contextPath }/cart/update/${item.flower.flowerid }/PLUS" style="font-size: x-large"> +</a>
							</div>
							<div class="col" style="font-size: x-large">
								<fmt:formatNumber type="number" pattern="#,##0"
									value="${item.flower.price * item.quantity }" />
								VNĐ <span><a style="font-size: x-large; margin-left:100px"
									href="${pageContext.request.contextPath }/cart/remove/${item.flower.flowerid }"
									onclick="return confirm('Are you sure?')">Xóa</a></span>
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
						class="text-muted">Tiếp tục mua sắm</span>
				</div>
			</div>
			<div class="col-md-4 summary"
				style="background-color: #ddd; border-top-right-radius: 1rem; border-bottom-right-radius: 1rem; padding: 4vh; color: rgb(65, 65, 65);">
				<div>
					<h1 style="font-size: x-large">
						<b>Chi tiết</b>
					</h1>
				</div>
				<hr>
				<div class="row">
					<div class="col" style="font-size: x-large">ITEMS ${count }</div>
					<div class="col text-right" style="font-size: x-large">
						<fmt:formatNumber type="number" pattern="#,##0" value="${total }" />
						VNĐ
					</div>
				</div>
				<form class="needs-validation" novalidate action="payment/checkout">
					<form style="padding: 2vh;">
						<br>
						<p style="font-size: x-large">Phí ship</p>
						<select style="width:600px; height:50px;"><option class="text-muted" style="font-size: x-large">Standard-Delivery-
								&euro;5.00</option></select> <br> <br>
						<p style="font-size: x-large">Mã giảm giá</p>
						<input id="code" name="code" placeholder="Enter your code">
						${message }
					</form>
					<div class="row"
						style="border-top: 1px solid rgba(0, 0, 0, .1); padding: 2vh 0;">
						<div class="col" style="font-size: x-large">Tổng</div>
						<div class="col text-right" style="font-size: x-large">
							<fmt:formatNumber type="number" pattern="#,##0" value="${total }" />
							VNĐ
						</div>
					</div>
					<a href="${pageContext.request.contextPath }/payment" class="btn" id="payment" style=" background-color: #000;
    border-color: #000;
    color: white;
    width: 100%;
  font-size: x-large;
    margin-top: 4vh;
    padding: 1vh;
    border-radius: 0;
    margin-top:100px;">THANH
						TOÁN</a>
					<!-- 				<button class="btn">CHECKOUT</button> -->
				</form>
			</div>
		</div>

	</div>

</body>
<%@include file="/WEB-INF/views/user/footer.jsp"%>
</html>