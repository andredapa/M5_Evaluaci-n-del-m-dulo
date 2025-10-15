<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registrar Estudiante</title>
</head>
<body>
    <h1>Registrar Nuevo Estudiante</h1>

    <form action="estudiantes" method="post">
        <p>
            <label for="nombre">Nombre Completo:</label><br>
            <input type="text" id="nombre" name="nombre" required>
        </p>

        <p>
            <label for="email">Correo Electrónico:</label><br>
            <input type="email" id="email" name="email" required>
        </p>

        <p>
            <label for="carrera">Carrera:</label><br>
            <input type="text" id="carrera" name="carrera" required>
        </p>

        <p>
            <button type="submit">Registrar</button>
            <a href="estudiantes?action=list">Cancelar</a>
        </p>
    </form>
</body>
</html>
