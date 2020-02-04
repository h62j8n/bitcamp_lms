<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="../js/site.js"></script>
<link href="../css/site.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<title>비트캠프 구리센터</title>
</head>
<body>
	<div id="wrap">
		<div id="header">
			<div class="container">
				<h1><a href="index.html"><img src="../images/ico/logo_w.png" alt="비트캠프 구리센터"></a></h1>
				<ul class="quick">
					<li><a href="lock.html"><i class="xi-profile-o"></i></a></li>
					<li><button type="button" class="btn_logout"><i class="xi-log-out"></i></button></li>
				</ul>
			</div>
		</div>
		<div id="container">
			<div class="container">
				<div id="gnb" class="gnb_area">
					<ul>
					</ul>
				</div>
				<div class="content_area">
					<div id="my" class="board_wrap curriculum list">
						<h2>나의 교육과정</h2>
						<h3>기본 정보</h3>
							<div class="top box">
								<dl>
									<dt>${mycurriculum.lec_name }</dt>
									<dd>교육기간 : ${mycurriculum.lec_start } ~ ${mycurriculum.lec_end }</dd>
									<dd>강의코드 : ${mycurriculum.lec_code }</dd>
									<dd>강의실 : 제 ${mycurriculum.lec_roomno }강의실</dd>
									<dd>교육강사 : ${mycurriculum.lec_instructor }</dd>
									<dd>수강인원 : ${mycurriculum.lec_applnum }/${mycurriculum.lec_lecnum }</dd>
								</dl>
							</div>
							<h3>상세 내용</h3>
							<div class="content box">
								<p>${mycurriculum.lec_content }</p>
							</div>
					</div>
				</div>
			</div>
		</div>
		<div id="footer">
			<div class="container">
				<ul class="foot_menu">
					<li><a href="">홈페이지 이용약관</a></li>
					<li><a href="">개인정보처리방침</a></li>
				</ul>
				<p class="foot_logo"><img src="../images/ico/logo_w.png" alt="비트캠프 구리센터"></p>
				<div class="foot_info">
					<p>
						<span>비트캠프 구리센터</span> <span>비트캠프 서울시 서초구 강남대로 459 (서초동,백암빌딩)</span> <span>대표이사 : 조현정</span>
					</p>
					<p>
						<span>사업자등록번호 : 214-85-24928</span> <span>문의 : 02-3486-9600</span>
						<span>팩스 : 02-6007-1245</span> <span>개인정보보호관리책임자 : 최종진</span>
					</p>
					<p>Copyright &copy; 비트캠프 All rights reserved.</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>