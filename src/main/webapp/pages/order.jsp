<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order</title>
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
<div id="content">
    <table>
        <td><img src="<%=request.getContextPath()%>/assets/hall.png"/></td>
        <td class="description">
            <p>Название фильма: ${film.name}</p>
            <p>Дата сеанса: <fmt:formatDate value="${session.date}" pattern="dd MMM yyyy"/></p>
            <p>Время начала: <fmt:formatDate value="${session.date}" pattern="HH:mm"/></p>
            <p>Зал: ${session.hall}</p>
            <form action="" method="post">
                <span>Выберите место:</span>
                <select name="choice">
                    <c:forEach items="${places}" var="place">
                        <option value="${place.id}">Ряд: ${place.row}, Место: ${place.place}</option>
                    </c:forEach>
                </select>
                <br>
                <br>
                <input type="submit" class="button" value="Сделать заказ">
            </form>
        </td>
    </table>
</div>
</body>
</html>
