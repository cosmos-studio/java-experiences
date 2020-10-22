'use strict';
require.config({
	// baseUrl : '',
	// waitSeconds : 10,
	paths : {
		'm1' : 'module1',
		'm2' : 'module2',
		'jquery' : '../../../lib/jquery',
		'underscore' : '../../../lib/underscore'
	}
// shim : {
// jQuery is an UMD module, so this block is not needed
// 'jquery' : {
// exports : 'jQuery'
// },
// Underscore is a variant UMD module, so this block is not needed
// 'underscore' : {
// deps : [ 'jquery' ],
// exports : '_'
// }
// }
})