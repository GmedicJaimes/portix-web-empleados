package com.portix.modelo;

import java.time.LocalDate;

public class Empleado {

  private int id;
  private String nombre;
  private String documento;
  private String cargo;
  private String correo;
  private String telefono;
  private LocalDate fechaIngreso;
  private String estado;

  public Empleado() {
  }

  public Empleado(String nombre, String documento, String cargo, String correo,
      String telefono, LocalDate fechaIngreso, String estado) {
    this.nombre = nombre;
    this.documento = documento;
    this.cargo = cargo;
    this.correo = correo;
    this.telefono = telefono;
    this.fechaIngreso = fechaIngreso;
    this.estado = estado;
  }

  public Empleado(int id, String nombre, String documento, String cargo, String correo,
      String telefono, LocalDate fechaIngreso, String estado) {
    this.id = id;
    this.nombre = nombre;
    this.documento = documento;
    this.cargo = cargo;
    this.correo = correo;
    this.telefono = telefono;
    this.fechaIngreso = fechaIngreso;
    this.estado = estado;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDocumento() {
    return documento;
  }

  public void setDocumento(String documento) {
    this.documento = documento;
  }

  public String getCargo() {
    return cargo;
  }

  public void setCargo(String cargo) {
    this.cargo = cargo;
  }

  public String getCorreo() {
    return correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public LocalDate getFechaIngreso() {
    return fechaIngreso;
  }

  public void setFechaIngreso(LocalDate fechaIngreso) {
    this.fechaIngreso = fechaIngreso;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  @Override
  public String toString() {
    return "Empleado{" +
        "id=" + id +
        ", nombre='" + nombre + '\'' +
        ", documento='" + documento + '\'' +
        ", cargo='" + cargo + '\'' +
        ", correo='" + correo + '\'' +
        ", telefono='" + telefono + '\'' +
        ", fechaIngreso=" + fechaIngreso +
        ", estado='" + estado + '\'' +
        '}';
  }
}