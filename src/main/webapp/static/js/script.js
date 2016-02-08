$(document).ready(function(){

	var mainSilde = $('.main-silde-wrapper .swiper-container').swiper({
	   	mode:'horizontal',
	   	loop: true,
	   	paginationClickable: true,
	   	grabCursor: true,
	   	pagination: '.pagination'
	  });

	var slide_w = 751; 
	var slide_h = 393; 

	var reSizeSilde = function () {
	  	var win_w = $(window).width();
	  	var new_h = (slide_h/slide_w)*win_w;
	  	$('.main-silde-wrapper, .main-silde-wrapper .swiper-container, .main-silde-wrapper .swiper-slide').height(new_h);
	};

	reSizeSilde();

	$(window).resize(function () {
		reSizeSilde();
	});

});