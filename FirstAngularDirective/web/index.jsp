<%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 9/16/2014
  Time: 3:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
      <style>
          .tree {
              width: 200px;
              height: 200px;
              background-color: green;
          }
          .light {
              width: 180px;
              height: 20px;
              background-color: yellow;
              margin: 12px auto;
          }
          .red {
              background-color: red;
          }
          .orange {
              background-color: orange;
          }
      </style>
  </head>
  <body ng-app="myApp">

  <xmas-tree>
      <xmas-light bg="red"></xmas-light>
      <xmas-light bg="orange"></xmas-light>
      <xmas-light></xmas-light>
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
  </script>
  </body>
</html>
