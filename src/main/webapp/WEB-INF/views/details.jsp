
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

</head>
<body>

 <jsp:include page="user/layoutshare.jsp" />


	<section class="pt-5 padding-bottom">
		<form modelAttribute="userAttr" style="margin-top: 10%; margin-bottom: 10%">
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
								<a type="button" class="btn btn-primary mt-3" href="${pageContext.request.contextPath }/cart/buy/${userAttr.flowerid}/10">Thêm
									vào giỏ hàng</a>
							</div>
						</div>

					</div>
				</div>
			</div>
		</form>
	</section>

 <jsp:include page="user/footer.jsp" />


</body>
</html>