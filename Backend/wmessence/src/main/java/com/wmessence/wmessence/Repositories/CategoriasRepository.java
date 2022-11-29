package com.wmessence.wmessence.Repositories;

import com.wmessence.wmessence.Models.CategoriasModel;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CategoriasRepository extends CrudRepository <CategoriasModel, Integer>{
    @Transactional (readOnly = true)
    @Query (value = "SELECT * FROM cn03_categorias WHERE _id= :id_category", nativeQuery = true)
    public List <CategoriasModel> consulta_categorias (@Param ("id_category") Integer id_category);
}
