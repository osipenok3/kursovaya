<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
    <style><%@include file="/styles/main.css"%></style>
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
<header>
    МОИ ПОКУПКИ
</header>
<p style="font-size: 20px; text-align: center">Здесь вы можете увидеть список своих покупок</p>
<div style="text-align: center">
    <table style="margin: auto">
        <tr>
            <th>Номер билета</th>
            <th>Фильм</th>
            <th>Дата</th>
            <th>Время сеанса</th>
            <th>Зал</th>
            <th>Место</th>
            <th>Цена</th>
        </tr>
        <c:forEach items="${tickets}" var="ticket">
            <tr>
                <td>${ticket.id}</td>
                <td>${ticket.film}</td>
                <td><fmt:formatDate value="${ticket.date}" pattern="dd MMM yyyy"/></td>
                <td><fmt:formatDate value="${ticket.date}" pattern="HH:mm"/></td>
                <td>${ticket.hall}</td>
                <td>Ряд - ${ticket.row} Место - ${ticket.place}</td>
                <td>${ticket.cost} руб.</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
