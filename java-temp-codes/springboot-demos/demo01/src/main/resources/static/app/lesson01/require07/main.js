'use strict';
require(['jquery', 'underscore', 'm1', 'm2'], function($, _, M1, M2) {
	$(function() {
		M1.fun1();
		M2.fun1();
		var list = [1, 2, 3, 4, 5, 6];
		var listStr = _.reduce(list, function(memo, num) {
			return memo + " / " + num;
		}, 0);
		$('#main').text("[ " + listStr + " ]").css('color', 'blue');
	})
})
// M1, M2: my own AMD models.
// Jq, Us: my own module variables
// $, _: original module variables
