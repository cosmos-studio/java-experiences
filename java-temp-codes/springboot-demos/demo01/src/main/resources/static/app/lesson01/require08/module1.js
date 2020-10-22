'use strict';
define( [ 'jquery', 'util' ], function($, util) {
	function sendmsg() {
		util.msgTag('m1').text('Hello M1');
	}
	return {
		'sendmsg' : sendmsg
	}
})