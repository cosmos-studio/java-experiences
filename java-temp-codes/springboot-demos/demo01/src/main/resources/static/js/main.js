'use strict';
require([
	'jquery',
	'underscore',
	'backbone',
	'handlebars'
], function(
	$,
	_,
	Backbone,
	Handlebars
) {
	$(function() {
		// section
		$('h2+ol').each(function(i, e) {
			$(e).prev().on('click', function(evt) {
				if ($(evt.target).next().is(':hidden')) {
					$(evt.target).next().show();
				} else {
					$(evt.target).next().hide();
				}
			});
			if (i > 0) {
				$(e).hide();
			}
		});
	});
})
