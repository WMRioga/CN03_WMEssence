package com.wmessence.wmessence.Controllers;

import com.wmessence.wmessence.Models.UsuariosModel;
import com.wmessence.wmessence.Services.UsuariosServices;
import com.wmessence.wmessence.Repositories.UsuariosRepository;
import com.wmessence.wmessence.Security.Hash;

import java.util.List;

import javax.validation.Valid;

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
    @ResponseBody
    public ResponseEntity<List<UsuariosModel>> consultarTodo(@RequestHeader ("usuario") String usuario, @RequestHeader("clave") String clave){
        UsuariosModel usuariosModel = new UsuariosModel();
        usuariosModel = usuariosRepository.login(usuario, Hash.sha1(clave));
        if (usuariosModel != null) {
            return new ResponseEntity<>(usuariosServices.findAll(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    // @GetMapping ("/list")
    // @ResponseBody
    // public List<UsuariosModel> consultarTodo(){
    //     return usuariosServices.findAll();
    // }
    @GetMapping ("/list/{id}")
    public UsuariosModel consultarPorId (@PathVariable Integer id){
        return usuariosServices.findById(id);
    }
    @GetMapping (value = "/login")
    @ResponseBody
    public UsuariosModel ingresar (@RequestParam ("usuario") String usuario, @RequestParam ("clave") String clave){
        return usuariosServices.login(usuario,clave);
    }
    @PostMapping (value = "/")
    @ResponseBody
    public ResponseEntity<UsuariosModel> agregar (@Valid @RequestBody UsuariosModel usuariosModel){
        // Cifrado de contraseña -- Linea 44
        usuariosModel.setUsser_passwd(Hash.sha1(usuariosModel.getUsser_passwd()));
        // Fin de Cifrado
        UsuariosModel obj = usuariosServices.save(usuariosModel);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    @PutMapping (value = "/")
    @ResponseBody
    public ResponseEntity<UsuariosModel> editar (@Valid @RequestBody UsuariosModel usuariosModel){
        // Cifrado de contraseña -- Linea 53
        usuariosModel.setUsser_passwd(Hash.sha1(usuariosModel.getUsser_passwd()));
        // Fin de Cifrado
        UsuariosModel obj = usuariosServices.findById(usuariosModel.get_id());
        if (obj != null) {
            obj.setUsser_email(usuariosModel.getUsser_email());
            obj.setUsser_name(usuariosModel.getUsser_name());
            obj.setUsser_passwd(usuariosModel.getUsser_passwd());
            usuariosServices.save(usuariosModel);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    @DeleteMapping (value = "/{id}")
    public ResponseEntity<UsuariosModel> eliminar (@PathVariable Integer id){
        UsuariosModel obj = usuariosServices.findById(id);
        if (obj != null) {
            usuariosServices.delete(id);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
}
// 3178865477 -- Nestor Anaya Chavez