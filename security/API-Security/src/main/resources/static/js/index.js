const formulario = document.querySelector('#formulario-crucero');
const tabla = document.querySelector('#tabla-crucero');
const url = 'http://localhost:9095/Productor/bebida';
const urlGet = 'http://localhost:9095/Consumidor/bebida';
formulario.addEventListener('submit', async (event) => {
    event.preventDefault();

    const nombre = formulario.querySelector('#nombre5').value;
    const descripcion = formulario.querySelector('#descripcion5').value;
    const precio = formulario.querySelector('#placa5').value;

    const data = {
        nombre: nombre,
        descripcion : descripcion,
        precio: precio
    };

    const response = await fetch(url, {
        method: 'POST',
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json'
        }
    });

    if (response.ok) {
        console.log('La solicitud ha sido exitosa');
        actualizarTabla();
    } else {
        console.error('Error al realizar la solicitud');
    }
});

function actualizarTabla() {
    fetch(urlGet)
        .then(response => response.json())
        .then(data => {
            // Limpiar la tabla existente
            while (tabla.firstChild) {
                tabla.removeChild(tabla.firstChild);
            }

            // Crear las filas de la tabla con los datos recibidos
            data.forEach(crucero => {

                const row = document.createElement('tr');
                const modeloCell = document.createElement('td');
                const nombreCell = document.createElement('td');
                const placaCell = document.createElement('td');

                modeloCell.textContent = crucero.nombre;
                nombreCell.textContent = crucero.descripcion;
                placaCell.textContent = crucero.precio;

                row.appendChild(modeloCell);
                row.appendChild(nombreCell);
                row.appendChild(placaCell);

                tabla.appendChild(row);
            });
        })
        .catch(error => {
            console.error('Error al actualizar la tabla: ', error);
        });
}



function eliminarDatos(id) {
    const deleteUrl = `${url}/${id}`;

    fetch(deleteUrl, {
        method: 'DELETE'
    })
        .then(response => response.json())
        .then(data => {
            console.log('Datos eliminados correctamente: ', data);
            actualizarTabla();
        })
        .catch(error => {
            console.error('Error al eliminar los datos: ', error);
        });
}


// Llamar actualizarTabla() al cargar la página
window.addEventListener('load', actualizarTabla);