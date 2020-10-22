'use strict';
//UMD advanced supported AMD
//will error when related modules are not AMD/UMD(support AMD) modules.
(function (factory) {
	var root = (typeof self == 'object' && self.self === self && self) ||
		(typeof global == 'object' && global.global === global && global)
        this ||
        {};
	if (typeof define === 'function' && define.amd) {
		// AMD
		define(['jquery', 'exports'], function($, exports) {
			root.M4 = factory(root, exports, $)
	    });
	} else if (typeof exports !== 'undefined') {
		// Node, CommonJS-like, (typeof exports === 'object')
		var $;
	    try { $ = require('jquery'); } catch (e) {}
	    factory(root, exports, $);
	} else {
		// Browser globals (root is window)
		root.M4 = factory(root, {}, (root.jQuery || root.$));
	}
})(function (root, M4, $) {
	M4.run = function() {
		$('#m4').text('Module 4 loaded successfully.');
	};
	
	return M4;
});
