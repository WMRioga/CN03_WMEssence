package com.wmessence.wmessence.Controllers;

import com.wmessence.wmessence.Models.UsuariosModel;
import com.wmessence.wmessence.Services.UsuariosServices;
import com.wmessence.wmessence.Repositories.UsuariosRepository;

import java.util.List;

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
}
// 3178865477 -- Nestor Anaya Chavez