<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.bit.lms.model.LoginDto" %>
<%
LoginDto login =(LoginDto)session.getAttribute("login");
if(login!=null){
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
				<h1>
					<a href="index_student2.html"><img src="../images/ico/logo_w.png" alt="비트캠프 구리센터"></a>
				</h1>
				<ul class="quick">
					<li><a href=""><i class="xi-profile-o"></i></a></li>
					<li><button type="button" class="btn_logout" onclick="popup()"><i class="xi-log-out"></i></button></li>
				</ul>
			</div>
		</div>
		<div id="container">
			<div class="container">
				<div id="gnb" class="gnb_area">
					<ul>
						<li><a href="curriculum_list.html"> <i class="xi-school"></i> <span>모집공고</span></a></li>
					</ul>
				</div>
				<div class="content_area">
					<div class="dashboard_wrap">
						<h2 class="hidden">대시보드 메인</h2>
						<!-- 학생 (수강신청 전)  -->
						<div>
							<div class="profile box">
								<h3>나의 프로필</h3>
								<div>
									<dl>
										<dt>
											<b>${login.name }</b> 님, 환영합니다
										</dt>
										<dd>이메일 : ${login.id }</dd>
										<dd>연락처 : ${login.tel }</dd>
									</dl>
								</div>
								<p class="btn_go">
									<a href="">내 정보 수정 <i class="xi-arrow-right"></i></a>
								</p>
							</div>
							<div class="class box">
								<h3>나의 교육과정</h3>
								<div>
									<dl>
										<dd class="cl_empty">
											등록된 교육과정이 없습니다.<br>수강신청을 먼저 진행해주세요.
										</dd>
									</dl>
								</div>
								<p class="btn_go">
									<a href="">수강신청 바로가기 <i class="xi-arrow-right"></i>
									</a>
								</p>
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
				<p class="foot_logo">
					<img src="../images/ico/logo_w.png" alt="비트캠프 구리센터">
				</p>
				<div class="foot_info">
					<p>
						<span>비트캠프 구리센터</span> <span>비트캠프 서울시 서초구 강남대로 459 (서초동,
							백암빌딩)</span> <span>대표이사 : 조현정</span>
					</p>
					<p>
						<span>사업자등록번호 : 214-85-24928</span> <span>문의 : 02-3486-9600</span>
						<span>팩스 : 02-6007-1245</span> <span>개인정보보호관리책임자 : 최종진</span>
					</p>
					<p>Copyright © 비트캠프 All rights reserved.</p>
				</div>
			</div>
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
</body>
</html>
<%
}else{
	response.sendRedirect("login.html?msg=AccessDenied");
}
%>