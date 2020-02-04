/* bPopup */
/*================================================================================
 * @name: bPopup - if you can't get it up, use bPopup
 * @author: (c)Bjoern Klinggaard (twitter@bklinggaard)
 * @demo: http://dinbror.dk/bpopup
 * @version: 0.11.0.min
 ================================================================================*/
 (function(c){c.fn.bPopup=function(A,E){function L(){a.contentContainer=c(a.contentContainer||b);switch(a.content){case "iframe":var d=c('<iframe class="b-iframe" '+a.iframeAttr+"></iframe>");d.appendTo(a.contentContainer);t=b.outerHeight(!0);u=b.outerWidth(!0);B();d.attr("src",a.loadUrl);l(a.loadCallback);break;case "image":B();c("<img />").load(function(){l(a.loadCallback);F(c(this))}).attr("src",a.loadUrl).hide().appendTo(a.contentContainer);break;default:B(),c('<div class="b-ajax-wrapper"></div>').load(a.loadUrl,a.loadData,function(d,b,e){l(a.loadCallback,b);F(c(this))}).hide().appendTo(a.contentContainer)}}function B(){a.modal&&c('<div class="b-modal '+e+'"></div>').css({backgroundColor:a.modalColor,position:"fixed",top:0,right:0,bottom:0,left:0,opacity:0,zIndex:a.zIndex+v}).appendTo(a.appendTo).fadeTo(a.speed,a.opacity);C();b.data("bPopup",a).data("id",e).css({left:"slideIn"==a.transition||"slideBack"==a.transition?"slideBack"==a.transition?f.scrollLeft()+w:-1*(x+u):m(!(!a.follow[0]&&n||g)),position:a.positionStyle||"absolute",top:"slideDown"==a.transition||"slideUp"==a.transition?"slideUp"==a.transition?f.scrollTop()+y:z+-1*t:p(!(!a.follow[1]&&q||g)),"z-index":a.zIndex+v+1}).each(function(){a.appending&&c(this).appendTo(a.appendTo)});G(!0)}function r(){a.modal&&c(".b-modal."+b.data("id")).fadeTo(a.speed,0,function(){c(this).remove()});a.scrollBar||c("html").css("overflow","auto");c(".b-modal."+e).unbind("click");f.unbind("keydown."+e);k.unbind("."+e).data("bPopup",0<k.data("bPopup")-1?k.data("bPopup")-1:null);b.undelegate(".bClose, ."+a.closeClass,"click."+e,r).data("bPopup",null);clearTimeout(H);G();return!1}function I(d){y=k.height();w=k.width();h=D();if(h.x||h.y)clearTimeout(J),J=setTimeout(function(){C();d=d||a.followSpeed;var e={};h.x&&(e.left=a.follow[0]?m(!0):"auto");h.y&&(e.top=a.follow[1]?p(!0):"auto");b.dequeue().each(function(){g?c(this).css({left:x,top:z}):c(this).animate(e,d,a.followEasing)})},50)}function F(d){var c=d.width(),e=d.height(),f={};a.contentContainer.css({height:e,width:c});e>=b.height()&&(f.height=b.height());c>=b.width()&&(f.width=b.width());t=b.outerHeight(!0);u=b.outerWidth(!0);C();a.contentContainer.css({height:"auto",width:"auto"});f.left=m(!(!a.follow[0]&&n||g));f.top=p(!(!a.follow[1]&&q||g));b.animate(f,250,function(){d.show();h=D()})}function M(){k.data("bPopup",v);b.delegate(".bClose, ."+a.closeClass,"click."+e,r);a.modalClose&&c(".b-modal."+e).css("cursor","pointer").bind("click",r);N||!a.follow[0]&&!a.follow[1]||k.bind("scroll."+e,function(){if(h.x||h.y){var d={};h.x&&(d.left=a.follow[0]?m(!g):"auto");h.y&&(d.top=a.follow[1]?p(!g):"auto");b.dequeue().animate(d,a.followSpeed,a.followEasing)}}).bind("resize."+e,function(){I()});a.escClose&&f.bind("keydown."+e,function(a){27==a.which&&r()})}function G(d){function c(e){b.css({display:"block",opacity:1}).animate(e,a.speed,a.easing,function(){K(d)})}switch(d?a.transition:a.transitionClose||a.transition){case "slideIn":c({left:d?m(!(!a.follow[0]&&n||g)):f.scrollLeft()-(u||b.outerWidth(!0))-200});break;case "slideBack":c({left:d?m(!(!a.follow[0]&&n||g)):f.scrollLeft()+w+200});break;case "slideDown":c({top:d?p(!(!a.follow[1]&&q||g)):f.scrollTop()-(t||b.outerHeight(!0))-200});break;case "slideUp":c({top:d?p(!(!a.follow[1]&&q||g)):f.scrollTop()+y+200});break;default:b.stop().fadeTo(a.speed,d?1:0,function(){K(d)})}}function K(d){d?(M(),l(E),a.autoClose&&(H=setTimeout(r,a.autoClose))):(b.hide(),l(a.onClose),a.loadUrl&&(a.contentContainer.empty(),b.css({height:"auto",width:"auto"})))}function m(a){return a?x+f.scrollLeft():x}function p(a){return a?z+f.scrollTop():z}function l(a,e){c.isFunction(a)&&a.call(b,e)}function C(){z=q?a.position[1]:Math.max(0,(y-b.outerHeight(!0))/2-a.amsl);x=n?a.position[0]:(w-b.outerWidth(!0))/2;h=D()}function D(){return{x:w>b.outerWidth(!0),y:y>b.outerHeight(!0)}}c.isFunction(A)&&(E=A,A=null);var a=c.extend({},c.fn.bPopup.defaults,A);a.scrollBar||c("html").css("overflow","hidden");var b=this,f=c(document),k=c(window),y=k.height(),w=k.width(),N=/OS 6(_\d)+/i.test(navigator.userAgent),v=0,e,h,q,n,g,z,x,t,u,J,H;b.close=function(){r()};b.reposition=function(a){I(a)};return b.each(function(){c(this).data("bPopup")||(l(a.onOpen),v=(k.data("bPopup")||0)+1,e="__b-popup"+v+"__",q="auto"!==a.position[1],n="auto"!==a.position[0],g="fixed"===a.positionStyle,t=b.outerHeight(!0),u=b.outerWidth(!0),a.loadUrl?L():B())})};c.fn.bPopup.defaults={amsl:50,appending:!0,appendTo:"body",autoClose:!1,closeClass:"b-close",content:"ajax",contentContainer:!1,easing:"swing",escClose:!0,follow:[!0,!0],followEasing:"swing",followSpeed:500,iframeAttr:'scrolling="no" frameborder="0"',loadCallback:!1,loadData:!1,loadUrl:!1,modal:!0,modalClose:!0,modalColor:"#000",onClose:!1,onOpen:!1,opacity:.7,position:["auto","auto"],positionStyle:"absolute",scrollBar:!0,speed:250,transition:"fadeIn",transitionClose:!1,zIndex:9997}})(jQuery);

 /* 뒤로가기 */
