var sales; // Variable global para almacenar los datos recibidos de la API

fetch("http://localhost:3000/sale/read")
    .then(response => response.json())
    .then(result => {
        sales = result; // Guardar los datos en la variable global
        mostrarTabla(sales); // Mostrar la tabla completa al cargar la página
    })
    .catch(error => console.log('Error:', error));

function mostrarTabla(sales) {
    var tabla = document.getElementById("tablaItems");
    var tbody = tabla.getElementsByTagName("tbody")[0];

    // Limpiar el contenido previo de la tabla
    tbody.innerHTML = "";

    // Crear las filas y celdas de la tabla con los datos recibidos
    sales.forEach(function(sale) {
        var fila = document.createElement("tr");
        var celdaNumeroServicio = document.createElement("td");
        var celdaNombreItem = document.createElement("td");
        var celdaCantidad = document.createElement("td");
        var celdaServicio = document.createElement("td");
        var celdaDescuento = document.createElement("td");
        var celdaPrecio = document.createElement("td");
        var celdaTotalSinDescuento = document.createElement("td");
        var celdaTotalConDescuento = document.createElement("td");

        celdaNumeroServicio.innerText = sale.numeroServicio;
        celdaNombreItem.innerText = sale.nombreItem;
        celdaCantidad.innerText = sale.cantidad;
        celdaServicio.innerText = sale.servicio;
        celdaDescuento.innerText = sale.descuento + "%";
        celdaPrecio.innerText = sale.precio;
        celdaTotalSinDescuento.innerText = sale.totalSinDescuento;
        celdaTotalConDescuento.innerText = sale.totalConDescuento;

        fila.appendChild(celdaNumeroServicio);
        fila.appendChild(celdaNombreItem);
        fila.appendChild(celdaCantidad);
        fila.appendChild(celdaServicio);
        fila.appendChild(celdaDescuento);
        fila.appendChild(celdaPrecio);
        fila.appendChild(celdaTotalSinDescuento);
        fila.appendChild(celdaTotalConDescuento);

        tbody.appendChild(fila);
    });
}

function filtrarPorNumeroServicio() {
    var filtro = document.getElementById("buscador").value.toLowerCase();

    // Filtrar los elementos que coincidan con el número de servicio ingresado
    var elementosFiltrados = sales.filter(function(sale) {
        return sale.numeroServicio.toString().toLowerCase().includes(filtro);
    });

    // Mostrar la tabla con los elementos filtrados
    mostrarTabla(elementosFiltrados);
}
