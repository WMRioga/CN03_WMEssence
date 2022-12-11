function listar_productos(){
    console.log("Listando...")
    fetch("http://localhost:8080/productos/list")
    .then(response => response.json())
    .then(data => {console.log(data)
        let codigo =""
            codigo += '<table class="table">'
            codigo += '<thead>'
            codigo += '    <tr>'
            codigo += '        <th scope="col">ID</th>'
            codigo += '        <th scope="col">Nombre</th>'
            codigo += '        <th scope="col">Descripcion</th>'
            codigo += '        <th scope="col">Costo</th>'
            codigo += '        <th scope="col">Opciones</th>'
            codigo += '    </tr>'
            codigo += '</thead>'
            codigo += '<tbody class="table-group-divider">'

            data.forEach(element => {
                console.log(element.product_name)
                codigo += '     <tr>'
                codigo += '         <th scope="row">'+element._id+'</th>'
                codigo += '         <td>'+element.product_name+'</td>'
                codigo += '         <td>'+element.product_description+'</td>'
                codigo += '         <td> $'+element.product_cost+'</td>'
                codigo += '         <td>'
                codigo += '             <div class="btn-group btn-group-sm d-grid d-md-flex justify-content-md-end" role="group" aria-label="Small button group">'
                codigo += '                 <a href="Productos_Editar.html?_id='+element._id+'" type="button" class="btn btn-outline-dark">Editar</a>'
                codigo += '                 <button onclick="eliminar_productos('+element._id+')" type="button" class="btn btn-outline-dark">Eliminar</button>'
                codigo += '             </div>'
                codigo += '         </td>'
                codigo += '     </tr>'
                // codigo += '</tbody>'
                // codigo += '</table>'
        });
        document.getElementById("tablas").innerHTML = codigo
    });
}
listar_productos()

function eliminar_productos(Id) {
    console.log("Eliminando el ID:"+Id)
    // Con la linea 39 y todo dentro de este if me permite confirmar antes de hacer
    if(confirm("Desea eliminar el registro?")){    
        let options = {
            method : "DELETE"
        }
        fetch("http://localhost:8080/productos/" + Id, options)
        .then (response => response.json())
        .then (data => {console.log(data)})
        alert("Producto eliminado.")
        listar_productos()
    }
}