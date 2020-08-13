<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.5.0.min.js"></script>

<form:form action="update.do" commandName="memberVO" id="register_form">
<div class="page-main-style">
	<div class="align-center"><h2>정보 수정</h2></div>
	<ul>
		<li>
			<label for="mem_name">이름</label>
			<form:input path="mem_name" />
			<form:errors path="mem_name" cssClass="error-color" />
		</li>
		<li>
			<label for="mem_email">이메일</label>
			<form:input path="mem_email" />
			<form:errors path="mem_email" cssClass="error-color" />
		</li>
		<li>
			<label for="mem_cell">연락처</label>
			<form:input path="mem_cell" />
			<form:errors path="mem_cell" cssClass="error-color" />
		</li>
		<li>
			<label for="mem_zip">우편번호</label>
			<input type="text" name="mem_zip" id="mem_zip" size="5" maxlength="5">
			<input type="button" id="zipcode_select" value="우편번호 찾기" onclick="sample4_execDaumPostcode()">
			<span id="zipcode"></span>
		</li>
		<li>
			<label for="mem_addr">주소</label>
			<form:input path="mem_addr" />
			<form:errors path="mem_addr" cssClass="error-color" />
		</li>
		<li>
			<label for="mem_addr2">상세주소</label>
			<form:input path="mem_addr2" />
			<form:errors path="mem_addr2" cssClass="error-color" />
		</li>
	</ul>
	<div class="align-center">
		<input type="submit" value="수정">
		<input type="button" value="취소" onclick="${pageContext.request.contextPath}/main/main.do">
	</div>
</div>
</form:form>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('mem_zip').value = data.zonecode;
                document.getElementById('mem_addr').value = roadAddr;
               
            }
        }).open();
    }
</script>
