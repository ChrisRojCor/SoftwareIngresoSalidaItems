<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Tabla de Items</title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <link rel="stylesheet" href="basicStyle.css">
    <link rel="stylesheet" href="dbStyle.css">
    <script src="Item.js"></script>
</head>
<body>

    <div class="menu">
        <img class="opcion1" class="img" src="logo.png" alt="Logo de la empresa">
        <a href="item.jsp">Registro Item</a>
        <a href="dbItem.jsp">Base Datos Items</a>
        <a href="customer.jsp">Registro Cliente</a>
        <a href="dbCustomer.jsp">Base Datos Clientes</a>
        <a href="sale.jsp">Registro Venta</a>
        <a href="dbSale.jsp">Base Datos Ventas</a>
        <h6>Sesión iniciada como:</h6>
        <a class="cerrar" href="index.jsp">Cerrar Sesión</a>
    </div>



    <div class="db">

        <form>
            <h1>Tabla de Items</h1>
            <label for="buscador">Buscar por ID:</label>
            <input type="text" id="buscador" onkeyup="filtrarPorId()">
                <table id="tablaItems">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>Modelo</th>
                        <th>Marca</th>
                        <th>Servicio por recibir</th>
                        <th>Id Cliente</th>
                        <th>Nombre Cliente</th>
                        <th>Teléfono</th>
                        <th># Servicio</th>
                        <th>Fecha</th>
                        <th>Observaciones</th>
                    </tr>
                    </thead>
                    <tbody>
                    <!-- Aquí se agregará el contenido de la tabla -->
                    </tbody>
                </table>
        </form>
    </div>
</body>
</html>
