<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://xmlns.jcp.org/jsf/html"
      xmlns:p="http://primefaces.org/ui">
<head>
    <title>Bienvenido al Sistema CRUD</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            flex-direction: column;
        }

        h1 {
            color: #333;
            font-size: 2.5em;
            margin-bottom: 20px;
        }

        p {
            color: #555;
            font-size: 1.2em;
            margin-bottom: 30px;
        }

        .options {
            display: flex;
            flex-direction: column;
            gap: 15px;
        }

        .options a {
            text-decoration: none;
            color: #fff;
            background-color: #007bff;
            padding: 10px 20px;
            border-radius: 5px;
            text-align: center;
            font-size: 1.1em;
            transition: background-color 0.3s ease;
        }

        .options a:hover {
            background-color: #0056b3;
        }

        .options a:active {
            background-color: #004080;
        }
    </style>
</head>
<body>
<h1>Bienvenido al Sistema CRUD</h1>
<p>Seleccione una opcion:</p>

<div class="options">
    <!-- Enlace para ir a la vista de Usuarios -->
    <a href="usuario.xhtml">Gestionar Usuarios</a>
    <!-- Enlace para ir a la vista de Publicaciones -->
    <a href="publicacion.xhtml">Gestionar Publicaciones</a>
    <!-- Enlace para ir a la vista de Roles -->
    <a href="rol.xhtml">Gestionar Roles</a>
</div>
</body>
</html>