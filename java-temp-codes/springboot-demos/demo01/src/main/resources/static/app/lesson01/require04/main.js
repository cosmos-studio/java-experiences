'use strict';
require.config({
	paths: {
		'm1':'module1',
		m2: 'module2'
	}
})
require(
	['m1', 'm2'],
	function(M1, M2) {
		$('#main').text('Module 1 & 2 loaded successfully.');
	}
)