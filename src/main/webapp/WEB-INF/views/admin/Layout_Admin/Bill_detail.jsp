<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<%@include file="/WEB-INF/views/admin/Layout_Admin/head_admin.jsp"%>
<title>A simple, clean, and responsive HTML invoice template</title>

<!-- Favicon -->
<link rel="icon" href="./images/favicon.png" type="image/x-icon" />

<!-- Invoice styling -->
<style>
body {
	font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif;
	text-align: center;
	color: #777;
}

body h1 {
	font-weight: 300;
	margin-bottom: 0px;
	padding-bottom: 0px;
	color: #000;
}

body h3 {
	font-weight: 300;
	margin-top: 10px;
	margin-bottom: 20px;
	font-style: italic;
	color: #555;
}

body a {
	color: #06f;
}

.invoice-box {
	max-width: 800px;
	margin: auto;
	padding: 30px;
	border: 1px solid #eee;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.15);
	font-size: 16px;
	line-height: 24px;
	font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif;
	color: #555;
}

.invoice-box table {
	width: 100%;
	line-height: inherit;
	text-align: left;
	border-collapse: collapse;
}

.invoice-box table td {
	padding: 5px;
	vertical-align: top;
}

.invoice-box table tr td:nth-child(2) {
	text-align: right;
}

.invoice-box table tr.top table td {
	padding-bottom: 20px;
}

.invoice-box table tr.top table td.title {
	font-size: 45px;
	line-height: 45px;
	color: #333;
}

.invoice-box table tr.information table td {
	padding-bottom: 40px;
}

.invoice-box table tr.heading td {
	background: #eee;
	border-bottom: 1px solid #ddd;
	font-weight: bold;
}

.invoice-box table tr.details td {
	padding-bottom: 20px;
}

.invoice-box table tr.item td {
	border-bottom: 1px solid #eee;
}

.invoice-box table tr.item.last td {
	border-bottom: none;
}

.invoice-box table tr.total td:nth-child(2) {
	border-top: 2px solid #eee;
	font-weight: bold;
}

@media only screen and (max-width: 600px) {
	.invoice-box table tr.top table td {
		width: 100%;
		display: block;
		text-align: center;
	}
	.invoice-box table tr.information table td {
		width: 100%;
		display: block;
		text-align: center;
	}
}
</style>
</head>

<body>

	<br />
	<br />
	<br />

	<div class="invoice-box">
		<table>
			<tr class="top">
				<td colspan="2">
					<table>
						<tr>
							<td class="title"><img
								src="https://res.cloudinary.com/ddt8drwas/image/upload/v1677545485/templatemo_logo_pxgzbv.png"
								alt="Company logo" style="width: 100%; max-width: 300px" /></td>

							<td>mã hóa đơn #: ${bill.billid }<br /> Ngày lập: <fmt:formatDate
									pattern="dd/MM/yyyy" value="${bill.date }" /><br />

							</td>
						</tr>
					</table>
				</td>
			</tr>

			<tr class="information">
				<td colspan="2">
					<table>
						<tr>
							<td>Cửa hàng bán hoa SH2T<br />Địa chỉ giao: ${user.address }<br />
								số điện thoại: ${user.phonenum}
							</td>

							<td><br />họ và tên: ${user.name }<br />Email:
								${user.email }</td>
						</tr>
					</table>
				</td>
			</tr>

			<tr class="heading">
				<td>Hình thức thanh toán</td>

				<td></td>
			</tr>

			<tr class="details">
				<td>${bill.method }</td>

				<td></td>

			</tr>

			<tr class="heading">
				<td>sản phẩm</td>

				<td>Giá</td>
			</tr>
			<c:set var="total" value="0"></c:set>
			<%!int countCart = 0;%>
			<c:forEach var="item" items="${sessionScope.cart }"
				varStatus="status">
				<c:set var="total"
					value="${total + item.flower.price * item.quantity }"></c:set>
				<tr class="item">
					<td>${item.flower.name}x${item.quantity}</td>

					<td id="price${status.index}">${item.flower.price }</td>
				</tr>
				<%
				countCart++;
				%>

			</c:forEach>
			<script>
					let total = $
					{
						item.flower.price
					};
					
					for (var i = 0; i < ${countCart}; i++) {
						let a = total.toLocaleString('vi-VN', {
							style : 'currency',
							currency : 'VND'
						});
						let b = "price" + i;
						document.getElementById(b).innerHTML = a;
					}

					
				</script>

			<tr class="total">
				<td>Tổng</td>
				<td id="price">${total }</td>
			</tr>
			<script>
				let price = $
				{
					total
				};
				let formattedNumbers = price.toLocaleString('vi-VN', {
					style : 'currency',
					currency : 'VND'
				});
				
				document.getElementById("price").innerHTML = formattedNumbers;
			</script>
			
		</table>
	</div>


</body>
<%@include file="/WEB-INF/views/admin/Layout_Admin/footer_admin.jsp"%>

</html>