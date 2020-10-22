(function(win) {
	'use strict';

	/*
	 * 文件依赖
	 */

	// Backbone会把自己加到全局变量中
	require(['backbone', 'underscore', 'router'], function() {
		Backbone.history.start(); // 开始监控url变化
	});

})(window);