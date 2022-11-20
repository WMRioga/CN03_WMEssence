package com.wmessence.wmessence.Controllers;

import com.wmessence.wmessence.Models.CategoriasModel;
import com.wmessence.wmessence.Repositories.CategoriasRepository;
import com.wmessence.wmessence.Services.CategoriasServices;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin ("*")
@RequestMapping ("/categorias")
public class CategoriasController {
    @Autowired
    private CategoriasRepository categoriasRepository;

    @Autowired
    private CategoriasServices categoriasServices;

    @PostMapping (value = "/")
    @ResponseBody
    public ResponseEntity <CategoriasModel> agregar (@RequestBody CategoriasModel categoriasModel){
        System.out.println(categoriasModel);
        CategoriasModel obj = categoriasServices.save(categoriasModel);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    @DeleteMapping (value = "/{id}")
    public ResponseEntity <CategoriasModel> eliminar (@PathVariable Integer id){
        CategoriasModel obj = categoriasServices.findById(id);
        if (obj != null){
            categoriasServices.delete(id);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    @PutMapping (value = "/")
    public ResponseEntity <CategoriasModel> editar (@RequestBody CategoriasModel categoriasModel){
        CategoriasModel obj = categoriasServices.findById(categoriasModel.get_id());
        if(obj != null){
            obj.setCategory_name(categoriasModel.getCategory_name());
            categoriasServices.save(obj);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    @GetMapping ("/list")
    public List <CategoriasModel> consultarTodo(){
        return categoriasServices.findAll();
    }
    @GetMapping ("/list/{id}")
    public CategoriasModel consultarPorId(@PathVariable Integer id){
        return categoriasServices.findById(id);
    }
}
