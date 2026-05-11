<!-- <%@ page contentType="text/html;charset=UTF-8" language="java" %> -->
<html>
<head>
    <title>Registro Cliente</title>
    <link rel="stylesheet" href="basicStyle.css">
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
        <form method="get" action="./CustomerServlet">
            <h1 >Registro de Clientes</h1>
            <table>
                <tr>
                    <td><label>Id Cliente:</label></td>
                    <td><input type="text" name="id"></td>
                    <td><label>Teléfono:</label></td>
                    <td><input type="text" name="phone"></td>
                </tr>

                <tr>
                    <td><label>Nombre Comercial:</label></td>
                    <td><input type="text" name="businessName"></td>
                    <td><label>Correo Contacto:</label></td>
                    <td><input type="text" name="contactEmail"></td>
                </tr>

                <tr>
                    <td><label>Nombre Cliente:</label></td>
                    <td><input type="text" name="customerName"></td>
                    <td><label>Correo Facturación:</label></td>
                    <td><input type="text" name="billingEmail"></td>
                </tr>

                <tr>
                    <td><label>Tipo Contribuyente:</label></td>
                    <td><input type="text" name="taxpayerType"></td>
                    <td><label>Dirección:</label></td>
                    <td><input type="text" name="address"></td>
                </tr>

                <tr>
                    <td><label>Código Actividad Principal:</label></td>
                    <td><input type="text" name="ciiu"></td>
                    <td><label>Ciudad:</label></td>
                    <td><input type="text" name="city"></td>
                </tr>

                <tr>
                    <td><label>Departamento:</label></td>
                    <td><input type="text" name="department"></td>
                    <!-- <td><label>Observaciones:</label></td> -->
                    <!-- <td><input type="text" name="comment"></td> -->
                </tr>

                <tr class="botones">
                    <td></td>
                    <td><button type="submit" name="boton1" value="saveButton">Guardar</button></td>
                    <td><button type="reset" name="boton2" value="clearButton">Limpiar</button></td>
                </tr>
            </table>
        </form>
    </div>

</body>
</html>
