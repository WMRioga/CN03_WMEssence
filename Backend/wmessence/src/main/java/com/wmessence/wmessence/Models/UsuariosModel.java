package com.wmessence.wmessence.Models;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name = "cn03_usuarios")
public class UsuariosModel implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="_id")
    private int _id;
    @NotEmpty(message = "El campo Nombre no puede estar vacío")
    @Column(name="usser_name")
    private String usser_name;
    @NotEmpty(message = "El campo Contraseña no puede estar vacío")
    // @Size(min = 3, max = 12, message = "El campo Contraseña debe tener mínimo 3 y máximo 12 caracteres")
    @Column(name="usser_passwd")
    private String usser_passwd;
    @NotEmpty(message = "El campo Correo no puede estar vacío")
    @Column(name="usser_email")
    private String usser_email;

    @Override
    public String toString(){
        return "Categorías [_id:" + _id + ", usser_name:" + usser_name + ", usser_email:" + usser_email + "]";
    }
}
