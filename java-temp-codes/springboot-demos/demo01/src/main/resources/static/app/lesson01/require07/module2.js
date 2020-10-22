'use strict';
define(['jquery'], function() {
	function fun1() {
		$('#msg2').text('Module 2');
	}

	return {
		'fun1' : fun1
	}
})