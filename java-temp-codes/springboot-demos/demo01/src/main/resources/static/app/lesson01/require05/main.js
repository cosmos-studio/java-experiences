'use strict';
require.config({
	paths : {
		'm1' : 'module1',
		m2 : 'module2',
		// if the first one of the paths loaded failed, then the second one will be loaded.
		'jquery' : ['http://libs.baidu.com/jquery/2.0.3/jquery', '/boot2/lib/jquery']
	}
});
require(['m1', 'm2', 'jquery'], function(M1, M2, myJQ) {
	myJQ(function() {
		myJQ('#main').text('Module 1 & 2 loaded successfully.');
	})
});