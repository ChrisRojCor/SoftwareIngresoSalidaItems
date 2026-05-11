<!-- <%@ page contentType="text/html;charset=UTF-8" language="java" %> -->
<html>
<head>
    <title>Inicio de Sesión</title>
    <link rel="stylesheet" href="indexStyle.css">
    <script src="Item.js"></script>
    <script src="Main.js"></script>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
</head>
<body>
    <div>    
        <form method="get" action="./LoginServlet">
            <h1>Iniciar Sesión</h1>
            <input class="campos" type="text" id="usuario" name="usuario" placeholder="Usuario">
            <input class="campos" type="password" id="contraseña" name="contraseña" placeholder="Contraseña">
            <button class="aceptar" type="submit">Aceptar</button>

        </form>
    </div>
</body>
</html>
