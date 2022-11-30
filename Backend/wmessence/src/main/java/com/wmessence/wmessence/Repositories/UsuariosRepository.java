package com.wmessence.wmessence.Repositories;

import com.wmessence.wmessence.Models.UsuariosModel;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UsuariosRepository extends CrudRepository <UsuariosModel, Integer>{
    // Operacion de autenticación (SELECT)
    @Transactional (readOnly = true) // No afecta la integridad de la base de datos
    @Query (value = "SELECT * FROM cn03_usuarios WHERE usser_email= :usuario AND usser_passwd= :clave", nativeQuery = true)
    public UsuariosModel login (@Param ("usuario") Integer usuario, @Param ("clave") Integer clave);
}
