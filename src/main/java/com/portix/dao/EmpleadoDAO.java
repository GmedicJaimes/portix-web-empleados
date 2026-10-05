package com.portix.dao;

import com.portix.conexion.ConexionBD;
import com.portix.modelo.Empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {

  // ---------- INSERTAR ----------
  public boolean insertarEmpleado(Empleado empleado) {
    String sql = "INSERT INTO empleados (nombre, documento, cargo, correo, telefono, fecha_ingreso, estado) " +
        "VALUES (?, ?, ?, ?, ?, ?, ?)";

    try (Connection conexion = ConexionBD.obtenerConexion();
        PreparedStatement ps = conexion.prepareStatement(sql)) {

      ps.setString(1, empleado.getNombre());
      ps.setString(2, empleado.getDocumento());
      ps.setString(3, empleado.getCargo());
      ps.setString(4, empleado.getCorreo());
      ps.setString(5, empleado.getTelefono());
      ps.setDate(6, Date.valueOf(empleado.getFechaIngreso()));
      ps.setString(7, empleado.getEstado());

      int filasAfectadas = ps.executeUpdate();
      return filasAfectadas > 0;

    } catch (SQLException e) {
      System.out.println("Error al insertar empleado: " + e.getMessage());
      return false;
    }
  }

  // ---------- CONSULTAR TODOS ----------
  public List<Empleado> consultarEmpleados() {
    List<Empleado> listaEmpleados = new ArrayList<>();
    String sql = "SELECT * FROM empleados";

    try (Connection conexion = ConexionBD.obtenerConexion();
        PreparedStatement ps = conexion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery()) {

      while (rs.next()) {
        Empleado empleado = mapearEmpleado(rs);
        listaEmpleados.add(empleado);
      }

    } catch (SQLException e) {
      System.out.println("Error al consultar empleados: " + e.getMessage());
    }

    return listaEmpleados;
  }

  // ---------- CONSULTAR POR ID ----------
  public Empleado consultarEmpleadoPorId(int id) {
    String sql = "SELECT * FROM empleados WHERE id = ?";
    Empleado empleado = null;

    try (Connection conexion = ConexionBD.obtenerConexion();
        PreparedStatement ps = conexion.prepareStatement(sql)) {

      ps.setInt(1, id);

      try (ResultSet rs = ps.executeQuery()) {
        if (rs.next()) {
          empleado = mapearEmpleado(rs);
        }
      }

    } catch (SQLException e) {
      System.out.println("Error al consultar empleado por id: " + e.getMessage());
    }

    return empleado;
  }

  // ---------- ACTUALIZAR ----------
  public boolean actualizarEmpleado(Empleado empleado) {
    String sql = "UPDATE empleados SET nombre = ?, documento = ?, cargo = ?, correo = ?, " +
        "telefono = ?, fecha_ingreso = ?, estado = ? WHERE id = ?";

    try (Connection conexion = ConexionBD.obtenerConexion();
        PreparedStatement ps = conexion.prepareStatement(sql)) {

      ps.setString(1, empleado.getNombre());
      ps.setString(2, empleado.getDocumento());
      ps.setString(3, empleado.getCargo());
      ps.setString(4, empleado.getCorreo());
      ps.setString(5, empleado.getTelefono());
      ps.setDate(6, Date.valueOf(empleado.getFechaIngreso()));
      ps.setString(7, empleado.getEstado());
      ps.setInt(8, empleado.getId());

      int filasAfectadas = ps.executeUpdate();
      return filasAfectadas > 0;

    } catch (SQLException e) {
      System.out.println("Error al actualizar empleado: " + e.getMessage());
      return false;
    }
  }

  // ---------- ELIMINAR ----------
  public boolean eliminarEmpleado(int id) {
    String sql = "DELETE FROM empleados WHERE id = ?";

    try (Connection conexion = ConexionBD.obtenerConexion();
        PreparedStatement ps = conexion.prepareStatement(sql)) {

      ps.setInt(1, id);
      int filasAfectadas = ps.executeUpdate();
      return filasAfectadas > 0;

    } catch (SQLException e) {
      System.out.println("Error al eliminar empleado: " + e.getMessage());
      return false;
    }
  }

  // ---------- MÉTODO AUXILIAR ----------
  private Empleado mapearEmpleado(ResultSet rs) throws SQLException {
    Empleado empleado = new Empleado();
    empleado.setId(rs.getInt("id"));
    empleado.setNombre(rs.getString("nombre"));
    empleado.setDocumento(rs.getString("documento"));
    empleado.setCargo(rs.getString("cargo"));
    empleado.setCorreo(rs.getString("correo"));
    empleado.setTelefono(rs.getString("telefono"));

    Date fecha = rs.getDate("fecha_ingreso");
    if (fecha != null) {
      empleado.setFechaIngreso(fecha.toLocalDate());
    }

    empleado.setEstado(rs.getString("estado"));
    return empleado;
  }
}
