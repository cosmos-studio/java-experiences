'use strict';
require(
	[
		'm1',
		'm2',
		'm3'
	],
	function(
		M1,
		M2,
		M3
	) {
	$(function() {
		M1.sendmsg();
		M2.sendmsg();
		M3.sendmsg();
	})
})
