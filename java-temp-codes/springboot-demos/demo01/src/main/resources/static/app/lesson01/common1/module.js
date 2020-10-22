'use strict';
(function(CommonUtil) {
	function fun1() {
		window.onload = function() {
			var msg = document.getElementById('msg');
			CommonUtil.setInnerText(msg, 'loaded by javascript...');
		};
	};
	fun1();
})(CommonUtil || {})
