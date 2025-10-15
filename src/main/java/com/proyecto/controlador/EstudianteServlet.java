package com.proyecto.controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.proyecto.dao.EstudianteDAO;
import com.proyecto.modelo.Estudiante;

@WebServlet("/estudiantes")
public class EstudianteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private EstudianteDAO estudianteDAO;

    @Override
    public void init() throws ServletException {
        estudianteDAO = new EstudianteDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        if (action == null) {
            action = "list"; 
        }

        try {
            switch (action) {
                case "new":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteEstudiante(request, response);
                    break;
                default:
                    listEstudiantes(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException("Error de base de datos en doGet: " + ex.getMessage(), ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            String idStr = request.getParameter("id");
            action = (idStr == null || idStr.isEmpty()) ? "insert" : "update";
        }
        
        try {
            switch (action) {
                case "insert":
                    insertEstudiante(request, response);
                    break;
                case "update":
                    updateEstudiante(request, response);
                    break;
                default:
                    response.sendRedirect("estudiantes?action=list");
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException("Error de base de datos en doPost: " + ex.getMessage(), ex);
        }
    }

    // Listar estudiantes
    private void listEstudiantes(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        List<Estudiante> listaEstudiantes = estudianteDAO.readAll();
        request.setAttribute("listaEstudiantes", listaEstudiantes);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("vista/listadoEstudiantes.jsp");
        dispatcher.forward(request, response);
    }

    // Mostrar formulario para nuevo estudiante
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("vista/formularioEstudiantes.jsp");
        dispatcher.forward(request, response);
    }

    // Mostrar formulario para editar estudiante
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Estudiante estudianteExistente = estudianteDAO.readById(id);
            request.setAttribute("estudiante", estudianteExistente);

            RequestDispatcher dispatcher = request.getRequestDispatcher("vista/formularioEditar.jsp");
            dispatcher.forward(request, response);
        } catch (NumberFormatException e) {
            response.sendRedirect("estudiantes?action=list");
        }
    }

    private void insertEstudiante(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String carrera = request.getParameter("carrera");
        
        Estudiante nuevoEstudiante = new Estudiante();
        nuevoEstudiante.setNombreCompleto(nombre);
        nuevoEstudiante.setEmail(email);
        nuevoEstudiante.setCarrera(carrera);

        estudianteDAO.create(nuevoEstudiante);

        response.sendRedirect("estudiantes?action=list");
    }

    private void updateEstudiante(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String carrera = request.getParameter("carrera");

        Estudiante estudianteActualizado = new Estudiante(id, nombre, email, carrera);
        estudianteDAO.update(estudianteActualizado);

        response.sendRedirect("estudiantes?action=list");
    }

    private void deleteEstudiante(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            estudianteDAO.delete(id);
            response.sendRedirect("estudiantes?action=list");
        } catch (NumberFormatException e) {
            response.sendRedirect("estudiantes?action=list");
        }
    }
}
