'use strict';
//UMD basic
(function(root, factory) {
	if (typeof define === 'function' && define.amd) {
		// AMD
		define(['util'], factory);
	} else if (typeof exports === 'object') {
		// Node, CommonJS之类的
		module.exports = factory(require('util'));
	} else {
		// 浏览器全局变量(root 即 window)
		root.M3 = factory(root.Util);
	}
}(this, function(Util) {
	function sendmsg() {
		Util.msgTag('m3').text('Hello M3');
	};
	return {
		'sendmsg' : sendmsg
	}
}));