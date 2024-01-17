<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Login</title>
    <style><%@include file="/styles/login.css"%></style>
    <style><%@include file="/styles/navbar.css"%></style>
</head>
<body>
<nav>
    <table>
        <th>
        <td><%@include file="/assets/logo.svg"%></td>
        <td><p style="color: #21110E">Главная</p></td>
        <td><p style="color: #21110E">Афиша</p></td>
        <td><p style="color: #21110E">О кинотеатре</p></td>
        </th>
    </table>
</nav>
<header>
    ДОБРО ПОЖАЛОВАТЬ В "CINEMA"
</header>
    <form action="" method="post">
        <div id="content">
            <span>Логин</span>
            <input name = "login" id = "login" type="text"/>
            <br>
            <span>Пароль</span>
            <input name = "password" id = "password" type="text"/>
            <br>
            <span style="text-align: center">${requestScope.errorText}</span>
            <br>
            <input type="submit" name="enter" class="button" value="Войти">
        </div>
    </form>
</div>
</body>
</html>