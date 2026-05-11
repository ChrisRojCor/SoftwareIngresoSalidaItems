var myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");

var raw = "{'id':2, 'name':'2', 'model':'2', 'brand':'2'}";

var requestOptions = {
    method: 'GET',
    headers: myHeaders,
    redirect: 'follow'
};

fetch("http://localhost:3000/item/read", requestOptions)
    .then(response => response.text())
    .then(result => console.log(result))
    .catch(error => console.log('error', error));

var items; // Variable global para almacenar los datos recibidos de la API

fetch("http://localhost:3000/item/read")
    .then(response => response.json())
    .then(result => {
        items = result; // Guardar los datos en la variable global
        mostrarTabla(items); // Mostrar la tabla completa al cargar la página
    })
    .catch(error => console.log('Error:', error));

function mostrarTabla(items) {
    var tabla = document.getElementById("tablaItems");
    var tbody = tabla.getElementsByTagName("tbody")[0];

    // Limpiar el contenido previo de la tabla
    tbody.innerHTML = "";

    // Crear las filas y celdas de la tabla con los datos recibidos
    items.forEach(function(item) {
        var fila = document.createElement("tr");
        var celdaId = document.createElement("td");
        var celdaNombre = document.createElement("td");
        var celdaModelo = document.createElement("td");
        var celdaMarca = document.createElement("td");
        var celdaServicio = document.createElement("td");
        var celdaIdCliente = document.createElement("td");
        var celdaNombreCliente = document.createElement("td");
        var celdaTelefono = document.createElement("td");
        var celdaNumServicio = document.createElement("td");
        var celdaFecha = document.createElement("td");
        var celdaObservaciones = document.createElement("td");

        celdaId.innerText = item.id;
        celdaNombre.innerText = item.name;
        celdaModelo.innerText = item.model;
        celdaMarca.innerText = item.brand;
        celdaServicio.innerText = item.service;
        celdaIdCliente.innerText = item.customerId;
        celdaNombreCliente.innerText = item.customerName;
        celdaTelefono.innerText = item.phone;
        celdaNumServicio.innerText = item.serviceNumber;
        celdaFecha.innerText = item.date;
        celdaObservaciones.innerText = item.comment;

        fila.appendChild(celdaId);
        fila.appendChild(celdaNombre);
        fila.appendChild(celdaModelo);
        fila.appendChild(celdaMarca);
        fila.appendChild(celdaServicio);
        fila.appendChild(celdaIdCliente);
        fila.appendChild(celdaNombreCliente);
        fila.appendChild(celdaTelefono);
        fila.appendChild(celdaNumServicio);
        fila.appendChild(celdaFecha);
        fila.appendChild(celdaObservaciones);

        tbody.appendChild(fila);
    });

}

function filtrarPorId() {
    var filtro = document.getElementById("buscador").value.toLowerCase();

    // Filtrar los elementos que coincidan con el ID ingresado
    var elementosFiltrados = items.filter(function(item) {
        return item.id.toString().toLowerCase().includes(filtro);
    });

    // Mostrar la tabla con los elementos filtrados
    mostrarTabla(elementosFiltrados);
}

