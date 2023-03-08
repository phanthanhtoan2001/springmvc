<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<style>
.form-container {
	display: flex;
	align-items: center;
}

.form-image {
	margin-right: 20px;
	width: 100px;
	height: 100px;
	object-fit: cover;
	border-radius: 50%;
}
</style>
</head>
<body>

	<div class="form-container">
		<img
			src="https://res.cloudinary.com/dju4wtxj8/image/upload/v1678265366/qydlhktj1g9dg1nhwc4p.jpg"
			alt="Hình ảnh" class="form-image" />
			<c:url var="saveUrl" value="/user/save" />
		<form  modelAttribute="userAttr" method="POST" action="${saveUrl}">
			<input type="text" hidden="true" value="${userAttr.id}" /> 
			
			<label >Email:</label> <input
			type="email"  value="${userAttr.email}"  />
			<label>SDT:</label> <input
			type="phone" value="${userAttr.phonenum}"  />
			
			<label >Mật khẩu</label> <input type="password"
			value="${userAttr.password}"  />
			<label for="địa chỉ">Địa chỉ:</label> <input type="text"
				value="${userAttr.address}"   />
				
		<input type="submit" value="Lưu thay đổi" />
		</form>
	</div>
</body>
</html>