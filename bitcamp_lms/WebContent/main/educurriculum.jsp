<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.bit.main.model.*,com.bit.emp.model.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<style type="text/css">
	h2.page-title{
		border-bottom:1px solid #666666;
		padding-top:20px;
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
<script type="text/javascript" src="../js/main.js"></script>
<script type="text/javascript" src="../js/swiper.min.js"></script>
<link href="../css/swiper.min.css" rel="stylesheet" type="text/css">
<link href="../css/home.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<link rel="shortcut icon" href="/favicon.ico">
<title>비트캠프 구리센터</title>
</head>
<body>
<div id="wrap">
<div id="header">
	<div class="container">
		<h1><a href="/bitcamp_lms/main"><img alt="비트캠프 구리센터" src="../images/comm/logo.png"></a></h1>
		<ul id="gnb"><!-- Global Navigation Bar -->
			<li>
				<a href="/bitcamp_lms/main/educenter.html">교육센터</a>
				<ul>
					<li><a href="/bitcamp_lms/main/educenter.html">센터 소개</a></li>
				</ul>
			</li>
			<li>
				<a href="/bitcamp_lms/main/educurriculum.html">교육과정</a>
				<ul>
					<li><a href="/bitcamp_lms/main/educurriculum.html">모집공고</a></li>
				</ul>
			</li>
			<li>
				<a href="/bitcamp_lms/main/hire.html">취업지원</a>
				<ul>
					<li><a href="/bitcamp_lms/main/hire.html">채용공고</a></li>
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
		<h2 class="page-title">모집공고 목록</h2>
		<button>수강신청 바로가기</button>
		<div class="table">
		<table>
			<tbody>
			<%
			ArrayList<EducurriculumDto> list=null;
			list=(ArrayList<EducurriculumDto>)request.getAttribute("educurriculumlist");
			
			for(int i=0; i<list.size(); i++){
				EducurriculumDto bean=list.get(i);
			%>
				<tr>
					<td><%=bean.getRecr_date() %></td>
					<!-- <td>디지털컨버전스 기반 자바 Open Source Web application 전문 개발자 양성과정 - 3월</td> -->
				</tr>
				<tr>
					<%-- <td><%=lecbean.getLec_start() %> ~ <%=lecbean.getLec_end() %> | <%=lecbean.getLec_applnum() %>/<%=lecbean.getLec_lecnum() %></td> --%>
				</tr>
			<%} %>
			</tbody>
		</table>
		</div>
		<div class="paging">
			<jsp:include page="/util/paging.jsp">
				<jsp:param value="${paging.page}" name="page"/>
		        <jsp:param value="${paging.beginPage}" name="begin"/>
		        <jsp:param value="${paging.endPage}" name="end"/>
		        <jsp:param value="${paging.prev}" name="prev"/>
		        <jsp:param value="${paging.next}" name="next"/>
			</jsp:include>
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