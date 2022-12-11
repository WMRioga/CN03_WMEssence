function listar_categorias(){
    console.log("Solicitando Categorías")
    fetch("http://localhost:8080/categorias/list")
    .then(response => response.json())
    .then(data => {console.log(data)
        let codigo =""
        data.forEach(Element => {
            codigo += '<option value='+Element._id+'>'
            codigo += Element.category_name
            codigo += '</option>'
        });
        document.getElementById("product_category").innerHTML = codigo
    });
}
listar_categorias()

function guardar(){
    console.log("Guardando...")
    const nombre = document.ProductForm.product_name.value
    const categoria = document.ProductForm.product_category.value
    const costo = document.ProductForm.product_cost.value
    const descripcion = document.ProductForm.product_description.value
    let product = {
        'product_name' : nombre,
        'product_category' : categoria,
        'product_cost' : costo,
        'product_description' : descripcion
    }
    console.log(product)
    let options = {
        method : "POST",
        body : JSON.stringify(product),
        headers : {"Content-Type" : "application/json"} 
    }
    fetch("http://localhost:8080/productos/", options)
    .then (response => response.json())
    .then (data => {console.log(data)})
}
