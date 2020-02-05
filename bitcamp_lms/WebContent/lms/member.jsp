<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.bit.lms.model.LoginDto, com.bit.lms.model.MemberDto, java.util.ArrayList" %>
<%
LoginDto login =(LoginDto)session.getAttribute("login");
if(login!=null){
%>
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
			<h1><a href=""><img src="../images/ico/logo_w.png" alt="비트캠프 구리센터"></a></h1>
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
				</ul>
			</div>
			<div class="content_area">
				<div id="member" class="board_wrap member list">
					<h2>회원 관리</h2>
					<div class="top box">
						<p>일반회원 목록 (총 000명)</p>
						<select id="bdSelect">
							<option value="회원">회원</option>
							<option value="관리자">관리자</option>
						</select>
					</div>
					<form>
						<dl class="list head box">
							<dt>
								<ul>
									<li>구분</li>
									<li>이름</li>
									<li>이메일(ID)</li>
									<li>연락처</li>
									<li>관리<button type="button" class="btn_more"></button></li>
								</ul>
							</dt>
							<dd>
								<ul>
									<li>강의코드</li>
									<li>강의실</li>
									<li>교육과정명</li>
									<li>1회차</li>
									<li>2회차</li>
									<li>3회차</li>
									<li>출석률</li>
								</ul>
							</dd>
						</dl>
						<dl class="list body box">
							<dt>
								<ul>
									<li>
										<select>
											<option value="">관리자</option>
											<option value="">회원</option>
										</select>
										<select>
											<option value="">행정팀</option>
											<option value="">영업팀</option>
											<option value="">취업팀</option>
											<option value="">회계팀</option>
											<option value="">강사팀</option>
										</select>
									</li>
									<li>홍길동</li>
									<li>user01@email.com</li>
									<li>010-0000-0000</li>
									<li><button type="submit">적용</button></li>
								</ul>
							</dt>
							<dd>
								<ul>
									<li class="mb_empty">등록된 교육과정 정보가 없습니다.</li>
								</ul>
							</dd>
							<dt>
								<ul>
									<li>
										<select>
											<option value="">회원</option>
											<option value="">관리자</option>
										</select>
										<select>
											<option value="">수강신청</option>
											<option value="">수강등록</option>
											<option value="">신청취소</option>
										</select>
									</li>
									<li>홍길동</li>
									<li>user01@email.com</li>
									<li>010-0000-0000</li>
									<li><button type="submit">적용</button></li>
								</ul>
							</dt>
							<dd>
								<ul>
									<li>LEC1000</li>
									<li>제 1강의실</li>
									<li class="mb_curriculum">
										<p>디지털컨버전스 기반 자바 Open Source Web application 전문 개발자 양성과정 - 3월</p>
										<span></span>
									</li>
									<li>0.00</li>
									<li>0.00</li>
									<li>0.00</li>
									<li>0%</li>
								</ul>
							</dd>
							<dt>
								<ul>
									<li>
										<p>회원</p>
										<p>수강 진행 중</p>
									</li>
									<li>홍길동</li>
									<li>user01@email.com</li>
									<li>010-0000-0000</li>
									<li><button type="submit">적용</button></li>
								</ul>
							</dt>
							<dd>
								<ul>
									<li>LEC1000</li>
									<li>제 1강의실</li>
									<li class="mb_curriculum">
										<p>디지털컨버전스 기반 자바 Open Source Web application 전문 개발자 양성과정 - 3월</p>
										<span></span>
									</li>
									<li>0.00</li>
									<li>0.00</li>
									<li>0.00</li>
									<li>0%</li>
								</ul>
							</dd>
						</dl>
					</form>
					<div class="bottom box">
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
<%
}else{
	response.sendRedirect("login.html?msg=AccessDenied");
}
%>