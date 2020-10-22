'use strict';
require([
	'jquery',
	'underscore',
	'backbone'
], function(
	$,
	_,
	Backbone
) {
	$(function() {

		// /////////////////////////////////
		// demo1 Model + Collection + View
		// 新建Model构造函数
		var People = Backbone.Model.extend({
			ctime : null,// 打卡时间
		});

		// 新建Collection构造函数
		var Peoples = Backbone.Collection.extend({
			initialize : function(models, options) {
				// add将Model添加进Collection，在这里调用View中定义的addOnePersonOnView函数
				this.bind("add", options.view.addOnePersonOnView);
			}
		});

		// 新建View构造函数
		var AppView = Backbone.View.extend({
			el : $("body"),
			initialize : function() {
				this.peoples = new Peoples(null, {
					view : this
				})// 实例化一个Collection
			},
			events : {
				"click #checkIn" : "checkIn",// 绑定#check的click事件，并执行checkIn函数
			},
			checkIn : function() {
				var now = new Date();
				var curr_time = now.getHours() + ":" + now.getMinutes() + ":" + now.getSeconds() + "." + now.getMilliseconds();
				var person = new People({ ctime : curr_time });
				if(this.peoples.length >= 10) {
					return;
				}
				this.peoples.add(person);
			},
			addOnePersonOnView : function(model) {
				$("#person-list").append("<li>" + "  打卡时间为：" + model.get('ctime') + "</li>");
			}
		});

		// 实例化一个View，自动执行initialize中的函数
		var appview = new AppView();

		// /////////////////////////////////
		// demo2 : Model
		var Man = Backbone.Model.extend({
			defaults : {
				name : "张三丰",
				age : "123"
			},
			initialize : function() {
				// 初始化时绑定监听，change事件会先于validate发生
				this.bind("change:name", function() {
					var name = this.get("name");
					$('#msg-list').append("<li>你改变了name的属性为：[" + name + "]</li>");
				});
				this.bind("invalid", function(model, error) {
					$('#msg-list').append("<li>" + "<span style='background-color:yellow'>"+error+"</span>" + "</li>");
				});
			},
			validate : function(attributes) {
				if (attributes.name === '') {
					return "name不能为空！";
				}
			},
			aboutMe : function() {
				return "我叫" + this.get("name") + ",今年" + this.get("age") + "岁";
			}
		});
		var man = new Man();
		//message-1 : aboutMe
		$('#msg-list').append("<li>" + man.aboutMe() + "</li>");
		//message-2 : change name message
		man.set({ name : '张无忌' });
		//message-3 : change name to empty
		man.set({ name : '' });
		//message-4 : will invoke invalid function
		man.save();

		// /////////////////////////////////
		// demo3 : Model + View
		var Man3 = Backbone.Model.extend({
			defaults : {
				name : "张三丰",
				age : "123"
			},
			initialize : function() {
				// 初始化时绑定监听，change事件会先于validate发生
				this.bind("change:name", function() {
					var name = this.get("name");
					$('#msg-list-3').append("<li>你改变了name的属性为：[" + name + "]</li>");
				});
				this.bind("invalid", function(model, error) {
					$('#msg-list-3').append("<li>" + "<span style='background-color:yellow'>"+error+"</span>" + "</li>");
				});
			},
			validate : function(attributes) {
				if (attributes.name === '') {
					return "name不能为空！";
				}
			},
			aboutMe : function() {
				return "我叫" + this.get("name") + ",今年" + this.get("age") + "岁";
			}
		});
		
		var ManView = Backbone.View.extend({
			el: $('#msg-list-3'),
			initialize: function() {
				this.man = new Man3();
			},
			addItem: function() {
				$('li').
				$el.append()
			}
		});
		var man = new Man3();
		//message-1 : aboutMe
		$('#msg-list-3').append("<li>" + man.aboutMe() + "</li>");
		//message-2 : change name message
		man.set({ name : '张无忌' });
		//message-3 : change name to empty
		man.set({ name : '' });
		//message-4 : will invoke invalid function
		man.save();

	})
})
