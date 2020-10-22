"use strict";

require.config({
	urlArgs: "bust=" + (new Date()).getTime(),
	baseUrl:"/js/lib",
	paths: {
		"jquery":"jquery-3.3.1",
		"underscore":"underscore",
		"backbone":"backbone",
		"hundlebars":"handlebars.runtime-v4.0.11",
	},
	shim: {
		"underscore": {
			exports: "_"
		},
		
		"backbone": {
			deps: ["underscore", 'jquery'],
			exports: "Backbone"
		}
	}
});

require(['jquery', 'underscore'], function($, _){
	$("#countby_btn").on("click", function(event, fn) {
		$("#countby_r").text(_.map([1, 2, 3], (x) => x * x));
	});
	$("#countby_reset").on("click", function(e, f){
		$("#countby_r").text("");
	});
});
