<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/admin/Layout_Admin/head_admin.jsp"%>
</head>
<body>
	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<div class="content-header">
			<div class="container-fluid">
				<div class="row mb-2">
					<div class="col-sm-6">
						<h1 class="m-0">Trang chủ</h1>
					</div>

				</div>
				<!-- /.row -->
			</div>
			<!-- /.container-fluid -->
		</div>
		<!-- /.content-header -->
		<!-- Main content -->
		<section class="content">
			<div class="container-fluid">
				<!-- Small boxes (Stat box) -->
				<div class="row">
					<div class="col-lg-3 col-6">
						<!-- small box -->
						<div class="small-box bg-info">
							<div class="inner">
								<h3 >${neworderbill_count}<!-- <sup style="font-size: 20px">
										đơn</sup> -->
								</h3>

								<p>Đơn hàng mới hôm nay</p>
							</div>
							<div class="icon">
								<i class="ion ion-bag"></i>
							</div>
							<a href="#" class="small-box-footer">Xem thêm <i
								class="fas fa-arrow-circle-right"></i></a>
						</div>
					</div>
					<!-- ./col -->
					<div class="col-lg-3 col-6">
						<!-- small box -->
						<div class="small-box bg-success">
							<div class="inner">
								<h3>
									${countoutstock}<!-- <sup style="font-size: 20px"> Sản phẩm</sup> -->
								</h3>

								<p>Số lượng sản phẩm còn dưới 10 cái</p>
							</div>
							<div class="icon">
								<i class="ion ion-stats-bars"></i>
							</div>
							<a href="${pageContext.request.contextPath }/admin/flowerindex" class="small-box-footer">Xem thêm <i
								class="fas fa-arrow-circle-right"></i></a>
						</div>
					</div>
					<!-- ./col -->
					<div class="col-lg-3 col-6">
						<!-- small box -->
						<div class="small-box bg-warning">
							<div class="inner">
								<h3>${customer_count}<!-- <sup style="font-size: 20px">
										tài khoản</sup> -->
								</h3>

								<p>Tổng khách hàng</p>
							</div>
							<div class="icon">
								<i class="ion ion-person-add"></i>
							</div>
							<a href="${pageContext.request.contextPath }/admin/customer"
								class="small-box-footer">Xem thêm <i
								class="fas fa-arrow-circle-right"></i></a>
						</div>
					</div>
					<!-- ./col -->
					<div class="col-lg-3 col-6">
						<!-- small box -->
						<div class="small-box bg-danger">
							<div class="inner">
								<h3>${orderCountFirstWeekEndWeek_count}<!-- <sup
										style="font-size: 20px"> đơn</sup> -->
								</h3>

								<p>Số hóa đơn đã được đặt trong tuần</p>
							</div>
							<div class="icon">
								<i class="ion ion-pie-graph"></i>
							</div>
							<a href="#" class="small-box-footer">  ㅤ <!-- <i
								class="fas fa-arrow-circle-right"></i> --></a>
						</div>
					</div>
					<!-- ./col -->
				</div>
				<!-- /.row -->
				<!-- Main row -->
				<div class="row">
					<!-- Left col -->
					<section class="col-lg-7 connectedSortable">
						<!-- Custom tabs (Charts with tabs)-->
						<!-- DONUT CHART -->
						<div class="card card-danger">
							<div class="card-header">
								<h3 class="card-title">Thống kê sản phẩm bán chạy</h3>

								<div class="card-tools">
									<button type="button" class="btn btn-tool"
										data-card-widget="collapse">
										<i class="fas fa-minus"></i>
									</button>
									<!-- <button type="button" class="btn btn-tool"
										data-card-widget="remove">
										<i class="fas fa-times"></i>
									</button> -->
								</div>
							</div>
							<div class="card-body">
								<canvas id="donutChart"
									style="min-height: 250px; height: 250px; max-height: 250px; max-width: 100%;"></canvas>
							</div>
							<!-- /.card-body -->
						</div>
						<!-- /.card -->
					</section>
					<!-- /.Left col -->
					<!-- right col (We are only adding the ID to make the widgets sortable)-->
					<section class="col-lg-5 connectedSortable">
						<!-- Calendar -->
						<div class="card bg-gradient-success">
							<div class="card-header border-0">

								<h3 class="card-title">
									<i class="far fa-calendar-alt"></i> Lịch
								</h3>
								<!-- tools card -->
								<div class="card-tools">
									<!-- button with a dropdown -->

									<button type="button" class="btn btn-success btn-sm"
										data-card-widget="collapse">
										<i class="fas fa-minus"></i>
									</button>
									<!-- <button type="button" class="btn btn-success btn-sm"
										data-card-widget="remove">
										<i class="fas fa-times"></i>
									</button> -->
								</div>
								<!-- /. tools -->
							</div>
							<!-- /.card-header -->
							<div class="card-body pt-0">
								<!--The calendar -->
								<div id="calendar" style="width: 100%"></div>
							</div>
							<!-- /.card-body -->
						</div>
						<!-- /.card -->
						<!-- Map card -->
						<div class="card bg-gradient-primary" style="display: none;">
							<div class="card-header border-0">
								<h3 class="card-title">
									<i class="fas fa-map-marker-alt mr-1"></i> Visitors
								</h3>
								<!-- card tools -->
								<div class="card-tools">
									<button type="button" class="btn btn-primary btn-sm daterange"
										title="Date range">
										<i class="far fa-calendar-alt"></i>
									</button>
									<button type="button" class="btn btn-primary btn-sm"
										data-card-widget="collapse" title="Collapse">
										<i class="fas fa-minus"></i>
									</button>
								</div>
								<!-- /.card-tools -->
							</div>

							<!-- /.card-body-->

							<div class="row">
								<div class="col-4 text-center">
									<div id="sparkline-1"></div>
									<div class="text-white"></div>
								</div>
								<!-- ./col -->
								<div class="col-4 text-center">
									<div id="sparkline-2"></div>
									<div class="text-white"></div>
								</div>
								<!-- ./col -->
								<div class="col-4 text-center">
									<div id="sparkline-3"></div>
									<div class="text-white"></div>
								</div>
								<!-- ./col -->
							</div>
							<!-- /.row -->
						</div>
				</div>
				<!-- /.card -->
		</section>
		<!-- right col -->
	</div>
	<!-- /.row (main row) -->
	</div>
	<!-- /.container-fluid -->
	</section>
	<!-- /.content -->
</body>
<%@include file="/WEB-INF/views/admin/Layout_Admin/footer_admin.jsp"%>
<script>
	//-------------
	//- DONUT CHART -
	//-------------
	// Get context with jQuery - using jQuery's .get() method.
	var donutChartCanvas = $('#donutChart').get(0).getContext('2d')

	var donutData = {
		labels : [ '${bestsellername1}', '${bestsellername2}',
				'${bestsellername3}', '${bestsellername4}',
				'${bestsellername5}', ],
		datasets : [ {
			data : [ '${bestsellerquantity1}', '${bestsellerquantity2}',
					'${bestsellerquantity3}', '${bestsellerquantity4}',
					'${bestsellerquantity5}' ],
			backgroundColor : [ '#f56954', '#00a65a', '#f39c12', '#00c0ef',
					'#3c8dbc', '#d2d6de' ],
		} ]
	}
	var donutOptions = {
		maintainAspectRatio : false,
		responsive : true,
	}
	//Create pie or douhnut chart
	// You can switch between pie and douhnut using the method below.
	new Chart(donutChartCanvas, {
		type : 'doughnut',
		data : donutData,
		options : donutOptions
	})
</script>
</html>