<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources//css/bootstrap.min.css">

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.5.0.min.js"></script>
	<script>
    	$(document).ready(function(){
    		$('#submit').click(function(){
    			if($('#car_name').val()==''){
    				alert('차량 종류를 선택하세요 !');
    			}
    			if($('#car_make').val()==''){
    				alert('모델 종류를 선택하세요 !');
    			}
    	})
    });
</script>
<style>
*{
	margin-bottom:50px;
	text-align:center;
}
b{
	font-size:20pt;
	margin:100px 0 100px 0;
	padding:10px;
	
}
text-align{
	text-align:center;
}
select {
	margin-top: 30px;
	padding: 7px 10px;
	font-family: inherit;
	background: url('${pageContext.request.contextPath}/resources/images/select.png') no-repeat 93% 50%;
	background-size: .8rem;
	border: 1px solid #ccc;
	border-radius: 0px;
	-webkit-appearance: none;
	-moz-appearance: none;
	appearance: none;
	font-size: 12px;
	color: #666;
	min-width: 120px;
}
input#submit{
  background-color: #A6A6A6;
  border: none;
  color: #ffffff;
  cursor: pointer;
  display: inline-block;
  font-family: 'BenchNine', Arial, sans-serif;
  font-size: 1em;
  font-size: 22px;
  line-height: 1em;
  margin: 15px 40px;
  outline: none;
  padding: 12px 40px 10px;
  position: relative;
  text-transform: uppercase;
  font-weight: 700;
}
input#text{
	width:100px;
	background-color: #D5D5D5;
	background-size: 1.5rem;
	border: 3px solid #fff;
	border-radius: 0px;
	-webkit-appearance: none;
	-moz-appearance: none;
	appearance: none;
	font-size: 20px;
	color: #666;
	min-width: 120px;
}
</style>
<form id="search" action="searchMain.do" method="get">
<div class="page-main-style">
	<b>마음속에 있는 바로 그 차! <br> 지금 검색해보세요!</b>  <br><br> 
	<select id="car_cate1" name="car_cate1">
		<option id="" value="" selected>모델 종류 선택</option>
		<option value="폭스바겐">폭스바겐</option>
		<option value="Kia">kia</option>
		<option value="BMW">BMW</option>
		<option value="HYUNDAI">HYUNDAI</option>
		<option value="DAL">현대</option>
		<option value="DAL">삼성</option>
	</select> 
	<select	id="car_name" name="car_name">
		<option id="" value="" selected>차량 종류 선택</option>
		<option value="폭스바겐 아티온2.0 TDI">폭스바겐 아티온2.0 TDI</option>
		<option value="폭스바겐 아테온 2.0 TDI 프레스티지">폭스바겐 아테온 2.0 TDI 프레스티지</option>
		<option value="Kia 뉴스포티지 TLX">Kia 뉴스포티지 TLX</option>
		<option value="BMW E71 30d">BMW E71 30d</option>
		<option value="BMW 750 Li">BMW E71 30d</option>
		<option value="HYUNDAI G330 G330">HYUNDAI G330 G330</option>
		<option value="더뉴파사트2.0">삼성</option>
	</select> 
    <div align="right">
    <input id="submit"type="submit" value="검색">
</div>
</div>
</form>
<section>
<c:if test="${count==0}">
		<div class="result-display">등록된 게시물이 없습니다.</div>
	</c:if>
	<c:if test="${count>0}">
			<div class="row text-center">
	<c:forEach var="search" items="${list}">
      <div class="col-lg-3 col-md-6 mb-4">
        <div class="card h-100">
          <img class="card-img-top" src="${pageContext.request.contextPath}/main/imageView.do?carp_num=${search.carp_num}" alt="">
          <div class="card-body">
            <h4 class="card-title">${search.car_cate1}</h4>
            <p class="card-text">${search.car_cate2}<br>${search.car_cate3}</p>
          </div>
          <div class="card-footer">
            <a href="${pageContext.request.contextPath}/main/detail.do?carp_num=${search.carp_num}" class="btn btn-primary">더보기</a>
          </div>
        </div>
      </div>
	</c:forEach>
    </div>
		</c:if>
		</section>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
