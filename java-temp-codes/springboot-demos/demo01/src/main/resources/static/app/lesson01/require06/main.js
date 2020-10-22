'use strict';
require([ 'm1', 'm2', 'jquery' ], function(M1, M2, myJQ) {
	myJQ(function() {
		$('#main').text('Modules 1 & 2 loaded successfully...');
	})
})