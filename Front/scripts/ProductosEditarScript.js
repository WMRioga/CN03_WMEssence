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


function editar_productos(){
    let params = new URLSearchParams(location.search);
    console.log(params)
    const ID = params.get('_id')
    fetch("http://localhost:8080/productos/list/" + ID)
    .then (response => response.json())
    .then (data => {console.log(data)
    document.ProductForm.product_name.value = data.product_name
    document.ProductForm.product_cost.value = data.product_cost
    document.ProductForm.product_description.value = data.product_description
    console.log("categoría_id: "+data.product_category)
    document.getElementById("product_category").selectedIndex = (data.product_category-1)
    })
}
editar_productos()

function actualizar(){
    let params = new URLSearchParams(location.search);
    const ID = params.get('_id')
    console.log("Actualizando ID: "+ ID)
    const nombre = document.ProductForm.product_name.value
    const categoria = document.ProductForm.product_category.value
    const costo = document.ProductForm.product_cost.value
    const descripcion = document.ProductForm.product_description.value
    let product = {
        '_id' : ID,
        'product_name' : nombre,
        'product_category' : categoria,
        'product_cost' : costo,
        'product_description' : descripcion
    }
    console.log(product)
    let options = {
        method : "PUT",
        body : JSON.stringify(product),
        headers : {"Content-Type" : "application/json"} 
    }
    let url = "http://localhost:8080/productos/"
    fetch(url, options)
    .then (response => response.json())
    .then (data => {console.log(data)})
    alert("Producto Actualizado, ID: "+ ID)
}