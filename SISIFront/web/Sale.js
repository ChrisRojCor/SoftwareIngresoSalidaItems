var carrito = [];

function agregarAlCarrito() {
    var nombreItem = document.getElementById("nombreItem").value;
    var cantidad = parseInt(document.getElementById("cantidad").value);
    var servicio = document.getElementById("servicio").value;
    var descuento = parseInt(document.getElementById("descuento").value);
    var precio = parseFloat(document.getElementById("precio").value);
    var numeroServicio = document.getElementById("numeroServicio").value;

    // Realizar validaciones aquí según tus necesidades

    var totalSinDescuento = calcularTotalSinDescuento(cantidad, precio);
    var totalConDescuento = calcularTotalConDescuento(totalSinDescuento, descuento);

    var venta = {
        nombreItem: nombreItem,
        cantidad: cantidad,
        servicio: servicio,
        descuento: descuento,
        precio: precio,
        totalSinDescuento: totalSinDescuento,
        totalConDescuento: totalConDescuento,
        numeroServicio: numeroServicio
    };

    carrito.push(venta);
    actualizarTablaCarrito();
    limpiarCampos();
}

function calcularTotalSinDescuento(cantidad, precio) {
    return cantidad * precio;
}

function calcularTotalConDescuento(totalSinDescuento, descuento) {
    // Implementa la lógica para aplicar el descuento al total aquí
    // Puedes reutilizar la lógica que habías implementado antes
    // (por ejemplo, la función calcularTotal() que aplicaba el descuento).
    // Por simplicidad, aquí asumimos que ya tienes una función para ello.
    return totalSinDescuento * ((100 - descuento) / 100);
}

function limpiarCarrito() {
    carrito = []; // Vaciar el carrito
    actualizarTablaCarrito(); // Actualizar la tabla
}

function actualizarTablaCarrito() {
    var tabla = document.getElementById("carritoTabla");
    var tbody = tabla.getElementsByTagName("tbody")[0];
    tbody.innerHTML = "";

    carrito.forEach(function (venta) {
        var fila = document.createElement("tr");
        var celdaNombreItem = document.createElement("td");
        var celdaCantidad = document.createElement("td");
        var celdaServicio = document.createElement("td");
        var celdaDescuento = document.createElement("td");
        var celdaPrecio = document.createElement("td");
        var celdaTotalSinDescuento = document.createElement("td");
        var celdaTotalConDescuento = document.createElement("td");
        var celdaNumeroServicio = document.createElement("td");

        celdaNumeroServicio.innerText = venta.numeroServicio;
        celdaNombreItem.innerText = venta.nombreItem;
        celdaCantidad.innerText = venta.cantidad;
        celdaServicio.innerText = venta.servicio;
        celdaDescuento.innerText = venta.descuento + "%";
        celdaPrecio.innerText = venta.precio;
        celdaTotalSinDescuento.innerText = venta.totalSinDescuento;
        celdaTotalConDescuento.innerText = venta.totalConDescuento;

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

function limpiarCampos() {
    document.getElementById("nombreItem").value = "";
    document.getElementById("cantidad").value = "";
    document.getElementById("servicio").value = "";
    document.getElementById("descuento").value = "";
    document.getElementById("precio").value = "";
}

function guardarVenta() {
    if (carrito.length === 0) {
        alert("El carrito está vacío. Agregue elementos al carrito antes de guardar.");
        return;
    }

    var url = "http://localhost:3000/sale/create";
    var requestOptions = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(carrito)
    };

    fetch(url, requestOptions)
        .then(response => response.json())
        .then(data => {
            alert("Venta guardada con éxito.");
            carrito = []; // Limpiar el carrito después de guardar
            actualizarTablaCarrito();
        })
        .catch(error => {
            alert("Error al guardar la venta: " + error);
        });

    console.log(carrito)
}



