/**
 * Created by daniel on 10/6/2014.
 */
requirejs.config({
    //baseUrl: '/resources',
    //enforceDefine: true,
    paths: {
        jquery: [
            '//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min', // no .js
            'js/lib/jquery.min' // fallback
        ],
        bootstrap: [
            '//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min',
            'js/lib/bootstrap.min'
        ],
        "knockout": [//if use "knockout-3.2.0" as name, komapping throws exception???
            '//cdnjs.cloudflare.com/ajax/libs/knockout/3.2.0/knockout-min',
            'js/lib/knockout-min'
        ],
        "komapping": [
            '//cdnjs.cloudflare.com/ajax/libs/knockout.mapping/2.4.1/knockout.mapping',
            'js/lib/knockout.mapping'
        ]
    },
    shim: {
        bootstrap: ['jquery']
    },
    deps: ["knockout", 'komapping'],
    callback: function (ko, komapping) {
        ko.mapping = komapping;
    }
});

// Bootstrap is not an AMD module, set enforceDefine false
// Have to define if enforceDefine is true. otherwise, Uncaught Error: No define call for main
// main is the name of this js file
//define(function() {
define(["jquery", "knockout", "bootstrap"], function($, ko) {
    $("pre").text($("head").html().replace(/script><script/g, "script>\r\n\r\n<script"));
    //ko.mapping
    //return {};
});
// add code to execute right awary.
//require(["jquery", "bootstrap"]);

// It's okay to define a module here with name
//define("json", ["jquery"], function($){
