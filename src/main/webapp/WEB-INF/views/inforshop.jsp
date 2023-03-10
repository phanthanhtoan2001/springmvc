<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.about {
  padding: 50px 0;
  background-color: #fff;
}

.about .section-title {
  font-size: 36px;
  font-weight: bold;
  color: #222;
  margin-bottom: 20px;
}

.about .section-text {
  font-size: 18px;
  color: #555;
  line-height: 1.5;
  margin-bottom: 20px;
}

.about .btn-primary {
  font-size: 18px;
  font-weight: bold;
  background-color: #f55d5d;
  border-color: #f55d5d;
  padding: 10px 20px;
  margin-top: 20px;
}

.about .btn-primary:hover {
  background-color: #fff;
  color: #f55d5d;
}

.about img {
  border-radius: 10px;
}



</style>
</head>
<body>
<jsp:include page="user/layoutshare.jsp" />
<section class="about">
  <div class="container">
    <div class="row">
      <div class="col-md-6">
        <h2 class="section-title">Chào mừng đến với Floral Shop!</h2>
        <p class="section-text">Floral Shop là nơi bạn có thể tìm thấy những bó hoa đẹp nhất, tươi nhất và chất lượng nhất. Chúng tôi tự hào là một trong những cửa hàng bán hoa hàng đầu tại địa phương và luôn cố gắng mang lại sự hài lòng cho khách hàng của mình.</p>
        <p class="section-text">Chúng tôi có một đội ngũ nhân viên tuyệt vời và đầy tâm huyết, luôn sẵn sàng giúp bạn chọn lựa những bó hoa phù hợp với mọi dịp và mức giá. Hãy đến với Floral Shop để tận hưởng sự tuyệt vời của những bông hoa!</p>
        <a href="${pageContext.request.contextPath }/flower/list" class="btn btn-primary">Khám phá cửa hàng của chúng tôi</a>
      </div>
      <div class="col-md-6">
        <img src="https://res.cloudinary.com/dju4wtxj8/image/upload/v1678265366/qydlhktj1g9dg1nhwc4p.jpg" alt="Flower Shop" class="img-fluid" style="height:80%">
      </div>
    </div>
  </div>
</section>
<jsp:include page="user/footer.jsp" />

</body>
</html>