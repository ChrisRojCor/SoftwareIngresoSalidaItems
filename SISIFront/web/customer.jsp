<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registro Cliente</title>
</head>
<body>

<div>
    <img src="logo.png" alt="Logo de la empresa">
    <a href="customer.jsp">Registro Cliente</a>
    <h6>Sesión iniciada como:</h6>
    <a href="index.jsp">Cerrar Sesión</a>
</div>

<div>

    <h1 align="center" >Registro de Clientes</h1>
    <form method="get" action="./CustomerServlet">
        <table align="center">
            <tr>
                <td><label># Nit Cliente:</label></td>
                <td><input type="text" name="id"></td>
                <td><label>Teléfono:</label></td>
                <td><input type="text" name="phone"></td>
            </tr>

            <tr>
                <td><label>Nombre Comercial:</label></td>
                <td><input type="text" name="tradeName"></td>
                <td><label>Correo Contacto:</label></td>
                <td><input type="text" name="contactEmail"></td>
            </tr>

            <tr>
                <td><label>Nombre Cliente:</label></td>
                <td><input type="text" name="customerName"></td>
                <td><label>Correo Facturación:</label></td>
                <td><input type="text" name="billinEmail"></td>
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
