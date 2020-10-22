'use strict';
(function(window, util){
	var M5 = {};
	M5.sendmsg = function() {
		util.msgTag('m5').text('Hello M5');
	};
	window.M5 = M5;
})(window, Util);