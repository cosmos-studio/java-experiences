'use strict';
// AMD
// will error when related modules are not AMD modules.
//define('util', [ 'jquery'], function($) {
define( [ 'jquery'], function($) {
	function msgTag(flag) {
		var idName = flag;
		var msgKey = '#'+idName;
		if($('body').find(msgKey).length > 0) {
			$('body').find(msgKey).remove();
		}
		$('body').children().last().after('<br/><span id="' + idName + '"></span>');
		return $(msgKey);
	};
	return {
		'msgTag' : msgTag
	}
})

