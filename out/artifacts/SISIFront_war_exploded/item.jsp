 <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registro de Items</title>
    <link rel="stylesheet" href="basicStyle.css">
    <script src="Main.js"></script>
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
        <form method="get" action="./ItemServlet">
            <h1> Registro Ítem</h1>
            <table>
                <tr>
                    <td><label>Serie o código:</label></td>
                    <td><input type="text" name="id"></td>
                    <td><label>Servicio por recibir:</label></td>
                    <td><input type="text" name="service"></td>
                    <td><label># servicio</label></td>
                    <td><input type="text" name="serviceNumber"></td>
                </tr>
    
                <tr>
                    <td><label>Nombre ítem:</label></td>
                    <td><input type="text" name="name"></td>
                    <td><label>Id Cliente:</label></td>
                    <td><input type="text" name="customerId"></td>
                    <td><label>Fecha:</label></td>
                    <td><input type="date" name="date"></td>
                </tr>
    
                <tr>
                    <td><label>Marca:</label></td>
                    <td><input type="text" name="brand"></td>
                    <td><label>Nombre Cliente:</label></td>
                    <td><input type="text" name="customerName"></td>
                </tr>
    
                <tr>
                    <td><label>Modelo:</label></td>
                    <td><input type="text" name="model"></td>
                    <td><label>Teléfono:</label></td>
                    <td><input type="text" name="phone"></td>
                </tr>
    
                <tr>
                    <td><label>Observaciones:</label></td>
                    <td><input type="text" name="comment"></td>
                </tr>
    
                <tr class="botones">
                    <td></td>
                    <td></td>
                    <td><button type="submit" name="boton1" value="saveButton">Guardar</button></td>
                    <td><button type="reset" name="boton2" value="clearButton">Limpiar</button></td>
                    <td></td>
                </tr>
            </table>
        </form>
    </div>

</body>
</html>
