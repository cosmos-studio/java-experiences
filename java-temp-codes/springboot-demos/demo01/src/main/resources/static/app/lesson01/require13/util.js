'use strict';
// global variable module
(function(window, $){
	var Util = {};
	Util.msgTag = function(flag) {
		var idName = flag;
		var msgKey = '#'+idName;
		if($('body').find(msgKey).length > 0) {
			$('body').find(msgKey).remove();
		}
		$('body').children().last().after('<br/><span id="' + idName + '"></span>');
		return $(msgKey);
	};
	window.Util = Util;
})(window, $);