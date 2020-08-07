<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div title="차량 사진 등록">

		<form:form action="sellPhoto.do" enctype="multipart/form-data" commandName="sellcarVO">
        <input type="hidden" name="car_num" value="${car_num}"/>
		<ul>
		<li>
		
		<label for="car_mainimg">차량 대표 사진(필)</label>
	<input type="file" id="upload1" name="upload1">
	<form:errors path="upload1"/>
	</li>
	<li>
		<label for="car_img1">차량 외부 사진(필)</label>
	<input type="file" id="upload2" name="upload2">
	<form:errors path="upload2"/>
	</li>
	<li>	
		<label for="car_img2">차량 외부 사진(필)</label>
	<input type="file" id="upload3" name="upload3">
	<form:errors path="upload3"/>
	</li>
	<li>	
		<label for="car_img3">차량 외부 사진</label>
	<input type="file" id="upload4" name="upload4">
	<form:errors path="upload4"/>
	</li>
	<li>
		<label for="car_img4">차량 외부 사진</label>
	<input type="file" id="upload5" name="upload5">
	<form:errors path="upload5"/>
	</li>
	<li>
		<label for="car_img5">차량 내부 사진(필)</label>
	<input type="file" id="upload6" name="upload6">
	<form:errors path="upload6"/>
	</li>
	<li>
		<label for="car_img6">차량 내부 사진(필)</label>
	<input type="file" id="upload7" name="upload7">
	<form:errors path="upload7"/>
	</li>
	<li>
		<label for="car_img7">차량 내부 사진(필)</label>
	<input type="file" id="upload8" name="upload8">
	<form:errors path="upload8"/>
	</li>
	<li>
		<label for="car_img8">차량 내부 사진</label>
	<input type="file" id="upload9" name="upload9">
	<form:errors path="upload9"/>
	</li>
	<li>
		<label for="car_img9">차량 내부 사진</label>
	<input type="file" id="upload10" name="upload10">
	<form:errors path="upload10"/>
	</li>
	<li>
		<label for="car_img10">차량 내부 사진</label>
	<input type="file" id="upload11" name="upload11">
	<form:errors path="upload11"/>
	</li>
	<li>
		<label for="car_option">차량 옵션 사진(필)</label>
	<input type="file" id="upload12" name="upload12">
	<form:errors path="upload12"/>
	</li>
	<li>
		<label for="car_test">차량 점검표(필)</label>
	<input type="file" id="upload13" name="upload13">
	<form:errors path="upload13"/>
	</li>
	<li>
		<label for="car_content">차량 설명(필)</label>
	<input type="file" id="upload14" name="upload14">
	<form:errors path="upload14"/>
	</li>
	<li>
		<label for="map_img">희망 전시장(필)</label>
	<input type="file" id="upload15" name="upload15">
	<form:errors path="upload15"/>
	</li>
	<li>
		<label for="car_log">차량 요약(필)</label>
	<input type="file" id="upload16" name="upload16">
	<form:errors path="upload16"/>
	</li>
	<li>
		<label for="car_detail">차량 상세설명(필)</label>
	<input type="file" id="upload17" name="upload17">
	<form:errors path="upload17"/>
	</li>
	</ul>
	<input type="submit" value="등록">
		</form:form>
	</div>