function login(){
    console.log("Logeando...")

    let clave = document.frm_login.passwd.value
    let usuario = document.frm_login.usser.value
    console.log(clave + ', '+ usuario)
    let usuario_clave = {
        'usser_name':'usuario',
        'usser_passwd':'clave'
    }
    let options ={
        method: "GET",
        body: JSON.stringify(usuario_clave),
        Headers:{
            'Content-Type':'application/json'
        }
    }
    fetch ("http://localhost:8080/usuarios/login", options)
    .then (response => response.json())
    .then (data => {console.log(data)
    });
}