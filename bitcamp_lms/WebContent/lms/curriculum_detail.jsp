<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.bit.lms.model.LoginDto, com.bit.home.model.EducurriDetailDto" %>
<%
LoginDto login =(LoginDto)session.getAttribute("login");
if(login!=null){
%>
<!DOCTYPE html>
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
			<h1><a href="index_student2.html"><img src="../images/ico/logo_w.png" alt="비트캠프 구리센터"></a></h1>
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
					<li class="on"><a href="curriculum_list.html"> <i class="xi-school"></i> <span>모집공고</span></a></li>
				</ul>
			</div>
			<div id="curriculum" class="content_area">
				<div class="board_wrap detail">
					<h2>모집공고</h2>
					<form id="detailForm">
						<% EducurriDetailDto bean=(EducurriDetailDto)request.getAttribute("recr_detail"); %>
						<div class="title box">
							<input type="hidden" name="idx" value="<%= bean.getRecr_no() %>">
							<h3><%= bean.getLec_name() %></h3>
							<ul>
								<li>등록일 &nbsp; <%= bean.getRecr_date() %></li>
								<li>조회 &nbsp; <%= String.format("%03d", bean.getRecr_count()) %></li>
							</ul>
						</div>
						<table class="table box">
							<tr class="bd_half">
								<th>교육기간</th>
								<td><%= bean.getLec_start() %> ~ <%= bean.getLec_end() %></td>
								<th>교육강사</th>
								<td><%= bean.getLec_instructor() %></td>
							</tr>
							<tr class="bd_half">
								<th>수강신청기간</th>
								<td><%= bean.getLec_appl_start() %> ~ <%= bean.getLec_appl_end() %></td>
								<th>모집인원</th>
								<td><%= bean.getLec_applnum() %>/<%= bean.getLec_lecnum() %></td>
							</tr>
						</table>
						<div class="content box">
							<p><%= bean.getLec_content() %></p>
						</div>
						<div class="bottom box">
							<ul class="bd_btns">
								<li><button type="button" class="btn_back">목록</button></li>
								<li><a href="curriculum_write.html?idx=<%= bean.getRecr_no() %>" class="btn_submit">수정</a></li>
								<li><button type="button" onclick="popPostDel()">삭제</button></li>
							</ul>
						</div>
					</form>
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
<div id="popup">
	<p class="alert"></p>
	<div class="btns"></div>
</div>
</body>
</html>
<%
}else{
	response.sendRedirect("login.html?msg=AccessDenied");
}
%>