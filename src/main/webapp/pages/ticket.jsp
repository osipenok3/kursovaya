<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ticket</title>
    <style><%@include file="/styles/order.css"%></style>
    <style><%@include file="/styles/navbar.css"%></style>
</head>
<body>
<nav>
    <table>
        <th>
        <td><%@include file="/assets/logo.svg"%></td>
        <td><a href="/main" class="sign_word">Главная</a></td>
        <td><a href="/poster" class="sign_word">Афиша</a></td>
        <td><a href="/about" class="sign_word">О кинотеатре</a></td>
        </th>
    </table>
</nav>
<div class="box">
    <p>Название фильма: ${ticket.film}</p>
    <p>Дата сеанса: <fmt:formatDate value="${ticket.date}" pattern="dd MMM yyyy"/></p>
    <p>Время начала: <fmt:formatDate value="${ticket.date}" pattern="HH:mm"/></p>
    <p>Зал: ${ticket.hall}</p>
    <p>Выбранное место: Ряд - ${ticket.row} Место - ${ticket.place}</p>
    <p>Стоимость: ${ticket.cost} руб.</p>
    <form action="#openModal" method="post" style="text-align: center">
        <span>Введите код оплаты</span>
        <input type="text" name="code">
        <br>
        <span>${requestScope.errorText}</span>
        <br>
        <input type="submit" class="button" value="Оплатить">
    </form>
</div>
</body>
</html>
