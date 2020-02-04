<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.bit.lms.model.LoginDto" %>
<%
LoginDto login =(LoginDto)session.getAttribute("login");
if(login!=null){
%>
<c:set var="bean"/>
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
				<li><button type="button" class="btn_logout" onclick="popup()"><i class="xi-log-out"></i></button></li>
			</ul>
		</div>
	</div>
	<div id="container">
		<div class="container">
			<div id="gnb" class="gnb_area">
				<ul>
					<li>
						<a href="mycurriculum.html?no=${login.mbNo }">
							<i class="xi-emoticon"></i>
							<span>나의 교육과정</span>
						</a>
					</li>
					<li>
						<a href="">
							<i class="xi-book-o"></i>
							<span>나의 출결현황</span>
						</a>
					</li>
					<li>
						<a href="">
							<i class="xi-presentation"></i>
							<span>나의 성적조회</span>
						</a>
					</li>
					<li>
						<a href="teachernotice.html">
							<i class="xi-info-o"></i>
							<span>강의실 공지사항</span>
						</a>
					</li>
				</ul>
			</div>
			<div class="content_area">
				<div class="dashboard_wrap">
					<h2 class="hidden">대시보드 메인</h2>
					<div>
						<div class="profile box">
							<h3>나의 프로필</h3>
							<div>
								<dl>
									<dt><b>${login.name }</b> 님, 환영합니다</dt>
									<dd>이메일 : ${login.id }</dd>
									<dd>연락처 : ${login.tel }</dd>
								</dl>
							</div>
							<p class="btn_go"><a href="lock.html">내 정보 수정 <i class="xi-arrow-right"></i></a></p>
						</div>
						<div class="class box">
						
							<h3>나의 교육과정</h3>
							<div>
								<p class="status">과정 진행 중</p>
								<p>${mycurriculum.lec_name }</p>
								<p>${mycurriculum.lec_start } ~ ${mycurriculum.lec_end }</p>
								<p class="btn_go"><a href="mycurriculum.html?no=${login.mbNo }">자세히 보기 <i class="xi-arrow-right"></i></a></p class="btn_go">
							</div>
						</div>
						<div class="attend box">
							<h3>오늘의 출결관리</h3>
							<dl>
								<dt>
									2020년 01월 01일
									<span>입실 &nbsp; : &nbsp; <b>08:59</b></span>
									<span>퇴실 &nbsp; : &nbsp; <b>18:31</b></span>
								</dt>
								<dd>
									<button type="button" id="btnAttend" class="btn_pop in"><span></span></button>
								</dd>
							</dl>
							<p class="btn_go"><a href="">자세히 보기 <i class="xi-arrow-right"></i></a></p>
						</div>
						<div class="board box">
							<h3>강의실 공지사항</h3>
							<div>
								<ul>
									<!-- <li>
										<a href="">
											<span>게시글</span>
											<span>2020-01-01</span>
										</a>
									</li> -->
									<li class="bd_empty">등록된 게시물이 없습니다.</li>
								</ul>
							</div>
							<p class="btn_go"><a href="teachernotice.html">자세히 보기 <i class="xi-arrow-right"></i></a></p>
						</div>
						<div class="status box">
							<h3>나의 출결현황</h3>
							<div>
								<ul>
									<li>
										나의 출석률 (<span>45.2</span>%)
										<p></p>
									</li>
									<li>
										과정 진행률 (<span>51.4</span>%)
										<p></p>
									</li>
								</ul>
							</div>
						</div>
						<div class="stats box">
							<h3>나의 출결통계</h3>
							<div>
								<ul>
									<li><span>38</span>출석</li>
									<li><span>7</span>지각</li>
									<li><span>0</span>조퇴</li>
									<li><span>2</span>결석</li>
								</ul>
							</div>
						</div>
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
					<span>비트캠프 구리센터</span>
					<span>비트캠프 서울시 서초구 강남대로 459 (서초동, 백암빌딩)</span>
					<span>대표이사 : 조현정</span>
				</p>
				<p>
					<span>사업자등록번호 : 214-85-24928</span>
					<span>문의 : 02-3486-9600</span>
					<span>팩스 : 02-6007-1245</span>
					<span>개인정보보호관리책임자 : 최종진</span>
				</p>
				<p>Copyright &copy; 비트캠프 All rights reserved.</p>
			</div>
		</div>
	</div>
</div>
<div id="popupAttend">
	<p class="alert">
		현재 시간 : [2020년 01월 01일 08:59:00]<br>
		입/퇴실 체크하시겠습니까?<br>
		※ 한 번 처리된 기록은 수정할 수 없습니다.
	</p>
	<div class="btns">
		<button type="button" class="btn_off yes">확인</button>
		<button type="button" class="btn_off no">확인</button>
	</div>
</div>
<div id="popup">
	<p class="alert">
		로그아웃 하시겠습니까?
	</p>
	<div class="btns">
		<form method="POST">
			<button type="submit" class="yes">예</button>
			<button type="button" class="btn_off no">아니오</button>
		</form>
	</div>
</div>
<script src="http://cdnjs.cloudflare.com/ajax/libs/waypoints/2.0.3/waypoints.min.js"></script>
<script type="text/javascript">
	attend();
	progress();
	count();
</script>
</body>
</html>
<%
}else{
	response.sendRedirect("login.html?msg=AccessDenied");
}
%>