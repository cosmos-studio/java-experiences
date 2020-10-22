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

require(['jquery', 'underscore', 'backbone'], function($, _, Backbone){
	$(function(){
		$("#api1_call").on("click", function(){
			//console.log("api1_call-click");
			$.ajax({
				type:"GET",
				url:"/webapi/res/hello",
				cache:false,
				success: function(msg){
					$("#api1_msg").text(msg.code + ":" + msg.msg);
					console.info(msg.code);
					console.info(msg.msg);
				}
			});
			
		});
		$("#api1_reset").on("click", function(){
			//console.log("api1_reset-click");
			$("#api1_msg").text("");
		});
		
	});
});
