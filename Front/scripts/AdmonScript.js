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
                codigo += '    <tr>'
                codigo += '        <th scope="row">'+element._id+'</th>'
                codigo += '        <td>'+element.product_name+'</td>'
                codigo += '        <td>'+element.product_description+'</td>'
                codigo += '        <td> $'+element.product_cost+'</td>'
                codigo += '        <td><button type="submit" class="btn btn-primary btn-sm">Ingresar</button></td>'
                codigo += '    </tr>'
                // codigo += '</tbody>'
                // codigo += '</table>'
        });
        document.getElementById("tablas").innerHTML = codigo
    })
}