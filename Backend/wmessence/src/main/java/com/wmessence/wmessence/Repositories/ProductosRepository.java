package com.wmessence.wmessence.Repositories;

import com.wmessence.wmessence.Models.ProductosModel;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProductosRepository extends CrudRepository <ProductosModel, Integer>{
    /* Operacion para seleccionar los articulos deridavos de la categoría (SELECT) */
    @Transactional (readOnly = true)
    @Query (value = "SELECT * FROM cuentas WHERE product_category= :qpc", nativeQuery = true)
    public List <ProductosModel> qry_product_category (@Param ("qpc") String qpc);
}
