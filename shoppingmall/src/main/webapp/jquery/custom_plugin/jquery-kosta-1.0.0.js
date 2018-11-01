/* jQuery 확장을 통한 사용자 플러그인 개발 */
$.fn.setBackground = function(color){
	$(this).css("background",color);
	return $(this);
};
