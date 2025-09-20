<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulario</title>
</head>
<body>
    <h1>Añade un libro</h1>
    <form action="/procesa/libro" method="POST">
        <div>
            <label for="">Titulo: </label>
            <input type="text" name="titulo">
        </div>
        <br>
        <div>
            <label for="">Autor: </label>
            <input type="text" name="autor">
        </div>
        <br>
        <button type="submit">Agregar Libro</button>
    </form>
    <br>
    <a href="/libros">
        <button>regresa a libros</button>
    </a>
</body>
</html>