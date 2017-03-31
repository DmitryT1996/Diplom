<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="reset.css">
    <link rel="stylesheet" type="text/css" href="blog.css">
    <title>Blog</title>
    <script src="jquery-3.1.1.min.js"></script>
</head>
<body>
<div id="container">
    <span id="logo">
        <a href="/home/max/projectM/new/welcome.html"><img src="/home/max/projectM/newIcon/logo_invert.png"></a>
    </span>

    <span id="enter">Войти</span>

    <form id="form" method="post" action="blog">
        <span class="closeForm">&times</span>
        <h1>Заголовок</h1>
        <input id="header" type="text" name="header"/>
        <h2>Что нового?</h2>
        <textarea id="post" rows="6" cols="45"></textarea>
        <input type="submit" name="submit" value="Отправить"/>
    </form>
</div>
</body>
</html>
