    (() => {
        "use strict";
    
        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        const forms = document.querySelectorAll(".needs-validation");
    
        // Loop over them and prevent submission
        Array.from(forms).forEach((form) => {
        form.addEventListener(
            "submit",
            (event) => {
            if (!form.checkValidity()) {
                event.preventDefault();
                event.stopPropagation();
            }
    
            form.classList.add("was-validated");
            },
            false
        );
        });
    })();
    
// -------------------------------------------------------------------------------------

    function Login(){
        console.log("Logueando...")

        let usser_name = document.FormAccess.usser_name.value
        let usser_passwd = document.FormAccess.usser_passwd.value
        let usser_email = document.FormAccess.usser_email.value
        console.log(usser_name +' || '+ usser_passwd +' || '+ usser_email)
        let usser = {
            'usser_name':"",
            'usser_passwd':usser_passwd,
            'usser_email':usser_email
        }
    }