<%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 9/16/2014
  Time: 11:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
  <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.22/angular.min.js"></script>
  <script>
      $(document).ready(function(){
          $.getJSON( "json/hello", function( data ) {
              console.log(data);
              var items = [];
              $.each( data, function( key, val ) {
                  items.push( "<li id='" + key + "'>" + val + "</li>" );
              });

              $( "<ul/>", {
                  "class": "my-new-list",
                  html: items.join( "" )
              }).appendTo( "body" );
          });
      });
  </script>
  </body>
</html>
