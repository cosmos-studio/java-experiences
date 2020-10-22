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
	function demo1(){
		console.log("demo-1 --------------------");
		var model = new Backbone.Model();
		model.set("name", "backbone loaded.");
		console.log(model.get("name"));
	}
	
	function demo2() {
		console.log("demo-2 --------------------");
	    var  model_1  =  new  Backbone.Model({'boy':'Jacob.Zhao'}); //直接赋值进行数据初始化
	    var  model_2  =  new  Backbone.Model({'girl':'Chiling.Lin'});
	    //创建一个数据模型集合
	    var   models  =  new  Backbone.Collection();
	    //通过add方法将单个模型添加到模型集合中
	    models.add(model_1);
	    models.add(model_2);
	    console.log(JSON.stringify(models));//JSON解析，将数据集合打印出来
	}
	
	function demo3() {
		//模型的构造函数的扩展,相当于继承，则声称的实列可以使用其父类的方法
		var MyModel = Backbone.Model.extend({
			//第一个参数写实列方法,第二个参数写静态方法
			instanceDo : function(){//实列方法
				console.log('Jacob.Zhao');
			}
		}, {
			staticDo : function(){//静态方法
				console.log('Chiling.Lin');
			}
		});
		var  model =  new MyModel;
		model.instanceDo(); //实列方法，直接使用实列来进行调用
		MyModel.staticDo(); //静态方法是挂载在构造函数下面的，所以需要使用构造函数来直接调用
	}
	
	function demo4() {
		var MyModel = Backbone.Model.extend({
			defaults: {
				name: "Chiling.Lin",
			},
			mylove: function(){
				return "say: my love";
			},
			// new instance method to debug;
			sum: function(from, to) {
				var sum = 0;
				for(var i = from; i<=to; i++) {
					sum += i;
				}
				return sum;
			}
		});
		
		var model = new MyModel();
		console.log(model.get("name"));
		console.log(model.mylove());
		console.log(model.sum(1,20));
	}
	
	function demo5() {
		var MyModel = Backbone.Model.extend({
			defaults: {
				name: "Chiling.Lin",
			},
			initialize: function() {
				//change of anything
				this.on("change",function(model, argObj){
					console.log("all change event occured.");
					console.log(model);
					console.log(argObj);
				});
				//change of name
				this.on("change:name", function(model, target, argObj){
					console.log("name event occured.");
					console.log(model);
					console.log(target);
					console.log(argObj);
				})
			}
		});
		
		var model = new MyModel();
		model.set("name", "Yoonjoo.Son - 1");
		model.set("name", "Yoonjoo.Son - 2", {"xxx":"yyy"});
		model.set("name", "Yoonjoo.Son - 3", ["xxx","yyy"]);
		model.set("name", "Yoonjoo.Son - 4", new Date());
	}

	//demo6
	$(function(){
		var M = Backbone.Model.extend({
			defaults: {
				name: "Chiling.Lin",
			}
		});
		var V = Backbone.View.extend({
			initialize: function(){
				//console.warn("v.init");
				$("#mvc_show").text(this.model.get("name"));
				this.listenTo(this.model, "change", this.show);
			},
			show: function(model){
				//console.warn("v.show");
				$("#mvc_show").text(model.get("name"));
			}
		});
		var m = new M;
		var V = new V({model:m});
		$("#mvc_change").on("click", function(){
			m.set('name', "Yunjoo.Son");
		});
		$("#mvc_reset").on("click", function(){
			m.set('name', "Chiling.Lin");
		});
		
	});
	
	
});
