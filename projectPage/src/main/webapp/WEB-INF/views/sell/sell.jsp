<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/sell.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery-ui.min.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
<script type="text/javascript">
	/* $(document).on('click','#popup',function(){
	  window.open('popup.do','제조사 선택','width=400, hegiht=400');
	}); */
	/* function showPopup() { window.open("popup.do", "a","width=820, height=400"); } */
	/* function newPop(){
	window.open('popup.do','제조사 선택','width=300,height=300,scrollbars=yes,left=200,top=50');
	} */
	/* $(function(){
		$('#dialog').dialog({
			autoOpen:false,
			show:{
				effect:'blind',
				duration:1000
			},
			hide:{
				effect:'blind',
				duration:1000
			}
		});
			
		
		//버튼이벤트 연결
		$('#opener').click(function(){
			$('#dialog').dialog('open');
	});
		}); */
		
		
</script>
	<div class="m">
		<div class="ti">
			<div class="ti-left">
				<input type="button" class="sell-search" value="내차 팔기 알아보기"
					onclick="location.href='home.do'">
			</div>
			<div class="ti-right">
				<input type="button" class="sell-result" value="내차 팔기 알아보기"
					onclick="location.href='home.do'">
			</div>
		</div>
		<div class="in">
			<div class="in-div">
				<form:form action="sell.do" commandName="sellcarVO">
					<div class="in-style">
						<div class="in-left">
							<ul>
								<li>
									<label for="car_number">차량번호</label>
									<form:input path="car_number" /> 
									<form:errors path="car_number" cssClass="error-color" />
								</li>
								<li>
									<label for="car_name">차량이름</label> 
									<form:input path="car_name" /> 
									<form:errors path="car_name" cssClass="error-color" />
								</li>
								<li>
									<label for="car_cate1">제조사</label> <!-- <input class="popup" id="popup" type=button value="제조사 선택"> --><!-- <a href="#" onclick="newPop()">제조사 선택</a> -->
									<form:input path="car_cate1"/>
									<form:errors path="car_cate1" cssClass="error-color"/>	
								</li>
								<li>
									<label for="car_cate2">차량 모델</label> 
									<form:input path="car_cate2" /> 
									<form:errors path="car_cate2" cssClass="error-color" />
								</li>
								<li><label for="car_cate3">연식</label> <form:input
										path="car_cate3" /> <form:errors path="car_cate3"
										cssClass="error-color" /></li>
								<li><label for="car_cate4">변속기</label><br>
									<input type="radio" name="car_cate4" value="0">수동
									<input type="radio" name="car_cate4" value="1">자동
								<form:errors path="car_cate4"
										cssClass="error-color" /></li>
								<li><label for="car_cate5">연료</label> <form:input
										path="car_cate5" /> <form:errors path="car_cate5"
										cssClass="error-color" /></li>
								<li><label for="car_des">주행 거리</label> <form:input
										path="car_des" /> <form:errors path="car_des"
										cssClass="error-color" /></li>
							</ul>
						</div>
						<div class="in-right">
							<ul>
								<li><label for="car_break">사고 유무</label> 
									<input type="radio" name="car_break" value="0">O
									<input type="radio" name="car_break" value="1">X 
								<form:errors path="car_break"
										cssClass="error-color" /></li>
								<li><label for="car_smoke">흡연 여부</label> 
									<input type="radio" name="car_smoke" value="0">O
									<input type="radio" name="car_smoke" value="1">X 
								<form:errors path="car_smoke"
										cssClass="error-color" /></li>
								<li><label for="car_outcolor">외부 색상</label> <form:input
										path="car_outcolor" /> <form:errors path="car_outcolor"
										cssClass="error-color" /></li>
								<li><label for="car_incolor">내부 색상</label> <form:input
										path="car_incolor" /> <form:errors path="car_incolor"
										cssClass="error-color" /></li>
								<li><label for="car_work">차량 용도</label> <form:input
										path="car_work" /> <form:errors path="car_work"
										cssClass="error-color" /></li>
								<li><label for="car_debt">압류 저당</label>
									<input type="radio" name="car_debt" value="0">O
									<input type="radio" name="car_debt" value="1">X
										<form:errors path="car_debt" cssClass="error-color" /></li>
								<li><label for="car_price">차량 가격</label> <form:input
										path="car_price" /> <form:errors path="car_price"
										cssClass="error-color" /></li>
							</ul>
						</div>
					</div>
					<div class="align-center">
						<input type="submit" value="등록"> 
						<input type="button" value="홈으로" onclick="location.href='main.do'">
					</div>
				</form:form>
			</div>
			
	
		</div>
	</div>
	
										