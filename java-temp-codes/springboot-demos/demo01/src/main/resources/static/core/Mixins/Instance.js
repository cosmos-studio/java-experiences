"use strict";
/**
 * @exports Mixins/Instance
 */
define([], {
    instance: function (config) {
        var Constructor = this;
        if(!this._instance) {
            this._instance = new Constructor(config);
        }
        return this._instance;
    }
});