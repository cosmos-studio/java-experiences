'use strict';
define('m2', [ 'jquery', 'util' ], function($, util) {
	function sendmsg() {
		util.msgTag('m2').text('Hello M2');
	}
	return {
		'sendmsg' : sendmsg
	}
})