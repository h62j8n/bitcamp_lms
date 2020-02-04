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
	<div class="join_wrap">
		<div id="header">
			<h1><a href="../lms"><img src="../images/ico/logo_big.png" alt="" width="300"></a></h1>
		</div>
		<div id="container">
			<form class="form_join" method="post" onsubmit="return validJoin()">
				<h2>회원가입</h2>
				<ul class="list_ipts">
					<li>
						<label for="logName" class="hidden">이름</label>
						<input type="text" id="logName" placeholder="이름" name="join_name">
						<p class="msg err"></p>
					</li>
					<li>
						<label for="logId" class="hidden">아이디(이메일)</label>
						<input type="email" id="logId" placeholder="아이디(이메일)" name="join_id">
						<p class="msg err"></p>
					</li>
					<li>
						<label for="logPw1" class="hidden">비밀번호</label>
						<input type="password" id="logPw1" placeholder="비밀번호 (8자리 이상 20자리 이하, 영문+숫자)" name="join_pw">
						<p class="msg err"></p>
					</li>
					<li>
						<label for="logPw2" class="hidden">비밀번호 확인</label>
						<input type="password" id="logPw2" placeholder="비밀번호 확인" name="join_pwcheck">
						<p class="msg err"></p>
					</li>
					<li>
						<label for="logNum" class="hidden">연락처</label>
						<input type="text" id="logNum" placeholder="연락처 (010-0000-0000)" name="join_tel">
						<p class="msg err"></p>
					</li>
					<li>
						<label for="logQuest" class="hidden">비밀번호 확인 질문</label>
						<select id="logQuest" name="join_question">
							<option value="">비밀번호 확인 질문</option>
							<option value="자신의 인생 좌우명은?">자신의 인생 좌우명은?</option>
							<option value="자신이 두번째로 존경하는 인물은?">자신이 두번째로 존경하는 인물은?</option>
							<option value="인상 깊게 읽은 책 이름은?">인상 깊게 읽은 책 이름은?</option>
							<option value="내가 좋아하는 캐릭터는?">내가 좋아하는 캐릭터는?</option>
							<option value="다시 태어나면 되고 싶은 것은?">다시 태어나면 되고 싶은 것은?</option>
						</select>
						<p class="msg err"></p>
					</li>
					<li>
						<label for="logAnswer" class="hidden">비밀번호 확인 답변</label>
						<input type="text" id="logAnswer" placeholder="비밀번호 확인 답변" name="join_answer">
						<p class="msg err"></p>
					</li>
				</ul>
				<ul class="list_chks">
					<li>
						<button type="button">홈페이지 이용약관 (<span>보기</span>)</button>
						<p>
							<input type="checkbox" id="logTerms1">
							<label for="logTerms1">동의합니다</label>
						</p>
						<textarea></textarea>
					</li>
					<li>
						<button type="button">개인정보처리방침 (<span>보기</span>)</button>
						<p>
							<input type="checkbox" id="logTerms2">
							<label for="logTerms2">동의합니다</label>
						</p>
						<textarea></textarea>
					</li>
					<li class="msg err"></li>
				</ul>
				<ul class="list_btns">
					<li><button type="button" onclick="history.back(-1);">돌아가기</button></li>
					<li><button type="submit">가입하기</button></li>
				</ul>
				<input type="hidden" id="hiddenJoinName" value="${param.result}">
				<input type="hidden" id="hiddenDupliID" value="${dupliId.cnt}">
			</form>
		</div>
	</div>
	<div id="footer">
		<p>Copyright &copy; 비트캠프 All rights reserved.</p>
	</div>
</div>
<div id="popup">
	<p class="alert">
		<b>${joinName.name }</b> 님의 회원가입이 완료되었습니다.<br>
		확인을 누르시면 로그인 페이지로 이동합니다.
	</p>
	<div class="btns">
		<button type="button" class="btn_off yes">확인</button>
	</div>
</div>

<script type="text/javascript">
	termsView();
	validation();
</script>
</body>
</html>