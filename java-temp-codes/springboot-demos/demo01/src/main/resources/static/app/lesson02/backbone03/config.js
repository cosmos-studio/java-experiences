'use strict';
// 配置baseUrl
var baseUrl = document.getElementById('main').getAttribute('data-baseurl');


var config = {
	baseUrl : baseUrl, 
	paths : { 
		zepto : 'libs/zepto.min',
		jquery : 'libs/zepto.min',
		underscore : 'libs/underscore',
		backbone : 'libs/backbone',
		text : 'libs/text' // 用于requirejs导入html类型的依赖
	}
};

require.config(config);
require.config({
	baseUrl: baseUrl,// 依赖相对路径
	paths : {// 如果某个前缀的依赖不是按照baseUrl拼接这么简单，就需要在这里指出
		'jquery' : '../../../lib/jquery',// UMD module supported AMD
		'underscore' : '../../../lib/underscore',// Closure module
		'backbone' : '../../../lib/backbone'// UMD advanced module supported AMD
	},
	shim : { // 引入没有使用requirejs模块写法的类库。backbone依赖underscore
		'jquery' : {
			exports : '$'
		},
		'underscore' : {
			exports : '_'
		},
		'backbone' : {
			deps : ['underscore', 'jquery'],
			exports : 'Backbone'
		}
	}
})
