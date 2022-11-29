package com.wmessence.wmessence.Services;

import com.wmessence.wmessence.Models.ProductosModel;
import com.wmessence.wmessence.Repositories.ProductosRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductosServices {
    @Autowired
    private ProductosRepository productosRepository;

    @Transactional (readOnly = false)
    public ProductosModel save(ProductosModel productosModel){
        return productosRepository.save(productosModel);
    }
    @Transactional (readOnly = false)
    public void delete(Integer id){
        productosRepository.deleteById(id);
    }
    @Transactional (readOnly = true)
    public ProductosModel findById(Integer id){
        return productosRepository.findById(id).orElse(null);
    }
    @Transactional (readOnly = true)
    public List <ProductosModel> findAll(){
        return (List<ProductosModel>) productosRepository.findAll();
    }
    @Transactional (readOnly = true)
    public List <ProductosModel> qry_product_category(Integer qpc){
        return (List<ProductosModel>) productosRepository.qry_product_category(qpc);
    }
}
