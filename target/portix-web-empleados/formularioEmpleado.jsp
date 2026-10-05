<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <title>Portix | Registrar Empleado</title>
    <style>
      body {
        font-family: Arial, sans-serif;
        background-color: #eeeeee;
        padding: 40px;
      }
      .form-container {
        background: white;
        max-width: 450px;
        margin: auto;
        padding: 30px;
        border-radius: 8px;
      }
      h2 {
        color: #0d3f6e;
      }
      label {
        display: block;
        margin-top: 12px;
        font-size: 0.9rem;
        color: #555;
      }
      input,
      select {
        width: 100%;
        padding: 8px;
        margin-top: 4px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
      }
      button {
        margin-top: 20px;
        width: 100%;
        background-color: #0d3f6e;
        color: white;
        border: none;
        padding: 10px;
        border-radius: 4px;
        cursor: pointer;
      }
      button:hover {
        background-color: #092c4d;
      }
      a {
        display: block;
        text-align: center;
        margin-top: 15px;
        color: #0d3f6e;
      }
    </style>
  </head>
  <body>
    <div class="form-container">
      <h2>Registrar Empleado</h2>

      <form action="empleados" method="post">
        <label for="nombre">Nombre</label>
        <input type="text" id="nombre" name="nombre" required />

        <label for="documento">Documento</label>
        <input type="text" id="documento" name="documento" required />

        <label for="cargo">Cargo</label>
        <input type="text" id="cargo" name="cargo" required />

        <label for="correo">Correo</label>
        <input type="email" id="correo" name="correo" />

        <label for="telefono">Teléfono</label>
        <input type="text" id="telefono" name="telefono" />

        <label for="fechaIngreso">Fecha de ingreso</label>
        <input type="date" id="fechaIngreso" name="fechaIngreso" required />

        <label for="estado">Estado</label>
        <select id="estado" name="estado">
          <option value="Activo">Activo</option>
          <option value="Inactivo">Inactivo</option>
        </select>

        <button type="submit">Guardar Empleado</button>
      </form>

      <a href="empleados">Ver listado de empleados</a>
    </div>
  </body>
</html>
