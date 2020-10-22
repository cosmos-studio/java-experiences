'use strict';
define(['jquery'], function() {
	function fun1() {
		$('#msg1').text('Module 1');
	}

	return {
		'fun1' : fun1
	}
})