<%@page import="com.bit.lms.model.TeacherNoticeDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<title>Document</title>
</head>
<body>
<div id="wrap">
	<div id="header">
		<div class="container">
			<h1><a href="index_teacher.html"><img src="../images/ico/logo_w.png" alt="비트캠프 구리센터"></a></h1>
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
				<div class="board_wrap list">
					<h2>강의실 공지사항</h2>
					<div class="top box">
						
					</div>
					<table class="table box">
						<thead>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>등록일</th>
								<th>조회</th>
							</tr>
						</thead>
						<tbody>
						<%
						ArrayList<TeacherNoticeDto> list=null;
						list=(ArrayList<TeacherNoticeDto>)request.getAttribute("teachernoticelist");
						for(int i=0; i<list.size(); i++){
							TeacherNoticeDto bean=list.get(i);
						%>
							<tr>
								<td><%=bean.getCls_no() %></td>
								<td><a href="teachernoticedetail.html?idx=<%=bean.getCls_no()%>"><%=bean.getCls_subject() %></a></td>
								<td><%=bean.getCls_date() %></td>
								<td><%=bean.getCls_count() %></td>
							</tr>
						<%} %>
						</tbody>
					</table>
					<div class="bottom box">
						<p class="bd_btns">
							<a href="teachernoticeadd.html" class="btn_submit">글 작성</a>
						</p>
						<ul class="bd_pages">
							<li><a href="" class="pg_start"><span class="hidden">첫 페이지</span></a></li>
							<li><a href="" class="pg_prev"><span class="hidden">이전 페이지</span></a></li>
							<li><a href="">1</a></li>
							<li><a href="">2</a></li>
							<li><b>3</b></li>
							<li><a href="">4</a></li>
							<li><a href="">5</a></li>
							<li><a href="" class="pg_next"><span class="hidden">다음 페이지</span></a></li>
							<li><a href="" class="pg_end"><span class="hidden">마지막 페이지</span></a></li>
						</ul>
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
</body>
</html>