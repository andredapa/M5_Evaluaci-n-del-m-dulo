<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Estudiante</title>
</head>
<body>
    <h1>Editar Estudiante</h1>

    <form action="estudiantes" method="post">
        <!-- ID oculto para edición -->
        <input type="hidden" name="id" value="${estudiante.id}">

        <p>
            <label for="nombre">Nombre Completo:</label><br>
            <input type="text" id="nombre" name="nombre" value="${estudiante.nombreCompleto}" required>
        </p>

        <p>
            <label for="email">Correo Electrónico:</label><br>
            <input type="email" id="email" name="email" value="${estudiante.email}" required>
        </p>

        <p>
            <label for="carrera">Carrera:</label><br>
            <input type="text" id="carrera" name="carrera" value="${estudiante.carrera}" required>
        </p>

        <p>
            <button type="submit">Actualizar</button>
            <a href="estudiantes?action=list">Cancelar</a>
        </p>
    </form>
</body>
</html>
