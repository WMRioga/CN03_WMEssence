console.log("Hola Mundo")

function ListarProductos(){
    fetch("http://localhost:8080/productos/list")
    .then(response => response.json())
    .then(data => {
        let codigo =""
        console.log(data)
        data.forEach(element => {
            console.log(element.product_name)
            // codigo += element.product_name + ", "
            codigo += '<div class="col-md-6 col-lg-4 p-1">'
            codigo += '    <div class="card mb-2 p-2 shadow h-100">'
            codigo += '        <div class="row g-0">'
            codigo += '            <div class="col-md-4">'
            codigo += '                <img src="img/Camisetas/'+element.product_attachment+'.jpg" class="img-fluid rounded-start" alt="...">'
            codigo += '            </div>'
            codigo += '            <div class="col-md-8">'
            codigo += '            <div class="card-text">'
            codigo += '                <h6 class="card-title">'+element.product_name+'</h6>'
            codigo += '                <p class="card-subtitle mb-2 text-muted">'+element.product_description+'</p>'
            codigo += '                <h6 class="card-title"> $'+element.product_cost+'</h6>'
            codigo += '                <!--<p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>-->'
            codigo += '            </div>'
            codigo += '            </div>'
            codigo += '        </div>'
            codigo += '    </div>'
            codigo += '</div>'
        });
        document.getElementById("Productos").innerHTML = codigo
    })
}
ListarProductos()

