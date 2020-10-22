require.config({
    baseUrl: '../boot',
    paths:{
        'jquery': 'js/lib/jquery/jquery',
        'backbone': '../lib/backbone/backbone',
        'underscore': '../lib/underscore/underscore',
        'handelbars': '../lib/handlebars/handlebars'
    },
    shim:{
        'backbone': {
            deps: ['underscore', 'jquery'],
            exports: 'Backbone'
        },
        'underscore': {
            deps: ['jquery'],
            exports: '_'
        },
        'lib/handlebars': {
            deps: ['jquery'],
            exports: 'Handlebars'
        }
    }
})