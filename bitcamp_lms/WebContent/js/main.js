function mainGnb() {
	var gnb = $("#gnb > li");
	gnb.on("mouseenter", function() {
		var list = $(this).find("ul");
		list.stop(true, true).slideDown(250);
	});
	gnb.on("mouseleave", function() {
		var list = $(this).find("ul");
		list.stop(true, true).slideUp(250);
	});
}

function mainSlider() {
	var swiper = new Swiper('.swiper-container', {
	  navigation: {
		nextEl: '.swiper-button-next',
		prevEl: '.swiper-button-prev',
	  },
	  autoplay: {
		delay: 5000,
	  },
	  loop: true,
	});
}

function pagination() {
	var pg = $(".bd_pages").find("li"),
		pgNum = pg.length;
	if (pgNum < 2) {
		pg.hide();
	}
}

function historyBack() {
	$(".btn_back").on("click", function() {
		history.back();
	});
}

$(document).ready(function() {
	mainGnb();
	historyBack();
	pagination();
});