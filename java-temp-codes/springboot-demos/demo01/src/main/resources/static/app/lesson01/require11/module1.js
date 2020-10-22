'use strict';
//if the module name 'm1' is provided, we must keep it is the same with the key name in config.paths.
//define('m1', ['util' ], function(util) {
define([ 'util' ], function(Util) {
	function sendmsg() {
		Util.msgTag('m1').text('Hello M1');
	}
	return {
		'sendmsg' : sendmsg
	}
})
