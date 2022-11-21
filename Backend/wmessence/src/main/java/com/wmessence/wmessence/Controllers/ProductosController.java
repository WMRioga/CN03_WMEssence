package com.wmessence.wmessence.Controllers;

import com.wmessence.wmessence.Models.ProductosModel;
import com.wmessence.wmessence.Services.ProductosServices;
import com.wmessence.wmessence.Repositories.ProductosRepository;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin ("*")
@RequestMapping ("/productos")
public class ProductosController {
    @Autowired
    private ProductosRepository productosRepository;

    @Autowired
    private ProductosServices productosServices;

    @PostMapping (value = "/")
    @ResponseBody
    public ResponseEntity<ProductosModel> agregar (@RequestBody ProductosModel productosModel){
        System.out.println(productosModel);
        ProductosModel obj = productosServices.save(productosModel);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    @DeleteMapping (value = "/{id}")
    public ResponseEntity<ProductosModel> eliminar (@PathVariable Integer id){
        ProductosModel obj = productosServices.findById(id);
        if (obj != null){
            productosServices.delete(id);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    @PutMapping (value = "/")
    public ResponseEntity<ProductosModel> editar (@RequestBody ProductosModel productosModel){
        ProductosModel obj = productosServices.findById(productosModel.get_id());
        if (obj != null){
            obj.setProduct_name(productosModel.getProduct_name());
            obj.setProduct_description(productosModel.getProduct_description());
            obj.setProduct_category(productosModel.getProduct_category());
            obj.setProduct_cost(productosModel.getProduct_cost());
            productosServices.save(obj);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    @GetMapping ("/list")
    public List<ProductosModel> consultarTodo(){
        return productosServices.findAll();
    }
    @GetMapping ("/list/{id}")
    public ProductosModel consultarPorId (@PathVariable Integer id){
        return productosServices.findById(id);
    }
    @GetMapping ("/consulta")
    @ResponseBody
    public List <ProductosModel> qry_product_category(@RequestParam ("qpc") String qpc){
        return productosServices.qry_product_category(qpc);
    }
}
