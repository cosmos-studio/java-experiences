
function mytest1() {
	alert("test 1");
}

var mytest2 = function() {
	alert("test 2");
}

var mytest3= new Object({
	_count: 0,
	method: function() {
		alert("mytest3.method() result");
	}
});

var mytest4 = (function(){
	var count = 0;
	var method = function() {
		alert("mytest4.method() result");
	};
	var method2 = function() {
		alert("mytest4.method2() result");
	};
	
	return {
		m1:method,
		m2:method2
	};
})();

var mytest5 = (function(mod) {
	mod.nmx = function() {
		alert("mew method - enlarge type");
	};
	return mod;
})(mytest4);


var mytest6 = (function(mod){
	mod.test = function(){
		alert("new method - widely type");
	};
	return mod;
})(mytest4||{});
