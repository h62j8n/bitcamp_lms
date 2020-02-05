<%@page import="com.bit.lms.model.TeacherNoticeEditDto"%>
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

				<div class="board_wrap write">

					<h2>공지사항 수정</h2>

					<form method="post">
						<%
						TeacherNoticeEditDto bean=(TeacherNoticeEditDto)request.getAttribute("teachernoticeedit");
						%>

						<table class="table box">

							<tr>
								<th><label for="postName">제목</label></th>
								<input type="hidden" name="cls_no" id="cls_no" value="<%=bean.getCls_no() %>"/>

								<td>

									<input type="text" name="cls_subject" id="cls_subject" value="<%=bean.getCls_subject() %>">

								</td>

							</tr>

							<tr>

								<th><label for="postContent">내용</label></th>

								<td>

									<textarea name="cls_content" id="cls_content"><%=bean.getCls_content() %></textarea>

								</td>

							</tr>

						</table>

						<div class="bottom box">

							<ul class="bd_btns">

								<li><button type="submit" class="btn_submit">수정 완료</button></li>
								<li><a href="teachernotice.html">취소</a></li>

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

</body>

</html>