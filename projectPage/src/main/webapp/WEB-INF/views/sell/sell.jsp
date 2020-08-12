<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- <link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/sell.css" /> --%>
<%-- <link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/jquery-ui.min.css"> --%>

<script type="text/javascript">
	
</script>

<title>내차 팔기 신청</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/sell-main.css" />

<section id="banner">
	<div class="inner">
		<header>
			<h1>내차 팔기</h1>
			
		</header>
		<c:if test="${empty user_id}">
		<a href="${pageContext.request.contextPath}/member/login.do" class="button big scrolly">로그인 후 이용가능합니다</a>
		</c:if>
		<c:if test="${!empty user_id}">
		<a href="${pageContext.request.contextPath}/main/main.do" class="button big scrolly">내차 팔기 알아보기</a>
		<a href="#insert" class="button big scrolly">차량 정보 등록</a>
		<a href="${pageContext.request.contextPath}/sell/sellview.do" class="button big scrolly">내차 사진등록</a>
		</c:if>
	</div>
</section>
<div id="insert">
<c:if test="${!empty user_id}">
	<!-- Section -->
	<section class="wrapper style1">
		<div class="inner">
			<!-- 2 Columns -->
			<div class="flex flex-2">
				<div class="col col1">
					<div class="image round fit">
						<img src="${pageContext.request.contextPath}/resources/images/sellcar.PNG" alt="" />
					</div>
				</div>
				<div class="col col2">
					<form:form action="sell.do" commandName="sellcarVO">
				<form:hidden path="car_num" />
				<div class="in-left">
						<ul>
							<li><label for="car_number">차량번호</label> <form:input
									path="car_number" /> <form:errors path="car_number"
									cssClass="error-color" /></li>
							<li><label for="car_name">차량이름</label> <form:input
									path="car_name" /> <form:errors path="car_name"
									cssClass="error-color" /></li>
							<li><label for="car_cate1">제조사</label> <!-- <input class="popup" id="popup" type=button value="제조사 선택"> -->
								<!-- <a href="#" onclick="newPop()">제조사 선택</a> --> <form:input
									path="car_cate1" /> <form:errors path="car_cate1"
									cssClass="error-color" /></li>
							<li><label for="car_cate2">차량 모델</label> <form:input
									path="car_cate2" /> <form:errors path="car_cate2"
									cssClass="error-color" /></li>
							<li><label for="car_cate3">연식(선택)</label><br> <select
								name="car_cate3">
									<option value="2020">2020년</option>
									<option value="2019">2019년</option>
									<option value="2018">2018년</option>
									<option value="2017">2017년</option>
									<option value="2016">2016년</option>
									<option value="2015">2015년</option>
									<option value="2014">2014년</option>
									<option value="2013">2013년</option>
									<option value="2012">2012년</option>
									<option value="2011">2011년</option>
									<option value="2010">2010년</option>
									<option value="2009">2009년</option>
									<option value="2008">2008년</option>
									<option value="2007">2007년</option>
									<option value="2006">2006년</option>
									<option value="2005">2005년</option>
									<option value="2004">2004년</option>
									<option value="2003">2003년</option>
									<option value="2002">2002년</option>
									<option value="2001">2001년</option>
									<option value="2000">2000년</option>
							</select> <form:errors path="car_cate3" cssClass="error-color" /></li>
							<li><label for="car_cate4">변속기(선택)</label><br> 
								<select name="car_cate4">
									<option value="1">자동</option>
									<option value="0">수동</option>
								</select>
							 <form:errors
									path="car_cate4" cssClass="error-color" /></li>
							<li><label for="car_cate5">연료(선택)</label><br>
								<select name="car_cate5">
									<option value="가솔린">가솔린</option>
									<option value="디젤">디젤</option>
									<option value="하이브리드">하이브리드</option>
									<option value="전기">전기</option>
									<option value="수소">수소</option>
								</select>
									<form:errors path="car_cate5" cssClass="error-color" /></li>
							<li><label for="car_des">주행 거리</label> <form:input
									path="car_des" /> <form:errors path="car_des"
									cssClass="error-color" /></li>
						</ul>
					</div>
					<div class="in-right">
						<ul>
							<li><label for="car_break">사고 유무(선택)</label> 
							<select name="car_break">
									<option value="1">사고</option>
									<option value="0">무사고</option>
								</select>
							<form:errors path="car_break" cssClass="error-color" /></li>
							<li><label for="car_smoke">흡연 여부(선택)</label>
								<select name="car_smoke">
									<option value="1">흡연</option>
									<option value="0">비흡연</option>
								</select> 
							<form:errors path="car_smoke" cssClass="error-color" /></li>
							<li><label for="car_outcolor">외부 색상</label> <form:input
									path="car_outcolor" /> <form:errors path="car_outcolor"
									cssClass="error-color" /></li>
							<li><label for="car_incolor">내부 색상</label> <form:input
									path="car_incolor" /> <form:errors path="car_incolor"
									cssClass="error-color" /></li>
							<li><label for="car_work">차량 용도(선택)</label><br> 
								<select name="car_work">
									<option value="출퇴근">출퇴근</option>
									<option value="업무용">업무용</option>
									<option value="화물운송">화물운송</option>
									<option value="기타">기타</option>
								</select>
							<form:errors path="car_work"
									cssClass="error-color" /></li>
							<li><label for="car_debt">압류 저당(선택)</label> 
							<select name="car_debt">
									<option value="1">해당</option>
									<option value="0">해당되지 않음</option>
								</select> <form:errors path="car_debt"
									cssClass="error-color" /></li>
							<li><label for="car_price">차량 가격</label> <form:input
									path="car_price" /> <form:errors path="car_price"
									cssClass="error-color" /></li>
						</ul>
					</div>
					<c:if test="${!empty user_id}">
					<input type="submit" value="등록"> 
					</c:if>
					<input type="button"
						value="홈으로" onclick="location.href='main.do'">
				</form:form>
				</div>
			</div>
		</div>
	</section>
	</c:if>
</div>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-3.5.0.min.js"></script>

<script
	src="${pageContext.request.contextPath}/resources/js/jquery.scrolly.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery.scrollex.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/sell-main.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/skel.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/util.js"></script>


