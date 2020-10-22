'use strict';
require.config({
	paths : {
		'jquery' : '../../../lib/jquery',// UMD supported AMD
		'util' : 'util',// closure module
		'm1' : 'module1',// AMD
		'm2' : 'module2',// UMD advanced supported AMD
		'm3' : 'module3',// UMD basic supported AMD
		'm4' : 'module4',// global variable module
		'm5' : 'module5'// closure module
	},
	shim : {
		'util' : {
			deps : ['jquery'],
			exports : 'Util'
		},
		'm4' : {
//			 deps:['util'], // this line is not needed for global variable module if it depends on a closure module
			exports : 'M4'
		},
		'm5' : {
			deps : ['util'],// this line is needed for closure module if it depends on a closure module.
			exports : 'M5'
		}
	}
})
