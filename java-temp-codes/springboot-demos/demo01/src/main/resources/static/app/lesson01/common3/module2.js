'use strict';
(function(window, $){
	var M2 = {};
	M2.run = function() {
		$('#m2').text('Module 2 loaded successfully.');
	};
	window.M2 = M2;
})(window, jQuery);