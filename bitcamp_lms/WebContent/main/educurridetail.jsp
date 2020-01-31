<%@page import="com.bit.main.model.EducurriDetailDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bit.main.model.IndexDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	h2.page-title {
    	border-bottom: 1px solid #666666;
  		padding-top:20px;
    	padding-bottom: 20px;
    	margin-bottom: 40px;
    	line-height: 50px;
    	color: #222222;
    	font-size: 30px;
	}
	.table-style {
    	border-top: 2px solid #444444;
    	margin-bottom: 25px;
	}
	table {
    	border-collapse: collapse;
    	width: 100%;
    	table-layout: fixed;
	}
	.table-style.style2 th{
		background:#f6f6f7;
		border-bottom: 1px solid #d6d6d6;
		border-right: 1px solid #d6d6d6;
	}
	.table-style.style2 td{
		border-bottom:1px solid #d6d6d6;
		padding: 10px;
	}
	.table-style.style2 td .text-box{
		min-height:220px;
		padding: 24px;
	}
	.button.right{
		text-align:right;
	}
	.button a {
		margin-bottom: 5px;
		margin-left: 6px;
		width: 85px;
		padding: 7px 0;
		text-align: center;
		display: inline-block;
		border: 1px solid #5c5c5c;
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
				<h1>
					<a href="/bitcamp_lms/main"><img src="../images/comm/logo.png" alt="비트캠프 구리센터"></a>
				</h1>
				<ul id="gnb">
					<li><a href="/bitcamp_lms/main/educenter.html">교육센터</a>
						<ul>
							<li><a href="/bitcamp_lms/main/educenter.html">센터 소개</a></li>
						</ul></li>
					<li><a href="/bitcamp_lms/main/educurriculum.html">교육과정</a>
						<ul>
							<li><a href="/bitcamp_lms/main/educurriculum.html">모집공고</a></li>
						</ul></li>
					<li><a href="/bitcamp_lms/main/hire.html">취업지원</a>
						<ul>
							<li><a href="/bitcamp_lms/main/hire.html">채용공고</a></li>
						</ul></li>
					<li><a href="">학생지원</a>
						<ul>
							<li><a href="">공지사항</a></li>
							<li><a href="">FAQ</a></li>
						</ul></li>
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
				<h2 class="page-title">모집공고 상세</h2>
				<div class="table-style style2">
					<table>
						<colgroup>
							<col style="width:20%;">
							<col style="width:30%;">
							<col style="width:20%;">
							<col style="width:30%;">
						</colgroup>
						<tbody>
							<%
							EducurriDetailDto bean=(EducurriDetailDto)request.getAttribute("recr_detail");
							%>
							<tr>
								<th>강의명</th>
								<td colspan="3"><%=bean.getLec_name() %></td>
							</tr>
							<tr>
								<th>작성일자</th>
								<td><%=bean.getRecr_date() %></td>
								<th>조회수</th>
								<td><%=bean.getRecr_count() %></td>
							</tr>
							<tr>
								<th>신청기간</th>
								<td><span><%=bean.getLec_appl_start() %> ~ <%=bean.getLec_appl_end() %></span></td>
								<th>신청인원</th>
								<td><%=bean.getLec_applnum() %>/<%=bean.getLec_lecnum() %></td>
							</tr>
							<tr>
								<td colspan="4" >
									<div class="text-box">
		                            <p><%=bean.getLec_content() %></p>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
		        <div class="button right">
					<a href="">목록</a>
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
	<script type="text/javascript">
		mainSlider();
	</script>
</body>
</html>