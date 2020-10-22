'use strict';
require.config({
	// baseUrl : '',
	// waitSeconds : 10,
	paths : {
		'jquery' : '../../../lib/jquery',
		'util' : 'util',
		'm1' : 'module1',
		'm2' : 'module2'
	},
//	shim : {
		// this is not needed for UMD modules
//		'jquery' : {
//			exports : 'jQuery'
//		},
		// this is not needed for AMD modules
//		'util' : {
//			exports : 'util'
//		},
//		'm1' : {
//			deps : ['jquery', 'util'],
//		},
//		'm2' : {
//			deps : ['jquery', 'util'],
//		}
//	}
})