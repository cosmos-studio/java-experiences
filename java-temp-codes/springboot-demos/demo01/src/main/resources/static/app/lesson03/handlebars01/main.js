'use strict';
require([
	'jquery', 'underscore', 'backbone', 'handlebars',
	'text!template/Section01Template.html',
	'text!template/Section02Template.html',
	'text!template/Section03Template.html',
	'text!template/Section04Template.html'
], function(
	$, _, Backbone, Handlebars,
	Section01Template,
	Section02Template,
	Section03Template,
	Section04Template
) {
	$(function(){
		// section 01 : basic demo
		var content01 = {
			title: 'Section-01',
			word: 'Hello Web World'
		};
		var section01Template = Handlebars.compile(Section01Template);
		var section01Html = section01Template(content01);
		$('#section-1').html(section01Html);
		
		//section 02 : HTML-escape demo1
		var content02 = {
				title: 'Section-02',
				word: 'There are six charactors in each brackets [&nbsp;&nbsp;&nbsp;][   ][<&>]'
		};
		var section02Template = Handlebars.compile(Section02Template);
		var section02Html = section02Template(content02);
		$('#section-2').html(section02Html);
		
		//section 03 : HTML-escape demo2
		var content03 = {
			title: 'Section-03',
			word: 'There are six charactors in each brackets [&nbsp;&nbsp;&nbsp;][   ][<&>]'
		};
		var section03Template = Handlebars.compile(Section03Template);
		var section03Html = section03Template(content03);
		$('#section-3').html(section03Html);
		
		//section 04 : HTML-escape demo3
		var content04 = {
				title: 'Section-04',
				word: 'There are six charactors in each brackets [&nbsp;&nbsp;&nbsp;][   ][<&>]'
		};
		var section04Template = Handlebars.compile(Section04Template);
		content04.word = new Handlebars.SafeString(content04.word);
		var section04Html = section04Template(content04);
		$('#section-4').html(section04Html);
	});
})
