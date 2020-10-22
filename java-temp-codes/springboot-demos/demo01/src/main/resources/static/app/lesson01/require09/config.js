'use strict';
require.config({
	paths : {
		'jquery' : '../../../lib/jquery',// UMD supported AMD
		'util' : 'util',// AMD
		'm1' : 'module1',// AMD
		'm2' : 'module2',// UMD advanced supported AMD
		'm3' : 'module3'// UMD basic supported AMD
	}
})