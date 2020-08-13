<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="assets/css/main.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources//css/bootstrap.min.css">

<div class="page-main-style">
	<h2>차량후기</h2>
	<c:if test="${count == 0}">
	<!--sadadasdsa sds-->
		<div class="result-display">등록된 게시물이 없습니다.</div>
	</c:if>
	<c:if test="${count > 0}">
			<tr
				style="background: url('../images/center.gif') repeat-x; text-align: center;">
			</tr>
				<div class="row text-center">
	<c:forEach var="carre" items="${list}">

      <div class="col-lg-3 col-md-6 mb-4">
        <div class="card h-100">
          <img class="card-img-top" src="imageView.do?num=${carre.num}" alt="">
          <div class="card-body">
            <h4 class="card-title">제목: ${carre.title}</h4>
            <p class="card-text">글번호: ${carre.num}<br>작성자: ${carre.mem_id}<br>작성일: ${carre.reg_date}<br>조회수: ${carre.hit}</p>
          </div>
          <div class="card-footer">
            <a href="${pageContext.request.contextPath}/carre/detail.do?num=${carre.num}" class="btn btn-primary">Find Out More!</a>
          </div>
        </div>
      </div>
	</c:forEach>
    </div>
		<div class="align-center">${pagingHtml}</div>
		<div class="align-right">
			<c:if test="${!empty user_id}">
			<input type="button" value="글쓰기" onclick="location.href='carrewrite.do'">
			</c:if>
		</div>
	</c:if>
	<form id="search_form" action="carrelist.do" method="get">
		<ul class="search">
			<li><select name="keyfield">
					<option value="title">제목</option>
					<option value="content">내용</option>
					<option value="id">id</option>
			</select></li>
			<li><input type="search" size="16" name="keyword" id="keyword">
			</li>
			<li><input type="submit" value="찾기"></li>
		</ul>
	</form>
</div>