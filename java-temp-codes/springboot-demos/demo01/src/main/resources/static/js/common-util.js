'use strict';
(function(window) {
	var CommonUtil = {};

	CommonUtil.getInnerText = function(element) {
		if (element.innerText) {
			return element.innerText;
		} else {
			return element.textContent;
		}
	};

	CommonUtil.setInnerText = function(element, text) {
		if (element.innerText) {
			element.innerText = text;
		} else {
			element.textContent = text;
		}
	}
	window.CommonUtil = CommonUtil;
})(window || {});