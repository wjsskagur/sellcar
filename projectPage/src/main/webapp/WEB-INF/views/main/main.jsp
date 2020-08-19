<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources//css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
				<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
				<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
			</ol>
<div class="carousel-inner">
				<div class="carousel-item active">
					<img src="${pageContext.request.contextPath}/resources/images/benz.jpg" class="d-block w-100" height="400">
					<div class="carousel-caption d-none d-md-block">
						<h5>Benz</h5>
						<p>Volkswagen Approved 폭스바겐 인증 중고차</p>
					</div>
				</div>
				<div class="carousel-item">
					<img src="${pageContext.request.contextPath}/resources/images/fox.png" class="d-block w-100" height="400">
					<div class="carousel-caption d-none d-md-block">
						<h5>fox</h5>
						<p>Volkswagen Approved 폭스바겐 인증 중고차</p>
					</div>
				</div>
				<div class="carousel-item">
					<img src="${pageContext.request.contextPath}/resources/images/g70.jpg" class="d-block w-100" height="400">
					<div class="carousel-caption d-none d-md-block">
						<h5>kia</h5>
						<p>Volkswagen Approved 폭스바겐 인증 중고차</p>
					</div>
				</div>
			</div>
			<!-- Previous & Next -->
			<a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a>
			<a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
<section>
	<div class="inner">
		<h2>
			SELL CAR에서 <span>검색하세요</span>
		</h2>
		<a href="${pageContext.request.contextPath}/search/search.do" class="btn btn-primary">검색하러가기</a>
	</div>
	<div class="row text-center">
	<c:forEach var="board" items="${list}">

      <div class="col-lg-3 col-md-6 mb-4">
        <div class="card h-100">
          <img class="card-img-top" src="imageView.do?carp_num=${board.carp_num}&filename=mainimage" alt="" width= auto height="243">
          <div class="card-body">
            <h4 class="card-title">${board.car_cate1}</h4>
            <p class="card-text">${board.car_cate2}<br>${board.car_cate3}</p>
          </div>
          <div class="card-footer">
            <a href="${pageContext.request.contextPath}/main/detail.do?carp_num=${board.carp_num}" class="btn btn-primary">더보기</a>
          </div>
        </div>
      </div>
      
	</c:forEach>
    </div>

</section>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
