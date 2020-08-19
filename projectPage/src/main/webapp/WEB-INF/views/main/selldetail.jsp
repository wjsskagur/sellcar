<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="assets/css/main.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources//css/bootstrap.min.css">
<style>
.a {
	background-color: #BBDEFB;
}

.carmap {
	background-color: #1C1C1C;
	padding: 10px 20px;
	align-content: center;
	color: #e5474b;
}

.c {
	background-color: #BBDEFB;
	margin: 10px 20px;
}

div {
	text-align: center;
}

th {
	background-color: #1C1C1C;
	color: white;
}
</style>

<div class="page-main-style">
	<h1 class="carmap">차량대표 사진</></h1>
	<div>
		<img src="imageView.do?carp_num=${sell.carp_num}&filename=mainimage"
			class="img-responsive" alt="Cinque Terre" width="608" height="472">
	</div>
	<table class="table table-striped table-bordered table-hover">
		<tr>
			<th><h1>차량외부사진</h1></th>
		</tr>
		<tr>
			<td><c:if test="${!empty sell.car_img1}">
					<img src="imageView.do?carp_num=${sell.carp_num}&filename=car_img1"
						class="img-responsive" alt="Cinque Terre" width="304" height="236">
				</c:if> <c:if test="${!empty sell.car_img2}">
					<img src="imageView.do?carp_num=${sell.carp_num}&filename=car_img2"
						class="img-responsive" alt="Cinque Terre" width="304" height="236">
				</c:if> <c:if test="${!empty sell.car_img3}">
					<img src="imageView.do?carp_num=${sell.carp_num}&filename=car_img3"
						class="img-responsive" alt="Cinque Terre" width="304" height="236">
				</c:if> <c:if test="${!empty sell.car_img4}">
					<img src="imageView.do?carp_num=${sell.carp_num}&filename=car_img4"
						class="img-responsive" alt="Cinque Terre" width="304" height="236">
				</c:if></td>
		</tr>
		<tr>
			<th><h1>차량내부사진</h1></th>
		</tr>
		<tr>
			<td><c:if test="${!empty sell.car_img5}">
					<img src="imageView.do?carp_num=${sell.carp_num}&filename=car_img5"
						class="img-responsive" alt="Cinque Terre" width="304" height="236">
				</c:if> <c:if test="${!empty sell.car_img6}">
					<img src="imageView.do?carp_num=${sell.carp_num}&filename=car_img6"
						class="img-responsive" alt="Cinque Terre" width="304" height="236">
				</c:if> <c:if test="${!empty sell.car_img7}">
					<img src="imageView.do?carp_num=${sell.carp_num}&filename=car_img7"
						class="img-responsive" alt="Cinque Terre" width="304" height="236">
				</c:if> <c:if test="${!empty sell.car_img8}">
					<img src="imageView.do?carp_num=${sell.carp_num}&filename=car_img8"
						class="img-responsive" alt="Cinque Terre" width="304" height="236">
				</c:if> <c:if test="${!empty sell.car_img9}">
					<img src="imageView.do?carp_num=${sell.carp_num}&filename=car_img9"
						class="img-responsive" alt="Cinque Terre" width="304" height="236">
				</c:if> <c:if test="${!empty sell.car_img10}">
					<img
						src="imageView.do?carp_num=${sell.carp_num}&filename=car_img10"
						class="img-responsive" alt="Cinque Terre" width="304" height="236">
				</c:if></td>
		</tr>
		<tr>
			<th><h1>차량 옵션</h1></th></tr>
			<tr><td><c:if test="${!empty sell.car_option}">
					<img
						src="imageView.do?carp_num=${sell.carp_num}&filename=car_option"
						class="img-responsive" alt="Cinque Terre" width=auto; height=154;>
				</c:if></td>
		</tr>
		<tr>
			<th><h1>차량 점검표</h1></th></tr>
			<tr><td><c:if test="${!empty sell.car_test}">
					<img src="imageView.do?carp_num=${sell.carp_num}&filename=car_test"
						class="img-responsive" alt="Cinque Terre" width=auto height=auto>
				</c:if></td>
		</tr>
		<tr>
			<th><h1>차량 설명</h1></th>
			
		</tr>
				<tr><td><c:if test="${!empty sell.car_content}">
				<img
						src="imageView.do?carp_num=${sell.carp_num}&filename=car_content"
						class="img-responsive" alt="Cinque Terre" width=auto height=auto>
				</c:if></td></tr>
		<tr>
			<th><h1>희망 전시장</h1></th>
		</tr>
				<tr>			<td><c:if test="${!empty sell.map_img}">
					<img
						src="imageView.do?carp_num=${sell.carp_num}&filename=map_img"
						class="img-responsive" alt="Cinque Terre" width=auto height=auto>
				</c:if></td></tr>
		<tr>
			<th><h1>차량 요약</h1></th>
		</tr>
				<tr><td><c:if test="${!empty sell.car_log}">
				<img
						src="imageView.do?carp_num=${sell.carp_num}&filename=car_log"
						class="img-responsive" alt="Cinque Terre" width=auto height=auto>
			</c:if></td></tr>
		<tr>
			<th><h1>차량 상세설명</h1></th>
		</tr>
				<tr><td colspan="2"><c:if test="${!empty sell.car_detail}">
					<img
						src="imageView.do?carp_num=${sell.carp_num}&filename=car_detail"
						class="img-responsive" alt="Cinque Terre" width=auto height=auto>
				</c:if></td></tr>
	</table>

	<div class="align-center"></div>
	<p></p>
	<hr size="1" width="100%">

	<div class="align-right">
		<input type="button" value="목록으로"
			onclick="location.href='main.do'">
	</div>
</div>