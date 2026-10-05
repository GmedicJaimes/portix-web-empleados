<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.portix.modelo.Empleado" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Portix | Listado de Empleados</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #eeeeee; padding: 40px; }
        .container { background: white; max-width: 900px; margin: auto; padding: 30px; border-radius: 8px; }
        h2 { color: #0d3f6e; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { padding: 10px; border-bottom: 1px solid #ddd; text-align: left; font-size: 0.9rem; }
        th { background-color: #0d3f6e; color: white; }
        a.accion { color: #d92d20; text-decoration: none; margin-right: 10px; }
        a.nuevo { display: inline-block; margin-top: 20px; background-color: #0d3f6e; color: white; padding: 10px 16px; border-radius: 4px; text-decoration: none; }
    </style>
</head>
<body>

    <div class="container">
        <h2>Listado de Empleados - Portix</h2>

        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Documento</th>
                    <th>Cargo</th>
                    <th>Correo</th>
                    <th>Teléfono</th>
                    <th>Fecha Ingreso</th>
                    <th>Estado</th>
                    <th>Acción</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Empleado> listaEmpleados = (List<Empleado>) request.getAttribute("listaEmpleados");
                    if (listaEmpleados != null) {
                        for (Empleado emp : listaEmpleados) {
                %>
                <tr>
                    <td><%= emp.getId() %></td>
                    <td><%= emp.getNombre() %></td>
                    <td><%= emp.getDocumento() %></td>
                    <td><%= emp.getCargo() %></td>
                    <td><%= emp.getCorreo() %></td>
                    <td><%= emp.getTelefono() %></td>
                    <td><%= emp.getFechaIngreso() %></td>
                    <td><%= emp.getEstado() %></td>
                    <td><a class="accion" href="empleados?accion=eliminar&id=<%= emp.getId() %>">Eliminar</a></td>
                </tr>
                <%
                        }
                    }
                %>
            </tbody>
        </table>

        <a class="nuevo" href="formularioEmpleado.jsp">+ Registrar nuevo empleado</a>
    </div>

</body>
</html>