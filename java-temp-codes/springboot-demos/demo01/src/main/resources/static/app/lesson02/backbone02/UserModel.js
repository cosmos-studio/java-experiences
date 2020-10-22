'use strict';
define(['jquery', 'underscore', 'backbone', 'handlebars'], function($, _,
		Backbone, Handlebars) {

	return Backbone.Model.extend({
		initialize : function() {
			console.log("User init...");
//			this.bind();
		},
//		constructor : function() {
//			console.log("constructor...");
////			Backbone.Model.apply(this, arguments);
////			UserModel.__super__.constructor.call(this);
//		},
		url : "../../../api/user/123",
		defaults : {
			name : 'A little rabit',
			age : 5,
			addr : 'China - XA'
		}
	});
})
