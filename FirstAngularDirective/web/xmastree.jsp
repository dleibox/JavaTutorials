<%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 9/16/2014
  Time: 3:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <style>
        .tree {
            width: 100%;
            height: 100%;
            margin: auto;
        }
        .lvl-1 {
            border: 20px solid green;
        }
        .lvl-2 {
            border: 30px solid green;
        }
        .lvl-3 {
            border: 40px solid green;
        }
        .lvl-4 {
            border: 50px solid green;
        }
        .lvl-5 {
            border: 60px solid green;
        }
        .lvl {
            height: 0;
            width: 0;
            border-top: 0;
            border-left-color: transparent;
            border-right-color: transparent;
            /*border-bottom-width: 20px;*/
            margin: 0 auto;
        }
        .light {
            width: 60px;
            height: 8px;
            background-color: yellow;
            position: relative;
            left: -30px;
            top: 6px;
        }
    </style>
</head>
<body ng-app="myApp">

<xmas-tree>
    <xmas-level lvl="lvl-1"><xmas-light></xmas-light></xmas-level>
    <xmas-level lvl="lvl-2"><xmas-light></xmas-light></xmas-level>
    <xmas-level lvl="lvl-3"><xmas-light></xmas-light></xmas-level>
    <xmas-level lvl="lvl-4"><xmas-light></xmas-light></xmas-level>
    <xmas-level lvl="lvl-5"><xmas-light></xmas-light></xmas-level>
</xmas-tree>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.22/angular.min.js"></script>
<script>
    var app = angular.module('myApp', []);
    app.directive("xmasLight", function(){
        return {
            scope:{
                bg:"@"
            },
            replace:true,
            restrict:"E",
            template:"<div class='light'></div>",
            link: function (scope, element){
                element.addClass(scope.bg);
            }
        }
    });
    app.directive("xmasTree",function(){
        return {
            restrict: "E",
            replace:true,
            transclude:true,
            template:"<div class='tree' ng-transclude></div>"
        }
    })
    app.directive("xmasLevel",function(){
        return {
            scope:{
                lvl:"@"
            },
            restrict: "E",
            replace:true,
            transclude:true,
            template:"<div class='lvl' ng-transclude></div>",
            link: function (scope, element){
                element.addClass(scope.lvl);
            }
        }
    })
</script>
</body>
</html>
