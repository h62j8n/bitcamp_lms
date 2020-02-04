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
				<form class="form_join" method="post" id="formFindpw" onsubmit="return validationFindpw1()">
					<h2>비밀번호 찾기/변경</h2>
					<ul class="list_ipts">
						<li>
							<label for="logId" class="hidden">아이디(이메일)</label>
							<input type="email" id="logId" placeholder="아이디(이메일)" name="findpw_id">
							<p class="msg err"></p>
						</li>
						<li class="step2">
							<label for="logQuest" class="hidden">비밀번호 확인 질문</label>
							<select id="logQuest" name="findpw_question">
								<option value="">비밀번호 확인 질문</option>
								<option value="자신의 인생 좌우명은?">자신의 인생 좌우명은?</option>
								<option value="자신이 두번째로 존경하는 인물은?">자신이 두번째로 존경하는 인물은?</option>
								<option value="인상 깊게 읽은 책 이름은?">인상 깊게 읽은 책 이름은?</option>
								<option value="내가 좋아하는 캐릭터는?">내가 좋아하는 캐릭터는?</option>
								<option value="다시 태어나면 되고 싶은 것은?">다시 태어나면 되고 싶은 것은?</option>
							</select>
							<p class="msg err"></p>
						</li>
						<li class="step2">
							<label for="logAnswer" class="hidden">비밀번호 확인 답변</label>
							<input type="text" id="logAnswer" placeholder="비밀번호 확인 답변" name="findpw_answer">
							<p class="msg err"></p>
						</li>
						<li class="step3">
							<label for="logPw1" class="hidden">비밀번호</label>
							<input type="password" id="logPw1" placeholder="비밀번호 (8자리 이상 20자리 이하, 영문+숫자)" name="findpw_pw">
							<p class="msg err"></p>
						</li>
						<li class="step3">
							<label for="logPw2" class="hidden">비밀번호 확인</label>
							<input type="password" id="logPw2" placeholder="비밀번호 확인">
							<p class="msg err"></p>
						</li>
					</ul>
					<p class="msg err"></p>
					<ul class="list_btns">
						<li><button type="button" onclick="location.href='login.html'">취소</button></li>
						<li><button type="submit">확인</button></li>
					</ul>
					<input type="hidden" id="hiddenfindpw" value="${findpwID.id }">
					<input type="hidden" id="hiddenfindpwID" value="${param.result_id }">
					<input type="hidden" id="hiddenfindpwQA" value="${param.result_qa }">
					<input type="hidden" id="hiddenfindpwPW" value="${param.result_pw }">
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
		비밀번호 변경이 완료되었습니다.<br>
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