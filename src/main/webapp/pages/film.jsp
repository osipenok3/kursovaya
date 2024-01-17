<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Film</title>
    <style><%@include file="/styles/film.css"%></style>
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
    О ФИЛЬМЕ
</header>
<div id="content">
    <table>
        <td><img src="<%=request.getContextPath()%>/assets/${film.name_file}"/></td>
        <td class="description"> Премьера: ${film.date_from} <br> Страна: ${film.country}
            <br> Жанр: ${film.genre} <br> Длительность: ${film.duration}</td>
    </table>
    <div id="timetable">
        <form action="" method="post">
            <table>
                <tr>
                    <th><h5>Дата</h5></th>
                    <th><h5>Время начала</h5></th>
                </tr>
                <c:forEach items="${sessions}" var="session">
                    <tr>
                        <td><h5><fmt:formatDate value="${session.date}" pattern="dd MMM yyyy"/></h5></td>
                        <td><h5><fmt:formatDate value="${session.date}" pattern="HH:mm"/></h5></td>
                        <td><button type="submit" name="id" value="${session.id}" class="button">Купить билеты</button></td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </div>
</div>
</body>
</html>
