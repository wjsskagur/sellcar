<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	window.onload=function() {
		var a = document.getElementsByTagName('dt');
		var b = document.getElementsByTagName('dd');
		for(var i = 0; i < a.length; i++) {
			a[i].nextElementsSibling.style.display = "none";
			a[i].onmouseover = function() {
				for(var j = 0; j < b.length; j++) {
					b[j].style.display = "none";
				}
				
				var st = this.nextElementSibling.style;
				if(st) {
					st.display = "block";
				}
			}
			a[i].onclick = function() {
				var st = this.nextElementSibling.style;
				if(st) {
					st.display = "none";
				}
			}
		}
	}
</script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<header id="header">

	<a href="${pageContext.request.contextPath}/main/main.do" class="logo">SEll
		CAR</a>
	<nav id="nav">
		 <a
			href="${pageContext.request.contextPath}/search/searchList.do">개요</a>
		<a href="${pageContext.request.contextPath}/search/search.do">매물
			검색</a> <a href="${pageContext.request.contextPath}/sell/sell.do">내차
			팔기</a> 
			<a href="${pageContext.request.contextPath}/carre/carrelist.do">차량 후기</a>
			<a href="${pageContext.request.contextPath}/member/myPage.do">마이페이지</a> <a
			href="${pageContext.request.contextPath}/board/center.do">고객센터</a>
				
	</nav>
	</header>
<a href="#menu" class="navPanelToggle"><span class="fa fa-bars"></span></a>












