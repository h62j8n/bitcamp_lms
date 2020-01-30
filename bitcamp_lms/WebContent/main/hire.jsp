<%@page import="java.util.ArrayList,com.bit.main.model.HireDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	h2.page-title{
		border-bottom:1px solid #666666;
		padding-bottom:20px;
		margin-bottom:40px;
		line-height:50px;
		color:#222222;
	}

</style>
<script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="../js/site.js"></script>
<script type="text/javascript" src="../js/swiper.min.js"></script>
<link href="../css/swiper.min.css" rel="stylesheet" type="text/css">
<link href="../css/site.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<link rel="shortcut icon" href="/favicon.ico">
<title>비트캠프 구리센터</title>
</head>
<body>
<div id="wrap">
<div id="header">
	<div class="container">
		<h1><a href=""><img alt="비트캠프 구리센터" src="../images/comm/logo.png"></a></h1>
		<ul id="gnb"><!-- Global Navigation Bar -->
			<li>
				<a href="">교육센터</a>
				<ul>
					<li><a href="">센터 소개</a></li>
				</ul>
			</li>
			<li>
				<a href="">교육과정</a>
				<ul>
					<li><a href="">모집공고</a></li>
				</ul>
			</li>
			<li>
				<a href="">취업지원</a>
				<ul>
					<li><a href="hire.html">채용공고</a></li>
				</ul>
			</li>
			<li>
				<a href="">학생지원</a>
				<ul>
					<li><a href="">공지사항</a></li>
					<li><a href="">FAQ</a></li>
				</ul>
			</li>
		</ul>
		<ul class="quick">
			<li><a href="https://www.bitcamp.co.kr/sch" target="_blank">서초본원</a></li>
			<li><a href="https://www.bitcamp.co.kr/gn" target="_blank">강남센터</a></li>
			<li><a href="https://www.bitcamp.co.kr/sc" target="_blank">신촌센터</a></li>
			<li><a href="https://www.bitcamp.co.kr/cr" target="_blank">종로센터</a></li>
			<li><a href="" target="_blank">LMS서비스</a></li>
		</ul>
	</div>
</div>
<div id="container">
	<div class="container">
		<h2 class="page-title">채용공고 목록</h2>
		<div id="content" align="center">
			<table width="800px">
				<thead>
					<tr>
						<th width="50px">번호</th>
						<th width="200px">업체명</th>
						<th width="50px">지역</th>
						<th width="50px">모집인원</th>
						<th width="50px">고용형태</th>
						<th width="50px">마감날짜</th>
					</tr>
				</thead>
				<tbody>
					<%
					ArrayList<HireDto> list=null;
					list=(ArrayList<HireDto>)request.getAttribute("hirelist");
					for(int i=0; i<list.size(); i++){
						HireDto bean=list.get(i);
					%>
					<tr>
						<td align="center"><%=bean.getJob_no()%></td>
						<td align="center"><a href="hireDetail.html"><%=bean.getJob_compname()%></td>
						<td align="center"><%=bean.getJob_loc()%></td>
						<td align="center"><%=bean.getJob_recrnum()%></td>
						<td align="center"><%=bean.getJob_emptype()%></td>
						<td align="center"><%=bean.getJob_enddate()%></td>
					</tr>
					<%} %>
				</tbody>
			</table>
			<br>
		</div>
	</div>
</div>
<div id="footer">
	<div class="container">
		<p class="foot_logo">
			<img src="../images/comm/logo.png" alt="비트캠프 구리센터">
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
			<p>Copyright &copy; 비트캠프 All rights reserved.</p>
		</div>
	</div>
</div>
</div>
</body>
</html>