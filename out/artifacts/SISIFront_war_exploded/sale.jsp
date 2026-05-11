<!-- <%@ page contentType="text/html;charset=UTF-8" language="java" %> -->
<html>
<head>
    <title>Registro de venta</title>
    <link rel="stylesheet" href="basicStyle.css">
    <link rel="stylesheet" href="saleStyle.css">
    <script src="Sale.js"></script>
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

    <div class="contenedor">

        <form id="ventaForm">
            <h1>Registro de Ventas</h1>

            <div class="datos">
                <label for="numeroServicio"># Servicio</label>
                <input type="number" id="numeroServicio" required>

                <label for="nombreItem">Nombre Ítem:</label>
                <input type="text" id="nombreItem" required>

                <label for="cantidad">Cantidad:</label>
                <input type="number" id="cantidad" required>

                <label for="servicio">Servicio a Recibir:</label>
                <input type="text" id="servicio" required>

                <label for="descuento">Descuento:</label>
                <input type="number" id="descuento" required>

                <label for="precio">Precio:</label>
                <input type="number" id="precio" required>
            </div>

            <div class="botones">
                <button type="button" onclick="agregarAlCarrito()">Agregar al Carrito</button>
                <button type="button" onclick="guardarVenta()">Guardar Venta</button>
                <button type="button" onclick="limpiarCarrito()">Limpiar Carrito</button>
            </div>

            <h2>Carrito de Compras</h2>
            <table id="carritoTabla">
                <thead>
                <tr>
                    <th># Servicio</th>
                    <th>Ítem</th>
                    <th>Cantidad</th>
                    <th>Servicio a Recibir</th>
                    <th>Descuento</th>
                    <th>Precio Unit.</th>
                    <th>Total</th>
                    <th>Total Neto</th>
                </tr>
                </thead>
                <tbody>
                <!-- Aquí se agregarán los elementos del carrito -->
                </tbody>
            </table>
        </form>


    </div>
</body>
</html>
