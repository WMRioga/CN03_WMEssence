package com.wmessence.wmessence.Controllers;

import com.wmessence.wmessence.Models.UsuariosModel;
import com.wmessence.wmessence.Services.UsuariosServices;
import com.wmessence.wmessence.Repositories.UsuariosRepository;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;

import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin ("*")
@RequestMapping ("/usuarios")
public class UsuariosController {
    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private UsuariosServices usuariosServices;

    @GetMapping ("/list")
    public List<UsuariosModel> consultarTodo(){
        return usuariosServices.findAll();
    }
    @GetMapping ("/list/{id}")
    public UsuariosModel consultarPorId (@PathVariable Integer id){
        return usuariosServices.findById(id);
    }
    // @PostMapping("/login")
    // public String login (@RequestBody UsuariosModel usuariosModel){
    //     System.out.println("Correo: " + usuariosModel.getUsser_email());
    //     System.out.println("Contraseña: " + usuariosModel.getUsser_passwd());
    //     EntityManager em = getEntityManager();
    //     try{
    //         String query = "SELECT * FROM cn03_usuarios WHERE usser_email= '" + usuariosModel.getUsser_email() + "' AND usser_passwd= '" + usuariosModel.getUsser_passwd() + "'";
    //         System.out.println(" " + query);
    //         Query q = em.createNativeQuery(query);
    //         List <UsuariosModel> listaUsuarios = q.getResultList();
    //         if (listaUsuarios.isEmpty()){
    //             return "no";
    //         }else{
    //             return "ok";
    //         }
    //     } catch (Exception ex){
    //         System.out.println(" " + ex);
    //     }
    // }
}
// 3178865477 -- Nestor Anaya Chavez