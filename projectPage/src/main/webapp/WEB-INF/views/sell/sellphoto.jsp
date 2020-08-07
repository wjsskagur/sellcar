<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div id="dialog" title="차량 사진 등록">
		<form:form action="sellPhoto.do" enctype="multipart/form-data" commandName="sellcarVO">
		<label for="car_mainimg">차량 대표 사진(필수)</label>
	<input type="file" id="upload1" name="upload1">
	<form:errors path="car_mainimg"/>
	</form:form>
		<form:form action="sellPhoto.do" enctype="multipart/form-data" commandName="sellcarVO">
		<label for="car_img1">차량 외부 사진(필수)</label>
	<input type="file" id="upload2" name="upload2">
	<form:errors path="car_img1"/>
		</form:form>
		<form:form action="sellPhoto.do" enctype="multipart/form-data" commandName="sellcarVO">
		<label for="car_img2">차량 외부 사진(필수)</label>
	<input type="file" id="upload3" name="upload3">
	<form:errors path="car_img2"/>
		</form:form>
		<form:form action="sellPhoto.do" enctype="multipart/form-data" commandName="sellcarVO">
		<label for="car_img3">차량 외부 사진</label>
	<input type="file" id="upload4" name="upload4">
	<form:errors path="car_img3"/>
		</form:form>
		<form:form action="sellPhoto.do" enctype="multipart/form-data" commandName="sellcarVO">
		<label for="car_img4">차량 외부 사진</label>
	<input type="file" id="upload5" name="upload5">
	<form:errors path="car_img4"/>
		</form:form>
		<form:form action="sellPhoto.do" enctype="multipart/form-data" commandName="sellcarVO">
		<label for="car_img5">차량 내부 사진(필수)</label>
	<input type="file" id="upload6" name="upload6">
	<form:errors path="car_img5"/>
		</form:form>
		<form:form action="sellPhoto.do" enctype="multipart/form-data" commandName="sellcarVO">
		<label for="car_img6">차량 내부 사진(필수)</label>
	<input type="file" id="upload7" name="upload7">
	<form:errors path="car_img6"/>
		</form:form>
		<form:form action="sellPhoto.do" enctype="multipart/form-data" commandName="sellcarVO">
		<label for="car_img7">차량 내부 사진(필수)</label>
	<input type="file" id="upload8" name="upload8">
	<form:errors path="car_img7"/>
		</form:form>
		<form:form action="sellPhoto.do" enctype="multipart/form-data" commandName="sellcarVO">
		<label for="car_img8">차량 내부 사진</label>
	<input type="file" id="upload9" name="upload9">
	<form:errors path="car_img8"/>
		</form:form>
		<form:form action="sellPhoto.do" enctype="multipart/form-data" commandName="sellcarVO">
		<label for="car_img9">차량 내부 사진</label>
	<input type="file" id="upload10" name="upload10">
	<form:errors path="car_img9"/>
		</form:form>
		<form:form action="sellPhoto.do" enctype="multipart/form-data" commandName="sellcarVO">
		<label for="car_img10">차량 내부 사진</label>
	<input type="file" id="upload11" name="upload11">
	<form:errors path="car_img10"/>
		</form:form>
		<form:form action="sellPhoto.do" enctype="multipart/form-data" commandName="sellcarVO">
		<label for="car_option">차량 옵션 사진</label>
	<input type="file" id="upload12" name="upload12">
	<form:errors path="car_option"/>
		</form:form>
		<form:form action="sellPhoto.do" enctype="multipart/form-data" commandName="sellcarVO">
		<label for="car_test">차량 점검표(필수)</label>
	<input type="file" id="upload13" name="upload13">
	<form:errors path="car_test"/>
		</form:form>
		<form:form action="sellPhoto.do" enctype="multipart/form-data" commandName="sellcarVO">
		<label for="car_content">차량 설명(필수)</label>
	<input type="file" id="upload14" name="upload14">
	<form:errors path="car_content"/>
		</form:form>
		<form:form action="sellPhoto.do" enctype="multipart/form-data" commandName="sellcarVO">
		<label for="map_img">희망 전시장(필수)</label>
	<input type="file" id="upload15" name="upload15">
	<form:errors path="map_img"/>
		</form:form>
		<form:form action="sellPhoto.do" enctype="multipart/form-data" commandName="sellcarVO">
		<label for="car_log">차량 요약(필수)</label>
	<input type="file" id="upload16" name="upload16">
	<form:errors path="car_log"/>
		</form:form>
		<form:form action="sell.do" enctype="multipart/form-data" commandName="sellcarVO">
		<label for="car_detail">차량 상세설명(필수)</label>
	<input type="file" id="upload17" name="upload17">
	<form:errors path="car_detail"/>
	<input type="submit" value="등록">
		</form:form>
	</div>