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
			<a href="${pageContext.request.contextPath}/board/carreview.do">차량 후기</a>
			<a href="#">마이페이지</a> <a
			href="${pageContext.request.contextPath}/board/center.do">고객센터</a>
	</nav>

</header>
<a href="#menu" class="navPanelToggle"><span class="fa fa-bars"></span></a>



<div class="align-right">
<c:if test="${user_auth == 3}">
			<dl id="menuwrapper">
				<dt>관리자 페이지</dt>
				<dd>
					<ul>
						<li><a
							href="${pageContext.request.contextPath}/management/member.do">회원
								관리</a></li>

						<li><a
							href="${pageContext.request.contextPath}/management/list.do">게시판
								관리</a></li>
					</ul>
				</dd>
			</dl>
		</c:if>
	<c:if test="${!empty user_id && user_auth > 1}">
	${user_id}님<input type="button" value="로그아웃" 
					onclick="location.href='${pageContext.request.contextPath}/member/logout.do'">	
	</c:if>
	<c:if test="${empty user_id}">
	<a href="${pageContext.request.contextPath}/member/registerAgree.do">회원가입</a>	
	<a href="${pageContext.request.contextPath}/member/login.do">로그인</a>
	</c:if>
</div>








