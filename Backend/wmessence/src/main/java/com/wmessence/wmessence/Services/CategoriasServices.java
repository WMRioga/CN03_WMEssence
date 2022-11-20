package com.wmessence.wmessence.Services;

import com.wmessence.wmessence.Models.CategoriasModel;
import com.wmessence.wmessence.Repositories.CategoriasRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriasServices {
    @Autowired
    private CategoriasRepository categoriasRepository;

    @Transactional (readOnly = false)
    public CategoriasModel save (CategoriasModel categoriasModel){
        return categoriasRepository.save(categoriasModel);
    }
    @Transactional (readOnly = false)
    public void delete(Integer id){
        categoriasRepository.deleteById(id);
    }
    @Transactional (readOnly = true)
    public CategoriasModel findById(Integer id){
        return categoriasRepository.findById(id).orElse(null);
    }
    @Transactional (readOnly = true)
    public List <CategoriasModel> findAll(){
        return (List <CategoriasModel>) categoriasRepository.findAll();
    }
    @Transactional (readOnly = true)
    public List <CategoriasModel> consulta_categorias(String id_category){
        return (List <CategoriasModel>) categoriasRepository.consulta_categorias(id_category);
    }
}
