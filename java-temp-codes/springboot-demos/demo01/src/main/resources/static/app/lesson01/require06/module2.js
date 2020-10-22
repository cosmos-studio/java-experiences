'use strict';
define(['jquery'], function(jQ) {
	function fun1() {
		jQ('#msg2').text('Module 2');
	}

	fun1();
})