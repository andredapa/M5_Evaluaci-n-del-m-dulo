<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String mensaje = (String) request.getAttribute("mensaje");
    if (mensaje == null) mensaje = "";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mensaje</title>
</head>
<body>
    <h2><%= mensaje %></h2>
    <p><a href="estudiantes?accion=listar">Volver a la lista</a></p>
</body>
</html>
