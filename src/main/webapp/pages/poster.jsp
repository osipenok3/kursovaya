<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Poster</title>
    <style><%@include file="/styles/poster.css"%></style>
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
    КИНОПРЕМЬЕРЫ
</header>
<div>
    <ul>
        <c:forEach items="${films}" var="film">
        <li>
            <div id="poster" onclick="window.location.href='/poster/${film.id}'" style="cursor: pointer;">
                <header class="names">С <c:out value="${film.date_from.toString()}" /></header>
                <img src="<%=request.getContextPath()%>/assets/<c:out value="${film.name_file}" />"/>
                <header class="names"><c:out value="${film.name}" /></header>
            </div>
        </li>
        </c:forEach>
    </ul>
</div>
</body>
</html>