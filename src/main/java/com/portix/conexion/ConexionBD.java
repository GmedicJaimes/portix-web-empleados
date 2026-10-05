package com.portix.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

  private static final String URL = "jdbc:mysql://localhost:3306/portix_db";
  private static final String USUARIO = "root";
  private static final String CONTRASENA = "admin";

  static {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public static Connection obtenerConexion() throws SQLException {
    return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
  }
}