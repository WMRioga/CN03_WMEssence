package com.wmessence.wmessence.Models;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name = "cn03_productos")
public class ProductosModel implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="_id")
    private int _id;
    @Column(name="product_name")
    private String product_name;
    @Column(name="product_category")
    private String product_category;
    @Column(name="product_description")
    private String product_description;
    @Column(name="product_cost")
    private String product_cost;

    @Override
    public String toString(){
        return "Categorías [_id:" + _id + ", product_name:" + product_name + ", product_category:" + product_category + ", product_description:" + product_description + ", product_cost:" + product_cost + "]";
    }
}
