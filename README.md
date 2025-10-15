# M5_Evaluaci-n-del-m-dulo
# MiApp - Gestión de Estudiantes (Java EE)

## Descripción
Aplicación web para CRUD de estudiantes usando Java EE (Servlets, JSP, patrón DAO y MVC). Permite registrar, visualizar, editar y eliminar estudiantes.

## Requisitos
- JDK 11+ (o la versión que uses)
- Apache Tomcat 9/10 (según versión de Jakarta/Servlet)
- MySQL (o PostgreSQL) — ajustar `ConexionBD.java`
- IDE: IntelliJ / Eclipse / Spring Tool Suite (opcional)

## Instalación y despliegue
1. Crear la base de datos:
   - Ejecutar `sql/crear_bd_estudiantes.sql` en tu servidor MySQL.
2. Configurar credenciales:
   - Editar `src/main/java/com/ejemplo/dao/ConexionBD.java` con tu usuario/contraseña.
3. Compilar y empaquetar:
   - Con Maven: `mvn clean package` → genera `target/miapp-estudiantes.war`
4. Despliegue:
   - Copiar `.war` al directorio `webapps` de Tomcat o usar la consola de Tomcat.
5. Entrar en el navegador:
   - `http://localhost:8080/miapp-estudiantes/estudiantes?accion=listar`

## Estructura
- `modelo` — clase `Estudiante`
- `dao` — `ConexionBD`, `EstudianteDAO`
- `controlador` — `EstudianteServlet`
- `vista` — JSPs: `lista.jsp`, `form.jsp`, `mensaje.jsp`

## Notas sobre seguridad y mejoras
- Validar y sanitizar entradas del usuario en servidor.
- Manejar excepciones y logging (SLF4J / Logback).
- Usar connection pooling (DataSource) para producción.
- Añadir JSTL y sacar lógica de presentación de los JSPs.
- Implementar paginación y búsqueda.

