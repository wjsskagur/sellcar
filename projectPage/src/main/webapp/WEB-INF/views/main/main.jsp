<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources//css/bootstrap.min.css">
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
		<fieldset>
			<legend>차량 검색</legend>
			<div class="select">
				<span class="select-box design-select">
				<select	class="design-select" data-title="" id="mak" onchange="getModel(this.value)">
						<option value="폭스바겐">폭스바겐</option>
						<option value="BMW">BMW</option>
						<option value="HYUNDAI">HYUNDAI</option>
						<option value="Kia">Kia</option>
						<option value="Mercedes-Benz">Mercedes-Benz</option>
						<option value="기아">기아</option>
						<option value="기아자동차">기아자동차</option>
						<option value="도요타">도요타</option>
						<option value="르노삼성">르노삼성</option>
						<option value="미니">미니</option>
						<option value="벤츠">벤츠</option>
						<option value="쉐보레">쉐보레</option>
						<option value="쌍용">쌍용</option>
						<option value="아우디">아우디</option>
						<option value="포드">포드</option>
						<option value="푸조">푸조</option>
						<option value="피아트">피아트</option>
						<option value="현대">현대</option>
						<option value="현대자동차">현대자동차</option>
				</select>
				<span class="selected" data-title="">폭스바겐</span>
				<i class="arrow"></i>
				</span>
				<span class="select-box design-select">
				<select class="design-select" data-title="MODEL" id="model"	onchange="getDetailModel(this.value)">
						<option value="">모델</option>
						<option value="CC">CC</option>
						<option value="EOS">EOS</option>
						<option value="골프">골프</option>
						<option value="보라">보라</option>
						<option value="비틀">비틀</option>
						<option value="시로코">시로코</option>
						<option value="아테온">아테온</option>
						<option value="제타">제타</option>
						<option value="투아렉">투아렉</option>
						<option value="티구안">티구안</option>
						<option value="파사트">파사트</option>
						<option value="페이톤">페이톤</option>
						<option value="폴로">폴로</option>
				</select>
				<span class="selected" data-title="MODEL">모델</span><i class="arrow"></i>
				</span>
				<span class="select-box design-select"><select
					class="design-select" data-title="DETAIL" id="detailModel"
					onchange="getNowSellingItemCount()">
						<option value="">세부모델</option>
				</select><span class="selected" data-title="DETAIL">세부모델</span><i
					class="arrow"></i></span>
				<button type="button" class="btn btn-primary btn-radius"
					id="searchBtn" onclick="goList()">
					<em>검색</em>
				</button>
			</div>
		</fieldset><br>
	</div>
	<div class="row text-center">
	<c:forEach var="board" items="${list}">

      <div class="col-lg-3 col-md-6 mb-4">
        <div class="card h-100">
          <img class="card-img-top" src="imageView.do?car_num=${board.car_num}" alt="">
          <div class="card-body">
            <h4 class="card-title">${board.car_cate1}</h4>
            <p class="card-text">${board.car_cate2}<br>${board.car_cate3}</p>
          </div>
          <div class="card-footer">
            <a href="cardetail.do" class="btn btn-primary">더보기</a>
          </div>
        </div>
      </div>
      
	</c:forEach>
    </div>

</section>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
