
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registro de venta</title>
</head>
<body>

    <div>
        <img src="logo.png" alt="Logo de la empresa">
        <a href="item.jsp">Registro Venta</a>
        <h6>Sesión iniciada como:</h6>
        <a href="index.jsp">Cerrar Sesión</a>
    </div>

    <div>

        <h1 align="center"> Registro de Venta</h1>
        <form method="get" action="./SaleServlet">
            <table align="center">
                <tr>
                    <td><label>Nombre ítem:</label></td>
                    <td><input type="text" name="name"></td>
                    <td><label>Cant:</label></td>
                    <td><input type="text" name="amount"></td>
                    <td><label>Servicio por recibir:</label></td>
                    <td><input type="text" name="service"></td>
                    <td><label>Desc:</label></td>
                    <td><input type="text" name="discount"></td>
                    <td align="center"><button type="submit" name="boton4" value="saveButton">Agregar</button></td>
                </tr>

                <tr>
                    <th>Nombre ítem</th>
                    <th>Cant.</th>
                    <th>Servicio por recibir</th>
                    <th>Desc.</th>
                    <th>Total</th>
                </tr>

                <tr>
                    <td>Ítem 1</td>
                    <td>3</td>
                    <td>Servicio 1</td>
                    <td>Descuento 1</td>
                    <td>$30</td>
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
