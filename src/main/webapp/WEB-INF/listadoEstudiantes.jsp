<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestión de Estudiantes - Listado</title>
</head>
<body>
    <h1>Lista de Estudiantes</h1>
    
    <p><a href="estudiantes?action=new">Registrar Nuevo Estudiante</a></p>

    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombre Completo</th>
                <th>Correo Electrónico</th>
                <th>Carrera</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="estudiante" items="${listaEstudiantes}">
                <tr>
                    <td>${estudiante.id}</td>
                    <td>${estudiante.nombreCompleto}</td>
                    <td>${estudiante.email}</td>
                    <td>${estudiante.carrera}</td>
                    <td>
                        <a href="estudiantes?action=edit&id=${estudiante.id}">Editar</a>
                        &nbsp;
                        <a href="estudiantes?action=delete&id=${estudiante.id}" 
                           onclick="return confirm('¿Seguro que quieres eliminar a ${estudiante.nombreCompleto}?');">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