function historyBack() {
	$(".btn_back").on("click", function() {
		history.back();
	});
}

/* 약관/방침 보기 */
function termsView() {
	var button = $(".list_chks button");
	button.on("click", function() {
		var terms = $(this).siblings("textarea"),
			span = $(this).find("span");
		if (terms.is(":visible")) {
			terms.slideUp(300);
			span.text("보기");
		} else {
			terms.slideDown(300);
			span.text("닫기");
		}
	});
}

/* 유효성검사 */
function validation() {
	var id = $("#logId"),
		pwAll = $("input[type=password]"),
		pw1 = $("#logPw1"),
		pw2 = $("#logPw2"),
		tel= $("#logNum"),
		quest = $("#logQuest"),
		answer = $("#logAnswer"),
		name1 = $("#logName"),
		ch1= $("#logTerms1"),
		ch2= $("#logTerms2");
		
		
	function msgInit(tooltip) {
		tooltip.text("");
		tooltip.css("opacity", 0);
	}
	/* 공란 */
	$("input").on("focusout", function() {
		var tooltip = $(this).siblings(".msg");
		var value = $(this).val();
		if (value == "") {
			tooltip.text("필수 입력사항입니다.");
			tooltip.css("opacity", 1);
		}
	});
	/* 이메일 주소 */
	id.on("change", function() {
		var tooltip = $(this).siblings(".msg");
		var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i,
			value = $(this).val();
		if (value != "" && !re.test(value)) {
			tooltip.text("이메일주소 형식이 올바르지 않습니다.");
			tooltip.css("opacity", 1);
		} else {
			msgInit(tooltip);
		}
	});
	/* 비밀번호 영문+숫자 8자리 이상 */
	pw1.on("change", function() {
		var tooltip = $(this).siblings(".msg");
		var re = /^.*(?=.{8,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;
		var value = pw1.val();
		if(!re.test(value)){
			tooltip.text("8~20자 영문과 숫자를 조합한 비밀번호를 입력해주세요");
			tooltip.css("opacity", 1);
		} else {
			msgInit(tooltip);
		}
	});
	/* 비밀번호 확인 */
	pw2.on("change", function(){
		var tooltip = $(this).siblings(".msg");
		var value1 =pw1.val();
		var value2 =pw2.val();
		if (value1 != value2) {
			tooltip.text("비밀번호가 일치하지 않습니다.");
			tooltip.css("opacity", 1);
		} else {
			msgInit(tooltip);
		}
	});
	/* 연락처 */
	tel.on("change", function(){
		var tooltip = $(this).siblings(".msg");
		var re = /^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/;
		var value = tel.val();
		if (!re.test(value)) {
			tooltip.text("연락처 형식이 올바르지 않습니다.");
			tooltip.css("opacity", 1);
		} else {
			msgInit(tooltip);
		}
	});
	/* 질문 */
	quest.on("change", function(){
		var tooltip = $(this).siblings(".msg");
		var value = quest.val();
		if (value == "") {
			tooltip.text("질문을 선택해주세요.");
			tooltip.css("opacity", 1);
		} else {
			msgInit(tooltip);
		}
	});
	/* 답변 */
	answer.on("change", function(){
		var tooltip = $(this).siblings(".msg");
		var value = answer.val();
		if (value != "") {
			tooltip.text("");
			tooltip.css("opacity", 1);
		}
	});
	/* 이름 */
	name1.on("change", function(){
		var tooltip = $(this).siblings(".msg");
		var value = name1.val();
		if (value != "") {
			tooltip.text("");
			tooltip.css("opacity", 1);
		} 
	});
}

/* 유효성검사 Submit */
function validJoin() {
	var jname = $("#logName"),
		jid = $("#logId"),
		jpw1= $("#logPw1"),
		jpw2= $("#logPw2"),
		jtel= $("#logNum"),
		jquest = $("#logQuest"),
		janswer = $("#logAnswer"),
		jch1= $("#logTerms1"),
		jch2= $("#logTerms2");

	if(jname.val() == ""){
		var tooltip = jname.siblings(".msg");
		tooltip.text("이름을 입력해주세요");
		tooltip.css("opacity", 1);
		return false;
	}
	var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i
	if(!re.test(jid.val())){
		var tooltip = jid.siblings(".msg");
		tooltip.text("이메일주소 형식이 올바르지 않습니다.");
		tooltip.css("opacity", 1);
		return false;
	}
	var re = /^.*(?=.{8,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;
	if(!re.test(jpw1.val())){
		var tooltip = jpw1.siblings(".msg");
		tooltip.text("8~20자 영문과 숫자를 조합한 비밀번호를 입력해주세요");
		tooltip.css("opacity", 1);
		return false;
	}
	if(jpw1.val() != jpw2.val()){
		var tooltip = jpw2.siblings(".msg");
		tooltip.text("비밀번호가 일치하지 않습니다.");
		tooltip.css("opacity", 1);
		return false;
	}
	var re = /^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/;
	if(!re.test(jtel.val())){
		var tooltip = jtel.siblings(".msg");
		tooltip.text("연락처 형식이 올바르지 않습니다.");
		tooltip.css("opacity", 1);
		return false;
	}
	if(jquest.val() == ""){
		var tooltip = jquest.siblings(".msg");
		tooltip.text("질문을 선택해주세요");
		tooltip.css("opacity", 1);
		return false;
	}
	if(janswer.val() == ""){
		var tooltip = janswer.siblings(".msg");
		tooltip.text("답변을 입력해주세요");
		tooltip.css("opacity", 1);
		return false;
	}
	if(!jch1.prop("checked") || !jch2.prop("checked")){
		var tooltip = jch1.parents("li").siblings(".msg");
		console.log(tooltip);
		tooltip.text("약관에 동의해주세요");
		tooltip.css("opacity", 1);
		return false;
	}
}

/* 아이디 찾기 submit */
function validationFindid() {
	var tel = $("#logNum"),
		name = $("#logName");
	if(name.val() == ""){
		var tooltip = name.siblings(".msg");
		tooltip.text("이름을 입력해주세요");
		tooltip.css("opacity", 1);
		return false;
	}
	var re = /^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/;
	if(!re.test(tel.val())){
		var tooltip = tel.siblings(".msg");
		tooltip.text("연락처 형식이 올바르지 않습니다.");
		tooltip.css("opacity", 1);
		return false;
	}
}

/* 비밀번호찾기 submit*/
function validationFindpw1(){
	var id = $("#logId");
	var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i
	if(!re.test(id.val())){
		var tooltip = id.siblings(".msg");
		tooltip.text("이메일주소 형식이 올바르지 않습니다.");
		tooltip.css("opacity", 1);
		return false;
	}
}
function validationFindpw2(){
    var	quest = $("#logQuest"),
		answer = $("#logAnswer");
	if(quest.val() == ""){
		var tooltip = quest.siblings(".msg");
		tooltip.text("질문을 선택해주세요");
		tooltip.css("opacity", 1);
		return false;
	}
	if(answer.val() == ""){
		var tooltip = answer.siblings(".msg");
		tooltip.text("답변을 입력해주세요");
		tooltip.css("opacity", 1);
		return false;
	}
}
function validationFindpw3(){
	var pw1= $("#logPw1"),
		pw2= $("#logPw2");
	var re = /^.*(?=.{8,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;
	if(!re.test(pw1.val())){
		var tooltip = pw1.siblings(".msg");
		tooltip.text("8~20자 영문과 숫자를 조합한 비밀번호를 입력해주세요");
		tooltip.css("opacity", 1);
		return false;
	}
	if(pw1.val() != pw2.val()){
		var tooltip = pw2.siblings(".msg");
		tooltip.text("비밀번호가 일치하지 않습니다.");
		tooltip.css("opacity", 1);
		return false;
	}
}

function step2() {
	$(".step2").slideDown(300);
	$("#logId").addClass("block").prop("readonly", true);
}
function step3() {
	$(".step2").slideUp(300);
	$(".step3").slideDown(300);
}
/* } 임시 (완료 후 삭제 예정=) */

/* 레이어팝업 */
function popup() {
	$("#popup").bPopup({
		closeClass: "btn_off",
		modalClose: false,
		positionStyle: 'fixed',
	});
}
/* 팝업 후 로그인페이지*/
function popupResult() {
	$("#popup").bPopup({
		closeClass: "btn_off",
		modalClose: false,
		positionStyle: 'fixed',
		onClose:function(){location.href="login.html";}
	});
}

/* 메인 { */
function progress() {
	var bar = $(".progress b");
	bar.each(function() {
		var percent = $(this).parents("li").children("span").text() / 100;
		var width = $(this).parents("p").width();
		var total = percent * width;
		var times = 1000;
		$(this).stop().animate({left: total}, times);
	});
}
function count() {
	var count = $(".stats span");
	count.counterUp({
		delay: 30,
		time: 1000
	});
}
/* 출결관리 */
function attend() {
	var button = $("#btnAttend");
	$(".btn_off.yes").on("click", function() {
		if (button.hasClass("in")) {
			button.addClass("out").removeClass("in");
		} else {
			button.addClass("in").removeClass("out");
		}
	});
}
/* } 메인 */

$(document).ready(function() {
	/* 회원가입*/
	if($("#hiddenDupliID").val() =="1"){
		var tooltip = $("#logId").siblings(".msg");
		tooltip.text("이미 사용중인 아이디입니다. 다시 입력해주세요");
		tooltip.css("opacity", 1);
	}else if($("#hiddenDupliID").val() =="0" && $("#hiddenJoinName").val() == "1"){
		popupResult();
	}
	
	/* 로그인  */
	if($("#hiddenLogin").val() == "0"){
		var tooltip = $("#hiddenLogin").siblings(".msg");
		tooltip.text("아이디 또는 비밀번호가 일치하지 않습니다.");
		tooltip.css("opacity", 1);
	}else if ($("#hiddenLogin").val() == "1"){
		location.href="index.html";
	}
	/* 아이디 찾기 */
	if($("#hiddenFindid").val() == "0"){
		var tooltip = $("#hiddenFindid").siblings(".msg");
		tooltip.text("이름 또는 연락처가 일치하지 않습니다.");
		tooltip.css("opacity", 1);
	}else if ($("#hiddenFindid").val() == "1"){
		popupResult();
	}
	/* 비밀번호 찾기*/
	if($("#hiddenfindpwID").val() == "1"){
		$("#formFindpw").attr("onsubmit", "return validationFindpw2()");
		$("#logId").val($("#hiddenfindpw").val());
		$(".step2").slideDown(300);
		$("#logId").addClass("block").prop("readonly", true);
	}else if($("#hiddenfindpwID").val() == "0"){
		var tooltip = $("#logId").siblings(".msg");
		tooltip.text("가입되지 않은 이메일입니다. 다시 입력해주세요.");
		tooltip.css("opacity", 1);
	}
	if($("#hiddenfindpwQA").val() == "1"){
		$("#formFindpw").attr("onsubmit", "return validationFindpw3()");
		$("#logId").val($("#hiddenfindpw").val());
		$(".step2").show();
		$("#logId").addClass("block").prop("readonly", true);
		$(".step2").slideUp(300);
		$(".step3").slideDown(300);
	}else if($("#hiddenfindpwQA").val() == "0"){
		$("#formFindpw").attr("onsubmit", "return validationFindpw2()");
		$("#logId").val($("#hiddenfindpw").val());
		$(".step2").show();
		$("#logId").addClass("block").prop("readonly", true);
		var tooltip = $("#logAnswer").siblings(".msg");
		tooltip.text("질문 또는 답변이 일치하지 않습니다. 다시 입력해주세요.");
		tooltip.css("opacity", 1);
	}
	if($("#hiddenfindpwPW").val() == "1"){
		popupResult();
	}
	/* 회원정보수정 비밀번호 확인*/
	if($("#hiddenLockResult").val() == "0"){
		var tooltip = $("#logPw2").siblings(".msg");
		tooltip.text("비밀번호가 일치하지 않습니다.");
		tooltip.css("opacity", 1);
	}else if($("#hiddenLockResult").val() == "1"){
		location.href="profile.html";
	}
	/* 레이어팝업 */
	$(".btn_pop").on("click", function() {
		popup();
	});
	historyBack();
});

/* datepicker */
function datepick() {
	$(".btn_date").datepicker({
		dateFormat: "yy-mm-dd"
	});
}

/* member */
function ref() {
	$(".mb_curriculum").each(function() {
		var tooltip = $(this).find("span"),
			text = $(this).text();
		tooltip.text(text);
		$(this).on("mouseenter", function() {
			tooltip.css("opacity", 1);
		});
		$(this).on("mouseleave", function() {
			tooltip.css("opacity", 0);
		});
	});
}
