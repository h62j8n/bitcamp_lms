<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,com.bit.home.model.FAQDto" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="../js/main.js"></script>
	<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
	<link href="../css/home.css" rel="stylesheet" type="text/css">
	<link rel="shortcut icon" href="/favicon.ico">
	<title>비트캠프 구리센터</title>
</head>
<body>
<div id="wrap">
<div id="header">
	<div class="container">
		<h1><a href="/bitcamp_lms"><img src="../images/ico/logo.png" alt="비트캠프 구리센터"></a></h1>
		<ul id="gnb">
			<li>
				<a href="/bitcamp_lms/home/educenter.html">교육센터</a>
				<ul>
					<li><a href="/bitcamp_lms/home/educenter.html">교육센터 소개</a></li>
				</ul>
			</li>
			<li>
				<a href="/bitcamp_lms/home/educurriculum.html">교육과정</a>
				<ul>
					<li><a href="/bitcamp_lms/home/educurriculum.html">모집공고</a></li>
				</ul>
			</li>
			<li>
				<a href="/bitcamp_lms/home/hire.html">취업지원</a>
				<ul>
					<li><a href="/bitcamp_lms/home/hire.html">채용공고</a></li>
				</ul>
			</li>
			<li>
				<a href="/bitcamp_lms/home/notice.html">학생지원</a>
				<ul>
					<li><a href="/bitcamp_lms/home/notice.html">공지사항</a></li>
					<li><a href="/bitcamp_lms/home/faq.html">FAQ</a></li>
				</ul>
			</li>
		</ul>
		<ul class="quick">
			<li><a href="https://www.bitcamp.co.kr/sch" target="_blank">서초본원</a></li>
			<li><a href="https://www.bitcamp.co.kr/gn" target="_blank">강남센터</a></li>
			<li><a href="https://www.bitcamp.co.kr/sc" target="_blank">신촌센터</a></li>
			<li><a href="https://www.bitcamp.co.kr/cr" target="_blank">종로센터</a></li>
			<li><a href="../lms/login.html" target="_blank">LMS서비스</a></li>
		</ul>
	</div>
</div>
<div id="container">
	<section class="title_area">
		<div class="container">
			<div>
				<h3>학생지원</h3>
				<p>친절하고 정확하게 안내해드리겠습니다.</p>
			</div>
		</div>
	</section>
	<section class="lnb_area">
		<ul>
			<li><a href="/bitcamp_lms/home/notice.html">공지사항</a></li>
			<li class="on"><a href="/bitcamp_lms/home/faq.html">FAQ</a></li>
		</ul>
	</section>
	<section class="content_area">
		<div class="container">
			<h2>FAQ</h2>
			<div class="board_wrap list">
				<%
				ArrayList<FAQDto> list=null;
				list=(ArrayList<FAQDto>)request.getAttribute("faqlist");
				%>
				<div class="top box">
					<p>총 게시물 : <%= String.format("%03d", list.size()) %></p>
				</div>
				<table class="table box">
					<tbody>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>등록일</th>
							<th>조회수</th>
						</tr>
						<%
						if (list.size() > 0) {
							for(int i=0; i<list.size(); i++){
								FAQDto bean=list.get(i);
						%>
						<tr>
							<td><%= bean.getFaq_no() %></td>
							<td><a href="faqdetail.html?idx=<%= bean.getFaq_no() %>"><%= bean.getFaq_subject() %></a></td>
							<td><%= bean.getFaq_date() %></td>
							<td><%= String.format("%03d", bean.getFaq_count()) %></td>
						</tr>
						<%
							}
						} else {
						%>
						<tr>
							<td class="bd_empty" colspan="4">등록된 게시물이 없습니다.</td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
				<div class="bottom box">
					<ul class="bd_pages">
						<jsp:include page="/util/paging.jsp">
							<jsp:param value="${paging.page}" name="page"/>
							<jsp:param value="${paging.beginPage}" name="begin"/>
							<jsp:param value="${paging.endPage}" name="end"/>
							<jsp:param value="${paging.prev}" name="prev"/>
							<jsp:param value="${paging.next}" name="next"/>
							<jsp:param value="${paging.totalPage}" name="total"/>
						</jsp:include>
					</ul>
				</div>
			</div>
		</div>
	</section>
</div>
<div id="footer">
	<div class="container">
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
			<p>Copyright &copy; 비트캠프 All rights reserved.</p>
		</div>
	</div>
</div>
</div>
</body>
</html>