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
		font-size:30px;
	}
	.table{
		border-top:2px solid #444444;
		margin-bottom:25px;
	}
	table>tbody>tr>td{
		border-bottom: 1px solid #ddd;
		width:1024px;
	}
	table>tbody>tr>th{
		border-bottom: 1px solid #ddd;
	}
	.paging{
		width:100px;
		margin:0px auto;
		padding:0;
		list-style:none;
		font-size:15px;
		color:#666666;
	}
	.paging >a{
		width:36px;
		heigth:36px;
		line-height:35px;
		text-align: center;
		margin : 0 3px;
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
		<div class="table">
			<table>
				<tbody>
					<tr>
						<th>번호</th>
						<th>업체명</th>
						<th>지역</th>
						<th>모집인원</th>
						<th>고용형태</th>
						<th>마감날짜</th>
					</tr>
					<%
					ArrayList<HireDto> list=null;
					list=(ArrayList<HireDto>)request.getAttribute("hirelist");
					for(int i=0; i<list.size(); i++){
						HireDto bean=list.get(i);
					%>
					<tr>
						<td align="center"><%=bean.getJob_no()%></td>
						<td align="center"><a href="hiredetail.html?idx=<%=bean.getJob_no()%>"><%=bean.getJob_compname() %></a></td>
						<td align="center"><%=bean.getJob_loc()%></td>
						<td align="center"><%=bean.getJob_recrnum()%></td>
						<td align="center"><%=bean.getJob_emptype()%></td>
						<td align="center"><%=bean.getJob_enddate()%></td>
					</tr>
					<%} %>
				</tbody>
			</table>
			<div class="paging">
			<jsp:include page="/util/paging.jsp">
				<jsp:param value="${paging.page}" name="page"/>
		        <jsp:param value="${paging.beginPage}" name="begin"/>
		        <jsp:param value="${paging.endPage}" name="end"/>
		        <jsp:param value="${paging.prev}" name="prev"/>
		        <jsp:param value="${paging.next}" name="next"/>
			</jsp:include>
			</div>
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