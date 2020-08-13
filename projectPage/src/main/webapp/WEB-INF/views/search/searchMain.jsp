<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/search.css"
	type="text/css">
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
	<select	id="car_name" name="car_name">
		<option id="" value="" selected>차량 종류 선택</option>
		<option value="기아">기아</option>
		<option value="현대">현대</option>
		<option value="삼성">삼성</option>
		<option value="스타랙스">기아</option>
		<option value="소나타">현대</option>
		<option value="아반떼">삼성</option>
	</select> 
	<select id="car_cate1" name="car_cate1">
		<option id="" value="" selected>모델 종류 선택</option>
		<option value="기아">기아</option>
		<option value="현대">현대</option>
		<option value="삼성">삼성</option>
		<option value="FOX">기아</option>
		<option value="DAL">현대</option>
		<option value="DAL">삼성</option>
	</select> 
    <div align="right">
    <input id="submit"type="submit" value="검색">
</div>
</div>
</form>
<c:if test="${count==0}">
		<div class="result-display">등록된 게시물이 없습니다.</div>
	</c:if>
	<c:if test="${count>0}">
			<table>
				<tr>
					<th>차이름</th>
					<th>제조사</th>
					<th>세부사항</th>
				</tr>
				<c:forEach var="search" items="${list}">
					<tr>
						<td>${search.car_name}</td>
						<td>${search.car_cate1}</td>
						<td>${search.car_cate2}</td>
					</tr>
				</c:forEach>
			</table>
			<div class="align-center">${pagingHtml}</div>
		</c:if>

