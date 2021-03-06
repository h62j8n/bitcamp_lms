<%@page import="com.bit.lms.model.Member3Dto,java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				<div id="member3" class="board_wrap member">
					<h2>수강등록 관리</h2>
					<div class="top box">
						<p>수강신청한 회원 목록 (총 000명)</p>
					</div>
					<form>
						<dl class="list head box">
							<dt>
								<ul>
									<li>수강상태</li>
									<li>이름</li>
									<li>이메일(ID)</li>
									<li>연락처</li>
									<li>관리</li>
								</ul>
							</dt>
							<dd>
								<ul>
									<li>강의코드</li>
									<li>강의실</li>
									<li>교육과정명</li>
								</ul>
							</dd>
						</dl>
						<dl class="list body box">
							<c:forEach items="${recrList }" var="bean">
								<dt>
									<ul>
										<li>
											<input type="hidden" id="hiddenapplmbno" value="${bean.id}" name="lecId">
											<input type="hidden" id="hiddenlecSta" value="${bean.staCode}">
											<select id="lecSta" name="lecSta">
												<option value="1">수강신청</option>
												<option value="2">수강등록</option>
												<option value="0">신청취소</option>
											</select>
										</li>
										<li>${bean.name}</li>
										<li>${bean.id}</li>
										<li>${bean.tel}</li>
										<li><button type="submit">적용</button></li>
									</ul>
								</dt>
								<dd>
									<ul>
										<li>${bean.lecCode}</li>
										<li>${bean.lecRoomNo} 강의실</li>
										<li class="mb_curriculum">
											<p>${bean.lecName}</p>
											<span></span>
										</li>
									</ul>
								</dd>
							</c:forEach>
						</dl>
						<input type="hidden" id="hiddenMember3" value="${param.result}">
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
<script type="text/javascript">
ref();
</script>
</body>
</html>