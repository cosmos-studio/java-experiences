//alert("Loaded successfully.");

require.config({
	baseUrl:"/js/lib",
	paths: {
		"jquery":"jquery-3.3.1",
		"underscore":"underscore",
		"backbone":"backbone",
		"hundlebars":"handlebars.runtime-v4.0.11",
		"math":"test2_math",
		"image":"require.image"
	},
	waiteSecond:45,
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

//first
require(['math', 'jquery'], function(mymath,$){
	//alert(mymath.add(80,20));
	var result = "math.add(80,20) = "+mymath.add(80,20);
	console.log(result);
	$("#first").text(result);
});

//second
require(["jquery", "underscore", "Backbone"], function($, _, bone){
	$(document).ready(function(){
		//alert("modules loaded");
		var result = "modules loaded";
		console.log(result);
		$("#second").text(result);
	});
});

//require_plugin
require(['image!/imgs/sunyz.jpg', 'jquery'], function(img, $){
	var result = "image loaded successfully.";
	console.info(result);
	$("#require_plugin_str").text(result);
	//document.body.appendChild(img);
	$("#require_plugin").append(img)
	$("img:first").attr("width", 170);
	console.info(img);
});