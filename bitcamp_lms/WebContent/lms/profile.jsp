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
					<li>
						<a href="">
							<i class="xi-emoticon"></i>
							<span>나의 교육과정</span>
						</a>
					</li>
					<li>
						<a href="">
							<i class="xi-book-o"></i>
							<span>나의 출결현황</span>
						</a>
					</li>
					<li>
						<a href="">
							<i class="xi-presentation"></i>
							<span>나의 성적조회</span>
						</a>
					</li>
					<li>
						<a href="">
							<i class="xi-info-o"></i>
							<span>강의실 공지사항</span>
						</a>
					</li>
				</ul>
			</div>
			<div class="content_area">
				<div class="profile_wrap">
					<h2>회원정보수정</h2>
					<form>
						<ul class="list_ipts">
							<li>
								<label for="logName">이름</label>
								<input type="hidden" id="logName" value="홍길동">
								<span>홍길동</span>
							</li>
							<li>
								<label for="logId">아이디(이메일)</label>
								<input type="hidden" id="logId" value="user01@email.com">
								<span>user01@email.com</span>
							</li>
							<li>
								<label for="logPw1">비밀번호</label>
								<input type="password" id="logPw1">
								<p class="msg err"></p>
							</li>
							<li>
								<label for="logPw2">비밀번호 확인</label>
								<input type="password" id="logPw2">
								<p class="msg err"></p>
							</li>
							<li>
								<label for="logNum">연락처</label>
								<input type="text" id="logNum" placeholder="연락처 (010-0000-0000)" value="010-0000-0000">
								<p class="msg err"></p>
							</li>
							<li>
								<label for="logQuest">비밀번호 확인 질문</label>
								<select id="logQuest">
									<option value="">비밀번호 확인 질문</option>
									<option value="" selected="true">내가 좋아하는 캐릭터는?</option>
								</select>
							</li>
							<li>
								<label for="logAnswer">비밀번호 확인 답변</label>
								<input type="text" id="logAnswer" placeholder="비밀번호 확인 답변" value="둘리">
								<p class="msg err"></p>
							</li>
						</ul>
						<ul class="list_btns">
							<li><button type="button">취소</button></li>
							<li><button type="submit">확인</button></li>
						</ul>
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