<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="../css/bootstrap.css" type="text/css">
<link rel="stylesheet" href="../css/bootstrap.min.css">

<section>
	<div class="inner">
		<h2>
			SELL CAR에서 <span>검색하세요</span>
		</h2>
		<fieldset>
			<legend>차량 검색</legend>
			<div class="select">
				<span class="select-box design-select">
				<select	class="design-select" data-title="" id="mak" onchange="getModel(this.value)">
						<option value="폭스바겐">폭스바겐</option>
						<option value="BMW">BMW</option>
						<option value="HYUNDAI">HYUNDAI</option>
						<option value="Kia">Kia</option>
						<option value="Mercedes-Benz">Mercedes-Benz</option>
						<option value="기아">기아</option>
						<option value="기아자동차">기아자동차</option>
						<option value="도요타">도요타</option>
						<option value="르노삼성">르노삼성</option>
						<option value="미니">미니</option>
						<option value="벤츠">벤츠</option>
						<option value="쉐보레">쉐보레</option>
						<option value="쌍용">쌍용</option>
						<option value="아우디">아우디</option>
						<option value="포드">포드</option>
						<option value="푸조">푸조</option>
						<option value="피아트">피아트</option>
						<option value="현대">현대</option>
						<option value="현대자동차">현대자동차</option>
				</select>
				<span class="selected" data-title="">폭스바겐</span>
				<i class="arrow"></i>
				</span>
				<span class="select-box design-select">
				<select class="design-select" data-title="MODEL" id="model"	onchange="getDetailModel(this.value)">
						<option value="">모델</option>
						<option value="CC">CC</option>
						<option value="EOS">EOS</option>
						<option value="골프">골프</option>
						<option value="보라">보라</option>
						<option value="비틀">비틀</option>
						<option value="시로코">시로코</option>
						<option value="아테온">아테온</option>
						<option value="제타">제타</option>
						<option value="투아렉">투아렉</option>
						<option value="티구안">티구안</option>
						<option value="파사트">파사트</option>
						<option value="페이톤">페이톤</option>
						<option value="폴로">폴로</option>
				</select>
				<span class="selected" data-title="MODEL">모델</span><i class="arrow"></i>
				</span>
				<span class="select-box design-select"><select
					class="design-select" data-title="DETAIL" id="detailModel"
					onchange="getNowSellingItemCount()">
						<option value="">세부모델</option>
				</select><span class="selected" data-title="DETAIL">세부모델</span><i
					class="arrow"></i></span>
				<button type="button" class="btn btn-primary btn-radius"
					id="searchBtn" onclick="goList()">
					<em>검색</em>
				</button>
			</div>
		</fieldset>
	</div>
</section>

