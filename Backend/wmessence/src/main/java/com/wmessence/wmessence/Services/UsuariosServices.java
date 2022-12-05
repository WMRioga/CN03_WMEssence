package com.wmessence.wmessence.Services;

import com.wmessence.wmessence.Models.UsuariosModel;
import com.wmessence.wmessence.Repositories.UsuariosRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuariosServices {
    @Autowired
    private UsuariosRepository usuariosRepository;

    @Transactional (readOnly = false)
    public UsuariosModel save(UsuariosModel usuariosModel){
        return usuariosRepository.save(usuariosModel);
    }
    @Transactional (readOnly = false)
    public void delete (Integer id){
        usuariosRepository.deleteById(id);
    }
    @Transactional (readOnly = true)
    public UsuariosModel findById(Integer id){
        return usuariosRepository.findById(id).orElse(null);
    }
    @Transactional (readOnly = true)
    public List <UsuariosModel> findAll(){
        return (List<UsuariosModel>) usuariosRepository.findAll();
    }
    @Transactional (readOnly = true)
    public UsuariosModel login(String usuario, String clave){
        return usuariosRepository.login(usuario, clave);
    }
}
