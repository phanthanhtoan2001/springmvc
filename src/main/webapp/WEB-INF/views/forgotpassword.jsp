<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Quên mật khẩu</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png"
	href="<c:url value='/template/images/icons/favicon.ico'/>">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value='/template/vendor/bootstrap/css/bootstrap.min.css'/>">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value='/template/fonts/font-awesome-4.7.0/css/font-awesome.min.css'/>">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value='/template/fonts/Linearicons-Free-v1.0.0/icon-font.min.css'/>">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value='/template/vendor/animate/animate.css'/>">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value='/template/vendor/css-hamburgers/hamburgers.min.css'/>">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value='/template/vendor/animsition/css/animsition.min.css'/>">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value='/template/vendor/select2/select2.min.css'/>">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value='/template/vendor/daterangepicker/daterangepicker.css'/>">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value='/template/css/util.css'/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/template/css/main.css'/>">
<!--===============================================================================================-->

<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>

<link
	href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/2.0.1/css/toastr.css"
	rel="stylesheet" />

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/2.0.1/js/toastr.js"></script>
</head>
<body>

	<div class="limiter">
		<div class="container-login100"
			style="background-image: url(<c:url value='/template/images/bg-01.jpg'/>);">
			<div class="wrap-login100 p-l-110 p-r-110 p-t-62 p-b-33">
				<form class="login100-form validate-form flex-sb flex-w"
					method="post"
					action="${pageContext.request.contextPath }/user/forgot">
						<span class="login100-form-title p-b-53"> Quên mật khẩu </span>

					<div class="p-t-31 p-b-9">
						<span class="txt1"> Email </span>
					</div>
					<div class="wrap-input100 validate-input"
						data-validate="Email is required">
						<input class="input100" type="email" name="email" > <span
							class="focus-input100"></span>
					</div>
					<div class="p-t-31 p-b-9">
						<span style="color:#ff0000;font-size: 16px;" class="txt1" > ${error} </span>
					</div>
					<div class="container-login100-form-btn m-t-17">
						<button id='login' class="login100-form-btn" type="submit">Gửi Email</button>
					</div>
					
					<div class="w-full text-center p-t-55">
						<span class="txt2"> Quay </span> <a href="${pageContext.request.contextPath }/user/login"
							class="txt2 bo1"> Trở lại </a>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!--TOAST //


	// -->
	<!-- <script type="text/javascript">
	

	$('#login').click(function() {
      	$.ajax({
            type: 'POST',
            url: '/user/login',
          
            success: function(result){
            	toastr.success('${toastshow}');
            	alert("error: ");
      	toastr.success('${toastshow}','Thanh cong',{timeOut:2000});
            },
            error: function(results){
            	toastr.success('${toastshow}');
            }
        });
    }); -->


	
	<script type="text/javascript">
		$(document).ready(function() {
			toastr.options.timeOut = 1500; // 1.5s
			 toastr.info('Xin chào!'); 
			
			$('#login').click(function() {
			
				toastr.info('Đang tiến hành!');
				
			});
		});
	</script> 

	<div id="dropDownSelect1"></div>

	<!--===============================================================================================-->
	<script
		src=<c:url value='/template/vendor/jquery/jquery-3.2.1.min.js'/>"></script>
	<!--===============================================================================================-->
	<script
		src=<c:url value='/template/vendor/animsition/js/animsition.min.js'/>"></script>
	<!--===============================================================================================-->
	<script src=<c:url value='/template/vendor/bootstrap/js/popper.js'/>"></script>
	<scriptsrc=<c:url value='/template/vendor/bootstrap/js/bootstrap.min.js'/>">
	</script> <!--===============================================================================================-->
	<script src=<c:url value='/template/vendor/select2/select2.min.js'/>"></script>
	<!--===============================================================================================-->
	<script
		src=<c:url value='/template/vendor/daterangepicker/moment.min.js'/>"></script>
	<script
		src=<c:url value='/template/vendor/daterangepicker/daterangepicker.js'/>"></script>
	<!--===============================================================================================-->
	<script
		src=<c:url value='/template/vendor/countdowntime/countdowntime.js'/>"></script>
	<!--===============================================================================================-->
	<script src=<c:url value='/template/js/main.js'/>"></script>
</body>
</html>