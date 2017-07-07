<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Стартовая страница</title>
    <style type="text/css">
        ul {
            display: block;
            list-style-type: circle;
            margin-top: 1em;
            margin-bottom: 1 em;
            margin-left: 0;
            margin-right: 0;
            padding-left: 40px;
        }
    </style>
</head>
<body>
    <h1 align="center" style="color: darkgreen">Начальная страница</h1>
    <hr>
    <form action="servletstart" method="post">
        Введите имя<br>
    <input type="text" name="name" value="Terminator">
        <br>
        Введите пароль<br>
    <input type="password" style="" name="password" value="password">
    <br>
    <input type="submit" value="Отправить">

    </form>
    <ul>
        <li>First element</li>
        <li>Second element</li>
        <li>Third element</li>
    </ul>
<img src="res/icon1.png" alt="html powered" height="70" width="60">
</body>
</html>
