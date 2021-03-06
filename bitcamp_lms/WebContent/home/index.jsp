<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.bit.home.model.IndexDto"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="js/main.js"></script>
	<script type="text/javascript" src="js/swiper.min.js"></script>
	<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
	<link href="css/swiper.min.css" rel="stylesheet" type="text/css">
	<link href="css/home.css" rel="stylesheet" type="text/css">
	<link rel="shortcut icon" href="/favicon.ico">
	<title>비트캠프 구리센터</title>
</head>
<body>
<div id="wrap">
	<div id="header">
		<div class="container">
			<h1>
				<a href="/bitcamp_lms"><img src="images/ico/logo.png" alt="비트캠프 구리센터"></a>
			</h1>
			<ul id="gnb">
				<li><a href="/bitcamp_lms/home/educenter.html">교육센터</a>
					<ul>
						<li><a href="/bitcamp_lms/home/educenter.html">교육센터 소개</a></li>
					</ul></li>
				<li><a href="/bitcamp_lms/home/educurriculum.html">교육과정</a>
					<ul>
						<li><a href="/bitcamp_lms/home/educurriculum.html">모집공고</a></li>
					</ul></li>
				<li><a href="/bitcamp_lms/home/hire.html">취업지원</a>
					<ul>
						<li><a href="/bitcamp_lms/home/hire.html">채용공고</a></li>
					</ul></li>
				<li><a href="/bitcamp_lms/home/notice.html">학생지원</a>
					<ul>
						<li><a href="/bitcamp_lms/home/notice.html">공지사항</a></li>
						<li><a href="/bitcamp_lms/home/faq.html">FAQ</a></li>
					</ul></li>
			</ul>
			<ul class="quick">
				<li><a href="https://www.bitcamp.co.kr/sch" target="_blank">서초본원</a></li>
				<li><a href="https://www.bitcamp.co.kr/gn" target="_blank">강남센터</a></li>
				<li><a href="https://www.bitcamp.co.kr/sc" target="_blank">신촌센터</a></li>
				<li><a href="https://www.bitcamp.co.kr/cr" target="_blank">종로센터</a></li>
				<li><a href="lms/login.html" target="_blank">LMS서비스</a></li>
			</ul>
		</div>
	</div>
	<div id="container">
		<section class="banner_area swiper-container">
		<ul class="swiper-wrapper">
			<li class="swiper-slide"
				style="background-image: url(images/img/main_banner01.jpg)"></li>
			<li class="swiper-slide"
				style="background-image: url(images/img/main_banner02.jpg)"></li>
			<li class="swiper-slide"
				style="background-image: url(images/img/main_banner03.jpg)"></li>
		</ul>
		<button type="button" class="swiper-button-prev">
			<i class="xi-angle-left-thin"></i>
		</button>
		<button type="button" class="swiper-button-next">
			<i class="xi-angle-right-thin"></i>
		</button>
		</section>
		<section class="board_area">
		<div class="container">
			<div class="board box">
				<h2>교육과정 모집공고</h2>
				<ul>
					<%
					ArrayList<IndexDto> list=null;
					list=(ArrayList<IndexDto>)request.getAttribute("indexlist");
					for(int i=0; i<list.size(); i++){
						if(i==5)break;
						IndexDto bean=list.get(i);
					%>
					<li><a href="/bitcamp_lms/home/educurridetail.html?idx=<%= bean.getRecr_no()%>"><span><%=bean.getLec_name() %></span><span><%=bean.getRecr_date() %></span></a></li>
					<%
					}
					%>	
				</ul>
			</div>
			<div class="lms box">
				<h2 class="hidden">LMS서비스</h2>
				<p>
					<a href="lms/login.html"> <i class="xi-school"></i><br> LMS서비스<br>
						<span>바로가기</span>
					</a>
				</p>
			</div>
			<div class="service box">
				<div>
					<h2>고객센터</h2>
					<p class="call_txt">
						<strong>02)3486-9600</strong>
					</p>
					<p>
						<span>평일 09:00 ~ 22:00</span>
					</p>
					<p>
						<span>주말/공휴일 10:00 ~ 18:00</span>
					</p>
				</div>
			</div>
		</div>
		</section>
	</div>
	<div id="footer">
		<div class="container">
			<p class="foot_logo">
				<img src="images/ico/logo_w.png" alt="비트캠프 구리센터">
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