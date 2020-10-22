'use strict';
// UMD advanced
(function (factory) {
	var root = (typeof self == 'object' && self.self === self && self) ||
		(typeof global == 'object' && global.global === global && global);
	if (typeof define === 'function' && define.amd) {
		// AMD
		define(['util', 'exports'], function(Util, exports) {
			root.M2 = factory(root, exports, Util)
	    });
	} else if (typeof exports !== 'undefined') {
		// Node, CommonJS-like, (typeof exports === 'object')
		var Util = require('util');
	    factory(root, exports, Util);
	} else {
		// Browser globals (root is window)
		root.M2 = factory(root, {}, root.Util);
	}
})(function (root, M2, Util) {
	M2.sendmsg = function() {
		Util.msgTag('m2').text('Hello M2');
	};
	
	return M2;
});