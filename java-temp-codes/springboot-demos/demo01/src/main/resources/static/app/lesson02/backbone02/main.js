'use strict';
require(['jquery', 'usermodel'], function($, UserModel) {
	var user = new UserModel();
	user.on('change', function(model){console.log('  => module [' + JSON.stringify(model.attributes) + '] changed.');});
	user.on('change:name', function(model, value){console.log('  => name   [' + JSON.stringify(model.attributes) + '] ' + value)});
	console.log(user);
	console.log(user.attributes);
	console.log(user.toJSON());
	console.log(user.get('name'));
	user.set('name', 'One Little Rabit');
	console.log(user.attributes);
	user.set({
		name: 'A little Rabit Doola',
		age: 7
	});
	console.log(user.attributes);
	console.log(user.escape('name'));
})
