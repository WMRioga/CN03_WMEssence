package com.wmessence.wmessence.Models;

import java.io.Serializable;

import javax.persistence.*;

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
    @Column(name="usser_name")
    private String usser_name;
    @Column(name="usser_passwd")
    private String usser_passwd;
    @Column(name="usser_email")
    private String usser_email;

    @Override
    public String toString(){
        return "Categorías [_id:" + _id + ", usser_name:" + usser_name + ", usser_email:" + usser_email + "]";
    }
}
