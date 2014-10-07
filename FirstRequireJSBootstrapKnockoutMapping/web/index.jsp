<%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 10/6/2014
  Time: 10:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>FirstStep Application</title>
    <style></style>

    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/main.css" />
    <script data-main="js/main" src="//cdnjs.cloudflare.com/ajax/libs/require.js/2.1.14/require.min.js"></script>
</head>
<body>
    <pre></pre>

    <h1>Click me to see !</h1>
    <p>http://codepen.io/aurer/pen/jEGbA</p>
    <p>https://ihatetomatoes.net/create-css3-spinning-preloader/</p>

    <div class="waiting">
        <svg version="1.1" id="loader-1" xmlns="http://www.w3.org/2000/svg" x="0px" y="0px" width="40px" height="40px" viewBox="0 0 50 50"
            style="border: 2px solid #7E3F98; border-radius: 40px;position: relative;top: 40%" xml:space="preserve">
            <path fill="#7E3F98" d="M43.935,25.145c0-10.318-8.364-18.683-18.683-18.683c-10.318,0-18.683,8.365-18.683,18.683h4.068c0-8.071,6.543-14.615,14.615-14.615c8.072,0,14.615,6.543,14.615,14.615H43.935z">
                <animateTransform attributeType="xml"
                                  attributeName="transform"
                                  type="rotate"
                                  from="0 25 25"
                                  to="360 25 25"
                                  dur="0.6s"
                                  repeatCount="indefinite"/>
            </path>
        </svg>
    </div>
</body>
</html>
