<%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 9/16/2014
  Time: 4:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" />
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css" />
    <style>
        .form-group .alert {
            padding: 0px;
            margin-bottom: 0px;
        }

        .extra-info {
            margin-top: 2em;
            font-size: smaller;
        }
    </style>
</head>
<body>
<div ng-app="app" ng-controller="MainCtrl">
    <div class="panel-group">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">Login form</h4>
            </div>
            <div class="panel-body">
                <ng-include src="'form.html'"></ng-include>
            </div>
        </div>
    </div>

    <!-- kept seperate from the bootstrap markup to keep this example clean -->
    <script type="text/ng-template" id="form.html">
        <form name="form" valid-submit="sendForm()" novalidate>
            <!-- call name-->
            <div class="form-group clearfix" ng-class="{
                    'has-error': form.$submitted && form.callName.$invalid,
                    'has-success': form.$submitted && form.callName.$valid}">
                <label class="col-sm-2 control-label" for="callName">Call Name</label>
                <div class="col-sm-5">
                    <input id="callName" name="callName" class="form-control" type="text" ng-model="person.callName" required autofocus></input>
                    <div class="alert alert-danger" ng-show="form.$submitted && form.callName.$error.required">Call name is required</div>
                    <p class="help-block">What do your parents and friends call you?</p>
                </div>
            </div>
            <!-- last name-->
            <div class="form-group clearfix" ng-class="{
                    'has-error': form.$submitted && form.lastName.$invalid,
                    'has-success': form.$submitted && form.lastName.$valid}">
                <label class="col-sm-2 control-label" for="lastName">Last Name</label>
                <div class="col-sm-5">
                    <input id="lastName" name="lastName" class="form-control" type="text" ng-model="person.lastName" required></input>
                    <div class="alert alert-danger" ng-show="form.$submitted && form.lastName.$error.required">required</div>
                    <p class="help-block">Last name as it is written on your passport</p>
                </div>
            </div>
            <!-- form controls-->
            <div class="form-group">
                <button type="submit" class="btn btn-primary" ng-disabled="(form.$submitted && form.$invalid)">Submit!</button>
            </div>
        </form>
    </script>
</div>

<div class="extra-info">
    <h4>This form has the following features:</h4>
    <a href="http://blog.projectnibble.org/2014/01/10/advanced-form-control-with-angularjs-and-bootstrap3/">source</a>
    <ul>
        <li>bootstrap 3: includes focus, error, helptext, alignment, typography</li>
        <li>autofocus: as soon as the page loads, the first input gets focus</li>
        <li>submission interceptor: validation errors are visible only once the form was submitted</li>
        <li>continuous feedback: after initial submission, the form keeps the user updated on validity</li>
        <li>unable to resubmit invalid form: the submit button is disabled until everything is correct</li>
    </ul>
</div>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.22/angular.min.js"></script>
<script>
    var app = angular.module('app', []);

    // directive that prevents submit if there are still form errors
    app.directive('validSubmit', [ '$parse', function($parse) {
        return {
            // we need a form controller to be on the same element as this directive
            // in other words: this directive can only be used on a &lt;form&gt;
            require: 'form',
            // one time action per form
            link: function(scope, element, iAttrs, form) {
                form.$submitted = false;
                // get a hold of the function that handles submission when form is valid
                var fn = $parse(iAttrs.validSubmit);

                // register DOM event handler and wire into Angular's lifecycle with scope.$apply
                element.on('submit', function(event) {
                    scope.$apply(function() {
                        // on submit event, set submitted to true (like the previous trick)
                        form.$submitted = true;
                        // if form is valid, execute the submission handler function and reset form submission state
                        if (form.$valid) {
                            fn(scope, { $event : event });
                            form.$submitted = false;
                        }
                    });
                });
            }
        };
    }
    ]);

    // handle form submission when the form is completely valid
    app.controller('MainCtrl', function($scope) {
        $scope.sendForm = function() {
            alert('form valid, sending request...');
        };
    });

    // focus on the first input when the page loads
    window.focus = function(selector) {
        // timeout is needed for Chrome (is a bug in Chrome)
        setTimeout(function(){
            $(!!selector ? selector : '[autofocus]:not(:focus)').first().focus();
        }, 1);
    };
</script>
</body>
</html>
