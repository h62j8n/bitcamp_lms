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

$(document).ready(function() {
	mainGnb();
});