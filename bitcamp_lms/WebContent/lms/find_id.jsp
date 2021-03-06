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
	<div class="untit_wrap mid">
		<div>
			<div id="header">
				<h1><a href="../lms"><img src="../images/ico/logo_big.png" alt="" width="300"></a></h1>
			</div>
			<div id="container">
				<form class="form_join" method="post" onsubmit="return validationFindid()">
					<h2>아이디 찾기</h2>
					<ul class="list_ipts">
						<li>
							<label for="logName" class="hidden">이름</label>
							<input type="text" id="logName" placeholder="이름" name="findid_name">
							<p class="msg err"></p>
						</li>
						<li>
							<label for="logNum" class="hidden">연락처</label>
							<input type="text" id="logNum" placeholder="연락처 (010-0000-0000)" name="findid_tel">
							<p class="msg err"></p>
						</li>
					</ul>
					<input type="hidden" id="hiddenFindid" value="${param.result}">
					<p class="msg err"></p>
					<ul class="list_btns">
						<li><button type="button" onclick="history.back(-1);">취소</button></li>
						<li><button type="submit">확인</button></li>
					</ul>
				</form>
			</div>
		</div>
	</div>
	<div id="footer">
		<p>Copyright &copy; 비트캠프 All rights reserved.</p>
	</div>
</div>
<div id="popup">
	<p class="alert">
		${findid.name } 님의 ID는 <b>${findid.id }</b> 입니다.<br>
		확인을 누르시면 로그인 페이지로 이동합니다.
	</p>
	<div class="btns">
		<button type="button" class="btn_off yes">확인</button>
	</div>
</div>
<script type="text/javascript">
	validation();
</script>
</body>
</html>