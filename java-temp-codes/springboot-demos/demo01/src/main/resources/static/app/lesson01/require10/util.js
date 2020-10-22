'use strict';
// UMD basic supported AMD
// will error when related modules are not AMD/UMD(support UMD) modules.
(function(root, factory) {
	if (typeof define === 'function' && define.amd) {
		// AMD
		define(['jquery'], factory);
	} else if (typeof exports === 'object') {
		// Node, CommonJS之类的
		module.exports = factory(require('jquery'));
	} else {
		// 浏览器全局变量(root 即 window)
		root.M3 = factory((root.jQuery || root.$));
	}
}(this, function(jQuery) {
	function msgTag(flag) {
		var idName = flag;
		var msgKey = '#' + idName;
		if(jQuery('body').find(msgKey).length > 0) {
			jQuery('body').find(msgKey).remove();
		}
		$('body').children().last().after('<br/><span id="' + idName + '"></span>');
		return $(msgKey);
	};
	return {
		'msgTag' : msgTag
	}
}));