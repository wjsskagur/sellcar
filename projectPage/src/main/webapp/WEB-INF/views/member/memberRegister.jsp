<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#agree').click(function(){
			var checkAll = $('#agreeAll').prop('checked');
			
			if(!checkAll) {
				alert("이용약관에 전부 동의해주시기 바랍니다.");
				return false;
			}
		});
		
		$('#check1, #check2, #check3, #check4').change(function(){
			if($('#check1').is(':checked') == true && $('#check3').is(':checked') == true){
				$('#agreeAll').prop('checked', true);
			}else{
				$('#agreeAll').prop('checked', false);
			}
			
		});
		
		$('#agreeAll').change(function(){
			var checkAll = $('#agreeAll').prop('checked');
			
			if(checkAll) {
				$('#check1').prop('checked', true);
				$('#check3').prop('checked', true);
			} else {
				$('#check1').prop('checked', false);
				$('#check3').prop('checked', false);
			}
		});
	});
</script>
<div class="page-main-style">
	<h2>회원가입</h2>
	<form action="register.do" method="get">
	<a><b>차 한대 4조 사이트 이용약관</b></a>
	<p>
		<b>제 1장 총칙</b><br>
		제 1조 [목적]<br>
		본 약관은 씨제이 제일제당㈜(이하 '회사'라 한다)가 운영하는 인터넷 관련 서비스(이하 '서비스'라 한다)를 이용함에 있어<br>
		CJ제일제당 패밀리사이트(이하 '패밀리사이트'라 한다)를 하나의 아이디 및 비밀번호로 동시에 가입하여 이용함에 있어 회사와<br>
		회원과의 권리ㆍ의무 및 책임사항, 서비스 이용조건과 절차사항, 기타 필요한 사항을 규정함을 목적으로 합니다.<br>
		※ 「PC통신, 무선 등을 이용하는 전자상거래에 대해서도 그 성질에 반하지 않는 한 이 약관을 준용합니다.」<br>
	</p>
	<ul>
		<li><input type="radio" id="check1" name="check1" value="1">동의합니다.</li>
		<li><input type="radio" id="check2" name="check1" value="0">동의하지 않습니다.</li>
	</ul>
	<a><b>개인정보 수집 및 이용안내</b></a>
	<p>
		<b>1. 수집하는 개인정보의 항목 및 수집방법</b><br>
		가. 수집하는 개인정보의 항목<br>
		첫째, 회사는 회원가입, 원활한 고객상담, 각종 서비스 제공을 위해 아래와 같은 항목의 개인정보를 수집하고 있습니다.<br>
		《일반 회원가입》 - 아이디, 이메일, 닉네임, 휴대폰번호
	</p>
	<ul>
		<li><input type="radio" id="check3" name="check2" value="1">동의합니다.</li>
		<li><input type="radio" id="check4" name="check2" value="0">동의하지 않습니다.</li>
	</ul>
	<div class="align-center">
		<input type="checkbox" value="2" id="agreeAll" name="agreeAll" onclick="check()">전체 동의합니다.
		<input type="submit" value="회원가입" id="agree" name="agree">
	</div>
	</form>
</div>