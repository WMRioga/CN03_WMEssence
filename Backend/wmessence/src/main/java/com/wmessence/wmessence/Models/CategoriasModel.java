package com.wmessence.wmessence.Models;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name = "cn03_categorias")
public class CategoriasModel implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="_id")
    private int _id;
    @NotEmpty(message = "El campo Nombre no puede esta vacío")
    @Column(name="category_name")
    private String category_name;

    @Override
    public String toString(){
        return "Categorías [_id:" + _id + ", category_name:" + category_name + "]";
    }
}
