package com.dam.pc106;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity 
@Table (name = "CLIENTE")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    public Cliente() {}

    @ManyToMany
    @JoinTable (name = "compra", // Tabla intermedia
                joinColumns = @JoinColumn (name = "id_cliente"), // FK hacia cliente
                inverseJoinColumns = @JoinColumn (name = "id_producto")) //FK hacía producto 


    private Set<Producto> productos = new HashSet<>(); //Crea una lista vacia

    public Cliente(int id, String nombre){

        this.id = id;
        this.nombre = nombre;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
}
