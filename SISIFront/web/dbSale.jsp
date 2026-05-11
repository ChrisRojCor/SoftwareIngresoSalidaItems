<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Tabla de Items</title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <link rel="stylesheet" href="basicStyle.css">
    <link rel="stylesheet" href="dbStyle.css">
    <script src="dbSale.js"></script>
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
        <h1>Tabla de Ventas</h1>
        <label for="buscador">Buscar por # Servicio:</label>
        <input type="text" id="buscador" onkeyup="filtrarPorNumeroServicio()">
        <table id="tablaItems">
            <thead>
            <tr>
                <th># Servicio</th>
                <th>Nombre Ítem</th>
                <th>Cantidad</th>
                <th>Servicio a Recibir</th>
                <th>Descuento</th>
                <th>Precio Unit.</th>
                <th>Total</th>
                <th>Total Neto</th>
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
