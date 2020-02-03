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
	<link href="../css/login.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
	<title>비트캠프 구리센터</title>
</head>
<body>
<div id="wrap">
	<div class="login_wrap mid">
		<div>
			<div id="header">
				<h1><a href="../lms"><img src="../images/ico/logo_big.png" alt="비트캠프 구리센터"></a></h1>
			</div>
			<div id="container">
				<h2 class="hidden">로그인</h2>
				<form class="form_login" method="post">
					<dl class="list_ipts">
						<dt>
							<label for="logId">
								<i class="xi-user"></i>
								<em class="hidden">아이디</em>
							</label>
						</dt>
						<dd><input type="text" id="logId" placeholder="e-mail" name=loginid></dd>
					</dl>
					<dl class="list_ipts">
						<dt>
							<label for="logPw">
								<i class="xi-lock"></i>
								<em class="hidden">비밀번호</em>
							</label>
						</dt>
						<dd><input type="password" id="logPw" placeholder="password" name=loginpw></dd>
					</dl>
					<!-- #툴팁 -->
					<input type="hidden" id="hiddenLogin" value="${param.result}">
					<p class="msg err"></p>
					<button type="submit">로그인</button>
				</form>
				<ul class="list_others">
					<li><a href="../lms/find_id.html">아이디</a> / <a href="../lms/find_pw.html">비밀번호 찾기</a></li>
					<li>아직 회원이 아니신가요? <a href="../lms/join.html">회원가입</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div id="footer">
		<p>Copyright &copy; 비트캠프 All rights reserved.</p>
	</div>
</div>
</body>
</html>