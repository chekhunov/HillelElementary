<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="resources" />
<!DOCTYPE html>
<html lang="${language}">
    <head>
        <title>JSP/JSTL i18n demo</title>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
                <title>Login</title>
    </head>
    <body>
        <form>
            <select id="language" name="language" onchange="submit()">
                <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
                <option value="nl" ${language == 'nl' ? 'selected' : ''}>Nederlands</option>
                <option value="es" ${language == 'es' ? 'selected' : ''}>Español</option>
                <option value="ru" ${language == 'ru' ? 'selected' : ''}>Русский</option>
            </select>
        </form>
        <form method="post">
            <label for="username"><fmt:message key="user.username" />:</label>
            <input type="text" id="username" name="username">
            <br>
            <label for="password"><fmt:message key="user.password" />:</label>
            <input type="password" id="password" name="password">
            <br>
            <fmt:message key="user.submit" var="buttonValue" />
            <input type="submit" name="submit" value="${buttonValue}">
        </form>
        ${loginError}

    </body>
</html>