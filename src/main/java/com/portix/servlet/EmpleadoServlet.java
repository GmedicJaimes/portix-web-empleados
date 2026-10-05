package com.portix.servlet;

import com.portix.dao.EmpleadoDAO;
import com.portix.modelo.Empleado;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/empleados")
public class EmpleadoServlet extends HttpServlet {

  private EmpleadoDAO empleadoDAO = new EmpleadoDAO();

  // ---------- MÉTODO GET: mostrar el listado de empleados ----------
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String accion = request.getParameter("accion");

    if (accion != null && accion.equals("eliminar")) {
      // Eliminar empleado por id (viene como parámetro en la URL)
      int id = Integer.parseInt(request.getParameter("id"));
      empleadoDAO.eliminarEmpleado(id);
    }

    // Consultar todos los empleados y enviarlos a la vista JSP
    List<Empleado> listaEmpleados = empleadoDAO.consultarEmpleados();
    request.setAttribute("listaEmpleados", listaEmpleados);

    // Redirige (forward) hacia la página JSP que muestra la tabla
    request.getRequestDispatcher("listaEmpleados.jsp").forward(request, response);
  }

  // ---------- MÉTODO POST: registrar un nuevo empleado ----------
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    // Capturar los datos enviados desde el formulario HTML
    String nombre = request.getParameter("nombre");
    String documento = request.getParameter("documento");
    String cargo = request.getParameter("cargo");
    String correo = request.getParameter("correo");
    String telefono = request.getParameter("telefono");
    String fechaIngresoStr = request.getParameter("fechaIngreso");
    String estado = request.getParameter("estado");

    LocalDate fechaIngreso = LocalDate.parse(fechaIngresoStr);

    Empleado nuevoEmpleado = new Empleado(
        nombre, documento, cargo, correo, telefono, fechaIngreso, estado);

    empleadoDAO.insertarEmpleado(nuevoEmpleado);

    // Después de guardar, redirige al listado (usando GET, para evitar reenvío del
    // formulario)
    response.sendRedirect("empleados");
  }
}