
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registro de Items</title>
</head>
<body>

    <div>
        <img src="logo.png" alt="Logo de la empresa">
        <a href="item.jsp">Registro Items</a>
        <h6>Sesión iniciada como:</h6>
        <a href="index.jsp">Cerrar Sesión</a>
    </div>

    <div>

        <h1 align="center"> Registro de Ítems</h1>
        <form method="get" action="./ItemServlet">
            <table align="center">
                <tr>
                    <td><label>Serie o código:</label></td>
                    <td><input type="text" name="id"></td>
                    <td><label># orden:</label></td>
                    <td><input type="text" name="orderNumber"></td>
                    <td><label># servicio</label></td>
                    <td><input type="text" name="serviceNumber"></td>
                </tr>

                <tr>
                    <td><label>Nombre ítem:</label></td>
                    <td><input type="text" name="name"></td>
                    <td><label>Nit Cliente:</label></td>
                    <td><input type="text" name="customerId"></td>
                    <td><label>Fecha:</label></td>
                    <td><input type="text" name="date"></td>
                </tr>

                <tr>
                    <td><label>Marca:</label></td>
                    <td><input type="text" name="brand"></td>
                    <td><label>Nombre Cliente:</label></td>
                    <td><input type="text" name="customerName"></td>
                </tr>

                <tr>
                    <td><label>Servicio por recibir::</label></td>
                    <td><input type="text" name="service"></td>
                    <td><label>Teléfono:</label></td>
                    <td><input type="text" name="phone"></td>
                </tr>

                <tr>
                    <td><label>Observaciones:</label></td>
                    <td><input type="text" name="comment"></td>
                </tr>

                <tr>
                    <td></td>
                    <td align="center"><button type="submit" name="boton1" value="saveButton">Guardar</button></td>
                    <td align="center"><button type="submit" name="boton2" value="clearButton">Limpiar</button></td>
                </tr>
            </table>
        </form>
    </div>

</body>
</html>
