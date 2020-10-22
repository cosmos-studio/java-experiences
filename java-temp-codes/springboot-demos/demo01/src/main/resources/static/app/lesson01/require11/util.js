'use strict';
// UMD advanced supported AMD
// will error when related modules are not AMD/UMD(support AMD) modules.
(function (factory) {
	var root = (typeof self == 'object' && self.self === self && self) ||
		(typeof global == 'object' && global.global === global && global);
	if (typeof define === 'function' && define.amd) {
		// AMD
		define(['jquery', 'exports'], function($, exports) {
			root.Util = factory(root, exports, $)
	    });
	} else if (typeof exports !== 'undefined') {
		// Node, CommonJS-like, (typeof exports === 'object')
		var $;
	    try { $ = require('jquery'); } catch (e) {}
	    factory(root, exports, $);
	} else {
		// Browser globals (root is window)
		root.Util = factory(root, {}, (root.jQuery || root.$));
	}
})(function (root, Util, $) {
	Util.msgTag = function(flag) {
		var idName = flag;
		var msgKey = '#'+idName;
		if($('body').find(msgKey).length > 0) {
			$('body').find(msgKey).remove();
		}
		$('body').children().last().after('<br/><span id="' + idName + '"></span>');
		return $(msgKey);
	};
	
	return Util;
});
