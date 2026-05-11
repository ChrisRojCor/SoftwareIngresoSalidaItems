var myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");

var raw = "{'id':2, 'name':'2', 'model':'2', 'brand':'2'}";

var requestOptions = {
    method: 'GET',
    headers: myHeaders,
    redirect: 'follow'
};

fetch("http://localhost:3000/customer/read", requestOptions)
    .then(response => response.text())
    .then(result => console.log(result))
    .catch(error => console.log('error', error));

var items; // Variable global para almacenar los datos recibidos de la API

fetch("http://localhost:3000/customer/read")
    .then(response => response.json())
    .then(result => {
        customers = result; // Guardar los datos en la variable global
        mostrarTabla(customers); // Mostrar la tabla completa al cargar la página
    })
    .catch(error => console.log('Error:', error));

function mostrarTabla(items) {
    var tabla = document.getElementById("tablaItems");
    var tbody = tabla.getElementsByTagName("tbody")[0];

    // Limpiar el contenido previo de la tabla
    tbody.innerHTML = "";

    // Crear las filas y celdas de la tabla con los datos recibidos
    items.forEach(function(customer) {
        var fila = document.createElement("tr");
        var celdaId = document.createElement("td");
        var celdaNombreComercial = document.createElement("td");
        var celdaNombreCliente = document.createElement("td");
        var celdaTipoContribuyente = document.createElement("td");
        var celdaCodigoActividad = document.createElement("td");
        var celdaDepartamento = document.createElement("td");
        var celdaTelefono = document.createElement("td");
        var celdaCorreoContacto = document.createElement("td");
        var celdaCorreoFacturacion = document.createElement("td");
        var celdaDireccion = document.createElement("td");
        var celdaCiudad = document.createElement("td");

        celdaId.innerText = customer.id;
        celdaNombreComercial.innerText = customer.customerName;
        celdaNombreCliente.innerText = customer.businessName;
        celdaTipoContribuyente.innerText = customer.taxpayerType;
        celdaCodigoActividad.innerText = customer.ciiu;
        celdaDepartamento.innerText = customer.phone;
        celdaTelefono.innerText = customer.contactEmail;
        celdaCorreoContacto.innerText = customer.billingEmail;
        celdaCorreoFacturacion.innerText = customer.address;
        celdaDireccion.innerText = customer.city;
        celdaCiudad.innerText = customer.department;

        fila.appendChild(celdaId);
        fila.appendChild(celdaNombreComercial);
        fila.appendChild(celdaNombreCliente);
        fila.appendChild(celdaTipoContribuyente);
        fila.appendChild(celdaCodigoActividad);
        fila.appendChild(celdaDepartamento);
        fila.appendChild(celdaTelefono);
        fila.appendChild(celdaCorreoContacto);
        fila.appendChild(celdaCorreoFacturacion);
        fila.appendChild(celdaDireccion);
        fila.appendChild(celdaCiudad);

        tbody.appendChild(fila);
    });


}

function filtrarPorId() {
    var filtro = document.getElementById("buscador").value.toLowerCase();

    // Filtrar los elementos que coincidan con el ID ingresado
    var elementosFiltrados = customers.filter(function(item) {
        return item.id.toString().toLowerCase().includes(filtro);
    });

    // Mostrar la tabla con los elementos filtrados
    mostrarTabla(elementosFiltrados);
}

