<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Libros</title>
</head>
<body>
    <h1>Libros</h1>
    <ul>
        <c:forEach var="libro" items="${libros}">   <!-- no sabia si mostrar el autor asi que lo comente -->
            <li><b>Titulo:</b> <a href="/libros/${libro.getKey()}">${libro.getKey()}</a><br> <!--<b>Autor:</b> ${libro.getValue()} --></li>
            <hr>
        </c:forEach>
    </ul>
    <br>
    <a href="/libros/formulario">
        <button>
            Añade un libro
        </button>
    </a>
</body>
</html>